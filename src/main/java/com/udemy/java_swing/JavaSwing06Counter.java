package com.udemy.java_swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JavaSwing06Counter extends JFrame {
	public static void main(String[] args) {
		new JavaSwing06Counter();
	}	
	
	private int contador = 0;
	private JLabel lblResultado = new JLabel("Contador: 0");
	
	//Constructor.
	public JavaSwing06Counter() throws HeadlessException{
		super("Ejemplo contador");
		 
		JButton btnSumar = new JButton("Sumar");
		JButton btnRestar = new JButton("Restar");
		btnSumar.addActionListener(new BtnSumarClickListener());
		btnRestar.addActionListener(new BtnRestarClickListener());
		
		Container panel = getContentPane();
		panel.add(btnSumar);
		panel.add(btnRestar);
		panel.add(lblResultado);
		panel.setLayout(new FlowLayout());
		
		setVisible(true);
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class BtnRestarClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			contador--;
			lblResultado.setText("Contador: " + contador);
			Toolkit.getDefaultToolkit().beep();
		}	
	};
	
	private class BtnSumarClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			contador++;
			lblResultado.setText("Contador: " + contador);
			Toolkit.getDefaultToolkit().beep();
		}	
	};
}
