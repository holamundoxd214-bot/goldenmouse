package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.util.Consumer;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 I2\u00020\u0001:\u0001IJ\u0016\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000E\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0006H&J\u0010\u0010\n\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0006H&J,\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H&J\u001C\u0010\u0014\u001A\u00020\u00032\u0012\u0010\u0015\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H&J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\f\u001A\u00020\rH&J\u0018\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\'J\u0010\u0010!\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u001EH\'J\u001C\u0010\"\u001A\u00020\u00032\u0012\u0010#\u001A\u000E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$H\'J\b\u0010\'\u001A\u00020\u0003H\'J\u0012\u0010(\u001A\u0004\u0018\u00010)2\u0006\u0010\f\u001A\u00020\rH&J\u0018\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020+2\u0006\u0010-\u001A\u00020)H\'J\u0018\u0010.\u001A\u00020+2\u0006\u0010,\u001A\u00020+2\u0006\u0010/\u001A\u000200H\'J\u0016\u00101\u001A\u00020\u00032\f\u00102\u001A\b\u0012\u0004\u0012\u00020)0\u0005H\'J\u0010\u00103\u001A\u00020\u00032\u0006\u00104\u001A\u000205H\'J\b\u00106\u001A\u00020\u0003H\'J\u0018\u00107\u001A\u00020\u00032\u0006\u00108\u001A\u00020\u00132\u0006\u00109\u001A\u00020&H\'J\u001C\u0010:\u001A\u00020\u00032\u0012\u0010#\u001A\u000E\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0$H\'J\b\u0010=\u001A\u00020\u0003H\'J\u0018\u0010>\u001A\u00020\u00032\u0006\u0010?\u001A\u00020@2\u0006\u0010A\u001A\u00020<H\'J&\u0010B\u001A\u00020\u00032\u0006\u0010?\u001A\u00020@2\u0006\u0010\u000E\u001A\u00020\u000F2\f\u0010C\u001A\b\u0012\u0004\u0012\u00020D0\u0011H\'J\u0016\u0010E\u001A\u00020\u00032\f\u0010C\u001A\b\u0012\u0004\u0012\u00020D0\u0011H\'J\u001E\u0010F\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020G0\u0011H\'J\u0016\u0010H\u001A\u00020\u00032\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020G0\u0011H\'R\u0012\u0010\u0016\u001A\u00020\u0017X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006JÀ\u0006\u0001"}, d2={"Landroidx/window/embedding/EmbeddingBackend;", "", "setRules", "", "rules", "", "Landroidx/window/embedding/EmbeddingRule;", "getRules", "addRule", "rule", "removeRule", "addSplitListenerForActivity", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "", "Landroidx/window/embedding/SplitInfo;", "removeSplitListenerForActivity", "consumer", "splitSupportStatus", "Landroidx/window/embedding/SplitController$SplitSupportStatus;", "getSplitSupportStatus", "()Landroidx/window/embedding/SplitController$SplitSupportStatus;", "isActivityEmbedded", "", "pinTopActivityStack", "taskId", "", "splitPinRule", "Landroidx/window/embedding/SplitPinRule;", "unpinTopActivityStack", "setSplitAttributesCalculator", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "clearSplitAttributesCalculator", "getActivityStack", "Landroidx/window/embedding/ActivityStack;", "setLaunchingActivityStack", "Landroid/os/Bundle;", "options", "activityStack", "setOverlayCreateParams", "overlayCreateParams", "Landroidx/window/embedding/OverlayCreateParams;", "finishActivityStacks", "activityStacks", "setEmbeddingConfiguration", "embeddingConfig", "Landroidx/window/embedding/EmbeddingConfiguration;", "invalidateVisibleActivityStacks", "updateSplitAttributes", "splitInfo", "splitAttributes", "setOverlayAttributesCalculator", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "clearOverlayAttributesCalculator", "updateOverlayAttributes", "overlayTag", "", "overlayAttributes", "addOverlayInfoCallback", "overlayInfoCallback", "Landroidx/window/embedding/OverlayInfo;", "removeOverlayInfoCallback", "addEmbeddedActivityWindowInfoCallbackForActivity", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "removeEmbeddedActivityWindowInfoCallbackForActivity", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface EmbeddingBackend {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\tH\u0007J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007J\b\u0010\u000E\u001A\u00020\u000BH\u0007R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/window/embedding/EmbeddingBackend$Companion;", "", "<init>", "()V", "decorator", "Lkotlin/Function1;", "Landroidx/window/embedding/EmbeddingBackend;", "getInstance", "context", "Landroid/content/Context;", "overrideDecorator", "", "overridingDecorator", "Landroidx/window/embedding/EmbeddingBackendDecorator;", "reset", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static Function1 decorator;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.decorator = new EmbeddingBackend$Companion$$ExternalSyntheticLambda1();
        }

        private Companion() {
            super();
        }

        static final EmbeddingBackend decorator$lambda$0(EmbeddingBackend arg1) {
            Intrinsics.checkNotNullParameter(arg1, "it");
            return arg1;
        }

        @JvmStatic public final EmbeddingBackend getInstance(Context arg2) {
            Intrinsics.checkNotNullParameter(arg2, "context");
            return Companion.decorator.invoke(ExtensionEmbeddingBackend.Companion.getInstance(arg2));
        }

        @JvmStatic public final void overrideDecorator(EmbeddingBackendDecorator arg1) {
            Intrinsics.checkNotNullParameter(arg1, "overridingDecorator");
            Companion.decorator = new EmbeddingBackend$Companion$overrideDecorator$1(arg1);
        }

        @JvmStatic public final void reset() {
            Companion.decorator = new EmbeddingBackend$Companion$$ExternalSyntheticLambda0();
        }

        static final EmbeddingBackend reset$lambda$1(EmbeddingBackend arg1) {
            Intrinsics.checkNotNullParameter(arg1, "it");
            return arg1;
        }
    }

    public static final Companion Companion;

    static {
        EmbeddingBackend.Companion = Companion.$$INSTANCE;
    }

    void addEmbeddedActivityWindowInfoCallbackForActivity(Activity arg1, Consumer arg2);

    void addOverlayInfoCallback(String arg1, Executor arg2, Consumer arg3);

    void addRule(EmbeddingRule arg1);

    void addSplitListenerForActivity(Activity arg1, Executor arg2, Consumer arg3);

    void clearOverlayAttributesCalculator();

    void clearSplitAttributesCalculator();

    void finishActivityStacks(Set arg1);

    ActivityStack getActivityStack(Activity arg1);

    @JvmStatic static EmbeddingBackend getInstance(Context arg1) {
        return EmbeddingBackend.Companion.getInstance(arg1);
    }

    Set getRules();

    SplitSupportStatus getSplitSupportStatus();

    void invalidateVisibleActivityStacks();

    boolean isActivityEmbedded(Activity arg1);

    @JvmStatic static void overrideDecorator(EmbeddingBackendDecorator arg1) {
        EmbeddingBackend.Companion.overrideDecorator(arg1);
    }

    boolean pinTopActivityStack(int arg1, SplitPinRule arg2);

    void removeEmbeddedActivityWindowInfoCallbackForActivity(Consumer arg1);

    void removeOverlayInfoCallback(Consumer arg1);

    void removeRule(EmbeddingRule arg1);

    void removeSplitListenerForActivity(Consumer arg1);

    @JvmStatic static void reset() {
        EmbeddingBackend.Companion.reset();
    }

    void setEmbeddingConfiguration(EmbeddingConfiguration arg1);

    Bundle setLaunchingActivityStack(Bundle arg1, ActivityStack arg2);

    void setOverlayAttributesCalculator(Function1 arg1);

    Bundle setOverlayCreateParams(Bundle arg1, OverlayCreateParams arg2);

    void setRules(Set arg1);

    void setSplitAttributesCalculator(Function1 arg1);

    void unpinTopActivityStack(int arg1);

    void updateOverlayAttributes(String arg1, OverlayAttributes arg2);

    void updateSplitAttributes(SplitInfo arg1, SplitAttributes arg2);
}

