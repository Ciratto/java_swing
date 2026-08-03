package com.udemy.java_swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JavaSwing11OptionDialog extends JFrame {
	
	//Constructor general.
	private JavaSwing11OptionDialog() {
		super("Ventana diálogo con opciones");

		Container contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		Object[] options = {"Si","No","Cancelar"};
		int value = JOptionPane.showOptionDialog(
				null, 
				"Desea Continuar?",
				"Confirmar alguna opcion",
				JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
		
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		System.err.println(value);
	}
	
	public static void main(String[] args) {
		new JavaSwing11OptionDialog();
	}
}
