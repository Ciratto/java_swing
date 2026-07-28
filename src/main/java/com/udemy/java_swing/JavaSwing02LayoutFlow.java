package com.udemy.java_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JavaSwing02LayoutFlow extends JFrame implements ActionListener {
	//Cuando arranca contruyo la pantalla.
	public static void main(String[] args) {
		new JavaSwing02LayoutFlow();

	}

	public JavaSwing02LayoutFlow() {
		super("Ejemplo de Ventana con Entorno Flotante");
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));

		for (int i=1;i<=10;i++) {
			JButton btnAceptar = new JButton("Aceptar ".concat(String.valueOf(i)));
			
			btnAceptar.addActionListener(e->actionPerformed(e));
			btnAceptar.setPreferredSize(new Dimension(200,100));
			panel.add(btnAceptar);	
		}

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
