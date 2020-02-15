package phonebook;

public class PhoneBook {
    private long id;
    private String surname;
    private String name;
    private String citi;
    private String street;
    private String flatnumber;
    private String phonenumber;

    public PhoneBook() {
    }

    public PhoneBook(long id, String surname, String name, String citi, String street, String flatnumber, String phonenumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.citi = citi;
        this.street = street;
        this.flatnumber = flatnumber;
        this.phonenumber = phonenumber;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiti() {
        return citi;
    }

    public void setCiti(String citi) {
        this.citi = citi;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatnumber() {
        return flatnumber;
    }

    public void setFlatnumber(String flatnumber) {
        this.flatnumber = flatnumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", citi='" + citi + '\'' +
                ", street='" + street + '\'' +
                ", flatnumber='" + flatnumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
