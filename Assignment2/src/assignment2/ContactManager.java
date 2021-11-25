/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;

/**
 *
 * @author huynh
 */
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
    
    
    
}
