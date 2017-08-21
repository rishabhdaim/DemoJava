/**
 * 
 */
package javageeks.dp.chainofresponsibility;

import java.util.Objects;

/**
 * @author Rishabh.Daim
 *
 */
public class TextFileHandler implements Handler {

	private Handler handler;
	private final String handlerName;
	
	/**
	 * @param handlerName
	 */
	public TextFileHandler(String handlerName) {
		this.handlerName = handlerName;
	}

	@Override
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void process(File file) {
		if (Objects.equals(file.getFileType(), "text")) {
			System.out.println("Saving and processing file via : " + handlerName);
		} else if (handler != null) {
			System.out.println("Delegating request for file " + file.getFileName() + " to " + handler.getHandlerName());
			handler.process(file);
		} else {
			System.err.println("File not supported");
		}
	}

	@Override
	public String getHandlerName() {
		return handlerName;
	}
}
