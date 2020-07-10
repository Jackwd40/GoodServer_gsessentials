package goodserver.gsessentials.pkg;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class rankhelp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {



        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            String option = strings[0];

            if (option.equalsIgnoreCase("kind")){
//                player.sendMessage("Kind");
//                player.sendMessage("- /sell : ability to sell things to the server using /sell hand or /sell inventory");
//                player.sendMessage("- /worth : ability to see the worth of items to the server");
//                player.sendMessage("- +1 Job");
//                player.sendMessage("- +1 Home");
                player.sendMessage(ChatColor.GREEN + "\n\nThe Kind " + ChatColor.RESET + ChatColor.GRAY + "\n$100" + ChatColor.RESET +
                        "\n/kit kind : get the kit for The Kind" +
                        "\n/sell : sell items to the server " +
                        "\n/worth : ability to see the worth of things to the server " +
                        "\n+1 Job " +
                        "\n+1 Home");
            } else if (option.equalsIgnoreCase("honest")){
                player.sendMessage(ChatColor.AQUA + "\n\nThe Honest " + ChatColor.RESET + ChatColor.GRAY + "\n$5,000" + ChatColor.RESET +
                        "\n/kit honest : get the kit for The Honest" +
                        "\n/back : Return to where you were last " +
                        "\n/craft : Open a crafting table anywhere! " +
                        "\n/disposal : Open a trashcan to dump unwanted items" +
                        "\n+2 Jobs " +
                        "\n+1 Home");
            } else if (option.equalsIgnoreCase("humble")){
                player.sendMessage(ChatColor.LIGHT_PURPLE + "\n\nThe Humble " + ChatColor.RESET + ChatColor.GRAY + "\n$100,000" + ChatColor.RESET +
                        "\n/kit Humble : get the kit for The Humble" +
                        "\n/feed : satisfy your hunger " +
                        "\n/condense : condense individual blocks into stacks" +
                        "\n/powertool : assign commands to items" +
                        "\n/nick : set a nickname for yourself" +
                        "\n/pweather : set the weather for yourself" +
                        "\n+2 Jobs" +
                        "\n+1 Home");
            } else if (option.equalsIgnoreCase("leader")){
                player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "\n\nThe Leader " + ChatColor.RESET + ChatColor.GRAY + "\n$1,000,000" + ChatColor.RESET +
                        "\n/kit leader : get the kit for The Leader" +
                        "\n/enderchest : open your enderchest anywhere " +
                        "\n/heal : heal yourself to full health " +
                        "\n/itemname : change the name of the item in your hand" +
                        "\n/lightning : shoot a bolt of lightning at your friends" +
                        "\n/ptime : set the time for yourself" +
                        "\n+3 Jobs " +
                        "\n+1 Home");
            } else if (option.equalsIgnoreCase("good")){
                player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "\n\nThe Good " + ChatColor.RESET + ChatColor.GRAY + "\n$10,000,000" + ChatColor.RESET +
                        "\n/kit good : get the kit for The Good" +
                        "\n/beezooka : shoot a bee at your friends " +
                        "\n/fly : enable fly to soar on the server" +
                        "\n/repair : repair your tools" +
                        "\n+3 Jobs " +
                        "\n+1 Home");
            }
        }




        return true;
    }
}
