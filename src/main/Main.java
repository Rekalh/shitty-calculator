package main;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import loaders.ModuleLoader;

public class Main {
	
	public static boolean debugMode = false;
	public static boolean areModulesLoaded = true;
	public static boolean isConsole = false;
	
	private static Mode mode;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Console console = new Console();
		
		ModuleLoader loader = new ModuleLoader();
		loader.loadModules(); // Loads all modules. Do not delete this line
		
		System.out.println("Enter '0' to start the program");
		int start = scanner.nextInt();
		
		switch (start) {
			case 0:
				mode = Mode.CALCULATOR;
				break;
			case 110011:
				mode = Mode.DEBUG_CALCULATOR;
				break;
			case 101010:
				mode = Mode.CONSOLE;
				break;
			default:
				System.out.println("Invalid input!");
				scanner.close();
				return;
		}
		
		if (mode.equals(Mode.CALCULATOR)) {
			int terms;
			int operationId;
			
			ArrayList<Float> nums = new ArrayList<>();
			Operations operation;
			
			System.out.println("Number of terms:");
			terms = scanner.nextInt();
			System.out.println("1.Add, 2.Divide, 3.Multiply, 4.Subtract");
			operationId = scanner.nextInt();
			
			switch (operationId) {
				case 1:
					operation = Operations.ADDITION;
					break;
				case 2:
					operation = Operations.DIVISION;
					break;
				case 3:
					operation = Operations.MULTIPLICATION;
					break;
				case 4:
					operation = Operations.SUBTRACTION;
					break;
				default:
					System.out.println("Invalid Operation");
					scanner.close();
					return;
			}
			
			for (int i = 0; i < terms; i++) {
				System.out.println("Number " + String.valueOf(i + 1) + ":");
				nums.add(scanner.nextFloat());
			}
			
			try {
				System.out.println((ModuleLoader.getModules()[operationId - 1]).invoke(operation.getName(), nums));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else if (mode == Mode.CONSOLE) {
			console.start();
		}
		scanner.close();
	}
}
