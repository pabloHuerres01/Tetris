package Tablero;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Figuras.*;

public class TableroPrincipal extends JPanel{
		
	// Ancho del tablero
    final int ancho = 12;
    
    // Alto del tablero
    final int alto = 25;

    // Indica si la pieza ha llegado a su fin en el tablero y necesitamos crear otra pieza nueva
    public boolean finalizadoCaida = false;
    
    // Una vez se inicia el juego empezaremos a escuchar eventos del teclado
    boolean eventosTeclado = false;
    
    //Piezas colocadas
    Figura[]figurasColocadas;
    
    // Posición de la pieza en el tablero para el eje de las X
    int x_actual = 0;
    
    // Posición de la pieza en el tablero para el eje de las Y
    int y_actual = 0;
    
    //Pieza actual 
    Figuras figura;
    
    //Constructor
    
    public TableroPrincipal(){
    	inicializarTablero();
    	eventosTeclado= true;
    	
    	 
        // Iniciamos los capturadores de eventos para el teclado
        addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent e) 
            {

                if (eventosTeclado) 
                {  
                    switch (e.getKeyCode()) 
                    {
 	  	             case KeyEvent.VK_LEFT:
 	  	                 puedeCaer(figura, x_actual - 1, y_actual);
 	  	                 break;
 	  	                 
 	  	             case KeyEvent.VK_RIGHT:
 	  	                 puedeCaer(figura, x_actual + 1, y_actual);
 	  	                 break;
 	  	                 
 	  	             case KeyEvent.VK_UP:
 	  	                 puedeCaer(figura.rotar(), x_actual, y_actual);
 	  	                 break;
 	               }
                }
            }
        });  
    }
    
    public void inicializarTablero() 
    {
    	figurasColocadas = new Figura [ancho * alto];
    	for(int i=0; i <(alto * ancho); i++) {
    		figurasColocadas[i]=Figura.Sin_Forma;
    	}
    }
    
    public boolean añadirNuevaPieza() 
    {
    	finalizadoCaida = false;
    	return nuevaPieza();
    }
    
    private boolean nuevaPieza() 
    {
    	figura = new Figuras();
    	figura.escogerPiezaAleatoriamente();
    	x_actual = ancho / 2 + 1;
        y_actual = alto - 1 + figura.obtenerYMinima();
        
        if(puedeCaer(figura, x_actual, y_actual))
        {
        	// Dejamos de escuchar eventos del teclado
            eventosTeclado = false;
            
            // Con esto finalizaremos el juego
        	return false;
        }
        return true;
    	
    }
    private boolean puedeCaer(Figuras figura2, int x, int y) 
    {
    	for(int i = 0; i<figura.obtenerNumCoordRel();++i)
    	{
    		int x2 = x + figura.obtenerX(i);
            int y2 = y - figura.obtenerY(i);
            
            if (x2 < 0 || x2 >= ancho || y2 < 0 || y2 > alto)
            {
                return false;
            }
            if (figurasAlmacenadas(x, y) != Figura.Sin_Forma) 
            {
                return false;
            }
    	}
    	figura = figura2;
        x_actual = x;
        y_actual = y;
        
        repaint();
        
        return true;
    }
    
    private Figura figurasAlmacenadas(int x, int y)
    {
    	return figurasColocadas[(y * ancho) + x];
    }
    
    public void bajarLinea()
    {
    	if (!puedeCaer(figura, x_actual, y_actual-1))
    	{
            haLlegadoFinal();
        }
    }
    
    private void haLlegadoFinal()
    {
    	for(int i = 0; i<4;i++)
    	{
    		// Obtenemos las casillas ocupadas a partir de sus coordenadas relativas
            int x = x_actual + figura.obtenerX(i);
            int y = y_actual - figura.obtenerY(i);
            
            // Almacenamos la pieza en el tablero final de forma lineal
            figurasColocadas[(y * ancho) + x] = figura.obtenerForma();
        }

        if (!finalizadoCaida){
            nuevaPieza();
        }
    }
    
    public boolean sumarNuevaPieza()
    {
    	finalizadoCaida = false;
    	return nuevaPieza();

    }
    
}
