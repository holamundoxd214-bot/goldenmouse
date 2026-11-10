package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.tooling.IdentifiableRecomposeScope;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001fB\u0011\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010=\u001A\u00020<2\u0006\u0010>\u001A\u00020;J\u0010\u0010?\u001A\u00020@2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0014J\u0006\u0010A\u001A\u00020<J\u000E\u0010B\u001A\u00020<2\u0006\u0010\u0004\u001A\u00020\u0005J\b\u0010C\u001A\u00020<H\u0016J\"\u0010D\u001A\u00020<2\u0018\u00109\u001A\u0014\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020<0:H\u0016J\u000E\u0010T\u001A\u00020<2\u0006\u0010U\u001A\u00020\fJ\u0006\u0010V\u001A\u00020<J\u000E\u0010W\u001A\u00020\u001A2\u0006\u0010X\u001A\u00020\u0014J\u001C\u0010Y\u001A\u00020<2\n\u0010X\u001A\u0006\u0012\u0002\b\u00030J2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0014J\u0010\u0010[\u001A\u00020\u001A2\b\u0010\\\u001A\u0004\u0018\u00010\u0014J*\u0010]\u001A\u00020\u001A*\u0006\u0012\u0002\b\u00030J2\u0018\u0010^\u001A\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030J\u0012\u0006\u0012\u0004\u0018\u00010\u00140IH\u0002J\u0006\u0010_\u001A\u00020<J\u001C\u0010`\u001A\u0010\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020<\u0018\u00010a2\u0006\u0010U\u001A\u00020\fJ\u0011\u0010c\u001A\u00020\u001A2\u0006\u0010d\u001A\u00020\fH\u0082\bJ\u0019\u0010e\u001A\u00020<2\u0006\u0010d\u001A\u00020\f2\u0006\u0010\u001F\u001A\u00020\u001AH\u0082\bR\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u00148VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\u001A8F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\u001D\u001A\u00020\u001A8F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001CR$\u0010 \u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b!\u0010\u001C\"\u0004\b\"\u0010#R$\u0010$\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b%\u0010\u001C\"\u0004\b&\u0010#R$\u0010\'\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b(\u0010\u001C\"\u0004\b)\u0010#R$\u0010*\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b+\u0010\u001C\"\u0004\b,\u0010#R$\u0010-\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b.\u0010\u001C\"\u0004\b/\u0010#R$\u00100\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b1\u0010\u001C\"\u0004\b2\u0010#R$\u00103\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b4\u0010\u001C\"\u0004\b5\u0010#R$\u00106\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b7\u0010\u001C\"\u0004\b8\u0010#R\"\u00109\u001A\u0016\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020<\u0018\u00010:X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010E\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010F\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010GX\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010H\u001A\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030J\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010IX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010K\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8B@BX\u0082\u000E¢\u0006\f\u001A\u0004\bL\u0010\u001C\"\u0004\bM\u0010#R$\u0010N\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bO\u0010\u001C\"\u0004\bP\u0010#R$\u0010Q\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A8@@BX\u0080\u000E¢\u0006\f\u001A\u0004\bR\u0010\u001C\"\u0004\bS\u0010#R\u0011\u0010Z\u001A\u00020\u001A8F¢\u0006\u0006\u001A\u0004\bZ\u0010\u001C¨\u0006g"}, d2={"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "Landroidx/compose/runtime/tooling/IdentifiableRecomposeScope;", "owner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "<init>", "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "getOwner$runtime", "()Landroidx/compose/runtime/RecomposeScopeOwner;", "setOwner$runtime", "flags", "", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "identity", "", "getIdentity$annotations", "()V", "getIdentity", "()Ljava/lang/Object;", "valid", "", "getValid", "()Z", "canRecompose", "getCanRecompose", "value", "used", "getUsed", "setUsed", "(Z)V", "reusing", "getReusing", "setReusing", "resetReusing", "getResetReusing", "setResetReusing", "paused", "getPaused", "setPaused", "resuming", "getResuming", "setResuming", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "compose", "composer", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "release", "adoptedBy", "invalidate", "updateScope", "currentToken", "trackedInstances", "Landroidx/collection/MutableObjectIntMap;", "trackedDependencies", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/DerivedState;", "rereading", "getRereading", "setRereading", "forcedRecompose", "getForcedRecompose", "setForcedRecompose", "skipped", "getSkipped$runtime", "setSkipped", "start", "token", "scopeSkipped", "recordRead", "instance", "recordDerivedStateValue", "isConditional", "isInvalidFor", "instances", "checkDerivedStateChanged", "dependencies", "rereadTrackedInstances", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "getFlag", "flag", "setFlag", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RecomposeScopeImpl implements RecomposeScope, ScopeUpdateScope, IdentifiableRecomposeScope {
    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000B\u001A\u00020\fH\u0000¢\u0006\u0002\b\rJ#\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0006\u001A\u00020\u00102\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2={"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", "", "<init>", "()V", "adoptAnchoredScopes", "", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "anchors", "", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "adoptAnchoredScopes$runtime", "hasAnchoredRecomposeScopes", "", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "hasAnchoredRecomposeScopes$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final void adoptAnchoredScopes$runtime(SlotWriter arg5, List arg6, RecomposeScopeOwner arg7) {
            List v4 = arg6;
            if(!((Collection)v4).isEmpty()) {
                int v4_1 = ((Collection)v4).size();
                int v1;
                for(v1 = 0; v1 < v4_1; ++v1) {
                    Object v2 = arg5.slot(arg6.get(v1), 0);
                    if((v2 instanceof RecomposeScopeImpl)) {
                    }
                    else {
                        v2 = null;
                    }

                    if(v2 != null) {
                        ((RecomposeScopeImpl)v2).adoptedBy(arg7);
                    }
                }
            }
        }

        public final boolean hasAnchoredRecomposeScopes$runtime(SlotTable arg5, List arg6) {
            List v4 = arg6;
            if(!((Collection)v4).isEmpty()) {
                int v4_1 = ((Collection)v4).size();
                int v0;
                for(v0 = 0; v0 < v4_1; ++v0) {
                    Object v2 = arg6.get(v0);
                    if((arg5.ownsAnchor(((GapAnchor)v2))) && ((arg5.slot$runtime(arg5.anchorIndex(((GapAnchor)v2)), 0) instanceof RecomposeScopeImpl))) {
                        return 1;
                    }
                }
            }

            return 0;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private Anchor anchor;
    private Function2 block;
    private int currentToken;
    private int flags;
    private RecomposeScopeOwner owner;
    private MutableScatterMap trackedDependencies;
    private MutableObjectIntMap trackedInstances;

    public static Unit $r8$lambda$dbiKKStJ0dvmAsxppAz0YmLcayE(RecomposeScopeImpl arg0, int arg1, MutableObjectIntMap arg2, Composition arg3) {
        return RecomposeScopeImpl.end$lambda$0$1(arg0, arg1, arg2, arg3);
    }

    static {
        RecomposeScopeImpl.Companion = new Companion(null);
        RecomposeScopeImpl.$stable = 8;
    }

    public RecomposeScopeImpl(RecomposeScopeOwner arg1) {
        super();
        this.owner = arg1;
    }

    public final void adoptedBy(RecomposeScopeOwner arg1) {
        this.owner = arg1;
    }

    private final boolean checkDerivedStateChanged(DerivedState arg2, MutableScatterMap arg3) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        SnapshotMutationPolicy v1 = arg2.getPolicy();
        if(v1 == null) {
            v1 = SnapshotStateKt.structuralEqualityPolicy();
        }

        return v1.equivalent(arg2.getCurrentRecord().getCurrentValue(), arg3.get(arg2)) ^ 1;
    }

    public final void compose(Composer arg2) {
        Function2 v1 = this.block;
        if(v1 != null) {
            v1.invoke(arg2, Integer.valueOf(1));
            return;
        }

        throw new IllegalStateException("Invalid restart scope".toString());
    }

    public final Function1 end(int arg20) {
        RecomposeScopeImpl v0 = this;
        int v1 = arg20;
        MutableObjectIntMap v2 = v0.trackedInstances;
        Function1 v3 = null;
        if(v2 != null && !v0.getSkipped$runtime()) {
            Object[] v5 = v2.keys;
            int[] v6 = v2.values;
            long[] v4 = v2.metadata;
            int v7 = v4.length - 2;
            if(v7 >= 0) {
                int v9;
                for(v9 = 0; true; ++v9) {
                    long v10 = v4[v9];
                    if((~v10 << 7 & v10 & -9187201950435737472L) != -9187201950435737472L) {
                        int v13 = 8;
                        int v12 = 8 - (~(v9 - v7) >>> 0x1F);
                        int v14;
                        for(v14 = 0; v14 < v12; ++v14) {
                            if((0xFF & v10) < 0x80 && v6[(v9 << 3) + v14] != v1) {
                                return new RecomposeScopeImpl$$ExternalSyntheticLambda0(v0, v1, v2);
                            }

                            v10 >>= v13;
                        }

                        if(v12 != v13) {
                            return v3;
                        }
                    }

                    if(v9 == v7) {
                        return v3;
                    }
                }
            }
        }

        return v3;
    }

    private static final Unit end$lambda$0$1(RecomposeScopeImpl arg18, int arg19, MutableObjectIntMap arg20, Composition arg21) {
        int v17;
        RecomposeScopeImpl v0 = arg18;
        int v1 = arg19;
        MutableObjectIntMap v2 = arg20;
        Composition v3 = arg21;
        if(v0.currentToken == v1 && (Intrinsics.areEqual(v2, v0.trackedInstances)) && ((v3 instanceof CompositionImpl))) {
            long[] v4 = v2.metadata;
            int v5 = v4.length - 2;
            if(v5 >= 0) {
                int v7;
                for(v7 = 0; true; ++v7) {
                    long v8 = v4[v7];
                    if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                        int v11 = 8;
                        int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                        int v12 = 0;
                        while(v12 < v10) {
                            if((0xFF & v8) < 0x80) {
                                int v13 = (v7 << 3) + v12;
                                Object v14 = v2.keys[v13];
                                int v15 = v2.values[v13] != v1 ? 1 : 0;
                                if(v15 != 0) {
                                    Composition v6 = v3;
                                    ((CompositionImpl)v6).removeObservation$runtime(v14, v0);
                                    v17 = v11;
                                    if((v14 instanceof DerivedState)) {
                                        ((CompositionImpl)v6).removeDerivedStateObservation$runtime(v14);
                                        MutableScatterMap v6_1 = v0.trackedDependencies;
                                        if(v6_1 != null) {
                                            v6_1.remove(v14);
                                        }
                                    }
                                }
                                else {
                                    v17 = v11;
                                }

                                if(v15 == 0) {
                                    goto label_63;
                                }

                                v2.removeValueAt(v13);
                            }
                            else {
                                v17 = v11;
                            }

                        label_63:
                            v8 >>= v17;
                            ++v12;
                            v11 = v17;
                        }

                        if(v10 != v11) {
                            break;
                        }
                    }

                    if(v7 == v5) {
                        break;
                    }
                }
            }
        }

        return Unit.INSTANCE;
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final boolean getCanRecompose() {
        if(this.block != null) {
            return 1;
        }

        return 0;
    }

    public final boolean getDefaultsInScope() {
        if((this.flags & 2) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getDefaultsInvalid() {
        if((this.flags & 4) != 0) {
            return 1;
        }

        return 0;
    }

    private final boolean getFlag(int arg1) {
        if((this.flags & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getForcedRecompose() {
        if((this.flags & 0x40) != 0) {
            return 1;
        }

        return 0;
    }

    public Object getIdentity() {
        return this.anchor;
    }

    public static void getIdentity$annotations() {
    }

    public final RecomposeScopeOwner getOwner$runtime() {
        return this.owner;
    }

    public final boolean getPaused() {
        if((this.flags & 0x100) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getRequiresRecompose() {
        if((this.flags & 8) != 0) {
            return 1;
        }

        return 0;
    }

    private final boolean getRereading() {
        if((this.flags & 0x20) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getResetReusing() {
        if((this.flags & 0x400) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getResuming() {
        if((this.flags & 0x200) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getReusing() {
        if((this.flags & 0x80) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getSkipped$runtime() {
        if((this.flags & 16) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getUsed() {
        if((this.flags & 1) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getValid() {
        if(this.owner != null) {
            Anchor v2 = this.anchor;
            boolean v2_1 = v2 != null ? v2.getValid() : false;
            if(!v2_1) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    public void invalidate() {
        RecomposeScopeOwner v0 = this.owner;
        if(v0 != null) {
            v0.invalidate(this, null);
        }
    }

    public final InvalidationResult invalidateForResult(Object arg2) {
        RecomposeScopeOwner v0 = this.owner;
        if(v0 != null) {
            InvalidationResult v1 = v0.invalidate(this, arg2);
            if(v1 == null) {
            }
            else {
                return v1;
            }
        }

        return InvalidationResult.IGNORED;
    }

    public final boolean isConditional() {
        if(this.trackedDependencies != null) {
            return 1;
        }

        return 0;
    }

    public final boolean isInvalidFor(Object arg18) {
        RecomposeScopeImpl v0 = this;
        Object v1 = arg18;
        if(v1 == null) {
            return 1;
        }

        MutableScatterMap v3 = v0.trackedDependencies;
        if(v3 == null) {
            return 1;
        }

        if((v1 instanceof DerivedState)) {
            return v0.checkDerivedStateChanged(((DerivedState)v1), v3);
        }

        if((v1 instanceof ScatterSet)) {
            if(((ScatterSet)v1).isNotEmpty()) {
                Object[] v4 = ((ScatterSet)v1).elements;
                long[] v1_1 = ((ScatterSet)v1).metadata;
                int v6 = v1_1.length - 2;
                if(v6 >= 0) {
                    int v7;
                    for(v7 = 0; true; ++v7) {
                        long v8 = v1_1[v7];
                        if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                            int v11 = 8;
                            int v10 = 8 - (~(v7 - v6) >>> 0x1F);
                            int v12;
                            for(v12 = 0; v12 < v10; ++v12) {
                                if((0xFF & v8) < 0x80) {
                                    Object v13 = v4[(v7 << 3) + v12];
                                    if(((v13 instanceof DerivedState)) && !v0.checkDerivedStateChanged(((DerivedState)v13), v3)) {
                                        goto label_50;
                                    }

                                    return 1;
                                }

                            label_50:
                                v8 >>= v11;
                            }

                            if(v10 != v11) {
                                return 0;
                            }
                        }

                        if(v7 == v6) {
                            return 0;
                        }
                    }
                }
            }

            return 0;
        }

        return 1;
    }

    public final void recordDerivedStateValue(DerivedState arg5, Object arg6) {
        MutableScatterMap v0 = this.trackedDependencies;
        if(v0 == null) {
            v0 = new MutableScatterMap(0, 1, null);
            this.trackedDependencies = v0;
        }

        v0.set(arg5, arg6);
    }

    public final boolean recordRead(Object arg6) {
        if(this.getRereading()) {
            return 0;
        }

        MutableObjectIntMap v0 = this.trackedInstances;
        if(v0 == null) {
            v0 = new MutableObjectIntMap(0, 1, null);
            this.trackedInstances = v0;
        }

        if(v0.put(arg6, this.currentToken, -1) == this.currentToken) {
            return 1;
        }

        return 0;
    }

    public final void release() {
        RecomposeScopeOwner v0 = this.owner;
        if(v0 != null) {
            v0.recomposeScopeReleased(this);
        }

        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
        this.block = null;
    }

    public final void rereadTrackedInstances() {
        int v12;
        int v11;
        long v8;
        int v7;
        RecomposeScopeImpl v1 = this;
        RecomposeScopeOwner v0 = v1.owner;
        if(v0 != null) {
            MutableObjectIntMap v2 = v1.trackedInstances;
            if(v2 != null) {
                v1.setRereading(true);
                try {
                    Object[] v4 = ((ObjectIntMap)v2).keys;
                    int[] v5 = ((ObjectIntMap)v2).values;
                    long[] v2_1 = ((ObjectIntMap)v2).metadata;
                    int v6 = v2_1.length - 2;
                    if(v6 >= 0) {
                        v7 = 0;
                        while(true) {
                        label_15:
                            v8 = v2_1[v7];
                            if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                                v11 = 8;
                                int v10 = 8 - (~(v7 - v6) >>> 0x1F);
                                v12 = 0;
                                while(true) {
                                label_29:
                                    if(v12 < v10) {
                                        if((0xFF & v8) < 0x80) {
                                            v0.recordReadOf(v4[(v7 << 3) + v12]);
                                        }

                                        goto label_39;
                                    }
                                    else {
                                        goto label_42;
                                    }
                                }
                            }

                            goto label_43;
                        }
                    }

                    goto label_46;
                }
                catch(Throwable v0_1) {
                    goto label_49;
                }

            label_39:
                v8 >>= v11;
                ++v12;
                goto label_29;
            label_42:
                if(v10 == v11) {
                label_43:
                    if(v7 == v6) {
                    }
                    else {
                        ++v7;
                        goto label_15;
                    label_49:
                        v1.setRereading(false);
                        throw v0_1;
                    }
                }

            label_46:
                v1.setRereading(false);
                return;
            }
        }
    }

    public final void scopeSkipped() {
        if(!this.getReusing()) {
            this.setSkipped(true);
        }
    }

    public final void setAnchor(Anchor arg1) {
        this.anchor = arg1;
    }

    public final void setDefaultsInScope(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 2 : v0 & -3;
        this.flags = v2;
    }

    public final void setDefaultsInvalid(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 4 : v0 & -5;
        this.flags = v2;
    }

    private final void setFlag(int arg2, boolean arg3) {
        int v0 = this.flags;
        if(arg3) {
            arg2 |= v0;
        }
        else {
            arg2 = ~arg2 & v0;
        }

        this.flags = arg2;
    }

    public final void setForcedRecompose(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 0x40 : v0 & -65;
        this.flags = v2;
    }

    public final void setOwner$runtime(RecomposeScopeOwner arg1) {
        this.owner = arg1;
    }

    public final void setPaused(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 0x100 : v0 & 0xFFFFFEFF;
        this.flags = v2;
    }

    public final void setRequiresRecompose(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 8 : v0 & -9;
        this.flags = v2;
    }

    private final void setRereading(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 0x20 : v0 & -33;
        this.flags = v2;
    }

    public final void setResetReusing(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 0x400 : v0 & 0xFFFFFBFF;
        this.flags = v2;
    }

    public final void setResuming(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 0x200 : v0 & 0xFFFFFDFF;
        this.flags = v2;
    }

    public final void setReusing(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 0x80 : v0 & 0xFFFFFF7F;
        this.flags = v2;
    }

    private final void setSkipped(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 16 : v0 & -17;
        this.flags = v2;
    }

    public final void setUsed(boolean arg2) {
        int v0 = this.flags;
        int v2 = arg2 ? v0 | 1 : v0 & -2;
        this.flags = v2;
    }

    public final void start(int arg1) {
        this.currentToken = arg1;
        this.setSkipped(false);
    }

    public void updateScope(Function2 arg1) {
        this.block = arg1;
    }
}

