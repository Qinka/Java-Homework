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
     * Field: Text Buffer
     * Display the text
     */
    private JTextField textBuffer;
    /**
     * The method to init the textBuffer
     */
    private JTextField initTextBuffer()
    { 
	if(textBuffer == null)
	    {
		textBuffer = new JTextField();
		textBuffer.setBounds(96, 49, 160, 20);
		textBuffer.setEditable(false);
	    }
	return textBuffer;
    }
    
    public Cal()
    {
	super();
	this.setSize(300, 200); 
	this.getContentPane().setLayout(null); 
	this.add(initTextBuffer(), null); 
	//this.add(getJTextField(), null); 
	//this.add(getJButton(), null); 
	this.setTitle("Calculator"); 
    }


    /**
     * Main function
     */
    public static void main(String[] name)
    {
	Cal c = new Cal();
	c.setVisible(true);
    }
}
