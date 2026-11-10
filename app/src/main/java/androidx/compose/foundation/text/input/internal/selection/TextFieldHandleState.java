package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0001&B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0010J\t\u0010\u001A\u001A\u00020\u0007HÆ\u0003J\t\u0010\u001B\u001A\u00020\tHÆ\u0003J\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003JB\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001E\u0010\u001FJ\u0013\u0010 \u001A\u00020\u00032\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020#HÖ\u0001J\t\u0010$\u001A\u00020%HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u000E¨\u0006\'"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "", "visible", "", "position", "Landroidx/compose/ui/geometry/Offset;", "lineHeight", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "<init>", "(ZJFLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getVisible", "()Z", "getPosition-F1C5BW0", "()J", "J", "getLineHeight", "()F", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getHandlesCrossed", "component1", "component2", "component2-F1C5BW0", "component3", "component4", "component5", "copy", "copy-YqVAtuI", "(ZJFLandroidx/compose/ui/text/style/ResolvedTextDirection;Z)Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "equals", "other", "hashCode", "", "toString", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldHandleState {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState$Companion;", "", "<init>", "()V", "Hidden", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "getHidden", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final TextFieldHandleState getHidden() {
            return TextFieldHandleState.Hidden;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final TextFieldHandleState Hidden;
    private final ResolvedTextDirection direction;
    private final boolean handlesCrossed;
    private final float lineHeight;
    private final long position;
    private final boolean visible;

    static {
        TextFieldHandleState.Companion = new Companion(null);
        TextFieldHandleState.Hidden = new TextFieldHandleState(false, Offset.Companion.getUnspecified-F1C5BW0(), 0f, ResolvedTextDirection.Ltr, false, null);
    }

    public TextFieldHandleState(boolean arg1, long arg2, float arg4, ResolvedTextDirection arg5, boolean arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg4, arg5, arg6);
    }

    private TextFieldHandleState(boolean arg1, long arg2, float arg4, ResolvedTextDirection arg5, boolean arg6) {
        super();
        this.visible = arg1;
        this.position = arg2;
        this.lineHeight = arg4;
        this.direction = arg5;
        this.handlesCrossed = arg6;
    }

    public static final TextFieldHandleState access$getHidden$cp() {
        return TextFieldHandleState.Hidden;
    }

    public final boolean component1() {
        return this.visible;
    }

    public final long component2-F1C5BW0() {
        return this.position;
    }

    public final float component3() {
        return this.lineHeight;
    }

    public final ResolvedTextDirection component4() {
        return this.direction;
    }

    public final boolean component5() {
        return this.handlesCrossed;
    }

    public final TextFieldHandleState copy-YqVAtuI(boolean arg9, long arg10, float arg12, ResolvedTextDirection arg13, boolean arg14) {
        return new TextFieldHandleState(arg9, arg10, arg12, arg13, arg14, null);
    }

    public static TextFieldHandleState copy-YqVAtuI$default(TextFieldHandleState arg0, boolean arg1, long arg2, float arg4, ResolvedTextDirection arg5, boolean arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.visible;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.position;
        }

        if((arg7 & 4) != 0) {
            arg4 = arg0.lineHeight;
        }

        if((arg7 & 8) != 0) {
            arg5 = arg0.direction;
        }

        if((arg7 & 16) != 0) {
            arg6 = arg0.handlesCrossed;
        }

        return arg0.copy-YqVAtuI(arg1, arg2, arg4, arg5, arg6);
    }

    public boolean equals(Object arg8) {
        if(this == (((TextFieldHandleState)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof TextFieldHandleState)) {
            return 0;
        }

        if(this.visible != ((TextFieldHandleState)arg8).visible) {
            return 0;
        }

        if(!Offset.equals-impl0(this.position, ((TextFieldHandleState)arg8).position)) {
            return 0;
        }

        if(Float.compare(this.lineHeight, ((TextFieldHandleState)arg8).lineHeight) != 0) {
            return 0;
        }

        if(this.direction != ((TextFieldHandleState)arg8).direction) {
            return 0;
        }

        if(this.handlesCrossed != ((TextFieldHandleState)arg8).handlesCrossed) {
            return 0;
        }

        return 1;
    }

    public final ResolvedTextDirection getDirection() {
        return this.direction;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.visible) * 0x1F + Offset.hashCode-impl(this.position)) * 0x1F + Float.hashCode(this.lineHeight)) * 0x1F + this.direction.hashCode()) * 0x1F + Boolean.hashCode(this.handlesCrossed);
    }

    public String toString() {
        return "TextFieldHandleState(visible=" + this.visible + ", position=" + Offset.toString-impl(this.position) + ", lineHeight=" + this.lineHeight + ", direction=" + this.direction + ", handlesCrossed=" + this.handlesCrossed + ')';
    }
}

