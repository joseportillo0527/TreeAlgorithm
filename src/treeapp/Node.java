/* Program Name:  Nodes.java
 * Programmer: Jose Portillo, 0818702
 * Assignment Number: Project #1
 * Purpose: Used to create nodes.
*/

package treeapp;

class Node
   {
   public char iData;             // data item (key)
   public Node leftChild;         // this node's left child
   public Node rightChild;        // this node's right child

   public void displayNode()      // display ourself
      {
      System.out.print('{');
      System.out.print(iData);
      System.out.print("} ");
      }
   }  // end class Node
