package cz.upce.inzui.z9.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Kaciš
 */
public class AStar {

    private PriorityQueue<AbstractElement> open;
    private List<AbstractElement> close;
    private AbstractElement startingState;
    private AbstractElement goalState;
    private List<IRule> rules;
    private int countState;
    private int countExpandedState;

    public AStar(AbstractElement startingState, AbstractElement goalState, List<IRule> rules) {
        this.open = new PriorityQueue<AbstractElement>();
        this.close = new ArrayList<AbstractElement>();
        this.startingState = startingState;
        this.goalState = goalState;
        this.rules = rules;

        this.open.add(this.startingState);
        this.countState = 1;
        this.countExpandedState = 0;
    }

    public boolean step() {
        if (this.open.isEmpty()) {
            return false;
        }
        this.countExpandedState++;
        AbstractElement expand = this.open.poll();
        this.close.add(expand);

        List<AbstractElement> newStates = expand.expand(this.rules, this.goalState);

        this.addOpen(newStates);
        if (expand.equals(this.goalState)) {
            this.goalState = expand;
            return false;
        }
        return true;
    }

    /**
     * Počet expandovaných stavů.
     * @return Počet expandovaných stavů.
     */
    public int getCountState() {
        return countState;
    }

    public int getCountExpandedState() {
        return countExpandedState;
    }

    public AbstractElement getGoalState() {
        return this.goalState;
    }

    public List<IRule> getSolution() {
        List<IRule> result = new ArrayList<IRule>();
        AbstractElement current = this.goalState;
        while (current.getParent() != null) {
            result.add(0, current.getUsedRule());
            current = current.getParent();
        }
        return result;
    }

    /**
     * Vkládá nové stavy do paměti open.
     * @param newStates Seznam nových stavů.
     */
    private void addOpen(List<AbstractElement> newStates) {
        newStates = this.checkMemory(newStates, this.open);
        newStates = this.checkMemory(newStates, this.close);
        this.countState += newStates.size();
        this.open.addAll(newStates);
    }

    /**
     * Kontroluje zda nové stavy nejsou obsažene v paměti.
     * @param newStates Seznam nových stavů.
     * @param collection Paměť který se má kontrolovat.
     * @return Vrací seznam stavů, které nejsou obsažené v paměti.
     */
    private List<AbstractElement> checkMemory(List<AbstractElement> newStates, Collection<AbstractElement> collection) {
        List<AbstractElement> copyNextState = new ArrayList<AbstractElement>(newStates);
        copyNextState.retainAll(collection);

        Collection<AbstractElement> copyCollection = new PriorityQueue<AbstractElement>(collection);
        copyCollection.retainAll(newStates);

        Collection<AbstractElement> delete = new ArrayList<AbstractElement>();
        for (AbstractElement o : copyCollection) {
            for (AbstractElement n : copyNextState) {
                if (o.equals(n) && o.compareTo(n) > 0) {
                    delete.add(n);
                    break;
                }
            }
        }
        copyCollection.removeAll(delete);

        collection.removeAll(delete);
        newStates.removeAll(copyCollection);

        return newStates;
    }
}
