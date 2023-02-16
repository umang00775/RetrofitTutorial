package com.umang_rathod.backend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);

        Call<List<Post>> call = jsonPlaceholderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    textview.setText("Response code: " + response.code());
                    return;
                }

                List<Post> dataReceived = response.body();

                for (Post post: dataReceived){
                    String dataToShow = "";
                    dataToShow = "User Id: " + post.getUserId() +
                            "\nId: " + post.getId() +
                            "\nTitle: " + post.getTitle() +
                            "\nText: " + post.getText() + "\n\n";
                    textview.append(dataToShow);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textview.setText(t.toString());
            }
        });


    }
}