package com.flyfish233.crypto.spake2;

public enum Spake2Role {
    public static final enum Spake2Role Alice;
    public static final enum Spake2Role Bob;

    private static Spake2Role[] $values() {
        return new Spake2Role[]{Spake2Role.Alice, Spake2Role.Bob};
    }

    static {
        Spake2Role.Alice = new Spake2Role("Alice", 0);
        Spake2Role.Bob = new Spake2Role("Bob", 1);
        Spake2Role.$VALUES = Spake2Role.$values();
    }

    private Spake2Role(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static Spake2Role valueOf(String arg1) {
        return Enum.valueOf(Spake2Role.class, arg1);
    }

    public static Spake2Role[] values() {
        return Spake2Role.$VALUES.clone();
    }
}

