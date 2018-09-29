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

import java.util.ArrayList;

public class WallType extends ConstructionBlockType{
	
	public ArrayList<Point> walls;
	
	public WallType() {
		walls = new ArrayList<Point>();
		for(int j = -3; j <= 3; j++) {
			walls.add(new Point(-3, j));
		}	
		for(int j = -3; j <= 3; j++) {
			walls.add(new Point(j, -3));
		}
		for(int j = -3; j <= 3; j++) {
			walls.add(new Point(3,j));
		}
		for(int j = -3; j <= 3; j++) {
			walls.add(new Point(j,3));
		}
	}
	
	
	@Override
	public Point nextPositionForGoing(Actor anActor, Point aMovement) {
		Point aux = anActor.position();
		aux = aux.plus(aMovement);
		if(walls.contains(aux)) {
			return anActor.position();
		}
		else return aux;
	}

}
