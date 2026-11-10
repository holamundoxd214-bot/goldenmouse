package com.TryJeanPc.goldenmouse.input;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0001&BE\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000B¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0006HÆ\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001D\u001A\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010\u001E\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000BHÆ\u0003JV\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000BHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001A\u00020\"2\b\u0010#\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001A\u00020\tHÖ\u0001J\t\u0010%\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000FR\u0015\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GameForegroundObservation;", "", "target", "", "observer", "sampledAtMillis", "", "topPackage", "activityType", "", "foregroundPackages", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/util/Set;)V", "getTarget", "()Ljava/lang/String;", "getObserver", "getSampledAtMillis", "()J", "getTopPackage", "getActivityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getForegroundPackages", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/util/Set;)Lcom/TryJeanPc/goldenmouse/input/GameForegroundObservation;", "equals", "", "other", "hashCode", "toString", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GameForegroundObservation {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000B2\u000E\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/input/GameForegroundObservation$Companion;", "", "<init>", "()V", "parse", "Lcom/TryJeanPc/goldenmouse/input/GameForegroundObservation;", "target", "", "observer", "payload", "now", "", "packages", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GameForegroundObservation parse(String arg15, String arg16, String arg17, long arg18, Set arg20) {
            long v4_1;
            String v14 = arg17;
            Intrinsics.checkNotNullParameter(arg15, "target");
            String v3 = arg16;
            Intrinsics.checkNotNullParameter(v3, "observer");
            Intrinsics.checkNotNullParameter(v14, "payload");
            int v0 = 320;
            int v1 = 1;
            List v4 = StringsKt.split$default(StringsKt.take(v14, v0), new char[]{'|'}, false, 0, 6, null);
            Object v5 = CollectionsKt.firstOrNull(v4);
            Integer v6 = null;
            Long v5_1 = v5 != null ? StringsKt.toLongOrNull(((String)v5)) : ((Long)v6);
            Object v7 = CollectionsKt.getOrNull(v4, 1);
            int v8 = 2;
            Object v9 = CollectionsKt.getOrNull(v4, v8);
            Integer v9_1 = v9 != null ? StringsKt.toIntOrNull(((String)v9)) : v6;
            if(v14.length() > v0 || v4.size() != 3 || v5_1 == null) {
            label_63:
                v1 = 0;
            }
            else {
                long v10 = arg18 - v5_1.longValue();
                if(0 > v10) {
                    goto label_63;
                }
                else if(v10 >= 1601) {
                    goto label_63;
                }
                else if(v7 == null) {
                    goto label_63;
                }
                else if(((String)v7).length() > 0xFF) {
                    goto label_63;
                }
                else if(new Regex("[A-Za-z_][A-Za-z0-9_.]*").matches(v7)) {
                    IntRange v14_1 = new IntRange(1, v8);
                    if(v9_1 == null) {
                        goto label_63;
                    }
                    else if(v14_1.contains(v9_1.intValue())) {
                    }
                    else {
                        goto label_63;
                    }
                }
                else {
                    goto label_63;
                }
            }

            if(v1 == 0) {
                v4_1 = arg18;
            }
            else if(v5_1 != null) {
                v4_1 = ((Number)v5_1).longValue();
            }
            else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            if(v1 != 0) {
            }
            else {
                v7 = v6;
            }

            if(v1 != 0) {
                v6 = v9_1;
            }

            return new GameForegroundObservation(arg15, v3, v4_1, v7, v6, arg20);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final Integer activityType;
    private final Set foregroundPackages;
    private final String observer;
    private final long sampledAtMillis;
    private final String target;
    private final String topPackage;

    static {
        GameForegroundObservation.Companion = new Companion(null);
        GameForegroundObservation.$stable = 8;
    }

    public GameForegroundObservation(String arg10, String arg11, long arg12, String arg14, Integer arg15, Set arg16, int arg17, DefaultConstructorMarker arg18) {
        Set v8 = (arg17 & 0x20) != 0 ? null : arg16;
        this(arg10, arg11, arg12, arg14, arg15, v8);
    }

    public GameForegroundObservation(String arg2, String arg3, long arg4, String arg6, Integer arg7, Set arg8) {
        Intrinsics.checkNotNullParameter(arg2, "target");
        Intrinsics.checkNotNullParameter(arg3, "observer");
        super();
        this.target = arg2;
        this.observer = arg3;
        this.sampledAtMillis = arg4;
        this.topPackage = arg6;
        this.activityType = arg7;
        this.foregroundPackages = arg8;
    }

    public final String component1() {
        return this.target;
    }

    public final String component2() {
        return this.observer;
    }

    public final long component3() {
        return this.sampledAtMillis;
    }

    public final String component4() {
        return this.topPackage;
    }

    public final Integer component5() {
        return this.activityType;
    }

    public final Set component6() {
        return this.foregroundPackages;
    }

    public final GameForegroundObservation copy(String arg9, String arg10, long arg11, String arg13, Integer arg14, Set arg15) {
        Intrinsics.checkNotNullParameter(arg9, "target");
        Intrinsics.checkNotNullParameter(arg10, "observer");
        return new GameForegroundObservation(arg9, arg10, arg11, arg13, arg14, arg15);
    }

    public static GameForegroundObservation copy$default(GameForegroundObservation arg0, String arg1, String arg2, long arg3, String arg5, Integer arg6, Set arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.target;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.observer;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.sampledAtMillis;
        }

        if((arg8 & 8) != 0) {
            arg5 = arg0.topPackage;
        }

        if((arg8 & 16) != 0) {
            arg6 = arg0.activityType;
        }

        if((arg8 & 0x20) != 0) {
            arg7 = arg0.foregroundPackages;
        }

        return arg0.copy(arg1, arg2, arg3, arg5, arg6, arg7);
    }

    public boolean equals(Object arg8) {
        if(this == (((GameForegroundObservation)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof GameForegroundObservation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.target, ((GameForegroundObservation)arg8).target)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.observer, ((GameForegroundObservation)arg8).observer)) {
            return 0;
        }

        if(this.sampledAtMillis != ((GameForegroundObservation)arg8).sampledAtMillis) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.topPackage, ((GameForegroundObservation)arg8).topPackage)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.activityType, ((GameForegroundObservation)arg8).activityType)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.foregroundPackages, ((GameForegroundObservation)arg8).foregroundPackages)) {
            return 0;
        }

        return 1;
    }

    public final Integer getActivityType() {
        return this.activityType;
    }

    public final Set getForegroundPackages() {
        return this.foregroundPackages;
    }

    public final String getObserver() {
        return this.observer;
    }

    public final long getSampledAtMillis() {
        return this.sampledAtMillis;
    }

    public final String getTarget() {
        return this.target;
    }

    public final String getTopPackage() {
        return this.topPackage;
    }

    public int hashCode() {
        int v0 = ((this.target.hashCode() * 0x1F + this.observer.hashCode()) * 0x1F + Long.hashCode(this.sampledAtMillis)) * 0x1F;
        String v1 = this.topPackage;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        Integer v1_2 = this.activityType;
        v1_1 = v1_2 == null ? 0 : v1_2.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        Set v3 = this.foregroundPackages;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "GameForegroundObservation(target=" + this.target + ", observer=" + this.observer + ", sampledAtMillis=" + this.sampledAtMillis + ", topPackage=" + this.topPackage + ", activityType=" + this.activityType + ", foregroundPackages=" + this.foregroundPackages + ")";
    }
}

