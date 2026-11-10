package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.YieldKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f\u0012\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000E\u0010!\u001A\u00020\u000EH\u0086@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001A\u0004\u0018\u00010\u0002*\u00020\u0005H\u0080@¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0014\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u00028V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001A\u0010\u001B\u001A\u00020\u001CX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 ¨\u0006&"}, d2={"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "<init>", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "cacheable", "", "getCacheable$ui_text", "()Z", "setCacheable$ui_text", "(Z)V", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AsyncFontListLoader implements State {
    public static final int $stable;
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable;
    private final List fontList;
    private final Function1 onCompletion;
    private final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;
    private final MutableState value$delegate;

    static {
    }

    public AsyncFontListLoader(List arg1, Object arg2, TypefaceRequest arg3, AsyncTypefaceCache arg4, Function1 arg5, PlatformFontLoader arg6) {
        super();
        this.fontList = arg1;
        this.typefaceRequest = arg3;
        this.asyncTypefaceCache = arg4;
        this.onCompletion = arg5;
        this.platformFontLoader = arg6;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(arg2, null, 2, null);
        this.cacheable = true;
    }

    public static final PlatformFontLoader access$getPlatformFontLoader$p(AsyncFontListLoader arg0) {
        return arg0.platformFontLoader;
    }

    public final boolean getCacheable$ui_text() {
        return this.cacheable;
    }

    public Object getValue() {
        return this.value$delegate.getValue();
    }

    public final Object load(Continuation arg15) {
        Object v7_2;
        Object v8;
        int v7;
        Object v9;
        Unit v0_5;
        boolean v15_1;
        int v15;
        Continuation v12;
        List v0_4;
        int v2;
        Continuation v0;
        if((arg15 instanceof AsyncFontListLoader$load$1)) {
            v0 = arg15;
            v2 = 0x80000000;
            if((((AsyncFontListLoader$load$1)v0).label & v2) != 0) {
                ((AsyncFontListLoader$load$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            AsyncFontListLoader$load$1 v0_1 = new AsyncFontListLoader$load$1(this, arg15);
        }

        arg15 = v0;
        Object v0_2 = ((AsyncFontListLoader$load$1)arg15).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((AsyncFontListLoader$load$1)arg15).label;
        Continuation v3 = null;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v0_2);
            try {
                v0_4 = this.fontList;
                v2 = v0_4.size();
                v12 = arg15;
                v15 = 0;
                goto label_48;
            }
            catch(Throwable v0_3) {
            label_121:
                v15_1 = JobKt.isActive(arg15.getContext());
                this.cacheable = false;
                this.onCompletion.invoke(new Immutable(this.getValue(), v15_1));
                throw v0_3;
            }

        label_102:
            v12 = arg15;
            v15 = v7;
            v0_2 = v8;
        label_105:
            ++v15;
            goto label_48;
        label_75:
            if(v0_2 != null) {
                try {
                    this.setValue(FontSynthesis_androidKt.synthesizeTypeface-FxwP2eA(this.typefaceRequest.getFontSynthesis-GVVA2EU(), v0_2, ((Font)v9), this.typefaceRequest.getFontWeight(), this.typefaceRequest.getFontStyle-_-LCdwA()));
                    v0_5 = Unit.INSTANCE;
                }
                catch(Throwable v0_3) {
                    goto label_121;
                }

                v15_1 = JobKt.isActive(arg15.getContext());
                this.cacheable = false;
                this.onCompletion.invoke(new Immutable(this.getValue(), v15_1));
                return v0_5;
            }
            else {
                try {
                    ((AsyncFontListLoader$load$1)arg15).L$0 = v8;
                    ((AsyncFontListLoader$load$1)arg15).L$1 = v3;
                    ((AsyncFontListLoader$load$1)arg15).I$0 = v7;
                    ((AsyncFontListLoader$load$1)arg15).I$1 = v2;
                    ((AsyncFontListLoader$load$1)arg15).label = v4;
                    if(YieldKt.yield(arg15) == v1) {
                    }
                    else {
                        goto label_102;
                    }
                }
                catch(Throwable v0_3) {
                    goto label_121;
                }

                return v1;
            }
        }
        else if(v2 == 1) {
            v2 = ((AsyncFontListLoader$load$1)arg15).I$1;
            v7 = ((AsyncFontListLoader$load$1)arg15).I$0;
            v8 = ((AsyncFontListLoader$load$1)arg15).L$1;
            v9 = ((AsyncFontListLoader$load$1)arg15).L$0;
            try {
                ResultKt.throwOnFailure(v0_2);
                Object v13 = v9;
                v9 = v8;
                v8 = v13;
                goto label_75;
            }
            catch(Throwable v0_3) {
                goto label_121;
            }
        }
        else if(v2 == v4) {
            v2 = ((AsyncFontListLoader$load$1)arg15).I$1;
            v7 = ((AsyncFontListLoader$load$1)arg15).I$0;
            v8 = ((AsyncFontListLoader$load$1)arg15).L$0;
            try {
                ResultKt.throwOnFailure(v0_2);
                goto label_102;
            }
            catch(Throwable v0_3) {
                goto label_121;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_48:
        if(v15 >= v2) {
            goto label_110;
        }

        try {
            v8 = v0_4.get(v15);
            if(!FontLoadingStrategy.equals-impl0(((Font)v8).getLoadingStrategy-PKNRLFQ(), FontLoadingStrategy.Companion.getAsync-PKNRLFQ())) {
                goto label_105;
            }

            AsyncTypefaceCache v7_1 = this.asyncTypefaceCache;
            PlatformFontLoader v9_1 = this.platformFontLoader;
            AsyncFontListLoader$load$2$typeface$1 v11 = new AsyncFontListLoader$load$2$typeface$1(this, ((Font)v8), v3);
            ((AsyncFontListLoader$load$1)v12).L$0 = v0_4;
            ((AsyncFontListLoader$load$1)v12).L$1 = v8;
            ((AsyncFontListLoader$load$1)v12).I$0 = v15;
            ((AsyncFontListLoader$load$1)v12).I$1 = v2;
            ((AsyncFontListLoader$load$1)v12).label = 1;
            v7_2 = v7_1.runCached(((Font)v8), v9_1, false, ((Function1)v11), v12);
            if(v7_2 != v1) {
                goto label_70;
            }
        }
        catch(Throwable v0_3) {
            goto label_108;
        }

        return v1;
    label_70:
        v9 = v8;
        List v8_1 = v0_4;
        v0_2 = v7_2;
        v7 = v15;
        arg15 = v12;
        goto label_75;
    label_108:
        arg15 = v12;
        goto label_121;
    label_110:
        v15_1 = JobKt.isActive(v12.getContext());
        this.cacheable = false;
        this.onCompletion.invoke(new Immutable(this.getValue(), v15_1));
        return Unit.INSTANCE;
    }

    public final Object loadWithTimeoutOrNull$ui_text(Font arg6, Continuation arg7) {
        Object v6;
        int v2;
        Continuation v0;
        if((arg7 instanceof AsyncFontListLoader$loadWithTimeoutOrNull$1)) {
            v0 = arg7;
            v2 = 0x80000000;
            if((((AsyncFontListLoader$loadWithTimeoutOrNull$1)v0).label & v2) != 0) {
                ((AsyncFontListLoader$loadWithTimeoutOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            AsyncFontListLoader$loadWithTimeoutOrNull$1 v0_1 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, arg7);
        }

        Object v7 = ((AsyncFontListLoader$loadWithTimeoutOrNull$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((AsyncFontListLoader$loadWithTimeoutOrNull$1)v0).label;
        Continuation v4 = null;
        if(v2 != 0) {
            if(v2 == 1) {
                v6 = ((AsyncFontListLoader$loadWithTimeoutOrNull$1)v0).L$0;
                try {
                    ResultKt.throwOnFailure(v7);
                    return v7;
                }
                catch(CancellationException v5) {
                    goto label_56;
                }
                catch(Exception v5_1) {
                    goto label_41;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v7);
        try {
            AsyncFontListLoader$loadWithTimeoutOrNull$2 v7_1 = new AsyncFontListLoader$loadWithTimeoutOrNull$2(this, arg6, v4);
            ((AsyncFontListLoader$loadWithTimeoutOrNull$1)v0).L$0 = arg6;
            ((AsyncFontListLoader$loadWithTimeoutOrNull$1)v0).label = 1;
            Object v5_2 = TimeoutKt.withTimeoutOrNull(15000, ((Function2)v7_1), v0);
            if(v5_2 != v1) {
                return v5_2;
            }

            return v1;
        }
        catch(Exception v5_1) {
        label_41:
            Element v7_2 = v0.getContext().get(CoroutineExceptionHandler.Key);
            if(v7_2 == null) {
                return v4;
            }

            ((CoroutineExceptionHandler)v7_2).handleException(v0.getContext(), new IllegalStateException("Unable to load font " + v6, ((Throwable)v5_1)));
        }
        catch(CancellationException v5) {
        label_56:
            if(JobKt.isActive(v0.getContext())) {
                return v4;
            }

            throw v5;
        }

        return v4;
    }

    public final void setCacheable$ui_text(boolean arg1) {
        this.cacheable = arg1;
    }

    private void setValue(Object arg1) {
        this.value$delegate.setValue(arg1);
    }
}

