package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableAddressSpace;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0096\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0014\u0010\u0007\u001A\u00060\u0002j\u0002`\u0001*\u00060\u0002j\u0002`\u0001H\u0002\u001A\u0015\u0010\b\u001A\u00060\u0002j\u0002`\u0001*\u00060\u0002j\u0002`\u0005H\u0082\b\u001A\u0015\u0010\b\u001A\u00060\u0002j\u0002`\u0001*\u00060\tj\u0002`\nH\u0082\b\u001A\f\u0010\u000B\u001A\u00020\f*\u00020\rH\u0000\u001A\f\u0010\u000E\u001A\u00020\u000F*\u00020\u0010H\u0000\u001A\f\u0010\u000E\u001A\u00020\u0011*\u00020\u0012H\u0000\u001A\u001B\u0010\u0013\u001A\u0004\u0018\u00010\t*\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0000¢\u0006\u0002\u0010\u0017\u001AE\u0010\u0018\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u001C0\u001A0\u0019*\u00020\u001D2\n\u0010\u001E\u001A\u00060\tj\u0002`\n2\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u001C0 H\u0000¢\u0006\u0004\b!\u0010\"\u001A\u001A\u0010#\u001A\u0004\u0018\u00010\u001B*\u00020\u001D2\n\u0010\u001E\u001A\u00060\tj\u0002`\nH\u0000\u001A4\u0010$\u001A\b\u0012\u0004\u0012\u0002H&0%\"\u0004\b\u0000\u0010&2\u001D\u0010\'\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H&0)\u0012\u0004\u0012\u00020*0(¢\u0006\u0002\b+H\u0082\b\u001A5\u0010,\u001A\u000E\u0012\u0004\u0012\u0002H.\u0012\u0004\u0012\u0002H/0-\"\b\b\u0000\u0010.*\u00020\u001C\"\b\b\u0001\u0010/*\u00020\u001C2\u0006\u00100\u001A\u00020\tH\u0002¢\u0006\u0002\u00101\u001A(\u00102\u001A\u0004\u0018\u00010\u001C2\b\u00103\u001A\u0004\u0018\u00010\u001C2\b\u00104\u001A\u0004\u0018\u00010\u001C2\b\u00105\u001A\u0004\u0018\u00010\u001CH\u0002\u001A\f\u00106\u001A\u00020\t*\u00020\u0004H\u0002\u001A\f\u00107\u001A\u00020\u0004*\u00020\tH\u0002\u001A(\u00108\u001A\u00060\u0002j\u0002`\u0001*\u00020\u00142\n\u00109\u001A\u00060\u0002j\u0002`\u00012\n\u0010:\u001A\u00060\u0002j\u0002`\u0001H\u0002\u001A4\u0010;\u001A\u00060\tj\u0002`\n*\u00020<2\n\u0010=\u001A\u00060\tj\u0002`\n2\n\u00109\u001A\u00060\tj\u0002`\n2\n\u0010:\u001A\u00060\tj\u0002`\nH\u0002\u001A%\u0010>\u001A\u00020\u0004*\u00020<2\n\u0010=\u001A\u00060\tj\u0002`\n2\n\u0010?\u001A\u00060\tj\u0002`\nH\u0082\b\u001A \u0010@\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001C0\u0019*\u00020\u00142\n\u0010\u001E\u001A\u00060\tj\u0002`\nH\u0002\"\u001C\u0010\u0003\u001A\u00020\u0004*\u00060\u0002j\u0002`\u00058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0006*\u0010\b\u0002\u0010\u0000\"\u0002`\u00012\u00060\u0002j\u0002`\u0001¨\u0006A"}, d2={"VirtualGroupHandle", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "", "isInsertHandle", "", "Landroidx/compose/runtime/VirtualGroupHandle;", "(J)Z", "toInsertAddress", "toGroupHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "asLinkComposer", "Landroidx/compose/runtime/LinkComposer;", "Landroidx/compose/runtime/Composer;", "asLinkRememberObserverHolder", "Landroidx/compose/runtime/LinkRememberObserverHolder;", "Landroidx/compose/runtime/RememberObserverHolder;", "Landroidx/compose/runtime/ReusableLinkRememberObserverHolder;", "Landroidx/compose/runtime/ReusableRememberObserverHolder;", "findSubcompositionContextGroup", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "context", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;Landroidx/compose/runtime/CompositionContext;)Ljava/lang/Integer;", "findInvalidations", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "group", "invalidations", "Landroidx/compose/runtime/collection/ScopeMap;", "findInvalidations-Vpaz1Sg", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;ILandroidx/collection/MutableScatterMap;)Ljava/util/List;", "getRecomposeScopeOrNull", "buildScatterSet", "Landroidx/collection/ScatterSet;", "T", "builderAction", "Lkotlin/Function1;", "Landroidx/collection/MutableScatterSet;", "", "Lkotlin/ExtensionFunctionType;", "multiMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "K", "V", "initialCapacity", "(I)Landroidx/collection/MutableScatterMap;", "getKey", "value", "left", "right", "asInt", "asBool", "firstGroupInTopologicalOrder", "a", "b", "findFirstSibling", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "parent", "childOf", "child", "collectNodesFrom", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LinkComposerKt {
    public static final boolean access$asBool(int arg0) {
        return LinkComposerKt.asBool(arg0);
    }

    public static final int access$asInt(boolean arg0) {
        return LinkComposerKt.asInt(arg0);
    }

    public static final List access$collectNodesFrom(SlotTable arg0, int arg1) {
        return LinkComposerKt.collectNodesFrom(arg0, arg1);
    }

    public static final long access$firstGroupInTopologicalOrder(SlotTable arg0, long arg1, long arg3) {
        return LinkComposerKt.firstGroupInTopologicalOrder(arg0, arg1, arg3);
    }

    public static final Object access$getKey(Object arg0, Object arg1, Object arg2) {
        return LinkComposerKt.getKey(arg0, arg1, arg2);
    }

    public static final boolean access$isInsertHandle(long arg0) {
        return LinkComposerKt.isInsertHandle(arg0);
    }

    public static final MutableScatterMap access$multiMap(int arg0) {
        return LinkComposerKt.multiMap(arg0);
    }

    public static final long access$toInsertAddress(long arg0) {
        return LinkComposerKt.toInsertAddress(arg0);
    }

    private static final boolean asBool(int arg0) {
        if(arg0 != 0) {
            return 1;
        }

        return 0;
    }

    private static final int asInt(boolean arg0) {
        return arg0;
    }

    public static final LinkComposer asLinkComposer(Composer arg1) {
        if((arg1 instanceof LinkComposer)) {
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

    public static final LinkRememberObserverHolder asLinkRememberObserverHolder(RememberObserverHolder arg1) {
        if((arg1 instanceof LinkRememberObserverHolder)) {
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

    public static final ReusableLinkRememberObserverHolder asLinkRememberObserverHolder(ReusableRememberObserverHolder arg1) {
        if((arg1 instanceof ReusableLinkRememberObserverHolder)) {
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

    private static final ScatterSet buildScatterSet(Function1 arg1) {
        MutableScatterSet v0 = ScatterSetKt.mutableScatterSetOf();
        arg1.invoke(v0);
        return ((ScatterSet)v0);
    }

    private static final boolean childOf(SlotTableAddressSpace arg2, int arg3, int arg4) {
        int v1;
        int[] v2 = arg2.getGroups();
        int v0;
        for(v0 = arg4; true; v0 = v2[v0 + 2]) {
            v1 = 1;
            if(v0 <= 0) {
                break;
            }

            if(v0 == arg3) {
                return 1;
            }
        }

        if(v0 != 0) {
        }
        else {
            v1 = 0;
        }

        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg4);
        }

        return 0;
    }

    private static final List collectNodesFrom(SlotTable arg6, int arg7) {
        int v4;
        ArrayList v0 = new ArrayList();
        SlotTableReader v6 = arg6.openReader();
        try {
            SlotTableAddressSpace v1 = SlotTableReader.access$getAddressSpace$p(v6);
            if(arg7 >= 0) {
                IntStack v2 = new IntStack();
                int[] v1_1 = v1.getGroups();
                int v3;
                for(v3 = arg7; true; v3 = v2.pop()) {
                label_9:
                    if(v6.isNode(v3)) {
                        ((List)v0).add(v6.node(v3));
                        v4 = 0;
                    }
                    else {
                        v4 = 1;
                    }

                    if(v3 != arg7) {
                        int v5 = v1_1[v3 + 1];
                        if(v5 >= 0) {
                            v2.push(v5);
                        }
                    }

                    v3 = v1_1[v3 + 3];
                    if(v4 != 0 && v3 >= 0) {
                        goto label_9;
                    }

                    if(v2.tos == 0) {
                        break;
                    }
                }
            }
        }
        catch(Throwable v7) {
            v6.close();
            throw v7;
        }

        v6.close();
        return ((List)v0);
    }

    private static final int findFirstSibling(SlotTableAddressSpace arg1, int arg2, int arg3, int arg4) {
        int v0 = -1;
        if(arg3 == v0) {
        }
        else {
            if(arg4 == v0) {
            }
            else {
                int[] v1 = arg1.getGroups();
                arg2 = v1[arg2 + 3];
                while(true) {
                    if(arg2 <= 0) {
                        break;
                    }
                    else if(arg2 != arg3) {
                        if(arg2 != arg4) {
                            arg2 = v1[arg2 + 1];
                            continue;
                        }
                        else {
                            return arg4;
                        }
                    }

                    return arg3;
                }

                ComposerKt.composeRuntimeError("Unexpected slot table structure");
                throw new KotlinNothingValueException();
            }

            return arg3;
        }

        return arg4;
    }

    public static final List findInvalidations-Vpaz1Sg(SlotTableReader arg17, int arg18, MutableScatterMap arg19) {
        int v7_1;
        int v0 = arg18;
        if(ScopeMap.isEmpty-impl(arg19)) {
            return CollectionsKt.emptyList();
        }

        List v1 = CollectionsKt.createListBuilder();
        MutableScatterSet v2 = ScatterSetKt.mutableScatterSetOf();
        SlotTableAddressSpace v3 = arg17.getTable().getAddressSpace();
        if(v0 >= 0) {
            IntStack v4 = new IntStack();
            int[] v3_1 = v3.getGroups();
            SlotTableReader v5 = arg17;
            int v6;
            for(v6 = v0; true; v6 = v4.pop()) {
            label_15:
                RecomposeScopeImpl v7 = LinkComposerKt.getRecomposeScopeOrNull(v5, v6);
                if(v7 != null) {
                    v2.add(v7);
                }

                if(v6 != v0) {
                    v7_1 = v3_1[v6 + 1];
                    if(v7_1 >= 0) {
                        v4.push(v7_1);
                    }
                }

                v6 = v3_1[v6 + 3];
                if(v6 >= 0) {
                    goto label_15;
                }

                if(v4.tos == 0) {
                    break;
                }
            }
        }

        Object[] v3_2 = arg19.keys;
        Object[] v4_1 = arg19.values;
        long[] v0_1 = arg19.metadata;
        int v5_1 = v0_1.length - 2;
        if(v5_1 >= 0) {
            for(v7_1 = 0; true; ++v7_1) {
                long v8 = v0_1[v7_1];
                if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                    int v11 = 8;
                    int v10 = 8 - (~(v7_1 - v5_1) >>> 0x1F);
                    int v12;
                    for(v12 = 0; v12 < v10; ++v12) {
                        if((0xFF & v8) < 0x80) {
                            int v13 = (v7_1 << 3) + v12;
                            Object v14 = v3_2[v13];
                            Object v13_1 = v4_1[v13];
                            Intrinsics.checkNotNull(v14, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                            if(((ScatterSet)v2).contains(v14)) {
                                v1.add(TuplesKt.to(v14, v13_1));
                            }
                        }

                        v8 >>= v11;
                    }

                    if(v10 != v11) {
                        break;
                    }
                }

                if(v7_1 == v5_1) {
                    break;
                }
            }
        }

        return CollectionsKt.build(v1);
    }

    public static final Integer findSubcompositionContextGroup(SlotTable arg11, CompositionContext arg12) {
        Integer v11_1;
        int v6_1;
        int v5;
        Integer v3;
        int v2;
        SlotTableReader v0 = arg11.openReader();
        try {
            int v1 = arg11.getRoot();
            v2 = v0.firstChildOf(v1);
        label_3:
            v3 = null;
            int v4 = -1;
            if(v2 != v4) {
                if((arg11.groupFlags$runtime(v2) & 0x40000000) == 0x40000000) {
                    v5 = SlotTable.access$getGroups(arg11)[v2 + 5];
                    if(v5 != v4) {
                        SlotTableAddressSpace v6 = arg11.getAddressSpace();
                        int v7 = (v5 & 15) + 1;
                        v5 >>= 4;
                        if(v7 > 15) {
                            v7 = SlotTableAddressSpace.access$getLargeSizes(v6).get(v5);
                        }

                        v6_1 = 0;
                        while(true) {
                        label_23:
                            if(v6_1 >= v7) {
                                goto label_52;
                            }

                            Object v8 = SlotTable.access$getSlots(arg11)[v5 + v6_1];
                            if(Intrinsics.areEqual(v8, Composer.Companion.getEmpty())) {
                                goto label_52;
                            }

                            if((v8 instanceof RememberObserverHolder)) {
                            }
                            else {
                                v8 = v3;
                            }

                            RememberObserver v8_1 = v8 != null ? ((RememberObserverHolder)v8).getWrapped() : ((RememberObserver)v3);
                            if((v8_1 instanceof CompositionContextHolder)) {
                            }
                            else {
                                v8_1 = ((RememberObserver)v3);
                            }

                            if(v8_1 != null && (Intrinsics.areEqual(((CompositionContextHolder)v8_1).getRef(), arg12))) {
                                v11_1 = Integer.valueOf(v2);
                                goto label_48;
                            }

                            goto label_50;
                        }
                    }
                }

                goto label_52;
            }

            goto label_71;
        }
        catch(Throwable v11) {
            goto label_75;
        }

    label_48:
        v0.close();
        return v11_1;
    label_50:
        ++v6_1;
        goto label_23;
        try {
        label_52:
            v5 = v0.firstChildOf(v2);
            if(v5 != v4 && (arg11.groupFlags$runtime(v2) & 0x80000000) == 0x80000000) {
                v2 = v5;
                goto label_3;
            }

            v5 = v2;
            for(v2 = v0.nextSiblingOf(v2); true; v2 = v0.nextSiblingOf(v5)) {
                if(v2 != v4) {
                    goto label_3;
                }

                v5 = v0.parentOf(v5);
                if(v5 == v4) {
                    break;
                }

                if(v5 == v1) {
                    break;
                }
            }

        label_71:
        }
        catch(Throwable v11) {
            goto label_75;
        }

        v0.close();
        return v3;
    label_75:
        v0.close();
        throw v11;
    }

    private static final long firstGroupInTopologicalOrder(SlotTable arg12, long arg13, long arg15) {
        String v12_1;
        int v11;
        int v8_1;
        int v3_1;
        int v7;
        int v2;
        if(arg13 == arg15) {
        }
        else {
            SlotTableAddressSpace v0 = arg12.getAddressSpace();
            int[] v1 = v0.getGroups();
            String v3 = "Traversing parent of group not in the slot table: ";
            int v4 = 1;
            int v6 = -1;
            if(GroupHandleKt.getGroup(arg13) != v6) {
                v2 = GroupHandleKt.getGroup(arg13);
            }
            else if(GroupHandleKt.getGroup(arg15) == v6) {
                v2 = GroupHandleKt.getContext(arg13);
            }
            else {
                v2 = GroupHandleKt.getContext(arg13);
                v7 = GroupHandleKt.getGroup(arg15);
                int[] v8 = v0.getGroups();
                int v9 = v7;
                while(true) {
                    if(v9 <= 0) {
                        break;
                    }
                    else if(v9 == v2) {
                        return arg15;
                    }
                    else {
                        v9 = v8[v9 + 2];
                        continue;
                    }

                    goto label_37;
                }

                v2 = v9 != 0 ? 1 : 0;
                if(v2 == 0) {
                    ComposerKt.composeImmediateRuntimeError(v3 + v7);
                }

                v2 = GroupHandleKt.getContext(arg13);
            }

        label_37:
            if(GroupHandleKt.getGroup(arg15) != v6) {
                v3_1 = GroupHandleKt.getGroup(arg15);
            }
            else if(GroupHandleKt.getGroup(arg13) == v6) {
                v3_1 = GroupHandleKt.getContext(arg15);
            }
            else {
                v7 = GroupHandleKt.getContext(arg15);
                v8_1 = GroupHandleKt.getGroup(arg13);
                int[] v9_1 = v0.getGroups();
                int v10 = v8_1;
                while(true) {
                    if(v10 <= 0) {
                        break;
                    }
                    else if(v10 == v7) {
                        return arg13;
                    }
                    else {
                        v10 = v9_1[v10 + 2];
                        continue;
                    }

                    goto label_66;
                }

                v7 = v10 != 0 ? 1 : 0;
                if(v7 == 0) {
                    ComposerKt.composeImmediateRuntimeError(v3 + v8_1);
                }

                v3_1 = GroupHandleKt.getContext(arg15);
            }

        label_66:
            if(v2 == v3_1) {
                return arg13;
            }

            v7 = v2 == v6 ? v6 : v1[v2 + 2];
            if(v3_1 == v6) {
            }
            else {
                v6 = v1[v3_1 + 2];
            }

            if(v7 == v3_1) {
            }
            else {
                if(v6 == v2) {
                }
                else {
                    if(v7 != v6) {
                        v8_1 = v0.distanceFrom$runtime(v2, arg12.getRoot());
                        int v12 = v0.distanceFrom$runtime(v3_1, arg12.getRoot());
                        if(v8_1 > v12) {
                            v8_1 -= v12;
                            v12 = 0;
                            while(v12 < v8_1) {
                                ++v12;
                                v11 = v7;
                                v7 = v1[v7 + 2];
                                v2 = v11;
                            }

                            if(v2 == v3_1) {
                                return arg15;
                            }
                        }
                        else {
                            v12 -= v8_1;
                            v8_1 = 0;
                            while(v8_1 < v12) {
                                ++v8_1;
                                v11 = v6;
                                v6 = v1[v6 + 2];
                                v3_1 = v11;
                            }

                            if(v3_1 == v2) {
                                return arg13;
                            }
                        }

                        while(v7 != v6) {
                            v12 = v1[v7 + 2];
                            v3_1 = v6;
                            v6 = v1[v6 + 2];
                            v2 = v7;
                            v7 = v12;
                        }
                    }

                    if(v2 != v3_1) {
                    }
                    else {
                        v4 = 0;
                    }

                    v12_1 = "Unexpected slot table structure";
                    if(v4 == 0) {
                        ComposerKt.composeImmediateRuntimeError(v12_1);
                    }

                    int v0_1 = LinkComposerKt.findFirstSibling(v0, v7, v2, v3_1);
                    if(v0_1 != v2) {
                        goto label_130;
                    }
                }

                return arg13;
            }

            return arg15;
        }

        return arg13;
    label_130:
        if(v0_1 == v3_1) {
            return arg15;
        }

        ComposerKt.composeRuntimeError(v12_1);
        throw new KotlinNothingValueException();
    }

    private static final Object getKey(Object arg2, Object arg3, Object arg4) {
        Object v1 = null;
        Object v0 = (arg2 instanceof JoinedKey) ? arg2 : v1;
        if(v0 != null) {
            if((Intrinsics.areEqual(((JoinedKey)v0).getLeft(), arg3)) && (Intrinsics.areEqual(((JoinedKey)v0).getRight(), arg4))) {
                return arg2;
            }

            arg2 = LinkComposerKt.getKey(((JoinedKey)v0).getLeft(), arg3, arg4);
            if(arg2 == null) {
                arg2 = LinkComposerKt.getKey(((JoinedKey)v0).getRight(), arg3, arg4);
            }

            return arg2;
        }

        return v1;
    }

    public static final RecomposeScopeImpl getRecomposeScopeOrNull(SlotTableReader arg1, int arg2) {
        Object v1 = arg1.getOrNull(arg2, 0);
        if((v1 instanceof RecomposeScopeImpl)) {
            return ((RecomposeScopeImpl)v1);
        }

        return null;
    }

    private static final boolean isInsertHandle(long arg0) {
        if(GroupHandleKt.getGroup(arg0) < -8) {
            return 1;
        }

        return 0;
    }

    private static final MutableScatterMap multiMap(int arg1) {
        return MultiValueMap.constructor-impl(new MutableScatterMap(arg1));
    }

    private static final long toGroupHandle(int arg4) {
        return (((long)UInt.constructor-impl(arg4))) & 0xFFFFFFFFL;
    }

    private static final long toGroupHandle(long arg0) {
        LinkComposerKt.isInsertHandle(arg0);
        return arg0;
    }

    private static final long toInsertAddress(long arg4) {
        return (((long)UInt.constructor-impl(-10 - GroupHandleKt.getGroup(arg4)))) & 0xFFFFFFFFL | (((long)GroupHandleKt.getContext(arg4))) << 0x20;
    }
}

