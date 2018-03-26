package com.simonov.testappbiapetr.db.tables;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.simonov.testappbiapetr.db.DataBase;
import com.simonov.testappbiapetr.utils.Constants;

/**
 * Created by simon on 22.03.2018.
 */

@Table(database = DataBase.class, name = Constants.DB.TABLE.ORDER)
public class Order extends BaseModel {
    @PrimaryKey
    @Column(name = "_id")
    int id;

    @Column
    int receive_id;

    @Column
    int giveout_id;

    @Column
    int date;
}
