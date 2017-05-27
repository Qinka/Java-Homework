package pro.qinka.pim.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.lang.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

import pro.qinka.pim.collection.*;
import pro.qinka.pim.entity.*;

/**
 * Main Window
 * 
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.10
 *
 * The main windows of the GUI part.
 */
public class MainWindows extends JFrame {
    /**
     * the constructor of the MainWindows
     * @param _bc the basic collection that means just a collection, instanced of PIMBaseCollection is fine.
     * @param __own the owner of the items which will be display, and this field will be used in adding.
     */
    public MainWindows(PIMBaseCollection _bc,String __own) {
	super();
	bc = _bc;
	own = __own;
	diList = new ArrayList<DayItem>();
	gcl = new GregorianCalendar();
	changeListener = new HashSet<PIMCListener>();
	initComponents();
    }

    private ArrayList<DayItem> diList;
    private String own;
    private int __week_delta;
    
    private GregorianCalendar gcl;
    
    /**
     * Empty event of one mouse clicked.
     * @param index the event id of which item was clicked.
     * ＠param e the event of the mouse.
     */
    private void diMouseClicked(int index,MouseEvent e) {
    }
    
    /**
     * the callback of the event when the windows is ready.
     * It will send request to load the collection from the remote backend, database, or the file.
     * @param e the windows event
     */
    private void thisWindowsReady(WindowEvent e) {
	if(bc instanceof PIMCollectionStored) {
	    PIMCollectionStored sc = (PIMCollectionStored)bc;
	    if(e.getNewState() == WindowEvent.WINDOW_OPENED) {
		sc.pull();
		System.out.println("pull");
	    }
	    else if(e.getNewState() == WindowEvent.WINDOW_CLOSING) {
		sc.push();
		System.out.println("push");
	    }
	}
	
    }

    /**
     * The event when the pim's collection changed.
     * @param i the id of the event such as the pull or  push. Details can be found at the following definition of the Adapter.
     */
    private void pimcollectonChanged(int i) {
	updateCal();
    }

    /**
     * the method of the event when the button, which is used to jump to the previous month, was clicked.
     * @param e the AWT event.
     */
    private void preMonthMouseClicked(AWTEvent e) {
	gcl.add(Calendar.MONTH, -1);
	updateCal();
    }

    /**
     * the method of the event when the button, which is used to jump yo the next month, was clicked.
     * @param e the AWT event.
     */
    private void nextMonthMouseClicked(AWTEvent e) {
	gcl.add(Calendar.MONTH, 1);
	updateCal();
    }

    /**
     * The method of action when the connection between the remote and the client will be disconnected.
     * @param e AWT event.
     */
    private void disconnectClicked(AWTEvent e) {
	JFrame jf = new ConnectionWindows();
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(false);
	jf.setVisible(true);
	this.dispose();
    }
    private void quitClicked(AWTEvent e) {
	this.dispose();
    }

    /**
     * the method for when the pull-action need to be done, in an asynchronous way.
     */
    private void invokePull() {
	SwingWorker<Object,Void> invoke = new SwingWorker() {
		@Override
		protected Object doInBackground() {
		    if(bc instanceof PIMCollectionStored)
			((PIMCollectionStored)bc).pull();
		    return new Object();
		}
		@Override
		protected void done() {
		    changePIMC(PIMCListener.PIMPULLED);
		}
	    };
	invoke.execute();
    }
    /**
     * the method for when the pull-action need to be done, in an asynchronous way.
     */
    private void invokePush() {
	SwingWorker<Object,Void> invoke = new SwingWorker() {
		@Override
		protected Object doInBackground() {
		    if(bc instanceof PIMCollectionStored)
			((PIMCollectionStored)bc).push();
		    return new Object();
		}
		@Override
		protected void done() {
		    changePIMC(PIMCListener.PIMPUSHED);
		}
	    };
	invoke.execute();
    }

    /**
     * the method when the list clicked
     * @param e AWT event
     */
    private void listClicked(AWTEvent e) {
	Vector<String> tmpNote = bc.stream().filter(pim -> pim instanceof PIMNote).map(pim -> (PIMNote) pim).map(pim -> "N " + pim.getContext()).collect(Collectors.toCollection(Vector<String>::new));
	__base = tmpNote.size();
	Vector<String> tmpCon = bc.stream().filter(pim -> pim instanceof PIMContact).map(pim -> (PIMContact) pim).map(pim -> "C " + pim.getFirstName() + " " + pim.getLastName() + "\n\temail " + pim.getEmail()).collect(Collectors.toCollection(Vector<String>::new));
	tmpNote.addAll(tmpCon);
	list1.setListData(tmpNote);
    }

    /**
     * the method of the action when the item clicked.
     * @param e  AWT event
     */
    private void itemClicked(AWTEvent e) {
	int index = list1.getSelectedIndex();
	if (index != -1) {
	    PIMEntity sel = null;
	    if (index >= __base) {
		index -= __base;
		sel = bc.getContacts().get(index);
	    }
	    else
	        sel = bc.getNotes().get(index);		
	    if (sel != null)
		new ShowItem(sel).setVisible(true);
	}
    }
    
