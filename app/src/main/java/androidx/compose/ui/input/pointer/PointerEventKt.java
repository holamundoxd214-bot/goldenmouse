package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0004\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0005\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0006\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0007\u001A\u00020\u0001*\u00020\u0002\u001A\u000F\u0010\b\u001A\u00020\t*\u00020\u0002¢\u0006\u0002\u0010\n\u001A\u000F\u0010\u000B\u001A\u00020\t*\u00020\u0002¢\u0006\u0002\u0010\n\u001A\u001B\u0010\f\u001A\u00020\t*\u00020\u00022\b\b\u0002\u0010\r\u001A\u00020\u0001H\u0002¢\u0006\u0002\u0010\u000E\u001A\f\u0010\u000F\u001A\u00020\u0001*\u00020\u0002H\u0007\u001A\f\u0010\u0010\u001A\u00020\u0001*\u00020\u0002H\u0007\u001A\f\u0010\u0011\u001A\u00020\u0012*\u00020\u0002H\u0007\u001A\f\u0010\u0013\u001A\u00020\u0012*\u00020\u0002H\u0007\u001A\f\u0010\u0014\u001A\u00020\u0012*\u00020\u0002H\u0007\u001A\u001B\u0010\u0015\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001A!\u0010\u0015\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u001A\u001A\u00020\u001B¢\u0006\u0004\b\u001C\u0010\u001D\u001A\r\u0010\u001E\u001A\u00020\u001F*\u00020\u0001H\u0082\b¨\u0006 "}, d2={"changedToDown", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "changedToDownIgnoreConsumed", "changedToUp", "changedToUpIgnoreConsumed", "positionChanged", "positionChangedIgnoreConsumed", "positionChange", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)J", "positionChangeIgnoreConsumed", "positionChangeInternal", "ignoreConsumed", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Z)J", "positionChangeConsumed", "anyChangeConsumed", "consumeDownChange", "", "consumePositionChange", "consumeAllChanges", "isOutOfBounds", "size", "Landroidx/compose/ui/unit/IntSize;", "isOutOfBounds-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)Z", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "isOutOfBounds-jwHxaWs", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJ)Z", "toInt", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PointerEventKt {
    @Deprecated(message="Partial consumption has been deprecated. Use isConsumed instead", replaceWith="<_subannotation>") public static final boolean anyChangeConsumed(PointerInputChange arg0) {
        return arg0.isConsumed();
    }

    public static final boolean changedToDown(PointerInputChange arg1) {
        if(!arg1.isConsumed() && !arg1.getPreviousPressed() && (arg1.getPressed())) {
            return 1;
        }

        return 0;
    }

    public static final boolean changedToDownIgnoreConsumed(PointerInputChange arg1) {
        if(!arg1.getPreviousPressed() && (arg1.getPressed())) {
            return 1;
        }

        return 0;
    }

    public static final boolean changedToUp(PointerInputChange arg1) {
        if(!arg1.isConsumed() && (arg1.getPreviousPressed()) && !arg1.getPressed()) {
            return 1;
        }

        return 0;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange arg1) {
        if((arg1.getPreviousPressed()) && !arg1.getPressed()) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="Use consume() instead", replaceWith="<_subannotation>") public static final void consumeAllChanges(PointerInputChange arg0) {
        arg0.consume();
    }

    @Deprecated(message="Partial consumption has been deprecated. Use consume() instead.", replaceWith="<_subannotation>") public static final void consumeDownChange(PointerInputChange arg2) {
        if(arg2.getPressed() != arg2.getPreviousPressed()) {
            arg2.consume();
        }
    }

    @Deprecated(message="Partial consumption has been deprecated. Use consume() instead.", replaceWith="<_subannotation>") public static final void consumePositionChange(PointerInputChange arg4) {
        if(!Offset.equals-impl0(PointerEventKt.positionChange(arg4), Offset.Companion.getZero-F1C5BW0())) {
            arg4.consume();
        }
    }

    @Deprecated(message="Use isOutOfBounds() that supports minimum touch target", replaceWith="<_subannotation>") public static final boolean isOutOfBounds-O0kMr_c(PointerInputChange arg7, long arg8) {
        long v0 = arg7.getPosition-F1C5BW0();
        float v2 = Float.intBitsToFloat(((int)(v0 >> 0x20)));
        float v0_1 = Float.intBitsToFloat(((int)(v0 & 0xFFFFFFFFL)));
        int v7 = ((int)(arg8 >> 0x20));
        int v8 = ((int)(arg8 & 0xFFFFFFFFL));
        int v3 = 1;
        int v1 = Float.compare(v2, 0f) < 0 ? 1 : 0;
        v7 = v2 > (((float)v7)) ? 1 : 0;
        v7 |= v1;
        int v9 = v0_1 < 0f ? 1 : 0;
        v7 |= v9;
        if(v0_1 > (((float)v8))) {
        }
        else {
            v3 = 0;
        }

        return v7 | v3;
    }

    public static final boolean isOutOfBounds-jwHxaWs(PointerInputChange arg8, long arg9, long arg11) {
        boolean v0 = PointerType.equals-impl0(arg8.getType-T8wyACA(), PointerType.Companion.getTouch-T8wyACA());
        long v1 = arg8.getPosition-F1C5BW0();
        float v3 = Float.intBitsToFloat(((int)(v1 >> 0x20)));
        float v1_1 = Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)));
        float v0_1 = ((float)(((int)v0)));
        float v2 = Float.intBitsToFloat(((int)(arg11 >> 0x20))) * v0_1;
        float v8 = (((float)(((int)(arg9 >> 0x20))))) + v2;
        float v11 = Float.intBitsToFloat(((int)(arg11 & 0xFFFFFFFFL))) * v0_1;
        float v9 = (((float)(((int)(arg9 & 0xFFFFFFFFL))))) + v11;
        int v12 = 1;
        int v10 = Float.compare(v3, -v2) < 0 ? 1 : 0;
        int v8_1 = v3 > v8 ? 1 : 0;
        v8_1 |= v10;
        v10 = v1_1 < -v11 ? 1 : 0;
        v8_1 |= v10;
        if(v1_1 > v9) {
        }
        else {
            v12 = 0;
        }

        return v8_1 | v12;
    }

    public static final long positionChange(PointerInputChange arg2) {
        return PointerEventKt.positionChangeInternal(arg2, false);
    }

    @Deprecated(message="Partial consumption has been deprecated. Use isConsumed instead", replaceWith="<_subannotation>") public static final boolean positionChangeConsumed(PointerInputChange arg0) {
        return arg0.isConsumed();
    }

    public static final long positionChangeIgnoreConsumed(PointerInputChange arg2) {
        return PointerEventKt.positionChangeInternal(arg2, true);
    }

    private static final long positionChangeInternal(PointerInputChange arg4, boolean arg5) {
        long v0 = Offset.minus-MK-Hz9U(arg4.getPosition-F1C5BW0(), arg4.getPreviousPosition-F1C5BW0());
        if(!arg5 && (arg4.isConsumed())) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        return v0;
    }

    static long positionChangeInternal$default(PointerInputChange arg0, boolean arg1, int arg2, Object arg3) {
        return PointerEventKt.positionChangeInternal(arg0, false);
    }

    public static final boolean positionChanged(PointerInputChange arg4) {
        return Offset.equals-impl0(PointerEventKt.positionChangeInternal(arg4, false), Offset.Companion.getZero-F1C5BW0()) ^ 1;
    }

    public static final boolean positionChangedIgnoreConsumed(PointerInputChange arg5) {
        return Offset.equals-impl0(PointerEventKt.positionChangeInternal(arg5, true), Offset.Companion.getZero-F1C5BW0()) ^ 1;
    }

    private static final int toInt(boolean arg0) {
        return arg0;
    }
}

