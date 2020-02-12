// Acheive well managed collections with Iterator and composit
// Defination: Iterator allows us to access the elements sequentially in a collection without exposing it's underlaying representation.
// Single Responsibility Principle.


class IteratorCheck {
	public static void main(String[] args) {
		DinnerMenu dinnerMenu = new DinnerMenu();
		Iterator iterator = dinnerMenu.createIterator();
		MenuItem mi;
		while(iterator.hasNext()) {
			mi = (MenuItem)iterator.next();
			System.out.println(mi.getName()+":"+mi.getPrice());
		}
	}
}


class DinnerMenu {
	MenuItem[] menuItems;
	int numberOfItems = 0;

	public DinnerMenu() {
		menuItems = new MenuItem[6];
		addMenuItem("Biryani", 30);
		addMenuItem("naan", 5);
		addMenuItem("salad", 2.5);
	}

	public void addMenuItem(String name, double price) {
		if(numberOfItems < 6) {
			menuItems[numberOfItems] = new MenuItem(name, price);
			numberOfItems++;
		}
	}

	public Iterator createIterator() {
		return new DinnerMenuIterator(menuItems);
	}
}

class MenuItem {
	String name;
	double price;
	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
}

interface Iterator {
	public boolean hasNext();
	public Object next();
}


class DinnerMenuIterator implements Iterator {
	MenuItem[] items;
	int position = 0;
	public DinnerMenuIterator(MenuItem[] items) {
		this.items = items;
	}
	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		}
		else {
			return true;
		}
	}
	public MenuItem next() {
		MenuItem item = items[position];
		position++;
		return item;
	}
}