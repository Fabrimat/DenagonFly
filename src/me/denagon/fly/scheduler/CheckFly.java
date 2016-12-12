package me.denagon.fly.scheduler;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import me.denagon.database.Query;

public class CheckFly extends BukkitRunnable{

	private JavaPlugin plugin;
	private Query query = new Query();
	
	public CheckFly(JavaPlugin plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("unused")
	@Override
	public void run() {
		Collection<? extends Player> onlineP = Bukkit.getOnlinePlayers();
		
		for(Player p : onlineP) {
			UUID uuid = p.getUniqueId();
			int timestampPlayer = query.getTimestamp(uuid);
			if (timestampPlayer >= 0) {
				Date date = new Date();
				long timestampNow = date.getTime();
				if (timestampNow > timestampPlayer) {
					BukkitTask task = new ScheduleFly(this.plugin, p).runTaskLater(this.plugin, 20);
				}
			}
		}
	}

}
