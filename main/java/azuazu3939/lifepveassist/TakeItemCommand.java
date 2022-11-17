package azuazu3939.lifepveassist;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.items.MythicItem;
import javassist.NotFoundException;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getPlayer;

public class TakeItemCommand implements CommandExecutor {

    private static TakeItemCommand instance;

    public TakeItemCommand() {
        TakeItemCommand.instance = this;
    }

    public static TakeItemCommand getInstance() {
        return instance;
    }

    String playerName;
    String mmitemid;
    int amount;
    Player player;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender.hasPermission("lifepveassist.command.takeitem")) && sender instanceof Player) {
            sender.sendMessage(ChatColor.RED + "権限がありません。");
            return true;
        }

        try {
            playerName = args[0];
            mmitemid = args[1];
            amount = Integer.parseInt(args[2]);
        } catch (Exception e) {
            sender.sendMessage("正しく入力しよう！ /takeitem <PlayerName> <MMItemID> <Amount>");
            sender.sendMessage("PlayerNameはオンラインプレイヤーのみ。");
            sender.sendMessage("MMItemIDは存在しているもののみ。IDは完全一致。");
            sender.sendMessage("Amountは所持しているか確認する量と消費する量。");
            return true;
        }

        try {
            player = getPlayer(playerName);
            if (player == null) {
                sender.sendMessage("このプレイヤーはログインしていません。");
                return true;
            }
        } catch (Exception e) {
            sender.sendMessage("このプレイヤーはログインしていません。");
            return true;
        }

        try {
            for (MythicItem mythicItem : MythicMobs.inst().getItemManager().getItems()) {

                if (mythicItem.getInternalName().equals(mmitemid)) {
                    CheckItem.hasItem(player, amount, mmitemid);
                }
            }
            if (mmitemid == null) {
                sender.sendMessage("そのアイテムは存在しません。");
                return true;
            }
        } catch (Exception e) {
            sender.sendMessage("そのアイテムは存在しません。");;
            return true;
        }
        return true;
    }
}
