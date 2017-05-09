/*
 * Created by JFormDesigner on Tue May 09 21:43:43 CST 2017
 */

package pro.qinka.pim.gui;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author John Lee
 */
public class MainWindows extends JFrame {
	public MainWindows() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - John Lee
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		menu2 = new JMenu();
		menuItem3 = new JMenuItem();
		menuItem4 = new JMenuItem();
		menu3 = new JMenu();
		label1 = new JLabel();
		dayItem1 = new DayItem();
		dayItem2 = new DayItem();
		dayItem3 = new DayItem();
		dayItem4 = new DayItem();
		dayItem5 = new DayItem();
		dayItem6 = new DayItem();
		dayItem7 = new DayItem();
		dayItem19 = new DayItem();
		dayItem8 = new DayItem();
		dayItem12 = new DayItem();
		dayItem18 = new DayItem();
		dayItem24 = new DayItem();
		dayItem28 = new DayItem();
		dayItem35 = new DayItem();
		dayItem20 = new DayItem();
		dayItem9 = new DayItem();
		dayItem13 = new DayItem();
		dayItem23 = new DayItem();
		dayItem25 = new DayItem();
		dayItem29 = new DayItem();
		dayItem34 = new DayItem();
		dayItem21 = new DayItem();
		dayItem10 = new DayItem();
		dayItem14 = new DayItem();
		dayItem17 = new DayItem();
		dayItem26 = new DayItem();
		dayItem30 = new DayItem();
		dayItem33 = new DayItem();
		dayItem22 = new DayItem();
		dayItem11 = new DayItem();
		dayItem15 = new DayItem();
		dayItem16 = new DayItem();
		dayItem27 = new DayItem();
		dayItem31 = new DayItem();
		dayItem32 = new DayItem();
		scrollPane1 = new JScrollPane();
		list1 = new JList();

		//======== this ========
		setTitle("Personal Information Manager GUI");
		setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[grow,sizegroup 1,fill]0" +
			"[grow,sizegroup 1,fill]0" +
			"[grow,sizegroup 1,fill]0" +
			"[grow,sizegroup 1,fill]0" +
			"[38,grow,sizegroup 1,fill]0" +
			"[79,grow,sizegroup 1,fill]0" +
			"[grow,sizegroup 1,fill]",
			// rows
			"[34]0" +
			"[grow,fill]0" +
			"[grow,fill]0" +
			"[grow,fill]0" +
			"[grow,fill]0" +
			"[grow,fill]0" +
			"[grow,fill]0"));

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("Remote");

				//---- menuItem1 ----
				menuItem1.setText("Save");
				menu1.add(menuItem1);

				//---- menuItem2 ----
				menuItem2.setText("Load");
				menu1.add(menuItem2);
			}
			menuBar1.add(menu1);

			//======== menu2 ========
			{
				menu2.setText("Operation");

				//---- menuItem3 ----
				menuItem3.setText("List");
				menu2.add(menuItem3);

				//---- menuItem4 ----
				menuItem4.setText("Create");
				menu2.add(menuItem4);
			}
			menuBar1.add(menu2);

			//======== menu3 ========
			{
				menu3.setText("Quit");
			}
			menuBar1.add(menu3);
		}
		setJMenuBar(menuBar1);

		//---- label1 ----
		label1.setText("YYYY-MM");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 8f));
		contentPane.add(label1, "cell 0 0 7 1");
		contentPane.add(dayItem1, "cell 0 1");
		contentPane.add(dayItem2, "cell 1 1");
		contentPane.add(dayItem3, "cell 2 1");
		contentPane.add(dayItem4, "cell 3 1");
		contentPane.add(dayItem5, "cell 4 1");
		contentPane.add(dayItem6, "cell 5 1");
		contentPane.add(dayItem7, "cell 6 1");
		contentPane.add(dayItem19, "cell 0 2");
		contentPane.add(dayItem8, "cell 1 2");
		contentPane.add(dayItem12, "cell 2 2");
		contentPane.add(dayItem18, "cell 3 2");
		contentPane.add(dayItem24, "cell 4 2");
		contentPane.add(dayItem28, "cell 5 2");
		contentPane.add(dayItem35, "cell 6 2");
		contentPane.add(dayItem20, "cell 0 3");
		contentPane.add(dayItem9, "cell 1 3");
		contentPane.add(dayItem13, "cell 2 3");
		contentPane.add(dayItem23, "cell 3 3");
		contentPane.add(dayItem25, "cell 4 3");
		contentPane.add(dayItem29, "cell 5 3");
		contentPane.add(dayItem34, "cell 6 3");
		contentPane.add(dayItem21, "cell 0 4");
		contentPane.add(dayItem10, "cell 1 4");
		contentPane.add(dayItem14, "cell 2 4");
		contentPane.add(dayItem17, "cell 3 4");
		contentPane.add(dayItem26, "cell 4 4");
		contentPane.add(dayItem30, "cell 5 4");
		contentPane.add(dayItem33, "cell 6 4");
		contentPane.add(dayItem22, "cell 0 5");
		contentPane.add(dayItem11, "cell 1 5");
		contentPane.add(dayItem15, "cell 2 5");
		contentPane.add(dayItem16, "cell 3 5");
		contentPane.add(dayItem27, "cell 4 5");
		contentPane.add(dayItem31, "cell 5 5");
		contentPane.add(dayItem32, "cell 6 5");

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(list1);
		}
		contentPane.add(scrollPane1, "cell 0 6 7 1");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - John Lee
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenu menu2;
	private JMenuItem menuItem3;
	private JMenuItem menuItem4;
	private JMenu menu3;
	private JLabel label1;
	private DayItem dayItem1;
	private DayItem dayItem2;
	private DayItem dayItem3;
	private DayItem dayItem4;
	private DayItem dayItem5;
	private DayItem dayItem6;
	private DayItem dayItem7;
	private DayItem dayItem19;
	private DayItem dayItem8;
	private DayItem dayItem12;
	private DayItem dayItem18;
	private DayItem dayItem24;
	private DayItem dayItem28;
	private DayItem dayItem35;
	private DayItem dayItem20;
	private DayItem dayItem9;
	private DayItem dayItem13;
	private DayItem dayItem23;
	private DayItem dayItem25;
	private DayItem dayItem29;
	private DayItem dayItem34;
	private DayItem dayItem21;
	private DayItem dayItem10;
	private DayItem dayItem14;
	private DayItem dayItem17;
	private DayItem dayItem26;
	private DayItem dayItem30;
	private DayItem dayItem33;
	private DayItem dayItem22;
	private DayItem dayItem11;
	private DayItem dayItem15;
	private DayItem dayItem16;
	private DayItem dayItem27;
	private DayItem dayItem31;
	private DayItem dayItem32;
	private JScrollPane scrollPane1;
	private JList list1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
