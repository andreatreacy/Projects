package ie.tudublin;

import c19718305.Assignment;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Assignment());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}