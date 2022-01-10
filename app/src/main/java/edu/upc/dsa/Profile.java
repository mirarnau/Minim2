package edu.upc.dsa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.upc.dsa.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profile extends AppCompatActivity {
    ImageView profileImage;
    TextView userName, description;
    ProgressBar circularProgress;

    String user = "Arnau";

    ApiInterface apiInterface;

    public static final String API_URL = "http://10.0.2.2:8080/dsaApp/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        this.profileImage = findViewById(R.id.profilePicID);
        this.userName = findViewById(R.id.userNameID);
        this.description = findViewById(R.id.descriptionID);
        this.circularProgress = findViewById(R.id.progressBarProfileID);

        circularProgress.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);

        getUserByID(this.user);
    }

    public void getUserByID (String userID){
        Call<User> call = apiInterface.getUserByID(userID);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    Log.d("Profile", "Error code:" + response.code());
                    return;
                }
                userName.setText(response.body().getIdUser());
                circularProgress.setVisibility(View.GONE);
                Log.d("Profile", "Successful getUser "+ userID);
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Profile.this, "Error in getting response from service", Toast.LENGTH_LONG).show();
                Log.d("Profile", "Error in getting response from service: "+t.getMessage());
            }
        });
    }

    public void profileToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

