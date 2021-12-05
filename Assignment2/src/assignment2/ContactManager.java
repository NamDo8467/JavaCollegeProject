/**
 *
 * Do Huynh - 101293009
 * Minh Nhat Vo - 101224717
 */
package assignment2;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contactList;
    
    public ContactManager(){
        contactList = new ArrayList<Contact>();
    }

    
    public void addContact(Contact contact){
        contactList.add(contact);
    }
    
    public void deleteContact(Contact contact){
        try {
            contactList.remove(contact);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }
    
    // Return the index at a specific index
    public Contact getContactAtIndex(int index){
        return contactList.get(index);
    }
    
    // Return index of a specific contact
    public int getIndexOfContact(Contact contact){
        return contactList.indexOf(contact);
    }
    
    public void replaceWithNewContact(int index, Contact contact){
        for (int i = 0; i < contactList.size(); i++) {
            if(i == index){
                contactList.set(index, contact);
            }
        }
    }
    
    // Return all contact that matches the city
    public ArrayList<Contact> searchByCity(String city){
        ArrayList<Contact> result = new ArrayList<>();
        for (int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getHomeAddress().city.equals(city)){
                result.add(contactList.get(i));
                return result;
               
           }
        }
        return null;
    }
    
     // Return all contact that matches the firstName and lastName
    public Contact searchFirstNameAndLastName(String firstName, String lastName){
        for (int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getFirstName().equals(firstName) && contactList.get(i).getLastName().equals(lastName) ){
               return contactList.get(i);
           }
        }
        return null;
    }
        
        
    public int getLength(){
        return  contactList.size();
    }
    
    
    
}