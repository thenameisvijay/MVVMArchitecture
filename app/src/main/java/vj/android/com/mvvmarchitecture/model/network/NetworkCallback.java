package vj.android.com.mvvmarchitecture.model.network;

import java.util.List;

import retrofit2.Response;
import vj.android.com.mvvmarchitecture.model.entity.GitHubRepo;

public interface NetworkCallback {

    void success(Response<List<GitHubRepo>> response);

    void failure(String body);
}
