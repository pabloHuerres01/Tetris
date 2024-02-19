package Ejecutable;

import java.awt.event.*;
import javax.swing.*;

import Tablero.TableroPrincipal;

public class Main extends JFrame {
	
	private Timer Temporizador;
	
	private TableroPrincipal Tablero;
	
	

	public static void main(String[] args) 
	{
		Main main = new Main();
		main.setLocationRelativeTo(null);
        main.setVisible(true);
		

	}
	
	public Main() 
	{
		setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Creamos el tablero del juego de tipo JPanel y lo añadimos al JFrame
    	Tablero = new TableroPrincipal();
    	Tablero.setFocusable(true);
        add(Tablero);
        
        // Creamos el temporizador
        Temporizador = new Timer(1000, new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		
        		// Si la pieza actual en el tablero no ha llegado al final, entonces continuamos su caida
        		if (!Tablero.finalizadoCaida){
        			Tablero.bajarLinea();
        		}
        		else{
        			// Si ha llegado al final del trayecto creamos una nueva pieza en el tablero
        			boolean se_pudo_anyadir = Tablero.sumarNuevaPieza();
        			
        			// En caso de no poder añadir una pieza nueva entonces fin del juego
        			if (!se_pudo_anyadir) {
        				Temporizador.stop();
        			}
                }
            }
        });
        
        // Iniciamos el juego
        Temporizador.start();
    }
	

}
