package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00042\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "", "SingleLine", "MultiLine", "Companion", "Landroidx/compose/foundation/text/input/TextFieldLineLimits$MultiLine;", "Landroidx/compose/foundation/text/input/TextFieldLineLimits$SingleLine;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TextFieldLineLimits {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/input/TextFieldLineLimits$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "getDefault", "()Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final TextFieldLineLimits Default;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.Default = new MultiLine(0, 0, 3, null);
        }

        private Companion() {
            super();
        }

        public final TextFieldLineLimits getDefault() {
            return Companion.Default;
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001A\u00020\u000BH\u0016J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/text/input/TextFieldLineLimits$MultiLine;", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "minHeightInLines", "", "maxHeightInLines", "<init>", "(II)V", "getMinHeightInLines", "()I", "getMaxHeightInLines", "toString", "", "equals", "", "other", "", "hashCode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MultiLine implements TextFieldLineLimits {
        public static final int $stable;
        private final int maxHeightInLines;
        private final int minHeightInLines;

        static {
        }

        public MultiLine(int arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 2) != 0) {
                arg2 = 0x7FFFFFFF;
            }

            this(1, arg2);
        }

        public MultiLine() {
            this(0, 0, 3, null);
        }

        public MultiLine(int arg2, int arg3) {
            super();
            this.minHeightInLines = arg2;
            this.maxHeightInLines = arg3;
            int v1 = 0;
            if(1 <= arg2 && arg2 <= arg3) {
                v1 = 1;
            }

            if(v1 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Expected 1 ≤ minHeightInLines ≤ maxHeightInLines, were " + arg2 + ", " + arg3);
            }
        }

        public boolean equals(Object arg5) {
            if(this == (((MultiLine)arg5))) {
                return 1;
            }

            if(arg5 == null) {
                return 0;
            }

            if(this.getClass() != arg5.getClass()) {
                return 0;
            }

            if(this.minHeightInLines != ((MultiLine)arg5).minHeightInLines) {
                return 0;
            }

            if(this.maxHeightInLines != ((MultiLine)arg5).maxHeightInLines) {
                return 0;
            }

            return 1;
        }

        public final int getMaxHeightInLines() {
            return this.maxHeightInLines;
        }

        public final int getMinHeightInLines() {
            return this.minHeightInLines;
        }

        public int hashCode() {
            return this.minHeightInLines * 0x1F + this.maxHeightInLines;
        }

        public String toString() {
            return "MultiLine(minHeightInLines=" + this.minHeightInLines + ", maxHeightInLines=" + this.maxHeightInLines + ')';
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/text/input/TextFieldLineLimits$SingleLine;", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "<init>", "()V", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SingleLine implements TextFieldLineLimits {
        public static final int $stable;
        public static final SingleLine INSTANCE;

        static {
            SingleLine.INSTANCE = new SingleLine();
        }

        private SingleLine() {
            super();
        }

        public String toString() {
            return "TextFieldLineLimits.SingleLine";
        }
    }

    public static final Companion Companion;

    static {
        TextFieldLineLimits.Companion = Companion.$$INSTANCE;
    }
}

