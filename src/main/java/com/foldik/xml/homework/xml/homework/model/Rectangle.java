package com.foldik.xml.homework.xml.homework.model;

public final class Rectangle {

    private final double width;
    private final double height;
    private final double x;
    private final double y;
    private final Color color;

    public Rectangle(double width, double height, double x, double y, Color color) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}
