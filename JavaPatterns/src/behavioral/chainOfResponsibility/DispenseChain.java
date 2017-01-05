package behavioral.chainOfResponsibility;

/**
 * Created by Marina on 02.01.2017.
 */
public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency cur);
}
