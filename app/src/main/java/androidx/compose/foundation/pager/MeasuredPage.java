package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001E\u0010\'\u001A\u00020(2\u0006\u0010$\u001A\u00020\u00032\u0006\u0010)\u001A\u00020\u00032\u0006\u0010*\u001A\u00020\u0003J\u000E\u0010+\u001A\u00020(2\u0006\u0010,\u001A\u00020-J\u000E\u0010.\u001A\u00020(2\u0006\u0010/\u001A\u00020\u0003J\u0017\u0010%\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u0003H\u0002¢\u0006\u0004\b0\u00101J(\u00105\u001A\u00020\t*\u00020\t2\u0012\u00106\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000307H\u0082\b¢\u0006\u0004\b8\u00109R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0019R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001BR\u0014\u0010\n\u001A\u00020\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001F\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0019R\u000E\u0010!\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010$\u001A\u00020\u00032\u0006\u0010#\u001A\u00020\u0003@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b%\u0010\u0019R\u000E\u0010&\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u00102\u001A\u00020\u0003*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b3\u00104¨\u0006:"}, d2={"Landroidx/compose/foundation/pager/MeasuredPage;", "Landroidx/compose/foundation/pager/PageInfo;", "index", "", "size", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "", "<init>", "(IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getSize", "J", "getKey", "()Ljava/lang/Object;", "isVertical", "crossAxisSize", "getCrossAxisSize", "placeableOffsets", "", "value", "offset", "getOffset", "mainAxisLayoutSize", "position", "", "layoutWidth", "layoutHeight", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "applyScrollDelta", "delta", "getOffset-Bjo55l4", "(I)J", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MeasuredPage implements PageInfo {
    public static final int $stable = 8;
    private final int crossAxisSize;
    private final Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Vertical verticalAlignment;
    private final long visualOffset;

    static {
    }

    private MeasuredPage(int arg1, int arg2, List arg3, long arg4, Object arg6, Orientation arg7, Horizontal arg8, Vertical arg9, LayoutDirection arg10, boolean arg11) {
        super();
        this.index = arg1;
        this.size = arg2;
        this.placeables = arg3;
        this.visualOffset = arg4;
        this.key = arg6;
        this.horizontalAlignment = arg8;
        this.verticalAlignment = arg9;
        this.layoutDirection = arg10;
        this.reverseLayout = arg11;
        arg2 = 0;
        boolean v1 = arg7 == Orientation.Vertical ? true : false;
        this.isVertical = v1;
        arg1 = arg3.size();
        int v4 = 0;
        while(arg2 < arg1) {
            Object v5 = arg3.get(arg2);
            int v5_1 = !this.isVertical ? ((Placeable)v5).getHeight() : ((Placeable)v5).getWidth();
            v4 = Math.max(v4, v5_1);
            ++arg2;
        }

        this.crossAxisSize = v4;
        this.placeableOffsets = new int[this.placeables.size() * 2];
        this.mainAxisLayoutSize = 0x80000000;
    }

    public MeasuredPage(int arg1, int arg2, List arg3, long arg4, Object arg6, Orientation arg7, Horizontal arg8, Vertical arg9, LayoutDirection arg10, boolean arg11, DefaultConstructorMarker arg12) {
        this(arg1, arg2, arg3, arg4, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public final void applyScrollDelta(int arg6) {
        this.offset = this.getOffset() + arg6;
        int v0 = this.placeableOffsets.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            boolean v2 = this.isVertical;
            if((v2) && v1 % 2 == 1 || !v2 && v1 % 2 == 0) {
                this.placeableOffsets[v1] += arg6;
            }
        }
    }

    private final long copy-4Tuh3kE(long arg5, Function1 arg7) {
        int v0 = this.isVertical ? IntOffset.getX-impl(arg5) : arg7.invoke(Integer.valueOf(IntOffset.getX-impl(arg5))).intValue();
        int v4 = this.isVertical ? arg7.invoke(Integer.valueOf(IntOffset.getY-impl(arg5))).intValue() : IntOffset.getY-impl(arg5);
        return IntOffset.constructor-impl((((long)v0)) << 0x20 | (((long)v4)) & 0xFFFFFFFFL);
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

    private final int getMainAxisSize(Placeable arg1) {
        if(this.isVertical) {
            return arg1.getHeight();
        }

        return arg1.getWidth();
    }

    public int getOffset() {
        return this.offset;
    }

    private final long getOffset-Bjo55l4(int arg5) {
        arg5 *= 2;
        return IntOffset.constructor-impl((((long)this.placeableOffsets[arg5 + 1])) & 0xFFFFFFFFL | (((long)this.placeableOffsets[arg5])) << 0x20);
    }

    public final int getSize() {
        return this.size;
    }

    public final void place(PlacementScope arg13) {
        PlacementScope v3;
        int v2 = 0;
        int v0 = this.mainAxisLayoutSize != 0x80000000 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
        }

        v0 = this.placeables.size();
        while(v2 < v0) {
            Object v4 = this.placeables.get(v2);
            long v5 = this.getOffset-Bjo55l4(v2);
            if(this.reverseLayout) {
                int v1 = this.isVertical ? IntOffset.getX-impl(v5) : this.mainAxisLayoutSize - IntOffset.getX-impl(v5) - this.getMainAxisSize(((Placeable)v4));
                int v5_1 = this.isVertical ? this.mainAxisLayoutSize - IntOffset.getY-impl(v5) - this.getMainAxisSize(((Placeable)v4)) : IntOffset.getY-impl(v5);
                v5 = IntOffset.constructor-impl((((long)v1)) << 0x20 | (((long)v5_1)) & 0xFFFFFFFFL);
            }

            v5 = IntOffset.plus-qkQi6aY(v5, this.visualOffset);
            if(this.isVertical) {
                v3 = arg13;
                PlacementScope.placeWithLayer-aW-9-wM$default(v3, ((Placeable)v4), v5, 0f, null, 6, null);
            }
            else {
                v3 = arg13;
                PlacementScope.placeRelativeWithLayer-aW-9-wM$default(v3, ((Placeable)v4), v5, 0f, null, 6, null);
            }

            ++v2;
            arg13 = v3;
        }
    }

    public final void position(int arg10, int arg11, int arg12) {
        int v3_1;
        this.offset = arg10;
        int v0 = this.isVertical ? arg12 : arg11;
        this.mainAxisLayoutSize = v0;
        List v0_1 = this.placeables;
        int v1 = v0_1.size();
        int v2;
        for(v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                return;
            }

            Object v3 = v0_1.get(v2);
            int v4 = v2 * 2;
            boolean v5 = this.isVertical;
            int[] v6 = this.placeableOffsets;
            if(v5) {
                Horizontal v5_1 = this.horizontalAlignment;
                if(v5_1 != null) {
                    v6[v4] = v5_1.align(((Placeable)v3).getWidth(), arg11, this.layoutDirection);
                    this.placeableOffsets[v4 + 1] = arg10;
                    v3_1 = ((Placeable)v3).getHeight();
                }
                else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment");
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

        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalAlignment");
        throw new KotlinNothingValueException();
    }
}

