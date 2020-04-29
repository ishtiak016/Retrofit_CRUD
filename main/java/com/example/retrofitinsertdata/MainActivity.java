package com.example.retrofitinsertdata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitinsertdata.APIService;
import com.example.retrofitinsertdata.ApiUtils;
import com.example.retrofitinsertdata.R;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText nametxt, agetxt, phonetxt, emailtxt;
    private APIService mAPIService;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nametxt = (EditText) findViewById(R.id.nametxt);
        agetxt = (EditText) findViewById(R.id.agetxt);
        phonetxt = (EditText) findViewById(R.id.phonetxt);
        emailtxt = (EditText) findViewById(R.id.emailtxt);

        submitBtn = (Button) findViewById(R.id.submitBtn);

        mAPIService = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    sendPost(nametxt.getText().toString(), agetxt.getText().toString(), phonetxt.getText().toString(), emailtxt.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    public void sendPost(String name, String age, String phone, String email) throws IOException {

        Call<String> call = mAPIService.getStringScalar(name, age, phone, email);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}
 