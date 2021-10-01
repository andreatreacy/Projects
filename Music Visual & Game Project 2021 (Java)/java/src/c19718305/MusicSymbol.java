package c19718305;

import processing.core.PApplet;

public class MusicSymbol extends Shape {

  private Assignment assignment;
  private float colour;
  private float rotation;
  private float speed;
  private float dx, dy;


  // the abstract method render from the Shape class is implemented here
  public void render(PApplet pa)  // must pass PApplet to use parameters associated with it
    {
        pa.pushMatrix();
        pa.stroke(colour, 255, 255);
        pa.fill(colour, 255, 255);
        pa.ellipse(x, y, size, size);
        pa.strokeWeight(2);
        pa.line(x + 8, y, x + 8, y - 50);
        pa.line(x + 8, y - 50, x + 20, y - 30);
        pa.popMatrix();
    }


    // update the position of the music symbol
    public void update(Assignment assignment)
    {   
        // used so the music symbols will move slightly more diagonally     
        dx = PApplet.sin(rotation);
        dy = -PApplet.cos(rotation);

        x += dx*speed;
        y += dy*speed;
        rotation += 0.01f;

        // if music symbol goes too far left for the screen
        if (x < 0)
        {
            respawn();
        }
        // if music symbol goes too far right for the screen
        if (x > assignment.width)
        {
            respawn();
        }
        // if music symbol goes too high for the screen
        if (y < 0)
        {
            respawn();
        }
        // if music symbol goes too low for the screen
        if (y > assignment.height)
        {
            respawn();
        }
    }


    // respawn the music symbol in a random position within the screen
    void respawn()
    {
        x = assignment.random(0, assignment.width);
        y = assignment.random(0, assignment.height);
        dx = assignment.random(5);
        dy = assignment.random(5);
    }

    public MusicSymbol(float x, float y, float size, float colour, float rotation, float speed, Assignment assignment) 
    {
        // call the superclass to access x, y and size
        // this is constructor chaining
        super(x, y, size); 
        this.colour = colour;
        this.rotation = rotation;
        this.speed = speed;
        this.assignment = assignment;
    }

    

}