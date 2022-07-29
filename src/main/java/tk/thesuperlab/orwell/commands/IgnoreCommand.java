package tk.thesuperlab.orwell.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.thesuperlab.orwell.services.IgnoreService;

public class IgnoreCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Command must be used by a player.");
			return false;
		}

		if(args.length != 1) {
			return false;
		}

		Player ignore = Bukkit.getPlayer(args[0]);
		if(ignore == null) {
			return false;
		}

		Player player = (Player) sender;

		if(IgnoreService.isPlayerIgnored(player, ignore)) {
			IgnoreService.unignorePlayer(player, ignore);
			sender.sendMessage("Player " + player.getDisplayName() + " unignored.");
		} else {
			IgnoreService.ignorePlayer(player, ignore);
			sender.sendMessage("Player " + player.getDisplayName() + " ignored.");
		}

		return true;
	}
}