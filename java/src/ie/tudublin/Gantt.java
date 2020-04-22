package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>(); //array list to hold instances of the task class
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		
	}

	public void printTasks()
	{
		
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
	}
	
	public void draw()
	{			
		background(0);
	}
}
