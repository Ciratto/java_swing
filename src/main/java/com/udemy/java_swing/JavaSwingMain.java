package com.udemy.java_swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaSwingMain {
	public static void main(String[] args) {
		createAndShowWindows();
	}
	
	public static void createAndShowWindows() {
		
		WindowAdapter windowAdapter = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.print("Cerrando ventana !");
				System.exit(0);
			};
		};
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Hola Mundo Swing");
		JLabel texto = new JLabel("Hola mundo!");
		
		frame.getContentPane().add(texto);
		frame.setVisible(true);
		frame.pack();
		frame.addWindowListener(windowAdapter);
		
	}
}
