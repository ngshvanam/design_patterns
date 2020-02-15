// Defination: The composite pattern allows to compose the objects in to tree structure to represent heirachies.
// Composite pattern allows us to treat collection of objects in the same way as single object.

import java.util.*;
class Composite {
	public static void main(String[] args) {
		DuckFloks duckFlols = new DuckFloks();

		Quckable malbarDuck = new MalbarDuck();
		duckFlols.addDuck(malbarDuck);

		Quckable dollDuck = new DollDuck();
		duckFlols.addDuck(dollDuck);

		duckFlols.quack();
	}
}

interface Quckable {
	public void quack();
}

class MalbarDuck implements Quckable {
	public void quack() {
		System.out.println("Quacking....");
	}
}

class DollDuck implements Quckable {
	public void quack() {
		System.out.println("Squeecking....");
	}
}

class DuckFloks implements Quckable{
	ArrayList<Quckable> ducks;
	public DuckFloks() {
		ducks = new ArrayList<Quckable>();
	}
	public void addDuck(Quckable duck) {
		ducks.add(duck);
	}
	public void quack() {
		Iterator<Quckable> iterator = ducks.iterator();
		while(iterator.hasNext()) {
			Quckable duck = iterator.next();
			duck.quack();
		}
	}
}

