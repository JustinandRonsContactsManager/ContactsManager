package src.data;

public class Person {

    private String name;
    private long number;

    public Person(String name){
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setName(String name){
        this.name = name;
    }


}// class
