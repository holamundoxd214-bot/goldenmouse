package androidx.compose.ui.text;

import java.text.BreakIterator;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000\u001A\u0014\u0010\u0004\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000¨\u0006\u0005"}, d2={"findPrecedingBreak", "", "", "index", "findFollowingBreak", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class JvmCharHelpers_androidKt {
    public static final int findFollowingBreak(String arg1, int arg2) {
        BreakIterator v0 = BreakIterator.getCharacterInstance();
        v0.setText(arg1);
        return v0.following(arg2);
    }

    public static final int findPrecedingBreak(String arg1, int arg2) {
        BreakIterator v0 = BreakIterator.getCharacterInstance();
        v0.setText(arg1);
        return v0.preceding(arg2);
    }
}

