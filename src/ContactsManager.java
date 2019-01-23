import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.Iterator;

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
                try {
                    deleteContact();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
//        long contactNumber = input.getLong("Please input the new contact number:");





        long contactNumber = 0;
        boolean is7Digits = false;
        boolean is10Digits = false;

        is7Digits = Long.toString(contactNumber).length() == 7;
        is10Digits = Long.toString(contactNumber).length() == 10;

//        if(is7Digits){
////            contactNumber = input.getLong("Please input the new contact number:");
//        }else if(is10Digits){
////            contactNumber = input.getLong("Please input the new contact number:");
//        }else{
//        }


        while(!is7Digits || !is10Digits){
            contactNumber = input.getLong("Please input the new contact number:");
            if(is7Digits){
                is7Digits = true;
                is10Digits = true;
            }
        }


            String numberAsString = Long.toString(contactNumber);
            String number = numberAsString.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");







        lines.add(contactName + " | " + number);

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

    public static void deleteContact() throws IOException {
        List<String> lines = Files.readAllLines(dataFile);
        Iterator itr = lines.iterator();
        String delete = input.getString("What do you want to delete? (CASE SENSITIVE)");

        while (itr.hasNext()) {
            String x = (String) itr.next();
            if (x.contains(delete))
                itr.remove();

        }

        Files.write(dataFile, lines);
        menu();
    }//deleteContact
    

}// class
