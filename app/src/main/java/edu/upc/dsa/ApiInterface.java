package edu.upc.dsa;

import edu.upc.dsa.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("user/register")
    Call<Object> addUser(@Body Object user);

    @POST("user/login")
    Call<Object> loginUser(@Body Object user);

    @GET("user/logout/{userName}")
    Call<Void> logoutUser(@Path("userName") String userName);

    @GET("Bike/getUserByID/{idUser}")
    Call<User> getUserByID(@Path("idUser") String idUser);
}
