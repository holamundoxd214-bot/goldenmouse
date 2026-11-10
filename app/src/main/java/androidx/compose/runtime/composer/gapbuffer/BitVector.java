package androidx.compose.runtime.composer.gapbuffer;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\nH\u0086\u0002J\u0019\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u000EH\u0086\u0002J\u000E\u0010\u0013\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\nJ\u000E\u0010\u0014\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\nJ%\u0010\u0015\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\n2\u0012\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0017H\u0082\bJ\u0016\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\nJ\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u001D"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/BitVector;", "", "<init>", "()V", "first", "", "second", "others", "", "size", "", "getSize", "()I", "get", "", "index", "set", "", "value", "nextSet", "nextClear", "nextBit", "valueSelector", "Lkotlin/Function1;", "setRange", "start", "end", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class BitVector {
    public static final int $stable = 8;
    private long first;
    private long[] others;
    private long second;

    static {
    }

    public BitVector() {
        super();
        this.others = SlotTableKt.access$getEmptyLongArray$p();
    }

    public final boolean get(int arg10) {
        long v1 = 0;
        long v3 = 1;
        int v6 = 0x40;
        if(arg10 < v6) {
            if((v3 << arg10 & this.first) != v1) {
                return 1;
            }

            return 0;
        }

        if(arg10 < 0x80) {
            if((v3 << arg10 - v6 & this.second) != v1) {
                return 1;
            }

            return 0;
        }

        long[] v9 = this.others;
        int v7 = v9.length;
        if(v7 == 0) {
            return 0;
        }

        int v8 = arg10 / 0x40 - 2;
        if(v8 >= v7) {
            return 0;
        }

        if((v3 << arg10 % v6 & v9[v8]) != v1) {
            return 1;
        }

        return 0;
    }

    public final int getSize() {
        return (this.others.length + 2) * 0x40;
    }

    private final int nextBit(int arg9, Function1 arg10) {
        int v2;
        int v1;
        int v0 = 0x40;
        if(arg9 < v0) {
            v1 = Long.numberOfTrailingZeros(arg10.invoke(Long.valueOf(this.first)).longValue() >>> arg9 << arg9);
            if(v1 < v0) {
                return v1;
            }
        }

        v1 = 0x80;
        if(arg9 < v1) {
            v2 = arg9 - 0x40;
            v2 = Long.numberOfTrailingZeros(arg10.invoke(Long.valueOf(this.second)).longValue() >>> v2 << v2);
            if(v2 < v0) {
                return v2 + v0;
            }
        }

        arg9 = Math.max(arg9, v1);
        v2 = arg9 / 0x40 - 2;
        long[] v8 = this.others;
        int v3 = v8.length;
        int v4;
        for(v4 = v2; v4 < v3; ++v4) {
            long v5 = arg10.invoke(Long.valueOf(v8[v4])).longValue();
            if(v4 == v2) {
                int v7 = arg9 % 0x40;
                v5 = v5 >>> v7 << v7;
            }

            int v5_1 = Long.numberOfTrailingZeros(v5);
            if(v5_1 < v0) {
                return v4 * v0 + v1 + v5_1;
            }
        }

        return 0x7FFFFFFF;
    }

    public final int nextClear(int arg9) {
        int v2;
        int v1;
        int v0 = 0x40;
        if(arg9 < v0) {
            v1 = Long.numberOfTrailingZeros(~this.first >>> arg9 << arg9);
            if(v1 < v0) {
                return v1;
            }
        }

        v1 = 0x80;
        if(arg9 < v1) {
            v2 = arg9 - 0x40;
            v2 = Long.numberOfTrailingZeros(~this.second >>> v2 << v2);
            if(v2 < v0) {
                return v2 + v0;
            }
        }

        arg9 = Math.max(arg9, v1);
        v2 = arg9 / 0x40 - 2;
        long[] v8 = this.others;
        int v3 = v8.length;
        int v4;
        for(v4 = v2; v4 < v3; ++v4) {
            long v5 = ~v8[v4];
            if(v4 == v2) {
                int v7 = arg9 % 0x40;
                v5 = v5 >>> v7 << v7;
            }

            int v5_1 = Long.numberOfTrailingZeros(v5);
            if(v5_1 < v0) {
                return v4 * v0 + v1 + v5_1;
            }
        }

        return 0x7FFFFFFF;
    }

    public final int nextSet(int arg9) {
        int v2;
        int v1;
        int v0 = 0x40;
        if(arg9 < v0) {
            v1 = Long.numberOfTrailingZeros(this.first >>> arg9 << arg9);
            if(v1 < v0) {
                return v1;
            }
        }

        v1 = 0x80;
        if(arg9 < v1) {
            v2 = arg9 - 0x40;
            v2 = Long.numberOfTrailingZeros(this.second >>> v2 << v2);
            if(v2 < v0) {
                return v2 + v0;
            }
        }

        arg9 = Math.max(arg9, v1);
        v2 = arg9 / 0x40 - 2;
        long[] v8 = this.others;
        int v3 = v8.length;
        int v4;
        for(v4 = v2; v4 < v3; ++v4) {
            long v5 = v8[v4];
            if(v4 == v2) {
                int v7 = arg9 % 0x40;
                v5 = v5 >>> v7 << v7;
            }

            int v5_1 = Long.numberOfTrailingZeros(v5);
            if(v5_1 < v0) {
                return v4 * v0 + v1 + v5_1;
            }
        }

        return 0x7FFFFFFF;
    }

    public final void set(int arg8, boolean arg9) {
        long v0 = 1;
        int v2 = 0x40;
        if(arg8 < v2) {
            this.first = (((long)(((int)arg9)))) << arg8 | ~(v0 << arg8) & this.first;
            return;
        }

        if(arg8 < 0x80) {
            this.second = (((long)(((int)arg9)))) << arg8 | ~(v0 << arg8 - 0x40) & this.second;
            return;
        }

        int v3 = arg8 / 0x40;
        int v4 = v3 - 2;
        arg8 %= v2;
        v0 <<= arg8;
        long[] v2_1 = this.others;
        if(v4 >= v2_1.length) {
            v2_1 = Arrays.copyOf(v2_1, v3 - 1);
            Intrinsics.checkNotNullExpressionValue(v2_1, "copyOf(...)");
            this.others = v2_1;
        }

        v2_1[v4] = (((long)(((int)arg9)))) << arg8 | ~v0 & v2_1[v4];
    }

    public final void setRange(int arg10, int arg11) {
        long v0 = arg10 < arg11 ? -1 : 0;
        int v2 = 0;
        int v4 = 0x40;
        int v5 = arg10 < v4 ? 1 : 0;
        this.first |= (((long)v5)) * v0 >>> 0x40 - (Math.min(v4, arg11) - arg10) << arg10;
        if(arg11 > v4) {
            arg10 = Math.max(arg10, v4);
            v4 = 0x80;
            if(arg10 < v4) {
                v2 = 1;
            }

            this.second |= v0 * (((long)v2)) >>> 0x80 - (Math.min(v4, arg11) - arg10) << arg10;
            if(arg11 <= v4) {
                return;
            }

            for(arg10 = Math.max(arg10, v4); arg10 < arg11; ++arg10) {
                this.set(arg10, true);
            }
        }
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("BitVector [");
        int v1 = this.getSize();
        int v2 = 1;
        int v4;
        for(v4 = 0; v4 < v1; ++v4) {
            if(this.get(v4)) {
                if(v2 == 0) {
                    v0.append(", ");
                }

                v0.append(v4);
                v2 = 0;
            }
        }

        v0.append(']');
        return v0.toString();
    }
}

