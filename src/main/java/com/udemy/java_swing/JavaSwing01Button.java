package com.udemy.java_swing;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JavaSwing01Button extends JFrame implements ActionListener{
	public static void main(String[] args) {
		new JavaSwing01Button();
	}
	
	public JavaSwing01Button() {
		super("Ejemplo de botón y eventos");
		
		JButton boton = new JButton("Aceptar");
		boton.setSize(100,50);
		
		//forma de implementar un evento de boton con expresion lambda
		boton.addActionListener((e)-> {
			System.out.println("Se presiona el boton 1° forma!");
		});

		//forma de implementar un boton mediante un metodo anonimo (al vuelo)
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se presiona el boton 3° forma!");
			}
		});
		
		//forma de implementar el evento de un boton mediante implementacion de interface 
		boton.addActionListener(this);
		
		//forma de implementar el evento de un boton mediante clase
		boton.addActionListener(new ButtonClickListener());
		
		getContentPane().add(boton);
		setSize(200,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Se presiona el boton 2° forma!");
		
	};
	
	private static class ButtonClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Se presiona el boton 4° forma!");
			Toolkit.getDefaultToolkit().beep();
		}	
	};
	
}
