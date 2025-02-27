package demo.java17;

import demo.java8.com.proto.model.AddressBookProtos.AddressBook;
import demo.java8.com.proto.model.AddressBookProtos.Person;
import demo.java8.com.proto.model.AddressBookProtos.Person.PhoneNumber;
import demo.java8.com.proto.model.AddressBookProtos.Person.PhoneType;

import java.io.*;

public class AddPerson {
    // This function fills in a Person message based on user input.
    private static Person promptForAddress(BufferedReader stdin) throws IOException {

        Person.Builder person = Person.newBuilder();

        System.out.print("Enter person ID: ");
        person.setId(Integer.parseInt(stdin.readLine()));

        System.out.print("Enter name: ");
        person.setName(stdin.readLine());

        System.out.print("Enter email address (blank for none): ");
        String email = stdin.readLine();
        if (email.length() > 0) {
            person.setEmail(email);
        }

        while (true) {
            System.out.print("Enter a phone number (or leave blank to finish): ");
            String number = stdin.readLine();
            if (number.length() == 0) {
                break;
            }

            PhoneNumber.Builder phoneNumber = PhoneNumber.newBuilder().setNumber(number);

            System.out.print("Is this a mobile, home, or work phone? ");
            String type = stdin.readLine();
            switch (type) {
                case "mobile" -> phoneNumber.setType(PhoneType.MOBILE);
                case "home" -> phoneNumber.setType(PhoneType.HOME);
                case "work" -> phoneNumber.setType(PhoneType.WORK);
                default -> System.out.println("Unknown phone type.  Using default.");
            }

            person.addPhones(phoneNumber);
        }

        return person.build();
    }

    // Main function:  Reads the entire address book from a file,
    //   adds one person based on user input, then writes it back out to the same
    //   file.
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage:  AddPerson ADDRESS_BOOK_FILE");
            System.exit(-1);
        }
        AddressBook.Builder addressBook = AddressBook.newBuilder();

        // Read the existing address book.
        try {
            addressBook.mergeFrom(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println(args[0] + ": File not found.  Creating a new file.");
        }

        // Add an address.
        addressBook.addPeople(promptForAddress(new BufferedReader(new InputStreamReader(System.in))));

        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream(args[0]);
        addressBook.build().writeTo(output);
        output.close();
    }

}
