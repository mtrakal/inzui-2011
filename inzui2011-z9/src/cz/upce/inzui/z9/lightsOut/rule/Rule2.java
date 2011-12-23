package cz.upce.inzui.z9.lightsOut.rule;

import cz.upce.inzui.z9.algorithm.IRule;
import cz.upce.inzui.z9.lightsOut.LightsOut;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaciš
 */
public class Rule2 extends Rule {

    public Rule2(String nameRule) {
        super(nameRule);
    }

    public Rule2(String nameRule, Point point) {
        super(nameRule, point);
    }

    @Override
    public List<LightsOut> evaluateRule(LightsOut current, LightsOut goal) {
        return super.evaluateRule(current, -1, 0);
    }

    @Override
    public IRule clone(Point point) {
        return new Rule2(super.getNameRule(), point);
    }
}
