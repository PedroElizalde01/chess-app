package tile;

import org.jetbrains.annotations.NotNull;

public class Position implements Comparable<Position> {

    private final int row;
    private final int column;

    public Position(int row,int column) {
        this.row = row;
        this.column = column;
    }

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }

    @Override
    public int compareTo(@NotNull Position pos) {
        if (pos.row() == this.row() && pos.column() == this.column()) return 0;
        return 1;
    }
}
