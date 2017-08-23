package com.ilkayaktas.margatsni.controller.api.instagram;

import android.content.Context;

import com.ilkayaktas.margatsni.controller.api.instagram.model.api.Scope;
import com.ilkayaktas.margatsni.controller.api.instagram.util.LibConstants;


/**
 * Instragam main class.
 * 
 * @author Lorensius W. L. T <lorenz@londatiga.net>
 *
 */
public class Instagram{

	private InstagramDialog mDialog;

	/**
	 * Instantiate new object of this class.
	 * 
	 * @param context Context
	 */
	public Instagram(Context context, Scope scope) {

		String mClientId = LibConstants.INSTAGRAM_CLIENT_ID;
		String  mClientSecret = LibConstants.INSTAGRAM_CLIENT_SECRET;
		String mRedirectUri = LibConstants.INSTAGRAM_CALBACK_URL;
		Scope mScope = scope;
		
		String authUrl = LibConstants.AUTH_URL + "client_id=" + mClientId + "&redirect_uri=" + mRedirectUri + "&response_type=code"+"&scope="+ mScope.toString();
		
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
	

}