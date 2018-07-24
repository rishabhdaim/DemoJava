package javageeks.dp.visitor;

/**
 * Created by diam on 7/24/2018.
 */
public class Fuel implements ItemElement {

    private final int price;
    private final int quantity;
    private final String name;

    public Fuel(final int price, final int quantity, final String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
