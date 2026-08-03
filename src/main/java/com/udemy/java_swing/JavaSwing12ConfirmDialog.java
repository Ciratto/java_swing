package com.udemy.java_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JavaSwing12ConfirmDialog extends JFrame {
	Container contenedor;
	
	private JavaSwing12ConfirmDialog() {
		super("Confirmaciones de diálogo");

		//Creacion de un formulario de dialogo.
		JLabel name = new JLabel("Nombre:",JLabel.LEFT);
		JLabel lastName = new JLabel("Apellido:",JLabel.LEFT);
		JLabel fiscalNumber =  new JLabel("Nro. Fiscal:",JLabel.LEFT);
		
		JTextField nameField = new JTextField();
		JTextField lastNameField = new JTextField();
		JTextField fiscalNumberField = new JTextField();
		
		JRadioButton mornign = new JRadioButton("Grupo Mañana",true);
		JRadioButton afternoon = new JRadioButton("Grupo Tarde",true);
		
		JPanel panelIzquierdo = new JPanel(new GridLayout(3, 1, 2, 2));
		panelIzquierdo.add(name);
		panelIzquierdo.add(lastName);
		panelIzquierdo.add(fiscalNumber);
		
		JPanel panelDerecho = new JPanel(new GridLayout(3, 1, 2, 2));
		panelDerecho.add(nameField);
		panelDerecho.add(lastNameField);
		panelDerecho.add(fiscalNumberField);
		
		JPanel panelSuperior = new JPanel(new GridLayout(1, 1));
		panelSuperior.add(panelIzquierdo);
		panelSuperior.add(panelDerecho);
		
		JPanel panelInferior = new JPanel(new GridLayout(1, 2));
		panelInferior.add(mornign);
		panelInferior.add(afternoon);
		
		JPanel formPanel = new JPanel(new GridLayout(2,2));
		formPanel.add(panelSuperior);
		formPanel.add(panelInferior);
		
		int option = JOptionPane.showConfirmDialog(this,formPanel,"Formulario",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		if (option == JOptionPane.OK_OPTION) {
			JOptionPane.showMessageDialog(this,"Se ha presionado el botón OK!","Aviso",JOptionPane.INFORMATION_MESSAGE);
		} else if (option == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(this,"Se ha presionado el botón Cancelar!","Aviso",JOptionPane.WARNING_MESSAGE);
		}

		//Ventana principal 
		contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaSwing12ConfirmDialog();
	}
}
