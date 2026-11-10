package androidx.compose.runtime.saveable;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1={"\u0000>\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001Aa\u0010\u0000\u001A\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0016\u0010\u0003\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0005\u001A\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00010\nH\u0007¢\u0006\u0002\u0010\u000B\u001A=\u0010\u0000\u001A\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0016\u0010\u0003\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u00022\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00010\nH\u0007¢\u0006\u0002\u0010\f\u001AS\u0010\u0000\u001A\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0016\u0010\u0003\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001A\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u00062\f\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00010\nH\u0007¢\u0006\u0002\u0010\r\u001A[\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00010\u000E\"\u0004\b\u0000\u0010\u00012\u0016\u0010\u0003\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u00022\u0014\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u00062\u0012\u0010\t\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u000E0\nH\u0007¢\u0006\u0002\u0010\u0010\u001Ag\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00010\u000E\"\u0004\b\u0000\u0010\u00012\u0016\u0010\u0003\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0004\"\u0004\u0018\u00010\u00022\u0014\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0012\u0010\t\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u000E0\nH\u0007¢\u0006\u0002\u0010\u0011\u001A>\u0010\u0012\u001A\u001C\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u000E\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000E0\u0006\"\u0004\b\u0000\u0010\u00012\u0014\u0010\u0013\u001A\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006H\u0000\u001A\u0016\u0010\u0014\u001A\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0002H\u0002\u001A\u0010\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u0002H\u0000\"\u000E\u0010\u0019\u001A\u00020\u001AX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"rememberSaveable", "T", "", "inputs", "", "saver", "Landroidx/compose/runtime/saveable/Saver;", "key", "", "init", "Lkotlin/Function0;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "Landroidx/compose/runtime/MutableState;", "stateSaver", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/MutableState;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "mutableStateSaver", "inner", "requireCanBeSaved", "", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "value", "generateCannotBeSavedErrorMessage", "MaxSupportedRadix", "", "runtime-saveable"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    public static MutableState $r8$lambda$7J4XtjRB0OEw6CpogYQeHyCSftY(Saver arg0, MutableState arg1) {
        return RememberSaveableKt.mutableStateSaver$lambda$0$1(arg0, arg1);
    }

    public static Unit $r8$lambda$Bb_m5NIgE_V_sjUdch0rI03OLhk(SaveableHolder arg0, Saver arg1, SaveableStateRegistry arg2, String arg3, Object arg4, Object[] arg5) {
        return RememberSaveableKt.rememberSaveable$lambda$1$0(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static MutableState $r8$lambda$E5IAz-BCBDD71kBVgtF29gFuNAE(Saver arg0, SaverScope arg1, MutableState arg2) {
        return RememberSaveableKt.mutableStateSaver$lambda$0$0(arg0, arg1, arg2);
    }

    static {
    }

    public static final void access$requireCanBeSaved(SaveableStateRegistry arg0, Object arg1) {
        RememberSaveableKt.requireCanBeSaved(arg0, arg1);
    }

    public static final String generateCannotBeSavedErrorMessage(Object arg1) {
        return arg1 + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
    }

    public static final Saver mutableStateSaver(Saver arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.Saver(new RememberSaveableKt$$ExternalSyntheticLambda0(arg2), new RememberSaveableKt$$ExternalSyntheticLambda1(arg2));
    }

    private static final MutableState mutableStateSaver$lambda$0$0(Saver arg1, SaverScope arg2, MutableState arg3) {
        if((arg3 instanceof SnapshotMutableState)) {
            Object v1 = arg1.save(arg2, ((SnapshotMutableState)arg3).getValue());
            if(v1 != null) {
                SnapshotMutationPolicy v2 = ((SnapshotMutableState)arg3).getPolicy();
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<kotlin.Any?>");
                return SnapshotStateKt.mutableStateOf(v1, v2);
            }

            return null;
        }

        throw new IllegalArgumentException("If you use a custom MutableState implementation you have to write a custom Saver and pass it as a saver param to rememberSaveable()".toString());
    }

    private static final MutableState mutableStateSaver$lambda$0$1(Saver arg1, MutableState arg2) {
        Object v1;
        if((arg2 instanceof SnapshotMutableState)) {
            if(((SnapshotMutableState)arg2).getValue() != null) {
                Object v0 = ((SnapshotMutableState)arg2).getValue();
                Intrinsics.checkNotNull(v0);
                v1 = arg1.restore(v0);
            }
            else {
                v1 = null;
            }

            SnapshotMutationPolicy v2 = ((SnapshotMutableState)arg2).getPolicy();
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver?>");
            MutableState v1_1 = SnapshotStateKt.mutableStateOf(v1, v2);
            Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver>");
            return v1_1;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final Object rememberSaveable(Object[] arg8, Function0 arg9, Composer arg10, int arg11) {
        int v1 = 0x5D40DE79;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(rememberSaveable)N(inputs,init)137@6309L71:RememberSaveable.kt#r2ddri");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:135)");
        }

        Composer v5 = arg10;
        Object v8 = RememberSaveableKt.rememberSaveable(Arrays.copyOf(arg8, arg8.length), SaverKt.autoSaver(), null, arg9, v5, arg11 << 6 & 0x1C00 | 0x180, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8;
    }

    public static final Object rememberSaveable(Object[] arg8, Saver arg9, Function0 arg10, Composer arg11, int arg12) {
        int v1 = 0x2836F350;
        ComposerKt.sourceInformationMarkerStart(arg11, v1, "C(rememberSaveable)N(inputs,saver,init)177@8157L65:RememberSaveable.kt#r2ddri");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg12, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:175)");
        }

        Composer v5 = arg11;
        Object v8 = RememberSaveableKt.rememberSaveable(Arrays.copyOf(arg8, arg8.length), arg9, null, arg10, v5, arg12 & 0x70 | 0x180 | arg12 << 3 & 0x1C00, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v8;
    }

    public static final MutableState rememberSaveable(Object[] arg8, Saver arg9, Function0 arg10, Composer arg11, int arg12) {
        int v1 = 0xD3866B17;
        ComposerKt.sourceInformationMarkerStart(arg11, v1, "C(rememberSaveable)N(inputs,stateSaver,init)205@9398L89:RememberSaveable.kt#r2ddri");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg12, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:203)");
        }

        Composer v5 = arg11;
        Object v8 = RememberSaveableKt.rememberSaveable(Arrays.copyOf(arg8, arg8.length), RememberSaveableKt.mutableStateSaver(arg9), null, arg10, v5, arg12 << 3 & 0x1C00 | 0x180, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return ((MutableState)v8);
    }

    @Deprecated(message=" \'rememberSaveable\' with a custom \'key\' is no longer supported. It bypasses positional scoping, leading to state bugs and inconsistent behavior (e.g., unintentional state sharing or loss, issues in nested LazyLayouts). Please remove the \'key\' parameter to use positional scoping for consistent, locally-scoped state. See https://r.android.com/3610053 for details.") public static final MutableState rememberSaveable(Object[] arg9, Saver arg10, String arg11, Function0 arg12, Composer arg13, int arg14, int arg15) {
        int v1 = -202053668;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(rememberSaveable)N(inputs,stateSaver,key,init)245@11388L88:RememberSaveable.kt#r2ddri");
        if((arg15 & 4) != 0) {
            arg11 = null;
        }

        String v4 = arg11;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:243)");
        }

        Composer v6 = arg13;
        Object v9 = RememberSaveableKt.rememberSaveable(Arrays.copyOf(arg9, arg9.length), RememberSaveableKt.mutableStateSaver(arg10), v4, arg12, v6, arg14 & 0x1F80, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        return ((MutableState)v9);
    }

    @Deprecated(message=" \'rememberSaveable\' with a custom \'key\' is no longer supported. It bypasses positional scoping, leading to state bugs and inconsistent behavior (e.g., unintentional state sharing or loss, issues in nested LazyLayouts). Please remove the \'key\' parameter to use positional scoping for consistent, locally-scoped state. See https://r.android.com/3610053 for details.") public static final Object rememberSaveable(Object[] arg9, Saver arg10, String arg11, Function0 arg12, Composer arg13, int arg14, int arg15) {
        Object v7_1;
        RememberSaveableKt$$ExternalSyntheticLambda2 v14_1;
        Object[] v7;
        int v1 = 0x1A56BFAB;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(rememberSaveable)N(inputs,saver,key,init)80@3807L27,90@4177L7,92@4203L293,100@4582L59,100@4571L70:RememberSaveable.kt#r2ddri");
        if((arg15 & 2) != 0) {
            arg10 = SaverKt.autoSaver();
        }

        Saver v3 = arg10;
        int v10 = arg15 & 4;
        Object v15 = null;
        if(v10 != 0) {
            arg11 = ((String)v15);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:79)");
        }

        long v0 = ComposablesKt.getCurrentCompositeKeyHashCode(arg13, 0);
        String v2 = arg11;
        if(v2 == null || ((CharSequence)v2).length() == 0) {
            arg11 = Long.toString(v0, CharsKt.checkRadix(RememberSaveableKt.MaxSupportedRadix));
            Intrinsics.checkNotNullExpressionValue(arg11, "toString(...)");
        }

        String v5 = arg11;
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        ProvidableCompositionLocal v11 = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
        ComposerKt.sourceInformationMarkerStart(arg13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v11_1 = arg13.consume(((CompositionLocal)v11));
        ComposerKt.sourceInformationMarkerEnd(arg13);
        Object v4 = v11_1;
        String v0_1 = "CC(remember):RememberSaveable.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg13, 0xDFA5C970, v0_1);
        v11_1 = arg13.rememberedValue();
        if(v11_1 == Composer.Companion.getEmpty()) {
            if(v4 != null) {
                v11_1 = ((SaveableStateRegistry)v4).consumeRestored(v5);
                if(v11_1 != null) {
                    v15 = v3.restore(v11_1);
                }
            }

            if(v15 == null) {
                v15 = arg12.invoke();
            }

            v7 = arg9;
            SaveableHolder v2_1 = new SaveableHolder(v3, ((SaveableStateRegistry)v4), v5, v15, v7);
            arg13.updateRememberedValue(v2_1);
            SaveableHolder v11_2 = v2_1;
        }
        else {
            v7 = arg9;
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        Object v9 = ((SaveableHolder)v11_1).getValueIfInputsDidntChange(v7);
        if(v9 == null) {
            v9 = arg12.invoke();
        }

        ComposerKt.sourceInformationMarkerStart(arg13, 0xDFA5F7E6, v0_1);
        boolean v12 = arg13.changedInstance(v11_1);
        int v0_2 = 0x20;
        arg14 = (arg14 & 0x70 ^ 0x30) > v0_2 && (arg13.changedInstance(v3)) || (arg14 & 0x30) == v0_2 ? 1 : 0;
        int v12_1 = (((int)v12)) | arg14 | arg13.changedInstance(v4) | arg13.changed(v5) | arg13.changedInstance(v9) | arg13.changedInstance(v7);
        Object v14 = arg13.rememberedValue();
        if(v12_1 != 0 || v14 == Composer.Companion.getEmpty()) {
            Object[] v8 = v7;
            v7_1 = v9;
            RememberSaveableKt$$ExternalSyntheticLambda2 v2_2 = new RememberSaveableKt$$ExternalSyntheticLambda2(v11_1, v3, v4, v5, v7_1, v8);
            arg13.updateRememberedValue(v2_2);
            v14_1 = v2_2;
        }
        else {
            v7_1 = v9;
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        EffectsKt.SideEffect(((Function0)v14_1), arg13, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        return v7_1;
    }

    private static final Unit rememberSaveable$lambda$1$0(SaveableHolder arg0, Saver arg1, SaveableStateRegistry arg2, String arg3, Object arg4, Object[] arg5) {
        arg0.update(arg1, arg2, arg3, arg4, arg5);
        return Unit.INSTANCE;
    }

    private static final void requireCanBeSaved(SaveableStateRegistry arg2, Object arg3) {
        String v3;
        if(arg3 != null && !arg2.canBeSaved(arg3)) {
            if((arg3 instanceof SnapshotMutableState)) {
                if(((SnapshotMutableState)arg3).getPolicy() != SnapshotStateKt.neverEqualPolicy() && ((SnapshotMutableState)arg3).getPolicy() != SnapshotStateKt.structuralEqualityPolicy() && ((SnapshotMutableState)arg3).getPolicy() != SnapshotStateKt.referentialEqualityPolicy()) {
                    v3 = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                    goto label_27;
                }

                v3 = "MutableState containing " + ((SnapshotMutableState)arg3).getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
            }
            else {
                v3 = RememberSaveableKt.generateCannotBeSavedErrorMessage(arg3);
            }

        label_27:
            throw new IllegalArgumentException(v3);
        }
    }
}

