package me.denagon.fly.scheduler;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class ScheduleFly extends BukkitRunnable {
	
	private Player player;
	private JavaPlugin plugin;
	
	public ScheduleFly(JavaPlugin plugin, Player p){
		this.player = p;
		this.plugin = plugin;
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		// TODO player.playSound(arg0, arg1, arg2, arg3);
		player.sendMessage("La fly si disattiverà tra 15 secondi!");
		BukkitTask task = new DeactivateFly(player).runTaskLater(this.plugin, 20*15);
		
	}

}
