package androidx.compose.foundation.text;

import android.content.Context;
import android.os.Looper;
import android.provider.Settings$System;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001A\r\u0010\u0002\u001A\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001A\b\u0010\u0010\u001A\u00020\u0011H\u0001\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"0\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0012²\u0006\n\u0010\u0013\u001A\u00020\u0003X\u008A\u008E\u0002"}, d2={"TAG", "", "platformAllowsRevealLastTyped", "", "(Landroidx/compose/runtime/Composer;I)Z", "DefaultContentResolverForSecureTextField", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroidx/compose/foundation/text/ContentResolverForSecureTextField;", "contentResolverForSecureTextField", "getContentResolverForSecureTextField$annotations", "()V", "getContentResolverForSecureTextField", "()Lkotlin/jvm/functions/Function1;", "setContentResolverForSecureTextField", "(Lkotlin/jvm/functions/Function1;)V", "resetContentResolverForSecureTextField", "", "foundation", "state"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicSecureTextField_androidKt {
    private static final Function1 DefaultContentResolverForSecureTextField = null;
    private static final String TAG = "BasicSecureTextField";
    private static Function1 contentResolverForSecureTextField;

    public static DisposableEffectResult $r8$lambda$IbjGVD23B0Wop_yqMmqkvJ5BX78(ContentResolverForSecureTextField arg0, BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1 arg1, DisposableEffectScope arg2) {
        return BasicSecureTextField_androidKt.platformAllowsRevealLastTyped$lambda$5$0(arg0, arg1, arg2);
    }

    static {
        BasicSecureTextField_androidKt$$ExternalSyntheticLambda1 v0 = new BasicSecureTextField_androidKt$$ExternalSyntheticLambda1();
        BasicSecureTextField_androidKt.DefaultContentResolverForSecureTextField = ((Function1)v0);
        BasicSecureTextField_androidKt.contentResolverForSecureTextField = ((Function1)v0);
    }

    static final BasicSecureTextField_androidKt$DefaultContentResolverForSecureTextField$1$1 DefaultContentResolverForSecureTextField$lambda$0(Context arg1) {
        return new BasicSecureTextField_androidKt$DefaultContentResolverForSecureTextField$1$1(arg1.getContentResolver());
    }

    public static final void access$platformAllowsRevealLastTyped$lambda$3(MutableState arg0, boolean arg1) {
        BasicSecureTextField_androidKt.platformAllowsRevealLastTyped$lambda$3(arg0, arg1);
    }

    public static final Function1 getContentResolverForSecureTextField() {
        return BasicSecureTextField_androidKt.contentResolverForSecureTextField;
    }

    public static void getContentResolverForSecureTextField$annotations() {
    }

    public static final boolean platformAllowsRevealLastTyped(Composer arg4, int arg5) {
        BasicSecureTextField_androidKt$$ExternalSyntheticLambda0 v2_2;
        BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1 v3_1;
        MutableState v0_3;
        int v1 = -1015272320;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(platformAllowsRevealLastTyped)39@1443L7,41@1478L119,44@1615L60,46@1711L263,53@2024L242,53@1979L287:BasicSecureTextField.android.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.text.platformAllowsRevealLastTyped (BasicSecureTextField.android.kt:38)");
        }

        ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        Function1 v0 = BasicSecureTextField_androidKt.contentResolverForSecureTextField;
        String v2 = "CC(remember):BasicSecureTextField.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg4, 0xD5231B17, v2);
        int v0_1 = arg4.changed(v0) | arg4.changed(v5_1);
        Object v1_1 = arg4.rememberedValue();
        if(v0_1 != 0 || v1_1 == Composer.Companion.getEmpty()) {
            v1_1 = BasicSecureTextField_androidKt.contentResolverForSecureTextField.invoke(v5_1);
            arg4.updateRememberedValue(v1_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        ComposerKt.sourceInformationMarkerStart(arg4, 0xD5232BFC, v2);
        boolean v5_2 = arg4.changed(v1_1);
        Object v0_2 = arg4.rememberedValue();
        if((v5_2) || v0_2 == Composer.Companion.getEmpty()) {
            v0_3 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((ContentResolverForSecureTextField)v1_1).getShowPassword()), null, 2, null);
            arg4.updateRememberedValue(v0_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        ComposerKt.sourceInformationMarkerStart(arg4, 0xD52338C7, v2);
        v5_2 = arg4.changed(v1_1);
        Object v3 = arg4.rememberedValue();
        if((v5_2) || v3 == Composer.Companion.getEmpty()) {
            v3_1 = new BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1(((ContentResolverForSecureTextField)v1_1), v0_3, HandlerCompat.createAsync(Looper.getMainLooper()));
            arg4.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        ComposerKt.sourceInformationMarkerStart(arg4, 0xD5235FD2, v2);
        arg5 = arg4.changedInstance(v1_1) | arg4.changedInstance(v3_1);
        Object v2_1 = arg4.rememberedValue();
        if(arg5 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            v2_2 = new BasicSecureTextField_androidKt$$ExternalSyntheticLambda0(((ContentResolverForSecureTextField)v1_1), v3_1);
            arg4.updateRememberedValue(v2_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        EffectsKt.DisposableEffect(v1_1, v3_1, ((Function1)v2_2), arg4, 0);
        v5_2 = BasicSecureTextField_androidKt.platformAllowsRevealLastTyped$lambda$2(v0_3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v5_2;
    }

    private static final boolean platformAllowsRevealLastTyped$lambda$2(MutableState arg0) {
        return ((State)arg0).getValue().booleanValue();
    }

    private static final void platformAllowsRevealLastTyped$lambda$3(MutableState arg0, boolean arg1) {
        arg0.setValue(Boolean.valueOf(arg1));
    }

    private static final DisposableEffectResult platformAllowsRevealLastTyped$lambda$5$0(ContentResolverForSecureTextField arg2, BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1 arg3, DisposableEffectScope arg4) {
        arg2.registerContentObserver(Settings$System.getUriFor("show_password"), false, arg3);
        return new BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$lambda$5$0$$inlined$onDispose$1(arg2, arg3);
    }

    public static final void resetContentResolverForSecureTextField() {
        BasicSecureTextField_androidKt.contentResolverForSecureTextField = BasicSecureTextField_androidKt.DefaultContentResolverForSecureTextField;
    }

    public static final void setContentResolverForSecureTextField(Function1 arg0) {
        BasicSecureTextField_androidKt.contentResolverForSecureTextField = arg0;
    }
}

