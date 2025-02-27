/**
 * 
 */
package demo.java8.javageeks.dp.memento;

/**
 * @author rishabh.daim
 * 
 */
public class FileWriterCaretaker {

	private Object obj;

	public void save(FileWriterUtil fileWriter) {
		this.obj = fileWriter.save();
	}

	public void undo(FileWriterUtil fileWriter) {
		fileWriter.undoToLastSave(obj);
	}
}