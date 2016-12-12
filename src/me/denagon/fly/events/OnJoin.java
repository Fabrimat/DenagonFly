package me.denagon.fly.events;

import java.util.Date;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.denagon.fly.Main;
import me.denagon.database.Query;
import me.denagon.fly.scheduler.ScheduleFly;

public class OnJoin implements Listener {
	
	Main main = new Main();
	private JavaPlugin plugin = main;
	private Query query = new Query();
	
	@EventHandler (priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		UUID uuid = p.getUniqueId();
		int timestampPlayer = query.getTimestamp(uuid);
		if (timestampPlayer >= 0) {
			Date date = new Date();
			long timestampNow = date.getTime();
			if (timestampNow > timestampPlayer) {
				new ScheduleFly(this.plugin, p).runTaskLater(this.plugin, 20);
			}
		}
    }
}
