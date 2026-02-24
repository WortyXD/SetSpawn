package MadeByWorty1.setSpawn;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final SetSpawn plugin;

    public SetSpawnCommand(SetSpawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Bu Komut Sadece Oyuncular İçindir.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("setspawn.use")) {
            player.sendMessage(plugin.getConfig().getString("messages.no-permission")
                    .replace("&", "§"));
            return true;
        }

        Location loc = player.getLocation();

        plugin.getConfig().set("spawn.world", loc.getWorld().getName());
        plugin.getConfig().set("spawn.x", loc.getX());
        plugin.getConfig().set("spawn.y", loc.getY());
        plugin.getConfig().set("spawn.z", loc.getZ());
        plugin.getConfig().set("spawn.yaw", loc.getYaw());
        plugin.getConfig().set("spawn.pitch", loc.getPitch());

        plugin.saveConfig();

        player.sendMessage(plugin.getConfig().getString("messages.spawn-set")
                .replace("&", "§"));
        return true;
    }
}
