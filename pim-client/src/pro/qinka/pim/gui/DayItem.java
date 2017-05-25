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
    /**
     * The constructor of the DayItem
     * The panel of the items.
     */
    public DayItem() {
	items = new PIMCollection();
	initComponents();
    }

    /**
     * The method to set the inner elements' visable property.
     * @param b the boolean value of the `visable'
     */
    public void setIVisible(boolean b) {
	label1.setVisible(b);
	list1.setVisible(b);
	scrollPane1.setVisible(b);
    }
    private PIMCollection items;
    
    /**
     * the method of the event about item clicked
     * @param e AWTEvent
     */
    private void itemClicked(AWTEvent e) {
	int index = list1.getSelectedIndex();
	if (index != -1) {
	    PIMEntity sel = items.get(index);
	    if (sel != null)
		new ShowItem(sel).setVisible(true);
	}
    }

    /**
     * the method to get the days, the text of the label.
     * @return the string of the label.
     */
    public String getDays() {
	return label1.getText();
    }
    /**
     * the method to get the items of the inner collection.
     * @return the collections of the items.
     */
    public PIMCollection getItems() {
	return items;
    }
    /**
     * the method to set the days of the item, the text of the label.
     * @param d the integer value of the day.
     */
    public void setDays(int d) {
	label1.setText(String.valueOf(d));
    }
    /**
     * the method to clean all the elements or items in the collection.
     */
    public void cleanItem() {
	items.clear();
	updateList();
    }
    /**
     * the method to add a item to the inner collection, and update.
     * @param p the pim enetity of the added one.
     */
    public void addItem(PIMEntity p) {
	if(p != null) {
	    items.add(p);
	    updateList();
	}
    }

    /**
     * the method to update the list in the panel when things changed.
     */
    private void updateList() {
	Vector<String> tmply = items.stream().map(pim -> display(pim)).collect(Collectors.toCollection(Vector<String>::new));
	list1.setListData(tmply);
	this.updateUI();
    }

    /**
     * the method to upload the items to `gui'
     * show one item using a dialog
     * @param e the PIM entity to be diplayed
     */
    protected String display(PIMEntity e) {
	StringBuilder sbr = new StringBuilder();
	sbr.append(e.__getType().toUpperCase().substring(0,1));
	sbr.append(" ");
	if (e instanceof PIMAppointment) sbr.append(((PIMAppointment)e).getDescription());
	if (e instanceof PIMTodo) sbr.append(((PIMTodo)e).getContext());
	return sbr.toString();	
    }

    /**
     * the method to init the panel.
     */
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
