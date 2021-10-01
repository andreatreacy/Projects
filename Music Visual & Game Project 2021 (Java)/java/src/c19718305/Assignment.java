package c19718305;

import ie.tudublin.*;
import java.util.ArrayList;

/*
Music Visual Assignment
Author: Andrea Treacy
Student Number: C19718305
Compiler: Visual Studio Code
Date: 07/05/2021
*/

public class Assignment extends Visual {

    public void settings() {
        size(800, 600, P3D);    // P3D needed for 3D shapes
    }

    StopWatch timer = new StopWatch();
    Bomb b1, b2, b3;
    Health h;
    Game g;
    MusicSymbol m;
    Star st;
    ArrayList<Bomb> bombs = new ArrayList<Bomb>();
    ArrayList<MusicSymbol> notes = new ArrayList<MusicSymbol>();
    ArrayList<Star> stars = new ArrayList<Star>();
    ArrayList<Cube> cubes = new ArrayList<Cube>();


    public void setup() {
        startMinim();
        loadAudio("java/data/Move Your Feet.mp3", width);   // load this file as the audio buffer cant be empty
        lerpedBuffer = new float[width];

        // create game objects
        g = new Game(this);
        h = new Health(this, g);
        b1 = new Bomb(this, g, 1);
        b2 = new Bomb(this, g, 2);
        b3 = new Bomb(this, g, 2);
        bombs.add(b1);
        bombs.add(b2);
        bombs.add(b3);

        // create 20 music symbols for case 4
        for(int i=0; i<20; i++)
        {
            m = new MusicSymbol(random(width), random(height), 18, random(255), random(10), random(3,7), this);
            notes.add(m);   // add music symbol to the array list
        }

        // create 100 stars for case 2
        for(int i=0; i<100; i++)
        {
            st = new Star(random(width), random(height));
            stars.add(st);   // add star to the array list
        }
    }

    public void keyPressed() {

        //Used for manually switching cases
        if (keyCode >= '0' && keyCode <= '9') 
        {
            which = keyCode - '0';
        }
        

        if (keyCode == ' ') 
        {
            // pause visual
            if (getAudioPlayer().isPlaying()) 
            {
                getAudioPlayer().pause();
                timer.stop();
            } 
            // unpause visual
            else 
            {
                getAudioPlayer().rewind();
                getAudioPlayer().play();
                timer.resume();
            }
        }
    }



    public void mouseClicked()
    {
        // Case 0: check if mouse clicked play game icon
        if(which == 0 && dist(mouseX, mouseY, width*0.75f, height/4 ) < 230 / 2)
        {
            loadAudio("java/data/Hot Butter Popcorn Song.mp3", width);  // load game music
            getAudioPlayer().play();  // play the mp3 file
            which = 9;
            g.setHealth(30);
            g.setScore(0);
        }

        // Case 0: check if mouse clicked play visual icon
        if(which == 0 && dist(mouseX, mouseY, width*0.75f, (height/2)*1.5f) < 230 / 2)
        {
            loadAudio("java/data/Move Your Feet.mp3", width);   // load visual music
            getAudioPlayer().play();  // play the mp3 file
            which = 1;
            timer.start();
        }

        // Case 9: enhanced for loop to iterate through all bombs
        for(Bomb b: bombs)
        {
            // check if mouse clicked in the bomb's area
            if(which == 9 && dist(mouseX, mouseY, b.x, b.y) < 25)
            {
                g.setScore(g.getScore()+10);    // add 10 to current game's score
                b.respawn();    // respawn the bomb
            }
        }

        // Case 9: check if mouse clicked in the health's area
        if(which == 9 && dist(mouseX, mouseY, h.x+25, h.y+25) < 25)
        {
            h.updateStats(g);   // this will add 10 to the player's health
            h.respawn();    // respawn the health
        }
    }


    float[] lerpedBuffer;
    int which = 0;
    boolean tap = true;
    float lerpedAverage = 0;
    float size = 0;
    float angle = 0;
    int numCubes = 1;

    // Case 6: optional messages to print
    String message1 = "Yeah!";
    String message2 = "Oh Yeah!";
    String message3 = "Don't Stop!";
    String message4 = "Can't Stop!";
    String message5 = "Won't Stop!";
    String message = message1;


