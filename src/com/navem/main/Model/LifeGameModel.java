package com.navem.main.Model;

import javax.swing.JFrame;

public class LifeGameModel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int filas;
	private final int cols;
	private final boolean[][] cells;

	public LifeGameModel(int rows, int cols) {
		this.filas = rows;
		this.cols = cols;
		this.cells = new boolean[rows][cols];
	}

	public void setCell(int fila, int col, boolean value) {
		cells[fila][col] = value;
	}

	// Conteo de vecinos que tiene cada celda
	private int countNeighbors(int row, int col) {
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0)
					continue;
				int newRow = (row + i + filas) % filas;
				int newCol = (col + j + cols) % cols;
				if (cells[newRow][newCol]) {
					count++;
				}
			}
		}
		return count;
	}

	public void evolve() {
		boolean[][] newCells = new boolean[filas][cols];

		// Calcular el nuevo estado de cada célula en función de los estados de sus
		// vecinos
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < cols; j++) {
				int neighbors = countNeighbors(i, j);
				if (cells[i][j]) {
					// Regla 1: Muere por soledad si tiene menos de dos vecinos vivos
					if (neighbors < 2) {
						newCells[i][j] = false;
					}
					// Regla 2: Sobrevive si tiene dos o tres vecinos vivos
					else if (neighbors == 2 || neighbors == 3) {
						newCells[i][j] = true;
					}
					// Regla 3: Muere por superpoblación si tiene más de tres vecinos vivos
					else {
						newCells[i][j] = false;
					}
				} else {
					// Regla 4: Nace una nueva célula si tiene exactamente tres vecinos vivos
					if (neighbors == 3) {
						newCells[i][j] = true;
					}
				}
			}
		}

		// Actualizar el estado de las células con los nuevos estados calculados
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < cols; j++) {
				cells[i][j] = newCells[i][j];
			}
		}
	}

	public boolean[][] getCells() {
		return cells;
	}

	public int getFilas() {
		return filas;
	}

	public int getCols() {
		return cols;
	}
	/*
	 * PATRONES DE MODELOS DE LIFEGAME
	 * 
	 * 
	 */

	public void setGosperGliderGunPattern(int row, int col) {
		if (row + 9 >= filas || col + 36 >= cols) {
			throw new IllegalArgumentException("El Patron excede la tabla");
		}

		cells[row][col + 24] = true;
		cells[row + 1][col + 22] = true;
		cells[row + 1][col + 24] = true;
		cells[row + 2][col + 12] = true;
		cells[row + 2][col + 13] = true;
		cells[row + 2][col + 20] = true;
		cells[row + 2][col + 21] = true;
		cells[row + 2][col + 34] = true;
		cells[row + 2][col + 35] = true;
		cells[row + 3][col + 11] = true;
		cells[row + 3][col + 15] = true;
		cells[row + 3][col + 20] = true;
		cells[row + 3][col + 21] = true;
		cells[row + 3][col + 34] = true;
		cells[row + 3][col + 35] = true;
		cells[row + 4][col + 0] = true;
		cells[row + 4][col + 1] = true;
		cells[row + 4][col + 10] = true;
		cells[row + 4][col + 16] = true;
		cells[row + 4][col + 20] = true;
		cells[row + 4][col + 21] = true;
		cells[row + 5][col + 0] = true;
		cells[row + 5][col + 1] = true;
		cells[row + 5][col + 10] = true;
		cells[row + 5][col + 14] = true;
		cells[row + 5][col + 16] = true;
		cells[row + 5][col + 17] = true;
		cells[row + 5][col + 22] = true;
		cells[row + 5][col + 24] = true;
		cells[row + 6][col + 10] = true;
		cells[row + 6][col + 16] = true;
		cells[row + 6][col + 24] = true;
		cells[row + 7][col + 11] = true;
		cells[row + 7][col + 15] = true;
		cells[row + 8][col + 12] = true;
		cells[row + 8][col + 13] = true;
	}

	public void setDiehardPattern(int row, int col) {
		if (row + 3 >= filas || col + 8 >= cols) {
			throw new IllegalArgumentException("El Patron excede la tabla");
		}

		cells[row + 1][col + 1] = true;
	    cells[row + 1][col + 2] = true;
	    cells[row + 2][col + 2] = true;
	    cells[row][col + 7] = true;
	    cells[row + 2][col + 6] = true;
	    cells[row + 2][col + 7] = true;
	    cells[row + 2][col + 8] = true;
	}

	public void setGliderPattern(int row, int col) {
		if (row + 2 >= filas || col + 2 >= cols) {
			throw new IllegalArgumentException("El Patron excede la tabla");
		}

		cells[row][col + 1] = true;
		cells[row + 1][col + 2] = true;
		cells[row + 2][col] = true;
		cells[row + 2][col + 1] = true;
		cells[row + 2][col + 2] = true;
	}
	
	public void setRightMovingSpaceshipPattern(int row, int col) {
	    if (row + 4 >= filas || col + 9 >= cols) {
	        throw new IllegalArgumentException("El Patron excede la tabla");
	    }

	    cells[row][col + 1] = true;
	    cells[row + 1][col + 2] = true;
	    cells[row + 2][col] = true;
	    cells[row + 2][col + 1] = true;
	    cells[row + 2][col + 2] = true;
	}
	
	public void setMovingPattern(int row, int col) {
	    if (row + 4 >= filas || col + 9 >= cols) {
	        throw new IllegalArgumentException("El Patron excede la tabla");
	    }

	    cells[row + 2][col + 1] = true;
	    cells[row + 2][col + 5] = true;
	    cells[row + 3][col] = true;
	    cells[row + 3][col + 4] = true;
	    cells[row + 4][col] = true;
	    cells[row + 4][col + 1] = true;
	    cells[row + 4][col + 2] = true;
	    cells[row + 4][col + 3] = true;
	    cells[row + 3][col + 8] = true;
	    cells[row + 4][col + 8] = true;
	    cells[row + 5][col + 8] = true;
	}

	public void setBlinkerPattern(int row, int col) {
		if (row + 2 >= filas || col + 3 >= cols) {
			throw new IllegalArgumentException("El Patron excede la tabla");
		}

		cells[row][col] = true;
		cells[row][col + 1] = true;
		cells[row][col - 1] = true;
	}

	
	public void setSpaceshipPattern(int row, int col) {
		if (row + 4 >= filas || col + 6 >= cols) {
	        throw new IllegalArgumentException("El Patron excede la tabla");
	    }

		cells[row + 1][col + 1] = true;
	    cells[row + 1][col + 4] = true;
	    cells[row + 2][col + 5] = true;
	    cells[row + 3][col] = true;
	    cells[row + 3][col + 4] = true;
	    cells[row + 4][col + 1] = true;
	    cells[row + 4][col + 2] = true;
	    cells[row + 4][col + 3] = true;
	    cells[row + 4][col + 4] = true;
	}

	public void setToadPattern(int row, int col) {
		if (row + 3 >= filas || col + 2 >= cols) {
			throw new IllegalArgumentException("El Patron excede la tabla");
		}

		cells[row][col + 1] = true;
		cells[row][col + 2] = true;
		cells[row][col + 3] = true;
		cells[row + 1][col] = true;
		cells[row + 1][col + 1] = true;
		cells[row + 1][col + 2] = true;
	}

	public void setBlockPattern(int row, int col) {
		if (row + 1 >= filas || col + 1 >= cols) {
			throw new IllegalArgumentException("El Patron excede la tabla");
		}

		cells[row][col] = true;
		cells[row][col + 1] = true;
		cells[row + 1][col] = true;
		cells[row + 1][col + 1] = true;
	}

	public void setTubPattern(int row, int col) {
		if (row + 2 >= filas || col + 2 >= cols) {
			throw new IllegalArgumentException("El Patron excede la tabla");
		}

		cells[row + 1][col] = true;
		cells[row][col + 1] = true;
		cells[row + 2][col + 1] = true;
		cells[row + 1][col + 2] = true;
	}

}
