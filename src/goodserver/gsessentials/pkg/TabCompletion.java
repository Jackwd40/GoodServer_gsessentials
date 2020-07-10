package goodserver.gsessentials.pkg;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompletion implements TabCompleter {

    @Override
    public List<String> onTabComplete (CommandSender sender, Command cmd, String label, String[] args){

        List<String> list = new ArrayList<>();

        if(cmd.getName().equalsIgnoreCase("rankhelp") && args.length >= 0){
            if(sender instanceof Player){
                Player player = (Player) sender;


                list.add("kind");
                list.add("honest");
                list.add("humble");
                list.add("leader");
                list.add("good");

            }
        }
        return list;
    }
}
