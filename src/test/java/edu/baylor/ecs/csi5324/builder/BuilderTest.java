package edu.baylor.ecs.csi5324.builder;

import org.junit.jupiter.api.Test;

class BuilderTest {

	@Test
	void test() {
		/**
		 * This needs a lot to improve
		 */
		Contact c = null;

		c = new Contact(new ContactSwingImporter());
//				c = new Contact(new ContactTextImporter());
		System.out.println("Contact: " + c);
		ContactHTMLExporter html = new ContactHTMLExporter();
		c.export(html);
		System.out.println("HTML:");
		System.out.println(html);
		ContactCSVExporter csv = new ContactCSVExporter();
		c.export(csv);
		System.out.println("CSV:\n" + csv);
		System.out.println("Starting gui display...");
		GUIExporter gui = new GUIExporter();
		c.export(gui);
		new SwingDisplay(gui.getJPanel());

		// Input CSV file with multiple lines
		// consider CSV file parser (Apache Commons CSV) - everyone

		// * All from the below
		// consider ExcelBuilder (Apache POI)
		// consider PDFBuilder (Apache PDF Box)
		// consider RTFBuilder (Apache FOP)
		// consider XMLBuilder (JAXB)

		// * Pick on of these four
		// consider HTMLBuilder
		// consider MDBuilder (MarkDown http://markdown.tautua.org/)
		// consider PPTBuilder (https://www.baeldung.com/apache-poi-slideshow/)
		// consider DOCBuilder (https://www.baeldung.com/docx4j)
	}

}
