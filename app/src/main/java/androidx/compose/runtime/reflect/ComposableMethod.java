package androidx.compose.runtime.reflect;

import androidx.compose.runtime.Composer;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001A\u00020\u0003J:\u0010\u0016\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u00012\u0016\u0010\u001A\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000E\"\u0004\u0018\u00010\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001BJ\u0013\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001F\u001A\u00020\nH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0017\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u001B\u0010\u0012\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u000E8F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2={"Landroidx/compose/runtime/reflect/ComposableMethod;", "", "method", "Ljava/lang/reflect/Method;", "composableInfo", "Landroidx/compose/runtime/reflect/ComposableInfo;", "<init>", "(Ljava/lang/reflect/Method;Landroidx/compose/runtime/reflect/ComposableInfo;)V", "asMethod", "parameterCount", "", "getParameterCount", "()I", "parameters", "", "Ljava/lang/reflect/Parameter;", "getParameters", "()[Ljava/lang/reflect/Parameter;", "parameterTypes", "Ljava/lang/Class;", "getParameterTypes", "()[Ljava/lang/Class;", "invoke", "composer", "Landroidx/compose/runtime/Composer;", "instance", "args", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComposableMethod {
    public static final int $stable = 8;
    private final ComposableInfo composableInfo;
    private final Method method;

    static {
    }

    public ComposableMethod(Method arg1, ComposableInfo arg2) {
        super();
        this.method = arg1;
        this.composableInfo = arg2;
    }

    public final Method asMethod() {
        return this.method;
    }

    public boolean equals(Object arg2) {
        if((arg2 instanceof ComposableMethod)) {
            return Intrinsics.areEqual(this.method, ((ComposableMethod)arg2).method);
        }

        return 0;
    }

    public final int getParameterCount() {
        return this.composableInfo.getRealParamsCount();
    }

    public final Class[] getParameterTypes() {
        return ArraysKt.copyOfRange(this.method.getParameterTypes(), 0, this.composableInfo.getRealParamsCount());
    }

    public final Parameter[] getParameters() {
        return ArraysKt.copyOfRange(this.method.getParameters(), 0, this.composableInfo.getRealParamsCount());
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public final Object invoke(Composer arg17, Object arg18, Object[] arg19) {
        Object v10_1;
        Integer v10_3;
        Composer v10_2;
        int v13;
        ComposableMethod v0 = this;
        Object[] v1 = arg19;
        ComposableInfo v2 = v0.composableInfo;
        int v3 = v2.component2();
        int v4 = v2.component3();
        int v2_1 = v2.component4();
        int v5 = v0.method.getParameterTypes().length;
        int v6 = v3 + 1;
        v4 += v6;
        Integer[] v7 = new Integer[v2_1];
        int v8 = 0;
        Integer v9 = Integer.valueOf(0);
        int v10;
        for(v10 = 0; v10 < v2_1; ++v10) {
            int v11 = v10 * 0x1F;
            IntRange v11_1 = RangesKt.until(v11, Math.min(v11 + 0x1F, v3));
            ArrayList v12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v11_1), 10));
            Iterator v11_2 = ((Iterable)v11_1).iterator();
            while(v11_2.hasNext()) {
                v13 = v11_2.nextInt();
                v13 = v13 >= v1.length || v1[v13] == null ? 1 : 0;
                ((Collection)v12).add(Integer.valueOf(v13));
            }

            v11_2 = ((Iterable)v12).iterator();
            int v12_1 = 0;
            for(v13 = 0; v11_2.hasNext(); v13 = v15) {
                Object v14 = v11_2.next();
                int v15 = v13 + 1;
                if(v13 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }

                v12_1 |= ((Number)v14).intValue() << v13;
            }

            v7[v10] = Integer.valueOf(v12_1);
        }

        Object[] v2_2 = new Object[v5];
        while(true) {
            if(v8 >= v5) {
                goto label_94;
            }

            if(v8 < 0 || v8 >= v3) {
                if(v8 == v3) {
                    v10_2 = arg17;
                    goto label_86;
                }

                if(v8 == v6 || v3 + 2 <= v8 && v8 < v4) {
                    v10_3 = v9;
                    goto label_86;
                }

                if(v4 <= v8 && v8 < v5) {
                    v10_3 = v7[v8 - v4];
                    goto label_86;
                }

                break;
            }
            else {
                if(v8 >= 0 && v8 < v1.length) {
                    v10_1 = v1[v8];
                    goto label_86;
                }

                v10_1 = ComposableMethodKt.access$getDefaultValue(v0.method.getParameterTypes()[v8]);
            }

        label_86:
            v2_2[v8] = v10_2;
            ++v8;
        }

        throw new IllegalStateException("Unexpected index".toString());
    label_94:
        return v0.method.invoke(arg18, Arrays.copyOf(v2_2, v5));
    }
}

