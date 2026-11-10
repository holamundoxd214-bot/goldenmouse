package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A!\u0010\u0007\u001A\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00042\u0006\u0010\t\u001A\u0002H\bH\u0000¢\u0006\u0002\u0010\n\u001A2\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f\"\b\b\u0000\u0010\b*\u00020\u00042\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\b0\u000EH\u0002\u001A.\u0010\u000F\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001A\u0018\u0010\u0011\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000E2\u0006\u0010\u0012\u001A\u00020\u0001H\u0002\u001A\u001B\u0010\u0013\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000E2\b\b\u0002\u0010\u0014\u001A\u00020\u0001H\u0082\u0010\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0002\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¨\u0006\u0015"}, d2={"throwableFields", "", "Ctor", "Lkotlin/Function1;", "", "ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "createConstructor", "Lkotlinx/coroutines/internal/Ctor;", "clz", "Ljava/lang/Class;", "safeCtor", "block", "fieldsCountOrDefault", "defaultValue", "fieldsCount", "accumulator", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields;

    static {
        WeakMapCtorCache v0;
        ExceptionsConstructorKt.throwableFields = ExceptionsConstructorKt.fieldsCountOrDefault(Throwable.class, -1);
        try {
            if(FastServiceLoaderKt.getANDROID_DETECTED()) {
                v0 = WeakMapCtorCache.INSTANCE;
                goto label_11;
            }

            ClassValueCtorCache v0_1 = ClassValueCtorCache.INSTANCE;
        }
        catch(Throwable ) {
            v0 = WeakMapCtorCache.INSTANCE;
        }

    label_11:
        ExceptionsConstructorKt.ctorCache = ((CtorCache)v0);
    }

    public static final Function1 access$createConstructor(Class arg0) {
        return ExceptionsConstructorKt.createConstructor(arg0);
    }

    private static final Function1 createConstructor(Class arg12) {
        Pair v5_1;
        Object v5;
        ExceptionsConstructorKt$createConstructor$nullResult$1 v0 = ExceptionsConstructorKt$createConstructor$nullResult$1.INSTANCE;
        if(ExceptionsConstructorKt.throwableFields != ExceptionsConstructorKt.fieldsCountOrDefault(arg12, 0)) {
        }
        else {
            Constructor[] v12 = arg12.getConstructors();
            ArrayList v1 = new ArrayList(v12.length);
            int v3 = v12.length;
            int v4;
            for(v4 = 0; true; ++v4) {
                v5 = null;
                if(v4 >= v3) {
                    break;
                }

                Constructor v6 = v12[v4];
                Class[] v7 = v6.getParameterTypes();
                int v8 = v7.length;
                if(v8 != 0) {
                    int v9 = 2;
                    int v10 = -1;
                    if(v8 == 1) {
                        Class v7_1 = v7[0];
                        if(Intrinsics.areEqual(v7_1, String.class)) {
                            v5_1 = TuplesKt.to(ExceptionsConstructorKt.safeCtor(new ExceptionsConstructorKt$$ExternalSyntheticLambda2(v6)), Integer.valueOf(v9));
                            goto label_71;
                        }

                        if(Intrinsics.areEqual(v7_1, Throwable.class)) {
                            v5_1 = TuplesKt.to(ExceptionsConstructorKt.safeCtor(new ExceptionsConstructorKt$$ExternalSyntheticLambda3(v6)), Integer.valueOf(1));
                            goto label_71;
                        }

                        v5_1 = TuplesKt.to(v5, Integer.valueOf(v10));
                    }
                    else if(v8 != v9) {
                        v5_1 = TuplesKt.to(v5, Integer.valueOf(v10));
                    }
                    else {
                        if((Intrinsics.areEqual(v7[0], String.class)) && (Intrinsics.areEqual(v7[1], Throwable.class))) {
                            v5_1 = TuplesKt.to(ExceptionsConstructorKt.safeCtor(new ExceptionsConstructorKt$$ExternalSyntheticLambda1(v6)), Integer.valueOf(3));
                            goto label_71;
                        }

                        v5_1 = TuplesKt.to(v5, Integer.valueOf(v10));
                    }
                }
                else {
                    v5_1 = TuplesKt.to(ExceptionsConstructorKt.safeCtor(new ExceptionsConstructorKt$$ExternalSyntheticLambda4(v6)), Integer.valueOf(0));
                }

            label_71:
                ((Collection)v1).add(v5_1);
            }

            Iterator v12_1 = ((Iterable)v1).iterator();
            if(!v12_1.hasNext()) {
            }
            else {
                v5 = v12_1.next();
                if(!v12_1.hasNext()) {
                }
                else {
                    int v1_1 = v5.getSecond().intValue();
                    do {
                        Object v2 = v12_1.next();
                        v3 = v2.getSecond().intValue();
                        if(v1_1 < v3) {
                            v5 = v2;
                            v1_1 = v3;
                        }

                        if(v12_1.hasNext()) {
                            continue;
                        }

                        break;
                    }
                    while(true);
                }
            }

            if(v5 == null) {
                goto label_98;
            }

            Object v12_2 = ((Pair)v5).getFirst();
            if(v12_2 == null) {
                goto label_98;
            }

            return ((Function1)v12_2);
        }

    label_98:
        return ((Function1)v0);
    }

    static final Throwable createConstructor$lambda$7$lambda$1(Constructor arg1, Throwable arg2) {
        Object v1 = arg1.newInstance(arg2.getMessage(), arg2);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Throwable");
        return ((Throwable)v1);
    }

    static final Throwable createConstructor$lambda$7$lambda$3(Constructor arg1, Throwable arg2) {
        Object v1 = arg1.newInstance(arg2.getMessage());
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Throwable");
        ((Throwable)v1).initCause(arg2);
        return ((Throwable)v1);
    }

    static final Throwable createConstructor$lambda$7$lambda$4(Constructor arg0, Throwable arg1) {
        Object v0 = arg0.newInstance(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Throwable");
        return ((Throwable)v0);
    }

    static final Throwable createConstructor$lambda$7$lambda$6(Constructor arg1, Throwable arg2) {
        Object v1 = arg1.newInstance();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Throwable");
        ((Throwable)v1).initCause(arg2);
        return ((Throwable)v1);
    }

    private static final int fieldsCount(Class arg5, int arg6) {
        do {
            Field[] v0 = arg5.getDeclaredFields();
            int v1 = v0.length;
            int v2 = 0;
            int v3 = 0;
            while(v2 < v1) {
                if(!Modifier.isStatic(v0[v2].getModifiers())) {
                    ++v3;
                }

                ++v2;
            }

            arg6 += v3;
            arg5 = arg5.getSuperclass();
        }
        while(arg5 != null);

        return arg6;
    }

    static int fieldsCount$default(Class arg0, int arg1, int arg2, Object arg3) {
        return ExceptionsConstructorKt.fieldsCount(arg0, 0);
    }

    private static final int fieldsCountOrDefault(Class arg3, int arg4) {
        Integer v3_2;
        Object v3_1;
        JvmClassMappingKt.getKotlinClass(arg3);
        try {
            v3_1 = Result.constructor-impl(Integer.valueOf(ExceptionsConstructorKt.fieldsCount$default(arg3, 0, 1, null)));
        }
        catch(Throwable v3) {
            v3_1 = Result.constructor-impl(ResultKt.createFailure(v3));
        }

        Integer v4 = Integer.valueOf(arg4);
        if(Result.isFailure-impl(v3_1)) {
            v3_2 = v4;
        }

        return ((Number)v3_2).intValue();
    }

    private static final Function1 safeCtor(Function1 arg1) {
        return new ExceptionsConstructorKt$$ExternalSyntheticLambda0(arg1);
    }

    static final Throwable safeCtor$lambda$9(Function1 arg3, Throwable arg4) {
        Object v3_1;
        Throwable v0 = null;
        try {
            v3_1 = arg3.invoke(arg4);
            if(!Intrinsics.areEqual(arg4.getMessage(), ((Throwable)v3_1).getMessage()) && !Intrinsics.areEqual(((Throwable)v3_1).getMessage(), arg4.toString())) {
                v3_1 = v0;
            }

            v3_1 = Result.constructor-impl(v3_1);
        }
        catch(Throwable v3) {
            v3_1 = Result.constructor-impl(ResultKt.createFailure(v3));
        }

        if(Result.isFailure-impl(v3_1)) {
        }
        else {
            Object v0_1 = v3_1;
        }

        return v0;
    }

    public static final Throwable tryCopyException(Throwable arg2) {
        Object v2;
        if((arg2 instanceof CopyableThrowable)) {
            try {
                v2 = Result.constructor-impl(((CopyableThrowable)arg2).createCopy());
            }
            catch(Throwable arg2) {
                v2 = Result.constructor-impl(ResultKt.createFailure(arg2));
            }

            if(Result.isFailure-impl(v2)) {
                arg2 = null;
            }

            return ((Throwable)v2);
        }

        return ExceptionsConstructorKt.ctorCache.get(arg2.getClass()).invoke(arg2);
    }
}

