package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.core.util.Consumer;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.BuildConfig;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitAttributesCalculatorParams;
import androidx.window.extensions.embedding.SplitInfo;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 T2\u00020\u0001:\u0001TB;\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u0016\u0010\u0016\u001A\u00020\u00172\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019H\u0016J\u0010\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J\u0010\u0010\u001E\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00020\u001DH\u0002J\u0010\u0010\u001F\u001A\u00020\u00152\u0006\u0010 \u001A\u00020!H\u0016J\u0018\u0010\"\u001A\u00020\u00152\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&H\u0017J\u0010\u0010\'\u001A\u00020\u00172\u0006\u0010#\u001A\u00020$H\u0017J\u001C\u0010(\u001A\u00020\u00172\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*H\u0017J\b\u0010-\u001A\u00020\u0017H\u0017J\u0016\u0010.\u001A\u00020\u00172\f\u0010/\u001A\b\u0012\u0004\u0012\u0002000\u0019H\u0017J\u0010\u00101\u001A\u00020\u00172\u0006\u00102\u001A\u000203H\u0017J\b\u00104\u001A\u00020\u0017H\u0002J\b\u00105\u001A\u00020\u0017H\u0017J\f\u00105\u001A\u00020\u0017*\u00020\u0003H\u0002J\u0018\u00106\u001A\u00020\u00172\u0006\u00107\u001A\u0002082\u0006\u00109\u001A\u00020,H\u0017J\u0018\u0010:\u001A\u00020;2\u0006\u0010<\u001A\u00020;2\u0006\u0010=\u001A\u000200H\u0017J\u0018\u0010>\u001A\u00020;2\u0006\u0010<\u001A\u00020;2\u0006\u0010?\u001A\u00020@H\u0017J\u001C\u0010A\u001A\u00020\u00172\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0*H\u0017J\b\u0010D\u001A\u00020\u0017H\u0017J\u0018\u0010E\u001A\u00020\u00172\u0006\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020CH\u0017J&\u0010I\u001A\u00020\u00172\u0006\u0010F\u001A\u00020G2\u0006\u0010J\u001A\u00020K2\f\u0010L\u001A\b\u0012\u0004\u0012\u00020N0MH\u0017J\u0016\u0010O\u001A\u00020\u00172\f\u0010L\u001A\b\u0012\u0004\u0012\u00020N0MH\u0017J\u001E\u0010P\u001A\u00020\u00172\u0006\u0010 \u001A\u00020!2\f\u0010Q\u001A\b\u0012\u0004\u0012\u00020R0MH\u0017J\u0016\u0010S\u001A\u00020\u00172\f\u0010Q\u001A\b\u0012\u0004\u0012\u00020R0MH\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001A\u0004\u0018\u00010\u000B8AX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006U"}, d2={"Landroidx/window/embedding/EmbeddingCompat;", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "embeddingExtension", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "adapter", "Landroidx/window/embedding/EmbeddingAdapter;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "applicationContext", "Landroid/content/Context;", "overlayController", "Landroidx/window/embedding/OverlayControllerImpl;", "activityWindowInfoCallbackController", "Landroidx/window/embedding/ActivityWindowInfoCallbackController;", "<init>", "(Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;Landroidx/window/embedding/EmbeddingAdapter;Landroidx/window/core/ConsumerAdapter;Landroid/content/Context;Landroidx/window/embedding/OverlayControllerImpl;Landroidx/window/embedding/ActivityWindowInfoCallbackController;)V", "getOverlayController$window_release", "()Landroidx/window/embedding/OverlayControllerImpl;", "windowSdkExtensions", "Landroidx/window/WindowSdkExtensions;", "isCustomSplitAttributeCalculatorSet", "", "setRules", "", "rules", "", "Landroidx/window/embedding/EmbeddingRule;", "setEmbeddingCallback", "embeddingCallback", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "registerSplitInfoCallback", "isActivityEmbedded", "activity", "Landroid/app/Activity;", "pinTopActivityStack", "taskId", "", "splitPinRule", "Landroidx/window/embedding/SplitPinRule;", "unpinTopActivityStack", "setSplitAttributesCalculator", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "clearSplitAttributesCalculator", "finishActivityStacks", "activityStacks", "Landroidx/window/embedding/ActivityStack;", "setEmbeddingConfiguration", "embeddingConfig", "Landroidx/window/embedding/EmbeddingConfiguration;", "setDefaultSplitAttributeCalculatorIfNeeded", "invalidateVisibleActivityStacks", "updateSplitAttributes", "splitInfo", "Landroidx/window/embedding/SplitInfo;", "splitAttributes", "setLaunchingActivityStack", "Landroid/os/Bundle;", "options", "activityStack", "setOverlayCreateParams", "overlayCreateParams", "Landroidx/window/embedding/OverlayCreateParams;", "setOverlayAttributesCalculator", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "clearOverlayAttributesCalculator", "updateOverlayAttributes", "overlayTag", "", "overlayAttributes", "addOverlayInfoCallback", "executor", "Ljava/util/concurrent/Executor;", "overlayInfoCallback", "Landroidx/core/util/Consumer;", "Landroidx/window/embedding/OverlayInfo;", "removeOverlayInfoCallback", "addEmbeddedActivityWindowInfoCallbackForActivity", "callback", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "removeEmbeddedActivityWindowInfoCallbackForActivity", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmbeddingCompat implements EmbeddingInterfaceCompat {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001A\u00020\u0005J\u0006\u0010\t\u001A\u00020\nJ\b\u0010\u000B\u001A\u00020\nH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/window/embedding/EmbeddingCompat$Companion;", "", "<init>", "()V", "DEBUG", "", "TAG", "", "isEmbeddingAvailable", "embeddingComponent", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "emptyActivityEmbeddingProxy", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ActivityEmbeddingComponent embeddingComponent() {
            if(this.isEmbeddingAvailable()) {
                ClassLoader v0 = EmbeddingCompat.class.getClassLoader();
                if(v0 != null) {
                    ConsumerAdapter v2 = new ConsumerAdapter(v0);
                    WindowExtensions v3 = WindowExtensionsProvider.getWindowExtensions();
                    Intrinsics.checkNotNullExpressionValue(v3, "getWindowExtensions(...)");
                    ActivityEmbeddingComponent v0_1 = new SafeActivityEmbeddingComponentProvider(v0, v2, v3).getActivityEmbeddingComponent();
                    if(v0_1 == null) {
                    }
                    else {
                        return v0_1;
                    }
                }

                return this.emptyActivityEmbeddingProxy();
            }

            return this.emptyActivityEmbeddingProxy();
        }

        private final ActivityEmbeddingComponent emptyActivityEmbeddingProxy() {
            Object v3 = Proxy.newProxyInstance(EmbeddingCompat.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, new EmbeddingCompat$Companion$$ExternalSyntheticLambda0());
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type androidx.window.extensions.embedding.ActivityEmbeddingComponent");
            return ((ActivityEmbeddingComponent)v3);
        }

        static final Unit emptyActivityEmbeddingProxy$lambda$2(Object arg0, Method arg1, Object[] arg2) {
            return Unit.INSTANCE;
        }

        public final boolean isEmbeddingAvailable() {
            ActivityEmbeddingComponent v6_1;
            String v6 = "EmbeddingCompat";
            try {
                ClassLoader v1 = EmbeddingCompat.class.getClassLoader();
                if(v1 != null) {
                    ConsumerAdapter v3 = new ConsumerAdapter(v1);
                    WindowExtensions v4 = WindowExtensionsProvider.getWindowExtensions();
                    Intrinsics.checkNotNullExpressionValue(v4, "getWindowExtensions(...)");
                    v6_1 = new SafeActivityEmbeddingComponentProvider(v1, v3, v4).getActivityEmbeddingComponent();
                    if(v6_1 == null) {
                        return 0;
                    }

                    return 1;
                }

                return 0;
            }
            catch(UnsupportedOperationException ) {
                Log.d(((String)v6_1), "Stub Extension");
            }
            catch(NoClassDefFoundError ) {
                Log.d(((String)v6_1), "Embedding extension version not found");
            }

            return 0;
        }
    }

    public static final Companion Companion = null;
    public static final boolean DEBUG = true;
    private static final String TAG = "EmbeddingCompat";
    private final ActivityWindowInfoCallbackController activityWindowInfoCallbackController;
    private final EmbeddingAdapter adapter;
    private final Context applicationContext;
    private final ConsumerAdapter consumerAdapter;
    private final ActivityEmbeddingComponent embeddingExtension;
    private boolean isCustomSplitAttributeCalculatorSet;
    private final OverlayControllerImpl overlayController;
    private final WindowSdkExtensions windowSdkExtensions;

    static {
        EmbeddingCompat.Companion = new Companion(null);
    }

    public EmbeddingCompat(ActivityEmbeddingComponent arg2, EmbeddingAdapter arg3, ConsumerAdapter arg4, Context arg5, OverlayControllerImpl arg6, ActivityWindowInfoCallbackController arg7) {
        Intrinsics.checkNotNullParameter(arg2, "embeddingExtension");
        Intrinsics.checkNotNullParameter(arg3, "adapter");
        Intrinsics.checkNotNullParameter(arg4, "consumerAdapter");
        Intrinsics.checkNotNullParameter(arg5, "applicationContext");
        super();
        this.embeddingExtension = arg2;
        this.adapter = arg3;
        this.consumerAdapter = arg4;
        this.applicationContext = arg5;
        this.overlayController = arg6;
        this.activityWindowInfoCallbackController = arg7;
        this.windowSdkExtensions = WindowSdkExtensions.Companion.getInstance();
    }

    public void addEmbeddedActivityWindowInfoCallbackForActivity(Activity arg2, Consumer arg3) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        Intrinsics.checkNotNullParameter(arg3, "callback");
        ActivityWindowInfoCallbackController v0 = this.activityWindowInfoCallbackController;
        if(v0 != null) {
            v0.addCallback(arg2, arg3);
            return;
        }

        Log.w("EmbeddingCompat", "EmbeddedActivityWindowInfo is not supported on device less than version 6");
    }

    public void addOverlayInfoCallback(String arg2, Executor arg3, Consumer arg4) {
        Intrinsics.checkNotNullParameter(arg2, "overlayTag");
        Intrinsics.checkNotNullParameter(arg3, "executor");
        Intrinsics.checkNotNullParameter(arg4, "overlayInfoCallback");
        OverlayControllerImpl v0 = this.overlayController;
        if(v0 != null) {
            v0.addOverlayInfoCallback(arg2, arg3, arg4);
            return;
        }

        Log.w("EmbeddingCompat", "overlayInfo is not supported on device less than version 5");
        arg4.accept(new OverlayInfo(arg2, null, null));
    }

    public void clearOverlayAttributesCalculator() {
        this.windowSdkExtensions.requireExtensionVersion$window_release(8);
        OverlayControllerImpl v2 = this.overlayController;
        Intrinsics.checkNotNull(v2);
        v2.setOverlayAttributesCalculator$window_release(null);
    }

    public void clearSplitAttributesCalculator() {
        this.windowSdkExtensions.requireExtensionVersion$window_release(2);
        this.embeddingExtension.clearSplitAttributesCalculator();
        this.isCustomSplitAttributeCalculatorSet = false;
        this.setDefaultSplitAttributeCalculatorIfNeeded();
    }

    public void finishActivityStacks(Set arg3) {
        Intrinsics.checkNotNullParameter(arg3, "activityStacks");
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        ActivityEmbeddingComponent v2 = this.embeddingExtension;
        LinkedHashSet v0 = new LinkedHashSet();
        Iterator v3 = ((Iterable)arg3).iterator();
        while(v3.hasNext()) {
            ((Collection)v0).add(v3.next().getToken$window_release());
        }

        v2.finishActivityStacksWithTokens(((Set)v0));
    }

    public final OverlayControllerImpl getOverlayController$window_release() {
        return this.overlayController;
    }

    private final void invalidateVisibleActivityStacks(ActivityEmbeddingComponent arg1) {
        arg1.invalidateTopVisibleSplitAttributes();
    }

    public void invalidateVisibleActivityStacks() {
        this.windowSdkExtensions.requireExtensionVersion$window_release(3);
        this.invalidateVisibleActivityStacks(this.embeddingExtension);
    }

    public boolean isActivityEmbedded(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        return this.embeddingExtension.isActivityEmbedded(arg2);
    }

    public boolean pinTopActivityStack(int arg3, SplitPinRule arg4) {
        Intrinsics.checkNotNullParameter(arg4, "splitPinRule");
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        return this.embeddingExtension.pinTopActivityStack(arg3, this.adapter.translateSplitPinRule(this.applicationContext, arg4));
    }

    private final void registerSplitInfoCallback(EmbeddingCallbackInterface arg2) {
        this.embeddingExtension.setSplitInfoCallback(new EmbeddingCompat$$ExternalSyntheticLambda1(arg2, this));
    }

    static final void registerSplitInfoCallback$lambda$1(EmbeddingCallbackInterface arg1, EmbeddingCompat arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg3, "splitInfoList");
        arg1.onSplitInfoChanged(arg2.adapter.translate(arg3));
    }

    public void removeEmbeddedActivityWindowInfoCallbackForActivity(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "callback");
        ActivityWindowInfoCallbackController v1 = this.activityWindowInfoCallbackController;
        if(v1 != null) {
            v1.removeCallback(arg2);
        }
    }

    public void removeOverlayInfoCallback(Consumer arg2) {
        Intrinsics.checkNotNullParameter(arg2, "overlayInfoCallback");
        OverlayControllerImpl v1 = this.overlayController;
        if(v1 != null) {
            v1.removeOverlayInfoCallback(arg2);
        }
    }

    private final void setDefaultSplitAttributeCalculatorIfNeeded() {
        if(this.windowSdkExtensions.getExtensionVersion() >= 5 && !this.isCustomSplitAttributeCalculatorSet && this.adapter.getEmbeddingConfiguration() != null) {
            this.embeddingExtension.setSplitAttributesCalculator(new EmbeddingCompat$$ExternalSyntheticLambda2(this));
        }
    }

    static final SplitAttributes setDefaultSplitAttributeCalculatorIfNeeded$lambda$3(EmbeddingCompat arg1, SplitAttributesCalculatorParams arg2) {
        if(arg2.areDefaultConstraintsSatisfied()) {
            EmbeddingAdapter v1 = arg1.adapter;
            SplitAttributes v2 = arg2.getDefaultSplitAttributes();
            Intrinsics.checkNotNullExpressionValue(v2, "getDefaultSplitAttributes(...)");
            return v1.translateSplitAttributes(v1.translate$window_release(v2));
        }

        return arg1.adapter.translateSplitAttributes(new Builder().setSplitType(SplitType.SPLIT_TYPE_EXPAND).build());
    }

    public void setEmbeddingCallback(EmbeddingCallbackInterface arg5) {
        Intrinsics.checkNotNullParameter(arg5, "embeddingCallback");
        int v0 = this.windowSdkExtensions.getExtensionVersion();
        if(v0 == 1) {
            this.consumerAdapter.addConsumer(this.embeddingExtension, Reflection.getOrCreateKotlinClass(List.class), "setSplitInfoCallback", new EmbeddingCompat$$ExternalSyntheticLambda0(arg5, this));
            return;
        }

        int v2 = 5;
        if(2 <= v0 && v0 < v2) {
            this.registerSplitInfoCallback(arg5);
            return;
        }

        if(v2 <= v0 && v0 <= 0x7FFFFFFF) {
            this.registerSplitInfoCallback(arg5);
            this.embeddingExtension.registerActivityStackCallback(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ActivityStackConsumer(arg5, this.adapter));
        }
    }

    static final Unit setEmbeddingCallback$lambda$0(EmbeddingCallbackInterface arg3, EmbeddingCompat arg4, List arg5) {
        Intrinsics.checkNotNullParameter(arg5, "values");
        ArrayList v0 = new ArrayList();
        Iterator v5 = ((Iterable)arg5).iterator();
        while(v5.hasNext()) {
            Object v1 = v5.next();
            if(!(v1 instanceof SplitInfo)) {
                continue;
            }

            ((Collection)v0).add(v1);
        }

        arg3.onSplitInfoChanged(arg4.adapter.translate(((List)v0)));
        return Unit.INSTANCE;
    }

    public void setEmbeddingConfiguration(EmbeddingConfiguration arg3) {
        Intrinsics.checkNotNullParameter(arg3, "embeddingConfig");
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        this.adapter.setEmbeddingConfiguration(arg3);
        this.setDefaultSplitAttributeCalculatorIfNeeded();
        if(this.windowSdkExtensions.getExtensionVersion() >= 8) {
            try {
                this.embeddingExtension.setAutoSaveEmbeddingState(arg3.isAutoSaveEmbeddingState());
            }
            catch(Throwable v3) {
                Log.w("EmbeddingCompat", "#setAutoSaveEmbeddingState failed", v3);
            }
        }

        this.embeddingExtension.invalidateTopVisibleSplitAttributes();
    }

    public Bundle setLaunchingActivityStack(Bundle arg2, ActivityStack arg3) {
        Intrinsics.checkNotNullParameter(arg2, "options");
        Intrinsics.checkNotNullParameter(arg3, "activityStack");
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        ActivityEmbeddingOptionsImpl.INSTANCE.setActivityStackToken$window_release(arg2, arg3.getToken$window_release());
        return arg2;
    }

    public void setOverlayAttributesCalculator(Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "calculator");
        this.windowSdkExtensions.requireExtensionVersion$window_release(8);
        OverlayControllerImpl v2 = this.overlayController;
        Intrinsics.checkNotNull(v2);
        v2.setOverlayAttributesCalculator$window_release(arg3);
    }

    public Bundle setOverlayCreateParams(Bundle arg1, OverlayCreateParams arg2) {
        Intrinsics.checkNotNullParameter(arg1, "options");
        Intrinsics.checkNotNullParameter(arg2, "overlayCreateParams");
        ActivityEmbeddingOptionsImpl.INSTANCE.setOverlayCreateParams$window_release(arg1, arg2);
        return arg1;
    }

    public void setRules(Set arg3) {
        Intrinsics.checkNotNullParameter(arg3, "rules");
        Iterator v0 = arg3.iterator();
        do {
            if(v0.hasNext()) {
                if(!(v0.next() instanceof SplitRule)) {
                    continue;
                }

                break;
            }

            goto label_23;
        }
        while(true);

        if(!Intrinsics.areEqual(SplitController.Companion.getInstance(this.applicationContext).getSplitSupportStatus(), SplitSupportStatus.SPLIT_AVAILABLE)) {
            if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.LOG) {
                Log.w("EmbeddingCompat", "Cannot set SplitRule because ActivityEmbedding Split is not supported or PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED is not set.");
            }

            return;
        }

    label_23:
        this.embeddingExtension.setEmbeddingRules(this.adapter.translate(this.applicationContext, arg3));
    }

    public void setSplitAttributesCalculator(Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "calculator");
        this.windowSdkExtensions.requireExtensionVersion$window_release(2);
        this.embeddingExtension.setSplitAttributesCalculator(this.adapter.translateSplitAttributesCalculator(arg3));
        this.isCustomSplitAttributeCalculatorSet = true;
    }

    public void unpinTopActivityStack(int arg3) {
        this.windowSdkExtensions.requireExtensionVersion$window_release(5);
        this.embeddingExtension.unpinTopActivityStack(arg3);
    }

    public void updateOverlayAttributes(String arg3, OverlayAttributes arg4) {
        Intrinsics.checkNotNullParameter(arg3, "overlayTag");
        Intrinsics.checkNotNullParameter(arg4, "overlayAttributes");
        this.windowSdkExtensions.requireExtensionVersion$window_release(8);
        OverlayControllerImpl v2 = this.overlayController;
        Intrinsics.checkNotNull(v2);
        v2.updateOverlayAttributes$window_release(arg3, arg4);
    }

    public void updateSplitAttributes(androidx.window.embedding.SplitInfo arg4, androidx.window.embedding.SplitAttributes arg5) {
        Intrinsics.checkNotNullParameter(arg4, "splitInfo");
        Intrinsics.checkNotNullParameter(arg5, "splitAttributes");
        this.windowSdkExtensions.requireExtensionVersion$window_release(3);
        int v0 = this.windowSdkExtensions.getExtensionVersion();
        ActivityEmbeddingComponent v1 = this.embeddingExtension;
        if(v0 >= 5) {
            v1.updateSplitAttributes(arg4.getToken$window_release(), this.adapter.translateSplitAttributes(arg5));
            return;
        }

        v1.updateSplitAttributes(arg4.getBinder$window_release(), this.adapter.translateSplitAttributes(arg5));
    }
}

