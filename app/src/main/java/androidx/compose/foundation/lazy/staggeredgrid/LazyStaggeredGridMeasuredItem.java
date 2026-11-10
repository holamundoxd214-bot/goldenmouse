package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bu\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u0004\u0012\u0006\u0010\r\u001A\u00020\u0004\u0012\u0006\u0010\u000E\u001A\u00020\u0004\u0012\u0006\u0010\u000F\u001A\u00020\u0004\u0012\u0006\u0010\u0010\u001A\u00020\u0004\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0006\u0012\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00000\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010(\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001A\u00020\u0004H\u0016J\u0017\u0010<\u001A\u0002092\u0006\u0010\u0003\u001A\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010>J\u001E\u0010?\u001A\u00020@2\u0006\u0010A\u001A\u00020\u00042\u0006\u0010B\u001A\u00020\u00042\u0006\u0010/\u001A\u00020\u0004J(\u0010?\u001A\u00020@2\u0006\u0010C\u001A\u00020\u00042\u0006\u0010D\u001A\u00020\u00042\u0006\u0010E\u001A\u00020\u00042\u0006\u0010F\u001A\u00020\u0004H\u0016J\u001E\u0010H\u001A\u00020@2\u0006\u0010I\u001A\u00020J2\u0006\u0010K\u001A\u00020L2\u0006\u0010M\u001A\u00020\u000BJ\u000E\u0010N\u001A\u00020@2\u0006\u0010/\u001A\u00020\u0004J\u0016\u0010O\u001A\u00020@2\u0006\u0010P\u001A\u00020\u00042\u0006\u0010Q\u001A\u00020\u000BJ(\u0010U\u001A\u000209*\u0002092\u0012\u0010V\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040WH\u0082\b¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001A\u00020[H\u0016R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u001CR\u0014\u0010\r\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0019R\u0014\u0010\u000E\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0019R\u000E\u0010\u000F\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001A\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u001BR\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00000\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001A\u00020\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001A\u0004\b \u0010!R\u001A\u0010#\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u001C\"\u0004\b$\u0010%R\u0014\u0010&\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010\u0019R\u0011\u0010)\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b*\u0010\u0019R\u0014\u0010+\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b,\u0010\u0019R\u0011\u0010-\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b.\u0010\u0019R\u000E\u0010/\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00100\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00101\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u00102\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u0010\u001C\"\u0004\b4\u0010%R\u0016\u00105\u001A\u000206X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001A\u0004\b7\u0010!R \u0010:\u001A\u0002092\u0006\u00108\u001A\u000209@RX\u0096\u000E¢\u0006\n\n\u0002\u0010\"\u001A\u0004\b;\u0010!R\u0011\u0010C\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\bG\u0010\u0019R\u0018\u0010A\u001A\u00020\u0004*\u0002098BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bR\u0010SR\u0019\u0010)\u001A\u00020\u0004*\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b*\u0010T¨\u0006\\"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "()Z", "getLane", "getSpan", "getContentType", "getConstraints-msEJaDk", "()J", "J", "isVisible", "setVisible", "(Z)V", "placeablesCount", "getPlaceablesCount", "getParentData", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "value", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "getOffset", "getOffset-Bjo55l4", "(I)J", "position", "", "mainAxis", "crossAxis", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "getMainAxisOffset", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "isLookingAhead", "updateMainAxisLayoutSize", "applyScrollDelta", "delta", "updateAnimations", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridMeasuredItem implements LazyLayoutMeasuredItem, LazyStaggeredGridItemInfo {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List placeables;
    private final long size;
    private final int span;

    static {
    }

    private LazyStaggeredGridMeasuredItem(int arg1, Object arg2, List arg3, boolean arg4, int arg5, int arg6, int arg7, int arg8, int arg9, Object arg10, LazyLayoutItemAnimator arg11, long arg12) {
        int v3_1;
        int v2;
        super();
        this.index = arg1;
        this.key = arg2;
        this.placeables = arg3;
        this.isVertical = arg4;
        this.lane = arg6;
        this.span = arg7;
        this.beforeContentPadding = arg8;
        this.afterContentPadding = arg9;
        this.contentType = arg10;
        this.animator = arg11;
        this.constraints = arg12;
        arg1 = 1;
        this.isVisible = true;
        int v4 = 0;
        if(arg3.isEmpty()) {
            v2 = 0;
        }
        else {
            arg2 = arg3.get(0);
            v2 = this.isVertical() ? ((Placeable)arg2).getHeight() : ((Placeable)arg2).getWidth();
            arg6 = CollectionsKt.getLastIndex(arg3);
            if(1 > arg6) {
                goto label_39;
            }

            for(arg7 = 1; true; ++arg7) {
                Object v8 = arg3.get(arg7);
                arg8 = this.isVertical() ? ((Placeable)v8).getHeight() : ((Placeable)v8).getWidth();
                if(arg8 > v2) {
                    v2 = arg8;
                }

                if(arg7 == arg6) {
                    break;
                }
            }
        }

    label_39:
        this.mainAxisSize = v2;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(v2 + arg5, 0);
        List v2_1 = this.placeables;
        if(v2_1.isEmpty()) {
        }
        else {
            Object v3 = v2_1.get(0);
            v3_1 = this.isVertical() ? ((Placeable)v3).getWidth() : ((Placeable)v3).getHeight();
            v4 = CollectionsKt.getLastIndex(v2_1);
            if(1 <= v4) {
                while(true) {
                    Object v5 = v2_1.get(arg1);
                    arg5 = this.isVertical() ? ((Placeable)v5).getWidth() : ((Placeable)v5).getHeight();
                    if(arg5 > v3_1) {
                        v3_1 = arg5;
                    }

                    if(arg1 == v4) {
                        break;
                    }

                    ++arg1;
                }
            }

            v4 = v3_1;
        }

        this.crossAxisSize = v4;
        this.mainAxisLayoutSize = 0x80000000;
        boolean v1 = this.isVertical();
        v2 = this.mainAxisSize;
        long v5_1 = 0xFFFFFFFFL;
        v3_1 = 0x20;
        long v1_1 = v1 ? IntSize.constructor-impl((((long)v2)) & v5_1 | (((long)v4)) << v3_1) : IntSize.constructor-impl((((long)v2)) << v3_1 | (((long)v4)) & v5_1);
        this.size = v1_1;
        this.offset = IntOffset.Companion.getZero-nOcc-ac();
    }

    public LazyStaggeredGridMeasuredItem(int arg1, Object arg2, List arg3, boolean arg4, int arg5, int arg6, int arg7, int arg8, int arg9, Object arg10, LazyLayoutItemAnimator arg11, long arg12, DefaultConstructorMarker arg14) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
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

    public final int getMainAxisOffset() {
        if(!this.isVertical()) {
            return IntOffset.getX-impl(this.getOffset-nOcc-ac());
        }

        return IntOffset.getY-impl(this.getOffset-nOcc-ac());
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    private final int getMainAxisSize(Placeable arg1) {
        if(this.isVertical()) {
            return arg1.getHeight();
        }

        return arg1.getWidth();
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

    public long getSize-YbymL2g() {
        return this.size;
    }

    public int getSpan() {
        return this.span;
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void place(PlacementScope arg14, LazyStaggeredGridMeasureContext arg15, boolean arg16) {
        int v7;
        GraphicsLayer v3_1;
        int v2 = 0;
        int v0 = this.mainAxisLayoutSize != 0x80000000 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
        }

        List v0_1 = this.placeables;
        int v1 = v0_1.size();
        while(v2 < v1) {
            Object v5 = v0_1.get(v2);
            int v3 = this.minMainAxisOffset;
            int v4 = this.isVertical() ? ((Placeable)v5).getHeight() : ((Placeable)v5).getWidth();
            v3 -= v4;
            v4 = this.maxMainAxisOffset;
            long v6 = this.getOffset-nOcc-ac();
            LazyLayoutItemAnimation v8 = this.animator.getAnimation(this.getKey(), v2);
            if(v8 != null) {
                if(arg16) {
                    v8.setLookaheadOffset--gyyYBs(v6);
                }
                else {
                    long v9 = !IntOffset.equals-impl0(v8.getLookaheadOffset-nOcc-ac(), LazyLayoutItemAnimation.Companion.getNotInitialized-nOcc-ac()) ? v8.getLookaheadOffset-nOcc-ac() : v6;
                    v9 = IntOffset.plus-qkQi6aY(v9, v8.getPlacementDelta-nOcc-ac());
                    if(this.getMainAxis--gyyYBs(v6) <= v3 && this.getMainAxis--gyyYBs(v9) <= v3 || this.getMainAxis--gyyYBs(v6) >= v4 && this.getMainAxis--gyyYBs(v9) >= v4) {
                        v8.cancelPlacementAnimation();
                    }

                    v6 = v9;
                }

                v3_1 = v8.getLayer();
            }
            else {
                v3_1 = null;
            }

            if(arg15.getReverseLayout()) {
                if(this.isVertical()) {
                    v4 = IntOffset.getX-impl(v6);
                }
                else {
                    int v9_1 = this.mainAxisLayoutSize - IntOffset.getX-impl(v6);
                    v4 = this.isVertical() ? ((Placeable)v5).getHeight() : ((Placeable)v5).getWidth();
                    v4 = v9_1 - v4;
                }

                if(this.isVertical()) {
                    v7 = this.mainAxisLayoutSize - IntOffset.getY-impl(v6);
                    int v6_1 = this.isVertical() ? ((Placeable)v5).getHeight() : ((Placeable)v5).getWidth();
                    v7 -= v6_1;
                }
                else {
                    v7 = IntOffset.getY-impl(v6);
                }

                v6 = IntOffset.constructor-impl((((long)v7)) & 0xFFFFFFFFL | (((long)v4)) << 0x20);
            }

            v6 = IntOffset.plus-qkQi6aY(v6, arg15.getContentOffset-nOcc-ac());
            if(!arg16 && v8 != null) {
                v8.setFinalOffset--gyyYBs(v6);
            }

            if(v3_1 != null) {
                PlacementScope.placeRelativeWithLayer-aW-9-wM$default(arg14, ((Placeable)v5), v6, v3_1, 0f, 4, null);
            }
            else {
                PlacementScope.placeRelativeWithLayer-aW-9-wM$default(arg14, ((Placeable)v5), v6, 0f, null, 6, null);
            }

            ++v2;
        }
    }

    public final void position(int arg6, int arg7, int arg8) {
        this.mainAxisLayoutSize = arg8;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = arg8 + this.afterContentPadding;
        long v0 = 0xFFFFFFFFL;
        int v2 = 0x20;
        long v6 = this.isVertical() ? IntOffset.constructor-impl((((long)arg7)) << v2 | v0 & (((long)arg6))) : IntOffset.constructor-impl((((long)arg7)) & v0 | (((long)arg6)) << v2);
        this.offset = v6;
    }

    public void position(int arg2, int arg3, int arg4, int arg5) {
        if(this.isVertical()) {
            arg4 = arg5;
        }

        this.position(arg2, arg3, arg4);
    }

    public void setNonScrollableItem(boolean arg1) {
        this.nonScrollableItem = arg1;
    }

    public final void setVisible(boolean arg1) {
        this.isVisible = arg1;
    }

    public String toString() {
        return super.toString();
    }

    public final void updateMainAxisLayoutSize(int arg2) {
        this.mainAxisLayoutSize = arg2;
        this.maxMainAxisOffset = arg2 + this.afterContentPadding;
    }
}

