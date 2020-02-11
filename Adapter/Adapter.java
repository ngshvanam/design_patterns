// Adpter resolves the diffrences between two incompitiable interfaces.
// Defination: Adapter converts one interface of the class to other interface that client expects.
// There are two types of adapters 1. class adapter 2. object adapter
// Class adapter requires multiple inheritence 
// 
// Design Principles
// Favour the composition over inheritance.
// Talk to only your friends


class Adapter {
	public static void main(String[] args) {
		Duck duck = new MalbarDuck();
		duck.quack();
		duck.fly();

		Turky turky = new RussianTruky();
		duck = new RussianTurkyAdapter(turky);
		duck.quack();
		duck.fly();
	}
}

interface Duck {
	public void quack();
	public void fly();
}

class MalbarDuck implements Duck {
	public void quack() {
		System.out.println("MalbarDuck quacking.");
	}
	public void fly() {
		System.out.println("MalbarDuck flying.");
	}
}

class RussianTurkyAdapter implements Duck {
	Turky turky;
	public RussianTurkyAdapter(Turky turky) {
	 this.turky = turky;
	}
	public void quack()
	{
		this.turky.squeek();
	}
	public void fly(){
		this.turky.fly();
	}
}

interface Turky {
	public void squeek();
	public void fly();
}

class RussianTruky implements Turky{
	public void squeek() {
		System.out.println("RussianTruky squekking.");
	}
	public void fly() {
		System.out.println("RussianTruky flying.");
	}
}
