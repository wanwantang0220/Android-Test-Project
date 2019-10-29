package ybq.android.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ybq.android.myapplication.R;
import ybq.android.myapplication.util.SnackBarUtil;

public class MaterialDesignActivity extends AppCompatActivity {

    LinearLayout coordinatorLayout;

    @BindView(R.id.tl_username)
    TextInputLayout tlUserName ;
    @BindView(R.id.tl_password)
    TextInputLayout tlPassword;
    @BindView(R.id.et_username)
    EditText etUserName;
    @BindView(R.id.et_passwprd)
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        ButterKnife.bind(this);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        Snackbar snackbar = Snackbar.make(coordinatorLayout,"这是massage", Snackbar.LENGTH_SHORT)
                .setAction("这是action", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MaterialDesignActivity.this,"你点击了action",Toast.LENGTH_SHORT).show();
            }
        });

        SnackBarUtil.setSnackbarColor(snackbar,getColor(R.color.color_blue),getColor(R.color.bg_btn));
        snackbar.show();
    }

}
