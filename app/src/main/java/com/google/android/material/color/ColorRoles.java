package com.google.android.material.color;

public final class ColorRoles {
    private final int accent;
    private final int accentContainer;
    private final int onAccent;
    private final int onAccentContainer;

    ColorRoles(int arg1, int arg2, int arg3, int arg4) {
        super();
        this.accent = arg1;
        this.onAccent = arg2;
        this.accentContainer = arg3;
        this.onAccentContainer = arg4;
    }

    public int getAccent() {
        return this.accent;
    }

    public int getAccentContainer() {
        return this.accentContainer;
    }

    public int getOnAccent() {
        return this.onAccent;
    }

    public int getOnAccentContainer() {
        return this.onAccentContainer;
    }
}

