package azuazu3939.lifepveassist;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

    private static LifePvEAssist instance;

    public ReloadCommand(LifePvEAssist instance) {

        ReloadCommand.instance = instance;
    }

    public static LifePvEAssist getInstance() {
        return instance;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender.hasPermission("lifepveassist.command.reload") && sender instanceof Player) {

            LifePvEAssist.getInstance().reload();
            sender.sendMessage("コンフィグをリロードしました。");
        }
        return true;
    }
}
