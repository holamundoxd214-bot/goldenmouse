package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B­\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\t\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\u0006\u0010\u0010\u001A\u00020\u000E\u0012\u0006\u0010\u0011\u001A\u00020\u0012\u0012\u0017\u0010\u0013\u001A\u0013\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014\u0012;\u0010\u0018\u001A7\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017¢\u0006\u0004\b\u001F\u0010 J\u0018\u0010*\u001A\u0014\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0\u0019J\u001B\u0010.\u001A\u00020-*\u00020+2\u0006\u0010/\u001A\u00020,H\u0002¢\u0006\u0004\b0\u00101J\t\u00102\u001A\u00020\u0003HÆ\u0003J\t\u00103\u001A\u00020\u0005HÆ\u0003J\t\u00104\u001A\u00020\u0007HÆ\u0003J\u0010\u00105\u001A\u00020\tHÂ\u0003¢\u0006\u0004\b6\u00107J\t\u00108\u001A\u00020\u000BHÆ\u0003J\u0010\u00109\u001A\u00020\tHÂ\u0003¢\u0006\u0004\b:\u00107J\t\u0010;\u001A\u00020\u000EHÂ\u0003J\t\u0010<\u001A\u00020\u000EHÂ\u0003J\t\u0010=\u001A\u00020\u000EHÂ\u0003J\t\u0010>\u001A\u00020\u0012HÂ\u0003J\u001A\u0010?\u001A\u0013\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014HÂ\u0003JC\u0010@\u001A7\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017HÂ\u0003¢\u0006\u0002\u0010AJÎ\u0001\u0010B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\t2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u000E2\b\b\u0002\u0010\u0011\u001A\u00020\u00122\u0019\b\u0002\u0010\u0013\u001A\u0013\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u00142=\b\u0002\u0010\u0018\u001A7\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017HÆ\u0001¢\u0006\u0004\bC\u0010DJ\u0013\u0010E\u001A\u00020\u00032\b\u0010F\u001A\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001A\u00020\u000EHÖ\u0001J\t\u0010I\u001A\u00020JHÖ\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010!R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0010\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0010\u0010\f\u001A\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001F\u0010\u0013\u001A\u0013\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\b\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000RE\u0010\u0018\u001A7\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001C\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006K"}, d2={"Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "itemCount", "", "maxLines", "maxItemsInMainAxis", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "<init>", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Lkotlin/jvm/functions/Function4;", "getMeasurePolicy", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "measure", "constraints", "measure-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "component10", "component11", "component12", "()Lkotlin/jvm/functions/Function4;", "copy", "copy-E4Q9ldg", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Ljava/util/List;Lkotlin/jvm/functions/Function4;)Landroidx/compose/foundation/layout/FlowMeasureLazyPolicy;", "equals", "other", "", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class FlowMeasureLazyPolicy implements FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Function4 getComposable;
    private final Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final int itemCount;
    private final float mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;
    private final List overflowComposables;
    private final Vertical verticalArrangement;

    public static Unit $r8$lambda$jp785Xd9HSR0zxnLiiWfgr0SBqo(FlowMeasureLazyPolicy arg0, int arg1, FlowLineInfo arg2, Composer arg3, int arg4) {
        return FlowMeasureLazyPolicy.measure_0kLqBqw$lambda$1$0(arg0, arg1, arg2, arg3, arg4);
    }

    public FlowMeasureLazyPolicy(boolean arg1, Horizontal arg2, Vertical arg3, float arg4, CrossAxisAlignment arg5, float arg6, int arg7, int arg8, int arg9, FlowLayoutOverflowState arg10, List arg11, Function4 arg12, DefaultConstructorMarker arg13) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    private FlowMeasureLazyPolicy(boolean arg1, Horizontal arg2, Vertical arg3, float arg4, CrossAxisAlignment arg5, float arg6, int arg7, int arg8, int arg9, FlowLayoutOverflowState arg10, List arg11, Function4 arg12) {
        super();
        this.isHorizontal = arg1;
        this.horizontalArrangement = arg2;
        this.verticalArrangement = arg3;
        this.mainAxisSpacing = arg4;
        this.crossAxisAlignment = arg5;
        this.crossAxisArrangementSpacing = arg6;
        this.itemCount = arg7;
        this.maxLines = arg8;
        this.maxItemsInMainAxis = arg9;
        this.overflow = arg10;
        this.overflowComposables = arg11;
        this.getComposable = arg12;
    }

    public final boolean component1() {
        return this.isHorizontal;
    }

    private final FlowLayoutOverflowState component10() {
        return this.overflow;
    }

    private final List component11() {
        return this.overflowComposables;
    }

    private final Function4 component12() {
        return this.getComposable;
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
        return this.itemCount;
    }

    private final int component8() {
        return this.maxLines;
    }

    private final int component9() {
        return this.maxItemsInMainAxis;
    }

    public final FlowMeasureLazyPolicy copy-E4Q9ldg(boolean arg15, Horizontal arg16, Vertical arg17, float arg18, CrossAxisAlignment arg19, float arg20, int arg21, int arg22, int arg23, FlowLayoutOverflowState arg24, List arg25, Function4 arg26) {
        return new FlowMeasureLazyPolicy(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, null);
    }

    public static FlowMeasureLazyPolicy copy-E4Q9ldg$default(FlowMeasureLazyPolicy arg0, boolean arg1, Horizontal arg2, Vertical arg3, float arg4, CrossAxisAlignment arg5, float arg6, int arg7, int arg8, int arg9, FlowLayoutOverflowState arg10, List arg11, Function4 arg12, int arg13, Object arg14) {
        if((arg13 & 1) != 0) {
            arg1 = arg0.isHorizontal;
        }

        if((arg13 & 2) != 0) {
            arg2 = arg0.horizontalArrangement;
        }

        if((arg13 & 4) != 0) {
            arg3 = arg0.verticalArrangement;
        }

        if((arg13 & 8) != 0) {
            arg4 = arg0.mainAxisSpacing;
        }

        if((arg13 & 16) != 0) {
            arg5 = arg0.crossAxisAlignment;
        }

        if((arg13 & 0x20) != 0) {
            arg6 = arg0.crossAxisArrangementSpacing;
        }

        if((arg13 & 0x40) != 0) {
            arg7 = arg0.itemCount;
        }

        if((arg13 & 0x80) != 0) {
            arg8 = arg0.maxLines;
        }

        if((arg13 & 0x100) != 0) {
            arg9 = arg0.maxItemsInMainAxis;
        }

        if((arg13 & 0x200) != 0) {
            arg10 = arg0.overflow;
        }

        if((arg13 & 0x400) != 0) {
            arg11 = arg0.overflowComposables;
        }

        if((arg13 & 0x800) != 0) {
            arg12 = arg0.getComposable;
        }

        return arg0.copy-E4Q9ldg(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public boolean equals(Object arg5) {
        if(this == (((FlowMeasureLazyPolicy)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof FlowMeasureLazyPolicy)) {
            return 0;
        }

        if(this.isHorizontal != ((FlowMeasureLazyPolicy)arg5).isHorizontal) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.horizontalArrangement, ((FlowMeasureLazyPolicy)arg5).horizontalArrangement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.verticalArrangement, ((FlowMeasureLazyPolicy)arg5).verticalArrangement)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.mainAxisSpacing, ((FlowMeasureLazyPolicy)arg5).mainAxisSpacing)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.crossAxisAlignment, ((FlowMeasureLazyPolicy)arg5).crossAxisAlignment)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.crossAxisArrangementSpacing, ((FlowMeasureLazyPolicy)arg5).crossAxisArrangementSpacing)) {
            return 0;
        }

        if(this.itemCount != ((FlowMeasureLazyPolicy)arg5).itemCount) {
            return 0;
        }

        if(this.maxLines != ((FlowMeasureLazyPolicy)arg5).maxLines) {
            return 0;
        }

        if(this.maxItemsInMainAxis != ((FlowMeasureLazyPolicy)arg5).maxItemsInMainAxis) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.overflow, ((FlowMeasureLazyPolicy)arg5).overflow)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.overflowComposables, ((FlowMeasureLazyPolicy)arg5).overflowComposables)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getComposable, ((FlowMeasureLazyPolicy)arg5).getComposable)) {
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

    public final Function2 getMeasurePolicy() {
        return new FlowMeasureLazyPolicy$$ExternalSyntheticLambda1(this);
    }

    static final MeasureResult getMeasurePolicy$lambda$0(FlowMeasureLazyPolicy arg2, SubcomposeMeasureScope arg3, Constraints arg4) {
        return arg2.measure-0kLqBqw(arg3, arg4.unbox-impl());
    }

    public Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public int hashCode() {
        return ((((((((((Boolean.hashCode(this.isHorizontal) * 0x1F + this.horizontalArrangement.hashCode()) * 0x1F + this.verticalArrangement.hashCode()) * 0x1F + Dp.hashCode-impl(this.mainAxisSpacing)) * 0x1F + this.crossAxisAlignment.hashCode()) * 0x1F + Dp.hashCode-impl(this.crossAxisArrangementSpacing)) * 0x1F + Integer.hashCode(this.itemCount)) * 0x1F + Integer.hashCode(this.maxLines)) * 0x1F + Integer.hashCode(this.maxItemsInMainAxis)) * 0x1F + this.overflow.hashCode()) * 0x1F + this.overflowComposables.hashCode()) * 0x1F + this.getComposable.hashCode();
    }

    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    private final MeasureResult measure-0kLqBqw(SubcomposeMeasureScope arg13, long arg14) {
        if(this.itemCount > 0 && this.maxLines != 0 && this.maxItemsInMainAxis != 0 && (Constraints.getMaxHeight-impl(arg14) != 0 || this.overflow.getType$foundation_layout() == OverflowType.Visible)) {
            ContextualFlowItemIterator v0 = new ContextualFlowItemIterator(this.itemCount, new FlowMeasureLazyPolicy$$ExternalSyntheticLambda3(arg13, this));
            this.overflow.setItemCount$foundation_layout(this.itemCount);
            FlowMeasureLazyPolicy v3 = this;
            this.overflow.setOverflowMeasurables-VKLhPVY$foundation_layout(((FlowLineMeasurePolicy)v3), arg14, new FlowMeasureLazyPolicy$$ExternalSyntheticLambda4(this, arg13));
            SubcomposeMeasureScope v2 = arg13;
            ContextualFlowItemIterator v4 = v0;
            float v5 = this.mainAxisSpacing;
            float v6 = this.crossAxisArrangementSpacing;
            LayoutOrientation v13 = this.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
            return FlowLayoutKt.breakDownItems-di9J0FM(((MeasureScope)v2), ((FlowLineMeasurePolicy)v3), ((Iterator)v4), v5, v6, OrientationIndependentConstraints.constructor-impl(arg14, v13), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }

        return MeasureScope.layout$default(arg13, 0, 0, null, new FlowMeasureLazyPolicy$$ExternalSyntheticLambda2(), 4, null);
    }

    static final Unit measure_0kLqBqw$lambda$0(PlacementScope arg0) {
        return Unit.INSTANCE;
    }

    static final List measure_0kLqBqw$lambda$1(SubcomposeMeasureScope arg2, FlowMeasureLazyPolicy arg3, int arg4, FlowLineInfo arg5) {
        return arg2.subcompose(Integer.valueOf(arg4), ComposableLambdaKt.composableLambdaInstance(0xF45F9C00, true, new FlowMeasureLazyPolicy$$ExternalSyntheticLambda0(arg3, arg4, arg5)));
    }

    private static final Unit measure_0kLqBqw$lambda$1$0(FlowMeasureLazyPolicy arg4, int arg5, FlowLineInfo arg6, Composer arg7, int arg8) {
        ComposerKt.sourceInformation(arg7, "C487@20659L26:ContextualFlowLayout.kt#2w3rfo");
        boolean v0 = (arg8 & 3) != 2 ? true : false;
        if(arg7.shouldExecute(v0, arg8 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xF45F9C00, arg8, -1, "androidx.compose.foundation.layout.FlowMeasureLazyPolicy.measure.<anonymous>.<anonymous> (ContextualFlowLayout.kt:487)");
            }

            arg4.getComposable.invoke(Integer.valueOf(arg5), arg6, arg7, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_27;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_27:
        return Unit.INSTANCE;
    }

    static final Measurable measure_0kLqBqw$lambda$2(FlowMeasureLazyPolicy arg2, SubcomposeMeasureScope arg3, boolean arg4, int arg5) {
        Object v0 = CollectionsKt.getOrNull(arg2.overflowComposables, (((int)arg4)) ^ 1);
        if(v0 != null) {
            return CollectionsKt.getOrNull(arg3.subcompose(arg4 + arg2.itemCount + arg5, ((Function2)v0)), 0);
        }

        return null;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("FlowMeasureLazyPolicy(isHorizontal=");
        v0.append(this.isHorizontal).append(", horizontalArrangement=").append(this.horizontalArrangement).append(", verticalArrangement=").append(this.verticalArrangement).append(", mainAxisSpacing=").append(Dp.toString-impl(this.mainAxisSpacing)).append(", crossAxisAlignment=").append(this.crossAxisAlignment).append(", crossAxisArrangementSpacing=").append(Dp.toString-impl(this.crossAxisArrangementSpacing)).append(", itemCount=").append(this.itemCount).append(", maxLines=").append(this.maxLines).append(", maxItemsInMainAxis=").append(this.maxItemsInMainAxis).append(", overflow=").append(this.overflow).append(", overflowComposables=").append(this.overflowComposables).append(", getComposable=");
        v0.append(this.getComposable).append(')');
        return v0.toString();
    }
}

