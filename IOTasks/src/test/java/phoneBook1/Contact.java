package phoneBook1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String surname;
    private String nikName;
    private String phoneNumber;
    private String mail;
    private String yearOfBirth;

    Contact(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getSurname() {
        return surname;
    }

    public String getNikName() {
        return nikName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        Pattern p = Pattern.compile("^[A-Za-z0-9][A-Za-z0-9]*[A-Za-z0-9]*@([A-Za-z0-9]+([A-Za-z0-9-]*[A-Za-z0-9]+)*)+[A-Za-z]*$");
        if (Pattern.matches(String.valueOf(p),mail))
        this.mail = mail;
        else System.out.println("Incorrect value of email");
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("phoneBook.txt"));
            Pattern reg = Pattern.compile("Phone: " + phoneNumber);
            String line;
            while ((line = br.readLine()) != null) {
                if (Pattern.matches(String.valueOf(reg), line))
                    System.out.println("This phone number already exist");
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.phoneNumber = phoneNumber;
    }
}
