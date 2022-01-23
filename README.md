# Inventory-Restore

A simple and effective inventory-restoring plugin for all versions of Minecraft.

##  Features

- Inventory caching on player death with the ability to restore it via a command
- Fully configurable configuration file
- Compatible with all versions of Minecraft
- Basic API that allows you to use this base functionality in a separate application

## Installation

- Download the Jar file from [here](https://www.spigotmc.org/resources/inventory-restore-1-8-1-17.22436/).
- Export the jar to your server's "plugins" folder either by dragging and dropping, or through an FTP client such as FileZilla.
- Restart your server

## Configuration

All configuration options are included in the config.yml file that will be generated in the plugins/InventoryRestore directory of your server.  View that [here](https://github.com/evancolewright/inventory-restore/blob/main/src/main/resources/config.yml).

After configuring, make sure to restart your server to reflect any changes you made.

## Commands

The plugin currently only has one command as of version 2.1.  This command is described in the table below.

| Usage                          | Aliases          | Permission Node          |
| ------------------------------ | ---------------- | ------------------------ |
| /inventoryrestore (playerName) | /ir, /invrestore | inventoryrestore.restore |

## API
This plugin contains useful functionality that you may want to hook into rather than re-implementing yourself.
### Caching a Player's Inventory
```
// Get plugin instance
IRPlugin irPlugin = (IRPlugin) getServer().getPluginManager().getPlugin("InventoryRestore");

// Cache the inventory
irPlugin.getIrManager().cacheInventoryContents(player);
```
### Restoring a Player's Inventory
```
// Get plugin instance
IRPlugin irPlugin = (IRPlugin) getServer().getPluginManager().getPlugin("InventoryRestore");

// Get the result of restoring a player's inventory
IRResult result = irPlugin.getIrManager().restoreInventory(player);

// Make sure it was restored successfully
if (result == IRResult.SUCCESS)
{
    // Do stuff here
}
```
### Clearing a Player's Inventory from the cache
```
// Get plugin instance
IRPlugin irPlugin = (IRPlugin) getServer().getPluginManager().getPlugin("InventoryRestore");

// Clear the player from the cache
irPlugin.getIrManager().clearCacheContents(player);
```

## Contributing
See [Contributing](https://github.com/evancolewright/inventory-restore/blob/main/Contributing.md).

