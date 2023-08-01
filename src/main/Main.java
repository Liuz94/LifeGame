package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.navem.main.Controller.LifeGameController;
import com.navem.main.Model.LifeGameModel;
import com.navem.main.View.LifeGameView;

public class Main {
	public static void main(String[] args) {
		int filas = 300;
		int cols = 300;
		int cellSize = 5;

		SwingUtilities.invokeLater(() -> {
			LifeGameView lifeGameView = new LifeGameView(filas, cols, cellSize);
			LifeGameModel lifeGameModel = lifeGameView.getModel();

			lifeGameModel.setGliderPattern(50, 50);

			LifeGameController lifeGameController = new LifeGameController(lifeGameModel, lifeGameView);
			lifeGameController.startGameLoop();

			// Creamos la ventana principal y agregamos LifeGameView
			JFrame mainFrame = new JFrame("Game of Life");
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.add(lifeGameView);
			mainFrame.setSize(cols * cellSize, filas * cellSize); // Establecemos el tamaño por defecto
			mainFrame.setResizable(true);
			mainFrame.setLocationRelativeTo(null); // Centrar la ventana
			mainFrame.setVisible(true);
		});
	}
}
