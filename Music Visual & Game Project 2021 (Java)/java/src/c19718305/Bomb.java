package c19718305;

import processing.core.PApplet;

public class Bomb implements GameStats {
    Assignment assignment;
    Game g;
    float x;
    float y = 0;
    float w = 50;
    float speed;
    float halfW = w/2;

    

    public Bomb(Assignment assignment, Game g, float x, float y, float w, float speed, float halfW) {
        this.assignment = assignment;
        this.g = g;
        this.x = x;
        this.y = y;
        this.w = w;
        this.speed = speed;
        this.halfW = halfW;
    }

    // method used so as not to overwrite the values set by the class
    public Bomb(Assignment assignment, Game g, float speed)
    {
        this.assignment = assignment;
        this.g = g;
        this.speed = speed;
        respawn();            
    }

    // position the bomb at the top of the screen in a random x position
    void respawn()
    {
        x = assignment.random(halfW, assignment.width-halfW);
        y = 0;
    }

    public void render(PApplet pa)
    {
        pa.pushMatrix();
        pa.stroke(0);   // black
        pa.fill(0); // black
        pa.ellipse(x, y, w, w); // bomb
        pa.rect(x-6, y-30, w/4, w/4);   // top of bomb
        pa.line(x, y-60, x, y); // fuse
        pa.strokeWeight(2);
        pa.stroke(255, 0, 0);   // red
        
        // lit part of fuse
        pa.line(x, y-60, x-5, y-70);
        pa.line(x, y-60, x-5, y-50);
        pa.line(x, y-60, x+5, y-70);
        pa.line(x, y-60, x+5, y-50);
        pa.stroke(247, 91, 0);  // orange
        pa.line(x, y-50, x, y-70);
        pa.line(x-10, y-60, x+10, y-60);
        pa.popMatrix();
    }

    // update the bomb's position
    public void update()
    {        
        y += 1*speed;   // move down the screen

        // if bomb hits the bunker
        if (y > assignment.height - 60 - halfW)
        {
            updateStats(g);
            respawn();
        }
    }

    // method from GameStats
    @Override
    public void updateStats(Game g) {
        g.health -= 10; // take 10 from health
    }

    
}