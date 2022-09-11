package Modules;

public class Users {
    String fullname;
    String phoneNumber;
    String password;
    String age;
    String location;
    int ID;


    public Users(int ID, String fullname, String phoneNumber, String password, String age, String location) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.age = age;
        this.location = location;
        this.ID = ID;
    }


    public Users(String fullname, String phoneNumber, String password, String age, String location) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.age = age;
        this.location = location;
    }

    public Users(String fullname, String phoneNumber, String age, String location) {
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.location = location;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
