package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.gapbuffer.GapAnchorKt;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.tooling.ComposeStackTraceMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u008A\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b%\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A3\u0010\u0005\u001A\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0011\u0010\n\u001A\r\u0012\u0004\u0012\u0002H\u00060\u000B¢\u0006\u0002\b\fH\u0087\b¢\u0006\u0002\u0010\r\u001A\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u0011H\u0007\u001A \u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u0011H\u0007\u001A\b\u0010\u001F\u001A\u00020\tH\u0007\u001A\u0018\u0010 \u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u0011H\u0007\u001A(\u0010 \u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u00012\u0006\u0010\"\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u0011H\u0007\u001A\b\u0010$\u001A\u00020\u000FH\u0007\u001A\u0010\u0010%\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0007H\u0007\u001A\u0014\u0010&\u001A\u00020\u000F*\u00020\u00022\u0006\u0010\'\u001A\u00020(H\u0000\u001A7\u0010)\u001A\u00020\u000F\"\u0004\b\u0000\u0010**\u00020\u00022\b\u0010+\u001A\u0004\u0018\u00010,2\u0018\u0010-\u001A\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H*0.H\u0080\b\u001A*\u0010W\u001A\u00020\u000F2\u0006\u0010X\u001A\u00020\t2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020\u00110\u000BH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A\u001F\u0010[\u001A\u00020\u000F2\u0006\u0010X\u001A\u00020\t2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020\u00110\u000BH\u0080\b\u001A\u0011\u0010[\u001A\u00020\u000F2\u0006\u0010X\u001A\u00020\tH\u0080\b\u001A\u0011\u0010W\u001A\u00020\u000F2\u0006\u0010X\u001A\u00020\tH\u0080\b\u001A\u0010\u0010\\\u001A\u00020]2\u0006\u0010^\u001A\u00020\u0011H\u0000\u001A\u0010\u0010_\u001A\u00020\u000F2\u0006\u0010^\u001A\u00020\u0011H\u0000\u001A.\u0010`\u001A\u00020a2\u0006\u0010b\u001A\u00020c2\u0006\u0010Q\u001A\u00020d2\u0006\u0010e\u001A\u00020\u00022\f\u0010f\u001A\b\u0012\u0002\b\u0003\u0018\u00010gH\u0000\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017\"\u001C\u0010\u0018\u001A\u00020\u0019X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u001E\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001D\"\u0018\u0010/\u001A\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b/\u00100\"\u0018\u0010/\u001A\u00020\t*\u0002018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b/\u00102\"\u000E\u00103\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u00104\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b5\u0010\u0017\"\u001C\u00106\u001A\u0002078\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b8\u0010\u0017\u001A\u0004\b9\u0010:\"\u0016\u0010;\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b<\u0010\u0017\"\u001C\u0010=\u001A\u0002078\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b>\u0010\u0017\u001A\u0004\b?\u0010:\"\u0016\u0010@\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bA\u0010\u0017\"\u001C\u0010B\u001A\u0002078\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\bC\u0010\u0017\u001A\u0004\bD\u0010:\"\u0016\u0010E\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bF\u0010\u0017\"\u001C\u0010G\u001A\u0002078\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\bH\u0010\u0017\u001A\u0004\bI\u0010:\"\u0016\u0010J\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bK\u0010\u0017\"\u001C\u0010L\u001A\u0002078\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\bM\u0010\u0017\u001A\u0004\bN\u0010:\"\u0016\u0010O\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bP\u0010\u0017\"\u001C\u0010Q\u001A\u0002078\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\bR\u0010\u0017\u001A\u0004\bS\u0010:\"\u0016\u0010T\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bU\u0010\u0017\"\u000E\u0010V\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010Z\u001A\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006h"}, d2={"nextGroup", "", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "getNextGroup", "(Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;)I", "cache", "T", "Landroidx/compose/runtime/Composer;", "invalid", "", "block", "Lkotlin/Function0;", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "sourceInformation", "", "composer", "", "sourceInformationMarkerStart", "key", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "()V", "composeStackTraceMode", "Landroidx/compose/runtime/tooling/ComposeStackTraceMode;", "getComposeStackTraceMode", "()I", "setComposeStackTraceMode-76WK1J0", "(I)V", "I", "isTraceInProgress", "traceEventStart", "info", "dirty1", "dirty2", "traceEventEnd", "sourceInformationMarkerEnd", "removeCurrentGroup", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "withAfterAnchorInfo", "R", "anchor", "Landroidx/compose/runtime/Anchor;", "cb", "Lkotlin/Function2;", "isAfterFirstChild", "(Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;)Z", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;)Z", "defaultsKey", "invocationKey", "getInvocationKey$annotations", "invocation", "", "getInvocation$annotations", "getInvocation", "()Ljava/lang/Object;", "providerKey", "getProviderKey$annotations", "provider", "getProvider$annotations", "getProvider", "compositionLocalMapKey", "getCompositionLocalMapKey$annotations", "compositionLocalMap", "getCompositionLocalMap$annotations", "getCompositionLocalMap", "providerValuesKey", "getProviderValuesKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerMapsKey", "getProviderMapsKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "referenceKey", "getReferenceKey$annotations", "reference", "getReference$annotations", "getReference", "reuseKey", "getReuseKey$annotations", "invalidGroupLocation", "runtimeCheck", "value", "lazyMessage", "EnableDebugRuntimeChecks", "debugRuntimeCheck", "composeRuntimeError", "", "message", "composeImmediateRuntimeError", "extractMovableContentAtCurrent", "Landroidx/compose/runtime/MovableContentState;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/MovableContentStateReference;", "slots", "applier", "Landroidx/compose/runtime/Applier;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ComposerKt {
    public static final boolean EnableDebugRuntimeChecks = false;
    private static int composeStackTraceMode = 0;
    private static final Object compositionLocalMap = null;
    public static final int compositionLocalMapKey = 202;
    private static CompositionTracer compositionTracer = null;
    public static final int defaultsKey = 0xFFFFFF81;
    private static final int invalidGroupLocation = -2;
    private static final Object invocation = null;
    public static final int invocationKey = 200;
    private static final Object provider = null;
    public static final int providerKey = 201;
    private static final Object providerMaps = null;
    public static final int providerMapsKey = 204;
    private static final Object providerValues = null;
    public static final int providerValuesKey = 203;
    private static final Object reference = null;
    public static final int referenceKey = 206;
    public static final int reuseKey = 0xCF;

    static {
        ComposerKt.composeStackTraceMode = ComposeStackTraceMode.Companion.getNone-MD5MrJc();
        ComposerKt.invocation = new OpaqueKey("provider");
        ComposerKt.provider = new OpaqueKey("provider");
        ComposerKt.compositionLocalMap = new OpaqueKey("compositionLocalMap");
        ComposerKt.providerValues = new OpaqueKey("providerValues");
        ComposerKt.providerMaps = new OpaqueKey("providers");
        ComposerKt.reference = new OpaqueKey("reference");
    }

    public static final void access$setCompositionTracer$p(CompositionTracer arg0) {
        ComposerKt.compositionTracer = arg0;
    }

    @ComposeCompilerApi public static final Object cache(Composer arg1, boolean arg2, Function0 arg3) {
        Object v0 = arg1.rememberedValue();
        if(!arg2) {
            if(v0 == Composer.Companion.getEmpty()) {
            }
            else {
                return v0;
            }
        }

        Object v2 = arg3.invoke();
        arg1.updateRememberedValue(v2);
        return v2;
    }

    public static final void composeImmediateRuntimeError(String arg3) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + arg3 + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final Void composeRuntimeError(String arg3) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + arg3 + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final void debugRuntimeCheck(boolean arg0) {
    }

    public static final void debugRuntimeCheck(boolean arg0, Function0 arg1) {
    }

    public static final MovableContentState extractMovableContentAtCurrent(ControlledComposition arg37, MovableContentStateReference arg38, SlotWriter arg39, Applier arg40) {
        List v0_5;
        MovableContentStateReference v1_1;
        List v8_2;
        boolean v0_2;
        SlotTable v36;
        Object v35;
        long v33;
        int v32;
        int v1;
        long v29;
        long[] v27;
        int v25;
        Anchor v21;
        int v11;
        int v10;
        ControlledComposition v0 = arg37;
        SlotWriter v2 = arg39;
        Applier v3 = arg40;
        SlotTable v4 = new SlotTable();
        if(v2.getCollectingSourceInformation()) {
            v4.collectSourceInformation();
        }

        if(v2.getCollectingCalledInformation()) {
            v4.collectCalledByInformation();
        }

        int v5 = v2.getCurrentGroup();
        if(v3 != null && v2.nodeCount(v5) > 0) {
            int v8;
            for(v8 = v2.getParent(); v8 > 0; v8 = v2.parent(v8)) {
                if(v2.isNode(v8)) {
                    break;
                }
            }

            if(v8 < 0) {
                goto label_50;
            }

            if(!v2.isNode(v8)) {
                goto label_50;
            }

            Object v9 = v2.node(v8);
            v10 = v8 + 1;
            v8 += v2.groupSize(v8);
            v11 = 0;
            while(v10 < v8) {
                int v12 = v2.groupSize(v10) + v10;
                if(v12 > v5) {
                }
                else {
                    v10 = v2.isNode(v10) ? 1 : v2.nodeCount(v10);
                    v11 += v10;
                    v10 = v12;
                    continue;
                }

                break;
            }

            v5 = v2.isNode(v5) ? 1 : v2.nodeCount(v5);
            v3.down(v9);
            v3.remove(v11, v5);
            v3.up();
        }

    label_50:
        Anchor v3_1 = arg38.getAnchor$runtime();
        if(v3_1.getValid()) {
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            ControlledComposition v5_1 = v0;
            if(ScopeMap.getSize-impl(CompositionImpl.access$getInvalidations$p(((CompositionImpl)v5_1))) > 0) {
                ArrayList v8_1 = new ArrayList();
                MutableScatterMap v5_2 = CompositionImpl.access$getInvalidations$p(((CompositionImpl)v5_1));
                long[] v9_1 = v5_2.metadata;
                v10 = v9_1.length - 2;
                if(v10 >= 0) {
                    v11 = 0;
                    while(true) {
                        long v12_1 = v9_1[v11];
                        int v16 = 7;
                        long v17 = -9187201950435737472L;
                        if((~v12_1 << v16 & v12_1 & v17) != v17) {
                            int v15 = 8;
                            int v14 = 8 - (~(v11 - v10) >>> 0x1F);
                            int v6 = 0;
                            while(v6 < v14) {
                                long v19 = 0xFF;
                                long v23 = 0x80;
                                if((v12_1 & v19) < v23) {
                                    int v7 = (v11 << 3) + v6;
                                    int v40 = v15;
                                    Object v15_1 = v5_2.keys[v7];
                                    v21 = v3_1;
                                    Object v3_2 = v5_2.values[v7];
                                    v25 = v6;
                                    Intrinsics.checkNotNull(v15_1, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                    if((v3_2 instanceof MutableScatterSet)) {
                                        Intrinsics.checkNotNull(v3_2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                        Object[] v26 = ((MutableScatterSet)v3_2).elements;
                                        long[] v6_1 = v3_2.metadata;
                                        v27 = v9_1;
                                        int v9_2 = v6_1.length - 2;
                                        if(v9_2 >= 0) {
                                            long[] v28 = v6_1;
                                            v29 = v12_1;
                                            v6 = 0;
                                            while(true) {
                                                v12_1 = v28[v6];
                                                if((~v12_1 << v16 & v12_1 & v17) != v17) {
                                                    int v0_1 = 8 - (~(v6 - v9_2) >>> 0x1F);
                                                    v1 = 0;
                                                    while(v1 < v0_1) {
                                                        if((v12_1 & v19) < v23) {
                                                            v32 = v1;
                                                            v1 = (v6 << 3) + v32;
                                                            v33 = v12_1;
                                                            Object v12_2 = v26[v1];
                                                            Object v13 = v15_1;
                                                            Anchor v31 = ((RecomposeScopeImpl)v13).getAnchor();
                                                            if(v31 != null) {
                                                                v35 = v15_1;
                                                                v36 = v4;
                                                                if(v2.inGroup(GapAnchorKt.asGapAnchor(v21), GapAnchorKt.asGapAnchor(v31))) {
                                                                    ((List)v8_1).add(TuplesKt.to(v13, v12_2));
                                                                    ((MutableScatterSet)v3_2).removeElementAt(v1);
                                                                }
                                                            }
                                                            else {
                                                                v36 = v4;
                                                                goto label_150;
                                                            }
                                                        }
                                                        else {
                                                            v32 = v1;
                                                            v36 = v4;
                                                            v33 = v12_1;
                                                        label_150:
                                                            v35 = v15_1;
                                                        }

                                                        v12_1 = v33 >> v40;
                                                        v1 = v32 + 1;
                                                        v15_1 = v35;
                                                        v4 = v36;
                                                    }

                                                    v36 = v4;
                                                    v35 = v15_1;
                                                    if(v0_1 != v40) {
                                                        break;
                                                    }
                                                }
                                                else {
                                                    v36 = v4;
                                                    v35 = v15_1;
                                                }

                                                if(v6 == v9_2) {
                                                    break;
                                                }

                                                ++v6;
                                                v15_1 = v35;
                                                v4 = v36;
                                                v40 = 8;
                                            }
                                        }
                                        else {
                                            v36 = v4;
                                            v29 = v12_1;
                                        }

                                        v0_2 = ((MutableScatterSet)v3_2).isEmpty();
                                    }
                                    else {
                                        v36 = v4;
                                        v27 = v9_1;
                                        v29 = v12_1;
                                        Intrinsics.checkNotNull(v3_2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                        v15_1 = v15_1;
                                        Anchor v0_3 = ((RecomposeScopeImpl)v15_1).getAnchor();
                                        if(v0_3 != null && (v2.inGroup(GapAnchorKt.asGapAnchor(v21), GapAnchorKt.asGapAnchor(v0_3)))) {
                                            ((List)v8_1).add(TuplesKt.to(v15_1, v3_2));
                                            v0_2 = true;
                                            goto label_192;
                                        }

                                        v0_2 = false;
                                    }

                                label_192:
                                    if(v0_2) {
                                        v5_2.removeValueAt(v7);
                                    }

                                    v1 = 8;
                                }
                                else {
                                    v21 = v3_1;
                                    v36 = v4;
                                    v25 = v6;
                                    v27 = v9_1;
                                    v29 = v12_1;
                                    v1 = v15;
                                }

                                v12_1 = v29 >> v1;
                                v6 = v25 + 1;
                                v15 = v1;
                                v3_1 = v21;
                                v9_1 = v27;
                                v4 = v36;
                            }

                            v21 = v3_1;
                            v36 = v4;
                            v27 = v9_1;
                            if(v14 != v15) {
                                break;
                            }
                        }
                        else {
                            v21 = v3_1;
                            v36 = v4;
                            v27 = v9_1;
                        }

                        if(v11 == v10) {
                            break;
                        }

                        ++v11;
                        v3_1 = v21;
                        v9_1 = v27;
                        v4 = v36;
                    }
                }
                else {
                    v36 = v4;
                }
            }
            else {
                v36 = v4;
                v8_2 = CollectionsKt.emptyList();
            }

            v1_1 = arg38;
            v1_1.setInvalidations$runtime(CollectionsKt.plus(arg38.getInvalidations$runtime(), ((Iterable)v8_2)));
        }
        else {
            v1_1 = arg38;
            v36 = v4;
        }

        SlotWriter v3_3 = v36.openWriter();
        try {
            v3_3.beginInsert();
            v3_3.startGroup(0x78CC281, v1_1.getContent$runtime());
            SlotWriter.markGroup$default(v3_3, 0, 1, null);
            v3_3.update(v1_1.getParameter$runtime());
            v0_5 = v2.moveTo(GapAnchorKt.asGapAnchor(v1_1.getAnchor$runtime()), 1, v3_3);
            v3_3.skipGroup();
            v3_3.endGroup();
            v3_3.endInsert();
        }
        catch(Throwable v0_4) {
            v3_3.close(false);
            throw v0_4;
        }

        v3_3.close(true);
        MovableContentState v2_1 = new MovableContentState(v36);
        v4 = v36;
        if(RecomposeScopeImpl.Companion.hasAnchoredRecomposeScopes$runtime(v4, v0_5)) {
            ComposerKt$extractMovableContentAtCurrent$movableContentRecomposeScopeOwner$1 v3_4 = new ComposerKt$extractMovableContentAtCurrent$movableContentRecomposeScopeOwner$1(arg37, v1_1);
            SlotWriter v1_2 = v4.openWriter();
            try {
                RecomposeScopeImpl.Companion.adoptAnchoredScopes$runtime(v1_2, v0_5, ((RecomposeScopeOwner)v3_4));
            }
            catch(Throwable v0_4) {
                v1_2.close(false);
                throw v0_4;
            }

            v1_2.close(true);
            return v2_1;
        }

        return v2_1;
    }

    public static final int getComposeStackTraceMode() {
        return ComposerKt.composeStackTraceMode;
    }

    public static final Object getCompositionLocalMap() {
        return ComposerKt.compositionLocalMap;
    }

    public static void getCompositionLocalMap$annotations() {
    }

    public static void getCompositionLocalMapKey$annotations() {
    }

    private static void getCompositionTracer$annotations() {
    }

    public static final Object getInvocation() {
        return ComposerKt.invocation;
    }

    public static void getInvocation$annotations() {
    }

    public static void getInvocationKey$annotations() {
    }

    private static final int getNextGroup(SlotWriter arg2) {
        return arg2.getCurrentGroup() + arg2.groupSize(arg2.getCurrentGroup());
    }

    public static final Object getProvider() {
        return ComposerKt.provider;
    }

    public static void getProvider$annotations() {
    }

    public static void getProviderKey$annotations() {
    }

    public static final Object getProviderMaps() {
        return ComposerKt.providerMaps;
    }

    public static void getProviderMaps$annotations() {
    }

    public static void getProviderMapsKey$annotations() {
    }

    public static final Object getProviderValues() {
        return ComposerKt.providerValues;
    }

    public static void getProviderValues$annotations() {
    }

    public static void getProviderValuesKey$annotations() {
    }

    public static final Object getReference() {
        return ComposerKt.reference;
    }

    public static void getReference$annotations() {
    }

    public static void getReferenceKey$annotations() {
    }

    public static void getReuseKey$annotations() {
    }

    public static final boolean isAfterFirstChild(SlotReader arg2) {
        if(arg2.getCurrentGroup() > arg2.getParent() + 1) {
            return 1;
        }

        return 0;
    }

    public static final boolean isAfterFirstChild(SlotWriter arg2) {
        if(arg2.getCurrentGroup() > arg2.getParent() + 1) {
            return 1;
        }

        return 0;
    }

    @ComposeCompilerApi public static final boolean isTraceInProgress() {
        CompositionTracer v0 = ComposerKt.compositionTracer;
        if(v0 != null && (v0.isTraceInProgress())) {
            return 1;
        }

        return 0;
    }

    public static final void removeCurrentGroup(SlotWriter arg2, RememberManager arg3) {
        arg2.forAllDataInRememberOrder(arg2.getCurrentGroup(), new ComposerKt$$ExternalSyntheticLambda0(arg3));
        arg2.removeGroup();
    }

    static final Unit removeCurrentGroup$lambda$0(RememberManager arg0, int arg1, Object arg2) {
        if((arg2 instanceof ComposeNodeLifecycleCallback)) {
            arg0.releasing(arg2);
        }

        if((arg2 instanceof RememberObserverHolder)) {
            arg0.forgetting(arg2);
        }

        if((arg2 instanceof RecomposeScopeImpl)) {
            ((RecomposeScopeImpl)arg2).release();
        }

        return Unit.INSTANCE;
    }

    public static final void runtimeCheck(boolean arg0) {
        if(!arg0) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
    }

    public static final void runtimeCheck(boolean arg0, Function0 arg1) {
        if(!arg0) {
            ComposerKt.composeImmediateRuntimeError(arg1.invoke());
        }
    }

    public static final void setComposeStackTraceMode-76WK1J0(int arg0) {
        ComposerKt.composeStackTraceMode = arg0;
    }

    @ComposeCompilerApi public static final void sourceInformation(Composer arg0, String arg1) {
        arg0.sourceInformation(arg1);
    }

    @ComposeCompilerApi public static final void sourceInformationMarkerEnd(Composer arg0) {
        arg0.sourceInformationMarkerEnd();
    }

    @ComposeCompilerApi public static final void sourceInformationMarkerStart(Composer arg0, int arg1, String arg2) {
        arg0.sourceInformationMarkerStart(arg1, arg2);
    }

    @ComposeCompilerApi public static final void traceEventEnd() {
        CompositionTracer v0 = ComposerKt.compositionTracer;
        if(v0 != null) {
            v0.traceEventEnd();
        }
    }

    @ComposeCompilerApi public static final void traceEventStart(int arg1, int arg2, int arg3, String arg4) {
        CompositionTracer v0 = ComposerKt.compositionTracer;
        if(v0 != null) {
            v0.traceEventStart(arg1, arg2, arg3, arg4);
        }
    }

    @ComposeCompilerApi @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the overload with $dirty metadata instead", replaceWith="<_subannotation>") public static final void traceEventStart(int arg1, String arg2) {
        ComposerKt.traceEventStart(arg1, -1, -1, arg2);
    }

    public static final void withAfterAnchorInfo(SlotWriter arg1, Anchor arg2, Function2 arg3) {
        int v0;
        int v2;
        if(arg2 == null || !arg2.getValid()) {
            v2 = -1;
            v0 = v2;
        }
        else {
            v2 = arg1.anchorIndex(GapAnchorKt.asGapAnchor(arg2));
            v0 = arg1.getSlotsSize() - arg1.slotsEndAllIndex$runtime(v2);
        }

        arg3.invoke(Integer.valueOf(v2), Integer.valueOf(v0));
    }
}

