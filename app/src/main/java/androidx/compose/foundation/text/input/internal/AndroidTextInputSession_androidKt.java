package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\u001A\u008E\u0001\u0010\u0006\u001A\u00020\u0007*\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0010\b\u0002\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0012\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0012H\u0080@¢\u0006\u0002\u0010\u001C\u001A\u0090\u0001\u0010\u0006\u001A\u00020\u0007*\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0006\u0010\u001D\u001A\u00020\u001E2\u000E\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0012\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0012H\u0081@¢\u0006\u0002\u0010\u001F\u001A \u0010#\u001A\u00020\u00142\b\b\u0002\u0010$\u001A\u00020\u00052\f\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0002\"\u0016\u0010\u0000\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00050!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"¨\u0006&"}, d2={"TIA_DEBUG", "", "getTIA_DEBUG$annotations", "()V", "TIA_TAG", "", "platformSpecificTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "onImeAction", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "", "updateSelectionState", "Lkotlin/Function0;", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "updateTouchMode", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/flow/MutableSharedFlow;Landroidx/compose/ui/platform/ViewConfiguration;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "(Landroidx/compose/ui/platform/PlatformTextInputSession;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/flow/MutableSharedFlow;Landroidx/compose/ui/platform/ViewConfiguration;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ALL_MIME_TYPES", "", "[Ljava/lang/String;", "logDebug", "tag", "content", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidTextInputSession_androidKt {
    private static final String[] ALL_MIME_TYPES = null;
    public static final boolean TIA_DEBUG = false;
    private static final String TIA_TAG = "AndroidTextInputSession";

    static {
        AndroidTextInputSession_androidKt.ALL_MIME_TYPES = new String[]{"*/*", "image/*", "video/*"};
    }

    public static final String[] access$getALL_MIME_TYPES$p() {
        return AndroidTextInputSession_androidKt.ALL_MIME_TYPES;
    }

    public static void getTIA_DEBUG$annotations() {
    }

    private static final void logDebug(String arg0, Function0 arg1) {
    }

    static void logDebug$default(String arg0, Function0 arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg0 = "AndroidTextInputSession";
        }

        AndroidTextInputSession_androidKt.logDebug(arg0, arg1);
    }

    public static final Object platformSpecificTextInputSession(PlatformTextInputSession arg18, TransformedTextFieldState arg19, TextLayoutState arg20, ImeOptions arg21, ReceiveContentConfiguration arg22, Function1 arg23, Function0 arg24, ComposeInputMethodManager arg25, MutableSharedFlow arg26, ViewConfiguration arg27, Function1 arg28, Continuation arg29) {
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 v1_1;
        int v3;
        Continuation v0 = arg29;
        if((v0 instanceof AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2)) {
            Continuation v1 = v0;
            v3 = 0x80000000;
            if((((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2)v1).label & v3) != 0) {
                ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_1 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2(v0);
        }

        Object v0_1 = v1_1.result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = v1_1.label;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3 v5 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3(arg26, arg19, arg20, arg25, arg18, arg21, arg22, arg23, arg24, arg27, arg28, null);
            v1_1.label = 1;
            if(CoroutineScopeKt.coroutineScope(((Function2)v5), ((Continuation)v1_1)) == v2) {
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

    public static final Object platformSpecificTextInputSession(PlatformTextInputSession arg14, TransformedTextFieldState arg15, TextLayoutState arg16, ImeOptions arg17, ReceiveContentConfiguration arg18, Function1 arg19, Function0 arg20, MutableSharedFlow arg21, ViewConfiguration arg22, Function1 arg23, Continuation arg24) {
        Continuation v1;
        Continuation v0 = arg24;
        if((v0 instanceof AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1)) {
            v1 = v0;
            int v3 = 0x80000000;
            if((((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1)v1).label & v3) != 0) {
                ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 v1_1 = new AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1(v0);
        }

        Continuation v13 = v1;
        Object v0_1 = ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1)v13).result;
        Object v1_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v2 = ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1)v13).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v0_1);
            ComposeInputMethodManager v9 = ComposeInputMethodManager_androidKt.ComposeInputMethodManager(arg14.getView());
            ((AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1)v13).label = 1;
            if(AndroidTextInputSession_androidKt.platformSpecificTextInputSession(arg14, arg15, arg16, arg17, arg18, arg19, arg20, v9, arg21, arg22, arg23, v13) == v1_2) {
                return v1_2;
            }
        }
        else if(v2 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            ResultKt.throwOnFailure(v0_1);
        }

        throw new KotlinNothingValueException();
    }

    public static Object platformSpecificTextInputSession$default(PlatformTextInputSession arg1, TransformedTextFieldState arg2, TextLayoutState arg3, ImeOptions arg4, ReceiveContentConfiguration arg5, Function1 arg6, Function0 arg7, MutableSharedFlow arg8, ViewConfiguration arg9, Function1 arg10, Continuation arg11, int arg12, Object arg13) {
        Function0 v0 = null;
        if((arg12 & 0x20) != 0) {
            arg7 = v0;
        }

        if((arg12 & 0x40) != 0) {
            arg8 = ((MutableSharedFlow)v0);
        }

        if((arg12 & 0x80) != 0) {
            arg9 = ((ViewConfiguration)v0);
        }

        return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }
}

