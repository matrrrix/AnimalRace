/** Hare class
*   inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Hare extends Racer
{
	
	private boolean isMorphed = false;
   /** Default Constructor: calls Racer default constructor
   */
   public Hare( )
   {
     super( );
   }

   /** Constructor
   *    @param rID   racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Hare( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
   }

   /** move:  calculates the new x position for the racer
   *   Hare move characteristics:  30% of the time, Hare jumps 5 pixels
   *                               70% of the time, Hare sleeps (no move)
   *   generates random number between 1 & 10
   *          for 1 - 7,  no change to x position
   *          for 8 - 10, x position is incremented by 5
   */
   public void move( )
   {
      Random rand = new Random( );
     int move =  rand.nextInt( 10 ) + 1 ;

     if ( getX( ) < 100 )
     {
      if ( move > 7 )
       setX( getX( ) + 5 );
     }
     else
     {
      if ( move > 7 )
       setX( getX( ) + 5 );
     }
   }

   /** draw: draws the Hare at current (x, y) coordinate
   *   @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startY = getY( );
     int startX = getX( );

   //checks if the morph method has been ran and changes size accordingly
     if (isMorphed) {
         // tail
         g.setColor( Color.LIGHT_GRAY );
         g.fillOval( startX - 37, startY + 8,  17, 17 ) ;

         //body
         g.setColor( Color.GRAY );
         g.fillOval( startX - 30, startY,  25,  25 );

         //head
         g.fillOval( startX - 13, startY + 2, 18, 13 );
         g.fillOval( startX - 13, startY - 8, 14, 27 );

         //flatten bottom
         g.clearRect( startX - 37, startY + 15, 32, 5 );
     }
     else {	 
     // tail
     g.setColor( Color.LIGHT_GRAY );
     g.fillOval( startX - 37, startY + 8,  12, 12 ) ;

     //body
     g.setColor( Color.GRAY );
     g.fillOval( startX - 30, startY,  20,  20 );

     //head
     g.fillOval( startX - 13, startY + 2, 13, 8 );
     g.fillOval( startX - 13, startY - 8, 8, 28 );

     //flatten bottom
     g.clearRect( startX - 37, startY + 15, 32, 5 );
     }
   }
   @Override
   public void morph(Graphics g) {
	 //morph changes occur in the draw method once boolean isMorphed is set to true
	   isMorphed = true;
	   this.draw(g);
   }
}