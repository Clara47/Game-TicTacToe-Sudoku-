import java.text.*;
import java.util.*;

class Game_Driver{
   public static void main(String argv[]){
   Scanner input = new Scanner(System.in);
   Game g;
   String answer;
   
   System.out.println("Do you want to play Tick Tac Toe? If no, you'll play Sudoku instead.  (yes/no)");
    answer = input.nextLine();
    
    if (answer.equals("yes")){
      g = new TTT();
      
      }//if
      
    else{
    g = new Sudoku();
    }
      g.printBoard();

      boolean gameOver = false;
      while(!gameOver){ // keep going while gameOver is false
         // 3) takeTurn 
         g.takeTurn(); 
         // 4) print Board 
         g.printBoard(); 
         // 5) checks to see if game has ended with this turn 
         gameOver = g.isWon();  
      
}
    



   }//main
}// class