package com.simonov.testappbiapetr.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by simon on 24.03.2018.
 */

public class TerminalsResponse {
    @SerializedName("terminal")
    @Expose
    List<TerminalResponse> terminals;

    public List<TerminalResponse> getTerminals() {
        return terminals;
    }
}
