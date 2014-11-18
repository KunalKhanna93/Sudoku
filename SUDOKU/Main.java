public class Main                    //the main class to be called
{
 public static void main(String []args)          //main function
  {SudokuFunctions obj=new SudokuFunctions();         
   SudokuSolver solver=new SudokuSolver();
   PlaySudoku play=new PlaySudoku();
   System.out.println("\f\n\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*SUDOKU*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*\n");
   System.out.println("\t\t\t\t  Welcome to this project on Sudoku.\n This project enables you to solve sudokus as well as play the game. Just sit back and follow the instructions.\n");
   int n;
   do
    {System.out.println("What would you like to do?");
     n=SimpleInput.askInt(" Enter '1' to Play Sudoku Game \n Enter '2' to Use Sudoku Solver \n Enter '3' to See Rules \n Enter '4' to See Example \n Enter '5' to Quit \n Please enter your choice: ");
     switch(n)
      {case 1:  play.userPlay();           //call to PlaySudoku
                break;
       case 2:  solver.program();    //method call to SudokuSolver
                break;
       case 3:  System.out.println("\f\n*******************************************Rules********************************************************\n ");
                System.out.println("   - Sudoku is played over a 9x9 grid, divided into 3x3 sub grids called regions.\n   - Each cell is indicated by its coordinates where capital letters(A-I) denotes row \n\t\tand small letters(a-i) indicate column. \n   - Sudoku begins with some of the grid cells already filled with numbers.\n   - The object of Sudoku is to fill the other empty cells with numbers between 1 and 9 \n\t(1 number only in each cell) according the following guidelines:\n\t 1. Number can appear only once on each row.\n\t 2. Number can appear only once on each column.\n\t 3. Number can appear only once on each region.\n   - A summary of this would be, that a number should appear only once on each row, column and region.\n\tThe more numbers that are removed, the harder the puzzle. ");
                break;
       case 4:  int [][]a=new int[9][9];
                System.out.println("\f\n******************************************Example*******************************************************\n ");
                System.out.println("For example, if the given sudoku is :");
                play.set(a);
                System.out.println("Then, solution is :");
                solver.solve(a);
                obj.show(a);
                break;
       case 5:  break;
       default: System.out.println("Entered value not present. Please enter again. ");
      }
     System.out.println("\n********************************************************************************************************\n");
    }while(n!=5);             //while the user does not want to quit
   System.out.println("\n\t\t\t\t   Thank you for playing. \n\t\t\t\t This project was made by: \n\t\t\t\t   NAME   : KUNAL KHANNA\n\t\t\t\t   CLASS  : 10 B \n\t\t\t\t   ROLL NO: 25 \n\t\t\t\t   SCHOOL : ST. JAMES' SCHOOL \n\t\t\t\t   SESSION: 2009-2010.");
   System.out.println("\n*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*");             
  }
}
    