package cz.upce.inzui.z9.algorithm;

/**
 *
 * @author Kaciš
 */
public interface IRule<E extends AbstractElement> {

    AbstractElement evaluateRule(E current, E goal);
}
