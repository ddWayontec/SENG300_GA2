package ca.ucalgary.seng300.a1;

import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;
import ca.ucalgary.seng300.a1.VendingManager;

public class VendingListener implements CoinSlotListener, SelectionButtonListener {
	private static VendingListener listener;
	private VendingManager mgr = VendingManager.getInstance();
	
	private VendingListener (){}
	
	/**
	 * Forces the existing singleton instance to be replaced.
	 * Called by VendingManager during its instantiation.
	 */
	protected static void initialize(){		
		listener = new VendingListener();
	}
	
	/**
	 * Provides access to the singleton instance for package-internal classes.
	 * @return The singleton VendingListener instance  
	 */
	protected static VendingListener getInstance(){
		return listener;
	}

	// Currently unneeded listener events.
	@Override
	public void coinRejected(CoinSlot slot, Coin coin) {}
	@Override
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {}
	@Override
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {}


	/**
	 * Responds to "pressed" notifications from registered SelectionButtons. 
	 */
	@Override
	public void pressed(SelectionButton button) {
		int bIndex = mgr.getButtonIndex(button); 
		if (bIndex == -1){
			//Then it's not a pop selection button. 
			//This may be where we handle "change return" button presses
		}
		else{
			try{
				//Assumes a 1-to-1, strictly ordered mapping between popIndex and and butttonindex
				mgr.buy(bIndex); 
			} catch(InsufficientFundsException e){
				//TODO Respond to insufficient funds by printing message to display.
				// Should use e.toString().
			} catch(DisabledException e){
				//TODO Respond to the system being disabled.
			} catch (EmptyException e){
				//TODO Respond to the pop rack being empty
			} catch (CapacityExceededException e){
				//TODO Respond to the delivery chute being full.
			}
		}		
	}

	/**
	 * Responds to "Valid coin inserted" notifications from the registered CoinSlot.
	 * Adds the 
	 */
	@Override
	public void validCoinInserted(CoinSlot slot, Coin coin) {
		mgr.addCredit(coin.getValue());
	}
}
