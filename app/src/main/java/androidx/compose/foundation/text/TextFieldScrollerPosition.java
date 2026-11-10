package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\r\b\u0001\u0018\u0000 :2\u00020\u0001:\u0001:B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ&\u0010-\u001A\u00020.2\u0006\u0010&\u001A\u00020\u00032\u0006\u0010/\u001A\u00020\u001E2\u0006\u00100\u001A\u00020\u00152\u0006\u00101\u001A\u00020\u0015J%\u00102\u001A\u00020.2\u0006\u00103\u001A\u00020\u00052\u0006\u00104\u001A\u00020\u00052\u0006\u00100\u001A\u00020\u0015H\u0000¢\u0006\u0002\b5J\u0015\u00106\u001A\u00020\u00152\u0006\u00107\u001A\u00020 ¢\u0006\u0004\b8\u00109R+\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER+\u0010\u0011\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00058F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001A\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000ER+\u0010\u0016\u001A\u00020\u00152\u0006\u0010\t\u001A\u00020\u00158F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u001F\u001A\u00020 X\u0086\u000E¢\u0006\u0010\n\u0002\u0010%\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010&\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u00038F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b+\u0010,\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*¨\u0006;"}, d2={"Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "", "initialOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "initial", "", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;F)V", "()V", "<set-?>", "offset", "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "maximum", "getMaximum", "setMaximum", "maximum$delegate", "", "viewportSize", "getViewportSize", "()I", "setViewportSize", "(I)V", "viewportSize$delegate", "Landroidx/compose/runtime/MutableIntState;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "getPreviousSelection-d9O1mEE", "()J", "setPreviousSelection-5zc-tL8", "(J)V", "J", "orientation", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "orientation$delegate", "Landroidx/compose/runtime/MutableState;", "update", "", "cursorRect", "containerSize", "textFieldSize", "coerceOffset", "cursorStart", "cursorEnd", "coerceOffset$foundation", "getOffsetToFollow", "selection", "getOffsetToFollow-5zc-tL8", "(J)I", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldScrollerPosition {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/text/TextFieldScrollerPosition$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return TextFieldScrollerPosition.Saver;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private final MutableFloatState maximum$delegate;
    private final MutableFloatState offset$delegate;
    private final MutableState orientation$delegate;
    private Rect previousCursorRect;
    private long previousSelection;
    private final MutableIntState viewportSize$delegate;

    static {
        TextFieldScrollerPosition.Companion = new Companion(null);
        TextFieldScrollerPosition.Saver = ListSaverKt.listSaver(new TextFieldScrollerPosition$$ExternalSyntheticLambda0(), new TextFieldScrollerPosition$$ExternalSyntheticLambda1());
    }

    public TextFieldScrollerPosition(Orientation arg1, float arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, 0f);
    }

    public TextFieldScrollerPosition() {
        this(Orientation.Vertical, 0f, 2, null);
    }

    public TextFieldScrollerPosition(Orientation arg3, float arg4) {
        super();
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg4);
        this.maximum$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.viewportSize$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.previousCursorRect = Rect.Companion.getZero();
        this.previousSelection = TextRange.Companion.getZero-d9O1mEE();
        this.orientation$delegate = SnapshotStateKt.mutableStateOf(arg3, SnapshotStateKt.structuralEqualityPolicy());
    }

    static final List Saver$lambda$0(SaverScope arg1, TextFieldScrollerPosition arg2) {
        Float v1 = Float.valueOf(arg2.getOffset());
        boolean v2 = arg2.getOrientation() == Orientation.Vertical ? true : false;
        return CollectionsKt.listOf(new Object[]{v1, Boolean.valueOf(v2)});
    }

    static final TextFieldScrollerPosition Saver$lambda$1(List arg3) {
        Object v1 = arg3.get(1);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Boolean");
        Orientation v1_1 = ((Boolean)v1).booleanValue() ? Orientation.Vertical : Orientation.Horizontal;
        Object v3 = arg3.get(0);
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Float");
        return new TextFieldScrollerPosition(v1_1, ((Float)v3).floatValue());
    }

    public static final Saver access$getSaver$cp() {
        return TextFieldScrollerPosition.Saver;
    }

    public final void coerceOffset$foundation(float arg5, float arg6, int arg7) {
        float v0 = this.getOffset();
        float v7 = ((float)arg7);
        float v1 = v0 + v7;
        if(arg6 <= v1) {
            int v2 = Float.compare(arg5, v0);
            if(v2 < 0 && arg6 - arg5 > v7) {
                goto label_4;
            }

            goto label_11;
        }
        else {
        label_4:
            arg6 -= v1;
            goto label_17;
        label_11:
            if(v2 < 0 && arg6 - arg5 <= v7) {
                arg6 = arg5 - v0;
                goto label_17;
            }

            arg6 = 0f;
        }

    label_17:
        this.setOffset(this.getOffset() + arg6);
    }

    public final float getMaximum() {
        return this.maximum$delegate.getFloatValue();
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    public final int getOffsetToFollow-5zc-tL8(long arg4) {
        if(TextRange.getStart-impl(arg4) != TextRange.getStart-impl(this.previousSelection)) {
            return TextRange.getStart-impl(arg4);
        }

        if(TextRange.getEnd-impl(arg4) != TextRange.getEnd-impl(this.previousSelection)) {
            return TextRange.getEnd-impl(arg4);
        }

        return TextRange.getMin-impl(arg4);
    }

    public final Orientation getOrientation() {
        return this.orientation$delegate.getValue();
    }

    public final long getPreviousSelection-d9O1mEE() {
        return this.previousSelection;
    }

    public final int getViewportSize() {
        return this.viewportSize$delegate.getIntValue();
    }

    private final void setMaximum(float arg1) {
        this.maximum$delegate.setFloatValue(arg1);
    }

    public final void setOffset(float arg1) {
        this.offset$delegate.setFloatValue(arg1);
    }

    public final void setOrientation(Orientation arg1) {
        this.orientation$delegate.setValue(arg1);
    }

    public final void setPreviousSelection-5zc-tL8(long arg1) {
        this.previousSelection = arg1;
    }

    private final void setViewportSize(int arg1) {
        this.viewportSize$delegate.setIntValue(arg1);
    }

    public final void update(Orientation arg3, Rect arg4, int arg5, int arg6) {
        float v6 = ((float)(arg6 - arg5));
        this.setMaximum(v6);
        if(arg4.getLeft() != this.previousCursorRect.getLeft() || arg4.getTop() != this.previousCursorRect.getTop()) {
            int v3 = arg3 == Orientation.Vertical ? 1 : 0;
            float v0 = v3 != 0 ? arg4.getTop() : arg4.getLeft();
            float v3_1 = v3 != 0 ? arg4.getBottom() : arg4.getRight();
            this.coerceOffset$foundation(v0, v3_1, arg5);
            this.previousCursorRect = arg4;
        }
        else {
        }

        this.setOffset(RangesKt.coerceIn(this.getOffset(), 0f, v6));
        this.setViewportSize(arg5);
    }
}

