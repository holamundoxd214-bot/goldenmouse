package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.view.textclassifier.TextClassification$Request$Builder;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.sync.Mutex$DefaultImpls;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1={"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\"\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u001EH\u0096@¢\u0006\u0004\b\"\u0010#J \u0010$\u001A\u00020%2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u001EH\u0082@¢\u0006\u0004\b&\u0010#J*\u0010\'\u001A\u00020%2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u001E2\b\u0010(\u001A\u0004\u0018\u00010)H\u0096@¢\u0006\u0004\b*\u0010+J \u0010,\u001A\u00020%2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u001EH\u0096@¢\u0006\u0004\b-\u0010#J(\u0010.\u001A\u00020%2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u001E2\u0006\u0010/\u001A\u00020\u000FH\u0082@¢\u0006\u0004\b0\u00101J<\u00104\u001A\u00020%*\u0002052\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u001E2\u0017\u00106\u001A\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020%07¢\u0006\u0002\b8H\u0000¢\u0006\u0004\b9\u0010:J\u001F\u0010;\u001A\u0004\u0018\u00010<2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u001E¢\u0006\u0004\b=\u0010>J?\u0010?\u001A\u0004\u0018\u0001H@\"\u0004\b\u0000\u0010@2\'\u0010A\u001A#\b\u0001\u0012\u0004\u0012\u00020\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u0002H@0C\u0012\u0006\u0012\u0004\u0018\u0001030B¢\u0006\u0002\b8H\u0082@¢\u0006\u0002\u0010DR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R/\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u00118B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001A\u00020\u001A8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u000E\u00102\u001A\u000203X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2={"Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviorsImpl;", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "context", "Landroid/content/Context;", "selectedTextType", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroid/content/Context;Landroidx/compose/foundation/text/selection/SelectedTextType;Landroidx/compose/ui/text/intl/LocaleList;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "textClassificationSession", "Landroid/view/textclassifier/TextClassifier;", "<set-?>", "Landroidx/compose/foundation/text/selection/TextClassificationResult;", "textClassificationResult", "getTextClassificationResult", "()Landroidx/compose/foundation/text/selection/TextClassificationResult;", "setTextClassificationResult", "(Landroidx/compose/foundation/text/selection/TextClassificationResult;)V", "textClassificationResult$delegate", "Landroidx/compose/runtime/MutableState;", "androidLocalList", "Landroid/os/LocaleList;", "getAndroidLocalList", "()Landroid/os/LocaleList;", "suggestSelectionForLongPressOrDoubleClick", "Landroidx/compose/ui/text/TextRange;", "text", "", "selection", "suggestSelectionForLongPressOrDoubleClick-pYaCw-w", "(Ljava/lang/CharSequence;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowContextMenuOrSelectionToolbar", "", "onShowContextMenuOrSelectionToolbar-Sb-Bc2M", "onShowContextMenu", "secondaryClickLocation", "Landroidx/compose/ui/geometry/Offset;", "onShowContextMenu-_2OEclM", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/geometry/Offset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowSelectionToolbar", "onShowSelectionToolbar-Sb-Bc2M", "classifyText", "textClassifier", "classifyText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AssistantItemKey", "", "addSmartSelectionTextContextMenuItems", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", "child", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation", "(Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;Ljava/lang/CharSequence;JLkotlin/jvm/functions/Function1;)V", "tryGetTextClassification", "Landroid/view/textclassifier/TextClassification;", "tryGetTextClassification-FDrldGo", "(Ljava/lang/CharSequence;J)Landroid/view/textclassifier/TextClassification;", "requireTextClassificationSession", "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformSelectionBehaviorsImpl implements PlatformSelectionBehaviors {
    public static final int $stable = 8;
    private final Object AssistantItemKey;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final LocaleList localeList;
    private final Mutex mutex;
    private final SelectedTextType selectedTextType;
    private final MutableState textClassificationResult$delegate;
    private TextClassifier textClassificationSession;

    static {
    }

    public PlatformSelectionBehaviorsImpl(CoroutineContext arg1, Context arg2, SelectedTextType arg3, LocaleList arg4) {
        super();
        this.coroutineContext = arg1;
        this.context = arg2;
        this.selectedTextType = arg3;
        this.localeList = arg4;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.textClassificationResult$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.AssistantItemKey = new Object();
    }

    public static final Object access$classifyText-M8tDOmk(PlatformSelectionBehaviorsImpl arg0, CharSequence arg1, long arg2, TextClassifier arg4, Continuation arg5) {
        return arg0.classifyText-M8tDOmk(arg1, arg2, arg4, arg5);
    }

    public static final android.os.LocaleList access$getAndroidLocalList(PlatformSelectionBehaviorsImpl arg0) {
        return arg0.getAndroidLocalList();
    }

    public static final Context access$getContext$p(PlatformSelectionBehaviorsImpl arg0) {
        return arg0.context;
    }

    public static final Mutex access$getMutex$p(PlatformSelectionBehaviorsImpl arg0) {
        return arg0.mutex;
    }

    public static final SelectedTextType access$getSelectedTextType$p(PlatformSelectionBehaviorsImpl arg0) {
        return arg0.selectedTextType;
    }

    public static final TextClassifier access$getTextClassificationSession$p(PlatformSelectionBehaviorsImpl arg0) {
        return arg0.textClassificationSession;
    }

    public static final Object access$onShowContextMenuOrSelectionToolbar-Sb-Bc2M(PlatformSelectionBehaviorsImpl arg0, CharSequence arg1, long arg2, Continuation arg4) {
        return arg0.onShowContextMenuOrSelectionToolbar-Sb-Bc2M(arg1, arg2, arg4);
    }

    public static final Object access$requireTextClassificationSession(PlatformSelectionBehaviorsImpl arg0, Function2 arg1, Continuation arg2) {
        return arg0.requireTextClassificationSession(arg1, arg2);
    }

    public static final void access$setTextClassificationResult(PlatformSelectionBehaviorsImpl arg0, TextClassificationResult arg1) {
        arg0.setTextClassificationResult(arg1);
    }

    public static final void access$setTextClassificationSession$p(PlatformSelectionBehaviorsImpl arg0, TextClassifier arg1) {
        arg0.textClassificationSession = arg1;
    }

    public final void addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation(TextContextMenuBuilderScope arg2, CharSequence arg3, long arg4, Function1 arg6) {
        TextClassification v3 = this.tryGetTextClassification-FDrldGo(arg3, arg4);
        if(v3 == null) {
            arg6.invoke(arg2);
            return;
        }

        int v5 = 0;
        if(!v3.getActions().isEmpty()) {
            TextContextMenuBuilderScope_androidKt.textClassificationItem(arg2, this.AssistantItemKey, v3, 0);
        }
        else if(TextClassifierHelperMethods.INSTANCE.hasLegacyAssistItem$foundation(v3)) {
            TextContextMenuBuilderScope_androidKt.textClassificationItem(arg2, this.AssistantItemKey, v3, -1);
        }

        arg6.invoke(arg2);
        List v4 = v3.getActions();
        int v6 = v4.size();
        while(v5 < v6) {
            v4.get(v5);
            if(v5 > 0) {
                TextContextMenuBuilderScope_androidKt.textClassificationItem(arg2, this.AssistantItemKey, v3, v5);
            }

            ++v5;
        }
    }

    private final Object classifyText-M8tDOmk(CharSequence arg21, long arg22, TextClassifier arg24, Continuation arg25) {
        long v14;
        Object v13;
        Object v6;
        long v8;
        Mutex v5_2;
        Unit v0_2;
        PlatformSelectionBehaviorsImpl$classifyText$1 v2_1;
        int v4;
        PlatformSelectionBehaviorsImpl v0 = this;
        Continuation v1 = arg25;
        if((v1 instanceof PlatformSelectionBehaviorsImpl$classifyText$1)) {
            Continuation v2 = v1;
            v4 = 0x80000000;
            if((((PlatformSelectionBehaviorsImpl$classifyText$1)v2).label & v4) != 0) {
                ((PlatformSelectionBehaviorsImpl$classifyText$1)v2).label -= v4;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v2_1 = new PlatformSelectionBehaviorsImpl$classifyText$1(v0, v1);
        }

        Object v1_1 = v2_1.result;
        Object v3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v4 = v2_1.label;
        int v5 = 2;
        Object v7 = null;
        if(v4 == 0) {
            ResultKt.throwOnFailure(v1_1);
            Mutex v4_2 = v0.mutex;
            CharSequence v1_2 = arg21;
            v2_1.L$0 = v1_2;
            TextClassifier v8_1 = arg24;
            v2_1.L$1 = v8_1;
            v2_1.L$2 = v4_2;
            long v9 = arg22;
            v2_1.J$0 = v9;
            v2_1.label = 1;
            if(v4_2.lock(v7, ((Continuation)v2_1)) == v3) {
                return v3;
            }
            else {
                long v18 = v9;
                TextClassifier v10_1 = v8_1;
                v8 = v18;
                CharSequence v11_1 = v1_2;
                try {
                label_60:
                    TextClassificationResult v1_3 = v0.getTextClassificationResult();
                    if(v1_3 != null && (PlatformSelectionBehaviors_androidKt.access$canReuse-h5sm0ck(v1_3, v11_1, v8))) {
                        v0_2 = Unit.INSTANCE;
                        goto label_65;
                    }

                    goto label_67;
                }
                catch(Throwable v0_1) {
                    goto label_102;
                }

            label_65:
                v4_2.unlock(v7);
                return v0_2;
            label_67:
                goto label_68;
            label_102:
                v4_2.unlock(v7);
                throw v0_1;
            label_68:
                v4_2.unlock(v7);
                TextClassification v6_1 = v10_1.classifyText(new TextClassification$Request$Builder(v11_1, TextRange.getMin-impl(v8), TextRange.getMax-impl(v8)).setDefaultLocales(v0.getAndroidLocalList()).build());
                Mutex v1_4 = v0.mutex;
                v2_1.L$0 = v11_1;
                v2_1.L$1 = v6_1;
                v2_1.L$2 = v1_4;
                v2_1.J$0 = v8;
                v2_1.label = v5;
                if(v1_4.lock(v7, ((Continuation)v2_1)) == v3) {
                    return v3;
                }

                v5_2 = v1_4;
                v14 = v8;
                v13 = v11_1;
            }
        }
        else if(v4 == 1) {
            v8 = v2_1.J$0;
            Object v4_1 = v2_1.L$2;
            Object v10 = v2_1.L$1;
            Object v11 = v2_1.L$0;
            ResultKt.throwOnFailure(v1_1);
            goto label_60;
        }
        else if(v4 == v5) {
            long v3_1 = v2_1.J$0;
            Object v5_1 = v2_1.L$2;
            v6 = v2_1.L$1;
            Object v2_2 = v2_1.L$0;
            ResultKt.throwOnFailure(v1_1);
            v13 = v2_2;
            v14 = v3_1;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        Object v16 = v6;
        try {
            v0.setTextClassificationResult(new TextClassificationResult(((CharSequence)v13), v14, ((TextClassification)v16), null));
        }
        catch(Throwable v0_1) {
            v5_2.unlock(v7);
            throw v0_1;
        }

        v5_2.unlock(v7);
        return Unit.INSTANCE;
    }

    private final android.os.LocaleList getAndroidLocalList() {
        LocaleList v3 = this.localeList;
        if(v3 != null) {
            android.os.LocaleList v3_1 = TextClassifierHelperMethods.INSTANCE.toAndroidLocaleList(v3);
            if(v3_1 == null) {
            }
            else {
                return v3_1;
            }
        }

        return new android.os.LocaleList(new Locale[]{androidx.compose.ui.text.intl.Locale.Companion.getCurrent().getPlatformLocale()});
    }

    private final TextClassificationResult getTextClassificationResult() {
        return this.textClassificationResult$delegate.getValue();
    }

    public Object onShowContextMenu-_2OEclM(CharSequence arg1, long arg2, Offset arg4, Continuation arg5) {
        Object v0 = this.onShowContextMenuOrSelectionToolbar-Sb-Bc2M(arg1, arg2, arg5);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    private final Object onShowContextMenuOrSelectionToolbar-Sb-Bc2M(CharSequence arg7, long arg8, Continuation arg10) {
        if(arg7.length() == 0) {
        }
        else {
            if(TextRange.getCollapsed-impl(arg8)) {
                goto label_5;
            }

            goto label_7;
        }

    label_5:
        return Unit.INSTANCE;
    label_7:
        return this.requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$onShowContextMenuOrSelectionToolbar$2(this, arg7, arg8, null), arg10);
    }

    public Object onShowSelectionToolbar-Sb-Bc2M(CharSequence arg1, long arg2, Continuation arg4) {
        Object v0 = this.onShowContextMenuOrSelectionToolbar-Sb-Bc2M(arg1, arg2, arg4);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    private final Object requireTextClassificationSession(Function2 arg4, Continuation arg5) {
        return BuildersKt.withContext(this.coroutineContext, new PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2(this, arg4, null), arg5);
    }

    private final void setTextClassificationResult(TextClassificationResult arg1) {
        this.textClassificationResult$delegate.setValue(arg1);
    }

    public Object suggestSelectionForLongPressOrDoubleClick-pYaCw-w(CharSequence arg7, long arg8, Continuation arg10) {
        if(arg7.length() == 0) {
        }
        else {
            if(TextRange.getCollapsed-impl(arg8)) {
                return null;
            }

            goto label_7;
        }

        return null;
    label_7:
        return this.requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(arg7, arg8, this, null), arg10);
    }

    public final TextClassification tryGetTextClassification-FDrldGo(CharSequence arg4, long arg5) {
        Object v1 = null;
        if(!DefaultImpls.tryLock$default(this.mutex, v1, 1, v1)) {
            return ((TextClassification)v1);
        }

        TextClassificationResult v0 = this.getTextClassificationResult();
        TextClassification v4 = v0 == null || !PlatformSelectionBehaviors_androidKt.access$canReuse-h5sm0ck(v0, arg4, arg5) ? ((TextClassification)v1) : v0.getTextClassification();
        DefaultImpls.unlock$default(this.mutex, v1, 1, v1);
        return v4;
    }
}

