package edu.baylor.ecs.csi5324.builder.solution;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType (XmlAccessType.FIELD)
public class ContactDirectoryXMLExporter implements ContactDirectory.Exporter{
  private List<XMLContact> contacts = new ArrayList<>();
  @XmlRootElement(name = "contact")
  @XmlAccessorType(XmlAccessType.FIELD)
  private class XMLContact{
    private String name;
    private String email;
    private String phone;

    public XMLContact(ContactDirectory.Contact contact){
      this.name = contact.name;
      this.email = contact.email;
      this.phone = contact.phone;
    }
  }

  public void addContact(ContactDirectory.Contact contact) {
    this.contacts.add(new XMLContact(contact));
  }

  public void buildXMLToFile(String xmlFile) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(ContactDirectoryXMLExporter.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    jaxbMarshaller.marshal(contacts, System.out);
    jaxbMarshaller.marshal(contacts, new File(xmlFile));
  }

  public void buildXMLToSystemOut() throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(ContactDirectoryXMLExporter.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    jaxbMarshaller.marshal(contacts, System.out);
  }
}
