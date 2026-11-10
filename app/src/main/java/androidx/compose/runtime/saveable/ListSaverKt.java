package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A}\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000422\u0010\u0005\u001A.\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000B0\u0006¢\u0006\u0002\b\f2)\u0010\r\u001A%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00040\u000B¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000F\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000E¨\u0006\u0010"}, d2={"listSaver", "Landroidx/compose/runtime/saveable/Saver;", "Original", "", "Saveable", "save", "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "", "Lkotlin/ExtensionFunctionType;", "restore", "Lkotlin/Function1;", "list", "runtime-saveable"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ListSaverKt {
    public static final Saver listSaver(Function2 arg1, Function1 arg2) {
        ListSaverKt$$ExternalSyntheticLambda0 v0 = new ListSaverKt$$ExternalSyntheticLambda0(arg1);
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, Original of androidx.compose.runtime.saveable.ListSaverKt.listSaver?>");
        return SaverKt.Saver(((Function2)v0), TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg2, 1));
    }

    static final Object listSaver$lambda$0(Function2 arg4, SaverScope arg5, Object arg6) {
        Object v4 = arg4.invoke(arg5, arg6);
        arg6 = v4;
        int v0 = ((Collection)arg6).size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = ((List)v4).get(v1);
            if(v2 != null) {
                if(arg5.canBeSaved(v2)) {
                }
                else {
                    throw new IllegalArgumentException("item at index " + v1 + " can\'t be saved: " + v2.toString());
                }
            }
        }

        if(!((Collection)arg6).isEmpty()) {
            return new ArrayList(((Collection)arg6));
        }

        return null;
    }
}

