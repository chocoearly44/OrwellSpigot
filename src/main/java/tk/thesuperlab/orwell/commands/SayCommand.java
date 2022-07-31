package tk.thesuperlab.orwell.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.thesuperlab.orwell.services.IgnoreService;
import tk.thesuperlab.orwell.services.MuteService;

public class SayCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		if(args.length < 1) {
			return false;
		}

		Player sender = (Player) commandSender;
		if(MuteService.isPlayerMuted(sender)) {
			sender.sendMessage(ChatColor.RED + "You are muted");
			return true;
		}

		StringBuilder rawMessage = new StringBuilder();
		for(String str : args) {
			rawMessage.append(str);
			rawMessage.append(' ');
		}

		String message = "[" + sender.getDisplayName() + "] " + rawMessage;
		commandSender.getServer().getOnlinePlayers().stream()
				.filter(player -> !IgnoreService.isPlayerIgnored(player, sender))
				.forEach(player -> player.sendMessage(message));

		return true;
	}
}
