import java.util.*;

class SudokuDriver{

   public static void main(String argv[]){
      Scanner input= new Scanner (System.in);
      Sudoku yasuo = new Sudoku();
      //named my sudoku "yasuo" because I can 
      boolean gameOver=false; 
     
      yasuo.instructions ();
     
      while (gameOver==false){
         yasuo.printBoard();

      
         yasuo.takeTurn ();
         yasuo.isFull();
      
         gameOver= yasuo.isWon();
     
         boolean dup = yasuo.duplicates();
         if (dup== true){ 
            gameOver=false;
            System.out.println("It looks like you have a duplicate");
      }  
      
      
      }//while
      
      
      if (gameOver=true){
      System.out.println("Congratulations, you have embraced the powers of Sudoku and become a winner so great you are... one.. with the wind.  *Whoosh!*");
      System.out.println ("(You won)");
   }
   }//main

   }//class