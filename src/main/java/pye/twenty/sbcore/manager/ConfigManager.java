package pye.twenty.sbcore.manager;

import pye.twenty.sbcore.config.BlockConfig;
import pye.twenty.sbcore.config.LocationConfig;
import pye.twenty.sbessentials.config.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ConfigManager {

    private final Map<Class<? extends Config>, Config> configMap;

    public ConfigManager() {
        List<Config> configs = new ArrayList<>();
        configs.add(new LocationConfig());
        configs.add(new BlockConfig());
        configMap = new HashMap<>();
        for (Config config : configs) {
            configMap.put(config.getClass(), config);
        }

    }

    public <T extends Config> T get(Class<T> configClass) {
        Config config = configMap.get(configClass);
        if (config != null) {
            return configClass.cast(config);
        }
        throw new IllegalArgumentException();
    }
}
