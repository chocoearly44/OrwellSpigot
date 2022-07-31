package tk.thesuperlab.orwell.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.thesuperlab.orwell.services.IgnoreService;

public class IgnoreCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		if(!(commandSender instanceof Player)) {
			commandSender.sendMessage("Command must be used by a player.");
			return false;
		}

		if(args.length != 1) {
			return false;
		}

		Player ignore = Bukkit.getPlayer(args[0]);
		if(ignore == null) {
			return false;
		}

		Player sender = (Player) commandSender;

		if(IgnoreService.isPlayerIgnored(sender, ignore)) {
			IgnoreService.unignorePlayer(sender, ignore);
			commandSender.sendMessage("Player " + ignore.getDisplayName() + " unignored.");
		} else {
			IgnoreService.ignorePlayer(sender, ignore);
			commandSender.sendMessage("Player " + ignore.getDisplayName() + " ignored.");
		}

		return true;
	}
}