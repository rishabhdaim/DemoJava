import demo.java8.com.proto.model.AddressBookProtos;

module java17 {
    requires java8;
    requires caliper;
    requires io.vavr;
    requires com.google.common;
    requires java.desktop;
    requires lombok;
    requires java.management;
    requires jmh.core;
    requires jmh.generator.annprocess;

    uses demo.java8.com.proto.model.AddressBookProtos;
    uses AddressBookProtos.Person;
    uses AddressBookProtos.AddressBook;
}