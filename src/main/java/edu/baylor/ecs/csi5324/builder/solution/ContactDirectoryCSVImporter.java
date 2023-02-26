package edu.baylor.ecs.csi5324.builder.solution;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ContactDirectoryCSVImporter implements ContactDirectory.Importer {
  private String csvPath;
  private Reader in;
  private Iterable<CSVRecord> records;
  String[] HEADERS = { "name", "email", "phone"};
  public ContactDirectoryCSVImporter(String csvPath) throws IOException {
    this.csvPath = csvPath;
  }
  private ContactDirectory.Contact _mapCsvRecordToContact(CSVRecord record){
    return new ContactDirectory.Contact(
        record.get("name"),
        record.get("email"),
        record.get("phone")
    );
  }

  public Iterable<ContactDirectory.Contact> provideContacts() {
    Stream stream = StreamSupport.stream(this.records.spliterator(), false)
        .map(this::_mapCsvRecordToContact);
    return stream::iterator;
  }

  public void open() {
    Reader in = null;
    try {
      in = new FileReader(csvPath);
    } catch (FileNotFoundException e) {
      throw new RuntimeException("The CSV file provided could not be opened.");
    }

    CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
        .setHeader(HEADERS)
        .setSkipHeaderRecord(true)
        .build();

    try {
      this.records = csvFormat.parse(in);
    } catch (IOException e) {
      throw new RuntimeException("There was a problem parsing the CSV file.");
    }
  }

  public void close() {
    try {
      this.in.close();
    } catch (IOException e) {
      throw new RuntimeException("The FileReader associated with the CSV file could not be closed");
    }
  }
}
