package TMS;
import java.io.*;
import java.util.*;

public class Task {
	
public int TaskId;
public String Title;
public String Description;
public int EmployeeId;
public int TaskStatusId;
public int ProjectId;
public int EstimatedHours;

Date StartDate = new Date();
Date EndDate = new Date();

	public boolean Add(int TaskId,String Title,String Description,int EmployeeId, int TaskStatusId,int ProjectId,int EstimatedHours)
	    {   boolean flag=false;
		BufferedWriter bw=null;
		try{
		    bw=new BufferedWriter(new FileWriter("Task.txt",true));
		    bw.write(TaskId+","+Title+","+Description+","+EmployeeId+","+TaskStatusId+","+ProjectId+","+EstimatedHours+"\n");
		    bw.close();
		    flag=true;
	           } 
                catch (IOException e) {
		e.printStackTrace();
	        }
		return flag;	
	    }
	    
	    
	public boolean UpdateTaskStatus(int TaskId, int TaskStatusId)
	    {   boolean flag=false;
		String Value=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		BufferedWriter BwHolder=null;
		BufferedReader BrHolder = null;
		String[] holder;
		try {
		BwHolder =new BufferedWriter(new FileWriter("TaskHolder.txt"));
		br=new BufferedReader(new FileReader("Task.txt"));
		
		while((Value=br.readLine())!=null) {
			holder=Value.split(",");
			if(String.valueOf(TaskId).equals(holder[0]) ) {
			    flag=true;
		            BwHolder.write(TaskId+","+holder[1]+","+holder[2]+","+holder[3]+","+TaskStatusId+","+holder[5]+","+holder[6]+"\n");
			    }
			else {
			BwHolder.write(holder[0]+","+holder[1]+","+holder[2]+","+holder[3]+","+holder[4]+","+holder[5]+","+holder[6]+"\n");
		}
		}
		BwHolder.close();
		br.close();
		 bw=new BufferedWriter(new FileWriter("Task.txt"));
		 BrHolder=new BufferedReader(new FileReader("TaskHolder.txt"));
		while((Value=BrHolder.readLine())!=null) {
			holder=Value.split(",");
			bw.write(holder[0]+","+holder[1]+","+holder[2]+","+holder[3]+","+holder[4]+","+holder[5]+","+holder[6]+"\n");
		}
		bw.close();
		BrHolder.close();
		}
		catch (IOException e) {
	            e.printStackTrace();
		}
		return flag;
	    }

