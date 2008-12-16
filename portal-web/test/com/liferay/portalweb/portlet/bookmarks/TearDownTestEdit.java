/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portalweb.portlet.bookmarks;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * <a href="TearDownTestEdit.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class TearDownTestEdit extends BaseTestCase {
	public void testTearDown() throws Exception {
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Bookmarks Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("link=Bookmarks Test Page"));
		selenium.waitForPageToLoad("30000");

		if (selenium.isElementPresent("//b")) {
			selenium.click(RuntimeVariables.replace("//b"));
			selenium.waitForPageToLoad("30000");

			if (selenium.isElementPresent("//b")) {
				selenium.click(RuntimeVariables.replace("//b"));
				selenium.waitForPageToLoad("30000");

				if (selenium.isElementPresent("//strong/span")) {
					selenium.click("//strong/span");

					for (int second = 0;; second++) {
						if (second >= 60) {
							fail("timeout");
						}

						try {
							if (selenium.isElementPresent("//img[@alt='Delete']")) {
								break;
							}
						}
						catch (Exception e) {
						}

						Thread.sleep(1000);
					}

					selenium.click(RuntimeVariables.replace("//img[@alt='Delete']"));
					selenium.waitForPageToLoad("30000");
					assertTrue(selenium.getConfirmation()
									   .matches("^Are you sure you want to delete this[\\s\\S]$"));
					assertFalse(selenium.isElementPresent("link=http://www.narutofan.com"));
					assertTrue(selenium.isTextPresent(
							"Your request processed successfully."));
				}
				selenium.click(RuntimeVariables.replace("link=Test Folder"));
				selenium.waitForPageToLoad("30000");
				selenium.click("//strong/span");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("link=Delete")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.click(RuntimeVariables.replace("link=Delete"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to delete this[\\s\\S]$"));
				assertFalse(selenium.isElementPresent("link=Test Subfolder"));
				assertTrue(selenium.isTextPresent(
						"Your request processed successfully."));
			}
			selenium.click(RuntimeVariables.replace("//span[1]/a"));
			selenium.waitForPageToLoad("30000");
			selenium.click("//strong/span");

			for (int second = 0;; second++) {
				if (second >= 60) {
					fail("timeout");
				}

				try {
					if (selenium.isElementPresent("link=Delete")) {
						break;
					}
				}
				catch (Exception e) {
				}

				Thread.sleep(1000);
			}

			selenium.click(RuntimeVariables.replace("link=Delete"));
			selenium.waitForPageToLoad("30000");
			assertTrue(selenium.getConfirmation()
							   .matches("^Are you sure you want to delete this[\\s\\S]$"));
			assertFalse(selenium.isElementPresent("link=Test Folder"));
			assertTrue(selenium.isTextPresent(
					"Your request processed successfully."));
			selenium.click(RuntimeVariables.replace("link=Return to Full Page"));
			selenium.waitForPageToLoad("30000");
		}
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//img[@alt='Remove']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click("//img[@alt='Remove']");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to remove this component[\\s\\S]$"));
		assertFalse(selenium.isElementPresent("//input[@value='Add Folder']"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//div[2]/ul/li[1]/a/span")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("//div[2]/ul/li[1]/a/span"));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Manage Pages")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("link=Manage Pages"));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//li[2]/ul/li[3]/a/span")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("//li[2]/ul/li[3]/a/span"));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("link=Page"));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//input[@value='Delete']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("//input[@value='Delete']"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getConfirmation()
						   .matches("^Are you sure you want to delete the selected page[\\s\\S]$"));
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("//div[2]/ul/li[1]/a/span")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("//div[2]/ul/li[1]/a/span"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isElementPresent("link=Bookmark Test Page"));
	}
}