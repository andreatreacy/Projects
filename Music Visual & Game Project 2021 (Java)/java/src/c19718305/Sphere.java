package c19718305;

import processing.core.PApplet;

public class Sphere extends Shape {

  private float colour1;    // 3 colours for RGB
  private float colour2;
  private float colour3;
  private float angleX;
  private float angleY;


  // the abstract method render from the Shape class is implemented here
  // draw sphere
  public void render(PApplet pa)  // must pass PApplet to use parameters associated with it
    {
        pa.pushMatrix();
        pa.translate(x, y, 0);  // move to x y coordinates
        pa.rotateX(angleX);
        pa.rotateY(angleY);
        pa.stroke(colour1, colour2, colour3);
        pa.sphere(size);
        pa.popMatrix();
    }

    public Sphere(float x, float y, float size, float colour1, float colour2, float colour3, float angleX, float angleY) 
    {
        // call the superclass to access x, y and size
        // this is constructor chaining
        super(x, y, size); 
        this.colour1 = colour1;
        this.colour2 = colour2;
        this.colour3 = colour3;
        this.angleX = angleX;
        this.angleY = angleY;
    }

    

}