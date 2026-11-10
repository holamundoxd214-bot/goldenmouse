package androidx.savedstate.internal;

import kotlin.Metadata;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\" \u0010\u0000\u001A\u0004\u0018\u00010\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"canonicalName", "", "Lkotlin/reflect/KClass;", "getCanonicalName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "savedstate"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CanonicalName_jvmKt {
    public static final String getCanonicalName(KClass arg0) {
        if(arg0 != null) {
            return arg0.getQualifiedName();
        }

        return null;
    }
}

