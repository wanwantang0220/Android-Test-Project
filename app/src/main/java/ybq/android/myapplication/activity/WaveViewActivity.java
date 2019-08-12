package ybq.android.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ybq.android.myapplication.R;
import ybq.android.myapplication.view.WaveView;

public class WaveViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_view);

        WaveView waveView = findViewById(R.id.wave_view);
        waveView.startAnimation();
    }
}
