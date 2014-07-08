/* Program Name:  TreeApp.java
* Programmer: Jose Portillo
*/
package treeapp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TreeApp {

   public static void main(String[] args) throws IOException
      {
      
      Scanner input = new Scanner (System.in);  
      String str;
      char[] alphaLetters;     // array of char
      int value;
    
      Tree theTree = new Tree();

      System.out.print("Enter the letters that you want to create " + 
              "the binary tree. Enter as abcdefg:  ");
      str = input.next();       // Gets user input
      alphaLetters = str.toCharArray(); // String characters to CharArray
    
      for(int i = 0; i < alphaLetters.length; i++)
      {
        theTree.insert(alphaLetters[i]);
      }

      while(true)
         {
         System.out.print("Enter the corresponding number for 1 show, " + 
                 "2 traverse or 3 Quit: ");
         int choice = getChar();
         switch(choice)
            {
            case '1':
               theTree.displayTree();
               break;
            case '2':
               System.out.print("Enter corresponding number 1 Preorder, 2 Inorder or 3 Postorder: ");
               value = getInt();
               theTree.traverse(value);
               break;
            case '3':
                System.exit(0);
            default:
               System.out.print("Invalid entry\n");
            }  // end switch
         }  // end while
      }  // end main()
// -------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
// -------------------------------------------------------------
   public static char getChar() throws IOException
      {
      String s = getString();
      return s.charAt(0);
      }
//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
// -------------------------------------------------------------
   }  // end class TreeApp
