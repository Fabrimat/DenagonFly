package me.denagon.fly.scheduler;

import java.util.Arrays;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.denagon.database.Db;

public class DeactivateFly extends BukkitRunnable{

	private Player player;
	private Db db = new Db();

	public DeactivateFly(Player p) {
        this.player = p;
    }
	
	@Override
	public void run() {
		player.setFlying(false);
		db.UUID.setValue(player.getUniqueId().toString());
		db.playerName.setValue(player.getName());
		db.hasFlyUntil.setValue(-1);
		db.FlyTimes.update(db.UUID,  Arrays.asList(db.playerName, db.hasFlyUntil));
	}

}
