/**
 * Cal
 * @author Qinka qinka@live.com me@qinka.pro 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.0
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Cal extends JFrame
{       
    /**
     * Main function
     */
    public static void main(String[] name)
    {
	CalWindows c = new CalWindows("test");
	c.setVisible(true);
	c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
