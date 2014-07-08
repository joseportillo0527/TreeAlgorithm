/* Program Name:  Tree.java
 *Programmer: Jose Portillo
 *Purpose: Insert nodes, traverse, and displays the tree.
*/
package treeapp;
import java.util.Stack;

class Tree
   {
   private Node root;             // first node of tree

// -------------------------------------------------------------
   public Tree()                  // constructor
      {
       Node newParent = new Node ();
       newParent.iData = '+';
       root = newParent;    //Starts root with '+'
      }            // one node in tree
// -------------------------------------------------------------
   public void insert(char id)
      { 
        Node newParent = new Node();    // make new node for parent
        newParent.iData = '+';           // insert +
        Node newNode = new Node();      // makes new node for user input
        newNode.iData = id;             // insert char
        Node current = root;       // start at root
        Node parent;
        
      /*If else is used to try to balance the tree. If id < 'm' then 
       *insert at left side of tree. Else insert at right side.
       */
         if (id < 'm')                  
         {
            while(true)                // (exits internally)
            {
               parent = current;
               if(current != null)  // Continues until inside if is true
               {
                   current = current.leftChild;
                   if(current == null)  // if end of the line,
                    {                 // insert newParent & then newNode.
                        parent.leftChild = newParent;
                        parent.leftChild.rightChild = newNode;  //Insert parents right child.
                        return;
                    }               
               }  // end of if != null
           }    //end while
         } // end if go left
         else                               // insert on right
         {
            while(true)                    // (exits internally)
            {
               parent = current;
               if(current != null)      // Continues until inside if is true
               {
                   current = current.rightChild;
                   if(current == null)  // if end of the line
                    {                   // insert newParent & then newNode.
                        parent.rightChild = newParent;
                        parent.rightChild.leftChild = newNode;
                        return;
                    }
               }  // end of if != null
            } //end while
          }  // end else go right
      }  // end insert()
// -------------------------------------------------------------
   public void traverse(int traverseType)
      {
      switch(traverseType)
         {
         case 1: System.out.print("\nPreorder traversal: ");
                 preOrder(root);
                 break;
         case 2: System.out.print("\nInorder traversal:  ");
                 inOrder(root);
                 break;
         case 3: System.out.print("\nPostorder traversal: ");
                 postOrder(root);
                 break;
         }
      System.out.println();
      }
// -------------------------------------------------------------
   private void preOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         System.out.print(localRoot.iData + " ");
         preOrder(localRoot.leftChild);
         preOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void inOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         inOrder(localRoot.leftChild);
         System.out.print(localRoot.iData + " ");
         inOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void postOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         postOrder(localRoot.leftChild);
         postOrder(localRoot.rightChild);
         System.out.print(localRoot.iData + " ");
         }
      }
// -------------------------------------------------------------
   public void displayTree()
      {
      Stack globalStack = new Stack();
      globalStack.push(root);
      int nBlanks = 32;
      boolean isRowEmpty = false;
      System.out.println(
      "......................................................");
      while(isRowEmpty==false)
         {
         Stack localStack = new Stack();
         isRowEmpty = true;

         for(int j=0; j<nBlanks; j++)
            System.out.print(' ');

         while(globalStack.isEmpty()==false)
            {
            Node temp = (Node)globalStack.pop();
            if(temp != null)
               {
               System.out.print(temp.iData);
               localStack.push(temp.leftChild);
               localStack.push(temp.rightChild);

               if(temp.leftChild != null ||
                                   temp.rightChild != null)
                  isRowEmpty = false;
               }
            else
               {
               System.out.print("--");
               localStack.push(null);
               localStack.push(null);
               }
            for(int j=0; j<nBlanks*2-2; j++)
               System.out.print(' ');
            }  // end while globalStack not empty
         System.out.println();
         nBlanks /= 2;
         while(localStack.isEmpty()==false)
            globalStack.push( localStack.pop() );
         }  // end while isRowEmpty is false
      System.out.println(
      "......................................................");
      }  // end displayTree()
// -------------------------------------------------------------
   }  // end class Tree
