/*
 * At first it seemed redundant to overload the constructor to allow for different sitations.
 * I wasn't sure what the benefit was.  Thinking about it, a custom message to the super() is 
 * a flexible way to account for any situation from the class that might be suseptible to exceptions.<br/><br/>
 * 
 * I thought it might be better to create public methods, but that no longer makes much sense.  Let the
 * Exception Class do its job and let this Class provide the necessary message to the user.
 */
package lab3;

/**
 *
 * @author Greg Clark <gclark7@my.wctc.edu>
 */
public class CustomExceptions extends IllegalArgumentException{
    
    private final String NULL_VAL="Null or empty string\n";
    private final String MISSING_CHAR="You have not included a mandatory character";
    
    
    public CustomExceptions(){
        super("Some portion of the required information is missing or not necessary");
    }
    /*
    public String customExceptionMissingCharacter(){
        String msg="";
        
        return msg;
    }
    * */
    
    public CustomExceptions(String prompt){
        super(prompt);
    }
    
    public String getNullValueMessage(){
        return NULL_VAL;
    }
    
    public String getMissingCharacterMessage(){
        return MISSING_CHAR;
    }
}
