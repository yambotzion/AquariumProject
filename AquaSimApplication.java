import java.awt.Color;
import java.util.Random;

/** Aquarium Lab Series: <br>    
 *      The AquaSimApplication class contains the main function that will
 *      run the Aquarium Simulation. (This description should be updated
 *      when the behavior of the program changes.)<br>
 *
 * Modifications: <br>
 *   23 March 2008,  Alyce Brady,  Created skeleton main that constructs and
 *                                 displays an empty aquarium.<br>
 *   (date), (your name), Modified to .... <br>
 *
 *  @author  Alyce Brady  (should be Your Name)
 *  @version 23 March 2008  (should be today's date)
 *  @see AquariumController
 **/
public class AquaSimApplication
{
    /**
     *  This is the main function.  It executes the program.
     *  @param    String args[] is never used
     **/
    private static Random generator;
    public static void main(String args[])
    {
        System.out.println("This will be an aquarium simulation.");

        // CONSTRUCT OBJECTS NEEDED FOR THE AQUARIUM SIMULATION.
                generator = new Random();
               
        // Construct the aquarium.  Specify its dimensions when creating it.
        Aquarium aqua;                 // create reference to an Aquarium ...
        aqua = new Aquarium(600, 480);
   
        // ... object that has now been created

        // Construct fish and add them to the aquarium.
        AquaFish teemo = new AquaFish(aqua,getColor(generator));
        AquaFish omegeo = new AquaFish(aqua,getColor(generator));
        AquaFish beemo = new AquaFish(aqua,getColor(generator));
        
        
        aqua.add(teemo);
        aqua.add(omegeo);
        aqua.add(beemo);
        
        

        // Construct a graphical user interface (GUI) to display and control
        // the simulation.  The user interface needs to know about the
        // aquarium, so we pass aqua to the user interface constructor.
        AquaSimGUI userInterface;              // create reference to GUI ...
        userInterface = new AquaSimGUI(aqua);  // ... and then GUI itself

        // Tell the user how to start the aquarium simulation.
        System.out.println("Press the Start button to start the simulation.");

        // Now wait for the user to press the start button.
        userInterface.waitForStart();

        // Draw the initial view of the aquarium and its contents.
        userInterface.showAquarium();


        // RUN THE AQUARIUM SIMULATION.

        // Make the fish move and redisplay.
        
        for(;;){
        teemo.moveForward(); 
        beemo.moveForward(); 
        omegeo.moveForward(); 
       
            if(teemo.atWall()){
         teemo.changeDir();
         
         
        }
        if(beemo.atWall()){
         beemo.changeDir();
        
        
        }
        if(omegeo.atWall()){
         omegeo.changeDir();
         
         
        }
        
        
       
        
        userInterface.showAquarium();
        
        
    }
        
        
        
        
        
       
        // WRAP UP.
        // Remind user how to quit application.
        

    }//end main
    public static Color getColor(Random generator){
        int randInt = generator.nextInt(6);
            if(randInt == 0)
                return Color.RED;
            else if(randInt == 1)
                return Color.ORANGE;
            else if(randInt == 2)
                return Color.YELLOW;
            else if(randInt == 3)
                return Color.GREEN;
            else if(randInt == 4)
                return Color.BLUE;
            else
                return Color.MAGENTA;
    }
}//end class
