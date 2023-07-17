package Battleship;
  import java.util.Scanner;
  import java.util.Random;
public class ChickenNuggets {
  




 public static Scanner target = new Scanner(System.in);
 public static int xInput;
 public static int yInput;
 
 public static void main(String[] args) {

   int[][] board = new int[10][10];
   
   //fill new board with 1, water
   for(int i = 0; i<10; i++){
     // i rows 1 to 10
     for(int j = 0; j<10; j++){
       // j columns 1 to 10
       board[i][j] = 1; 
       //1 is assigned for ~ (untouched)
     }//end for
   }//end for
   
   //System.out.println(Arrays.deepToString(board));
   printBoard(board); //print board

   
   //loop that calls placement method with lenghts 2,3,4,5 and then print board
   placement(2, board);
   placement(3, board);
   placement(4, board);
   placement(5, board);
   numberPrint(board);
   

   //let user fire shots
   board = fireFunction(board);
 
 }//end public static void main

 //Below are the methods
//}//end class main
 public static void printBoard(int[][] board){
 // logic for printing a board
   for(int r = 0; r<10; r++){
   int F = 9 - r;
     System.out.print( F +" | ");
   
     for(int p = 0; p<10; p++){
 
       if(board[r][p] == 1 | board[r][p] == 2){
         
         System.out.print(" ~ "); 
         //print water
       }
       else if(board[r][p] == -1){
         
         System.out.print(" * "); 
         // print hit
       }
       else{
     
       System.out.print(" O "); 
       // print miss
       }
     }
     System.out.print(" | \n");
   }//forloop printing
   System.out.println("_ -  0  1  2  3  4  5  6  7  8  9");
 }//end print method

/*
public static int[][] placeShips(int[][] board){ 
  //old single ship placement method
   for( int g = 0; g < 9; g++){
     int y = getRandomNumberInRange(0,9);
     int x = getRandomNumberInRange(0,9);
     board[x][y] = 2;
   }
 return board; 
 }//end Placing ships method
 */

 private static int getRandomNumberInRange(int min, int max) { 
   System.out.println("Getting Random int");
   if (min >= max) {
     throw new IllegalArgumentException("max must be greater than min");
   }
   Random r = new Random();
   return r.nextInt((max - min) + 1) + min;
 }// end getRandomInt method


public static int[][] fireFunction(int[][] board){
  int boardCheck;
  int boardCheck2;
  int hitCount = 0;
  for(boardCheck = 0; boardCheck < 10; boardCheck++){
    
   for(boardCheck2 = 0; boardCheck2 < 10; boardCheck2++){ //double for loop to go through entire board and see if any ships left

       if( board[boardCheck][boardCheck2] == 2){
       
         for(int g = 4; g > -1; g--){

          // Might want to use a try catch to handle errors from nextInt() like if someone uses anything other than a number.
          //Heres a link https://www.w3schools.com/java/java_try_catch.asp.
           System.out.println("Select an X coordinate");
           xInput = target.nextInt();
           System.out.println("Now select a Y coordinate");
           yInput = target.nextInt();
           //printBoard(board);
           
           
           if(board[9-yInput][xInput] == 2){
             //if hit              
             System.out.println("You shot at (" + xInput + "," + yInput + ") and hit!");
             board[9-yInput][xInput] = -1;
             printBoard(board);
             hitCount++;
             if(hitCount == 14){
              System.out.println("You shot all the ships! Good job winner!");
               return board;
             }
             //double for loop to print integer board array
                        
             for(int i = 0; i<10; i++){
               System.out.print( 9-i + " [ ");
               for(int j = 0; j<10; j++){
               
                 System.out.print(" " + board[i][j] + " ");       
       
                }//end for 
             System.out.print(" ]\n");
             }//end for
             
             System.out.println("You now have " + (g) + " shots left.");
             
           }//end if

           else if(board[9-yInput][xInput] == 1){
             //if miss
             
             System.out.println("You shot at (" + xInput + "," + yInput + ") and missed...");
             board[9-yInput][xInput] = 0;
             printBoard(board);
             for(int i = 0; i<10; i++){
               System.out.print( 9-i + " [ ");
               for(int j = 0; j<10; j++){
      
             System.out.print(" " + board[i][j] + " ");       
       
                }//end for
             System.out.print(" ]\n");
             }//end for
             
             System.out.println("You now have " + (g) + " shots left.");
             
           }//end else if

           else{
             System.out.println("Invalid target: That spot has either been shot already or you have put in an invalid coordinate");
           }//end else 

         }//end for
         System.out.println("Youve hit all the ships in 'hitCount' shots");
         return board;
       }//end if

     }//end for
     
   }//end for
   
 
 return board;
 }//end fire function method

