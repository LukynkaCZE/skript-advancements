package me.hotpocket.skriptadvancements;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Skriptadvancements extends JavaPlugin {
    private static Skriptadvancements instance;
    SkriptAddon addon;

    public Skriptadvancements() {
    }

    public void onEnable() {
        instance = this;
        this.addon = Skript.registerAddon(this);
        this.addon.setLanguageFileDirectory("lang");

        int id = 15554;
        Metrics metrics = new Metrics(this, id);

        try {
            this.addon.loadClasses("me.hotpocket.skriptadvancements", new String[]{"elements"});
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        Bukkit.getLogger().info("[skript-advancements] has been enabled.");
    }

    public void onDisable() {
        Bukkit.getLogger().info("[skript-advancements] has been disabled.");
    }

    public static Skriptadvancements getInstance() {
        return instance;
    }
}
