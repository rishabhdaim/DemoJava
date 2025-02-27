package demo.java17;

import demo.java8.com.proto.model.AddressBookProtos.AddressBook;
import demo.java8.com.proto.model.AddressBookProtos.Person;

import java.io.FileInputStream;
import java.util.function.Consumer;

public class ListPeople {
    // Iterates though all people in the AddressBook and prints info about them.
    private static void print(AddressBook addressBook) {
        addressBook.getPeopleList().forEach(person -> {
            System.out.println("Person ID: " + person.getId());
            System.out.println("  Name: " + person.getName());
            if (person.hasEmail()) {
                System.out.println("  E-mail address: " + person.getEmail());
            }
            person.getPhonesList().forEach(getPhoneNumber());
        });
    }

    private static Consumer<Person.PhoneNumber> getPhoneNumber() {
        return pn -> System.out.printf(switch (pn.getType()) {
            case MOBILE -> ("  Mobile phone # : %s\n");
            case HOME -> ("  Home phone # : %s\n");
            case WORK -> ("  Work phone # : %s\n");
        }, pn.getNumber());
    }

    // Main function:  Reads the entire address book from a file and prints all
    //   the information inside.
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage:  ListPeople ADDRESS_BOOK_FILE");
            System.exit(-1);
        }

        // Read the existing address book.
        AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(args[0]));
        print(addressBook);
    }
}
