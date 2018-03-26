package com.simonov.testappbiapetr.api;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ColumnIgnore;
import com.raizlabs.android.dbflow.annotation.ColumnMap;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.simonov.testappbiapetr.db.DataBase;
import com.simonov.testappbiapetr.utils.Constants;

import org.json.JSONObject;

/**
 * Created by simon on 24.03.2018.
 */
@Table(database = DataBase.class, name = Constants.DB.TABLE.TERMINAL)
public class TerminalResponse extends BaseModel {
    @PrimaryKey
    @Column(name = "_id")
    @Expose
    int id;

    @Column
    @Expose
    String name;

    @Column
    @Expose
    String address;

    @Column
    @Expose
    double latitude;

    @Column
    @Expose
    double longitude;

    @Column(name = "receiveCargo")
    @SerializedName("receiveCargo")
    @Expose
    boolean receive_cargo;

    @Column(name = "giveoutCargo")
    @SerializedName("giveoutCargo")
    @Expose
    boolean giveout_cargo;

    @Column(name = "default")
    @SerializedName("default")
    @Expose
    boolean default_cargo;

    @SerializedName("maps")
    @Expose
    MapsResponse maps_link;

    @Column(name = "city_id", defaultValue = "-1")
    int cityId;

    @Column(name = "map_url")
    String mapUrl;

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isReceive_cargo() {
        return receive_cargo;
    }

    public void setReceive_cargo(boolean receive_cargo) {
        this.receive_cargo = receive_cargo;
    }

    public boolean isGiveout_cargo() {
        return giveout_cargo;
    }

    public void setGiveout_cargo(boolean giveout_cargo) {
        this.giveout_cargo = giveout_cargo;
    }

    public boolean isDefault_cargo() {
        return default_cargo;
    }

    public void setDefault_cargo(boolean default_cargo) {
        this.default_cargo = default_cargo;
    }

    public MapsResponse getMaps_link() {
        return maps_link;
    }

    public void setMaps_link(MapsResponse maps_link) {
        this.maps_link = maps_link;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "TerminalResponse{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
