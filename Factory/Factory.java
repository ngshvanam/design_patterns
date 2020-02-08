// DesignPrinciple: Identify the aspects that vary and seperate them out from what stays same.
// DesignPrinciple: Depend on Obstractions do not depend upon concrete implementations.
// There can be n number of clients to the factory and seperating out object creation in one class enable us to do one point of change. We can also avoid the code dublication of creator logic.
// It is not recommended to static methods as we loose subclassing for extending factory.
// A simple factory is't actually a design pattern. It is just a static factory.
// Defination: The FACTORY METHOD defines an interface to create an object, but lets subclass deside what class to instantiate.
// Factory method creates the Objects using Inheritance

// Pizzassss....

class Factory {
	public static void main(String[] args) {
		PizzaStore ps = new NyPizzaStore();
		ps.orderPizaa("chese");
		ps = new ChicagoPizzaStore();
		ps.orderPizaa("veg");
	}
}


abstract class PizzaStore {
	public Pizza orderPizaa(String type) {
		Pizza pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.pack();
		return pizza;
	}

	public abstract Pizza createPizza(String type);
}

class NyPizzaStore extends PizzaStore {
	public Pizza createPizza(String type) {
		if(type == "chese") {
			return new NYChesePizza();
		}
		else if(type == "veg") {
			return new NYVegPizza();
		}
		return null;
	}
}

class ChicagoPizzaStore extends PizzaStore {
	public Pizza createPizza(String type) {
		if(type == "chese") {
			return new ChicagoChesePizza();
		}
		else if(type == "veg") {
			return new ChicagoVegPizza();
		}
		return null;
	}
}

class Pizza {
	String description;

	void prepare() { System.out.println(description + " Preparing"); }
	void bake() { System.out.println(description + " Baking"); }
	void cut() { System.out.println(description + " Cutting to sectors"); }
	void pack() { System.out.println(description + " Packing"); }
}

class NYChesePizza extends Pizza{
	public NYChesePizza() { description = "Newyark Chese Pizaa"; }
}

class NYVegPizza extends Pizza{
	public NYVegPizza() { description = "Newyark Veg Pizaa"; }
}

class ChicagoChesePizza extends Pizza{
	public ChicagoChesePizza() { description = "Chicago Chese Pizaa"; }
}

class ChicagoVegPizza extends Pizza{
	public ChicagoVegPizza() { description = "Chicago Veg Pizaa"; }
	void cut() { System.out.println(description + " Cutting to squares"); }
}

