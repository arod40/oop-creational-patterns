package edu.baylor.ecs.csi5324.builder;

import com.google.common.io.Files;
import edu.baylor.ecs.csi5324.builder.solution.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.*;

class BuilderTest {

	@Test
	void test() {
		/**
		 * This needs a lot to improve
		 */
//		Contact c = null;
//
//		c = new Contact(new ContactSwingImporter());
////				c = new Contact(new ContactTextImporter());
//		System.out.println("Contact: " + c);
//		ContactHTMLExporter html = new ContactHTMLExporter();
//		c.export(html);
//		System.out.println("HTML:");
//		System.out.println(html);
//		ContactCSVExporter csv = new ContactCSVExporter();
//		c.export(csv);
//		System.out.println("CSV:\n" + csv);
//		System.out.println("Starting gui display...");
//		GUIExporter gui = new GUIExporter();
//		c.export(gui);
//		new SwingDisplay(gui.getJPanel());

		// ContactDirectory (Director role in Builder pattern)
		ContactDirectory directory = new ContactDirectory();

		// Input CSV file with multiple lines
		String csvPath = "src/test/resources/ContactList.csv";
		ContactDirectoryCSVImporter csvImporter = new ContactDirectoryCSVImporter(csvPath);

		// * All from the below
		// XLSX (Excel)
		ContactDirectoryExcelExporter xlsExporter = new ContactDirectoryExcelExporter();
		directory.construct(csvImporter, xlsExporter);
		try {
			FileOutputStream outputStream = new FileOutputStream("src/test/resources/ContactList.xlsx");
			xlsExporter.buildXLSX(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
//		compareFiles("src/test/resources/ContactList.xlsx", "src/test/resources/ContactListOracle.xlsx");

		// PDF
		ContactDirectoryPDFExporter pdfExporter = new ContactDirectoryPDFExporter(2, 20);
		directory.construct(csvImporter, pdfExporter);
		pdfExporter.buildPDF("src/test/resources/ContactList.pdf");
//		compareFiles("src/test/resources/ContactList.pdf", "src/test/resources/ContactListOracle.pdf");


		// consider RTFBuilder (Apache FOP)

		// XML
		ContactDirectoryXMLExporter xmlExporter = new ContactDirectoryXMLExporter();
		directory.construct(csvImporter, xmlExporter);
		try {
			OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream("src/test/resources/ContactList.xlsx"));
			xmlExporter.buildXML(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		compareFiles("src/test/resources/ContactList.xml", "src/test/resources/ContactListOracle.xml");



		// * Pick on of these four
		// consider HTMLBuilder
		// consider MDBuilder (MarkDown http://markdown.tautua.org/)
		// consider PPTBuilder (https://www.baeldung.com/apache-poi-slideshow/)
		// consider DOCBuilder (https://www.baeldung.com/docx4j)

	}

	private void compareFiles(String f1, String f2) {
		File file1 = new File(f1);
		File file2 = new File(f2);
		try {
			assertTrue(Files.equal(file1, file2));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
