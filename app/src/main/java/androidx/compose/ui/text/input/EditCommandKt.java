package androidx.compose.ui.text.input;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0002¨\u0006\u0005"}, d2={"isSurrogatePair", "", "high", "", "low", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class EditCommandKt {
    public static final boolean access$isSurrogatePair(char arg0, char arg1) {
        return EditCommandKt.isSurrogatePair(arg0, arg1);
    }

    private static final boolean isSurrogatePair(char arg0, char arg1) {
        if((Character.isHighSurrogate(arg0)) && (Character.isLowSurrogate(arg1))) {
            return 1;
        }

        return 0;
    }
}

