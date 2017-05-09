package pro.qinka.pim.gui;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Tue May 09 21:20:38 CST 2017
 */



/**
 * @author John Lee
 */
public class ConnectionWindows extends JFrame {
	public ConnectionWindows() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - John Lee
		label3 = new JLabel();
		label4 = new JLabel();
		comboBox1 = new JComboBox<>();
		label5 = new JLabel();
		label6 = new JLabel();
		textField2 = new JTextField();
		passwordField1 = new JPasswordField();
		button1 = new JButton();

		//======== this ========
		setResizable(false);
		setTitle("Connection");
		Container contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[219,fill]" +
			"[220,fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

		//---- label3 ----
		label3.setText("Connection for PIM");
		label3.setFont(new Font("Comic Sans MS", label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 14));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label3, "cell 0 0 2 1");

		//---- label4 ----
		label4.setText("Select a remote");
		contentPane.add(label4, "cell 0 1 2 1");

		//---- comboBox1 ----
		comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
			"local file",
			"http backend",
			"database"
		}));
		contentPane.add(comboBox1, "cell 0 2 2 1");

		//---- label5 ----
		label5.setText("User Name");
		contentPane.add(label5, "cell 0 3");

		//---- label6 ----
		label6.setText("Password");
		contentPane.add(label6, "cell 1 3");
		contentPane.add(textField2, "cell 0 4");
		contentPane.add(passwordField1, "cell 1 4");

		//---- button1 ----
		button1.setText("Connect");
		contentPane.add(button1, "cell 0 5 2 1");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - John Lee
	private JLabel label3;
	private JLabel label4;
	private JComboBox<String> comboBox1;
	private JLabel label5;
	private JLabel label6;
	private JTextField textField2;
	private JPasswordField passwordField1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
