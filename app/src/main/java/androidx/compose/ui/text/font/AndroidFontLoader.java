package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\nH\u0016J\u0018\u0010\u000B\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\nH\u0096@¢\u0006\u0002\u0010\fR\u0016\u0010\u0002\u001A\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "kotlin.jvm.PlatformType", "loadBlocking", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "awaitLoad", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    static {
    }

    public AndroidFontLoader(Context arg1) {
        super();
        this.context = arg1.getApplicationContext();
    }

    public Object awaitLoad(Font arg6, Continuation arg7) {
        Object v6;
        AndroidFontLoader$awaitLoad$1 v0_1;
        int v2;
        if((arg7 instanceof AndroidFontLoader$awaitLoad$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((AndroidFontLoader$awaitLoad$1)v0).label & v2) != 0) {
                ((AndroidFontLoader$awaitLoad$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new AndroidFontLoader$awaitLoad$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            if((arg6 instanceof AndroidFont)) {
                TypefaceLoader v7_1 = ((AndroidFont)arg6).getTypefaceLoader();
                Context v5 = this.context;
                v0_1.label = 1;
                Object v5_1 = v7_1.awaitLoad(v5, ((AndroidFont)arg6), ((Continuation)v0_1));
                if(v5_1 == v1) {
                }
                else {
                    return v5_1;
                }
            }
            else if((arg6 instanceof ResourceFont)) {
                Context v2_1 = this.context;
                v0_1.L$0 = arg6;
                v0_1.label = v3;
                v7 = AndroidFontLoader_androidKt.access$loadAsync(arg6, v2_1, ((Continuation)v0_1));
                if(v7 == v1) {
                    return v1;
                }

                goto label_49;
            }
            else {
                goto label_53;
            }

            return v1;
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v7);
            return v7;
        }
        else if(v2 == v3) {
            v6 = v0_1.L$0;
            ResultKt.throwOnFailure(v7);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_49:
        return PlatformTypefaces_androidKt.setFontVariationSettings(((Typeface)v7), ((ResourceFont)v6).getVariationSettings(), this.context);
    label_53:
        throw new IllegalArgumentException("Unknown font type: " + arg6);
    }

    public Object getCacheKey() {
        return this.cacheKey;
    }

    public Typeface loadBlocking(Font arg5) {
        Object v5_2;
        if((arg5 instanceof AndroidFont)) {
            return ((AndroidFont)arg5).getTypefaceLoader().loadBlocking(this.context, ((AndroidFont)arg5));
        }

        Object v1 = null;
        if((arg5 instanceof ResourceFont)) {
            Font v0 = arg5;
            int v2 = ((ResourceFont)v0).getLoadingStrategy-PKNRLFQ();
            if(FontLoadingStrategy.equals-impl0(v2, FontLoadingStrategy.Companion.getBlocking-PKNRLFQ())) {
                Typeface v5 = AndroidFontLoader_androidKt.access$load(((ResourceFont)v0), this.context);
                goto label_37;
            }

            if(FontLoadingStrategy.equals-impl0(v2, FontLoadingStrategy.Companion.getOptionalLocal-PKNRLFQ())) {
                try {
                    v5_2 = Result.constructor-impl(AndroidFontLoader_androidKt.access$load(((ResourceFont)arg5), this.context));
                }
                catch(Throwable v5_1) {
                    v5_2 = Result.constructor-impl(ResultKt.createFailure(v5_1));
                }

                if(Result.isFailure-impl(v5_2)) {
                }
                else {
                    v1 = v5_2;
                }

                v5_2 = v1;
            label_37:
                return PlatformTypefaces_androidKt.setFontVariationSettings(((Typeface)v5_2), ((ResourceFont)v0).getVariationSettings(), this.context);
            }

            if(FontLoadingStrategy.equals-impl0(v2, FontLoadingStrategy.Companion.getAsync-PKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            }

            throw new IllegalArgumentException("Unknown loading type " + FontLoadingStrategy.toString-impl(((ResourceFont)v0).getLoadingStrategy-PKNRLFQ()));
        }

        return ((Typeface)v1);
    }

    public Object loadBlocking(Font arg1) {
        return this.loadBlocking(arg1);
    }
}

