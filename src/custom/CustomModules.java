package custom;

import java.util.ArrayList;

public class CustomModules {

	/*
	 * Preferred data types: Integer, Float, Double
	 * 
	 * Integer: ..., -3, -2, -1, 0, 1, 2, 3, ...
	 * 
	 * Float: Up to 7 decimal places
	 * 
	 * Double: Up to 15 decimal places
	 * 
	 * public static <data type> <name>(ArrayList<data type> nums) {
	 * 		code;
	 * }
	 */
	
	public static float sqrt(ArrayList<Float> nums) {
		if (nums.size() > 1) return 0.0f;
		return (float)Math.sqrt(nums.get(0));
	}
}
