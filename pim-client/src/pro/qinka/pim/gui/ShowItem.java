package pro.qinka.pim.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import pro.qinka.pim.entity.*;
import java.lang.*;
import java.util.*;

/**
 * Show Item
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @licnese GPL3
 * @version 0.2.0.0
 * 
 * Show the items
 */
public class ShowItem extends JDialog {
    /**
     * The constuctor of ShowItem
     */
    public ShowItem(PIMEntity _item) {
	super();
	item = _item;
	initComponents();
    }

    /**
     * The method of the event when ok-button clicked.
     * @param e AWT event param
     */
    private void okButtonClicked(AWTEvent e) {
	this.dispose();
    }	
    
    /**
     * the initial method of the dialog.
     */
    private void initComponents() {
	dialogPane = new JPanel();
	contentPanel = new JPanel();
	contextInfo = new HashMap();
	buttonBar = new JPanel();
	okButton = new JButton();

	//======== this ========
	Container contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());

	//======== dialogPane ========
	{    
	    dialogPane.setLayout(new BorderLayout());
	}
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
						 "[grow]" +
						 "[grow]" +
						 "[grow]" +
						 "[grow]"));

	    //====== context =======
	    {

		/* -- Haskell
		 * genCPS :: (String -> a) -> String -> String -> Int -> Int -> a
		 * genCPS func kind context sel row = func $ concat [ "// ---- ", kind, " ----","\n"
		 *                                                  , "contextInfo.put(\"",kind,"\",new JLabel());","\n"
		 *                                                  , "contextInfo.get(\"",kind,"\").setText(",context,");","\n"
		 *                                                  , "contentPanel.add(contextInfo.get(\"",kind,"\"),\"cell ",show sel,"  ",show row,"\");","\n"
		 *                                                  ]
		 *
		 * genPairCPS :: (String -> a) -> String -> String -> String -> Int -> a
		 * genPairCPS func k c1 c2 row = let func' = \s2 -> genCPS (\s1 -> func $ s1 ++ s2) k c1 0 row
		 *                               in genCPS func' (k++"C") c2 1 row
		 */
		if(item instanceof PIMAppointment) {
		    PIMAppointment a = (PIMAppointment)item;
		    // ---- type ----
		    contextInfo.put("type",new JLabel());
		    contextInfo.get("type").setText("Appointment");
		    contextInfo.get("type").setHorizontalAlignment(SwingConstants.CENTER);
		    contentPanel.add(contextInfo.get("type"),"cell 0 0 2 1");
		    // ---- priority ----
		    contextInfo.put("priority",new JLabel());
		    contextInfo.get("priority").setText("Priority");
		    contextInfo.get("priority").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("priority"),"cell 0 1");
		    // -- priority context --
		    contextInfo.put("priorityC",new JLabel());
		    contextInfo.get("priorityC").setText(a.getPriority());
		    contentPanel.add(contextInfo.get("priorityC"),"cell 1 1");
		    // ---- Description ----
		    contextInfo.put("description",new JLabel());
		    contextInfo.get("description").setText("Description");
		    contextInfo.get("description").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("description"),"cell 0 2");
		    // -- description context --
		    contextInfo.put("descriptionC",new JLabel());
		    contextInfo.get("descriptionC").setText(a.getDescription());
		    contentPanel.add(contextInfo.get("descriptionC"),"cell 1 2");
		    // ---- date ----
		    contextInfo.put("date", new JLabel());
		    contextInfo.get("date").setText("Date");
		    contextInfo.get("date").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("date"),"cell 0 3");
		    // -- date context --
		    contextInfo.put("dateC", new JLabel());
		    contextInfo.get("dateC").setText(a.getDate("YYYY-MM-DD"));
		    contentPanel.add(contextInfo.get("dateC"),"cell 1 3");
		}
		else if(item instanceof PIMContact) {
		    PIMContact a = (PIMContact)item;
		    // ---- type ----
		    contextInfo.put("type",new JLabel());
		    contextInfo.get("type").setText("Contact");
		    contextInfo.get("type").setHorizontalAlignment(SwingConstants.CENTER);
		    contentPanel.add(contextInfo.get("type"),"cell 0 0 2 1");
		    // ---- priority ----
		    contextInfo.put("priority",new JLabel());
		    contextInfo.get("priority").setText("Priority");
		    contextInfo.get("priority").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("priority"),"cell 0 1");
		    // -- priority context --
		    contextInfo.put("priorityC",new JLabel());
		    contextInfo.get("priorityC").setText(a.getPriority());
		    contentPanel.add(contextInfo.get("priorityC"),"cell 1 1");
		    // genPairCPS putStrLn "first-name" (show "First Name") "a.getFirstName()" 2
		    // ---- first-name ----
		    contextInfo.put("first-name",new JLabel());
		    contextInfo.get("first-name").setText("First Name");
		    contextInfo.get("first-name").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("first-name"),"cell 0  2");
		    // ---- first-nameC ----
		    contextInfo.put("first-nameC",new JLabel());
		    contextInfo.get("first-nameC").setText(a.getFirstName());
		    contentPanel.add(contextInfo.get("first-nameC"),"cell 1  2");
		    // genPairCPS putStrLn "last-name" (show "Last Name") "a.getLastName()" 3
		    // ---- last-name ----
		    contextInfo.put("last-name",new JLabel());
		    contextInfo.get("last-name").setText("Last Name");
		    contextInfo.get("last-name").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("last-name"),"cell 0  3");
		    // ---- last-nameC ----
		    contextInfo.put("last-nameC",new JLabel());
		    contextInfo.get("last-nameC").setText(a.getLastName());
		    contentPanel.add(contextInfo.get("last-nameC"),"cell 1  3");
		    // genPairCPS putStrLn "email" (show "E-Mail") "a.getEmail()" 4
		    // ---- email ----
		    contextInfo.put("email",new JLabel());
		    contextInfo.get("email").setText("E-Mail");
		    contextInfo.get("email").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("email"),"cell 0  4");
		    // ---- emailC ----
		    contextInfo.put("emailC",new JLabel());
		    contextInfo.get("emailC").setText(a.getEmail());
		    contentPanel.add(contextInfo.get("emailC"),"cell 1  4");
		}
		else if(item instanceof PIMNote) {
		    PIMNote a = (PIMNote)item;
		    // ---- type ----
		    contextInfo.put("type",new JLabel());
		    contextInfo.get("type").setText("Note");
		    contextInfo.get("type").setHorizontalAlignment(SwingConstants.CENTER);
		    contentPanel.add(contextInfo.get("type"),"cell 0 0 2 1");
		    // ---- priority ----
		    contextInfo.put("priority",new JLabel());
		    contextInfo.get("priority").setText("Priority");
		    contextInfo.get("priority").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("priority"),"cell 0 1");
		    // -- priority context --
		    contextInfo.put("priorityC",new JLabel());
		    contextInfo.get("priorityC").setText(a.getPriority());
		    contentPanel.add(contextInfo.get("priorityC"),"cell 1 1");
		    // genPairCPS putStrLn "note" (show "Note") "a.getContext()" 2
		    // ---- note ----
		    contextInfo.put("note",new JLabel());
		    contextInfo.get("note").setText("Note");
		    contextInfo.get("note").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("note"),"cell 0  2");
		    // ---- noteC ----
		    contextInfo.put("noteC",new JLabel());
		    contextInfo.get("noteC").setText(a.getContext());
		    contentPanel.add(contextInfo.get("noteC"),"cell 1  2");			
		}
		else if(item instanceof PIMTodo) {
		    PIMTodo a = (PIMTodo)item;
		    // ---- type ----
		    contextInfo.put("type",new JLabel());
		    contextInfo.get("type").setText("Todo");
		    contextInfo.get("type").setHorizontalAlignment(SwingConstants.CENTER);
		    contentPanel.add(contextInfo.get("type"),"cell 0 0 2 1");
		    // ---- priority ----
		    contextInfo.put("priority",new JLabel());
		    contextInfo.get("priority").setText("Priority");
		    contextInfo.get("priority").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("priority"),"cell 0 1");
		    // -- priority context --
		    contextInfo.put("priorityC",new JLabel());
		    contextInfo.get("priorityC").setText(a.getPriority());
		    contentPanel.add(contextInfo.get("priorityC"),"cell 1 1");
		    // genPairCPS putStrLn "todo" (show "Todo") "a.getContext()" 2
		    // ---- todo ----
		    contextInfo.put("todo",new JLabel());
		    contextInfo.get("todo").setText("Todo");
		    contextInfo.get("todo").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("todo"),"cell 0  2");
		    // ---- todoC ----
		    contextInfo.put("todoC",new JLabel());
		    contextInfo.get("todoC").setText(a.getContext());
		    contentPanel.add(contextInfo.get("todoC"),"cell 1  2");
		    // genPairCPS putStrLn "date" (show "Date") "a.getDate(\"YYYY-MM-DD\")" 3
		    // ---- date ----
		    contextInfo.put("date",new JLabel());
		    contextInfo.get("date").setText("Date");
		    contextInfo.get("date").setHorizontalAlignment(SwingConstants.RIGHT);
		    contentPanel.add(contextInfo.get("date"),"cell 0  3");
		    // ---- dateC ----
		    contextInfo.put("dateC",new JLabel());
		    contextInfo.get("dateC").setText(a.getDate("YYYY-MM-DD"));
		    contentPanel.add(contextInfo.get("dateC"),"cell 1  3");
		}
		else this.dispose();
	    }
	    dialogPane.add(contentPanel, BorderLayout.CENTER);

	    //======== buttonBar ========
	    {
		buttonBar.setLayout(new MigLayout(
						  "insets dialog,alignx right",
						  // columns
						  "[button,fill]",
						  // rows
						  null));

		//---- okButton ----
		okButton.setText("OK");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    okButtonClicked(e);
			}
		    });
		buttonBar.add(okButton, "cell 0 0");
	    }
	    dialogPane.add(buttonBar, BorderLayout.SOUTH);
	}	
	contentPane.add(dialogPane, BorderLayout.CENTER);
	pack();
	setLocationRelativeTo(getOwner());
    }
    private JPanel dialogPane;
    private JPanel contentPanel;
    private HashMap<String,JLabel> contextInfo;
    private JPanel buttonBar;
    private JButton okButton;
    private PIMEntity item;
}
