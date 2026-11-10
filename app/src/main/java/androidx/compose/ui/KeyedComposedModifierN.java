package androidx.compose.ui;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001BX\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0010\u0010\u0004\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0017\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000B\u0012\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0002\b\u000E¢\u0006\u0002\b\u000B¢\u0006\u0004\b\u000F\u0010\u0010J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u001D\u0010\u0004\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u001B"}, d2={"Landroidx/compose/ui/KeyedComposedModifierN;", "Landroidx/compose/ui/ComposedModifier;", "fqName", "", "keys", "", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "<init>", "(Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getFqName", "()Ljava/lang/String;", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class KeyedComposedModifierN extends ComposedModifier {
    private final String fqName;
    private final Object[] keys;

    public KeyedComposedModifierN(String arg1, Object[] arg2, Function1 arg3, Function3 arg4) {
        super(arg3, arg4);
        this.fqName = arg1;
        this.keys = arg2;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof KeyedComposedModifierN)) && (Intrinsics.areEqual(this.fqName, ((KeyedComposedModifierN)arg3).fqName)) && (Arrays.equals(this.keys, ((KeyedComposedModifierN)arg3).keys))) {
            return 1;
        }

        return 0;
    }

    public final String getFqName() {
        return this.fqName;
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public int hashCode() {
        return this.fqName.hashCode() * 0x1F + Arrays.hashCode(this.keys);
    }
}

