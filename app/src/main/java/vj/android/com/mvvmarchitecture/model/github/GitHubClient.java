package vj.android.com.mvvmarchitecture.model.github;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Response;
import vj.android.com.mvvmarchitecture.model.BaseClient;
import vj.android.com.mvvmarchitecture.model.entity.GitHubRepo;
import vj.android.com.mvvmarchitecture.model.network.NetworkCallback;
import vj.android.com.mvvmarchitecture.viewmodel.RepoViewModel;

public class GitHubClient extends BaseClient {

    public static final String TAG = GitHubClient.class.getSimpleName();

    public GitHubClient() {
        super();
    }

    public void getDetails(@NonNull final RepoViewModel.UserDetailsListener callback) {
        // Build url
        String url = "vg4029";

        // Configure response
        NetworkCallback networkCallback = new NetworkCallback() {

            @Override
            public void success(Response<List<GitHubRepo>> response) {
                callback.onUserListReceived(response.body());
            }

            @Override
            public void failure(String body) {
                // TODO: set default error message
                String message = "";
                if (!TextUtils.isEmpty(body)) {
                    Error error = new Gson().fromJson(body, Error.class);
                    message = error.getMessage();
                }
                callback.onFailure(message);
            }
        };

        makeGetRequest(url, networkCallback);
    }
}
