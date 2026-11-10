package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0081\b\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\'\u0010+\u001A\u0004\u0018\u00010\"2\u0006\u0010,\u001A\u00020&2\u0006\u0010-\u001A\u00020\u00052\u0006\u0010.\u001A\u00020\u0005H\u0000¢\u0006\u0002\b/J\'\u00100\u001A\u0004\u0018\u0001012\u0006\u0010,\u001A\u00020&2\u0006\u0010-\u001A\u00020\u00052\u0006\u0010.\u001A\u00020\u0005H\u0000¢\u0006\u0002\b2J3\u00103\u001A\u0002042\b\u0010\u001B\u001A\u0004\u0018\u0001052\b\u0010\u001F\u001A\u0004\u0018\u0001052\u0006\u00106\u001A\u00020&2\u0006\u00107\u001A\u000208H\u0000¢\u0006\u0004\b9\u0010:J3\u00103\u001A\u0002042\u0006\u0010;\u001A\u00020<2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001C2\u0006\u00107\u001A\u000208H\u0000¢\u0006\u0004\b9\u0010=JY\u00103\u001A\u0002042\u0006\u0010;\u001A\u00020<2\u0006\u00107\u001A\u00020828\u0010$\u001A4\u0012\u0013\u0012\u00110&¢\u0006\f\b\'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\'\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010\u001C0%H\u0000¢\u0006\u0004\b?\u0010@J\u000E\u0010A\u001A\u00020\u0003HÀ\u0003¢\u0006\u0002\bBJ\u000E\u0010C\u001A\u00020\u0005HÀ\u0003¢\u0006\u0002\bDJ\u000E\u0010E\u001A\u00020\u0005HÀ\u0003¢\u0006\u0002\bFJ\'\u0010G\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010H\u001A\u00020&2\b\u0010I\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001A\u00020\u0005HÖ\u0001J\t\u0010K\u001A\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\u0006\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0014\u0010\u000E\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\fR\u0014\u0010\u0010\u001A\u00020\u0011X\u0080D¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\f\"\u0004\b\u001A\u0010\u0017R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001F\u001A\u0004\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010 \u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010!\u001A\u0004\u0018\u00010\"X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010#\u001A\u0004\u0018\u00010\"X\u0082\u000E¢\u0006\u0002\n\u0000RB\u0010$\u001A6\u0012\u0013\u0012\u00110&¢\u0006\f\b\'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0006\u0012\u0004\u0018\u00010\u001C\u0018\u00010%X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006L"}, d2={"Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;II)V", "getType$foundation_layout", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "getMinLinesToShowCollapse$foundation_layout", "()I", "getMinCrossAxisSizeToShowCollapse$foundation_layout", "shownItemCount", "getShownItemCount$foundation_layout", "shownItemLazyErrorMessage", "", "getShownItemLazyErrorMessage$foundation_layout", "()Ljava/lang/String;", "itemShown", "getItemShown$foundation_layout", "setItemShown$foundation_layout", "(I)V", "itemCount", "getItemCount$foundation_layout", "setItemCount$foundation_layout", "seeMoreMeasurable", "Landroidx/compose/ui/layout/Measurable;", "seeMorePlaceable", "Landroidx/compose/ui/layout/Placeable;", "collapseMeasurable", "collapsePlaceable", "seeMoreSize", "Landroidx/collection/IntIntPair;", "collapseSize", "getOverflowMeasurable", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isExpandable", "noOfItemsShown", "ellipsisSize", "hasNext", "lineIndex", "totalCrossAxisSize", "ellipsisSize-F35zm-w$foundation_layout", "ellipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "ellipsisInfo$foundation_layout", "setOverflowMeasurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "isHorizontal", "constraints", "Landroidx/compose/ui/unit/Constraints;", "setOverflowMeasurables--hBUhpc$foundation_layout", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMeasurable;ZJ)V", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Measurable;J)V", "numberOfItemsShown", "setOverflowMeasurables-VKLhPVY$foundation_layout", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function2;)V", "component1", "component1$foundation_layout", "component2", "component2$foundation_layout", "component3", "component3$foundation_layout", "copy", "equals", "other", "hashCode", "toString", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FlowLayoutOverflowState {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[OverflowType.values().length];
            try {
                v0[OverflowType.Visible.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[OverflowType.Clip.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[OverflowType.ExpandIndicator.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[OverflowType.ExpandOrCollapseIndicator.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private Measurable collapseMeasurable;
    private Placeable collapsePlaceable;
    private IntIntPair collapseSize;
    private Function2 getOverflowMeasurable;
    private int itemCount;
    private int itemShown;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private Measurable seeMoreMeasurable;
    private Placeable seeMorePlaceable;
    private IntIntPair seeMoreSize;
    private final String shownItemLazyErrorMessage;
    private final OverflowType type;

    public static Unit $r8$lambda$-m2ROQiu9rBBdn8cJzD4xOgaBic(FlowLayoutOverflowState arg0, FlowLineMeasurePolicy arg1, Placeable arg2) {
        return FlowLayoutOverflowState.setOverflowMeasurables__hBUhpc$lambda$3$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$VUtDCuPB218Uj3oOp5nD-CrJgyk(FlowLayoutOverflowState arg0, FlowLineMeasurePolicy arg1, Placeable arg2) {
        return FlowLayoutOverflowState.setOverflowMeasurables__hBUhpc$lambda$2$0(arg0, arg1, arg2);
    }

    static {
    }

    public FlowLayoutOverflowState(OverflowType arg1, int arg2, int arg3) {
        super();
        this.type = arg1;
        this.minLinesToShowCollapse = arg2;
        this.minCrossAxisSizeToShowCollapse = arg3;
        this.shownItemLazyErrorMessage = "Accessing shownItemCount before it is set. Are you calling this in the Composition phase, rather than in the draw phase? Consider our samples on how to use it during the draw phase or consider using ContextualFlowRow/ContextualFlowColumn which initializes this method in the composition phase.";
        this.itemShown = -1;
    }

    public final OverflowType component1$foundation_layout() {
        return this.type;
    }

    public final int component2$foundation_layout() {
        return this.minLinesToShowCollapse;
    }

    public final int component3$foundation_layout() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final FlowLayoutOverflowState copy(OverflowType arg1, int arg2, int arg3) {
        return new FlowLayoutOverflowState(arg1, arg2, arg3);
    }

    public static FlowLayoutOverflowState copy$default(FlowLayoutOverflowState arg0, OverflowType arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.type;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.minLinesToShowCollapse;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.minCrossAxisSizeToShowCollapse;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public final WrapEllipsisInfo ellipsisInfo$foundation_layout(boolean arg11, int arg12, int arg13) {
        Object v3;
        Placeable v4;
        Placeable v10;
        IntIntPair v12;
        Measurable v11_2;
        Object v11_1;
        Function2 v11;
        int v0 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        WrapEllipsisInfo v1 = null;
        if(v0 != 1 && v0 != 2) {
            if(v0 != 3) {
                if(v0 == 4) {
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            if(arg11) {
                v11 = this.getOverflowMeasurable;
                if(v11 != null) {
                    v11_1 = v11.invoke(Boolean.valueOf(true), Integer.valueOf(this.getShownItemCount$foundation_layout()));
                    if(v11_1 == null) {
                        goto label_25;
                    }
                }
                else {
                label_25:
                    v11_2 = this.seeMoreMeasurable;
                }

                v12 = this.seeMoreSize;
                if(this.getOverflowMeasurable != null) {
                    goto label_54;
                }

                v10 = this.seeMorePlaceable;
                goto label_51;
            }
            else {
                if(arg12 < this.minLinesToShowCollapse - 1 || arg13 < this.minCrossAxisSizeToShowCollapse) {
                    v11_1 = v1;
                }
                else {
                    v11 = this.getOverflowMeasurable;
                    if(v11 != null) {
                        v11_1 = v11.invoke(Boolean.valueOf(false), Integer.valueOf(this.getShownItemCount$foundation_layout()));
                        if(v11_1 == null) {
                            goto label_44;
                        }

                        goto label_47;
                    }

                label_44:
                    v11_2 = this.collapseMeasurable;
                }

            label_47:
                v12 = this.collapseSize;
                if(this.getOverflowMeasurable == null) {
                    v10 = this.collapsePlaceable;
                label_51:
                    v4 = v10;
                    v3 = v11_2;
                    goto label_56;
                }

            label_54:
                v3 = v11_2;
                v4 = ((Placeable)v1);
            }

        label_56:
            if(v3 == null) {
                return v1;
            }

            Intrinsics.checkNotNull(v12);
            return new WrapEllipsisInfo(((Measurable)v3), v4, v12.unbox-impl(), false, 8, null);
        }

        return v1;
    }

    public final IntIntPair ellipsisSize-F35zm-w$foundation_layout(boolean arg5, int arg6, int arg7) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        IntIntPair v1 = null;
        if(v0 != 1 && v0 != 2) {
            if(v0 == 3) {
                if(!arg5) {
                    return v1;
                }

                return this.seeMoreSize;
            }
            else if(v0 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            else if(arg5) {
                return this.seeMoreSize;
            }
            else {
                if(arg6 + 1 >= this.minLinesToShowCollapse && arg7 >= this.minCrossAxisSizeToShowCollapse) {
                    return this.collapseSize;
                }

                return v1;
            }
        }

        return v1;
    }

    public boolean equals(Object arg5) {
        if(this == (((FlowLayoutOverflowState)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof FlowLayoutOverflowState)) {
            return 0;
        }

        if(this.type != ((FlowLayoutOverflowState)arg5).type) {
            return 0;
        }

        if(this.minLinesToShowCollapse != ((FlowLayoutOverflowState)arg5).minLinesToShowCollapse) {
            return 0;
        }

        if(this.minCrossAxisSizeToShowCollapse != ((FlowLayoutOverflowState)arg5).minCrossAxisSizeToShowCollapse) {
            return 0;
        }

        return 1;
    }

    public final int getItemCount$foundation_layout() {
        return this.itemCount;
    }

    public final int getItemShown$foundation_layout() {
        return this.itemShown;
    }

    public final int getMinCrossAxisSizeToShowCollapse$foundation_layout() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final int getMinLinesToShowCollapse$foundation_layout() {
        return this.minLinesToShowCollapse;
    }

    public final int getShownItemCount$foundation_layout() {
        int v0 = this.itemShown;
        if(v0 != -1) {
            return v0;
        }

        throw new IllegalStateException(this.shownItemLazyErrorMessage);
    }

    public final String getShownItemLazyErrorMessage$foundation_layout() {
        return this.shownItemLazyErrorMessage;
    }

    public final OverflowType getType$foundation_layout() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 0x1F + Integer.hashCode(this.minLinesToShowCollapse)) * 0x1F + Integer.hashCode(this.minCrossAxisSizeToShowCollapse);
    }

    public final void setItemCount$foundation_layout(int arg1) {
        this.itemCount = arg1;
    }

    public final void setItemShown$foundation_layout(int arg1) {
        this.itemShown = arg1;
    }

    public final void setOverflowMeasurables--hBUhpc$foundation_layout(FlowLineMeasurePolicy arg10, Measurable arg11, Measurable arg12, long arg13) {
        LayoutOrientation v0 = arg10.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
        arg13 = OrientationIndependentConstraints.toBoxConstraints-OenEA2s(OrientationIndependentConstraints.copy-yUG9Ft0$default(OrientationIndependentConstraints.constructor-impl(arg13, v0), 0, 0, 0, 0, 10, null), v0);
        if(arg11 != null) {
            FlowLayoutKt.measureAndCache-rqJ1uqs(arg11, arg10, arg13, new FlowLayoutOverflowState$$ExternalSyntheticLambda0(this, arg10));
            this.seeMoreMeasurable = arg11;
        }

        if(arg12 != null) {
            FlowLayoutKt.measureAndCache-rqJ1uqs(arg12, arg10, arg13, new FlowLayoutOverflowState$$ExternalSyntheticLambda1(this, arg10));
            this.collapseMeasurable = arg12;
        }
    }

    public final void setOverflowMeasurables--hBUhpc$foundation_layout(IntrinsicMeasurable arg4, IntrinsicMeasurable arg5, boolean arg6, long arg7) {
        Measurable v5;
        Measurable v4;
        LayoutOrientation v0 = arg6 ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
        arg7 = OrientationIndependentConstraints.constructor-impl(arg7, v0);
        Placeable v0_1 = null;
        if(arg4 != null) {
            int v1 = FlowLayoutKt.mainAxisMin(arg4, arg6, Constraints.getMaxHeight-impl(arg7));
            this.seeMoreSize = IntIntPair.box-impl(IntIntPair.constructor-impl(v1, FlowLayoutKt.crossAxisMin(arg4, arg6, v1)));
            if((arg4 instanceof Measurable)) {
            }
            else {
                v4 = ((Measurable)v0_1);
            }

            this.seeMoreMeasurable = v4;
            this.seeMorePlaceable = v0_1;
        }

        if(arg5 != null) {
            int v4_1 = FlowLayoutKt.mainAxisMin(arg5, arg6, Constraints.getMaxHeight-impl(arg7));
            this.collapseSize = IntIntPair.box-impl(IntIntPair.constructor-impl(v4_1, FlowLayoutKt.crossAxisMin(arg5, arg6, v4_1)));
            if((arg5 instanceof Measurable)) {
            }
            else {
                v5 = ((Measurable)v0_1);
            }

            this.collapseMeasurable = v5;
            this.collapsePlaceable = v0_1;
        }
    }

    public final void setOverflowMeasurables-VKLhPVY$foundation_layout(FlowLineMeasurePolicy arg10, long arg11, Function2 arg13) {
        Integer v1 = Integer.valueOf(0);
        this.itemShown = 0;
        this.getOverflowMeasurable = arg13;
        this.setOverflowMeasurables--hBUhpc$foundation_layout(arg10, arg13.invoke(Boolean.valueOf(true), v1), arg13.invoke(Boolean.valueOf(false), v1), arg11);
    }

    private static final Unit setOverflowMeasurables__hBUhpc$lambda$2$0(FlowLayoutOverflowState arg2, FlowLineMeasurePolicy arg3, Placeable arg4) {
        int v3;
        int v0;
        if(arg4 != null) {
            v0 = arg3.mainAxisSize(arg4);
            v3 = arg3.crossAxisSize(arg4);
        }
        else {
            v0 = 0;
            v3 = 0;
        }

        arg2.seeMoreSize = IntIntPair.box-impl(IntIntPair.constructor-impl(v0, v3));
        arg2.seeMorePlaceable = arg4;
        return Unit.INSTANCE;
    }

    private static final Unit setOverflowMeasurables__hBUhpc$lambda$3$0(FlowLayoutOverflowState arg2, FlowLineMeasurePolicy arg3, Placeable arg4) {
        int v3;
        int v0;
        if(arg4 != null) {
            v0 = arg3.mainAxisSize(arg4);
            v3 = arg3.crossAxisSize(arg4);
        }
        else {
            v0 = 0;
            v3 = 0;
        }

        arg2.collapseSize = IntIntPair.box-impl(IntIntPair.constructor-impl(v0, v3));
        arg2.collapsePlaceable = arg4;
        return Unit.INSTANCE;
    }

    public String toString() {
        return "FlowLayoutOverflowState(type=" + this.type + ", minLinesToShowCollapse=" + this.minLinesToShowCollapse + ", minCrossAxisSizeToShowCollapse=" + this.minCrossAxisSizeToShowCollapse + ')';
    }
}

