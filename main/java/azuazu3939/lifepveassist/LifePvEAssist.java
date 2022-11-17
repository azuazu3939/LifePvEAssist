package azuazu3939.lifepveassist;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class LifePvEAssist extends JavaPlugin {

    private static LifePvEAssist instance;

    public LifePvEAssist() {
        instance = this;
    }

    public static LifePvEAssist getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();

        Objects.requireNonNull(getServer().getPluginCommand("takeitem")).setExecutor(new TakeItemCommand());
        Objects.requireNonNull(getServer().getPluginCommand("lpa")).setExecutor(new ReloadCommand(ReloadCommand.getInstance()));

    }

    @Override
    public void onDisable() {
    }

    public void reload() {
        saveDefaultConfig();
        reloadConfig();
    }
}
