package com.asgeirr.businesscard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

public class IconTextView extends ConstraintLayout {

    private ImageView ivIcon;
    private AppCompatTextView tvText;
    private View vSpace;
    String text;
    @DrawableRes
    int iconRes;
    @ColorInt
    int textColor, iconColor;
    private boolean isBold, isItalic, isUnderline;
    private Typeface font;

    public IconTextView(Context context) {
        super(context);
        initControl();
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initControl();
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl();
    }

    private void initControl() {
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_icon_text_view, this);
        ivIcon=findViewById(R.id.IconTextView_ivIcon);
        vSpace=findViewById(R.id.IconTextView_vSpace);
        tvText=findViewById(R.id.IconTextView_tvText);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(getMeasuredHeight()>0)
            updateView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setElem(Elem elem) {
        text=elem.getText();
        textColor=getColorFromString(elem.getColor());
        isBold=elem.isBold();
        isItalic=elem.isItalic();
        isUnderline=elem.isUnderline();
        font=getFontFamilyFromInt(elem.getFont());
        iconRes=getElementIcon(elem);
        iconColor=getColorFromString(elem.getIconColor());
        updateView();
    }

    private void updateView() {
        ivIcon.setImageResource(iconRes);
        ivIcon.setColorFilter(iconColor, PorterDuff.Mode.SRC_IN);
        tvText.setText(text);
        tvText.setTextColor(textColor);
        tvText.setTypeface(font);
        tvText.getLayoutParams().width=(int)(tvText.getPaint().measureText(text)+1);
        tvText.invalidate();
        tvText.requestLayout();
        if(getLayoutParams()==null)
            return;
        getLayoutParams().width=ivIcon.getMeasuredWidth()+vSpace.getMeasuredWidth()+tvText.getMeasuredWidth();
        invalidate();
        requestLayout();
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
        setBoldStyle(font);
        setItalicStyle(font);
        setUnderlinedStyle();
        return font;
    }

    private void setUnderlinedStyle() {
        if (isUnderline)
            tvText.setPaintFlags(tvText.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        else
            tvText.setPaintFlags(tvText.getPaintFlags() & (~Paint.UNDERLINE_TEXT_FLAG));
    }

    private void setBoldStyle(Typeface font) {
        font = Typeface.create(font, isBold?(isItalic?Typeface.BOLD_ITALIC:Typeface.BOLD):(isItalic?Typeface.ITALIC:Typeface.NORMAL));
    }

    private void setItalicStyle(Typeface font){
        font = Typeface.create(font, isItalic?(isBold?Typeface.BOLD_ITALIC:Typeface.ITALIC):(isBold?Typeface.BOLD:Typeface.NORMAL));
    }

    private int getColorFromString(String color){
        if(TextUtils.isEmpty(color))
            color="000000";
        return Color.parseColor("#"+color);
    }

    public int getElementIcon(Elem elem){
        int res=0;
        switch (elem.getIconType()){
            case 1:
                res=R.drawable.ic_phone_dark_blue_24dp;
                break;
            case 2:
                res=R.drawable.ic_mail_enable_24dp;
                break;
            case 3:
                res=R.drawable.ic_web_dark_blue_24dp;
                break;
        }
        return res;
    }

    public void setText(String text) {
        this.text=text;
        updateView();
    }
}
