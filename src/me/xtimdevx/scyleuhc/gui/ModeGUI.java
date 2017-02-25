package me.xtimdevx.scyleuhc.gui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.xtimdevx.scyleuhc.Main;
import me.xtimdevx.scyleuhc.Settings;
import me.xtimdevx.scyleuhc.commands.UHCCommand;
import me.xtimdevx.scyleuhc.utils.Prefix;

public class ModeGUI implements Listener{
	
	public ModeGUI(Main main) {
	}

	public static Inventory setMode(Player player) {
		Inventory inv = Bukkit.createInventory(player, 9, "§7Modes for §b" + player.getName());
		ArrayList<String> lore = new ArrayList<String>(); 
		
		ItemStack host = new ItemStack (Material.REDSTONE_BLOCK);
		ItemMeta hostMeta = host.getItemMeta();
		hostMeta.setDisplayName("§b§lUHC §8» §fHost");
		lore.add(" ");
		lore.add("§fGo into §bHOST §fmode.");
		lore.add(" ");
		if(Settings.getData().get("game.host").equals(player.getName())){
			hostMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		}
		hostMeta.setLore(lore);
		host.setItemMeta(hostMeta);
		inv.setItem(2, host);
		lore.clear();
		
		ItemStack spec = new ItemStack (Material.REDSTONE_BLOCK);
		ItemMeta specMeta = spec.getItemMeta();
		specMeta.setDisplayName("§b§lUHC §8» §fSpec");
		lore.add(" ");
		lore.add("§fGo into §bSPEC §fmode.");
		lore.add(" ");
		if(UHCCommand.opspectators.containsKey(player.getName())){
			specMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		}
		specMeta.setLore(lore);
		spec.setItemMeta(specMeta);
		inv.setItem(4, spec);
		lore.clear();
		
		ItemStack playerm = new ItemStack (Material.REDSTONE_BLOCK);
		ItemMeta playerMeta = playerm.getItemMeta();
		playerMeta.setDisplayName("§b§lUHC §8» §fPlayer");
		lore.add(" ");
		lore.add("§fGo into §bPLAYER §fmode.");
		lore.add(" ");
		playerMeta.setLore(lore);
		playerm.setItemMeta(playerMeta);
		inv.setItem(6, playerm);
		lore.clear();
		
		player.openInventory(inv);
		return inv;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equalsIgnoreCase("§7Modes for §b" + player.getName())) {
			e.setCancelled(true);
			if(e.getSlot() == 2) {
				if(Settings.getData().get("game.host").equals(player.getName())) {
					player.sendMessage(Prefix.PREFIX + "You are no longer in the mode §bHOST§f.");
					Settings.getData().set("game.host", "none");
					Settings.getInstance().saveData();
					player.closeInventory();
					return;
				}
				for(Player online : Bukkit.getOnlinePlayers()) {
					online.sendMessage(Prefix.PREFIX + "§b" + player.getName() + " §fis now in the mode §bHOST§f.");
				}
				Settings.getData().set("game.host", player.getName());
				Settings.getInstance().saveData();
				player.closeInventory();
				return;
			}
			if(e.getSlot() == 4) {
				if(UHCCommand.opspectators.containsKey(player.getName())) {
					player.sendMessage(Prefix.PREFIX + "You are no longer in the mode §bSPEC§f.");
					UHCCommand.opspectators.remove(player.getName());
					player.closeInventory();
					return;
				}
				for(Player online : Bukkit.getOnlinePlayers()) {
					online.sendMessage(Prefix.PREFIX + "§b" + player.getName() + " §fis now in the mode §bSPEC§f.");
				}
				UHCCommand.opspectators.put(player.getName(), null);
				player.closeInventory();
				return;
			}
		}
	}

}
