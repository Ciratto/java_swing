package com.udemy.java_swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class JavaSwing13TableModel extends JFrame {
	
	//Constructor
	private JavaSwing13TableModel() {
		super("Ejemplo Table Model");
		
		JTable table = new JTable();
		table.setModel(new UserTableModel());

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);

		JPanel panel = new JPanel();
		panel.add(scroll);
		
		getContentPane().add(panel);
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class UserTableModel extends AbstractTableModel {
		private String[] columns = {"Id","Name","LastName","Email"};
		private Object[][] rows;
		
		//Simulamos datos
		private UserTableModel() {
			this.rows = new Object[5][4];
			this.rows[0] = new Object[] {1,"Delfina","Gomez","correo1@gmail.com"};
			this.rows[1] = new Object[] {2,"Miriam","Gomez","correo2@gmail.com"};
			this.rows[2] = new Object[] {3,"Cristian","Gomez","correo3@gmail.com"};
			this.rows[3] = new Object[] {4,"Ana","Gomez","correo4@gmail.com"};
			this.rows[4] = new Object[] {5,"Juan","Gomez","correo5@gmail.com"};
		}
		
		@Override
		public int getRowCount() {
			return rows.length;
		}

		@Override
		public int getColumnCount() {
			return columns.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return rows[rowIndex][columnIndex];
		}

		@Override
		public String getColumnName(int column) {
			return columns[column];
		}
	}
	
	//Lanzador
	public static void main(String[] args) {
		new JavaSwing13TableModel();
	}

}
