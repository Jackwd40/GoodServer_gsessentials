package goodserver.gsessentials.pkg;

import com.gmail.nossr50.api.ChatAPI;
import com.gmail.nossr50.chat.AdminChatManager;
import com.gmail.nossr50.chat.ChatManager;
import com.gmail.nossr50.events.chat.McMMOAdminChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R1.boss.CraftBossBar;
import org.bukkit.entity.Player;

public class gsac implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            String message = "AC";
            BarColor color = BarColor.RED;
            BarStyle style = BarStyle.SOLID;
            BossBar bossBar = Bukkit.createBossBar(message, color, style);

//            CraftBossBar bar = new CraftBossBar(message, color, style);

            if (ChatAPI.isUsingAdminChat(player)){
                System.out.println("I did trigger. L33");
                bossBar.removePlayer(player);
                bossBar.setColor(BarColor.RED);
                bossBar.addPlayer(player);
                ChatAPI.toggleAdminChat(player);
            } else {
                bossBar.addPlayer(player);
                bossBar.setColor(BarColor.GREEN);
                ChatAPI.toggleAdminChat(player);
            }
        }
        return true;
    }
}
