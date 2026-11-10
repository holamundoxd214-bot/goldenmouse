package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u001B\u0010\u0006\u001A\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001A\u001B\u0010\u000B\u001A\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\n\u001A\u001B\u0010\r\u001A\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u000E\u0010\n\u001A\u0014\u0010\u000F\u001A\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¨\u0006\u0010"}, d2={"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "fromTextLayoutToCore", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "offset", "fromTextLayoutToCore-Uv8p0NA", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "fromDecorationToTextLayout", "fromDecorationToTextLayout-Uv8p0NA", "fromWindowToDecoration", "fromWindowToDecoration-Uv8p0NA", "fromTextLayoutToDecoration", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextLayoutStateKt {
    public static final long coerceIn-3MmeM6k(long arg6, Rect arg8) {
        float v6_1;
        float v1_1;
        int v0 = 0x20;
        int v1 = ((int)(arg6 >> v0));
        if(Float.intBitsToFloat(v1) < arg8.getLeft()) {
            v1_1 = arg8.getLeft();
        }
        else if(Float.intBitsToFloat(v1) > arg8.getRight()) {
            v1_1 = arg8.getRight();
        }
        else {
            v1_1 = Float.intBitsToFloat(v1);
        }

        long v2 = 0xFFFFFFFFL;
        int v6 = ((int)(arg6 & v2));
        if(Float.intBitsToFloat(v6) < arg8.getTop()) {
            v6_1 = arg8.getTop();
        }
        else if(Float.intBitsToFloat(v6) > arg8.getBottom()) {
            v6_1 = arg8.getBottom();
        }
        else {
            v6_1 = Float.intBitsToFloat(v6);
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(v1_1))) << v0 | (((long)Float.floatToRawIntBits(v6_1))) & v2);
    }

    public static final long fromDecorationToTextLayout-Uv8p0NA(TextLayoutState arg2, long arg3) {
        Offset v2_1;
        LayoutCoordinates v0 = arg2.getTextLayoutNodeCoordinates();
        if(v0 != null) {
            LayoutCoordinates v2 = arg2.getDecoratorNodeCoordinates();
            if(v2 != null) {
                long v0_1 = !v0.isAttached() || !v2.isAttached() ? arg3 : v0.localPositionOf-R5De75A(v2, arg3);
                v2_1 = Offset.box-impl(v0_1);
            }
            else {
                v2_1 = null;
            }

            if(v2_1 == null) {
                return arg3;
            }

            return v2_1.unbox-impl();
        }

        return arg3;
    }

    public static final long fromTextLayoutToCore-Uv8p0NA(TextLayoutState arg3, long arg4) {
        LayoutCoordinates v0 = arg3.getTextLayoutNodeCoordinates();
        if(v0 != null) {
            Offset v2 = null;
            if(v0.isAttached()) {
            }
            else {
                v0 = ((LayoutCoordinates)v2);
            }

            if(v0 == null) {
                return arg4;
            }

            LayoutCoordinates v3 = arg3.getCoreNodeCoordinates();
            if(v3 != null) {
                if(v3.isAttached()) {
                }
                else {
                    v3 = ((LayoutCoordinates)v2);
                }

                if(v3 == null) {
                    goto label_17;
                }

                v2 = Offset.box-impl(v3.localPositionOf-R5De75A(v0, arg4));
            }

        label_17:
            if(v2 == null) {
                return arg4;
            }

            return v2.unbox-impl();
        }

        return arg4;
    }

    public static final Rect fromTextLayoutToDecoration(TextLayoutState arg3, Rect arg4) {
        LayoutCoordinates v0 = arg3.getTextLayoutNodeCoordinates();
        if(v0 != null) {
            LayoutCoordinates v2 = null;
            if(v0.isAttached()) {
            }
            else {
                v0 = v2;
            }

            if(v0 == null) {
                return arg4;
            }

            LayoutCoordinates v3 = arg3.getDecoratorNodeCoordinates();
            if(v3 == null) {
                return arg4;
            }

            if(v3.isAttached()) {
                v2 = v3;
            }

            if(v2 == null) {
                return arg4;
            }

            return arg4.translate-k-4lQ0M(v2.localBoundingBoxOf(v0, false).getTopLeft-F1C5BW0());
        }

        return arg4;
    }

    public static final long fromWindowToDecoration-Uv8p0NA(TextLayoutState arg1, long arg2) {
        LayoutCoordinates v1 = arg1.getDecoratorNodeCoordinates();
        if(v1 != null && (v1.isAttached())) {
            return v1.windowToLocal-MK-Hz9U(arg2);
        }

        return arg2;
    }
}

