package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import androidx.collection.FloatListKt;
import androidx.collection.MutableFloatList;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\u001A\u001E\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0001H\u0002\u001A\u001E\u0010\u0006\u001A\u00020\u00012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001A\u00020\u0001H\u0002\u001A.\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0002\u001A.\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u0001H\u0002\u001A8\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u00012\u0006\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0002\u001A0\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u0001H\u0002\u001A&\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00012\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001C\u001A\u00020\u001DH\u0002\u001A \u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u00142\u0006\u0010!\u001A\u00020\u00192\u0006\u0010\"\u001A\u00020\u0001H\u0002\u001A(\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00120$*\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u0010\u0016\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0014H\u0002\u001A0\u0010%\u001A\u00020\u00012\u0006\u0010&\u001A\u00020\u00012\u0006\u0010\'\u001A\u00020\u00012\u0006\u0010(\u001A\u00020\u00012\u0006\u0010)\u001A\u00020\u00012\u0006\u0010*\u001A\u00020\u0001H\u0002¨\u0006+"}, d2={"getStartShiftDistance", "", "startKeylineSteps", "", "Landroidx/compose/material3/carousel/KeylineList;", "beforeContentPadding", "getEndShiftDistance", "endKeylineSteps", "afterContentPadding", "getStartKeylineSteps", "defaultKeylines", "carouselMainAxisSize", "itemSpacing", "getEndKeylineSteps", "createShiftedKeylineListForContentPadding", "from", "contentPadding", "pivot", "Landroidx/compose/material3/carousel/Keyline;", "pivotIndex", "", "moveKeylineAndCreateShiftedKeylineList", "srcIndex", "dstIndex", "getStepInterpolationPoints", "Landroidx/collection/FloatList;", "totalShiftDistance", "steps", "isShiftingLeft", "", "getShiftPointRange", "Landroidx/compose/material3/carousel/ShiftPointRange;", "stepsCount", "shiftPoint", "interpolation", "move", "", "lerp", "outputMin", "outputMax", "inputMin", "inputMax", "value", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class StrategyKt {
    public static final List access$getEndKeylineSteps(KeylineList arg0, float arg1, float arg2, float arg3) {
        return StrategyKt.getEndKeylineSteps(arg0, arg1, arg2, arg3);
    }

    public static final float access$getEndShiftDistance(List arg0, float arg1) {
        return StrategyKt.getEndShiftDistance(arg0, arg1);
    }

    public static final ShiftPointRange access$getShiftPointRange(int arg0, FloatList arg1, float arg2) {
        return StrategyKt.getShiftPointRange(arg0, arg1, arg2);
    }

    public static final List access$getStartKeylineSteps(KeylineList arg0, float arg1, float arg2, float arg3) {
        return StrategyKt.getStartKeylineSteps(arg0, arg1, arg2, arg3);
    }

    public static final float access$getStartShiftDistance(List arg0, float arg1) {
        return StrategyKt.getStartShiftDistance(arg0, arg1);
    }

    public static final FloatList access$getStepInterpolationPoints(float arg0, List arg1, boolean arg2) {
        return StrategyKt.getStepInterpolationPoints(arg0, arg1, arg2);
    }

    public static final float access$lerp(float arg0, float arg1, float arg2, float arg3, float arg4) {
        return StrategyKt.lerp(arg0, arg1, arg2, arg3, arg4);
    }

    private static final KeylineList createShiftedKeylineListForContentPadding(KeylineList arg17, float arg18, float arg19, float arg20, Keyline arg21, int arg22) {
        KeylineList v0 = arg17;
        KeylineList v1 = v0;
        ArrayList v2 = new ArrayList(((List)v1).size());
        int v3 = v1.size();
        int v4 = 0;
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            Object v6 = ((List)v1).get(v5);
            if(!v6.isAnchor()) {
                v2.add(v6);
            }
        }

        float v1_1 = arg20 / (((float)((Collection)v2).size()));
        v1 = KeylineListKt.keylineListOf(arg18, arg19, arg22, arg21.getOffset() - v1_1 / 2f + arg20, new StrategyKt$$ExternalSyntheticLambda1(v0, v1_1));
        v2 = new ArrayList(((List)v1).size());
        v3 = v1.size();
        while(v4 < v3) {
            v2.add(Keyline.copy$default(((List)v1).get(v4), 0f, 0f, v0.get(v4).getUnadjustedOffset(), false, false, false, 0f, 0x7B, null));
            ++v4;
        }

        return new KeylineList(((List)v2));
    }

    static final Unit createShiftedKeylineListForContentPadding$lambda$2(KeylineList arg5, float arg6, KeylineListScope arg7) {
        int v0 = arg5.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = ((List)arg5).get(v1);
            arg7.add(((Keyline)v2).getSize() - Math.abs(arg6), ((Keyline)v2).isAnchor());
        }

        return Unit.INSTANCE;
    }

    private static final List getEndKeylineSteps(KeylineList arg9, float arg10, float arg11, float arg12) {
        if(arg9.isEmpty()) {
            return CollectionsKt.emptyList();
        }

        ArrayList v0 = new ArrayList();
        ((List)v0).add(arg9);
        if(arg9.isLastFocalItemAtEndOfContainer(arg10)) {
            if(arg12 == 0f) {
                return ((List)v0);
            }

            ((List)v0).add(StrategyKt.createShiftedKeylineListForContentPadding(arg9, arg10, arg11, -arg12, arg9.getLastFocal(), arg9.getLastFocalIndex()));
            return ((List)v0);
        }

        float v3 = arg10;
        float v4 = arg11;
        int v10 = arg9.getLastFocalIndex();
        int v11 = arg9.getLastNonAnchorIndex();
        v10 = v11 - v10;
        if(v10 <= 0 && arg9.getLastFocal().getCutoff() > 0f) {
            ((List)v0).add(StrategyKt.moveKeylineAndCreateShiftedKeylineList(arg9, 0, 0, v3, v4));
            return ((List)v0);
        }

        int v5;
        for(v5 = 0; v5 < v10; ++v5) {
            Object v6 = CollectionsKt.last(((List)v0));
            int v7 = v11 - v5;
            v7 = v7 < CollectionsKt.getLastIndex(arg9) ? ((KeylineList)v6).lastIndexBeforeFocalRangeWithSize(arg9.get(v7 + 1).getSize()) + 1 : 0;
            ((List)v0).add(StrategyKt.moveKeylineAndCreateShiftedKeylineList(((KeylineList)v6), arg9.getLastNonAnchorIndex(), v7, v3, v4));
        }

        if(arg12 == 0f) {
            return ((List)v0);
        }

        ((List)v0).set(CollectionsKt.getLastIndex(((List)v0)), StrategyKt.createShiftedKeylineListForContentPadding(CollectionsKt.last(((List)v0)), v3, v4, -arg12, CollectionsKt.last(((List)v0)).getLastFocal(), CollectionsKt.last(((List)v0)).getLastFocalIndex()));
        return ((List)v0);
    }

    private static final float getEndShiftDistance(List arg1, float arg2) {
        if(arg1.isEmpty()) {
            return 0;
        }

        return Math.max(CollectionsKt.last(CollectionsKt.first(arg1)).getUnadjustedOffset() - CollectionsKt.last(CollectionsKt.last(arg1)).getUnadjustedOffset(), arg2);
    }

    private static final ShiftPointRange getShiftPointRange(int arg6, FloatList arg7, float arg8) {
        float v1 = arg7.get(0);
        Iterator v6 = RangesKt.until(1, arg6).iterator();
        while(v6.hasNext()) {
            int v2 = v6.nextInt();
            float v4 = arg7.get(v2);
            if(arg8 <= v4) {
                return new ShiftPointRange(v2 - 1, v2, StrategyKt.lerp(0f, 1f, v1, v4, arg8));
            }

            v1 = v4;
        }

        return new ShiftPointRange(0, 0, 0f);
    }

    private static final List getStartKeylineSteps(KeylineList arg9, float arg10, float arg11, float arg12) {
        if(arg9.isEmpty()) {
            return CollectionsKt.emptyList();
        }

        ArrayList v0 = new ArrayList();
        ((List)v0).add(arg9);
        if(arg9.isFirstFocalItemAtStartOfContainer()) {
            if(arg12 == 0f) {
                return ((List)v0);
            }

            ((List)v0).add(StrategyKt.createShiftedKeylineListForContentPadding(arg9, arg10, arg11, arg12, arg9.getFirstFocal(), arg9.getFirstFocalIndex()));
            return ((List)v0);
        }

        float v3 = arg10;
        float v4 = arg11;
        float v5 = arg12;
        int v10 = arg9.getFirstNonAnchorIndex();
        int v11 = arg9.getFirstFocalIndex() - v10;
        int v12 = 0;
        if(v11 <= 0 && arg9.getFirstFocal().getCutoff() > 0f) {
            ((List)v0).add(StrategyKt.moveKeylineAndCreateShiftedKeylineList(arg9, 0, 0, v3, v4));
            return ((List)v0);
        }

        while(v12 < v11) {
            Object v1 = CollectionsKt.last(((List)v0));
            int v6 = v10 + v12;
            int v7 = CollectionsKt.getLastIndex(arg9);
            if(v6 > 0) {
                v7 = ((KeylineList)v1).firstIndexAfterFocalRangeWithSize(arg9.get(v6 - 1).getSize()) - 1;
            }

            ((List)v0).add(StrategyKt.moveKeylineAndCreateShiftedKeylineList(((KeylineList)v1), arg9.getFirstNonAnchorIndex(), v7, v3, v4));
            ++v12;
        }

        if(v5 == 0f) {
            return ((List)v0);
        }

        ((List)v0).set(CollectionsKt.getLastIndex(((List)v0)), StrategyKt.createShiftedKeylineListForContentPadding(CollectionsKt.last(((List)v0)), v3, v4, v5, CollectionsKt.last(((List)v0)).getFirstFocal(), CollectionsKt.last(((List)v0)).getFirstFocalIndex()));
        return ((List)v0);
    }

    private static final float getStartShiftDistance(List arg1, float arg2) {
        if(arg1.isEmpty()) {
            return 0;
        }

        return Math.max(CollectionsKt.first(CollectionsKt.last(arg1)).getUnadjustedOffset() - CollectionsKt.first(CollectionsKt.first(arg1)).getUnadjustedOffset(), arg2);
    }

    private static final FloatList getStepInterpolationPoints(float arg7, List arg8, boolean arg9) {
        MutableFloatList v1 = FloatListKt.mutableFloatListOf(0f);
        if(arg7 == 0f) {
        }
        else {
            if(arg8.isEmpty()) {
                goto label_6;
            }

            goto label_7;
        }

    label_6:
        return ((FloatList)v1);
    label_7:
        IntRange v0 = RangesKt.until(1, arg8.size());
        ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10));
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            int v3 = v0_1.nextInt();
            int v4 = v3 - 1;
            Object v5 = arg8.get(v4);
            Object v6 = arg8.get(v3);
            float v6_1 = arg9 ? CollectionsKt.first(((List)v6)).getUnadjustedOffset() - CollectionsKt.first(((List)v5)).getUnadjustedOffset() : CollectionsKt.last(((List)v5)).getUnadjustedOffset() - CollectionsKt.last(((List)v6)).getUnadjustedOffset();
            v6_1 /= arg7;
            float v3_1 = v3 == CollectionsKt.getLastIndex(arg8) ? 1f : v1.get(v4) + v6_1;
            ((Collection)v2).add(Boolean.valueOf(v1.add(v3_1)));
        }

        return ((FloatList)v1);
    }

    private static final float lerp(float arg1, float arg2, float arg3, float arg4, float arg5) {
        if(arg5 <= arg3) {
            return arg1;
        }

        if(arg5 >= arg4) {
            return arg2;
        }

        return MathHelpersKt.lerp(arg1, arg2, (arg5 - arg3) / (arg4 - arg3));
    }

    private static final List move(List arg1, int arg2, int arg3) {
        Object v0 = arg1.get(arg2);
        arg1.remove(arg2);
        arg1.add(arg3, v0);
        return arg1;
    }

    private static final KeylineList moveKeylineAndCreateShiftedKeylineList(KeylineList arg3, int arg4, int arg5, float arg6, float arg7) {
        int v0 = arg4 > arg5 ? 1 : -1;
        return KeylineListKt.keylineListOf(arg6, arg7, arg3.getPivotIndex() + v0, arg3.getPivot().getOffset() + (arg3.get(arg4).getSize() - arg3.get(arg4).getCutoff() + arg7) * (((float)v0)), new StrategyKt$$ExternalSyntheticLambda0(arg3, arg4, arg5));
    }

    static final Unit moveKeylineAndCreateShiftedKeylineList$lambda$5(KeylineList arg2, int arg3, int arg4, KeylineListScope arg5) {
        List v2 = StrategyKt.move(CollectionsKt.toMutableList(((Collection)arg2)), arg3, arg4);
        arg3 = v2.size();
        for(arg4 = 0; arg4 < arg3; ++arg4) {
            Object v0 = v2.get(arg4);
            arg5.add(((Keyline)v0).getSize(), ((Keyline)v0).isAnchor());
        }

        return Unit.INSTANCE;
    }
}

