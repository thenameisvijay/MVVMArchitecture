package vj.android.com.mvvmarchitecture.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import vj.android.com.mvvmarchitecture.model.entity.GitHubRepo;

public class RepoItemViewModel extends BaseObservable {

    private GitHubRepo gitHubRepo;

    public RepoItemViewModel(GitHubRepo gitHubRepo) {
        this.gitHubRepo = gitHubRepo;
    }

    @Bindable
    public String getName() {
        return !TextUtils.isEmpty(gitHubRepo.getName()) ? gitHubRepo.getName() : "";
    }
}
