package org.derjannik.bashlobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

public class ClanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("clan")) {
            sender.sendMessage(ChatColor.GREEN + "Clan management command executed.");
            // Add clan management logic here
            return true;
        }
        return false;
    }
}
