public class SudokuFunctions        //important functions stored here
{public void singleInput(int [][]a,char ch)  //takes single cell input 
  {String s="";
   int i=0,j=0,num=0;
   do
    {s=SimpleInput.askString("\nEnter Cell number followed by the number in the cell.(For example to enter 9 in the top left box, enter Aa9) \n Your input: ");
     s=s.trim();
     if(s.length()!=3)
       {System.out.print("Insufficient input. Please enter again.");
        continue;                                   //ask again
       }
     i=s.charAt(0)-65;                              //ASCII of 'A' is 65
     j=s.charAt(1)-97;                              //ASCII of 'a' is 97
     num=s.charAt(2)-48;                            //ASCII of '0' is 48
     if(i<0 || i>8 || j<0 || j>8 || a[i][j]!=0 || num<0 || num>9 || (ch=='y' && isValid(a,i,j,num)==false))
            System.out.println("Invalid input. Please enter again.");
    }while(s.length()!=3 || i<0 || i>8 || j<0 || j>8 || a[i][j]!=0 || num<0 ||num>9 || (ch=='y'&& isValid(a,i,j,num)==false));
   a[i][j]=num;                 //if value is valid, it stores it.
  } 
  
 public void show(int[][] a)          // prints the sudoku
  {int i,j;
   char chu='A';
   System.out.println("\n\t\t\t\t\t    a b c   d e f   g h i   "); //columns
   for(i=0;i<9;i++,chu++)
    {if(i%3==0)
        System.out.println("\t\t\t\t\t  -------------------------");  
     System.out.print("\t\t\t\t\t"+chu+" ");                        //rows
     for(j=0;j<9;j++)
       {if(j%3==0)
           System.out.print("| ");
        System.out.print((a[i][j]==0?"  ":a[i][j]+" "));   //ternary output
       }
     System.out.println("|");
    }
   System.out.println("\t\t\t\t\t  -------------------------");
   }  
   
 public boolean isValid(int[][] a,int r,int c,int num)    //checks validity
  {int i,j,gRow=r-r%3,gCol=c-c%3;
   for(i=0;i<9;i++)                      // row and column repitition check
     {if((num==a[i][c] && num!=0) || (num==a[r][i] && num!=0))
            return false;
     }
  for(i=gRow;i<gRow+3;i++)               // grid repititions
     {for(j=gCol;j<gCol+3;j++)
        {if(num==a[i][j] && num!=0)
            return false;
        }
     }
   return true;                            // no violations
  }
  
 public boolean isPossible(int[][] a,int r,int c,int num) //is cell possible
  {int i,j,gRow=r-r%3,gCol=c-c%3;                 //returns true only if the
   boolean flag=true;                             // value appears once in a
   for(i=0;i<9;i++)                               // row,grid or column
     {if(num==a[i][c] && num!=0 && i!=r)  //column check
           flag=false;
     }
   if(flag==true)
     return true;
   flag=true;
   for(j=0;j<9;j++)                       // row check
     {if(num==a[r][j] && num!=0 && j!=c)
         flag=false;
     }
   if(flag==true)
     return true;
   flag=true;
  for(i=gRow;i<gRow+3;i++)                // grid check
     {for(j=gCol;j<gCol+3;j++)
        {if(num==a[i][j] && num!=0 && (i!=r || j!=c))
             flag=false;
        }
     }
   if(flag==true)
     return true;
   return false; 
  }
  
 public void removeDuplicates(int [][]a,int [][]b,int r,int c) //remove nos.
  {int i,j,rg=r-r%3,cg=c-c%3; 
   for(i=0;i<9;i++)                       //removing from cell and row
    {if(a[r][i]!=b[r][i] && i!=c)
      b[r][i]=0;
     if(a[i][c]!=b[i][c] && i!=r)
      b[i][c]=0;
    }
   for(i=rg;i<rg+3;i++)                   //removing from grid
     {for(j=cg;j<cg+3;j++)
       {if(a[i][j]!=b[i][j] && (i!=r || j!=c))
         b[i][j]=0;
       }
     } 
  }
  
 public int fillSingleCells(int [][]a)   //normal scan to fill empty cells
  {int r,c,i,j,n=0,pass=0,num=0;
   for(r=0;r<9;r++)
    {for(c=0;c<9;c++)                    //check's each cell
      {if(a[r][c]==0)
         {int[]d=new int[10];            
          n=0;
          for(i=0;i<9;i++)      //values already appearing in row & column
            {d[a[i][c]]++;
             d[a[r][i]]++;
            }
          for(i=r-r%3;i<r-r%3+3;i++)   //grid's values
           {for(j=c-c%3;j<c-c%3+3;j++)
             {d[a[i][j]]++;
             }
           }
          for(i=1;i<=9;i++)            //which no's are missing
           {if(d[i]==0)
              {n++;
               num=i;
              }
           }
         if(n==1)                    //if only one possible
            {a[r][c]=num;              //then fill it with
             pass++;                   //the value left
            }
         }
      }
    }
   return pass;                 //returns the no. of cells filled
  }
  
 public boolean isDone(int [][]a)   //checks if all cells filled
  {int i,j;
   for(i=0;i<9;i++)
    {for(j=0;j<9;j++)
        {if(a[i][j]==0)                   //if any cell empty,
            return false;                      //returns false
        }
    }
   return true;                        //if all filled
  }
}