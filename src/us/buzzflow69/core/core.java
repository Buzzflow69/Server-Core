package us.buzzflow69.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import us.buzzflow69.core.ModCommands.Vanish;
import us.buzzflow69.core.Utils.ULicense;


@SuppressWarnings("unused")
public final class core extends JavaPlugin {

    @Override
    public void onEnable() {
        new Vanish(this);
        if(!new ULicense(getCoreConfig().getString("Auth.HWID"), "https://license.flaxeneel2.cf/api/v1", "5c63cbdfa7427242a79f5a2f206cbfe29a4e006f").verify()) {
            Bukkit.getPluginManager().disablePlugin(this);
            Bukkit.getScheduler().cancelTasks(this);
        }

    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "Disabled.");
    }
}
