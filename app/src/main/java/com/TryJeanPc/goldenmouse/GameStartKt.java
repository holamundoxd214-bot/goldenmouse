package com.TryJeanPc.goldenmouse;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.TryJeanPc.goldenmouse.activation.ActivationStatus;
import com.TryJeanPc.goldenmouse.license.LicenseActivity;
import com.TryJeanPc.goldenmouse.license.LicenseManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutCancellationException;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AN\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\"\u0010\b\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tH\u0080@¢\u0006\u0002\u0010\r\u001A0\u0010\u000E\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0080@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"runForCurrentGame", "Lcom/TryJeanPc/goldenmouse/StartEvaluation;", "Lcom/TryJeanPc/goldenmouse/StartRequirementEvaluator;", "packageName", "", "isCurrent", "Lkotlin/Function0;", "", "onReady", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lcom/TryJeanPc/goldenmouse/StartRequirementEvaluator;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startGoldenGame", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GameStartKt {
    public static final Object runForCurrentGame(StartRequirementEvaluator arg3, String arg4, Function0 arg5, Function2 arg6, Continuation arg7) {
        String v0 = arg4;
        int v0_1 = v0 == null || (StringsKt.isBlank(((CharSequence)v0))) ? 1 : 0;
        return arg3.runIfReady(v0_1 ^ 1, new GameStartKt$runForCurrentGame$2(arg5, arg6, arg4, null), arg7);
    }

    public static final Object startGoldenGame(Context arg7, String arg8, Function0 arg9, Continuation arg10) {
        Object v7;
        GameStartKt$startGoldenGame$1 v0_1;
        int v2;
        if((arg10 instanceof GameStartKt$startGoldenGame$1)) {
            Continuation v0 = arg10;
            v2 = 0x80000000;
            if((((GameStartKt$startGoldenGame$1)v0).label & v2) != 0) {
                ((GameStartKt$startGoldenGame$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new GameStartKt$startGoldenGame$1(arg10);
        }

        Object v10 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        Object v4 = null;
        String v5 = "GOLDEN_START";
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            if(!LicenseManager.isAuthorized()) {
                arg7.startActivity(new Intent(arg7, LicenseActivity.class).addFlags(0x10000000));
                return v4;
            }
            else {
                Log.i(v5, "phase=requirements-start target=" + arg8);
                Toast.makeText(arg7, "Comprobando requisitos…", 0).show();
                StartRequirementEvaluator v10_1 = new StartRequirementEvaluator(new GameStartKt$$ExternalSyntheticLambda0(arg7), new GameStartKt$startGoldenGame$evaluator$2(((Continuation)v4)));
                try {
                    GameStartKt$startGoldenGame$result$1 v2_1 = new GameStartKt$startGoldenGame$result$1(arg7, arg9, ((Continuation)v4));
                    v0_1.L$0 = arg7;
                    v0_1.L$1 = SpillingKt.nullOutSpilledVariable(arg8);
                    v0_1.L$2 = SpillingKt.nullOutSpilledVariable(arg9);
                    v0_1.L$3 = SpillingKt.nullOutSpilledVariable(v10_1);
                    v0_1.label = 1;
                    v10 = GameStartKt.runForCurrentGame(v10_1, arg8, arg9, ((Function2)v2_1), ((Continuation)v0_1));
                    if(v10 == v1) {
                        return v1;
                    }

                label_76:
                    ActivationStatus v8_2 = ((StartEvaluation)v10).getCoreStatus();
                    List v9 = ((StartEvaluation)v10).getBlockedRequirements();
                    ArrayList v0_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v9), 10));
                    Iterator v9_1 = ((Iterable)v9).iterator();
                    while(v9_1.hasNext()) {
                        ((Collection)v0_2).add(v9_1.next().getDefinition().getId());
                    }

                    Log.i(v5, "phase=requirements-result core=" + v8_2 + " blocked=" + v0_2 + " canStart=" + ((StartEvaluation)v10).getCanStart());
                    return v10;
                }
                catch(Exception v8) {
                label_105:
                    Log.e(v5, "Fallo al iniciar el servicio o abrir el juego", v8);
                    arg8 = v8.getMessage();
                    if(arg8 == null) {
                        arg8 = "error del servicio o del juego";
                    }

                    Toast.makeText(((Context)v7), "No se pudo iniciar: " + arg8, 1).show();
                    return v4;
                }
                catch(CancellationException v7_1) {
                label_119:
                    Log.i(v5, "phase=start-cancelled");
                    throw v7_1;
                }
                catch(TimeoutCancellationException v8_1) {
                label_122:
                    Log.e(v5, "No se confirmó una fuente de primer plano antes de abrir el juego", ((Throwable)v8_1));
                    Toast.makeText(((Context)v7), "El observador privilegiado no respondió. Revisa la activación Shizuku/KADB.", 1).show();
                    return v4;
                }
            }
        }
        else if(v2 == 1) {
            v7 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v10);
                goto label_76;
            }
            catch(Exception v8) {
                goto label_105;
            }
            catch(CancellationException v7_1) {
                goto label_119;
            }
            catch(TimeoutCancellationException v8_1) {
                goto label_122;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        goto label_76;
        return v4;
    }

    static final List startGoldenGame$lambda$0(Context arg2) {
        Log.i("GOLDEN_START", "phase=permissions-check");
        return PermissionRequirements.INSTANCE.evaluate(arg2);
    }
}

