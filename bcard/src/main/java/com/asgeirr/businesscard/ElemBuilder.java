package com.asgeirr.businesscard;

public class ElemBuilder {
    private float angle;
    private boolean bold;
    private String color;
    private String font;
    private String fontSize;
    private float height;
    private String iconColor;
    private int iconType;
    private boolean italic;
    private String text;
    private String thumbnail;
    private boolean underline;
    private float width;
    private float xPosition;
    private float yPosition;

    public ElemBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public ElemBuilder setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public ElemBuilder setxPosition(float xPosition) {
        this.xPosition = xPosition;
        return this;
    }

    public ElemBuilder setyPosition(float yPosition) {
        this.yPosition = yPosition;
        return this;
    }

    public ElemBuilder setWidth(float width) {
        this.width = width;
        return this;
    }

    public ElemBuilder setHeight(float height) {
        this.height = height;
        return this;
    }

    public ElemBuilder setAngle(float angle) {
        this.angle = angle;
        return this;
    }

    public ElemBuilder setBold(boolean bold) {
        this.bold = bold;
        return this;
    }

    public ElemBuilder setItalic(boolean italic) {
        this.italic = italic;
        return this;
    }

    public ElemBuilder setUnderline(boolean underline) {
        this.underline = underline;
        return this;
    }

    public ElemBuilder setFont(String font) {
        this.font = font;
        return this;
    }

    public ElemBuilder setFontSize(String fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public ElemBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public ElemBuilder setIconType(int iconType) {
        this.iconType = iconType;
        return this;
    }

    public ElemBuilder setIconColor(String iconColor) {
        this.iconColor = iconColor;
        return this;
    }

    public Elem createElem() {
        return new Elem(text, thumbnail, xPosition, yPosition, width, height, angle, bold, italic, underline, font, fontSize, color, iconType, iconColor);
    }
}