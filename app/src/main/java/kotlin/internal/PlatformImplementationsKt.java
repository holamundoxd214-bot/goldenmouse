package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A#\u0010\u0002\u001A\u0002H\u0003\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0083\u0088\u0004¢\u0006\u0002\u0010\u0006\u001A\"\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0081\u0080\u0004\"\u0011\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0084\b¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS;

    static {
        JDK8PlatformImplementations v0 = new JDK8PlatformImplementations();
        try {
            PlatformImplementationsKt.IMPLEMENTATIONS = ((PlatformImplementations)v0);
            return;
        }
        catch(ClassCastException v1) {
            ClassLoader v0_1 = v0.getClass().getClassLoader();
            ClassLoader v2 = PlatformImplementations.class.getClassLoader();
            if(!Intrinsics.areEqual(v0_1, v2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + v0_1 + ", base type classloader: " + v2, ((Throwable)v1));
            }

            throw v1;
        }
    }

    public static final boolean apiVersionIsAtLeast(int arg1, int arg2, int arg3) {
        return KotlinVersion.CURRENT.isAtLeast(arg1, arg2, arg3);
    }

    private static final Object castToBaseType(Object arg5) {
        String v0 = "T";
        try {
            Intrinsics.reifiedOperationMarker(1, v0);
            return arg5;
        }
        catch(ClassCastException v1) {
            ClassLoader v5 = arg5.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker(4, v0);
            ClassLoader v0_1 = Object.class.getClassLoader();
            if(!Intrinsics.areEqual(v5, v0_1)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + v5 + ", base type classloader: " + v0_1, ((Throwable)v1));
            }

            throw v1;
        }
    }
}

