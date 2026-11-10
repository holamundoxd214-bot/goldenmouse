package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001Bd\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\f\u0012\u001C\u0010\r\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E0\t¢\u0006\u0002\b\u000F¢\u0006\u0002\b\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0015¨\u0006\u001D"}, d2={"Landroidx/compose/ui/KeyedComposedModifier3;", "Landroidx/compose/ui/ComposedModifier;", "fqName", "", "key1", "", "key2", "key3", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getFqName", "()Ljava/lang/String;", "getKey1", "()Ljava/lang/Object;", "getKey2", "getKey3", "equals", "", "other", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class KeyedComposedModifier3 extends ComposedModifier {
    private final String fqName;
    private final Object key1;
    private final Object key2;
    private final Object key3;

    public KeyedComposedModifier3(String arg1, Object arg2, Object arg3, Object arg4, Function1 arg5, Function3 arg6) {
        super(arg5, arg6);
        this.fqName = arg1;
        this.key1 = arg2;
        this.key2 = arg3;
        this.key3 = arg4;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof KeyedComposedModifier3)) && (Intrinsics.areEqual(this.fqName, ((KeyedComposedModifier3)arg3).fqName)) && (Intrinsics.areEqual(this.key1, ((KeyedComposedModifier3)arg3).key1)) && (Intrinsics.areEqual(this.key2, ((KeyedComposedModifier3)arg3).key2)) && (Intrinsics.areEqual(this.key3, ((KeyedComposedModifier3)arg3).key3))) {
            return 1;
        }

        return 0;
    }

    public final String getFqName() {
        return this.fqName;
    }

    public final Object getKey1() {
        return this.key1;
    }

    public final Object getKey2() {
        return this.key2;
    }

    public final Object getKey3() {
        return this.key3;
    }

    public int hashCode() {
        int v0 = this.fqName.hashCode() * 0x1F;
        Object v1 = this.key1;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.key2;
        v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        Object v3 = this.key3;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }
}

