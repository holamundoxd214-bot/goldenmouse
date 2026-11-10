package kotlin.internal.jdk7;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000FB\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0082\u0080\u0004J\u001A\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0096\u0080\u0004J\u0018\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000B0\u000E2\u0006\u0010\f\u001A\u00020\u000BH\u0096\u0080\u0004¨\u0006\u0010"}, d2={"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "<init>", "()V", "sdkIsNullOrAtLeast", "", "version", "", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "ReflectSdkVersion", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) public class JDK7PlatformImplementations extends PlatformImplementations {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0084\b¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2={"Lkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion;", "", "<init>", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE;
        public static final Integer sdkVersion;

        static {
            Object v1;
            ReflectSdkVersion.INSTANCE = new ReflectSdkVersion();
            Object v0 = null;
            try {
                v1 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(v0);
                if((v1 instanceof Integer)) {
                }
                else {
                    goto label_12;
                }
            }
            catch(Throwable ) {
            label_12:
                v1 = v0;
            }

            if(v1 != null && v1.intValue() > 0) {
                v0 = v1;
            }

            ReflectSdkVersion.sdkVersion = ((Integer)v0);
        }

        private ReflectSdkVersion() {
            super();
        }
    }

    public JDK7PlatformImplementations() {
        super();
    }

    public void addSuppressed(Throwable arg2, Throwable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "cause");
        Intrinsics.checkNotNullParameter(arg3, "exception");
        if(this.sdkIsNullOrAtLeast(19)) {
            arg2.addSuppressed(arg3);
            return;
        }

        super.addSuppressed(arg2, arg3);
    }

    public List getSuppressed(Throwable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "exception");
        if(this.sdkIsNullOrAtLeast(19)) {
            Throwable[] v1 = arg2.getSuppressed();
            Intrinsics.checkNotNullExpressionValue(v1, "getSuppressed(...)");
            return ArraysKt.asList(((Object[])v1));
        }

        return super.getSuppressed(arg2);
    }

    private final boolean sdkIsNullOrAtLeast(int arg1) {
        if(ReflectSdkVersion.sdkVersion != null) {
            if(ReflectSdkVersion.sdkVersion.intValue() >= arg1) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

