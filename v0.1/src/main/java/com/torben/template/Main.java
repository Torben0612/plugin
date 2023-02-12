package com.torben.template;

import com.torben.template.guis.AnvilTextGUI;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    ConfigManager manager = new ConfigManager(this);

    String licence = this.getConfig().getString("licence");

    @Override
    public void onEnable() {
        saveDefaultConfig();
        if(!new AdvancedLicense(licence, "https://tornadokspigotplugins.000webhostapp.com/verify.php", this).register()) return;

        saveResource("lang_en.yml", false);
        saveResource("lang_es.yml", false);
        getCommand("anvil-gui").setExecutor(new AnvilTextGUI());

        System.out.println(ChatColor.GREEN + manager.getMessage(ConfigMessage.PLUGIN_ENABLED));

    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + manager.getMessage(ConfigMessage.PLUGIN_DISABLED));
    }
}
