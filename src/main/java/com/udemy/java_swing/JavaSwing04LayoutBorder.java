package com.udemy.java_swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JavaSwing04LayoutBorder extends JFrame implements ActionListener {
	//Cuando arranca contruyo la pantalla.
	public static void main(String[] args) {
		new JavaSwing04LayoutBorder();

	}

	public JavaSwing04LayoutBorder() {
		super("Ejemplo de Ventana con Entorno Flotante");
		
		JPanel panel = new JPanel(new BorderLayout(8,4));

		
		JButton btnAceptar = new JButton("Aceptar ");
		btnAceptar.addActionListener(e->actionPerformed(e));
		btnAceptar.setPreferredSize(new Dimension(200,100));
		
		panel.add(btnAceptar, BorderLayout.CENTER);	
		panel.add(new JButton("North"), BorderLayout.NORTH);
		panel.add(new JButton("South"), BorderLayout.SOUTH);
		panel.add(new JButton("West"), BorderLayout.WEST);
		panel.add(new JButton("East"), BorderLayout.EAST);

		setContentPane(panel);
		setVisible(true);
		setSize(600,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Se ha presionado el botón");
	}

}
