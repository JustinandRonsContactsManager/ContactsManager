import java.util.Scanner;

public class Input {

    Scanner scanner;

    // Input constructor
    public Input(){
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public boolean yesNo(){
        String input = getString();
        if(input.equalsIgnoreCase("yes")
                || input.equalsIgnoreCase("y")
                || input.equalsIgnoreCase("no")
                || input.equalsIgnoreCase("n")){
            return input.equalsIgnoreCase("yes")
                    || input.equalsIgnoreCase("y");
        }else{
            System.out.println("Enter \"yes\" or \"no\" :");
            return yesNo();
        }
    }

    public boolean yesNo(String prompt){
        System.out.println(prompt);
        return yesNo();
    }

    public int getInt(){
        while (!scanner.hasNextInt()) {
            System.out.println("Enter an number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public int getInt(String prompt){
        System.out.println(prompt);
        return getInt();
    }

    public int getInt(int min, int max){
        int userInput = getInt();
        if(userInput >= min && userInput <= max){
            return userInput;
        }else{
            System.out.printf("Enter a number between %d and %d.%n", min, max);
            return getInt(min, max);
        }
    }

    public int getInt(int min, int max, String prompt){
        System.out.println(prompt);
        return getInt(min, max);
    }

    public long getLong(){
        while (!scanner.hasNextLong()) {
            System.out.println("Enter an long number: ");
            scanner.next();
        }
        return scanner.nextLong();
    }

    public long getLong(String prompt){
        System.out.println(prompt);
        return getLong();
    }

    public String getString(){
        return scanner.next();
    }

    public String getString(String prompt){
        System.out.println(prompt);
        return getString();
    }

    public double getDouble(){
        while (!scanner.hasNextDouble()) {
            System.out.println("Enter a double: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public double getDouble(String prompt){
        System.out.println(prompt);
        return getDouble();
    }

    public double getDouble(double min, double max){
        double userInput = getDouble();
        if(userInput >= min & userInput <= max){
            return userInput;
        }else{
            System.out.printf("Enter a number between %.2f and %.2f.%n", min, max);
            return getDouble(min, max);
        }
    }

    public double getDouble(double min, double max, String prompt){
        System.out.println(prompt);
        return getDouble(min, max);
    }

    public long getBinary(String prompt){
        System.out.println(prompt);
        return getBinary();
    }

    public long getBinary(){
        while (!scanner.hasNextLong(2)) {
            System.out.println("Enter an binary: ");
            scanner.next();
        }
        String binary = scanner.next();
        return Integer.parseInt(binary,2);
    }

    public long getHex(String prompt){
        System.out.println(prompt);
        return getHex();
    }

    public long getHex(){
        while (!scanner.hasNextLong(16)) {
            System.out.println("Enter an hexidecimal: ");
            scanner.next();
        }
        String hexidecimal = scanner.next();
        return Long.parseLong(hexidecimal, 16);
    }

}//class
