package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\b\u0010\f\u001A\u00020\rH\u0007\u001A)\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00100\u000F\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001A\u001A\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u00022\b\u0010\u0006\u001A\u0004\u0018\u00010\u0004H\u0007\":\u0010\u0000\u001A.\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00030\u0001j\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"&\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00078\u0006@BX\u0087\u000E¢\u0006\u000E\n\u0000\u0012\u0004\b\t\u0010\n\u001A\u0004\b\b\u0010\u000B¨\u0006\u0014"}, d2={"liveLiteralCache", "Ljava/util/HashMap;", "", "Landroidx/compose/runtime/MutableState;", "", "Lkotlin/collections/HashMap;", "value", "", "isLiveLiteralsEnabled", "isLiveLiteralsEnabled$annotations", "()V", "()Z", "enableLiveLiterals", "", "liveLiteral", "Landroidx/compose/runtime/State;", "T", "key", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/compose/runtime/State;", "updateLiveLiteralValue", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LiveLiteralKt {
    private static boolean isLiveLiteralsEnabled;
    private static final HashMap liveLiteralCache;

    static {
        LiveLiteralKt.liveLiteralCache = new HashMap();
    }

    public static final void enableLiveLiterals() {
        LiveLiteralKt.isLiveLiteralsEnabled = true;
    }

    public static final boolean isLiveLiteralsEnabled() {
        return LiveLiteralKt.isLiveLiteralsEnabled;
    }

    @ComposeCompilerApi public static void isLiveLiteralsEnabled$annotations() {
    }

    @ComposeCompilerApi public static final State liveLiteral(String arg3, Object arg4) {
        MutableState v1_1;
        HashMap v0 = LiveLiteralKt.liveLiteralCache;
        Object v1 = ((Map)v0).get(arg3);
        if(v1 == null) {
            v1_1 = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
            ((Map)v0).put(arg3, v1_1);
        }

        Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type androidx.compose.runtime.State<T of androidx.compose.runtime.internal.LiveLiteralKt.liveLiteral>");
        return ((State)v1_1);
    }

    public static final void updateLiveLiteralValue(String arg3, Object arg4) {
        int v3;
        HashMap v0 = LiveLiteralKt.liveLiteralCache;
        Object v1 = ((Map)v0).get(arg3);
        if(v1 == null) {
            MutableState v1_1 = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
            ((Map)v0).put(arg3, v1_1);
            v3 = 0;
        }
        else {
            v3 = 1;
        }

        if(v3 != 0) {
            ((MutableState)v1).setValue(arg4);
        }
    }
}

