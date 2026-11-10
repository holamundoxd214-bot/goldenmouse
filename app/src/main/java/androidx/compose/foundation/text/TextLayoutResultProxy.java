package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000F\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000E\u0010\u0019\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u001BJ\u0018\u0010\u001C\u001A\u00020\u00122\u0006\u0010\u001D\u001A\u00020\u00122\b\b\u0002\u0010\u001E\u001A\u00020\u0016J\u0015\u0010\u001F\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001A\u00020\u00142\u0006\u0010 \u001A\u00020\u0014H\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001A\u00020\u00142\u0006\u0010 \u001A\u00020\u0014H\u0000¢\u0006\u0004\b\'\u0010%J\u0013\u0010(\u001A\u00020\u0014*\u00020\u0014H\u0002¢\u0006\u0004\b)\u0010%R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\f\"\u0004\b\u0010\u0010\u000E¨\u0006*"}, d2={"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "decorationBoxCoordinates", "<init>", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "getInnerTextFieldCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setInnerTextFieldCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getDecorationBoxCoordinates", "setDecorationBoxCoordinates", "getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "", "getOffsetForPosition-3MmeM6k", "(JZ)I", "getLineForVerticalPosition", "vertical", "", "getLineEnd", "lineIndex", "visibleEnd", "isPositionOnText", "offset", "isPositionOnText-k-4lQ0M", "(J)Z", "translateDecorationToInnerCoordinates", "translateDecorationToInnerCoordinates-MK-Hz9U$foundation", "(J)J", "translateInnerToDecorationCoordinates", "translateInnerToDecorationCoordinates-MK-Hz9U$foundation", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextLayoutResultProxy {
    public static final int $stable = 8;
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    static {
    }

    public TextLayoutResultProxy(TextLayoutResult arg1, LayoutCoordinates arg2, LayoutCoordinates arg3) {
        super();
        this.value = arg1;
        this.innerTextFieldCoordinates = arg2;
        this.decorationBoxCoordinates = arg3;
    }

    public TextLayoutResultProxy(TextLayoutResult arg2, LayoutCoordinates arg3, LayoutCoordinates arg4, int arg5, DefaultConstructorMarker arg6) {
        LayoutCoordinates v0 = null;
        if((arg5 & 2) != 0) {
            arg3 = v0;
        }

        if((arg5 & 4) != 0) {
            arg4 = v0;
        }

        this(arg2, arg3, arg4);
    }

    private final long coercedInVisibleBoundsOfInputText-MK-Hz9U(long arg5) {
        Rect v1_1;
        Object v1;
        LayoutCoordinates v0 = this.innerTextFieldCoordinates;
        if(v0 != null) {
            if(v0.isAttached()) {
                LayoutCoordinates v4 = this.decorationBoxCoordinates;
                v1 = null;
                if(v4 != null) {
                    v1_1 = LayoutCoordinates.localBoundingBoxOf$default(v4, v0, false, 2, v1);
                }
            }
            else {
                v1_1 = Rect.Companion.getZero();
            }

            if((((Rect)v1)) != null) {
                goto label_16;
            }

            goto label_14;
        }
        else {
        label_14:
            v1_1 = Rect.Companion.getZero();
        }

    label_16:
        return TextLayoutResultProxyKt.access$coerceIn-3MmeM6k(arg5, ((Rect)v1));
    }

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final int getLineEnd(int arg1, boolean arg2) {
        return this.value.getLineEnd(arg1, arg2);
    }

    public static int getLineEnd$default(TextLayoutResultProxy arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.getLineEnd(arg1, false);
    }

    public final int getLineForVerticalPosition(float arg7) {
        return this.value.getLineForVerticalPosition(Float.intBitsToFloat(((int)(this.translateDecorationToInnerCoordinates-MK-Hz9U$foundation(this.coercedInVisibleBoundsOfInputText-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(arg7))) & 0xFFFFFFFFL))) & 0xFFFFFFFFL))));
    }

    public final int getOffsetForPosition-3MmeM6k(long arg1, boolean arg3) {
        if(arg3) {
            arg1 = this.coercedInVisibleBoundsOfInputText-MK-Hz9U(arg1);
        }

        return this.value.getOffsetForPosition-k-4lQ0M(this.translateDecorationToInnerCoordinates-MK-Hz9U$foundation(arg1));
    }

    public static int getOffsetForPosition-3MmeM6k$default(TextLayoutResultProxy arg0, long arg1, boolean arg3, int arg4, Object arg5) {
        return arg0.getOffsetForPosition-3MmeM6k(arg1, true);
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    public final boolean isPositionOnText-k-4lQ0M(long arg4) {
        arg4 = this.translateDecorationToInnerCoordinates-MK-Hz9U$foundation(this.coercedInVisibleBoundsOfInputText-MK-Hz9U(arg4));
        int v0 = this.value.getLineForVerticalPosition(Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg4))));
        int v4 = ((int)(arg4 >> 0x20));
        if(Float.intBitsToFloat(v4) >= this.value.getLineLeft(v0) && Float.intBitsToFloat(v4) <= this.value.getLineRight(v0)) {
            return 1;
        }

        return 0;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates arg1) {
        this.decorationBoxCoordinates = arg1;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates arg1) {
        this.innerTextFieldCoordinates = arg1;
    }

    public final long translateDecorationToInnerCoordinates-MK-Hz9U$foundation(long arg4) {
        LayoutCoordinates v0 = this.innerTextFieldCoordinates;
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

            LayoutCoordinates v3 = this.decorationBoxCoordinates;
            if(v3 == null) {
                return arg4;
            }

            if(v3.isAttached()) {
                v2 = v3;
            }

            if(v2 == null) {
                return arg4;
            }

            return v0.localPositionOf-R5De75A(v2, arg4);
        }

        return arg4;
    }

    public final long translateInnerToDecorationCoordinates-MK-Hz9U$foundation(long arg4) {
        LayoutCoordinates v0 = this.innerTextFieldCoordinates;
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

            LayoutCoordinates v3 = this.decorationBoxCoordinates;
            if(v3 == null) {
                return arg4;
            }

            if(v3.isAttached()) {
                v2 = v3;
            }

            if(v2 == null) {
                return arg4;
            }

            return v2.localPositionOf-R5De75A(v0, arg4);
        }

        return arg4;
    }
}

