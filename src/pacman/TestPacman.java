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

import junit.framework.TestCase;

public class TestPacman extends TestCase {

	//NO SE PUEDE CAMBIAR EL TIPO DE LAS VARIABLES
	//SI SE PUEDEN CREAR CLASES ESPECIALES PARA CADA
	//ACTOR O CONSTRUCTIONBLOCKTYPE
	protected Actor pacman;
	protected Actor blueGhost;
	protected ConstructionBlockType wallType;
	protected ConstructionBlockType spaceType;
	protected ConstructionBlockType leftTransporterType;
	protected ConstructionBlockType ghostHouseDoorType;
	
	protected Point left;
	protected Point right;
	protected Point up;
	protected Point down;
	
	public void setUp() {
		left = new Point(-1,0);
		right = new Point (1,0);
		up = new Point(0,1);
		down = new Point(0,-1);		
		blueGhost = new Ghost(2,2);
		wallType = new WallType();
	}
	
	public void testGhostCanNotGoIntoAWall(){
		assertEquals(
				blueGhost.position(),
				wallType.nextPositionForGoing(blueGhost,left));

		assertEquals(
				blueGhost.position(),
				wallType.nextPositionForGoing(blueGhost,right));
		
		assertEquals(
				blueGhost.position(),
				wallType.nextPositionForGoing(blueGhost,up));
		
		assertEquals(
				blueGhost.position(),
				wallType.nextPositionForGoing(blueGhost,down));
	}

	public void testPacmanCanNotGoIntoAWall(){
		assertEquals(
				pacman.position(),
				wallType.nextPositionForGoing(pacman,left));

		assertEquals(
				pacman.position(),
				wallType.nextPositionForGoing(pacman,right));
		
		assertEquals(
				pacman.position(),
				wallType.nextPositionForGoing(pacman,up));
		
		assertEquals(
				pacman.position(),
				wallType.nextPositionForGoing(pacman,down));
	}

	public void testPacmanMovesIntoSpacesVeryFast(){
		assertEquals(
				pacman.position().plus(new Point(-2,0)),
				spaceType.nextPositionForGoing(pacman,left));

		assertEquals(
				pacman.position().plus(new Point(2,0)),
				spaceType.nextPositionForGoing(pacman,right));
		
		assertEquals(
				pacman.position().plus(new Point(0,2)),
				spaceType.nextPositionForGoing(pacman,up));
		
		assertEquals(
				pacman.position().plus(new Point(0,-2)),
				spaceType.nextPositionForGoing(pacman,down));

	}

	public void testGhostMovesIntoSpacesSlowly(){
		assertEquals(
				blueGhost.position().plus(new Point(-1,0)),
				spaceType.nextPositionForGoing(blueGhost,left));

		assertEquals(
				blueGhost.position().plus(new Point(1,0)),
				spaceType.nextPositionForGoing(blueGhost,right));
		
		assertEquals(
				blueGhost.position().plus(new Point(0,1)),
				spaceType.nextPositionForGoing(blueGhost,up));
		
		assertEquals(
				blueGhost.position().plus(new Point(0,-1)),
				spaceType.nextPositionForGoing(blueGhost,down));
	}

	public void testGhostCanEnterHisHouse(){
		assertEquals(
				blueGhost.position().plus(new Point(-1,0)),
				ghostHouseDoorType.nextPositionForGoing(blueGhost,left));

		assertEquals(
				blueGhost.position().plus(new Point(1,0)),
				ghostHouseDoorType.nextPositionForGoing(blueGhost,right));
		
		assertEquals(
				blueGhost.position().plus(new Point(0,1)),
				ghostHouseDoorType.nextPositionForGoing(blueGhost,up));
		
		assertEquals(
				blueGhost.position().plus(new Point(0,-1)),
				ghostHouseDoorType.nextPositionForGoing(blueGhost,down));
	}

	public void testPacmanCanNotEnterGhostHouse(){
		assertEquals(
				pacman.position(),
				ghostHouseDoorType.nextPositionForGoing(pacman,left));

		assertEquals(
				pacman.position(),
				ghostHouseDoorType.nextPositionForGoing(pacman,right));
		
		assertEquals(
				pacman.position(),
				ghostHouseDoorType.nextPositionForGoing(pacman,up));
		
		assertEquals(
				pacman.position(),
				ghostHouseDoorType.nextPositionForGoing(pacman,down));
	}

	public void testTransporterMovesPacmanToNewPosition(){
		assertEquals(
				new Point(10,4),
				leftTransporterType.nextPositionForGoing(pacman,left));

		assertEquals(
				new Point(10,4),
				leftTransporterType.nextPositionForGoing(pacman,right));
	}

	public void testGhostCanNotGoIntoTransporter(){
		assertEquals(
				blueGhost.position(),
				leftTransporterType.nextPositionForGoing(blueGhost,left));

		assertEquals(
				blueGhost.position(),
				leftTransporterType.nextPositionForGoing(blueGhost,right));
	}

}