    public void draw() {
        background(0);
        stroke(255);
        float halfHeight = height / 2;
        float halfWidth = width / 2;
        float average = 0;
        float sum = 0;

        // Calculate the average of the buffer
        for (int i = 0; i < getAudioBuffer().size(); i ++)    // .size() as ab is treated as array list
        {
            sum += abs(getAudioBuffer().get(i));  // abs = absolute value
        }
        average = sum / (float)getAudioBuffer().size();
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);


        // Case 8: make the stick man tap his feet
        if(timer.getTimeSeconds()%2 == 0)
        {
            tap = false;
        }
        else
        {
            tap = true;
        }

        // if message to print is Yeah!
        if(timer.getTimeSeconds() == 23.0 || timer.getTimeSeconds() == 74.0 || timer.getTimeSeconds() == 123.0 || 
        timer.getTimeSeconds() == 174.0)
        {
           message = message1;
        }

        // if message to print is Oh Yeah!
        if(timer.getTimeSeconds() == 26.0 || timer.getTimeSeconds() == 78.0 || timer.getTimeSeconds() == 127.0)
        {
           message = message2;
        }

        // if message to print is Don't Stop!
        if(timer.getTimeSeconds() == 47.0 || timer.getTimeSeconds() == 98.0 || timer.getTimeSeconds() == 140.0)
        {
           message = message3;
        }

        // if message to print is Can't Stop!
        if(timer.getTimeSeconds() == 50.0 || timer.getTimeSeconds() == 101.0 || timer.getTimeSeconds() == 143.0)
        {
           message = message4;
        }

        // if message to print is Won't Stop!
        if(timer.getTimeSeconds() == 52.0 || timer.getTimeSeconds() == 103.0 || timer.getTimeSeconds() == 145.0)
        {
           message = message5;
        }

        // if case 1 is to be displayed
        if(timer.getTimeSeconds() == 37.0 || timer.getTimeSeconds() == 180.0 || timer.getTimeSeconds() == 102 ||
        timer.getTimeSeconds() == 130.0 || timer.getTimeSeconds() == 166.0 || timer.getTimeSeconds() == 181.0)
        {
            which = 1;
        }

        // if case 2 is to be displayed
        if(timer.getTimeSeconds() == 54.0 || timer.getTimeSeconds() == 88.0 || timer.getTimeSeconds() == 116.0 ||
        timer.getTimeSeconds() == 158.0 || timer.getTimeSeconds() == 172.0 || timer.getTimeSeconds() == 178.0)
        {
            which = 2;
        }

        // if case 3 is to be displayed
        if(timer.getTimeSeconds() == 29.0 || timer.getTimeSeconds() == 50.0 || timer.getTimeSeconds() == 80.0 ||
        timer.getTimeSeconds() == 100.0 || timer.getTimeSeconds() == 134.0 || timer.getTimeSeconds() == 177.0)
        {
            which = 3;
        }

        // if case 4 is to be displayed
        if(timer.getTimeSeconds() == 14.0 || timer.getTimeSeconds() == 75.0 || timer.getTimeSeconds() == 102.0 ||
        timer.getTimeSeconds() == 126.0 || timer.getTimeSeconds() == 138.0)
        {
            which = 4;
        }

        // if case 5 is to be displayed
        if(timer.getTimeSeconds() == 25.0 || timer.getTimeSeconds() == 52 || timer.getTimeSeconds() == 91.0 ||
        timer.getTimeSeconds() == 142.0 || timer.getTimeSeconds() == 176.0)
        {
            which = 5;
        }

        // if case 6 is to be displayed
        if(timer.getTimeSeconds() == 24.0 || timer.getTimeSeconds() == 28.0 || timer.getTimeSeconds() == 32.0 ||
        timer.getTimeSeconds() == 36.0 || timer.getTimeSeconds() == 49.0 || timer.getTimeSeconds() == 51.0 ||
        timer.getTimeSeconds() == 53.0 || timer.getTimeSeconds() == 74.0 || timer.getTimeSeconds() == 78.0 ||
        timer.getTimeSeconds() == 82.0 || timer.getTimeSeconds() == 86.0 || timer.getTimeSeconds() == 99.0 ||
        timer.getTimeSeconds() == 101.0 || timer.getTimeSeconds() == 103.0 || timer.getTimeSeconds() == 125.0 ||
        timer.getTimeSeconds() == 129.0 || timer.getTimeSeconds() == 133.0 || timer.getTimeSeconds() == 137.0 ||
        timer.getTimeSeconds() == 141.0 || timer.getTimeSeconds() == 144.0 || timer.getTimeSeconds() == 146.0 ||
        timer.getTimeSeconds() == 179.0)
        {
            which = 6;
        }

