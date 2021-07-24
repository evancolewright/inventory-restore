package com.github.evancolewright.inventoryrestore;

import com.github.evancolewright.inventoryrestore.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public final class IRCommands implements CommandExecutor
{
    private final IRPlugin plugin;
    private final FileConfiguration config;

    public IRCommands(IRPlugin plugin)
    {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        if (args.length == 1)
        {
            Player target = Bukkit.getPlayer(args[0]);
            switch (plugin.getIrManager().restoreInventory(target))
            {
                case OFFLINE:
                    PlayerUtils.sendColorMessage(commandSender, config.getString("messages.player_offline"));
                    break;
                case INVENTORY_NOT_EMPTY:
                    PlayerUtils.sendColorMessage(commandSender, config.getString("messages.player_inventory_not_empty"));
                    break;
                case NO_SAVED_INVENTORY:
                    PlayerUtils.sendColorMessage(commandSender, config.getString("messages.player_no_cache"));
                    break;
                default:
                    PlayerUtils.sendColorMessage(commandSender, config.getString("messages.player_inventory_restored")
                            .replace("{PLAYER}", target.getName()));
                    PlayerUtils.sendColorMessage(target, config.getString("messages.inventory_restored"));
            }
        } else
        {
            PlayerUtils.sendColorMessage(commandSender, config.getString("messages.usage"));
        }
        return false;
    }

}
