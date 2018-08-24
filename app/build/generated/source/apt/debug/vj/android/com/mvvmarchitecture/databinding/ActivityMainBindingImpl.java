package vj.android.com.mvvmarchitecture.databinding;
import vj.android.com.mvvmarchitecture.R;
import vj.android.com.mvvmarchitecture.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.support.v7.widget.RecyclerView) bindings[1]
            );
        ensureBindingComponentIsNotNull(vj.android.com.mvvmarchitecture.model.databinding.RecyclerViewDataBinding.class);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.repoRv.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.repoData == variableId) {
            setRepoData((vj.android.com.mvvmarchitecture.viewmodel.RepoViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRepoData(@Nullable vj.android.com.mvvmarchitecture.viewmodel.RepoViewModel RepoData) {
        updateRegistration(0, RepoData);
        this.mRepoData = RepoData;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.repoData);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeRepoData((vj.android.com.mvvmarchitecture.viewmodel.RepoViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRepoData(vj.android.com.mvvmarchitecture.viewmodel.RepoViewModel RepoData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.adapter) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.data) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        vj.android.com.mvvmarchitecture.model.adapter.RepoAdapter repoDataAdapter = null;
        vj.android.com.mvvmarchitecture.viewmodel.RepoViewModel repoData = mRepoData;
        java.util.List<vj.android.com.mvvmarchitecture.model.entity.GitHubRepo> repoDataData = null;

        if ((dirtyFlags & 0xfL) != 0) {



                if (repoData != null) {
                    // read repoData.adapter
                    repoDataAdapter = repoData.getAdapter();
                    // read repoData.data
                    repoDataData = repoData.getData();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xfL) != 0) {
            // api target 1

            this.mBindingComponent.getRecyclerViewDataBinding().bind(this.repoRv, repoDataAdapter, repoDataData);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): repoData
        flag 1 (0x2L): repoData.adapter
        flag 2 (0x3L): repoData.data
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}