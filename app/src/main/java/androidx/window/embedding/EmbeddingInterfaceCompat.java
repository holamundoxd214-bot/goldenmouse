package androidx.window.embedding;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.util.Consumer;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001?J\u0016\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\tH&J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH&J\u0018\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\'J\u0010\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0010H\'J\u001C\u0010\u0014\u001A\u00020\u00032\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\'J\b\u0010\u0019\u001A\u00020\u0003H\'J\u0018\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u001EH\'J\u0018\u0010\u001F\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020!H\'J\u0016\u0010\"\u001A\u00020\u00032\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\u001E0\u0005H\'J\u0010\u0010$\u001A\u00020\u00032\u0006\u0010%\u001A\u00020&H\'J\b\u0010\'\u001A\u00020\u0003H\'J\u0018\u0010(\u001A\u00020\u00032\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u0018H\'J\u001C\u0010,\u001A\u00020\u00032\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u0016H\'J\b\u0010/\u001A\u00020\u0003H\'J\u0018\u00100\u001A\u00020\u00032\u0006\u00101\u001A\u0002022\u0006\u00103\u001A\u00020.H\'J&\u00104\u001A\u00020\u00032\u0006\u00101\u001A\u0002022\u0006\u00105\u001A\u0002062\f\u00107\u001A\b\u0012\u0004\u0012\u00020908H\'J\u0016\u0010:\u001A\u00020\u00032\f\u00107\u001A\b\u0012\u0004\u0012\u00020908H\'J\u001E\u0010;\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\f\u0010<\u001A\b\u0012\u0004\u0012\u00020=08H\'J\u0016\u0010>\u001A\u00020\u00032\f\u0010<\u001A\b\u0012\u0004\u0012\u00020=08H\'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006@À\u0006\u0001"}, d2={"Landroidx/window/embedding/EmbeddingInterfaceCompat;", "", "setRules", "", "rules", "", "Landroidx/window/embedding/EmbeddingRule;", "setEmbeddingCallback", "embeddingCallback", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "isActivityEmbedded", "", "activity", "Landroid/app/Activity;", "pinTopActivityStack", "taskId", "", "splitPinRule", "Landroidx/window/embedding/SplitPinRule;", "unpinTopActivityStack", "setSplitAttributesCalculator", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "Landroidx/window/embedding/SplitAttributes;", "clearSplitAttributesCalculator", "setLaunchingActivityStack", "Landroid/os/Bundle;", "options", "activityStack", "Landroidx/window/embedding/ActivityStack;", "setOverlayCreateParams", "overlayCreateParams", "Landroidx/window/embedding/OverlayCreateParams;", "finishActivityStacks", "activityStacks", "setEmbeddingConfiguration", "embeddingConfig", "Landroidx/window/embedding/EmbeddingConfiguration;", "invalidateVisibleActivityStacks", "updateSplitAttributes", "splitInfo", "Landroidx/window/embedding/SplitInfo;", "splitAttributes", "setOverlayAttributesCalculator", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "clearOverlayAttributesCalculator", "updateOverlayAttributes", "overlayTag", "", "overlayAttributes", "addOverlayInfoCallback", "executor", "Ljava/util/concurrent/Executor;", "overlayInfoCallback", "Landroidx/core/util/Consumer;", "Landroidx/window/embedding/OverlayInfo;", "removeOverlayInfoCallback", "addEmbeddedActivityWindowInfoCallbackForActivity", "callback", "Landroidx/window/embedding/EmbeddedActivityWindowInfo;", "removeEmbeddedActivityWindowInfoCallbackForActivity", "EmbeddingCallbackInterface", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface EmbeddingInterfaceCompat {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001A\u00020\u00032\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "", "onSplitInfoChanged", "", "splitInfo", "", "Landroidx/window/embedding/SplitInfo;", "onActivityStackChanged", "activityStacks", "Landroidx/window/embedding/ActivityStack;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public interface EmbeddingCallbackInterface {
        void onActivityStackChanged(List arg1);

        void onSplitInfoChanged(List arg1);
    }

    void addEmbeddedActivityWindowInfoCallbackForActivity(Activity arg1, Consumer arg2);

    void addOverlayInfoCallback(String arg1, Executor arg2, Consumer arg3);

    void clearOverlayAttributesCalculator();

    void clearSplitAttributesCalculator();

    void finishActivityStacks(Set arg1);

    void invalidateVisibleActivityStacks();

    boolean isActivityEmbedded(Activity arg1);

    boolean pinTopActivityStack(int arg1, SplitPinRule arg2);

    void removeEmbeddedActivityWindowInfoCallbackForActivity(Consumer arg1);

    void removeOverlayInfoCallback(Consumer arg1);

    void setEmbeddingCallback(EmbeddingCallbackInterface arg1);

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

