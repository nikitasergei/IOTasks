package PhoneBook;

import PhoneBook.PhoneBookExceptions.IncorrectEmailValue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Contact {
    private String name;
    private String nikName;
    private String surname;
    private String mail;
    private LocalDate birthDay;
    private Set<Phone> phones;

    Contact(String name) {
        this.name = name;
        this.phones = new HashSet<>();
    }


    public void setMail(String mail) {
        Pattern p = Pattern.compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$", Pattern.CASE_INSENSITIVE);
        if (Pattern.matches(String.valueOf(p), mail))
            this.mail = mail;
        else try {
            throw new IncorrectEmailValue();
        } catch (IncorrectEmailValue ex) {
            ex.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNikName() {
        if (this.nikName != null)
            return nikName;
        else return "";
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public String getSurname() {
        if (this.surname != null)
            return surname;
        else return "";
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDay() {
        if (this.birthDay != null)
            return birthDay;
        else return LocalDate.of(0,0,0);
    }

    public void setBirthDay(int year, int month, int day) {
        this.birthDay = LocalDate.of(year, month, day);
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public String getMail() {
        if (this.mail != null)
            return mail;
        else return "Mail not detected";
    }

    public boolean setPhone(Phone phone) {
        return this.phones.add(phone);
    }


}
