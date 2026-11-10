package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005H\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/text/input/internal/SingleLineCodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "<init>", "()V", "LINE_FEED", "", "CARRIAGE_RETURN", "WHITESPACE", "ZERO_WIDTH_SPACE", "transform", "codepointIndex", "codepoint", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SingleLineCodepointTransformation implements CodepointTransformation {
    public static final int $stable = 0;
    private static final int CARRIAGE_RETURN = 13;
    public static final SingleLineCodepointTransformation INSTANCE = null;
    private static final int LINE_FEED = 10;
    private static final int WHITESPACE = 0x20;
    private static final int ZERO_WIDTH_SPACE = 0xFEFF;

    static {
        SingleLineCodepointTransformation.INSTANCE = new SingleLineCodepointTransformation();
    }

    private SingleLineCodepointTransformation() {
        super();
    }

    public String toString() {
        return "SingleLineCodepointTransformation";
    }

    public int transform(int arg1, int arg2) {
        if(arg2 == 10) {
            return 0x20;
        }

        if(arg2 == 13) {
            return 0xFEFF;
        }

        return arg2;
    }
}

