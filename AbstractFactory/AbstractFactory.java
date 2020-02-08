// Defination: Abstract Factory Design pattern provides interface for creating families of related/dependent objects without specifing the concrete classes.
// Factories patterns are of categorize and select types
// AbstractFactory creates objects through composition.
// Note: Don't get confused with this big snippets it is combination of Factory method and abstract factory. Start fro IngredientFactory class for Abstract factory.

// Pizzassss continued ...


class AbstractFactory {
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
	IngredientFactory ingredientFactory;
	public NyPizzaStore() {
		ingredientFactory = new NYPizzaIngredientFactory();
	}
	public Pizza createPizza(String type) {
		if(type == "chese") {
			return new NYChesePizza(ingredientFactory);
		}
		else if(type == "veg") {
			return new NYVegPizza(ingredientFactory);
		}
		return null;
	}
}

class ChicagoPizzaStore extends PizzaStore {
	IngredientFactory ingredientFactory;
	public ChicagoPizzaStore() {
		ingredientFactory = new ChicagoPizzaIngredientFactory();
	}
	public Pizza createPizza(String type) {
		if(type == "chese") {
			return new ChicagoChesePizza(ingredientFactory);
		}
		else if(type == "veg") {
			return new ChicagoVegPizza(ingredientFactory);
		}
		return null;
	}
}

class Pizza {
	String description;
	IngredientFactory ingredientFactory;

	void prepare() { System.out.println(description + " Preparing" + " Ingredients:"+ ingredientFactory.getDough().getDescription() + ", "+ ingredientFactory.getSauce().getDescription()); }
	void bake() { System.out.println(description + " Baking"); }
	void cut() { System.out.println(description + " Cutting to sectors"); }
	void pack() { System.out.println(description + " Packing"); }
}

class NYChesePizza extends Pizza{

	public NYChesePizza(IngredientFactory ingredientFactory) { 
		this.ingredientFactory = ingredientFactory;;
		description = "Newyark Chese Pizaa"; 
	}
}

class NYVegPizza extends Pizza{
	public NYVegPizza(IngredientFactory ingredientFactory) { 
		this.ingredientFactory = ingredientFactory;
		description = "Newyark Veg Pizaa"; 
	}
}

class ChicagoChesePizza extends Pizza{
	public ChicagoChesePizza(IngredientFactory ingredientFactory) { 
		this.ingredientFactory = ingredientFactory;
		description = "Chicago Chese Pizaa"; 
	}
}

class ChicagoVegPizza extends Pizza{
	public ChicagoVegPizza(IngredientFactory ingredientFactory) { 
		this.ingredientFactory = ingredientFactory;
		description = "Chicago Veg Pizaa"; 
	}
	void cut() { System.out.println(description + " Cutting to squares"); }
}

interface IngredientFactory {
	public Dough getDough();
	public Sauce getSauce();
}

class NYPizzaIngredientFactory implements IngredientFactory {
	public Dough getDough() {
		return new ThickCrustDough();
	}
	public Sauce getSauce() {
		return new PlumTomotoSauce();
	}
}

class ChicagoPizzaIngredientFactory implements IngredientFactory {
	public Dough getDough() {
		return new ThinCrustDough();
	}
	public Sauce getSauce() {
		return new MarinaSauce();
	}
}

interface Dough {
	public String getDescription();
}

class ThickCrustDough implements Dough {
	public String getDescription() {
		return "ThickCrustDough";
	}
}

class ThinCrustDough implements Dough {
	public String getDescription() {
		return "ThinCrustDough";
	}
}

interface Sauce {
	public String getDescription();
}

class PlumTomotoSauce implements Sauce {
	public String getDescription() {
		return "PlumTomotoSauce";
	}
}

class MarinaSauce implements Sauce {
	public String getDescription() {
		return "MarinaSauce";
	}
}
