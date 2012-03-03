// PatroDyne: Patron Supported Dynamic Executables, http://patrodyne.org
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

/**
 * Launch the HelloWorld application.
 * 
 * By design, this class depends only on default packages to limit class loader
 * exceptions. Once activated, it starts the actual application by transferring
 * control to the HelloWorldSwing class. This class catches exceptions for
 * display to the console and/or the desktop.
 * 
 * Other classes import optional packages using the standard extension
 * mechanism. The extension path is specified using a system property,
 * java.ext.dirs.
 */
public class HelloWorld
{
	protected static final String SALUTATION = "Hello";
	
	/**
	 * Launch the application. An optional user name can be specified as the
	 * first argument; otherwise, the system user name is used. Throwables are
	 * trapped for error handling.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(String[] args)
	{
		try
		{
			String title = args.length > 0 ? args[0] : helloUser();
			HelloWorldSwing.start(title);
		}
		catch (Throwable t)
		{
			errorHandler(t);
		}
	}

	/**
	 * Retrieve the user name from the system, capitalize the first letter and
	 * append it to Hello for a proper salutation.
	 * 
	 * @return A Hello User string.
	 */
	protected static String helloUser()
	{
		String helloUser = SALUTATION + " World";
		String userName = System.getProperty("user.name");
		if (userName != null && !userName.isEmpty())
		{
			helloUser = SALUTATION;
			helloUser += " ";
			helloUser += userName.substring(0, 1).toUpperCase();
			helloUser += userName.substring(1).toLowerCase();
		}
		return helloUser;
	}

	/**
	 * Handle throwable exceptions by 1) printing the stack trace to the
	 * standard error stream and 2) in a windowing system, display the stack
	 * trace in a message dialog.
	 * 
	 * @param t A throwable exception
	 */
	protected static void errorHandler(Throwable t)
	{
		// Print stack trace to console.
		t.printStackTrace();
		
		// Display stack trace to the desktop, when available.
		if (!GraphicsEnvironment.isHeadless())
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
			String title = HelloWorld.class.getSimpleName() + " Exception";
			JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.ERROR_MESSAGE);
		}
	}
}
// vi:set tabstop=4 hardtabs=4 shiftwidth=4:
