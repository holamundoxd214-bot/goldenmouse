package androidx.compose.foundation.text;

import androidx.emoji2.text.EmojiCompat;
import java.text.BreakIterator;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000\u001A\u0014\u0010\u0004\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000\u001A\u001C\u0010\u0005\u001A\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0001H\u0002\u001A\u001C\u0010\b\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0001H\u0000\u001A\n\u0010\t\u001A\u0004\u0018\u00010\nH\u0002¨\u0006\u000B"}, d2={"findPrecedingBreak", "", "", "index", "findFollowingBreak", "findCodePointBefore", "", "ifNotFound", "findCodePointOrEmojiStartBefore", "getEmojiCompatIfLoaded", "Landroidx/emoji2/text/EmojiCompat;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class StringHelpers_androidKt {
    private static final int findCodePointBefore(CharSequence arg0, int arg1, int arg2) {
        if(arg1 <= 0) {
            return arg2;
        }

        return Character.offsetByCodePoints(arg0, arg1, -1);
    }

    public static final int findCodePointOrEmojiStartBefore(String arg2, int arg3, int arg4) {
        if(arg3 <= 0) {
            return arg4;
        }

        EmojiCompat v0 = StringHelpers_androidKt.getEmojiCompatIfLoaded();
        if(v0 == null) {
            return StringHelpers_androidKt.findCodePointBefore(((CharSequence)arg2), arg3, arg4);
        }

        int v0_1 = v0.getEmojiStart(((CharSequence)arg2), arg3 - 1);
        if(v0_1 < 0) {
            return StringHelpers_androidKt.findCodePointBefore(((CharSequence)arg2), arg3, arg4);
        }

        return v0_1;
    }

    public static final int findFollowingBreak(String arg4, int arg5) {
        EmojiCompat v0 = StringHelpers_androidKt.getEmojiCompatIfLoaded();
        Integer v1 = null;
        if(v0 != null) {
            Integer v0_1 = Integer.valueOf(v0.getEmojiEnd(arg4, arg5));
            if(v0_1.intValue() == -1) {
            }
            else {
                v1 = v0_1;
            }
        }

        if(v1 != null) {
            return v1.intValue();
        }

        BreakIterator v0_2 = BreakIterator.getCharacterInstance();
        v0_2.setText(arg4);
        return v0_2.following(arg5);
    }

    public static final int findPrecedingBreak(String arg5, int arg6) {
        EmojiCompat v0 = StringHelpers_androidKt.getEmojiCompatIfLoaded();
        Integer v1 = null;
        if(v0 != null) {
            Integer v0_1 = Integer.valueOf(v0.getEmojiStart(arg5, Math.max(0, arg6 - 1)));
            if(v0_1.intValue() == -1) {
            }
            else {
                v1 = v0_1;
            }
        }

        if(v1 != null) {
            return v1.intValue();
        }

        BreakIterator v0_2 = BreakIterator.getCharacterInstance();
        v0_2.setText(arg5);
        return v0_2.preceding(arg6);
    }

    private static final EmojiCompat getEmojiCompatIfLoaded() {
        EmojiCompat v1 = null;
        if(EmojiCompat.isConfigured()) {
            EmojiCompat v0 = EmojiCompat.get();
            if(v0.getLoadState() == 1) {
                return v0;
            }
        }

        return v1;
    }
}

