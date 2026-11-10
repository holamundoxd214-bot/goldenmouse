package androidx.collection;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u0019\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\bH\u0080\b\u001A\u001E\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u0002H\u001D0\u001B\"\u0004\b\u0000\u0010\u001C\"\u0004\b\u0001\u0010\u001D\u001A\u001D\u0010\u001E\u001A\u00060\u0001j\u0002`\u001F2\u0006\u0010\u0018\u001A\u00020\r2\u0006\u0010 \u001A\u00020\bH\u0080\b\u001A\u0011\u0010!\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\bH\u0080\b\u001A\u0011\u0010#\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\bH\u0080\b\u001A\u0013\u0010\"\u001A\u00020\b2\b\u0010$\u001A\u0004\u0018\u00010\u0010H\u0080\b\u001A\u0019\u0010%\u001A\u00020&2\u0006\u0010\u0018\u001A\u00020\r2\u0006\u0010\'\u001A\u00020\bH\u0080\b\u001A\u0019\u0010(\u001A\u00020&2\u0006\u0010\u0018\u001A\u00020\r2\u0006\u0010\'\u001A\u00020\bH\u0080\b\u001A\u0011\u0010)\u001A\u00020&2\u0006\u0010*\u001A\u00020\u0001H\u0081\b\u001A\u0019\u0010)\u001A\u00020&2\u0006\u0010\u0018\u001A\u00020\r2\u0006\u0010\'\u001A\u00020\bH\u0080\b\u001A\u0010\u0010+\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\bH\u0000\u001A\u001E\u0010,\u001A\u000E\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u0002H\u001D0\u000F\"\u0004\b\u0000\u0010\u001C\"\u0004\b\u0001\u0010\u001D\u001AO\u0010,\u001A\u000E\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u0002H\u001D0\u000F\"\u0004\b\u0000\u0010\u001C\"\u0004\b\u0001\u0010\u001D2*\u0010-\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u0002H\u001D0/0.\"\u000E\u0012\u0004\u0012\u0002H\u001C\u0012\u0004\u0012\u0002H\u001D0/¢\u0006\u0002\u00100\u001A\u0010\u00101\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\bH\u0000\u001A\u0010\u00102\u001A\u00020\b2\u0006\u00103\u001A\u00020\bH\u0000\u001A\u0019\u00104\u001A\u00020\u00012\u0006\u00105\u001A\u00020\r2\u0006\u0010 \u001A\u00020\bH\u0081\b\u001A\u0010\u00106\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\bH\u0000\u001A)\u00107\u001A\u00020\u00172\u0006\u00105\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\b2\u0006\u0010 \u001A\u00020\b2\u0006\u0010*\u001A\u00020\u0001H\u0080\b\u001A!\u00108\u001A\u00020\u00172\u0006\u00105\u001A\u00020\r2\u0006\u0010 \u001A\u00020\b2\u0006\u0010*\u001A\u00020\u0001H\u0080\b\u001A\u0011\u00109\u001A\u00020\b*\u00060\u0001j\u0002`:H\u0080\b\u001A\u0011\u0010;\u001A\u00020&*\u00060\u0001j\u0002`:H\u0080\b\u001A\u0011\u0010<\u001A\u00020\b*\u00060\u0001j\u0002`=H\u0081\b\u001A\u0015\u0010>\u001A\u00060\u0001j\u0002`:*\u00060\u0001j\u0002`\u001FH\u0080\b\u001A\u0015\u0010?\u001A\u00060\u0001j\u0002`:*\u00060\u0001j\u0002`\u001FH\u0081\b\u001A\u001D\u0010@\u001A\u00060\u0001j\u0002`:*\u00060\u0001j\u0002`\u001F2\u0006\u0010A\u001A\u00020\bH\u0081\b\u001A\u0011\u0010B\u001A\u00020\u0001*\u00060\u0001j\u0002`:H\u0080\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0004\"\u000E\u0010\u0007\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001A\u00020\r8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001C\u0010\u000E\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0014\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0004*\f\b\u0000\u0010C\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010D\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010E\"\u00020\u00012\u00020\u0001¨\u0006F"}, d2={"AllEmpty", "", "BitmaskLsb", "getBitmaskLsb$annotations", "()V", "BitmaskMsb", "getBitmaskMsb$annotations", "ClonedMetadataCount", "", "DefaultScatterCapacity", "Deleted", "Empty", "EmptyGroup", "", "EmptyScatterMap", "Landroidx/collection/MutableScatterMap;", "", "", "GroupWidth", "MurmurHashC1", "Sentinel", "getSentinel$annotations", "convertMetadataForCleanup", "", "metadata", "capacity", "emptyScatterMap", "Landroidx/collection/ScatterMap;", "K", "V", "group", "Landroidx/collection/Group;", "offset", "h1", "hash", "h2", "k", "isDeleted", "", "index", "isEmpty", "isFull", "value", "loadedCapacity", "mutableScatterMapOf", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/collection/MutableScatterMap;", "nextCapacity", "normalizeCapacity", "n", "readRawMetadata", "data", "unloadedCapacity", "writeMetadata", "writeRawMetadata", "get", "Landroidx/collection/Bitmask;", "hasNext", "lowestBitSet", "Landroidx/collection/StaticBitmask;", "maskEmpty", "maskEmptyOrDeleted", "match", "m", "next", "Bitmask", "Group", "StaticBitmask", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 0x101010101010101L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 0xFE;
    public static final long Empty = 0x80;
    public static final long[] EmptyGroup = null;
    private static final MutableScatterMap EmptyScatterMap = null;
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = 0xCC9E2D51;
    public static final long Sentinel = 0xFF;

    static {
        ScatterMapKt.EmptyGroup = new long[]{-9187201950435737345L, -1};
        ScatterMapKt.EmptyScatterMap = new MutableScatterMap(0);
    }

    public static final void convertMetadataForCleanup(long[] arg7, int arg8) {
        Intrinsics.checkNotNullParameter(arg7, "metadata");
        int v0 = 7;
        arg8 = arg8 + v0 >> 3;
        int v2;
        for(v2 = 0; v2 < arg8; ++v2) {
            long v3 = arg7[v2] & -9187201950435737472L;
            arg7[v2] = -72340172838076674L & ~v3 + (v3 >>> v0);
        }

        arg8 = ArraysKt.getLastIndex(arg7);
        v0 = arg8 - 1;
        arg7[v0] = arg7[v0] & 0xFFFFFFFFFFFFFFL | -72057594037927936L;
        arg7[arg8] = arg7[0];
    }

    public static final ScatterMap emptyScatterMap() {
        MutableScatterMap v0 = ScatterMapKt.EmptyScatterMap;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return ((ScatterMap)v0);
    }

    public static final int get(long arg0) {
        return Long.numberOfTrailingZeros(arg0) >> 3;
    }

    public static void getBitmaskLsb$annotations() {
    }

    public static void getBitmaskMsb$annotations() {
    }

    public static void getSentinel$annotations() {
    }

    public static final long group(long[] arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg5, "metadata");
        int v0 = arg6 >> 3;
        arg6 = (arg6 & 7) << 3;
        return -(((long)arg6)) >> 0x3F & arg5[v0 + 1] << 0x40 - arg6 | arg5[v0] >>> arg6;
    }

    public static final int h1(int arg0) {
        return arg0 >>> 7;
    }

    public static final int h2(int arg0) {
        return arg0 & 0x7F;
    }

    public static final boolean hasNext(long arg2) {
        if(arg2 != 0) {
            return 1;
        }

        return 0;
    }

    public static final int hash(Object arg1) {
        int v1 = arg1 != null ? arg1.hashCode() : 0;
        v1 *= 0xCC9E2D51;
        return v1 ^ v1 << 16;
    }

    public static final boolean isDeleted(long[] arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "metadata");
        if((arg2[arg3 >> 3] >> ((arg3 & 7) << 3) & 0xFF) == 0xFE) {
            return 1;
        }

        return 0;
    }

    public static final boolean isEmpty(long[] arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "metadata");
        if((arg2[arg3 >> 3] >> ((arg3 & 7) << 3) & 0xFF) == 0x80) {
            return 1;
        }

        return 0;
    }

    public static final boolean isFull(long arg2) {
        if(arg2 < 0x80) {
            return 1;
        }

        return 0;
    }

    public static final boolean isFull(long[] arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "metadata");
        if((arg2[arg3 >> 3] >> ((arg3 & 7) << 3) & 0xFF) < 0x80) {
            return 1;
        }

        return 0;
    }

    public static final int loadedCapacity(int arg1) {
        if(arg1 == 7) {
            return 6;
        }

        return arg1 - arg1 / 8;
    }

    public static final int lowestBitSet(long arg0) {
        return Long.numberOfTrailingZeros(arg0) >> 3;
    }

    public static final long maskEmpty(long arg3) {
        return arg3 & ~arg3 << 6 & -9187201950435737472L;
    }

    public static final long maskEmptyOrDeleted(long arg3) {
        return arg3 & ~arg3 << 7 & -9187201950435737472L;
    }

    public static final long match(long arg4, int arg6) {
        arg4 ^= (((long)arg6)) * 0x101010101010101L;
        return ~arg4 & arg4 - 0x101010101010101L & -9187201950435737472L;
    }

    public static final MutableScatterMap mutableScatterMapOf() {
        return new MutableScatterMap(0, 1, null);
    }

    public static final MutableScatterMap mutableScatterMapOf(Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        MutableScatterMap v0 = new MutableScatterMap(arg2.length);
        v0.putAll(arg2);
        return v0;
    }

    public static final long next(long arg2) {
        return arg2 & arg2 - 1;
    }

    public static final int nextCapacity(int arg0) {
        if(arg0 == 0) {
            return 6;
        }

        return arg0 * 2 + 1;
    }

    public static final int normalizeCapacity(int arg1) {
        if(arg1 > 0) {
            return -1 >>> Integer.numberOfLeadingZeros(arg1);
        }

        return 0;
    }

    public static final long readRawMetadata(long[] arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "data");
        return arg2[arg3 >> 3] >> ((arg3 & 7) << 3) & 0xFF;
    }

    public static final int unloadedCapacity(int arg2) {
        int v0 = 7;
        if(arg2 == v0) {
            return 8;
        }

        return arg2 + (arg2 - 1) / v0;
    }

    public static final void writeMetadata(long[] arg6, int arg7, int arg8, long arg9) {
        Intrinsics.checkNotNullParameter(arg6, "data");
        int v0 = arg8 >> 3;
        int v1 = (arg8 & 7) << 3;
        arg9 = arg9 << v1 | arg6[v0] & ~(0xFF << v1);
        arg6[v0] = arg9;
        arg6[(arg8 - 7 & arg7) + (arg7 & 7) >> 3] = arg9;
    }

    public static final void writeRawMetadata(long[] arg5, int arg6, long arg7) {
        Intrinsics.checkNotNullParameter(arg5, "data");
        int v0 = arg6 >> 3;
        arg6 = (arg6 & 7) << 3;
        arg5[v0] = arg7 << arg6 | arg5[v0] & ~(0xFF << arg6);
    }
}

