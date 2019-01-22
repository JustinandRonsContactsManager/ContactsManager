import java.util.List;
import java.io.IOException;

public class ContactsManager {
    String directory = "data";
    String file = "contacts.txt";

    public static void main(String[] args) {
        start();
    }// main

    static Input input = new Input();

    public static void menu(){
        System.out.println("Welcome to Contacts Manager\n");
        System.out.println("1: View all contacts");
        System.out.println("2: Add a new contact");
        System.out.println("3: Search a contact by his/her name");
        System.out.println("4: Delete an existing contact");

        int userInput = input.getInt(1, 4, "Enter an option (1, 2, 3 or 4):");

        if(userInput == 1){
          //view all contacts
        } else if( userInput == 2) {
          //add a new contact
        } else if( userInput == 3) {
          //search a contact by name
        } else if( userInput == 4) {
          //delete an extisting contact
        }
    }//menu

    public static void start(){
        menu();
    }//start

    public static void viewContacts(){
      Path contactsPath = Paths.get(directory, file);
      //write file path
      //catch and create file if not found
    }
    public static void addContact(){
      //
    }
    public static void searchContact(){

    }
    public static void deleteContact(){

    }


}// class
