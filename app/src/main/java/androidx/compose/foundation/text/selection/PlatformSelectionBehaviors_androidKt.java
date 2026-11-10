package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.os.Build$VERSION;
import androidx.compose.foundation.text.contextmenu.ProcessText_androidKt;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1={"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A!\u0010\u0014\u001A\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001A\u00020\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\fH\u0001¢\u0006\u0002\u0010\u0017\u001A#\u0010\u0018\u001A\u00020\u0019*\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0002¢\u0006\u0004\b\u001F\u0010 \u001AX\u0010!\u001A\u00020\"*\u00020#2\u0006\u0010$\u001A\u00020\n2\u0006\u0010%\u001A\u00020\u00192\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\b\u0010&\u001A\u0004\u0018\u00010\r2\u0017\u0010\'\u001A\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\"0(¢\u0006\u0002\b)H\u0000¢\u0006\u0002\b*\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"F\u0010\b\u001A$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\t8\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006+"}, d2={"LocalTextClassifierCoroutineContext", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkotlin/coroutines/CoroutineContext;", "getLocalTextClassifierCoroutineContext", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "TEXT_CLASSIFIER_INITIALIZATION_TIMEOUT_MILLIS", "", "TEXT_CLASSIFICATION_TIMEOUT_MILLIS", "PlatformSelectionBehaviorsFactory", "Lkotlin/Function4;", "Landroid/content/Context;", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "Landroidx/compose/ui/text/intl/LocaleList;", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviorsFactory$annotations", "()V", "getPlatformSelectionBehaviorsFactory", "()Lkotlin/jvm/functions/Function4;", "setPlatformSelectionBehaviorsFactory", "(Lkotlin/jvm/functions/Function4;)V", "rememberPlatformSelectionBehaviors", "selectedTextType", "localeList", "(Landroidx/compose/foundation/text/selection/SelectedTextType;Landroidx/compose/ui/text/intl/LocaleList;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "canReuse", "", "Landroidx/compose/foundation/text/selection/TextClassificationResult;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "canReuse-h5sm0ck", "(Landroidx/compose/foundation/text/selection/TextClassificationResult;Ljava/lang/CharSequence;J)Z", "addPlatformTextContextMenuItems", "", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "context", "editable", "platformSelectionBehaviors", "child", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "addPlatformTextContextMenuItems-71BSaZU", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PlatformSelectionBehaviors_androidKt {
    private static final ProvidableCompositionLocal LocalTextClassifierCoroutineContext = null;
    private static Function4 PlatformSelectionBehaviorsFactory = null;
    private static final long TEXT_CLASSIFICATION_TIMEOUT_MILLIS = 200;
    private static final long TEXT_CLASSIFIER_INITIALIZATION_TIMEOUT_MILLIS = 300;

    static {
        PlatformSelectionBehaviors_androidKt.LocalTextClassifierCoroutineContext = CompositionLocalKt.staticCompositionLocalOf(new PlatformSelectionBehaviors_androidKt$$ExternalSyntheticLambda0());
        PlatformSelectionBehaviors_androidKt.PlatformSelectionBehaviorsFactory = new PlatformSelectionBehaviors_androidKt$$ExternalSyntheticLambda1();
    }

    static final CoroutineContext LocalTextClassifierCoroutineContext$lambda$0() {
        return Dispatchers.getIO();
    }

    static final PlatformSelectionBehaviorsImpl PlatformSelectionBehaviorsFactory$lambda$0(CoroutineContext arg1, Context arg2, SelectedTextType arg3, LocaleList arg4) {
        return new PlatformSelectionBehaviorsImpl(arg1, arg2, arg3, arg4);
    }

    public static final boolean access$canReuse-h5sm0ck(TextClassificationResult arg0, CharSequence arg1, long arg2) {
        return PlatformSelectionBehaviors_androidKt.canReuse-h5sm0ck(arg0, arg1, arg2);
    }

    public static final void addPlatformTextContextMenuItems-71BSaZU(TextContextMenuBuilderScope arg7, Context arg8, boolean arg9, CharSequence arg10, TextRange arg11, PlatformSelectionBehaviors arg12, Function1 arg13) {
        if(Build$VERSION.SDK_INT >= 28 && arg10 != null && arg11 != null && arg12 != null) {
            if(!(arg12 instanceof PlatformSelectionBehaviorsImpl)) {
            }
            else {
                arg12.addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation(arg7, arg10, arg11.unbox-impl(), arg13);
                ProcessText_androidKt.addProcessedTextContextMenuItems-UAq72N0(arg7, arg8, arg9, arg10, arg11.unbox-impl());
                return;
            }
        }

        arg13.invoke(arg7);
        if(arg10 != null && arg11 != null) {
            ProcessText_androidKt.addProcessedTextContextMenuItems-UAq72N0(arg7, arg8, arg9, arg10, arg11.unbox-impl());
        }
    }

    private static final boolean canReuse-h5sm0ck(TextClassificationResult arg2, CharSequence arg3, long arg4) {
        if((TextRange.equals-impl0(arg4, arg2.getSelection-d9O1mEE())) && (Intrinsics.areEqual(arg3, arg2.getText()))) {
            return 1;
        }

        return 0;
    }

    public static final ProvidableCompositionLocal getLocalTextClassifierCoroutineContext() {
        return PlatformSelectionBehaviors_androidKt.LocalTextClassifierCoroutineContext;
    }

    public static final Function4 getPlatformSelectionBehaviorsFactory() {
        return PlatformSelectionBehaviors_androidKt.PlatformSelectionBehaviorsFactory;
    }

    public static void getPlatformSelectionBehaviorsFactory$annotations() {
    }

    public static final PlatformSelectionBehaviors rememberPlatformSelectionBehaviors(SelectedTextType arg7, LocaleList arg8, Composer arg9, int arg10) {
        int v0 = 430530635;
        arg9.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg9, "C(rememberPlatformSelectionBehaviors)N(selectedTextType,localeList)100@4598L7,101@4669L7,102@4688L172:PlatformSelectionBehaviors.android.kt#eksfi3");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg10, -1, "androidx.compose.foundation.text.selection.rememberPlatformSelectionBehaviors (PlatformSelectionBehaviors.android.kt:95)");
        }

        if(Build$VERSION.SDK_INT < 28) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg9.endReplaceGroup();
            return null;
        }

        ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_2 = arg9.consume(((CompositionLocal)v0_1));
        ComposerKt.sourceInformationMarkerEnd(arg9);
        ProvidableCompositionLocal v3 = PlatformSelectionBehaviors_androidKt.LocalTextClassifierCoroutineContext;
        ComposerKt.sourceInformationMarkerStart(arg9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1 = arg9.consume(((CompositionLocal)v3));
        ComposerKt.sourceInformationMarkerEnd(arg9);
        ComposerKt.sourceInformationMarkerStart(arg9, 1423092631, "CC(remember):PlatformSelectionBehaviors.android.kt#9igjgp");
        int v2 = arg9.changed(v1) | arg9.changed(v0_2);
        int v4 = 0;
        int v6 = 4;
        int v3_1 = (arg10 & 14 ^ 6) > v6 && (arg9.changed(arg7.ordinal())) || (arg10 & 6) == v6 ? 1 : 0;
        v2 |= v3_1;
        v6 = 0x20;
        if((arg10 & 0x70 ^ 0x30) > v6 && (arg9.changed(arg8)) || (arg10 & 0x30) == v6) {
            v4 = 1;
        }

        arg10 = v2 | v4;
        Object v2_1 = arg9.rememberedValue();
        if(arg10 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            v2_1 = PlatformSelectionBehaviors_androidKt.PlatformSelectionBehaviorsFactory.invoke(v1, v0_2, arg7, arg8);
            arg9.updateRememberedValue(v2_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg9.endReplaceGroup();
        return ((PlatformSelectionBehaviors)v2_1);
    }

    public static final void setPlatformSelectionBehaviorsFactory(Function4 arg0) {
        PlatformSelectionBehaviors_androidKt.PlatformSelectionBehaviorsFactory = arg0;
    }
}

