import java.util.List;
import java.io.IOException;

public class ContactsManager {
    String directory = "src/data";
    String file = "contacts.txt";
    Path contactsPath = Paths.get(directory);

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
          viewContacts();
        } else if( userInput == 2) {
          //add a new contact
          addContact();
        } else if( userInput == 3) {
          //search a contact by name
          searchContact();
        } else if( userInput == 4) {
          //delete an extisting contact
          deleteContact();
        }
    }//menu

    private String contact;
    private Int number;

    public Contact(String Contact) {
      this.contact = contact;
      this.number = number;
    }//Contact

    public String getContact() {
      return contact;
    }//getContact

    public Int getNumber() {
      return number;
    }//getNumber
    //setters
    public void setNumber(Int number) {
      this.number = number;
    }//setNumber

    public void setContact(String contact) {
      this.contact = contact;
    }//setContact

    public static void start(){
        menu();
    }//start

    public static void viewContacts(){
      //write file path

      List<String> Files.readAllLines(Path contactsPath);
      //catch and create file if not found
      if(Files.notExists(Path contactsPath)){
        Path Files.creatFile(Path contactsPath);
      }

    }//viewContacts
    public static void addContact(){
      //initialize contactsList
      List<String> contactsList;
      Path contactsPath = Paths.get("data", "contacts.txt");
      String newContactName = input.getString("Enter a new Contact Name");
      Int newPhoneNumber = input.getInt("Enter a new Phone number for " + newContactName);
      Files.write(contactsPath, Arrays.listOf(contactsList));

    }//addContact
    public static void searchContact(){

    }//searchContact
    public static void deleteContact(){

    }//deleteContact



}// class
