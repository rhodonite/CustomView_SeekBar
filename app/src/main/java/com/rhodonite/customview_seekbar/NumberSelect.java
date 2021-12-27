package com.rhodonite.customview_seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class NumberSelect extends LinearLayout {

    Button addButton;
    Button minusButton;
    TextView valueTextView;

    private int minValue;
    private int maxValue;
    private int defaultValue;
    private int textValue;

    public interface NumberSelectListener {
        public void onValueChange(int value);
    }

    private NumberSelectListener listener;

    public NumberSelect(Context context) {
        super(context);
        init(context, null);
    }

    public NumberSelect(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public NumberSelect(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.numberselect, this);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        this.addButton = (Button) findViewById(R.id.addButton);
        this.minusButton = (Button) findViewById(R.id.minusButton);
        this.valueTextView = (TextView) findViewById(R.id.valueTextView);

        this.textValue = 0;
        this.maxValue = Integer.MAX_VALUE;
        this.minValue = 0;

        if (attrs != null) {
            TypedArray attributes = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.NumberSelect,
                    0, 0);

            this.maxValue = attributes.getInt(R.styleable.NumberSelect_max_value, this.maxValue);
            this.minValue = attributes.getInt(R.styleable.NumberSelect_min_value, this.minValue);
            this.defaultValue = attributes.getInt(R.styleable.NumberSelect_default_value, 0);


            this.valueTextView.setText(String.valueOf(defaultValue));
        }

        this.addButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addTextValue();
                if ( listener != null) {
                    listener.onValueChange(textValue);
                }
            }
        });

        this.minusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                minusTextValue();
                if ( listener != null) {
                    listener.onValueChange(textValue);
                }
            }
        });
    }

    public void setMaxValue(int value) {
        this.maxValue = value;
    }
    public void setMinValue(int value) {
        this.minValue = value;
    }
    public void setDefaultValue(int value) {
        this.defaultValue = value;
        this.valueTextView.setText(String.valueOf(defaultValue));
        textValue = Integer.parseInt(valueTextView.getText().toString());
    }

    private void addTextValue(){
        textValue = Integer.parseInt(valueTextView.getText().toString());
        if ( this.textValue < this.maxValue) {
            this.textValue++;
            this.valueTextView.setText(String.valueOf(this.textValue));
        }
    }

    private void minusTextValue(){
        textValue = Integer.parseInt(valueTextView.getText().toString());
        if ( this.textValue > this.minValue) {
            this.textValue--;
            this.valueTextView.setText(String.valueOf(this.textValue));
        }
    }

    public void setListener(NumberSelectListener listener) {
        this.listener = listener;
    }
}