package com.simonov.testappbiapetr.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by simon on 24.03.2018.
 */

public class MapsResponse {
    @Expose
    Width width;

    public Width getWidth() {
        return width;
    }

    public void setWidth(Width width) {
        this.width = width;
    }
}
