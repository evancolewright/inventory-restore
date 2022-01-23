package com.github.evancolewright.inventoryrestore;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class IRPlugin extends JavaPlugin
{
    @Getter
    private IRManager irManager;

    @Override
    public void onEnable()
    {
        IRPlugin IRpLUGIN = (IRPlugin) getServer().getPluginManager().getPlugin("InventoryRestore");

        saveDefaultConfig();
        irManager = new IRManager(this);
        getServer().getPluginManager().registerEvents(new IRListeners(this), this);
        getCommand("inventoryrestore").setExecutor(new IRCommands(this));
        getLogger().info("Setup successful!  For support, PM me on SpigotMC or open an issue on GitHub.");
    }
}
