package lib.ilkayaktas.instagram;

import android.content.Context;

import lib.ilkayaktas.instagram.model.api.Scope;
import lib.ilkayaktas.instagram.util.LibConstants;

/**
 * Instragam main class.
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 *
 */
public class Instagram{
	private Context mContext;
	
	private InstagramDialog mDialog;
	private final InstagramSession mSession;
	
	private String mClientId;
	private String mClientSecret;
	private String mRedirectUri;
	private Scope mScope;
	
	/**
	 * Instantiate new object of this class.
	 * 
	 * @param context Context
	 */
	public Instagram(Context context, Scope scope) {
		mContext = context;
		
		mClientId = LibConstants.INSTAGRAM_CLIENT_ID;
		mClientSecret = LibConstants.INSTAGRAM_CLIENT_SECRET;
		mRedirectUri = LibConstants.INSTAGRAM_CALBACK_URL;
		mScope = scope;
		
		String authUrl = LibConstants.AUTH_URL + "client_id=" + mClientId + "&redirect_uri=" + mRedirectUri + "&response_type=code"+"&scope="+mScope.toString();
		
		mSession = new InstagramSession(context);

		// Create dialog and callback result
		mDialog = new InstagramDialog(context, authUrl);
	}
	
	/**
	 * Authorize user.
	 * 
	 */
	public void authorize() {
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
	


}