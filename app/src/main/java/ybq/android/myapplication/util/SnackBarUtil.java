package ybq.android.myapplication.util;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import ybq.android.myapplication.R;

public class SnackBarUtil {


    public static void  setSnackbarColor(Snackbar snackbar,int messageColor,
                                         int backgroundColor) {
        View view = snackbar.getView();
        if(view !=null){
            //修改view的背景色
            view.setBackgroundColor(backgroundColor);
            //获取Snackbar的message控件，修改字体颜色
            ((TextView)view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);
        }
    }


}
