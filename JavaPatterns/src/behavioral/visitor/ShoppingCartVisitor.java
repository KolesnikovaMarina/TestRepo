package behavioral.visitor;

/**
 * Created by Marina on 03.01.2017.
 */
public interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}

