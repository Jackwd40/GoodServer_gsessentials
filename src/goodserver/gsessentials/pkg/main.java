package goodserver.gsessentials.pkg;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


public class main extends JavaPlugin {

    //    initalizies the econonmy as vault recommends
    private static Economy econ = null;


    @Override
    public void onEnable() {
        getLogger().info("GS Essentials was enabled");

//        enable economy as vault recommends
        if (!setupEconomy() ) {
            System.out.println("No economy plugin found. Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        } else if (getServer().getPluginManager().getPlugin("LuckPerms") == null){
            System.out.println("LuckPerms was not found. Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }


//        getCommand("NAME OF COMMAND").setExecutor(new CLASS NAME);

        getCommand("rankhelp").setTabCompleter(new TabCompletion());
        getCommand("rankhelp").setExecutor(new rankhelp());
        getCommand("keepInv").setTabCompleter(new TabCompletion());
        getCommand("keepinv").setExecutor(new keepinv());


    }

    // Will not need to be edited.
    // setup econ as vault recommends
    private boolean setupEconomy(){
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    // standard method that handles when the server shuts down and the plugin is disabled.
    @Override
    public void onDisable() {
        getLogger().info("GS Essentials was disabled");
    }

    // Will not need to be edited.
    //    get method as vault recommends
    public static Economy getEconomy() {
        return econ;
    }

    //
    public static User loadUser(Player player){
        if (!player.isOnline()){
            throw new IllegalStateException("Player is offline.");
        }


        LuckPerms api = LuckPermsProvider.get();
        return api.getUserManager().getUser(player.getUniqueId());
    }
}
