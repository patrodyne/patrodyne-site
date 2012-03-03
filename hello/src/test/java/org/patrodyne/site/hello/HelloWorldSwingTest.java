// PatroDyne: Patron Supported Dynamic Web Applications
// Released under LGPL license. See terms at http://www.gnu.org.
package org.patrodyne.site.hello;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;

import org.junit.Test;

import static org.patrodyne.site.hello.HelloWorldSwing.NAME_LABEL_HELLO;

/**
 * Unit tests for HelloWorldSwing.
 * 
 * @author Rick O'Sullivan
 */
public class HelloWorldSwingTest
{
	/**
	 * Test method for
	 * {@link org.patrodyne.site.hello.HelloWorldSwing#initialize()}.
	 */
	@Test
	public void testInitialize()
	{
		HelloWorldSwing helloWorldSwing = new HelloWorldSwing("TEST");
		JLabel labelHello = findComponent(helloWorldSwing.frame, NAME_LABEL_HELLO, JLabel.class);
		assertNotNull(labelHello);
		assertEquals("TEST", labelHello.getText());
	}

	/**
	 * Find a AWT component contained in parent for a given name.
	 * 
	 * @param parent Parent AWT component.
	 * @param name Search name.
	 * @param type Search type.
	 * @return A component with the specified name.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T findComponent(Component parent, String name, Class<T> type)
	{
		T findComponent = null;
		if ((parent.getClass() == type) && name.equals(parent.getName()))
			findComponent = (T) parent;
		else if (parent instanceof Container)
		{
			for (Component component : ((Container) parent).getComponents())
			{
				findComponent = findComponent(component, name, type);
				if (findComponent != null)
					break;
			}
		}
		return findComponent;
	}
}
// vi:set tabstop=4 hardtabs=4 shiftwidth=4:
