package vj.android.com.mvvmarchitecture.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import vj.android.com.mvvmarchitecture.R;

public class CommonUtils {
    private static AlertDialog alertDialog;

    public static void showProgressBar(Context context, boolean isCancellable) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View dialogView = inflater.inflate(R.layout.progress_dialog_layout, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(isCancellable);
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}
