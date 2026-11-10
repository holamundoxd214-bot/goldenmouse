package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager$Property;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Consumer;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.BuildConfig;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.PredicateAdapter;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 b2\u00020\u0001:\u0005bcdefB\u001B\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0017J\u0016\u0010\u001A\u001A\u00020\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0017J\u0010\u0010\u001D\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u0019H\u0017J\u0010\u0010\u001F\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u0019H\u0017J,\u0010 \u001A\u00020\u001B2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\u0012\u0010%\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\'0&H\u0016J\u001C\u0010)\u001A\u00020\u001B2\u0012\u0010*\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\'0&H\u0016J\b\u0010+\u001A\u00020,H\u0002J\u0010\u00103\u001A\u00020,2\u0006\u0010!\u001A\u00020\"H\u0016J\u0018\u00104\u001A\u00020,2\u0006\u00105\u001A\u0002062\u0006\u00107\u001A\u000208H\u0017J\u0010\u00109\u001A\u00020\u001B2\u0006\u00105\u001A\u000206H\u0017J\u001C\u0010:\u001A\u00020\u001B2\u0012\u0010;\u001A\u000E\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<H\u0017J\b\u0010?\u001A\u00020\u001BH\u0017J\u0012\u0010@\u001A\u0004\u0018\u00010A2\u0006\u0010!\u001A\u00020\"H\u0016J\u0012\u0010B\u001A\u0004\u0018\u00010A2\u0006\u0010!\u001A\u00020\"H\u0003J\u0018\u0010C\u001A\u00020D2\u0006\u0010E\u001A\u00020D2\u0006\u0010F\u001A\u00020AH\u0017J\u0018\u0010G\u001A\u00020D2\u0006\u0010E\u001A\u00020D2\u0006\u0010H\u001A\u00020IH\u0017J\u0016\u0010J\u001A\u00020\u001B2\f\u0010K\u001A\b\u0012\u0004\u0012\u00020A0\u0018H\u0017J\u0010\u0010L\u001A\u00020\u001B2\u0006\u0010M\u001A\u00020NH\u0017J\b\u0010O\u001A\u00020\u001BH\u0017J\u0018\u0010P\u001A\u00020\u001B2\u0006\u0010Q\u001A\u00020(2\u0006\u0010R\u001A\u00020>H\u0017J\u001C\u0010S\u001A\u00020\u001B2\u0012\u0010;\u001A\u000E\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0<H\u0017J\b\u0010V\u001A\u00020\u001BH\u0017J\u0018\u0010W\u001A\u00020\u001B2\u0006\u0010X\u001A\u00020Y2\u0006\u0010Z\u001A\u00020UH\u0017J&\u0010[\u001A\u00020\u001B2\u0006\u0010X\u001A\u00020Y2\u0006\u0010#\u001A\u00020$2\f\u0010\\\u001A\b\u0012\u0004\u0012\u00020]0&H\u0017J\u0016\u0010^\u001A\u00020\u001B2\f\u0010\\\u001A\b\u0012\u0004\u0012\u00020]0&H\u0017J\u001E\u0010_\u001A\u00020\u001B2\u0006\u0010!\u001A\u00020\"2\f\u0010%\u001A\b\u0012\u0004\u0012\u00020`0&H\u0017J\u0016\u0010a\u001A\u00020\u001B2\f\u0010%\u001A\b\u0012\u0004\u0012\u00020`0&H\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\"\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r8\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001A\u00060\u0014R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001B\u0010-\u001A\u00020.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001A\u0004\b/\u00100¨\u0006g"}, d2={"Landroidx/window/embedding/ExtensionEmbeddingBackend;", "Landroidx/window/embedding/EmbeddingBackend;", "applicationContext", "Landroid/content/Context;", "embeddingExtension", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "<init>", "(Landroid/content/Context;Landroidx/window/embedding/EmbeddingInterfaceCompat;)V", "getEmbeddingExtension", "()Landroidx/window/embedding/EmbeddingInterfaceCompat;", "setEmbeddingExtension", "(Landroidx/window/embedding/EmbeddingInterfaceCompat;)V", "splitChangeCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/embedding/ExtensionEmbeddingBackend$SplitListenerWrapper;", "getSplitChangeCallbacks$annotations", "()V", "getSplitChangeCallbacks", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "embeddingCallback", "Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "ruleTracker", "Landroidx/window/embedding/ExtensionEmbeddingBackend$RuleTracker;", "getRules", "", "Landroidx/window/embedding/EmbeddingRule;", "setRules", "", "rules", "addRule", "rule", "removeRule", "addSplitListenerForActivity", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "", "Landroidx/window/embedding/SplitInfo;", "removeSplitListenerForActivity", "consumer", "areExtensionsAvailable", "", "splitSupportStatus", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "getSplitSupportStatus", "()Landroidx/window/embedding/SplitController$SplitSupportStatus;", "splitSupportStatus$delegate", "Lkotlin/Lazy;", "isActivityEmbedded", "pinTopActivityStack", "taskId", "", "splitPinRule", "Landroidx/window/embedding/SplitPinRule;", "unpinTopActivityStack", "setSplitAttributesCalculator", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "clearSplitAttributesCalculator", "getActivityStack", "Landroidx/window/embedding/ActivityStack;", "getActivityStackFromSplitInfoList", "setLaunchingActivityStack", "Landroid/os/Bundle;", "options", "activityStack", "setOverlayCreateParams", "overlayCreateParams", "Landroidx/window/embedding/OverlayCreateParams;", "finishActivityStacks", "activityStacks", "setEmbeddingConfiguration", "embeddingConfig", "Landroidx/window/embedding/EmbeddingConfiguration;", "invalidateVisibleActivityStacks", "updateSplitAttributes", "splitInfo", "splitAttributes", "setOverlayAttributesCalculator", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "clearOverlayAttributesCalculator", "updateOverlayAttributes", "overlayTag", "", "overlayAttributes", "addOverlayInfoCallback", "overlayInfoCallback", "Landroidx/window/embedding/OverlayInfo;", "removeOverlayInfoCallback", "addEmbeddedActivityWindowInfoCallbackForActivity", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "removeEmbeddedActivityWindowInfoCallbackForActivity", "Companion", "RuleTracker", "SplitListenerWrapper", "EmbeddingCallbackImpl", "Api31Impl", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ExtensionEmbeddingBackend implements EmbeddingBackend {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/window/embedding/ExtensionEmbeddingBackend$Api31Impl;", "", "<init>", "()V", "isSplitPropertyEnabled", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "context", "Landroid/content/Context;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api31Impl {
        public static final Api31Impl INSTANCE;

        static {
            Api31Impl.INSTANCE = new Api31Impl();
        }

        private Api31Impl() {
            super();
        }

        public final SplitSupportStatus isSplitPropertyEnabled(Context arg3) {
            PackageManager$Property v3_1;
            String v2 = "EmbeddingBackend";
            Intrinsics.checkNotNullParameter(arg3, "context");
            try {
                v3_1 = arg3.getPackageManager().getProperty("android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED", arg3.getPackageName());
            }
            catch(Exception v3) {
                if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.LOG) {
                    Log.e(v2, "PackageManager.getProperty is not supported", ((Throwable)v3));
                }

                return SplitSupportStatus.SPLIT_ERROR_PROPERTY_NOT_DECLARED;
            }
            catch(PackageManager$NameNotFoundException ) {
                if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.LOG) {
                    Log.w(v2, "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must be set and enabled in AndroidManifest.xml to use splits APIs.");
                }

                return SplitSupportStatus.SPLIT_ERROR_PROPERTY_NOT_DECLARED;
            }

            Intrinsics.checkNotNull(v3_1);
            if(!v3_1.isBoolean()) {
                if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.LOG) {
                    Log.w(v2, "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must have a boolean value");
                }

                return SplitSupportStatus.SPLIT_ERROR_PROPERTY_NOT_DECLARED;
            }

            if(v3_1.getBoolean()) {
                return SplitSupportStatus.SPLIT_AVAILABLE;
            }

            return SplitSupportStatus.SPLIT_UNAVAILABLE;
        }
    }

    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rJ\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\rH\u0002J\u0017\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0015R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/window/embedding/ExtensionEmbeddingBackend$Companion;", "", "<init>", "()V", "globalInstance", "Landroidx/window/embedding/ExtensionEmbeddingBackend;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "TAG", "", "getInstance", "Landroidx/window/embedding/EmbeddingBackend;", "context", "Landroid/content/Context;", "initAndVerifyEmbeddingExtension", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "applicationContext", "isExtensionVersionSupported", "", "extensionVersion", "", "(Ljava/lang/Integer;)Z", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final EmbeddingBackend getInstance(Context arg3) {
            Intrinsics.checkNotNullParameter(arg3, "context");
            if(ExtensionEmbeddingBackend.globalInstance == null) {
                ReentrantLock v2 = ExtensionEmbeddingBackend.globalLock;
                ((Lock)v2).lock();
                try {
                    if(ExtensionEmbeddingBackend.globalInstance == null) {
                        arg3 = arg3.getApplicationContext();
                        Companion v0 = ExtensionEmbeddingBackend.Companion;
                        Intrinsics.checkNotNull(arg3);
                        ExtensionEmbeddingBackend.globalInstance = new ExtensionEmbeddingBackend(arg3, v0.initAndVerifyEmbeddingExtension(arg3));
                    }
                }
                catch(Throwable v3) {
                    ((Lock)v2).unlock();
                    throw v3;
                }

                ((Lock)v2).unlock();
            }

            ExtensionEmbeddingBackend v2_1 = ExtensionEmbeddingBackend.globalInstance;
            Intrinsics.checkNotNull(v2_1);
            return ((EmbeddingBackend)v2_1);
        }

        private final EmbeddingInterfaceCompat initAndVerifyEmbeddingExtension(Context arg12) {
            EmbeddingCompat v4;
            String v1 = "EmbeddingBackend";
            int v0 = WindowSdkExtensions.Companion.getInstance().getExtensionVersion();
            EmbeddingCompat v2 = null;
            try {
                if(!this.isExtensionVersionSupported(Integer.valueOf(v0))) {
                    goto label_51;
                }

                if(!EmbeddingCompat.Companion.isEmbeddingAvailable()) {
                    goto label_51;
                }

                ClassLoader v11 = EmbeddingBackend.class.getClassLoader();
                if(v11 != null) {
                    ActivityEmbeddingComponent v5 = EmbeddingCompat.Companion.embeddingComponent();
                    EmbeddingAdapter v6 = new EmbeddingAdapter(new PredicateAdapter(v11));
                    ConsumerAdapter v7 = new ConsumerAdapter(v11);
                    OverlayControllerImpl v9 = v0 >= 8 ? new OverlayControllerImpl(v5, v6) : ((OverlayControllerImpl)v2);
                    ActivityWindowInfoCallbackController v10 = v0 >= 6 ? new ActivityWindowInfoCallbackController(v5) : ((ActivityWindowInfoCallbackController)v2);
                    v4 = new EmbeddingCompat(v5, v6, v7, arg12, v9, v10);
                }
                else {
                    v4 = v2;
                }

                v2 = v4;
            }
            catch(Throwable v0_1) {
                Log.d(v1, "Failed to load embedding extension: " + v0_1);
            }

        label_51:
            if(v2 == null) {
                Log.d(v1, "No supported embedding extension found");
            }

            return ((EmbeddingInterfaceCompat)v2);
        }

        public final boolean isExtensionVersionSupported(Integer arg2) {
            if(arg2 == null) {
                return 0;
            }

            if(arg2.intValue() >= 1) {
                return 1;
            }

            return 0;
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000F\u001A\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u0012\u001A\u00020\u00102\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\f0\u0005H\u0016R \u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\b\"\u0004\b\u000E\u0010\n¨\u0006\u0014"}, d2={"Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "<init>", "(Landroidx/window/embedding/ExtensionEmbeddingBackend;)V", "lastInfo", "", "Landroidx/window/embedding/SplitInfo;", "getLastInfo", "()Ljava/util/List;", "setLastInfo", "(Ljava/util/List;)V", "lastActivityStacks", "Landroidx/window/embedding/ActivityStack;", "getLastActivityStacks", "setLastActivityStacks", "onSplitInfoChanged", "", "splitInfo", "onActivityStackChanged", "activityStacks", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmbeddingCallbackImpl implements EmbeddingCallbackInterface {
        private List lastActivityStacks;
        private List lastInfo;

        public EmbeddingCallbackImpl(ExtensionEmbeddingBackend arg1) {
            ExtensionEmbeddingBackend.this = arg1;
            super();
            this.lastInfo = CollectionsKt.emptyList();
            this.lastActivityStacks = CollectionsKt.emptyList();
        }

        public final List getLastActivityStacks() {
            return this.lastActivityStacks;
        }

        public final List getLastInfo() {
            return this.lastInfo;
        }

        public void onActivityStackChanged(List arg2) {
            Intrinsics.checkNotNullParameter(arg2, "activityStacks");
            this.lastActivityStacks = arg2;
        }

        public void onSplitInfoChanged(List arg2) {
            Intrinsics.checkNotNullParameter(arg2, "splitInfo");
            this.lastInfo = arg2;
            Iterator v1 = ExtensionEmbeddingBackend.this.getSplitChangeCallbacks().iterator();
            Intrinsics.checkNotNullExpressionValue(v1, "iterator(...)");
            while(v1.hasNext()) {
                v1.next().accept(arg2);
            }
        }

        public final void setLastActivityStacks(List arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<set-?>");
            this.lastActivityStacks = arg2;
        }

        public final void setLastInfo(List arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<set-?>");
            this.lastInfo = arg2;
        }
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\r\u001A\u00020\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00060\u0010J\u0006\u0010\u0011\u001A\u00020\u000EJ\u0018\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\u00062\b\b\u0002\u0010\u0014\u001A\u00020\u0015J\u000E\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\u0006J\u0011\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0013\u001A\u00020\u0006H\u0086\u0002R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR*\u0010\t\u001A\u001E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00060\nj\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u0006`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/window/embedding/ExtensionEmbeddingBackend$RuleTracker;", "", "<init>", "()V", "splitRules", "Landroidx/collection/ArraySet;", "Landroidx/window/embedding/EmbeddingRule;", "getSplitRules", "()Landroidx/collection/ArraySet;", "tagRuleMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setRules", "", "rules", "", "clearRules", "addOrUpdateRule", "rule", "throwOnDuplicateTag", "", "removeRule", "contains", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class RuleTracker {
        private final ArraySet splitRules;
        private final HashMap tagRuleMap;

        public RuleTracker() {
            super();
            this.splitRules = new ArraySet(0, 1, null);
            this.tagRuleMap = new HashMap();
        }

        public final void addOrUpdateRule(EmbeddingRule arg3, boolean arg4) {
            Intrinsics.checkNotNullParameter(arg3, "rule");
            if(this.splitRules.contains(arg3)) {
                return;
            }

            String v0 = arg3.getTag();
            if(v0 == null) {
                this.splitRules.add(arg3);
                return;
            }

            if(this.tagRuleMap.containsKey(v0)) {
                if(!arg4) {
                    TypeIntrinsics.asMutableCollection(this.splitRules).remove(this.tagRuleMap.get(v0));
                    this.tagRuleMap.put(v0, arg3);
                    this.splitRules.add(arg3);
                    return;
                }

                throw new IllegalArgumentException("Duplicated tag: " + v0 + ". Tag must be unique among all registered rules");
            }

            this.tagRuleMap.put(v0, arg3);
            this.splitRules.add(arg3);
        }

        public static void addOrUpdateRule$default(RuleTracker arg0, EmbeddingRule arg1, boolean arg2, int arg3, Object arg4) {
            arg0.addOrUpdateRule(arg1, false);
        }

        public final void clearRules() {
            this.splitRules.clear();
            this.tagRuleMap.clear();
        }

        public final boolean contains(EmbeddingRule arg2) {
            Intrinsics.checkNotNullParameter(arg2, "rule");
            return this.splitRules.contains(arg2);
        }

        public final ArraySet getSplitRules() {
            return this.splitRules;
        }

        public final void removeRule(EmbeddingRule arg2) {
            Intrinsics.checkNotNullParameter(arg2, "rule");
            if(!this.splitRules.contains(arg2)) {
            }
            else {
                this.splitRules.remove(arg2);
                if(arg2.getTag() != null) {
                    this.tagRuleMap.remove(arg2.getTag());
                }
            }
        }

        public final void setRules(Set arg3) {
            Intrinsics.checkNotNullParameter(arg3, "rules");
            this.clearRules();
            Iterator v3 = ((Iterable)arg3).iterator();
            while(v3.hasNext()) {
                this.addOrUpdateRule(v3.next(), true);
            }
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0014\u0010\u000F\u001A\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\t0\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001D\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0016\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/window/embedding/ExtensionEmbeddingBackend$SplitListenerWrapper;", "", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "", "Landroidx/window/embedding/SplitInfo;", "<init>", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "getCallback", "()Landroidx/core/util/Consumer;", "lastValue", "accept", "", "splitInfoList", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitListenerWrapper {
        private final Activity activity;
        private final Consumer callback;
        private final Executor executor;
        private List lastValue;

        public SplitListenerWrapper(Activity arg2, Executor arg3, Consumer arg4) {
            Intrinsics.checkNotNullParameter(arg2, "activity");
            Intrinsics.checkNotNullParameter(arg3, "executor");
            Intrinsics.checkNotNullParameter(arg4, "callback");
            super();
            this.activity = arg2;
            this.executor = arg3;
            this.callback = arg4;
        }

        public final void accept(List arg5) {
            Intrinsics.checkNotNullParameter(arg5, "splitInfoList");
            ArrayList v0 = new ArrayList();
            Iterator v5 = ((Iterable)arg5).iterator();
            while(v5.hasNext()) {
                Object v1 = v5.next();
                if(!v1.contains(this.activity)) {
                    continue;
                }

                ((Collection)v0).add(v1);
            }

            if(Intrinsics.areEqual(v0, this.lastValue)) {
                return;
            }

            this.lastValue = ((List)v0);
            this.executor.execute(new ExtensionEmbeddingBackend$SplitListenerWrapper$$ExternalSyntheticLambda0(this, ((List)v0)));
        }

        static final void accept$lambda$1(SplitListenerWrapper arg0, List arg1) {
            arg0.callback.accept(arg1);
        }

        public final Consumer getCallback() {
            return this.callback;
        }
    }

    public static final Companion Companion = null;
    private static final String TAG = "EmbeddingBackend";
    private final Context applicationContext;
    private final EmbeddingCallbackImpl embeddingCallback;
    private EmbeddingInterfaceCompat embeddingExtension;
    private static volatile ExtensionEmbeddingBackend globalInstance;
    private static final ReentrantLock globalLock;
    private final RuleTracker ruleTracker;
    private final CopyOnWriteArrayList splitChangeCallbacks;
    private final Lazy splitSupportStatus$delegate;

    static {
        ExtensionEmbeddingBackend.Companion = new Companion(null);
        ExtensionEmbeddingBackend.globalLock = new ReentrantLock();
    }

    public ExtensionEmbeddingBackend(Context arg2, EmbeddingInterfaceCompat arg3) {
        Intrinsics.checkNotNullParameter(arg2, "applicationContext");
        super();
        this.applicationContext = arg2;
        this.embeddingExtension = arg3;
        EmbeddingCallbackImpl v2 = new EmbeddingCallbackImpl(this);
        this.embeddingCallback = v2;
        this.splitChangeCallbacks = new CopyOnWriteArrayList();
        arg3 = this.embeddingExtension;
        if(arg3 != null) {
            arg3.setEmbeddingCallback(((EmbeddingCallbackInterface)v2));
        }

        this.ruleTracker = new RuleTracker();
        this.splitSupportStatus$delegate = LazyKt.lazy(new ExtensionEmbeddingBackend$$ExternalSyntheticLambda0(this));
    }

    public static final ExtensionEmbeddingBackend access$getGlobalInstance$cp() {
        return ExtensionEmbeddingBackend.globalInstance;
    }

    public static final ReentrantLock access$getGlobalLock$cp() {
        return ExtensionEmbeddingBackend.globalLock;
    }

    public static final void access$setGlobalInstance$cp(ExtensionEmbeddingBackend arg0) {
        ExtensionEmbeddingBackend.globalInstance = arg0;
    }

    public void addEmbeddedActivityWindowInfoCallbackForActivity(Activity arg2, Consumer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        Intrinsics.checkNotNullParameter(arg3, "callback");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            v1.addEmbeddedActivityWindowInfoCallbackForActivity(arg2, arg3);
        }
    }

    public void addOverlayInfoCallback(String arg2, Executor arg3, Consumer arg4) {
        Intrinsics.checkNotNullParameter(arg2, "overlayTag");
        Intrinsics.checkNotNullParameter(arg3, "executor");
        Intrinsics.checkNotNullParameter(arg4, "overlayInfoCallback");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            v1.addOverlayInfoCallback(arg2, arg3, arg4);
            return;
        }

        arg4.accept(new OverlayInfo(arg2, null, null));
    }

    public void addRule(EmbeddingRule arg6) {
        Intrinsics.checkNotNullParameter(arg6, "rule");
        ReentrantLock v0 = ExtensionEmbeddingBackend.globalLock;
        ((Lock)v0).lock();
        try {
            if(!this.ruleTracker.contains(arg6)) {
                RuleTracker.addOrUpdateRule$default(this.ruleTracker, arg6, false, 2, null);
                EmbeddingInterfaceCompat v6 = this.embeddingExtension;
                if(v6 != null) {
                    v6.setRules(this.getRules());
                }
            }
        }
        catch(Throwable v5) {
            ((Lock)v0).unlock();
            throw v5;
        }

        ((Lock)v0).unlock();
    }

    public void addSplitListenerForActivity(Activity arg3, Executor arg4, Consumer arg5) {
        Intrinsics.checkNotNullParameter(arg3, "activity");
        Intrinsics.checkNotNullParameter(arg4, "executor");
        Intrinsics.checkNotNullParameter(arg5, "callback");
        ReentrantLock v0 = ExtensionEmbeddingBackend.globalLock;
        ((Lock)v0).lock();
        try {
            if(this.embeddingExtension != null) {
                goto label_17;
            }

            Log.v("EmbeddingBackend", "Extension not loaded, skipping callback registration.");
            arg5.accept(CollectionsKt.emptyList());
        }
        catch(Throwable v2) {
            goto label_28;
        }

        ((Lock)v0).unlock();
        return;
        try {
        label_17:
            SplitListenerWrapper v1 = new SplitListenerWrapper(arg3, arg4, arg5);
            this.splitChangeCallbacks.add(v1);
            v1.accept(this.embeddingCallback.getLastInfo());
        }
        catch(Throwable v2) {
        label_28:
            ((Lock)v0).unlock();
            throw v2;
        }

        ((Lock)v0).unlock();
    }

    private final boolean areExtensionsAvailable() {
        if(this.embeddingExtension != null) {
            return 1;
        }

        return 0;
    }

    public void clearOverlayAttributesCalculator() {
        EmbeddingInterfaceCompat v0 = this.embeddingExtension;
        if(v0 != null) {
            v0.clearOverlayAttributesCalculator();
        }
    }

    public void clearSplitAttributesCalculator() {
        ReentrantLock v0 = ExtensionEmbeddingBackend.globalLock;
        ((Lock)v0).lock();
        try {
            EmbeddingInterfaceCompat v1_1 = this.embeddingExtension;
            if(v1_1 != null) {
                v1_1.clearSplitAttributesCalculator();
            }
        }
        catch(Throwable v1) {
            ((Lock)v0).unlock();
            throw v1;
        }

        ((Lock)v0).unlock();
    }

    public void finishActivityStacks(Set arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activityStacks");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            v1.finishActivityStacks(arg2);
        }
    }

    public ActivityStack getActivityStack(Activity arg5) {
        ActivityStack v2_1;
        Object v2;
        Intrinsics.checkNotNullParameter(arg5, "activity");
        ReentrantLock v0 = ExtensionEmbeddingBackend.globalLock;
        ((Lock)v0).lock();
        try {
            Iterator v1 = this.embeddingCallback.getLastActivityStacks().iterator();
            do {
                if(v1.hasNext()) {
                    v2 = v1.next();
                    if(!v2.contains(arg5)) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_14;
                }
            }
            while(true);

            goto label_15;
        label_14:
            v2 = null;
        label_15:
            if(v2 == null) {
                v2_1 = this.getActivityStackFromSplitInfoList(arg5);
            }
        }
        catch(Throwable v4) {
            goto label_20;
        }

        ((Lock)v0).unlock();
        return v2_1;
    label_20:
        ((Lock)v0).unlock();
        throw v4;
    }

    private final ActivityStack getActivityStackFromSplitInfoList(Activity arg3) {
        Object v0;
        Iterator v2 = this.embeddingCallback.getLastInfo().iterator();
        do {
        label_3:
            if(!v2.hasNext()) {
                return null;
            }

            v0 = v2.next();
            if(!((SplitInfo)v0).contains(arg3)) {
                goto label_3;
            }

            if(((SplitInfo)v0).getPrimaryActivityStack().contains(arg3)) {
                return ((SplitInfo)v0).getPrimaryActivityStack();
            }
        }
        while(!((SplitInfo)v0).getSecondaryActivityStack().contains(arg3));

        return ((SplitInfo)v0).getSecondaryActivityStack();
    }

    public final EmbeddingInterfaceCompat getEmbeddingExtension() {
        return this.embeddingExtension;
    }

    public Set getRules() {
        Set v1_1;
        ReentrantLock v0 = ExtensionEmbeddingBackend.globalLock;
        ((Lock)v0).lock();
        try {
            v1_1 = CollectionsKt.toSet(this.ruleTracker.getSplitRules());
        }
        catch(Throwable v1) {
            ((Lock)v0).unlock();
            throw v1;
        }

        ((Lock)v0).unlock();
        return v1_1;
    }

    public final CopyOnWriteArrayList getSplitChangeCallbacks() {
        return this.splitChangeCallbacks;
    }

    public static void getSplitChangeCallbacks$annotations() {
    }

    public SplitSupportStatus getSplitSupportStatus() {
        return this.splitSupportStatus$delegate.getValue();
    }

    public void invalidateVisibleActivityStacks() {
        EmbeddingInterfaceCompat v0 = this.embeddingExtension;
        if(v0 != null) {
            v0.invalidateVisibleActivityStacks();
        }
    }

    public boolean isActivityEmbedded(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            return v1.isActivityEmbedded(arg2);
        }

        return 0;
    }

    public boolean pinTopActivityStack(int arg2, SplitPinRule arg3) {
        Intrinsics.checkNotNullParameter(arg3, "splitPinRule");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            return v1.pinTopActivityStack(arg2, arg3);
        }

        return 0;
    }

    public void removeEmbeddedActivityWindowInfoCallbackForActivity(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "callback");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            v1.removeEmbeddedActivityWindowInfoCallbackForActivity(arg2);
        }
    }

    public void removeOverlayInfoCallback(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "overlayInfoCallback");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            v1.removeOverlayInfoCallback(arg2);
        }
    }

    public void removeRule(EmbeddingRule arg3) {
        Intrinsics.checkNotNullParameter(arg3, "rule");
        ReentrantLock v0 = ExtensionEmbeddingBackend.globalLock;
        ((Lock)v0).lock();
        try {
            if(this.ruleTracker.contains(arg3)) {
                this.ruleTracker.removeRule(arg3);
                EmbeddingInterfaceCompat v3 = this.embeddingExtension;
                if(v3 != null) {
                    v3.setRules(this.getRules());
                }
            }
        }
        catch(Throwable v2) {
            ((Lock)v0).unlock();
            throw v2;
        }

        ((Lock)v0).unlock();
    }

    public void removeSplitListenerForActivity(Consumer arg5) {
        Object v2;
        Intrinsics.checkNotNullParameter(arg5, "consumer");
        ReentrantLock v0 = ExtensionEmbeddingBackend.globalLock;
        ((Lock)v0).lock();
        try {
            Iterator v1 = this.splitChangeCallbacks.iterator();
            Intrinsics.checkNotNullExpressionValue(v1, "iterator(...)");
            do {
                if(v1.hasNext()) {
                    v2 = v1.next();
                    if(!Intrinsics.areEqual(((SplitListenerWrapper)v2).getCallback(), arg5)) {
                        continue;
                    }

                    break;
                }

                goto label_16;
            }
            while(true);

            this.splitChangeCallbacks.remove(v2);
        label_16:
        }
        catch(Throwable v4) {
            goto label_20;
        }

        ((Lock)v0).unlock();
        return;
    label_20:
        ((Lock)v0).unlock();
        throw v4;
    }

    public void setEmbeddingConfiguration(EmbeddingConfiguration arg2) {
        Intrinsics.checkNotNullParameter(arg2, "embeddingConfig");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            v1.setEmbeddingConfiguration(arg2);
        }
    }

    public final void setEmbeddingExtension(EmbeddingInterfaceCompat arg1) {
        this.embeddingExtension = arg1;
    }

    public Bundle setLaunchingActivityStack(Bundle arg2, ActivityStack arg3) {
        Intrinsics.checkNotNullParameter(arg2, "options");
        Intrinsics.checkNotNullParameter(arg3, "activityStack");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            Bundle v1_1 = v1.setLaunchingActivityStack(arg2, arg3);
            if(v1_1 == null) {
            }
            else {
                return v1_1;
            }
        }

        return arg2;
    }

    public void setOverlayAttributesCalculator(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "calculator");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            v1.setOverlayAttributesCalculator(arg2);
        }
    }

    public Bundle setOverlayCreateParams(Bundle arg2, OverlayCreateParams arg3) {
        Intrinsics.checkNotNullParameter(arg2, "options");
        Intrinsics.checkNotNullParameter(arg3, "overlayCreateParams");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            Bundle v1_1 = v1.setOverlayCreateParams(arg2, arg3);
            if(v1_1 == null) {
            }
            else {
                return v1_1;
            }
        }

        return arg2;
    }

    public void setRules(Set arg3) {
        Intrinsics.checkNotNullParameter(arg3, "rules");
        ReentrantLock v0 = ExtensionEmbeddingBackend.globalLock;
        ((Lock)v0).lock();
        try {
            this.ruleTracker.setRules(arg3);
            EmbeddingInterfaceCompat v3 = this.embeddingExtension;
            if(v3 != null) {
                v3.setRules(this.getRules());
            }
        }
        catch(Throwable v2) {
            ((Lock)v0).unlock();
            throw v2;
        }

        ((Lock)v0).unlock();
    }

    public void setSplitAttributesCalculator(Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "calculator");
        ReentrantLock v0 = ExtensionEmbeddingBackend.globalLock;
        ((Lock)v0).lock();
        try {
            EmbeddingInterfaceCompat v1_1 = this.embeddingExtension;
            if(v1_1 != null) {
                v1_1.setSplitAttributesCalculator(arg2);
            }
        }
        catch(Throwable v1) {
            ((Lock)v0).unlock();
            throw v1;
        }

        ((Lock)v0).unlock();
    }

    static final SplitSupportStatus splitSupportStatus_delegate$lambda$6(ExtensionEmbeddingBackend arg2) {
        if(!arg2.areExtensionsAvailable()) {
            return SplitSupportStatus.SPLIT_UNAVAILABLE;
        }

        if(Build$VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.INSTANCE.isSplitPropertyEnabled(arg2.applicationContext);
        }

        return SplitSupportStatus.SPLIT_AVAILABLE;
    }

    public void unpinTopActivityStack(int arg1) {
        EmbeddingInterfaceCompat v0 = this.embeddingExtension;
        if(v0 != null) {
            v0.unpinTopActivityStack(arg1);
        }
    }

    public void updateOverlayAttributes(String arg2, OverlayAttributes arg3) {
        Intrinsics.checkNotNullParameter(arg2, "overlayTag");
        Intrinsics.checkNotNullParameter(arg3, "overlayAttributes");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            v1.updateOverlayAttributes(arg2, arg3);
        }
    }

    public void updateSplitAttributes(SplitInfo arg2, SplitAttributes arg3) {
        Intrinsics.checkNotNullParameter(arg2, "splitInfo");
        Intrinsics.checkNotNullParameter(arg3, "splitAttributes");
        EmbeddingInterfaceCompat v1 = this.embeddingExtension;
        if(v1 != null) {
            v1.updateSplitAttributes(arg2, arg3);
        }
    }
}

