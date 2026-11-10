package kotlin.internal.jdk8;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;
import kotlin.time.Clock;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0082\u0080\u0004J\u001C\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0096\u0080\u0004J\n\u0010\u000E\u001A\u00020\u000FH\u0096\u0080\u0004J\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004¨\u0006\u0013"}, d2={"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "<init>", "()V", "sdkIsNullOrAtLeast", "", "version", "", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "defaultPlatformRandom", "Lkotlin/random/Random;", "getSystemClock", "Lkotlin/time/Clock;", "ReflectSdkVersion", "kotlin-stdlib-jdk8"}, k=1, mv={2, 3, 0}, xi=0x30) public class JDK8PlatformImplementations extends JDK7PlatformImplementations {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0084\b¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2={"Lkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", "", "<init>", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk8"}, k=1, mv={2, 3, 0}, xi=0x30) final class ReflectSdkVersion {
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

    public JDK8PlatformImplementations() {
        super();
    }

    public Random defaultPlatformRandom() {
        if(this.sdkIsNullOrAtLeast(34)) {
            return new PlatformThreadLocalRandom();
        }

        return super.defaultPlatformRandom();
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg4, "matchResult");
        Intrinsics.checkNotNullParameter(arg5, "name");
        MatchGroup v0 = null;
        if((arg4 instanceof Matcher)) {
        }
        else {
            arg4 = ((MatchResult)v0);
        }

        if(arg4 != null) {
            IntRange v3 = new IntRange(((Matcher)arg4).start(arg5), ((Matcher)arg4).end(arg5) - 1);
            if(v3.getStart().intValue() >= 0) {
                String v4 = ((Matcher)arg4).group(arg5);
                Intrinsics.checkNotNullExpressionValue(v4, "group(...)");
                v0 = new MatchGroup(v4, v3);
            }

            return v0;
        }

        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public Clock getSystemClock() {
        if(this.sdkIsNullOrAtLeast(26)) {
            return new JDK8PlatformImplementations$getSystemClock$1();
        }

        return new JDK8PlatformImplementations$getSystemClock$2();
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

