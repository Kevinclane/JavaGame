package com.JavaAPI.RequestModels;

public class EncounterUserAction {

    public String action;
    public String characterId;
    public String targetId;
    public Boolean inParty;
    public String encounterId;

    public EncounterUserAction(String action, String characterId, String targetId, Boolean inParty, String encounterId) {
        this.action = action;
        this.characterId = characterId;
        this.targetId = targetId;
        this.inParty = inParty;
        this.encounterId = encounterId;
    }
}
