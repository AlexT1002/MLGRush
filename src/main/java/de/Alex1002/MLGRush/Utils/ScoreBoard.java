package de.Alex1002.MLGRush.Utils;

import de.Alex1002.MLGRush.init;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreBoard {
    private static Objective objective = init.getObjective();
    private static Team redTeam = init.getRedTeam();
    private static Team blueTeam = init.getBlueTeam();
    private static Team redTeamCount = init.getRedTeamCount();
    private static Team blueTeamCount = init.getBlueTeamCount();

    public static void setScoreboard(Player player){
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§f§lMLGRush");
        objective.getScore("§c§lTeam Rot").setScore(4);
        objective.getScore("§9").setScore(3);
        objective.getScore("§1§lTeam Blau").setScore(2);
        objective.getScore("§8").setScore(1);

        if(redTeam == null){
            redTeam = objective.getScoreboard().registerNewTeam("redTeam");
            init.setRedTeam(redTeam);
        }
        if(blueTeam == null){
            blueTeam = objective.getScoreboard().registerNewTeam("blueTeam");
            init.setBlueTeam(blueTeam);
        }
        if(redTeamCount == null){
            redTeamCount = objective.getScoreboard().registerNewTeam("redTeamPoints");
            init.setRedTeamCount(redTeamCount);
        }
        if(blueTeamCount == null){
            blueTeamCount = objective.getScoreboard().registerNewTeam("blueTeamPoints");
            init.setBlueTeamCount(blueTeamCount);
        }

        redTeam.setPrefix("§c§lR §7• ");
        blueTeam.setPrefix("§1§lB §7• ");

        redTeamCount.setPrefix("§7§l• §6" + init.getRedTeamPoints());
        blueTeamCount.setPrefix("§7§l• §6" + init.getBlueTeamPoints());

        redTeamCount.addEntry("§9");
        blueTeamCount.addEntry("§8");


        player.setScoreboard(objective.getScoreboard());
    }

    public static void addToTeam(Player player){
        int maxPlayersInTeam = init.getPlayerList().size()/2;
        if(redTeam.getSize() != maxPlayersInTeam){
            redTeam.addPlayer(player);
            init.addPlayerToTeamRed(player);
            init.setRedTeam(redTeam);
        }else if(blueTeam.getSize() != maxPlayersInTeam){
            blueTeam.addPlayer(player);
            init.addPlayerToTeamBlue(player);
            init.setBlueTeam(blueTeam);
        }
    }

    public static void addPoints(Team playerTeam){
        if(playerTeam.equals(redTeamCount)){
            init.setRedTeamPoints(init.getRedTeamPoints() + 1);
            init.getRedTeamCount().setPrefix("§7§l• §6" + init.getRedTeamPoints());
        }else{
            init.setBlueTeamPoints(init.getBlueTeamPoints() + 1);
            init.getBlueTeamCount().setPrefix("§7§l• §6" + init.getBlueTeamPoints());
        }
    }
}
