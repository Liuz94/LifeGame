package com.navem.main.View;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.navem.main.Model.LifeGameModel;

public class LifeGameView extends JPanel {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private final LifeGameModel model;
	private final int cellSize;

	public LifeGameView(int rows, int cols, int cellSize) {
		this.model = new LifeGameModel(rows, cols);
		this.cellSize = cellSize;
	}

	// Se pinta las celdas dependiendo si estan vivas o muertas
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		boolean[][] cells = model.getCells();

		for (int i = 0; i < model.getFilas(); i++) {
			for (int j = 0; j < model.getCols(); j++) {
				Color cellColor = cells[i][j] ? Color.BLACK : Color.WHITE;
				g.setColor(cellColor);
				g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
			}
		}
	}

	// Inicia el juego y ponemos un timer para las actualizaciones
	public void startGameLoop() {
		Timer timer = new Timer(100, e -> {
			model.evolve();
			repaint(); // Vuelve a pintar la vista en cada actualización
		});
		timer.start();
	}

	public LifeGameModel getModel() {
		return model;
	}
}
