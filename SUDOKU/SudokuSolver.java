import java.io.*;
import java.util.*;
public class SudokuSolver          
{public static SudokuFunctions obj2=new SudokuFunctions();       
 
 public void input(int [][]a)          //inputs the incomplete sudoku
  {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   String s="";
   boolean flag;
   System.out.println("\f\n***********************************************SUDOKU SOLVER*************************************************\n");
   System.out.println("\nEnter values in each line from left to right separated by commas(,). Blanks are to be represented by 0(zeros). ");
   int r,c,num=0;
   for(r=0;r<9;r++)
    {obj2.show(a);   
     do
      {flag=true;
       s=SimpleInput.askString("\n\t Enter values for line "+(r+1)+": "); 
       StringTokenizer stz=new StringTokenizer(s,",");   //separates using StringTokenizer
       if(stz.countTokens()==9)
        {for(c=0;c<9;c++)
          {try                                          //error handling
             {num=Integer.parseInt(stz.nextToken().trim());
             }
           catch(Exception e)
             {System.out.println("You have entered a non-integer. Please enter again.");
              flag=false;
             }
           if(obj2.isValid(a,r,c,num)==true && num>=0 && num<10 && flag==true)     //checks validity of input
              a[r][c]=num;               
           else
             {System.out.println("Input values not valid for positions.Please enter again.");
              flag=false;
              break;
             }
          }
        }
       else
        {flag=false;
         System.out.println("You have not entered 9 values. Enter again.");
        }
      }while(flag==false);
    }
   obj2.show(a); 
  }
  
 public boolean solve(int [][]a)          //returns true when solvable
  {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   int [][]b=new int[9][9];                //copy of original
   int i,j,num,pass=0;
   do
    {pass=0;
     for(num=1;num<=9;num++)
      {pass+=obj2.fillSingleCells(a);      //normal scan to fill uP
       for(i=0;i<9;i++)                    // copies a into b
        {for(j=0;j<9;j++)
          {b[i][j]=a[i][j];
           if(a[i][j]==0)       //if the position is empty it fills num
               b[i][j]=num;
          }
        }  
       for(i=0;i<9;i++)         // removes wrong duplicates
        {for(j=0;j<9;j++)
          {if(a[i][j]==num)
             obj2.removeDuplicates(a,b,i,j); 
          }
        }
       for(i=0;i<9;i++)      //checks if a num fits in a particular cell
         {for(j=0;j<9;j++)
            {if(b[i][j]==num  && a[i][j]==0 && obj2.isPossible(b,i,j,num)==true)
                {a[i][j]=num;
                 pass++;
                }
            }
         }
      }
     if(obj2.isDone(a)==true)    //checks if solved
         break;
    }while(pass>0);              //if no values filled, then come out
   if(obj2.isDone(a)==true)      //if solved,return true
      return true;
   else 
      return false;           //returns false when data is insufficient
  }

 public void program()                         //the main function
  {SudokuSolver obj=new SudokuSolver();
   int [][]a=new int [9][9];
   obj.input(a);
   boolean flag=true;
   System.out.println("\n\t\tSolving.....\n");
   do
    {flag=obj.solve(a);        //checks if it is solvable(pure sudoku)
     obj2.show(a);      
     if(flag==false)                    //if not, asks for more values
      {System.out.println("INSUFFICIENT VALUES. ENTER MORE VALUES.");
       obj2.singleInput(a,'y');             //inputs 1 cell at a time
      }
    }while(flag==false);
   System.out.println("\t\t\t\tYour sudoku is solved above.");
  }
}