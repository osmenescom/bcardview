package com.asgeirr.businesscard;

public class SimpleElemBuilder {
    protected float angle;
    protected boolean bold;
    protected String color;
    protected String font;
    protected String fontSize;
    protected float height;
    protected String iconColor;
    protected int iconType;
    protected boolean italic;
    protected String text;
    protected String thumbnail;
    protected boolean underline;
    protected float width;
    protected float xPosition;
    protected float yPosition;

    public SimpleElemBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public SimpleElemBuilder setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public SimpleElemBuilder setxPosition(float xPosition) {
        this.xPosition = xPosition;
        return this;
    }

    public SimpleElemBuilder setyPosition(float yPosition) {
        this.yPosition = yPosition;
        return this;
    }

    public SimpleElemBuilder setWidth(float width) {
        this.width = width;
        return this;
    }

    public SimpleElemBuilder setHeight(float height) {
        this.height = height;
        return this;
    }

    public SimpleElemBuilder setAngle(float angle) {
        this.angle = angle;
        return this;
    }

    public SimpleElemBuilder setBold(boolean bold) {
        this.bold = bold;
        return this;
    }

    public SimpleElemBuilder setItalic(boolean italic) {
        this.italic = italic;
        return this;
    }

    public SimpleElemBuilder setUnderline(boolean underline) {
        this.underline = underline;
        return this;
    }

    public SimpleElemBuilder setFont(String font) {
        this.font = font;
        return this;
    }

    public SimpleElemBuilder setFontSize(String fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public SimpleElemBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public SimpleElemBuilder setIconType(int iconType) {
        this.iconType = iconType;
        return this;
    }

    public SimpleElemBuilder setIconColor(String iconColor) {
        this.iconColor = iconColor;
        return this;
    }

    public SimpleElem createElem() {
        return new SimpleElem(text, thumbnail, xPosition, yPosition, width, height, angle, bold, italic, underline, font, fontSize, color, iconType, iconColor);
    }
}