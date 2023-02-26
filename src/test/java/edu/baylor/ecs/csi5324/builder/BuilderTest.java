package edu.baylor.ecs.csi5324.builder;

import edu.baylor.ecs.csi5324.builder.solution.ContactDirectory;
import edu.baylor.ecs.csi5324.builder.solution.ContactDirectoryCSVImporter;
import edu.baylor.ecs.csi5324.builder.solution.ContactDirectoryXMLExporter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

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
		// consider ExcelBuilder (Apache POI)
		// consider PDFBuilder (Apache PDF Box)
		// consider RTFBuilder (Apache FOP)

		// XML
		ContactDirectoryXMLExporter xmlExporter = new ContactDirectoryXMLExporter();
		directory.construct(csvImporter, xmlExporter);
		StringWriter writer = new StringWriter();
		xmlExporter.buildXML(writer);
		String xmlProducedContent = writer.toString();
		try {
			String xmlOracleContent = new String(Files.readAllBytes(Paths.get("src/test/resources/ContactList.xml")));
			assertEquals(xmlProducedContent, xmlOracleContent);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		// * Pick on of these four
		// consider HTMLBuilder
		// consider MDBuilder (MarkDown http://markdown.tautua.org/)
		// consider PPTBuilder (https://www.baeldung.com/apache-poi-slideshow/)
		// consider DOCBuilder (https://www.baeldung.com/docx4j)
	}

}
