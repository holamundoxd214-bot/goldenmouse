package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.GapComposer$CompositionContextHolder;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A9\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\u0010\t\u001A\u0012\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\nH\u0000\u001A$\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\n2\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\u0000\u001A3\u0010\f\u001A\u0004\u0018\u00010\r*\u00020\u000E2#\u0010\u000F\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0010H\u0000\u001A\u001B\u0010\u0015\u001A\u0004\u0018\u00010\u0007*\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u0017H\u0000¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2={"buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "child", "", "group", "", "parent", "(Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;Ljava/lang/Object;ILjava/lang/Integer;)Ljava/util/List;", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "traceForGroup", "findLocation", "Landroidx/compose/runtime/tooling/ObjectLocation;", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "filter", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "findSubcompositionContextGroup", "context", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;Landroidx/compose/runtime/CompositionContext;)Ljava/lang/Integer;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ComposeStackTraceBuilderKt {
    public static final List buildTrace(SlotReader arg6) {
        if(!arg6.getClosed() && arg6.getSize() != 0) {
            ReaderTraceBuilder v0 = new ReaderTraceBuilder(arg6);
            int v1 = arg6.getParent();
            Integer v2 = Integer.valueOf(arg6.getSlot());
            while(v1 >= 0) {
                Object v3 = arg6.hasObjectKey(v1) ? arg6.groupObjectKey(v1) : Composer.Companion.getEmpty();
                v0.processEdge(arg6.groupKey(v1), v3, arg6.getTable$runtime().sourceInformationOf(v1), v2);
                GapAnchor v2_1 = arg6.anchor(v1);
                v1 = arg6.parent(v1);
            }

            return v0.trace();
        }

        return CollectionsKt.emptyList();
    }

    public static final List buildTrace(SlotWriter arg5, Object arg6, int arg7, Integer arg8) {
        int v1;
        Integer v6;
        int v8;
        WriterTraceBuilder v0;
        if(!arg5.getClosed() && arg5.getSize$runtime() != 0) {
            v0 = new WriterTraceBuilder(arg5);
            if(arg8 != null) {
                v8 = arg8.intValue();
            }
            else if(arg5.getParent() < 0) {
                v8 = arg5.parent(arg7);
            }
            else {
                v8 = arg5.getParent();
            }

            if(arg6 == null) {
                v6 = Integer.valueOf(arg5.groupSlotIndex(arg7));
            }

            if(arg5.isValid(arg7)) {
                v1 = arg5.groupKey(arg7);
                goto label_27;
            }
            else {
                arg7 = v8 >= 0 ? arg5.parent(v8) : v8;
                v1 = arg5.groupKey(v8);
            }

            goto label_40;
        }

        return CollectionsKt.emptyList();
    label_27:
        while(arg7 >= 0) {
            Object v2 = arg5.hasObjectKey(arg7) ? arg5.groupObjectKey(arg7) : Composer.Companion.getEmpty();
            v0.processEdge(v1, v2, arg5.sourceInformationOf$runtime(arg7), v6);
            GapAnchor v6_1 = arg5.anchor(arg7);
            if(v8 >= 0) {
                arg7 = arg5.parent(v8);
                v1 = arg5.groupKey(v8);
                goto label_40;
            }

            arg7 = v8;
        }

        return v0.trace();
    label_40:
        int v4 = v8;
        v8 = arg7;
        arg7 = v4;
        goto label_27;
    }

    public static List buildTrace$default(SlotWriter arg1, Object arg2, int arg3, Integer arg4, int arg5, Object arg6) {
        Object v0 = null;
        if((arg5 & 1) != 0) {
            arg2 = v0;
        }

        if((arg5 & 2) != 0) {
            arg3 = arg1.getCurrentGroup();
        }

        if((arg5 & 4) != 0) {
            arg4 = ((Integer)v0);
        }

        return ComposeStackTraceBuilderKt.buildTrace(arg1, arg2, arg3, arg4);
    }

    public static final ObjectLocation findLocation(SlotTable arg6, Function1 arg7) {
        int v4_1;
        ObjectLocation v6_1;
        Integer v4;
        SlotReader v0 = arg6.openReader();
        int v2 = 0;
        try {
            while(true) {
            label_3:
                v4 = null;
                if(v2 >= arg6.getGroupsSize()) {
                    goto label_32;
                }

                if((v0.isNode(v2)) && (arg7.invoke(v0.node(v2)).booleanValue())) {
                    v6_1 = new ObjectLocation(v2, v4);
                    break;
                }

                goto label_16;
            }
        }
        catch(Throwable v6) {
            goto label_36;
        }

        v0.close();
        return v6_1;
        try {
        label_16:
            int v3 = v0.slotSize(v2);
            v4_1 = 0;
            while(true) {
            label_18:
                if(v4_1 >= v3) {
                    goto label_30;
                }

                if(!arg7.invoke(v0.groupGet(v2, v4_1)).booleanValue()) {
                    goto label_28;
                }

                v6_1 = new ObjectLocation(v2, Integer.valueOf(v4_1));
                break;
            }
        }
        catch(Throwable v6) {
            goto label_36;
        }

        v0.close();
        return v6_1;
    label_28:
        ++v4_1;
        goto label_18;
    label_30:
        ++v2;
        goto label_3;
    label_32:
        goto label_33;
    label_36:
        v0.close();
        throw v6;
    label_33:
        v0.close();
        return ((ObjectLocation)v4);
    }

    public static final Integer findSubcompositionContextGroup(SlotTable arg2, CompositionContext arg3) {
        Integer v3_1;
        SlotReader v2 = arg2.openReader();
        try {
            v3_1 = ComposeStackTraceBuilderKt.findSubcompositionContextGroup$lambda$0$scanGroup(v2, arg3, 0, v2.getSize());
        }
        catch(Throwable v3) {
            v2.close();
            throw v3;
        }

        v2.close();
        return v3_1;
    }

    private static final Integer findSubcompositionContextGroup$lambda$0$scanGroup(SlotReader arg4, CompositionContext arg5, int arg6, int arg7) {
        RememberObserver v0;
        while(true) {
            v0 = null;
            if(arg6 >= arg7) {
                break;
            }

            int v1 = arg4.groupSize(arg6) + arg6;
            if((arg4.hasMark(arg6)) && arg4.groupKey(arg6) == 206 && (Intrinsics.areEqual(arg4.groupObjectKey(arg6), ComposerKt.getReference()))) {
                Object v2 = arg4.groupGet(arg6, 0);
                if((v2 instanceof RememberObserverHolder)) {
                }
                else {
                    v2 = v0;
                }

                RememberObserver v2_1 = v2 != null ? ((RememberObserverHolder)v2).getWrapped() : v0;
                if((v2_1 instanceof CompositionContextHolder)) {
                    v0 = v2_1;
                }

                if(v0 == null) {
                    goto label_32;
                }

                if(!Intrinsics.areEqual(((CompositionContextHolder)v0).getRef(), arg5)) {
                    goto label_32;
                }

                return Integer.valueOf(arg6);
            }

        label_32:
            if(arg4.containsMark(arg6)) {
                Integer v6 = ComposeStackTraceBuilderKt.findSubcompositionContextGroup$lambda$0$scanGroup(arg4, arg5, arg6 + 1, v1);
                if(v6 != null) {
                    return Integer.valueOf(((Number)v6).intValue());
                }
            }

            arg6 = v1;
        }

        return ((Integer)v0);
    }

    public static final List traceForGroup(SlotReader arg7, int arg8, Object arg9) {
        GapAnchor v9;
        ReaderTraceBuilder v0 = new ReaderTraceBuilder(arg7);
        int v1 = arg7.parent(arg8);
        GapAnchor v2 = arg7.anchor(arg8);
        while(arg8 >= 0) {
            Object v3 = arg7.hasObjectKey(arg8) ? arg7.groupObjectKey(arg8) : Composer.Companion.getEmpty();
            v0.processEdge(arg7.groupKey(arg8), v3, arg7.getTable$runtime().sourceInformationOf(arg8), arg9);
            if(v1 >= 0) {
                GapAnchor v6 = v2;
                v2 = arg7.anchor(v1);
                arg8 = v1;
                v1 = arg7.parent(v1);
                v9 = v6;
                continue;
            }

            arg8 = v1;
            v9 = v2;
        }

        return v0.trace();
    }
}

