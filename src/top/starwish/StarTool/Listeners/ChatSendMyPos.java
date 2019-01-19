package top.starwish.StarTool.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import top.starwish.StarTool.Files.Config;

public class ChatSendMyPos implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
       if (Config.getPosTranlate) {
           if (e.getMessage().equalsIgnoreCase(Config.getPosText)) {
               Player player = e.getPlayer();
               e.setMessage("§b(" + (int)(player.getLocation().getX()) + "," + (int)(player.getLocation().getY()) + "," + (int)(player.getLocation().getZ()) + ")");
               return;
           }
       }
    }
}