 //randomposition
 
 public static void placement(int length, int[][]board){
   int x = 0;
   int y = 0;
   int direction = getRandomNumberInRange(1,2);//chose direction
   
   if( direction == 2){
     //horizontal
     if(length == 2){
       //ship size 2 
       x = getRandomNumberInRange(0,8);
       y = getRandomNumberInRange(0,9);
     }
     else if(length == 3){
       //ship size 3
       x = getRandomNumberInRange(1,8);
       y = getRandomNumberInRange(0,9);
     }
     else if(length == 4){
       //ship size 4
       x = getRandomNumberInRange(0,6);
       y = getRandomNumberInRange(0,9);
     }
     else if(length == 5){
       //ship size 5
       x = getRandomNumberInRange(2,7);
       y = getRandomNumberInRange(0,9);
     }
   }
   else if(direction == 1){
   //vertical
     if(length == 2){
       //ship size 2 
       x = getRandomNumberInRange(0,9);
       y = getRandomNumberInRange(1,9);
     }
     else if(length == 3){
       //ship size 3
       x = getRandomNumberInRange(0,9);
       y = getRandomNumberInRange(1,8);
     }
     else if(length == 4){
       //ship size 4
       x = getRandomNumberInRange(0,9);
       y = getRandomNumberInRange(3,9);
     }
     else if(length == 5){
       //ship size 5
       x = getRandomNumberInRange(0,9);
       y = getRandomNumberInRange(2,7);
     }
   }
     int[] A = {x,y};
     System.out.println("The coordinates of the head for length " + length + ": "+ "(" + A[0] + "," + A[1] +")");
     //call on checkers method 
     checkers(A, length, direction, board);
     

     

   } //end placement method

