package com.practice.machine_coding.online_war_game.dto;

import com.practice.machine_coding.online_war_game.enums.GameLocation;
import com.practice.machine_coding.online_war_game.enums.GameRank;
import java.util.List;

public class MatchRequest {

  private final List<Player> players;

  private final GameLocation gameLocation;

  private final GameModeDTO gameMode;

  private final GameRank gameRank;

  public MatchRequest(
      List<Player> players, GameLocation gameLocation, GameModeDTO gameMode, GameRank gameRank) {
    this.players = players;
    this.gameLocation = gameLocation;
    this.gameMode = gameMode;
    this.gameRank = gameRank;
  }

  public GameRank getGameRank() {
    return gameRank;
  }

  public GameModeDTO getGameMode() {
    return gameMode;
  }

  public GameLocation getGameLocation() {
    return gameLocation;
  }

  public List<Player> getPlayers() {
    return players;
  }
}
