
// Defination: THe template menthod defines the steps of an alorithm and allows subclasses to provide the implementations.
// The Template method is great design tool for creating frameworks.
// Templatemethod gives important technique for code reuse.
// The Factory method is specialization of TemplateMethod.
// Hooks are methods that does nothing or gives default behaviour in abstract class but may be overriden in sub classes.
// We can implement compareTo template method of Array class for sorting elements.
// JFrame paint method is template method pattern. Java applets as well.

// Design Principle
// Holliwood principle. Don't call us we will call you. In template method the supercalss telling th subclass don't call me we will call you.
// Holliwood principle: TemplateMethod, FactoryMethod, Onserver. Dependency Inversion.
// 


class TemplateMethodCheck {
	public static void main(String[] args) {
		System.out.println("Preparing Coffee");
		CoffineBevourage coffee = new Coffee();
		coffee.prepare();
		System.out.println("=======================");
		System.out.println("Preparing Tea");
		CoffineBevourage tea = new Tea();
		tea.prepare();
	}
}


abstract class CoffineBevourage {
	public void prepare() {
		boilwater();
		brew();
		poureincup();
		addCondiments();
	}
	public void boilwater() {
		System.out.println("Boiling water.");
	}
	public abstract void brew();
	public void poureincup() {
		System.out.println("pouring in cup.");	
	}
	public abstract void addCondiments();
}

class Coffee extends CoffineBevourage {
	@Override
	public void brew() {
		System.out.println("Add cofee powder.");	
	}
	public void addCondiments() {
		System.out.println("Add Milk and sugar.");
	}
}

class Tea extends CoffineBevourage {
	@Override
	public void brew() {
		System.out.println("Add tea powder.");	
	}
	public void addCondiments() {
		System.out.println("Add lemon.");
	}
}