        // if case 7 is to be displayed
        if(timer.getTimeSeconds() == 33.0 || timer.getTimeSeconds() == 65.0 || timer.getTimeSeconds() == 84.0 ||
        timer.getTimeSeconds() == 102.0 || timer.getTimeSeconds() == 147.0 || timer.getTimeSeconds() == 172.0 || 
        timer.getTimeSeconds() == 173.0 || timer.getTimeSeconds() == 174.0)
        {
            which = 7;

            // display 1 cube
            if(timer.getTimeSeconds() == 33.0 || timer.getTimeSeconds() == 172.0)
            {
                numCubes = 1;
            }

            // display 2 cubes
            if(timer.getTimeSeconds() == 65.0 || timer.getTimeSeconds() == 102.0 || timer.getTimeSeconds() == 173.0)
            {
                numCubes = 2;
            }

            // display 4 cubes
            if(timer.getTimeSeconds() == 84.0 || timer.getTimeSeconds() == 147.0 || timer.getTimeSeconds() == 174.0)
            {
                numCubes = 4;
            }
        }

        // if case 8 is to be displayed
        if(timer.getTimeSeconds() == 40.0 || timer.getTimeSeconds() == 104.0 || timer.getTimeSeconds() == 145.0
        || timer.getTimeSeconds() == 175.0)
        {
            which = 8;
        }

        switch (which)
        {
            // menu
            case 0:
            {
                getAudioPlayer().pause();   // don't play audio on the menu
                colorMode(RGB);
                fill(181,23,192);
                stroke(181,23,192);
                textAlign(CENTER, CENTER);
                textSize(70);
                text("Play Game", width*0.25f+50, halfHeight/2);
                text("Play Visual", width*0.25f+50, halfHeight*1.5f);
                noFill();

                // if mouse is over play game icon
                if(dist(mouseX, mouseY, width*0.75f, halfHeight/2 ) < 230 / 2)
                {
                    stroke(240,116,249);    // light purple
                }
                
                // play game icon
                triangle(width*0.75f+50, halfHeight/2, width*0.75f-50, halfHeight/2+50, width*0.75f-50, halfHeight/2-50);
                strokeWeight(4);
                ellipse(width*0.75f, halfHeight/2, 200, 200);
                ellipse(width*0.75f, halfHeight/2, 230, 230);

                stroke(181,23,192);     // reset to dark purple

                // if mouse is over play visual icon
                if(dist(mouseX, mouseY, width*0.75f, halfHeight*1.5f ) < 230 / 2)
                {
                    stroke(240,116,249);    // light purple
                }

                // play visual icon
                triangle(width*0.75f+50, halfHeight*1.5f, width*0.75f-50, halfHeight*1.5f+50, width*0.75f-50, halfHeight*1.5f-50);
                strokeWeight(4);
                ellipse(width*0.75f, halfHeight*1.5f, 200, 200);
                ellipse(width*0.75f, halfHeight*1.5f, 230, 230);
                break;
            }   

            // coloured spiral
            case 1:
            {
                colorMode(HSB);
                strokeWeight(2);
                float radius = 0.05f;
                int numPoints = 200; // number of points on the spiral
                float thetaInc = TWO_PI / (float)numPoints;
                float lastX = width/2;
                float lastY = height/2;

                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < getAudioBuffer().size(); i++) 
                {
                    float theta = i * (thetaInc + lerpedAverage*2);
                    float x = width/2 + sin(theta) * radius;
                    float y = height/2 - cos(theta) * radius;
                    radius += 0.5f + lerpedAverage;
                    line(lastX, lastY, x, y);
                    float colour = map(i, 0, 300, 0, 255) % 255.0f; // colours go to 255 then start at 0 again
                    stroke(colour,255,255);
                    lastX = x;
                    lastY = y;
                }
                break;
            }  

