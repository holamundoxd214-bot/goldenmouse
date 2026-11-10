package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2={"Landroidx/compose/ui/input/pointer/PointerIcon;", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PointerIcon {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/ui/input/pointer/PointerIcon$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getDefault", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "Crosshair", "getCrosshair", "Text", "getText", "Hand", "getHand", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final PointerIcon Crosshair;
        private static final PointerIcon Default;
        private static final PointerIcon Hand;
        private static final PointerIcon Text;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.Default = PointerIcon_androidKt.getPointerIconDefault();
            Companion.Crosshair = PointerIcon_androidKt.getPointerIconCrosshair();
            Companion.Text = PointerIcon_androidKt.getPointerIconText();
            Companion.Hand = PointerIcon_androidKt.getPointerIconHand();
        }

        private Companion() {
            super();
        }

        public final PointerIcon getCrosshair() {
            return Companion.Crosshair;
        }

        public final PointerIcon getDefault() {
            return Companion.Default;
        }

        public final PointerIcon getHand() {
            return Companion.Hand;
        }

        public final PointerIcon getText() {
            return Companion.Text;
        }
    }

    public static final Companion Companion;

    static {
        PointerIcon.Companion = Companion.$$INSTANCE;
    }
}

