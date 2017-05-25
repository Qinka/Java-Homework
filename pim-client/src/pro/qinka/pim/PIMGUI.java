package pro.qinka.pim;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import pro.qinka.pim.gui.*;

/**
 * PIMGUI
 * @author Qinka me@qinka.pro qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.2.0.10
 * 
 * The GUI of PIM
 * 
 */
public class PIMGUI {
    public static void main(String[] args) {
        JFrame jf = new ConnectionWindows();
	jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	jf.setVisible(true);
    }
}
