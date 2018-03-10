//**********************************************************************
/* Author = Ian Gonzales
 * Partner = Jesse LaFlesch
 * File = Movement.java
 * Creation Date: 3/9/18
 * Purpose = Used by the Player or Enemy to move about the screen
 ***********************************************************************/

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement {

	private MoveListener move;
	
	public Movement() {
	}
	
	public void moveRight() {
	}
	
	public void moveLeft() {
	}
	
	public void moveUp() {
	}
	
	public void moveDown() {
	}
	
	
	private class MoveListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	
	}
	
	public String toString() {
		return "I am a Movement object, and I exist.";
	}
}


