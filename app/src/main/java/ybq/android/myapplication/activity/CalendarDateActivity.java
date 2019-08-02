package ybq.android.myapplication.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ybq.android.myapplication.R;
import ybq.android.myapplication.util.DateTest;

import static ybq.android.myapplication.util.DateTest.getSevendate;
import static ybq.android.myapplication.util.DateTest.getWeek;
import static ybq.android.myapplication.util.DateTest.getWeekDay;

public class CalendarDateActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_date);

        TextView tv = findViewById(R.id.tvDate);

        List<DateTest.WeekDay> list = getSevendate();
        String str = "";
        for (DateTest.WeekDay  weekday : list) {
            str = str + weekday.week+"   "+weekday.day  +"\n";
            Log.i("TAG",weekday.week+"   "+weekday.day);
        }
        tv.setText(str);
    }


}
