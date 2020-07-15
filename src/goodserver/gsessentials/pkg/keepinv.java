package goodserver.gsessentials.pkg;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.InheritanceNode;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.stream.Collectors;

public class keepinv implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;


            LuckPerms api = LuckPermsProvider.get();
            User user = main.loadUser(player);
            Set<String> groups = user.getNodes().stream()
                    .filter(NodeType.INHERITANCE::matches)
                    .map(NodeType.INHERITANCE::cast)
                    .map(InheritanceNode::getGroupName)
                    .collect(Collectors.toSet());

            if (strings.length == 0){
                // make sure they are at least humble
                if (player.hasPermission("goodserver.keepinv.toggle")){
                    // if they have it, remove it
                    if (player.hasPermission("essentials.keepinv")){
                        user.data().remove(Node.builder("essentials.keepinv").build());
                        player.sendMessage("Keep inventory is " + ChatColor.RED + "OFF");
                        api.getUserManager().saveUser(user);

                        // if they don't have it, add it
                    } else {
                        if (!player.hasPermission("essentials.keepinv")){
                            user.data().add(Node.builder("essentials.keepinv").build());
                        }
                        player.sendMessage("Keep inventory is " + ChatColor.GREEN + "ON");
                        api.getUserManager().saveUser(user);
                    }
                }
                else {
                    player.sendMessage(ChatColor.RED + "You don't have permission to turn on keep inventory yet!");
                }
            } else if (strings.length == 1) {
                if (player.hasPermission("goodserver.keepinv.toggle")) {
                    if (strings[0].equalsIgnoreCase("on")) {
                        if (!player.hasPermission("essentials.keepinv")){
                            user.data().add(Node.builder("essentials.keepinv").build());
                        }
                        player.sendMessage("Set keep inventory to " + ChatColor.GREEN + "ON");
                        api.getUserManager().saveUser(user);
                    } else if (strings[0].equalsIgnoreCase("off")) {
                        if (player.hasPermission("essentials.keepvin")){
                            user.data().remove(Node.builder("essentials.keepinv").build());
                        }
                        player.sendMessage("Set keep inventory to " + ChatColor.RED + "OFF");
                        api.getUserManager().saveUser(user);
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permission to turn on keep inventory yet!");
                }
            }
        }

        return true;
    }


}