package vj.android.com.mvvmarchitecture.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import vj.android.com.mvvmarchitecture.BR;
import vj.android.com.mvvmarchitecture.model.RepositoryListener;
import vj.android.com.mvvmarchitecture.model.adapter.RepoAdapter;
import vj.android.com.mvvmarchitecture.model.entity.GitHubRepo;
import vj.android.com.mvvmarchitecture.model.github.GitHubClient;

public class RepoViewModel extends BaseObservable {

    private RepoAdapter adapter;
    private List<GitHubRepo> data;
    private GitHubClient gitHubClient;

    public RepoViewModel() {
        this.adapter = new RepoAdapter();
        this.data = new ArrayList<>();
        this.gitHubClient = new GitHubClient();
    }

    @Bindable
    public RepoAdapter getAdapter() {
        return this.adapter;
    }

    @Bindable
    public List<GitHubRepo> getData() {
        return this.data;
    }

    /*private void populateData() {
        GitHubRepo gitHubRepo = new GitHubRepo();
        for (int i = 0; i < data.size(); i++) {
            gitHubRepo.setName(data.get(i).getName());
            data.add(gitHubRepo);
        }
        notifyPropertyChanged(BR.data);
    }*/

    public void getUserDetails(@NonNull final UserDetailsListener callback) {

        UserDetailsListener userDetailsListener = new UserDetailsListener() {

            @Override
            public void onUserListReceived(List<GitHubRepo> users) {
                // Return response to callback
                callback.onUserListReceived(users);
                for (int i = 0; i < users.size(); i++) {
                    GitHubRepo gitHubRepo = new GitHubRepo();
                    gitHubRepo.setName(users.get(i).getName());
                    data.add(gitHubRepo);
                }
                notifyPropertyChanged(BR.data);

            }

            @Override
            public void onFailure(String message) {
                callback.onFailure(message);
            }
        };
        gitHubClient.getDetails(userDetailsListener);
    }

    public interface UserDetailsListener extends RepositoryListener {
        void onUserListReceived(List<GitHubRepo> users);
    }
}
