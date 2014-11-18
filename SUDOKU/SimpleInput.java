import java.io.*;
public class SimpleInput            /*takes input of a particular datatype*/
{ //static BufferedReader object
 public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  
 public static int askInt(String q)          // for integer inputs    
  {int n=0;
   boolean valid;
   do
    {valid=true;
     try
       {System.out.print(q);
        n=Integer.parseInt(br.readLine());
       }
     catch(Exception e)                            //if there is an error
       {System.out.println("Invalid data type. Please enter again.");
        valid=false;
       }
    }while(valid==false);
   return n;
  }
  
 public static String askString(String q)       //for String inputs
  {String s="";
   try
     {System.out.print(q);
      s=br.readLine();
     }
   catch(Exception e)                                 //dummy catch 
     {
     }
   return s; 
  }
}                                                    //end of class