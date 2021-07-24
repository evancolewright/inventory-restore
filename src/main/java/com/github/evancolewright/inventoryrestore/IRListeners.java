package com.github.evancolewright.inventoryrestore;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public final class IRListeners implements Listener
{
    private final IRPlugin plugin;
    public IRListeners(IRPlugin plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        plugin.getIrManager().cacheInventoryContents(event.getEntity());
    }
}
