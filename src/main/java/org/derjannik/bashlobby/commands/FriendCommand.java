package org.derjannik.bashlobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

public class FriendCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("friend")) {
            sender.sendMessage(ChatColor.GREEN + "Friend management command executed.");
            // Add friend management logic here
            return true;
        }
        return false;
    }
}
