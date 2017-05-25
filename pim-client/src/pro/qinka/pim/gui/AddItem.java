package pro.qinka.pim.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;

import java.lang.*;
import java.util.function.*;
import pro.qinka.pim.entity.*;
import pro.qinka.pim.collection.*;


/**
 * AddItem
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.0
 *
 * Add the items.
 */
public class AddItem extends JDialog {
    public AddItem(PIMBaseCollection _bc,String _o,Function<Integer,Integer> _change) {
	super();
	bc = _bc;
	own = _o;
	cs = _change;
	initComponents();
    }

    private void typeStateChanged(ItemEvent e) {
	String sel = (String)(typeC.getSelectedItem());
	if(sel.equals("appointment")) {
	    a1.setText("date");
	    a2.setText("description");
	    a3.setText("");
	}
	else if(sel.equals("contact")) {
	    a1.setText("first name");
	    a2.setText("last name");
	    a3.setText("email");	    
	}
	else if(sel.equals("note")) {
	    a1.setText("note");
	    a2.setText("");
	    a3.setText("");
	}
	else if(sel.equals("todo")) {
	    a1.setText("date");
	    a2.setText("todo");
	    a3.setText("");
	}
	a1C.setText("");
	a2C.setText("");
	a3C.setText("");
	a1.setVisible(!a1.getText().isEmpty());
	a1C.setVisible(!a1.getText().isEmpty());
	a2.setVisible(!a2.getText().isEmpty());
	a2C.setVisible(!a2.getText().isEmpty());
	a3.setVisible(!a3.getText().isEmpty());
	a3C.setVisible(!a3.getText().isEmpty());
    }

    private void okButtonMouseClicked(MouseEvent e) {
	if(okButton.isEnabled()) {
	    String sel = (String)(typeC.getSelectedItem());
	    PIMEntity i;
	    if(sel.equals("appointment")) {
		PIMAppointment ii = new PIMAppointment(a2C.getText(),own,priorityC.getText());
		try {
		    ii.setDate("yyyy-MM-dd",a1C.getText());
		}
		catch (Exception exception) {
		    exception.printStackTrace();
		    return;
		}
		i = ii;
	    }
	    else if(sel.equals("contact")) {
		PIMContact ii = new PIMContact(a3C.getText(),a1C.getText(),a2C.getText(),own,priorityC.getText());
		i = ii;
	    }
	    else if(sel.equals("note")) {
		PIMNote ii = new PIMNote(a1C.getText(),own,priorityC.getText());
		i = ii;
	    }
	    else if(sel.equals("todo")) {
		PIMTodo ii = new PIMTodo(a2.getText(),own,priorityC.getText());
		try {
		    ii.setDate("yyyy-MM-dd",a1C.getText());
		}
		catch (Exception exception) {
		    exception.printStackTrace();
		    return;
		}
		i =ii;
	    }
	    else i = null;
	    if(bc.add(i)) {
		this.cs.apply(-1);
		this.setVisible(false);
		this.dispose();
	    }
	    else return;
	}
    }

    private void fieldUpdateCheck(CaretEvent e) {
	boolean p  = priority.getText().isEmpty() == priorityC.getText().isEmpty();
	boolean c1 = a1.getText().isEmpty() == a1C.getText().isEmpty();
	boolean c2 = a2.getText().isEmpty() == a2C.getText().isEmpty();
	boolean c3 = a3.getText().isEmpty() == a3C.getText().isEmpty();
	okButton.setEnabled(p && c1 && c2 && c3);
    }
    
    private void cancelButtonMouseClicked(MouseEvent e) {
	this.setVisible(false);
	this.dispose();
    }

