// Defination: State Design pattern allows an object to change it's behaviour when it's state is changed.
// Strategy pattern typically configures the context object with algoritm.
// State pattern changes the behavious of the context object when it changes the state.

// Design principles. All design principles

class StateCheck {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.keyon();
		vehicle.horn();
		vehicle.accelerate();
		vehicle.keyoff();
		vehicle.horn();
		vehicle.applybreak();
		vehicle.horn();
		vehicle.keyoff();
	}
}

class Vehicle {
	State stopState;
	State startState;
	State runningState;
	State notRunningState;
	State currentState;
	public Vehicle() {
		this.stopState = new StopState(this);
		this.startState = new StartState(this);
		this.runningState = new RunningState(this);
		this.currentState = this.stopState;
	}
	public void setState(State state) {
		this.currentState = state;
	}
	public State getStopState(){
		return stopState;
	}
	public State getStartState(){
		return startState;
	}
	public State getRunningState(){
		return runningState;
	}
	public void keyon() {
		this.currentState.keyon();
	}
	public void accelerate() {
		this.currentState.accelerate();
	}
	public void horn() {
		this.currentState.horn();
	}
	public void applybreak(){
		this.currentState.applybreak();
	}
	public void keyoff() {
		this.currentState.keyoff();
	}
}

// It can be abstract class as well
interface State {
	public void keyon();
	public void accelerate();
	public void horn();
	public void applybreak();
	public void keyoff();
}

class StopState implements State {
	Vehicle vehicle;
	public StopState(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public void keyon() {
		System.out.println("Starting vehicle");
		this.vehicle.setState(this.vehicle.getStartState());
	}
	public void accelerate() {
		System.out.println("The vehicle is not in started.");
	}
	public void horn() {
		System.out.println("The vehicle is not in started.");
	}
	public void applybreak(){
		System.out.println("The vehicle is not in started.");
	}
	public void keyoff() {
		System.out.println("The vehicle is not in started.");
	}
}

class StartState implements State {
	Vehicle vehicle;
	public StartState(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public void keyon() {
		System.out.println("The vehicle started already.");
	}
	public void accelerate() {
		System.out.println("The vehicle moving.");
		this.vehicle.setState(this.vehicle.getRunningState());
	}
	public void horn() {
		System.out.println("Horn...");
	}
	public void applybreak(){
		System.out.println("The vehicleis not moving.");
	}
	public void keyoff() {
		System.out.println("Stopping the Vehicle");
		this.vehicle.setState(this.vehicle.getStopState());
	}
}

class RunningState implements State {
	Vehicle vehicle;
	public RunningState(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public void keyon() {
		System.out.println("The Vehicle is running.");
	}
	public void accelerate() {
		System.out.println("The Vehicle is running.");
	}
	public void horn() {
		System.out.println("Horn...");
	}
	public void applybreak(){
		System.out.println("The vehicleis slowing down.");
		this.vehicle.setState(this.vehicle.getStartState());
	}
	public void keyoff() {
		System.out.println("Can not key off in running state.");
	}
}