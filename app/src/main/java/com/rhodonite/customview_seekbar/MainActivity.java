package com.rhodonite.customview_seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private NumberSelect numberSelect;
    private CustomView_4SeekBar customView4SeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.numberSelect = (NumberSelect)findViewById(R.id.number_select);
        this.customView4SeekBar = (CustomView_4SeekBar) findViewById(R.id.customView_4SeekBar);
        numberSelect.setListener(new NumberSelect.NumberSelectListener() {

            @Override
            public void onValueChange(int value) {
                Log.d("onValueChange", String.valueOf(value));
            }
        });
        customView4SeekBar.setListener(new CustomView_4SeekBar.CustomView_4SeekBarListener() {
            @Override
            public void onTopRightSeekValueChange(int value) {
                Log.d("onTopRightSeekValueChange", String.valueOf(value));
            }

            @Override
            public void onTopLeftSeekValueChange(int value) {
                Log.d("onTopLeftSeekValueChange", String.valueOf(value));
            }

            @Override
            public void onBottomRightSeekValueChange(int value) {
                Log.d("onBottomRightSeekValueChange", String.valueOf(value));
            }

            @Override
            public void onBottomLeftSeekValueChange(int value) {
                Log.d("onBottomLeftSeekValueChange", String.valueOf(value));
            }
        });
    }
}