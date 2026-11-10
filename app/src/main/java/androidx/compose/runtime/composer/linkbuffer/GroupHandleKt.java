package androidx.compose.runtime.composer.linkbuffer;

import kotlin.Metadata;
import kotlin.UInt;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\u001A%\u0010\u0004\u001A\u00060\u0001j\u0002`\u00032\n\u0010\u0005\u001A\u00060\u0006j\u0002`\u00072\n\u0010\b\u001A\u00060\u0006j\u0002`\u0007H\u0080\b\u001A0\u0010\u0004\u001A\u00060\u0001j\u0002`\u00032\n\u0010\r\u001A\u00060\u0006j\u0002`\u00072\n\u0010\u000E\u001A\u00060\u0006j\u0002`\u00072\n\u0010\b\u001A\u00060\u0006j\u0002`\u0007H\u0000\"\u0012\u0010\u0002\u001A\u00060\u0001j\u0002`\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u001C\u0010\t\u001A\u00020\u0006*\u00060\u0001j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B\"\u001C\u0010\b\u001A\u00020\u0006*\u00060\u0001j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\u000B*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u000F"}, d2={"GroupHandle", "", "NULL_GROUP_HANDLE", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "makeGroupHandle", "groupContext", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "group", "context", "getContext", "(J)I", "getGroup", "parent", "predecessor", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class GroupHandleKt {
    public static final long NULL_GROUP_HANDLE = -1;

    public static final int getContext(long arg1) {
        return ((int)(arg1 >>> 0x20));
    }

    public static final int getGroup(long arg0) {
        return ((int)arg0);
    }

    public static final long makeGroupHandle(int arg4, int arg5, int arg6) {
        long v4;
        long v0 = 0xFFFFFFFFL;
        int v2 = 0x20;
        if(arg6 >= 0) {
            v4 = (((long)arg5)) << v2;
            arg6 = UInt.constructor-impl(arg6);
        }
        else {
            v4 = (((long)arg4)) << v2;
            arg6 = UInt.constructor-impl(-1);
        }

        return v4 | v0 & (((long)arg6));
    }

    public static final long makeGroupHandle(int arg4, int arg5) {
        return (((long)UInt.constructor-impl(arg5))) & 0xFFFFFFFFL | (((long)arg4)) << 0x20;
    }
}

