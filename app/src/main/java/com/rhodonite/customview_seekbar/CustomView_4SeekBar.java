package com.rhodonite.customview_seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.rhodonite.customview_seekbar.R;


public class CustomView_4SeekBar extends RelativeLayout {

    TextView titleTextView;
    SeekBar leftTopSeekbar;
    SeekBar rightTopSeekbar;
    SeekBar leftBottomSeekbar;
    SeekBar rightBottomSeekbar;

    private boolean isLeftButtonOnOff = true;
    private boolean isRightButtonOnOff = true;
    private int defaultValue;
    private int maxValue;
    private String titleText;
    private boolean isSeekBarOnTouch = false;


    public interface CustomView_4SeekBarListener {
        public void onTopRightSeekValueChange(int value);
        public void onTopLeftSeekValueChange(int value);
        public void onBottomRightSeekValueChange(int value);
        public void onBottomLeftSeekValueChange(int value);

    }

    private CustomView_4SeekBarListener listener;

    public CustomView_4SeekBar(Context context) {
        super(context);
        init(context, null);
    }

    public CustomView_4SeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomView_4SeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.customview_4seekbar, this);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);

        this.titleTextView = (TextView) findViewById(R.id.tv_title);
        this.leftTopSeekbar = (SeekBar) findViewById(R.id.sb_left);
        this.rightTopSeekbar = (SeekBar) findViewById(R.id.sb_right);
        this.leftBottomSeekbar = (SeekBar) findViewById(R.id.sb_left_1);
        this.rightBottomSeekbar = (SeekBar) findViewById(R.id.sb_right_1);


        this.maxValue = 20;
        this.titleText = "Title";
        this.defaultValue = 0;

        if (attrs != null) {
            TypedArray attributes = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.CustomSelect,
                    0, 0);

            this.maxValue = attributes.getInt(R.styleable.CustomSelect_max_value_, this.maxValue);
            this.defaultValue = attributes.getInt(R.styleable.CustomSelect_default_value_, 0);
            this.titleText = attributes.getString(R.styleable.CustomSelect_Title);

            this.leftTopSeekbar.setMax(maxValue);
            this.leftTopSeekbar.setProgress(defaultValue);
            this.rightTopSeekbar.setMax(maxValue);
            this.rightTopSeekbar.setProgress(defaultValue);
            this.rightBottomSeekbar.setMax(maxValue);
            this.rightBottomSeekbar.setProgress(defaultValue);
            this.titleTextView.setText(titleText);

        }


        this.leftTopSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (isSeekBarOnTouch)
                    if (listener != null)
                        listener.onTopLeftSeekValueChange(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isSeekBarOnTouch = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (isSeekBarOnTouch) {
                   /* if (listener != null)
                        listener.onLeftSeekValueChange(leftSeekbar.getProgress());*/
                    isSeekBarOnTouch = false;
                }
            }
        });
        this.rightTopSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (isSeekBarOnTouch)
                    if (listener != null)
                        listener.onTopRightSeekValueChange(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isSeekBarOnTouch = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (isSeekBarOnTouch) {
                    /*if (listener != null)
                        listener.onRightSeekValueChange(rightSeekbar.getProgress());*/
                    isSeekBarOnTouch = false;
                }
            }
        });
        this.leftBottomSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (isSeekBarOnTouch)
                    if (listener != null)
                        listener.onBottomLeftSeekValueChange(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isSeekBarOnTouch = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (isSeekBarOnTouch) {
                   /* if (listener != null)
                        listener.onLeftSeekValueChange(leftSeekbar.getProgress());*/
                    isSeekBarOnTouch = false;
                }
            }
        });
        this.rightBottomSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (isSeekBarOnTouch)
                    if (listener != null)
                        listener.onBottomRightSeekValueChange(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isSeekBarOnTouch = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (isSeekBarOnTouch) {
                    /*if (listener != null)
                        listener.onRightSeekValueChange(rightSeekbar.getProgress());*/
                    isSeekBarOnTouch = false;
                }
            }
        });
    }



    public void setRightTopSeekbar(int value) {
        rightTopSeekbar.setProgress(value);
    }
    public void setLeftTopSeekbar(int value) {
        leftTopSeekbar.setProgress(value);
    }
    public void setRightBottomSeekbar(int value) {
        rightBottomSeekbar.setProgress(value);
    }
    public void setLeftBottomSeekbar(int value) {
        leftBottomSeekbar.setProgress(value);
    }
    public void setListener(CustomView_4SeekBarListener listener) {
        this.listener = listener;
    }
}
