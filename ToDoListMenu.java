package miniproject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class ToDoListMenu 
{
    public static void main(String args[]) 
    throws IOException
	{
		int choice;
		String name;
		Scanner sc=new Scanner(System.in);
		do
		{
		System.out.println("========To-Do-List Menu========");
		System.out.println("1.Add Task");
		System.out.println("2.View Task");
		System.out.println("3.Remove a Task");
		System.out.println("4.Quit");
		System.out.println("Enter The Your Choice:");
		choice=sc.nextInt();
		char[] array =new char[100];
		char[] name1=new char[100];
		switch(choice)
		{
		 
		case 1:
			
		  System.out.println("Enter The Task");
		  name=sc.next();
		  try (PrintWriter writer = new PrintWriter(new FileWriter("perna.txt", true))) 
	        {
	            writer.println(name + ",");
	            System.out.println("Enter Task successfully added.");
	           
	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	        break;
	        
		case 2:
			
            System.out.println("To View Task List");
            FileReader reader=new FileReader("perna.txt");
    		//BufferedReader bufferedReader=new BufferedReader(reader);
    		reader.read(array);
    		System.out.println(array);
    		reader.close();
       break;
       
	case 3:
		
		Scanner sc1 = new Scanner(System.in);

        System.out.print("Enter the  Task to remove: ");
        String 	name11= sc1.next();

        BufferedReader reader1 = new BufferedReader(new FileReader("perna.txt"));
        String currentLine;
        StringBuilder fileContent = new StringBuilder();

        while ((currentLine = reader1.readLine()) != null)
         {
            if (currentLine.contains(name11))
            {
                continue;
            }
            
            fileContent.append(currentLine).append("\n");
        }
  
        reader1.close();
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("perna.txt")));
        writer.print(fileContent.toString());
        writer.close();

        System.out.println("Task removed successfully.");
        break;
        
	case 4:
		  System.out.println("Quit");
		  }
		}
		while(choice<=4);
	}
}