package edu.baylor.ecs.csi5324.builder.solution;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class ContactDirectoryPDFExporter implements ContactDirectory.Exporter{
  private PDDocument document = new PDDocument();

  PDPageContentStream currentPage;

  private int fontSize;

  private int linesPerPage;

  private int currentPageLine;

  public ContactDirectoryPDFExporter(int linesPerPage, int fontSize){
    this.linesPerPage = linesPerPage;
    this.fontSize = fontSize;
    this.currentPageLine = 0;
    createNewPage();
  }
  public void addContact(ContactDirectory.Contact contact) {
    if (this.currentPageLine == this.linesPerPage) createNewPage();

    try {
      currentPage.newLine();
      currentPage.showText(contact.name + " -- " + contact.email+ " -- " + contact.phone);
      this.currentPageLine++;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void createNewPage(){
    try {
      if (currentPage != null) {
        currentPage.endText();
        currentPage.close();
      }
      this.currentPageLine = 0;
      PDPage page = new PDPage();
      document.addPage(page);
      currentPage = new PDPageContentStream(document, page);
      currentPage.setFont(PDType1Font.COURIER, fontSize);
      currentPage.setLeading(50);
      currentPage.beginText();
      currentPage.newLineAtOffset(100, 700);
      currentPage.showText("Name -- Email -- Phone");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void buildPDF(String pdfFile){
    try {
      currentPage.endText();
      currentPage.close();
      document.save(pdfFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
