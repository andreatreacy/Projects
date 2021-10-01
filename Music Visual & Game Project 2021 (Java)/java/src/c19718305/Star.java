package c19718305;

import processing.core.PApplet;


public class Star {
    float x;
    float y;



    public Star(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // draw star
    public void render(PApplet pa)
    {
        pa.point(x, y);
    }

    
}