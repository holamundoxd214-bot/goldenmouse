package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\n\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u000F\u0012\u0006\u0010\u0011\u001A\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001D\u001A\u00020\u001E*\u00020\u001F2\u0012\u0010 \u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0!2\u0006\u0010#\u001A\u00020$H\u0016¢\u0006\u0004\b%\u0010&J(\u0010\'\u001A\u00020\u000F*\u00020(2\u0012\u0010 \u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0!0!2\u0006\u0010*\u001A\u00020\u000FH\u0016J(\u0010+\u001A\u00020\u000F*\u00020(2\u0012\u0010 \u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0!0!2\u0006\u0010,\u001A\u00020\u000FH\u0016J(\u0010-\u001A\u00020\u000F*\u00020(2\u0012\u0010 \u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0!0!2\u0006\u0010,\u001A\u00020\u000FH\u0016J(\u0010.\u001A\u00020\u000F*\u00020(2\u0012\u0010 \u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0!0!2\u0006\u0010*\u001A\u00020\u000FH\u0016JD\u0010/\u001A\u00020\u000F2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020)0!2\u0006\u00100\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\u000F2\u0006\u00101\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u0012J$\u00102\u001A\u00020\u000F2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020)0!2\u0006\u0010*\u001A\u00020\u000F2\u0006\u00103\u001A\u00020\u000FJD\u00104\u001A\u00020\u000F2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020)0!2\u0006\u00105\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\u000F2\u0006\u00101\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u0012J\u0012\u00106\u001A\u00020\u000F*\u00020)2\u0006\u00107\u001A\u00020\u000FJ\u0012\u00108\u001A\u00020\u000F*\u00020)2\u0006\u00107\u001A\u00020\u000FJ\u0012\u00109\u001A\u00020\u000F*\u00020)2\u0006\u00107\u001A\u00020\u000FJ\t\u0010:\u001A\u00020\u0004HÆ\u0003J\t\u0010;\u001A\u00020\u0006HÆ\u0003J\t\u0010<\u001A\u00020\bHÆ\u0003J\u0010\u0010=\u001A\u00020\nHÂ\u0003¢\u0006\u0004\b>\u0010?J\t\u0010@\u001A\u00020\fHÆ\u0003J\u0010\u0010A\u001A\u00020\nHÂ\u0003¢\u0006\u0004\bB\u0010?J\t\u0010C\u001A\u00020\u000FHÂ\u0003J\t\u0010D\u001A\u00020\u000FHÂ\u0003J\t\u0010E\u001A\u00020\u0012HÂ\u0003Jj\u0010F\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\n2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u0012HÆ\u0001¢\u0006\u0004\bG\u0010HJ\u0013\u0010I\u001A\u00020\u00042\b\u0010J\u001A\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001A\u00020\u000FHÖ\u0001J\t\u0010M\u001A\u00020NHÖ\u0001R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0010\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001AR\u0014\u0010\u000B\u001A\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0010\u0010\r\u001A\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001AR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2={"Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "maxItemsInMainAxis", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "<init>", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "minIntrinsicMainAxisSize", "crossAxisAvailable", "crossAxisSpacing", "maxIntrinsicMainAxisSize", "arrangementSpacing", "intrinsicCrossAxisSize", "mainAxisAvailable", "maxMainAxisIntrinsicItemSize", "size", "minCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "copy", "copy-QuyCDyQ", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "equals", "other", "", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class FlowMeasurePolicy implements FlowLineMeasurePolicy, MultiContentMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final float mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;
    private final Vertical verticalArrangement;

    public FlowMeasurePolicy(boolean arg1, Horizontal arg2, Vertical arg3, float arg4, CrossAxisAlignment arg5, float arg6, int arg7, int arg8, FlowLayoutOverflowState arg9, DefaultConstructorMarker arg10) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    private FlowMeasurePolicy(boolean arg1, Horizontal arg2, Vertical arg3, float arg4, CrossAxisAlignment arg5, float arg6, int arg7, int arg8, FlowLayoutOverflowState arg9) {
        super();
        this.isHorizontal = arg1;
        this.horizontalArrangement = arg2;
        this.verticalArrangement = arg3;
        this.mainAxisSpacing = arg4;
        this.crossAxisAlignment = arg5;
        this.crossAxisArrangementSpacing = arg6;
        this.maxItemsInMainAxis = arg7;
        this.maxLines = arg8;
        this.overflow = arg9;
    }

    public final boolean component1() {
        return this.isHorizontal;
    }

    public final Horizontal component2() {
        return this.horizontalArrangement;
    }

    public final Vertical component3() {
        return this.verticalArrangement;
    }

    private final float component4-D9Ej5fM() {
        return this.mainAxisSpacing;
    }

    public final CrossAxisAlignment component5() {
        return this.crossAxisAlignment;
    }

    private final float component6-D9Ej5fM() {
        return this.crossAxisArrangementSpacing;
    }

    private final int component7() {
        return this.maxItemsInMainAxis;
    }

    private final int component8() {
        return this.maxLines;
    }

    private final FlowLayoutOverflowState component9() {
        return this.overflow;
    }

    public final FlowMeasurePolicy copy-QuyCDyQ(boolean arg12, Horizontal arg13, Vertical arg14, float arg15, CrossAxisAlignment arg16, float arg17, int arg18, int arg19, FlowLayoutOverflowState arg20) {
        return new FlowMeasurePolicy(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, null);
    }

    public static FlowMeasurePolicy copy-QuyCDyQ$default(FlowMeasurePolicy arg0, boolean arg1, Horizontal arg2, Vertical arg3, float arg4, CrossAxisAlignment arg5, float arg6, int arg7, int arg8, FlowLayoutOverflowState arg9, int arg10, Object arg11) {
        if((arg10 & 1) != 0) {
            arg1 = arg0.isHorizontal;
        }

        if((arg10 & 2) != 0) {
            arg2 = arg0.horizontalArrangement;
        }

        if((arg10 & 4) != 0) {
            arg3 = arg0.verticalArrangement;
        }

        if((arg10 & 8) != 0) {
            arg4 = arg0.mainAxisSpacing;
        }

        if((arg10 & 16) != 0) {
            arg5 = arg0.crossAxisAlignment;
        }

        if((arg10 & 0x20) != 0) {
            arg6 = arg0.crossAxisArrangementSpacing;
        }

        if((arg10 & 0x40) != 0) {
            arg7 = arg0.maxItemsInMainAxis;
        }

        if((arg10 & 0x80) != 0) {
            arg8 = arg0.maxLines;
        }

        if((arg10 & 0x100) != 0) {
            arg9 = arg0.overflow;
        }

        return arg0.copy-QuyCDyQ(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public boolean equals(Object arg5) {
        if(this == (((FlowMeasurePolicy)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof FlowMeasurePolicy)) {
            return 0;
        }

        if(this.isHorizontal != ((FlowMeasurePolicy)arg5).isHorizontal) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.horizontalArrangement, ((FlowMeasurePolicy)arg5).horizontalArrangement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.verticalArrangement, ((FlowMeasurePolicy)arg5).verticalArrangement)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.mainAxisSpacing, ((FlowMeasurePolicy)arg5).mainAxisSpacing)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.crossAxisAlignment, ((FlowMeasurePolicy)arg5).crossAxisAlignment)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.crossAxisArrangementSpacing, ((FlowMeasurePolicy)arg5).crossAxisArrangementSpacing)) {
            return 0;
        }

        if(this.maxItemsInMainAxis != ((FlowMeasurePolicy)arg5).maxItemsInMainAxis) {
            return 0;
        }

        if(this.maxLines != ((FlowMeasurePolicy)arg5).maxLines) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.overflow, ((FlowMeasurePolicy)arg5).overflow)) {
            return 0;
        }

        return 1;
    }

    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    public Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.isHorizontal) * 0x1F + this.horizontalArrangement.hashCode()) * 0x1F + this.verticalArrangement.hashCode()) * 0x1F + Dp.hashCode-impl(this.mainAxisSpacing)) * 0x1F + this.crossAxisAlignment.hashCode()) * 0x1F + Dp.hashCode-impl(this.crossAxisArrangementSpacing)) * 0x1F + Integer.hashCode(this.maxItemsInMainAxis)) * 0x1F + Integer.hashCode(this.maxLines)) * 0x1F + this.overflow.hashCode();
    }

    public final int intrinsicCrossAxisSize(List arg26, int arg27, int arg28, int arg29, int arg30, int arg31, FlowLayoutOverflowState arg32) {
        long v0_1;
        FlowMeasurePolicy v0 = this;
        List v1 = arg26;
        int v2 = arg27;
        int v4 = 0;
        if(v1.isEmpty()) {
            v0_1 = IntIntPair.constructor-impl(0, 0);
        }
        else {
            int v3 = 0x7FFFFFFF;
            FlowLayoutBuildingBlocks v10 = new FlowLayoutBuildingBlocks(arg30, arg32, OrientationIndependentConstraints.constructor-impl(0, v2, 0, v3), arg31, arg28, arg29, null);
            Object v5 = CollectionsKt.getOrNull(v1, 0);
            int v6 = v5 != null ? v0.minCrossAxisIntrinsicItemSize(((IntrinsicMeasurable)v5), v2) : 0;
            int v7 = v5 != null ? v0.minMainAxisIntrinsicItemSize(((IntrinsicMeasurable)v5), v6) : 0;
            boolean v9 = true;
            boolean v11 = v1.size() > 1 ? true : false;
            long v13 = IntIntPair.constructor-impl(v2, v3);
            IntIntPair v8 = null;
            IntIntPair v15 = v5 == null ? v8 : IntIntPair.box-impl(IntIntPair.constructor-impl(v7, v6));
            int v17 = 0;
            if(v10.getWrapInfo-OpUlnko(v11, 0, v13, v15, 0, 0, 0, false, false).isLastItemInContainer()) {
                if(v5 != null) {
                }
                else {
                    v9 = false;
                }

                IntIntPair v0_2 = arg32.ellipsisSize-F35zm-w$foundation_layout(v9, 0, 0);
                int v0_3 = v0_2 != null ? IntIntPair.getSecond-impl(v0_2.unbox-impl()) : 0;
                v0_1 = IntIntPair.constructor-impl(v0_3, 0);
                goto label_157;
            }

            int v5_1 = v1.size();
            int v14 = v2;
            int v12 = 0;
            int v15_1 = 0;
            int v21 = 0;
            int v13_1 = 0;
            int v11_1 = 0;
            while(v12 < v5_1) {
                v7 = v14 - v7;
                v14 = v12 + 1;
                int v18 = Math.max(v11_1, v6);
                Object v6_1 = CollectionsKt.getOrNull(v1, v14);
                v11_1 = v6_1 != null ? v0.minCrossAxisIntrinsicItemSize(((IntrinsicMeasurable)v6_1), v2) : v4;
                v15_1 = v6_1 != null ? v0.minMainAxisIntrinsicItemSize(((IntrinsicMeasurable)v6_1), v11_1) + arg28 : v4;
                boolean v4_1 = v12 + 2 < v1.size() ? true : false;
                v12 = v14 - v21;
                int v19 = v13_1;
                int v16 = v14;
                v13 = IntIntPair.constructor-impl(v7, v3);
                IntIntPair v20 = v6_1 == null ? v8 : IntIntPair.box-impl(IntIntPair.constructor-impl(v15_1, v11_1));
                int v22 = v16;
                v16 = v19;
                int v23 = v15_1;
                int v24 = v11_1;
                v11 = v4_1;
                v4 = v24;
                WrapInfo v11_2 = v10.getWrapInfo-OpUlnko(v11, v12, v13, v20, v16, v17, v18, false, false);
                if(v11_2.isLastItemInLine()) {
                    v14 = v17 + (v18 + arg29);
                    v13_1 = v16;
                    v16 = v12;
                    boolean v12_1 = v6_1 != null ? true : false;
                    WrapEllipsisInfo v6_2 = v10.getWrapEllipsisInfo(v11_2, v12_1, v13_1, v14, v7, v16);
                    v15_1 = v23 - arg28;
                    ++v13_1;
                    if(v11_2.isLastItemInContainer()) {
                        if(v6_2 != null) {
                            v0_1 = v6_2.getEllipsisSize-OO21N7I();
                            if(!v6_2.getPlaceEllipsisOnLastContentLine()) {
                                v14 += IntIntPair.getSecond-impl(v0_1) + arg29;
                            }
                        }

                        v17 = v14;
                        v15_1 = v22;
                        break;
                    }

                    v17 = v14;
                    v7 = v15_1;
                    v21 = v22;
                    v11_1 = 0;
                    v14 = v2;
                }
                else {
                    v14 = v7;
                    v13_1 = v16;
                    v11_1 = v18;
                    v7 = v23;
                }

                v6 = v4;
                v12 = v22;
                v15_1 = v12;
                v4 = 0;
            }

            v0_1 = IntIntPair.constructor-impl(v17 - arg29, v15_1);
        }

    label_157:
        return IntIntPair.getFirst-impl(v0_1);
    }

    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg14, List arg15, int arg16) {
        List v2_1;
        Object v2;
        IntrinsicMeasurable v4_1;
        FlowLayoutOverflowState v3 = this.overflow;
        Object v4 = CollectionsKt.getOrNull(arg15, 1);
        IntrinsicMeasurable v5 = null;
        if(v4 != null) {
            v4 = CollectionsKt.firstOrNull(((List)v4));
        }
        else {
            v4_1 = v5;
        }

        Object v6 = CollectionsKt.getOrNull(arg15, 2);
        if(v6 != null) {
            Object v5_1 = CollectionsKt.firstOrNull(((List)v6));
        }

        v3.setOverflowMeasurables--hBUhpc$foundation_layout(v4_1, v5, this.isHorizontal(), ConstraintsKt.Constraints$default(0, arg16, 0, 0, 13, null));
        if(this.isHorizontal()) {
            v2 = CollectionsKt.firstOrNull(arg15);
            if(v2 == null) {
                v2_1 = CollectionsKt.emptyList();
            }

            return this.intrinsicCrossAxisSize(v2, arg16, arg14.roundToPx-0680j_4(this.mainAxisSpacing), arg14.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }

        v2 = CollectionsKt.firstOrNull(arg15);
        if(v2 == null) {
            v2_1 = CollectionsKt.emptyList();
        }

        return this.maxIntrinsicMainAxisSize(((List)v2), arg16, arg14.roundToPx-0680j_4(this.mainAxisSpacing));
    }

    public final int maxIntrinsicMainAxisSize(List arg11, int arg12, int arg13) {
        int v0 = this.maxItemsInMainAxis;
        int v1 = arg11.size();
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        while(v3 < v1) {
            int v7 = this.maxMainAxisIntrinsicItemSize(arg11.get(v3), arg12) + arg13;
            int v8 = v3 + 1;
            if(v8 - v5 == v0 || v8 == arg11.size()) {
                v4 = Math.max(v4, v6 + v7 - arg13);
                v6 = 0;
                v5 = v3;
            }
            else {
                v6 += v7;
            }

            v3 = v8;
        }

        return v4;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg14, List arg15, int arg16) {
        List v2_1;
        Object v2;
        IntrinsicMeasurable v4_1;
        FlowLayoutOverflowState v3 = this.overflow;
        Object v4 = CollectionsKt.getOrNull(arg15, 1);
        IntrinsicMeasurable v5 = null;
        if(v4 != null) {
            v4 = CollectionsKt.firstOrNull(((List)v4));
        }
        else {
            v4_1 = v5;
        }

        Object v6 = CollectionsKt.getOrNull(arg15, 2);
        if(v6 != null) {
            Object v5_1 = CollectionsKt.firstOrNull(((List)v6));
        }

        v3.setOverflowMeasurables--hBUhpc$foundation_layout(v4_1, v5, this.isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, arg16, 7, null));
        if(this.isHorizontal()) {
            v2 = CollectionsKt.firstOrNull(arg15);
            if(v2 == null) {
                v2_1 = CollectionsKt.emptyList();
            }

            return this.maxIntrinsicMainAxisSize(v2_1, arg16, arg14.roundToPx-0680j_4(this.mainAxisSpacing));
        }

        int v10 = arg16;
        v2 = CollectionsKt.firstOrNull(arg15);
        if(v2 == null) {
            v2_1 = CollectionsKt.emptyList();
        }

        return this.intrinsicCrossAxisSize(v2_1, v10, arg14.roundToPx-0680j_4(this.mainAxisSpacing), arg14.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public final int maxMainAxisIntrinsicItemSize(IntrinsicMeasurable arg1, int arg2) {
        if(this.isHorizontal()) {
            return arg1.maxIntrinsicWidth(arg2);
        }

        return arg1.maxIntrinsicHeight(arg2);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg11, List arg12, long arg13) {
        Object v5;
        if(this.maxLines != 0 && this.maxItemsInMainAxis != 0 && !arg12.isEmpty() && (Constraints.getMaxHeight-impl(arg13) != 0 || this.overflow.getType$foundation_layout() == OverflowType.Visible)) {
            Object v0 = CollectionsKt.first(arg12);
            if(((List)v0).isEmpty()) {
                return MeasureScope.layout$default(arg11, 0, 0, null, new FlowMeasurePolicy$$ExternalSyntheticLambda1(), 4, null);
            }

            MeasureScope v2 = arg11;
            Object v11 = CollectionsKt.getOrNull(arg12, 1);
            Object v1 = null;
            if(v11 != null) {
                v5 = CollectionsKt.firstOrNull(((List)v11));
            }
            else {
                Measurable v5_1 = ((Measurable)v1);
            }

            v11 = CollectionsKt.getOrNull(arg12, 2);
            if(v11 != null) {
                v1 = CollectionsKt.firstOrNull(((List)v11));
            }

            Object v6 = v1;
            this.overflow.setItemCount$foundation_layout(((List)v0).size());
            FlowMeasurePolicy v1_1 = this;
            long v7 = arg13;
            this.overflow.setOverflowMeasurables--hBUhpc$foundation_layout(v1_1, ((Measurable)v5), ((Measurable)v6), v7);
            Iterator v11_1 = ((List)v0).iterator();
            float v3 = this.mainAxisSpacing;
            float v4 = this.crossAxisArrangementSpacing;
            LayoutOrientation v12 = this.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
            return FlowLayoutKt.breakDownItems-di9J0FM(v2, ((FlowLineMeasurePolicy)v1_1), v11_1, v3, v4, OrientationIndependentConstraints.constructor-impl(v7, v12), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }

        return MeasureScope.layout$default(arg11, 0, 0, null, new FlowMeasurePolicy$$ExternalSyntheticLambda0(), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final Unit measure_3p2s80s$lambda$1(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    public final int minCrossAxisIntrinsicItemSize(IntrinsicMeasurable arg1, int arg2) {
        if(this.isHorizontal()) {
            return arg1.minIntrinsicHeight(arg2);
        }

        return arg1.minIntrinsicWidth(arg2);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg14, List arg15, int arg16) {
        List v2_1;
        Object v2;
        IntrinsicMeasurable v4_1;
        FlowLayoutOverflowState v3 = this.overflow;
        Object v4 = CollectionsKt.getOrNull(arg15, 1);
        IntrinsicMeasurable v5 = null;
        if(v4 != null) {
            v4 = CollectionsKt.firstOrNull(((List)v4));
        }
        else {
            v4_1 = v5;
        }

        Object v6 = CollectionsKt.getOrNull(arg15, 2);
        if(v6 != null) {
            Object v5_1 = CollectionsKt.firstOrNull(((List)v6));
        }

        v3.setOverflowMeasurables--hBUhpc$foundation_layout(v4_1, v5, this.isHorizontal(), ConstraintsKt.Constraints$default(0, arg16, 0, 0, 13, null));
        if(this.isHorizontal()) {
            v2 = CollectionsKt.firstOrNull(arg15);
            if(v2 == null) {
                v2_1 = CollectionsKt.emptyList();
            }

            return this.intrinsicCrossAxisSize(v2_1, arg16, arg14.roundToPx-0680j_4(this.mainAxisSpacing), arg14.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }

        v2 = CollectionsKt.firstOrNull(arg15);
        if(v2 == null) {
            v2_1 = CollectionsKt.emptyList();
        }

        return this.minIntrinsicMainAxisSize(v2_1, arg16, arg14.roundToPx-0680j_4(this.mainAxisSpacing), arg14.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public final int minIntrinsicMainAxisSize(List arg15, int arg16, int arg17, int arg18, int arg19, int arg20, FlowLayoutOverflowState arg21) {
        int v12;
        int v9 = arg16;
        int v6 = arg19;
        int v7 = arg20;
        if(arg15.isEmpty()) {
            return 0;
        }

        int v3 = arg15.size();
        int[] v1 = new int[v3];
        int v4 = arg15.size();
        int[] v2 = new int[v4];
        int v8 = arg15.size();
        int v10;
        for(v10 = 0; v10 < v8; ++v10) {
            Object v11 = arg15.get(v10);
            v12 = this.minMainAxisIntrinsicItemSize(((IntrinsicMeasurable)v11), v9);
            v1[v10] = v12;
            v2[v10] = this.minCrossAxisIntrinsicItemSize(((IntrinsicMeasurable)v11), v12);
        }

        int v14 = 0x7FFFFFFF;
        if(v7 != v14 && v6 != v14) {
            v14 = v6 * v7;
        }

        v10 = 1;
        if(v14 >= arg15.size() || arg21.getType$foundation_layout() != OverflowType.ExpandOrCollapseIndicator) {
            if(v14 >= arg15.size() && v7 >= arg21.getMinLinesToShowCollapse$foundation_layout() && arg21.getType$foundation_layout() == OverflowType.ExpandOrCollapseIndicator) {
            label_37:
                v8 = 1;
                goto label_48;
            }

            v8 = 0;
        }
        else if(arg21.getType$foundation_layout() == OverflowType.ExpandIndicator) {
            goto label_37;
        }
        else {
            goto label_37;
        }

    label_48:
        v14 = Math.min(v14 - v8, arg15.size());
        v8 = ArraysKt.sum(v1) + (arg15.size() - 1) * arg17;
        if(v4 == 0) {
            goto label_109;
        }

        v4 = v2[0];
        int v11_1 = ArraysKt.getLastIndex(v2);
        if(1 <= v11_1) {
            v12 = 1;
            goto label_61;
        label_109:
            throw new NoSuchElementException();
            while(true) {
            label_61:
                int v13 = v2[v12];
                if(v4 < v13) {
                    v4 = v13;
                }

                if(v12 == v11_1) {
                    break;
                }

                ++v12;
            }
        }

        if(v3 != 0) {
            v3 = v1[0];
            int v5 = ArraysKt.getLastIndex(v1);
            if(1 <= v5) {
                while(true) {
                    v11_1 = v1[v10];
                    if(v3 < v11_1) {
                        v3 = v11_1;
                    }

                    if(v10 == v5) {
                        break;
                    }

                    ++v10;
                }
            }

            v10 = v3;
            v11_1 = v8;
            while(v10 <= v11_1) {
                if(v4 == v9) {
                }
                else {
                    v3 = (v10 + v11_1) / 2;
                    long v12_1 = FlowLayoutKt.intrinsicCrossAxisSize(arg15, v1, v2, v3, arg17, arg18, v6, v7, arg21);
                    v4 = IntIntPair.getFirst-impl(v12_1);
                    int v0 = IntIntPair.getSecond-impl(v12_1);
                    if(v4 > v9 || v0 < v14) {
                        v10 = v3 + 1;
                        if(v10 > v11_1) {
                            return v10;
                        }
                    }
                    else if(v4 < v9) {
                        v11_1 = v3 - 1;
                    }
                    else {
                        return v3;
                    }

                    v6 = arg19;
                    v7 = arg20;
                    v8 = v3;
                    continue;
                }

                return v8;
            }

            return v8;
        }

        throw new NoSuchElementException();
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg14, List arg15, int arg16) {
        List v2_1;
        Object v2;
        Object v5_1;
        IntrinsicMeasurable v4_1;
        FlowLayoutOverflowState v3 = this.overflow;
        Object v4 = CollectionsKt.getOrNull(arg15, 1);
        IntrinsicMeasurable v5 = null;
        if(v4 != null) {
            v4 = CollectionsKt.firstOrNull(((List)v4));
        }
        else {
            v4_1 = v5;
        }

        Object v6 = CollectionsKt.getOrNull(arg15, 2);
        if(v6 != null) {
            v5_1 = CollectionsKt.firstOrNull(((List)v6));
        }

        v3.setOverflowMeasurables--hBUhpc$foundation_layout(v4_1, ((IntrinsicMeasurable)v5_1), this.isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, arg16, 7, null));
        if(this.isHorizontal()) {
            v2 = CollectionsKt.firstOrNull(arg15);
            if(v2 == null) {
                v2_1 = CollectionsKt.emptyList();
            }

            return this.minIntrinsicMainAxisSize(v2_1, arg16, arg14.roundToPx-0680j_4(this.mainAxisSpacing), arg14.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }

        v2 = CollectionsKt.firstOrNull(arg15);
        if(v2 == null) {
            v2_1 = CollectionsKt.emptyList();
        }

        return this.intrinsicCrossAxisSize(v2_1, arg16, arg14.roundToPx-0680j_4(this.mainAxisSpacing), arg14.roundToPx-0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public final int minMainAxisIntrinsicItemSize(IntrinsicMeasurable arg1, int arg2) {
        if(this.isHorizontal()) {
            return arg1.minIntrinsicWidth(arg2);
        }

        return arg1.minIntrinsicHeight(arg2);
    }

    public String toString() {
        return "FlowMeasurePolicy(isHorizontal=" + this.isHorizontal + ", horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", mainAxisSpacing=" + Dp.toString-impl(this.mainAxisSpacing) + ", crossAxisAlignment=" + this.crossAxisAlignment + ", crossAxisArrangementSpacing=" + Dp.toString-impl(this.crossAxisArrangementSpacing) + ", maxItemsInMainAxis=" + this.maxItemsInMainAxis + ", maxLines=" + this.maxLines + ", overflow=" + this.overflow + ')';
    }
}

