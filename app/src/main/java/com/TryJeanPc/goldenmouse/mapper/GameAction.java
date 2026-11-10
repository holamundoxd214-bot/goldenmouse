package com.TryJeanPc.goldenmouse.mapper;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\r¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/mapper/GameAction;", "", "<init>", "(Ljava/lang/String;I)V", "TOUCH", "MOVE_FORWARD", "MOVE_BACKWARD", "MOVE_LEFT", "MOVE_RIGHT", "JUMP", "FIRE", "AIM", "MACRO", "JOYSTICK_SPRINT", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum GameAction {
    public static final enum GameAction AIM;
    public static final enum GameAction FIRE;
    public static final enum GameAction JOYSTICK_SPRINT;
    public static final enum GameAction JUMP;
    public static final enum GameAction MACRO;
    public static final enum GameAction MOVE_BACKWARD;
    public static final enum GameAction MOVE_FORWARD;
    public static final enum GameAction MOVE_LEFT;
    public static final enum GameAction MOVE_RIGHT;
    public static final enum GameAction TOUCH;

    private static final GameAction[] $values() {
        return new GameAction[]{GameAction.TOUCH, GameAction.MOVE_FORWARD, GameAction.MOVE_BACKWARD, GameAction.MOVE_LEFT, GameAction.MOVE_RIGHT, GameAction.JUMP, GameAction.FIRE, GameAction.AIM, GameAction.MACRO, GameAction.JOYSTICK_SPRINT};
    }

    static {
        GameAction.TOUCH = new GameAction("TOUCH", 0);
        GameAction.MOVE_FORWARD = new GameAction("MOVE_FORWARD", 1);
        GameAction.MOVE_BACKWARD = new GameAction("MOVE_BACKWARD", 2);
        GameAction.MOVE_LEFT = new GameAction("MOVE_LEFT", 3);
        GameAction.MOVE_RIGHT = new GameAction("MOVE_RIGHT", 4);
        GameAction.JUMP = new GameAction("JUMP", 5);
        GameAction.FIRE = new GameAction("FIRE", 6);
        GameAction.AIM = new GameAction("AIM", 7);
        GameAction.MACRO = new GameAction("MACRO", 8);
        GameAction.JOYSTICK_SPRINT = new GameAction("JOYSTICK_SPRINT", 9);
        GameAction[] v0 = GameAction.$values();
        GameAction.$VALUES = v0;
        GameAction.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private GameAction(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return GameAction.$ENTRIES;
    }

    public static GameAction valueOf(String arg1) {
        return Enum.valueOf(GameAction.class, arg1);
    }

    public static GameAction[] values() {
        return GameAction.$VALUES.clone();
    }
}

