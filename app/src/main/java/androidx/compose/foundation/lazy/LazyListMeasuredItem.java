package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0091\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001A\u00020\t\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\t\u0012\u0006\u0010\u0011\u001A\u00020\u0004\u0012\u0006\u0010\u0012\u001A\u00020\u0004\u0012\u0006\u0010\u0013\u001A\u00020\u0004\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\u0006\u0010\u0016\u001A\u00020\u0017\u0012\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017\u0012\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00000\u001A\u0012\u0006\u0010\u001B\u001A\u00020\u001C¢\u0006\u0004\b\u001D\u0010\u001EJ\u0012\u0010@\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001A\u00020\u0004H\u0016J(\u0010A\u001A\u00020B2\u0006\u0010C\u001A\u00020\u00042\u0006\u0010D\u001A\u00020\u00042\u0006\u0010E\u001A\u00020\u00042\u0006\u0010F\u001A\u00020\u0004H\u0016J\u001E\u0010A\u001A\u00020B2\u0006\u0010C\u001A\u00020\u00042\u0006\u0010E\u001A\u00020\u00042\u0006\u0010F\u001A\u00020\u0004J\u000E\u0010G\u001A\u00020B2\u0006\u00109\u001A\u00020\u0004J\u0017\u0010*\u001A\u00020\u00152\u0006\u0010\u0003\u001A\u00020\u0004H\u0016¢\u0006\u0004\bH\u0010IJ\u0016\u0010J\u001A\u00020B2\u0006\u0010K\u001A\u00020\u00042\u0006\u0010L\u001A\u00020\tJ\u0016\u0010M\u001A\u00020B2\u0006\u0010N\u001A\u00020O2\u0006\u0010P\u001A\u00020\tJ(\u0010W\u001A\u00020\u0015*\u00020\u00152\u0012\u0010X\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040YH\u0082\b¢\u0006\u0004\bZ\u0010[R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010!R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0014\u0010\u0016\u001A\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$R\u0016\u0010\u0018\u001A\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b%\u0010$R\u0014\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00000\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001B\u001A\u00020\u001CX\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001A\u0004\b&\u0010\'R\u001E\u0010)\u001A\u00020\u00042\u0006\u0010(\u001A\u00020\u0004@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b*\u0010 R\u0014\u0010+\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b,\u0010 R\u0014\u0010-\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b.\u0010 R\u0014\u0010/\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b0\u0010 R\u0014\u00101\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b2\u0010 R\u0011\u00103\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b4\u0010 R\u001A\u00105\u001A\u00020\tX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u0010!\"\u0004\b7\u00108R\u000E\u00109\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010:\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010;\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010<\u001A\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b?\u0010 R\u0018\u0010Q\u001A\u00020\u0004*\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bR\u0010SR\u0018\u0010T\u001A\u00020\u0004*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bU\u0010V¨\u0006\\"}, d2={"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "()Z", "J", "getKey", "()Ljava/lang/Object;", "getContentType", "getConstraints-msEJaDk", "()J", "value", "offset", "getOffset", "size", "getSize", "lane", "getLane", "span", "getSpan", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "getParentData", "position", "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "updateMainAxisLayoutSize", "getOffset-Bjo55l4", "(I)J", "applyScrollDelta", "delta", "updateAnimations", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyListMeasuredItem implements LazyListItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final int lane;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int spacing;
    private final int span;
    private final Vertical verticalAlignment;
    private final long visualOffset;

    static {
    }

    private LazyListMeasuredItem(int arg2, List arg3, boolean arg4, Horizontal arg5, Vertical arg6, LayoutDirection arg7, boolean arg8, int arg9, int arg10, int arg11, long arg12, Object arg14, Object arg15, LazyLayoutItemAnimator arg16, long arg17) {
        super();
        this.index = arg2;
        this.placeables = arg3;
        this.isVertical = arg4;
        this.horizontalAlignment = arg5;
        this.verticalAlignment = arg6;
        this.layoutDirection = arg7;
        this.reverseLayout = arg8;
        this.beforeContentPadding = arg9;
        this.afterContentPadding = arg10;
        this.spacing = arg11;
        this.visualOffset = arg12;
        this.key = arg14;
        this.contentType = arg15;
        this.animator = arg16;
        this.constraints = arg17;
        this.span = 1;
        this.mainAxisLayoutSize = 0x80000000;
        arg2 = arg3.size();
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        while(v5 < arg2) {
            Object v8 = arg3.get(v5);
            int v0 = this.isVertical() ? ((Placeable)v8).getHeight() : ((Placeable)v8).getWidth();
            v6 += v0;
            int v8_1 = !this.isVertical() ? ((Placeable)v8).getHeight() : ((Placeable)v8).getWidth();
            v7 = Math.max(v7, v8_1);
            ++v5;
        }

        this.size = v6;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(this.getSize() + this.spacing, 0);
        this.crossAxisSize = v7;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    public LazyListMeasuredItem(int arg1, List arg2, boolean arg3, Horizontal arg4, Vertical arg5, LayoutDirection arg6, boolean arg7, int arg8, int arg9, int arg10, long arg11, Object arg13, Object arg14, LazyLayoutItemAnimator arg15, long arg16, DefaultConstructorMarker arg18) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg13, arg14, arg15, arg16);
    }

    public final void applyScrollDelta(int arg10, boolean arg11) {
        int v4;
        if(this.getNonScrollableItem()) {
        }
        else {
            this.offset = this.getOffset() + arg10;
            int v0 = this.placeableOffsets.length;
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                int v3 = v2 & 1;
                if((this.isVertical()) && v3 != 0 || !this.isVertical() && v3 == 0) {
                    this.placeableOffsets[v2] += arg10;
                }
            }

            if(!arg11) {
                return;
            }

            int v11 = this.getPlaceablesCount();
            while(v1 < v11) {
                LazyLayoutItemAnimation v0_1 = this.animator.getAnimation(this.getKey(), v1);
                if(v0_1 != null) {
                    long v2_1 = v0_1.getRawOffset-nOcc-ac();
                    long v5 = 0xFFFFFFFFL;
                    int v7 = 0x20;
                    if(this.isVertical()) {
                        v4 = IntOffset.getX-impl(v2_1);
                        v2 = Integer.valueOf(IntOffset.getY-impl(v2_1) + arg10).intValue();
                    }
                    else {
                        v4 = Integer.valueOf(IntOffset.getX-impl(v2_1) + arg10).intValue();
                        v2 = IntOffset.getY-impl(v2_1);
                    }

                    v0_1.setRawOffset--gyyYBs(IntOffset.constructor-impl((((long)v4)) << v7 | v5 & (((long)v2))));
                }

                ++v1;
            }
        }
    }

    private final long copy-4Tuh3kE(long arg4, Function1 arg6) {
        int v4;
        int v3;
        long v0 = 0xFFFFFFFFL;
        int v2 = 0x20;
        if(this.isVertical()) {
            v3 = IntOffset.getX-impl(arg4);
            v4 = arg6.invoke(Integer.valueOf(IntOffset.getY-impl(arg4))).intValue();
        }
        else {
            v3 = arg6.invoke(Integer.valueOf(IntOffset.getX-impl(arg4))).intValue();
            v4 = IntOffset.getY-impl(arg4);
        }

        return IntOffset.constructor-impl((((long)v4)) & v0 | (((long)v3)) << v2);
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

    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    public int getOffset() {
        return this.offset;
    }

    public long getOffset-Bjo55l4(int arg6) {
        long v0 = 0xFFFFFFFFL;
        int v2 = 0x20;
        if(arg6 == 0 && this.getPlaceablesCount() == 0) {
            boolean v6 = this.isVertical();
            int v5 = this.getOffset();
            if(v6) {
                return IntOffset.constructor-impl((((long)v5)) & v0);
            }
            else {
                return IntOffset.constructor-impl((((long)v5)) << v2);
            }
        }

        arg6 *= 2;
        return IntOffset.constructor-impl((((long)this.placeableOffsets[arg6 + 1])) & v0 | (((long)this.placeableOffsets[arg6])) << v2);
    }

    public Object getParentData(int arg1) {
        return this.placeables.get(arg1).getParentData();
    }

    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    public int getSize() {
        return this.size;
    }

    public int getSpan() {
        return this.span;
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    public final void place(PlacementScope arg14, boolean arg15) {
        PlacementScope v3_1;
        GraphicsLayer v1_1;
        long v8;
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
            long v5 = this.getOffset-Bjo55l4(v2);
            LazyLayoutItemAnimation v7 = this.animator.getAnimation(this.getKey(), v2);
            if(v7 != null) {
                if(arg15) {
                    v7.setLookaheadOffset--gyyYBs(v5);
                }
                else {
                    if(!IntOffset.equals-impl0(v7.getLookaheadOffset-nOcc-ac(), LazyLayoutItemAnimation.Companion.getNotInitialized-nOcc-ac())) {
                        v5 = v7.getLookaheadOffset-nOcc-ac();
                    }

                    v8 = IntOffset.plus-qkQi6aY(v5, v7.getPlacementDelta-nOcc-ac());
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
                v8 = 0xFFFFFFFFL;
                int v10 = 0x20;
                v5 = this.isVertical() ? (((long)(this.mainAxisLayoutSize - IntOffset.getY-impl(v5) - this.getMainAxisSize(((Placeable)v4))))) & v8 | (((long)IntOffset.getX-impl(v5))) << v10 : (((long)(this.mainAxisLayoutSize - IntOffset.getX-impl(v5) - this.getMainAxisSize(((Placeable)v4))))) << v10 | v8 & (((long)IntOffset.getY-impl(v5)));
                v5 = IntOffset.constructor-impl(v5);
            }

            v5 = IntOffset.plus-qkQi6aY(v5, this.visualOffset);
            if(!arg15 && v7 != null) {
                v7.setFinalOffset--gyyYBs(v5);
            }

            if(!this.isVertical()) {
                v3_1 = arg14;
                GraphicsLayer v7_1 = v1_1;
                if(v7_1 != null) {
                    PlacementScope.placeRelativeWithLayer-aW-9-wM$default(v3_1, ((Placeable)v4), v5, v7_1, 0f, 4, null);
                }
                else {
                    PlacementScope.placeRelativeWithLayer-aW-9-wM$default(v3_1, ((Placeable)v4), v5, 0f, null, 6, null);
                }
            }
            else if(v1_1 != null) {
                v3_1 = arg14;
                PlacementScope.placeWithLayer-aW-9-wM$default(v3_1, ((Placeable)v4), v5, v1_1, 0f, 4, null);
            }
            else {
                v3_1 = arg14;
                PlacementScope.placeWithLayer-aW-9-wM$default(v3_1, ((Placeable)v4), v5, 0f, null, 6, null);
            }

            ++v2;
            arg14 = v3_1;
        }
    }

    public final void position(int arg10, int arg11, int arg12) {
        int v3_1;
        this.offset = arg10;
        int v0 = this.isVertical() ? arg12 : arg11;
        this.mainAxisLayoutSize = v0;
        List v0_1 = this.placeables;
        int v1 = v0_1.size();
        int v2;
        for(v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                goto label_49;
            }

            Object v3 = v0_1.get(v2);
            int v4 = v2 * 2;
            boolean v5 = this.isVertical();
            int[] v6 = this.placeableOffsets;
            if(v5) {
                Horizontal v5_1 = this.horizontalAlignment;
                if(v5_1 != null) {
                    v6[v4] = v5_1.align(((Placeable)v3).getWidth(), arg11, this.layoutDirection);
                    this.placeableOffsets[v4 + 1] = arg10;
                    v3_1 = ((Placeable)v3).getHeight();
                }
                else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == true");
                    throw new KotlinNothingValueException();
                }
            }
            else {
                v6[v4] = arg10;
                ++v4;
                Vertical v5_2 = this.verticalAlignment;
                if(v5_2 != null) {
                    v6[v4] = v5_2.align(((Placeable)v3).getHeight(), arg12);
                    v3_1 = ((Placeable)v3).getWidth();
                }
                else {
                    break;
                }
            }

            arg10 += v3_1;
        }

        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalAlignment when isVertical == false");
        throw new KotlinNothingValueException();
    label_49:
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public void position(int arg1, int arg2, int arg3, int arg4) {
        this.position(arg1, arg3, arg4);
    }

    public void setNonScrollableItem(boolean arg1) {
        this.nonScrollableItem = arg1;
    }

    public final void updateMainAxisLayoutSize(int arg2) {
        this.mainAxisLayoutSize = arg2;
        this.maxMainAxisOffset = arg2 + this.afterContentPadding;
    }
}

