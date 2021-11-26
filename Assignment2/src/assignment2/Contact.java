
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
    private Address address;
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
    
    public Contact(String fN, String lN, String homePhone, String workPhone, Address address, String email, String birthday, String notes){
        this.firstName = fN;
        this.lastName = lN;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.address = address;
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

    public Address getHomeAddress() {
        return address;
    }

    public void setHomeAddress(Address address) {
        this.address = address;
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
    @Override
    public String toString() {
        String s = "First Name: " + firstName + "\n";
        s += "Last name: " + lastName + "\n";
        s += "Home phone: " + homePhone + "\n";
        s += "Work phone=" + workPhone + "\n";
        s += "Home address: " + address.toString() + "\n";
        s += "Email: " + email + "\n";
        s += "Birthday:" + birthday + "\n";
        s += "Notes: " + notes + "\n";
        return s;
          
    }
}
