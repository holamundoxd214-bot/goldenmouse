package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.emoji2.text.EmojiCompat;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000E\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005J\u000E\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005J\u000E\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005J\u000E\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005J\u000E\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005J\u000E\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005J\u000E\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u0005J\u000E\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u0005J\u0018\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0017H\u0002J\u0018\u0010\u001A\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u0017H\u0002J\u0010\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u0005H\u0002J\u0010\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u0005H\u0002J\u0010\u0010\u001D\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u0005H\u0002J\u0010\u0010\u001E\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u0005H\u0002J\u0010\u0010\u001F\u001A\u00020 2\u0006\u0010\u0010\u001A\u00020\u0005H\u0002J\u0010\u0010!\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u0005H\u0002J\u0010\u0010\"\u001A\u00020\u00172\u0006\u0010\u0010\u001A\u00020\u0005H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Landroidx/compose/ui/text/android/selection/WordIterator;", "", "charSequence", "", "start", "", "end", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/lang/CharSequence;IILjava/util/Locale;)V", "getCharSequence", "()Ljava/lang/CharSequence;", "iterator", "Ljava/text/BreakIterator;", "nextBoundary", "offset", "prevBoundary", "getPrevWordBeginningOnTwoWordsBoundary", "getNextWordEndOnTwoWordBoundary", "getPunctuationBeginning", "getPunctuationEnd", "isAfterPunctuation", "", "isOnPunctuation", "getBeginning", "getEnd", "isPunctuationStartBoundary", "isPunctuationEndBoundary", "isAfterLetterOrDigitOrEmoji", "isOnLetterOrDigitOrEmoji", "checkOffsetIsValid", "", "isBoundary", "isHiraganaKatakanaBoundary", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WordIterator {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/ui/text/android/selection/WordIterator$Companion;", "", "<init>", "()V", "WINDOW_WIDTH", "", "isPunctuation", "", "cp", "isPunctuation$ui_text", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final boolean isPunctuation$ui_text(int arg1) {
            int v0 = Character.getType(arg1);
            if(v0 != 23 && v0 != 20 && v0 != 22 && v0 != 30 && v0 != 29 && v0 != 24) {
                if(v0 == 21) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int WINDOW_WIDTH = 50;
    private final CharSequence charSequence;
    private final int end;
    private final BreakIterator iterator;
    private final int start;

    static {
        WordIterator.Companion = new Companion(null);
        WordIterator.$stable = 8;
    }

    public WordIterator(CharSequence arg4, int arg5, int arg6, Locale arg7) {
        super();
        this.charSequence = arg4;
        int v0 = 1;
        int v2 = arg5 < 0 || arg5 > arg4.length() ? 0 : 1;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("input start index is outside the CharSequence");
        }

        if(arg6 < 0 || arg6 > arg4.length()) {
            v0 = 0;
        }
        else {
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("input end index is outside the CharSequence");
        }

        BreakIterator v7 = BreakIterator.getWordInstance(arg7);
        this.iterator = v7;
        this.start = Math.max(0, arg5 - 50);
        this.end = Math.min(arg4.length(), arg6 + 50);
        v7.setText(new CharSequenceCharacterIterator(arg4, arg5, arg6));
    }

    private final void checkOffsetIsValid(int arg4) {
        int v0 = this.start;
        int v2 = 0;
        if(arg4 <= this.end && v0 <= arg4) {
            v2 = 1;
        }

        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Invalid offset: " + arg4 + ". Valid range is [" + this.start + " , " + this.end + ']');
        }
    }

    private final int getBeginning(int arg2, boolean arg3) {
        this.checkOffsetIsValid(arg2);
        if(this.isOnLetterOrDigitOrEmoji(arg2)) {
            if((this.isBoundary(arg2)) && (!this.isAfterLetterOrDigitOrEmoji(arg2) || !arg3)) {
                return arg2;
            }

            return this.prevBoundary(arg2);
        }

        if(this.isAfterLetterOrDigitOrEmoji(arg2)) {
            return this.prevBoundary(arg2);
        }

        return -1;
    }

    public final CharSequence getCharSequence() {
        return this.charSequence;
    }

    private final int getEnd(int arg2, boolean arg3) {
        this.checkOffsetIsValid(arg2);
        if(this.isAfterLetterOrDigitOrEmoji(arg2)) {
            if((this.isBoundary(arg2)) && (!this.isOnLetterOrDigitOrEmoji(arg2) || !arg3)) {
                return arg2;
            }

            return this.nextBoundary(arg2);
        }

        if(this.isOnLetterOrDigitOrEmoji(arg2)) {
            return this.nextBoundary(arg2);
        }

        return -1;
    }

    public final int getNextWordEndOnTwoWordBoundary(int arg2) {
        return this.getEnd(arg2, true);
    }

    public final int getPrevWordBeginningOnTwoWordsBoundary(int arg2) {
        return this.getBeginning(arg2, true);
    }

    public final int getPunctuationBeginning(int arg2) {
        this.checkOffsetIsValid(arg2);
        while(arg2 != -1) {
            if(this.isPunctuationStartBoundary(arg2)) {
                return arg2;
            }

            arg2 = this.prevBoundary(arg2);
        }

        return arg2;
    }

    public final int getPunctuationEnd(int arg2) {
        this.checkOffsetIsValid(arg2);
        while(arg2 != -1) {
            if(this.isPunctuationEndBoundary(arg2)) {
                return arg2;
            }

            arg2 = this.nextBoundary(arg2);
        }

        return arg2;
    }

    private final boolean isAfterLetterOrDigitOrEmoji(int arg4) {
        int v0 = this.start + 1;
        if(arg4 <= this.end && v0 <= arg4) {
            if(Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, arg4))) {
                return 1;
            }
            else {
                --arg4;
                if(Character.isSurrogate(this.charSequence.charAt(arg4))) {
                    return 1;
                }
                else if(EmojiCompat.isConfigured()) {
                    EmojiCompat v0_1 = EmojiCompat.get();
                    if(v0_1.getLoadState() == 1 && v0_1.getEmojiStart(this.charSequence, arg4) != -1) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    public final boolean isAfterPunctuation(int arg3) {
        int v0 = this.start + 1;
        if(arg3 <= this.end && v0 <= arg3) {
            return WordIterator.Companion.isPunctuation$ui_text(Character.codePointBefore(this.charSequence, arg3));
        }

        return 0;
    }

    private final boolean isBoundary(int arg3) {
        this.checkOffsetIsValid(arg3);
        if((this.iterator.isBoundary(arg3)) && (!this.isOnLetterOrDigitOrEmoji(arg3) || !this.isOnLetterOrDigitOrEmoji(arg3 - 1) || !this.isOnLetterOrDigitOrEmoji(arg3 + 1))) {
            if(arg3 > 0 && arg3 < this.charSequence.length() - 1) {
                if(this.isHiraganaKatakanaBoundary(arg3)) {
                }
                else if(!this.isHiraganaKatakanaBoundary(arg3 + 1)) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final boolean isHiraganaKatakanaBoundary(int arg4) {
        int v1 = arg4 - 1;
        if((Intrinsics.areEqual(Character$UnicodeBlock.of(this.charSequence.charAt(v1)), Character$UnicodeBlock.HIRAGANA)) && (Intrinsics.areEqual(Character$UnicodeBlock.of(this.charSequence.charAt(arg4)), Character$UnicodeBlock.KATAKANA)) || (Intrinsics.areEqual(Character$UnicodeBlock.of(this.charSequence.charAt(arg4)), Character$UnicodeBlock.HIRAGANA)) && (Intrinsics.areEqual(Character$UnicodeBlock.of(this.charSequence.charAt(v1)), Character$UnicodeBlock.KATAKANA))) {
            return 1;
        }

        return 0;
    }

    private final boolean isOnLetterOrDigitOrEmoji(int arg4) {
        int v0 = this.start;
        if(arg4 < this.end && v0 <= arg4) {
            if(Character.isLetterOrDigit(Character.codePointAt(this.charSequence, arg4))) {
                return 1;
            }
            else if(Character.isSurrogate(this.charSequence.charAt(arg4))) {
                return 1;
            }
            else if(EmojiCompat.isConfigured()) {
                EmojiCompat v0_1 = EmojiCompat.get();
                if(v0_1.getLoadState() == 1 && v0_1.getEmojiStart(this.charSequence, arg4) != -1) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public final boolean isOnPunctuation(int arg3) {
        int v0 = this.start;
        if(arg3 < this.end && v0 <= arg3) {
            return WordIterator.Companion.isPunctuation$ui_text(Character.codePointAt(this.charSequence, arg3));
        }

        return 0;
    }

    private final boolean isPunctuationEndBoundary(int arg2) {
        if(!this.isOnPunctuation(arg2) && (this.isAfterPunctuation(arg2))) {
            return 1;
        }

        return 0;
    }

    private final boolean isPunctuationStartBoundary(int arg2) {
        if((this.isOnPunctuation(arg2)) && !this.isAfterPunctuation(arg2)) {
            return 1;
        }

        return 0;
    }

    public final int nextBoundary(int arg2) {
        this.checkOffsetIsValid(arg2);
        arg2 = this.iterator.following(arg2);
        if((this.isOnLetterOrDigitOrEmoji(arg2 - 1)) && (this.isOnLetterOrDigitOrEmoji(arg2)) && !this.isHiraganaKatakanaBoundary(arg2)) {
            return this.nextBoundary(arg2);
        }

        return arg2;
    }

    public final int prevBoundary(int arg2) {
        this.checkOffsetIsValid(arg2);
        arg2 = this.iterator.preceding(arg2);
        if((this.isOnLetterOrDigitOrEmoji(arg2)) && (this.isAfterLetterOrDigitOrEmoji(arg2)) && !this.isHiraganaKatakanaBoundary(arg2)) {
            return this.prevBoundary(arg2);
        }

        return arg2;
    }
}

