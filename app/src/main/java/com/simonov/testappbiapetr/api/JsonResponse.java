package com.simonov.testappbiapetr.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by simon on 24.03.2018.
 */

public class JsonResponse {
    @SerializedName("city")
    @Expose
    private List<CityResponse> cities;

    public List<CityResponse> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "cities size=" + cities.size() +
                '}';
    }
}
