package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016J\u0010\u0010\u000B\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016J\u0010\u0010\r\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/ui/text/android/selection/WordSegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "text", "", "wordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "<init>", "(Ljava/lang/CharSequence;Landroidx/compose/ui/text/android/selection/WordIterator;)V", "previousStartBoundary", "", "offset", "previousEndBoundary", "nextStartBoundary", "nextEndBoundary", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WordSegmentFinder implements SegmentFinder {
    public static final int $stable = 8;
    private final CharSequence text;
    private final WordIterator wordIterator;

    static {
    }

    public WordSegmentFinder(CharSequence arg1, WordIterator arg2) {
        super();
        this.text = arg1;
        this.wordIterator = arg2;
    }

    public int nextEndBoundary(int arg3) {
        do {
            arg3 = this.wordIterator.nextBoundary(arg3);
            int v0 = -1;
            if(arg3 == v0) {
                return v0;
            }
        }
        while(Character.isWhitespace(this.text.charAt(arg3 - 1)));

        return arg3;
    }

    public int nextStartBoundary(int arg3) {
        do {
            arg3 = this.wordIterator.nextBoundary(arg3);
            int v0 = -1;
            if(arg3 != v0) {
                if(arg3 == this.text.length()) {
                }
                else {
                    if(Character.isWhitespace(this.text.charAt(arg3))) {
                        continue;
                    }

                    return arg3;
                }
            }

            return v0;
        }
        while(true);

        return arg3;
    }

    public int previousEndBoundary(int arg3) {
        do {
            arg3 = this.wordIterator.prevBoundary(arg3);
            int v0 = -1;
            if(arg3 != v0 && arg3 != 0) {
                if(Character.isWhitespace(this.text.charAt(arg3 - 1))) {
                    continue;
                }

                return arg3;
            }

            return v0;
        }
        while(true);

        return arg3;
    }

    public int previousStartBoundary(int arg2) {
        do {
            arg2 = this.wordIterator.prevBoundary(arg2);
            int v0 = -1;
            if(arg2 == v0) {
                return v0;
            }
        }
        while(Character.isWhitespace(this.text.charAt(arg2)));

        return arg2;
    }
}

