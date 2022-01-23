package com.github.evancolewright.inventoryrestore;

import com.github.evancolewright.inventoryrestore.utils.PlayerUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class IRManager
{
    private final Map<UUID, ItemStack[]> inventoryContents = new HashMap<>();
    private final Map<UUID, ItemStack[]> armorContents = new HashMap<>();

    private final IRPlugin plugin;
    private final FileConfiguration config;

    public IRManager(IRPlugin plugin)
    {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    /**
     * Attempts to cache a {@link Player} inventory on death.
     *
     * @param player The player that died
     */
    public void cacheInventoryContents(Player player)
    {
        if (player.getKiller() == null && !plugin.getConfig().getBoolean("store_on_natural_death"))
            return;
        inventoryContents.put(player.getUniqueId(), player.getInventory().getContents());
        armorContents.put(player.getUniqueId(), player.getInventory().getArmorContents());
    }

    /**
     * Attempts to restore a {@link Player} inventory from the cache.
     *
     * @param player The {@link Player} that needs restoring
     * @return The {@link IRResult} that describes the result of the attempted restore
     */
    public IRResult restoreInventory(Player player)
    {
        if (player == null) return IRResult.OFFLINE;
        if (!player.isOnline()) return IRResult.OFFLINE;
        if (config.getBoolean("require_empty_inventory") && !PlayerUtils.isInventoryEmpty(player)) return IRResult.INVENTORY_NOT_EMPTY;
        if (!inventoryContents.containsKey(player.getUniqueId())) return IRResult.NO_SAVED_INVENTORY;

        PlayerInventory inventory = player.getInventory();
        inventory.setContents(inventoryContents.get(player.getUniqueId()));
        inventory.setArmorContents(armorContents.get(player.getUniqueId()));

        if (config.getBoolean("clear_on_restore"))
            clearCacheContents(player);

        return IRResult.SUCCESS;
    }

    /**
     * Clears a {@link Player}'s {@link org.bukkit.inventory.Inventory} from the cache if it exists.
     * @param player The {@link Player} that needs clearing
     */
    public void clearCacheContents(Player player)
    {
        inventoryContents.remove(player.getUniqueId());
        armorContents.remove(player.getUniqueId());
    }
}
