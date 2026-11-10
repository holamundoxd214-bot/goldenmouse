package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B}\u0012A\u0010\u0003\u001A=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r\u0012\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000F\u0012\u001D\u0010\u0012\u001A\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u000E\u001A\u00020\u00112\u0006\u0010\"\u001A\u00020\u0010H\u0016¢\u0006\u0004\b#\u0010$J\u0014\u0010\u0012\u001A\u00020\u0011*\u00020\u00142\u0006\u0010%\u001A\u00020\u0015H\u0016J#\u0010&\u001A\u00020\f*\u00020\u00052\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\'\u0010(RU\u0010\u0003\u001A=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR&\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u001C\"\u0004\b\u001D\u0010\u001ER1\u0010\u0012\u001A\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u001F\"\u0004\b \u0010!¨\u0006)"}, d2={"Landroidx/compose/ui/layout/ApproachLayoutModifierNodeImpl;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "isMeasurementApproachInProgress", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "isPlacementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getMeasureBlock", "()Lkotlin/jvm/functions/Function3;", "setMeasureBlock", "(Lkotlin/jvm/functions/Function3;)V", "()Lkotlin/jvm/functions/Function1;", "setMeasurementApproachInProgress", "(Lkotlin/jvm/functions/Function1;)V", "()Lkotlin/jvm/functions/Function2;", "setPlacementApproachInProgress", "(Lkotlin/jvm/functions/Function2;)V", "lookaheadSize", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "lookaheadCoordinates", "approachMeasure", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ApproachLayoutModifierNodeImpl extends Node implements ApproachLayoutModifierNode {
    private Function1 isMeasurementApproachInProgress;
    private Function2 isPlacementApproachInProgress;
    private Function3 measureBlock;

    public ApproachLayoutModifierNodeImpl(Function3 arg1, Function1 arg2, Function2 arg3) {
        super();
        this.measureBlock = arg1;
        this.isMeasurementApproachInProgress = arg2;
        this.isPlacementApproachInProgress = arg3;
    }

    public MeasureResult approachMeasure-3p2s80s(ApproachMeasureScope arg1, Measurable arg2, long arg3) {
        return this.measureBlock.invoke(arg1, arg2, Constraints.box-impl(arg3));
    }

    public final Function3 getMeasureBlock() {
        return this.measureBlock;
    }

    public final Function1 isMeasurementApproachInProgress() {
        return this.isMeasurementApproachInProgress;
    }

    public boolean isMeasurementApproachInProgress-ozmzZPI(long arg1) {
        return this.isMeasurementApproachInProgress.invoke(IntSize.box-impl(arg1)).booleanValue();
    }

    public final Function2 isPlacementApproachInProgress() {
        return this.isPlacementApproachInProgress;
    }

    public boolean isPlacementApproachInProgress(PlacementScope arg1, LayoutCoordinates arg2) {
        return this.isPlacementApproachInProgress.invoke(arg1, arg2).booleanValue();
    }

    public final void setMeasureBlock(Function3 arg1) {
        this.measureBlock = arg1;
    }

    public final void setMeasurementApproachInProgress(Function1 arg1) {
        this.isMeasurementApproachInProgress = arg1;
    }

    public final void setPlacementApproachInProgress(Function2 arg1) {
        this.isPlacementApproachInProgress = arg1;
    }
}

