package tk.thesuperlab.orwell.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.thesuperlab.orwell.services.MuteService;

public class MuteCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length != 1) {
			return false;
		}

		Player player = Bukkit.getPlayer(args[0]);
		if(player == null) {
			return false;
		}

		if(MuteService.isPlayerMuted(player)) {
			MuteService.unmutePlayer(player);
			sender.sendMessage("Player " + player.getDisplayName() + " unmuted.");
		} else {
			MuteService.mutePlayer(player);
			sender.sendMessage("Player " + player.getDisplayName() + " muted.");
		}

		return true;
	}
}
