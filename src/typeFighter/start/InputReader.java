package typeFighter.start;
import org.lwjgl.input.Keyboard;

public class InputReader {
 
 private boolean keyReleased;
 
 public char getInput(){
  char keyPressed = Keyboard.CHAR_NONE;
  
  if (keyReleased && Keyboard.getEventKeyState()) {
   keyPressed = Keyboard.getEventCharacter();
   keyReleased = false;

  }
  
  else if (keyReleased && Keyboard.getEventKeyState()) {
   keyReleased = false;
  }
  
  else if (Keyboard.next()) {
   keyReleased = true;
  }
  return keyPressed;
 }
}