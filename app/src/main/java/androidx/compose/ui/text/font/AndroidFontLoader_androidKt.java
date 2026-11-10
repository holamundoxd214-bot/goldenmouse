package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0002\u001A\u001A\u0010\u0005\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"load", "Landroid/graphics/Typeface;", "Landroidx/compose/ui/text/font/ResourceFont;", "context", "Landroid/content/Context;", "loadAsync", "(Landroidx/compose/ui/text/font/ResourceFont;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidFontLoader_androidKt {
    public static final Typeface access$load(ResourceFont arg0, Context arg1) {
        return AndroidFontLoader_androidKt.load(arg0, arg1);
    }

    public static final Object access$loadAsync(ResourceFont arg0, Context arg1, Continuation arg2) {
        return AndroidFontLoader_androidKt.loadAsync(arg0, arg1, arg2);
    }

    private static final Typeface load(ResourceFont arg0, Context arg1) {
        Typeface v0 = ResourcesCompat.getFont(arg1, arg0.getResId());
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    private static final Object loadAsync(ResourceFont arg4, Context arg5, Continuation arg6) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg6), 1);
        v0.initCancellability();
        ResourcesCompat.getFont(arg5, arg4.getResId(), new AndroidFontLoader_androidKt$loadAsync$2$1(v0, arg4), null);
        Object v4 = v0.getResult();
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg6);
        }

        return v4;
    }
}

