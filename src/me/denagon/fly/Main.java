package me.denagon.fly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.denagon.fly.events.Damage;

public class Main extends JavaPlugin {
	
	//private static Main instance;
	
	//public static Main getInstance() {
    //    return instance;
    //}
	
	private void intro() {
		this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + ">>>>>>>> [INFO] ----------------- DenagonFly v1.0 Alpha ------------------");
        this.getServer().getConsoleSender().sendMessage(ChatColor.AQUA +  ">>>>>>>> [INFO]               Created by Fabrimat & Cekkin23!");
        this.getServer().getConsoleSender().sendMessage(ChatColor.AQUA +  ">>>>>>>> [INFO]               Thank you for using this Plugin!");
        this.getServer().getConsoleSender().sendMessage(ChatColor.RED +   ">>>>>>>> [INFO]                    www.denagonstales.net      ");
        this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + ">>>>>>>> [INFO] ----------------------------------------------------------");
	}
	
	private void events() {
		this.getServer().getPluginManager().registerEvents(new Damage(), this); // onDamage (Damage.java)
	}
	
	@Override
	public void onEnable() {
        intro();
        events();
	}
	
	@Override
	public void onDisable() {
		Bukkit.getServer().getLogger().info("DenagonFly disabled!");
		this.getServer().getConsoleSender().sendMessage(">>>>>>>> [INFO] DenagonFly disabled!");
	}

}
