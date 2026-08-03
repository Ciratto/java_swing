package com.udemy.java_swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JavaSwing10MessageDialog extends JFrame {
	
	Container contenedor;
	
	//Construnctor de la ventana.
	private JavaSwing10MessageDialog() {
		super("Ventana de alerta");
		
		contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());

		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JOptionPane.showMessageDialog(null,"Debe instroducir datos en los campos","Aviso",JOptionPane.ERROR_MESSAGE);
	}
	
	//Lanzar ventana.
	public static void main(String[] args) {
		new JavaSwing10MessageDialog();
	}
}
