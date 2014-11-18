public class PlaySudoku            
{public void set(int [][]a)                 //sets a solvable sudoku
  {SudokuSolver obj=new SudokuSolver();
   SudokuFunctions obj2=new SudokuFunctions();
   int[][]b=new int [9][9];                 //a copy of original array
   int i=0,j=0,num=0,tag=0;
   boolean flag=false;           //becomes true when the sudoku is solvable
   while(flag==false)
    {if(tag==1000)                     //if it gets stuck, then restart
      {tag=0;
       for(i=0;i<9;i++)
        {for(j=0;j<9;j++)
          {a[i][j]=0;
           b[i][j]=0;
          }
        }
      }
     do 
      {i=(int)(Math.random()*9);           //randomly generate row
       j=(int)(Math.random()*9);           //randomly generate column
       num=(int)(Math.random()*10);        //randomly generate number
      }while(obj2.isValid(b,i,j,num)==false || a[i][j]!=0);  
     a[i][j]=num;
     b[i][j]=num;
     flag=obj.solve(b);                 //checks if it is solvable
     tag++;
    }
   obj2.show(a);                         //displays the sudoku
  } 
  
 public void userPlay()                 //the main program
  {System.out.println("\f\n********************************************PLAY SUDOKU GAME**********************************************\n");
   SudokuSolver obj=new SudokuSolver();
   SudokuFunctions obj2=new SudokuFunctions();
   int [][]a=new int[9][9];              //create sudoku
   int i,j,n;
   int[][]soln=new int[9][9];            //copies sudoku into another array
   boolean flag;
   System.out.println("\n\t\tThe sudoku to solve is: ");
   set(a);                               //sets a solvable sudoku
   for(i=0;i<9;i++)
     {for(j=0;j<9;j++)
        {soln[i][j]=a[i][j];
        }
     }
   obj.solve(soln);                     //soln carries solved array
   System.out.println("Proceed to solving....");
   while(obj2.isDone(a)==false)
     {flag=true;
      n=SimpleInput.askInt("\nWhat would you like to do? \n   Enter '1'. To continue with entering values \n   Enter '2'. To remove mistakes press  \n   Enter '3'. To see solution  \n   Enter '4'. To Quit \n Please enter your choice: ");
      switch(n)                                   //switch-case
       {case 1: obj2.singleInput(a,'n');          //user fills a cell
                System.out.println("\f");
                obj2.show(a);
                break;
        case 2: for(i=0;i<9;i++)                  //removes mistakes
                  {for(j=0;j<9;j++) 
                    {if(a[i][j]!=soln[i][j])
                       a[i][j]=0;
                    }
                  }
                obj2.show(a);
                System.out.println("\nYour mistakes have been removed.");
                break;
        case 3: System.out.println("\nHere is the correct solution:");
                obj2.show(soln);                //shows the solution
                flag=false;
                break;
        case 4: flag=false;                 //quits from the loop
                System.out.println("\nYou have successfully quit the game.");
                break;          
        default: System.out.println("Entered choice does not exist.");
        }
      if(flag==false)
        break;
      if(obj2.isDone(a)==true)          //checks if all cells are filled
         {for(i=0;i<9;i++)
           {for(j=0;j<9;j++)
              {if(a[i][j]!=soln[i][j]) //ensures all are filled correctly
                  {flag=false;
                   a[i][j]=0;
                  }
              }
           }
          if(flag==true)               //if it has been correctly solved
             System.out.println("\n\t\t\tMission accomplished!!!"); 
          else
             {System.out.println("Sorry, one or more values had been entered incorrectly. They have been removed.");
              obj2.show(a);
             }
         }
     }
  }
}