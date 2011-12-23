package cz.upce.inzui.z9.algorithm;

import java.util.List;

/**
 *
 * @author Kaciš
 */
public interface IRule<E extends AbstractElement> {

    List<E> evaluateRule(E current, E goal);
}
