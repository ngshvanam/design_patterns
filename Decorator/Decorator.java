// DesignPrinciple: OpenClosePrinciple => Casses open for extension but closed for modification
// Defination: Decorator pattern attaches additional responsibilites to the object dynamically. 
// It gives flexible alternative to subclassing for extending the functionality (Using object composition).
// We can observ a linked list of style implementation
// We need inheritance to just match the type. We are not inheriting any behaviour. That means we just need to consider the contract of beverage not behaviours.



class Decorator {
	public static void main(String[] args) {
		Beverage b = new BlackRoastCofee();
		b = new Milk(b);
		b = new Whip(b);
		System.out.println(b.getDescription() + "::Cost: " + b.cost());

		b = new Tea();
		b = new Milk(b);
		b = new TeaPowder(b);
		System.out.println(b.getDescription() + "::Cost: " + b.cost());
	}
}

abstract class Beverage {
	String description;
	public String getDescription(){
		return description;
	}

	public abstract float cost();
}


class BlackRoastCofee extends Beverage {
	public BlackRoastCofee() {
		this.description = "Black Roast Cofee";
	}
	@Override
	public float cost() {
		return (float)10;
	}
}

class Tea extends Beverage {
	public Tea() {
		this.description = "Tea";
	}
	@Override
	public float cost() {
		return (float)5;
	}
}

abstract class TopinsDecorator extends Beverage{
	Beverage beverage;
	public abstract String getDescription();
}

class Milk extends TopinsDecorator {
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public float cost() {
		return (float)2 + this.beverage.cost();
	}

	public String getDescription(){
		return beverage.getDescription()+ ", Milk";
	}
}


class Whip extends TopinsDecorator {
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public float cost() {
		return (float)2.5 + this.beverage.cost();
	}

	public String getDescription(){
		return beverage.getDescription()+ ", Whip";
	}
}


class TeaPowder extends TopinsDecorator {
	public TeaPowder(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public float cost() {
		return (float)1 + this.beverage.cost();
	}
	public String getDescription(){
		return beverage.getDescription()+ ", Tea Powder";
	}
}
