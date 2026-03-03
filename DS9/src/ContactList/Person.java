package ContactList;

public class Person {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = "";
        this.address = "";
    }

    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getPhone(){ return phone; }
    public String getAddress(){ return address; }

    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
    public void setPhone(String phone){ this.phone = phone; }
    public void setAddress(String address){ this.address = address; }

    public String toString(){ return firstName + " " + lastName; }
}