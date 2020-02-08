package com.developer.post_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    JsonPlaceHolder jsonPlaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.my_TextView);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
      //  getposting();
       // getFieldPosting();
        getHashdata();

    }
    private void getHashdata(){
        Map<String,String> fields=new HashMap<>();
        fields.put("userId","20");
        fields.put("title","hey Title");
        fields.put("body","hey body.??");

        Call<DataModel> call=jsonPlaceHolder.getHAshPostdata(fields);
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if(!response.isSuccessful()){
                    textView.setText("code:" + response.code());
                    return;
                }
                DataModel model1=response.body();
                String content=" ";
                content += "code:" +response.code() +"\n";
                content += "userId:" +model1.getUserId() +"\n";
                content += "title:" +model1. getTitle() +"\n";
                content += "ID:" +model1.getId() +"\n";
                content += "body:" +model1.getText() +"\n";
                textView.setText(content);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });



    }

    private void getFieldPosting(){
        Call<DataModel> call=jsonPlaceHolder.getDataFieldsPost(23,"hey title","hi text");
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if(!response.isSuccessful()){
                    textView.setText("code:" + response.code());
                    return;
                }
                DataModel model1=response.body();
                String content=" ";
                content += "code:" +response.code() +"\n";
                content += "userId:" +model1.getUserId() +"\n";
                content += "title:" +model1. getTitle() +"\n";
                content += "ID:" +model1.getId() +"\n";
                content += "body:" +model1.getText() +"\n";
                textView.setText(content);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }


    private void getposting() {
        DataModel model = new DataModel(
                "New Title for Post Api",
                " hit the post Api just Now.."
                , 20);

        Call<DataModel> call=jsonPlaceHolder.getDataPost(model);
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if(!response.isSuccessful()){
                    textView.setText("code:" + response.code());
                    return;
                }
                DataModel model1=response.body();
                String content=" ";
                content += "code:" +response.code() +"\n";
                content += "userId:" +model1.getUserId() +"\n";
                content += "title:" +model1. getTitle() +"\n";
                content += "ID:" +model1.getId() +"\n";
                content += "body:" +model1.getText() +"\n";
                textView.setText(content);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

}
