package androidx.compose.foundation.text;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0015\u001A\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u000F\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/text/TextContextMenuItems;", "", "key", "", "stringId", "Landroidx/compose/foundation/text/ContextMenuStrings;", "drawableId", "Landroidx/compose/foundation/text/ContextMenuIcons;", "<init>", "(Ljava/lang/String;ILjava/lang/Object;II)V", "getKey", "()Ljava/lang/Object;", "getStringId-9Hzcbyc", "()I", "I", "getDrawableId-3I4p1mQ", "Cut", "Copy", "Paste", "SelectAll", "Autofill", "resolvedString", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public enum TextContextMenuItems {
    public static final enum TextContextMenuItems Autofill;
    public static final enum TextContextMenuItems Copy;
    public static final enum TextContextMenuItems Cut;
    public static final enum TextContextMenuItems Paste;
    public static final enum TextContextMenuItems SelectAll;
    private final int drawableId;
    private final Object key;
    private final int stringId;

    private static final TextContextMenuItems[] $values() {
        return new TextContextMenuItems[]{TextContextMenuItems.Cut, TextContextMenuItems.Copy, TextContextMenuItems.Paste, TextContextMenuItems.SelectAll, TextContextMenuItems.Autofill};
    }

    static {
        TextContextMenuItems.Cut = new TextContextMenuItems("Cut", 0, TextContextMenuKeys.INSTANCE.getCutKey(), ContextMenuStrings.Companion.getCut-9Hzcbyc(), ContextMenuIcons.Companion.getActionModeCutDrawable-3I4p1mQ());
        TextContextMenuItems.Copy = new TextContextMenuItems("Copy", 1, TextContextMenuKeys.INSTANCE.getCopyKey(), ContextMenuStrings.Companion.getCopy-9Hzcbyc(), ContextMenuIcons.Companion.getActionModeCopyDrawable-3I4p1mQ());
        TextContextMenuItems.Paste = new TextContextMenuItems("Paste", 2, TextContextMenuKeys.INSTANCE.getPasteKey(), ContextMenuStrings.Companion.getPaste-9Hzcbyc(), ContextMenuIcons.Companion.getActionModePasteDrawable-3I4p1mQ());
        TextContextMenuItems.SelectAll = new TextContextMenuItems("SelectAll", 3, TextContextMenuKeys.INSTANCE.getSelectAllKey(), ContextMenuStrings.Companion.getSelectAll-9Hzcbyc(), ContextMenuIcons.Companion.getActionModeSelectAllDrawable-3I4p1mQ());
        TextContextMenuItems.Autofill = new TextContextMenuItems("Autofill", 4, TextContextMenuKeys.INSTANCE.getAutofillKey(), ContextMenuStrings.Companion.getAutofill-9Hzcbyc(), ContextMenuIcons.Companion.getID_NULL-3I4p1mQ());
        TextContextMenuItems[] v0 = TextContextMenuItems.$values();
        TextContextMenuItems.$VALUES = v0;
        TextContextMenuItems.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TextContextMenuItems(String arg1, int arg2, Object arg3, int arg4, int arg5) {
        super(arg1, arg2);
        this.key = arg3;
        this.stringId = arg4;
        this.drawableId = arg5;
    }

    public final int getDrawableId-3I4p1mQ() {
        return this.drawableId;
    }

    public static EnumEntries getEntries() {
        return TextContextMenuItems.$ENTRIES;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getStringId-9Hzcbyc() {
        return this.stringId;
    }

    public final String resolvedString(Composer arg4, int arg5) {
        int v1 = 479426150;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(resolvedString)178@7376L19:CommonContextMenuArea.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.text.TextContextMenuItems.resolvedString (CommonContextMenuArea.kt:178)");
        }

        String v3 = ContextMenuStrings_androidKt.getString-tk4Tqcs(this.stringId, arg4, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public static TextContextMenuItems valueOf(String arg1) {
        return Enum.valueOf(TextContextMenuItems.class, arg1);
    }

    public static TextContextMenuItems[] values() {
        return TextContextMenuItems.$VALUES.clone();
    }
}

