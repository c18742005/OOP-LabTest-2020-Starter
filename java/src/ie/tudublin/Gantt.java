package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.TableRow;
import processing.data.Table;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>(); //array list to hold instances of the task class
	
	public void settings()
	{
		size(800, 600);
	}

	// method to populate the tasks arraylist from the tasks.csv file
	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");

		// loop over each row and retrieve the data
		for(TableRow tr : t.rows())
		{
			Task task = new Task(tr);
			tasks.add(task);
		}
	}

	// method to print each task to the console
	public void printTasks()
	{
		// lopp through each task and print to console
		for(Task t : tasks)
		{
			println(t);
		}
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
