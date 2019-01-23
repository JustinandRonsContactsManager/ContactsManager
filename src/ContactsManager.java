import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class ContactsManager {

    static Input input = new Input();
    static String directory = "src/data";
    static String filename = "contactsList.txt";
    static Path dataDirectory = Paths.get(directory);
    static Path dataFile = Paths.get(directory, filename);

        public static void main(String[] args) throws FileNotFoundException {
        start();
    }// main

    public static void start(){
        System.out.println("Welcome to Contacts Manager!");
        menu();
    }

    public static void menu(){
        System.out.println("\nPlease enter an option");
        System.out.println("1: View all contacts");
        System.out.println("2: Add a new contact");
        System.out.println("3: Search a contact by his/her name");
        System.out.println("4: Delete an existing contact");
        System.out.println("5: Exit");

        int optionSelected = input.getInt(1, 5);

        switch(optionSelected){
            case 1:
                try {
                    showContacts();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    addNewContact();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try{
                    ContactsManager contactsSearch = new ContactsManager();
                    contactsSearch.searchContacts();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                // code block
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
                break;
        }
    }// menu

    public static void showContacts() throws IOException {
        List<String> contactList = Files.readAllLines(dataFile);

        System.out.println("Here's the contact list:");

        for(String item : contactList) {
            System.out.println(item);
        }

        menu();
    }// showContacts

    public static void addNewContact() throws IOException {
        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }
        if(Files.notExists(dataFile)) {
            Files.createFile(dataFile);
        }

        List<String> lines = Files.readAllLines(dataFile);

        String contactName = input.getString("Please input the new contact name:");
        long contactNumber = input.getLong("Please input the new contact number:");

        lines.add(contactName + " | " + contactNumber);

        Files.write(dataFile, lines);

        menu();
    }// addNewContact

    public void searchContacts() throws FileNotFoundException{
        Scanner scan = new Scanner(new File(directory, filename));
        String searchName = input.getString("Enter a contact name");
        while(scan.hasNext()){
            String contactInfo = scan.nextLine().toLowerCase().toString();
            if(contactInfo.contains(searchName.toLowerCase())){
                System.out.print(contactInfo + "\n");
            }
        }
        menu();
    }//searchContact

    public static void deleteContact(){

    }//deleteContact

}// class
