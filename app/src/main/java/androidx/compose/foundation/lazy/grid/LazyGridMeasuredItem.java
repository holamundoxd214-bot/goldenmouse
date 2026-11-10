package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0095\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\u0004\u0012\u0006\u0010\n\u001A\u00020\u0004\u0012\u0006\u0010\u000B\u001A\u00020\b\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u0004\u0012\u0006\u0010\u000F\u001A\u00020\u0004\u0012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\b\u0010\u0015\u001A\u0004\u0018\u00010\u0006\u0012\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00000\u0017\u0012\u0006\u0010\u0018\u001A\u00020\u0019\u0012\u0006\u0010\u001A\u001A\u00020\u0004\u0012\u0006\u0010\u001B\u001A\u00020\u0004¢\u0006\u0004\b\u001C\u0010\u001DJ\u0012\u00103\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001A\u00020\u0004H\u0016J\u0017\u0010>\u001A\u00020\u00142\u0006\u0010\u0003\u001A\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010@J(\u0010E\u001A\u00020F2\u0006\u0010G\u001A\u00020\u00042\u0006\u0010H\u001A\u00020\u00042\u0006\u0010I\u001A\u00020\u00042\u0006\u0010J\u001A\u00020\u0004H\u0016J6\u0010E\u001A\u00020F2\u0006\u0010G\u001A\u00020\u00042\u0006\u0010H\u001A\u00020\u00042\u0006\u0010I\u001A\u00020\u00042\u0006\u0010J\u001A\u00020\u00042\u0006\u0010:\u001A\u00020\u00042\u0006\u0010<\u001A\u00020\u0004J\u000E\u0010K\u001A\u00020F2\u0006\u00100\u001A\u00020\u0004J\u0016\u0010L\u001A\u00020F2\u0006\u0010M\u001A\u00020\u00042\u0006\u0010N\u001A\u00020\bJ\u0016\u0010O\u001A\u00020F2\u0006\u0010P\u001A\u00020Q2\u0006\u0010R\u001A\u00020\bJ(\u0010W\u001A\u00020\u0014*\u00020\u00142\u0012\u0010X\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040YH\u0082\b¢\u0006\u0004\bZ\u0010[R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\"R\u0011\u0010\t\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u001FR\u000E\u0010\u000B\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0016\u0010\u0015\u001A\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b%\u0010!R\u0014\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00000\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001A\u00020\u0019X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001A\u0004\b&\u0010\'R\u0014\u0010\u001A\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\u001FR\u0014\u0010\u001B\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b)\u0010\u001FR\u0011\u0010*\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b+\u0010\u001FR\u0014\u0010,\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b-\u0010\u001FR\u0014\u0010.\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b/\u0010\u001FR\u000E\u00100\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00101\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00102\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u00104\u001A\u000205X\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001A\u0004\b6\u0010\'R \u00108\u001A\u00020\u00142\u0006\u00107\u001A\u00020\u0014@RX\u0096\u000E¢\u0006\n\n\u0002\u0010$\u001A\u0004\b9\u0010\'R\u001E\u0010:\u001A\u00020\u00042\u0006\u00107\u001A\u00020\u0004@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b;\u0010\u001FR\u001E\u0010<\u001A\u00020\u00042\u0006\u00107\u001A\u00020\u0004@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b=\u0010\u001FR\u001A\u0010A\u001A\u00020\bX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bB\u0010\"\"\u0004\bC\u0010DR\u0018\u0010S\u001A\u00020\u0004*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bT\u0010UR\u0018\u0010*\u001A\u00020\u0004*\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b+\u0010V¨\u0006\\"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "isVertical", "", "crossAxisSize", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lane", "span", "<init>", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "()Z", "getCrossAxisSize", "J", "getContentType", "getConstraints-msEJaDk", "()J", "getLane", "getSpan", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "placeablesCount", "getPlaceablesCount", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "getParentData", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "value", "offset", "getOffset-nOcc-ac", "row", "getRow", "column", "getColumn", "getOffset", "getOffset-Bjo55l4", "(I)J", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "position", "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "updateMainAxisLayoutSize", "applyScrollDelta", "delta", "updateAnimations", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridMeasuredItem implements LazyGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator animator;
    private final int beforeContentPadding;
    private int column;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final int span;
    private final long visualOffset;

    static {
    }

    private LazyGridMeasuredItem(int arg3, Object arg4, boolean arg5, int arg6, int arg7, boolean arg8, LayoutDirection arg9, int arg10, int arg11, List arg12, long arg13, Object arg15, LazyLayoutItemAnimator arg16, long arg17, int arg19, int arg20) {
        super();
        this.index = arg3;
        this.key = arg4;
        this.isVertical = arg5;
        this.crossAxisSize = arg6;
        this.reverseLayout = arg8;
        this.layoutDirection = arg9;
        this.beforeContentPadding = arg10;
        this.afterContentPadding = arg11;
        this.placeables = arg12;
        this.visualOffset = arg13;
        this.contentType = arg15;
        this.animator = arg16;
        this.constraints = arg17;
        this.lane = arg19;
        this.span = arg20;
        this.mainAxisLayoutSize = 0x80000000;
        arg3 = arg12.size();
        int v5 = 0;
        arg6 = 0;
        while(v5 < arg3) {
            Object v8 = arg12.get(v5);
            int v8_1 = this.isVertical() ? ((Placeable)v8).getHeight() : ((Placeable)v8).getWidth();
            arg6 = Math.max(arg6, v8_1);
            ++v5;
        }

        this.mainAxisSize = arg6;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(arg7 + arg6, 0);
        boolean v3 = this.isVertical();
        int v4 = this.crossAxisSize;
        long v7 = 0xFFFFFFFFL;
        v5 = 0x20;
        long v3_1 = v3 ? IntSize.constructor-impl((((long)v4)) << v5 | (((long)arg6)) & v7) : IntSize.constructor-impl((((long)v4)) & v7 | (((long)arg6)) << v5);
        this.size = v3_1;
        this.offset = IntOffset.Companion.getZero-nOcc-ac();
        this.row = -1;
        this.column = -1;
    }

    public LazyGridMeasuredItem(int arg1, Object arg2, boolean arg3, int arg4, int arg5, boolean arg6, LayoutDirection arg7, int arg8, int arg9, List arg10, long arg11, Object arg13, LazyLayoutItemAnimator arg14, long arg15, int arg17, int arg18, DefaultConstructorMarker arg19) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg13, arg14, arg15, arg17, arg18);
    }

    public final void applyScrollDelta(int arg11, boolean arg12) {
        if(this.getNonScrollableItem()) {
        }
        else {
            long v0 = this.getOffset-nOcc-ac();
            int v2 = this.isVertical() ? IntOffset.getX-impl(v0) : IntOffset.getX-impl(v0) + arg11;
            boolean v3 = this.isVertical();
            int v0_1 = IntOffset.getY-impl(v0);
            if(v3) {
                v0_1 += arg11;
            }

            int v3_1 = 0x20;
            long v6 = 0xFFFFFFFFL;
            this.offset = IntOffset.constructor-impl((((long)v2)) << v3_1 | (((long)v0_1)) & v6);
            if(!arg12) {
                return;
            }

            int v12 = this.getPlaceablesCount();
            for(v0_1 = 0; v0_1 < v12; ++v0_1) {
                LazyLayoutItemAnimation v1 = this.animator.getAnimation(this.getKey(), v0_1);
                if(v1 != null) {
                    long v4 = v1.getRawOffset-nOcc-ac();
                    v2 = this.isVertical() ? IntOffset.getX-impl(v4) : Integer.valueOf(IntOffset.getX-impl(v4) + arg11).intValue();
                    boolean v8 = this.isVertical();
                    int v4_1 = IntOffset.getY-impl(v4);
                    if(v8) {
                        v4_1 = Integer.valueOf(v4_1 + arg11).intValue();
                    }

                    v1.setRawOffset--gyyYBs(IntOffset.constructor-impl((((long)v4_1)) & v6 | (((long)v2)) << v3_1));
                }
            }
        }
    }

    private final long copy-4Tuh3kE(long arg5, Function1 arg7) {
        int v0 = this.isVertical() ? IntOffset.getX-impl(arg5) : arg7.invoke(Integer.valueOf(IntOffset.getX-impl(arg5))).intValue();
        int v4 = this.isVertical() ? arg7.invoke(Integer.valueOf(IntOffset.getY-impl(arg5))).intValue() : IntOffset.getY-impl(arg5);
        return IntOffset.constructor-impl((((long)v0)) << 0x20 | (((long)v4)) & 0xFFFFFFFFL);
    }

    public int getColumn() {
        return this.column;
    }

    public long getConstraints-msEJaDk() {
        return this.constraints;
    }

    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public int getLane() {
        return this.lane;
    }

    private final int getMainAxis--gyyYBs(long arg1) {
        if(this.isVertical()) {
            return IntOffset.getY-impl(arg1);
        }

        return IntOffset.getX-impl(arg1);
    }

    private final int getMainAxisSize(Placeable arg1) {
        if(this.isVertical()) {
            return arg1.getHeight();
        }

        return arg1.getWidth();
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    public long getOffset-Bjo55l4(int arg1) {
        return this.getOffset-nOcc-ac();
    }

    public long getOffset-nOcc-ac() {
        return this.offset;
    }

    public Object getParentData(int arg1) {
        return this.placeables.get(arg1).getParentData();
    }

    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    public int getRow() {
        return this.row;
    }

    public long getSize-YbymL2g() {
        return this.size;
    }

    public int getSpan() {
        return this.span;
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    public final void place(PlacementScope arg13, boolean arg14) {
        PlacementScope v3_1;
        GraphicsLayer v1_1;
        int v2 = 0;
        int v0 = this.mainAxisLayoutSize != 0x80000000 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
        }

        v0 = this.getPlaceablesCount();
        while(v2 < v0) {
            Object v4 = this.placeables.get(v2);
            int v1 = this.minMainAxisOffset - this.getMainAxisSize(((Placeable)v4));
            int v3 = this.maxMainAxisOffset;
            long v5 = this.getOffset-nOcc-ac();
            LazyLayoutItemAnimation v7 = this.animator.getAnimation(this.getKey(), v2);
            if(v7 != null) {
                if(arg14) {
                    v7.setLookaheadOffset--gyyYBs(v5);
                }
                else {
                    long v8 = !IntOffset.equals-impl0(v7.getLookaheadOffset-nOcc-ac(), LazyLayoutItemAnimation.Companion.getNotInitialized-nOcc-ac()) ? v7.getLookaheadOffset-nOcc-ac() : v5;
                    v8 = IntOffset.plus-qkQi6aY(v8, v7.getPlacementDelta-nOcc-ac());
                    if(this.getMainAxis--gyyYBs(v5) <= v1 && this.getMainAxis--gyyYBs(v8) <= v1 || this.getMainAxis--gyyYBs(v5) >= v3 && this.getMainAxis--gyyYBs(v8) >= v3) {
                        v7.cancelPlacementAnimation();
                    }

                    v5 = v8;
                }

                v1_1 = v7.getLayer();
            }
            else {
                v1_1 = null;
            }

            if(this.reverseLayout) {
                v3 = this.isVertical() ? IntOffset.getX-impl(v5) : this.mainAxisLayoutSize - IntOffset.getX-impl(v5) - this.getMainAxisSize(((Placeable)v4));
                int v6 = this.isVertical() ? this.mainAxisLayoutSize - IntOffset.getY-impl(v5) - this.getMainAxisSize(((Placeable)v4)) : IntOffset.getY-impl(v5);
                v5 = IntOffset.constructor-impl((((long)v6)) & 0xFFFFFFFFL | (((long)v3)) << 0x20);
            }

            v5 = IntOffset.plus-qkQi6aY(v5, this.visualOffset);
            if(!arg14 && v7 != null) {
                v7.setFinalOffset--gyyYBs(v5);
            }

            if(!this.isVertical()) {
                v3_1 = arg13;
                GraphicsLayer v7_1 = v1_1;
                if(v7_1 != null) {
                    PlacementScope.placeRelativeWithLayer-aW-9-wM$default(v3_1, ((Placeable)v4), v5, v7_1, 0f, 4, null);
                }
                else {
                    PlacementScope.placeRelativeWithLayer-aW-9-wM$default(v3_1, ((Placeable)v4), v5, 0f, null, 6, null);
                }
            }
            else if(v1_1 != null) {
                v3_1 = arg13;
                PlacementScope.placeWithLayer-aW-9-wM$default(v3_1, ((Placeable)v4), v5, v1_1, 0f, 4, null);
            }
            else {
                v3_1 = arg13;
                PlacementScope.placeWithLayer-aW-9-wM$default(v3_1, ((Placeable)v4), v5, 0f, null, 6, null);
            }

            ++v2;
            arg13 = v3_1;
        }
    }

    public void position(int arg8, int arg9, int arg10, int arg11) {
        this.position(arg8, arg9, arg10, arg11, -1, -1);
    }

    public final void position(int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
        int v0 = this.isVertical() ? arg8 : arg7;
        this.mainAxisLayoutSize = v0;
        if(this.isVertical()) {
        }
        else {
            arg7 = arg8;
        }

        if((this.isVertical()) && this.layoutDirection == LayoutDirection.Rtl) {
            arg6 = arg7 - arg6 - this.crossAxisSize;
        }

        long v0_1 = 0xFFFFFFFFL;
        arg8 = 0x20;
        long v5 = this.isVertical() ? IntOffset.constructor-impl((((long)arg6)) << arg8 | v0_1 & (((long)arg5))) : IntOffset.constructor-impl((((long)arg6)) & v0_1 | (((long)arg5)) << arg8);
        this.offset = v5;
        this.row = arg9;
        this.column = arg10;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public void setNonScrollableItem(boolean arg1) {
        this.nonScrollableItem = arg1;
    }

    public final void updateMainAxisLayoutSize(int arg2) {
        this.mainAxisLayoutSize = arg2;
        this.maxMainAxisOffset = arg2 + this.afterContentPadding;
    }
}

