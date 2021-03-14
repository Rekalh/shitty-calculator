package main;

public enum Operations {
	
	ADDITION(0, "add"),
	SUBTRACTION(3, "subtract"),
	MULTIPLICATION(2, "multiply"),
	DIVISION(1, "divide");
	
	private int id;
	private String name;
	
	Operations(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	int getId() {
		return this.id;
	}
	
	String getName() {
		return this.name;
	}
}
