package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/input/LinuxKeyCodeMap;", "", "<init>", "()V", "name", "", "code", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class LinuxKeyCodeMap {
    public static final int $stable;
    public static final LinuxKeyCodeMap INSTANCE;

    static {
        LinuxKeyCodeMap.INSTANCE = new LinuxKeyCodeMap();
    }

    private LinuxKeyCodeMap() {
        super();
    }

    public final String name(int arg4) {
        if(arg4 == 1) {
            return "ESCAPE";
        }

        int v1 = 11;
        if(2 <= arg4 && arg4 < v1) {
            return String.valueOf(arg4 - 1);
        }

        if(arg4 == v1) {
            return "0";
        }

        if(arg4 == 12) {
            return "MINUS";
        }

        if(arg4 == 13) {
            return "EQUALS";
        }

        if(arg4 == 14) {
            return "DEL";
        }

        if(arg4 == 15) {
            return "TAB";
        }

        if(arg4 == 16) {
            return "Q";
        }

        if(arg4 == 17) {
            return "W";
        }

        if(arg4 == 18) {
            return "E";
        }

        if(arg4 == 19) {
            return "R";
        }

        if(arg4 == 20) {
            return "T";
        }

        if(arg4 == 21) {
            return "Y";
        }

        if(arg4 == 22) {
            return "U";
        }

        if(arg4 == 23) {
            return "I";
        }

        if(arg4 == 24) {
            return "O";
        }

        if(arg4 == 25) {
            return "P";
        }

        if(arg4 == 26) {
            return "LEFT_BRACKET";
        }

        if(arg4 == 27) {
            return "RIGHT_BRACKET";
        }

        if(arg4 == 28) {
            return "ENTER";
        }

        if(arg4 == 29) {
            return "LEFTCTRL";
        }

        if(arg4 == 30) {
            return "A";
        }

        if(arg4 == 0x1F) {
            return "S";
        }

        if(arg4 == 0x20) {
            return "D";
        }

        String v0 = "F";
        if(arg4 == 33) {
            return v0;
        }

        if(arg4 == 34) {
            return "G";
        }

        if(arg4 == 35) {
            return "H";
        }

        if(arg4 == 36) {
            return "J";
        }

        if(arg4 == 37) {
            return "K";
        }

        if(arg4 == 38) {
            return "L";
        }

        if(arg4 == 39) {
            return "SEMICOLON";
        }

        if(arg4 == 40) {
            return "APOSTROPHE";
        }

        if(arg4 == 41) {
            return "GRAVE";
        }

        if(arg4 == 42) {
            return "LEFTSHIFT";
        }

        if(arg4 == 43) {
            return "BACKSLASH";
        }

        if(arg4 == 44) {
            return "Z";
        }

        if(arg4 == 45) {
            return "X";
        }

        if(arg4 == 46) {
            return "C";
        }

        if(arg4 == 0x2F) {
            return "V";
        }

        if(arg4 == 0x30) {
            return "B";
        }

        if(arg4 == 49) {
            return "N";
        }

        if(arg4 == 50) {
            return "M";
        }

        if(arg4 == 51) {
            return "COMMA";
        }

        if(arg4 == 52) {
            return "PERIOD";
        }

        if(arg4 == 53) {
            return "SLASH";
        }

        if(arg4 == 54) {
            return "RIGHTSHIFT";
        }

        if(arg4 == 55) {
            return "NUMPAD_MULTIPLY";
        }

        if(arg4 == 56) {
            return "LEFTALT";
        }

        if(arg4 == 57) {
            return "SPACE";
        }

        int v3 = 58;
        if(arg4 == v3) {
            return "CAPS_LOCK";
        }

        int v2 = 69;
        if(59 <= arg4 && arg4 < v2) {
            return v0 + (arg4 - v3);
        }

        if(arg4 == v2) {
            return "NUM_LOCK";
        }

        if(arg4 == 70) {
            return "SCROLL_LOCK";
        }

        if(arg4 == 71) {
            return "NUMPAD_7";
        }

        if(arg4 == 72) {
            return "NUMPAD_8";
        }

        if(arg4 == 73) {
            return "NUMPAD_9";
        }

        if(arg4 == 74) {
            return "NUMPAD_SUBTRACT";
        }

        if(arg4 == 75) {
            return "NUMPAD_4";
        }

        if(arg4 == 76) {
            return "NUMPAD_5";
        }

        if(arg4 == 77) {
            return "NUMPAD_6";
        }

        if(arg4 == 78) {
            return "NUMPAD_ADD";
        }

        if(arg4 == 0x4F) {
            return "NUMPAD_1";
        }

        if(arg4 == 80) {
            return "NUMPAD_2";
        }

        if(arg4 == 81) {
            return "NUMPAD_3";
        }

        if(arg4 == 82) {
            return "NUMPAD_0";
        }

        if(arg4 == 83) {
            return "NUMPAD_DOT";
        }

        if(arg4 == 87) {
            return "F11";
        }

        if(arg4 == 88) {
            return "F12";
        }

        if(arg4 == 0x60) {
            return "NUMPAD_ENTER";
        }

        if(arg4 == 97) {
            return "RIGHTCTRL";
        }

        if(arg4 == 98) {
            return "NUMPAD_DIVIDE";
        }

        if(arg4 == 100) {
            return "RIGHTALT";
        }

        if(arg4 == 102) {
            return "MOVE_HOME";
        }

        if(arg4 == 103) {
            return "DPAD_UP";
        }

        if(arg4 == 104) {
            return "PAGE_UP";
        }

        if(arg4 == 105) {
            return "DPAD_LEFT";
        }

        if(arg4 == 106) {
            return "DPAD_RIGHT";
        }

        if(arg4 == 107) {
            return "MOVE_END";
        }

        if(arg4 == 108) {
            return "DPAD_DOWN";
        }

        if(arg4 == 109) {
            return "PAGE_DOWN";
        }

        if(arg4 == 110) {
            return "INSERT";
        }

        if(arg4 == 0x6F) {
            return "FORWARD_DEL";
        }

        if(arg4 == 0x7D) {
            return "LEFTMETA";
        }

        if(arg4 == 0x7E) {
            return "RIGHTMETA";
        }

        if(arg4 == 0x7F) {
            return "MENU";
        }

        return "LINUX_" + arg4;
    }
}

