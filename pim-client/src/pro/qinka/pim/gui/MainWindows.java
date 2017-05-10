/*
 * Created by JFormDesigner on Tue May 09 21:43:43 CST 2017
 */

package pro.qinka.pim.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import pro.qinka.pim.collection.PIMBaseCollection;

/**
 * @author John Lee
 */
public class MainWindows extends JFrame {
    public MainWindows(PIMBaseCollection _bc) {
	super();
	bc = _bc;
	initComponents();
	
    }

    private void di1MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di2MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di3MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di4MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di5MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di6MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di7MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di8MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di9MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di10MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di11MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di12MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di13MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di14MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di15MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di16MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di17MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di18MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di19MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di20MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di21MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di22MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di23MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di24MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di25MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di26MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di27MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di28MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di29MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di30MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di31MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di32MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di33MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di34MouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void di35MouseClicked(MouseEvent e) {
	// TODO add your code here
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
	menuItem5 = new JMenuItem();
	menuItem6 = new JMenuItem();
	menu3 = new JMenu();
	label1 = new JLabel();
	label2 = new JLabel();
	label3 = new JLabel();
	label4 = new JLabel();
	label5 = new JLabel();
	label6 = new JLabel();
	label7 = new JLabel();
	label8 = new JLabel();
	di1 = new DayItem();
	di2 = new DayItem();
	di3 = new DayItem();
	di4 = new DayItem();
	di5 = new DayItem();
	di6 = new DayItem();
	di7 = new DayItem();
	di8 = new DayItem();
	di9 = new DayItem();
	di10 = new DayItem();
	di11 = new DayItem();
	di12 = new DayItem();
	di13 = new DayItem();
	di14 = new DayItem();
	di15 = new DayItem();
	di16 = new DayItem();
	di17 = new DayItem();
	di18 = new DayItem();
	di19 = new DayItem();
	di20 = new DayItem();
	di21 = new DayItem();
	di22 = new DayItem();
	di23 = new DayItem();
	di24 = new DayItem();
	di25 = new DayItem();
	di26 = new DayItem();
	di27 = new DayItem();
	di28 = new DayItem();
	di29 = new DayItem();
	di30 = new DayItem();
	di31 = new DayItem();
	di32 = new DayItem();
	di33 = new DayItem();
	di34 = new DayItem();
	di35 = new DayItem();
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
		menu2.addSeparator();

		//---- menuItem5 ----
		menuItem5.setText("next month");
		menu2.add(menuItem5);

		//---- menuItem6 ----
		menuItem6.setText("previous month");
		menu2.add(menuItem6);
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

	//---- label2 ----
	label2.setHorizontalAlignment(SwingConstants.CENTER);
	label2.setText("Sun");
	contentPane.add(label2, "cell 0 1");

	//---- label3 ----
	label3.setHorizontalAlignment(SwingConstants.CENTER);
	label3.setText("Mon");
	contentPane.add(label3, "cell 1 1");

	//---- label4 ----
	label4.setHorizontalAlignment(SwingConstants.CENTER);
	label4.setText("Tue");
	contentPane.add(label4, "cell 2 1");

	//---- label5 ----
	label5.setHorizontalAlignment(SwingConstants.CENTER);
	label5.setText("Wed");
	contentPane.add(label5, "cell 3 1");

	//---- label6 ----
	label6.setHorizontalAlignment(SwingConstants.CENTER);
	label6.setText("Thu");
	contentPane.add(label6, "cell 4 1");

	//---- label7 ----
	label7.setHorizontalAlignment(SwingConstants.CENTER);
	label7.setText("Fri");
	contentPane.add(label7, "cell 5 1");

	//---- label8 ----
	label8.setHorizontalAlignment(SwingConstants.CENTER);
	label8.setText("Sat");
	contentPane.add(label8, "cell 6 1");

	//---- di1 ----
	di1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di1MouseClicked(e);
		}
	    });
	contentPane.add(di1, "cell 0 2");

	//---- di2 ----
	di2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di2MouseClicked(e);
		}
	    });
	contentPane.add(di2, "cell 1 2");

	//---- di3 ----
	di3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di3MouseClicked(e);
		}
	    });
	contentPane.add(di3, "cell 2 2");

	//---- di4 ----
	di4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di4MouseClicked(e);
		}
	    });
	contentPane.add(di4, "cell 3 2");

	//---- di5 ----
	di5.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di5MouseClicked(e);
		}
	    });
	contentPane.add(di5, "cell 4 2");

	//---- di6 ----
	di6.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di6MouseClicked(e);
		}
	    });
	contentPane.add(di6, "cell 5 2");

	//---- di7 ----
	di7.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di7MouseClicked(e);
		}
	    });
	contentPane.add(di7, "cell 6 2");

	//---- di8 ----
	di8.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di8MouseClicked(e);
		}
	    });
	contentPane.add(di8, "cell 0 3");

	//---- di9 ----
	di9.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di9MouseClicked(e);
		}
	    });
	contentPane.add(di9, "cell 1 3");

	//---- di10 ----
	di10.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di10MouseClicked(e);
		}
	    });
	contentPane.add(di10, "cell 2 3");

	//---- di11 ----
	di11.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di11MouseClicked(e);
		}
	    });
	contentPane.add(di11, "cell 3 3");

	//---- di12 ----
	di12.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di12MouseClicked(e);
		}
	    });
	contentPane.add(di12, "cell 4 3");

	//---- di13 ----
	di13.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di13MouseClicked(e);
		}
	    });
	contentPane.add(di13, "cell 5 3");

	//---- di14 ----
	di14.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di14MouseClicked(e);
		}
	    });
	contentPane.add(di14, "cell 6 3");

	//---- di15 ----
	di15.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di15MouseClicked(e);
		}
	    });
	contentPane.add(di15, "cell 0 4");

	//---- di16 ----
	di16.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di16MouseClicked(e);
		}
	    });
	contentPane.add(di16, "cell 1 4");

	//---- di17 ----
	di17.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di17MouseClicked(e);
		}
	    });
	contentPane.add(di17, "cell 2 4");

	//---- di18 ----
	di18.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di18MouseClicked(e);
		}
	    });
	contentPane.add(di18, "cell 3 4");

	//---- di19 ----
	di19.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di19MouseClicked(e);
		}
	    });
	contentPane.add(di19, "cell 4 4");

	//---- di20 ----
	di20.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di20MouseClicked(e);
		}
	    });
	contentPane.add(di20, "cell 5 4");

	//---- di21 ----
	di21.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di21MouseClicked(e);
		}
	    });
	contentPane.add(di21, "cell 6 4");

	//---- di22 ----
	di22.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di22MouseClicked(e);
		}
	    });
	contentPane.add(di22, "cell 0 5");

	//---- di23 ----
	di23.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di23MouseClicked(e);
		}
	    });
	contentPane.add(di23, "cell 1 5");

	//---- di24 ----
	di24.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di24MouseClicked(e);
		}
	    });
	contentPane.add(di24, "cell 2 5");

	//---- di25 ----
	di25.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di25MouseClicked(e);
		}
	    });
	contentPane.add(di25, "cell 3 5");

	//---- di26 ----
	di26.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di26MouseClicked(e);
		}
	    });
	contentPane.add(di26, "cell 4 5");

	//---- di27 ----
	di27.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di27MouseClicked(e);
		}
	    });
	contentPane.add(di27, "cell 5 5");

	//---- di28 ----
	di28.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di28MouseClicked(e);
		}
	    });
	contentPane.add(di28, "cell 6 5");

	//---- di29 ----
	di29.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di29MouseClicked(e);
		}
	    });
	contentPane.add(di29, "cell 0 6");

	//---- di30 ----
	di30.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di30MouseClicked(e);
		}
	    });
	contentPane.add(di30, "cell 1 6");

	//---- di31 ----
	di31.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di31MouseClicked(e);
		}
	    });
	contentPane.add(di31, "cell 2 6");

	//---- di32 ----
	di32.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di32MouseClicked(e);
		}
	    });
	contentPane.add(di32, "cell 3 6");

	//---- di33 ----
	di33.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di33MouseClicked(e);
		}
	    });
	contentPane.add(di33, "cell 4 6");

	//---- di34 ----
	di34.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di34MouseClicked(e);
		}
	    });
	contentPane.add(di34, "cell 5 6");

	//---- di35 ----
	di35.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    di35MouseClicked(e);
		}
	    });
	contentPane.add(di35, "cell 6 6");

	//======== scrollPane1 ========
	{
	    scrollPane1.setViewportView(list1);
	}
	contentPane.add(scrollPane1, "cell 0 7 7 1");
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
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private DayItem di1;
    private DayItem di2;
    private DayItem di3;
    private DayItem di4;
    private DayItem di5;
    private DayItem di6;
    private DayItem di7;
    private DayItem di8;
    private DayItem di9;
    private DayItem di10;
    private DayItem di11;
    private DayItem di12;
    private DayItem di13;
    private DayItem di14;
    private DayItem di15;
    private DayItem di16;
    private DayItem di17;
    private DayItem di18;
    private DayItem di19;
    private DayItem di20;
    private DayItem di21;
    private DayItem di22;
    private DayItem di23;
    private DayItem di24;
    private DayItem di25;
    private DayItem di26;
    private DayItem di27;
    private DayItem di28;
    private DayItem di29;
    private DayItem di30;
    private DayItem di31;
    private DayItem di32;
    private DayItem di33;
    private DayItem di34;
    private DayItem di35;
    private JScrollPane scrollPane1;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    PIMBaseCollection bc;
}
