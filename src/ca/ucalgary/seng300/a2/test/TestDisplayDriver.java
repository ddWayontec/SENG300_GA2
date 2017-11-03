package ca.ucalgary.seng300.a2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.lsmr.vending.hardware.DisabledException;
import org.lsmr.vending.hardware.Display;

import ca.ucalgary.seng300.a2.DispListener;
import ca.ucalgary.seng300.a2.DisplayDriver;

public class TestDisplayDriver {

	private DispListener testDisplayListener;
	private Display dummyDisplay = new Display();
	private DisplayDriver displayDriver = new DisplayDriver(dummyDisplay);

	@Before
	public void setup() throws Exception {

		// Instantiate a testlistener to receive messages with this test class
		testDisplayListener = new DispListener();
		dummyDisplay.register(testDisplayListener);
	}

	////////////////////////////////////////////////////////////////////////
	// Test Display Driver
	////////////////////////////////////////////////////////////////////////

	/**
	 * Tests default message display
	 *
	 * Note: This test should be disabled if shorter test times are desired Note:
	 * Due to this running threaded, if some processes take up a larger amount of
	 * time, it is possible this test might fail, as it is dependent on delays and
	 * timing
	 *
	 * @throws DisabledException
	 * @throws InterruptedException
	 */
	@Test
	public void testDefaultGreeting() throws DisabledException, InterruptedException {

		// ensure the default greeting is displaying correctly.
		displayDriver.greetingMessage();
		Thread.sleep(2000); // initial delay
		for (int i = 0; i < 3; i++) { // Loops 3 times
			assertEquals("Hi there!", testDisplayListener.getMessageLast());
			Thread.sleep(5000);
			assertEquals("", testDisplayListener.getMessageLast());
			Thread.sleep(10000);
		}
	}

	/**
	 * Test to make sure greeting message is not still displaying after display is
	 * updated with new message
	 *
	 * @throws DisabledException
	 * @throws InterruptedException
	 */
	@Test
	public void testMessageUpdate() throws DisabledException, InterruptedException {
		// ensure that default greeting is still not scheduled after coin is added, or
		// display is updated.
		displayDriver.greetingMessage();
		Thread.sleep(8000); // let the default message be displayed for 8 seconds
		displayDriver.newMessage("Credit: $  1.00");
		Thread.sleep(15000);
		assertEquals("Credit: $  1.00", testDisplayListener.getMessageLast()); // ensure thread has not been replaced by
																				// default greeting
	}

	/**
	 * Test a newMessage(message, duration, resumeGreeting) - Check duration of
	 * message and see if Greeting plays after a message is displaye
	 *
	 * @throws DisabledException
	 * @throws InterruptedException
	 */
	@Test
	public void testNewMessageDurationWithGreeting() throws DisabledException, InterruptedException {
		// ensure that default greeting is still not scheduled after coin is added, or
		// display is updated.
		displayDriver.newMessage("Greeting After Message", 5, true);
		Thread.sleep(6000);
		assertEquals("Hi there!", testDisplayListener.getMessageLast());
		displayDriver.clearMessage();
	}

	/**
	 * Test a newMessage(message, duration, resumeGreeting) - Check duration of
	 * message and see if Greeting plays after a message is displaye
	 *
	 * @throws DisabledException
	 * @throws InterruptedException
	 */
	@Test
	public void testNewMessageDurationNoGreeting() throws DisabledException, InterruptedException {
		// ensure that default greeting is still not scheduled after coin is added, or
		// display is updated.
		displayDriver.newMessage("No Greeting", 5, false);
		Thread.sleep(7000);
		assertEquals("", testDisplayListener.getMessageCurrent());
		displayDriver.clearMessage();
	}

}