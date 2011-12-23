package cz.upce.inzui.z9.lightsOut;

import cz.upce.inzui.z9.algorithm.AbstractElement;
import cz.upce.inzui.z9.algorithm.IRule;
import java.awt.Point;

/**
 *
 * @author Kaciš
 */
public class LightsOut extends AbstractElement<Integer> {

    private TableArray table;

    public LightsOut(int sizeTable) {
        super(0, 0, null, null);
        this.table = new TableArray(sizeTable);
        this.table.set(false);
    }

    public LightsOut(int capacityY, int capacityX) {
        super(0, 0, null, null);
        this.table = new TableArray(capacityY, capacityX);
        this.table.set(false);
    }

    public LightsOut(LightsOut parent, TableArray table, Point mark, IRule usedRule) {
        super(0, 0, parent, null);
        this.table = table.clone();
        super.setParent(parent);
        super.setG(super.getParent().getG() + 1);
        this.mark(mark, this.table);
        super.setUsedRule(usedRule);
        super.setH(this.countH());
    }

    public TableArray getTable() {
        return this.table;
    }

    @Override
    public String toString() {
        String result = "";
        for (int y = 0; y < this.table.getCapacityY(); y++) {
            for (int x = 0; x < this.table.getCapacityY(); x++) {
                if (this.table.get(x, y)) {
                    result += "1 ";
                } else {
                    result += "0 ";
                }
            }
            result += "\n";
        }
        result += "g()=" + super.getG() + ", h()=" + super.getH() + ", cena=" + this.getValueHeuristicFunction() + "\n";
        if (super.getUsedRule() != null) {
            result += super.getUsedRule().toString() + "\n";
        }
        return result;
    }

    public void edit(Point point) {
        if (point.x >= 0 && point.x < this.table.getCapacityX() && point.y >= 0 && point.y < this.table.getCapacityY()) {
            this.table.set(!this.table.get(point.x, point.y), point.x, point.y);
        }
    }

    public void mark(Point point) {
        this.mark(point, this.table);
    }

    private int countH() {
        int count = 0;
        boolean is = true;

        TableArray temp = this.table.clone();
        for (int y = 0; y < temp.getCapacityY(); y++) {
            for (int x = 0; x < temp.getCapacityX(); x++) {
                if (this.isMask(new Point(x, y), temp)) {
                    this.mark(new Point(x, y), temp);
                    is = false;
                }
            }
        }

        for (int y = 0; y < temp.getCapacityY(); y++) {
            for (int x = 0; x < temp.getCapacityX(); x++) {
                if (temp.get(x, y)) {
                    count++;
                }
            }
        }
        if (count == 0 && is) {
            count = -1;
        }
        return count;
    }

    private void mark(Point point, TableArray array) {
        if (point.y - 1 >= 0) {
            array.set(!array.get(point.x, point.y - 1), point.x, point.y - 1);
        }
        if (point.x - 1 >= 0) {
            array.set(!array.get(point.x - 1, point.y), point.x - 1, point.y);
        }
        if (point.y + 1 < array.getCapacityY()) {
            array.set(!array.get(point.x, point.y + 1), point.x, point.y + 1);
        }
        if (point.x + 1 < array.getCapacityX()) {
            array.set(!array.get(point.x + 1, point.y), point.x + 1, point.y);
        }
        array.set(!array.get(point.x, point.y), point.x, point.y);
    }

    private boolean isMask(Point point, TableArray array) {
        if (point.y - 1 >= 0) {
            if (!array.get(point.x, point.y - 1)) {
                return false;
            }
        }
        if (point.x - 1 >= 0) {
            if (!array.get(point.x - 1, point.y)) {
                return false;
            }
        }
        if (point.y + 1 < array.getCapacityY()) {
            if (!array.get(point.x, point.y + 1)) {
                return false;
            }
        }
        if (point.x + 1 < array.getCapacityX()) {
            if (!array.get(point.x + 1, point.y)) {
                return false;
            }
        }
        if (!array.get(point.x, point.y)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LightsOut)) {
            return false;
        }
        LightsOut temp = (LightsOut) obj;
        return this.table.equals(temp.getTable());
    }

    @Override
    public Integer getValueHeuristicFunction() {
        return super.getG() + super.getH();
    }

    @Override
    public int compareTo(AbstractElement<Integer> o) {
        return this.getValueHeuristicFunction().compareTo(o.getValueHeuristicFunction());
    }
}
