package azuazu3939.lifepveassist;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.util.jnbt.CompoundTag;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CheckItem {

    public static void hasItem(Player player, int amount, String mmitemid) {

        for (ItemStack itemStack : player.getInventory().getContents()) {

            CompoundTag tag = MythicMobs.inst().getVolatileCodeHandler().getItemHandler().getNBTData(itemStack);

            if (tag.containsKey("MYTHIC_TYPE")) if (tag.getString("MYTHIC_TYPE").equals(mmitemid)) {
                TakeItem.removeInvItem(player, itemStack, amount, mmitemid);
                break;
            }
        }
    }
}
