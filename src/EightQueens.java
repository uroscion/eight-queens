/** EightQueens contains the major methods to search for all queen solutions on 
* a given chessboard size.  It contains an IntStack queenStack that is set to 
* a size of 8 by 8 in the constructor.
* @author Todd Fleming
*/
public class EightQueens{
/*--Member-Variables----------------------------------------------------------*/
 /** The stack that contains values for queen positions.*/
 private IntStack queenStack;
/*--End-of-Member-Variables---------------------------------------------------*/

 
/*--Constructor---------------------------------------------------------------*/
 EightQueens()
 {
  queenStack = new IntStack(8);
}/*--End-of-Constructor-------------------------------------------------------*/

 
 /*--Is-Position-Safe-Method--------------------------------------------------*/
 /** Checks to see if a position passed in is safe (ie: is not attacked by any
 * other queens on the board (values in the stack).
 * @param checkRow: the int position to check.
 * @return boolean, true if safe, false if not.
 */
 private boolean isSafe(int checkRow)
 {
  //For every value in the stack..
  for (Integer e: queenStack)
  {
   //Check to see if the position to check is in the same row (same value as
   //any other position in the stack.
   if (e == checkRow) return false; 
   //Check to see if the position is diagonal (only need to worry about posit.
   //to the right on the board) to any other position in the stack.
   else if (queenStack.indexOf(e) + e == queenStack.size() + checkRow) 
    return false;
   else if (queenStack.indexOf(e) - e == queenStack.size() - checkRow) 
    return false;
  }
  return true;
 }/*--End-of-Is-Safe-Method---------------------------------------------------*/


 /*--Find-Safe-Position-Method------------------------------------------------*/
 /** Finds the next safe position in the column to check, starting at the last
 * try's position plus 1.
 * @return the safe position int.
 */
 private int findSafe(int latestTry) // find a new safe position
 {
  for (int i = latestTry; i <= 7; i++)
  {
  // System.out.print("position: " + i);
   if (isSafe(i)) return i;
  }
  return -1; // no solution
 }/*--End-of-Find-Safe-Method-------------------------------------------------*/

 /*--Search-Queens-Method-----------------------------------------------------*/
 /** Finds all possible solutions for the queens problem of the size given by 
 * the stack using backtracking.  Prints out all solutions and the total
 * solutions.
 */
 public void search_queens()
 {
  queenStack.popAll();//Empty the stack
  queenStack.push(0);//Push zero as the first row position to start with.
  int nextTryStart = 0;//now the next try to start on is zero too.
  int atry;//Create a holder to hold the current try.
  int count = 0; //A counter for the number of solutions
  while (true)
  {
   //If the stack isn't full..
   if (!queenStack.isFull())
   {
          //try to find a safe position in the next column.
          atry = findSafe(nextTryStart);
          //If one is found, then push that on the stack and keep searching.
          if (atry >= 0)  
          {  
           queenStack.push(atry);
           nextTryStart = 0;
          }
          //If not, then backtrack.
          else
          { 
            //If the stack is empty, break, we're done and backtracked to end.
            if (queenStack.isEmpty()) break;
            //If not, then just backtrack by popping the last try off the stack.
            nextTryStart = queenStack.pop()+1;
          }
   }/*--End-of-If--*/
   else //queenStack is full and a solution is found, print out the solution.
   {
    System.out.println(queenStack.toString());//print the solution as stack
    System.out.println(queenStack.chessPositionsToString());//print in chess not
    count++;//increment the number of solutions.
    nextTryStart = queenStack.pop() + 1;//pop off and keep going.
   }
  }/*--End-of-While--*/
  System.out.println("total:" + count);//print out the total solutions count.
 }/*--End-of-Search-Queens-Method---------------------------------------------*/

 
}/*--End-of-Class-------------------------------------------------------------*/