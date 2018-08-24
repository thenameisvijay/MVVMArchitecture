package vj.android.com.mvvmarchitecture.model.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import vj.android.com.mvvmarchitecture.model.adapter.RepoAdapter;
import vj.android.com.mvvmarchitecture.model.entity.GitHubRepo;

public class RecyclerViewDataBinding {

    @BindingAdapter({"android:adapter", "android:data"})
    public void bind(RecyclerView recyclerView, RepoAdapter adapter, List<GitHubRepo> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
}
