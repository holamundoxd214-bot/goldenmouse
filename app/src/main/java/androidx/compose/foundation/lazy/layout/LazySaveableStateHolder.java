package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry$Entry;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B9\b\u0016\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001\u0012\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000B\u0018\u00010\t\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\rJ\u001C\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000B0\tH\u0016J(\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\f2\u0011\u0010\u0014\u001A\r\u0012\u0004\u0012\u00020\u00120\u0015¢\u0006\u0002\b\u0016H\u0017¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\fH\u0016J\u0011\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\fH\u0096\u0001J\u0013\u0010\u001C\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001A\u00020\nH\u0096\u0001J!\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0013\u001A\u00020\n2\u000E\u0010\u001F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0015H\u0096\u0001R\u000E\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\f0\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "wrappedRegistry", "wrappedHolder", "<init>", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "parentRegistry", "restoredValues", "", "", "", "", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/util/Map;Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "previouslyComposedKeys", "Landroidx/collection/MutableScatterSet;", "performSave", "SaveableStateProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "removeState", "canBeSaved", "", "value", "consumeRestored", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazySaveableStateHolder implements SaveableStateHolder, SaveableStateRegistry {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001A\"\u0012\u0004\u0012\u00020\u0006\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\u00070\u00052\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\r¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder$Companion;", "", "<init>", "()V", "saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "", "", "", "parentRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "wrappedHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver saver(SaveableStateRegistry arg2, SaveableStateHolder arg3) {
            return SaverKt.Saver(new LazySaveableStateHolder$Companion$$ExternalSyntheticLambda0(), new LazySaveableStateHolder$Companion$$ExternalSyntheticLambda1(arg2, arg3));
        }

        static final Map saver$lambda$0(SaverScope arg0, LazySaveableStateHolder arg1) {
            Map v0 = arg1.performSave();
            if(v0.isEmpty()) {
                v0 = null;
            }

            return v0;
        }

        static final LazySaveableStateHolder saver$lambda$1(SaveableStateRegistry arg1, SaveableStateHolder arg2, Map arg3) {
            return new LazySaveableStateHolder(arg1, arg3, arg2);
        }
    }

    public static final Companion Companion;
    private final MutableScatterSet previouslyComposedKeys;
    private final SaveableStateHolder wrappedHolder;
    private final SaveableStateRegistry wrappedRegistry;

    public static DisposableEffectResult $r8$lambda$jj9gHuxYpptM1p5c7NwEvJGyldg(LazySaveableStateHolder arg0, Object arg1, DisposableEffectScope arg2) {
        return LazySaveableStateHolder.SaveableStateProvider$lambda$0$0(arg0, arg1, arg2);
    }

    static {
        LazySaveableStateHolder.Companion = new Companion(null);
    }

    public LazySaveableStateHolder(SaveableStateRegistry arg1, SaveableStateHolder arg2) {
        super();
        this.wrappedRegistry = arg1;
        this.wrappedHolder = arg2;
        this.previouslyComposedKeys = ScatterSetKt.mutableScatterSetOf();
    }

    public LazySaveableStateHolder(SaveableStateRegistry arg2, Map arg3, SaveableStateHolder arg4) {
        this(SaveableStateRegistryKt.SaveableStateRegistry(arg3, new LazySaveableStateHolder$$ExternalSyntheticLambda2(arg2)), arg4);
    }

    public void SaveableStateProvider(Object arg5, Function2 arg6, Composer arg7, int arg8) {
        int v2;
        int v1;
        int v0 = 0xCCD76F7C;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(SaveableStateProvider)N(key,content)75@3305L35,76@3371L109,76@3349L131:LazySaveableStateHolder.kt#wow0x6");
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
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:74)");
            }

            v2 = v1 & 14;
            this.wrappedHolder.SaveableStateProvider(arg5, arg6, arg7, v1 & 0x7E);
            ComposerKt.sourceInformationMarkerStart(arg7, 0xF4B994C9, "CC(remember):LazySaveableStateHolder.kt#9igjgp");
            v0 = arg7.changedInstance(this) | arg7.changedInstance(arg5);
            Object v1_1 = arg7.rememberedValue();
            if(v0 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                LazySaveableStateHolder$$ExternalSyntheticLambda0 v1_2 = new LazySaveableStateHolder$$ExternalSyntheticLambda0(this, arg5);
                arg7.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg7);
            EffectsKt.DisposableEffect(arg5, ((Function1)v1_1), arg7, v2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_69;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_69:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new LazySaveableStateHolder$$ExternalSyntheticLambda1(this, arg5, arg6, arg8));
        }
    }

    private static final DisposableEffectResult SaveableStateProvider$lambda$0$0(LazySaveableStateHolder arg0, Object arg1, DisposableEffectScope arg2) {
        arg0.previouslyComposedKeys.minusAssign(arg1);
        return new LazySaveableStateHolder$SaveableStateProvider$lambda$0$0$$inlined$onDispose$1(arg0, arg1);
    }

    static final Unit SaveableStateProvider$lambda$1(LazySaveableStateHolder arg0, Object arg1, Function2 arg2, int arg3, Composer arg4, int arg5) {
        arg0.SaveableStateProvider(arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    static final boolean _init_$lambda$0(SaveableStateRegistry arg0, Object arg1) {
        if(arg0 != null) {
            return arg0.canBeSaved(arg1);
        }

        return 1;
    }

    public static final MutableScatterSet access$getPreviouslyComposedKeys$p(LazySaveableStateHolder arg0) {
        return arg0.previouslyComposedKeys;
    }

    public boolean canBeSaved(Object arg1) {
        return this.wrappedRegistry.canBeSaved(arg1);
    }

    public Object consumeRestored(String arg1) {
        return this.wrappedRegistry.consumeRestored(arg1);
    }

    public Map performSave() {
        MutableScatterSet v0 = this.previouslyComposedKeys;
        Object[] v1 = ((ScatterSet)v0).elements;
        long[] v0_1 = ((ScatterSet)v0).metadata;
        int v2 = v0_1.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v0_1[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            this.wrappedHolder.removeState(v1[(v4 << 3) + v9]);
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        break;
                    }
                }

                if(v4 == v2) {
                    break;
                }
            }
        }

        return this.wrappedRegistry.performSave();
    }

    public Entry registerProvider(String arg1, Function0 arg2) {
        return this.wrappedRegistry.registerProvider(arg1, arg2);
    }

    public void removeState(Object arg1) {
        this.wrappedHolder.removeState(arg1);
    }
}

