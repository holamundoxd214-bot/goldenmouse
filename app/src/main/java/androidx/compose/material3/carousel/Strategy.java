package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u0000 -2\u00020\u0001:\u0001-BM\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\b¢\u0006\u0004\b\f\u0010\rB1\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\b¢\u0006\u0004\b\f\u0010\u000EJ\'\u0010$\u001A\u00020\u00032\u0006\u0010%\u001A\u00020\b2\u0006\u0010&\u001A\u00020\b2\b\b\u0002\u0010\'\u001A\u00020!H\u0000¢\u0006\u0002\b(J\u0013\u0010)\u001A\u00020!2\b\u0010*\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001A\u00020,H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0015R\u0011\u0010\u000B\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0015R\u000E\u0010\u0019\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001E\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0015R\u0011\u0010 \u001A\u00020!¢\u0006\b\n\u0000\u001A\u0004\b \u0010\"R\u0016\u0010#\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006."}, d2={"Landroidx/compose/material3/carousel/Strategy;", "", "defaultKeylines", "Landroidx/compose/material3/carousel/KeylineList;", "startKeylineSteps", "", "endKeylineSteps", "availableSpace", "", "itemSpacing", "beforeContentPadding", "afterContentPadding", "<init>", "(Landroidx/compose/material3/carousel/KeylineList;Ljava/util/List;Ljava/util/List;FFFF)V", "(Landroidx/compose/material3/carousel/KeylineList;FFFF)V", "getDefaultKeylines", "()Landroidx/compose/material3/carousel/KeylineList;", "getStartKeylineSteps", "()Ljava/util/List;", "getEndKeylineSteps", "getAvailableSpace", "()F", "getItemSpacing", "getBeforeContentPadding", "getAfterContentPadding", "startShiftDistance", "endShiftDistance", "startShiftPoints", "Landroidx/collection/FloatList;", "endShiftPoints", "itemMainAxisSize", "getItemMainAxisSize", "isValid", "", "()Z", "lastStartAndEndKeylineListSteps", "getKeylineListForScrollOffset", "scrollOffset", "maxScrollOffset", "roundToNearestStep", "getKeylineListForScrollOffset$material3", "equals", "other", "hashCode", "", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Strategy {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/material3/carousel/Strategy$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/material3/carousel/Strategy;", "getEmpty", "()Landroidx/compose/material3/carousel/Strategy;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Strategy getEmpty() {
            return Strategy.Empty;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Strategy Empty;
    private final float afterContentPadding;
    private final float availableSpace;
    private final float beforeContentPadding;
    private final KeylineList defaultKeylines;
    private final List endKeylineSteps;
    private final float endShiftDistance;
    private final FloatList endShiftPoints;
    private final boolean isValid;
    private final float itemSpacing;
    private List lastStartAndEndKeylineListSteps;
    private final List startKeylineSteps;
    private final float startShiftDistance;
    private final FloatList startShiftPoints;

    static {
        Strategy.Companion = new Companion(null);
        Strategy.$stable = 8;
        Strategy.Empty = new Strategy(KeylineListKt.emptyKeylineList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0f, 0f, 0f, 0f);
    }

    public Strategy(KeylineList arg9, float arg10, float arg11, float arg12, float arg13) {
        this(arg9, StrategyKt.access$getStartKeylineSteps(arg9, arg10, arg11, arg12), StrategyKt.access$getEndKeylineSteps(arg9, arg10, arg11, arg13), arg10, arg11, arg12, arg13);
    }

    private Strategy(KeylineList arg1, List arg2, List arg3, float arg4, float arg5, float arg6, float arg7) {
        super();
        this.defaultKeylines = arg1;
        this.startKeylineSteps = arg2;
        this.endKeylineSteps = arg3;
        this.availableSpace = arg4;
        this.itemSpacing = arg5;
        this.beforeContentPadding = arg6;
        this.afterContentPadding = arg7;
        arg5 = StrategyKt.access$getStartShiftDistance(arg2, arg6);
        this.startShiftDistance = arg5;
        arg6 = StrategyKt.access$getEndShiftDistance(arg3, arg7);
        this.endShiftDistance = arg6;
        boolean v7 = true;
        this.startShiftPoints = StrategyKt.access$getStepInterpolationPoints(arg5, arg2, true);
        this.endShiftPoints = StrategyKt.access$getStepInterpolationPoints(arg6, arg3, false);
        if((((Collection)arg1).isEmpty()) || arg4 == 0f || this.getItemMainAxisSize() == 0f) {
            v7 = false;
        }

        this.isValid = v7;
    }

    public static final Strategy access$getEmpty$cp() {
        return Strategy.Empty;
    }

    public boolean equals(Object arg5) {
        if(this == (((Strategy)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Strategy)) {
            return 0;
        }

        boolean v1 = this.isValid;
        if(!v1 && !arg5.isValid) {
            return 1;
        }

        if(v1 != ((Strategy)arg5).isValid) {
            return 0;
        }

        if(this.availableSpace == ((Strategy)arg5).availableSpace && this.itemSpacing == ((Strategy)arg5).itemSpacing && this.beforeContentPadding == ((Strategy)arg5).beforeContentPadding && this.afterContentPadding == ((Strategy)arg5).afterContentPadding && this.getItemMainAxisSize() == ((Strategy)arg5).getItemMainAxisSize() && this.startShiftDistance == ((Strategy)arg5).startShiftDistance && this.endShiftDistance == ((Strategy)arg5).endShiftDistance) {
            if(!Intrinsics.areEqual(this.startShiftPoints, ((Strategy)arg5).startShiftPoints)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.endShiftPoints, ((Strategy)arg5).endShiftPoints)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.defaultKeylines, ((Strategy)arg5).defaultKeylines)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final float getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final float getAvailableSpace() {
        return this.availableSpace;
    }

    public final float getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final KeylineList getDefaultKeylines() {
        return this.defaultKeylines;
    }

    public final List getEndKeylineSteps() {
        return this.endKeylineSteps;
    }

    public final float getItemMainAxisSize() {
        return this.defaultKeylines.getFirstFocal().getSize();
    }

    public final float getItemSpacing() {
        return this.itemSpacing;
    }

    public final KeylineList getKeylineListForScrollOffset$material3(float arg8, float arg9, boolean arg10) {
        arg8 = Math.max(0f, arg8);
        float v1 = this.startShiftDistance;
        float v2 = Math.max(0f, arg9 - this.endShiftDistance);
        if(v1 <= arg8 && arg8 <= v2) {
            return this.defaultKeylines;
        }

        float v3 = 1f;
        v1 = StrategyKt.access$lerp(v3, 0f, 0f, v1, arg8);
        FloatList v4 = this.startShiftPoints;
        List v5 = this.startKeylineSteps;
        if(arg8 > v2) {
            v1 = StrategyKt.access$lerp(0f, v3, v2, arg9, arg8);
            v4 = this.endShiftPoints;
            v5 = this.endKeylineSteps;
            if(v2 < 0.01f) {
                int v9 = 2;
                if(this.startKeylineSteps.size() == v9 && this.endKeylineSteps.size() == v9) {
                    List v8 = this.lastStartAndEndKeylineListSteps;
                    if(v8 == null) {
                        KeylineList[] v8_1 = new KeylineList[v9];
                        v8_1[0] = CollectionsKt.last(this.startKeylineSteps);
                        v8_1[1] = CollectionsKt.last(this.endKeylineSteps);
                        v8 = CollectionsKt.listOf(((Object[])v8_1));
                        this.lastStartAndEndKeylineListSteps = v8;
                    }

                    v5 = v8;
                    Intrinsics.checkNotNull(v5);
                }
            }
        }

        ShiftPointRange v7 = StrategyKt.access$getShiftPointRange(v5.size(), v4, v1);
        if(arg10) {
            int v7_1 = MathKt.roundToInt(v7.getSteppedInterpolation()) == 0 ? v7.getFromStepIndex() : v7.getToStepIndex();
            return v5.get(v7_1);
        }

        return KeylineListKt.lerp(v5.get(v7.getFromStepIndex()), v5.get(v7.getToStepIndex()), v7.getSteppedInterpolation());
    }

    public static KeylineList getKeylineListForScrollOffset$material3$default(Strategy arg0, float arg1, float arg2, boolean arg3, int arg4, Object arg5) {
        return arg0.getKeylineListForScrollOffset$material3(arg1, arg2, false);
    }

    public final List getStartKeylineSteps() {
        return this.startKeylineSteps;
    }

    public int hashCode() {
        boolean v0 = this.isValid;
        if(!v0) {
            return Boolean.hashCode(v0);
        }

        return (((((((((Boolean.hashCode(v0) * 0x1F + Float.hashCode(this.availableSpace)) * 0x1F + Float.hashCode(this.itemSpacing)) * 0x1F + Float.hashCode(this.beforeContentPadding)) * 0x1F + Float.hashCode(this.afterContentPadding)) * 0x1F + Float.hashCode(this.getItemMainAxisSize())) * 0x1F + Float.hashCode(this.startShiftDistance)) * 0x1F + Float.hashCode(this.endShiftDistance)) * 0x1F + this.startShiftPoints.hashCode()) * 0x1F + this.endShiftPoints.hashCode()) * 0x1F + this.defaultKeylines.hashCode();
    }

    public final boolean isValid() {
        return this.isValid;
    }
}

