package androidx.compose.ui.contentcapture;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.LongSparseArray;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest$Builder;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u0002:\u0006\u0082\u0001\u0083\u0001\u0084\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u000E\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u00106\u001A\u00020\"2\u0006\u00107\u001A\u000208H\u0016J\u0010\u00109\u001A\u00020\"2\u0006\u00107\u001A\u000208H\u0016J\u0010\u0010=\u001A\u00020\"2\u0006\u0010>\u001A\u00020?H\u0016J\u0010\u0010@\u001A\u00020\"2\u0006\u0010>\u001A\u00020?H\u0016J\u0010\u0010A\u001A\u00020\"H\u0080@¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001A\u00020\"H\u0000¢\u0006\u0002\bEJ\r\u0010F\u001A\u00020\"H\u0000¢\u0006\u0002\bGJ\b\u0010H\u001A\u00020\"H\u0002J\u0018\u0010I\u001A\u00020\"2\u0006\u0010J\u001A\u00020K2\u0006\u0010L\u001A\u000201H\u0002J\u0016\u0010M\u001A\u00020\"2\f\u0010N\u001A\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0018\u0010O\u001A\u00020\"2\u0006\u0010P\u001A\u00020Q2\u0006\u0010R\u001A\u00020SH\u0002J\b\u0010T\u001A\u00020\"H\u0002J\b\u0010U\u001A\u00020\"H\u0002J\u0016\u0010V\u001A\u0004\u0018\u00010W*\u00020K2\u0006\u0010X\u001A\u00020QH\u0002J&\u0010Y\u001A\u00020\"*\u00020K2\u0018\u0010Z\u001A\u0014\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\"0[H\u0002JG\u0010\\\u001A\u00020\"\"\u0004\b\u0000\u0010]*\b\u0012\u0004\u0012\u0002H]0^2\u0018\u0010Z\u001A\u0014\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u0002H]\u0012\u0004\u0012\u00020\"0[2\u0012\u0010_\u001A\u000E\u0012\u0004\u0012\u0002H]\u0012\u0004\u0012\u00020\u001F0`H\u0082\bJ\u001A\u0010a\u001A\u00020\"2\u0006\u0010b\u001A\u00020Q2\b\u0010c\u001A\u0004\u0018\u00010WH\u0002J\u0010\u0010d\u001A\u00020\"2\u0006\u0010b\u001A\u00020QH\u0002J\b\u0010e\u001A\u00020\"H\u0002J\u0018\u0010f\u001A\u00020\"2\u0006\u0010X\u001A\u00020Q2\u0006\u0010g\u001A\u00020KH\u0002J\u0010\u0010h\u001A\u00020\"2\u0006\u0010g\u001A\u00020KH\u0002J\u0010\u0010i\u001A\u00020\"2\u0006\u0010g\u001A\u00020KH\u0002J\r\u0010j\u001A\u00020\"H\u0000¢\u0006\u0002\bkJ\r\u0010l\u001A\u00020\"H\u0000¢\u0006\u0002\bmJ\r\u0010n\u001A\u00020\"H\u0000¢\u0006\u0002\boJ\b\u0010p\u001A\u00020\"H\u0002J\b\u0010q\u001A\u00020\"H\u0002J\b\u0010r\u001A\u00020\"H\u0002J-\u0010s\u001A\u00020\"2\u0006\u0010t\u001A\u00020u2\u0006\u0010v\u001A\u00020w2\u000E\u0010x\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010z0yH\u0001¢\u0006\u0002\b{J\'\u0010|\u001A\u00020\"2\u0006\u0010}\u001A\u00020\u00002\u000F\u0010~\u001A\u000B\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010\u007FH\u0001¢\u0006\u0003\b\u0081\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\"\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR&\u0010\u0010\u001A\u0004\u0018\u00010\u00078\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010 \u001A\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001A\u00020$X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\"\u0010\'\u001A\b\u0012\u0004\u0012\u00020)0(8@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000E\u0010.\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010/\u001A\b\u0012\u0004\u0012\u00020100X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00102\u001A\u000201X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00103\u001A\u00020\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00104\u001A\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001A\u00020\u001F8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b;\u0010<¨\u0006\u0085\u0001"}, d2={"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/view/View$OnAttachStateChangeListener;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "onContentCaptureSession", "Lkotlin/Function0;", "Landroidx/compose/ui/contentcapture/ContentCaptureSessionWrapper;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function0;)V", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "getOnContentCaptureSession", "()Lkotlin/jvm/functions/Function0;", "setOnContentCaptureSession", "(Lkotlin/jvm/functions/Function0;)V", "contentCaptureSession", "getContentCaptureSession$ui$annotations", "()V", "getContentCaptureSession$ui", "()Landroidx/compose/ui/contentcapture/ContentCaptureSessionWrapper;", "setContentCaptureSession$ui", "(Landroidx/compose/ui/contentcapture/ContentCaptureSessionWrapper;)V", "bufferedEvents", "", "Landroidx/compose/ui/contentcapture/ContentCaptureEvent;", "SendRecurringContentCaptureEventsIntervalMillis", "", "translateStatus", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "currentSemanticsNodesInvalidated", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "handler", "Landroid/os/Handler;", "getHandler$ui", "()Landroid/os/Handler;", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes$ui", "()Landroidx/collection/IntObjectMap;", "setCurrentSemanticsNodes$ui", "(Landroidx/collection/IntObjectMap;)V", "currentSemanticsNodesSnapshotTimestampMillis", "previousSemanticsNodes", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "checkingForSemanticsChanges", "contentCaptureChangeChecker", "Ljava/lang/Runnable;", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "isEnabled", "isEnabled$ui", "()Z", "onStart", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSemanticsChange", "onSemanticsChange$ui", "onLayoutChange", "onLayoutChange$ui", "sendContentCaptureDisappearEvents", "sendContentCaptureAppearEvents", "newNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "oldNode", "checkForContentCapturePropertyChanges", "newSemanticsNodes", "sendContentCaptureTextUpdateEvent", "id", "", "newText", "", "updateSemanticsCopy", "notifySubtreeStateChangeIfNeeded", "toViewStructure", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "index", "fastForEachReplacedVisibleChildren", "action", "Lkotlin/Function2;", "fastForEachIndexedWithFilter", "T", "", "predicate", "Lkotlin/Function1;", "bufferContentCaptureViewAppeared", "virtualId", "viewStructure", "bufferContentCaptureViewDisappeared", "notifyContentCaptureChanges", "updateBuffersOnAppeared", "node", "updateBuffersOnDisappeared", "updateTranslationOnAppeared", "onShowTranslation", "onShowTranslation$ui", "onHideTranslation", "onHideTranslation$ui", "onClearTranslation", "onClearTranslation$ui", "showTranslatedText", "hideTranslatedText", "clearTranslatedText", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onCreateVirtualViewTranslationRequests$ui", "onVirtualViewTranslationResponses", "contentCaptureManager", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onVirtualViewTranslationResponses$ui", "TranslateStatus", "ViewTranslationHelperMethods", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidContentCaptureManager implements View$OnAttachStateChangeListener, DefaultLifecycleObserver {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$Companion;", "", "<init>", "()V", "VIEW_STRUCTURE_BUNDLE_KEY_TIMESTAMP", "", "VIEW_STRUCTURE_BUNDLE_KEY_ADDITIONAL_INDEX", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW_ORIGINAL", "SHOW_TRANSLATED", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) enum TranslateStatus {
        public static final enum TranslateStatus SHOW_ORIGINAL;
        public static final enum TranslateStatus SHOW_TRANSLATED;

        private static final TranslateStatus[] $values() {
            return new TranslateStatus[]{TranslateStatus.SHOW_ORIGINAL, TranslateStatus.SHOW_TRANSLATED};
        }

        static {
            TranslateStatus.SHOW_ORIGINAL = new TranslateStatus("SHOW_ORIGINAL", 0);
            TranslateStatus.SHOW_TRANSLATED = new TranslateStatus("SHOW_TRANSLATED", 1);
            TranslateStatus[] v0 = TranslateStatus.$values();
            TranslateStatus.$VALUES = v0;
            TranslateStatus.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private TranslateStatus(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return TranslateStatus.$ENTRIES;
        }

        public static TranslateStatus valueOf(String arg1) {
            return Enum.valueOf(TranslateStatus.class, arg1);
        }

        public static TranslateStatus[] values() {
            return TranslateStatus.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u000E\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\rH\u0007J \u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u000E\u0010\u0010\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0007J \u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u000E\u0010\u0010\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0002¨\u0006\u0014"}, d2={"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$ViewTranslationHelperMethods;", "", "<init>", "()V", "onCreateVirtualViewTranslationRequests", "", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "virtualIds", "", "supportedFormats", "", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "doTranslation", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ViewTranslationHelperMethods {
        public static final ViewTranslationHelperMethods INSTANCE;

        static {
            ViewTranslationHelperMethods.INSTANCE = new ViewTranslationHelperMethods();
        }

        private ViewTranslationHelperMethods() {
            super();
        }

        private final void doTranslation(AndroidContentCaptureManager arg7, LongSparseArray arg8) {
            int v6 = arg8.size();
            int v0;
            for(v0 = 0; v0 < v6; ++v0) {
                long v1 = arg8.keyAt(v0);
                Object v3 = arg8.get(v1);
                if(v3 != null) {
                    TranslationResponseValue v3_1 = ((ViewTranslationResponse)v3).getValue("android:text");
                    if(v3_1 != null) {
                        CharSequence v3_2 = v3_1.getText();
                        if(v3_2 != null) {
                            Object v1_1 = arg7.getCurrentSemanticsNodes$ui().get(((int)v1));
                            if(v1_1 != null) {
                                SemanticsNode v1_2 = ((SemanticsNodeWithAdjustedBounds)v1_1).getSemanticsNode();
                                if(v1_2 != null) {
                                    v1_1 = SemanticsConfigurationKt.getOrNull(v1_2.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetTextSubstitution());
                                    if(v1_1 != null) {
                                        Function v1_3 = ((AccessibilityAction)v1_1).getAction();
                                        if(v1_3 != null) {
                                            ((Function1)v1_3).invoke(new AnnotatedString(v3_2.toString(), null, 2, null));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public final void onCreateVirtualViewTranslationRequests(AndroidContentCaptureManager arg12, long[] arg13, int[] arg14, Consumer arg15) {
            int v11 = arg13.length;
            int v14;
            for(v14 = 0; v14 < v11; ++v14) {
                Object v0 = arg12.getCurrentSemanticsNodes$ui().get(((int)arg13[v14]));
                if(v0 != null) {
                    SemanticsNode v0_1 = ((SemanticsNodeWithAdjustedBounds)v0).getSemanticsNode();
                    if(v0_1 == null) {
                    }
                    else {
                        ViewTranslationRequest$Builder v1 = new ViewTranslationRequest$Builder(arg12.getView().getAutofillId(), ((long)v0_1.getId()));
                        Object v2 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getText());
                        if(v2 != null) {
                            String v0_2 = ListUtilsKt.fastJoinToString$default(((List)v2), "\n", null, null, 0, null, null, 62, null);
                            if(v0_2 != null) {
                                v1.setValue("android:text", TranslationRequestValue.forText(new AnnotatedString(v0_2, null, 2, null)));
                                arg15.accept(v1.build());
                            }
                        }
                    }
                }
            }
        }

        public final void onVirtualViewTranslationResponses(AndroidContentCaptureManager arg3, LongSparseArray arg4) {
            if(Build$VERSION.SDK_INT < 0x1F) {
                return;
            }

            if(Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                this.doTranslation(arg3, arg4);
                return;
            }

            arg3.getView().post(new AndroidContentCaptureManager$ViewTranslationHelperMethods$$ExternalSyntheticLambda0(arg3, arg4));
        }

        static final void onVirtualViewTranslationResponses$lambda$0(AndroidContentCaptureManager arg1, LongSparseArray arg2) {
            ViewTranslationHelperMethods.INSTANCE.doTranslation(arg1, arg2);
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ContentCaptureEventType.values().length];
            try {
                v0[ContentCaptureEventType.VIEW_APPEAR.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ContentCaptureEventType.VIEW_DISAPPEAR.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private long SendRecurringContentCaptureEventsIntervalMillis;
    public static final String VIEW_STRUCTURE_BUNDLE_KEY_ADDITIONAL_INDEX = "android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX";
    public static final String VIEW_STRUCTURE_BUNDLE_KEY_TIMESTAMP = "android.view.contentcapture.EventTimestamp";
    private final Channel boundsUpdateChannel;
    private final List bufferedEvents;
    private boolean checkingForSemanticsChanges;
    private final Runnable contentCaptureChangeChecker;
    private ContentCaptureSessionWrapper contentCaptureSession;
    private IntObjectMap currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private long currentSemanticsNodesSnapshotTimestampMillis;
    private final Handler handler;
    private Function0 onContentCaptureSession;
    private MutableIntObjectMap previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private TranslateStatus translateStatus;
    private final AndroidComposeView view;

    static {
        AndroidContentCaptureManager.Companion = new Companion(null);
        AndroidContentCaptureManager.$stable = 8;
    }

    public AndroidContentCaptureManager(AndroidComposeView arg3, Function0 arg4) {
        super();
        this.view = arg3;
        this.onContentCaptureSession = arg4;
        this.bufferedEvents = new ArrayList();
        this.SendRecurringContentCaptureEventsIntervalMillis = 100;
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        this.currentSemanticsNodesInvalidated = true;
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.handler = new Handler(Looper.getMainLooper());
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(arg3.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.contentCaptureChangeChecker = new AndroidContentCaptureManager$$ExternalSyntheticLambda0(this);
    }

    public static final void access$notifySubtreeStateChangeIfNeeded(AndroidContentCaptureManager arg0) {
        arg0.notifySubtreeStateChangeIfNeeded();
    }

    public static final void access$updateBuffersOnAppeared(AndroidContentCaptureManager arg0, int arg1, SemanticsNode arg2) {
        arg0.updateBuffersOnAppeared(arg1, arg2);
    }

    public final Object boundsUpdatesEventLoop$ui(Continuation arg9) {
        Object v2_1;
        AndroidContentCaptureManager$boundsUpdatesEventLoop$1 v0_1;
        int v2;
        if((arg9 instanceof AndroidContentCaptureManager$boundsUpdatesEventLoop$1)) {
            Continuation v0 = arg9;
            v2 = 0x80000000;
            if((((AndroidContentCaptureManager$boundsUpdatesEventLoop$1)v0).label & v2) != 0) {
                ((AndroidContentCaptureManager$boundsUpdatesEventLoop$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new AndroidContentCaptureManager$boundsUpdatesEventLoop$1(this, arg9);
        }

        Object v9 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            ChannelIterator v9_1 = this.boundsUpdateChannel.iterator();
            goto label_35;
        label_43:
            if(((Boolean)v9).booleanValue()) {
                ((ChannelIterator)v2_1).next();
                if(this.isEnabled$ui()) {
                    this.notifyContentCaptureChanges();
                }

                if(!this.checkingForSemanticsChanges) {
                    this.checkingForSemanticsChanges = true;
                    this.handler.post(this.contentCaptureChangeChecker);
                }

                long v5 = this.SendRecurringContentCaptureEventsIntervalMillis;
                v0_1.L$0 = v2_1;
                v0_1.label = v3;
                if(DelayKt.delay(v5, ((Continuation)v0_1)) != v1) {
                    goto label_23;
                }

                return v1;
            }
            else {
                return Unit.INSTANCE;
            label_35:
                v0_1.L$0 = v9_1;
                v0_1.label = 1;
                v2_1 = v9_1.hasNext(((Continuation)v0_1));
                if(v2_1 == v1) {
                    return v1;
                }

                Object v7 = v2_1;
                v2_1 = v9_1;
                v9 = v7;
                goto label_43;
            }
        }
        else if(v2 == 1) {
            v2_1 = v0_1.L$0;
            ResultKt.throwOnFailure(v9);
            goto label_43;
        }
        else if(v2 == v3) {
            v2_1 = v0_1.L$0;
            ResultKt.throwOnFailure(v9);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_23:
        v9 = v2_1;
        goto label_35;
    }

    private final void bufferContentCaptureViewAppeared(int arg8, ViewStructureCompat arg9) {
        if(arg9 == null) {
            return;
        }

        this.bufferedEvents.add(new ContentCaptureEvent(arg8, this.currentSemanticsNodesSnapshotTimestampMillis, ContentCaptureEventType.VIEW_APPEAR, arg9));
    }

    private final void bufferContentCaptureViewDisappeared(int arg8) {
        this.bufferedEvents.add(new ContentCaptureEvent(arg8, this.currentSemanticsNodesSnapshotTimestampMillis, ContentCaptureEventType.VIEW_DISAPPEAR, null));
    }

    private final void checkForContentCapturePropertyChanges(IntObjectMap arg35) {
        long v32;
        SemanticsNode v31;
        Object v2_2;
        long[] v30;
        int v29;
        int v2_1;
        int v1_1;
        int[] v27;
        long v24;
        long[] v26;
        long v22;
        int v17;
        AndroidContentCaptureManager v0 = this;
        IntObjectMap v1 = arg35;
        int[] v2 = v1.keys;
        long[] v3 = v1.metadata;
        int v4 = v3.length - 2;
        if(v4 >= 0) {
            int v6 = 0;
            while(true) {
                long v7 = v3[v6];
                int v11 = 7;
                long v12 = -9187201950435737472L;
                if((~v7 << v11 & v7 & v12) != v12) {
                    int v10 = 8;
                    int v9 = 8 - (~(v6 - v4) >>> 0x1F);
                    int v14 = 0;
                    while(v14 < v9) {
                        long v15 = 0xFF;
                        long v19 = 0x80;
                        if((v7 & v15) < v19) {
                            int v5 = v2[(v6 << 3) + v14];
                            v17 = v11;
                            Object v11_1 = v0.previousSemanticsNodes.get(v5);
                            Object v5_1 = v1.get(v5);
                            SemanticsNode v21 = null;
                            SemanticsNode v5_2 = v5_1 != null ? ((SemanticsNodeWithAdjustedBounds)v5_1).getSemanticsNode() : v21;
                            if(v5_2 != null) {
                                if(v11_1 == null) {
                                    MutableScatterMap v11_2 = v5_2.getUnmergedConfig$ui().getProps$ui();
                                    v22 = v12;
                                    Object[] v12_1 = ((ScatterMap)v11_2).keys;
                                    long[] v11_3 = ((ScatterMap)v11_2).metadata;
                                    int v13 = v11_3.length - 2;
                                    if(v13 >= 0) {
                                        v26 = v11_3;
                                        v24 = v15;
                                        int v15_1 = 0;
                                        int v16;
                                        for(v16 = v10; true; v16 = 8) {
                                            long v10_1 = v26[v15_1];
                                            v27 = v2;
                                            if((~v10_1 << v17 & v10_1 & v22) != v22) {
                                                v1_1 = 8 - (~(v15_1 - v13) >>> 0x1F);
                                                v2_1 = 0;
                                                while(v2_1 < v1_1) {
                                                    if((v10_1 & v24) < v19) {
                                                        v29 = v2_1;
                                                        v30 = v3;
                                                        if(Intrinsics.areEqual(v12_1[(v15_1 << 3) + v2_1], SemanticsProperties.INSTANCE.getText())) {
                                                            v2_2 = SemanticsConfigurationKt.getOrNull(v5_2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getText());
                                                            v2_2 = v2_2 != null ? CollectionsKt.firstOrNull(((List)v2_2)) : v21;
                                                            v0.sendContentCaptureTextUpdateEvent(v5_2.getId(), String.valueOf(v2_2));
                                                        }
                                                    }
                                                    else {
                                                        v29 = v2_1;
                                                        v30 = v3;
                                                    }

                                                    v10_1 >>= v16;
                                                    v2_1 = v29 + 1;
                                                    v3 = v30;
                                                }

                                                v30 = v3;
                                                if(v1_1 != v16) {
                                                    goto label_110;
                                                }
                                            }
                                            else {
                                                v30 = v3;
                                            }

                                            if(v15_1 == v13) {
                                                goto label_110;
                                            }

                                            ++v15_1;
                                            v2 = v27;
                                            v3 = v30;
                                        }
                                    }
                                    else {
                                        v27 = v2;
                                        v30 = v3;
                                        goto label_110;
                                    }
                                }
                                else {
                                    v27 = v2;
                                    v30 = v3;
                                    v22 = v12;
                                    v24 = v15;
                                    MutableScatterMap v1_2 = v5_2.getUnmergedConfig$ui().getProps$ui();
                                    Object[] v2_3 = ((ScatterMap)v1_2).keys;
                                    long[] v1_3 = ((ScatterMap)v1_2).metadata;
                                    int v3_1 = v1_3.length - 2;
                                    if(v3_1 >= 0) {
                                        v10 = 0;
                                        while(true) {
                                            v12 = v1_3[v10];
                                            v26 = v1_3;
                                            Object[] v15_2 = v2_3;
                                            if((~v12 << v17 & v12 & v22) != v22) {
                                                v1_1 = 8 - (~(v10 - v3_1) >>> 0x1F);
                                                v2_1 = 0;
                                                while(v2_1 < v1_1) {
                                                    if((v12 & v24) < v19) {
                                                        v29 = v2_1;
                                                        v31 = v5_2;
                                                        if(Intrinsics.areEqual(v15_2[(v10 << 3) + v2_1], SemanticsProperties.INSTANCE.getText())) {
                                                            v2_2 = SemanticsConfigurationKt.getOrNull(((SemanticsNodeCopy)v11_1).getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
                                                            v2_2 = v2_2 != null ? CollectionsKt.firstOrNull(((List)v2_2)) : v21;
                                                            v32 = v7;
                                                            v5_1 = SemanticsConfigurationKt.getOrNull(v31.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getText());
                                                            v5_1 = v5_1 != null ? CollectionsKt.firstOrNull(((List)v5_1)) : v21;
                                                            if(Intrinsics.areEqual(v2_2, v5_1)) {
                                                                goto label_177;
                                                            }

                                                            v0.sendContentCaptureTextUpdateEvent(v31.getId(), String.valueOf(v5_1));
                                                        }
                                                        else {
                                                            goto label_176;
                                                        }
                                                    }
                                                    else {
                                                        v29 = v2_1;
                                                        v31 = v5_2;
                                                    label_176:
                                                        v32 = v7;
                                                    }

                                                label_177:
                                                    v12 >>= 8;
                                                    v2_1 = v29 + 1;
                                                    v5_2 = v31;
                                                    v7 = v32;
                                                }

                                                v31 = v5_2;
                                                v32 = v7;
                                                if(v1_1 != 8) {
                                                    goto label_198;
                                                }
                                            }
                                            else {
                                                v31 = v5_2;
                                                v32 = v7;
                                            }

                                            if(v10 == v3_1) {
                                                goto label_198;
                                            }

                                            ++v10;
                                            v2_3 = v15_2;
                                            v1_3 = v26;
                                            v5_2 = v31;
                                            v7 = v32;
                                        }
                                    }

                                label_110:
                                    v32 = v7;
                                }

                            label_198:
                                v2_1 = 8;
                                goto label_211;
                            }

                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        else {
                            v27 = v2;
                            v30 = v3;
                            v32 = v7;
                            v17 = v11;
                            v22 = v12;
                            v2_1 = v10;
                        }

                    label_211:
                        v7 = v32 >> v2_1;
                        ++v14;
                        v1 = arg35;
                        v10 = v2_1;
                        v11 = v17;
                        v12 = v22;
                        v2 = v27;
                        v3 = v30;
                    }

                    v27 = v2;
                    v30 = v3;
                    if(v9 != v10) {
                        return;
                    }
                }
                else {
                    v27 = v2;
                    v30 = v3;
                }

                if(v6 == v4) {
                    return;
                }

                ++v6;
                v1 = arg35;
                v2 = v27;
                v3 = v30;
            }
        }
    }

    private final void clearTranslatedText() {
        IntObjectMap v13 = this.getCurrentSemanticsNodes$ui();
        Object[] v0 = v13.values;
        long[] v13_1 = v13.metadata;
        int v1 = v13_1.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v13_1[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            SemanticsConfiguration v9 = v0[(v3 << 3) + v8].getSemanticsNode().getUnmergedConfig$ui();
                            if(SemanticsConfigurationKt.getOrNull(v9, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()) != null) {
                                Object v9_1 = SemanticsConfigurationKt.getOrNull(v9, SemanticsActions.INSTANCE.getClearTextSubstitution());
                                if(v9_1 != null) {
                                    Function v9_2 = ((AccessibilityAction)v9_1).getAction();
                                    if(v9_2 != null) {
                                        ((Function0)v9_2).invoke();
                                    }
                                }
                            }
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return;
                    }
                }

                if(v3 == v1) {
                    return;
                }
            }
        }
    }

    static final void contentCaptureChangeChecker$lambda$0(AndroidContentCaptureManager arg4) {
        if(!arg4.isEnabled$ui()) {
            return;
        }

        Trace.beginSection("ContentCapture:changeChecker");
        try {
            Owner.measureAndLayout$default(arg4.view, false, 1, null);
            arg4.sendContentCaptureDisappearEvents();
            Trace.beginSection("ContentCapture:sendAppearEvents");
        }
        catch(Throwable v4) {
            goto label_31;
        }

        try {
            arg4.sendContentCaptureAppearEvents(arg4.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), arg4.previousSemanticsRoot);
            goto label_19;
        }
        catch(Throwable v4) {
            try {
                Trace.endSection();
                throw v4;
            label_19:
                Trace.endSection();
                arg4.checkForContentCapturePropertyChanges(arg4.getCurrentSemanticsNodes$ui());
                arg4.updateSemanticsCopy();
                arg4.checkingForSemanticsChanges = false;
            }
            catch(Throwable v4) {
            label_31:
                Trace.endSection();
                throw v4;
            }
        }

        Trace.endSection();
    }

    private final void fastForEachIndexedWithFilter(List arg5, Function2 arg6, Function1 arg7) {
        int v4 = arg5.size();
        int v0 = 0;
        int v1 = 0;
        while(v0 < v4) {
            Object v2 = arg5.get(v0);
            if(arg7.invoke(v2).booleanValue()) {
                arg6.invoke(Integer.valueOf(v1), v2);
                ++v1;
            }

            ++v0;
        }
    }

    private final void fastForEachReplacedVisibleChildren(SemanticsNode arg7, Function2 arg8) {
        List v7 = arg7.getReplacedChildren$ui();
        int v0 = v7.size();
        int v1 = 0;
        int v2 = 0;
        while(v1 < v0) {
            Object v3 = v7.get(v1);
            if(this.getCurrentSemanticsNodes$ui().containsKey(v3.getId())) {
                arg8.invoke(Integer.valueOf(v2), v3);
                ++v2;
            }

            ++v1;
        }
    }

    public final ContentCaptureSessionWrapper getContentCaptureSession$ui() {
        return this.contentCaptureSession;
    }

    public static void getContentCaptureSession$ui$annotations() {
    }

    public final IntObjectMap getCurrentSemanticsNodes$ui() {
        if(this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsOwnerKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner(), -1, AndroidContentCaptureManager$currentSemanticsNodes$1.INSTANCE);
            this.currentSemanticsNodesSnapshotTimestampMillis = System.currentTimeMillis();
        }

        return this.currentSemanticsNodes;
    }

    public final Handler getHandler$ui() {
        return this.handler;
    }

    public final Function0 getOnContentCaptureSession() {
        return this.onContentCaptureSession;
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    private final void hideTranslatedText() {
        IntObjectMap v13 = this.getCurrentSemanticsNodes$ui();
        Object[] v0 = v13.values;
        long[] v13_1 = v13.metadata;
        int v1 = v13_1.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v13_1[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            SemanticsConfiguration v9 = v0[(v3 << 3) + v8].getSemanticsNode().getUnmergedConfig$ui();
                            if(Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v9, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.valueOf(true))) {
                                Object v9_1 = SemanticsConfigurationKt.getOrNull(v9, SemanticsActions.INSTANCE.getShowTextSubstitution());
                                if(v9_1 != null) {
                                    Function v9_2 = ((AccessibilityAction)v9_1).getAction();
                                    if(v9_2 != null) {
                                        ((Function1)v9_2).invoke(Boolean.valueOf(false));
                                    }
                                }
                            }
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return;
                    }
                }

                if(v3 == v1) {
                    return;
                }
            }
        }
    }

    public final boolean isEnabled$ui() {
        if((ContentCaptureManager.Companion.isEnabled()) && this.contentCaptureSession != null) {
            return 1;
        }

        return 0;
    }

    private final void notifyContentCaptureChanges() {
        ContentCaptureSessionWrapper v0 = this.contentCaptureSession;
        if(v0 == null) {
        }
        else if(Build$VERSION.SDK_INT < 29) {
        }
        else if(!this.bufferedEvents.isEmpty()) {
            List v1 = this.bufferedEvents;
            int v2 = v1.size();
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                Object v4 = v1.get(v3);
                int v5 = WhenMappings.$EnumSwitchMapping$0[((ContentCaptureEvent)v4).getType().ordinal()];
                if(v5 == 1) {
                    ViewStructureCompat v4_2 = ((ContentCaptureEvent)v4).getStructureCompat();
                    if(v4_2 != null) {
                        v0.notifyViewAppeared(v4_2.toViewStructure());
                    }
                }
                else if(v5 == 2) {
                    AutofillId v4_1 = v0.newAutofillId(((long)((ContentCaptureEvent)v4).getId()));
                    if(v4_1 != null) {
                        v0.notifyViewDisappeared(v4_1);
                    }
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            v0.flush();
            this.bufferedEvents.clear();
        }
    }

    private final void notifySubtreeStateChangeIfNeeded() {
        this.boundsUpdateChannel.trySend-JP2dKIU(Unit.INSTANCE);
    }

    public final void onClearTranslation$ui() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        this.clearTranslatedText();
    }

    public final void onCreateVirtualViewTranslationRequests$ui(long[] arg2, int[] arg3, Consumer arg4) {
        ViewTranslationHelperMethods.INSTANCE.onCreateVirtualViewTranslationRequests(this, arg2, arg3, arg4);
    }

    public final void onHideTranslation$ui() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        this.hideTranslatedText();
    }

    public final void onLayoutChange$ui() {
        this.currentSemanticsNodesInvalidated = true;
        if(this.isEnabled$ui()) {
            this.notifySubtreeStateChangeIfNeeded();
        }
    }

    public final void onSemanticsChange$ui() {
        this.currentSemanticsNodesInvalidated = true;
        if((this.isEnabled$ui()) && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.contentCaptureChangeChecker);
        }
    }

    public final void onShowTranslation$ui() {
        this.translateStatus = TranslateStatus.SHOW_TRANSLATED;
        this.showTranslatedText();
    }

    public void onStart(LifecycleOwner arg2) {
        this.contentCaptureSession = this.onContentCaptureSession.invoke();
        this.updateBuffersOnAppeared(-1, this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        this.notifyContentCaptureChanges();
    }

    public void onStop(LifecycleOwner arg1) {
        this.updateBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        this.notifyContentCaptureChanges();
        this.contentCaptureSession = null;
    }

    public void onViewAttachedToWindow(View arg1) {
    }

    public void onViewDetachedFromWindow(View arg2) {
        this.handler.removeCallbacks(this.contentCaptureChangeChecker);
        this.contentCaptureSession = null;
    }

    public final void onVirtualViewTranslationResponses$ui(AndroidContentCaptureManager arg1, LongSparseArray arg2) {
        ViewTranslationHelperMethods.INSTANCE.onVirtualViewTranslationResponses(arg1, arg2);
    }

    private final void sendContentCaptureAppearEvents(SemanticsNode arg5, SemanticsNodeCopy arg6) {
        this.fastForEachReplacedVisibleChildren(arg5, new AndroidContentCaptureManager$sendContentCaptureAppearEvents$1(arg6, this));
        List v5 = arg5.getReplacedChildren$ui();
        int v6 = v5.size();
        int v0;
        for(v0 = 0; v0 < v6; ++v0) {
            Object v1 = v5.get(v0);
            if((this.getCurrentSemanticsNodes$ui().containsKey(((SemanticsNode)v1).getId())) && (this.previousSemanticsNodes.containsKey(((SemanticsNode)v1).getId()))) {
                Object v2 = this.previousSemanticsNodes.get(((SemanticsNode)v1).getId());
                if(v2 != null) {
                    this.sendContentCaptureAppearEvents(((SemanticsNode)v1), ((SemanticsNodeCopy)v2));
                }
                else {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    private final void sendContentCaptureDisappearEvents() {
        MutableIntObjectMap v0 = this.previousSemanticsNodes;
        int[] v1 = ((IntObjectMap)v0).keys;
        long[] v0_1 = ((IntObjectMap)v0).metadata;
        int v2 = v0_1.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v0_1[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = v1[(v4 << 3) + v9];
                            if(!this.getCurrentSemanticsNodes$ui().containsKey(v10)) {
                                this.bufferContentCaptureViewDisappeared(v10);
                                this.notifySubtreeStateChangeIfNeeded();
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 != v8) {
                        return;
                    }
                }

                if(v4 == v2) {
                    return;
                }
            }
        }
    }

    private final void sendContentCaptureTextUpdateEvent(int arg3, String arg4) {
        ContentCaptureSessionWrapper v2;
        if(Build$VERSION.SDK_INT < 29) {
        }
        else {
            v2 = this.contentCaptureSession;
            if(v2 == null) {
                return;
            }

            goto label_7;
        }

        return;
    label_7:
        AutofillId v3 = v2.newAutofillId(((long)arg3));
        if(v3 != null) {
            v2.notifyViewTextChanged(v3, ((CharSequence)arg4));
            return;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid content capture ID");
        throw new KotlinNothingValueException();
    }

    public final void setContentCaptureSession$ui(ContentCaptureSessionWrapper arg1) {
        this.contentCaptureSession = arg1;
    }

    public final void setCurrentSemanticsNodes$ui(IntObjectMap arg1) {
        this.currentSemanticsNodes = arg1;
    }

    public final void setOnContentCaptureSession(Function0 arg1) {
        this.onContentCaptureSession = arg1;
    }

    private final void showTranslatedText() {
        IntObjectMap v13 = this.getCurrentSemanticsNodes$ui();
        Object[] v0 = v13.values;
        long[] v13_1 = v13.metadata;
        int v1 = v13_1.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v13_1[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            SemanticsConfiguration v9 = v0[(v3 << 3) + v8].getSemanticsNode().getUnmergedConfig$ui();
                            if(Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v9, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.valueOf(false))) {
                                Object v9_1 = SemanticsConfigurationKt.getOrNull(v9, SemanticsActions.INSTANCE.getShowTextSubstitution());
                                if(v9_1 != null) {
                                    Function v9_2 = ((AccessibilityAction)v9_1).getAction();
                                    if(v9_2 != null) {
                                        ((Function1)v9_2).invoke(Boolean.valueOf(true));
                                    }
                                }
                            }
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return;
                    }
                }

                if(v3 == v1) {
                    return;
                }
            }
        }
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode arg17, int arg18) {
        AutofillId v3_1;
        AndroidContentCaptureManager v0 = this;
        ContentCaptureSessionWrapper v1 = v0.contentCaptureSession;
        ViewStructureCompat v2 = null;
        if(v1 == null) {
            return v2;
        }

        if(Build$VERSION.SDK_INT < 29) {
            return v2;
        }

        AutofillIdCompat v3 = ViewCompatShims.getAutofillId(v0.view);
        if(v3 == null) {
            return v2;
        }

        SemanticsNode v4 = arg17.getParent();
        if(v4 != null) {
            v3_1 = v1.newAutofillId(((long)v4.getId()));
            if(v3_1 == null) {
                return v2;
            }
        }
        else {
            v3_1 = v3.toAutofillId();
        }

        ViewStructureCompat v6 = v1.newVirtualViewStructure(v3_1, ((long)arg17.getId()));
        if(v6 == null) {
            return v2;
        }

        SemanticsConfiguration v1_1 = arg17.getUnmergedConfig$ui();
        if(v1_1.contains(SemanticsProperties.INSTANCE.getPassword())) {
            return v2;
        }

        Bundle v3_2 = v6.getExtras();
        if(v3_2 != null) {
            v3_2.putLong("android.view.contentcapture.EventTimestamp", v0.currentSemanticsNodesSnapshotTimestampMillis);
            v3_2.putInt("android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX", arg18);
        }

        Object v0_1 = SemanticsConfigurationKt.getOrNull(v1_1, SemanticsProperties.INSTANCE.getTestTag());
        if(v0_1 != null) {
            v6.setId(arg17.getId(), ((String)v2), ((String)v2), ((String)v0_1));
        }

        v0_1 = SemanticsConfigurationKt.getOrNull(v1_1, SemanticsProperties.INSTANCE.getIsTraversalGroup());
        if(v0_1 != null) {
            ((Boolean)v0_1).booleanValue();
            v6.setClassName("android.widget.ViewGroup");
        }

        Object v7 = SemanticsConfigurationKt.getOrNull(v1_1, SemanticsProperties.INSTANCE.getText());
        String v0_2 = "\n";
        if(v7 != null) {
            v6.setClassName("android.widget.TextView");
            v6.setText(ListUtilsKt.fastJoinToString$default(((List)v7), v0_2, null, null, 0, null, null, 62, null));
        }

        Object v2_1 = SemanticsConfigurationKt.getOrNull(v1_1, SemanticsProperties.INSTANCE.getEditableText());
        if(v2_1 != null) {
            v6.setClassName("android.widget.EditText");
            v6.setText(((CharSequence)v2_1));
        }

        v7 = SemanticsConfigurationKt.getOrNull(v1_1, SemanticsProperties.INSTANCE.getContentDescription());
        if(v7 != null) {
            v6.setContentDescription(ListUtilsKt.fastJoinToString$default(((List)v7), v0_2, null, null, 0, null, null, 62, null));
        }

        v0_1 = SemanticsConfigurationKt.getOrNull(v1_1, SemanticsProperties.INSTANCE.getRole());
        if(v0_1 != null) {
            v0_2 = SemanticsUtils_androidKt.toLegacyClassName-V4PA4sw(((Role)v0_1).unbox-impl());
            if(v0_2 != null) {
                v6.setClassName(v0_2);
            }
        }

        TextLayoutResult v0_3 = SemanticsUtils_androidKt.getTextLayoutResult(v1_1);
        if(v0_3 != null) {
            TextLayoutInput v0_4 = v0_3.getLayoutInput();
            v6.setTextStyle(TextUnit.getValue-impl(v0_4.getStyle().getFontSize-XSAIIZE()) * v0_4.getDensity().getDensity() * v0_4.getDensity().getFontScale(), 0, 0, 0);
        }

        Rect v0_5 = arg17.getBoundsInParent$ui();
        v6.setDimens(((int)v0_5.getLeft()), ((int)v0_5.getTop()), 0, 0, ((int)(v0_5.getRight() - v0_5.getLeft())), ((int)(v0_5.getBottom() - v0_5.getTop())));
        return v6;
    }

    private final void updateBuffersOnAppeared(int arg2, SemanticsNode arg3) {
        if(!this.isEnabled$ui()) {
            return;
        }

        this.updateTranslationOnAppeared(arg3);
        this.bufferContentCaptureViewAppeared(arg3.getId(), this.toViewStructure(arg3, arg2));
        this.fastForEachReplacedVisibleChildren(arg3, new AndroidContentCaptureManager$updateBuffersOnAppeared$1(this));
    }

    private final void updateBuffersOnDisappeared(SemanticsNode arg4) {
        if(!this.isEnabled$ui()) {
        }
        else {
            this.bufferContentCaptureViewDisappeared(arg4.getId());
            List v4 = arg4.getReplacedChildren$ui();
            int v0 = v4.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                this.updateBuffersOnDisappeared(v4.get(v1));
            }
        }
    }

    private final void updateSemanticsCopy() {
        AndroidContentCaptureManager v0 = this;
        v0.previousSemanticsNodes.clear();
        IntObjectMap v1 = v0.getCurrentSemanticsNodes$ui();
        int[] v2 = v1.keys;
        Object[] v3 = v1.values;
        long[] v1_1 = v1.metadata;
        int v4 = v1_1.length - 2;
        if(v4 >= 0) {
            int v6;
            for(v6 = 0; true; ++v6) {
                long v7 = v1_1[v6];
                if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                    int v10 = 8;
                    int v9 = 8 - (~(v6 - v4) >>> 0x1F);
                    int v11;
                    for(v11 = 0; v11 < v9; ++v11) {
                        if((0xFF & v7) < 0x80) {
                            int v12 = (v6 << 3) + v11;
                            v0.previousSemanticsNodes.set(v2[v12], new SemanticsNodeCopy(v3[v12].getSemanticsNode(), v0.getCurrentSemanticsNodes$ui()));
                        }

                        v7 >>= v10;
                    }

                    if(v9 != v10) {
                        break;
                    }
                }

                if(v6 == v4) {
                    break;
                }
            }
        }

        v0.previousSemanticsRoot = new SemanticsNodeCopy(v0.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), v0.getCurrentSemanticsNodes$ui());
    }

    private final void updateTranslationOnAppeared(SemanticsNode arg6) {
        Function v5_1;
        Object v5;
        SemanticsConfiguration v6 = arg6.getUnmergedConfig$ui();
        Object v0 = SemanticsConfigurationKt.getOrNull(v6, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution());
        TranslateStatus v1 = this.translateStatus;
        TranslateStatus v2 = TranslateStatus.SHOW_ORIGINAL;
        Boolean v3 = Boolean.valueOf(false);
        Boolean v4 = Boolean.valueOf(true);
        if(v1 == v2 && (Intrinsics.areEqual(v0, v4))) {
            v5 = SemanticsConfigurationKt.getOrNull(v6, SemanticsActions.INSTANCE.getShowTextSubstitution());
            if(v5 != null) {
                v5_1 = ((AccessibilityAction)v5).getAction();
                if(v5_1 != null) {
                    ((Function1)v5_1).invoke(v3);
                    return;
                }
            }
        }
        else if(this.translateStatus == TranslateStatus.SHOW_TRANSLATED && (Intrinsics.areEqual(v0, v3))) {
            v5 = SemanticsConfigurationKt.getOrNull(v6, SemanticsActions.INSTANCE.getShowTextSubstitution());
            if(v5 != null) {
                v5_1 = ((AccessibilityAction)v5).getAction();
                if(v5_1 != null) {
                    ((Function1)v5_1).invoke(v4);
                }
            }
        }
    }
}

