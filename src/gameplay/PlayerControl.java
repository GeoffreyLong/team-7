package gameplay;

import gameplay.Cycle.Heading;

/**
 * @author Geoffrey Long
 * 
 * This class takes as input the keystrokes made by the players, 
 * and makes the appropriate change on the cycle heading.
 */
public class PlayerControl {
        Cycle cycleOne;
        Cycle cycleTwo;
        
        /**
         * Instantiate both cycles as class variables.  
         * This will allow changes to be made on the cycles.
         * @param cycleOne
         * @param cycleTwo
         */
        public PlayerControl(Cycle cycleOne, Cycle cycleTwo){
                this.cycleOne = cycleOne;
                this.cycleTwo = cycleTwo;
        }
        
        /**
         * This method will map the keyCodes from the keystrokes to specific 
         * cycle headings.  The cycle headings will be updated appropriately.
         * @param keyCode
         */
        public void setHeading(int keyCode){
                switch(keyCode){
                case 65:
                        cycleOne.setCurHeading(Heading.LEFT);
                        break;
                case 68:
                        cycleOne.setCurHeading(Heading.RIGHT);
                        break;
                case 87:
                        cycleOne.setCurHeading(Heading.UP);
                        break;
                case 83:
                        cycleOne.setCurHeading(Heading.DOWN);
                        break;
                case 37:
                        cycleTwo.setCurHeading(Heading.LEFT);
                        break;
                case 39:
                        cycleTwo.setCurHeading(Heading.RIGHT);
                        break;
                case 38:
                        cycleTwo.setCurHeading(Heading.UP);
                        break;
                case 40:
                        cycleTwo.setCurHeading(Heading.DOWN);
                        break;
                }
        }
        
        // added to get cycleOne, Ashley
        public Cycle getCycleOne() {
        	return cycleOne;
        }
        
        // added to get cycleTwo, Ashley
        public Cycle getCycleTwo() {
        	return cycleTwo;
        }
}