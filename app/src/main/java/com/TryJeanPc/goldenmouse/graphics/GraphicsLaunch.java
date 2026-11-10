package com.TryJeanPc.goldenmouse.graphics;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.NonCancellable;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¤\u0001\u0010\u0004\u001A\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\t2\u001C\u0010\n\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000B2$\b\u0002\u0010\u000E\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000F2\u0014\b\u0002\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00070\u000B2\u001C\u0010\u0012\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000BH\u0086@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsLaunch;", "", "<init>", "()V", "run", "T", "enabled", "", "isCurrent", "Lkotlin/Function0;", "prepare", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "onOutcome", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsLaunchOutcome;", "accepted", "launch", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsLaunch {
    public static final int $stable;
    public static final GraphicsLaunch INSTANCE;

    static {
        GraphicsLaunch.INSTANCE = new GraphicsLaunch();
    }

    private GraphicsLaunch() {
        super();
    }

    public final Object run(boolean arg8, Function0 arg9, Function1 arg10, Function2 arg11, Function1 arg12, Function1 arg13, Continuation arg14) {
        GraphicsLaunch$run$4 v5;
        NonCancellable v4_2;
        GraphicsLaunchOutcome v4_1;
        boolean v6_3;
        Object v6_2;
        Function2 v6_1;
        Function1 v11;
        Function2 v12;
        Function1 v1_1;
        ObjectRef v9;
        Function0 v3_3;
        Exception v7_2;
        ObjectRef v10;
        Function1 v6;
        Throwable v8_1;
        boolean v7_3;
        GraphicsLaunch$run$4 v4;
        NonCancellable v3_2;
        GraphicsLaunch$run$1 v0_1;
        if((arg14 instanceof GraphicsLaunch$run$1)) {
            Continuation v0 = arg14;
            int v2 = 0x80000000;
            if((((GraphicsLaunch$run$1)v0).label & v2) != 0) {
                ((GraphicsLaunch$run$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new GraphicsLaunch$run$1(this, arg14);
        }

        Object v7 = v0_1.result;
        Object v14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object v2_1 = null;
        switch(v0_1.label) {
            case 0: {
                goto label_106;
            }
            case 2: {
                goto label_74;
            }
            case 1: 
            case 3: {
                goto label_64;
            }
            case 4: {
                goto label_45;
            }
            case 5: {
                goto label_33;
            }
            case 6: {
                goto label_22;
            }
        }

        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_33:
        Object v8 = v0_1.L$8;
        ResultKt.throwOnFailure(v7);
        return v8;
    label_22:
        v8 = v0_1.L$7;
        ResultKt.throwOnFailure(v7);
        goto label_342;
    label_106:
        ResultKt.throwOnFailure(v7);
        ObjectRef v7_1 = new ObjectRef();
        v7_1.element = GraphicsLaunchOutcome.CHANGED;
        ObjectRef v1 = new ObjectRef();
        try {
            if(arg9.invoke().booleanValue()) {
                goto label_141;
            }
        }
        catch(Exception v3) {
            goto label_296;
        }
        catch(Throwable v3_1) {
            goto label_284;
        }

        if(arg8) {
            v3_2 = NonCancellable.INSTANCE;
            v4 = new GraphicsLaunch$run$4(arg11, v7_1, v1, ((Continuation)v2_1));
            v0_1.L$0 = SpillingKt.nullOutSpilledVariable(arg9);
            v0_1.L$1 = SpillingKt.nullOutSpilledVariable(arg10);
            v0_1.L$2 = SpillingKt.nullOutSpilledVariable(arg11);
            v0_1.L$3 = SpillingKt.nullOutSpilledVariable(arg12);
            v0_1.L$4 = SpillingKt.nullOutSpilledVariable(arg13);
            v0_1.L$5 = SpillingKt.nullOutSpilledVariable(v7_1);
            v0_1.L$6 = SpillingKt.nullOutSpilledVariable(v1);
            v0_1.Z$0 = arg8;
            v0_1.label = 1;
            if(BuildersKt.withContext(((CoroutineContext)v3_2), ((Function2)v4), ((Continuation)v0_1)) == v14) {
                return v14;
            }
        }

        return v2_1;
    label_141:
        if(arg8) {
            try {
                v0_1.L$0 = arg9;
                v0_1.L$1 = SpillingKt.nullOutSpilledVariable(arg10);
                v0_1.L$2 = arg11;
                v0_1.L$3 = arg12;
                v0_1.L$4 = arg13;
                v0_1.L$5 = v7_1;
                v0_1.L$6 = v1;
                v0_1.Z$0 = arg8;
                v0_1.label = 2;
                if(arg10.invoke(v0_1) != v14) {
                    goto label_156;
                }
            }
            catch(Throwable v3_1) {
            label_284:
                v6 = arg10;
                v10 = v7_1;
                v7_3 = arg8;
                v8_1 = v3_1;
                v3_3 = arg9;
                v9 = v1;
                v1_1 = arg13;
                arg13 = arg12;
                v12 = arg11;
                v11 = v6;
                goto label_317;
            }
            catch(Exception v3) {
            label_296:
                v6 = arg10;
                v10 = v7_1;
                v7_2 = v3;
                v3_3 = arg9;
                v9 = v1;
                v1_1 = arg13;
                arg13 = arg12;
                v12 = arg11;
                v11 = v6;
                goto label_305;
            }

            return v14;
        }

    label_156:
        v6 = arg10;
        v10 = v7_1;
        Function1 v7_4 = v6;
        goto label_159;
    label_74:
        arg8 = v0_1.Z$0;
        Object v9_1 = v0_1.L$6;
        Object v10_1 = v0_1.L$5;
        Object v13 = v0_1.L$4;
        Object v12_1 = v0_1.L$3;
        Object v11_1 = v0_1.L$2;
        Object v1_2 = v0_1.L$1;
        Object v3_4 = v0_1.L$0;
        try {
            ResultKt.throwOnFailure(v7);
            v7 = v1_2;
            v1_2 = v9_1;
            v9_1 = v3_4;
        }
        catch(Exception v7_2) {
            goto label_100;
        }
        catch(Throwable v7_5) {
            goto label_90;
        }

        try {
        label_159:
            if(((Function0)v9_1).invoke().booleanValue()) {
                goto label_187;
            }
        }
        catch(Exception v3) {
            goto label_274;
        }
        catch(Throwable v3_1) {
            goto label_263;
        }

        if(arg8) {
            v3_2 = NonCancellable.INSTANCE;
            v4 = new GraphicsLaunch$run$4(((Function2)v11_1), ((ObjectRef)v10_1), v1, ((Continuation)v2_1));
            v0_1.L$0 = SpillingKt.nullOutSpilledVariable(v9_1);
            v0_1.L$1 = SpillingKt.nullOutSpilledVariable(v7);
            v0_1.L$2 = SpillingKt.nullOutSpilledVariable(v11_1);
            v0_1.L$3 = SpillingKt.nullOutSpilledVariable(v12_1);
            v0_1.L$4 = SpillingKt.nullOutSpilledVariable(v13);
            v0_1.L$5 = SpillingKt.nullOutSpilledVariable(v10_1);
            v0_1.L$6 = SpillingKt.nullOutSpilledVariable(v1);
            v0_1.Z$0 = arg8;
            v0_1.label = 3;
            if(BuildersKt.withContext(((CoroutineContext)v3_2), ((Function2)v4), ((Continuation)v0_1)) == v14) {
                return v14;
            }
        }

        return v2_1;
        try {
        label_187:
            v0_1.L$0 = SpillingKt.nullOutSpilledVariable(v9_1);
            v0_1.L$1 = SpillingKt.nullOutSpilledVariable(v7);
            v0_1.L$2 = v11_1;
            v0_1.L$3 = v12_1;
            v0_1.L$4 = SpillingKt.nullOutSpilledVariable(v13);
            v0_1.L$5 = v10_1;
            v0_1.L$6 = v1;
            v0_1.Z$0 = arg8;
            v0_1.label = 4;
            v3_4 = ((Function1)v13).invoke(v0_1);
            if(v3_4 != v14) {
                goto label_203;
            }
        }
        catch(Throwable v3_1) {
        label_263:
            v6_1 = ((Function2)v11_1);
            v11_1 = v7;
            v7_3 = arg8;
            v8_1 = v3_1;
            v3_3 = ((Function0)v9_1);
            v9_1 = v1;
            v1_1 = ((Function1)v13);
            arg13 = ((Function1)v12_1);
            v12 = v6_1;
            goto label_317;
        }
        catch(Exception v3) {
        label_274:
            v6_1 = ((Function2)v11_1);
            v11_1 = v7;
            v7_2 = v3;
            v3_3 = ((Function0)v9_1);
            v9_1 = v1;
            v1_1 = ((Function1)v13);
            arg13 = ((Function1)v12_1);
            v12 = v6_1;
            goto label_305;
        }

        return v14;
    label_203:
        v6_1 = ((Function2)v11_1);
        v11_1 = v7;
        v7 = v3_4;
        Function1 v3_5 = ((Function1)v13);
        arg13 = ((Function1)v12_1);
        v12 = v6_1;
        goto label_209;
    label_45:
        arg8 = v0_1.Z$0;
        v9_1 = v0_1.L$6;
        v10_1 = v0_1.L$5;
        v13 = v0_1.L$4;
        v12_1 = v0_1.L$3;
        v11_1 = v0_1.L$2;
        v1_2 = v0_1.L$1;
        v3_4 = v0_1.L$0;
        try {
            ResultKt.throwOnFailure(v7);
            v6_2 = v1_2;
            v1_2 = v9_1;
            v9_1 = v3_4;
            v3_4 = v13;
            v13 = v12_1;
            v12_1 = v11_1;
            v11_1 = v6_2;
        }
        catch(Throwable v7_5) {
        label_90:
            v6_3 = arg8;
            v8_1 = v7_5;
            v7_3 = v6_3;
            v6_2 = v12_1;
            v12_1 = v11_1;
            v11_1 = v1_2;
            v1_2 = v13;
            v13 = v6_2;
            goto label_317;
        }
        catch(Exception v7_2) {
        label_100:
            v6_2 = v12_1;
            v12_1 = v11_1;
            v11_1 = v1_2;
            v1_2 = v13;
            v13 = v6_2;
            goto label_305;
        }

    label_209:
        if(v7 == null) {
            try {
                v4_1 = GraphicsLaunchOutcome.NO_RESULT;
                goto label_218;
            label_212:
                v4_1 = !((Function1)v13).invoke(v7).booleanValue() ? GraphicsLaunchOutcome.REJECTED : GraphicsLaunchOutcome.REQUESTED;
            label_218:
                ((ObjectRef)v10_1).element = v4_1;
                if(!arg8) {
                    return v7;
                }

                goto label_220;
            }
            catch(Throwable v7_5) {
                v6_3 = arg8;
                v8_1 = v7_5;
                v7_3 = v6_3;
                v6_2 = v3_5;
                v3_3 = ((Function0)v9_1);
                v9_1 = v1;
                v1_2 = v6_2;
                goto label_317;
            }
            catch(Exception v7_2) {
                v6_2 = v3_5;
                v3_3 = ((Function0)v9_1);
                v9_1 = v1;
                v1_2 = v6_2;
                try {
                label_305:
                    ((ObjectRef)v9_1).element = v7_2;
                    v4_1 = (v7_2 instanceof CancellationException) ? GraphicsLaunchOutcome.CANCELLED : GraphicsLaunchOutcome.ERROR;
                    ((ObjectRef)v10_1).element = v4_1;
                    throw v7_2;
                }
                catch(Throwable v7_5) {
                    v6_3 = arg8;
                    v8_1 = v7_5;
                    v7_3 = v6_3;
                    goto label_317;
                }
            }
        }
        else {
            goto label_212;
        }

        goto label_218;
    label_317:
        if(v7_3) {
            v4_2 = NonCancellable.INSTANCE;
            v5 = new GraphicsLaunch$run$4(v12, ((ObjectRef)v10_1), ((ObjectRef)v9_1), ((Continuation)v2_1));
            v0_1.L$0 = SpillingKt.nullOutSpilledVariable(v3_3);
            v0_1.L$1 = SpillingKt.nullOutSpilledVariable(v11_1);
            v0_1.L$2 = SpillingKt.nullOutSpilledVariable(v12);
            v0_1.L$3 = SpillingKt.nullOutSpilledVariable(v13);
            v0_1.L$4 = SpillingKt.nullOutSpilledVariable(v1_1);
            v0_1.L$5 = SpillingKt.nullOutSpilledVariable(v10_1);
            v0_1.L$6 = SpillingKt.nullOutSpilledVariable(v9_1);
            v0_1.L$7 = v8_1;
            v0_1.Z$0 = v7_3;
            v0_1.label = 6;
            if(BuildersKt.withContext(((CoroutineContext)v4_2), ((Function2)v5), ((Continuation)v0_1)) != v14) {
                goto label_342;
            }

            return v14;
        }

    label_342:
        throw v8;
    label_220:
        v4_2 = NonCancellable.INSTANCE;
        v5 = new GraphicsLaunch$run$4(v12, ((ObjectRef)v10_1), v1, ((Continuation)v2_1));
        v0_1.L$0 = SpillingKt.nullOutSpilledVariable(v9_1);
        v0_1.L$1 = SpillingKt.nullOutSpilledVariable(v11_1);
        v0_1.L$2 = SpillingKt.nullOutSpilledVariable(v12);
        v0_1.L$3 = SpillingKt.nullOutSpilledVariable(v13);
        v0_1.L$4 = SpillingKt.nullOutSpilledVariable(v3_5);
        v0_1.L$5 = SpillingKt.nullOutSpilledVariable(v10_1);
        v0_1.L$6 = SpillingKt.nullOutSpilledVariable(v1);
        v0_1.L$7 = SpillingKt.nullOutSpilledVariable(v7);
        v0_1.L$8 = v7;
        v0_1.Z$0 = arg8;
        v0_1.label = 5;
        if(BuildersKt.withContext(((CoroutineContext)v4_2), ((Function2)v5), ((Continuation)v0_1)) == v14) {
            return v14;
        }

        return v7;
    label_64:
        ResultKt.throwOnFailure(v7);
        return v2_1;
    }

    public static Object run$default(GraphicsLaunch arg8, boolean arg9, Function0 arg10, Function1 arg11, Function2 arg12, Function1 arg13, Function1 arg14, Continuation arg15, int arg16, Object arg17) {
        GraphicsLaunch$$ExternalSyntheticLambda0 v13;
        GraphicsLaunch$run$2 v12;
        if((arg16 & 8) != 0) {
            v12 = new GraphicsLaunch$run$2(null);
        }

        Function2 v4 = ((Function2)v12);
        if((arg16 & 16) != 0) {
            v13 = new GraphicsLaunch$$ExternalSyntheticLambda0();
        }

        return arg8.run(arg9, arg10, arg11, v4, ((Function1)v13), arg14, arg15);
    }

    static final boolean run$lambda$0(Object arg0) {
        return 1;
    }
}

