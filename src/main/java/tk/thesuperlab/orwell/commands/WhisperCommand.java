package tk.thesuperlab.orwell.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.thesuperlab.orwell.services.IgnoreService;
import tk.thesuperlab.orwell.services.MuteService;

public class WhisperCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		if(args.length < 2) {
			return false;
		}

		Player receiver = Bukkit.getPlayer(args[0]);
		if(receiver == null) {
			return false;
		}

		Player sender = (Player) commandSender;
		if(MuteService.isPlayerMuted(sender)) {
			sender.sendMessage(ChatColor.RED + "You are muted");
			return true;
		}

		sender.sendMessage("You whispered to " + receiver.getDisplayName());
		if(IgnoreService.isPlayerIgnored(receiver, sender)) {
			return true;
		}

		StringBuilder rawMessage = new StringBuilder();
		for(int i = 1; i < args.length; i++) {
			rawMessage.append(args[i]);
			rawMessage.append(' ');
		}

		String message = String.valueOf(ChatColor.GRAY) +
				ChatColor.ITALIC +
				sender.getDisplayName() +
				" whispers to you: " +
				rawMessage;

		receiver.sendMessage(message);
		return true;
	}
}
