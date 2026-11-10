package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J%\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0016H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001A\u00020\u001A*\u00020\u001BH\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u0013\u0010\u0019\u001A\u00020\u001A*\u00020\u0013H\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ\u0013\u0010\u0019\u001A\u00020\u001A*\u00020 H\u0016¢\u0006\u0004\b\u001E\u0010!J\u0013\u0010\"\u001A\u00020\u001B*\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u0013\u0010\"\u001A\u00020\u001B*\u00020\u0013H\u0016¢\u0006\u0004\b#\u0010%J\u0013\u0010\"\u001A\u00020\u001B*\u00020\u001AH\u0016¢\u0006\u0004\b&\u0010$J\u0013\u0010\'\u001A\u00020(*\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001A\u00020)*\u00020(H\u0016¢\u0006\u0004\b-\u0010+JF\u0010.\u001A\u00020/2\u0006\u00100\u001A\u00020\u00132\u0006\u00101\u001A\u00020\u00132\u0012\u00102\u001A\u000E\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0013032\u0017\u00105\u001A\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\b9H\u0096\u0001Ja\u0010.\u001A\u00020/2\u0006\u00100\u001A\u00020\u00132\u0006\u00101\u001A\u00020\u00132\u0012\u00102\u001A\u000E\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0013032\u0019\u0010:\u001A\u0015\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u000208\u0018\u000106¢\u0006\u0002\b92\u0017\u00105\u001A\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020806¢\u0006\u0002\b9H\u0096\u0001J\u0014\u0010<\u001A\u00020\u0013*\u00020\u001AH\u0097\u0001¢\u0006\u0004\b=\u0010>J\u0014\u0010<\u001A\u00020\u0013*\u00020\u001BH\u0097\u0001¢\u0006\u0004\b?\u0010@J\u0014\u0010A\u001A\u00020 *\u00020\u001AH\u0097\u0001¢\u0006\u0004\bB\u0010!J\u0014\u0010A\u001A\u00020 *\u00020\u001BH\u0097\u0001¢\u0006\u0004\bC\u0010\u001DJ\r\u0010D\u001A\u00020E*\u00020FH\u0097\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000E0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000F\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001A\u00020 8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\bH\u0010IR\u0014\u0010J\u001A\u00020 8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\bK\u0010IR\u0014\u0010L\u001A\u00020M8VX\u0096\u0005¢\u0006\u0006\u001A\u0004\bL\u0010NR\u0012\u0010O\u001A\u00020PX\u0096\u0005¢\u0006\u0006\u001A\u0004\bQ\u0010R¨\u0006S"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeMeasureScope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeMeasureScope;)V", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "placeablesCache", "Landroidx/collection/MutableIntObjectMap;", "", "Landroidx/compose/ui/layout/Placeable;", "measurablesCache", "Landroidx/compose/ui/layout/Measurable;", "compose", "index", "", "measure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "toSp-0xMU5do", "toSize", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toSize-XkaWNTQ", "(J)J", "toDpSize", "toDpSize-k-rfVVM", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "roundToPx", "roundToPx-0680j_4", "(F)I", "roundToPx--R2X_6o", "(J)I", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "density", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {
    public static final int $stable;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final LazyLayoutItemProvider itemProvider;
    private final MutableIntObjectMap measurablesCache;
    private final MutableIntObjectMap placeablesCache;
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    static {
    }

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory arg1, SubcomposeMeasureScope arg2) {
        super();
        this.itemContentFactory = arg1;
        this.subcomposeMeasureScope = arg2;
        this.itemProvider = arg1.getItemProvider().invoke();
        this.placeablesCache = IntObjectMapKt.mutableIntObjectMapOf();
        this.measurablesCache = IntObjectMapKt.mutableIntObjectMapOf();
    }

    public List compose(int arg4) {
        Object v0 = this.measurablesCache.get(arg4);
        if(v0 != null) {
            return ((List)v0);
        }

        v0 = this.itemProvider.getKey(arg4);
        List v0_1 = this.subcomposeMeasureScope.subcompose(v0, this.itemContentFactory.getContent(arg4, v0, this.itemProvider.getContentType(arg4)));
        this.measurablesCache.set(arg4, v0_1);
        return v0_1;
    }

    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    public boolean isLookingAhead() {
        return this.subcomposeMeasureScope.isLookingAhead();
    }

    public MeasureResult layout(int arg1, int arg2, Map arg3, Function1 arg4) {
        return this.subcomposeMeasureScope.layout(arg1, arg2, arg3, arg4);
    }

    public MeasureResult layout(int arg1, int arg2, Map arg3, Function1 arg4, Function1 arg5) {
        return this.subcomposeMeasureScope.layout(arg1, arg2, arg3, arg4, arg5);
    }

    @Deprecated(message="Please use compose and measure") public List measure-0kLqBqw(int arg6, long arg7) {
        Object v0 = this.placeablesCache.get(arg6);
        if(v0 != null) {
            return ((List)v0);
        }

        v0 = this.itemProvider.getKey(arg6);
        List v0_1 = this.subcomposeMeasureScope.subcompose(v0, this.itemContentFactory.getContent(arg6, v0, this.itemProvider.getContentType(arg6)));
        int v1 = v0_1.size();
        ArrayList v2 = new ArrayList(v1);
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            v2.add(v0_1.get(v3).measure-BRTryo0(arg7));
        }

        this.placeablesCache.set(arg6, v2);
        return ((List)v2);
    }

    public int roundToPx--R2X_6o(long arg1) {
        return this.subcomposeMeasureScope.roundToPx--R2X_6o(arg1);
    }

    public int roundToPx-0680j_4(float arg1) {
        return this.subcomposeMeasureScope.roundToPx-0680j_4(arg1);
    }

    public float toDp-GaN1DYA(long arg1) {
        return this.subcomposeMeasureScope.toDp-GaN1DYA(arg1);
    }

    public float toDp-u2uoSUM(float arg1) {
        return this.subcomposeMeasureScope.toDp-u2uoSUM(arg1);
    }

    public float toDp-u2uoSUM(int arg1) {
        return this.subcomposeMeasureScope.toDp-u2uoSUM(arg1);
    }

    public long toDpSize-k-rfVVM(long arg1) {
        return this.subcomposeMeasureScope.toDpSize-k-rfVVM(arg1);
    }

    public float toPx--R2X_6o(long arg1) {
        return this.subcomposeMeasureScope.toPx--R2X_6o(arg1);
    }

    public float toPx-0680j_4(float arg1) {
        return this.subcomposeMeasureScope.toPx-0680j_4(arg1);
    }

    public Rect toRect(DpRect arg1) {
        return this.subcomposeMeasureScope.toRect(arg1);
    }

    public long toSize-XkaWNTQ(long arg1) {
        return this.subcomposeMeasureScope.toSize-XkaWNTQ(arg1);
    }

    public long toSp-0xMU5do(float arg1) {
        return this.subcomposeMeasureScope.toSp-0xMU5do(arg1);
    }

    public long toSp-kPz2Gy4(float arg1) {
        return this.subcomposeMeasureScope.toSp-kPz2Gy4(arg1);
    }

    public long toSp-kPz2Gy4(int arg1) {
        return this.subcomposeMeasureScope.toSp-kPz2Gy4(arg1);
    }
}

