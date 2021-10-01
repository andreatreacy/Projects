package c19718305;

import processing.core.PApplet;

// abstract class extended by Sphere, Cube, and MusicSymbol

public abstract class Shape {
    float x;
    float y;
    float size;


    // this method will be called from the classes that extend Shape to set the values for x, y and size
    public Shape(float x, float y, float size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }


    public float getX() {
        return x;
    }



    public void setX(float x) {
        this.x = x;
    }



    public float getY() {
        return y;
    }



    public void setY(float y) {
        this.y = y;
    }



    public float getSize() {
        return size;
    }



    public void setSize(float size) {
        this.size = size;
    }



    // subclasses MUST implement this abstract method
    public abstract void render(PApplet pa);

}