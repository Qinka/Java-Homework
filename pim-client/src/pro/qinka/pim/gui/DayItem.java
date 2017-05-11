package pro.qinka.pim.gui;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import pro.qinka.pim.entity.*;
import pro.qinka.pim.collection.*;
/*
 * Created by JFormDesigner on Tue May 09 21:37:53 CST 2017
 */



/**
 * @author John Lee
 */
public class DayItem extends JPanel {
    public DayItem() {
	items = new PIMCollection();
	initComponents();
    }

    public void setIVisible(boolean b) {
	label1.setVisible(b);
	list1.setVisible(b);
	scrollPane1.setVisible(b);
    }
    private PIMCollection items;
    
    public String getDays() {
	return label1.getText();
    }
    public PIMCollection getItems() {
	return items;
    }
    public void setDays(int d) {
	label1.setText(String.valueOf(d));
    }
    public void cleanItem() {
	items.clear();
	Vector<String> tmp = items.stream().map(pim -> pim.toString()).collect(Collectors.toCollection(Vector<String>::new));
	list1.setListData(tmp);
	this.updateUI();
    }
    public void addItem(PIMEntity p) {
	if(p != null) {
	    items.add(p);
	    Vector<String> tmp = items.stream().map(pim -> pim.toString()).collect(Collectors.toCollection(Vector<String>::new));
	    list1.setListData(tmp);
	    this.updateUI();
	}
    }
    

    private void initComponents() {
	// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
	// Generated using JFormDesigner Evaluation license - John Lee
	label1 = new JLabel();
	scrollPane1 = new JScrollPane();
	list1 = new JList();

	//======== this ========

	// JFormDesigner evaluation mark
	/*setBorder(new javax.swing.border.CompoundBorder(
		new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
			"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
			javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
			java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});*/

	setLayout(new MigLayout(
		"hidemode 3",
		// columns
		"[100,grow,fill]",
		// rows
		"[2,grow]0" +
		"[30,grow]0"));

	//---- label1 ----
	label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 5f));
	label1.setHorizontalAlignment(SwingConstants.TRAILING);
	add(label1, "cell 0 0");

	//======== scrollPane1 ========
	{
		scrollPane1.setViewportView(list1);
	}
	add(scrollPane1, "cell 0 1");
	// JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - John Lee
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JList<String> list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
