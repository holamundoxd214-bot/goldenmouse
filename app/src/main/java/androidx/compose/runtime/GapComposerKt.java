package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.KeyInfo;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\f\u0010\u0000\u001A\u00020\u0003*\u00020\u0003H\u0000\u001A\u0014\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000\u001A\u001E\u0010\t\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0002\u001A5\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u000F\"\b\b\u0000\u0010\u0010*\u00020\r\"\b\b\u0001\u0010\u0011*\u00020\r2\u0006\u0010\u0012\u001A\u00020\u000BH\u0002¢\u0006\u0002\u0010\u0013\u001A(\u0010\u0014\u001A\u0004\u0018\u00010\r2\b\u0010\u0015\u001A\u0004\u0018\u00010\r2\b\u0010\u0016\u001A\u0004\u0018\u00010\r2\b\u0010\u0017\u001A\u0004\u0018\u00010\rH\u0002\u001A\u001A\u0010\u0018\u001A\u00020\u000B*\b\u0012\u0004\u0012\u00020\u001A0\u00192\u0006\u0010\u001B\u001A\u00020\u000BH\u0002\u001A\u001A\u0010\u001C\u001A\u00020\u000B*\b\u0012\u0004\u0012\u00020\u001A0\u00192\u0006\u0010\u001B\u001A\u00020\u000BH\u0002\u001A,\u0010\u001D\u001A\u00020\u0005*\b\u0012\u0004\u0012\u00020\u001A0\u001E2\u0006\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\rH\u0002\u001A$\u0010\"\u001A\u0004\u0018\u00010\u001A*\b\u0012\u0004\u0012\u00020\u001A0\u001E2\u0006\u0010#\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020\u000BH\u0002\u001A\u001C\u0010%\u001A\u0004\u0018\u00010\u001A*\b\u0012\u0004\u0012\u00020\u001A0\u001E2\u0006\u0010\u001B\u001A\u00020\u000BH\u0002\u001A\"\u0010&\u001A\u00020\u0005*\b\u0012\u0004\u0012\u00020\u001A0\u001E2\u0006\u0010#\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020\u000BH\u0002\u001A7\u0010\'\u001A\u00020\u0005*\b\u0012\u0004\u0012\u00020\u001A0\u00192\u0006\u0010#\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020\u000B2\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u00050)H\u0082\b\u001A\f\u0010*\u001A\u00020\u000B*\u00020+H\u0002\u001A\f\u0010,\u001A\u00020+*\u00020\u000BH\u0002\u001A\u001C\u0010-\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0019*\u00020.2\u0006\u0010/\u001A\u000200H\u0002\u001A\u001C\u00101\u001A\u00020\u000B*\u0002022\u0006\u0010\n\u001A\u00020\u000B2\u0006\u00103\u001A\u00020\u000BH\u0002\u001A$\u00104\u001A\u00020\u000B*\u0002022\u0006\u00105\u001A\u00020\u000B2\u0006\u00106\u001A\u00020\u000B2\u0006\u00107\u001A\u00020\u000BH\u0002\"\u0018\u00108\u001A\u00020\r*\u0002098BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b:\u0010;\"\u001E\u0010<\u001A\u0012\u0012\u0004\u0012\u00020\u001A0=j\b\u0012\u0004\u0012\u00020\u001A`>X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010?\u001A\u00020\u000BX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010@\u001A\u00020\u000BX\u0080T¢\u0006\u0002\n\u0000¨\u0006A"}, d2={"asGapRememberObserverHolder", "Landroidx/compose/runtime/GapRememberObserverHolder;", "Landroidx/compose/runtime/RememberObserverHolder;", "Landroidx/compose/runtime/ReusableGapRememberObserverHolder;", "deactivateCurrentGroup", "", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "removeData", "index", "", "data", "", "multiMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "K", "V", "initialCapacity", "(I)Landroidx/collection/MutableScatterMap;", "getKey", "value", "left", "right", "findLocation", "", "Landroidx/compose/runtime/Invalidation;", "location", "findInsertLocation", "insertIfMissing", "", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "firstInRange", "start", "end", "removeLocation", "removeRange", "forEachInRange", "block", "Lkotlin/Function1;", "asInt", "", "asBool", "collectNodesFrom", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "anchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "distanceFrom", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "root", "nearestCommonRootOf", "a", "b", "common", "joinedKey", "Landroidx/compose/runtime/composer/gapbuffer/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/composer/gapbuffer/KeyInfo;)Ljava/lang/Object;", "InvalidationLocationAscending", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "rootKey", "nodeKey", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class GapComposerKt {
    private static final Comparator InvalidationLocationAscending = null;
    public static final int nodeKey = 0x7D;
    public static final int rootKey = 100;

    static {
        GapComposerKt.InvalidationLocationAscending = new GapComposerKt$$ExternalSyntheticLambda1();
    }

    static final int InvalidationLocationAscending$lambda$0(Invalidation arg0, Invalidation arg1) {
        return Intrinsics.compare(arg0.getLocation(), arg1.getLocation());
    }

    public static final boolean access$asBool(int arg0) {
        return GapComposerKt.asBool(arg0);
    }

    public static final int access$asInt(boolean arg0) {
        return GapComposerKt.asInt(arg0);
    }

    public static final List access$collectNodesFrom(SlotTable arg0, GapAnchor arg1) {
        return GapComposerKt.collectNodesFrom(arg0, arg1);
    }

    public static final int access$findInsertLocation(List arg0, int arg1) {
        return GapComposerKt.findInsertLocation(arg0, arg1);
    }

    public static final Invalidation access$firstInRange(List arg0, int arg1, int arg2) {
        return GapComposerKt.firstInRange(arg0, arg1, arg2);
    }

    public static final Comparator access$getInvalidationLocationAscending$p() {
        return GapComposerKt.InvalidationLocationAscending;
    }

    public static final Object access$getJoinedKey(KeyInfo arg0) {
        return GapComposerKt.getJoinedKey(arg0);
    }

    public static final Object access$getKey(Object arg0, Object arg1, Object arg2) {
        return GapComposerKt.getKey(arg0, arg1, arg2);
    }

    public static final void access$insertIfMissing(List arg0, int arg1, RecomposeScopeImpl arg2, Object arg3) {
        GapComposerKt.insertIfMissing(arg0, arg1, arg2, arg3);
    }

    public static final MutableScatterMap access$multiMap(int arg0) {
        return GapComposerKt.multiMap(arg0);
    }

    public static final int access$nearestCommonRootOf(SlotReader arg0, int arg1, int arg2, int arg3) {
        return GapComposerKt.nearestCommonRootOf(arg0, arg1, arg2, arg3);
    }

    public static final Invalidation access$removeLocation(List arg0, int arg1) {
        return GapComposerKt.removeLocation(arg0, arg1);
    }

    public static final void access$removeRange(List arg0, int arg1, int arg2) {
        GapComposerKt.removeRange(arg0, arg1, arg2);
    }

    private static final boolean asBool(int arg0) {
        if(arg0 != 0) {
            return 1;
        }

        return 0;
    }

    public static final GapRememberObserverHolder asGapRememberObserverHolder(RememberObserverHolder arg1) {
        if((arg1 instanceof GapRememberObserverHolder)) {
        }
        else {
            arg1 = null;
        }

        if(0 != 0) {
            return arg1;
        }

        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    public static final ReusableGapRememberObserverHolder asGapRememberObserverHolder(ReusableGapRememberObserverHolder arg1) {
        if((arg1 instanceof ReusableGapRememberObserverHolder)) {
        }
        else {
            arg1 = null;
        }

        if(0 != 0) {
            return arg1;
        }

        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    private static final int asInt(boolean arg0) {
        return arg0;
    }

    private static final List collectNodesFrom(SlotTable arg2, GapAnchor arg3) {
        ArrayList v0 = new ArrayList();
        SlotReader v1 = arg2.openReader();
        try {
            GapComposerKt.collectNodesFrom$lambda$0$collectFromGroup(v1, ((List)v0), arg2.anchorIndex(arg3));
        }
        catch(Throwable v2) {
            v1.close();
            throw v2;
        }

        v1.close();
        return ((List)v0);
    }

    private static final void collectNodesFrom$lambda$0$collectFromGroup(SlotReader arg2, List arg3, int arg4) {
        if(arg2.isNode(arg4)) {
            arg3.add(arg2.node(arg4));
            return;
        }

        int v0 = arg4 + 1;
        arg4 += arg2.groupSize(arg4);
        while(v0 < arg4) {
            GapComposerKt.collectNodesFrom$lambda$0$collectFromGroup(arg2, arg3, v0);
            v0 += arg2.groupSize(v0);
        }
    }

    public static final void deactivateCurrentGroup(SlotWriter arg2, RememberManager arg3) {
        arg2.forAllDataInRememberOrder(arg2.getCurrentGroup(), new GapComposerKt$$ExternalSyntheticLambda0(arg3, arg2));
    }

    static final Unit deactivateCurrentGroup$lambda$0(RememberManager arg1, SlotWriter arg2, int arg3, Object arg4) {
        if((arg4 instanceof ComposeNodeLifecycleCallback)) {
            arg1.deactivating(((ComposeNodeLifecycleCallback)arg4));
        }
        else if(!(arg4 instanceof ReusableRememberObserverHolder)) {
            if((arg4 instanceof RememberObserverHolder)) {
                GapComposerKt.removeData(arg2, arg3, arg4);
                arg1.forgetting(((RememberObserverHolder)arg4));
            }
            else if((arg4 instanceof RecomposeScopeImpl)) {
                GapComposerKt.removeData(arg2, arg3, arg4);
                ((RecomposeScopeImpl)arg4).release();
            }
        }

        return Unit.INSTANCE;
    }

    private static final int distanceFrom(SlotReader arg1, int arg2, int arg3) {
        int v0;
        for(v0 = 0; arg2 > 0; ++v0) {
            if(arg2 == arg3) {
                return v0;
            }

            arg2 = arg1.parent(arg2);
        }

        return v0;
    }

    private static final int findInsertLocation(List arg0, int arg1) {
        int v0 = GapComposerKt.findLocation(arg0, arg1);
        if(v0 < 0) {
            v0 = -(v0 + 1);
        }

        return v0;
    }

    private static final int findLocation(List arg4, int arg5) {
        int v2;
        int v0 = arg4.size() - 1;
        int v1 = 0;
        while(true) {
            if(v1 > v0) {
                goto label_16;
            }

            v2 = v1 + v0 >>> 1;
            int v3 = Intrinsics.compare(arg4.get(v2).getLocation(), arg5);
            if(v3 < 0) {
                v1 = v2 + 1;
                continue;
            }

            if(v3 <= 0) {
                return v2;
            }

            v0 = v2 - 1;
        }

        return v2;
    label_16:
        return -(v1 + 1);
    }

    private static final Invalidation firstInRange(List arg1, int arg2, int arg3) {
        arg2 = GapComposerKt.findInsertLocation(arg1, arg2);
        if(arg2 < arg1.size()) {
            Object v1 = arg1.get(arg2);
            if(((Invalidation)v1).getLocation() < arg3) {
                return ((Invalidation)v1);
            }
        }

        return null;
    }

    private static final void forEachInRange(List arg2, int arg3, int arg4, Function1 arg5) {
        for(arg3 = GapComposerKt.findInsertLocation(arg2, arg3); arg3 < arg2.size(); ++arg3) {
            Object v0 = arg2.get(arg3);
            if(((Invalidation)v0).getLocation() >= arg4) {
                return;
            }

            arg5.invoke(v0);
        }
    }

    private static final Object getJoinedKey(KeyInfo arg2) {
        if(arg2.getObjectKey() != null) {
            return new JoinedKey(Integer.valueOf(arg2.getKey()), arg2.getObjectKey());
        }

        return Integer.valueOf(arg2.getKey());
    }

    private static final Object getKey(Object arg2, Object arg3, Object arg4) {
        Object v1 = null;
        Object v0 = (arg2 instanceof JoinedKey) ? arg2 : v1;
        if(v0 != null) {
            if((Intrinsics.areEqual(((JoinedKey)v0).getLeft(), arg3)) && (Intrinsics.areEqual(((JoinedKey)v0).getRight(), arg4))) {
                return arg2;
            }

            arg2 = GapComposerKt.getKey(((JoinedKey)v0).getLeft(), arg3, arg4);
            if(arg2 == null) {
                arg2 = GapComposerKt.getKey(((JoinedKey)v0).getRight(), arg3, arg4);
            }

            return arg2;
        }

        return v1;
    }

    private static final void insertIfMissing(List arg3, int arg4, RecomposeScopeImpl arg5, Object arg6) {
        int v0 = GapComposerKt.findLocation(arg3, arg4);
        Object v1 = null;
        if(v0 < 0) {
            v0 = -(v0 + 1);
            if((arg6 instanceof DerivedState)) {
            }
            else {
                arg6 = v1;
            }

            arg3.add(v0, new Invalidation(arg5, arg4, arg6));
            return;
        }

        Object v3 = arg3.get(v0);
        if((arg6 instanceof DerivedState)) {
            Object v4 = ((Invalidation)v3).getInstances();
            if(v4 == null) {
                ((Invalidation)v3).setInstances(arg6);
                return;
            }

            if((v4 instanceof MutableScatterSet)) {
                ((MutableScatterSet)v4).add(arg6);
                return;
            }

            ((Invalidation)v3).setInstances(ScatterSetKt.mutableScatterSetOf(v4, arg6));
            return;
        }

        ((Invalidation)v3).setInstances(v1);
    }

    private static final MutableScatterMap multiMap(int arg1) {
        return MultiValueMap.constructor-impl(new MutableScatterMap(arg1));
    }

    private static final int nearestCommonRootOf(SlotReader arg4, int arg5, int arg6, int arg7) {
        if(arg5 == arg6) {
        }
        else {
            if(arg5 != arg7) {
                if(arg6 == arg7) {
                }
                else if(arg4.parent(arg5) == arg6) {
                    return arg6;
                }
                else if(arg4.parent(arg6) == arg5) {
                    return arg5;
                }
                else {
                    goto label_11;
                }
            }

            return arg7;
        }

        return arg5;
    label_11:
        if(arg4.parent(arg5) == arg4.parent(arg6)) {
            return arg4.parent(arg5);
        }
        else {
            int v0 = GapComposerKt.distanceFrom(arg4, arg5, arg7);
            arg7 = GapComposerKt.distanceFrom(arg4, arg6, arg7);
            int v1 = v0 - arg7;
            int v2 = 0;
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                arg5 = arg4.parent(arg5);
            }

            arg7 -= v0;
            while(v2 < arg7) {
                arg6 = arg4.parent(arg6);
                ++v2;
            }

            while(arg5 != arg6) {
                arg5 = arg4.parent(arg5);
                arg6 = arg4.parent(arg6);
            }

            return arg5;
        }

        return arg7;
    }

    private static final void removeData(SlotWriter arg1, int arg2, Object arg3) {
        Object v1 = arg1.clear(arg2);
        arg2 = arg3 == v1 ? 1 : 0;
        if(arg2 == 0) {
            ComposerKt.composeImmediateRuntimeError("Slot table is out of sync (expected " + arg3 + ", got " + v1 + ')');
        }
    }

    private static final Invalidation removeLocation(List arg0, int arg1) {
        arg1 = GapComposerKt.findLocation(arg0, arg1);
        if(arg1 >= 0) {
            return arg0.remove(arg1);
        }

        return null;
    }

    private static final void removeRange(List arg1, int arg2, int arg3) {
        arg2 = GapComposerKt.findInsertLocation(arg1, arg2);
        while(arg2 < arg1.size()) {
            if(arg1.get(arg2).getLocation() >= arg3) {
                return;
            }

            arg1.remove(arg2);
        }
    }
}

