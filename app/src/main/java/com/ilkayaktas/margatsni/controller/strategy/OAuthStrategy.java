package com.ilkayaktas.margatsni.controller.strategy;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.ilkayaktas.margatsni.controller.api.fivehundredpx.Px500Api;
import com.ilkayaktas.margatsni.utils.AppConstants;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by iaktas on 28.08.2017.
 */

public class OAuthStrategy implements Strategy {

    private OAuth10aService service;
    private OAuth1RequestToken requestToken;

    @Override
    public String execute() {
        try {
            service = new ServiceBuilder(AppConstants.FIVEHUNDREDPX_CUSTOMER_KEY)
                    .apiSecret(AppConstants.FIVEHUNDREDPX_CUSTOMER_SECRET)
                    .build(Px500Api.instance());

            // get request token
            requestToken = service.getRequestToken();

            return service.getAuthorizationUrl(requestToken);

        } catch (InterruptedException | ExecutionException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OAuth10aService getService() {
        return service;
    }

    public OAuth1RequestToken getRequestToken() {
        return requestToken;
    }
}
