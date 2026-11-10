package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001E0\u001D2\u0006\u0010\u001F\u001A\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\"\u0010#\u001A\u00020\t*\u00020$2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020%0\u001D2\u0006\u0010\n\u001A\u00020\tH\u0016J\"\u0010&\u001A\u00020\t*\u00020$2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020%0\u001D2\u0006\u0010\'\u001A\u00020\tH\u0016J\"\u0010(\u001A\u00020\t*\u00020$2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020%0\u001D2\u0006\u0010\n\u001A\u00020\tH\u0016J\"\u0010)\u001A\u00020\t*\u00020$2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020%0\u001D2\u0006\u0010\'\u001A\u00020\tH\u0016JK\u0010*\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010+\u001A\u00020\t2\u0006\u0010,\u001A\u00020\t2\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u00020.2\u0006\u00100\u001A\u00020.2\u0006\u00101\u001A\u00020\tH\u0002¢\u0006\u0004\b2\u00103R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001A\u00020\u000B¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017¨\u00064"}, d2={"Landroidx/compose/material3/TopAppBarMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scrolledOffset", "Landroidx/compose/material3/internal/FloatProducer;", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "titleBottomPadding", "", "height", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;IFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScrolledOffset", "()Landroidx/compose/material3/internal/FloatProducer;", "getTitleVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTitleHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getTitleBottomPadding", "()I", "getHeight-D9Ej5fM", "()F", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "placeTopAppBar", "layoutHeight", "maxLayoutHeight", "navigationIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "titlePlaceable", "actionIconsPlaceable", "titleBaseline", "placeTopAppBar-mpW86Vk", "(Landroidx/compose/ui/layout/MeasureScope;JIILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;I)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class TopAppBarMeasurePolicy implements MeasurePolicy {
    private final float height;
    private final FloatProducer scrolledOffset;
    private final int titleBottomPadding;
    private final Horizontal titleHorizontalAlignment;
    private final Vertical titleVerticalArrangement;

    public TopAppBarMeasurePolicy(FloatProducer arg1, Vertical arg2, Horizontal arg3, int arg4, float arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    private TopAppBarMeasurePolicy(FloatProducer arg1, Vertical arg2, Horizontal arg3, int arg4, float arg5) {
        super();
        this.scrolledOffset = arg1;
        this.titleVerticalArrangement = arg2;
        this.titleHorizontalAlignment = arg3;
        this.titleBottomPadding = arg4;
        this.height = arg5;
    }

    public final float getHeight-D9Ej5fM() {
        return this.height;
    }

    public final FloatProducer getScrolledOffset() {
        return this.scrolledOffset;
    }

    public final int getTitleBottomPadding() {
        return this.titleBottomPadding;
    }

    public final Horizontal getTitleHorizontalAlignment() {
        return this.titleHorizontalAlignment;
    }

    public final Vertical getTitleVerticalArrangement() {
        return this.titleVerticalArrangement;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg6, List arg7, int arg8) {
        Integer v6;
        int v5 = arg6.roundToPx-0680j_4(this.height);
        int v0 = 0;
        if(arg7.isEmpty()) {
            v6 = null;
        }
        else {
            v6 = Integer.valueOf(arg7.get(0).maxIntrinsicHeight(arg8));
            int v1 = CollectionsKt.getLastIndex(arg7);
            int v2 = 1;
            if(1 > v1) {
                goto label_22;
            }

            while(true) {
                Integer v3 = Integer.valueOf(arg7.get(v2).maxIntrinsicHeight(arg8));
                if(((Comparable)v3).compareTo(v6) > 0) {
                    v6 = v3;
                }

                if(v2 == v1) {
                    break;
                }

                ++v2;
            }
        }

    label_22:
        if(v6 != null) {
            v0 = v6.intValue();
        }

        return Math.max(v5, v0);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg3, List arg4, int arg5) {
        int v2 = arg4.size();
        int v3 = 0;
        int v0 = 0;
        while(v3 < v2) {
            v0 += arg4.get(v3).maxIntrinsicWidth(arg5);
            ++v3;
        }

        return v0;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg22, List arg23, long arg24) {
        int v2_1;
        int v16;
        Placeable v8_1;
        int v7_1;
        Placeable v3_1;
        String v6;
        TopAppBarMeasurePolicy v0 = this;
        List v1 = arg23;
        List v2 = v1;
        int v3 = ((Collection)v2).size();
        int v5 = 0;
        while(true) {
            v6 = "Collection contains no element matching the predicate.";
            if(v5 >= v3) {
                break;
            }

            Object v7 = v1.get(v5);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v7)), "navigationIcon")) {
                v3_1 = ((Measurable)v7).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg24, 0, 0, 0, 0, 14, null));
                v5 = ((Collection)v2).size();
                v7_1 = 0;
                goto label_24;
            }

            ++v5;
            v0 = this;
        }

        ListUtilsKt.throwNoSuchElementException(v6);
        throw new KotlinNothingValueException();
    label_24:
        while(v7_1 < v5) {
            Object v8 = v1.get(v7_1);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v8)), "actionIcons")) {
                v8_1 = ((Measurable)v8).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg24, 0, 0, 0, 0, 14, null));
                v7_1 = 0x7FFFFFFF;
                v5 = Constraints.getMaxWidth-impl(arg24) == v7_1 ? Constraints.getMaxWidth-impl(arg24) : RangesKt.coerceAtLeast(Constraints.getMaxWidth-impl(arg24) - v3_1.getWidth() - v8_1.getWidth(), 0);
                v16 = v5;
                v2_1 = ((Collection)v2).size();
                v5 = 0;
                goto label_53;
            }

            ++v7_1;
            v0 = this;
        }

        ListUtilsKt.throwNoSuchElementException(v6);
        throw new KotlinNothingValueException();
    label_53:
        while(v5 < v2_1) {
            Object v9 = v1.get(v5);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v9)), "title")) {
                Placeable v1_1 = ((Measurable)v9).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg24, 0, v16, 0, 0, 12, null));
                int v9_1 = v1_1.get(AlignmentLineKt.getLastBaseline()) != 0x80000000 ? v1_1.get(AlignmentLineKt.getLastBaseline()) : 0;
                float v2_2 = v0.scrolledOffset.invoke();
                v2_1 = Float.isNaN(v2_2) ? 0 : MathKt.roundToInt(v2_2);
                MeasureScope v6_1 = arg22;
                v5 = Math.max(v6_1.roundToPx-0680j_4(v0.height), v1_1.getHeight());
                int v4 = Constraints.getMaxHeight-impl(arg24) == v7_1 ? v5 : RangesKt.coerceAtLeast(v2_1 + v5, 0);
                return v0.placeTopAppBar-mpW86Vk(v6_1, arg24, v4, v5, v3_1, v1_1, v8_1, v9_1);
            }

            ++v5;
            v0 = this;
        }

        ListUtilsKt.throwNoSuchElementException(v6);
        throw new KotlinNothingValueException();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg6, List arg7, int arg8) {
        Integer v6;
        int v5 = arg6.roundToPx-0680j_4(this.height);
        int v0 = 0;
        if(arg7.isEmpty()) {
            v6 = null;
        }
        else {
            v6 = Integer.valueOf(arg7.get(0).minIntrinsicHeight(arg8));
            int v1 = CollectionsKt.getLastIndex(arg7);
            int v2 = 1;
            if(1 > v1) {
                goto label_22;
            }

            while(true) {
                Integer v3 = Integer.valueOf(arg7.get(v2).minIntrinsicHeight(arg8));
                if(((Comparable)v3).compareTo(v6) > 0) {
                    v6 = v3;
                }

                if(v2 == v1) {
                    break;
                }

                ++v2;
            }
        }

    label_22:
        if(v6 != null) {
            v0 = v6.intValue();
        }

        return Math.max(v5, v0);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg3, List arg4, int arg5) {
        int v2 = arg4.size();
        int v3 = 0;
        int v0 = 0;
        while(v3 < v2) {
            v0 += arg4.get(v3).minIntrinsicWidth(arg5);
            ++v3;
        }

        return v0;
    }

    private final MeasureResult placeTopAppBar-mpW86Vk(MeasureScope arg14, long arg15, int arg17, int arg18, Placeable arg19, Placeable arg20, Placeable arg21, int arg22) {
        return MeasureScope.layout$default(arg14, Constraints.getMaxWidth-impl(arg15), arg17, null, new TopAppBarMeasurePolicy$$ExternalSyntheticLambda0(arg19, arg17, arg20, arg21, arg15, arg14, this, arg22, arg18), 4, null);
    }

    static final Unit placeTopAppBar_mpW86Vk$lambda$8(Placeable arg10, int arg11, Placeable arg12, Placeable arg13, long arg14, MeasureScope arg16, TopAppBarMeasurePolicy arg17, int arg18, int arg19, PlacementScope arg20) {
        TopAppBarMeasurePolicy v0 = arg17;
        int v1 = arg19;
        PlacementScope.placeRelative$default(arg20, arg10, 0, (arg11 - arg10.getHeight()) / 2, 0f, 4, null);
        int v10 = Math.max(arg16.roundToPx-0680j_4(AppBarKt.TopAppBarTitleInset), arg10.getWidth());
        int v2 = arg13.getWidth();
        int v3 = v0.titleHorizontalAlignment.align(arg12.getWidth(), Constraints.getMaxWidth-impl(arg14), LayoutDirection.Ltr);
        if(v3 < v10) {
            v10 -= v3;
            goto label_25;
        }
        else if(arg12.getWidth() + v3 > Constraints.getMaxWidth-impl(arg14) - v2) {
            v10 = Constraints.getMaxWidth-impl(arg14) - v2 - (arg12.getWidth() + v3);
        label_25:
            v3 += v10;
        }

        v2 = v3;
        Vertical v10_1 = v0.titleVerticalArrangement;
        if(Intrinsics.areEqual(v10_1, Arrangement.INSTANCE.getCenter())) {
            v10 = (arg11 - arg12.getHeight()) / 2;
            goto label_47;
        }
        else {
            v3 = 0;
            if(Intrinsics.areEqual(v10_1, Arrangement.INSTANCE.getBottom())) {
                v10 = v0.titleBottomPadding;
                if(v10 == 0) {
                    v10 = arg11 - arg12.getHeight();
                    goto label_47;
                }
                else {
                    v10 -= arg12.getHeight() - arg18;
                    int v0_1 = arg12.getHeight() + v10;
                    if(v0_1 > v1) {
                        v10 -= v0_1 - v1;
                    }

                    v10 = arg11 - arg12.getHeight() - Math.max(0, v10);
                label_47:
                    v3 = v10;
                }
            }
        }

        PlacementScope.placeRelative$default(arg20, arg12, v2, v3, 0f, 4, null);
        PlacementScope.placeRelative$default(arg20, arg13, Constraints.getMaxWidth-impl(arg14) - arg13.getWidth(), (arg11 - arg13.getHeight()) / 2, 0f, 4, null);
        return Unit.INSTANCE;
    }
}

