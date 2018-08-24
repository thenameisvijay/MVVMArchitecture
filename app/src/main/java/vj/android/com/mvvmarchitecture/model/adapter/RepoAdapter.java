package vj.android.com.mvvmarchitecture.model.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vj.android.com.mvvmarchitecture.R;
import vj.android.com.mvvmarchitecture.databinding.RepoAdapterLayoutBinding;
import vj.android.com.mvvmarchitecture.model.entity.GitHubRepo;
import vj.android.com.mvvmarchitecture.viewmodel.RepoItemViewModel;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoDataHolder> {

    private List<GitHubRepo> data;

    public RepoAdapter() {
        this.data = new ArrayList<>();
    }

    @NonNull
    @Override
    public RepoDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RepoAdapterLayoutBinding repoAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.repo_adapter_layout, parent, false);
        return new RepoDataHolder(repoAdapterLayoutBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RepoDataHolder holder, int position) {
        GitHubRepo gitHubRepo = data.get(position);
        holder.setRepoData(new RepoItemViewModel(gitHubRepo));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RepoDataHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RepoDataHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<GitHubRepo> data) {
        if (data == null || data.isEmpty()) {
            this.data.clear();
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    class RepoDataHolder extends RecyclerView.ViewHolder {
        RepoAdapterLayoutBinding binding;

        RepoDataHolder(View itemView) {
            super(itemView);
            bind();
        }

        void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if (binding != null) {
                binding.unbind(); // Don't forget to unbind
            }
        }

        void setRepoData(RepoItemViewModel viewModel) {
            if (binding != null) {
                binding.setRepoData(viewModel);
            }
        }
    }
}
