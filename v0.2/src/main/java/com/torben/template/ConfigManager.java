package com.torben.template;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {

    private YamlConfiguration yamlConfiguration;


    public ConfigManager(Main main){

        File file = new File(main.getDataFolder(), main.getConfig().getString("language") + ".yml");
        if (file.exists()){
            yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        } else {
            System.out.println("AI Plugin couldn't start as an invalid language file was selected in config.yml");
        }

    }

    public String getMessage(ConfigMessage message){

        return yamlConfiguration.getString(message.name().toLowerCase());

    }

}
