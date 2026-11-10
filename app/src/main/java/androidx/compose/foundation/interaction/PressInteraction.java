package androidx.compose.foundation.interaction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2={"Landroidx/compose/foundation/interaction/PressInteraction;", "Landroidx/compose/foundation/interaction/Interaction;", "Press", "Release", "Cancel", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PressInteraction extends Interaction {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/interaction/PressInteraction$Cancel;", "Landroidx/compose/foundation/interaction/PressInteraction;", "press", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "<init>", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getPress", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Cancel implements PressInteraction {
        public static final int $stable;
        private final Press press;

        static {
        }

        public Cancel(Press arg1) {
            super();
            this.press = arg1;
        }

        public final Press getPress() {
            return this.press;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/foundation/interaction/PressInteraction;", "pressPosition", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPressPosition-F1C5BW0", "()J", "J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Press implements PressInteraction {
        public static final int $stable;
        private final long pressPosition;

        static {
        }

        public Press(long arg1, DefaultConstructorMarker arg3) {
            this(arg1);
        }

        private Press(long arg1) {
            super();
            this.pressPosition = arg1;
        }

        public final long getPressPosition-F1C5BW0() {
            return this.pressPosition;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/interaction/PressInteraction$Release;", "Landroidx/compose/foundation/interaction/PressInteraction;", "press", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "<init>", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getPress", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Release implements PressInteraction {
        public static final int $stable;
        private final Press press;

        static {
        }

        public Release(Press arg1) {
            super();
            this.press = arg1;
        }

        public final Press getPress() {
            return this.press;
        }
    }

}

