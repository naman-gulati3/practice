package com.practice.machine_coding.online_war_game.dto;

import com.practice.machine_coding.online_war_game.enums.GameLocation;
import java.util.LinkedList;
import java.util.Queue;

public class Game {

  private final long gameId;
  private final GameModeDTO gameMode;
  private final GameLocation gameLocation;
  private final Queue<Team> teams;

  public Game(long gameId, GameModeDTO gameMode, GameLocation gameLocation, Queue<Team> teams) {
    this.gameId = gameId;
    this.gameMode = gameMode;
    this.gameLocation = gameLocation;
    this.teams = new LinkedList<>();
    validateGameState();
  }

  private void validateGameState() {
    if (teams.size() != 2) {
      throw new IllegalArgumentException("Minimum number of required team is 2");
    }
  }

  public boolean isFull() {
    return teams.size() == gameMode.numOfRequiredPlayers();
  }

  public void addPlayer(Team team) {
    this.teams.add(team);
  }

  public long getGameId() {
    return gameId;
  }

  public GameModeDTO getGameMode() {
    return gameMode;
  }

  public GameLocation getGameLocation() {
    return gameLocation;
  }

  public Queue<Team> getTeams() {
    return teams;
  }
}
