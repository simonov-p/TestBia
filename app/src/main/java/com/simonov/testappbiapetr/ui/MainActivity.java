package com.simonov.testappbiapetr.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.simonov.testappbiapetr.R;
import com.simonov.testappbiapetr.api.ApiFactory;
import com.simonov.testappbiapetr.api.CityResponse;
import com.simonov.testappbiapetr.api.JsonResponse;
import com.simonov.testappbiapetr.api.TerminalResponse;
import com.simonov.testappbiapetr.db.tables.ApiMethod;
import com.simonov.testappbiapetr.utils.Utils;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    List<CityResponse> cities;

    @BindView(R.id.save)
    Button buttonSave;

    @BindView(R.id.copyDb)
    Button buttonCopyDb;

    @BindView(R.id.text_view_start)
    TextView textViewFrom;

    @BindView(R.id.text_view_destination)
    TextView textViewTo;

    @OnClick(R.id.text_view_destination)
    void onDestinationClick(){
        Intent intent = new Intent(this, PickActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.text_view_start)
    void onStartOnClick(){
        Intent intent = new Intent(this, PickActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.save)
    void onSaveClick(){
        saveDataToDB();
    }

    @OnClick(R.id.copyDb)
    void onCopyClick(){
        Utils.copyDbToSdCard(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Log.v("spree", "onCreate");

        FlowManager.init(new FlowConfig.Builder(this).build());

        final CharSequence[] items = {"GET", "POST"};

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        alertBuilder.setTitle("Title");
        alertBuilder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ApiMethod apiMethod = new ApiMethod();
                apiMethod.setMethod(items[i].toString());
                apiMethod.save();
                if (i == 0) {
                    Call<JsonResponse> call = ApiFactory.getTerminalService().getCitiesJson();
                    Log.d("spree call url", call.request().url().toString());

                    call.enqueue(new Callback<JsonResponse>() {
                        @Override
                        public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                            if (response.isSuccessful()) {
                                Log.d("spree", response.body().toString());
                                cities = response.body().getCities();

                                Toast.makeText(MainActivity.this, "Response successful", Toast.LENGTH_SHORT).show();
                            } else {
                                try {
                                    Log.d("spree onResponse", response.errorBody().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<JsonResponse> call, Throwable t) {
                            Log.d("spree onFailure", t.toString());
                        }
                    });
                }
            }
        });
        alertBuilder.show();
    }

    private void saveDataToDB (){
        for (CityResponse city : cities) {
            city.save();
            Log.d("spree onSaveCl c save", city.getName());
            Log.d("spree onSaveCl c save", " size=" + city.getTerminals().getTerminals().size());
            for (TerminalResponse terminalResponse : city.getTerminals().getTerminals()) {
                terminalResponse.setCityId(city.getId());
                try {
                    terminalResponse.setMapUrl(terminalResponse.getMaps_link().getWidth().width640.height.height640.url);
                } catch (NullPointerException e) {
                    terminalResponse.setMapUrl("none");
                }
                terminalResponse.save();
                Log.d("spree terminal save", terminalResponse.getName());
            }
        }
    }
}
