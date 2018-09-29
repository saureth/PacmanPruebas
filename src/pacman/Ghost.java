/*
 * Developed by 10Pines SRL
 * License: 
 * This work is licensed under the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License. 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/ 
 * or send a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, 
 * California, 94041, USA.
 *  
 */
package pacman;

public class Ghost extends Actor {

	public Point myPosition;
	
	public Ghost() {
		this.myPosition = new Point(0,0);
	}
	
	public Ghost(int pX, int pY) {
		this.myPosition = new Point(pX,pY);
	}
	
	@Override
	public Point position() {		
		return myPosition;
	}

}
