/**  Python class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Python extends Racer
{
	private int speed;
	private Random rand;
	private boolean isMorphed = false;
		
   /** Default Constructor: calls Racer default constructor
   */
   public Python( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Python( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     setRandAndSpeed();
   }

   /** move:  calculates the new x position for the racer
   *   Python move characteristics: "Forward and back"
   *      increment x by 3 for most of time, but moves back 2 for the rest
   */
   public void move( )
   {
     int move =  rand.nextInt( 100 )  + 1;
     if ( move < speed )
       setX( getX( ) + 3 );
     //ensures that the racer does not move backwards from the start
     else if (getX() > 2) {
    	 setX(getX() - 2);
     }
   }

   /** draw: draws the Python at current (x, y) coordinate
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startX = getX( );
     int startY = getY( );
     
     g.setColor(Color.MAGENTA);
     
     //body segments
     g.fillOval( startX - 30, startY, 7, 11 );
     g.fillOval( startX - 25, startY, 7, 11);
     g.fillOval( startX - 20, startY, 7, 11 );
     g.fillOval( startX - 15, startY, 7, 11 );
     g.fillOval( startX - 10, startY, 7, 11 );
     g.fillOval( startX - 5, startY, 7, 11 );
     //head
     g.setColor(Color.PINK);
     g.fillOval( startX - 5, startY - 5,  10, 10 );

     //flatten bottom
      g.clearRect( startX - 30, startY + 11, 35, 4 );
      
    //checks if the morph method has been ran and adds a hat if morph has occurred
      if (isMorphed) {
     	 g.setColor(Color.black);
     	 g.fillRect(startX - 5, startY - 3, 12,2 );
     	 g.fillRect(startX - 3, startY - 7, 7,6 );
      }
   }
   
   private void setRandAndSpeed( ) {
      // percentage of time (between 60 - 69%) that this python moves forward each turn
      rand = new Random( );
      speed = rand.nextInt( 10 ) + 60;
   }
   @Override
   public void morph(Graphics g) {
	 //morph changes occur in the draw method once boolean isMorphed is set to true
	   isMorphed = true;
	   this.draw(g);
   }
}