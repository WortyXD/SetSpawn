package MadeByWorty1.setSpawn;

import org.bukkit.plugin.java.JavaPlugin;

public final class SetSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getLogger().info("SetSpawn Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SetSpawn Disabled!");
    }
}
