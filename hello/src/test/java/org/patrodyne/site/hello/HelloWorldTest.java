// PatroDyne: Patron Supported Dynamic Executables, http://patrodyne.org
// Released under LGPL license. See terms at http://www.gnu.org.

package org.patrodyne.site.hello;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for HelloWorld application.
 * 
 * @author Rick O'Sullivan
 */
public class HelloWorldTest
{
	/**
	 * Test method for {@link org.patrodyne.site.hello.HelloWorld#helloUser()}.
	 */
	@Test
	public void testHelloUser()
	{
		String helloUser = HelloWorld.helloUser();
		assertNotNull(helloUser);
		assertTrue(helloUser.startsWith(HelloWorld.SALUTATION));
	}
}
// vi:set tabstop=4 hardtabs=4 shiftwidth=4:
