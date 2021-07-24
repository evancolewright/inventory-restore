# Inventory-Restore

A simple and effective inventory-restoring plugin for all versions of Minecraft.

##  Features

- Inventory caching on player death with the ability to restore it via a command
- Fully configurable configuration file
- Compatible with all versions of Minecraft

## Configuration

All configuration options are included in the config.yml file that will be generated in the /plugins/InventoryRestore directory of your server.  View that [here](https://github.com/evancolewright/inventory-restore/blob/main/src/main/resources/config.yml).

After configuring to your liking, restart / reload your server.

## Commands

The plugin currently only has one command as of version 2.0.  This command is described in the table below.

| Usage                          | Aliases          | Permission Node          |
| ------------------------------ | ---------------- | ------------------------ |
| /inventoryrestore <playerName> | /ir, /invrestore | inventoryrestore.restore |

## Installation

- Download the Jar file from [here]https://www.spigotmc.org/resources/inventory-restore-1-8-1-17.22436/).
- Export the jar to your server's "plugins" folder either by dragging and dropping, or through an FTP client such as FileZilla.
- Restart / Reload your server

## Reporting Issues / Contributing

**When reporting issues**, please include the following items in the thread with a descriptive title:

- The Spigot server version you are running

- A stack trace enclosed in code tags

- A brief description of the error

  

**For contributing purposes**, pull requests are welcome, but I do ask that you attempt to not branch outside the scope of this plugin.  This program is not intended to be extremely complex or feature-packed.   To summarize, small features are more appropriate.
