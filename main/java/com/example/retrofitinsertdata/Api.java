package com.example.retrofitinsertdata;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;

/**
 * Created by Android on 1/6/2018.
 */

public interface Api {

    String BASE_URL ="https://ishakharide.000webhostapp.com/";
    @GET("fetch_data.php")
    Call<List<Details_Pojo>> getstatus();

}