package cz.upce.inzui.z9.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaciš
 */
public abstract class AbstractElement<E> implements Comparable<AbstractElement<E>> {

    protected E h;
    protected E g;
    protected AbstractElement<E> parent;
    protected IRule<AbstractElement<E>> usedRule;

    /**
     * Vrací seznam všech stavů, které mohou nastat podle seznamu pravidel.
     * @param rules Seznam pravidel.
     * @param goalState Cíloví stav.
     * @return Seznam stavů, které mohou nastat.
     */
    public List<AbstractElement<E>> expand(List<IRule<AbstractElement<E>>> rules, AbstractElement<E> goalState) {
        List<AbstractElement<E>> result = new ArrayList<AbstractElement<E>>();
        for (IRule<AbstractElement<E>> rule : rules) {
            AbstractElement<E> element = rule.evaluateRule(this, goalState);
            if (element != null) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Porovnává stavy prvků. Pokud jsou stejné vrací true.
     * @param obj
     * @return true pokud jsou stejné. False pokud nejsou.
     */
    @Override
    abstract public boolean equals(Object obj);

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.h != null ? this.h.hashCode() : 0);
        hash = 43 * hash + (this.g != null ? this.g.hashCode() : 0);
        hash = 43 * hash + (this.parent != null ? this.parent.hashCode() : 0);
        hash = 43 * hash + (this.usedRule != null ? this.usedRule.hashCode() : 0);
        return hash;
    }

    public E getG() {
        return g;
    }

    public E getH() {
        return h;
    }

    public AbstractElement<E> getParent() {
        return parent;
    }

    public IRule<AbstractElement<E>> getUsedRule() {
        return usedRule;
    }

    abstract public E getValueHeuristicFunction();
}
