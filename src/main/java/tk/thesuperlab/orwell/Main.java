package tk.thesuperlab.orwell;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tk.thesuperlab.orwell.commands.IgnoreCommand;
import tk.thesuperlab.orwell.commands.MuteCommand;
import tk.thesuperlab.orwell.listeners.ChatListener;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {
	public static Logger logger = Bukkit.getLogger();

	@Override
	public void onEnable() {
		logger.info("We shall meet in the place where there is no darkness.");

		// Register listeners
		getServer().getPluginManager().registerEvents(new ChatListener(), this);

		// Setup commands
		this.getCommand("mute").setExecutor(new MuteCommand());
		this.getCommand("ignore").setExecutor(new IgnoreCommand());
	}

	@Override
	public void onDisable() {
		logger.info("Power is not a means; it is an end.");
	}
}
