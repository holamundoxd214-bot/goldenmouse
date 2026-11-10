package kotlin.concurrent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AN\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0086\u0080\u0004\u001A4\u0010\u000E\u001A\u0002H\u000F\"\b\b\u0000\u0010\u000F*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000F0\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000F0\fH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2={"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ThreadsKt {
    private static final Object getOrSet(ThreadLocal arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "default");
        Object v0 = arg1.get();
        if(v0 == null) {
            Object v2 = arg2.invoke();
            arg1.set(v2);
            return v2;
        }

        return v0;
    }

    public static final Thread thread(boolean arg1, boolean arg2, ClassLoader arg3, String arg4, int arg5, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "block");
        ThreadsKt$thread$thread$1 v0 = new ThreadsKt$thread$thread$1(arg6);
        if(arg2) {
            v0.setDaemon(true);
        }

        if(arg5 > 0) {
            v0.setPriority(arg5);
        }

        if(arg4 != null) {
            v0.setName(arg4);
        }

        if(arg3 != null) {
            v0.setContextClassLoader(arg3);
        }

        if(arg1) {
            v0.start();
        }

        return ((Thread)v0);
    }

    public static Thread thread$default(boolean arg1, boolean arg2, ClassLoader arg3, String arg4, int arg5, Function0 arg6, int arg7, Object arg8) {
        ClassLoader v0 = null;
        if((arg7 & 4) != 0) {
            arg3 = v0;
        }

        if((arg7 & 8) != 0) {
            arg4 = ((String)v0);
        }

        if((arg7 & 16) != 0) {
            arg5 = -1;
        }

        return ThreadsKt.thread(true, false, arg3, arg4, arg5, arg6);
    }
}

