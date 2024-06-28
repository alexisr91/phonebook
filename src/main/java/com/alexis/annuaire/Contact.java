package com.alexis.annuaire;

public class Contact {
    
    private String lastName;
    private String firstName;

    private String phoneNumber;


    // Construct
    public Contact(String lastName, String firstName, String phoneNumber){
        this.lastName    = lastName;
        this.firstName   = firstName;
        this.phoneNumber = phoneNumber;
    }
    
  

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Long return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override // Passer outre, annotation pour le polymorphisme
    public String toString(){
        return this.lastName + " " + this.firstName + " " + this.phoneNumber;
    }
}
