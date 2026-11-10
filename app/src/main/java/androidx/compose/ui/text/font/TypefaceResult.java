package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0007\bR\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/text/font/TypefaceResult;", "Landroidx/compose/runtime/State;", "", "cacheable", "", "getCacheable", "()Z", "Immutable", "Async", "Landroidx/compose/ui/text/font/TypefaceResult$Async;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TypefaceResult extends State {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0012\u0010\u000E\u001A\u00020\u0003X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/font/TypefaceResult$Async;", "Landroidx/compose/ui/text/font/TypefaceResult;", "Landroidx/compose/runtime/State;", "", "current", "Landroidx/compose/ui/text/font/AsyncFontListLoader;", "<init>", "(Landroidx/compose/ui/text/font/AsyncFontListLoader;)V", "getCurrent$ui_text", "()Landroidx/compose/ui/text/font/AsyncFontListLoader;", "cacheable", "", "getCacheable", "()Z", "value", "getValue", "()Ljava/lang/Object;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Async implements State, TypefaceResult {
        public static final int $stable;
        private final AsyncFontListLoader current;

        static {
        }

        public Async(AsyncFontListLoader arg1) {
            super();
            this.current = arg1;
        }

        public boolean getCacheable() {
            return this.current.getCacheable$ui_text();
        }

        public final AsyncFontListLoader getCurrent$ui_text() {
            return this.current;
        }

        public Object getValue() {
            return this.current.getValue();
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "Landroidx/compose/ui/text/font/TypefaceResult;", "value", "", "cacheable", "", "<init>", "(Ljava/lang/Object;Z)V", "getValue", "()Ljava/lang/Object;", "getCacheable", "()Z", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Immutable implements TypefaceResult {
        public static final int $stable;
        private final boolean cacheable;
        private final Object value;

        static {
        }

        public Immutable(Object arg1, boolean arg2) {
            super();
            this.value = arg1;
            this.cacheable = arg2;
        }

        public Immutable(Object arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
            this(arg1, true);
        }

        public boolean getCacheable() {
            return this.cacheable;
        }

        public Object getValue() {
            return this.value;
        }
    }

    boolean getCacheable();
}

