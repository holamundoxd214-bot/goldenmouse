package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010*\n\u0002\b\t\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B7\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000E\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u0010\u001A\u00020\tH\u0002J\u001B\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013JC\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000E\u0010\u0015\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000E\u0010\u0016\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u0017J?\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0010\u0004\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u0019\u001A\u00020\t2\u000E\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u001AJ#\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001CJ5\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001E\u001A\u00020\t2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\u001FJG\u0010 \u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\t2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00062\u0006\u0010!\u001A\u00020\"H\u0002¢\u0006\u0002\u0010#J\u0016\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u001B\u001A\u00020\tH\u0016J;\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\tH\u0002¢\u0006\u0002\u0010&J3\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\tH\u0002¢\u0006\u0002\u0010(J?\u0010)\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010*\u001A\u00020\"H\u0002¢\u0006\u0002\u0010+J=\u0010,\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010*\u001A\u00020\"H\u0002¢\u0006\u0002\u0010+J\"\u0010-\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002000/H\u0016J\u000E\u00101\u001A\b\u0012\u0004\u0012\u00028\u000002H\u0016J\u0016\u00103\u001A\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001B\u001A\u00020\tH\u0016J\u001D\u00105\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001B\u001A\u00020\tH\u0002¢\u0006\u0002\u00106J\u0016\u00107\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\tH\u0096\u0002¢\u0006\u0002\u00108J#\u00109\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001CJ?\u0010:\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\t2\b\u0010;\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010<R\u0018\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\n\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "root", "", "", "tail", "size", "", "rootShift", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "getSize", "()I", "rootSize", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "pushTail", "shift", "([Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "insertIntoTail", "tailIndex", "([Ljava/lang/Object;ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "insertIntoRoot", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "removeAt", "removeFromTailAt", "([Ljava/lang/Object;III)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "pullLastBuffer", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "removeFromRootAt", "removeAll", "predicate", "Lkotlin/Function1;", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "listIterator", "", "bufferFor", "(I)[Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "set", "setInRoot", "e", "([Ljava/lang/Object;IILjava/lang/Object;)[Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentVector extends AbstractPersistentList implements PersistentList {
    public static final int $stable = 8;
    private final Object[] root;
    private final int rootShift;
    private final int size;
    private final Object[] tail;

    static {
    }

    public PersistentVector(Object[] arg3, Object[] arg4, int arg5, int arg6) {
        super();
        this.root = arg3;
        this.tail = arg4;
        this.size = arg5;
        this.rootShift = arg6;
        boolean v5 = true;
        int v0 = 0x20;
        int v3 = this.size() > v0 ? 1 : 0;
        if(v3 == 0) {
            PreconditionsKt.throwIllegalArgumentException("Trie-based persistent vector should have at least 33 elements, got " + this.size());
        }

        if(this.size() - UtilsKt.rootSize(this.size()) <= RangesKt.coerceAtMost(arg4.length, v0)) {
        }
        else {
            v5 = false;
        }

        CommonFunctionsKt.assert(v5);
    }

    public PersistentCollection add(Object arg1) {
        return this.add(arg1);
    }

    public PersistentList add(Object arg4) {
        int v0 = this.size() - this.rootSize();
        int v1 = 0x20;
        if(v0 < v1) {
            Object[] v1_1 = Arrays.copyOf(this.tail, v1);
            Intrinsics.checkNotNullExpressionValue(v1_1, "copyOf(...)");
            v1_1[v0] = arg4;
            return new PersistentVector(this.root, v1_1, this.size() + 1, this.rootShift);
        }

        return this.pushFilledTail(this.root, this.tail, UtilsKt.presizedBufferWith(arg4));
    }

    public PersistentList add(int arg7, Object arg8) {
        ListImplementation.checkPositionIndex$runtime(arg7, this.size());
        if(arg7 == this.size()) {
            return this.add(arg8);
        }

        int v0 = this.rootSize();
        if(arg7 >= v0) {
            return this.insertIntoTail(this.root, arg7 - v0, arg8);
        }

        ObjectRef v5 = new ObjectRef(null);
        return this.insertIntoTail(this.insertIntoRoot(this.root, this.rootShift, arg7, arg8, v5), 0, v5.getValue());
    }

    private final Object[] bufferFor(int arg3) {
        if(this.rootSize() <= arg3) {
            return this.tail;
        }

        Object[] v0 = this.root;
        int v2;
        for(v2 = this.rootShift; v2 > 0; v2 += -5) {
            Object v0_1 = v0[UtilsKt.indexSegment(arg3, v2)];
            Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }

        return v0;
    }

    public Builder builder() {
        return this.builder();
    }

    public PersistentVectorBuilder builder() {
        return new PersistentVectorBuilder(this, this.root, this.tail, this.rootShift);
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder builder() {
        return this.builder();
    }

    public Object get(int arg2) {
        ListImplementation.checkElementIndex$runtime(arg2, this.size());
        return this.bufferFor(arg2)[arg2 & 0x1F];
    }

    public int getSize() {
        return this.size;
    }

    private final Object[] insertIntoRoot(Object[] arg11, int arg12, int arg13, Object arg14, ObjectRef arg15) {
        Object[] v10;
        int v0 = UtilsKt.indexSegment(arg13, arg12);
        String v1 = "copyOf(...)";
        int v2 = 0x20;
        if(arg12 == 0) {
            if(v0 == 0) {
                v10 = new Object[v2];
            }
            else {
                v10 = Arrays.copyOf(arg11, v2);
                Intrinsics.checkNotNullExpressionValue(v10, v1);
            }

            ArraysKt.copyInto(arg11, v10, v0 + 1, v0, 0x1F);
            arg15.setValue(arg11[0x1F]);
            v10[v0] = arg14;
            return v10;
        }

        Object[] v3 = Arrays.copyOf(arg11, v2);
        Intrinsics.checkNotNullExpressionValue(v3, v1);
        int v6 = arg12 - 5;
        Object v12 = arg11[v0];
        v1 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        Intrinsics.checkNotNull(v12, v1);
        PersistentVector v4 = this;
        ObjectRef v9 = arg15;
        v3[v0] = v4.insertIntoRoot(v12, v6, arg13, arg14, v9);
        while(true) {
            ++v0;
            if(v0 < v2 && v3[v0] != null) {
                Object v10_1 = arg11[v0];
                Intrinsics.checkNotNull(v10_1, v1);
                v3[v0] = v4.insertIntoRoot(v10_1, v6, 0, v9.getValue(), v9);
                continue;
            }

            return v3;
        }

        return v3;
    }

    private final PersistentVector insertIntoTail(Object[] arg6, int arg7, Object arg8) {
        int v0 = this.size() - this.rootSize();
        Object[] v1 = Arrays.copyOf(this.tail, 0x20);
        Intrinsics.checkNotNullExpressionValue(v1, "copyOf(...)");
        Object[] v3 = this.tail;
        if(v0 < 0x20) {
            ArraysKt.copyInto(v3, v1, arg7 + 1, arg7, v0);
            v1[arg7] = arg8;
            return new PersistentVector(arg6, v1, this.size() + 1, this.rootShift);
        }

        Object v2 = v3[0x1F];
        ArraysKt.copyInto(v3, v1, arg7 + 1, arg7, v0 - 1);
        v1[arg7] = arg8;
        return this.pushFilledTail(arg6, v1, UtilsKt.presizedBufferWith(v2));
    }

    public ListIterator listIterator(int arg8) {
        ListImplementation.checkPositionIndex$runtime(arg8, this.size());
        return new PersistentVectorIterator(this.root, this.tail, arg8, this.size(), this.rootShift / 5 + 1);
    }

    private final Object[] pullLastBuffer(Object[] arg6, int arg7, int arg8, ObjectRef arg9) {
        Object[] v5;
        int v0 = UtilsKt.indexSegment(arg8, arg7);
        Object[] v1 = null;
        int v2 = 5;
        if(arg7 == v2) {
            arg9.setValue(arg6[v0]);
            v5 = v1;
        }
        else {
            Object v3 = arg6[v0];
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            v5 = this.pullLastBuffer(((Object[])v3), arg7 - v2, arg8, arg9);
        }

        if(v5 == null && v0 == 0) {
            return v1;
        }

        arg6 = Arrays.copyOf(arg6, 0x20);
        Intrinsics.checkNotNullExpressionValue(arg6, "copyOf(...)");
        arg6[v0] = v5;
        return arg6;
    }

    private final PersistentList pullLastBufferFromRoot(Object[] arg3, int arg4, int arg5) {
        if(arg5 == 0) {
            if(arg3.length == 33) {
                arg3 = Arrays.copyOf(arg3, 0x20);
                Intrinsics.checkNotNullExpressionValue(arg3, "copyOf(...)");
            }

            return new SmallPersistentVector(arg3);
        }

        ObjectRef v0 = new ObjectRef(null);
        Object[] v2 = this.pullLastBuffer(arg3, arg5, arg4 - 1, v0);
        Intrinsics.checkNotNull(v2);
        Object v3 = v0.getValue();
        String v0_1 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        Intrinsics.checkNotNull(v3, v0_1);
        if(v2[1] == null) {
            Object v2_1 = v2[0];
            Intrinsics.checkNotNull(v2_1, v0_1);
            return new PersistentVector(((Object[])v2_1), ((Object[])v3), arg4, arg5 - 5);
        }

        return new PersistentVector(v2, ((Object[])v3), arg4, arg5);
    }

    private final PersistentVector pushFilledTail(Object[] arg5, Object[] arg6, Object[] arg7) {
        int v0 = this.size() >> 5;
        int v1 = this.rootShift;
        if(v0 > 1 << v1) {
            arg5 = UtilsKt.presizedBufferWith(arg5);
            v0 = this.rootShift + 5;
            return new PersistentVector(this.pushTail(arg5, v0, arg6), arg7, this.size() + 1, v0);
        }

        return new PersistentVector(this.pushTail(arg5, v1, arg6), arg7, this.size() + 1, this.rootShift);
    }

    private final Object[] pushTail(Object[] arg4, int arg5, Object[] arg6) {
        int v0 = UtilsKt.indexSegment(this.size() - 1, arg5);
        int v1 = 0x20;
        if(arg4 != null) {
            arg4 = Arrays.copyOf(arg4, v1);
            Intrinsics.checkNotNullExpressionValue(arg4, "copyOf(...)");
            if(arg4 == null) {
                goto label_9;
            }
        }
        else {
        label_9:
            arg4 = new Object[v1];
        }

        v1 = 5;
        if(arg5 == v1) {
            arg4[v0] = arg6;
            return arg4;
        }

        arg4[v0] = this.pushTail(arg4[v0], arg5 - v1, arg6);
        return arg4;
    }

    public PersistentCollection removeAll(Function1 arg1) {
        return this.removeAll(arg1);
    }

    public PersistentList removeAll(Function1 arg1) {
        PersistentVectorBuilder v0 = this.builder();
        v0.removeAllWithPredicate(arg1);
        return v0.build();
    }

    public PersistentList removeAt(int arg7) {
        ListImplementation.checkElementIndex$runtime(arg7, this.size());
        int v0 = this.rootSize();
        Object[] v1 = this.root;
        if(arg7 >= v0) {
            return this.removeFromTailAt(v1, v0, this.rootShift, arg7 - v0);
        }

        return this.removeFromTailAt(this.removeFromRootAt(v1, this.rootShift, arg7, new ObjectRef(this.tail[0])), v0, this.rootShift, 0);
    }

    private final Object[] removeFromRootAt(Object[] arg7, int arg8, int arg9, ObjectRef arg10) {
        Object[] v6;
        int v0 = UtilsKt.indexSegment(arg9, arg8);
        String v1 = "copyOf(...)";
        int v2 = 0x1F;
        int v3 = 0x20;
        if(arg8 == 0) {
            if(v0 == 0) {
                v6 = new Object[v3];
            }
            else {
                v6 = Arrays.copyOf(arg7, v3);
                Intrinsics.checkNotNullExpressionValue(v6, v1);
            }

            ArraysKt.copyInto(arg7, v6, v0, v0 + 1, v3);
            v6[v2] = arg10.getValue();
            arg10.setValue(arg7[v0]);
            return v6;
        }

        if(arg7[v2] == null) {
            v2 = UtilsKt.indexSegment(this.rootSize() - 1, arg8);
        }

        arg7 = Arrays.copyOf(arg7, v3);
        Intrinsics.checkNotNullExpressionValue(arg7, v1);
        arg8 += -5;
        int v1_1 = v0 + 1;
        String v3_1 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        if(v1_1 <= v2) {
            while(true) {
                Object v4 = arg7[v2];
                Intrinsics.checkNotNull(v4, v3_1);
                arg7[v2] = this.removeFromRootAt(((Object[])v4), arg8, 0, arg10);
                if(v2 != v1_1) {
                    --v2;
                    continue;
                }

                break;
            }
        }

        Object v1_2 = arg7[v0];
        Intrinsics.checkNotNull(v1_2, v3_1);
        arg7[v0] = this.removeFromRootAt(((Object[])v1_2), arg8, arg9, arg10);
        return arg7;
    }

    private final PersistentList removeFromTailAt(Object[] arg6, int arg7, int arg8, int arg9) {
        int v0 = this.size() - arg7;
        boolean v2 = arg9 < v0 ? true : false;
        CommonFunctionsKt.assert(v2);
        if(v0 == 1) {
            return this.pullLastBufferFromRoot(arg6, arg7, arg8);
        }

        Object[] v2_1 = Arrays.copyOf(this.tail, 0x20);
        Intrinsics.checkNotNullExpressionValue(v2_1, "copyOf(...)");
        int v3 = v0 - 1;
        if(arg9 < v3) {
            ArraysKt.copyInto(this.tail, v2_1, arg9, arg9 + 1, v0);
        }

        v2_1[v3] = null;
        return new PersistentVector(arg6, v2_1, arg7 + v0 - 1, arg8);
    }

    private final int rootSize() {
        return UtilsKt.rootSize(this.size());
    }

    public PersistentList set(int arg3, Object arg4) {
        ListImplementation.checkElementIndex$runtime(arg3, this.size());
        if(this.rootSize() <= arg3) {
            Object[] v0 = Arrays.copyOf(this.tail, 0x20);
            Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
            v0[arg3 & 0x1F] = arg4;
            return new PersistentVector(this.root, v0, this.size(), this.rootShift);
        }

        return new PersistentVector(this.setInRoot(this.root, this.rootShift, arg3, arg4), this.tail, this.size(), this.rootShift);
    }

    private final Object[] setInRoot(Object[] arg4, int arg5, int arg6, Object arg7) {
        int v0 = UtilsKt.indexSegment(arg6, arg5);
        arg4 = Arrays.copyOf(arg4, 0x20);
        Intrinsics.checkNotNullExpressionValue(arg4, "copyOf(...)");
        if(arg5 == 0) {
            arg4[v0] = arg7;
            return arg4;
        }

        Object v1 = arg4[v0];
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        arg4[v0] = this.setInRoot(((Object[])v1), arg5 - 5, arg6, arg7);
        return arg4;
    }
}

