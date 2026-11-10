package androidx.compose.runtime.retain;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00012\u0011\u0010\f\u001A\r\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0002\b\u000EH\u0007¢\u0006\u0002\u0010\u000FJ\u0012\u0010\u0010\u001A\u00020\u00112\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\u0012\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001J+\u0010\u0013\u001A\u00020\n2#\u0010\u0014\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00050\u0015J\u0006\u0010\u0018\u001A\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u0006\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/retain/RetainedValuesStoreRegistry;", "", "<init>", "()V", "isDisposed", "", "childStores", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "LocalRetainedValuesStoreProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "getOrCreateRetainedValuesStoreForChild", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "clearChild", "clearChildren", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dispose", "runtime-retain"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RetainedValuesStoreRegistry {
    public static final int $stable = 8;
    private final MutableScatterMap childStores;
    private boolean isDisposed;

    static {
    }

    public RetainedValuesStoreRegistry() {
        super();
        this.childStores = new MutableScatterMap(0, 1, null);
    }

    public final void LocalRetainedValuesStoreProvider(Object arg5, Function2 arg6, Composer arg7, int arg8) {
        int v2;
        int v1;
        int v0 = 0x9F0B979C;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(LocalRetainedValuesStoreProvider)N(key,content)71@3830L139:RetainedValuesStoreRegistry.kt#3my55w");
        if((arg8 & 6) == 0) {
            v1 = arg7.changedInstance(arg5) ? 4 : 2;
            v1 |= arg8;
        }
        else {
            v1 = arg8;
        }

        if((arg8 & 0x30) == 0) {
            v2 = arg7.changedInstance(arg6) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg8 & 0x180) == 0) {
            v2 = arg7.changedInstance(this) ? 0x100 : 0x80;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg7.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.runtime.retain.RetainedValuesStoreRegistry.LocalRetainedValuesStoreProvider (RetainedValuesStoreRegistry.kt:70)");
            }

            LocalRetainedValuesStoreKt.LocalRetainedValuesStoreProvider(this.getOrCreateRetainedValuesStoreForChild(arg5), arg6, arg7, v1 & 0x70);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_52;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_52:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new RetainedValuesStoreRegistry$$ExternalSyntheticLambda0(this, arg5, arg6, arg8));
        }
    }

    static final Unit LocalRetainedValuesStoreProvider$lambda$0(RetainedValuesStoreRegistry arg0, Object arg1, Function2 arg2, int arg3, Composer arg4, int arg5) {
        arg0.LocalRetainedValuesStoreProvider(arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public final void clearChild(Object arg1) {
        Object v0 = this.childStores.remove(arg1);
        if(v0 != null) {
            ((ManagedRetainedValuesStore)v0).dispose();
        }
    }

    public final void clearChildren(Function1 arg14) {
        MutableScatterMap v13 = this.childStores;
        long[] v0 = v13.metadata;
        int v1 = v0.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v0[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            int v9 = (v3 << 3) + v8;
                            Object v10 = v13.keys[v9];
                            Object v11 = v13.values[v9];
                            v10 = arg14.invoke(v10);
                            if(((Boolean)v10).booleanValue()) {
                                ((ManagedRetainedValuesStore)v11).dispose();
                            }

                            if(!((Boolean)v10).booleanValue()) {
                                goto label_40;
                            }

                            v13.removeValueAt(v9);
                        }

                    label_40:
                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return;
                    }
                }

                if(v3 == v1) {
                    return;
                }
            }
        }
    }

    public final void dispose() {
        this.isDisposed = true;
        this.clearChildren(new RetainedValuesStoreRegistry$$ExternalSyntheticLambda1());
    }

    static final boolean dispose$lambda$0(Object arg0) {
        return 1;
    }

    private final RetainedValuesStore getOrCreateRetainedValuesStoreForChild(Object arg2) {
        ManagedRetainedValuesStore v0_1;
        if(this.isDisposed) {
            PreconditionsKt.throwIllegalStateException("Cannot get a RetainedValuesStore after a RetainedValuesStoreRegistry has been disposed.");
        }

        MutableScatterMap v1 = this.childStores;
        Object v0 = v1.get(arg2);
        if(v0 == null) {
            v0_1 = new ManagedRetainedValuesStore();
            v1.set(arg2, v0_1);
        }

        return ((RetainedValuesStore)v0_1);
    }
}

