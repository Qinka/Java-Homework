
import pro.qinka.pim.gui.ConnectionWindows;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Test {
    public static void main(String[] args) {
        JFrame jf = new ConnectionWindows();
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
