package Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.navem.main.Model.LifeGameModel;

class LifeGameTest {

	@Test
	public void testGliderPatternAfter5Iterations() {
		int rows = 10;
		int cols = 10;
		LifeGameModel model = new LifeGameModel(rows, cols);

		// Establecer el patrón Glider en una ubicación específica
		model.setGliderPattern(2, 2);

		// Verificar el estado del patrón Glider después de establecerlo
		boolean[][] cells = model.getCells();
		assertTrue(cells[2][3]);
		assertTrue(cells[3][4]);
		assertTrue(cells[4][2]);
		assertTrue(cells[4][3]);
		assertTrue(cells[4][4]);

		for (int i = 0; i < 5; i++) {
			model.evolve();
		}

		// Verificar el estado del patrón Glider después de 5 iteraciones
		cells = model.getCells();
		assertFalse(cells[2][2]);
		assertTrue(cells[4][3]);
		assertTrue(cells[5][4]);
		assertTrue(cells[6][4]);
		assertTrue(cells[5][5]);
		assertTrue(cells[4][5]);
	}

	@Test
	public void testBlinkerPatternIteration5() {
		int rows = 5;
		int cols = 5;
		LifeGameModel model = new LifeGameModel(rows, cols);

		model.setBlinkerPattern(1, 1);

		for (int i = 0; i < 5; i++) {
			model.evolve();
		}

		boolean[][] cells = model.getCells();
		assertFalse(cells[1][0]); // Celda muerta
		assertFalse(cells[1][2]); // Celda muerta
		assertTrue(cells[2][1]); // Celda viva
		assertTrue(cells[1][1]); // Celda viva
		assertTrue(cells[0][1]); // Celda viva
		assertFalse(cells[2][0]); // Celda muerta
		assertFalse(cells[2][2]); // Celda muerta
	}

	@Test
	public void testDiehardPatternAfter130Generations() {
		int rows = 20;
		int cols = 20;
		LifeGameModel model = new LifeGameModel(rows, cols);

		// Establecer el patrón Diehard en una ubicación específica
		model.setDiehardPattern(5, 5);

		for (int i = 0; i < 135; i++) {
			model.evolve();
		}

		boolean[][] cells = model.getCells();

		// Verificar el estado de las células después de 130 iteraciones
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				assertFalse(cells[row][col], "Celda (" + row + "," + col + ") debe estar muerta");
			}
		}
	}

}
