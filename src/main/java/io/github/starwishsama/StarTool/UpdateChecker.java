package io.github.starwishsama.StarTool;

import io.github.starwishsama.StarTool.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class UpdateChecker {
    public static String getLatestVer(){
        String version = null;
        try {
            URL url = new URL("https://raw.githubusercontent.com/StarWishsama/StarTool/lite/Version.txt");
            InputStream a = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(a, StandardCharsets.UTF_8));
            version = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;
    }
    public static boolean isLatest(){
        boolean isLatest = false;
        String latestVer = getLatestVer();
        String current = StarToolMain.getInstance().getDescription().getVersion();
        if (latestVer.equalsIgnoreCase(current)){
            isLatest = true;
        }
        return isLatest;
    }
    static void CheckUpdate(){
        new BukkitRunnable(){
            public void run(){
                if (isLatest()){
                    Bukkit.getConsoleSender().sendMessage(Utils.color("&bStarTool > &e您当前正在使用最新版本!"));
                } else
                    Bukkit.getConsoleSender().sendMessage(Utils.color("&bStarTool > &e新版本 " + getLatestVer() +" 已发布, 请至 Github Releases 界面下载."));
            }
        }.runTaskAsynchronously(StarToolMain.getInstance());
    }
}
