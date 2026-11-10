package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\b\u0002\n\u0002\u0010\u000F\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0017\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0014\n\u0002\u0010\u0013\n\u0002\b\u0002\u001A/\u0010\u0000\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001A\u0002H\u00012\u0006\u0010\u0004\u001A\u0002H\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0005\u001A\u001A\u0010\u0000\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u0004\u001A\u00020\u0006H\u0087\u0088\u0004\u001A\u001A\u0010\u0000\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\u001A\u0010\u0000\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00020\bH\u0087\u0088\u0004\u001A\u001A\u0010\u0000\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\tH\u0087\u0088\u0004\u001A\u001A\u0010\u0000\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\n2\u0006\u0010\u0004\u001A\u00020\nH\u0087\u0088\u0004\u001A\u001A\u0010\u0000\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u000BH\u0087\u0088\u0004\u001A7\u0010\u0000\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001A\u0002H\u00012\u0006\u0010\u0004\u001A\u0002H\u00012\u0006\u0010\f\u001A\u0002H\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\r\u001A\"\u0010\u0000\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u0004\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u0006H\u0087\u0088\u0004\u001A\"\u0010\u0000\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\"\u0010\u0000\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\bH\u0087\u0088\u0004\u001A\"\u0010\u0000\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\tH\u0087\u0088\u0004\u001A\"\u0010\u0000\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\n2\u0006\u0010\u0004\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0087\u0088\u0004\u001A\"\u0010\u0000\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0087\u0088\u0004\u001A;\u0010\u0000\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001A\u0002H\u00012\u0012\u0010\u000E\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000F\"\u0002H\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0010\u001A\u001E\u0010\u0000\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\n\u0010\u000E\u001A\u00020\u0011\"\u00020\u0006H\u0087\u0080\u0004\u001A\u001E\u0010\u0000\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00072\n\u0010\u000E\u001A\u00020\u0012\"\u00020\u0007H\u0087\u0080\u0004\u001A\u001E\u0010\u0000\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\b2\n\u0010\u000E\u001A\u00020\u0013\"\u00020\bH\u0087\u0080\u0004\u001A\u001E\u0010\u0000\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\t2\n\u0010\u000E\u001A\u00020\u0014\"\u00020\tH\u0087\u0080\u0004\u001A\u001E\u0010\u0000\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\n2\n\u0010\u000E\u001A\u00020\u0015\"\u00020\nH\u0087\u0080\u0004\u001A\u001E\u0010\u0000\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u000B2\n\u0010\u000E\u001A\u00020\u0016\"\u00020\u000BH\u0087\u0080\u0004\u001A/\u0010\u0017\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001A\u0002H\u00012\u0006\u0010\u0004\u001A\u0002H\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0005\u001A\u001A\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u0004\u001A\u00020\u0006H\u0087\u0088\u0004\u001A\u001A\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\u001A\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00020\bH\u0087\u0088\u0004\u001A\u001A\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\tH\u0087\u0088\u0004\u001A\u001A\u0010\u0017\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\n2\u0006\u0010\u0004\u001A\u00020\nH\u0087\u0088\u0004\u001A\u001A\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u000BH\u0087\u0088\u0004\u001A7\u0010\u0017\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001A\u0002H\u00012\u0006\u0010\u0004\u001A\u0002H\u00012\u0006\u0010\f\u001A\u0002H\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\r\u001A\"\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u0004\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u0006H\u0087\u0088\u0004\u001A\"\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0007H\u0087\u0088\u0004\u001A\"\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\bH\u0087\u0088\u0004\u001A\"\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\tH\u0087\u0088\u0004\u001A\"\u0010\u0017\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\n2\u0006\u0010\u0004\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0087\u0088\u0004\u001A\"\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0087\u0088\u0004\u001A;\u0010\u0017\u001A\u0002H\u0001\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001A\u0002H\u00012\u0012\u0010\u000E\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000F\"\u0002H\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0010\u001A\u001E\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\n\u0010\u000E\u001A\u00020\u0011\"\u00020\u0006H\u0087\u0080\u0004\u001A\u001E\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00072\n\u0010\u000E\u001A\u00020\u0012\"\u00020\u0007H\u0087\u0080\u0004\u001A\u001E\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\b2\n\u0010\u000E\u001A\u00020\u0013\"\u00020\bH\u0087\u0080\u0004\u001A\u001E\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\t2\n\u0010\u000E\u001A\u00020\u0014\"\u00020\tH\u0087\u0080\u0004\u001A\u001E\u0010\u0017\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\n2\n\u0010\u000E\u001A\u00020\u0015\"\u00020\nH\u0087\u0080\u0004\u001A\u001E\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u000B2\n\u0010\u000E\u001A\u00020\u0016\"\u00020\u000BH\u0087\u0080\u0004¨\u0006\u0018"}, d2={"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/comparisons/ComparisonsKt") class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    public ComparisonsKt___ComparisonsJvmKt() {
        super();
    }

    private static final byte maxOf(byte arg0, byte arg1) {
        return ((byte)Math.max(arg0, arg1));
    }

    private static final byte maxOf(byte arg0, byte arg1, byte arg2) {
        return ((byte)Math.max(arg0, Math.max(arg1, arg2)));
    }

    public static final byte maxOf(byte arg3, byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = ((byte)Math.max(arg3, arg4[v1]));
        }

        return arg3;
    }

    private static final double maxOf(double arg0, double arg2) {
        return Math.max(arg0, arg2);
    }

    private static final double maxOf(double arg0, double arg2, double arg4) {
        return Math.max(arg0, Math.max(arg2, arg4));
    }

    public static final double maxOf(double arg4, double[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = arg6.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4 = Math.max(arg4, arg6[v1]);
        }

        return arg4;
    }

    private static final float maxOf(float arg0, float arg1) {
        return Math.max(arg0, arg1);
    }

    private static final float maxOf(float arg0, float arg1, float arg2) {
        return Math.max(arg0, Math.max(arg1, arg2));
    }

    public static final float maxOf(float arg3, float[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = Math.max(arg3, arg4[v1]);
        }

        return arg3;
    }

    private static final int maxOf(int arg0, int arg1) {
        return Math.max(arg0, arg1);
    }

    private static final int maxOf(int arg0, int arg1, int arg2) {
        return Math.max(arg0, Math.max(arg1, arg2));
    }

    public static final int maxOf(int arg3, int[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = Math.max(arg3, arg4[v1]);
        }

        return arg3;
    }

    private static final long maxOf(long arg0, long arg2) {
        return Math.max(arg0, arg2);
    }

    private static final long maxOf(long arg0, long arg2, long arg4) {
        return Math.max(arg0, Math.max(arg2, arg4));
    }

    public static final long maxOf(long arg4, long[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = arg6.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4 = Math.max(arg4, arg6[v1]);
        }

        return arg4;
    }

    public static final Comparable maxOf(Comparable arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "a");
        Intrinsics.checkNotNullParameter(arg2, "b");
        if(arg1.compareTo(arg2) >= 0) {
            return arg1;
        }

        return arg2;
    }

    public static final Comparable maxOf(Comparable arg1, Comparable arg2, Comparable arg3) {
        Intrinsics.checkNotNullParameter(arg1, "a");
        Intrinsics.checkNotNullParameter(arg2, "b");
        Intrinsics.checkNotNullParameter(arg3, "c");
        return ComparisonsKt.maxOf(arg1, ComparisonsKt.maxOf(arg2, arg3));
    }

    public static final Comparable maxOf(Comparable arg3, Comparable[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "a");
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = ComparisonsKt.maxOf(arg3, arg4[v1]);
        }

        return arg3;
    }

    private static final short maxOf(short arg0, short arg1) {
        return ((short)Math.max(arg0, arg1));
    }

    private static final short maxOf(short arg0, short arg1, short arg2) {
        return ((short)Math.max(arg0, Math.max(arg1, arg2)));
    }

    public static final short maxOf(short arg3, short[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = ((short)Math.max(arg3, arg4[v1]));
        }

        return arg3;
    }

    private static final byte minOf(byte arg0, byte arg1) {
        return ((byte)Math.min(arg0, arg1));
    }

    private static final byte minOf(byte arg0, byte arg1, byte arg2) {
        return ((byte)Math.min(arg0, Math.min(arg1, arg2)));
    }

    public static final byte minOf(byte arg3, byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = ((byte)Math.min(arg3, arg4[v1]));
        }

        return arg3;
    }

    private static final double minOf(double arg0, double arg2) {
        return Math.min(arg0, arg2);
    }

    private static final double minOf(double arg0, double arg2, double arg4) {
        return Math.min(arg0, Math.min(arg2, arg4));
    }

    public static final double minOf(double arg4, double[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = arg6.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4 = Math.min(arg4, arg6[v1]);
        }

        return arg4;
    }

    private static final float minOf(float arg0, float arg1) {
        return Math.min(arg0, arg1);
    }

    private static final float minOf(float arg0, float arg1, float arg2) {
        return Math.min(arg0, Math.min(arg1, arg2));
    }

    public static final float minOf(float arg3, float[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = Math.min(arg3, arg4[v1]);
        }

        return arg3;
    }

    private static final int minOf(int arg0, int arg1) {
        return Math.min(arg0, arg1);
    }

    private static final int minOf(int arg0, int arg1, int arg2) {
        return Math.min(arg0, Math.min(arg1, arg2));
    }

    public static final int minOf(int arg3, int[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = Math.min(arg3, arg4[v1]);
        }

        return arg3;
    }

    private static final long minOf(long arg0, long arg2) {
        return Math.min(arg0, arg2);
    }

    private static final long minOf(long arg0, long arg2, long arg4) {
        return Math.min(arg0, Math.min(arg2, arg4));
    }

    public static final long minOf(long arg4, long[] arg6) {
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = arg6.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4 = Math.min(arg4, arg6[v1]);
        }

        return arg4;
    }

    public static final Comparable minOf(Comparable arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "a");
        Intrinsics.checkNotNullParameter(arg2, "b");
        if(arg1.compareTo(arg2) <= 0) {
            return arg1;
        }

        return arg2;
    }

    public static final Comparable minOf(Comparable arg1, Comparable arg2, Comparable arg3) {
        Intrinsics.checkNotNullParameter(arg1, "a");
        Intrinsics.checkNotNullParameter(arg2, "b");
        Intrinsics.checkNotNullParameter(arg3, "c");
        return ComparisonsKt.minOf(arg1, ComparisonsKt.minOf(arg2, arg3));
    }

    public static final Comparable minOf(Comparable arg3, Comparable[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "a");
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = ComparisonsKt.minOf(arg3, arg4[v1]);
        }

        return arg3;
    }

    private static final short minOf(short arg0, short arg1) {
        return ((short)Math.min(arg0, arg1));
    }

    private static final short minOf(short arg0, short arg1, short arg2) {
        return ((short)Math.min(arg0, Math.min(arg1, arg2)));
    }

    public static final short minOf(short arg3, short[] arg4) {
        Intrinsics.checkNotNullParameter(arg4, "other");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3 = ((short)Math.min(arg3, arg4[v1]));
        }

        return arg3;
    }
}

