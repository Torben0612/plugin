package com.torben.template.guis;

import com.torben.template.ConfigManager;
import com.torben.template.ConfigMessage;
import com.torben.template.Main;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AnvilTextGUI implements CommandExecutor {

    private Main main;

    public AnvilTextGUI(Main main) {
        this.main = main;
    }
    ConfigManager manager = new ConfigManager(main);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            new AnvilGUI.Builder()
                    .onComplete((target, text) -> {
                        Bukkit.broadcastMessage(target.getName() + ChatColor.YELLOW + manager.getMessage(ConfigMessage.BROADCAST_PREFIX) + text);

                        return AnvilGUI.Response.close();
                    })
                    .text(manager.getMessage(ConfigMessage.TEXT_INSIDE_ANVIL_GUI))
                    .title(manager.getMessage(ConfigMessage.ANVIL_GUI_TITLE))
                    .itemLeft(new ItemStack(Material.NAME_TAG))
                    .plugin(new Main())
                    .open(player);

        } else {
            sender.sendMessage(ChatColor.RED + manager.getMessage(ConfigMessage.PLAYER_CMD_ONLY_ERROR));
            return false;
        }
        return false;
    }
}