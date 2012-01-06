/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.inzui.z9.lightsOut;

import cz.upce.inzui.z9.algorithm.AStar;
import cz.upce.inzui.z9.algorithm.IRule;
import cz.upce.inzui.z9.lightsOut.rule.Rule1;
import cz.upce.inzui.z9.lightsOut.rule.Rule2;
import cz.upce.inzui.z9.lightsOut.rule.Rule3;
import cz.upce.inzui.z9.lightsOut.rule.Rule4;
import cz.upce.inzui.z9.lightsOut.rule.Rule5;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kaciš
 */
public class test {

    public static void main(String[] args) {
        LightsOut goalState = new LightsOut(5, 6);
        LightsOut startingState = new LightsOut(5, 6);
        startingState.edit(new Point(0, 0));

        System.out.println(startingState);

        List<IRule> rules = new ArrayList<IRule>();
        rules.add(new Rule1("Klikni na svitící."));
        rules.add(new Rule2("Klikni vlevo od svitící."));
        rules.add(new Rule3("Klikni vpravo od svitící."));
        rules.add(new Rule4("Klikni nad svitící."));
        rules.add(new Rule5("Klikni pod svitící."));

        AStar as = new AStar(startingState, goalState, rules);

        do {
        } while (as.step());

        System.out.println("Počet expandovaných stavů: " + as.getCountExpandedState());
        System.out.println("Počet stavů: " + as.getCountState());
        for (Iterator<IRule> it = as.getSolution().iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
        if (as.getSolution().isEmpty()) {
            System.out.println("Nemá řešení.");
        }
    }
}
