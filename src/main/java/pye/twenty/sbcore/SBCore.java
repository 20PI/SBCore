package pye.twenty.sbcore;

import lombok.Getter;
import pye.twenty.sbcore.listener.BlockBreakListener;
import pye.twenty.sbcore.listener.BlockPlaceListener;
import pye.twenty.sbcore.manager.ConfigManager;
import pye.twenty.sbcore.manager.PlayerManager;

import java.util.logging.Level;

@Getter
public enum SBCore {

    INSTANCE;

    private SBCorePlugin plugin;
    private ConfigManager configManager;
    private PlayerManager playerManager;


    public void initialize(SBCorePlugin plugin) {
        this.plugin = plugin;
        registerSerializables();
        registerManagers();
        registerListeners();
        registerCommands();
    }


    private void registerManagers() {
        configManager = new ConfigManager();
        playerManager = new PlayerManager();
    }

    private void registerListeners() {
        plugin.getServer().getPluginManager().registerEvents(new BlockBreakListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), plugin);

    }
    private void registerSerializables() {
    }
    private void registerCommands() {
    }

    public void disable() {
    }

    public void log(String string) {
        assert plugin != null;
        log(Level.INFO, string);
    }

    public void log(Level level, String string) {
        assert plugin != null;
        plugin.getLogger().log(level, string);
    }


}
