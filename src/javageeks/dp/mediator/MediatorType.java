/**
 * 
 */
package javageeks.dp.mediator;

/**
 * @author Rishabh.Daim
 *
 */
enum MediatorType {
	
	COTTON("Cotton Clothes"), DENIM("Denim Clothes"), SILK("Silk Clothes");
	
	private String name;

	private MediatorType(final String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
