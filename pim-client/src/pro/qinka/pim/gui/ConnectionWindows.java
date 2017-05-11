package pro.qinka.pim.gui;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;

import pro.qinka.pim.collection.PIMBaseCollection;

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

	private void button1MouseClicked(MouseEvent e) {
	    // TODO add your code here
	    Connector cr = null;
	    switch(comboBox1.getSelectedIndex()){
	    case 0: // file
		cr = new ConnectSelect.FileConnect(connectionparam.getText());
		break;
	    case 1: // http backend
		cr = new ConnectSelect.BackendConnect(connectionparam.getText());
		break;
	    case 2: //database
		cr = new ConnectSelect.DatabaseConnect(connectionparam.getText(),
						       usernameI.getText(),
						       new String(passwordI.getPassword()));
		break;
	    default: // PIMCollection
		cr = new ConnectSelect();
		break;
	    }
	    PIMBaseCollection pimc = cr.getCollection();
	    JFrame jf = new MainWindows(pimc,textField1.getText());
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(false);
	    jf.setVisible(true);
	    this.dispose();
	}

	private void comboBox1ItemStateChanged(ItemEvent e) {
	    // TODO add your code here
	    boolean isVis = comboBox1.getSelectedItem().equals("database");
	    usernameT.setVisible(isVis);
	    usernameI.setVisible(isVis);
	    passwordT.setVisible(isVis);
	    passwordI.setVisible(isVis);
	    this.pack();
	}

	private void fieldUpdateCheck(CaretEvent e) {
	    boolean btEnable = textField1.getText().isEmpty() || connectionparam.getText().isEmpty();
	    boolean dbOpt;
	    if (comboBox1.getSelectedIndex() == 2)
		dbOpt = usernameI.getText().isEmpty() || String.valueOf(passwordI.getPassword()).isEmpty();
	    else dbOpt = false;
	    boolean fn = !(dbOpt || btEnable);
	    if (fn != button1.isEnabled()) {
		button1.setEnabled(fn);
		button1.setVisible(fn);
		this.pack();
	    }
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - John Lee
		label3 = new JLabel();
		label4 = new JLabel();
		label1 = new JLabel();
		comboBox1 = new JComboBox<>();
		textField1 = new JTextField();
		label2 = new JLabel();
		connectionparam = new JTextField();
		usernameT = new JLabel();
		passwordT = new JLabel();
		usernameI = new JTextField();
		passwordI = new JPasswordField();
		button1 = new JButton();

		//======== this ========
		setTitle("Connection");
		Container contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[219,grow,fill]" +
			"[220,grow,fill]",
			// rows
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]"));

		//---- label3 ----
		label3.setText("Connection for PIM");
		label3.setFont(new Font("Comic Sans MS", label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 14));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label3, "cell 0 0 2 1");

		//---- label4 ----
		label4.setText("Select a remote");
		contentPane.add(label4, "cell 0 1");

		//---- label1 ----
		label1.setText("Your name");
		contentPane.add(label1, "cell 1 1");

		//---- comboBox1 ----
		comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
			"local file",
			"http backend",
			"database"
		}));
		comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
		contentPane.add(comboBox1, "cell 0 2");

		//---- textField1 ----
		textField1.addCaretListener(e -> fieldUpdateCheck(e));
		contentPane.add(textField1, "cell 1 2");

		//---- label2 ----
		label2.setText("Connection Param");
		contentPane.add(label2, "cell 0 3 2 1");

		//---- connectionparam ----
		connectionparam.addCaretListener(e -> fieldUpdateCheck(e));
		contentPane.add(connectionparam, "cell 0 4 2 1");

		//---- usernameT ----
		usernameT.setText("User Name");
		usernameT.setVisible(false);
		contentPane.add(usernameT, "cell 0 5");

		//---- passwordT ----
		passwordT.setText("Password");
		passwordT.setVisible(false);
		contentPane.add(passwordT, "cell 1 5");

		//---- usernameI ----
		usernameI.setVisible(false);
		usernameI.addCaretListener(e -> fieldUpdateCheck(e));
		contentPane.add(usernameI, "cell 0 6");

		//---- passwordI ----
		passwordI.setVisible(false);
		passwordI.addCaretListener(e -> fieldUpdateCheck(e));
		contentPane.add(passwordI, "cell 1 6");

		//---- button1 ----
		button1.setText("Connect");
		button1.setEnabled(false);
		button1.setVisible(false);
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button1MouseClicked(e);
			}
		});
		contentPane.add(button1, "cell 0 7 2 1");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - John Lee
	private JLabel label3;
	private JLabel label4;
	private JLabel label1;
	private JComboBox<String> comboBox1;
	private JTextField textField1;
	private JLabel label2;
	private JTextField connectionparam;
	private JLabel usernameT;
	private JLabel passwordT;
	private JTextField usernameI;
	private JPasswordField passwordI;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
