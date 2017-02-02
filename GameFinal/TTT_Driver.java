import java.util.*; 


class TTT_Driver{
   public static void main(String argv[]){
      boolean gameOver = false;
      //String board[][] = initializeBoard();
     // String symbol = "O"; 
      TTT tttGame= new TTT ();
      tttGame.instructions();
      while(!gameOver){ // keep going while gameOver is false
         tttGame.takeTurn();
         gameOver = tttGame.isWinner() || tttGame.isFull(); 
         tttGame.printBoard(); 
      }
      if(tttGame.isWinner()) 
         System.out.println("Congratulations " + tttGame.getSymbol()); 
      else
         System.out.println("Tie!"); 
   }// main
}