	public boolean Update(int TaskId,String Title,String Description,int EmployeeId, int TaskStatusId,int ProjectId,int EstimatedHours)
	    {   boolean flag=false;
		String Value=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		BufferedWriter BwHolder=null;
		BufferedReader BrHolder = null;
		String[] holder;
		try {
		BwHolder =new BufferedWriter(new FileWriter("TaskHolder.txt"));
		br=new BufferedReader(new FileReader("Task.txt"));
		while((Value=br.readLine())!=null) {
			holder=Value.split(",");
			if(String.valueOf(TaskId).equals(holder[0]) ) {
			    flag=true;
			    BwHolder.write(TaskId+","+Title+","+Description+","+EmployeeId+","+TaskStatusId+","+ProjectId+","+EstimatedHours+"\n");
                        }
			else {
			BwHolder.write(holder[0]+","+holder[1]+","+holder[2]+","+holder[3]+","+holder[4]+","+holder[5]+","+holder[6]+"\n");
		}
		}
		BwHolder.close();
		br.close();
		 bw=new BufferedWriter(new FileWriter("Task.txt"));
		 BrHolder=new BufferedReader(new FileReader("TaskHolder.txt"));
		while((Value=BrHolder.readLine())!=null) {
			holder=Value.split(",");
			bw.write(holder[0]+","+holder[1]+","+holder[2]+","+holder[3]+","+holder[4]+","+holder[5]+","+holder[6]+"\n");
		}	
		
		bw.close();
		BrHolder.close();
		}
		catch (IOException e) {
	        e.printStackTrace();
		}
		return flag;
	    }
	public boolean Delete(int TaskId)
	    {   boolean flag=false;
		String Value=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		BufferedWriter BwHolder=null;
		BufferedReader BrHolder = null;
		String[] holder;
		try {
		BwHolder =new BufferedWriter(new FileWriter("TaskHolder.txt"));
		br=new BufferedReader(new FileReader("Task.txt"));
		while((Value=br.readLine())!=null) {
			holder=Value.split(",");
			if(String.valueOf(TaskId).equals(holder[0]) ) {
			    flag=true;
			continue;
			}
			else {
			BwHolder.write(holder[0]+","+holder[1]+","+holder[2]+","+holder[3]+","+holder[4]+","+holder[5]+"+"+holder[6]+"\n");
		}
		}
		BwHolder.close();
		br.close();
		bw=new BufferedWriter(new FileWriter("Task.txt"));
		BrHolder=new BufferedReader(new FileReader("TaskHolder.txt"));
		while((Value=BrHolder.readLine())!=null) {
		    holder=Value.split(",");
	            bw.write(holder[0]+","+holder[1]+","+holder[2]+","+holder[3]+","+holder[4]+","+holder[5]+"+"+holder[6]+"\n");
		}	
		bw.close();
		BrHolder.close();
		}
		catch (IOException e) {
		   e.printStackTrace();
	        }
		return flag;
}
        
        
        public Task GetTaskById(int TaskId)
	    { 
              String Value=null;
              BufferedReader br=null;
              String[] holder;
              Task Obj= new Task();
                try{
                  br= new BufferedReader(new FileReader("Task.txt"));
                  while((Value=br.readLine())!=null) {
			holder=Value.split(",");
			if(String.valueOf(TaskId).equals(holder[0])) {
                            Obj.Title=String.valueOf(holder[1]);
                            Obj.Description=String.valueOf(holder[2]);
                            Obj.EmployeeId=Integer.valueOf(holder[3]);
                            Obj.TaskStatusId=Integer.valueOf(holder[4]);
                            Obj.ProjectId=Integer.valueOf(holder[5]);
                            Obj.EstimatedHours=Integer.valueOf(holder[6]);
                        }
		        }
		br.close();
                }
              catch(IOException e){
                  e.printStackTrace();
              }
                return Obj;
            }
        
	
	public List<Task> GetProjectTaskList(int ProjectId)
	    { String Value;
              BufferedReader br=null;
              String[] holder;
              ArrayList <Task> Projectlist = new ArrayList <Task>();
	    	try {
	    	    br = new BufferedReader(new FileReader("Task.txt"));
	    	    while ((Value= br.readLine()) != null)
	    		{holder = Value.split(",");
	    		Task obj2 = new Task();
	    		obj2.TaskId = Integer.valueOf(holder[0]);
	    		obj2.Title = holder[1];
	    		obj2.Description = holder [2];
	    		obj2.EmployeeId = Integer.valueOf(holder[3]);
	    		obj2.TaskStatusId = Integer.valueOf(holder[4]);
	    		obj2.ProjectId = Integer.valueOf(holder[5]);
	    		obj2.EstimatedHours = Integer.valueOf(holder[6]);
	    		if(obj2.ProjectId == ProjectId)
	    		{
	    		Projectlist.add(obj2);
	    		}
		    	br.close();
	    	}
	    	}
	    	catch(IOException e) {
	    	     e.printStackTrace();
	    	    }
	    	return Projectlist;
              }
	    
	    public List<Task> GetEmployeeTaskList(int EmployeeId)
	    {   ArrayList <Task> Taskslist = new ArrayList <Task>();
	    	String Value;
	    	String[] holder = null;
	    	BufferedReader br;
	    	try {
	    	    br = new BufferedReader(new FileReader("Task.txt"));
	    	    while ((Value= br.readLine()) != null)
	    		{holder = Value.split(",");
	    		Task obj = new Task();
	    		obj.TaskId = Integer.valueOf(holder[0]);
	    		obj.Title = holder[1];
	    		obj.Description = holder [2];
	    		obj.EmployeeId = Integer.valueOf(holder[3]);
	    		obj.TaskStatusId = Integer.valueOf(holder[4]);
	    		obj.ProjectId = Integer.valueOf(holder[5]);
	    		obj.EstimatedHours = Integer.valueOf(holder[6]);
	    		if(obj.EmployeeId == EmployeeId)
	    		{
	    		Taskslist.add(obj);
	    		}
		    	br.close();
	    	}
	    	}
	    	catch(IOException e) {
	    	     e.printStackTrace();
	    	    }
	    	return Taskslist;
	    }
	    
	    public List<Task> GetTaskList()
	    {
	    	ArrayList <Task> Taskslist = new ArrayList <Task>();
	    	String Value;
	    	String[] holder = null;
	    	BufferedReader br;
	    	
	    	try {   br = new BufferedReader(new FileReader("Task.txt"));
	    		while ((Value= br.readLine()) != null )
	    		{holder = Value.split(",");
	    		Task obj = new Task();
	    		obj.TaskId = Integer.valueOf(holder[0]);
	    		obj.Title = holder[1];
	    		obj.Description = holder [2];
	    		obj.EmployeeId = Integer.valueOf(holder[3]);
	    		obj.TaskStatusId = Integer.valueOf(holder[4]);
	    		obj.ProjectId = Integer.valueOf(holder[5]);
	    		obj.EstimatedHours = Integer.valueOf(holder[6]);
	    		Taskslist.add(obj);
	    		}
		    	br.close();
	    	}
	    	
	    	catch(IOException e) {
	    	    e.printStackTrace();  
	    	}
	    	return Taskslist;
	    }

}
