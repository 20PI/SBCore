package pye.twenty.sbcore;

import lombok.Getter;

import java.util.logging.Level;

@Getter
public enum SBCore {

    INSTANCE;

    private SBCorePlugin plugin;


    public void initialize(SBCorePlugin plugin) {
        this.plugin = plugin;
        registerSerializables();
        registerManagers();
        registerCommands();
    }


    private void registerManagers() {
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
