
public class ContactsManager {

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
    }


    public static void start(){
        menu();

        input.getInt(1, 4, "Enter an option:");


    }


}// class
