/**  Kangaroo class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Kangaroo extends Racer
{
	private int speed;
	private Random rand;
	private int count = 0;
	private boolean isMorphed = false;
	
   /** Default Constructor: calls Racer default constructor
   */
   public Kangaroo( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Kangaroo( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     setRandAndSpeed();
   }

   /** move:  calculates the new x position for the racer
   *   Kangaroo move characteristics: "Up and down momentum"
   *      increment x by 1 around half of the time, while also incrementing by another 2
   *      about a fourth of the time or another 1 a fourth of the time.
   *      also makes y move up or down by 3 every other time move is called to simulate a jump.
   */
   public void move( )
   {
	 ++count;
	 /*kangaroo will move up 3 on the second time move() is called, then alternate down and up every other time count
	 *is incremented
	  */
	 if (count % 4 == 0) {
		 setY(getY() - 3);
	 }
	 else if (count % 4 == 2){
		 setY(getY() + 3);
	 }
     int move =  rand.nextInt( 100 )  + 1;
     if ( move < speed ) {
    	 setX( getX( ) + 1 );
    	 //decides if another 2 or 1 should be added to the x value based on the value of move
    	 if (move < 40) {
    		 setX(getX() + 2);
    	 }
    	 else if (move < 20) {
    		 setX(getX() + 1);
    	 }
     }
   }

   /** draw: draws the Kangaroo at current (x, y) coordinate
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
	   int startX = getX( );
	     int startY = getY( );

	   //checks if the morph method has been ran and changes colors accordingly
	     if (isMorphed) {
		     g.setColor(Color.red);
		     //body
		     g.fillOval( startX - 15, startY - 2, 10, 17 );

		     g.setColor(Color.orange);
		     //head
		     g.fillOval( startX - 12, startY - 5,  7, 7 );

		     //flatten bottom
		     g.clearRect( startX - 30, startY + 11, 35, 4 );

		     g.setColor(Color.black);
		     //feet
		     g.fillOval( startX - 16, startY + 8,  5, 5 );
		     g.fillOval( startX - 9, startY + 8, 5, 5 );
		     
		     //hands
		     g.fillOval( startX - 14, startY + 1,  3, 3 );
		     g.fillOval( startX - 7, startY + 1, 3, 3 );
	     }
	     else {
	     g.setColor(Color.gray);
	     //body
	     g.fillOval( startX - 15, startY - 2, 10, 17 );

	     g.setColor(Color.DARK_GRAY);
	     //head
	     g.fillOval( startX - 12, startY - 5,  7, 7 );

	     //flatten bottom
	     g.clearRect( startX - 30, startY + 11, 35, 4 );

	     g.setColor(Color.black);
	     //feet
	     g.fillOval( startX - 16, startY + 8,  5, 5 );
	     g.fillOval( startX - 9, startY + 8, 5, 5 );
	     
	     //hands
	     g.fillOval( startX - 14, startY + 1,  3, 3 );
	     g.fillOval( startX - 7, startY + 1, 3, 3 );
	     }
   }
   
   private void setRandAndSpeed( ) {
      // percentage of time (between 40 -49%) that this K moves each turn
      rand = new Random( );
      speed = rand.nextInt( 10 ) + 40;
   }
   @Override
   public void morph(Graphics g) {
	 //morph changes occur in the draw method once boolean isMorphed is set to true
	   isMorphed = true;
	   this.draw(g);
   }
}