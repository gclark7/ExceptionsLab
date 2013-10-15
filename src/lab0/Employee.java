package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    public static final int MIN_VACATION_DAYS=0;
    private final String WRONG_NUM="Number is either higher or lower than necessary.";
    private final String WRONG_NAME="Only alpha characters; no number or symbols...sorry Artist FKA Prince";
    private final String NULL_VAL="Null or empty string";
    private final String MAX_CHARS="Value has exceeded the maximum of 50 characters";
    private final int MAX_ALPHA=50;
    private final int MAX_SSN=9;
    private final String WRONG_SSN="Only 9 numbers please";
    private final String MAX_DIGITS="Too many numbers to be a SSN";
    
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    /**
     * version 2 constructor utilizes the setter methods to validate values
     * @param firstName
     * @param lastName
     * @param ssn
     * @param hireDate
     * @param daysVacation 
     */
    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSsn(ssn);
        this.setHireDate(hireDate);
        this.setDaysVacation(daysVacation);
    }
    /*original constructor
    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }*/
    
    public int getDaysVacation() {
        return daysVacation;
    }

    /**
     * no one in this company has more than 28 days of vacation
     * also checks to be sure number is not negative
     * @param daysVacation 
     */
    public void setDaysVacation(int daysVacation) {
        if(daysVacation>MAX_VACATION_DAYS){
            throw new IllegalArgumentException(WRONG_NUM);
        }else if(daysVacation<MIN_VACATION_DAYS){
            throw new IllegalArgumentException(WRONG_NUM);
        }else{this.daysVacation = daysVacation;}
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * checks for null, 0-length, max characters, alpha characters
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        if(firstName==null||firstName.length()==0){
            throw new IllegalArgumentException(NULL_VAL);
        }else if(firstName.length()>MAX_ALPHA){
             throw new IllegalArgumentException(MAX_CHARS);
        }else{
            String pattern = "^[a-zA-Z]*$";
            if(!firstName.matches(pattern)){
                    throw new IllegalArgumentException(WRONG_NAME);
            }else{ this.firstName = firstName;}
        }
       
    }

    public Date getHireDate() {
        return hireDate;
    }

    /**
     * checks for null and legitimate date
     * @param hireDate 
     */
    public void setHireDate(Date hireDate) {
        if(hireDate==null){
            throw new IllegalArgumentException(NULL_VAL);
        }else{
        this.hireDate = hireDate;
        }
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Checks for null, 0-length, max length, min length and alpha characters
     * @param lastName 
     */
    public void setLastName(String lastName) {
         if(lastName==null||lastName.length()==0){
            throw new IllegalArgumentException(NULL_VAL);
        }else if(lastName.length()>MAX_ALPHA){
             throw new IllegalArgumentException(MAX_CHARS);
        }else{
            String pattern = "^[a-zA-Z]*$";
            if(!lastName.matches(pattern)){
                    throw new IllegalArgumentException(WRONG_NAME);
            }else{ this.lastName = lastName;}
        }
    }

    public final String getSsn() {
        return ssn;
    }

    /**
     * Checks for null, 0-length, digits and max digits
     * @param ssn 
     */
    public void setSsn(String ssn) {
        
        if(ssn==null||ssn.length()==0){
            throw new IllegalArgumentException(NULL_VAL);
        }else if(ssn.length()>MAX_SSN){
             throw new IllegalArgumentException(MAX_DIGITS);
        }else{
            String pattern = "^[0-9]*$";
            if(!ssn.matches(pattern)){
                    throw new IllegalArgumentException(WRONG_SSN);
            }else{ this.ssn = ssn;}
        }
    }
    
    
}
