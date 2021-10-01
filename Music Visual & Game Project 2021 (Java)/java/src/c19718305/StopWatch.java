package c19718305;

public class StopWatch {

  private long startTime = 0;
  private long stopTime = 0;
  private boolean running = false;


  public void start() 
  {
    startTime = System.currentTimeMillis();
    running = true;
  }


  public void stop() 
  {
    stopTime = System.currentTimeMillis();
    running = false;
  }


  public void resume() 
  {
    startTime = getTimeMilliseconds();  // resume from the time it stopped at
    running = true;
  }


  // time passed in milliseconds
  public long getTimeMilliseconds() 
  {
    long timePassed;

    if(running == true) 
    {
      timePassed = (System.currentTimeMillis() - startTime);
    } 
    else 
    {
      timePassed = (stopTime - startTime);
    }
    return timePassed;
  }


  // time passed in seconds
  public long getTimeSeconds() 
  {
    long timePassed;

    if (running == true) 
    {
      timePassed = (System.currentTimeMillis() - startTime) / 1000; // 1000 milliseconds in a second
    } 
    else 
    {
      timePassed = (stopTime - startTime) / 1000;
    }
    return timePassed;
  }
}