    /**
     * The method of the event when there is an item to be create and the buton or menu was clicked.
     * @param e AWT event
     */
    private void createClicked(AWTEvent e) {
	new AddItem(bc,own,i -> { changePIMC(i.intValue());return i;}).setVisible(true);
    }
    
    /**
     * the initial method of the windows
     */
    private void initComponents() {
	menuBar1 = new JMenuBar();
	remoteMenu = new JMenu();
	remoteSaveMenu = new JMenuItem();
	remoteLoadMenu = new JMenuItem();
	operationMenu = new JMenu();
	operationListMenu = new JMenuItem();
	operationCreateMenu = new JMenuItem();
	optNextMonMenu = new JMenuItem();
	optPreMonMenu = new JMenuItem();
	pimMenu = new JMenu();
	disConnectMenu = new JMenuItem();
	quitMenu = new JMenuItem();
	preMonth = new JButton();
	yearmonth = new JLabel();
	nextMonth = new JButton();
	sunLab = new JLabel();
	monLab = new JLabel();
	tueLab = new JLabel();
	wedLab = new JLabel();
	thuLab = new JLabel();
	friLab = new JLabel();
	satLab = new JLabel();
	diList = new ArrayList<DayItem>();
	scrollPane1 = new JScrollPane();
	list1 = new JList();
	
	//======== this ========
	setTitle("Personal Information Manager GUI");
	setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
	addWindowStateListener(e -> thisWindowsReady(e));
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
					    "[36]0" +
					    "[22]0" +
					    "[grow,fill]0" +
					    "[grow,fill]0" +
					    "[grow,fill]0" +
					    "[grow,fill]0" +
					    "[grow,fill]0" +
					    "[grow,fill]0"));

	//======== menuBar1 ========
	{
	    
	    //======== pimMenu ========
	    {
		pimMenu.setText("PIM");
		//---- disConnectMenu ----
		disConnectMenu.setText("Disconnect");
		disConnectMenu.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
			    disconnectClicked(e);
			}
		    });
		pimMenu.add(disConnectMenu);

		//---- quitMenu ----
		quitMenu.setText("Quit");
		quitMenu.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
			    quitClicked(e);
			}
		    });
		pimMenu.add(quitMenu);
	    }
	    menuBar1.add(pimMenu);

	    //======== remoteMenu ========
	    {
		remoteMenu.setText("Remote");

		//---- remoteSaveMenu ----
		remoteSaveMenu.setText("Save");
		remoteSaveMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    invokePush();
			}
		    });
			    
		remoteMenu.add(remoteSaveMenu);

		//---- remoteLoadMenu ----
		remoteLoadMenu.setText("Load");
		remoteLoadMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    invokePull();
			}
		    });
		remoteMenu.add(remoteLoadMenu);
	    }
	    menuBar1.add(remoteMenu);

	    //======== operationMenu ========
	    {
		operationMenu.setText("Operation");

		//---- operationListMenu ----
		operationListMenu.setText("List");
		operationListMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    listClicked(e);
			}
		    });
		operationMenu.add(operationListMenu);

		//---- operationcreatemenu ----
		operationCreateMenu.setText("Create");
		operationCreateMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    createClicked(e);
			}
		    });
		operationMenu.add(operationCreateMenu);
		    
		operationMenu.addSeparator();

		//---- optNextMonMenu ----
		optNextMonMenu.setText("next month");
		optNextMonMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    nextMonthMouseClicked(e);
			}
		    });
		operationMenu.add(optNextMonMenu);

		//---- optPreMonMenu ----
		optPreMonMenu.setText("previous month");
		optPreMonMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    preMonthMouseClicked(e);
			}
		    });
		operationMenu.add(optPreMonMenu);
	    }
	    menuBar1.add(operationMenu);
	}
	setJMenuBar(menuBar1);

	//---- preMonth ----
	preMonth.setText("<");
	preMonth.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    preMonthMouseClicked(e);
		}
	    });
	contentPane.add(preMonth, "cell 0 0");

	//---- yearmonth ----
	yearmonth.setHorizontalAlignment(SwingConstants.CENTER);
	yearmonth.setFont(yearmonth.getFont().deriveFont(yearmonth.getFont().getStyle() | Font.BOLD, yearmonth.getFont().getSize() + 8f));
	contentPane.add(yearmonth, "cell 1 0 5 1");
		    
	//---- nextMonth ----
	nextMonth.setText(">");
	nextMonth.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    nextMonthMouseClicked(e);
		}
	    });
	contentPane.add(nextMonth, "cell 6 0");

	//---- sunLab ----
	sunLab.setHorizontalAlignment(SwingConstants.CENTER);
	sunLab.setText("Sun");
	sunLab.setVisible(false);
	contentPane.add(sunLab, "cell 0 1");

	//---- monLab ----
	monLab.setHorizontalAlignment(SwingConstants.CENTER);
	monLab.setText("Mon");
	monLab.setVisible(false);
	contentPane.add(monLab, "cell 1 1");

	//---- tueLab ----
	tueLab.setHorizontalAlignment(SwingConstants.CENTER);
	tueLab.setText("Tue");
	tueLab.setVisible(false);
	contentPane.add(tueLab, "cell 2 1");

	//---- wedLab ----
	wedLab.setHorizontalAlignment(SwingConstants.CENTER);
	wedLab.setText("Wed");
	wedLab.setVisible(false);
	contentPane.add(wedLab, "cell 3 1");

	//---- thuLab ----
	thuLab.setHorizontalAlignment(SwingConstants.CENTER);
	thuLab.setText("Thu");
	thuLab.setVisible(false);
	contentPane.add(thuLab, "cell 4 1");

	//---- friLab ----
	friLab.setHorizontalAlignment(SwingConstants.CENTER);
	friLab.setText("Fri");
	friLab.setVisible(false);
	contentPane.add(friLab, "cell 5 1");

	//---- satLab ----
	satLab.setHorizontalAlignment(SwingConstants.CENTER);
	satLab.setText("Sat");
	satLab.setVisible(false);
	contentPane.add(satLab, "cell 6 1");


	//--- change listener
	this.addPIMCChangeListener(new PIMCListener() {
		@Override
		public void collectionUpdate(int i) {
		    pimcollectonChanged(i);
		}
	    });
	
	for(int j = 2;j<8;j++)
	    for(int i = 0;i<7;i++) {
		final int index = i+(j-2)*7;
		DayItem item = new DayItem();
		item.setVisible(false);		
		item.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    diMouseClicked(index,e);
			}
		    });
		diList.add(item);
		contentPane.add(item,"cell "+String.valueOf(i)+" "+String.valueOf(j));
	    }
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
	contentPane.add(scrollPane1, "cell 0 8 7 1");
	invokePull();
	pack();
	setLocationRelativeTo(getOwner());
    }
	
    /**
     * the method about update calender
     */
    private void updateCal() {
	for (DayItem item:diList) {
	    item.setVisible(false);
	    item.cleanItem();
	}
	sunLab.setVisible(true);
	monLab.setVisible(true);
	tueLab.setVisible(true);
	wedLab.setVisible(true);
	thuLab.setVisible(true);
	friLab.setVisible(true);
	satLab.setVisible(true);
	gcl.set(Calendar.DAY_OF_MONTH, 1);
	int month = gcl.get(Calendar.MONTH);
	yearmonth.setText(String.valueOf(gcl.get(Calendar.YEAR)) + "-" +
			  String.valueOf(gcl.get(Calendar.MONTH)+1));
	int week_delta = gcl.get(Calendar.DAY_OF_WEEK) - 2;
	yearmonth.setVisible(true);
	while( month == gcl.get(Calendar.MONTH)) {
	    int today = gcl.get(Calendar.DAY_OF_MONTH);
	    DayItem item = diList.get(week_delta + today);
	    item.setDays(gcl.get(Calendar.DAY_OF_MONTH));
	    item.setVisible(true);
	    for(PIMEntity each:bc.getItemsForDate(gcl.getTime())) {
		if(each == null) System.out.println(">>HOW?? null");
		else item.addItem(each);
	    }
	    gcl.add(Calendar.DAY_OF_MONTH, 1);
	}
	gcl.add(Calendar.MONTH, -1);
	this.pack();
    }
    
    private JMenuBar menuBar1;
    private JMenu remoteMenu;
    private JMenuItem remoteSaveMenu;
    private JMenuItem remoteLoadMenu;
    private JMenu operationMenu;
    private JMenuItem operationListMenu;
    private JMenuItem operationCreateMenu;
    private JMenuItem optNextMonMenu;
    private JMenuItem optPreMonMenu;
    private JMenu pimMenu;
    private JMenuItem disConnectMenu;
    private JMenuItem quitMenu;
    private JButton preMonth;
    private JLabel yearmonth;
    private JButton nextMonth;
    private JLabel sunLab;
    private JLabel monLab;
    private JLabel tueLab;
    private JLabel wedLab;
    private JLabel thuLab;
    private JLabel friLab;
    private JLabel satLab;
    private JScrollPane scrollPane1;
    private JList list1;
    private int __base;

    PIMBaseCollection bc;
    private HashSet<PIMCListener> changeListener;

    private void changePIMC(int state) {
	for(PIMCListener i:changeListener)
	    i.collectionUpdate(state);
    }

    public void addPIMCChangeListener(PIMCListener pl){
	changeListener.add(pl);
    }

    interface PIMCListener extends EventListener {
	public static final int PIMPUSHED = 0;
	public static final int PIMPULLED = 1;
	public void collectionUpdate(int i);
    }
}
