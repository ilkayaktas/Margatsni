package lib.ilkayaktas.instagram;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import lib.ilkayaktas.instagram.exceptions.InstagramException;
import lib.ilkayaktas.instagram.model.api.Scope;
import lib.ilkayaktas.instagram.model.entity.users.basicinfo.UserInfo;
import lib.ilkayaktas.instagram.util.LibConstants;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Instragam main class.
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 *
 */
public class Instagram{
	private Context mContext;
	
	private InstagramDialog mDialog;
	private InstagramAuthListener mListener;
	private InstagramSession mSession;
	
	private String mClientId;
	private String mClientSecret;
	private String mRedirectUri;
	private Scope mScope;
	
	/**
	 * Instantiate new object of this class.
	 * 
	 * @param context Context
	 * @param clientId Client id
	 * @param clientSecret Client secret
	 * @param redirectUri Redirect uri
	 */
	public Instagram(Context context, String clientId, String clientSecret, String redirectUri, Scope scope) {
		mContext = context;
		
		mClientId = clientId;
		mClientSecret = clientSecret;
		mRedirectUri = redirectUri;
		mScope = scope;
		
		String authUrl = LibConstants.AUTH_URL + "client_id=" + mClientId + "&redirect_uri=" + mRedirectUri + "&response_type=code"+"&scope="+mScope.toString();
		
		mSession = new InstagramSession(context);

		// Create dialog and callback result
		mDialog 		= new InstagramDialog(context, authUrl, redirectUri, new InstagramDialog.InstagramDialogListener() {
			
			@Override
			public void onSuccess(String code) {
				retreiveAccessToken(code);
			}
			
			@Override
			public void onError(String error) {
				mListener.onError(error);
			}

			@Override
			public void onCancel() {
			mListener.onCancel();
				
			}
		});
	}
	
	/**
	 * Authorize user.
	 * 
	 * @param listener Auth listner
	 */
	public void authorize(InstagramAuthListener listener) {
		mListener = listener;
		
		mDialog.show();
	}
	
	/**
	 * Reset session.
	 */
	public void resetSession() {
		mSession.reset();
		
		mDialog.clearCache();
	}
	
	/**
	 * Get session.
	 * 
	 * @return Instagram session.
	 */
	public InstagramSession getSession() {
		return mSession;
	}
	
	/**
	 * Retreive access token.
	 * 
	 * @param code
	 */
	private void retreiveAccessToken(String code) {		
		new AccessTokenTask(code).execute();
	}

	public class AccessTokenTask extends AsyncTask<URL, Integer, Long> {		
		ProgressDialog progressDlg;
		UserInfo user;
		String code;
		
		public AccessTokenTask(String code) {
			this.code		= code;
			
			progressDlg 	= new ProgressDialog(mContext);
			
			progressDlg.setMessage("Getting access token...");			
		}
		
		protected void onCancelled() {
			progressDlg.cancel();
		}
		
    	protected void onPreExecute() {
    		progressDlg.show();
    	}
    
        protected Long doInBackground(URL... urls) {         
            long result = 0;
            
            try {

				Retrofit retrofit = new Retrofit.Builder()
						.baseUrl("https://api.instagram.com/")
						.addConverterFactory(GsonConverterFactory.create())
						.build();

				AuthenticationService authenticationService = retrofit.create(AuthenticationService.class);

				Map<String, String> options = new HashMap<String, String>();
				options.put("client_id", mClientId);
				options.put("client_secret", mClientSecret);
				options.put("grant_type", "authorization_code");
				options.put("redirect_uri", mRedirectUri);
				options.put("code", code);

				Call<UserInfo> user = authenticationService.getAccessToken(options);

//    			List<NameValuePair> params = new ArrayList<NameValuePair>(5);
//
//    			params.add(new BasicNameValuePair("client_id", 		mClientId));
//    			params.add(new BasicNameValuePair("client_secret",  mClientSecret));
//    			params.add(new BasicNameValuePair("grant_type", 	"authorization_code"));
//    			params.add(new BasicNameValuePair("redirect_uri", 	mRedirectUri));
//    			params.add(new BasicNameValuePair("code", 			code));
//
//    			InstagramRequest request	= new InstagramRequest();
//    			String response				= request.post(LibConstants.ACCESS_TOKEN_URL, params);
//
//				user = createObjectFromResponse(UserInfo.class, response);
    		} catch (Exception e) { 
    			e.printStackTrace();
    		}
            
            return result;
        }

        protected void onProgressUpdate(Integer... progress) {              	
        }

        protected void onPostExecute(Long result) {        	
        	progressDlg.dismiss();
        	
        	if (user != null) {
        		mSession.store(user);

        		mListener.onSuccess(user);
        	} else {
        		mListener.onError("Failed to get access token");
        	}
        }                
    }
	
	public interface InstagramAuthListener {
		public abstract void onSuccess(UserInfo user);
		public abstract void onError(String error);
		public abstract void onCancel();
	}

	public <T> T createObjectFromResponse(Class<T> clazz, final String response) throws InstagramException {
		Gson gson = new Gson();
		T object;

		try {
			object = gson.fromJson(response, clazz);
		} catch (Exception e) {
			throw new InstagramException("Error parsing json to object type " + clazz.getName(), e);
		}

		return object;
	}
}