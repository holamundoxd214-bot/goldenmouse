package androidx.window.embedding;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.WindowMetrics;
import androidx.core.util.Consumer;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.ActivityStack$Token;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.ActivityStackAttributes$Builder;
import androidx.window.extensions.embedding.ActivityStackAttributes;
import androidx.window.extensions.embedding.ActivityStackAttributesCalculatorParams;
import androidx.window.extensions.embedding.ParentContainerInfo;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetricsCalculator$Companion;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter;
import androidx.window.layout.util.DensityCompatHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u008E\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001F\u001A\u00020 2\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00150\"H\u0003J7\u0010#\u001A\u00020\r2\u0006\u0010$\u001A\u00020\u00152\b\u0010%\u001A\u0004\u0018\u00010\r2\u0006\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020+H\u0001¢\u0006\u0002\b,J\u0017\u0010-\u001A\u0004\u0018\u00010\r2\u0006\u0010.\u001A\u00020\u0015H\u0011¢\u0006\u0002\b/J\u001D\u00100\u001A\u00020 2\u0006\u0010.\u001A\u00020\u00152\u0006\u00101\u001A\u00020\rH\u0010¢\u0006\u0002\b2J\u0014\u00103\u001A\u000204*\u00020\r2\u0006\u00105\u001A\u000206H\u0002J\u0018\u00107\u001A\b\u0012\u0004\u0012\u00020\u00190\u001E*\b\u0012\u0004\u0012\u00020\u00190\u001EH\u0002J&\u00108\u001A\u00020 2\u0006\u0010.\u001A\u00020\u00152\u0006\u00109\u001A\u00020:2\f\u0010;\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BH\u0016J\f\u0010<\u001A\u00020\u001C*\u00020\u0019H\u0002J\u0016\u0010=\u001A\u00020 2\f\u0010;\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000B2\u0014\u0010\n\u001A\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000B8@@@X\u0081\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00190\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R.\u0010\u001A\u001A \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001C0\u001B\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001E0\u001D0\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2={"Landroidx/window/embedding/OverlayControllerImpl;", "", "embeddingExtension", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "adapter", "Landroidx/window/embedding/EmbeddingAdapter;", "<init>", "(Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;Landroidx/window/embedding/EmbeddingAdapter;)V", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "value", "Lkotlin/Function1;", "Landroidx/window/embedding/OverlayAttributesCalculatorParams;", "Landroidx/window/embedding/OverlayAttributes;", "overlayAttributesCalculator", "getOverlayAttributesCalculator$window_release", "()Lkotlin/jvm/functions/Function1;", "setOverlayAttributesCalculator$window_release", "(Lkotlin/jvm/functions/Function1;)V", "overlayTagToDefaultAttributesMap", "", "", "overlayTagToCurrentAttributesMap", "Landroid/util/ArrayMap;", "overlayTagToContainerMap", "Landroidx/window/extensions/embedding/ActivityStack;", "overlayInfoToActivityStackCallbackMap", "Landroidx/core/util/Consumer;", "Landroidx/window/embedding/OverlayInfo;", "Landroidx/window/extensions/core/util/function/Consumer;", "", "cleanUpDismissedOverlayContainerRecords", "", "lastOverlayTags", "", "calculateOverlayAttributes", "tag", "initialOverlayAttrs", "windowMetrics", "Landroidx/window/layout/WindowMetrics;", "configuration", "Landroid/content/res/Configuration;", "windowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "calculateOverlayAttributes$window_release", "getUpdatedOverlayAttributes", "overlayTag", "getUpdatedOverlayAttributes$window_release", "updateOverlayAttributes", "overlayAttributes", "updateOverlayAttributes$window_release", "toActivityStackAttributes", "Landroidx/window/extensions/embedding/ActivityStackAttributes;", "parentContainerInfo", "Landroidx/window/extensions/embedding/ParentContainerInfo;", "getOverlayContainers", "addOverlayInfoCallback", "executor", "Ljava/util/concurrent/Executor;", "overlayInfoCallback", "toOverlayInfo", "removeOverlayInfoCallback", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public class OverlayControllerImpl {
    private final EmbeddingAdapter adapter;
    private final ActivityEmbeddingComponent embeddingExtension;
    private final ReentrantLock globalLock;
    private Function1 overlayAttributesCalculator;
    private final ArrayMap overlayInfoToActivityStackCallbackMap;
    private final ArrayMap overlayTagToContainerMap;
    private final ArrayMap overlayTagToCurrentAttributesMap;
    private final Map overlayTagToDefaultAttributesMap;

    public OverlayControllerImpl(ActivityEmbeddingComponent arg2, EmbeddingAdapter arg3) {
        Intrinsics.checkNotNullParameter(arg2, "embeddingExtension");
        Intrinsics.checkNotNullParameter(arg3, "adapter");
        super();
        this.embeddingExtension = arg2;
        this.adapter = arg3;
        this.globalLock = new ReentrantLock();
        this.overlayTagToDefaultAttributesMap = new ArrayMap();
        this.overlayTagToCurrentAttributesMap = new ArrayMap();
        this.overlayTagToContainerMap = new ArrayMap();
        this.overlayInfoToActivityStackCallbackMap = new ArrayMap();
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(8);
        arg2.setActivityStackAttributesCalculator(new OverlayControllerImpl$$ExternalSyntheticLambda0(this));
        arg2.registerActivityStackCallback(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new OverlayControllerActivityStackConsumer(new OverlayControllerImpl$$ExternalSyntheticLambda1(this)));
    }

    static final ActivityStackAttributes _init_$lambda$3(OverlayControllerImpl arg13, ActivityStackAttributesCalculatorParams arg14) {
        ActivityStackAttributes v13_1;
        String v0 = "getLaunchOptions(...)";
        String v1 = "getConfiguration(...)";
        String v2 = "getWindowMetrics(...)";
        ReentrantLock v3 = arg13.globalLock;
        ((Lock)v3).lock();
        try {
            ParentContainerInfo v4 = arg14.getParentContainerInfo();
            Intrinsics.checkNotNullExpressionValue(v4, "getParentContainerInfo(...)");
            DensityCompatHelper v5 = DensityCompatHelper.Companion.getInstance();
            Configuration v6 = v4.getConfiguration();
            Intrinsics.checkNotNullExpressionValue(v6, v1);
            WindowMetrics v7 = v4.getWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(v7, v2);
            float v5_1 = v5.density(v6, v7);
            Companion v6_1 = WindowMetricsCalculator.Companion;
            v7 = v4.getWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(v7, v2);
            androidx.window.layout.WindowMetrics v6_2 = v6_1.translateWindowMetrics$window_release(v7, v5_1);
            String v8 = arg14.getActivityStackTag();
            Intrinsics.checkNotNullExpressionValue(v8, "getActivityStackTag(...)");
            ActivityEmbeddingOptionsImpl v7_1 = ActivityEmbeddingOptionsImpl.INSTANCE;
            Bundle v9 = arg14.getLaunchOptions();
            Intrinsics.checkNotNullExpressionValue(v9, v0);
            OverlayAttributes v9_1 = v7_1.getOverlayAttributes$window_release(v9);
            Companion v7_2 = WindowMetricsCalculator.Companion;
            WindowMetrics v10 = arg14.getParentContainerInfo().getWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(v10, v2);
            androidx.window.layout.WindowMetrics v10_1 = v7_2.translateWindowMetrics$window_release(v10, v5_1);
            Configuration v11 = arg14.getParentContainerInfo().getConfiguration();
            Intrinsics.checkNotNullExpressionValue(v11, v1);
            ExtensionsWindowLayoutInfoAdapter v1_1 = ExtensionsWindowLayoutInfoAdapter.INSTANCE;
            WindowLayoutInfo v2_1 = v4.getWindowLayoutInfo();
            Intrinsics.checkNotNullExpressionValue(v2_1, "getWindowLayoutInfo(...)");
            OverlayControllerImpl v7_3 = arg13;
            OverlayAttributes v13 = v7_3.calculateOverlayAttributes$window_release(v8, v9_1, v10_1, v11, v1_1.translate$window_release(v6_2, v2_1));
            ActivityEmbeddingOptionsImpl v1_2 = ActivityEmbeddingOptionsImpl.INSTANCE;
            Bundle v14 = arg14.getLaunchOptions();
            Intrinsics.checkNotNullExpressionValue(v14, v0);
            v1_2.putActivityStackAlignment$window_release(v14, v13.getBounds());
            v13_1 = v7_3.toActivityStackAttributes(v13, v4);
        }
        catch(Throwable v0_1) {
            ((Lock)v3).unlock();
            throw v0_1;
        }

        ((Lock)v3).unlock();
        return v13_1;
    }

    static final Unit _init_$lambda$6(OverlayControllerImpl arg7, List arg8) {
        Intrinsics.checkNotNullParameter(arg8, "activityStacks");
        ReentrantLock v0 = arg7.globalLock;
        ((Lock)v0).lock();
        try {
            Set v1 = arg7.overlayTagToContainerMap.keySet();
            Intrinsics.checkNotNullExpressionValue(v1, "<get-keys>(...)");
            arg7.overlayTagToContainerMap.clear();
            ArrayMap v2 = arg7.overlayTagToContainerMap;
            arg8 = arg7.getOverlayContainers(arg8);
            ArrayList v3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)arg8), 10));
            Iterator v8 = ((Iterable)arg8).iterator();
            while(v8.hasNext()) {
                Object v4 = v8.next();
                String v6 = ((ActivityStack)v4).getTag();
                Intrinsics.checkNotNull(v6);
                ((Collection)v3).add(new Pair(v6, v4));
            }

            MapsKt.putAll(((Map)v2), ((Iterable)v3));
            arg7.cleanUpDismissedOverlayContainerRecords(v1);
        }
        catch(Throwable v7) {
            goto label_33;
        }

        ((Lock)v0).unlock();
        return Unit.INSTANCE;
    label_33:
        ((Lock)v0).unlock();
        throw v7;
    }

    public void addOverlayInfoCallback(String arg3, Executor arg4, Consumer arg5) {
        Intrinsics.checkNotNullParameter(arg3, "overlayTag");
        Intrinsics.checkNotNullParameter(arg4, "executor");
        Intrinsics.checkNotNullParameter(arg5, "overlayInfoCallback");
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            OverlayControllerImpl$$ExternalSyntheticLambda2 v1 = new OverlayControllerImpl$$ExternalSyntheticLambda2(arg3, this, arg5);
            this.overlayInfoToActivityStackCallbackMap.put(arg5, v1);
            this.embeddingExtension.registerActivityStackCallback(arg4, ((androidx.window.extensions.core.util.function.Consumer)v1));
        }
        catch(Throwable v2) {
            ((Lock)v0).unlock();
            throw v2;
        }

        ((Lock)v0).unlock();
    }

    static final void addOverlayInfoCallback$lambda$11$lambda$10(String arg3, OverlayControllerImpl arg4, Consumer arg5, List arg6) {
        Intrinsics.checkNotNullParameter(arg6, "activityStacks");
        ArrayList v0 = new ArrayList();
        Iterator v6 = ((Iterable)arg6).iterator();
        while(v6.hasNext()) {
            Object v1 = v6.next();
            if(!Intrinsics.areEqual(v1.getTag(), arg3)) {
                continue;
            }

            ((Collection)v0).add(v1);
        }

        if(((List)v0).size() <= 1) {
            OverlayInfo v4 = ((List)v0).isEmpty() ? new OverlayInfo(arg3, null, null) : arg4.toOverlayInfo(CollectionsKt.first(((List)v0)));
            arg5.accept(v4);
            return;
        }

        throw new IllegalStateException("There must be at most one overlay ActivityStack with " + arg3);
    }

    public final OverlayAttributes calculateOverlayAttributes$window_release(String arg7, OverlayAttributes arg8, androidx.window.layout.WindowMetrics arg9, Configuration arg10, androidx.window.layout.WindowLayoutInfo arg11) {
        Object v5_1;
        String v4;
        OverlayAttributes v5;
        Intrinsics.checkNotNullParameter(arg7, "tag");
        Intrinsics.checkNotNullParameter(arg9, "windowMetrics");
        Intrinsics.checkNotNullParameter(arg10, "configuration");
        Intrinsics.checkNotNullParameter(arg11, "windowLayoutInfo");
        OverlayAttributes v0 = this.getUpdatedOverlayAttributes$window_release(arg7);
        if(v0 != null) {
            v5 = v0;
        }
        else if(arg8 != null) {
            v5 = arg8;
        }
        else {
            throw new IllegalArgumentException("Can\'t retrieve overlay attributes from launch options");
        }

        Function1 v8 = this.getOverlayAttributesCalculator$window_release();
        if(v8 != null) {
            v4 = arg7;
            Object v7 = v8.invoke(new OverlayAttributesCalculatorParams(arg9, arg10, arg11, v4, v5));
            if(v7 == null) {
            }
            else {
                v5_1 = v7;
            }
        }
        else {
            v4 = arg7;
        }

        this.overlayTagToCurrentAttributesMap.put(v4, v5_1);
        return ((OverlayAttributes)v5_1);
    }

    private final void cleanUpDismissedOverlayContainerRecords(Set arg5) {
        if(arg5.isEmpty()) {
        }
        else {
            ArrayList v0 = new ArrayList();
            Set v1 = this.overlayTagToContainerMap.keySet();
            Intrinsics.checkNotNullExpressionValue(v1, "<get-keys>(...)");
            Iterator v5 = arg5.iterator();
            while(v5.hasNext()) {
                Object v2 = v5.next();
                if(v1.contains(v2)) {
                    continue;
                }

                if(this.embeddingExtension.getActivityStackToken(((String)v2)) != null) {
                    continue;
                }

                v0.add(v2);
            }

            v5 = v0.iterator();
            Intrinsics.checkNotNullExpressionValue(v5, "iterator(...)");
            while(v5.hasNext()) {
                Object v0_1 = v5.next();
                Intrinsics.checkNotNullExpressionValue(v0_1, "next(...)");
                this.overlayTagToDefaultAttributesMap.remove(v0_1);
                this.overlayTagToCurrentAttributesMap.remove(v0_1);
            }
        }
    }

    public final Function1 getOverlayAttributesCalculator$window_release() {
        Function1 v1_1;
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            v1_1 = this.overlayAttributesCalculator;
        }
        catch(Throwable v1) {
            ((Lock)v0).unlock();
            throw v1;
        }

        ((Lock)v0).unlock();
        return v1_1;
    }

    private final List getOverlayContainers(List arg3) {
        ArrayList v2 = new ArrayList();
        Iterator v3 = ((Iterable)arg3).iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            if(v0.getTag() == null) {
                continue;
            }

            ((Collection)v2).add(v0);
        }

        return CollectionsKt.toList(((Iterable)v2));
    }

    public OverlayAttributes getUpdatedOverlayAttributes$window_release(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "overlayTag");
        return this.overlayTagToDefaultAttributesMap.get(arg2);
    }

    public void removeOverlayInfoCallback(Consumer arg3) {
        Intrinsics.checkNotNullParameter(arg3, "overlayInfoCallback");
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            Object v3 = this.overlayInfoToActivityStackCallbackMap.remove(arg3);
            if(v3 != null) {
                this.embeddingExtension.unregisterActivityStackCallback(((androidx.window.extensions.core.util.function.Consumer)v3));
            }
        }
        catch(Throwable v2) {
            ((Lock)v0).unlock();
            throw v2;
        }

        ((Lock)v0).unlock();
    }

    public final void setOverlayAttributesCalculator$window_release(Function1 arg2) {
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            this.overlayAttributesCalculator = arg2;
        }
        catch(Throwable v1) {
            ((Lock)v0).unlock();
            throw v1;
        }

        ((Lock)v0).unlock();
    }

    private final ActivityStackAttributes toActivityStackAttributes(OverlayAttributes arg4, ParentContainerInfo arg5) {
        ActivityStackAttributes v3 = new ActivityStackAttributes$Builder().setRelativeBounds(EmbeddingBounds.Companion.translateEmbeddingBounds$window_release(arg4.getBounds(), this.adapter.translate$window_release(arg5)).toRect()).setWindowAttributes(this.adapter.translateWindowAttributes$window_release()).build();
        Intrinsics.checkNotNullExpressionValue(v3, "build(...)");
        return v3;
    }

    private final OverlayInfo toOverlayInfo(ActivityStack arg5) {
        String v1 = arg5.getTag();
        Intrinsics.checkNotNull(v1);
        ArrayMap v2 = this.overlayTagToCurrentAttributesMap;
        String v3 = arg5.getTag();
        Intrinsics.checkNotNull(v3);
        return new OverlayInfo(v1, v2.get(v3), this.adapter.translate$window_release(arg5));
    }

    public void updateOverlayAttributes$window_release(String arg5, OverlayAttributes arg6) {
        ActivityStack$Token v1_1;
        Intrinsics.checkNotNullParameter(arg5, "overlayTag");
        Intrinsics.checkNotNullParameter(arg6, "overlayAttributes");
        ReentrantLock v0 = this.globalLock;
        ((Lock)v0).lock();
        try {
            Object v1 = this.overlayTagToContainerMap.get(arg5);
            if(v1 != null) {
                v1_1 = ((ActivityStack)v1).getActivityStackToken();
                if(v1_1 == null) {
                    goto label_11;
                }
            }
            else {
            label_11:
                v1_1 = this.embeddingExtension.getActivityStackToken(arg5);
                if(v1_1 == null) {
                    goto label_14;
                }
            }

            goto label_16;
        }
        catch(Throwable v4) {
            goto label_29;
        }

    label_14:
        ((Lock)v0).unlock();
        return;
        try {
        label_16:
            ActivityEmbeddingComponent v2 = this.embeddingExtension;
            ParentContainerInfo v3 = v2.getParentContainerInfo(v1_1);
            Intrinsics.checkNotNull(v3);
            v2.updateActivityStackAttributes(v1_1, this.toActivityStackAttributes(arg6, v3));
            this.overlayTagToDefaultAttributesMap.put(arg5, arg6);
            this.overlayTagToCurrentAttributesMap.put(arg5, arg6);
        }
        catch(Throwable v4) {
        label_29:
            ((Lock)v0).unlock();
            throw v4;
        }

        ((Lock)v0).unlock();
    }
}

