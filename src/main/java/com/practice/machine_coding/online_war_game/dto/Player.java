package com.practice.machine_coding.online_war_game.dto;

import com.practice.machine_coding.online_war_game.enums.GameRank;

public class Player {

  private final long id;
  private final String alias;
  private GameRank rank;
  private final boolean isInGame;

  public Player(long id, String alias, boolean isInGame) {
    this.id = id;
    this.alias = alias;
    this.rank = GameRank.UNRANKED;
    this.isInGame = false;
  }

  public long getId() {
    return id;
  }

  public String getAlias() {
    return alias;
  }

  public GameRank getRank() {
    return rank;
  }

  public boolean isInGame() {
    return isInGame;
  }

  public void setRank(GameRank rank) {
    this.rank = rank;
  }
}
