/*
 * solve N queen using backtracking. 
 * @solveNQUtil() <- a helper function that returns false 
 * if queens cannot be placed, else returns true and prints the placement o fqueen 
 */
public class nQueen {
 public boolean solveNQ() {
    int board[][] = { {0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};//chess is a 2D array

    if(solveNQUtil(board, 0) == false) {
        System.out.print("Solution does not exist");
        return false;
    }

    printSolution(board);
    return true;
 }

 //@solveNQUtil() <- helps solve the N queen problem
 boolean solveNQUtil(int board[][], int col) {
    if(col >= N) return true; //queen placement available

    //consider one column and try placing the n++ queen in all rows one by one 
    for(int i = 0; i< N ;i++) {
        if(isSafe(board, i, col)) {
            board[i][col] = 1;

            if(solveNQUtil(board, col + 1) == true) return true;

            board[i][col] = 0;//the backtracking
            /*This ensures that if there's no solution further to the row placemnet, the backtraking make sure
             that the uqeen placemnet is removed form the veyr col position */

        }
    }
    return false; //if the queen cannot be placed in any row in the given col, return fasle
  }

  /*@isSagfe checeks if a queen can be placed on the baord [row][col].
   * Queens are already placed in teh column - to col -1
  */
  public boolean isSafe(int board[][], int row, int col) {
    int i, j;
  }

}