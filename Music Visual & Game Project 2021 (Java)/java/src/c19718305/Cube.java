package c19718305;

import processing.core.PApplet;

public class Cube extends Shape {

  private float colour;
  private float angle;


  // the abstract method render from the Shape class is implemented here
  // draw cube
  public void render(PApplet pa)  // must pass PApplet to use parameters associated with it
    {
        pa.pushMatrix();
        pa.translate(x, y, 0);  // move to x y coordinates
        pa.rotateX(angle);
        pa.rotateY(angle);
        pa.stroke(colour, 255, 255);
        pa.box(size);
        pa.popMatrix();
    }


    public Cube(float x, float y, float size, float colour, float angle) {
        // call the superclass to access x, y and size
        // this is constructor chaining
        super(x, y, size);
        this.colour = colour;
        this.angle = angle;
    }

    

}