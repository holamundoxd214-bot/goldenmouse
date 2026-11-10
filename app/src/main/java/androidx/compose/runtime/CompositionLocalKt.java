package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A0\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000E\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001A \u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001A+\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0017\u0010\t\u001A\u0013\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u0002H\u00020\n¢\u0006\u0002\b\f\u001A \u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000F\u001A<\u0010\u0010\u001A\u00020\u00112\u001A\u0010\u0012\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013\"\u0006\u0012\u0002\b\u00030\u00142\u0011\u0010\u0015\u001A\r\u0012\u0004\u0012\u00020\u00110\u0006¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001A,\u0010\u0010\u001A\u00020\u00112\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u00142\u0011\u0010\u0015\u001A\r\u0012\u0004\u0012\u00020\u00110\u0006¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u0019\u001A(\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u001A\u001A\u00020\u001B2\u0011\u0010\u0015\u001A\r\u0012\u0004\u0012\u00020\u00110\u0006¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001C\u001A3\u0010\u001D\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u00142\u0011\u0010\u0015\u001A\r\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0002\u0010\u001E\u001AC\u0010\u001F\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001A\u0010\u0012\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013\"\u0006\u0012\u0002\b\u00030\u00142\u0011\u0010\u0015\u001A\r\u0012\u0004\u0012\u0002H\u00020\u0006¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0002\u0010 ¨\u0006!"}, d2={"compositionLocalOf", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "Lkotlin/Function0;", "staticCompositionLocalOf", "compositionLocalWithComputedDefaultOf", "defaultComputation", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "compositionLocalWithHostDefaultOf", "key", "Landroidx/compose/runtime/HostDefaultKey;", "CompositionLocalProvider", "", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "content", "Landroidx/compose/runtime/Composable;", "([Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "value", "(Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "context", "Landroidx/compose/runtime/CompositionLocalContext;", "(Landroidx/compose/runtime/CompositionLocalContext;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "withCompositionLocal", "(Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "withCompositionLocals", "([Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompositionLocalKt {
    public static final void CompositionLocalProvider(ProvidedValue arg3, Function2 arg4, Composer arg5, int arg6) {
        int v0 = 0xF712C275;
        arg5 = arg5.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(CompositionLocalProvider)N(value,content)427@19546L9:CompositionLocal.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg6, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:425)");
        }

        arg5.startProvider(arg3);
        arg4.invoke(arg5, Integer.valueOf(arg6 >> 3 & 14));
        arg5.endProvider();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ScopeUpdateScope v5 = arg5.endRestartGroup();
        if(v5 != null) {
            v5.updateScope(new CompositionLocalKt$$ExternalSyntheticLambda0(arg3, arg4, arg6));
        }
    }

    public static final void CompositionLocalProvider(ProvidedValue[] arg3, Function2 arg4, Composer arg5, int arg6) {
        int v0 = 0x18BF8A0A;
        arg5 = arg5.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(CompositionLocalProvider)N(values,content)407@18805L9:CompositionLocal.kt#9igjgp");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg6, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:405)");
        }

        arg5.startProviders(arg3);
        arg4.invoke(arg5, Integer.valueOf(arg6 >> 3 & 14));
        arg5.endProviders();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ScopeUpdateScope v5 = arg5.endRestartGroup();
        if(v5 != null) {
            v5.updateScope(new CompositionLocalKt$$ExternalSyntheticLambda1(arg3, arg4, arg6));
        }
    }

    public static final void CompositionLocalProvider(CompositionLocalContext arg6, Function2 arg7, Composer arg8, int arg9) {
        int v1;
        int v0 = -1162003659;
        arg8 = arg8.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg8, "C(CompositionLocalProvider)N(context,content)447@20203L145:CompositionLocal.kt#9igjgp");
        if((arg9 & 6) == 0) {
            v1 = arg8.changed(arg6) ? 4 : 2;
            v1 |= arg9;
        }
        else {
            v1 = arg9;
        }

        if((arg9 & 0x30) == 0) {
            int v2 = arg8.changedInstance(arg7) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg8.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:446)");
            }

            PersistentCompositionLocalMap v0_1 = arg6.getCompositionLocals$runtime();
            ArrayList v2_2 = new ArrayList(((Map)v0_1).size());
            Iterator v0_2 = ((Map)v0_1).entrySet().iterator();
            while(v0_2.hasNext()) {
                Object v3 = v0_2.next();
                ((Collection)v2_2).add(((Map$Entry)v3).getValue().toProvided(((Map$Entry)v3).getKey()));
            }

            Object[] v0_3 = ((Collection)v2_2).toArray(new ProvidedValue[0]);
            CompositionLocalKt.CompositionLocalProvider(Arrays.copyOf(v0_3, v0_3.length), arg7, arg8, v1 & 0x70);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_62;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_62:
        ScopeUpdateScope v8 = arg8.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new CompositionLocalKt$$ExternalSyntheticLambda2(arg6, arg7, arg9));
        }
    }

    static final Unit CompositionLocalProvider$lambda$0(ProvidedValue[] arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        CompositionLocalKt.CompositionLocalProvider(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit CompositionLocalProvider$lambda$1(ProvidedValue arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        CompositionLocalKt.CompositionLocalProvider(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit CompositionLocalProvider$lambda$3(CompositionLocalContext arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        CompositionLocalKt.CompositionLocalProvider(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal compositionLocalOf(SnapshotMutationPolicy arg1, Function0 arg2) {
        return new DynamicProvidableCompositionLocal(arg1, arg2);
    }

    public static ProvidableCompositionLocal compositionLocalOf$default(SnapshotMutationPolicy arg0, Function0 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg0 = SnapshotStateKt.structuralEqualityPolicy();
        }

        return CompositionLocalKt.compositionLocalOf(arg0, arg1);
    }

    public static final ProvidableCompositionLocal compositionLocalWithComputedDefaultOf(Function1 arg1) {
        return new ComputedProvidableCompositionLocal(arg1);
    }

    public static final ProvidableCompositionLocal compositionLocalWithHostDefaultOf(HostDefaultKey arg1) {
        return CompositionLocalKt.compositionLocalWithComputedDefaultOf(new CompositionLocalKt$$ExternalSyntheticLambda3(arg1));
    }

    static final Object compositionLocalWithHostDefaultOf$lambda$0(HostDefaultKey arg1, CompositionLocalAccessorScope arg2) {
        return arg2.getCurrentValue(HostDefaultProviderKt.getLocalHostDefaultProvider()).getHostDefault(arg1);
    }

    public static final ProvidableCompositionLocal staticCompositionLocalOf(Function0 arg1) {
        return new StaticProvidableCompositionLocal(arg1);
    }

    public static final Object withCompositionLocal(ProvidedValue arg2, Function2 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformationMarkerStart(arg4, -2048339502, "CC(withCompositionLocal)N(value,content)473@21238L9:CompositionLocal.kt#9igjgp");
        arg4.startProvider(arg2);
        Object v2 = arg3.invoke(arg4, Integer.valueOf(arg5 >> 3 & 14));
        arg4.endProvider();
        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v2;
    }

    public static final Object withCompositionLocals(ProvidedValue[] arg2, Function2 arg3, Composer arg4, int arg5) {
        ComposerKt.sourceInformationMarkerStart(arg4, 1127393670, "CC(withCompositionLocals)N(values,content)496@22191L9:CompositionLocal.kt#9igjgp");
        arg4.startProviders(arg2);
        Object v2 = arg3.invoke(arg4, Integer.valueOf(arg5 >> 3 & 14));
        arg4.endProvider();
        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v2;
    }
}

