package com.ilkayaktas.margatsni.controller.services;

import android.os.AsyncTask;

import com.ilkayaktas.margatsni.controller.strategy.Strategy;

import javax.inject.Inject;


/**
 * Created by ilkay on 05/02/2017.
 */

public class MobssAsyncTask extends AsyncTask<Void, Void, String> {
    
    AsyncResponse response;
    Strategy strategy;
    
    @Inject
    public MobssAsyncTask(Strategy strategy, AsyncResponse response) {
        this.strategy = strategy;
        this.response = response;
    }
    
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Void... params) {
        return strategy.execute();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        response.processFinish(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(String result) {
        super.onCancelled(result);
    }


}
