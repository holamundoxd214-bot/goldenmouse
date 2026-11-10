package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContent;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeOwner;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.ReusableRememberObserverHolder;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.runtime.tooling.ObjectLocation;
import java.util.ConcurrentModificationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0014\u0010\u0000\u001A\u00020\u00012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004H\u0002\u001A\f\u0010\u0005\u001A\u00020\u0006*\u00020\u0007H\u0000\u001A\b\u0010\b\u001A\u00020\tH\u0000\u001A\u0018\u0010\n\u001A\u00020\u000B*\u00020\u00062\n\u0010\f\u001A\u00060\u0003j\u0002`\rH\u0000\u001A\u0014\u0010\u000E\u001A\u00020\t*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0000\u001A\u0014\u0010\u0012\u001A\u00020\t*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0000\u001A\u001C\u0010\u0013\u001A\u00020\u00032\n\u0010\u0014\u001A\u00060\u0003j\u0002`\r2\u0006\u0010\u0015\u001A\u00020\u0006H\u0000\u001A.\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u000F2\f\u0010\u001D\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u001EH\u0002\u001A3\u0010\u001F\u001A\u0004\u0018\u00010 *\u00020\u00062#\u0010!\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\'0\"H\u0000\u001A \u0010(\u001A\u00020\t*\u00020\u00062\n\u0010\f\u001A\u00060\u0003j\u0002`\r2\u0006\u0010)\u001A\u00020*H\u0000\u001A\'\u0010+\u001A\u0004\u0018\u00010,*\n\u0012\u0006\u0012\u0004\u0018\u00010#0-2\n\u0010.\u001A\u00060\u0003j\u0002`/H\u0002¢\u0006\u0002\u00100\u001A\u0015\u00101\u001A\u000602j\u0002`3*\u00060\u0003j\u0002`\rH\u0082\b\u001A\u0016\u00104\u001A\u00020\u0001*\u0004\u0018\u00010#2\u0006\u00105\u001A\u00020\u0003H\u0002\"\u000E\u00106\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u00067"}, d2={"flagsNames", "", "flags", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "asLinkBufferSlotTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "Landroidx/compose/runtime/SlotStorage;", "throwConcurrentModificationException", "", "compositionGroupOf", "Landroidx/compose/runtime/tooling/CompositionGroup;", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "removeCurrentGroup", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "deactivateCurrentGroup", "nodeIndexOf", "groupAddress", "table", "extractMovableContentAtCurrent", "Landroidx/compose/runtime/MovableContentState;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "slots", "applier", "Landroidx/compose/runtime/Applier;", "findLocation", "Landroidx/compose/runtime/tooling/ObjectLocation;", "filter", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "value", "", "adoptScopesInGroupToNewParent", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "recomposeScopeOrNullInRegion", "Landroidx/compose/runtime/RecomposeScopeImpl;", "", "slotRegion", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "([Ljava/lang/Object;I)Landroidx/compose/runtime/RecomposeScopeImpl;", "toGroupHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "summarize", "size", "LIVE_EDIT_INVALID_KEY", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SlotTableKt {
    private static final int LIVE_EDIT_INVALID_KEY = -3;

    public static final MovableContentState access$extractMovableContentAtCurrent(ControlledComposition arg0, MovableContentStateReference arg1, SlotTableEditor arg2, Applier arg3) {
        return SlotTableKt.extractMovableContentAtCurrent(arg0, arg1, arg2, arg3);
    }

    public static final String access$flagsNames(int arg0) {
        return SlotTableKt.flagsNames(arg0);
    }

    public static final RecomposeScopeImpl access$recomposeScopeOrNullInRegion(Object[] arg0, int arg1) {
        return SlotTableKt.recomposeScopeOrNullInRegion(arg0, arg1);
    }

    public static final String access$summarize(Object arg0, int arg1) {
        return SlotTableKt.summarize(arg0, arg1);
    }

    public static final void adoptScopesInGroupToNewParent(SlotTable arg5, int arg6, RecomposeScopeOwner arg7) {
        int[] v0 = arg5.getAddressSpace().getGroups();
        Object[] v1 = arg5.getAddressSpace().getSlots();
        SlotTableAddressSpace v5 = arg5.getAddressSpace();
        if(arg6 >= 0) {
            IntStack v2 = new IntStack();
            int[] v5_1 = v5.getGroups();
            int v3;
            for(v3 = arg6; true; v3 = v2.pop()) {
            label_10:
                RecomposeScopeImpl v4 = SlotTableKt.recomposeScopeOrNullInRegion(v1, v0[v3 + 5]);
                if(v4 != null) {
                    v4.adoptedBy(arg7);
                }

                if(v3 != arg6) {
                    int v4_1 = v5_1[v3 + 1];
                    if(v4_1 >= 0) {
                        v2.push(v4_1);
                    }
                }

                v3 = v5_1[v3 + 3];
                if(v3 >= 0) {
                    goto label_10;
                }

                if(v2.tos == 0) {
                    return;
                }
            }
        }
    }

    public static final SlotTable asLinkBufferSlotTable(SlotStorage arg1) {
        if((arg1 instanceof SlotTable)) {
        }
        else {
            arg1 = null;
        }

        if(0 != 0) {
            return arg1;
        }

        ComposerKt.composeRuntimeError("Inconsistent composer");
        throw new KotlinNothingValueException();
    }

    public static final CompositionGroup compositionGroupOf(SlotTable arg2, int arg3) {
        return new SlotTableGroup(arg2, arg3, arg2.getVersion());
    }

    public static final void deactivateCurrentGroup(SlotTableEditor arg2, RememberManager arg3) {
        arg2.visitSlotsInRememberOrder(arg2.getCurrentGroup(), new SlotTableKt$$ExternalSyntheticLambda0(arg3));
    }

    static final boolean deactivateCurrentGroup$lambda$0(RememberManager arg1, int arg2, int arg3, Object arg4) {
        if((arg4 instanceof ComposeNodeLifecycleCallback)) {
            arg1.deactivating(((ComposeNodeLifecycleCallback)arg4));
            return 0;
        }

        if((arg4 instanceof ReusableRememberObserverHolder)) {
            return 0;
        }

        if((arg4 instanceof RememberObserverHolder)) {
            arg1.forgetting(((RememberObserverHolder)arg4));
            return 1;
        }

        if((arg4 instanceof RecomposeScopeImpl)) {
            ((RecomposeScopeImpl)arg4).release();
            return 1;
        }

        return 0;
    }

    private static final MovableContentState extractMovableContentAtCurrent(ControlledComposition arg12, MovableContentStateReference arg13, SlotTableEditor arg14, Applier arg15) {
        int v4_2;
        int v6;
        int v0 = arg14.getCurrentGroup();
        int v1 = -1;
        if(arg15 != null && arg14.nodeCountOf(v0) > 0) {
            SlotTableAddressSpace v4 = arg14.getTable().getAddressSpace();
            int v5 = arg14.getParentGroup();
            int[] v4_1 = v4.getGroups();
            v6 = v4_1[v5 + 2];
            while(true) {
                if(v6 <= 0) {
                    break;
                }
                else if(arg14.isNode(v6)) {
                }
                else {
                    v6 = v4_1[v6 + 2];
                    continue;
                }

                goto label_32;
            }

            v4_2 = v6 != 0 ? 1 : 0;
            if(v4_2 == 0) {
                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + v5);
            }

            v6 = v1;
        label_32:
            if(v6 < 0) {
                goto label_46;
            }

            if(!arg14.isNode(v6)) {
                goto label_46;
            }

            Object v4_3 = arg14.node(v6);
            if(v4_3 == null) {
                ComposerKt.composeImmediateRuntimeError("Invalid slot table structure");
                Unit v4_4 = Unit.INSTANCE;
            }

            v5 = SlotTableKt.nodeIndexOf(v0, arg14.getTable());
            v0 = arg14.nodeCountOf(v0);
            arg15.down(v4_3);
            arg15.remove(v5, v0);
            arg15.up();
        }

    label_46:
        SlotTableBuilder v4_5 = new SlotTableBuilder(arg14.getTable().getAddressSpace(), false, false);
        v4_5.buildStart();
        MovableContent v7 = arg13.getContent$runtime();
        v6 = v7 == Composer.Companion.getEmpty() ? 0 : 0x1000000;
        v4_5.startNewGroup(0x78CC281, v6, v7, null, null);
        v4_5.addFlags(0x10000000);
        v4_5.append(arg13.getParameter$runtime());
        v4_5.moveFrom(arg14, (((long)UInt.constructor-impl(arg14.firstChildOf(LinkAnchorKt.asLinkAnchor(arg13.getAnchor$runtime()).getAddress())))) & 0xFFFFFFFFL);
        v4_5.endGroup();
        SlotTable v14 = v4_5.build();
        MovableContentState v15 = new MovableContentState(v14);
        if(v14.getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while an editor is pending");
        }

        SlotTableAddressSpace v0_1 = v14.getAddressSpace();
        v4_2 = v14.getRoot();
        if(v4_2 >= 0) {
            IntStack v5_1 = new IntStack();
            int[] v0_2 = v0_1.getGroups();
            SlotTableKt$extractMovableContentAtCurrent$1$owner$1 v6_1 = null;
            while(true) {
                int v7_1 = v14.getGroups()[v4_2 + 5];
                if(v7_1 != v1) {
                    SlotTableAddressSpace v8 = v14.getAddressSpace();
                    int v9 = (v7_1 & 15) + 1;
                    v7_1 >>= 4;
                    if(v9 > 15) {
                        v9 = v8.getLargeSizes().get(v7_1);
                    }

                    int v8_1;
                    for(v8_1 = 0; v8_1 < v9; ++v8_1) {
                        Object v10 = v14.getSlots()[v7_1 + v8_1];
                        if(Intrinsics.areEqual(v10, Composer.Companion.getEmpty())) {
                            break;
                        }

                        if((v10 instanceof RecomposeScopeImpl)) {
                            SlotTableKt$extractMovableContentAtCurrent$1$owner$1 v11 = v6_1;
                            if(v11 == null) {
                                v6_1 = new SlotTableKt$extractMovableContentAtCurrent$1$owner$1(arg12, arg13);
                                v11 = v6_1;
                            }

                            ((RecomposeScopeImpl)v10).adoptedBy(((RecomposeScopeOwner)v11));
                        }
                    }
                }

                v7_1 = v0_2[v4_2 + 1];
                if(v7_1 >= 0) {
                    v5_1.push(v7_1);
                }

                v4_2 = v0_2[v4_2 + 3];
                if(v4_2 >= 0) {
                    continue;
                }

                if(v5_1.tos == 0) {
                    return v15;
                }

                v4_2 = v5_1.pop();
            }
        }

        return v15;
    }

    public static final ObjectLocation findLocation(SlotTable arg11, Function1 arg12) {
        int v7_1;
        int v6;
        ObjectLocation v11_1;
        int v5;
        int[] v2_1;
        IntStack v4;
        Integer v3;
        SlotTableReader v0 = arg11.openReader();
        try {
            int v1 = arg11.getRoot();
            SlotTableAddressSpace v2 = arg11.getAddressSpace();
            v3 = null;
            if(v1 >= 0) {
                v4 = new IntStack();
                v2_1 = v2.getGroups();
                v5 = v1;
                while(true) {
                label_9:
                    if((v0.isNode(v5)) && (arg12.invoke(v0.node(v5)).booleanValue())) {
                        v11_1 = new ObjectLocation(v5, v3);
                        goto label_17;
                    }

                    goto label_19;
                }
            }

            goto label_65;
        }
        catch(Throwable v11) {
            goto label_69;
        }

    label_17:
        v0.close();
        return v11_1;
        try {
        label_19:
            v6 = arg11.getGroups()[v5 + 5];
            if(v6 != -1) {
                SlotTableAddressSpace v7 = arg11.getAddressSpace();
                int v8 = (v6 & 15) + 1;
                v6 >>= 4;
                if(v8 > 15) {
                    v8 = v7.getLargeSizes().get(v6);
                }

                v7_1 = 0;
                while(true) {
                label_33:
                    if(v7_1 >= v8) {
                        goto label_51;
                    }

                    Object v9 = arg11.getSlots()[v6 + v7_1];
                    if(Intrinsics.areEqual(v9, Composer.Companion.getEmpty())) {
                        goto label_51;
                    }

                    if(!arg12.invoke(v9).booleanValue()) {
                        goto label_49;
                    }

                    v11_1 = new ObjectLocation(v5, Integer.valueOf(v7_1));
                    goto label_47;
                }
            }

            goto label_51;
        }
        catch(Throwable v11) {
            goto label_69;
        }

    label_47:
        v0.close();
        return v11_1;
    label_49:
        ++v7_1;
        goto label_33;
    label_51:
        if(v5 != v1) {
            v6 = v5 + 1;
            try {
                v6 = v2_1[v6];
                if(v6 >= 0) {
                    v4.push(v6);
                }

            label_56:
                v5 = v2_1[v5 + 3];
                if(v5 >= 0) {
                    goto label_9;
                }

                if(v4.tos == 0) {
                }
                else {
                    v5 = v4.pop();
                    goto label_9;
                }

            label_65:
                goto label_66;
            }
            catch(Throwable v11) {
            label_69:
                v0.close();
                throw v11;
            }
        }

        goto label_56;
    label_66:
        v0.close();
        return ((ObjectLocation)v3);
    }

    private static final String flagsNames(int arg3) {
        String v0 = (arg3 & 0x800000) == 0x800000 ? "N" : "";
        if((arg3 & 0x1000000) == 0x1000000) {
            v0 = v0 + 'O';
        }

        if((arg3 & 0x2000000) == 0x2000000) {
            v0 = v0 + 'A';
        }

        if((arg3 & 0x4000000) == 0x4000000) {
            v0 = v0 + 'R';
        }

        if((arg3 & 0x8000000) == 0x8000000) {
            v0 = v0 + 'r';
        }

        if((arg3 & 0x10000000) == 0x10000000) {
            v0 = v0 + 'C';
        }

        if((arg3 & 0x20000000) == 0x20000000) {
            v0 = v0 + 'c';
        }

        if((arg3 & 0x40000000) == 0x40000000) {
            v0 = v0 + 'S';
        }

        if((arg3 & 0x80000000) == 0x80000000) {
            v0 = v0 + 's';
        }

        int v1 = 0x7FFFFF & arg3;
        if(v1 != 0) {
            if((arg3 & 0xFF800000) != 0) {
                v0 = v0 + ' ';
            }

            return v0 + "CC(" + v1 + ')';
        }

        return v0;
    }

    public static final int nodeIndexOf(int arg8, SlotTable arg9) {
        SlotTableAddressSpace v9 = arg9.getAddressSpace();
        int[] v0 = v9.getGroups();
        int v1 = 0;
        while(arg8 > 0) {
            int v2 = v0[arg8 + 2];
            int[] v3 = v9.getGroups();
            int v4 = v3[v2 + 3];
            while(true) {
                int v5 = 0x800000;
                if(v4 > 0 && v4 != arg8) {
                    int v6 = v0[arg8 + 4];
                    v5 = (v6 & v5) == v5 ? 1 : 0x7FFFFF & v6;
                    v1 += v5;
                    v4 = v3[v4 + 1];
                    continue;
                }

                break;
            }

            if((v0[v2 + 4] & v5) == v5) {
                return v1;
            }

            arg8 = v2;
        }

        return v1;
    }

    private static final RecomposeScopeImpl recomposeScopeOrNullInRegion(Object[] arg1, int arg2) {
        RecomposeScopeImpl v0 = null;
        if(arg2 < 0) {
            return v0;
        }

        Object v1 = arg1[arg2 >> 4];
        if((v1 instanceof RecomposeScopeImpl)) {
            return ((RecomposeScopeImpl)v1);
        }

        return v0;
    }

    public static final void removeCurrentGroup(SlotTableEditor arg2, RememberManager arg3) {
        arg2.visitSlotsInRememberOrder(arg2.getCurrentGroup(), new SlotTableKt$$ExternalSyntheticLambda1(arg3));
        SlotTableEditor.removeGroup$default(arg2, false, 1, null);
    }

    static final boolean removeCurrentGroup$lambda$0(RememberManager arg0, int arg1, int arg2, Object arg3) {
        if((arg3 instanceof ComposeNodeLifecycleCallback)) {
            arg0.releasing(arg3);
        }

        if((arg3 instanceof RememberObserverHolder)) {
            arg0.forgetting(arg3);
        }

        if((arg3 instanceof RecomposeScopeImpl)) {
            ((RecomposeScopeImpl)arg3).release();
        }

        return 0;
    }

    private static final String summarize(Object arg13, int arg14) {
        Object v0 = (arg13 instanceof String) ? arg13 : null;
        if(v0 == null) {
            String v13 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(String.valueOf(arg13), "androidx.", "a.", false, 4, null), "compose.", "c.", false, 4, null), "runtime.", "r.", false, 4, null), "internal.", "ι.", false, 4, null), "ui.", "u.", false, 4, null), "foundation.", "f.", false, 4, null), "Modifier", "μ", false, 4, null), "material.", "m.", false, 4, null), "Function", "λ", false, 4, null), "OpaqueKey", "κ", false, 4, null), "MutableState", "σ", false, 4, null);
            v13 = v13.substring(0, Math.min(arg14, v13.length()));
            Intrinsics.checkNotNullExpressionValue(v13, "substring(...)");
            return v13;
        }

        return ((String)v0);
    }

    public static final void throwConcurrentModificationException() {
        throw new ConcurrentModificationException();
    }

    private static final long toGroupHandle(int arg4) {
        return (((long)UInt.constructor-impl(arg4))) & 0xFFFFFFFFL;
    }
}

