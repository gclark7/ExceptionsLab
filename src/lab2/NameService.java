package lab2;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
    private final String REQUEST_FULL_NAME="Enter full name\n FirstName then LastName\n ***Please place a space between names***"+
            "\nOnly Alpha characters";
    private final String PRESENT_LAST_NAME="Your last name is: ";
    private final String NULL_VAL="Null or empty string\n";
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) throws IllegalArgumentException{
        //String[] nameParts = fullName.split(" ");
        //return nameParts[LAST_NAME_IDX];
        
        String lastName="";
        String msg="";
        //String temp="";
        //String pattern = "[a-zA-Z]"+ " " + "[a-zA-Z]";
        boolean nameRight=false;
        int j=0;
        
        //do{
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
               throw new IllegalArgumentException(msg+REQUEST_FULL_NAME);
            }
        //}while(!nameRight);
        
        
        return lastName;
        
        
    }
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) {
        String[] nameParts = fullName.split(" ");
        return nameParts[FIRST_NAME_IDX];
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) {
        return name.length();
    }
    
}
