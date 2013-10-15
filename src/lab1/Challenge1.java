package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again. (Yes, this violates 
 * the Single Responsibility Principle, but for this lab, we'll overlook that.)
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int LAST_NAME_IDX = 1;
    private static final String REQUEST_FULL_NAME="Enter full name\n FirstName then LastName\n ***Please place a space between names***"+
            "\nOnly Alpha characters";
    private static final String PRESENT_LAST_NAME="Your last name is: ";
    private static final String WRONG_NAME="Needs a space with Alpha characters\n";
    private static final String NULL_VAL="Null or empty string\n";

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        
        String fullName = JOptionPane.showInputDialog(REQUEST_FULL_NAME);
        String lastName = app.extractLastName(fullName);
        String msg =  PRESENT_LAST_NAME + lastName;
        JOptionPane.showMessageDialog(null, msg);
    }
    
    /**
     * finds last name starting at the last character and working forward to a space.
     * If no space is found a prompt requests the proper format until it is correctly entered
     * 
     * @param fullName
     * @return 
     */
    public String extractLastName(String fullName) {
        String lastName="";
        String msg="";
        //String temp="";
        //String pattern = "[a-zA-Z]"+ " " + "[a-zA-Z]";
        boolean nameRight=false;
        int j=0;
        
        do{
            if(fullName==null||fullName.length()==0){
                nameRight=false;
               msg=NULL_VAL;
            }else{
                for(int i=fullName.length()-1;i>=0;i--){
                    if(fullName.charAt(i)==32&&nameRight==false){
                        nameRight=true;
                        msg="";
                        //extract last name
                        for(j=i;j<fullName.length();j++){
                            lastName+=fullName.toCharArray()[j];
                        }
                    }
                 }
            }
        
            if(!nameRight){
                fullName = JOptionPane.showInputDialog(msg+REQUEST_FULL_NAME);
            }
        }while(!nameRight);
        
        
        return lastName;
        //String[] nameParts = fullName.split(" ");
        //return nameParts[LAST_NAME_IDX];
        //tried
        /*
         * else if(!fullName.matches(pattern)){
                    nameRight=false;
                    System.out.println("not matching pattern");
         */
    }

    
}
