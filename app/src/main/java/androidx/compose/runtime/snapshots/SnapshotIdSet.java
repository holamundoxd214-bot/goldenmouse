package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u0000 ,2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001,B5\b\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\n\u0010\u0006\u001A\u00060\u0002j\u0002`\u0003\u0012\u000E\u0010\u0007\u001A\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\u000F2\n\u0010\u0010\u001A\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001A\u00020\u00002\n\u0010\u0010\u001A\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001A\u00020\u00002\n\u0010\u0010\u001A\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0013J\u000E\u0010\u0015\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u0000J\u000E\u0010\u0017\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u0000J\u000E\u0010\u0018\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\u0000J\u0013\u0010\u001A\u001A\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001BH\u0096\u0002J>\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\u00002+\u0010\u001E\u001A\'\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00000\u001FH\u0082\bJ!\u0010#\u001A\u00020$2\u0016\u0010%\u001A\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020$0&H\u0086\bJ\u001B\u0010\'\u001A\u00060\u0002j\u0002`\u00032\n\u0010(\u001A\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010)J\b\u0010*\u001A\u00020+H\u0016R\u000E\u0010\u0004\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00060\u0002j\u0002`\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0007\u001A\n\u0018\u00010\bj\u0004\u0018\u0001`\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006-"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "upperSet", "lowerSet", "lowerBound", "belowBound", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "<init>", "(JJJ[J)V", "J", "[J", "get", "", "id", "(J)Z", "set", "(J)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "clear", "andNot", "ids", "and", "or", "bits", "iterator", "", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "lowest", "default", "(J)J", "toString", "", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotIdSet implements Iterable, KMappedMarker {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final SnapshotIdSet EMPTY;
    private final long[] belowBound;
    private final long lowerBound;
    private final long lowerSet;
    private final long upperSet;

    static {
        SnapshotIdSet.Companion = new Companion(null);
        SnapshotIdSet.EMPTY = new SnapshotIdSet(0, 0, 0, null);
    }

    private SnapshotIdSet(long arg1, long arg3, long arg5, long[] arg7) {
        super();
        this.upperSet = arg1;
        this.lowerSet = arg3;
        this.lowerBound = arg5;
        this.belowBound = arg7;
    }

    public static final long[] access$getBelowBound$p(SnapshotIdSet arg0) {
        return arg0.belowBound;
    }

    public static final SnapshotIdSet access$getEMPTY$cp() {
        return SnapshotIdSet.EMPTY;
    }

    public static final long access$getLowerBound$p(SnapshotIdSet arg2) {
        return arg2.lowerBound;
    }

    public static final long access$getLowerSet$p(SnapshotIdSet arg2) {
        return arg2.lowerSet;
    }

    public static final long access$getUpperSet$p(SnapshotIdSet arg2) {
        return arg2.upperSet;
    }

    public final SnapshotIdSet and(SnapshotIdSet arg20) {
        long v12_1;
        int v10_1;
        long v0_1;
        long v4;
        long v15;
        long v8;
        long v6;
        long[] v12;
        long[] v3_1;
        long v10;
        SnapshotIdSet v0 = this;
        SnapshotIdSet v1 = arg20;
        SnapshotIdSet v2 = SnapshotIdSet.EMPTY;
        if(Intrinsics.areEqual(v1, v2)) {
        }
        else if(Intrinsics.areEqual(v0, v2)) {
        }
        else {
            long v3 = v1.lowerBound;
            v10 = v0.lowerBound;
            if(v3 == v10) {
                v3_1 = v1.belowBound;
                v12 = v0.belowBound;
                if(v3_1 == v12) {
                    v6 = v0.upperSet;
                    v8 = v1.upperSet;
                    v15 = 0;
                    v4 = v0.lowerSet;
                    v0_1 = v1.lowerSet;
                    long v17 = v4 & v0_1;
                    if((v6 & v8) == v15 && v17 == v15 && v12 == null) {
                        return v2;
                    }

                    goto label_26;
                }
            }

            goto label_32;
        }

        return v2;
    label_26:
        return new SnapshotIdSet(v6 & v8, v4 & v0_1, v10, v12);
    label_32:
        v15 = 0;
        v4 = 0x40;
        v6 = 1;
        int v8_1 = 0x40;
        int v9 = 0;
        if(v0.belowBound == null) {
            v3_1 = v0.belowBound;
            if(v3_1 != null) {
                v10_1 = v3_1.length;
                int v11;
                for(v11 = 0; v11 < v10_1; ++v11) {
                    v12_1 = v3_1[v11];
                    if(v1.get(v12_1)) {
                        v2 = v2.set(v12_1);
                    }
                }
            }

            if(v0.lowerSet != v15) {
                int v3_2;
                for(v3_2 = 0; v3_2 < v8_1; ++v3_2) {
                    if((v0.lowerSet & v6 << v3_2) != v15) {
                        v10 = v0.lowerBound + (((long)v3_2));
                        if(v1.get(v10)) {
                            v2 = v2.set(v10);
                        }
                    }
                }
            }

            if(v0.upperSet != v15) {
                while(v9 < v8_1) {
                    if((v0.upperSet & v6 << v9) != v15) {
                        v10 = v0.lowerBound + (((long)v9)) + v4;
                        if(v1.get(v10)) {
                            v2 = v2.set(v10);
                        }
                    }

                    ++v9;
                }
            }

            return v2;
        }

        v3_1 = v1.belowBound;
        if(v3_1 != null) {
            v10_1 = v3_1.length;
            for(v11 = 0; v11 < v10_1; ++v11) {
                v12_1 = v3_1[v11];
                if(v0.get(v12_1)) {
                    v2 = v2.set(v12_1);
                }
            }
        }

        if(v1.lowerSet != v15) {
            for(v3_2 = 0; v3_2 < v8_1; ++v3_2) {
                if((v1.lowerSet & v6 << v3_2) != v15) {
                    v10 = v1.lowerBound + (((long)v3_2));
                    if(v0.get(v10)) {
                        v2 = v2.set(v10);
                    }
                }
            }
        }

        if(v1.upperSet != v15) {
            while(v9 < v8_1) {
                if((v1.upperSet & v6 << v9) != v15) {
                    v10 = v1.lowerBound + (((long)v9)) + v4;
                    if(v0.get(v10)) {
                        v2 = v2.set(v10);
                    }
                }

                ++v9;
            }
        }

        return v2;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet arg12) {
        long[] v0_2;
        SnapshotIdSet v0 = SnapshotIdSet.EMPTY;
        if(arg12 == v0) {
            return this;
        }

        if(this == v0) {
            return v0;
        }

        long v0_1 = arg12.lowerBound;
        long v7 = this.lowerBound;
        if(v0_1 == v7) {
            v0_2 = arg12.belowBound;
            long[] v9 = this.belowBound;
            if(v0_2 == v9) {
                return new SnapshotIdSet(~arg12.upperSet & this.upperSet, this.lowerSet & ~arg12.lowerSet, v7, v9);
            }
        }

        v0_2 = arg12.belowBound;
        int v1 = 0;
        if(v0_2 != null) {
            int v2 = v0_2.length;
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                this = this.clear(v0_2[v3]);
            }
        }

        long v4 = 0;
        long v2_1 = 1;
        int v6 = 0x40;
        if(Long.compare(arg12.lowerSet, v4) != 0) {
            int v0_3;
            for(v0_3 = 0; v0_3 < v6; ++v0_3) {
                if((arg12.lowerSet & v2_1 << v0_3) != v4) {
                    this = this.clear(arg12.lowerBound + (((long)v0_3)));
                }
            }
        }

        if(arg12.upperSet != v4) {
            while(v1 < v6) {
                if((arg12.upperSet & v2_1 << v1) != v4) {
                    this = this.clear(arg12.lowerBound + (((long)v1)) + 0x40);
                }

                ++v1;
            }
        }

        return this;
    }

    public final SnapshotIdSet clear(long arg12) {
        long v0 = arg12 - this.lowerBound;
        long v2 = 0;
        long v5 = 1;
        long v7 = 0x40;
        if(Intrinsics.compare(v0, v2) < 0 || Intrinsics.compare(v0, v7) >= 0) {
            if(Intrinsics.compare(v0, v7) >= 0 && Intrinsics.compare(v0, 0x80) < 0) {
                arg12 = v5 << (((int)v0)) - 0x40;
                v0 = this.upperSet;
                if((v0 & arg12) != v2) {
                    return new SnapshotIdSet(v0 & ~arg12, this.lowerSet, this.lowerBound, this.belowBound);
                }
                else {
                    return this;
                }
            }

            if(Intrinsics.compare(v0, v2) >= 0) {
                return this;
            }

            long[] v0_1 = this.belowBound;
            if(v0_1 == null) {
                return this;
            }

            int v12 = SnapshotId_jvmKt.binarySearch(v0_1, arg12);
            if(v12 < 0) {
                return this;
            }

            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdRemovedAt(v0_1, v12));
        }
        else {
            arg12 = v5 << (((int)v0));
            v0 = this.lowerSet;
            if((v0 & arg12) != v2) {
                return new SnapshotIdSet(this.upperSet, v0 & ~arg12, this.lowerBound, this.belowBound);
            }
        }

        return this;
    }

    private final SnapshotIdSet fastFold(SnapshotIdSet arg12, Function2 arg13) {
        Object v12;
        long[] v0 = this.belowBound;
        int v1 = 0;
        if(v0 != null) {
            int v2 = v0.length;
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                v12 = arg13.invoke(v12, Long.valueOf(v0[v3]));
            }
        }

        long v4 = 0;
        long v2_1 = 1;
        int v6 = 0x40;
        if(Long.compare(this.lowerSet, v4) != 0) {
            int v0_1;
            for(v0_1 = 0; v0_1 < v6; ++v0_1) {
                if((this.lowerSet & v2_1 << v0_1) != v4) {
                    v12 = arg13.invoke(v12, Long.valueOf(this.lowerBound + (((long)v0_1))));
                }
            }
        }

        if(this.upperSet != v4) {
            while(v1 < v6) {
                if((this.upperSet & v2_1 << v1) != v4) {
                    v12 = arg13.invoke(v12, Long.valueOf(this.lowerBound + (((long)v1)) + 0x40));
                }

                ++v1;
            }
        }

        return ((SnapshotIdSet)v12);
    }

    public final void fastForEach(Function1 arg12) {
        long[] v0 = this.belowBound;
        int v1 = 0;
        if(v0 != null) {
            int v2 = v0.length;
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                arg12.invoke(Long.valueOf(v0[v3]));
            }
        }

        long v4 = 0;
        long v2_1 = 1;
        int v6 = 0x40;
        if(Long.compare(this.lowerSet, v4) != 0) {
            int v0_1;
            for(v0_1 = 0; v0_1 < v6; ++v0_1) {
                if((this.lowerSet & v2_1 << v0_1) != v4) {
                    arg12.invoke(Long.valueOf(this.lowerBound + (((long)v0_1))));
                }
            }
        }

        if(this.upperSet != v4) {
            while(v1 < v6) {
                if((this.upperSet & v2_1 << v1) != v4) {
                    arg12.invoke(Long.valueOf(this.lowerBound + (((long)v1)) + 0x40));
                }

                ++v1;
            }
        }
    }

    public final boolean get(long arg12) {
        long v0 = arg12 - this.lowerBound;
        long v2 = 0;
        long v5 = 1;
        long v7 = 0x40;
        if(Intrinsics.compare(v0, v2) >= 0 && Intrinsics.compare(v0, v7) < 0) {
            if((v5 << (((int)v0)) & this.lowerSet) != v2) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(Intrinsics.compare(v0, v7) >= 0 && Intrinsics.compare(v0, 0x80) < 0) {
            if((v5 << (((int)v0)) - 0x40 & this.upperSet) != v2) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(Intrinsics.compare(v0, v2) > 0) {
            return 0;
        }

        long[] v11 = this.belowBound;
        if(v11 != null && SnapshotId_jvmKt.binarySearch(v11, arg12) >= 0) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, null)).iterator();
    }

    public final long lowest(long arg6) {
        long[] v0 = this.belowBound;
        if(v0 != null) {
            return v0[0];
        }

        long v0_1 = this.lowerSet;
        long v2 = 0;
        if(v0_1 != v2) {
            return this.lowerBound + (((long)Long.numberOfTrailingZeros(v0_1)));
        }

        v0_1 = this.upperSet;
        if(v0_1 != v2) {
            return this.lowerBound + 0x40 + (((long)Long.numberOfTrailingZeros(v0_1)));
        }

        return arg6;
    }

    public final SnapshotIdSet or(SnapshotIdSet arg15) {
        int v9_1;
        long[] v0_2;
        SnapshotIdSet v0 = SnapshotIdSet.EMPTY;
        if(arg15 == v0) {
            return this;
        }

        if(this == v0) {
            return arg15;
        }

        long v0_1 = arg15.lowerBound;
        long v7 = this.lowerBound;
        if(v0_1 == v7) {
            v0_2 = arg15.belowBound;
            long[] v9 = this.belowBound;
            if(v0_2 == v9) {
                return new SnapshotIdSet(arg15.upperSet | this.upperSet, this.lowerSet | arg15.lowerSet, v7, v9);
            }
        }

        long v1 = 0x40;
        long v3 = 1;
        int v5 = 0x40;
        int v6 = 0;
        v7 = 0;
        if(this.belowBound == null) {
            v0_2 = this.belowBound;
            if(v0_2 != null) {
                v9_1 = v0_2.length;
                int v10;
                for(v10 = 0; v10 < v9_1; ++v10) {
                    arg15 = arg15.set(v0_2[v10]);
                }
            }

            if(this.lowerSet != v7) {
                int v0_3;
                for(v0_3 = 0; v0_3 < v5; ++v0_3) {
                    if((this.lowerSet & v3 << v0_3) != v7) {
                        arg15 = arg15.set(this.lowerBound + (((long)v0_3)));
                    }
                }
            }

            if(this.upperSet != v7) {
                while(v6 < v5) {
                    if((this.upperSet & v3 << v6) != v7) {
                        arg15 = arg15.set(this.lowerBound + (((long)v6)) + v1);
                    }

                    ++v6;
                }
            }

            return arg15;
        }

        v0_2 = arg15.belowBound;
        if(v0_2 != null) {
            v9_1 = v0_2.length;
            for(v10 = 0; v10 < v9_1; ++v10) {
                this = this.set(v0_2[v10]);
            }
        }

        if(arg15.lowerSet != v7) {
            for(v0_3 = 0; v0_3 < v5; ++v0_3) {
                if((arg15.lowerSet & v3 << v0_3) != v7) {
                    this = this.set(arg15.lowerBound + (((long)v0_3)));
                }
            }
        }

        if(arg15.upperSet != v7) {
            while(v6 < v5) {
                if((arg15.upperSet & v3 << v6) != v7) {
                    this = this.set(arg15.lowerBound + (((long)v6)) + v1);
                }

                ++v6;
            }
        }

        return this;
    }

    public final SnapshotIdSet set(long arg28) {
        long[] v3_2;
        long v24;
        long v22;
        SnapshotIdSet v0 = this;
        long v1 = arg28;
        long v3 = v1 - v0.lowerBound;
        long v5 = 0;
        long v8 = 0x40;
        long v10 = 1;
        if(Intrinsics.compare(v3, v5) < 0 || Intrinsics.compare(v3, v8) >= 0) {
            int v12 = 0x40;
            long v13 = 0x80;
            if(Intrinsics.compare(v3, v8) >= 0 && Intrinsics.compare(v3, v13) < 0) {
                v1 = v10 << (((int)v3)) - v12;
                v3 = v0.upperSet;
                if((v3 & v1) == v5) {
                    return new SnapshotIdSet(v3 | v1, v0.lowerSet, v0.lowerBound, v0.belowBound);
                }
                else {
                    return v0;
                }
            }

            if(Intrinsics.compare(v3, v13) >= 0) {
                if(this.get(arg28)) {
                    return v0;
                }

                v13 = v0.upperSet;
                long v15 = v8;
                v8 = v0.lowerSet;
                long v17 = v10;
                v10 = v0.lowerBound;
                long v21 = v13;
                long v12_1 = (v1 + v17) / v15 * v15;
                if(Intrinsics.compare(v12_1, v5) < 0) {
                    v12_1 = 0x7FFFFFFFFFFFFF80L;
                }

                SnapshotIdArrayBuilder v7 = null;
                long v20;
                for(v20 = v21; Intrinsics.compare(v10, v12_1) < 0; v20 = v5) {
                    if(v8 != v5) {
                        if(v7 == null) {
                            v7 = new SnapshotIdArrayBuilder(v0.belowBound);
                        }

                        int v3_1 = 0;
                        int v14 = 0x40;
                        while(v3_1 < v14) {
                            v22 = v5;
                            if(Long.compare(v8 & v17 << v3_1, v5) != 0) {
                                v7.add((((long)v3_1)) + v10);
                            }

                            ++v3_1;
                            v5 = v22;
                        }
                    }

                    v22 = v5;
                    if(v20 == v22) {
                        v24 = v12_1;
                        goto label_95;
                    }

                    v10 += v15;
                    v8 = v20;
                    v5 = v22;
                }

                v22 = v8;
                v24 = v10;
            label_95:
                if(v7 != null) {
                    v3_2 = v7.toArray();
                    if(v3_2 == null) {
                        goto label_99;
                    }
                }
                else {
                label_99:
                    v3_2 = v0.belowBound;
                }

                return new SnapshotIdSet(v20, v22, v24, v3_2).set(v1);
            }

            v3_2 = v0.belowBound;
            if(v3_2 == null) {
                return new SnapshotIdSet(v0.upperSet, v0.lowerSet, v0.lowerBound, new long[]{v1});
            }

            int v5_1 = SnapshotId_jvmKt.binarySearch(v3_2, v1);
            if(v5_1 >= 0) {
                return v0;
            }

            return new SnapshotIdSet(v0.upperSet, v0.lowerSet, v0.lowerBound, SnapshotId_jvmKt.withIdInsertedAt(v3_2, -(v5_1 + 1), v1));
        }
        else {
            v1 = v10 << (((int)v3));
            v3 = v0.lowerSet;
            if((v3 & v1) == v5) {
                return new SnapshotIdSet(v0.upperSet, v3 | v1, v0.lowerBound, v0.belowBound);
            }
        }

        return v0;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder().append(super.toString()).append(" [");
        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)this), 10));
        Iterator v12 = ((Iterable)this).iterator();
        while(v12.hasNext()) {
            ((Collection)v1).add(String.valueOf(v12.next().longValue()));
        }

        return v0.append(ListUtilsKt.fastJoinToString$default(v1, null, null, null, 0, null, null, 0x3F, null)).append(']').toString();
    }
}

