package com.simonov.testappbiapetr.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by simon on 24.03.2018.
 */

public interface GetTerminalService {
//    @GET("/static/catalog/terminals_v3.json")
//    @GET("/s/39eecj6jed4p1kl/")
//    @GET("/drive/u/0/folders/0B-7vtpCo5MCvV2c1WEdUQ0lvbnM")
    @GET("/bins/ighfz")
    Call<JsonResponse> getCitiesJson();
}
