package edu.baylor.ecs.csi5324.builder.solution;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ContactDirectoryExcelExporter implements ContactDirectory.Exporter{
  private Workbook workbook = new XSSFWorkbook();

  private Sheet sheet = workbook.createSheet("Contacts");;

  private int rowCounter = 0;

  public ContactDirectoryExcelExporter(){
    createRowWithValues("Name", "Email", "Phone");
  }
  public void addContact(ContactDirectory.Contact contact) {
    createRowWithValues(contact.name, contact.email, contact.phone);
  }

  private void createRowWithValues(String... values){
    Row row = sheet.createRow(rowCounter++);
    for (int i =0; i < values.length; i++){
      Cell headerCell = row.createCell(i);
      headerCell.setCellValue(values[i]);
    }
  }

  public void buildXLSX(FileOutputStream outputStream){
    try {
      workbook.write(outputStream);
      workbook.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
