/**
 * 
 */
package demo.java8.tutorialpoints.spring.batch;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author Rishabh.Daim
 *
 */
public class CustomItemProcessor implements ItemProcessor<Tutorial, Tutorial> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
	 */
	@Override
	public Tutorial process(Tutorial item) throws Exception {
		System.out.println("Processing..." + item);

		// Creating PDF document object
		File file = new File("test.pdf");
		if (!file.exists()) {
			file.createNewFile();
		}
		PDDocument doc = PDDocument.load(file);

		// Creating a blank page
		PDPage page = new PDPage();
		doc.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);

		String[][] content = { { "Id", "" + item.getTutorial_id() },
				{ "Title", item.getTutorial_title() },
				{ "Authour", item.getTutorial_author() },
				{ "Submission Date", item.getSubmission_date() } };
		
		drawTable(page, contentStream, 700, 100, content);

		contentStream.close();
		doc.save("test.pdf");
		System.out.println("Hello");
		return item;
	}

	@SuppressWarnings("deprecation")
	public static void drawTable(PDPage page, PDPageContentStream contentStream, float y, float margin, String[][] content) throws IOException {
		
		final int rows = content.length;
		final int cols = content[0].length;
		final float rowHeight = 50;
		final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
		final float tableHeight = rowHeight * rows;
		final float colWidth = tableWidth / (float) cols;
		final float cellMargin = 5f;

		// draw the rows
		float nexty = y;
		for (int i = 0; i <= rows; i++) {
			contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
			nexty -= rowHeight;
		}

		// draw the columns
		float nextx = margin;
		for (int i = 0; i <= cols; i++) {
			contentStream.drawLine(nextx, y, nextx, y - tableHeight);
			nextx += colWidth;
		}

		// now add the text
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

		float textx = margin + cellMargin;
		float texty = y - 15;
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content[i].length; j++) {
				String text = content[i][j];
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(textx, texty);
				contentStream.drawString(text);
				contentStream.endText();
				textx += colWidth;
			}
			texty -= rowHeight;
			textx = margin + cellMargin;
		}
	}
}
