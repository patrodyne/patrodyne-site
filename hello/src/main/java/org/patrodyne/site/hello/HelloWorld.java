// PatroDyne: Patron Supported Dynamic Executables
// Released under LGPL license. See terms at http://www.gnu.org.
package org.patrodyne.site.hello;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import java.io.StringWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// Launch a HelloWorld application.
// By design, this class must have minimal library dependencies
// to ensure that it can activate. Once activated, it can catch
// exceptions and display them to the console and/or the desktop.
public class HelloWorld
{
	// Start application using command line arguments
	public static void main(String[] args)
	{
		try
		{
			String title = args.length > 0 ? args[0] : helloUser();
			HelloWorldSwing.start(title);
		}
		catch ( Throwable t)
		{
			errorHandler(t);
		}
	}

	private static String helloUser()
	{
		String helloUser = "Hello World";
		String userName = System.getProperty("user.name");
		if ( userName != null && !userName.isEmpty() )
		{
			helloUser = "Hello ";
			helloUser += userName.substring(0,1).toUpperCase();
			helloUser += userName.substring(1).toLowerCase();
		}
		return helloUser;
	}

	// Handle throwable errors
	private static void errorHandler(Throwable t) 
	{
		// Print stack trace to console.
		t.printStackTrace();

		// Display stack trace to the desktop, when available.
		if ( !GraphicsEnvironment.isHeadless() )
		{
			// Create and configure a text area - fill it with exception text.
			final JTextArea textArea = new JTextArea();
			textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
			textArea.setEditable(false);
			StringWriter writer = new StringWriter();
			t.printStackTrace(new PrintWriter(writer));
			textArea.setText(writer.toString());
			
			// Stuff it in a scrollpane with a controlled size.
			JScrollPane scrollPane = new JScrollPane(textArea);		
			scrollPane.setPreferredSize(new Dimension(600, 360));
			
			// Pass the scrollpane to the joptionpane.				
			String title = HelloWorld.class.getSimpleName()+" Exception";
			JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.ERROR_MESSAGE);
		}
	}
}
// vi:set tabstop=4 hardtabs=4 shiftwidth=4:
