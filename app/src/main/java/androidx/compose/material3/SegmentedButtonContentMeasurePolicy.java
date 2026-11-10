package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0016\u001A\u00020\u0017*\u00020\u00182\u0012\u0010\u0019\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001B0\u001A0\u001A2\u0006\u0010\u001C\u001A\u00020\u001DH\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR(\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006 "}, d2={"Landroidx/compose/material3/SegmentedButtonContentMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/animation/core/AnimationSpec;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "setAnimatable", "(Landroidx/compose/animation/core/Animatable;)V", "initialOffset", "Ljava/lang/Integer;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SegmentedButtonContentMeasurePolicy implements MultiContentMeasurePolicy {
    public static final int $stable;
    private Animatable animatable;
    private final AnimationSpec animationSpec;
    private Integer initialOffset;
    private final CoroutineScope scope;

    static {
    }

    public SegmentedButtonContentMeasurePolicy(CoroutineScope arg1, AnimationSpec arg2) {
        super();
        this.scope = arg1;
        this.animationSpec = arg2;
    }

    public final Animatable getAnimatable() {
        return this.animatable;
    }

    public final AnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg18, List arg19, long arg20) {
        Object v4_2;
        int v13_1;
        Object v12_1;
        int v4_1;
        int v11;
        SegmentedButtonContentMeasurePolicy v3 = this;
        MeasureScope v0 = arg18;
        long v4 = arg20;
        int v2 = 0;
        Object v6 = arg19.get(0);
        int v7 = 1;
        Object v1 = arg19.get(1);
        ArrayList v8 = new ArrayList(((List)v6).size());
        int v9 = v6.size();
        int v10;
        for(v10 = 0; v10 < v9; ++v10) {
            v8.add(((List)v6).get(v10).measure-BRTryo0(v4));
        }

        Continuation v9_1 = null;
        if(((List)v8).isEmpty()) {
            v6 = v9_1;
        }
        else {
            v6 = ((List)v8).get(0);
            v10 = v6.getWidth();
            v11 = CollectionsKt.getLastIndex(((List)v8));
            if(1 <= v11) {
                int v12;
                for(v12 = 1; true; ++v12) {
                    Object v13 = ((List)v8).get(v12);
                    int v14 = v13.getWidth();
                    if(v10 < v14) {
                        v6 = v13;
                        v10 = v14;
                    }

                    if(v12 == v11) {
                        break;
                    }
                }
            }
        }

        int v6_1 = v6 != null ? ((Placeable)v6).getWidth() : 0;
        ArrayList v10_1 = new ArrayList(((List)v1).size());
        v11 = v1.size();
        for(v12 = 0; v12 < v11; ++v12) {
            v10_1.add(((List)v1).get(v12).measure-BRTryo0(v4));
        }

        ArrayList v5 = v10_1;
        if(((List)v5).isEmpty()) {
            v1 = v9_1;
        }
        else {
            v1 = ((List)v5).get(0);
            v4_1 = v1.getWidth();
            v10 = CollectionsKt.getLastIndex(((List)v5));
            if(1 <= v10) {
                for(v11 = 1; true; ++v11) {
                    v12_1 = ((List)v5).get(v11);
                    v13_1 = v12_1.getWidth();
                    if(v4_1 < v13_1) {
                        v1 = v12_1;
                        v4_1 = v13_1;
                    }

                    if(v11 == v10) {
                        break;
                    }
                }
            }
        }

        Integer v1_1 = v1 != null ? Integer.valueOf(((Placeable)v1).getWidth()) : ((Integer)v9_1);
        if(((List)v5).isEmpty()) {
            v4_2 = v9_1;
        }
        else {
            v4_2 = ((List)v5).get(0);
            v10 = v4_2.getHeight();
            v11 = CollectionsKt.getLastIndex(((List)v5));
            if(1 > v11) {
                goto label_101;
            }

            while(true) {
                v12_1 = ((List)v5).get(v7);
                v13_1 = v12_1.getHeight();
                if(v10 < v13_1) {
                    v4_2 = v12_1;
                    v10 = v13_1;
                }

                if(v7 == v11) {
                    break;
                }

                ++v7;
            }
        }

    label_101:
        v4_1 = v4_2 != null ? ((Placeable)v4_2).getHeight() : 0;
        v7 = Math.max(v0.roundToPx-0680j_4(SegmentedButtonDefaults.INSTANCE.getIconSize-D9Ej5fM()), v6_1) + v0.roundToPx-0680j_4(SegmentedButtonKt.access$getIconSpacing$p());
        int v1_2 = v1_1 != null ? v1_1.intValue() : 0;
        v7 += v1_2;
        if(v6_1 == 0) {
            v2 = -(v0.roundToPx-0680j_4(SegmentedButtonDefaults.INSTANCE.getIconSize-D9Ej5fM()) + v0.roundToPx-0680j_4(SegmentedButtonKt.access$getIconSpacing$p())) / 2;
        }

        if(v3.initialOffset == null) {
            v3.initialOffset = Integer.valueOf(v2);
        }
        else {
            Animatable v1_3 = v3.animatable;
            if(v1_3 == null) {
                Integer v11_1 = v3.initialOffset;
                Intrinsics.checkNotNull(v11_1);
                Animatable v10_2 = new Animatable(v11_1, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), null, null, 12, null);
                v3.animatable = v10_2;
                v1_3 = v10_2;
            }

            if(v1_3.getTargetValue().intValue() == v2) {
                goto label_157;
            }

            BuildersKt.launch$default(v3.scope, null, null, new SegmentedButtonContentMeasurePolicy$measure$1(v1_3, v2, v3, v9_1), 3, null);
        }

    label_157:
        return MeasureScope.layout$default(arg18, v7, v4_1, null, new SegmentedButtonContentMeasurePolicy$$ExternalSyntheticLambda0(v8, arg18, v3, v2, ((List)v5), v4_1), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$8(List arg21, MeasureScope arg22, SegmentedButtonContentMeasurePolicy arg23, int arg24, List arg25, int arg26, PlacementScope arg27) {
        List v0 = arg21;
        MeasureScope v1 = arg22;
        List v2 = arg25;
        int v3 = v0.size();
        int v4 = 0;
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            Object v8 = v0.get(v5);
            PlacementScope.place$default(arg27, ((Placeable)v8), 0, (arg26 - ((Placeable)v8).getHeight()) / 2, 0f, 4, null);
        }

        int v0_1 = v1.roundToPx-0680j_4(SegmentedButtonDefaults.INSTANCE.getIconSize-D9Ej5fM()) + v1.roundToPx-0680j_4(SegmentedButtonKt.access$getIconSpacing$p());
        Animatable v1_1 = arg23.animatable;
        int v1_2 = v1_1 != null ? v1_1.getValue().intValue() : arg24;
        int v16 = v0_1 + v1_2;
        v0_1 = v2.size();
        while(v4 < v0_1) {
            Object v15 = v2.get(v4);
            PlacementScope.place$default(arg27, ((Placeable)v15), v16, (arg26 - ((Placeable)v15).getHeight()) / 2, 0f, 4, null);
            ++v4;
        }

        return Unit.INSTANCE;
    }

    public final void setAnimatable(Animatable arg1) {
        this.animatable = arg1;
    }
}

