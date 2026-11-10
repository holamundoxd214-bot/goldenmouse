package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/ui/text/input/VisualTransformation;", "", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface VisualTransformation {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/text/input/VisualTransformation$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/input/VisualTransformation;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/input/VisualTransformation;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final VisualTransformation None;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.None = new VisualTransformation$Companion$$ExternalSyntheticLambda0();
        }

        private Companion() {
            super();
        }

        static final TransformedText None$lambda$0(AnnotatedString arg2) {
            return new TransformedText(arg2, OffsetMapping.Companion.getIdentity());
        }

        public final VisualTransformation getNone() {
            return Companion.None;
        }

        public static void getNone$annotations() {
        }
    }

    public static final Companion Companion;

    static {
        VisualTransformation.Companion = Companion.$$INSTANCE;
    }

    TransformedText filter(AnnotatedString arg1);
}

