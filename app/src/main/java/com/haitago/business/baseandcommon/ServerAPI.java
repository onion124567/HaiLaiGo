package com.haitago.business.baseandcommon;


import com.haitago.BuildConfig;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ServerAPI {

    //    public static final String ENDPOINT = "http://10.96.8.104:8080/recruit";
//    public static final String ENDPOINT = "http://10.96.8.76:8081";
//    public static final String ENDPOINT = "http://10.96.24.39:8081/";
    public static final String ENDPOINT = BuildConfig.ENDPOINT;

    /**
     * 下载
     */
    @Streaming
    @GET
    Call<ResponseBody> downloadFileWithDynamicUrlSync(@Url String fileUrl);

}
