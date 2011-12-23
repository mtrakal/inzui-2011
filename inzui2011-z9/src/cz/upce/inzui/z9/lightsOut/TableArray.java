package cz.upce.inzui.z9.lightsOut;

/**
 *
 * @author Kaciš
 */
public class TableArray {

    private boolean[][] array;
    private int capacityX;
    private int capacityY;

    public TableArray(int capacity) {
        this.init(capacity, capacity);
    }

    public TableArray(int capacityY, int capacityX) {
        this.init(capacityY, capacityX);
    }

    private void init(int capacityY, int capacityX) {
        if (capacityY <= 0) {
            capacityY = 1;
        }
        if (capacityX <= 0) {
            capacityX = 1;
        }
        this.array = new boolean[capacityY][capacityX];

        this.capacityX = capacityX;
        this.capacityY = capacityY;
    }

    public void set(boolean element) {
        for (int y = 0; y < this.capacityY; y++) {
            for (int x = 0; x < this.capacityX; x++) {
                this.array[y][x] = element;
            }
        }
    }

    public void set(boolean element, int indexX, int indexY) {
        this.array[indexY][indexX] = element;
    }

    public boolean get(int indexX, int indexY) {
        return this.array[indexY][indexX];
    }

    public int getCapacityX() {
        return capacityX;
    }

    public int getCapacityY() {
        return capacityY;
    }

    @Override
    protected TableArray clone() {
        TableArray result = new TableArray(this.capacityY, this.capacityX);
        for (int y = 0; y < this.capacityY; y++) {
            for (int x = 0; x < this.capacityX; x++) {
                result.set(this.get(x, y), x, y);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TableArray)) {
            return false;
        }
        TableArray temp = (TableArray) obj;
        for (int y = 0; y < this.capacityY; y++) {
            for (int x = 0; x < this.capacityX; x++) {
                if (this.get(x, y) != temp.get(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
