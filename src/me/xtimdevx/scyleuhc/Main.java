package me.xtimdevx.scyleuhc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.xtimdevx.scyleuhc.commands.UHCCommand;
import me.xtimdevx.scyleuhc.gui.ModeGUI;

public class Main extends JavaPlugin{
	
	public static Plugin plugin;
	
	public void onEnable() {
		plugin = this;
		registerCommands();
		registerListeners();
		Settings.getInstance().setup(plugin);
		}
	
	public void registerCommands() {
		getCommand("uhc").setExecutor(new UHCCommand());
	}
	
	public void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new ModeGUI(this), this);
	}

}
