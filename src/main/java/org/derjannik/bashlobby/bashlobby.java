package org.derjannik.bashlobby;

import org.bukkit.entity.Player;
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
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.derjannik.bashlobby.utils.TabListManager;

import java.util.Objects;

public class bashlobby extends JavaPlugin implements Listener {
    private LobbyScoreboard lobbyScoreboard;

    @Override
    public void onEnable() {
        getLogger().info("Plugin aktiviert!");
        Objects.requireNonNull(this.getCommand("lobby")).setExecutor(new LobbyHelpCommand());
        Objects.requireNonNull(this.getCommand("lobby spawn")).setExecutor(new LobbySpawnCommand());
        Objects.requireNonNull(this.getCommand("lobby minigames")).setExecutor(new LobbyMinigamesCommand());
        Objects.requireNonNull(this.getCommand("report")).setExecutor(new ReportCommand());
        Objects.requireNonNull(this.getCommand("friend")).setExecutor(new FriendCommand());
        Objects.requireNonNull(this.getCommand("party")).setExecutor(new PartyCommand());
        Objects.requireNonNull(this.getCommand("clan")).setExecutor(new ClanCommand());
        Bukkit.getPluginManager().registerEvents(new MainMenu(this), this);
        Bukkit.getPluginManager().registerEvents(new FriendsMenu(this), this);
        Bukkit.getPluginManager().registerEvents(new CosmeticsMenu(this), this);
        Bukkit.getPluginManager().registerEvents(this, this);

        // Initialize TabListManager
        TabListManager tabListManager = new TabListManager(this);
        for (Player player : Bukkit.getOnlinePlayers()) {
            tabListManager.updateTabList(player);
        }

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
