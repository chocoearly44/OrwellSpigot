package tk.thesuperlab.orwell.services;

import org.bukkit.entity.Player;

import java.util.List;

public class SayService {
	private SayService() {
	}

	public static void sayMessage(Player sender, List<Player> receivers, String message) {
		String displayName = sender.getDisplayName();

		receivers.stream()
				.filter(player -> !IgnoreService.isPlayerIgnored(player, sender))
				.forEach(player -> player.sendMessage(displayName +
						" » " +
						message
				));
	}
}
