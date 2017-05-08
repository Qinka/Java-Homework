import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import java.lang.*;
import java.util.*;
/*
 * Created by JFormDesigner on Mon May 08 17:08:48 CST 2017
 */



/**
 * @author John Lee
 */
public class CalWindows extends JFrame {

    private int __result;
    private int __sign;



    public CalWindows(String title) {
	super(title);
	__result = 0;
	__sign = 0;
	initComponents();
    }
    
    private void b7MouseClicked(MouseEvent e) {
	eval.setText(eval.getText()+"7");
    }

    private void b8MouseClicked(MouseEvent e) {
	eval.setText(eval.getText()+"8");
    }

    private void b9MouseClicked(MouseEvent e) {
	eval.setText(eval.getText()+"9");
    }

    private void bPlusMouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void b4MouseClicked(MouseEvent e) {
	eval.setText(eval.getText()+"4");
    }

    private void b5MouseClicked(MouseEvent e) {
	eval.setText(eval.getText()+"5");
    }

    private void b6MouseClicked(MouseEvent e) {
	eval.setText(eval.getText()+"6");
    }

    private void bMinusMouseClicked(MouseEvent e) {
	
    }

    private void b1MouseClicked(MouseEvent e) {
	eval.setText(eval.getText()+"1");
    }

    private void b2MouseClicked(MouseEvent e) {	
	eval.setText(eval.getText()+"2");
    }

    private void b3MouseClicked(MouseEvent e) {
	eval.setText(eval.getText()+"2");
    }

    private void bTimesMouseClicked(MouseEvent e) {
    }

    private void b0MouseClicked(MouseEvent e) {
	if(eval.getText().isEmpty())
	    return;
	else
	    eval.setText(eval.getText()+"0");
    }

    private void bCRLMouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void bEqMouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void bDivMouseClicked(MouseEvent e) {
	// TODO add your code here
    }

    private void initComponents() {
	// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
	// Generated using JFormDesigner Evaluation license - John Lee
	eval = new JTextField();
	b7 = new JButton();
	b8 = new JButton();
	b9 = new JButton();
	bPlus = new JButton();
	b4 = new JButton();
	b5 = new JButton();
	b6 = new JButton();
	bMinus = new JButton();
	b1 = new JButton();
	b2 = new JButton();
	b3 = new JButton();
	bTimes = new JButton();
	b0 = new JButton();
	bCRL = new JButton();
	bEq = new JButton();
	bDiv = new JButton();

	//======== this ========
	Container contentPane = getContentPane();
	contentPane.setLayout(new MigLayout(
					    "hidemode 3,alignx center",
					    // columns
					    "[17,fill]" +
					    "[fill]" +
					    "[fill]" +
					    "[fill]",
					    // rows
					    "[]" +
					    "[]" +
					    "[]" +
					    "[]" +
					    "[]"));
	contentPane.add(eval, "cell 0 0 4 1,growx");

	//---- b7 ----
	b7.setText("7");
	b7.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b7MouseClicked(e);
		}
	    });
	contentPane.add(b7, "cell 0 1,grow");

	//---- b8 ----
	b8.setText("8");
	b8.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b8MouseClicked(e);
		}
	    });
	contentPane.add(b8, "cell 1 1,grow");

	//---- b9 ----
	b9.setText("9");
	b9.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b9MouseClicked(e);
		}
	    });
	contentPane.add(b9, "cell 2 1,grow");

	//---- bPlus ----
	bPlus.setText("+");
	bPlus.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    bPlusMouseClicked(e);
		}
	    });
	contentPane.add(bPlus, "cell 3 1,grow");

	//---- b4 ----
	b4.setText("4");
	b4.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b4MouseClicked(e);
		}
	    });
	contentPane.add(b4, "cell 0 2,grow");

	//---- b5 ----
	b5.setText("5");
	b5.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b5MouseClicked(e);
		}
	    });
	contentPane.add(b5, "cell 1 2,grow");

	//---- b6 ----
	b6.setText("6");
	b6.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b6MouseClicked(e);
		}
	    });
	contentPane.add(b6, "cell 2 2,grow");

	//---- bMinus ----
	bMinus.setText("-");
	bMinus.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    bMinusMouseClicked(e);
		}
	    });
	contentPane.add(bMinus, "cell 3 2,grow");

	//---- b1 ----
	b1.setText("1");
	b1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b1MouseClicked(e);
		}
	    });
	contentPane.add(b1, "cell 0 3,grow");

	//---- b2 ----
	b2.setText("2");
	b2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b2MouseClicked(e);
		}
	    });
	contentPane.add(b2, "cell 1 3,grow");

	//---- b3 ----
	b3.setText("3");
	b3.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b3MouseClicked(e);
		}
	    });
	contentPane.add(b3, "cell 2 3,grow");

	//---- bTimes ----
	bTimes.setText("*");
	bTimes.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    bTimesMouseClicked(e);
		}
	    });
	contentPane.add(bTimes, "cell 3 3,grow");

	//---- b0 ----
	b0.setText("0");
	b0.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    b0MouseClicked(e);
		}
	    });
	contentPane.add(b0, "cell 0 4,grow");

	//---- bCRL ----
	bCRL.setText("CLR");
	bCRL.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    bCRLMouseClicked(e);
		}
	    });
	contentPane.add(bCRL, "cell 1 4,grow");

	//---- bEq ----
	bEq.setText("=");
	bEq.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    bEqMouseClicked(e);
		}
	    });
	contentPane.add(bEq, "cell 2 4,grow");

	//---- bDiv ----
	bDiv.setText("/");
	bDiv.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    bDivMouseClicked(e);
		}
	    });
	contentPane.add(bDiv, "cell 3 4,grow");
	pack();
	setLocationRelativeTo(getOwner());
	// JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - John Lee
    private JTextField eval;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton bPlus;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton bMinus;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton bTimes;
    private JButton b0;
    private JButton bCRL;
    private JButton bEq;
    private JButton bDiv;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
