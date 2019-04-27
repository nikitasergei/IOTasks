package PhoneBook;

public interface PhonebookService {
    /*
     *Create and @return new Contact with @name
     *If Contact wasn't created @return null
     */
    Contact createNewContact(String name);

    /*
     * Adds a Сontact to the phonebook
     */
    void addContactToPhonebook(Contact contact);

    /*
     * Print to console all Contacts, witch are in phonebook
     */
    void showAllContacts();

    /*
     * Print Contact with @name to console, if this Contact located in phonebook
     */
    void showContact(String name);


    /*
     * Check Contact in phonebook with @phoneNumber and @PhoneNumberType.
     * if Contact was found print it to console
     */
    void findContact(PhoneNumberType pNT, String phoneNumber);

}
