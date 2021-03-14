package loaders;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import custom.CustomModules;
import modules.BuiltInModules;

public class ModuleLoader {
	
	private static Method[] custom_modules;
	private static Method[] built_in_modules;
	private static Method[] modules;
	
	public void loadModules() {
		custom_modules = CustomModules.class.getDeclaredMethods();
		built_in_modules = BuiltInModules.class.getDeclaredMethods();
		
		modules = Arrays.copyOf(built_in_modules, built_in_modules.length + custom_modules.length);
		System.arraycopy(custom_modules, 0, modules, built_in_modules.length, custom_modules.length);
	}
	
	public static Method[] getBuiltInModules() {
		return built_in_modules;
	}
	
	public static Method[] getCustomModules() {
		return custom_modules;
	}
	
	public static Method[] getModules() {
		return modules;
	}
	
	public static ArrayList<String> getModuleNames() {
		ArrayList<String> names = new ArrayList<>();
		for (Method m : getModules()) {
			names.add(m.getName());
		}
		return names;
	}
	
	public static ArrayList<String> getBuiltInModuleNames() {
		ArrayList<String> names = new ArrayList<>();
		for (Method m : getBuiltInModules()) {
			names.add(m.getName());
		}
		return names;
	}
	
	public static ArrayList<String> getCustomModuleNames() {
		ArrayList<String> names = new ArrayList<>();
		for (Method m : getCustomModules()) {
			names.add(m.getName());
		}
		return names;
	}
}
