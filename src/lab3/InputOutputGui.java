package lab3;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
     private NameService nameService;
     private final String REQUEST_FULL_NAME="Enter full name\n FirstName then LastName\n ***Please place a space between names***"+
            "\nOnly Alpha characters";
     private final String PRESENT_LAST_NAME="Your last name is: ";

    public InputOutputGui() {
        nameService = new NameService();
    }

    /**
     * The GUI is now responsible for output of illegal argument exceptions
     * a do while loop ensures the input is verified and proper prior to extraction
     * a try catch handles the last name extraction and the exceptions produced
     */
    public void startConversation() {
        
        String fullName = JOptionPane.showInputDialog(REQUEST_FULL_NAME);
        String lastName="";
        String msg=""; 
        boolean rightName=false;
        
        do{
        try{
            lastName= nameService.extractLastName(fullName);
            rightName=true;
        }catch(CustomExceptions e){
            JOptionPane.showMessageDialog(null, e);
            rightName=false;
        }
            if(!rightName){
                fullName = JOptionPane.showInputDialog(REQUEST_FULL_NAME);
            }
        }while(!rightName);
        
        msg= PRESENT_LAST_NAME + lastName;
        JOptionPane.showMessageDialog(null, msg);
        
    }
     
}
