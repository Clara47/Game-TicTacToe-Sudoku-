import java.util.*; 
import java.io.*;
// take out all statics
// delete inputs (keep them anywhere? *keeping in valid input and duplicate funcs) 

class Sudoku extends Game{
     private boolean gameOver ;
     private int board[][] = initializeBoard();    
     private int bSoln[][]=solution();
     int number;


    int [][] solution(){
       int [][] bSoln= { { 9,8,1,2,5,7,3,4,6},
				{5,6,2,9,3,4,1,8,7},
				{7,3,4,1,6,8,2,5,9},     
				{3,2,5,8,7,9,4,6,1},
				{4,7,6,3,1,5,9,2,8},
				{1,9,8,4,2,6,5,7,3},
				{6,4,9,5,8,3,7,1,2},
				{2,5,7,6,9,1,8,3,4},
				{8,1,3,7,4,2,6,9,5}};
            return (bSoln);
            }//boardSoln end
 

    int [][] initializeBoard(){
      int [] [] board = { { -1,-1,-1, 2,-1,-1, -1, 4,6},
         {5,6,2, -1,-1,-1, -1,8, -1},
         {7,-1,-1, -1,-1,-1, -1,5,-1},      
         {3,-1,-1, -1,-1,9, -1,6,1}, 
         {-1,7,-1, 3,-1,5, -1,2,-1}, 
         {1,9,-1, 4,-1,-1, -1,-1,3}, 
         {-1,4,-1, -1,-1,-1, -1,-1,2}, 
         {-1,5,-1, -1,-1,-1, 8,3,4}, 
         {8,1,-1, -1,-1,2, -1,-1,-1}};    
      //stub: returns an almost-finished board   

      return (board); 
   }//IB Func end

     void printBoard() {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
                System.out.println("-----------------------");
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(board[i][j] == -1
                                 ? " "
                                 : Integer.toString(board[i][j]));

                System.out.print(' ');
            }
            System.out.println("|");
            
        }
        System.out.println("-----------------------");
    }
         
         
      void takeTurn (){
      Scanner input = new Scanner(System.in);
      System.out.println("Enter which number 1-9 that you want to place");
      int number =input.nextInt();
      
      System.out.println("What row would you like?"); //gets row from player
      int row = input.nextInt();
      System.out.println("What column would you like?"); //gets column
      int col = input.nextInt();
         
      boolean valid = validInput (row, col, number, board);//separate function, checks validity
          
      while (valid=false){//This prompts a new entry if input is invalid
         System.out.println("Invalid Input: Please pick a better entry.");
         System.out.println("Enter which number 1-9 that you want to place");
         number =input.nextInt();
         System.out.println("What row would you like?"); //gets row from player
         row = input.nextInt();
         System.out.println("What column would you like?"); //gets column
         col = input.nextInt();
         valid = validInput (row, col, number,board);//re-checks
      }//end while loop
      board[row][col]= number; //this adds the number to the space
      //return(board);//returns board to main  
   }//end Take Turn
      
     
   boolean isFull(){       
      int target= -1;
      boolean full = true; 
      for(int row=0; row<9; row++){
         for(int col=0; col<9; col++){
            if(board[row][col]==(target)){
               full=false;}
         }//for c
      }//for r
      return(full);          
   }//end isFull
      
   boolean validInput(int row, int col, int number, int [][] board){
   //aks about r and c first
      if (row<0 || row>=9){
         System.out.println("That's not a good space.");
         return(false);
         }//if r
      if (col<0 || col>=9){
         System.out.println("That's really not a good space.");
         return(false);
      }//if c
      if (number<=0 || number>=10){
         System.out.println("Your number input is invalid.");
         return(false);
         }//if n
      else{
         return (true);
        
      }//else
   }//validInput
   
   boolean isWon(){ 
      for (int row=0; row< 9; row++){
         for (int col=0;col<9;col++){
         if (board[row][col]!=bSoln[row][col]){
            gameOver=false;
            }//if
          else{
            gameOver=true;
            }//else
         }//r
         }//c
      return(gameOver); 
   }//isWon
   
 boolean duplicates(){
        // checking for rows
        int [] temp = new int [board.length];
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[i].length; j++){
                if (board[i][j] != -1)
                    temp[board[i][j]-1]++;
            }
            for (int j = 0 ; j < board[i].length; j++){
                if (temp[j] > 1)
                    return true;
            }//for

            for (int j = 0 ; j < board[i].length; j++){
                temp[j] = 0;
            }
        }//rowsEnd

        for (int j = 0 ; j < board[0].length ; j++){
            for (int i = 0 ; i < board.length; i++){
                if (board[i][j] != -1)
                    temp[board[i][j]-1]++;
            }

            for (int i = 0 ; i < board.length; i++){
                if (temp[i] >  1)
                    return true;
            }

            for (int i = 0 ; i < board.length; i++){
                temp[i] = 0;
            }

        }//colsEnd
        for (int i = 0 ; i < 3 ; i++){//start of the 3x3 grid checking for dups
            for (int j = 0; j < 3 ; j++){
                for (int k = (i*3) ; k < (i*3) + 3 ; k++){
                    for (int l = (j*3); l < (j*3) + 3; l++){
                        if (board[k][l] != -1)
                            temp[board[k][l]-1]++; 
                    }
                }

                for (int k = 0; k < 9; k++){
                    if (temp[k] > 1)
                        return true;
                }

                for (int k = 0; k < 9 ; k++){
                    temp[k] = 0;
                }

            }
        }
        return false;
    }//3x3end
    
   String instructions (){
   String s = "Sudoku\n"
         + "Rules:\n"
         + "\n"
         + "Enter numbers 1-9, so that you complete rows, columns, and grids of the numbers 1-9\n"
         + "without two of the same number being in one row, column or grid.";
   System.out.println(s);
   return (s);
   }
  
         
         
}//classEnd