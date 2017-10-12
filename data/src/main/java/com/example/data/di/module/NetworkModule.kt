//package com.example.data.di.module
//
//import com.example.data.api.RestApi
//
//import com.example.data.di.qualifier.AuthIntercept
//import com.example.data.di.qualifier.ServerInfo
//import com.example.data.di.scope.ApplicationScope
//import dagger.Binds
//import dagger.Module
//import dagger.Provides
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//
///**
// * Created by Artur on 12.09.2017.
// */
//@Module
//class NetworkModule{
//    @Provides
//    @ApplicationScope
//    fun proviceService(retrofit: Retrofit):RestApi = retrofit.create(RestApi::class.java)
//
//    @Provides
//    @ApplicationScope
//    fun proviceRetrofit(@ServerInfo url: String, okHttpClient: OkHttpClient):
//            Retrofit = Retrofit.Builder()
//            .baseUrl(url)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//
//    @Provides
//    @ApplicationScope
//    fun provideOkHttpClient(@AuthIntercept auth: Interceptor): OkHttpClient =
//            OkHttpClient.Builder()
//                    .addInterceptor(auth)
//                    .build()
////    @Binds
////    @ApplicationScope
////    @AuthIntercept
////    abstract fun provideAuthInterceptor(authInterceptor: AuthInterceptor): Interceptor
//}