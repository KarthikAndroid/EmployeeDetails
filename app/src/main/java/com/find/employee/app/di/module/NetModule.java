package com.find.employee.app.di.module;


import com.find.employee.app.data.rest.EmployeeService;
import com.find.employee.app.di.scope.AppScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetModule {
    private static final String BASE_URL = "https://demo9919266.mockable.io/";


    @AppScope
    @Provides
    OkHttpClient provideOkhttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(logging);
        return client.build();
    }

    @AppScope
    @Provides
    static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @AppScope
    @Provides
    static EmployeeService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(EmployeeService.class);
    }


}
