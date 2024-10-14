package org.derjannik.bashlobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

public class PartyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("party")) {
            sender.sendMessage(ChatColor.GREEN + "Party management command executed.");
            // Add party management logic here
            return true;
        }
        return false;
    }
}
