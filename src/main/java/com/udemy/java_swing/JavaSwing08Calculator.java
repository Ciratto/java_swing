package com.udemy.java_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JavaSwing08Calculator extends JFrame{
	JTextField numeroA;
	JTextField numeroB;
	JTextField result;
	
	//Contruyo ventana.
	private JavaSwing08Calculator() {
		super("Ejemplo Calculadora");
		
		//Construyo menu
		JMenuBar menuBar = new JMenuBar();	 
		JMenu menuOperaciones = new JMenu("Operaciones");
		JMenu menuExit = new JMenu("Exit");
		JMenuItem itemAdd = new JMenuItem("Suma");
		JMenuItem itemSub = new JMenuItem("Resta");
		JMenuItem itemDiv = new JMenuItem("Divide");
		JMenuItem itemMulti = new JMenuItem("Multiplica");
		JMenuItem itemClose = new JMenuItem("Salir");

		menuBar.add(menuOperaciones);
		menuBar.add(menuExit);
		
		menuOperaciones.add(itemAdd);
		menuOperaciones.add(itemSub);
		menuOperaciones.add(itemDiv);
		menuOperaciones.add(itemMulti);
		menuOperaciones.add(itemClose);
		menuExit.add(itemClose);
		
		//Panel Centro------------------------------
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new FlowLayout()); //Que los componentes interiores esten alineados uno al lado del otro
		panelCentro.add(new JLabel("Numero 1"));
		panelCentro.add(numeroA = new JTextField(3));
		panelCentro.add(new JLabel("Numero 2"));
		panelCentro.add(numeroB = new JTextField(3));
		panelCentro.add(new JLabel("Resultado"));
		panelCentro.add(result = new JTextField(5));
		
		//Contenedor principal.------------------------
		Container container = getContentPane(); 	
		container.setLayout(new BorderLayout()); //Que los componente sinteriores se sectoricen por norte, sur, este, oeste, y centro
		container.add(panelCentro, BorderLayout.CENTER); //Que el panel central justamente este en el centro.

		result.setEditable(false);
		
		setJMenuBar(menuBar);
		setLocationRelativeTo(null);
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	};
	
	
	//Abro pantalla
	public static void main(String[] args) {
		new JavaSwing08Calculator();
	}
}
