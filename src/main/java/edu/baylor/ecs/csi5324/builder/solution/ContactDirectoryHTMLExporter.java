package edu.baylor.ecs.csi5324.builder.solution;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ContactDirectoryHTMLExporter implements ContactDirectory.Exporter{
  List<ContactDirectory.Contact> contactList = new ArrayList<>();

  public void addContact(ContactDirectory.Contact contact) {
    contactList.add(contact);
  }

  public void buildHTML(OutputStreamWriter outputStreamWriter){
    StringBuilder stringBuilder = new StringBuilder("<table>\n")
        .append("\t<tr>\n")
        .append("\t\t<th>Name</th>\n")
        .append("\t\t<th>Email</th>\n")
        .append("\t\t<th>Phone</th>\n")
        .append("\t</tr>");
    for (ContactDirectory.Contact contact:
         contactList) {
      stringBuilder
          .append("\t<tr>\n")
          .append("\t\t<td>").append(contact.name).append("</td>\n")
          .append("\t\t<td>").append(contact.email).append("</td>\n")
          .append("\t\t<td>").append(contact.phone).append("</td>\n")
          .append("\t</tr>\n");
    }

    stringBuilder.append("</table>\n");

    try {
      outputStreamWriter.write(stringBuilder.toString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
