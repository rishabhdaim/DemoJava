/**
 * 
 */
package demo.java8.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public class TestFactoryMethodPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DisplayService service = new FeedbackXMLDisplayService();
		service.display();
		service = new ErrorXMLDisplayService();
		service.display();
		service = new OrderXMLDisplayService();
		service.display();
		service = new ResponseXMLDisplayService();
		service.display();
	}
}
