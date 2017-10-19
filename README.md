# Assignment 1
## Task
* Implementing the logic of the vending machine, building on top of Rob's (simulated) hardware
  
## Requirements
* Get the vending machine to correctly react to coin insertions and button presses
* Write one or more classes that listen for the right kind of events from the hardware then call other methods on the hardware to get it to do the appropriate thing according to the current state
  * e.g. no money entered, no pop vended! 
* You MUST NOT alter the hardware source code. 
* Must handle the registration of logic classes with the appropriate hardware
* Mr. Client says don't: 
  * Be fancy at this point.  
  * Return change.  
  * Turn on notification lights.  
  * Print out meaningful messages to the VM's display.
  * If you ignore Mr. Client, expect him to not be happy. 
    * Food for thought: When is it OK to not worry about Mr. Client's happiness?

## Setup
* Class project name: ca.ucalgary.seng300.a1 containing a package of the same name
* JUnit package: ca.ucalgary.seng300.a1.test in that project.

	
## Testing
* Strive for good coverage of your logic implementation by your test suite.  
* You can assume that the hardware functions as it should
  * i.e., integration tests involving parts of your logic and my hardware are fine.

## Questions and Answers
* There are lots of things that have not been explained in much detail.  
  * Guessing at the answers is not a great idea, especially if you don't check.  
* Who can you check with?  Mr. Client, of course!  
  * Contact through D2L or in-person (during lecture)
  * Be professional.  Be courageous.  
  * "Dumb questions" are sometimes the most important ones to ask! 

## Assignment submission
* Submit to Dropbox folder by Oct 23 8AM
* Place project in a ZIP file
  * Do not include the hardware classes.
* Each team can just submit one version of your code.
* Add the names and IDs of all team members in comments

## Previously asked Questions:
* How many coins does the maschine need to store?
  * Our current hardware setup should hold about 200 coins.  Some components may get replaced in future, as we are looking at our options.
* What are the denominations of coins?
  * Standard Canadian coins at this point.  We'll be looking to expand into other markets later.
* What is the currency?
  * See 2.
* How many pop options are we offering?
  * 6 for now.  Expect this to change for some versions of machine.
* What is the maximum number of pop cans per machine/slot?
  * Each pop rack holds 10 pop cans.
* When is a transaction completed?
  * Transactions don't make much sense here.  There is money entered in the machine.  Someone selects a pop.  This will sometimes change how much money there is in the machine.
* Would it be OK to not return invalid coins and store them in a separate coin rack?
  * No.  In fact, the hardware deals with this, according to how it is configured.
* Do you want a demonstration of multiple buttons working, or just a proof of concept for one button?
  * We want to see it working for the configuration I mentioned above.
* Is it possible to cancel a transaction?
  * See 6.  Later, there may be a "Return coins button" ... we're still considering if that makes sense to us.
* Since we’re not using indicator lights or display messages, what happens if you do not insert enough coins? What about if the pop you want is out? What about if it’s invalid input(e.g. You press a button that is not connected to any pop) ?
  * For now, the user will only see that a pop is returned or not.  If there is no pop in a rack, they should not get charged for it.  This is for the proof of concept; it will definitely change later.
* What if a rack is out of pop?
  * See 10.

### Mr. Client message Oct 17
* You need to keep track of how much money has been entered in the machine, and how much of it has been used.  If there isn't enough money for a pop, pressing a selection button shouldn't do anything.  Otherwise, the pop should be vended and its cost should be subtracted from the total available

### Mr. Client message Oct 18
* This is a simple vending machine.  There is one button representing each pop kind (more than one button can represent the same pop), which corresponds to exactly one pop rack.  The hardware simulator is already set up that way,
You do realize that you have to build on top of the existing hardware, right?  You can use the standard configuration for now.  The hardware will take care of many things already.  Make sure you understand what it does and does not do on its own.  If you write some simple code that instantiates a vending machine, you can use the debugger to see how it is hooked together.  The documentation also explains this.
The logic that you need to implement just deals with button presses and coin entries, dispensing the appropriate pop when appropriate and possible. All other aspects (change, display, signal lights, etc.) are for future extensions.
You should implement JUnit test cases to unit test your logic.  You should also implement system tests to test the hardware with the software installed.  Yes, the test suite is a deliverable.
