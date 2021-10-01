package c19718305;

import processing.core.PApplet;

public class Health implements GameStats {
    Assignment assignment;
    Game g;
    float x;
    float y = 0;
    float w = 50;
    float speed;
    float halfW = w/2;


    public Health(Assignment assignment, Game g, float x, float y, float w, float speed, float halfW) {
        this.assignment = assignment;
        this.g = g;
        this.x = x;
        this.y = y;
        this.w = w;
        this.speed = speed;
        this.halfW = halfW;
    }

    // method used so as not to overwrite the values set by the class
    public Health(Assignment assignment, Game g)
    {
        this.assignment = assignment;
        this.g = g;
        respawn();            
    }

    // position the health pack at the top of the screen in a random x position
    void respawn()
    {
        x = assignment.random(halfW, assignment.width-w);
        y = 0;
    }

    // draw the health pack
    public void render(PApplet pa)
    {
        pa.pushMatrix();
        pa.stroke(0);   // black
        pa.fill(255);   // white
        pa.rect(x, y, w, w);
        pa.fill(255,0,0);   //red
        pa.noStroke();
        pa.rect(x+20, y+5, 10, 40); // cross (vertical)
        pa.rect(x+5, y+20, 40, 10); // cross (horizontal)
        pa.popMatrix();
    }

    // update the health pack's position
    public void update()
    {        
        y += 1; // move down the screen

        // if health pack hits the bunker
        if (y > assignment.height - 60 - w)
        {
            respawn();
        }
    }

    // method from GameStats
    public void updateStats(Game g)
    {
        g.health += 10; // add 10 to health
    }

}