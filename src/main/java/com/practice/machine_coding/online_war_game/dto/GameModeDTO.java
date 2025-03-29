package com.practice.machine_coding.online_war_game.dto;

import com.practice.machine_coding.online_war_game.enums.GameMode;

public record GameModeDTO(GameMode mode, int numOfRequiredPlayers) {}
