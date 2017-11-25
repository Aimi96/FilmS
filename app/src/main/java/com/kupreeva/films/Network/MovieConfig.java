package com.kupreeva.films.Network;

import com.kupreeva.films.Network.Params;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by mkmtst on 17.10.2017.
 */
public class MovieConfig {
    private final String API_KEY;
    private Retrofit retrofit;

    public MovieConfig (String API_KEY) {  //ему нежно прописать ключ и создать ретрофик, который позволяет обращаться к серверу и получать инфу
        this.API_KEY = API_KEY;
        retrofit = new Retrofit.Builder().baseUrl(Params.BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OkHttpClient client = retrofit.client();
        client.interceptors().add(new AuthInterceptor(API_KEY));
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }

    private class AuthInterceptor implements Interceptor { //производит аутентификацию на сервере (каждый раз в запрос добавляет апи ключ)
        private final String API_KEY;

        public AuthInterceptor (String API_KEY) {
            this.API_KEY = API_KEY;
        }


        @Override
        public Response intercept(Chain chain) throws IOException { //это метод получения ответа от сервера
            Request request = chain.request();
            HttpUrl url = request.httpUrl()
                    .newBuilder()
                    .addQueryParameter(Params.PARAM_API_KEY, API_KEY) //добавляет апи ключ к запросу
                    .build();
            request = request.newBuilder().url(url).build();
            Response response = chain.proceed(request);
            return response;
        }
    }
}
