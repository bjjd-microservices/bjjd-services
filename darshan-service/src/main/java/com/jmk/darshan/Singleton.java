package com.jmk.darshan;

import java.io.Serializable;

//Lazy instantiation using double locking mechanism
public class Singleton implements Serializable {

	private static Singleton instance;

	private Singleton() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					System.out.println("getInstance(): First time ");
					instance = new Singleton();
				}
			}
		}

		return instance;
	}

	/**
	 * If the Singleton class implements the java.io.Serializable interface, when a
	 * singleton is serialized and then deserialized more than once, there will be
	 * multiple instances of Singleton created. In order to avoid this readResolve
	 * method should be implemented. This method is called immediately after an
	 * object of this class is deserialized. This method returns the singleton
	 * instance.
	 */
	protected Object readResolve() {
		return getInstance();
	}

	public void doSomething() {
		System.out.println("doSomething(): Singleton does something!");
	}
}
