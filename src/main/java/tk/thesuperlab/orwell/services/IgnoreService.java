package tk.thesuperlab.orwell.services;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class IgnoreService {
	private static final HashMap<Player, ArrayList<Player>> ignoredPlayers = new HashMap<>();

	private IgnoreService() {
	}

	public static void ignorePlayer(Player player, Player ignore) {
		ArrayList<Player> ignored = ignoredPlayers.getOrDefault(player, new ArrayList<>());
		ignored.add(ignore);

		ignoredPlayers.put(player, ignored);
	}

	public static void unignorePlayer(Player player, Player unignore) {
		ArrayList<Player> ignored = ignoredPlayers.getOrDefault(player, new ArrayList<>());
		ignored.remove(unignore);

		ignoredPlayers.put(player, ignored);
	}

	public static boolean isPlayerIgnored(Player player, Player ignored) {
		return ignoredPlayers.getOrDefault(player, new ArrayList<>()).contains(ignored);
	}
}
