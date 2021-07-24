package com.github.evancolewright.inventoryrestore;

import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class IRPlugin extends JavaPlugin
{
    @Getter(AccessLevel.PACKAGE)
    private IRManager irManager;

    @Override
    public void onEnable()
    {
        saveDefaultConfig();
        irManager = new IRManager(this);
        getServer().getPluginManager().registerEvents(new IRListeners(this), this);
        getCommand("inventoryrestore").setExecutor(new IRCommands(this));
        getLogger().info("Setup successful!  For support, PM me on SpigotMC or open an issue on GitHub.");
    }
}
