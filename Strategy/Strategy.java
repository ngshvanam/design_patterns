// STRATEGY
// Has-A is better than IS-A relationship. 
// Design Principle: Favouring composition over inheritance.
// Delegation
// Indentify the aspects of the application that vary and seperate them from what stays same (Encapsulate what varies)
// Design Principle: Program to interfaces not to the implementations.
// Program to interfces nothing but program to supertypes
// Q&A Is it alright classes just having the behaviours? In OO world classes represents the things that generally have state and methods.
// Here beahaviour means both state and methods. we can have instance variable that represents that hiehgt to fly.

// Defination: Define a family of algorithms encapsulate them and make them interchangeable.


class Strategy 
{
	public static void main(String[] args) {
		Duck realDuck = new RealDuck();
	    realDuck.display();
	    realDuck.swim();
	    realDuck.quack();
	    realDuck.fly();
	    
	    System.out.println("==================\n");

	    Duck dollDuck = new DollDuck();
	    dollDuck.display();
	    dollDuck.swim();
	    dollDuck.quack();
	    dollDuck.fly();
	}
}

abstract class Duck {
	FlyBehaviour flybehaviour;
	QuackBahaviour quackBehaviour;

	public Duck() {}

	public void setFlyBehaviour(FlyBehaviour flybehaviour) {
		this.flybehaviour = flybehaviour;
	}

	public void setQuackBehaviour(QuackBahaviour quackBehaviour) {
		this.quackBehaviour = quackBehaviour;
	}

	public void fly() {
		flybehaviour.fly();
	}
	public void quack() {
		quackBehaviour.quack();
	}
	public abstract void display();
	public abstract void swim();
}

class RealDuck extends Duck {
	public RealDuck() {
		this.flybehaviour = new FlyHigh();
		this.quackBehaviour = new Quack();
	}

	@Override
	public void display() {
		System.out.println("Real Duck\n");
	}
	@Override
	public void swim() {
		System.out.println("Real Duck swimming\n");
	}
}

class DollDuck extends Duck {
	public DollDuck() {
		this.flybehaviour = new NullFly();
		this.quackBehaviour = new Squeek();
	}

	@Override
	public void display() {
		System.out.println("Doll Duck\n");
	}
	@Override
	public void swim() {
		System.out.println("Doll Duck swimming\n");
	}
}

interface FlyBehaviour {
	public void fly();
}

class FlyHigh implements FlyBehaviour {
	public void fly() {
		System.out.println("Flying High\n");
	}
}

class NullFly implements FlyBehaviour {
	public void fly() {
		System.out.println("Not flying\n");
	}
}


interface QuackBahaviour {
	public void quack();
}

class Quack implements QuackBahaviour {
	public void quack() {
		System.out.println("Quacking\n");
	}
}

class Squeek implements QuackBahaviour {
	public void quack() {
		System.out.println("Squeeking\n");
	}
}
