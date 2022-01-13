package com.JavaAPI.RequestModels;

public class EncounterReq {
    public String[] partyIds;
    public int enemyCount;
    public String gameId;
    public int level;

    public EncounterReq(String[] partyIds, int enemyCount, String gameId, int level) {
        this.partyIds = partyIds;
        this.enemyCount = enemyCount;
        this.gameId = gameId;
        this.level = level;
    }
}

