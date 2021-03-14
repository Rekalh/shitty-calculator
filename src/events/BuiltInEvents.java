package events;

import loaders.ModuleLoader;
import main.Main;
import main.RefStrings;

public class BuiltInEvents {

	public static void disableModules() {
		Main.areModulesLoaded = false;
		System.out.println("Unloaded all modules");
	}
	
	public static void enableModules() {
		Main.areModulesLoaded = true;
		System.out.println("Loaded all modules");
	}
	
	public static void showInfo() {
		System.out.println("Name: " + RefStrings.NAME + "\n" + "Version: " + RefStrings.VERSION);
		System.out.println("Loaded with: " + RefStrings.CONSOLE_VERSION);
		System.out.println("Modules loaded: " + ModuleLoader.getModuleNames().toString());
		System.out.println("Built in modules: " + ModuleLoader.getBuiltInModuleNames().toString());
		System.out.println("Custom modules: " + ModuleLoader.getCustomModuleNames().toString());
	}
}
