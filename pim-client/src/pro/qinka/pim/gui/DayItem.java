package pro.qinka.pim.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import pro.qinka.pim.entity.*;
import pro.qinka.pim.collection.*;
    
/**
 * DayItem
 *
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.10
 *
 * The panel to show one's items.
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

    private void itemClicked(AWTEvent e) {
	int index = list1.getSelectedIndex();
	if (index != -1) {
	    PIMEntity sel = items.get(index);
	    if (sel != null)
		new ShowItem(sel).setVisible(true);
	}
    }
    
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
	updateList();
    }
    public void addItem(PIMEntity p) {
	if(p != null) {
	    items.add(p);
	    updateList();
	}
    }

    private void updateList() {
	Vector<String> tmply = items.stream().map(pim -> display(pim)).collect(Collectors.toCollection(Vector<String>::new));
	list1.setListData(tmply);
	this.updateUI();
    }

    protected String display(PIMEntity e) {
	StringBuilder sbr = new StringBuilder();
	sbr.append(e.__getType().toUpperCase().substring(0,1));
	sbr.append(" ");
	if (e instanceof PIMAppointment) sbr.append(((PIMAppointment)e).getDescription());
	if (e instanceof PIMTodo) sbr.append(((PIMTodo)e).getContext());
	return sbr.toString();	
    }

    private void initComponents() {
	label1 = new JLabel();
	scrollPane1 = new JScrollPane();
	list1 = new JList();

	//======== this ========
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

	// -- list1 --
	list1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    itemClicked(e);
		}
	    });

	//======== scrollPane1 ========
	{
	    scrollPane1.setViewportView(list1);
	    scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	add(scrollPane1, "cell 0 1");
    }
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList<String> list1;
}
