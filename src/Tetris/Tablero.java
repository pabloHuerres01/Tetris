package Tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tablero {
	
	
	public boolean puedeJugar = true;
	
	
	
	public String[][]tablero;
	
	public Tablero(int ancho, int alto) {
	
		tablero=new String[alto][ancho];	
	
i		for(int i = 0; i<ancho;i++) {
			for(int y = 0; y<alto; y++) {
				tablero[i][y]="[0]";				
			}			
		}
		
		recorrerMatriz();
	}
	
	/*
	 * ancho => tablero.length
	 * alto => tablero[0].length
	 */
	public void recorrerMatriz() {		
		for(int i = 0; i<tablero.length;i++) {
			for(int y = 0; y<tablero[0].length; y++) {
				System.out.print(tablero[i][y]);				
			}
			System.out.println("");
			
		}
		puedeJugar=false;
	}
	

	/*
	private int ancho, altura;
	
	
	private void pintarCuadrado(Graphics g, int x, int y, Figuras Forma)
    {
        Color colors[] = { 
    		new Color(0, 0, 0), new Color(204, 102, 102), 
            new Color(102, 204, 102), new Color(102, 102, 204), 
            new Color(204, 204, 102), new Color(204, 102, 204), 
            new Color(102, 204, 204), new Color(218, 170, 0)
        };
        
        Color color = colors[Forma.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, anchoDelCuadrado() - 2, altoDelCuadrado() - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + altoDelCuadrado() - 1, x, y);
        g.drawLine(x, y, x + anchoDelCuadrado() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + altoDelCuadrado() - 1, x + anchoDelCuadrado() - 1, y + altoDelCuadrado() - 1);
        g.drawLine(x + anchoDelCuadrado() - 1, y + altoDelCuadrado() - 1, x + anchoDelCuadrado() - 1, y + 1);
    }

	private int anchoDelCuadrado() {
		// TODO Auto-generated method stub
		return (int) (getSize().getWidth()/ancho);
	}

	private int altoDelCuadrado() {
		// TODO Auto-generated method stub
		return (int) (getSize().getHeight()/altura);
	}
	*/
}
