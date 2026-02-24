package MadeByWorty1.setSpawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final SetSpawn plugin;

    public SpawnCommand(SetSpawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Bu Komut Sadece Oyuncular İçindir.");
            return true;
        }

        Player player = (Player) sender;

        if (!plugin.getConfig().contains("spawn.world")) {
            player.sendMessage(plugin.getConfig().getString("messages.spawn-not-set")
                    .replace("&", "§"));
            return true;
        }

        Location spawn = new Location(
                Bukkit.getWorld(plugin.getConfig().getString("spawn.world")),
                plugin.getConfig().getDouble("spawn.x"),
                plugin.getConfig().getDouble("spawn.y"),
                plugin.getConfig().getDouble("spawn.z"),
                (float) plugin.getConfig().getDouble("spawn.yaw"),
                (float) plugin.getConfig().getDouble("spawn.pitch")
        );

        player.teleport(spawn);
        player.sendMessage(plugin.getConfig().getString("messages.spawn-teleport")
                .replace("&", "§"));

        return true;
    }
}
