package Hactoberfest2021.Java_DSA.BackTracking;
/*
The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
*/
//This is a standard Backtracking Problem
import java.util.Scanner;
public class Nqueens {
    static boolean make(int board[][])
    {
        int col=0;
        int n=board.length;
            if(utility(board,col,n)==false)
            return false;
            else
            return true;
    }
    static boolean issafe(int board[][],int row,int col,int n)
    {
        int i,j;
        for(i=0;i<col;i++)
        if(board[row][i]==1)//check the columns to the left in the same row
        return false;
        for(i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
        if(board[i][j]==1)//check the cells in the left up diagonal
        return false;
        for(i=row+1,j=col-1;i<n&&j>=0;i++,j--)
        if(board[i][j]==1)//check in the lower left diagonal
        return false;

        return true;
    }
    static boolean utility(int board[][],int col,int n)
    {
        if(col>=n)
        return true;
        for(int i=0;i<n;i++)//to iterate over the rows
        {
            if(issafe(board,i,col,n)==true)
            {
                /**First queen in column=1
                 * Second in 2
                 * Third in 3 ... and so on
                 */
                board[i][col]=1;//place the queen in the spot
                //and now recur to place next queen
                if(utility(board,col+1,n)==true)
                    return true;//if next queen was placed successfully return true
                //if the next queen cannot be placed then remove the current queen and
                //now try by keeping in next row
                board[i][col]=0;
            }
        }
        return false;//if no solution can be found, false is returned
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of N");
        int n=sc.nextInt();
        int board[][]=new int[n][n];
        for(int x[]: board)
        {
            for(int y: x)
            y=0;
        }
        sc.close();
        if(make(board)==false)//number of queens=4
        {
            System.out.println("No Solution Exists");
            return;
        }
        print(board);
    }
    static void print(int board[][])
    {
        //int n=board.length;
        for(int i[]:board)
        {
            for(int j:i)
            System.out.print(j+" ");
            System.out.println();
        }
    }
}
