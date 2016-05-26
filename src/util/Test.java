package util;

import javax.swing.JOptionPane;

public class Test {
	public static void main(String[] args) {
		Conexion cn = new Conexion();
		String r=cn.open();
		JOptionPane.showMessageDialog(null, r);
	}
}