    private void initComponents() {
	dialogPane = new JPanel();
	contentPanel = new JPanel();
	type = new JLabel();
	typeC = new JComboBox<>();
	priority = new JLabel();
	priorityC = new JTextField();
	a1 = new JLabel();
	a1C = new JTextField();
	a2 = new JLabel();
	a2C = new JTextField();
	a3 = new JLabel();
	a3C = new JTextField();
	buttonBar = new JPanel();
	okButton = new JButton();
	cancelButton = new JButton();
	textField1 = new JTextField();

	//======== this ========
	Container contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());

	//======== dialogPane ========
	{
	    dialogPane.setLayout(new BorderLayout());

	    //======== contentPanel ========
	    {
		contentPanel.setLayout(new MigLayout("insets dialog,hidemode 3",
						     // columns
						     "[fill]" +
						     "[grow,fill]",
						     // rows
						     "[grow]" +
						     "[grow]" +
						     "[grow]" +
						     "[grow]" +
						     "[grow]"));

		//---- type ----
		type.setText("text");
		contentPanel.add(type, "cell 0 0");

		//---- typeC ----
		typeC.setModel(new DefaultComboBoxModel<>(new String[] {
			    "appointment",
			    "contact",
			    "note",
			    "todo"
			}));
		typeC.addItemListener(e -> typeStateChanged(e));
		contentPanel.add(typeC, "cell 1 0");

		//---- priority ----
		priority.setText("priority");
		priorityC.setText("");
		priorityC.addCaretListener(e -> fieldUpdateCheck(e));
		contentPanel.add(priority, "cell 0 1");
		contentPanel.add(priorityC, "cell 1 1");

		//---- a1 ----
		a1.setText("date");
		a1C.setText("");
		a1C.addCaretListener(e -> fieldUpdateCheck(e));
		contentPanel.add(a1, "cell 0 2");
		contentPanel.add(a1C, "cell 1 2");

		//---- a2 ----
		a2.setText("description");
		a2C.setText("");
		a2C.addCaretListener(e -> fieldUpdateCheck(e));
		contentPanel.add(a2, "cell 0 3");
		contentPanel.add(a2C, "cell 1 3");
	          

		//---- a3 ----
		a3.setText("");
		a3C.setText("");
		a3C.addCaretListener(e -> fieldUpdateCheck(e));
		a3.setVisible(false);
		a3C.setVisible(false);
		contentPanel.add(a3, "cell 0 4");
		contentPanel.add(a3C, "cell 1 4");
	    }
	    dialogPane.add(contentPanel, BorderLayout.CENTER);

	    //======== buttonBar ========
	    {
		buttonBar.setLayout(new MigLayout(
						  "insets dialog,alignx right",
						  // columns
						  "[button,fill]" +
						  "[button,fill]",
						  // rows
						  null));

		//---- okButton ----
		okButton.setText("OK");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    okButtonMouseClicked(e);
			}
		    });
		boolean p  = priority.getText().isEmpty() == priorityC.getText().isEmpty();
		boolean c1 = a1.getText().isEmpty() == a1C.getText().isEmpty();
		boolean c2 = a2.getText().isEmpty() == a2C.getText().isEmpty();
		boolean c3 = a3.getText().isEmpty() == a3C.getText().isEmpty();
		okButton.setEnabled(p && c1 && c2 && c3);
		buttonBar.add(okButton, "cell 0 0");

		//---- cancelButton ----
		cancelButton.setText("Cancel");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    cancelButtonMouseClicked(e);
			}
		    });
		buttonBar.add(cancelButton, "cell 1 0");
	    }
	    dialogPane.add(buttonBar, BorderLayout.SOUTH);
	}
	contentPane.add(dialogPane, BorderLayout.CENTER);
	pack();
	setLocationRelativeTo(getOwner());
    }

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel type;
    private JComboBox<String> typeC;
    private JLabel priority;
    private JTextField priorityC;
    private JLabel a1;
    private JTextField a1C;
    private JLabel a2;
    private JTextField a2C;
    private JLabel a3;
    private JTextField a3C;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField textField1;
    private PIMBaseCollection bc;
    private String own;
    private Function<Integer,Integer> cs;
}
