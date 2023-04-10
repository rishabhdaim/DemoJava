/**
 * 
 */
package demo.java.javageeks.dp.chainofresponsibility;

/**
 * @author Rishabh.Daim
 *
 */
public interface Handler {

	public void setHandler(Handler handler);

	public void process(File file);

	public String getHandlerName();
}
