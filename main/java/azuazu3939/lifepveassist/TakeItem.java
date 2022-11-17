package azuazu3939.lifepveassist;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TakeItem {

    public static void removeInvItem(Player player, ItemStack itemStack, int amount, String mmidloop) {

        int a = itemStack.getAmount();
        if (a < amount) {
            itemStack.subtract(a);
            int b = amount - a;
            CheckItem.hasItem(player, b, mmidloop);
        } else itemStack.subtract(amount);
    }
}
