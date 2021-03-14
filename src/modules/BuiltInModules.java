package modules;

import java.util.ArrayList;

import main.Main;

public class BuiltInModules {

	// Addition
	public static float add(ArrayList<Float> nums) {
		
		float sum = 0;
		if (!nums.isEmpty()) {
			for (float n : nums) {
				if (Main.debugMode) System.out.println("Added " + String.valueOf(n) + " to " + String.valueOf(sum));
				sum += n;
			}
		}
		return sum;
	}
	
	// Subtraction
	public static float subtract(ArrayList<Float> nums) {
		
		float difference = 0;
		if (!nums.isEmpty()) {
			difference = nums.get(0);
			if (nums.size() > 1) {
				for (int i = 1; i < nums.size(); i++) {
					if (Main.debugMode) System.out.println("Subtracted " + String.valueOf(nums.get(i)) + " from " + String.valueOf(difference));
					difference -= nums.get(i);
				}
			}
		}
		return difference;
	}
	
	// Multiplication
	public static float multiply(ArrayList<Float> nums) {
		
		float product = 1;
		if (nums.size() > 1) {
			for (float n : nums) {
				if (Main.debugMode) System.out.println("Multiplied " + String.valueOf(n) + " with " + String.valueOf(product));
				product *= n;
			}
			return product;
		} else {
			return 0;
		}
	}
	
	// Division
	public static float divide(ArrayList<Float> nums) {
		
		float quotient = 0f;
		if (!nums.isEmpty())
			quotient = nums.get(0);
		if (nums.size() > 1) {
			for (float n : nums) {
				if (n != 0f) {
					quotient /= n;
				} else {
					System.out.println("Can't divide by 0");
					return 0f;
				}
			}
			return quotient;
		}
		return 0f;
	}
}
