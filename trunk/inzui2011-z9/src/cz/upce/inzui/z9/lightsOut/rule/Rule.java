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
public abstract class Rule implements IRule<LightsOut> {

    private String nameRule;
    private Point point;

    public Rule(String nameRule) {
        this.nameRule = nameRule;
    }

    public Rule(String nameRule, Point point) {
        this.nameRule = nameRule;
        this.point = point;
    }

    @Override
    public String toString() {
        return this.nameRule + " [" + this.point.x + "," + this.point.y + "]";
    }

    public Point getPoint() {
        return point;
    }

    public String getNameRule() {
        return nameRule;
    }

    @Override
    public abstract List<LightsOut> evaluateRule(LightsOut current, LightsOut goal);

    protected List<LightsOut> evaluateRule(LightsOut current, int dX, int dY) {
        List<LightsOut> result = new ArrayList<LightsOut>();

        for (int y = 0; y < current.getTable().getCapacityY(); y++) {
            for (int x = 0; x < current.getTable().getCapacityX(); x++) {
                if (x + dX >= 0 && x + dX < current.getTable().getCapacityX()
                        && y + dY >= 0 && y + dY < current.getTable().getCapacityY()) {
                    if (current.getTable().get(x, y)) {
                        Point tempPoint = new Point(x + dX, y + dY);
                        if (!this.isUsed(tempPoint, current)) {
                            LightsOut temp = new LightsOut(current, current.getTable(), tempPoint, this.clone(tempPoint));
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }

    public abstract IRule clone(Point point);

    private boolean isUsed(Point tempPoint, LightsOut current) {
        while (current != null) {
            IRule usedRule = current.getUsedRule();
            if (usedRule != null) {
                if (((Rule) usedRule).getPoint().equals(tempPoint)) {
                    return true;
                }
            }
            current = (LightsOut) current.getParent();
        }
        return false;
    }
}
