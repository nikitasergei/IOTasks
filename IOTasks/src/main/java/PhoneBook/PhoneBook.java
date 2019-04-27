package PhoneBook;

import PhoneBook.PhoneBookExceptions.ContactAlreadyExistsException;

import java.io.*;
import java.util.regex.Pattern;

public class PhoneBook {
    private File file;
    private String marker = "          ";


    public PhoneBook() {
        try {
            this.file = new File("phoneBook.txt");
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Contact createNewContact(String name) {
        try {
            Contact contact = new Contact(name);
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(this.file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Pattern reg = Pattern.compile("Name: " + name);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (Pattern.matches(String.valueOf(reg), str)) {
                    try {
                        throw new ContactAlreadyExistsException();
                    } catch (ContactAlreadyExistsException e) {
                        e.printStackTrace();
                    } finally {
                        bufferedReader.close();
                    }
                }
            }
            return contact;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addContactToPhonebook(Contact contact) {
        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));
            FileWriter fileWr = new FileWriter(this.file, true);
            fileWr.append("Name: ").append(contact.getName()).append("\n")
                    .append("nikName: ").append(contact.getNikName()).append("\n")
                    .append("Surname: ").append(contact.getSurname()).append("\n")
                    .append("Phone: ").append(contact.getPhones().toString()).append("\n")
                    .append(contact.getMail()).append("\n")
                    .append(contact.getBirthDay().toString()).append("\n")
                    .append(this.marker).append("\n");
            fileWr.close();
        } catch
        (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAllContacts() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showContact(String name) {
        Pattern reg = Pattern.compile("Name: " + name);
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file));
            String line;
            while ((line = br.readLine()) != null) {
                if (Pattern.matches(String.valueOf(reg), line)) {
                    System.out.println(line);
                    String str;
                    while (!(str = br.readLine()).equals(this.marker))
                        System.out.println(str);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findContact(PhoneNumberType pNT, String phoneNumber) {
//        Pattern reg = Pattern.compile(pNT + " : " + phoneNumber);
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file));
            String line;
            br.mark(1);
            while ((line = br.readLine()) != null) {
                if (line.startsWith(this.marker))
                    br.mark(0);
                if (line.contains(pNT + " : " + phoneNumber)) {
                    br.reset();
                    String str;
                    while (!(str = br.readLine()).equals(this.marker)) {
                        System.out.println(str);
                        if (str.equals(this.marker))
                            break;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

