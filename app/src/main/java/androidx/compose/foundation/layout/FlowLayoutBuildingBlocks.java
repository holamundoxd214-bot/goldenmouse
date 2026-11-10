package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0002#$B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\fJ8\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0003JW\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\u00032\u0006\u0010\u001F\u001A\u00020\u00132\u0006\u0010 \u001A\u00020\u0013¢\u0006\u0004\b!\u0010\"R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000E\u0010\b\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks;", "", "maxItemsInMainAxis", "", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "maxLines", "mainAxisSpacing", "crossAxisSpacing", "<init>", "(ILandroidx/compose/foundation/layout/FlowLayoutOverflowState;JIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getWrapEllipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "wrapInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "hasNext", "", "lastContentLineIndex", "totalCrossAxisSize", "leftOverMainAxis", "nextIndexInLine", "getWrapInfo", "nextItemHasNext", "leftOver", "Landroidx/collection/IntIntPair;", "nextSize", "lineIndex", "currentLineCrossAxisSize", "isWrappingRound", "isEllipsisWrap", "getWrapInfo-OpUlnko", "(ZIJLandroidx/collection/IntIntPair;IIIZZ)Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "WrapInfo", "WrapEllipsisInfo", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FlowLayoutBuildingBlocks {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "", "ellipsis", "Landroidx/compose/ui/layout/Measurable;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "ellipsisSize", "Landroidx/collection/IntIntPair;", "placeEllipsisOnLastContentLine", "", "<init>", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Placeable;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEllipsis", "()Landroidx/compose/ui/layout/Measurable;", "getPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "getEllipsisSize-OO21N7I", "()J", "J", "getPlaceEllipsisOnLastContentLine", "()Z", "setPlaceEllipsisOnLastContentLine", "(Z)V", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WrapEllipsisInfo {
        public static final int $stable = 8;
        private final Measurable ellipsis;
        private final long ellipsisSize;
        private boolean placeEllipsisOnLastContentLine;
        private final Placeable placeable;

        static {
        }

        private WrapEllipsisInfo(Measurable arg1, Placeable arg2, long arg3, boolean arg5) {
            super();
            this.ellipsis = arg1;
            this.placeable = arg2;
            this.ellipsisSize = arg3;
            this.placeEllipsisOnLastContentLine = arg5;
        }

        public WrapEllipsisInfo(Measurable arg8, Placeable arg9, long arg10, boolean arg12, int arg13, DefaultConstructorMarker arg14) {
            this(arg8, arg9, arg10, true, null);
        }

        public WrapEllipsisInfo(Measurable arg1, Placeable arg2, long arg3, boolean arg5, DefaultConstructorMarker arg6) {
            this(arg1, arg2, arg3, arg5);
        }

        public final Measurable getEllipsis() {
            return this.ellipsis;
        }

        public final long getEllipsisSize-OO21N7I() {
            return this.ellipsisSize;
        }

        public final boolean getPlaceEllipsisOnLastContentLine() {
            return this.placeEllipsisOnLastContentLine;
        }

        public final Placeable getPlaceable() {
            return this.placeable;
        }

        public final void setPlaceEllipsisOnLastContentLine(boolean arg1) {
            this.placeEllipsisOnLastContentLine = arg1;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "", "isLastItemInLine", "", "isLastItemInContainer", "<init>", "(ZZ)V", "()Z", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WrapInfo {
        public static final int $stable;
        private final boolean isLastItemInContainer;
        private final boolean isLastItemInLine;

        static {
        }

        public WrapInfo(boolean arg1, boolean arg2) {
            super();
            this.isLastItemInLine = arg1;
            this.isLastItemInContainer = arg2;
        }

        public WrapInfo() {
            this(false, false, 3, null);
        }

        public WrapInfo(boolean arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
            this(false, false);
        }

        public final boolean isLastItemInContainer() {
            return this.isLastItemInContainer;
        }

        public final boolean isLastItemInLine() {
            return this.isLastItemInLine;
        }
    }

    public static final int $stable = 8;
    private final long constraints;
    private final int crossAxisSpacing;
    private final int mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;

    static {
    }

    private FlowLayoutBuildingBlocks(int arg1, FlowLayoutOverflowState arg2, long arg3, int arg5, int arg6, int arg7) {
        super();
        this.maxItemsInMainAxis = arg1;
        this.overflow = arg2;
        this.constraints = arg3;
        this.maxLines = arg5;
        this.mainAxisSpacing = arg6;
        this.crossAxisSpacing = arg7;
    }

    public FlowLayoutBuildingBlocks(int arg1, FlowLayoutOverflowState arg2, long arg3, int arg5, int arg6, int arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg5, arg6, arg7);
    }

    public final WrapEllipsisInfo getWrapEllipsisInfo(WrapInfo arg2, boolean arg3, int arg4, int arg5, int arg6, int arg7) {
        boolean v1;
        WrapEllipsisInfo v0 = null;
        if(!arg2.isLastItemInContainer()) {
            return v0;
        }

        WrapEllipsisInfo v2 = this.overflow.ellipsisInfo$foundation_layout(arg3, arg4, arg5);
        if(v2 == null) {
            return v0;
        }

        if(arg4 >= 0) {
            if(arg7 != 0) {
                if(arg6 - IntIntPair.getFirst-impl(v2.getEllipsisSize-OO21N7I()) < 0) {
                }
                else if(arg7 < this.maxItemsInMainAxis) {
                    goto label_16;
                }

                goto label_18;
            }

        label_16:
            v1 = true;
        }
        else {
        label_18:
            v1 = false;
        }

        v2.setPlaceEllipsisOnLastContentLine(v1);
        return v2;
    }

    public final WrapInfo getWrapInfo-OpUlnko(boolean arg13, int arg14, long arg15, IntIntPair arg17, int arg18, int arg19, int arg20, boolean arg21, boolean arg22) {
        int v0 = arg18;
        int v1 = arg20;
        int v7 = arg19 + v1;
        if(arg17 == null) {
            return new WrapInfo(true, true);
        }

        if(this.overflow.getType$foundation_layout() == OverflowType.Visible) {
        }
        else {
            if(v0 >= this.maxLines) {
            }
            else {
                if(IntIntPair.getSecond-impl(arg15) - IntIntPair.getSecond-impl(arg17.unbox-impl()) < 0) {
                    goto label_21;
                }

                goto label_24;
            }

        label_21:
            return new WrapInfo(true, true);
        }

    label_24:
        if(arg14 == 0) {
        }
        else {
            if(arg14 >= this.maxItemsInMainAxis) {
            }
            else {
                if(IntIntPair.getFirst-impl(arg15) - IntIntPair.getFirst-impl(arg17.unbox-impl()) < 0) {
                    goto label_34;
                }

                goto label_65;
            }

        label_34:
            if(arg21) {
                return new WrapInfo(true, true);
            }

            return new WrapInfo(true, this.getWrapInfo-OpUlnko(arg13, 0, IntIntPair.constructor-impl(Constraints.getMaxWidth-impl(this.constraints), IntIntPair.getSecond-impl(arg15) - this.crossAxisSpacing - v1), IntIntPair.box-impl(IntIntPair.constructor-impl(IntIntPair.getFirst-impl(arg17.unbox-impl()) - this.mainAxisSpacing, IntIntPair.getSecond-impl(arg17.unbox-impl()))), v0 + 1, v7, 0, true, false).isLastItemInContainer());
        }

    label_65:
        v7 = arg19 + Math.max(v1, IntIntPair.getSecond-impl(arg17.unbox-impl()));
        IntIntPair v13 = arg22 ? null : this.overflow.ellipsisSize-F35zm-w$foundation_layout(arg13, v0, v7);
        IntIntPair v5 = v13;
        if(v5 != null) {
            v5.unbox-impl();
            if(arg14 + 1 >= this.maxItemsInMainAxis) {
            }
            else {
                if(IntIntPair.getFirst-impl(arg15) - IntIntPair.getFirst-impl(arg17.unbox-impl()) - this.mainAxisSpacing - IntIntPair.getFirst-impl(v5.unbox-impl()) < 0) {
                    goto label_91;
                }

                goto label_118;
            }

        label_91:
            if(arg22) {
                return new WrapInfo(true, true);
            }

            WrapInfo v12 = this.getWrapInfo-OpUlnko(false, 0, IntIntPair.constructor-impl(Constraints.getMaxWidth-impl(this.constraints), IntIntPair.getSecond-impl(arg15) - this.crossAxisSpacing - Math.max(v1, IntIntPair.getSecond-impl(arg17.unbox-impl()))), v5, v0 + 1, v7, 0, true, true);
            return new WrapInfo(v12.isLastItemInContainer(), v12.isLastItemInContainer());
        }

    label_118:
        return new WrapInfo(false, false);
    }
}

