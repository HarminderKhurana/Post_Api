package com.developer.post_api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JsonPlaceHolder {

    @POST("posts")
    Call<DataModel> getDataPost(@Body DataModel dataModel);

    @FormUrlEncoded
    @POST("posts")
    Call<DataModel>  getDataFieldsPost(
            @Field("userid") int userId,
            @Field("title") String title,
            @Field("bnody") String text

    );

    @FormUrlEncoded
    @POST("posts")
    Call<DataModel>  getHAshPostdata(@FieldMap Map<String,String> fields);
}
