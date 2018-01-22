package com.kornievich.selectionCommition.command;

public enum Roles {
    ADMIN("admin"),
    ENTRANT("entrant");
    private String text;
    private Roles(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
