/**
 * 
 */
package demo.java.javageeks.dp.memento;

/**
 * @author rishabh.daim
 * 
 */
public class FileWriterUtil {
	private String fileName;
	private StringBuilder content;

	/**
	 * @param fileName
	 * @param content
	 */
	public FileWriterUtil(String fileName) {
		super();
		this.fileName = fileName;
		this.content = new StringBuilder();
	}

	public void write(String str) {
		content.append(str);
	}

	public Memento save() {
		return new Memento(this.fileName, this.content);
	}

	public void undoToLastSave(Object obj) {
		Memento memento = (Memento) obj;
		this.fileName = memento.fileName;
		this.content = memento.content;
	}

	/**
	 * @author rishabh.daim
	 * 
	 */
	private class Memento {
		private String fileName;
		private StringBuilder content;

		public Memento(String fileName, StringBuilder content) {
			this.fileName = fileName;
			// notice the deep copy so that Memento and FileWriterUtil content
			// variables don't refer to same object
			this.content = new StringBuilder(content);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileWriterUtil [fileName=" + fileName + ", content="
				+ content.toString() + "]";
	}
}