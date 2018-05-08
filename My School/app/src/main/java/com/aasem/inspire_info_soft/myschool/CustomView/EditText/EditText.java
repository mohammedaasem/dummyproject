package com.aasem.inspire_info_soft.myschool.CustomView.EditText;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import com.aasem.inspire_info_soft.myschool.R;


/**
 * Created by paym on 28/8/17.
 */

public class EditText extends android.widget.EditText {
    public boolean isSet;
    public int length=0;
    Context context;
    public EditText(Context context) {
        super(context);
        init(context);
    }

    public void setLength(int length) {
        this.length = (length-1);
    }

    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        this.context=context;
        setBackgroundResource(R.drawable.bg1);
        setCompoundDrawablePadding(10);
        setPadding(20,0,0,0);
        isSet=false;
        if(getText().toString().length()>length)
        {
            setBackgroundResource(R.drawable.bg);
        }
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        if(!isSet) {
            setBackgroundResource(R.drawable.bg1);
        }
        else
        {
            setBackgroundResource(R.drawable.bg);
        }

    }

    public String getText1()
    {
        if(getText().toString()==null)
        {
            return "";
        }
        return getText().toString();
    }

    public int getInt()
    {
        try {
            return Integer.parseInt(getText().toString());
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public double getDouble()
    {
        try {
            return Double.parseDouble(getText().toString());
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public int getFloat()
    {
        try {
            return (int) Float.parseFloat(getText().toString());
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if(getText().length()>length)
        {
            isSet=true;
        }
        else
        {
            isSet=false;
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }


    @Override
    public void setCompoundDrawables(@Nullable Drawable left, @Nullable Drawable top, @Nullable Drawable right, @Nullable Drawable bottom) {
        try {
            left.setColorFilter(ContextCompat.getColor(getContext(), R.color.greaybg), PorterDuff.Mode.MULTIPLY);
            super.setCompoundDrawables(left, top, right, bottom);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void setError(CharSequence error) {
        super.setError(error);
    }

//    @Override
//    public void setError(CharSequence error, Drawable icon) {
//        super.setError(error, icon);
//        setBackgroundResource(R.drawable.error);
//    }
}