   public static int[] reRoll(int length){
   int x = 0;
   int y = 0;
   int direction = getRandomNumberInRange(1,2);//chose direction
   int[] xy_array_reroll;
   xy_array_reroll = new int[2];

   if( direction == 2){
     //horizontal
      if(length == 2){
       //ship size 2 
       x = getRandomNumberInRange(0,8);
       y = getRandomNumberInRange(0,9);
     }
     else if(length == 3){
       //ship size 3
       x = getRandomNumberInRange(1,8);
       y = getRandomNumberInRange(0,9);
     }
     else if(length == 4){
       //ship size 4
       x = getRandomNumberInRange(0,6);
       y = getRandomNumberInRange(0,9);
     }
     else if(length == 5){
       //ship size 5
       x = getRandomNumberInRange(2,7);
       y = getRandomNumberInRange(0,9);
     }
    }
      else if(direction == 1){
   //vertical
     if(length == 2){
       //ship size 2 
       x = getRandomNumberInRange(0,9);
       y = getRandomNumberInRange(1,9);
     }
     else if(length == 3){
       //ship size 3
       x = getRandomNumberInRange(0,9);
       y = getRandomNumberInRange(1,8);
     }
     else if(length == 4){
       //ship size 4
       x = getRandomNumberInRange(0,9);
       y = getRandomNumberInRange(3,9);
     }
     else if(length == 5){
       //ship size 5
       x = getRandomNumberInRange(0,9);
       y = getRandomNumberInRange(2,7);
     }
   }
   xy_array_reroll[0] = x;
   xy_array_reroll[1] = y;
 
   return xy_array_reroll;
 }
   public static void checkers(int[] A, int length, int direction, int[][] board){
     //checking if valid placement
     
     //direction 2 horizontal, 1 vertical
     int x = A[0];
     int y = A[1];
     boolean placed = false;
   
     if(length == 5){
       while(placed == false){
         

         if(direction == 2){
           System.out.println("horizontal");
           if(board [9-y][x] != 2 && board[9-y][x+1] != 2 && board[9-y][x+2] != 2 && board[9-y][x-1] != 2 && board[9-y][x-2] != 2){
             for(int o = -2; o < 3; o++){
               board[9-y][x+o] = 2;
             }
             placed = true;
           }
           else{
             System.out.println("Rerolling position...");
             int[] x_y_New = reRoll(length);
             x = x_y_New[0];
             y = x_y_New[1];

           }
         
         }
       
         else if(direction == 1){
             System.out.println("vertical");
           if(board [9-y][x] != 2 && board[8-y][x] != 2 && board[7-y][x] != 2 && board[10-y][x] != 2 && board[11-y][x] != 2){
             for(int o = -2; o < 3; o++){
               board[9-y+o][x] = 2;
             }
           placed = true;
           }
           else{
             System.out.println("Rerolling position...");
             int[] x_y_New = reRoll(length);
             x = x_y_New[0];
             y = x_y_New[1];

             
           }
       }
       else{
           System.out.println("Failed at length: " + length + "direction: " + direction );
       //reRoll(length);
       }
     } 
   }      
       
       
    // }
     
     else if(length == 4){
       placed = false;
        while(placed == false){
         if(direction == 2){
           System.out.println("horizontal");
           if(board [9-y][x] != 2 && board[9-y][x+1] != 2 && board[9-y][x+2] != 2 && board[9-y][x+3] != 2){
             for(int o = 0; o < 4; o++){
               board[9-y][x+o] = 2;
             }
             placed = true;
             }
           else{
             System.out.println("Rerolling position...");
             int[] x_y_New = reRoll(length);
             x = x_y_New[0];
             y = x_y_New[1];

           }
         }
     
       
         else if(direction == 1){
             System.out.println("vertical");
           if(board [9-y][x] != 2 && board[8-y][x] != 2 && board[7-y][x] != 2 && board[6-y][x] != 2){
             for(int o = 0; o < 4; o++){
               board[9-y+o][x] = 2;
             }
             placed = true;
             }
             else{
               System.out.println("Rerolling position...");
               int[] x_y_New = reRoll(length);
               x = x_y_New[0];
               y = x_y_New[1];

             
           }
         } //end if
        }
       }//end else if of length=4
     else if(length == 3){
         placed = false;
         while(placed == false){
           if(direction == 2){
             System.out.println("horizontal");
             if(board [9-y][x] != 2 && board[9-y][x+1] != 2 && board[9-y][x-1] !=2){
               for(int o = -1; o < 2; o++){
                 board[9-y][x+o] = 2;
               }
             placed = true;
             }
             else{
               System.out.println("Rerolling position...");
               int[] x_y_New = reRoll(length);
               x = x_y_New[0];
               y = x_y_New[1];

             }
             }
             
           
         
           else if(direction == 1){
               System.out.println("vertical");
             if(board [9-y][x] != 2 && board[8-y][x] != 2 && board[10-y][x] !=2){
               for(int o = -1; o < 2; o++){
                 
                 board[9-y+o][x] = 2;
               }
             placed = true;
             }
             else{
               System.out.println("Rerolling position...");
               int[] x_y_New = reRoll(length);
               x = x_y_New[0];
               y = x_y_New[1];

             }  
           }
     
        } 
     }//end if
     else if(length == 2){
         placed = false;
         while(placed = false){
           
           if(direction == 2){
             System.out.println("horizontal");
             if(board [9-y][x] != 2 && board[9-y][x+1] != 2){
               for(int o = 0; o < 2; o++){
                 board[9-y][x+o] = 2;
               }
             placed = true;
             }
             else{
               System.out.println("Rerolling position...");
               int[] x_y_New = reRoll(length);
               x = x_y_New[0];
               y = x_y_New[1];

             }  
           }
         
           else if(direction == 1){
               System.out.println("vertical");
             if(board [9-y][x] != 2 && board[10-y][x] != 2){
               for(int o = 0; o < 2; o++){
                 board[9-y+o][x] = 2;
               }
             placed = true;
             }
             else{
               System.out.println("Rerolling position...");
               int[] x_y_New = reRoll(length);
               x = x_y_New[0];
               y = x_y_New[1];

             }  
           }
         }
     } //end if

   }// end checker method
   
 public static void numberPrint(int[][] board){
   //method to print the number arrays board
   for(int i = 0; i<10; i++){
    System.out.print( 9-i + " [ ");
     for(int j = 0; j<10; j++){
       System.out.print(" " + board[i][j] + " ");
     }//end for
     System.out.print(" ]\n");
   }//end for
 }//End numberPrint method


//***************** END OF PROGRAM ***************
}//end of Main class



// 8/6 - Get reroll to work, call on it in checkers and make sure all ships are placing.

//More Notes
//~ = water. # = Shot fired/miss. * = hit on ship.
//-1 = shot and hit, 0 = shot but no hit, 1 = not shot/ untouched water, 2=ship unhit
//methods needed: Initialize board, show board, Initialize ships, shoot(limited shots), check hit, miss, hit, board update, shot counter, check for win or loss.



//notes for ship placing: Odd number length ships. The 1x1s are the easiest to place, just give it a random coordinate. 3x3s would half to have 2 different versions, one horizontal and one verticle. Each is limited in their either x or y values so that it stays within the grid. Same for 5x5, but limited by 2. Also print out ship locations for testing. 

