package ca.ucalgary.seng300.a1.test;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.Arrays;
import java.util.List;

import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;
import ca.ucalgary.seng300.a1.*;


public class VendingListenerSystemTest {
	
	private VendingMachine machine = null;
	private VendingManager manager = null;
	private CoinSlot slot = null;
	private SelectionButton cokeButton = null;
	private SelectionButton spriteButton = null;
	private SelectionButton crushButton = null;
	private SelectionButton aleButton = null;
	private SelectionButton pepsiButton = null;
	private SelectionButton dietButton = null;
	
	@Before
	public void setup() throws Exception{
		
		List<String> popCanNames = Arrays.asList("Coke", "Sprite", "Crush", "Ale", "Pepsi", "Diet");
		List<Integer> popCanCosts = Arrays.asList(250,250,250,250,250,250);
		
		// Initialize accepted currency. Non-changing.
		int[] coinKinds = {5, 10, 25, 100,200};
		Coin nickel = new Coin(5);
		Coin dime = new Coin(10);
		Coin quarter = new Coin(25);
		Coin loonie = new Coin(100);
		Coin toonie = new Coin(200);
		
		// Set-up the Vending Machine
		// - Accepts Canadian Currency
		// - Has 6 selection buttons. (6 types of pop)
		// - Coin Rack capacity of 15 in Mr.Client's updated response to competing group.
		// - Pop Rack capacity of 10 to hold 10 of each types of pop.
		// - Receptacle capacity of 200 in Mr. Client's updated response to competing group.
		machine = new VendingMachine(coinKinds, 6, 15, 10, 200);
		machine.configure(popCanNames, popCanCosts);
		
		VendingManager.initialize(machine);
		manager = VendingManager.getInstance();
		slot = machine.getCoinSlot();
		cokeButton = machine.getSelectionButton(0);
		spriteButton = machine.getSelectionButton(1);
		crushButton = machine.getSelectionButton(2);
		aleButton = machine.getSelectionButton(3);
		pepsiButton = machine.getSelectionButton(4);
		dietButton = machine.getSelectionButton(5);
		
	}
	
	@Test
	public void loser() {
		cokeButton.press();
		Deliverable[] dispensed = machine.getDeliveryChute().removeItems();
		for (Deliverable each : dispensed){
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
