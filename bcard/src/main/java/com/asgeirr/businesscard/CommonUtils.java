package com.asgeirr.businesscard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class CommonUtils {
    public static boolean equals(Object o1, Object o2){
        if(o1==null && o2==null)
            return true;
        if(o1 instanceof Long || o2 instanceof Long){
            return (o1==null &&  ((Long) o2)==0L)|| (o2==null && ((Long) o1)==0L) || (o1!=null && o2!=null && ((Long) o1).longValue()==((Long) o2).longValue());
        } else if( o1 instanceof String || o2 instanceof String) {
            return (o1 == null && TextUtils.isEmpty((String) o2)) || (TextUtils.isEmpty((String) o1) && o2 == null) || (o1 != null && o1.equals(o2));
        }else if( o1 instanceof Integer || o2 instanceof Integer){
            return (o1==null && ((Integer) o2)==0)|| (o2==null && ((Integer) o1)==0) || (o1!=null && o2!=null && ((Integer) o1).compareTo((Integer) o2) == 0);
        } else if( o1 instanceof Double || o2 instanceof Double){
            return (o1==null && ((Double) o2)==0)|| (o2==null && ((Double) o1)==0) || (o1!=null && o2!=null && (((Double) o1).compareTo((Double) o2) == 0));
        } else if( o1 instanceof Float || o2 instanceof Float){
            return (o1==null && ((Float) o2)==0F)|| (o2==null && ((Float) o1)==0F) || (o1!=null && o2!=null && (((Float) o1).compareTo((Float) o2) == 0));
        } else if( o1 instanceof Boolean || o2 instanceof Boolean){
            return (o1==null && !((Boolean) o2))|| (o2==null && !((Boolean) o1)) || (o1!=null && o2!=null && ((Boolean) o1).compareTo((Boolean) o2) == 0);
        } else  if( o1 instanceof Short || o2 instanceof Short){
            return (o1==null && ((Short) o2)==0)|| (o2==null && ((Short) o1)==0) || (o1!=null && o2!=null && ((Short) o1).compareTo((Short) o2) == 0);
        } else
            return o1!=null && o1.equals(o2);
    }

    public static int getColorFromString(String color) {
        if (TextUtils.isEmpty(color) || color.length() != 6)
            color = "000000";
        return Color.parseColor("#" + color);
    }

    public static Typeface getFontFamilyFromInt(Context context, String fontInt, boolean isItalic, boolean isBold) {
        Typeface font = null;
        if (TextUtils.isEmpty(fontInt))
            return Typeface.SANS_SERIF;
        switch (fontInt) {
            case "0":
                font = ResourcesCompat.getFont(context, R.font.arial);
                break;
            case "1":
                font = ResourcesCompat.getFont(context, R.font.gandhi_sans);
                break;
            case "2":
                font = ResourcesCompat.getFont(context, R.font.baskerville);
                break;
            case "3":
                font = ResourcesCompat.getFont(context, R.font.gill_sans);
                break;
            case "4":
                font = ResourcesCompat.getFont(context, R.font.gotham);
                break;
            case "5":
                font = ResourcesCompat.getFont(context, R.font.helvetica);
                break;
            case "6":
                font = ResourcesCompat.getFont(context, R.font.optima);
                break;
            case "7":
                font = Typeface.SANS_SERIF;
                break;
            case "8":
                font = ResourcesCompat.getFont(context, R.font.times_new_roman);
                break;
            default:
                font = Typeface.SANS_SERIF;
                break;
        }
        font = Typeface.create(font, isBold ? (isItalic ? Typeface.BOLD_ITALIC : Typeface.BOLD) : (isItalic ? Typeface.ITALIC : Typeface.NORMAL));
        return font;
    }

    public static int getElementIcon(int iconType) {
        int res = -1;
        switch (iconType) {
            case 1:
                res = R.drawable.ic_phone_dark_blue_24dp;
                break;
            case 2:
                res = R.drawable.ic_mail_enable_24dp;
                break;
            case 3:
                res = R.drawable.ic_web_dark_blue_24dp;
                break;
        }
        return res;
    }

    public static int parseStringColor(String color) {
        if (TextUtils.isEmpty(color))
            color = "000000";
        return Color.parseColor("#" + color);
    }

    public static Bitmap loadBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap(v.getWidth() * 2, v.getHeight() * 2, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        c.scale(2.0f, 2.0f);
        v.draw(c);
        return b;
    }

    public static String saveBitmap(Bitmap bitmap, Context context, String fileName) {
        File imagePath = null;
        FileOutputStream fos;
        try {
            imagePath = File.createTempFile(fileName, ".png", context.getCacheDir());
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            return imagePath.getAbsolutePath();
        } catch (IOException e) {
            return "";
        }
    }
}
