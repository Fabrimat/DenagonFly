package me.denagon.fly.events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

public class Damage implements Listener {


	@EventHandler (priority = EventPriority.HIGH)
	public void onArrowHit(EntityDamageByEntityEvent e) {
		Entity damaged = e.getEntity();
		Entity damageEntity = e.getDamager();
		
		if(damaged instanceof Player)
		if(damageEntity instanceof Arrow) {
			Arrow arrow = (Arrow)damageEntity;
			ProjectileSource entityThrower = arrow.getShooter();
			if(entityThrower instanceof Player) {
				Player pt = (Player)entityThrower;
				//Player playerHit = (Player)damaged;
				if(pt.isFlying() && !pt.hasPermission("fly.canDamage")) {
					pt.sendMessage(ChatColor.RED+"Non puoi colpire gli altri giocatori mentre hai la FLY attivata!");
					pt.playSound(pt.getLocation(), Sound.ENTITY_GHAST_HURT, 1, 1);
					e.setCancelled(true);
				}
			}
		}
		}
		

		@EventHandler (priority = EventPriority.HIGH)
		public void OnNormalHit(EntityDamageByEntityEvent e) {
			if (e.getDamager() instanceof Player) {
				if (e.getEntity() instanceof Player){
					Entity damageEntity = e.getDamager();
					Player dam = (Player)damageEntity;
					if(dam.isFlying() && !dam.hasPermission("flyhurt.admin")) {
						dam.sendMessage(ChatColor.RED+"Non puoi colpire gli altri giocatori mentre hai la FLY attivata!");
						dam.playSound(dam.getLocation(), Sound.ENTITY_GHAST_HURT, 1, 1);
						e.setCancelled(true);
					}
				}
			}
		}
}