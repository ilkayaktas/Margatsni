package com.ilkayaktas.margatsni.controller.strategy;

import android.app.Activity;
import android.content.Context;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.ilkayaktas.margatsni.controller.api.fivehundredpx.FiveHundredPxDialog;
import com.ilkayaktas.margatsni.controller.api.fivehundredpx.Px500Api;
import com.ilkayaktas.margatsni.controller.services.MobssAsyncTask;
import com.ilkayaktas.margatsni.utils.AppConstants;

/**
 * Created by iaktas on 28.08.2017.
 */

public class OAuthStrategy implements Strategy {

    private Context context;

    public OAuthStrategy(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        try {
            OAuth10aService service = new ServiceBuilder(AppConstants.FIVEHUNDREDPX_CUSTOMER_KEY)
                    .apiSecret(AppConstants.FIVEHUNDREDPX_CUSTOMER_SECRET)
                    .build(Px500Api.instance());

            OAuth1RequestToken requestToken = service.getRequestToken();

            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String authorizationUrl = service.getAuthorizationUrl(requestToken);
                    System.out.println(authorizationUrl);

                    new FiveHundredPxDialog(context, service, requestToken, authorizationUrl, new FiveHundredPxDialog.OnApiAuthentication() {

                        @Override
                        public void onSucces(String verifier) {
                            new MobssAsyncTask((Activity) context, new OAuthAccessTokenStrategy(service,requestToken,verifier)).execute();
                        }

                    }).show();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
