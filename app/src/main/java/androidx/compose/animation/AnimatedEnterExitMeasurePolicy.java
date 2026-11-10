package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000E\u001A\u00020\u000F*\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001A\u00020\u0019*\u00020\u001A2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u001B0\u00122\u0006\u0010\u001C\u001A\u00020\u0019H\u0016J\"\u0010\u001D\u001A\u00020\u0019*\u00020\u001A2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u001B0\u00122\u0006\u0010\u001E\u001A\u00020\u0019H\u0016J\"\u0010\u001F\u001A\u00020\u0019*\u00020\u001A2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u001B0\u00122\u0006\u0010\u001C\u001A\u00020\u0019H\u0016J\"\u0010 \u001A\u00020\u0019*\u00020\u001A2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u001B0\u00122\u0006\u0010\u001E\u001A\u00020\u0019H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006!"}, d2={"Landroidx/compose/animation/AnimatedEnterExitMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scope", "Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "<init>", "(Landroidx/compose/animation/AnimatedVisibilityScopeImpl;)V", "getScope", "()Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "hasLookaheadOccurred", "", "getHasLookaheadOccurred", "()Z", "setHasLookaheadOccurred", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    private boolean hasLookaheadOccurred;
    private final AnimatedVisibilityScopeImpl scope;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl arg1) {
        super();
        this.scope = arg1;
    }

    public final boolean getHasLookaheadOccurred() {
        return this.hasLookaheadOccurred;
    }

    public final AnimatedVisibilityScopeImpl getScope() {
        return this.scope;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg3, List arg4, int arg5) {
        if(arg4.isEmpty()) {
            return 0;
        }

        int v2 = arg4.get(0).maxIntrinsicHeight(arg5);
        int v3 = CollectionsKt.getLastIndex(arg4);
        int v0 = 1;
        if(1 <= v3) {
            while(true) {
                int v1 = arg4.get(v0).maxIntrinsicHeight(arg5);
                if(v1 > v2) {
                    v2 = v1;
                }

                if(v0 == v3) {
                    return v2;
                }

                ++v0;
            }
        }

        return v2;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg3, List arg4, int arg5) {
        if(arg4.isEmpty()) {
            return 0;
        }

        int v2 = arg4.get(0).maxIntrinsicWidth(arg5);
        int v3 = CollectionsKt.getLastIndex(arg4);
        int v0 = 1;
        if(1 <= v3) {
            while(true) {
                int v1 = arg4.get(v0).maxIntrinsicWidth(arg5);
                if(v1 > v2) {
                    v2 = v1;
                }

                if(v0 == v3) {
                    return v2;
                }

                ++v0;
            }
        }

        return v2;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg11, List arg12, long arg13) {
        ArrayList v0 = new ArrayList(arg12.size());
        int v1 = arg12.size();
        int v2 = 0;
        int v4 = 0;
        int v5 = 0;
        while(v2 < v1) {
            Placeable v3 = arg12.get(v2).measure-BRTryo0(arg13);
            v4 = Math.max(v4, v3.getWidth());
            v5 = Math.max(v5, v3.getHeight());
            v0.add(v3);
            ++v2;
        }

        arg13 = 0xFFFFFFFFL;
        v1 = 0x20;
        if(arg11.isLookingAhead()) {
            this.hasLookaheadOccurred = true;
            this.scope.getTargetSize$animation().setValue(IntSize.box-impl(IntSize.constructor-impl((((long)v5)) & arg13 | (((long)v4)) << v1)));
        }
        else if(!this.hasLookaheadOccurred) {
            this.scope.getTargetSize$animation().setValue(IntSize.box-impl(IntSize.constructor-impl((((long)v5)) & arg13 | (((long)v4)) << v1)));
        }

        return MeasureScope.layout$default(arg11, v4, v5, null, new AnimatedEnterExitMeasurePolicy$measure$1(((List)v0)), 4, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg3, List arg4, int arg5) {
        if(arg4.isEmpty()) {
            return 0;
        }

        int v2 = arg4.get(0).minIntrinsicHeight(arg5);
        int v3 = CollectionsKt.getLastIndex(arg4);
        int v0 = 1;
        if(1 <= v3) {
            while(true) {
                int v1 = arg4.get(v0).minIntrinsicHeight(arg5);
                if(v1 > v2) {
                    v2 = v1;
                }

                if(v0 == v3) {
                    return v2;
                }

                ++v0;
            }
        }

        return v2;
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg3, List arg4, int arg5) {
        if(arg4.isEmpty()) {
            return 0;
        }

        int v2 = arg4.get(0).minIntrinsicWidth(arg5);
        int v3 = CollectionsKt.getLastIndex(arg4);
        int v0 = 1;
        if(1 <= v3) {
            while(true) {
                int v1 = arg4.get(v0).minIntrinsicWidth(arg5);
                if(v1 > v2) {
                    v2 = v1;
                }

                if(v0 == v3) {
                    return v2;
                }

                ++v0;
            }
        }

        return v2;
    }

    public final void setHasLookaheadOccurred(boolean arg1) {
        this.hasLookaheadOccurred = arg1;
    }
}

