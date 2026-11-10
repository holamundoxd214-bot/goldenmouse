package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.System_jvmKt;
import androidx.compose.runtime.internal.WeakReference;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00028\u0000¢\u0006\u0002\u0010\u001CJ\u001D\u0010\u001D\u001A\u00020\u001E2\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001A0 H\u0086\bJ\u001D\u0010!\u001A\u00020\u00062\u0006\u0010\u001B\u001A\u00028\u00002\u0006\u0010\"\u001A\u00020\u0006H\u0002¢\u0006\u0002\u0010#J%\u0010$\u001A\u00020\u00062\u0006\u0010%\u001A\u00020\u00062\u0006\u0010\u001B\u001A\u00028\u00002\u0006\u0010&\u001A\u00020\u0006H\u0002¢\u0006\u0002\u0010\'J\r\u0010(\u001A\u00020\u001AH\u0001¢\u0006\u0002\b)R\u001A\u0010\u0005\u001A\u00020\u0006X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u000B\u001A\u00020\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R*\u0010\u0011\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00130\u0012X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0018\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "T", "", "<init>", "()V", "size", "", "getSize$runtime", "()I", "setSize$runtime", "(I)V", "hashes", "", "getHashes$runtime", "()[I", "setHashes$runtime", "([I)V", "values", "", "Landroidx/compose/runtime/internal/WeakReference;", "getValues$runtime", "()[Landroidx/compose/runtime/internal/WeakReference;", "setValues$runtime", "([Landroidx/compose/runtime/internal/WeakReference;)V", "[Landroidx/compose/runtime/internal/WeakReference;", "add", "", "value", "(Ljava/lang/Object;)Z", "removeIf", "", "block", "Lkotlin/Function1;", "find", "hash", "(Ljava/lang/Object;I)I", "findExactIndex", "midIndex", "valueHash", "(ILjava/lang/Object;I)I", "isValid", "isValid$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SnapshotWeakSet {
    public static final int $stable = 8;
    private int[] hashes;
    private int size;
    private WeakReference[] values;

    static {
    }

    public SnapshotWeakSet() {
        super();
        this.hashes = new int[16];
        this.values = new WeakReference[16];
    }

    public final boolean add(Object arg14) {
        int v3;
        int v0 = this.size;
        int v1 = System_jvmKt.identityHashCode(arg14);
        if(v0 > 0) {
            v3 = this.find(arg14, v1);
            if(v3 >= 0) {
                return 0;
            }
        }
        else {
            v3 = -1;
        }

        int v9 = -(v3 + 1);
        WeakReference[] v3_1 = this.values;
        int v5 = v3_1.length;
        if(v0 == v5) {
            v5 *= 2;
            WeakReference[] v12 = new WeakReference[v5];
            int[] v6 = new int[v5];
            v5 = v9 + 1;
            System.arraycopy(v3_1, v9, v12, v5, v0 - v9);
            System.arraycopy(this.values, 0, v12, 0, v9);
            ArraysKt.copyInto(this.hashes, v6, v5, v9, v0);
            ArraysKt.copyInto$default(this.hashes, v6, 0, 0, v9, 6, null);
            this.values = v12;
            this.hashes = v6;
        }
        else {
            int v2 = v9 + 1;
            System.arraycopy(v3_1, v9, v3_1, v2, v0 - v9);
            ArraysKt.copyInto(this.hashes, this.hashes, v2, v9, v0);
        }

        this.values[v9] = new WeakReference(arg14);
        this.hashes[v9] = v1;
        ++this.size;
        return 1;
    }

    private final int find(Object arg5, int arg6) {
        int v2;
        int v0 = this.size - 1;
        int v1 = 0;
        while(true) {
            if(v1 > v0) {
                goto label_24;
            }

            v2 = v1 + v0 >>> 1;
            int v3 = this.hashes[v2];
            if(v3 < arg6) {
                v1 = v2 + 1;
                continue;
            }

            if(v3 <= arg6) {
                break;
            }

            v0 = v2 - 1;
        }

        WeakReference v0_1 = this.values[v2];
        Object v0_2 = v0_1 != null ? v0_1.get() : null;
        if(arg5 == v0_2) {
            return v2;
        }

        return this.findExactIndex(v2, arg5, arg6);
    label_24:
        return -(v1 + 1);
    }

    private final int findExactIndex(int arg4, Object arg5, int arg6) {
        WeakReference v2;
        Object v1;
        int v0 = arg4 - 1;
        while(true) {
            v1 = null;
            if(-1 < v0) {
                if(this.hashes[v0] != arg6) {
                }
                else {
                    v2 = this.values[v0];
                    if(v2 != null) {
                        v1 = v2.get();
                    }

                    if(v1 == arg5) {
                        return v0;
                    }

                    --v0;
                    continue;
                }
            }

            break;
        }

        ++arg4;
        v0 = this.size;
        while(arg4 < v0) {
            if(this.hashes[arg4] != arg6) {
                return -(arg4 + 1);
            }

            v2 = this.values[arg4];
            Object v2_1 = v2 != null ? v2.get() : v1;
            if(v2_1 == arg5) {
                return arg4;
            }

            ++arg4;
        }

        return -(this.size + 1);
    }

    public final int[] getHashes$runtime() {
        return this.hashes;
    }

    public final int getSize$runtime() {
        return this.size;
    }

    public final WeakReference[] getValues$runtime() {
        return this.values;
    }

    public final boolean isValid$runtime() {
        int v0 = this.size;
        WeakReference[] v1 = this.values;
        int[] v7 = this.hashes;
        int v2 = v1.length;
        if(v0 > v2) {
            return 0;
        }

        int v4 = 0x80000000;
        int v5 = 0;
        while(v5 < v0) {
            int v6 = v7[v5];
            if(v6 < v4) {
                return 0;
            }
            else {
                WeakReference v4_1 = v1[v5];
                if(v4_1 == null) {
                    return 0;
                }
                else {
                    Object v4_2 = v4_1.get();
                    if(v4_2 != null && v6 != System_jvmKt.identityHashCode(v4_2)) {
                        return 0;
                    }

                    ++v5;
                    v4 = v6;
                    continue;
                }
            }

            break;
        }

        while(v0 < v2) {
            if(v7[v0] != 0) {
                return 0;
            }

            if(v1[v0] != null) {
                return 0;
            }

            ++v0;
        }

        return 1;
    }

    public final void removeIf(Function1 arg7) {
        Object v4;
        int v0 = this.getSize$runtime();
        int v2 = 0;
        int v3 = 0;
        while(true) {
            v4 = null;
            if(v2 >= v0) {
                break;
            }

            WeakReference v5 = this.getValues$runtime()[v2];
            if(v5 != null) {
                v4 = v5.get();
            }

            if(v4 != null && !arg7.invoke(v4).booleanValue()) {
                if(v3 != v2) {
                    this.getValues$runtime()[v3] = v5;
                    this.getHashes$runtime()[v3] = this.getHashes$runtime()[v2];
                }

                ++v3;
            }

            ++v2;
        }

        int v7;
        for(v7 = v3; v7 < v0; ++v7) {
            this.getValues$runtime()[v7] = ((WeakReference)v4);
            this.getHashes$runtime()[v7] = 0;
        }

        if(v3 != v0) {
            this.setSize$runtime(v3);
        }
    }

    public final void setHashes$runtime(int[] arg1) {
        this.hashes = arg1;
    }

    public final void setSize$runtime(int arg1) {
        this.size = arg1;
    }

    public final void setValues$runtime(WeakReference[] arg1) {
        this.values = arg1;
    }
}

