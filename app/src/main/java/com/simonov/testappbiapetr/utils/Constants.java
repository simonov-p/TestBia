package com.simonov.testappbiapetr.utils;

/**
 * Created by simon on 24.03.2018.
 */

public interface Constants {
    interface DB {
        String DB_NAME = "terminals";
        int DB_VERSION = 1;

        interface TABLE {
            String ACCESS_POINT = "access_point";
            String CITY = "city";
            String TERMINAL = "terminal";
            String API_METHOD = "api_method";
            String ORDER = "order";

        }
    }

    interface SHARED_PREFS {
        String CURRENT_LANGUAGE_ID = "current_language_id";
    }

    public interface URL {
//        String API_URL = "https://api.dellin.ru/static/catalog/";
//        String API_URL = "https://www.dropbox.com/s/39eecj6jed4p1kl/";
//        String API_URL = "https://drive.google.com/";
        String API_URL = "https://api.myjson.com/";
    }
}