            // space scene
            case 2:
            {
                colorMode(RGB);
                strokeWeight(1);
                
                // render all of the stars
                for(Star st: stars)
                {
                    st.render(this); 
                }
                
                // create sound wave
                for (int i = 0; i < getAudioBuffer().size(); i++) 
                {
                    float line_colour = map(i, 0, getAudioBuffer().size(), 0, 255);
                    stroke(line_colour, 255, 255);   // colour will be aqua to white as colour mode is RGB
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], getAudioBuffer().get(i), 0.1f);
                    strokeWeight(1);
                    line(halfWidth - getAudioBuffer().get(i) * halfWidth/6, i, halfWidth + getAudioBuffer().get(i) * halfWidth/6, i);
                }

                angle += 0.01f; // increment angle
                fill(255, 78, 1);   // orange
                Sphere s = new Sphere(10, height-50, 100+300*lerpedAverage, 255, 0, 0, angle*3, angle*3);   // red/orange planet
                s.render(this);
                fill(255, 1, 171);  // purple
                s = new Sphere(width-100, 200, 50+200*lerpedAverage, 0, 0, 255, angle*5, angle*5);  // blue/purple planet
                s.render(this);
                fill(255,222,1);    // yellow
                s = new Sphere(100, 100, 20+200*lerpedAverage, 233, 38, 155, angle*2, angle*2); // pink/yellow planet
                s.render(this);

                fill(0, 255, 0);    // green
                rotateY(angle*3);   // rotate
                s = new Sphere(width/2-100, 200, 50, 3, 110, 10, 0, 0);     // dark green/light green planet
                s.render(this);
                fill(9,0,255);  // blue
                rotateY(-angle*5);  // rotate
                s = new Sphere(width-100, height-200, 50, 0, 255, 222, 0, 0);   // aqua/blue planet
                s.render(this);
                break;
            } 

            // growing circles
            case 3:
            {
                colorMode(RGB);
                noFill();
                strokeWeight(6);
                stroke(255, 0, 0);  // red
                ellipse(width/2, height/2, size, size);
                stroke(255, 255, 255);  // white
                ellipse(width/2, height/2, size-100, size-100);
                stroke(0, 255, 255);    // aqua
                ellipse(width/2, height/2, size-200, size-200);
                stroke(255, 0, 255);    // purple
                ellipse(width/2, height/2, size-300, size-300);
                size += 40; // increment size quickly

                // if circle is too big for the screen
                if(size == width+200)
                {
                    size = 0;
                }
                break;
            } 

            // speakers and music symbols scene
            case 4:
            {
                colorMode(RGB);
                noStroke();
                angle += 0.1f;  // increment angle
                fill(255, 18, 1);   // dark orange
                rect(100-30, height*0.25f-30,150,300);  // left back speaker
                rect(width-220, height*0.25f-30,150,300);   // right back speaker
                fill(208, 85, 23);  // light orange
                rect(100, height*0.25f,150,300);    // left speaker
                rect(width-250, height*0.25f,150,300);  // right speaker
                noFill();
                strokeWeight(2);
                Sphere s = new Sphere(180, height*0.25f+50, 10+60*lerpedAverage, 68, 56, 50, 0, 0); // left small speaker diaphragm
                s.render(this);
                s = new Sphere(180, height*0.25f+200, 30+100*lerpedAverage, 68, 56, 50, 0, 0); // left large speaker diaphragm
                s.render(this);
                s = new Sphere(180, height*0.25f+200, 20, 0, 0, 0, 0, 0); // left speaker dust cap
                s.render(this);
                s = new Sphere(width-180, height*0.25f+50, 10+60*lerpedAverage, 68, 56, 50, 0, 0); // right small speaker diaphragm
                s.render(this);
                s = new Sphere(width-180, height*0.25f+200, 30+100*lerpedAverage, 68, 56, 50, 0, 0); // right Large speaker diaphragm
                s.render(this);
                s = new Sphere(width-180, height*0.25f+200, 20, 0, 0, 0, 0, 0); // right speaker dust cap
                s.render(this);
                
                colorMode(HSB); // change to HSB as music symbols will be rendered that way

                //enhanced for loop to go through all music symbols
                for(MusicSymbol n: notes)
                {
                    n.update(this); // update the music symbol's position
                    n.render(this); // render the music symbol
                } 
                break;
            } 

            // sound wave and sphere
            case 5:
            {
                colorMode(HSB);
                noFill();
                strokeWeight(2);
                float size = 100 + 100 * lerpedAverage * 8;

                // create multi-coloured cound wave
                for (int i = 0; i < getAudioBuffer().size(); i++) 
                {
                    float line_colour = map(i, 0, getAudioBuffer().size(), 0, 255);
                    stroke(line_colour, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], getAudioBuffer().get(i), 0.1f);
                    strokeWeight(1);
                    line(i, halfHeight - getAudioBuffer().get(i) * halfHeight/5, i, halfHeight + getAudioBuffer().get(i) * halfHeight/5);
                }

                // as random changes every time draw runs c will flash different colours
                float c = map(random(1),0,1,0,255);
                
                // create a multi-layered sphere
                for(int i=0; i<5; i++)
                {
                    Sphere s = new Sphere(width/2, height/2, size-i*100, c, c, c, angle, angle);
                    s.render(this);
                    angle += 0.01f; // increment angle
                }
                break; 
            } 

            // flashing text
            case 6:
            {
                colorMode(HSB);
                float c = map(random(1),0,1,0,255); // as random changes every time draw runs c will flash different colours
                fill(c,255,255);
                textAlign(CENTER, CENTER);
                textSize(30 + lerpedAverage * 400); // text will grow in response to the music
                text(message, width/2, height/2);
                //text(timer.getTimeSeconds(), width/2, height-50); // uncomment to view time count
                break;
            }

            // dancing cubes
            case 7:
            {
                colorMode(HSB);
                noFill();
                strokeWeight(2);
                angle += 0.05f; // increment angle
                float size = 100 + 100 * lerpedAverage * 5; // cubes will change size in responce to music
                int[] colours = new int[] {240, 300, 60};   // pink, red, yellow

                // create one cube with 3 layers (pink, red, yellow)
                if(numCubes==1)
                {
                    for(int i=0; i<3; i++)
                    {
                        Cube c = new Cube(width/2, height/2, size, colours[i], angle);
                        c.render(this);
                        size = size - 20;   // next layer will be 20 smaller
                    }   
                }
                // create 2 cubes with 3 layers (pink, red, yellow)
                else if(numCubes==2)
                {
                    float x = width*0.25f;  // used to position the cubes side by side

                    // create 2 cubes
                    for(int j=0; j<2; j++)
                    {
                        // create the 3 layers for each cubes
                        for(int i=0; i<3; i++)
                        {
                            Cube c = new Cube(x, height/2, size, colours[i], angle);
                            c.render(this);
                            size = size - 20;   // next layer will be 20 smaller
                        }
                        size = 100 + 100 * lerpedAverage * 5;   // reset size for next cube
                        x = x * 3;  // set new x coordinates for next cube
                    }  
                }
                // create 4 cubes with 3 layers (pink, red, yellow)
                else if(numCubes==4)
                {
                    // used to position the cubes in 2 rows of 2
                    float x = width*0.25f;
                    float y = height*0.25f;

                    // create the 4 cubes
                    for(int j=0; j<4; j++)
                    {
                        // create the three layers for each cube
                        for(int i=0; i<3; i++)
                        {
                            Cube c = new Cube(x, y, size/2, colours[i], angle);
                            c.render(this);
                            size = size - 20;   // next layer will be 20 smaller
                        }
                        size = 100 + 100 * lerpedAverage * 5;   // reset size for next cube

                        // change the x and y coordinates so the cubes are spaced in 2 rows
                        if(j==0 || j==2)
                        {
                            x = x * 3;  // set new x coordinates for next cube
                        }
                        else if(j==1)
                        {
                            x = x / 3;
                            y = y * 3;  // set new y coordinates for next cube
                        }
                    }//end outer for  
                }//end else if
                break;
            } 

            // stick man
            case 8:
            {
                colorMode(HSB);
                strokeWeight(2);
                float size = 100 + 100 * lerpedAverage * 10;

                // create the beams
                for (int i = 0; i < getAudioBuffer().size(); i++) {

                    float line_colour = map(i, 0, getAudioBuffer().size(), 0, 255);
                    stroke(line_colour, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], getAudioBuffer().get(i), 0.1f);
                    strokeWeight(1);
                    //left beam
                    line(halfWidth-100, height*0.75f-100, halfWidth - getAudioBuffer().get(i) * halfWidth-400, 0);
                    //right beam    
                    line(halfWidth+100, height*0.75f-100, halfWidth - getAudioBuffer().get(i) * halfWidth+400, 0);    
                }

                fill(30,255,255);   // yellow
                stroke(30,255,255); // yelow
                strokeWeight(4);
                line(halfWidth, halfHeight+50, halfWidth, height-100);  //body
                line(halfWidth - 50, height *0.75f-50, halfWidth +50, height *0.75f-50);  //arms
                line(halfWidth - 100, height *0.75f-100, halfWidth -50, height *0.75f-50);  //left arm
                line(halfWidth + 100, height *0.75f-100, halfWidth +50, height *0.75f-50);  //right arm
                noStroke();
                ellipse(halfWidth - 100, height *0.75f-100, 20,20); //left hand
                ellipse(halfWidth + 100, height *0.75f-100, 20,20); //right hand
                stroke(30,255,255);
                line(halfWidth, height-100, halfWidth -40, height-20);  //left leg
                line(halfWidth, height-100, halfWidth +40, height-20);  //right leg

                // the stick man will tap his feet
                if(tap==true)
                {
                    // draw feet flat
                    line(halfWidth-40, height-20, halfWidth-80,height-20);  //left foot
                    line(halfWidth+40, height-20, halfWidth+80,height-20);  //right foot
                }
                else
                {
                    // draw feet raised
                    line(halfWidth-40, height-20, halfWidth-80,height-30);  //left foot
                    line(halfWidth+40, height-20, halfWidth+80,height-30);  //right foot
                }

                fill(30,255,255);
                ellipse(halfWidth, halfHeight, 100, 100);   //head
                fill(255);  // white
                stroke(0);  // black
                strokeWeight(1);
                ellipse(halfWidth-20, halfHeight-10, 10+size/20, 10+size/20);   //left eye
                ellipse(halfWidth+20, halfHeight-10, 10+size/20, 10+size/20);   // right eye
                fill(0);    // black
                ellipse(halfWidth-20, halfHeight-10, 2+size/20, 1+size/20);   //left pupil
                ellipse(halfWidth+20, halfHeight-10, 2+size/20, 1+size/20);   //right pupil
                fill(245,255,255);  // pink
                triangle(halfWidth, halfHeight+35,halfWidth-10,halfHeight+15, halfWidth+10,halfHeight+15);  //mouth
                break;
            }

            case 9:
            {
                colorMode(RGB);

                // if game has not ended
                if(g.getHealth()>0)
                {
                    background(149, 154, 148);  // grey
                    noFill();

                    // draw target around the mouse pointer
                    stroke(14,108,4);   // dark green
                    ellipse(mouseX, mouseY, 80, 80);
                    line(mouseX+40, mouseY, mouseX-40, mouseY);
                    line(mouseX, mouseY+40, mouseX, mouseY-40);

                    // draw bunker
                    stroke(0);  // black
                    line(20, height-60, width-20, height-60);   // top of bunker
                    line(0, height, 20, height-60); //left side
                    line(width, height, width-20, height-60);   //right side

                    textSize(20);
                    fill(255,0,0);  // red

                    // display score and health
                    text("Score: " + g.getScore(), 100, height-30);
                    text("Bunker Health: " + g.getHealth(), width-150, height-30);

                    h.update(); // update health pack's position
                    h.render(this); // render the health pack

                    // iterate through all of the bombs
                    for(Bomb b: bombs)
                    {
                        b.update(); // update bomb's position
                        b.render(this);     // render the bomb
                    } 
                }
                // game is over
                else
                {
                    fill(255,0,0);  // red
                    textSize(100);
                    textAlign(CENTER, CENTER);
                    text("GAME OVER", halfWidth, halfHeight);
                    text("Score: " + g.getScore(), halfWidth, halfHeight+100);
                }
                break;
            }
            
        }        
    }
}