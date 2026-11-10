package kotlin.internal;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;
import kotlin.time.Clock;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0015B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0096\u0080\u0004J\u0018\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\b\u001A\u00020\u0007H\u0096\u0080\u0004J\u001C\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001A\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001A\u00020\u0014H\u0096\u0080\u0004¨\u0006\u0016"}, d2={"Lkotlin/internal/PlatformImplementations;", "", "<init>", "()V", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "defaultPlatformRandom", "Lkotlin/random/Random;", "getSystemClock", "Lkotlin/time/Clock;", "ReflectThrowable", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public class PlatformImplementations {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "<init>", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE;
        public static final Method addSuppressed;
        public static final Method getSuppressed;

        static {
            Method v6;
            Method v5;
            ReflectThrowable.INSTANCE = new ReflectThrowable();
            Class v0 = Throwable.class;
            Method[] v1 = v0.getMethods();
            Intrinsics.checkNotNull(v1);
            int v2 = v1.length;
            int v3 = 0;
            int v4;
            for(v4 = 0; true; ++v4) {
                v5 = null;
                if(v4 >= v2) {
                    break;
                }

                v6 = v1[v4];
                if(Intrinsics.areEqual(v6.getName(), "addSuppressed")) {
                    Class[] v7 = v6.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(v7, "getParameterTypes(...)");
                    if(Intrinsics.areEqual(ArraysKt.singleOrNull(((Object[])v7)), v0)) {
                        goto label_26;
                    }
                }
            }

            v6 = v5;
        label_26:
            ReflectThrowable.addSuppressed = v6;
            int v0_1 = v1.length;
            while(v3 < v0_1) {
                Method v2_1 = v1[v3];
                if(Intrinsics.areEqual(v2_1.getName(), "getSuppressed")) {
                    v5 = v2_1;
                }
                else {
                    ++v3;
                    continue;
                }

                break;
            }

            ReflectThrowable.getSuppressed = v5;
        }

        private ReflectThrowable() {
            super();
        }
    }

    public PlatformImplementations() {
        super();
    }

    public void addSuppressed(Throwable arg1, Throwable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "cause");
        Intrinsics.checkNotNullParameter(arg2, "exception");
        Method v0 = ReflectThrowable.addSuppressed;
        if(v0 != null) {
            v0.invoke(arg1, arg2);
        }
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "matchResult");
        Intrinsics.checkNotNullParameter(arg2, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public List getSuppressed(Throwable arg2) {
        Intrinsics.checkNotNullParameter(arg2, "exception");
        Method v1 = ReflectThrowable.getSuppressed;
        if(v1 != null) {
            Object v1_1 = v1.invoke(arg2);
            if(v1_1 != null) {
                List v1_2 = ArraysKt.asList(((Object[])v1_1));
                if(v1_2 == null) {
                }
                else {
                    return v1_2;
                }
            }
        }

        return CollectionsKt.emptyList();
    }

    public Clock getSystemClock() {
        throw new UnsupportedOperationException("getSystemClock should not be called on the base PlatformImplementations.");
    }
}

