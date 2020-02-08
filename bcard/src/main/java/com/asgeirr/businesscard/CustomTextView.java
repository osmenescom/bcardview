package com.asgeirr.businesscard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;

import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.TextViewCompat;

public class CustomTextView extends AppCompatTextView {

    String text;
    @ColorInt
    int textColor;
    private boolean isBold, isItalic, isUnderline;
    private Typeface font;

    public CustomTextView(Context context) {
        super(context);
        initControl();
    }

    private void initControl() {
        super.setAutoSizeTextTypeWithDefaults(TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        super.setAutoSizeTextTypeUniformWithConfiguration(1, 300, 1, TypedValue.COMPLEX_UNIT_SP);
    }

    public void setElem(Elem elem) {
        text=elem.getText();
        textColor=getColorFromString(elem.getColor());
        isBold=elem.isBold();
        isItalic=elem.isItalic();
        isUnderline=elem.isUnderline();
        font =getFontFamilyFromInt(elem.getFont());
        updateView();
    }

    private void updateView() {
        super.setText(text);
        super.setTextColor(textColor);
        super.setTypeface(font);
    }

    private Typeface getFontFamilyFromInt(String fontInt) {
        Typeface font=null;
        if(TextUtils.isEmpty(fontInt))
            return Typeface.SANS_SERIF;
        switch (fontInt){
            case "0":
                font= ResourcesCompat.getFont(getContext(), R.font.arial);
                break;
            case "1":
                font=ResourcesCompat.getFont(getContext(), R.font.gandhi_sans);
                break;
            case "2":
                font=ResourcesCompat.getFont(getContext(), R.font.baskerville);
                break;
            case "3":
                font=ResourcesCompat.getFont(getContext(), R.font.gill_sans);
                break;
            case "4":
                font=ResourcesCompat.getFont(getContext(), R.font.gotham);
                break;
            case "5":
                font=ResourcesCompat.getFont(getContext(), R.font.helvetica);
                break;
            case "6":
                font=ResourcesCompat.getFont(getContext(), R.font.optima);
                break;
            case "7":
                font=Typeface.SANS_SERIF;
                break;
            case "8":
                font=ResourcesCompat.getFont(getContext(), R.font.times_new_roman);
                break;
            default:
                font=Typeface.SANS_SERIF;
                break;
        }
        setBoldStyle();
        setItalicStyle();
        setUnderlinedStyle();
        return font;
    }

    private void setUnderlinedStyle() {
        if (isUnderline)
            setPaintFlags(getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        else
            setPaintFlags(getPaintFlags() & (~Paint.UNDERLINE_TEXT_FLAG));
    }

    private void setBoldStyle() {
        font = Typeface.create(font, isBold?(isItalic?Typeface.BOLD_ITALIC:Typeface.BOLD):(isItalic?Typeface.ITALIC:Typeface.NORMAL));
    }

    private void setItalicStyle(){
        font = Typeface.create(font, isItalic?(isBold?Typeface.BOLD_ITALIC:Typeface.ITALIC):(isBold?Typeface.BOLD:Typeface.NORMAL));
    }

    private int getColorFromString(String color){
        if(TextUtils.isEmpty(color))
            color="000000";
        return Color.parseColor("#"+color);
    }

    public void updateText(String text) {
        this.text=text;
        getLayoutParams().width=(int)(getPaint().measureText(text)+1);
        updateView();
    }
}
