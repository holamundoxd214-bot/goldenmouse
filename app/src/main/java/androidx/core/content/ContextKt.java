package androidx.core.content;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001AQ\u0010\u0005\u001A\u00020\u0006*\u00020\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\n2\b\b\u0003\u0010\u000B\u001A\u00020\f2\b\b\u0003\u0010\r\u001A\u00020\f2\u0017\u0010\u000E\u001A\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000F¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001A;\u0010\u0005\u001A\u00020\u0006*\u00020\u00032\b\b\u0001\u0010\u0012\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\n2\u0017\u0010\u000E\u001A\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000F¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001A[\u0010\u0013\u001A\u00020\u0014*\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\f2\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\u001F\u0010\u001C\u001A\u001B\u0012\u0004\u0012\u00020\u001E\u0012\u0006\u0012\u0004\u0018\u00010\u001F\u0012\u0004\u0012\u00020\u00060\u001D¢\u0006\u0002\b\u0011H\u0086@¢\u0006\u0002\u0010 \u001Ak\u0010!\u001A\u00020\u0014*\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\f2\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2/\u0010\u001C\u001A+\b\u0001\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"¢\u0006\u0002\b\u0011H\u0086@¢\u0006\u0002\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&"}, d2={"getSystemService", "T", "", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "withStyledAttributes", "", "set", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/ExtensionFunctionType;", "resourceId", "receiveBroadcasts", "", "filter", "Landroid/content/IntentFilter;", "flags", "broadcastPermission", "", "scheduler", "Landroid/os/Handler;", "onReceive", "Lkotlin/Function2;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Intent;", "(Landroid/content/Context;Landroid/content/IntentFilter;ILjava/lang/String;Landroid/os/Handler;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveBroadcastsAsync", "Lkotlin/Function3;", "Landroid/content/BroadcastReceiver$PendingResult;", "Lkotlin/coroutines/Continuation;", "(Landroid/content/Context;Landroid/content/IntentFilter;ILjava/lang/String;Landroid/os/Handler;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ContextKt {
    public static final Object getSystemService(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return ContextCompat.getSystemService(arg2, Object.class);
    }

    public static final Object receiveBroadcasts(Context arg13, IntentFilter arg14, int arg15, String arg16, Handler arg17, Function2 arg18, Continuation arg19) {
        Throwable v15;
        Object v14;
        Object v13;
        ContextKt$receiveBroadcasts$1 v2_1;
        int v4;
        Function2 v0 = arg18;
        Continuation v1 = arg19;
        if((v1 instanceof ContextKt$receiveBroadcasts$1)) {
            Continuation v2 = v1;
            v4 = 0x80000000;
            if((((ContextKt$receiveBroadcasts$1)v2).label & v4) != 0) {
                ((ContextKt$receiveBroadcasts$1)v2).label -= v4;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v2_1 = new ContextKt$receiveBroadcasts$1(v1);
        }

        Object v1_1 = v2_1.result;
        Object v3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v4 = v2_1.label;
        if(v4 == 0) {
            ResultKt.throwOnFailure(v1_1);
            ObjectRef v1_2 = new ObjectRef();
            try {
                v2_1.L$0 = arg13;
                v2_1.L$1 = arg14;
                v2_1.L$2 = arg16;
                v2_1.L$3 = arg17;
                v2_1.L$4 = v0;
                v2_1.L$5 = v1_2;
                v2_1.I$0 = arg15;
                v2_1.label = 1;
                CancellableContinuationImpl v12 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(((Continuation)v2_1)), 1);
                v12.initCancellability();
                v1_2.element = new ContinuationBroadcastReceiver(v12, v0);
                ContextCompat.registerReceiver(arg13, v1_2.element, arg14, arg16, arg17, arg15);
                v14 = v12.getResult();
                if(v14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(((Continuation)v2_1));
                }

                if(v14 == v3) {
                    return v3;
                }

            label_73:
                throw new KotlinNothingValueException();
            }
            catch(Throwable v0_1) {
                v15 = v0_1;
                Context v14_1 = ((Context)v13);
                v13 = v1_1;
                goto label_80;
            }
        }
        else if(v4 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            v13 = v2_1.L$5;
            v14 = v2_1.L$0;
            try {
                ResultKt.throwOnFailure(v1_1);
                v1_1 = v13;
                v13 = v14;
                goto label_73;
            }
            catch(Throwable v0_1) {
                v15 = v0_1;
                goto label_80;
            }
        }

        goto label_73;
    label_80:
        if(((ObjectRef)v13).element != null) {
            ((Context)v14).unregisterReceiver(((ObjectRef)v13).element);
        }

        throw v15;
    }

    public static Object receiveBroadcasts$default(Context arg1, IntentFilter arg2, int arg3, String arg4, Handler arg5, Function2 arg6, Continuation arg7, int arg8, Object arg9) {
        String v0 = null;
        if((arg8 & 4) != 0) {
            arg4 = v0;
        }

        if((arg8 & 8) != 0) {
            arg5 = ((Handler)v0);
        }

        return ContextKt.receiveBroadcasts(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final Object receiveBroadcastsAsync(Context arg13, IntentFilter arg14, int arg15, String arg16, Handler arg17, Function3 arg18, Continuation arg19) {
        int v3;
        Continuation v1;
        Continuation v0 = arg19;
        if((v0 instanceof ContextKt$receiveBroadcastsAsync$1)) {
            v1 = v0;
            v3 = 0x80000000;
            if((((ContextKt$receiveBroadcastsAsync$1)v1).label & v3) != 0) {
                ((ContextKt$receiveBroadcastsAsync$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            ContextKt$receiveBroadcastsAsync$1 v1_1 = new ContextKt$receiveBroadcastsAsync$1(v0);
        }

        Object v0_1 = ((ContextKt$receiveBroadcastsAsync$1)v1).result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = ((ContextKt$receiveBroadcastsAsync$1)v1).label;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            ContextKt$receiveBroadcastsAsync$2 v5 = new ContextKt$receiveBroadcastsAsync$2(arg13, arg14, arg15, arg16, arg17, arg18, null);
            ((ContextKt$receiveBroadcastsAsync$1)v1).label = 1;
            if(CoroutineScopeKt.coroutineScope(((Function2)v5), v1) == v2) {
                return v2;
            }
        }
        else if(v3 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            ResultKt.throwOnFailure(v0_1);
        }

        throw new KotlinNothingValueException();
    }

    public static Object receiveBroadcastsAsync$default(Context arg1, IntentFilter arg2, int arg3, String arg4, Handler arg5, Function3 arg6, Continuation arg7, int arg8, Object arg9) {
        String v0 = null;
        if((arg8 & 4) != 0) {
            arg4 = v0;
        }

        if((arg8 & 8) != 0) {
            arg5 = ((Handler)v0);
        }

        return ContextKt.receiveBroadcastsAsync(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final void withStyledAttributes(Context arg1, int arg2, int[] arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "attrs");
        Intrinsics.checkNotNullParameter(arg4, "block");
        TypedArray v1 = arg1.obtainStyledAttributes(arg2, arg3);
        arg4.invoke(v1);
        v1.recycle();
    }

    public static final void withStyledAttributes(Context arg1, AttributeSet arg2, int[] arg3, int arg4, int arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "attrs");
        Intrinsics.checkNotNullParameter(arg6, "block");
        TypedArray v1 = arg1.obtainStyledAttributes(arg2, arg3, arg4, arg5);
        arg6.invoke(v1);
        v1.recycle();
    }

    public static void withStyledAttributes$default(Context arg1, AttributeSet arg2, int[] arg3, int arg4, int arg5, Function1 arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg2 = null;
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "attrs");
        Intrinsics.checkNotNullParameter(arg6, "block");
        TypedArray v1 = arg1.obtainStyledAttributes(arg2, arg3, 0, 0);
        arg6.invoke(v1);
        v1.recycle();
    }
}

