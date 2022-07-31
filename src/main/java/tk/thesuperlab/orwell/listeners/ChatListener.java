package tk.thesuperlab.orwell.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import tk.thesuperlab.orwell.services.MuteService;
import tk.thesuperlab.orwell.services.SayService;

import java.util.ArrayList;

public class ChatListener implements Listener {
	@EventHandler
	public void chatSent(AsyncPlayerChatEvent event) {
		event.setCancelled(true);

		Player sender = event.getPlayer();
		if(MuteService.isPlayerMuted(sender)) {
			sender.sendMessage(ChatColor.RED + "You are muted");
			return;
		}

		SayService.sayMessage(
				sender,
				new ArrayList<>(event.getRecipients()),
				event.getMessage()
		);
	}
}
