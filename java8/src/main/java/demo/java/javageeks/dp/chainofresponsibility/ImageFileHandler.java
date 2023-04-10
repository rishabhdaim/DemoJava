/**
 * 
 */
package demo.java.javageeks.dp.chainofresponsibility;

import java.util.Objects;

/**
 * @author Rishabh.Daim
 *
 */
public class ImageFileHandler implements Handler {

	private Handler handler;
	private final String handlerName;

	public ImageFileHandler(String handlerName) {
		this.handlerName = handlerName;
	}

	@Override
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void process(File file) {
		if (Objects.equals("image", file.getFileType())) {
			System.out.println("Process and saving audio file... by "
					+ handlerName);
		} else if (handler != null) {
			System.out.println(handlerName + " fowards request to "
					+ handler.getHandlerName());
			handler.process(file);
		} else {
			System.out.println("File not supported");
		}
	}

	@Override
	public String getHandlerName() {
		return handlerName;
	}
}
