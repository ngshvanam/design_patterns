// Defination: The command pattern allows us to decouple the requester of any action from the object that actually perform the action.
// The received of the request bound to the command (encapsulated in).

class CommandCheck {
	public static void main(String[] args) {
		Light light = new Light();
		RemoteController remoteController = new RemoteController();
		Command command = new LightonCommand(light);
		remoteController.setSlot(command);
		remoteController.buttenPressed();
		command = new LightoffCommand(light);
		remoteController.setSlot(command);
		remoteController.buttenPressed();
	}
}


class RemoteController {
	Command command;
	public RemoteController() {

	}
	public void setSlot(Command command) {
		this.command = command;
	}
	public void buttenPressed() {
		this.command.execute();
	}
}

interface Command {
	public void execute();
}

class LightonCommand implements Command {
	Light light;
	public LightonCommand(Light light) {
		this.light = light;
	}
	public void execute() {
		this.light.on();
	}	
}

class LightoffCommand implements Command {
	Light light;
	public LightoffCommand(Light light) {
		this.light = light;
	}
	public void execute() {
		this.light.off();
	}	
}

class Light {
	public void on() { System.out.println("Light is switched on."); }
	public void off() { System.out.println("Light is switched off."); }
}

