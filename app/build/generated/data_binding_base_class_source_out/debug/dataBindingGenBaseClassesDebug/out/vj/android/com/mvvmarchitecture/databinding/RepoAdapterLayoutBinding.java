package vj.android.com.mvvmarchitecture.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import vj.android.com.mvvmarchitecture.viewmodel.RepoItemViewModel;

public abstract class RepoAdapterLayoutBinding extends ViewDataBinding {
  @NonNull
  public final TextView repoTv;

  @Bindable
  protected RepoItemViewModel mRepoData;

  protected RepoAdapterLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView repoTv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.repoTv = repoTv;
  }

  public abstract void setRepoData(@Nullable RepoItemViewModel repoData);

  @Nullable
  public RepoItemViewModel getRepoData() {
    return mRepoData;
  }

  @NonNull
  public static RepoAdapterLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RepoAdapterLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RepoAdapterLayoutBinding>inflate(inflater, vj.android.com.mvvmarchitecture.R.layout.repo_adapter_layout, root, attachToRoot, component);
  }

  @NonNull
  public static RepoAdapterLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static RepoAdapterLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<RepoAdapterLayoutBinding>inflate(inflater, vj.android.com.mvvmarchitecture.R.layout.repo_adapter_layout, null, false, component);
  }

  public static RepoAdapterLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static RepoAdapterLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (RepoAdapterLayoutBinding)bind(component, view, vj.android.com.mvvmarchitecture.R.layout.repo_adapter_layout);
  }
}
