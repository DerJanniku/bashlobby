package org.derjannik.bashlobby;

import org.bukkit.plugin.java.JavaPlugin;
import org.derjannik.bashlobby.commands.LobbyHelpCommand;
import org.derjannik.bashlobby.commands.LobbySpawnCommand;
import org.derjannik.bashlobby.commands.LobbyMinigamesCommand;
import org.derjannik.bashlobby.commands.ReportCommand;
import org.derjannik.bashlobby.commands.FriendCommand;
import org.derjannik.bashlobby.commands.PartyCommand;
import org.derjannik.bashlobby.commands.ClanCommand;
import org.derjannik.bashlobby.gui.MainMenu;
import org.derjannik.bashlobby.gui.FriendsMenu;
import org.derjannik.bashlobby.gui.CosmeticsMenu;
import org.derjannik.bashlobby.utils.LobbyScoreboard;
import org.derjannik.bashlobby.commands.ClanCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;

public class bashlobby extends JavaPlugin implements Listener {
    private LobbyScoreboard lobbyScoreboard;

    @Override
    public void onEnable() {
        getLogger().info("Plugin aktiviert!");
        this.getCommand("lobby").setExecutor(new LobbyHelpCommand());
        this.getCommand("lobby spawn").setExecutor(new LobbySpawnCommand());
        this.getCommand("lobby minigames").setExecutor(new LobbyMinigamesCommand());
        this.getCommand("report").setExecutor(new ReportCommand());
        this.getCommand("friend").setExecutor(new FriendCommand());
        this.getCommand("party").setExecutor(new PartyCommand());
        this.getCommand("clan").setExecutor(new ClanCommand());
        Bukkit.getPluginManager().registerEvents(new MainMenu(this), this);
        Bukkit.getPluginManager().registerEvents(new FriendsMenu(this), this);
        Bukkit.getPluginManager().registerEvents(new CosmeticsMenu(this), this);
        Bukkit.getPluginManager().registerEvents(this, this);

        lobbyScoreboard = new LobbyScoreboard(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin deaktiviert!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        lobbyScoreboard.createScoreboard(event.getPlayer());
    }
}