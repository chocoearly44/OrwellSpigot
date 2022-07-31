package tk.thesuperlab.orwell.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.thesuperlab.orwell.services.MuteService;
import tk.thesuperlab.orwell.services.SayService;

import java.util.ArrayList;

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

		StringBuilder message = new StringBuilder();
		for(String str : args) {
			message.append(str);
			message.append(' ');
		}

		SayService.sayMessage(
				sender,
				new ArrayList<>(commandSender.getServer().getOnlinePlayers()),
				message.toString()
		);

		return true;
	}
}
