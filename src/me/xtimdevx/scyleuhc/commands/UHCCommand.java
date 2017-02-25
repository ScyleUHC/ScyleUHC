package me.xtimdevx.scyleuhc.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.xtimdevx.scylehavex.User;
import me.xtimdevx.scylehavex.User.Rank;
import me.xtimdevx.scyleuhc.gui.ModeGUI;
import me.xtimdevx.scyleuhc.utils.Prefix;

public class UHCCommand implements CommandExecutor{
	
	public static Map<String, List<String>> opspectators = new HashMap<>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("uhc")) {
			Player p = (Player) sender;
			User user = User.get(p);
			if(args.length == 0) {
				p.sendMessage(Prefix.PREFIX + "UHC commands:");
				p.sendMessage(Prefix.PREFIX + "/uhc - §odisplay this menu");
				p.sendMessage(Prefix.PREFIX + "/uhc info - §oPlugin info");
				p.sendMessage(Prefix.PREFIX + "/helpop <question> - §oask a question.");
				p.sendMessage(Prefix.PREFIX + "/gameinfo - §oBasis game info.");
				p.sendMessage(Prefix.PREFIX + "/scenario - §oScenario info.");
				p.sendMessage(Prefix.PREFIX + "/stats - §oTake a look at your stats.");
				if(user.getRank() != Rank.PLAYER && user.getRank() != Rank.VIP) {
					p.sendMessage(Prefix.PREFIX + "Staff commands:");
					p.sendMessage(Prefix.PREFIX + "/uhc nextstate - §oSet the server to the next state");
					p.sendMessage(Prefix.PREFIX + "/uhc end - §oEnd the UHC.");
					p.sendMessage(Prefix.PREFIX + "/uhc resetboard - §oReset the killboard");
					p.sendMessage(Prefix.PREFIX + "/uhc world <seed> - §oCreate the UHC world.");
					p.sendMessage(Prefix.PREFIX + "/uhc mode - §oChange your mode.");
					p.sendMessage(Prefix.PREFIX + "/uhc mode <player> - §oChange the mode of a player.");
					p.sendMessage(Prefix.PREFIX + "/latespawn - §oLatespawn a player.");
				}
				return true;
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("mode")) {
					if(user.getra)
					ModeGUI.setMode(p);
				}
			}
		}
		return true;
	}

}
