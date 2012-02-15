// PatroDyne: Patron Supported Dynamic Executables, http://patrodyne.org
// Released under LGPL license. See terms at http://www.gnu.org.
package org.patrodyne.site.hello;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Demonstration of a Swing application with a SLF4J logger. */
public class HelloWorldSwing implements Runnable 
{
	/** Represents a logger. */
	protected static Logger log = LoggerFactory.getLogger(HelloWorldSwing.class);

	private String title = "";
	/** 
	 * Get a title for the main frame.
	 * @return A title string.
	 */
	protected String getTitle()
	{ 
		return title;
	}
	/**
	 * Set a title for the main frame.
	 * @param title text for the main window frame.
	 */
	protected void setTitle(String title)
	{
		this.title = title;
	}

	/** Construct with a title for the frame. */
	public HelloWorldSwing(String title)
	{
		setTitle(title);
	}

	/** 
	 * Start application in in the dispatch thread of the AWT EventQueue,
	 * for thread safety.
	 */
	public static void start(String title)
	{
		EventQueue.invokeLater(new HelloWorldSwing(title));
	}

	/** 
	 * Run this application in the AWT event dispatching thread,
	 * for thread safety. Initialize a frame, set its size to a small
	 * portion of the screen and center it, set a title and make the
	 * frame visible.
	 */
	public void run()
	{
		log.info(getTitle()+": Start");

		// Initialize a frame.
		JFrame frame = new JFrame(getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Make the frame a fraction of the height and width
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width/6, height/16);

		// Add content.
		final JLabel label = new JLabel(getTitle());
		frame.getContentPane().add(label);

		// Center the frame on screen
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		log.info(title+": Finish");
	}
}
// vi:set tabstop=4 hardtabs=4 shiftwidth=4:
