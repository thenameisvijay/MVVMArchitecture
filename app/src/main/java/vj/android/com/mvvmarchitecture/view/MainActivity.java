package vj.android.com.mvvmarchitecture.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import vj.android.com.mvvmarchitecture.R;
import vj.android.com.mvvmarchitecture.Utils.CommonUtils;
import vj.android.com.mvvmarchitecture.databinding.ActivityMainBinding;
import vj.android.com.mvvmarchitecture.model.entity.GitHubRepo;
import vj.android.com.mvvmarchitecture.viewmodel.RepoViewModel;
import vj.android.com.mvvmarchitecture.viewmodel.RepoViewModel.UserDetailsListener;

public class MainActivity extends AppCompatActivity implements UserDetailsListener {

    private String TAG = MainActivity.class.getSimpleName();

    RepoViewModel repoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = bind();
        initRecyclerView(view);
        CommonUtils.showProgressBar(this, true);
    }

    private View bind() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        repoViewModel = new RepoViewModel();
        binding.setRepoData(repoViewModel);
        repoViewModel.getUserDetails(this);
        return binding.getRoot();
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.repo_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onUserListReceived(List<GitHubRepo> users) {
        Log.e(TAG, users.get(0).getName());
        CommonUtils.hideProgressBar(this);
    }

    @Override
    public void onFailure(String message) {
        Log.e(TAG, message);
    }
}
