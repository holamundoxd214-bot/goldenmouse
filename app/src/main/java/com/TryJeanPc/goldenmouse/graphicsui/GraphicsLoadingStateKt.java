package com.TryJeanPc.goldenmouse.graphicsui;

import com.TryJeanPc.goldenmouse.graphics.GraphicsStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A&\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005H\u0000\u001AP\u0010\u0007\u001A\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001A\u00020\u00012\u0014\u0010\n\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\f0\u000B2\u001C\u0010\r\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000BH\u0080@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2={"graphicsLoadingOperation", "Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsLoadingOperation;", "state", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsStatus;", "saving", "", "checking", "runGraphicsLoading", "T", "operation", "show", "Lkotlin/Function1;", "", "work", "Lkotlin/coroutines/Continuation;", "", "(Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsLoadingOperation;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GraphicsLoadingStateKt {
    public static final GraphicsLoadingOperation graphicsLoadingOperation(GraphicsStatus arg1, boolean arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "state");
        if(arg1.getBusy()) {
            String v1 = arg1.getOperation();
            if(v1 != null) {
                switch(v1.hashCode()) {
                    case -494020896: {
                        goto label_27;
                    }
                    case -79041976: {
                        goto label_21;
                    }
                    case 928303099: {
                        goto label_15;
                    }
                    case 1660755958: {
                        goto label_9;
                    }
                }

                goto label_33;
            label_21:
                if(!v1.equals("APLICAR")) {
                }
                else {
                    return GraphicsLoadingOperation.APPLY;
                label_9:
                    if(!v1.equals("PRELAUNCH")) {
                    }
                    else {
                        return GraphicsLoadingOperation.PREPARE;
                    label_27:
                        if(!v1.equals("LANZAMIENTO")) {
                        }
                        else {
                            return GraphicsLoadingOperation.LAUNCH_RECEIPT;
                        label_15:
                            if(!v1.equals("RESTAURAR")) {
                            }
                            else {
                                return GraphicsLoadingOperation.RESTORE;
                            }
                        }
                    }
                }
            }

        label_33:
            return GraphicsLoadingOperation.RECOVER;
        }

        if(arg2) {
            return GraphicsLoadingOperation.SAVE;
        }

        if(arg3) {
            return GraphicsLoadingOperation.CHECK;
        }

        return null;
    }

    public static GraphicsLoadingOperation graphicsLoadingOperation$default(GraphicsStatus arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        return GraphicsLoadingStateKt.graphicsLoadingOperation(arg1, false, false);
    }

    public static final Object runGraphicsLoading(GraphicsLoadingOperation arg5, Function1 arg6, Function1 arg7, Continuation arg8) {
        Object v6;
        GraphicsLoadingStateKt$runGraphicsLoading$1 v0_1;
        int v2;
        if((arg8 instanceof GraphicsLoadingStateKt$runGraphicsLoading$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((GraphicsLoadingStateKt$runGraphicsLoading$1)v0).label & v2) != 0) {
                ((GraphicsLoadingStateKt$runGraphicsLoading$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new GraphicsLoadingStateKt$runGraphicsLoading$1(arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        Object v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            arg6.invoke(arg5);
            try {
                v0_1.L$0 = SpillingKt.nullOutSpilledVariable(arg5);
                v0_1.L$1 = arg6;
                v0_1.L$2 = SpillingKt.nullOutSpilledVariable(arg7);
                v0_1.label = 1;
                v8 = arg7.invoke(v0_1);
                if(v8 != v1) {
                    goto label_41;
                }
            }
            catch(Throwable v5) {
            label_44:
                ((Function1)v6).invoke(v3);
                throw v5;
            }

            return v1;
        }
        else if(v2 == 1) {
            v6 = v0_1.L$1;
            try {
                ResultKt.throwOnFailure(v8);
            }
            catch(Throwable v5) {
                goto label_44;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_41:
        ((Function1)v6).invoke(v3);
        return v8;
    }
}

