package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Landroidx/compose/material3/ScaffoldLayoutContent;", "", "<init>", "(Ljava/lang/String;I)V", "TopBar", "MainContent", "Snackbar", "Fab", "BottomBar", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) enum ScaffoldLayoutContent {
    public static final enum ScaffoldLayoutContent BottomBar;
    public static final enum ScaffoldLayoutContent Fab;
    public static final enum ScaffoldLayoutContent MainContent;
    public static final enum ScaffoldLayoutContent Snackbar;
    public static final enum ScaffoldLayoutContent TopBar;

    private static final ScaffoldLayoutContent[] $values() {
        return new ScaffoldLayoutContent[]{ScaffoldLayoutContent.TopBar, ScaffoldLayoutContent.MainContent, ScaffoldLayoutContent.Snackbar, ScaffoldLayoutContent.Fab, ScaffoldLayoutContent.BottomBar};
    }

    static {
        ScaffoldLayoutContent.TopBar = new ScaffoldLayoutContent("TopBar", 0);
        ScaffoldLayoutContent.MainContent = new ScaffoldLayoutContent("MainContent", 1);
        ScaffoldLayoutContent.Snackbar = new ScaffoldLayoutContent("Snackbar", 2);
        ScaffoldLayoutContent.Fab = new ScaffoldLayoutContent("Fab", 3);
        ScaffoldLayoutContent.BottomBar = new ScaffoldLayoutContent("BottomBar", 4);
        ScaffoldLayoutContent[] v0 = ScaffoldLayoutContent.$values();
        ScaffoldLayoutContent.$VALUES = v0;
        ScaffoldLayoutContent.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ScaffoldLayoutContent(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return ScaffoldLayoutContent.$ENTRIES;
    }

    public static ScaffoldLayoutContent valueOf(String arg1) {
        return Enum.valueOf(ScaffoldLayoutContent.class, arg1);
    }

    public static ScaffoldLayoutContent[] values() {
        return ScaffoldLayoutContent.$VALUES.clone();
    }
}

