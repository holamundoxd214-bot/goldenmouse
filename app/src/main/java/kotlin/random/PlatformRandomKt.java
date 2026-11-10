package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004\u001A\u000E\u0010\u0003\u001A\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004\u001A\n\u0010\u0004\u001A\u00020\u0002H\u0081\u0088\u0004\u001A\u001A\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\bH\u0080\u0080\u0004¨\u0006\n"}, d2={"asJavaRandom", "Ljava/util/Random;", "Lkotlin/random/Random;", "asKotlinRandom", "defaultPlatformRandom", "doubleFromParts", "", "hi26", "", "low27", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class PlatformRandomKt {
    public static final Random asJavaRandom(kotlin.random.Random arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        kotlin.random.Random v0 = (arg1 instanceof AbstractPlatformRandom) ? arg1 : null;
        if(v0 != null) {
            Random v0_1 = ((AbstractPlatformRandom)v0).getImpl();
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return new KotlinRandom(arg1);
    }

    public static final kotlin.random.Random asKotlinRandom(Random arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Random v0 = (arg1 instanceof KotlinRandom) ? arg1 : null;
        if(v0 != null) {
            kotlin.random.Random v0_1 = ((KotlinRandom)v0).getImpl();
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return new PlatformRandom(arg1);
    }

    private static final kotlin.random.Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int arg2, int arg3) {
        return (((double)(((((long)arg2)) << 27) + (((long)arg3))))) / 9007199254740992;
    }
}

