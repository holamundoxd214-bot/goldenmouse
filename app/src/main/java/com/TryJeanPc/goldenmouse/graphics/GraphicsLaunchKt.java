package com.TryJeanPc.goldenmouse.graphics;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\u0000\u001A\\\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u001C\u0010\b\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\t2\u001C\u0010\f\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\tH\u0080@¢\u0006\u0002\u0010\r\u001A\u0012\u0010\u000E\u001A\u00020\u00012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0005H\u0000\u001Af\u0010\u0010\u001A\u00020\u00072\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00130\u00122\u001C\u0010\u0014\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\t2\u001C\u0010\u0015\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\t2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0080@¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2={"graphicsNeedsPreparation", "", "profile", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "pending", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecord;", "prepareGraphicsTexture", "", "recover", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "apply", "(Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecord;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "graphicsWatchRequired", "record", "observeGraphicsRecovery", "now", "Lkotlin/Function0;", "", "pause", "poll", "expired", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GraphicsLaunchKt {
    public static final boolean graphicsNeedsPreparation(GraphicsProfile arg1, GraphicsRecord arg2) {
        Intrinsics.checkNotNullParameter(arg1, "profile");
        if(!arg1.getTextureRequested() && (arg2 == null || !arg2.getAutomatic())) {
            List v1 = arg2 != null ? arg2.getTextureFeatures() : null;
            if(v1 != null) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    public static final boolean graphicsWatchRequired(GraphicsRecord arg2) {
        if(arg2 != null && (arg2.getAutomatic()) && !arg2.getUncertain()) {
            return 1;
        }

        return 0;
    }

    public static final Object observeGraphicsRecovery(Function0 arg22, Function1 arg23, Function1 arg24, Function0 arg25, Continuation arg26) {
        Object v1_2;
        Object v7_1;
        int v8_1;
        Continuation v9;
        long v14;
        Object v13;
        Object v12;
        Object v11;
        long v8;
        int v7;
        int v10_2;
        long v20;
        int v0_2;
        Object v15;
        Object v14_1;
        Function1 v13_1;
        GraphicsLaunchKt$observeGraphicsRecovery$1 v1_1;
        int v3;
        Continuation v1;
        Continuation v0 = arg26;
        if((v0 instanceof GraphicsLaunchKt$observeGraphicsRecovery$1)) {
            v1 = v0;
            v3 = 0x80000000;
            if((((GraphicsLaunchKt$observeGraphicsRecovery$1)v1).label & v3) != 0) {
                ((GraphicsLaunchKt$observeGraphicsRecovery$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_1 = new GraphicsLaunchKt$observeGraphicsRecovery$1(v0);
        }

        Object v0_1 = v1_1.result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = v1_1.label;
        int v5 = 2;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            Function1 v3_1 = arg24;
            v9 = ((Continuation)v1_1);
            v10_2 = 0;
            long v11_1 = arg22.invoke().longValue();
            Function1 v1_3 = arg23;
            Function0 v7_2 = arg25;
            v8_1 = 60;
            Function0 v0_3 = arg22;
            goto label_72;
        label_125:
            if(!((Boolean)v0_1).booleanValue()) {
                return Unit.INSTANCE;
            }
            else {
                v10_2 = v3 + 1;
                Object v3_2 = v11;
                v0_1 = v13;
                v11_1 = v14;
            label_72:
                if(v10_2 < v8_1) {
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).L$0 = v0_1;
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).L$1 = v1_2;
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).L$2 = v3_2;
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).L$3 = v7_1;
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).J$0 = v11_1;
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).I$0 = v8_1;
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).I$1 = v10_2;
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).I$2 = v10_2;
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).I$3 = 0;
                    ((GraphicsLaunchKt$observeGraphicsRecovery$1)v9).label = 1;
                    if(((Function1)v1_2).invoke(v9) == v2) {
                        return v2;
                    }
                    else {
                        Function0 v15_1 = ((Function0)v0_1);
                        v14_1 = v1_2;
                        v13_1 = ((Function1)v3_2);
                        v0_2 = 0;
                        v1 = v9;
                        v3 = v10_2;
                        v20 = v11_1;
                        v12 = v7_1;
                        v7 = v8_1;
                    }
                }
                else {
                    ((Function0)v7_1).invoke();
                    return Unit.INSTANCE;
                }
            }
        }
        else if(v3 == 1) {
            v3 = v1_1.I$3;
            v7 = v1_1.I$2;
            v8_1 = v1_1.I$1;
            int v9_1 = v1_1.I$0;
            long v10_1 = v1_1.J$0;
            v12 = v1_1.L$3;
            v13 = v1_1.L$2;
            v14_1 = v1_1.L$1;
            v15 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            v0_2 = v3;
            v3 = v8_1;
            v20 = v10_1;
            v10_2 = v7;
            v7 = v9_1;
        }
        else if(v3 == v5) {
            v3 = v1_1.I$1;
            v7 = v1_1.I$0;
            v8 = v1_1.J$0;
            Object v10 = v1_1.L$3;
            v11 = v1_1.L$2;
            v12 = v1_1.L$1;
            v13 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            v14 = v8;
            v9 = ((Continuation)v1_1);
            v8_1 = v7;
            v7_1 = v10;
            v1_2 = v12;
            goto label_125;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        v8 = v20;
        if(((Function0)v15).invoke().longValue() - v8 >= 300000) {
            ((Function0)v12).invoke();
            return Unit.INSTANCE;
        }

        v1_1.L$0 = v15;
        v1_1.L$1 = v14_1;
        v1_1.L$2 = v13_1;
        v1_1.L$3 = v12;
        v1_1.J$0 = v8;
        v1_1.I$0 = v7;
        v1_1.I$1 = v3;
        v1_1.I$2 = v10_2;
        v1_1.I$3 = v0_2;
        v1_1.label = v5;
        v0_1 = v13_1.invoke(v1_1);
        if(v0_1 == v2) {
            return v2;
        }

        v11 = v13_1;
        v13 = v15;
        v20 = v8;
        v9 = ((Continuation)v1_1);
        v8_1 = v7;
        v7_1 = v12;
        v1_2 = v14_1;
        v14 = v20;
        goto label_125;
    }

    public static final Object prepareGraphicsTexture(GraphicsProfile arg0, GraphicsRecord arg1, Function1 arg2, Function1 arg3, Continuation arg4) {
        Object v0;
        if(arg0.getTextureRequested()) {
            v0 = arg3.invoke(arg4);
            if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v0;
            }

            return Unit.INSTANCE;
        }

        if(arg1 == null || !arg1.getAutomatic()) {
            List v0_1 = arg1 != null ? arg1.getTextureFeatures() : null;
            if(v0_1 == null) {
                goto label_24;
            }
        }
        else {
        }

        v0 = arg2.invoke(arg4);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    label_24:
        return Unit.INSTANCE;
    }
}

