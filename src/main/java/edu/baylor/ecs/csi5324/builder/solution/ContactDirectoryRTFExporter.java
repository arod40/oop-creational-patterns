package edu.baylor.ecs.csi5324.builder.solution;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.FileOutputStream;
import java.io.IOException;

public class ContactDirectoryRTFExporter implements ContactDirectory.Exporter{

  private RTFEditorKit rtfEditorKit = new RTFEditorKit();
  private Document document = rtfEditorKit.createDefaultDocument();

  public ContactDirectoryRTFExporter(){
    try {
      document.insertString(document.getLength(), "Name -- Email -- Phone" + "\n", null);
    } catch (BadLocationException e) {
      throw new RuntimeException(e);
    }
  }

  public void addContact(ContactDirectory.Contact contact) {
    try {
      document.insertString(document.getLength(), contact.name + " -- " + contact.email+ " -- " + contact.phone + "\n", null);
    } catch (BadLocationException e) {
      throw new RuntimeException(e);
    }
  }

  public void buildRTF(FileOutputStream outputStream){
    try {
      rtfEditorKit.write(outputStream, document, document.getStartPosition().getOffset(), document.getLength());
    } catch (IOException | BadLocationException e) {
      e.printStackTrace();
    }
  }
}
