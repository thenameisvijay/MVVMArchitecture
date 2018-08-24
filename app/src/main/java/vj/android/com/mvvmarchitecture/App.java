package vj.android.com.mvvmarchitecture;

import android.app.Application;
import android.databinding.DataBindingUtil;

import vj.android.com.mvvmarchitecture.model.databinding.AppDataBindingComponent;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }
}
