package com.simonov.testappbiapetr.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.simonov.testappbiapetr.db.DataBase;
import com.simonov.testappbiapetr.utils.Constants;

import java.util.List;

/**
 * Created by simon on 24.03.2018.
 */

@Table(database = DataBase.class, name = Constants.DB.TABLE.CITY)
public class CityResponse extends BaseModel {
    @PrimaryKey
    @Column(name = "_id")
    @Expose
    int id;

    @Column
    @Expose
    private String name;

    @Expose
    private TerminalsResponse terminals;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTerminals(TerminalsResponse terminals) {
        this.terminals = terminals;
    }

    public TerminalsResponse getTerminals() {
        return terminals;
    }
}
