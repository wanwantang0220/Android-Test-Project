package ybq.android.myapplication.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import ybq.android.myapplication.R;
import ybq.android.myapplication.util.DateUtil;

import static ybq.android.myapplication.util.DateUtil.getSevendate;

public class CalendarDateActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_date);

        TextView tv = findViewById(R.id.tvDate);

        List<DateUtil.WeekDay> list = getSevendate();
        String str = "";
        for (DateUtil.WeekDay  weekday : list) {
            str = str + weekday.week+"   "+weekday.day  +"\n";
            Log.i("TAG",weekday.week+"   "+weekday.day);
        }
        tv.setText(str);
    }


}
