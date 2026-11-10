package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0001\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0010\u0010\u0004\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0010\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012 \b\u0002\u0010\b\u001A\u001A\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\t\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000BJ\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001A\u001A\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\t\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchDisplayTokenResolver;", "", "api", "", "surface", "Lkotlin/Function0;", "Ljava/lang/Class;", "control", "composer", "Lkotlin/Pair;", "<init>", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "resolve", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchDisplayToken;", "physicalId", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchDisplayTokenResolver {
    public static final int $stable;
    private final int api;
    private final Function0 composer;
    private final Function0 control;
    private final Function0 surface;

    static {
    }

    public StretchDisplayTokenResolver(int arg2, Function0 arg3, Function0 arg4, Function0 arg5) {
        Intrinsics.checkNotNullParameter(arg3, "surface");
        Intrinsics.checkNotNullParameter(arg4, "control");
        super();
        this.api = arg2;
        this.surface = arg3;
        this.control = arg4;
        this.composer = arg5;
    }

    public StretchDisplayTokenResolver(int arg1, Function0 arg2, Function0 arg3, Function0 arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 8) != 0) {
            arg4 = null;
        }

        this(arg1, arg2, arg3, arg4);
    }

    public final StretchDisplayToken resolve(long arg11) {
        Object v10_2;
        Object v2_1;
        String v2 = "SURFACE_CONTROL";
        List v0 = this.api >= 34 ? CollectionsKt.listOf(new Pair[]{TuplesKt.to("DISPLAY_CONTROL", this.control), TuplesKt.to(v2, this.surface)}) : CollectionsKt.listOf(TuplesKt.to(v2, this.surface));
        ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10));
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            v2_1 = v0_1.next();
            ((Collection)v1).add(TuplesKt.to(((Pair)v2_1).component1(), new StretchDisplayTokenResolver$$ExternalSyntheticLambda0(((Pair)v2_1).component2())));
        }

        Function0 v10 = this.composer;
        Object v0_2 = null;
        if(v10 != null) {
            Pair v10_1 = TuplesKt.to("SURFACE_COMPOSER_AIDL", v10);
        }
        else {
            v10_2 = v0_2;
        }

        Iterator v10_3 = CollectionsKt.plus(((Collection)v1), CollectionsKt.listOfNotNull(v10_2)).iterator();
        Throwable v1_1 = ((Throwable)v0_2);
        while(v10_3.hasNext()) {
            Object v1_2 = v10_3.next();
            v2_1 = ((Pair)v1_2).component1();
            v1_2 = ((Pair)v1_2).component2();
            try {
                v1_2 = ((Function0)v1_2).invoke();
                Object v5 = ((Pair)v1_2).component1();
                v1_2 = ((Pair)v1_2).component2();
                Method v6 = ((Class)v5).getMethod("getPhysicalDisplayIds");
                if(StretchDisplayTokenResolver.resolve$present(v6, v1_2, arg11)) {
                    v5 = ((Class)v5).getMethod("getPhysicalDisplayToken", Long.TYPE).invoke(v1_2, Long.valueOf(arg11));
                    if((v5 instanceof IBinder)) {
                    }
                    else {
                        v5 = v0_2;
                    }

                    if(v5 != null && (((IBinder)v5).isBinderAlive()) && (StretchDisplayTokenResolver.resolve$present(v6, v1_2, arg11))) {
                        if(v5 != null) {
                            return new StretchDisplayToken(((IBinder)v5), ((String)v2_1));
                        }
                        else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }

                    throw new IllegalStateException("Physical token unavailable".toString());
                }

                throw new IllegalStateException("Physical ID absent".toString());
            }
            catch(LinkageError v1_3) {
                continue;
            }
            catch(Exception v1_4) {
                continue;
            }
        }

        throw new StretchCompatibilityFailure("DISPLAY_TOKEN_UNAVAILABLE", ((Throwable)v1_3));
    }

    static final Pair resolve$lambda$1$lambda$0(Function0 arg1) {
        return TuplesKt.to(arg1.invoke(), null);
    }

    private static final boolean resolve$present(Method arg2, Object arg3, long arg4) {
        Object v2 = arg2.invoke(arg3);
        if((v2 instanceof long[])) {
        }
        else {
            v2 = null;
        }

        if(v2 != null && (ArraysKt.contains(((long[])v2), arg4))) {
            return 1;
        }

        return 0;
    }
}

