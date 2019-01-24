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
import java.util.regex.Pattern;

public class ContactsManager extends Person {

    public static void main(String[] args){
        start();
    }// main

    static Input input = new Input();
    static String directory = "src/data";
    static String filename = "contactsList.txt";
    static Path dataDirectory = Paths.get(directory);
    static Path dataFile = Paths.get(directory, filename);

    // constructor
    public ContactsManager(String name, String number) {
        super(name, number);
    }

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
                    searchContacts();
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
        List<Person> people = new ArrayList<>();

        String contactName = input.getString("Please input the new contact name:");
        
        for(Person person: people){
            if(contactName == person.getName()){
                addNewContact();
            }    
        }

        boolean loop = true;
            do{
                long contactNumber = input.getLong("Please input the new contact number:");
                String numberAsString;
                String number;
                if(Long.toString(contactNumber).length() == 7){
                    loop = false;
                    numberAsString = Long.toString(contactNumber);
                    number = numberAsString.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
                    Person person = new Person(contactName, number);
                    people.add(person);
                    lines.add(person.getName() + " | " + person.getNumber());
                }else if(Long.toString(contactNumber).length() == 10){
                    loop = false;
                    numberAsString = Long.toString(contactNumber);
                    number = numberAsString.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
                    Person person = new Person(contactName, number);
                    people.add(person);
                    lines.add(person.getName() + " | " + person.getNumber());
                }
            }while(loop);

            Files.write(dataFile, lines);
        menu();
    }// addNewContact

    public static void searchContacts() throws FileNotFoundException{
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
            String subStringArray[] = x.split(Pattern.quote("|"));
            String subStringTrimmed = subStringArray[0].trim();
            System.out.println(subStringTrimmed);
            if (subStringTrimmed.contains(delete)){
                itr.remove();
            }
        }

        Files.write(dataFile, lines);
        menu();
    }//deleteContact

}// class