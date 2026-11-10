package androidx.compose.ui.platform;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.contentcapture.ContentCaptureSessionWrapper;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u001B\u0010\t\u001A\u00020\n*\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\r\u0010\u000E\u001A+\u0010\u000F\u001A\u00020\n*\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001A/\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0019H\u0002¢\u0006\u0004\b\u001C\u0010\u001D\u001A\u0014\u0010\u001E\u001A\u00020\u001F*\u00020 2\u0006\u0010\f\u001A\u00020 H\u0002\u001A\u000E\u0010!\u001A\u0004\u0018\u00010\"*\u00020 H\u0002\u001A\u0014\u0010$\u001A\u00020\u001F*\u00020%2\u0006\u0010\f\u001A\u00020%H\u0002\"&\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010#\u001A\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"platformTextInputServiceInterceptor", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "getPlatformTextInputServiceInterceptor", "()Lkotlin/jvm/functions/Function1;", "setPlatformTextInputServiceInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "ONE_FRAME_120_HERTZ_IN_MILLISECONDS", "", "preTransform", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "preTransform-JiSxe2E", "([F[F)V", "preTranslate", "x", "", "y", "tmpMatrix", "preTranslate-cG2Xzmc", "([FFF[F)V", "dot", "m1", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "containsDescendant", "", "Landroid/view/View;", "getContentCaptureSessionCompat", "Landroidx/compose/ui/contentcapture/ContentCaptureSessionWrapper;", "maskForNonWindowMetricsChanges", "diffForWindowMetricsChanged", "Landroid/content/res/Configuration;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidComposeView_androidKt {
    private static final long ONE_FRAME_120_HERTZ_IN_MILLISECONDS = 8;
    private static final int maskForNonWindowMetricsChanges = 0x5000E27F;
    private static Function1 platformTextInputServiceInterceptor;

    static {
        AndroidComposeView_androidKt.platformTextInputServiceInterceptor = AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1.INSTANCE;
    }

    public static final boolean access$containsDescendant(View arg0, View arg1) {
        return AndroidComposeView_androidKt.containsDescendant(arg0, arg1);
    }

    public static final boolean access$diffForWindowMetricsChanged(Configuration arg0, Configuration arg1) {
        return AndroidComposeView_androidKt.diffForWindowMetricsChanged(arg0, arg1);
    }

    public static final ContentCaptureSessionWrapper access$getContentCaptureSessionCompat(View arg0) {
        return AndroidComposeView_androidKt.getContentCaptureSessionCompat(arg0);
    }

    public static final void access$preTransform-JiSxe2E(float[] arg0, float[] arg1) {
        AndroidComposeView_androidKt.preTransform-JiSxe2E(arg0, arg1);
    }

    public static final void access$preTranslate-cG2Xzmc(float[] arg0, float arg1, float arg2, float[] arg3) {
        AndroidComposeView_androidKt.preTranslate-cG2Xzmc(arg0, arg1, arg2, arg3);
    }

    private static final boolean containsDescendant(View arg2, View arg3) {
        if(Intrinsics.areEqual(arg3, arg2)) {
            return 0;
        }

        ViewParent v3;
        for(v3 = arg3.getParent(); v3 != null; v3 = v3.getParent()) {
            if((((View)v3)) == arg2) {
                return 1;
            }
        }

        return 0;
    }

    private static final boolean diffForWindowMetricsChanged(Configuration arg0, Configuration arg1) {
        if((arg0.diff(arg1) & 0xAFFF1D80) != 0) {
            return 1;
        }

        return 0;
    }

    private static final float dot-p89u6pk(float[] arg3, int arg4, float[] arg5, int arg6) {
        arg4 *= 4;
        return arg3[arg4] * arg5[arg6] + arg3[arg4 + 1] * arg5[4 + arg6] + arg3[arg4 + 2] * arg5[8 + arg6] + arg3[arg4 + 3] * arg5[12 + arg6];
    }

    private static final ContentCaptureSessionWrapper getContentCaptureSessionCompat(View arg1) {
        ViewCompatShims.setImportantForContentCapture(arg1, 1);
        return ViewCompatShims.getContentCaptureSession(arg1);
    }

    public static final Function1 getPlatformTextInputServiceInterceptor() {
        return AndroidComposeView_androidKt.platformTextInputServiceInterceptor;
    }

    private static final void preTransform-JiSxe2E(float[] arg21, float[] arg22) {
        float v3 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 0, arg21, 0);
        float v5 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 0, arg21, 1);
        float v7 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 0, arg21, 2);
        float v9 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 0, arg21, 3);
        float v10 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 1, arg21, 0);
        float v11 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 1, arg21, 1);
        float v12 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 1, arg21, 2);
        float v13 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 1, arg21, 3);
        float v14 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 2, arg21, 0);
        float v15 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 2, arg21, 1);
        float v16 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 2, arg21, 2);
        float v17 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 2, arg21, 3);
        float v18 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 3, arg21, 0);
        float v19 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 3, arg21, 1);
        float v20 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 3, arg21, 2);
        float v1 = AndroidComposeView_androidKt.dot-p89u6pk(arg22, 3, arg21, 3);
        arg21[0] = v3;
        arg21[1] = v5;
        arg21[2] = v7;
        arg21[3] = v9;
        arg21[4] = v10;
        arg21[5] = v11;
        arg21[6] = v12;
        arg21[7] = v13;
        arg21[8] = v14;
        arg21[9] = v15;
        arg21[10] = v16;
        arg21[11] = v17;
        arg21[12] = v18;
        arg21[13] = v19;
        arg21[14] = v20;
        arg21[15] = v1;
    }

    private static final void preTranslate-cG2Xzmc(float[] arg6, float arg7, float arg8, float[] arg9) {
        Matrix.reset-impl(arg9);
        Matrix.translate-impl$default(arg9, arg7, arg8, 0f, 4, null);
        AndroidComposeView_androidKt.preTransform-JiSxe2E(arg6, arg9);
    }

    public static final void setPlatformTextInputServiceInterceptor(Function1 arg0) {
        AndroidComposeView_androidKt.platformTextInputServiceInterceptor = arg0;
    }
}

