package androidx.compose.runtime.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u0004\u0018\u00010\u00012\u0006\u0010\f\u001A\u00020\rJ\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001J\u0018\u0010\u0011\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001J\u0010\u0010\u0012\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\rH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/internal/ThreadMap;", "", "size", "", "keys", "", "values", "", "<init>", "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "get", "key", "", "trySet", "", "value", "newWith", "find", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ThreadMap {
    public static final int $stable = 8;
    private final long[] keys;
    private final int size;
    private final Object[] values;

    static {
    }

    public ThreadMap(int arg1, long[] arg2, Object[] arg3) {
        super();
        this.size = arg1;
        this.keys = arg2;
        this.values = arg3;
    }

    private final int find(long arg9) {
        int v0 = this.size - 1;
        int v1 = -1;
        if(v0 != v1) {
            int v2 = 0;
            if(v0 == 0) {
                goto label_24;
            }

            while(true) {
                if(v2 > v0) {
                    goto label_21;
                }

                v1 = v2 + v0 >>> 1;
                int v3 = Long.compare(this.keys[v1] - arg9, 0);
                if(v3 < 0) {
                    v2 = v1 + 1;
                    continue;
                }

                if(v3 <= 0) {
                    return v1;
                }

                v0 = v1 - 1;
            }

            return v1;
        label_21:
            return -(v2 + 1);
        label_24:
            long v3_1 = this.keys[0];
            if(v3_1 == arg9) {
                return 0;
            }

            if(v3_1 <= arg9) {
                return v1;
            }

            return -2;
        }

        return v1;
    }

    public final Object get(long arg1) {
        int v1 = this.find(arg1);
        if(v1 >= 0) {
            return this.values[v1];
        }

        return null;
    }

    public final ThreadMap newWith(long arg12, Object arg14) {
        int v6;
        int v0 = this.size;
        Object[] v1 = this.values;
        int v2 = v1.length;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        while(v4 < v2) {
            if(v1[v4] != null) {
                ++v5;
            }

            ++v4;
        }

        int v1_1 = v5 + 1;
        long[] v2_1 = new long[v1_1];
        Object[] v4_1 = new Object[v1_1];
        if(v1_1 > 1) {
            v6 = 0;
            goto label_18;
        }
        else {
            v2_1[0] = arg12;
            v4_1[0] = arg14;
            goto label_52;
        label_18:
            while(v3 < v1_1) {
                if(v6 >= v0) {
                    break;
                }

                long v8 = this.keys[v6];
                Object v7 = this.values[v6];
                if(v8 > arg12) {
                    v2_1[v3] = arg12;
                    v4_1[v3] = arg14;
                    ++v3;
                }
                else {
                    if(v7 != null) {
                        v2_1[v3] = v8;
                        v4_1[v3] = v7;
                        ++v3;
                    }

                    ++v6;
                    continue;
                }

                break;
            }

            if(v6 == v0) {
                v2_1[v5] = arg12;
                v4_1[v5] = arg14;
                goto label_52;
            }

            while(v3 < v1_1) {
                long v13 = this.keys[v6];
                Object v12 = this.values[v6];
                if(v12 != null) {
                    v2_1[v3] = v13;
                    v4_1[v3] = v12;
                    ++v3;
                }

                ++v6;
            }
        }

    label_52:
        return new ThreadMap(v1_1, v2_1, v4_1);
    }

    public final boolean trySet(long arg1, Object arg3) {
        int v1 = this.find(arg1);
        if(v1 < 0) {
            return 0;
        }

        this.values[v1] = arg3;
        return 1;
    }
}

