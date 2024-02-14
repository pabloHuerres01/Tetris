package Tetris;

public class Juego {

	public static void main(String[] args) {
		/*
		 * Primero se pasa el horizontal, despues el vertical
		 */
		Tablero tablero = new Tablero(8,10);
		while(tablero.puedeJugar == true) {
			tablero.recorrerMatriz();
		}
	}

}
