package com.github.evancolewright.inventoryrestore.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class PlayerUtils
{
    public static boolean isInventoryEmpty(Player player)
    {
        for (ItemStack itemStack : player.getInventory().getContents())
            if (itemStack != null) return false;
        return true;
    }

    public static void sendColorMessage(CommandSender commandSender, String message)
    {
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
