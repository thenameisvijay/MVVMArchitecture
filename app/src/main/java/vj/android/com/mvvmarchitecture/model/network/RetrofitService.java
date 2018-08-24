package vj.android.com.mvvmarchitecture.model.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vj.android.com.mvvmarchitecture.model.entity.GitHubRepo;

interface RetrofitService {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getUserRepos(@Path("user") String user);
}
