package de.Alex1002.MLGRush;

import de.Alex1002.MLGRush.GameStates.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;

public class init {
    private static MLGRush plugin;
    private static GameStateManager gameStateManager = new GameStateManager(plugin);
    private static Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    private static Objective objective = scoreboard.registerNewObjective("abcd", "abcd");
    private static Team redTeam = scoreboard.getTeam("redTeam");
    private static Team blueTeam = scoreboard.getTeam("blueTeam");
    private static Team redTeamCount = scoreboard.getTeam("redTeamCount");
    private static Team blueTeamCount = scoreboard.getTeam("blueTeamCount");

    private static int redTeamPoints;
    private static int blueTeamPoints;

    private static ArrayList<Player> playerList = new ArrayList<>();
    private static ArrayList<Block> placedBlocks = new ArrayList<>();
    private static ArrayList<Player> redTeamList = new ArrayList<>();
    private static ArrayList<Player> blueTeamList = new ArrayList<>();
    private static String winnerTeam;

    private static Location location;
    private static int timerSeconds = 5;


    public static void setPlugin(MLGRush plugin) {
        init.plugin = plugin;
    }
    public static MLGRush getPlugin() {
        return plugin;
    }

    public static GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public static Scoreboard getScoreboard() {
        return scoreboard;
    }
    public static Objective getObjective() {
        return objective;
    }

    public static void setRedTeam(Team redTeam) {
        init.redTeam = redTeam;
    }
    public static void setBlueTeam(Team blueTeam) {
        init.blueTeam = blueTeam;
    }
    public static Team getRedTeam() {
        return redTeam;
    }
    public static Team getBlueTeam() {
        return blueTeam;
    }

    public static void setRedTeamCount(Team redTeamCount) {
        init.redTeamCount = redTeamCount;
    }
    public static void setBlueTeamCount(Team blueTeamCount) {
        init.blueTeamCount = blueTeamCount;
    }
    public static Team getRedTeamCount() {
        return redTeamCount;
    }
    public static Team getBlueTeamCount() {
        return blueTeamCount;
    }

    public static void setRedTeamPoints(int redTeamPointsInt) {
        init.redTeamPoints = redTeamPointsInt;
    }
    public static void setBlueTeamPoints(int blueTeamPointsInt) {
        init.blueTeamPoints = blueTeamPointsInt;
    }
    public static int getRedTeamPoints() {
        return redTeamPoints;
    }
    public static int getBlueTeamPoints() {
        return blueTeamPoints;
    }

    public static void addPlayer(Player player){
        playerList.add(player);
    }
    public static void removePlayer(Player player){
        playerList.remove(player);
    }
    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public static void addBlock(Block block){
        placedBlocks.add(block);
    }
    public static ArrayList<Block> getPlacedBlocks() {
        return placedBlocks;
    }

    public static void addPlayerToTeamRed(Player player){
        redTeamList.add(player);
    }
    public static ArrayList<Player> getRedTeamList() {
        return redTeamList;
    }

    public static void addPlayerToTeamBlue(Player player){
        blueTeamList.add(player);
    }
    public static ArrayList<Player> getBlueTeamList() {
        return blueTeamList;
    }

    public static void setWinnerTeam(String winnerTeam) {
        init.winnerTeam = winnerTeam;
    }
    public static String getWinnerTeam() {
        return winnerTeam;
    }

    private static void setLocation(String PATH){
        double X = plugin.getConfig().getDouble(PATH+".X");
        double Y = plugin.getConfig().getDouble(PATH+".Y");
        double Z = plugin.getConfig().getDouble(PATH+".Z");
        float YAW = plugin.getConfig().getLong(PATH+".YAW");
        float PITCH = plugin.getConfig().getLong(PATH+".PITCH");
        World WORLD = Bukkit.getWorld(plugin.getConfig().getString(PATH+".WORLD"));
        location = new Location(WORLD, X,Y,Z,YAW,PITCH);
    }
    public static Location getLocation(String which) {
        if(which == "redteam"){
            setLocation("Setup.Map.redTeam");
            return location;
        }else if(which == "blueteam"){
            setLocation("Setup.Map.blueTeam");
            return location;
        }else if(which == "lobbyspawn"){
            setLocation("Setup.Lobby");
            return location;
        }
        return null;
    }

    public static void setTimerSeconds(int timerSeconds) {
        init.timerSeconds = timerSeconds;
    }
    public static int getTimerSeconds() {
        return timerSeconds;
    }
}