package com.asgeirr.businesscard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Elem implements Cloneable{
    private String text;
    private String thumbnail;
    private float xPosition;
    private float yPosition;
    private float width;
    private float height;
    private float angle;
    private boolean bold;
    private boolean italic;
    private boolean underline;
    private String font;
    private String fontSize;
    private String color;
    private int iconType;
    private String iconColor;

    public Elem(String text, String thumbnail, float xPosition, float yPosition, float width, float height, float angle, boolean bold, boolean italic, boolean underline, String font, String fontSize, String color, int iconType, String iconColor) {
        this.text = text;
        this.thumbnail = thumbnail;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.angle = angle;
        this.bold = bold;
        this.italic = italic;
        this.underline = underline;
        this.font = font;
        this.fontSize = fontSize;
        this.color = color;
        this.iconType = iconType;
        this.iconColor = iconColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public float getxPosition() {
        return xPosition;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public boolean isUnderline() {
        return underline;
    }

    public void setUnderline(boolean underline) {
        this.underline = underline;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIconType() {
        return iconType;
    }

    public void setIconType(int iconType) {
        this.iconType = iconType;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    public static Elem getDefault(){
        Elem elem= new ElemBuilder().createElem();
        elem.setFont("7");
        elem.setColor("000000");
        return elem;
    }

    @NonNull
    @Override
    protected Elem clone() {
        try {
            return (Elem) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null ) return false;
        if (!(obj instanceof Elem)) return false;
        Elem elem = (Elem) obj;
        return angle == elem.getAngle() &&
                bold == elem.isBold() &&
                CommonUtils.equals(color, elem.getColor()) &&
                CommonUtils.equals(font, elem.getFont()) &&
                CommonUtils.equals(fontSize, elem.getFontSize()) &&
                height == elem.getHeight() &&
                CommonUtils.equals(iconColor, elem.getIconColor()) &&
                iconType == elem.getIconType() &&
                italic == elem.isItalic() &&
                CommonUtils.equals(text, elem.getText()) &&
                CommonUtils.equals(thumbnail, elem.getThumbnail()) &&
                underline == elem.isUnderline() &&
                width == elem.getWidth() &&
                xPosition == elem.getxPosition() &&
                yPosition == elem.getyPosition();
    }
}
