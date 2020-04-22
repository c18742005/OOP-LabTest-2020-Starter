package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.TableRow;
import processing.data.Table;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>(); //array list to hold instances of the task class
	
	// variable to control the size of the border around the graph
	float borderLeft = 1.5f * width;
	float borderRight = 0.4f * width;
	float borderY = 0.6f * height;
	int rectHeight = 35; // height of each rectangle bar

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

	public void displayTasks()
	{
		stroke(255);
		textAlign(CENTER, CENTER);

		// loop to draw the grid
		for(int i = 1; i <= 30; i++)
		{
			float x = map(i, 1, 30, borderLeft, width - borderRight);
			
			line(x, borderRight, x, height - borderRight);
			fill(255);
			text(i, x, borderRight / 2);
		}

		// loop to draw the task names beside the grid
		for(int i = 0; i < tasks.size(); i++)
		{
			float y = map(i, 0, tasks.size(), borderY, height - borderY);
			text(tasks.get(i).getTask(), borderY, y + 15);
		}

		colorMode(HSB);

		// loop to draw the bars of the chart
		for(int i = 0; i < tasks.size(); i++)
		{
			float x = map(tasks.get(i).getStart(), 1, 30, borderLeft, width - borderRight);
			float y = map(i, 0, tasks.size(), borderY, height - borderY);
			float x1 = map(tasks.get(i).getEnd(), 1, 30, borderLeft, width - borderRight);
			float colourDiff = 255 / tasks.size(); // changes the HSB colour of each bar
			
			noStroke();
			fill(i * colourDiff, 255, 255);
			rect(x, y, x1 - x, rectHeight);
		}
	}
	
	int selected; // hold the selected bar of the bar chart
	int barSide = -1; // holds whether the start or end of the bar chart is selected. 0 is start, 1 is end, -1 is none

	public void mousePressed()
	{	
		for(int i = 0; i < tasks.size(); i++)
		{
			float x = map(tasks.get(i).getStart(), 1, 30, borderLeft, width - borderRight);
            float x1 = map(tasks.get(i).getEnd(), 1, 30, borderLeft, width - borderRight);
            float y = map(i, 0, tasks.size(), borderY, height - borderY);
			
			// check if start of gantt chart is selected
			if(mouseX >= x - 20 && mouseX <= x + 20 && mouseY >= y && mouseY <= y + rectHeight)
			{
				println("Mouse pressed start of bar chart");
				selected = i;
				barSide = 0;
			} // check if end of gantt char is selected
			else if(mouseX >= x1 - 20 && mouseX <= x1 + 20 && mouseY >= y && mouseY <= y + rectHeight)
			{
				println("Mouse pressed end of bar chart");
				selected = i;
				barSide = 1;
			}
		}
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
		float x = map(mouseX, borderLeft, width - borderRight, 1, 30);
		
		// if the start of the bar is selected then alter the start value of the bar
		if(barSide == 0)
		{
			tasks.get(selected).setStart((int)x);
		}
		else if(barSide == 1) // if the end of the chart is selected then alter the end of the bar
		{
			tasks.get(selected).setEnd((int)x);
		}
	}

	// setup method to load tasks from csv file and print them to console
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
