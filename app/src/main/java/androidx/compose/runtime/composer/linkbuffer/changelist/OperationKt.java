package androidx.compose.runtime.composer.linkbuffer.changelist;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContent;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchorKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableBuilder;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditorKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000Z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001A,\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\n\u0010\t\u001A\u00060\nj\u0002`\u000BH\u0002\u001A,\u0010\f\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\n\u0010\r\u001A\u00060\nj\u0002`\u000B2\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u001A\u001C\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\n\u0010\u000F\u001A\u00060\u0001j\u0002`\u0010H\u0002\u001A4\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0004\u001A\u00020\u00052\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u0007H\u0002\u001A5\u0010\u0018\u001A\u00020\u00032\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u001B\u001A\u00020\u00052\n\u0010\u001C\u001A\u00060\nj\u0002`\u000B2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00030\u001EH\u0082\b\u001A*\u0010\u001F\u001A\u00020 *\u00020 2\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u001B\u001A\u00020\u00052\n\u0010\t\u001A\u00060\nj\u0002`\u000BH\u0002\u001A\u0014\u0010\u0018\u001A\u00020\u001A*\u00020\u001A2\u0006\u0010\u0004\u001A\u00020\u0005H\u0002*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006!"}, d2={"IntParameter", "", "positionToParentOf", "", "slots", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "applier", "Landroidx/compose/runtime/Applier;", "", "handle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "positionToInsert", "destination", "nodeIndex", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "releaseMovableGroup", "composition", "Landroidx/compose/runtime/ControlledComposition;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "withCurrentStackTrace", "errorContext", "Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationErrorContext;", "editor", "location", "block", "Lkotlin/Function0;", "attachComposeStackTrace", "", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class OperationKt {
    public static final Throwable access$attachComposeStackTrace(Throwable arg0, OperationErrorContext arg1, SlotTableEditor arg2, long arg3) {
        return OperationKt.attachComposeStackTrace(arg0, arg1, arg2, arg3);
    }

    public static final int access$positionToInsert(SlotTableEditor arg0, long arg1, Applier arg3) {
        return OperationKt.positionToInsert(arg0, arg1, arg3);
    }

    public static final void access$releaseMovableGroup(ControlledComposition arg0, CompositionContext arg1, MovableContentStateReference arg2, SlotTableEditor arg3, Applier arg4) {
        OperationKt.releaseMovableGroup(arg0, arg1, arg2, arg3, arg4);
    }

    public static final OperationErrorContext access$withCurrentStackTrace(OperationErrorContext arg0, SlotTableEditor arg1) {
        return OperationKt.withCurrentStackTrace(arg0, arg1);
    }

    private static final Throwable attachComposeStackTrace(Throwable arg1, OperationErrorContext arg2, SlotTableEditor arg3, long arg4) {
        if(arg2 == null) {
            return arg1;
        }

        return ComposeStackTraceKt.attachComposeStackTrace(arg1, new OperationKt$$ExternalSyntheticLambda0(arg4, arg3, arg2));
    }

    static final ComposeStackTrace attachComposeStackTrace$lambda$0(long arg7, SlotTableEditor arg9, OperationErrorContext arg10) {
        Integer v0_1;
        if(arg7 != -1) {
            arg9.seek(arg7);
        }

        Object v0 = null;
        List v7 = SlotTableEditorKt.buildTrace$default(arg9, v0, 0, 3, v0);
        Object v8 = CollectionsKt.lastOrNull(v7);
        if(v8 != null) {
            v0_1 = ((ComposeStackTraceFrame)v8).getGroupOffset();
        }

        Integer v4 = v0_1;
        List v8_1 = arg10.buildStackTrace(v4);
        if(v4 != null) {
            if(v8_1.isEmpty()) {
            }
            else {
                v8_1 = CollectionsKt.plus(CollectionsKt.listOf(ComposeStackTraceFrame.copy$default(CollectionsKt.first(v8_1), 0, null, v4, 3, null)), CollectionsKt.drop(((Iterable)v8_1), 1));
            }
        }

        return new ComposeStackTrace(CollectionsKt.plus(((Collection)v7), ((Iterable)v8_1)), arg10.getSourceInformationEnabled());
    }

    private static final int nodeIndex(SlotTableEditor arg10, int arg11) {
        int v0 = 0;
        if(arg11 < 0) {
            return 0;
        }

        SlotTable v1 = arg10.getTable();
        int[] v2 = v1.getAddressSpace().getGroups();
        int v3 = arg11;
        int v5 = v3;
        int v4 = 0;
        while(true) {
            if(v3 <= 0) {
                break;
            }
            else if(arg10.isNode(v3)) {
            }
            else {
                int v6 = arg10.parentOf(v3);
                int v7 = v6 < 0 ? v1.getRoot() : arg10.firstChildOf(v6);
                int[] v8 = v1.getAddressSpace().getGroups();
                while(v7 >= 0) {
                    if(v7 == v5) {
                    }
                    else {
                        v4 += arg10.nodeCountOf(v7);
                        v7 = v8[v7 + 1];
                        continue;
                    }

                    break;
                }

                v3 = v2[v3 + 2];
                v5 = v6;
                continue;
            }

            return v4;
        }

        if(v3 != 0) {
            v0 = 1;
        }

        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg11);
        }

        return v4;
    }

    private static final int positionToInsert(SlotTableEditor arg7, long arg8, Applier arg10) {
        int v4;
        OperationKt.positionToParentOf(arg7, arg10, arg8);
        int v0 = arg7.getParentGroup();
        int v8 = GroupHandleKt.getGroup(arg8);
        IntStack v9 = new IntStack();
        int[] v1 = arg7.getTable().getAddressSpace().getGroups();
        int v2 = v8;
        while(true) {
            v4 = 0;
            if(v2 <= 0) {
                break;
            }
            else if(v2 != v0) {
                v9.push(v2);
                v2 = v1[v2 + 2];
                continue;
            }

            goto label_28;
        }

        int v1_1 = v2 != 0 ? 1 : 0;
        if(v1_1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + v8);
        }

    label_28:
        v0 = arg7.getParentGroup() == v0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Unexpected slot table structure when inserting movable content");
        }

        v0 = arg7.getCurrentGroup();
        v1_1 = 0;
        v2 = 0;
        while(arg7.getCurrentGroup() != v8) {
            if(v9.tos != 0 && arg7.getCurrentGroup() == v9.peek()) {
                if(arg7.isNode()) {
                    arg10.down(arg7.getNode());
                    v2 = 1;
                    v1_1 = 0;
                }

                arg7.startGroup();
                v9.pop();
                continue;
            }

            v1_1 += arg7.skipGroup();
        }

        if(v2 == 0) {
            v4 = OperationKt.nodeIndex(arg7, v0);
        }

        return v1_1 + v4;
    }

    private static final void positionToParentOf(SlotTableEditor arg2, Applier arg3, long arg4) {
        if(arg2.getParentGroup() >= 0) {
            MutableIntSet v0 = IntSetKt.mutableIntSetOf();
            SlotTable v1 = arg2.getTable();
            int v4 = arg2.parentOf(GroupHandleKt.getGroup(arg4));
            int[] v5 = v1.getAddressSpace().getGroups();
            int v1_1;
            for(v1_1 = v4; v1_1 > 0; v1_1 = v5[v1_1 + 2]) {
                v0.add(v1_1);
            }

            int v5_1 = v1_1 != 0 ? 1 : 0;
            if(v5_1 == 0) {
                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + v4);
            }

            while(arg2.getParentGroup() >= 0) {
                if(v0.contains(arg2.getParentGroup())) {
                    return;
                }

                if(arg2.isParentGroupANode()) {
                    arg3.up();
                }

                arg2.endGroup();
            }
        }
    }

    private static final void releaseMovableGroup(ControlledComposition arg7, CompositionContext arg8, MovableContentStateReference arg9, SlotTableEditor arg10, Applier arg11) {
        int v2 = 0;
        SlotTableBuilder v1 = new SlotTableBuilder(arg10.getTable().getAddressSpace(), false, false);
        v1.buildStart();
        MovableContent v4 = arg9.getContent$runtime();
        if(v4 == Composer.Companion.getEmpty()) {
        }
        else {
            v2 = 0x1000000;
        }

        v1.startNewGroup(0x78CC281, v2, v4, null, null);
        v1.addFlags(0x10000000);
        v1.append(arg9.getParameter$runtime());
        v1.moveFrom(arg10, (((long)UInt.constructor-impl(arg10.getTable().getAddressSpace().getGroups()[LinkAnchorKt.asLinkAnchor(arg9.getAnchor$runtime()).getAddress() + 3]))) & 0xFFFFFFFFL);
        v1.endGroup();
        SlotTable v10 = v1.build();
        MovableContentState v0 = new MovableContentState(v10);
        if(v10.hasRecomposeScopes(v10.getRoot())) {
            SlotTableKt.adoptScopesInGroupToNewParent(v10, v10.getRoot(), new OperationKt$releaseMovableGroup$movableContentRecomposeScopeOwner$1(arg7, arg9));
        }

        arg8.movableContentStateReleased$runtime(arg9, v0, arg11);
    }

    private static final OperationErrorContext withCurrentStackTrace(OperationErrorContext arg1, SlotTableEditor arg2) {
        return new OperationKt$withCurrentStackTrace$1(arg1, arg2);
    }

    private static final void withCurrentStackTrace(OperationErrorContext arg0, SlotTableEditor arg1, long arg2, Function0 arg4) {
        try {
            arg4.invoke();
            return;
        }
        catch(Throwable v4) {
            throw OperationKt.attachComposeStackTrace(v4, arg0, arg1, arg2);
        }
    }
}

