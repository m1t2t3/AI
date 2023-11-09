package lab6;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		if (row < Node.N - 1) {
            row++;
        }
	}
//task1
	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
        return (row == q.row || column == q.column || Math.abs(row - q.row) == Math.abs(column - q.column));
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
