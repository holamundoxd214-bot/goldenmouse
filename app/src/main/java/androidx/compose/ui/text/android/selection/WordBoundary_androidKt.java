package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000\u001A\u0014\u0010\u0004\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000¨\u0006\u0005"}, d2={"getWordStart", "", "Landroidx/compose/ui/text/android/selection/WordIterator;", "offset", "getWordEnd", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WordBoundary_androidKt {
    public static final int getWordEnd(WordIterator arg1, int arg2) {
        int v1 = arg1.isAfterPunctuation(arg1.nextBoundary(arg2)) ? arg1.getPunctuationEnd(arg2) : arg1.getNextWordEndOnTwoWordBoundary(arg2);
        if(v1 == -1) {
            return arg2;
        }

        return v1;
    }

    public static final int getWordStart(WordIterator arg1, int arg2) {
        int v1 = arg1.isOnPunctuation(arg1.prevBoundary(arg2)) ? arg1.getPunctuationBeginning(arg2) : arg1.getPrevWordBeginningOnTwoWordsBoundary(arg2);
        if(v1 == -1) {
            return arg2;
        }

        return v1;
    }
}

