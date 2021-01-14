package com.smartcity.covidcenterlamongan;

import com.smartcity.covidcenterlamongan.Model.ModelDataIndonesia;
import com.smartcity.covidcenterlamongan.Model.ModelObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("indonesia")
    Call<List<ModelDataIndonesia>> getData();

    @GET("indonesia/provinsi")
    Call<List<ModelObject>> getProvinsi();
}
