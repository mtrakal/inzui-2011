package cz.upce.inzui.z9.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kaciš
 */
public abstract class AbstractElement<E> implements Comparable<AbstractElement<E>> {

    private E h;
    private E g;
    private AbstractElement<E> parent;
    private IRule<AbstractElement<E>> usedRule;

    public AbstractElement(E h, E g, AbstractElement<E> parent, IRule<AbstractElement<E>> usedRule) {
        this.h = h;
        this.g = g;
        this.parent = parent;
        this.usedRule = usedRule;
    }

    /**
     * Vrací seznam všech stavů, které mohou nastat podle seznamu pravidel.
     * @param rules Seznam pravidel.
     * @param goalState Cíloví stav.
     * @return Seznam stavů, které mohou nastat.
     */
    public List<AbstractElement<E>> expand(List<IRule<AbstractElement<E>>> rules, AbstractElement<E> goalState) {
        List<AbstractElement<E>> result = new ArrayList<AbstractElement<E>>();
        for (IRule<AbstractElement<E>> rule : rules) {
            List<AbstractElement<E>> elements = rule.evaluateRule(this, goalState);
            if (elements != null) {
                for (Iterator<AbstractElement<E>> it = elements.iterator(); it.hasNext();) {
                    AbstractElement<E> element = it.next();
                    if (!result.contains(element)) {
                        result.add(element);
                    }

                }
//                result.addAll(element);
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

    protected void setG(E g) {
        this.g = g;
    }

    protected void setH(E h) {
        this.h = h;
    }

    protected void setParent(AbstractElement<E> parent) {
        this.parent = parent;
    }

    protected void setUsedRule(IRule<AbstractElement<E>> usedRule) {
        this.usedRule = usedRule;
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
