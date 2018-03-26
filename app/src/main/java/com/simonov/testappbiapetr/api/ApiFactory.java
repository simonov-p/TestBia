package com.simonov.testappbiapetr.api;

import android.support.annotation.NonNull;

import com.simonov.testappbiapetr.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by simon on 24.03.2018.
 */

public class ApiFactory {
    @NonNull
    private static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
    @NonNull
    public static GetTerminalService getTerminalService() {
        return getRetrofit().create(GetTerminalService.class);
    }
}
