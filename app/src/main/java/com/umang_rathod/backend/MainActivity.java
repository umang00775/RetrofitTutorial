package com.umang_rathod.backend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private TextView textview;
    JsonPlaceholderApi jsonPlaceholderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);

        getComments();

    }

    private void getComments(){
        Map<String, Integer> parameters = new HashMap<>();
        parameters.put("postId", 3);

        Call<List<Comment>> call = jsonPlaceholderApi.getComments(parameters);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(!response.isSuccessful()){
                    textview.setText("Response Code: " + response.code());
                    return;
                }
                List<Comment> receivedData = response.body();
                for(Comment comment: receivedData){
                    String data = "Post ID: " + comment.getPostId() +
                            "\nID: " + comment.getId() +
                            "\nName: " + comment.getName() +
                            "\nEmail: " + comment.getEmail() +
                            "\nComment: " + comment.getComment() + "\n\n";
                    textview.append(data);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textview.setText(t.toString());
            }
        });
    }
}