package com.simonov.testappbiapetr.db.tables;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.simonov.testappbiapetr.db.DataBase;
import com.simonov.testappbiapetr.utils.Constants;

/**
 * Created by simon on 24.03.2018.
 */
@Table(database = DataBase.class, name = Constants.DB.TABLE.API_METHOD)
public class ApiMethod extends BaseModel{
    @PrimaryKey
    @Column
    int id;

    @Column
    String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(int item) {
        switch (item) {
            case 0:
                this.method = "GET";
                break;
            case 1:
                this.method = "POST";
        }
    }
    public void setMethod(String item) {
        this.method = item;
    }
}
