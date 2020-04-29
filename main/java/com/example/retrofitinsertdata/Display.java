package com.example.retrofitinsertdata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Display extends AppCompatActivity {

    TextView nametxt, agetxt, phonetxt, emailtxt;
    Button retrieveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametxt = (TextView) findViewById(R.id.nametxt);
        agetxt = (TextView) findViewById(R.id.agetxt);
        phonetxt = (TextView) findViewById(R.id.phonetxt);
        emailtxt = (TextView) findViewById(R.id.emailtxt);

        retrieveBtn = (Button) findViewById(R.id.retrieveBtn);

        retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData();
            }
        });


    }


    private void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Details_Pojo>> call = api.getstatus();

        call.enqueue(new Callback<List<Details_Pojo>>() {
            @Override
            public void onResponse(Call<List<Details_Pojo>> call, Response<List<Details_Pojo>> response) {
                List<Details_Pojo> adslist = response.body();

                String name = adslist.get(0).getName();
                String age = adslist.get(0).getAge();
                String phone = adslist.get(0).getPhone();
                String email = adslist.get(0).getEmail();

                nametxt.setText(name);
                agetxt.setText(age);
                phonetxt.setText(phone);
                emailtxt.setText(email);

            }

            @Override
            public void onFailure(Call<List<Details_Pojo>> call, Throwable t) {

                Toast.makeText(Display.this, ""+t.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
