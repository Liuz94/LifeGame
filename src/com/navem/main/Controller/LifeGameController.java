package com.navem.main.Controller;

import javax.swing.Timer;

import com.navem.main.Model.LifeGameModel;
import com.navem.main.View.LifeGameView;

public class LifeGameController {
	private LifeGameModel model;
	private LifeGameView view;

	public LifeGameController(LifeGameModel model, LifeGameView view) {
		this.model = model;
		this.view = view;
	}

	// Método para iniciar el bucle del juego
	public void startGameLoop() {
		Timer timer = new Timer(100, e -> {
			model.evolve();
			view.repaint();
		});
		timer.start();
	}
}
