package main;

import java.util.ArrayList;
import java.util.Scanner;

import events.BuiltInEvents;
import loaders.ModuleLoader;

import java.lang.reflect.Method;

public class Console {

	private ArrayList<String> commands = new ArrayList<>();
	@SuppressWarnings("unused")
	private Method[] modules = ModuleLoader.getModules(); 
	private Scanner input = new Scanner(System.in);
	private int event_caller = Integer.MAX_VALUE;
	
	private void initCommands() {
		commands.add("enable_modules");
		commands.add("disable_modules");
		commands.add("exit");
		commands.add("show_info");
	}
	
	public void start() {
		Main.isConsole = true;
		this.initCommands();
		while (Main.isConsole) {
			String command = input.nextLine();
			if (commands.contains(command)) {
				event_caller = commands.indexOf(command);
				this.callEvent(event_caller);
			}
		}
	}
	
	public void exit() {
		Main.isConsole = false;
		Main.main(new String[0]);
	}
	
	public ArrayList<String> getCommands() {
		return commands;
	}
	
	private void callEvent(int id) {
		switch (id) {
			case 0:
				BuiltInEvents.enableModules();
				break;
			case 1:
				BuiltInEvents.disableModules();
				break;
			case 2:
				this.exit();
				break;
			case 3:
				BuiltInEvents.showInfo();
				break;
			case Integer.MAX_VALUE:
				break;
			default:
				System.out.println("Invalid command");
		}
	}
}
