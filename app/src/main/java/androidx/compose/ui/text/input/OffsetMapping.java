package androidx.compose.ui.text.input;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H&J\u0010\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/ui/text/input/OffsetMapping;", "", "originalToTransformed", "", "offset", "transformedToOriginal", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface OffsetMapping {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/input/OffsetMapping$Companion;", "", "<init>", "()V", "Identity", "Landroidx/compose/ui/text/input/OffsetMapping;", "getIdentity", "()Landroidx/compose/ui/text/input/OffsetMapping;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final OffsetMapping Identity;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.Identity = new OffsetMapping$Companion$Identity$1();
        }

        private Companion() {
            super();
        }

        public final OffsetMapping getIdentity() {
            return Companion.Identity;
        }
    }

    public static final Companion Companion;

    static {
        OffsetMapping.Companion = Companion.$$INSTANCE;
    }

    int originalToTransformed(int arg1);

    int transformedToOriginal(int arg1);
}

