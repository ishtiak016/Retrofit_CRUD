package com.example.retrofitinsertdata;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("Insert.php")
    Call<String> getStringScalar(@Field("name") String name, @Field("age")
            String age, @Field("phone") String phone, @Field("email") String email);

}
