/** IntStack is a Stack of ints from Java.util.Stack.  It also has methods for
* isFull and sets a size and capacity in constructor.  It inherits all methods
* from Stack and Vector.  It also has an additional toString that prints out
* chessPositions for an eight size stack.
* @author Todd Fleming
*/
public class IntStack extends java.util.Stack<Integer>{
/*--Member-Variables----------------------------------------------------------*/
 private final static long serialVersionUID = 00001;
 
 /** The size limit for this stack.*/
 private int capacity;
/*--End-of-Member-Variables---------------------------------------------------*/
 
 
/*--Constructor---------------------------------------------------------------*/ 
public IntStack(int capacity)
{
  this.setSize(capacity());
  this.ensureCapacity(capacity); 
  this.capacity = capacity;
}/*--End-of-Constructor-------------------------------------------------------*/


 /*--Is-Full-Method-----------------------------------------------------------*/
 /** Determines if the stack is at full size or not.*/
 public boolean isFull()
 {
  return size() == capacity;
 }/*--End-of-Is-Full-Method---------------------------------------------------*/
 
 
 /*--To-String-Override-Method------------------------------------------------*/
 /** @return String: every Integer value in the stack with spaces between.*/
 public String toString()
 {
  String tempString = "";
  for (Integer o: this)
  {
   tempString += o.toString() + " ";
  }
  return tempString;
 }/*--End-of-To-String-Override-Method----------------------------------------*/
 
 
 /*--Chess-Positions-To-String-Method-----------------------------------------*/
 /** Converts integer values of row and index value columns to a-h, 1-8 
 * notation, flipping the index values 0-7 to 8-1.
 * @return String: all positions in the stack as chess notation positions with
 * spaces in between.
 */
 public String chessPositionsToString()
 {
  String tempString = "";
  String[] letters = new String[]{"a","b","c","d","e","f","g","h"};
  int i = 0;
  for (Integer o: this)
  {
   int tempRow = Math.abs(o - 8);
   tempString += letters[i] + tempRow + " ";
   i++;
  }
  return tempString;
 }/*--End-of-Chess-Positions-To-String-Method---------------------------------*/

 
 /*--Pop-All-Method-----------------------------------------------------------*/
 /** Removes all items from the stack.*/
 public void popAll()
 {
  while (!this.isEmpty())
   this.pop();
 }/*--End-of-Pop-All-Method---------------------------------------------------*/
 
 
}/*--End-of-Class-------------------------------------------------------------*/