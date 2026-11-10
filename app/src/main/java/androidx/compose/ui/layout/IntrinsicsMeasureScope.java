package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J`\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u00102\u0019\u0010\u0012\u001A\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\u0002\b\u00162\u0017\u0010\u0017\u001A\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0016J\u0014\u0010\u0019\u001A\u00020\r*\u00020\u001AH\u0097\u0001¢\u0006\u0004\b\u001B\u0010\u001CJ\u0014\u0010\u0019\u001A\u00020\r*\u00020\u001DH\u0097\u0001¢\u0006\u0004\b\u001E\u0010\u001FJ\u0014\u0010 \u001A\u00020\u001A*\u00020\rH\u0097\u0001¢\u0006\u0004\b!\u0010\"J\u0014\u0010 \u001A\u00020\u001A*\u00020#H\u0097\u0001¢\u0006\u0004\b!\u0010$J\u0014\u0010 \u001A\u00020\u001A*\u00020\u001DH\u0097\u0001¢\u0006\u0004\b%\u0010&J\u0014\u0010\'\u001A\u00020(*\u00020)H\u0097\u0001¢\u0006\u0004\b*\u0010+J\u0014\u0010,\u001A\u00020#*\u00020\u001AH\u0097\u0001¢\u0006\u0004\b-\u0010$J\u0014\u0010,\u001A\u00020#*\u00020\u001DH\u0097\u0001¢\u0006\u0004\b.\u0010&J\r\u0010/\u001A\u000200*\u000201H\u0097\u0001J\u0014\u00102\u001A\u00020)*\u00020(H\u0097\u0001¢\u0006\u0004\b3\u0010+J\u0014\u00104\u001A\u00020\u001D*\u00020\rH\u0097\u0001¢\u0006\u0004\b5\u00106J\u0014\u00104\u001A\u00020\u001D*\u00020#H\u0097\u0001¢\u0006\u0004\b5\u00107J\u0014\u00104\u001A\u00020\u001D*\u00020\u001AH\u0097\u0001¢\u0006\u0004\b8\u00107R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u00109\u001A\u00020#8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b:\u0010;R\u0014\u0010<\u001A\u00020#8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b=\u0010;R\u0014\u0010>\u001A\u00020?8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\b>\u0010@¨\u0006A"}, d2={"Landroidx/compose/ui/layout/IntrinsicsMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "intrinsicMeasureScope", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "<init>", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/unit/LayoutDirection;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "density", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IntrinsicsMeasureScope implements IntrinsicMeasureScope, MeasureScope {
    public static final int $stable;
    private final LayoutDirection layoutDirection;

    static {
    }

    public IntrinsicsMeasureScope(IntrinsicMeasureScope arg1, LayoutDirection arg2) {
        super();
        this.$$delegate_0 = arg1;
        this.layoutDirection = arg2;
    }

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public boolean isLookingAhead() {
        return this.$$delegate_0.isLookingAhead();
    }

    public MeasureResult layout(int arg2, int arg3, Map arg4, Function1 arg5, Function1 arg6) {
        int v1 = 0;
        int v6 = 0xFF000000;
        if((0 & v6) == 0 && (v6 & 0) == 0) {
            v1 = 1;
        }

        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + 0 + " x " + 0 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }

        return new IntrinsicsMeasureScope$layout$1(0, 0, arg4, arg5);
    }

    public int roundToPx--R2X_6o(long arg1) {
        return this.$$delegate_0.roundToPx--R2X_6o(arg1);
    }

    public int roundToPx-0680j_4(float arg1) {
        return this.$$delegate_0.roundToPx-0680j_4(arg1);
    }

    public float toDp-GaN1DYA(long arg1) {
        return this.$$delegate_0.toDp-GaN1DYA(arg1);
    }

    public float toDp-u2uoSUM(float arg1) {
        return this.$$delegate_0.toDp-u2uoSUM(arg1);
    }

    public float toDp-u2uoSUM(int arg1) {
        return this.$$delegate_0.toDp-u2uoSUM(arg1);
    }

    public long toDpSize-k-rfVVM(long arg1) {
        return this.$$delegate_0.toDpSize-k-rfVVM(arg1);
    }

    public float toPx--R2X_6o(long arg1) {
        return this.$$delegate_0.toPx--R2X_6o(arg1);
    }

    public float toPx-0680j_4(float arg1) {
        return this.$$delegate_0.toPx-0680j_4(arg1);
    }

    public Rect toRect(DpRect arg1) {
        return this.$$delegate_0.toRect(arg1);
    }

    public long toSize-XkaWNTQ(long arg1) {
        return this.$$delegate_0.toSize-XkaWNTQ(arg1);
    }

    public long toSp-0xMU5do(float arg1) {
        return this.$$delegate_0.toSp-0xMU5do(arg1);
    }

    public long toSp-kPz2Gy4(float arg1) {
        return this.$$delegate_0.toSp-kPz2Gy4(arg1);
    }

    public long toSp-kPz2Gy4(int arg1) {
        return this.$$delegate_0.toSp-kPz2Gy4(arg1);
    }
}

