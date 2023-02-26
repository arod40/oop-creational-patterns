package edu.baylor.ecs.csi5324.builder.solution;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "contacts")
@XmlAccessorType (XmlAccessType.FIELD)
public class ContactDirectoryXMLExporter implements ContactDirectory.Exporter{

  @XmlRootElement(name = "contact")
  @XmlAccessorType(XmlAccessType.FIELD)
  private static class XMLContact{
    private String name;
    private String email;
    private String phone;

    public XMLContact(){

    }

    public XMLContact(ContactDirectory.Contact contact){
      this.name = contact.name;
      this.email = contact.email;
      this.phone = contact.phone;
    }
  }

  @XmlElement(name = "contact")
  private List<XMLContact> contacts = new ArrayList<XMLContact>();;

  public List<XMLContact> getContacts(){
    return contacts;
  }

  public void setContacts(List<XMLContact> contacts){
    this.contacts = contacts;
  }

  public void addContact(ContactDirectory.Contact contact) {
    this.contacts.add(new XMLContact(contact));
  }

  public void buildXML(Writer writer) {
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(ContactDirectoryXMLExporter.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(this, writer);
    }
    catch (JAXBException e){
      throw new RuntimeException(e);
    }
  }
}
