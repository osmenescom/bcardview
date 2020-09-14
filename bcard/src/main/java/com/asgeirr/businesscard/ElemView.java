package com.asgeirr.businesscard;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ElemView extends LinearLayout {

    String text;
    @DrawableRes
    int iconRes;
    @ColorInt
    int textColor, iconColor;
    private ImageView ivIcon;
    private TextView tvText;
    private boolean isUnderline;
    private Typeface font;

    public ElemView(Context context) {
        super(context);
    }

    public ElemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ElemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ElemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        setOrientation(HORIZONTAL);
        if (iconRes != -1 && ivIcon == null) {
            ivIcon = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(getMeasuredHeight(), getMeasuredHeight());
            layoutParams.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
            layoutParams.width = getMeasuredHeight();
            addView(ivIcon, layoutParams);
            ivIcon.setImageResource(iconRes);
            ivIcon.setColorFilter(iconColor, PorterDuff.Mode.SRC_IN);

        }
        if (tvText == null) {
            tvText = new TextView(getContext());
            int width = (getMeasuredWidth() - (ivIcon == null ? 0 : ivIcon.getLayoutParams().width + ((LayoutParams) ivIcon.getLayoutParams()).rightMargin)) - (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
            LayoutParams layoutParams = new LayoutParams(Math.max(width, 0), getMeasuredHeight());
            addView(tvText, layoutParams);
            tvText.setTextColor(textColor);
            tvText.setTypeface(font);
            tvText.setTextSize(TypedValue.COMPLEX_UNIT_PX, getFitFontSize(tvText.getLayoutParams().width, tvText.getLayoutParams().height, tvText.getPaint(), font, text));
            tvText.setText(text);
        }
    }

    public void setElem(SimpleElem simpleElem) {
        text = simpleElem.getText();
        textColor = CommonUtils.getColorFromString(simpleElem.getColor());
        isUnderline = simpleElem.isUnderline();
        font = CommonUtils.getFontFamilyFromInt(getContext(), simpleElem.getFont(), simpleElem.isItalic(), simpleElem.isBold());
        iconRes = CommonUtils.getElementIcon(simpleElem.getIconType());
        iconColor = CommonUtils.getColorFromString(simpleElem.getIconColor());
        isUnderline = simpleElem.isUnderline();
    }

    public void updateText(String text) {
        if (tvText == null)
            return;
        this.text = text;
        tvText.setTextSize(TypedValue.COMPLEX_UNIT_PX, getFitFontSize(tvText.getMeasuredWidth(), tvText.getMeasuredHeight(), tvText.getPaint(), font, text));
        tvText.setText(text);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredHeight() > 0)
            init();
    }

    float getFitFontSize(float boundWidth, float boundHeight, Paint paint, Typeface typeface, String text) {
        float baseTextSize = boundHeight;
        paint.setTextSize(baseTextSize);
        paint.setTypeface(typeface);
        while (paint.getFontMetrics().bottom - paint.getFontMetrics().top > boundHeight) {
            baseTextSize--;
            paint.setTextSize(baseTextSize);
        }
        while (paint.measureText(text) > boundWidth) {
            baseTextSize--;
            paint.setTextSize(baseTextSize);
        }
        return baseTextSize;
    }
}
