
package assignment2;

/**
 *
 * @author 
 */
public class Contact {
    
    private String firstName;
    private String lastName;
    private String homePhone;
    private String workPhone;
    private String homeAddress;
    private String email;
    private String birthday;
    private String notes;
    
    
    public  Contact(){
        this.firstName = "";
        this.lastName = "";
        this.homePhone = "";
        this.workPhone = "";
        this.email = "";
        this.notes = "";
        
    }
    
    public Contact(String fN, String lN, String homePhone, String workPhone, String homeAddress, String email, String birthday, String notes){
        this.firstName = fN;
        this.lastName = lN;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.homeAddress = homeAddress;
        this.email = email;
        this.birthday = birthday;
        this.notes = notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
         
    
    
            
            
            
    
    
    
    
    
    
    
    
}
