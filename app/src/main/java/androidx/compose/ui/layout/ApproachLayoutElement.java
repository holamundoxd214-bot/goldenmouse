package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u008E\u0001\u0012A\u0010\u0003\u001A=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r\u0012\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000F\u0012.\b\u0002\u0010\u0012\u001A(\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\r¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001D\u001A\u00020\u0002H\u0016J\u0010\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u0002H\u0016J\f\u0010!\u001A\u00020\u001F*\u00020\"H\u0016J\u0013\u0010#\u001A\u00020\u00112\b\u0010$\u001A\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001A\u00020\'H\u0016RL\u0010\u0003\u001A=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u001D\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u001BR7\u0010\u0012\u001A(\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\r¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u001C¨\u0006("}, d2={"Landroidx/compose/ui/layout/ApproachLayoutElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNodeImpl;", "approachMeasure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "isMeasurementApproachInProgress", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "isPlacementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadCoordinates", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getApproachMeasure", "()Lkotlin/jvm/functions/Function3;", "()Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function2;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ApproachLayoutElement extends ModifierNodeElement {
    private final Function3 approachMeasure;
    private final Function1 isMeasurementApproachInProgress;
    private final Function2 isPlacementApproachInProgress;

    public ApproachLayoutElement(Function3 arg1, Function1 arg2, Function2 arg3) {
        super();
        this.approachMeasure = arg1;
        this.isMeasurementApproachInProgress = arg2;
        this.isPlacementApproachInProgress = arg3;
    }

    public ApproachLayoutElement(Function3 arg1, Function1 arg2, Function2 arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = LookaheadScopeKt.access$getDefaultPlacementApproachInProgress$p();
        }

        this(arg1, arg2, arg3);
    }

    public Node create() {
        return this.create();
    }

    public ApproachLayoutModifierNodeImpl create() {
        return new ApproachLayoutModifierNodeImpl(this.approachMeasure, this.isMeasurementApproachInProgress, this.isPlacementApproachInProgress);
    }

    public boolean equals(Object arg5) {
        if(this == (((ApproachLayoutElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ApproachLayoutElement)) {
            return 0;
        }

        if(this.approachMeasure != ((ApproachLayoutElement)arg5).approachMeasure) {
            return 0;
        }

        if(this.isMeasurementApproachInProgress != ((ApproachLayoutElement)arg5).isMeasurementApproachInProgress) {
            return 0;
        }

        if(this.isPlacementApproachInProgress != ((ApproachLayoutElement)arg5).isPlacementApproachInProgress) {
            return 0;
        }

        return 1;
    }

    public final Function3 getApproachMeasure() {
        return this.approachMeasure;
    }

    public int hashCode() {
        return (this.approachMeasure.hashCode() * 0x1F + this.isMeasurementApproachInProgress.hashCode()) * 0x1F + this.isPlacementApproachInProgress.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("approachLayout");
        arg4.getProperties().set("approachMeasure", this.approachMeasure);
        arg4.getProperties().set("isMeasurementApproachInProgress", this.isMeasurementApproachInProgress);
        arg4.getProperties().set("isPlacementApproachInProgress", this.isPlacementApproachInProgress);
    }

    public final Function1 isMeasurementApproachInProgress() {
        return this.isMeasurementApproachInProgress;
    }

    public final Function2 isPlacementApproachInProgress() {
        return this.isPlacementApproachInProgress;
    }

    public void update(Node arg1) {
        this.update(((ApproachLayoutModifierNodeImpl)arg1));
    }

    public void update(ApproachLayoutModifierNodeImpl arg2) {
        arg2.setMeasureBlock(this.approachMeasure);
        arg2.setMeasurementApproachInProgress(this.isMeasurementApproachInProgress);
        arg2.setPlacementApproachInProgress(this.isPlacementApproachInProgress);
    }
}

