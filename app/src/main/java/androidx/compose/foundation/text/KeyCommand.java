package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000B\n\u0002\b6\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001Bj\u0002\b\u001Cj\u0002\b\u001Dj\u0002\b\u001Ej\u0002\b\u001Fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b\'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8¨\u00069"}, d2={"Landroidx/compose/foundation/text/KeyCommand;", "", "editsText", "", "<init>", "(Ljava/lang/String;IZ)V", "getEditsText", "()Z", "LEFT_CHAR", "RIGHT_CHAR", "RIGHT_WORD", "LEFT_WORD", "NEXT_PARAGRAPH", "PREV_PARAGRAPH", "LINE_START", "LINE_END", "LINE_LEFT", "LINE_RIGHT", "UP", "DOWN", "CENTER", "PAGE_UP", "PAGE_DOWN", "HOME", "END", "COPY", "PASTE", "CUT", "DELETE_PREV_CHAR", "DELETE_NEXT_CHAR", "DELETE_PREV_WORD", "DELETE_NEXT_WORD", "DELETE_FROM_LINE_START", "DELETE_TO_LINE_END", "SELECT_ALL", "SELECT_LEFT_CHAR", "SELECT_RIGHT_CHAR", "SELECT_UP", "SELECT_DOWN", "SELECT_PAGE_UP", "SELECT_PAGE_DOWN", "SELECT_HOME", "SELECT_END", "SELECT_LEFT_WORD", "SELECT_RIGHT_WORD", "SELECT_NEXT_PARAGRAPH", "SELECT_PREV_PARAGRAPH", "SELECT_LINE_START", "SELECT_LINE_END", "SELECT_LINE_LEFT", "SELECT_LINE_RIGHT", "DESELECT", "NEW_LINE", "TAB", "UNDO", "REDO", "CHARACTER_PALETTE", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum KeyCommand {
    public static final enum KeyCommand CENTER;
    public static final enum KeyCommand CHARACTER_PALETTE;
    public static final enum KeyCommand COPY;
    public static final enum KeyCommand CUT;
    public static final enum KeyCommand DELETE_FROM_LINE_START;
    public static final enum KeyCommand DELETE_NEXT_CHAR;
    public static final enum KeyCommand DELETE_NEXT_WORD;
    public static final enum KeyCommand DELETE_PREV_CHAR;
    public static final enum KeyCommand DELETE_PREV_WORD;
    public static final enum KeyCommand DELETE_TO_LINE_END;
    public static final enum KeyCommand DESELECT;
    public static final enum KeyCommand DOWN;
    public static final enum KeyCommand END;
    public static final enum KeyCommand HOME;
    public static final enum KeyCommand LEFT_CHAR;
    public static final enum KeyCommand LEFT_WORD;
    public static final enum KeyCommand LINE_END;
    public static final enum KeyCommand LINE_LEFT;
    public static final enum KeyCommand LINE_RIGHT;
    public static final enum KeyCommand LINE_START;
    public static final enum KeyCommand NEW_LINE;
    public static final enum KeyCommand NEXT_PARAGRAPH;
    public static final enum KeyCommand PAGE_DOWN;
    public static final enum KeyCommand PAGE_UP;
    public static final enum KeyCommand PASTE;
    public static final enum KeyCommand PREV_PARAGRAPH;
    public static final enum KeyCommand REDO;
    public static final enum KeyCommand RIGHT_CHAR;
    public static final enum KeyCommand RIGHT_WORD;
    public static final enum KeyCommand SELECT_ALL;
    public static final enum KeyCommand SELECT_DOWN;
    public static final enum KeyCommand SELECT_END;
    public static final enum KeyCommand SELECT_HOME;
    public static final enum KeyCommand SELECT_LEFT_CHAR;
    public static final enum KeyCommand SELECT_LEFT_WORD;
    public static final enum KeyCommand SELECT_LINE_END;
    public static final enum KeyCommand SELECT_LINE_LEFT;
    public static final enum KeyCommand SELECT_LINE_RIGHT;
    public static final enum KeyCommand SELECT_LINE_START;
    public static final enum KeyCommand SELECT_NEXT_PARAGRAPH;
    public static final enum KeyCommand SELECT_PAGE_DOWN;
    public static final enum KeyCommand SELECT_PAGE_UP;
    public static final enum KeyCommand SELECT_PREV_PARAGRAPH;
    public static final enum KeyCommand SELECT_RIGHT_CHAR;
    public static final enum KeyCommand SELECT_RIGHT_WORD;
    public static final enum KeyCommand SELECT_UP;
    public static final enum KeyCommand TAB;
    public static final enum KeyCommand UNDO;
    public static final enum KeyCommand UP;
    private final boolean editsText;

    private static final KeyCommand[] $values() {
        return new KeyCommand[]{KeyCommand.LEFT_CHAR, KeyCommand.RIGHT_CHAR, KeyCommand.RIGHT_WORD, KeyCommand.LEFT_WORD, KeyCommand.NEXT_PARAGRAPH, KeyCommand.PREV_PARAGRAPH, KeyCommand.LINE_START, KeyCommand.LINE_END, KeyCommand.LINE_LEFT, KeyCommand.LINE_RIGHT, KeyCommand.UP, KeyCommand.DOWN, KeyCommand.CENTER, KeyCommand.PAGE_UP, KeyCommand.PAGE_DOWN, KeyCommand.HOME, KeyCommand.END, KeyCommand.COPY, KeyCommand.PASTE, KeyCommand.CUT, KeyCommand.DELETE_PREV_CHAR, KeyCommand.DELETE_NEXT_CHAR, KeyCommand.DELETE_PREV_WORD, KeyCommand.DELETE_NEXT_WORD, KeyCommand.DELETE_FROM_LINE_START, KeyCommand.DELETE_TO_LINE_END, KeyCommand.SELECT_ALL, KeyCommand.SELECT_LEFT_CHAR, KeyCommand.SELECT_RIGHT_CHAR, KeyCommand.SELECT_UP, KeyCommand.SELECT_DOWN, KeyCommand.SELECT_PAGE_UP, KeyCommand.SELECT_PAGE_DOWN, KeyCommand.SELECT_HOME, KeyCommand.SELECT_END, KeyCommand.SELECT_LEFT_WORD, KeyCommand.SELECT_RIGHT_WORD, KeyCommand.SELECT_NEXT_PARAGRAPH, KeyCommand.SELECT_PREV_PARAGRAPH, KeyCommand.SELECT_LINE_START, KeyCommand.SELECT_LINE_END, KeyCommand.SELECT_LINE_LEFT, KeyCommand.SELECT_LINE_RIGHT, KeyCommand.DESELECT, KeyCommand.NEW_LINE, KeyCommand.TAB, KeyCommand.UNDO, KeyCommand.REDO, KeyCommand.CHARACTER_PALETTE};
    }

    static {
        KeyCommand.LEFT_CHAR = new KeyCommand("LEFT_CHAR", 0, false);
        KeyCommand.RIGHT_CHAR = new KeyCommand("RIGHT_CHAR", 1, false);
        KeyCommand.RIGHT_WORD = new KeyCommand("RIGHT_WORD", 2, false);
        KeyCommand.LEFT_WORD = new KeyCommand("LEFT_WORD", 3, false);
        KeyCommand.NEXT_PARAGRAPH = new KeyCommand("NEXT_PARAGRAPH", 4, false);
        KeyCommand.PREV_PARAGRAPH = new KeyCommand("PREV_PARAGRAPH", 5, false);
        KeyCommand.LINE_START = new KeyCommand("LINE_START", 6, false);
        KeyCommand.LINE_END = new KeyCommand("LINE_END", 7, false);
        KeyCommand.LINE_LEFT = new KeyCommand("LINE_LEFT", 8, false);
        KeyCommand.LINE_RIGHT = new KeyCommand("LINE_RIGHT", 9, false);
        KeyCommand.UP = new KeyCommand("UP", 10, false);
        KeyCommand.DOWN = new KeyCommand("DOWN", 11, false);
        KeyCommand.CENTER = new KeyCommand("CENTER", 12, false);
        KeyCommand.PAGE_UP = new KeyCommand("PAGE_UP", 13, false);
        KeyCommand.PAGE_DOWN = new KeyCommand("PAGE_DOWN", 14, false);
        KeyCommand.HOME = new KeyCommand("HOME", 15, false);
        KeyCommand.END = new KeyCommand("END", 16, false);
        KeyCommand.COPY = new KeyCommand("COPY", 17, false);
        KeyCommand.PASTE = new KeyCommand("PASTE", 18, true);
        KeyCommand.CUT = new KeyCommand("CUT", 19, true);
        KeyCommand.DELETE_PREV_CHAR = new KeyCommand("DELETE_PREV_CHAR", 20, true);
        KeyCommand.DELETE_NEXT_CHAR = new KeyCommand("DELETE_NEXT_CHAR", 21, true);
        KeyCommand.DELETE_PREV_WORD = new KeyCommand("DELETE_PREV_WORD", 22, true);
        KeyCommand.DELETE_NEXT_WORD = new KeyCommand("DELETE_NEXT_WORD", 23, true);
        KeyCommand.DELETE_FROM_LINE_START = new KeyCommand("DELETE_FROM_LINE_START", 24, true);
        KeyCommand.DELETE_TO_LINE_END = new KeyCommand("DELETE_TO_LINE_END", 25, true);
        KeyCommand.SELECT_ALL = new KeyCommand("SELECT_ALL", 26, false);
        KeyCommand.SELECT_LEFT_CHAR = new KeyCommand("SELECT_LEFT_CHAR", 27, false);
        KeyCommand.SELECT_RIGHT_CHAR = new KeyCommand("SELECT_RIGHT_CHAR", 28, false);
        KeyCommand.SELECT_UP = new KeyCommand("SELECT_UP", 29, false);
        KeyCommand.SELECT_DOWN = new KeyCommand("SELECT_DOWN", 30, false);
        KeyCommand.SELECT_PAGE_UP = new KeyCommand("SELECT_PAGE_UP", 0x1F, false);
        KeyCommand.SELECT_PAGE_DOWN = new KeyCommand("SELECT_PAGE_DOWN", 0x20, false);
        KeyCommand.SELECT_HOME = new KeyCommand("SELECT_HOME", 33, false);
        KeyCommand.SELECT_END = new KeyCommand("SELECT_END", 34, false);
        KeyCommand.SELECT_LEFT_WORD = new KeyCommand("SELECT_LEFT_WORD", 35, false);
        KeyCommand.SELECT_RIGHT_WORD = new KeyCommand("SELECT_RIGHT_WORD", 36, false);
        KeyCommand.SELECT_NEXT_PARAGRAPH = new KeyCommand("SELECT_NEXT_PARAGRAPH", 37, false);
        KeyCommand.SELECT_PREV_PARAGRAPH = new KeyCommand("SELECT_PREV_PARAGRAPH", 38, false);
        KeyCommand.SELECT_LINE_START = new KeyCommand("SELECT_LINE_START", 39, false);
        KeyCommand.SELECT_LINE_END = new KeyCommand("SELECT_LINE_END", 40, false);
        KeyCommand.SELECT_LINE_LEFT = new KeyCommand("SELECT_LINE_LEFT", 41, false);
        KeyCommand.SELECT_LINE_RIGHT = new KeyCommand("SELECT_LINE_RIGHT", 42, false);
        KeyCommand.DESELECT = new KeyCommand("DESELECT", 43, false);
        KeyCommand.NEW_LINE = new KeyCommand("NEW_LINE", 44, true);
        KeyCommand.TAB = new KeyCommand("TAB", 45, true);
        KeyCommand.UNDO = new KeyCommand("UNDO", 46, true);
        KeyCommand.REDO = new KeyCommand("REDO", 0x2F, true);
        KeyCommand.CHARACTER_PALETTE = new KeyCommand("CHARACTER_PALETTE", 0x30, true);
        KeyCommand[] v0 = KeyCommand.$values();
        KeyCommand.$VALUES = v0;
        KeyCommand.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private KeyCommand(String arg1, int arg2, boolean arg3) {
        super(arg1, arg2);
        this.editsText = arg3;
    }

    public final boolean getEditsText() {
        return this.editsText;
    }

    public static EnumEntries getEntries() {
        return KeyCommand.$ENTRIES;
    }

    public static KeyCommand valueOf(String arg1) {
        return Enum.valueOf(KeyCommand.class, arg1);
    }

    public static KeyCommand[] values() {
        return KeyCommand.$VALUES.clone();
    }
}

