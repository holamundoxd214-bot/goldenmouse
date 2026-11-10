package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001AH\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0019\b\u0002\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001C\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\t\u001AZ\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\u0019\b\u0002\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001C\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u000E\u001Ad\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\r2\u0019\b\u0002\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001C\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0010\u001An\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\r2\b\u0010\u0011\u001A\u0004\u0018\u00010\r2\u0019\b\u0002\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001C\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0012\u001Ah\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001A\u00020\u000B2\u0016\u0010\u0013\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2\u0019\b\u0002\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u001C\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\b¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0015\u001A\u0019\u0010\u0016\u001A\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0001H\u0007¢\u0006\u0002\b\u0019\u001A\u0014\u0010\u001A\u001A\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0001H\u0002\u001A\u0019\u0010\u001B\u001A\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0001H\u0007¢\u0006\u0002\b\u0016\u001A\u0014\u0010\u001C\u001A\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0001H\u0000¨\u0006\u001D"}, d2={"composed", "Landroidx/compose/ui/Modifier;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "fullyQualifiedName", "", "key1", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key3", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "keys", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "materialize", "Landroidx/compose/runtime/Composer;", "modifier", "materializeModifier", "materializeImpl", "materializeWithCompositionLocalInjection", "materializeWithCompositionLocalInjectionInternal", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ComposedModifierKt {
    public static final Modifier access$materializeImpl(Composer arg0, Modifier arg1) {
        return ComposedModifierKt.materializeImpl(arg0, arg1);
    }

    public static final Modifier composed(Modifier arg1, Function1 arg2, Function3 arg3) {
        return arg1.then(new ComposedModifier(arg2, arg3));
    }

    public static final Modifier composed(Modifier arg7, String arg8, Object arg9, Object arg10, Object arg11, Function1 arg12, Function3 arg13) {
        return arg7.then(new KeyedComposedModifier3(arg8, arg9, arg10, arg11, arg12, arg13));
    }

    public static final Modifier composed(Modifier arg6, String arg7, Object arg8, Object arg9, Function1 arg10, Function3 arg11) {
        return arg6.then(new KeyedComposedModifier2(arg7, arg8, arg9, arg10, arg11));
    }

    public static final Modifier composed(Modifier arg1, String arg2, Object arg3, Function1 arg4, Function3 arg5) {
        return arg1.then(new KeyedComposedModifier1(arg2, arg3, arg4, arg5));
    }

    public static final Modifier composed(Modifier arg1, String arg2, Object[] arg3, Function1 arg4, Function3 arg5) {
        return arg1.then(new KeyedComposedModifierN(arg2, arg3, arg4, arg5));
    }

    public static Modifier composed$default(Modifier arg0, Function1 arg1, Function3 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg0, arg1, arg2);
    }

    public static Modifier composed$default(Modifier arg7, String arg8, Object arg9, Object arg10, Object arg11, Function1 arg12, Function3 arg13, int arg14, Object arg15) {
        if((arg14 & 16) != 0) {
            arg12 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg7, arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public static Modifier composed$default(Modifier arg6, String arg7, Object arg8, Object arg9, Function1 arg10, Function3 arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg10 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static Modifier composed$default(Modifier arg0, String arg1, Object arg2, Function1 arg3, Function3 arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg0, arg1, arg2, arg3, arg4);
    }

    public static Modifier composed$default(Modifier arg0, String arg1, Object[] arg2, Function1 arg3, Function3 arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Kept for backwards compatibility only. If you are recompiling, use materialize.", replaceWith="<_subannotation>") public static final Modifier materialize(Composer arg0, Modifier arg1) {
        return ComposedModifierKt.materializeWithCompositionLocalInjectionInternal(arg0, arg1);
    }

    private static final Modifier materializeImpl(Composer arg2, Modifier arg3) {
        if(arg3.all(ComposedModifierKt$materializeImpl$1.INSTANCE)) {
            return arg3;
        }

        arg2.startReplaceableGroup(1219399079);
        Object v3 = arg3.foldIn(Modifier.Companion, new ComposedModifierKt$materializeImpl$result$1(arg2));
        arg2.endReplaceableGroup();
        return ((Modifier)v3);
    }

    public static final Modifier materializeModifier(Composer arg1, Modifier arg2) {
        arg1.startReplaceGroup(0x1A365F2C);
        arg2 = ComposedModifierKt.materializeImpl(arg1, arg2);
        arg1.endReplaceGroup();
        return arg2;
    }

    public static final Modifier materializeWithCompositionLocalInjectionInternal(Composer arg2, Modifier arg3) {
        if(arg3 == Modifier.Companion) {
            return arg3;
        }

        return ComposedModifierKt.materializeModifier(arg2, new CompositionLocalMapInjectionElement(arg2.getCurrentCompositionLocalMap()).then(arg3));
    }
}

