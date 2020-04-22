package ie.tudublin;

import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;
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
		Table t - loadTable("tasks.csv", "header");

		// loop over each row and retrieve the data
		for(TableRow tr : t.rows())
		{
			Task task = new Task(tr);
			tasks.add(task);
		}
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
