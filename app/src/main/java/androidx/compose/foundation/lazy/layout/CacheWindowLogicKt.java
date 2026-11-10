package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\u001AZ\u0010\u0000\u001A\u00020\u0001*\u00020\u00022K\u0010\u0003\u001AG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001A\u0017\u0010\u0011\u001A\u00020\u00012\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0082\b\"\u000E\u0010\f\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"forEachVisibleItem", "", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "itemIndex", "", "itemKey", "mainAxisSize", "InvalidItemSize", "InvalidIndex", "UnsetItemCount", "DebugEnabled", "", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CacheWindowLogicKt {
    private static final boolean DebugEnabled = false;
    public static final int InvalidIndex = -1;
    private static final int InvalidItemSize = -1;
    private static final int UnsetItemCount = -1;

    private static final void debugLog(Function0 arg0) {
    }

    public static final void forEachVisibleItem(CacheWindowScope arg5, Function3 arg6) {
        int v0 = arg5.getVisibleLineCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg6.invoke(Integer.valueOf(arg5.getVisibleItemLine(v1)), arg5.getVisibleLineKey(v1), Integer.valueOf(arg5.getVisibleItemSize(v1)));
        }
    }
}

