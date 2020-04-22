package ie.tudublin;

import processing.data.TableRow;

public class Task
{
    private String task;
    private int start;
    private int end;

    //accessor methods
    public void setTask(String task)
    {
        this.task = task;
    }

    public String getTask()
    {
        return task;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public int getStart()
    {
        return start;
    }

    public void setEnd(int end)
    {
        this.end = end;
    }

    public int getEnd()
    {
        return end;
    }

    //Converts the object to a string to allow printing to console
    public String toString()
    {
        return task + "\t" + start + "\t" + end;
    }

    // constructor that takes intial values and assigns them to fields
    public Task(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    // constructor that takes a TableRow as a parameter
    public Task(TableRow tr)
    {
        this(
            tr.getString("Task")
            , tr.getInt("Start")
            , tr.getInt("End")
        );
    }
}