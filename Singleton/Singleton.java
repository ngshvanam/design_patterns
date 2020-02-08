// Desination: Singleton pattern ensures a class has only one instance and provides a global point of access to it.


// Use synchrinzed. But it is expenssive when we call each time to get instance.
class Singleton {
	private static Singleton singleton;

	private Singleton(){}

	public synchronized static getInstace() {
		if(singleton == null) {
			singleton = new Singleton();
		}

		return singleton;

	}

}

// Use eager initialization. If resource is expenssive and not used after eager loading.
class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton(){}

	public synchronized static getInstace() {
		return singleton;
	}

}


//Use double checked locking
class Singleton {
	private static Singleton singleton;

	private Singleton(){}

	public static getInstace() {
		if(singleton == null) {
			synchronized (Singleton.class) {
				if(singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}