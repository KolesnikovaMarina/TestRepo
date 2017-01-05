package behavioral.visitor;

/**
 * Created by Marina on 03.01.2017.
 */
 public interface ItemElement {
    public int accept(ShoppingCartVisitor visitor);
}
