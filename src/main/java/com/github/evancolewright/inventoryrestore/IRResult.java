package com.github.evancolewright.inventoryrestore;

import org.bukkit.entity.Player;

/**
 * Represents the result of attempting to restore a {@link Player} inventory.
 */
public enum IRResult
{
    /**
     * {@link Player} is not online
     */
    OFFLINE,

    /**
     * {@link Player} inventory is not empty
     */
    INVENTORY_NOT_EMPTY,

    /**
     * {@link Player} does not have a cached inventory
     */
    NO_SAVED_INVENTORY,

    /**
     * {@link Player} had their inventory restored successfully
     */
    SUCCESS;
}
