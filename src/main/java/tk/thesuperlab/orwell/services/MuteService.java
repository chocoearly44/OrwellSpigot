package tk.thesuperlab.orwell.services;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class MuteService {
	private static final ArrayList<Player> mutedPlayers = new ArrayList<>();

	private MuteService() {
	}

	public static void mutePlayer(Player player) {
		mutedPlayers.add(player);
	}

	public static void unmutePlayer(Player player) {
		mutedPlayers.remove(player);
	}

	public static boolean isPlayerMuted(Player player) {
		return mutedPlayers.contains(player);
	}
}
