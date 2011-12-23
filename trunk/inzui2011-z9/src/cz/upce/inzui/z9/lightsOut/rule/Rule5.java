package cz.upce.inzui.z9.lightsOut.rule;

import cz.upce.inzui.z9.algorithm.IRule;
import cz.upce.inzui.z9.lightsOut.LightsOut;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author Kaciš
 */
public class Rule5 extends Rule {

    public Rule5(String nameRule) {
        super(nameRule);
    }

    public Rule5(String nameRule, Point point) {
        super(nameRule, point);
    }

    @Override
    public List<LightsOut> evaluateRule(LightsOut current, LightsOut goal) {
        return super.evaluateRule(current, 0, 1);
    }

    @Override
    public IRule clone(Point point) {
        return new Rule5(super.getNameRule(), point);
    }
}
