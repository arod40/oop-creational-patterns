package edu.baylor.ecs.csi5324.builder.solution;

import java.io.FileNotFoundException;

public class ContactDirectory {
  public static class Contact{
    String name;
    String email;
    String phone;

    public Contact(String name, String email, String phone){
      this.name = name;
      this.email = email;
      this.phone = phone;
    }
  }

  public interface Importer{
    Iterable<Contact> provideContacts();
    void   open();
    void   close();
}

  public interface Exporter{
    void addContact(Contact contact);
  }

  public final void construct(Importer importer, Exporter exporter){
    importer.open();
    for (Contact contact:
         importer.provideContacts()) {
      exporter.addContact(contact);
    }
    importer.close();
  }
}
