/**
 * 
 */
package javageeks.dp.chainofresponsibility;

/**
 * @author Rishabh.Daim
 *
 */
public class TestChainofResponsibility {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = null;
		final Handler textHandler = new TextFileHandler("Text Handler");
		final Handler docHandler = new DocFileHandler("Doc Handler");
		final Handler excelHandler = new ExcelFileHandler("Excel Handler");
		final Handler audioHandler = new AudioFileHandler("Audio Handler");
		final Handler videoHandler = new VideoFileHandler("Video Handler");
		final Handler imageHandler = new ImageFileHandler("Image Handler");
		
		textHandler.setHandler(docHandler);
		docHandler.setHandler(excelHandler);
		excelHandler.setHandler(audioHandler);
		audioHandler.setHandler(videoHandler);
		videoHandler.setHandler(imageHandler);

		file = new File("Abc.mp3", "audio", "C:");
		textHandler.process(file);
		System.out.println();
		file = new File("Abc.jpg", "video", "C:");
		textHandler.process(file);
		System.out.println();
		file = new File("Abc.doc", "doc", "C:");
		textHandler.process(file);
		System.out.println();
		file = new File("Abc.bat", "bat", "C:");
		textHandler.process(file);
		System.out.println();
	}

}
