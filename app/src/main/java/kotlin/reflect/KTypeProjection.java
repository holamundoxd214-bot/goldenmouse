package kotlin.reflect;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001D\bF\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004J\f\u0010\u000E\u001A\u0004\u0018\u00010\u0003HÆ\u0083\u0004J\f\u0010\u000F\u001A\u0004\u0018\u00010\u0005HÆ\u0083\u0004J\"\u0010\u0010\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0081\u0004J\u0014\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001A\u00020\u0015HÖ\u0081\u0004R\u0017\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getVariance", "()Lkotlin/reflect/KVariance;", "getType", "()Lkotlin/reflect/KType;", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class KTypeProjection {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\fH\u0087\u0080\u0004J\u0012\u0010\r\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\fH\u0087\u0080\u0004J\u0012\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\fH\u0087\u0080\u0004R\u0017\u0010\u0004\u001A\u00020\u00058\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0015\u0010\u0007\u001A\u00020\u00058FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000F"}, d2={"Lkotlin/reflect/KTypeProjection$Companion;", "", "<init>", "()V", "star", "Lkotlin/reflect/KTypeProjection;", "getStar$annotations", "STAR", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "invariant", "type", "Lkotlin/reflect/KType;", "contravariant", "covariant", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final KTypeProjection contravariant(KType arg2) {
            Intrinsics.checkNotNullParameter(arg2, "type");
            return new KTypeProjection(KVariance.IN, arg2);
        }

        @JvmStatic public final KTypeProjection covariant(KType arg2) {
            Intrinsics.checkNotNullParameter(arg2, "type");
            return new KTypeProjection(KVariance.OUT, arg2);
        }

        public final KTypeProjection getSTAR() {
            return KTypeProjection.star;
        }

        public static void getStar$annotations() {
        }

        @JvmStatic public final KTypeProjection invariant(KType arg2) {
            Intrinsics.checkNotNullParameter(arg2, "type");
            return new KTypeProjection(KVariance.INVARIANT, arg2);
        }
    }

    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[KVariance.values().length];
            try {
                v0[KVariance.INVARIANT.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[KVariance.IN.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[KVariance.OUT.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final Companion Companion;
    public static final KTypeProjection star;
    private final KType type;
    private final KVariance variance;

    static {
        KTypeProjection.Companion = new Companion(null);
        KTypeProjection.star = new KTypeProjection(null, null);
    }

    public KTypeProjection(KVariance arg3, KType arg4) {
        super();
        this.variance = arg3;
        this.type = arg4;
        int v2 = 1;
        int v1 = arg3 == null ? 1 : 0;
        if(arg4 == null) {
        }
        else {
            v2 = 0;
        }

        if(v1 == v2) {
            return;
        }

        String v2_1 = arg3 == null ? "Star projection must have no type specified." : "The projection variance " + arg3 + " requires type to be specified.";
        throw new IllegalArgumentException(v2_1.toString());
    }

    public final KVariance component1() {
        return this.variance;
    }

    public final KType component2() {
        return this.type;
    }

    @JvmStatic public static final KTypeProjection contravariant(KType arg1) {
        return KTypeProjection.Companion.contravariant(arg1);
    }

    public final KTypeProjection copy(KVariance arg1, KType arg2) {
        return new KTypeProjection(arg1, arg2);
    }

    public static KTypeProjection copy$default(KTypeProjection arg0, KVariance arg1, KType arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.variance;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.type;
        }

        return arg0.copy(arg1, arg2);
    }

    @JvmStatic public static final KTypeProjection covariant(KType arg1) {
        return KTypeProjection.Companion.covariant(arg1);
    }

    public boolean equals(Object arg5) {
        if(this == (((KTypeProjection)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof KTypeProjection)) {
            return 0;
        }

        if(this.variance != ((KTypeProjection)arg5).variance) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.type, ((KTypeProjection)arg5).type)) {
            return 0;
        }

        return 1;
    }

    public final KType getType() {
        return this.type;
    }

    public final KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        KVariance v0 = this.variance;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        KType v2 = this.type;
        if(v2 == null) {
        }
        else {
            v1 = v2.hashCode();
        }

        return v0_1 + v1;
    }

    @JvmStatic public static final KTypeProjection invariant(KType arg1) {
        return KTypeProjection.Companion.invariant(arg1);
    }

    public String toString() {
        KVariance v0 = this.variance;
        int v1 = -1;
        int v0_1 = v0 == null ? v1 : WhenMappings.$EnumSwitchMapping$0[v0.ordinal()];
        if(v0_1 != v1) {
            if(v0_1 != 1) {
                if(v0_1 != 2) {
                    if(v0_1 == 3) {
                        return "out " + this.type;
                    }

                    throw new NoWhenBranchMatchedException();
                }

                return "in " + this.type;
            }

            return String.valueOf(this.type);
        }

        return "*";
    }
}

