package edu.upc.dsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.upc.dsa.ui.main.RecyclerAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecyclerPage extends AppCompatActivity {

    List<Object> data;
    ProgressBar circularProgress;

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    public static final String API_URL = "http://10.0.2.2:8080/dsaApp/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        this.circularProgress = findViewById(R.id.progressBarRecyclerID);
        circularProgress.setVisibility(View.VISIBLE);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerViewID);
    }


    public void initializeRecyclerView(List<Object> data){
        RecyclerAdapter myAdapter= new RecyclerAdapter(this, data);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    }


    public void toMainPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
