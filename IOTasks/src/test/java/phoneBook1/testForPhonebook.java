package phoneBook1;

import PhoneBook.Contact;
import PhoneBook.Phone;
import PhoneBook.PhoneBook;
import PhoneBook.PhoneNumberType;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

public class testForPhonebook {

    @BeforeClass
    public static void before() {
        File file1 = new File("phoneBook.txt");
        file1.delete();

    }

    @Test
    public void testCreateContacts() {
        before();
        PhoneBook pb = new PhoneBook();
        Contact sergei = pb.createNewContact("Сергей");
        Contact alex = pb.createNewContact("Alex");
        Contact kat = pb.createNewContact("Kat");
        Assert.assertNotNull(sergei);
        Assert.assertNotNull(alex);
        Assert.assertNotNull(kat);
    }

    @Test
    public void testForFindNumber() {
        before();
        PhoneBook pb = new PhoneBook();
        Contact sergei = pb.createNewContact("Сергей");
        sergei.setSurname("Никита");
        sergei.setNikName("Иванович");
        sergei.setMail("Dok@mail.ru");
        sergei.setBirthDay(1988, 10, 15);
        sergei.setPhone(new Phone(PhoneNumberType.MOBILE, 336237019));
        sergei.setPhone(new Phone(PhoneNumberType.FAX, 152446612));
        pb.addContactToPhonebook(sergei);

        Contact alex = pb.createNewContact("Alex");
        alex.setSurname("Кротов");
        alex.setNikName("Иванович");
        alex.setMail("Dok12@mail.ru");
        alex.setBirthDay(1989, 11, 12);
        alex.setPhone(new Phone(PhoneNumberType.MOBILE, 296336363));
        alex.setPhone(new Phone(PhoneNumberType.HOME, 152447795));
        pb.addContactToPhonebook(alex);

        Contact kat = pb.createNewContact("Ekaterina");
        kat.setSurname("Inavova");
        kat.setNikName("Sergeevna");
        kat.setMail("jbvjb@mail.ru");
        kat.setBirthDay(1990, 4, 10);
        kat.setPhone(new Phone(PhoneNumberType.WORK, 296555999));
        kat.setPhone(new Phone(PhoneNumberType.HOME, 152548205));
        pb.addContactToPhonebook(kat);


        pb.findContact(PhoneNumberType.HOME, "152548205");
        System.out.println(" ");
        pb.findContact(PhoneNumberType.MOBILE, "336237019");

    }


    @Test
    public void testForFindContact() {
        before();
        PhoneBook pb = new PhoneBook();
        Contact sergei = pb.createNewContact("Сергей");
        sergei.setSurname("Никита");
        sergei.setNikName("Иванович");
        sergei.setMail("Dok@mail.ru");
        sergei.setBirthDay(1988, 10, 15);
        sergei.setPhone(new Phone(PhoneNumberType.MOBILE, 336237019));
        sergei.setPhone(new Phone(PhoneNumberType.FAX, 152446612));
        pb.addContactToPhonebook(sergei);

        Contact alex = pb.createNewContact("Alex");
        alex.setSurname("Кротов");
        alex.setNikName("Иванович");
        alex.setMail("Dok12@mail.ru");
        alex.setBirthDay(1989, 11, 12);
        alex.setPhone(new Phone(PhoneNumberType.MOBILE, 296336363));
        alex.setPhone(new Phone(PhoneNumberType.HOME, 152447795));
        pb.addContactToPhonebook(alex);

        Contact kat = pb.createNewContact("Ekaterina");
        kat.setSurname("Inavova");
        kat.setNikName("Sergeevna");
        kat.setMail("jbvjb@mail.ru");
        kat.setBirthDay(1990, 4, 10);
        kat.setPhone(new Phone(PhoneNumberType.WORK, 296555999));
        kat.setPhone(new Phone(PhoneNumberType.HOME, 152548205));
        pb.addContactToPhonebook(kat);

        pb.showContact("Alex");
        System.out.println("");
        pb.showContact("Ekaterina");
    }


    @Test
    public void testForShowAllContacts() {
        before();
        PhoneBook pb = new PhoneBook();
        Contact sergei = pb.createNewContact("Сергей");
        sergei.setSurname("Никита");
        sergei.setNikName("Иванович");
        sergei.setMail("Dok@mail.ru");
        sergei.setBirthDay(1988, 10, 15);
        sergei.setPhone(new Phone(PhoneNumberType.MOBILE, 336237019));
        sergei.setPhone(new Phone(PhoneNumberType.FAX, 152446612));
        pb.addContactToPhonebook(sergei);

        Contact alex = pb.createNewContact("Alex");
        alex.setSurname("Кротов");
        alex.setNikName("Иванович");
        alex.setMail("Dok12@mail.ru");
        alex.setBirthDay(1989, 11, 12);
        alex.setPhone(new Phone(PhoneNumberType.MOBILE, 296336363));
        alex.setPhone(new Phone(PhoneNumberType.HOME, 152447795));
        pb.addContactToPhonebook(alex);

        Contact kat = pb.createNewContact("Ekaterina");
        kat.setSurname("Inavova");
        kat.setNikName("Sergeevna");
        kat.setMail("jbvjb@mail.ru");
        kat.setBirthDay(1990, 4, 10);
        kat.setPhone(new Phone(PhoneNumberType.WORK, 296555999));
        kat.setPhone(new Phone(PhoneNumberType.HOME, 152548205));
        pb.addContactToPhonebook(kat);


        pb.showAllContacts();
    }
}