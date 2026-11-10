package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.view.WindowMetrics;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.core.util.function.Function;
import androidx.window.extensions.core.util.function.Predicate;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.ActivityRule$Builder;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack$Token;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.ActivityStackAttributes$Builder;
import androidx.window.extensions.embedding.ActivityStackAttributes;
import androidx.window.extensions.embedding.ActivityStackAttributesCalculatorParams;
import androidx.window.extensions.embedding.AnimationBackground$ColorBackground;
import androidx.window.extensions.embedding.AnimationBackground;
import androidx.window.extensions.embedding.AnimationParams$Builder;
import androidx.window.extensions.embedding.AnimationParams;
import androidx.window.extensions.embedding.DividerAttributes$Builder;
import androidx.window.extensions.embedding.DividerAttributes;
import androidx.window.extensions.embedding.EmbeddedActivityWindowInfo;
import androidx.window.extensions.embedding.ParentContainerInfo;
import androidx.window.extensions.embedding.SplitAttributes$Builder;
import androidx.window.extensions.embedding.SplitAttributes$SplitType$ExpandContainersSplitType;
import androidx.window.extensions.embedding.SplitAttributes$SplitType$HingeSplitType;
import androidx.window.extensions.embedding.SplitAttributes$SplitType$RatioSplitType;
import androidx.window.extensions.embedding.SplitAttributes$SplitType;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitAttributesCalculatorParams;
import androidx.window.extensions.embedding.SplitInfo$Token;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule$Builder;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPinRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule$Builder;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import androidx.window.extensions.embedding.SplitRule;
import androidx.window.extensions.embedding.WindowAttributes;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\bB\b\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001A\u00020\u0011H\u0002J\r\u0010\u0012\u001A\u00020\u0011H\u0001¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001A\u00020\u0011H\u0001¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001A\u00020\u0011H\u0001¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001A\u00020\u0011H\u0001¢\u0006\u0002\b\u0019J\r\u0010\u001A\u001A\u00020\u0011H\u0001¢\u0006\u0002\b\u001BJ\r\u0010\u001C\u001A\u00020\u0011H\u0001¢\u0006\u0002\b\u001DJ\r\u0010\u001E\u001A\u00020\u0011H\u0001¢\u0006\u0002\b\u001FJ\r\u0010 \u001A\u00020\u0011H\u0001¢\u0006\u0002\b!J\b\u0010\"\u001A\u00020\u0011H\u0002J\b\u0010\'\u001A\u00020\u0011H\u0002J\b\u0010(\u001A\u00020\u0011H\u0002J\b\u0010)\u001A\u00020\u0011H\u0002J\b\u0010*\u001A\u00020\u0011H\u0002J\b\u0010+\u001A\u00020\u0011H\u0002J\b\u0010,\u001A\u00020\u0011H\u0002J\b\u0010-\u001A\u00020\u0011H\u0002J\b\u0010.\u001A\u00020\u0011H\u0002J\b\u0010/\u001A\u00020\u0011H\u0002J\b\u00100\u001A\u00020\u0011H\u0002J\b\u00101\u001A\u00020\u0011H\u0002J\b\u00102\u001A\u00020\u0011H\u0002J\b\u00103\u001A\u00020\u0011H\u0002J\b\u00104\u001A\u00020\u0011H\u0002J\b\u00105\u001A\u00020\u0011H\u0002J\b\u00106\u001A\u00020\u0011H\u0002J\b\u00107\u001A\u00020\u0011H\u0002J\b\u00108\u001A\u00020\u0011H\u0002J\b\u00109\u001A\u00020\u0011H\u0002J\b\u0010:\u001A\u00020\u0011H\u0002J\b\u0010;\u001A\u00020\u0011H\u0002J\b\u0010<\u001A\u00020\u0011H\u0002J\b\u0010=\u001A\u00020\u0011H\u0002J\b\u0010>\u001A\u00020\u0011H\u0002J\b\u0010?\u001A\u00020\u0011H\u0002J\b\u0010@\u001A\u00020\u0011H\u0002J\b\u0010A\u001A\u00020\u0011H\u0002J\b\u0010B\u001A\u00020\u0011H\u0002J\b\u0010C\u001A\u00020\u0011H\u0002J\b\u0010D\u001A\u00020\u0011H\u0002J\b\u0010E\u001A\u00020\u0011H\u0002J\b\u0010F\u001A\u00020\u0011H\u0002J\b\u0010G\u001A\u00020\u0011H\u0002J\b\u0010H\u001A\u00020\u0011H\u0002J\b\u0010I\u001A\u00020\u0011H\u0002J\b\u0010J\u001A\u00020\u0011H\u0002J\b\u0010K\u001A\u00020\u0011H\u0002J\b\u0010L\u001A\u00020\u0011H\u0002J\b\u0010M\u001A\u00020\u0011H\u0002J\b\u0010N\u001A\u00020\u0011H\u0002J\b\u0010O\u001A\u00020\u0011H\u0002J\b\u0010P\u001A\u00020\u0011H\u0002J\b\u0010Q\u001A\u00020\u0011H\u0002J\b\u0010R\u001A\u00020\u0011H\u0002J\b\u0010S\u001A\u00020\u0011H\u0002J\b\u0010T\u001A\u00020\u0011H\u0002J\b\u0010U\u001A\u00020\u0011H\u0002J\b\u0010V\u001A\u00020\u0011H\u0002J\b\u0010W\u001A\u00020\u0011H\u0002J\b\u0010X\u001A\u00020\u0011H\u0002J\b\u0010Y\u001A\u00020\u0011H\u0002J\b\u0010Z\u001A\u00020\u0011H\u0002J\b\u0010[\u001A\u00020\u0011H\u0002J\b\u0010\\\u001A\u00020\u0011H\u0002J\b\u0010]\u001A\u00020\u0011H\u0002J\b\u0010^\u001A\u00020\u0011H\u0002J\b\u0010_\u001A\u00020\u0011H\u0002J\b\u0010`\u001A\u00020\u0011H\u0002J\b\u0010a\u001A\u00020\u0011H\u0002J\b\u0010b\u001A\u00020\u0011H\u0002J\b\u0010c\u001A\u00020\u0011H\u0002J\b\u0010d\u001A\u00020\u0011H\u0002J\b\u0010e\u001A\u00020\u0011H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001A\u0004\u0018\u00010\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0018\u0010#\u001A\u0006\u0012\u0002\b\u00030$8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&¨\u0006f"}, d2={"Landroidx/window/embedding/SafeActivityEmbeddingComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "windowExtensions", "Landroidx/window/extensions/WindowExtensions;", "<init>", "(Ljava/lang/ClassLoader;Landroidx/window/core/ConsumerAdapter;Landroidx/window/extensions/WindowExtensions;)V", "safeWindowExtensionsProvider", "Landroidx/window/SafeWindowExtensionsProvider;", "activityEmbeddingComponent", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "getActivityEmbeddingComponent", "()Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "canUseActivityEmbeddingComponent", "", "isActivityEmbeddingComponentAccessible", "isActivityEmbeddingComponentAccessible$window_release", "hasValidVendorApiLevel1", "hasValidVendorApiLevel1$window_release", "hasValidVendorApiLevel2", "hasValidVendorApiLevel2$window_release", "hasValidVendorApiLevel3", "hasValidVendorApiLevel3$window_release", "hasValidVendorApiLevel5", "hasValidVendorApiLevel5$window_release", "hasValidVendorApiLevel6", "hasValidVendorApiLevel6$window_release", "hasValidVendorApiLevel7", "hasValidVendorApiLevel7$window_release", "hasValidVendorApiLevel8", "hasValidVendorApiLevel8$window_release", "isOverlayFeatureValid", "activityEmbeddingComponentClass", "Ljava/lang/Class;", "getActivityEmbeddingComponentClass", "()Ljava/lang/Class;", "isActivityEmbeddingComponentValid", "isMethodSetEmbeddingRulesValid", "isMethodIsActivityEmbeddedValid", "isMethodSetSplitInfoCallbackJavaConsumerValid", "isMethodGetSplitRatioValid", "isMethodGetLayoutDirectionValid", "isClassActivityRuleValid", "isClassActivityRuleBuilderLevel1Valid", "isClassSplitInfoValid", "isClassSplitPairRuleValid", "isClassSplitPairRuleBuilderLevel1Valid", "isClassSplitPlaceholderRuleValid", "isClassSplitPlaceholderRuleBuilderLevel1Valid", "isMethodSetSplitInfoCallbackWindowConsumerValid", "isMethodClearSplitInfoCallbackValid", "isMethodSplitAttributesCalculatorValid", "isMethodGetSplitAttributesValid", "isMethodGetFinishPrimaryWithPlaceholderValid", "isMethodGetDefaultSplitAttributesValid", "isClassActivityRuleBuilderLevel2Valid", "isClassEmbeddingRuleValid", "isClassSplitAttributesValid", "isClassSplitAttributesCalculatorParamsValid", "isClassSplitTypeValid", "isClassSplitPairRuleBuilderLevel2Valid", "isClassSplitPlaceholderRuleBuilderLevel2Valid", "isMethodInvalidateTopVisibleSplitAttributesValid", "isMethodUpdateSplitAttributesValid", "isMethodSplitInfoGetTokenValid", "isActivityStackGetActivityStackTokenValid", "isMethodRegisterActivityStackCallbackValid", "isMethodUnregisterActivityStackCallbackValid", "isMethodPinUnpinTopActivityStackValid", "isMethodUpdateSplitAttributesWithTokenValid", "isMethodGetSplitInfoTokenValid", "isClassAnimationBackgroundValid", "isClassActivityStackTokenValid", "isClassWindowAttributesValid", "isClassSplitInfoTokenValid", "isMethodGetEmbeddedActivityWindowInfoValid", "isMethodSetEmbeddedActivityWindowInfoCallbackValid", "isMethodClearEmbeddedActivityWindowInfoCallbackValid", "isMethodGetDividerAttributesValid", "isMethodSetDividerAttributesValid", "isClassEmbeddedActivityWindowInfoValid", "isClassDividerAttributesValid", "isClassDividerAttributesBuilderValid", "isMethodGetAnimationParamsValid", "isMethodSetAnimationParamsValid", "isMethodIsDraggingToFullscreenAllowedValid", "isMethodSetDraggingToFullscreenAllowedValid", "isClassAnimationParamsValid", "isClassAnimationParamsBuilderValid", "isActivityStackGetTagValid", "isMethodGetActivityStackTokenValid", "isClassParentContainerInfoValid", "isMethodGetParentContainerInfoValid", "isMethodSetActivityStackAttributesCalculatorValid", "isMethodClearActivityStackAttributesCalculatorValid", "isMethodUpdateActivityStackAttributesValid", "isClassActivityStackAttributesValid", "isClassActivityStackAttributesBuilderValid", "isClassActivityStackAttributesCalculatorParamsValid", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SafeActivityEmbeddingComponentProvider {
    private final ConsumerAdapter consumerAdapter;
    private final ClassLoader loader;
    private final SafeWindowExtensionsProvider safeWindowExtensionsProvider;
    private final WindowExtensions windowExtensions;

    public SafeActivityEmbeddingComponentProvider(ClassLoader arg2, ConsumerAdapter arg3, WindowExtensions arg4) {
        Intrinsics.checkNotNullParameter(arg2, "loader");
        Intrinsics.checkNotNullParameter(arg3, "consumerAdapter");
        Intrinsics.checkNotNullParameter(arg4, "windowExtensions");
        super();
        this.loader = arg2;
        this.consumerAdapter = arg3;
        this.windowExtensions = arg4;
        this.safeWindowExtensionsProvider = new SafeWindowExtensionsProvider(arg2);
    }

    private final boolean canUseActivityEmbeddingComponent() {
        if(!this.isActivityEmbeddingComponentAccessible$window_release()) {
            return 0;
        }

        int v0 = WindowSdkExtensions.Companion.getInstance().getExtensionVersion();
        if(v0 == 1) {
            return this.hasValidVendorApiLevel1$window_release();
        }

        if(v0 == 2) {
            return this.hasValidVendorApiLevel2$window_release();
        }

        int v3 = 5;
        if(3 <= v0 && v0 < v3) {
            return this.hasValidVendorApiLevel3$window_release();
        }

        if(v0 == v3) {
            return this.hasValidVendorApiLevel5$window_release();
        }

        if(v0 == 6) {
            return this.hasValidVendorApiLevel6$window_release();
        }

        if(v0 == 7) {
            return this.hasValidVendorApiLevel7$window_release();
        }

        if(8 <= v0 && v0 <= 0x7FFFFFFF) {
            return this.hasValidVendorApiLevel8$window_release();
        }

        return 0;
    }

    public final ActivityEmbeddingComponent getActivityEmbeddingComponent() {
        ActivityEmbeddingComponent v1 = null;
        if(this.canUseActivityEmbeddingComponent()) {
            try {
                return this.windowExtensions.getActivityEmbeddingComponent();
            }
            catch(UnsupportedOperationException ) {
                return v1;
            }
        }

        return v1;
    }

    private final Class getActivityEmbeddingComponentClass() {
        Class v1 = this.loader.loadClass("androidx.window.extensions.embedding.ActivityEmbeddingComponent");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }

    public final boolean hasValidVendorApiLevel1$window_release() {
        if((this.isMethodSetEmbeddingRulesValid()) && (this.isMethodIsActivityEmbeddedValid()) && (this.isMethodSetSplitInfoCallbackJavaConsumerValid()) && (this.isMethodGetSplitRatioValid()) && (this.isMethodGetLayoutDirectionValid()) && (this.isClassActivityRuleValid()) && (this.isClassActivityRuleBuilderLevel1Valid()) && (this.isClassSplitInfoValid()) && (this.isClassSplitPairRuleValid()) && (this.isClassSplitPairRuleBuilderLevel1Valid()) && (this.isClassSplitPlaceholderRuleValid()) && (this.isClassSplitPlaceholderRuleBuilderLevel1Valid())) {
            return 1;
        }

        return 0;
    }

    public final boolean hasValidVendorApiLevel2$window_release() {
        if((this.hasValidVendorApiLevel1$window_release()) && (this.isMethodSetSplitInfoCallbackWindowConsumerValid()) && (this.isMethodClearSplitInfoCallbackValid()) && (this.isMethodSplitAttributesCalculatorValid()) && (this.isMethodGetSplitAttributesValid()) && (this.isMethodGetFinishPrimaryWithPlaceholderValid()) && (this.isMethodGetDefaultSplitAttributesValid()) && (this.isClassActivityRuleBuilderLevel2Valid()) && (this.isClassEmbeddingRuleValid()) && (this.isClassSplitAttributesValid()) && (this.isClassSplitAttributesCalculatorParamsValid()) && (this.isClassSplitTypeValid()) && (this.isClassSplitPairRuleBuilderLevel2Valid()) && (this.isClassSplitPlaceholderRuleBuilderLevel2Valid())) {
            return 1;
        }

        return 0;
    }

    public final boolean hasValidVendorApiLevel3$window_release() {
        if((this.hasValidVendorApiLevel2$window_release()) && (this.isMethodInvalidateTopVisibleSplitAttributesValid()) && (this.isMethodUpdateSplitAttributesValid()) && (this.isMethodSplitInfoGetTokenValid())) {
            return 1;
        }

        return 0;
    }

    public final boolean hasValidVendorApiLevel5$window_release() {
        if((this.hasValidVendorApiLevel3$window_release()) && (this.isActivityStackGetActivityStackTokenValid()) && (this.isMethodRegisterActivityStackCallbackValid()) && (this.isMethodUnregisterActivityStackCallbackValid()) && (this.isMethodPinUnpinTopActivityStackValid()) && (this.isMethodUpdateSplitAttributesWithTokenValid()) && (this.isMethodGetSplitInfoTokenValid()) && (this.isClassAnimationBackgroundValid()) && (this.isClassActivityStackTokenValid()) && (this.isClassWindowAttributesValid()) && (this.isClassSplitInfoTokenValid())) {
            return 1;
        }

        return 0;
    }

    public final boolean hasValidVendorApiLevel6$window_release() {
        if((this.hasValidVendorApiLevel5$window_release()) && (this.isMethodGetEmbeddedActivityWindowInfoValid()) && (this.isMethodSetEmbeddedActivityWindowInfoCallbackValid()) && (this.isMethodClearEmbeddedActivityWindowInfoCallbackValid()) && (this.isMethodGetDividerAttributesValid()) && (this.isMethodSetDividerAttributesValid()) && (this.isClassEmbeddedActivityWindowInfoValid()) && (this.isClassDividerAttributesValid()) && (this.isClassDividerAttributesBuilderValid())) {
            return 1;
        }

        return 0;
    }

    public final boolean hasValidVendorApiLevel7$window_release() {
        if((this.hasValidVendorApiLevel6$window_release()) && (this.isMethodGetAnimationParamsValid()) && (this.isMethodSetAnimationParamsValid()) && (this.isMethodIsDraggingToFullscreenAllowedValid()) && (this.isMethodSetDraggingToFullscreenAllowedValid()) && (this.isClassAnimationParamsValid()) && (this.isClassAnimationParamsBuilderValid())) {
            return 1;
        }

        return 0;
    }

    public final boolean hasValidVendorApiLevel8$window_release() {
        return this.hasValidVendorApiLevel7$window_release();
    }

    public final boolean isActivityEmbeddingComponentAccessible$window_release() {
        if((this.safeWindowExtensionsProvider.isWindowExtensionsValid$window_release()) && (this.isActivityEmbeddingComponentValid())) {
            return 1;
        }

        return 0;
    }

    private final boolean isActivityEmbeddingComponentValid() {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getActivityEmbeddingComponent is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda57(this));
    }

    static final boolean isActivityEmbeddingComponentValid$lambda$0(SafeActivityEmbeddingComponentProvider arg4) {
        Method v0 = arg4.safeWindowExtensionsProvider.getWindowExtensionsClass$window_release().getMethod("getActivityEmbeddingComponent");
        Class v4 = arg4.getActivityEmbeddingComponentClass();
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, v4))) {
            return 1;
        }

        return 0;
    }

    private final boolean isActivityStackGetActivityStackTokenValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityStack#getActivityToken is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda42());
    }

    static final boolean isActivityStackGetActivityStackTokenValid$lambda$29() {
        Method v0 = ActivityStack.class.getMethod("getActivityStackToken");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, ActivityStack$Token.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isActivityStackGetTagValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityStack#getTag is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda28());
    }

    static final boolean isActivityStackGetTagValid$lambda$53() {
        Method v0 = ActivityStack.class.getMethod("getTag");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, String.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isClassActivityRuleBuilderLevel1Valid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule.Builder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda26());
    }

    static final boolean isClassActivityRuleBuilderLevel1Valid$lambda$7() {
        Class v0 = ActivityRule$Builder.class;
        Method v2 = v0.getMethod("setShouldAlwaysExpand", Boolean.TYPE);
        ReflectionUtils v3 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v3.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, v0))) {
            return 1;
        }

        return 0;
    }

    private final boolean isClassActivityRuleBuilderLevel2Valid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule.Builder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda33());
    }

    static final boolean isClassActivityRuleBuilderLevel2Valid$lambda$19() {
        Class v0 = ActivityRule$Builder.class;
        Class[] v1 = new Class[2];
        Class v2 = Predicate.class;
        v1[0] = v2;
        v1[1] = v2;
        Constructor v1_1 = v0.getDeclaredConstructor(v1);
        Method v2_1 = v0.getMethod("setTag", String.class);
        ReflectionUtils v5 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v1_1);
        if(v5.isPublic$window_release(v1_1)) {
            ReflectionUtils v1_2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v2_1);
            if((v1_2.isPublic$window_release(v2_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2_1, v0))) {
                return 1;
            }
        }

        return 0;
    }

    private final boolean isClassActivityRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda11());
    }

    static final boolean isClassActivityRuleValid$lambda$6() {
        Method v0 = ActivityRule.class.getMethod("shouldAlwaysExpand");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, Boolean.TYPE))) {
            return 1;
        }

        return 0;
    }

    private final boolean isClassActivityStackAttributesBuilderValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStackAttributes.Builder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda31());
    }

    static final boolean isClassActivityStackAttributesBuilderValid$lambda$61() {
        Class v0 = ActivityStackAttributes$Builder.class;
        Constructor v2 = v0.getDeclaredConstructor();
        Method v4 = v0.getMethod("setRelativeBounds", Rect.class);
        Method v5 = v0.getMethod("setWindowAttributes", WindowAttributes.class);
        ReflectionUtils v6 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if(v6.isPublic$window_release(v2)) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v4);
            if((v2_1.isPublic$window_release(v4)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v4, v0))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v5);
                if((v2_1.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, v0))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isClassActivityStackAttributesCalculatorParamsValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStackAttributesCalculatorParams is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda13());
    }

    static final boolean isClassActivityStackAttributesCalculatorParamsValid$lambda$62() {
        Class v0 = ActivityStackAttributesCalculatorParams.class;
        Method v2 = v0.getMethod("getParentContainerInfo");
        Method v3 = v0.getMethod("getActivityStackTag");
        Method v0_1 = v0.getMethod("getLaunchOptions");
        ReflectionUtils v4 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v4.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, ParentContainerInfo.class))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, String.class))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v0_1);
                if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, Bundle.class))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isClassActivityStackAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStackAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda1());
    }

    static final boolean isClassActivityStackAttributesValid$lambda$60() {
        Class v0 = ActivityStackAttributes.class;
        Method v2 = v0.getMethod("getRelativeBounds");
        Method v0_1 = v0.getMethod("getWindowAttributes");
        ReflectionUtils v3 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v3.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, Rect.class))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v0_1);
            if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, WindowAttributes.class))) {
                return 1;
            }
        }

        return 0;
    }

    private final boolean isClassActivityStackTokenValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStack.Token is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda62());
    }

    static final boolean isClassActivityStackTokenValid$lambda$36() {
        Class v0 = ActivityStack$Token.class;
        Method v2 = v0.getMethod("toBundle");
        Class[] v4 = new Class[1];
        Class v5 = Bundle.class;
        v4[0] = v5;
        Method v4_1 = v0.getMethod("readFromBundle", v4);
        Method v6 = v0.getMethod("createFromBinder", IBinder.class);
        Field v7 = v0.getDeclaredField("INVALID_ACTIVITY_STACK_TOKEN");
        ReflectionUtils v8 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v8.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, v5))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v4_1);
            if((v2_1.isPublic$window_release(v4_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v4_1, v0))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v6);
                if((v2_1.isPublic$window_release(v6)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6, v0))) {
                    ReflectionUtils v0_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v7);
                    if(v0_1.isPublic$window_release(v7)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassAnimationBackgroundValid() {
        return ReflectionUtils.validateReflection$window_release("Class AnimationBackground is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda32());
    }

    static final boolean isClassAnimationBackgroundValid$lambda$35() {
        Class v0 = AnimationBackground.class;
        Class v1 = AnimationBackground$ColorBackground.class;
        Method v3 = v0.getMethod("createColorBackground", Integer.TYPE);
        Field v4 = v0.getDeclaredField("ANIMATION_BACKGROUND_DEFAULT");
        Method v6 = v1.getMethod("getColor");
        Method v7 = SplitAttributes.class.getMethod("getAnimationBackground");
        Class v8 = SplitAttributes$Builder.class;
        Method v9 = v8.getMethod("setAnimationBackground", v0);
        ReflectionUtils v10 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        if((v10.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, v1))) {
            ReflectionUtils v1_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v4);
            if(v1_1.isPublic$window_release(v4)) {
                v1_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v6);
                if((v1_1.isPublic$window_release(v6)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6, Integer.TYPE))) {
                    v1_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v7);
                    if((v1_1.isPublic$window_release(v7)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v7, v0))) {
                        ReflectionUtils v0_1 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(v9);
                        if((v0_1.isPublic$window_release(v9)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v9, v8))) {
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassAnimationParamsBuilderValid() {
        return ReflectionUtils.validateReflection$window_release("Class AnimationParams.Builder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda30());
    }

    static final boolean isClassAnimationParamsBuilderValid$lambda$52() {
        Class v0 = AnimationParams$Builder.class;
        Method v2 = v0.getMethod("setAnimationBackground", AnimationBackground.class);
        Method v3 = v0.getMethod("setOpenAnimationResId", Integer.TYPE);
        Method v5 = v0.getMethod("setCloseAnimationResId", Integer.TYPE);
        Method v6 = v0.getMethod("setChangeAnimationResId", Integer.TYPE);
        ReflectionUtils v7 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v7.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, v0))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, v0))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v5);
                if((v2_1.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, v0))) {
                    v2_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v6);
                    if((v2_1.isPublic$window_release(v6)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6, v0))) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassAnimationParamsValid() {
        return ReflectionUtils.validateReflection$window_release("Class AnimationParams is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda34());
    }

    static final boolean isClassAnimationParamsValid$lambda$51() {
        Class v0 = AnimationParams.class;
        Field v1 = v0.getDeclaredField("DEFAULT_ANIMATION_RESOURCES_ID");
        Method v3 = v0.getMethod("getAnimationBackground");
        Method v4 = v0.getMethod("getOpenAnimationResId");
        Method v5 = v0.getMethod("getCloseAnimationResId");
        Method v0_1 = v0.getMethod("getChangeAnimationResId");
        ReflectionUtils v6 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v1);
        if(v6.isPublic$window_release(v1)) {
            ReflectionUtils v1_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v1_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, AnimationBackground.class))) {
                v1_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v4);
                if((v1_1.isPublic$window_release(v4)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v4, Integer.TYPE))) {
                    v1_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v5);
                    if((v1_1.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, Integer.TYPE))) {
                        v1_1 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(v0_1);
                        if((v1_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, Integer.TYPE))) {
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassDividerAttributesBuilderValid() {
        return ReflectionUtils.validateReflection$window_release("Class DividerAttributes.Builder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda27());
    }

    static final boolean isClassDividerAttributesBuilderValid$lambda$46() {
        Class v0 = DividerAttributes$Builder.class;
        Constructor v2 = v0.getDeclaredConstructor(Integer.TYPE);
        Constructor v3 = v0.getDeclaredConstructor(DividerAttributes.class);
        Method v5 = v0.getMethod("setWidthDp", Integer.TYPE);
        Method v6 = v0.getMethod("setPrimaryMinRatio", Float.TYPE);
        Method v7 = v0.getMethod("setPrimaryMaxRatio", Float.TYPE);
        Method v8 = v0.getMethod("setDividerColor", Integer.TYPE);
        ReflectionUtils v9 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if(v9.isPublic$window_release(v2)) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if(v2_1.isPublic$window_release(v3)) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v5);
                if((v2_1.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, v0))) {
                    v2_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v6);
                    if((v2_1.isPublic$window_release(v6)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6, v0))) {
                        v2_1 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(v7);
                        if((v2_1.isPublic$window_release(v7)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v7, v0))) {
                            v2_1 = ReflectionUtils.INSTANCE;
                            Intrinsics.checkNotNull(v8);
                            if((v2_1.isPublic$window_release(v8)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v8, v0))) {
                                return 1;
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassDividerAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class DividerAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda51());
    }

    static final boolean isClassDividerAttributesValid$lambda$45() {
        Class v0 = DividerAttributes.class;
        Method v2 = v0.getMethod("getDividerType");
        Method v3 = v0.getMethod("getWidthDp");
        Method v4 = v0.getMethod("getPrimaryMinRatio");
        Method v5 = v0.getMethod("getPrimaryMaxRatio");
        Method v0_1 = v0.getMethod("getDividerColor");
        ReflectionUtils v6 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v6.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, Integer.TYPE))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, Integer.TYPE))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v4);
                if((v2_1.isPublic$window_release(v4)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v4, Float.TYPE))) {
                    v2_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v5);
                    if((v2_1.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, Float.TYPE))) {
                        v2_1 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(v0_1);
                        if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, Integer.TYPE))) {
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassEmbeddedActivityWindowInfoValid() {
        return ReflectionUtils.validateReflection$window_release("Class EmbeddedActivityWindowInfo is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda45());
    }

    static final boolean isClassEmbeddedActivityWindowInfoValid$lambda$44() {
        Class v0 = EmbeddedActivityWindowInfo.class;
        Method v2 = v0.getMethod("getActivity");
        Method v3 = v0.getMethod("isEmbedded");
        Method v4 = v0.getMethod("getTaskBounds");
        Method v0_1 = v0.getMethod("getActivityStackBounds");
        ReflectionUtils v5 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v5.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, Activity.class))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, Boolean.TYPE))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v4);
                if(v2_1.isPublic$window_release(v4)) {
                    v2_1 = ReflectionUtils.INSTANCE;
                    Class v3_1 = Rect.class;
                    if(v2_1.doesReturn$window_release(v4, v3_1)) {
                        v2_1 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(v0_1);
                        if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, v3_1))) {
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassEmbeddingRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class EmbeddingRule is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda8());
    }

    static final boolean isClassEmbeddingRuleValid$lambda$20() {
        Method v0 = EmbeddingRule.class.getMethod("getTag");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, String.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isClassParentContainerInfoValid() {
        return ReflectionUtils.validateReflection$window_release("ParentContainerInfo is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda47());
    }

    static final boolean isClassParentContainerInfoValid$lambda$55() {
        Class v0 = ParentContainerInfo.class;
        Method v2 = v0.getMethod("getWindowMetrics");
        Method v3 = v0.getMethod("getConfiguration");
        Method v0_1 = v0.getMethod("getWindowLayoutInfo");
        ReflectionUtils v4 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v4.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, WindowMetrics.class))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, Configuration.class))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v0_1);
                if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, WindowLayoutInfo.class))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isClassSplitAttributesCalculatorParamsValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributesCalculatorParams is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda20());
    }

    static final boolean isClassSplitAttributesCalculatorParamsValid$lambda$22() {
        Class v0 = SplitAttributesCalculatorParams.class;
        Method v2 = v0.getMethod("getParentWindowMetrics");
        Method v3 = v0.getMethod("getParentConfiguration");
        Method v4 = v0.getMethod("getDefaultSplitAttributes");
        Method v5 = v0.getMethod("areDefaultConstraintsSatisfied");
        Method v6 = v0.getMethod("getParentWindowLayoutInfo");
        Method v0_1 = v0.getMethod("getSplitRuleTag");
        ReflectionUtils v7 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v7.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, WindowMetrics.class))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, Configuration.class))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v4);
                if((v2_1.isPublic$window_release(v4)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v4, SplitAttributes.class))) {
                    v2_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v5);
                    if((v2_1.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, Boolean.TYPE))) {
                        v2_1 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(v6);
                        if((v2_1.isPublic$window_release(v6)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6, WindowLayoutInfo.class))) {
                            v2_1 = ReflectionUtils.INSTANCE;
                            Intrinsics.checkNotNull(v0_1);
                            if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, String.class))) {
                                return 1;
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda35());
    }

    static final boolean isClassSplitAttributesValid$lambda$21() {
        Class v0 = SplitAttributes.class;
        Method v2 = v0.getMethod("getLayoutDirection");
        Method v0_1 = v0.getMethod("getSplitType");
        Class v3 = SplitAttributes$Builder.class;
        Class[] v5 = new Class[1];
        Class v6 = SplitAttributes$SplitType.class;
        v5[0] = v6;
        Method v5_1 = v3.getMethod("setSplitType", v5);
        Method v3_1 = v3.getMethod("setLayoutDirection", Integer.TYPE);
        ReflectionUtils v7 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v7.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, Integer.TYPE))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v0_1);
            if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, v6))) {
                ReflectionUtils v0_2 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v5_1);
                if(v0_2.isPublic$window_release(v5_1)) {
                    v0_2 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v3_1);
                    if(v0_2.isPublic$window_release(v3_1)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassSplitInfoTokenValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo.Token is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda24());
    }

    static final boolean isClassSplitInfoTokenValid$lambda$38() {
        Class v0 = SplitInfo$Token.class;
        Method v2 = v0.getMethod("createFromBinder", IBinder.class);
        ReflectionUtils v3 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v3.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, v0))) {
            return 1;
        }

        return 0;
    }

    private final boolean isClassSplitInfoValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitInfo is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda18());
    }

    static final boolean isClassSplitInfoValid$lambda$8() {
        Class v0 = SplitInfo.class;
        Method v2 = v0.getMethod("getPrimaryActivityStack");
        Method v3 = v0.getMethod("getSecondaryActivityStack");
        Method v0_1 = v0.getMethod("getSplitRatio");
        ReflectionUtils v4 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if(v4.isPublic$window_release(v2)) {
            v4 = ReflectionUtils.INSTANCE;
            Class v5 = ActivityStack.class;
            if(v4.doesReturn$window_release(v2, v5)) {
                ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v3);
                if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, v5))) {
                    v2_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v0_1);
                    if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, Float.TYPE))) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassSplitPairRuleBuilderLevel1Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule.Builder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda2());
    }

    static final boolean isClassSplitPairRuleBuilderLevel1Valid$lambda$10() {
        Class v0 = SplitPairRule$Builder.class;
        Method v2 = v0.getMethod("setSplitRatio", Float.TYPE);
        Method v3 = v0.getMethod("setLayoutDirection", Integer.TYPE);
        ReflectionUtils v5 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v5.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, v0))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, v0))) {
                return 1;
            }
        }

        return 0;
    }

    private final boolean isClassSplitPairRuleBuilderLevel2Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule.Builder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda0());
    }

    static final boolean isClassSplitPairRuleBuilderLevel2Valid$lambda$24() {
        Class v0 = SplitPairRule$Builder.class;
        Class[] v1 = new Class[3];
        Class v2 = Predicate.class;
        v1[0] = v2;
        v1[1] = v2;
        v1[2] = v2;
        Constructor v1_1 = v0.getDeclaredConstructor(v1);
        Method v2_1 = v0.getMethod("setDefaultSplitAttributes", SplitAttributes.class);
        Method v5 = v0.getMethod("setTag", String.class);
        ReflectionUtils v6 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v1_1);
        if(v6.isPublic$window_release(v1_1)) {
            ReflectionUtils v1_2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v2_1);
            if((v1_2.isPublic$window_release(v2_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2_1, v0))) {
                v1_2 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v5);
                if((v1_2.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, v0))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isClassSplitPairRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda59());
    }

    static final boolean isClassSplitPairRuleValid$lambda$9() {
        Class v0 = SplitPairRule.class;
        Method v2 = v0.getMethod("getFinishPrimaryWithSecondary");
        Method v3 = v0.getMethod("getFinishSecondaryWithPrimary");
        Method v0_1 = v0.getMethod("shouldClearTop");
        ReflectionUtils v4 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v4.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, Integer.TYPE))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, Integer.TYPE))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v0_1);
                if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, Boolean.TYPE))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isClassSplitPlaceholderRuleBuilderLevel1Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule.Builder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda14());
    }

    static final boolean isClassSplitPlaceholderRuleBuilderLevel1Valid$lambda$12() {
        Class v0 = SplitPlaceholderRule$Builder.class;
        Method v2 = v0.getMethod("setSplitRatio", Float.TYPE);
        Method v3 = v0.getMethod("setLayoutDirection", Integer.TYPE);
        Method v5 = v0.getMethod("setSticky", Boolean.TYPE);
        Method v6 = v0.getMethod("setFinishPrimaryWithSecondary", Integer.TYPE);
        ReflectionUtils v7 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v7.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, v0))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, v0))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v5);
                if((v2_1.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, v0))) {
                    v2_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v6);
                    if((v2_1.isPublic$window_release(v6)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6, v0))) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassSplitPlaceholderRuleBuilderLevel2Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule.Builder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda46());
    }

    static final boolean isClassSplitPlaceholderRuleBuilderLevel2Valid$lambda$25() {
        Class v0 = SplitPlaceholderRule$Builder.class;
        Class[] v1 = new Class[4];
        v1[0] = Intent.class;
        Class v2 = Predicate.class;
        v1[1] = v2;
        v1[2] = v2;
        v1[3] = v2;
        Constructor v1_1 = v0.getDeclaredConstructor(v1);
        Method v2_1 = v0.getMethod("setDefaultSplitAttributes", SplitAttributes.class);
        Method v5 = v0.getMethod("setFinishPrimaryWithPlaceholder", Integer.TYPE);
        Method v6 = v0.getMethod("setTag", String.class);
        ReflectionUtils v7 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v1_1);
        if(v7.isPublic$window_release(v1_1)) {
            ReflectionUtils v1_2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v2_1);
            if((v1_2.isPublic$window_release(v2_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2_1, v0))) {
                v1_2 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v5);
                if((v1_2.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, v0))) {
                    v1_2 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v6);
                    if((v1_2.isPublic$window_release(v6)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6, v0))) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassSplitPlaceholderRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda44());
    }

    static final boolean isClassSplitPlaceholderRuleValid$lambda$11() {
        Class v0 = SplitPlaceholderRule.class;
        Method v2 = v0.getMethod("getPlaceholderIntent");
        Method v3 = v0.getMethod("isSticky");
        Method v0_1 = v0.getMethod("getFinishPrimaryWithSecondary");
        ReflectionUtils v4 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v4.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, Intent.class))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, Boolean.TYPE))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v0_1);
                if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, Integer.TYPE))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isClassSplitTypeValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributes.SplitType is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda36());
    }

    static final boolean isClassSplitTypeValid$lambda$23() {
        Class v0 = SplitAttributes$SplitType$RatioSplitType.class;
        Constructor v2 = v0.getDeclaredConstructor(Float.TYPE);
        Method v3 = v0.getMethod("getRatio");
        Method v5 = v0.getMethod("splitEqually");
        Class v6 = SplitAttributes$SplitType$HingeSplitType.class;
        Class[] v7 = new Class[1];
        Class v8 = SplitAttributes$SplitType.class;
        v7[0] = v8;
        Constructor v7_1 = v6.getDeclaredConstructor(v7);
        Method v6_1 = v6.getMethod("getFallbackSplitType");
        Constructor v9 = SplitAttributes$SplitType$ExpandContainersSplitType.class.getDeclaredConstructor();
        ReflectionUtils v10 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if(v10.isPublic$window_release(v2)) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, Float.TYPE))) {
                v2_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v7_1);
                if(v2_1.isPublic$window_release(v7_1)) {
                    v2_1 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(v5);
                    if((v2_1.isPublic$window_release(v5)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v5, v0))) {
                        ReflectionUtils v0_1 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(v6_1);
                        if((v0_1.isPublic$window_release(v6_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6_1, v8))) {
                            v0_1 = ReflectionUtils.INSTANCE;
                            Intrinsics.checkNotNull(v9);
                            if(v0_1.isPublic$window_release(v9)) {
                                return 1;
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    private final boolean isClassWindowAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class WindowAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda23());
    }

    static final boolean isClassWindowAttributesValid$lambda$37() {
        Class v0 = WindowAttributes.class;
        Method v2 = v0.getMethod("getDimAreaBehavior");
        Method v3 = SplitAttributes.class.getMethod("getWindowAttributes");
        Class v4 = SplitAttributes$Builder.class;
        Method v6 = v4.getMethod("setWindowAttributes", v0);
        ReflectionUtils v7 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v7.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, Integer.TYPE))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v2_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, v0))) {
                ReflectionUtils v0_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v6);
                if((v0_1.isPublic$window_release(v6)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6, v4))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isMethodClearActivityStackAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("clearActivityStackAttributesCalculator is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda6(this));
    }

    static final boolean isMethodClearActivityStackAttributesCalculatorValid$lambda$58(SafeActivityEmbeddingComponentProvider arg2) {
        Method v2 = arg2.getActivityEmbeddingComponentClass().getMethod("clearActivityStackAttributesCalculator");
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        return v0.isPublic$window_release(v2);
    }

    private final boolean isMethodClearEmbeddedActivityWindowInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#clearEmbeddedActivityWindowInfoCallback is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda7(this));
    }

    static final boolean isMethodClearEmbeddedActivityWindowInfoCallbackValid$lambda$41(SafeActivityEmbeddingComponentProvider arg2) {
        Method v2 = arg2.getActivityEmbeddingComponentClass().getMethod("clearEmbeddedActivityWindowInfoCallback");
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        return v0.isPublic$window_release(v2);
    }

    private final boolean isMethodClearSplitInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#clearSplitInfoCallback is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda21(this));
    }

    static final boolean isMethodClearSplitInfoCallbackValid$lambda$14(SafeActivityEmbeddingComponentProvider arg2) {
        Method v2 = arg2.getActivityEmbeddingComponentClass().getMethod("clearSplitInfoCallback");
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        return v0.isPublic$window_release(v2);
    }

    private final boolean isMethodGetActivityStackTokenValid() {
        return ReflectionUtils.validateReflection$window_release("getActivityStackToken is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda53(this));
    }

    static final boolean isMethodGetActivityStackTokenValid$lambda$54(SafeActivityEmbeddingComponentProvider arg4) {
        Method v4 = arg4.getActivityEmbeddingComponentClass().getMethod("getActivityStackToken", String.class);
        ReflectionUtils v1 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v4);
        if((v1.isPublic$window_release(v4)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v4, ActivityStack$Token.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetAnimationParamsValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#getAnimationParams is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda15());
    }

    static final boolean isMethodGetAnimationParamsValid$lambda$47() {
        Method v0 = SplitAttributes.class.getMethod("getAnimationParams");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, AnimationParams.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetDefaultSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitRule#getDefaultSplitAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda39());
    }

    static final boolean isMethodGetDefaultSplitAttributesValid$lambda$18() {
        Method v0 = SplitRule.class.getMethod("getDefaultSplitAttributes");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, SplitAttributes.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetDividerAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#getDividerAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda48());
    }

    static final boolean isMethodGetDividerAttributesValid$lambda$42() {
        Method v0 = SplitAttributes.class.getMethod("getDividerAttributes");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, DividerAttributes.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetEmbeddedActivityWindowInfoValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#getEmbeddedActivityWindowInfo is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda19(this));
    }

    static final boolean isMethodGetEmbeddedActivityWindowInfoValid$lambda$39(SafeActivityEmbeddingComponentProvider arg4) {
        Method v4 = arg4.getActivityEmbeddingComponentClass().getMethod("getEmbeddedActivityWindowInfo", Activity.class);
        ReflectionUtils v1 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v4);
        if((v1.isPublic$window_release(v4)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v4, EmbeddedActivityWindowInfo.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetFinishPrimaryWithPlaceholderValid() {
        return ReflectionUtils.validateReflection$window_release("SplitPlaceholderRule#getFinishPrimaryWithPlaceholder is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda12());
    }

    static final boolean isMethodGetFinishPrimaryWithPlaceholderValid$lambda$17() {
        Method v0 = SplitPlaceholderRule.class.getMethod("getFinishPrimaryWithPlaceholder");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, Integer.TYPE))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetLayoutDirectionValid() {
        return ReflectionUtils.validateReflection$window_release("SplitRule#getLayoutDirection is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda50());
    }

    static final boolean isMethodGetLayoutDirectionValid$lambda$5() {
        Method v0 = SplitRule.class.getMethod("getLayoutDirection");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, Integer.TYPE))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetParentContainerInfoValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#getParentContainerInfo is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda49(this));
    }

    static final boolean isMethodGetParentContainerInfoValid$lambda$56(SafeActivityEmbeddingComponentProvider arg4) {
        Method v4 = arg4.getActivityEmbeddingComponentClass().getMethod("getParentContainerInfo", ActivityStack$Token.class);
        ReflectionUtils v1 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v4);
        if((v1.isPublic$window_release(v4)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v4, ParentContainerInfo.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getSplitAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda60());
    }

    static final boolean isMethodGetSplitAttributesValid$lambda$16() {
        Method v0 = SplitInfo.class.getMethod("getSplitAttributes");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, SplitAttributes.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetSplitInfoTokenValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getSplitInfoToken is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda5());
    }

    static final boolean isMethodGetSplitInfoTokenValid$lambda$34() {
        Method v0 = SplitInfo.class.getMethod("getSplitInfoToken");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, SplitInfo$Token.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodGetSplitRatioValid() {
        return ReflectionUtils.validateReflection$window_release("SplitRule#getSplitRatio is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda37());
    }

    static final boolean isMethodGetSplitRatioValid$lambda$4() {
        Method v0 = SplitRule.class.getMethod("getSplitRatio");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, Float.TYPE))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodInvalidateTopVisibleSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("#invalidateTopVisibleSplitAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda25(this));
    }

    static final boolean isMethodInvalidateTopVisibleSplitAttributesValid$lambda$26(SafeActivityEmbeddingComponentProvider arg2) {
        Method v2 = arg2.getActivityEmbeddingComponentClass().getMethod("invalidateTopVisibleSplitAttributes");
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        return v0.isPublic$window_release(v2);
    }

    private final boolean isMethodIsActivityEmbeddedValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#isActivityEmbedded is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda38(this));
    }

    static final boolean isMethodIsActivityEmbeddedValid$lambda$2(SafeActivityEmbeddingComponentProvider arg4) {
        Method v4 = arg4.getActivityEmbeddingComponentClass().getMethod("isActivityEmbedded", Activity.class);
        ReflectionUtils v1 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v4);
        if((v1.isPublic$window_release(v4)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v4, Boolean.TYPE))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodIsDraggingToFullscreenAllowedValid() {
        return ReflectionUtils.validateReflection$window_release("DividerAttributes#isDraggingToFullscreenAllowed is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda43());
    }

    static final boolean isMethodIsDraggingToFullscreenAllowedValid$lambda$49() {
        Method v0 = DividerAttributes.class.getMethod("isDraggingToFullscreenAllowed");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, Boolean.TYPE))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodPinUnpinTopActivityStackValid() {
        return ReflectionUtils.validateReflection$window_release("#pin(unPin)TopActivityStack is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda4(this));
    }

    static final boolean isMethodPinUnpinTopActivityStackValid$lambda$32(SafeActivityEmbeddingComponentProvider arg6) {
        Class v0 = SplitPinRule.class;
        Method v2 = v0.getMethod("isSticky");
        Method v0_1 = arg6.getActivityEmbeddingComponentClass().getMethod("pinTopActivityStack", Integer.TYPE, v0);
        Method v6 = arg6.getActivityEmbeddingComponentClass().getMethod("unpinTopActivityStack", Integer.TYPE);
        ReflectionUtils v3 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v3.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, Boolean.TYPE))) {
            ReflectionUtils v2_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v0_1);
            if((v2_1.isPublic$window_release(v0_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0_1, Boolean.TYPE))) {
                ReflectionUtils v0_2 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v6);
                if(v0_2.isPublic$window_release(v6)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isMethodRegisterActivityStackCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("registerActivityStackCallback is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda55(this));
    }

    static final boolean isMethodRegisterActivityStackCallbackValid$lambda$30(SafeActivityEmbeddingComponentProvider arg3) {
        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("registerActivityStackCallback", Executor.class, Consumer.class);
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0.isPublic$window_release(v3);
    }

    private final boolean isMethodSetActivityStackAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("setActivityStackAttributesCalculator is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda17(this));
    }

    static final boolean isMethodSetActivityStackAttributesCalculatorValid$lambda$57(SafeActivityEmbeddingComponentProvider arg3) {
        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("setActivityStackAttributesCalculator", Function.class);
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0.isPublic$window_release(v3);
    }

    private final boolean isMethodSetAnimationParamsValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#setAnimationParams is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda58());
    }

    static final boolean isMethodSetAnimationParamsValid$lambda$48() {
        Class v0 = SplitAttributes$Builder.class;
        Method v2 = v0.getMethod("setAnimationParams", AnimationParams.class);
        ReflectionUtils v3 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v3.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, v0))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodSetDividerAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#setDividerAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda29());
    }

    static final boolean isMethodSetDividerAttributesValid$lambda$43() {
        Class v0 = SplitAttributes$Builder.class;
        Method v2 = v0.getMethod("setDividerAttributes", DividerAttributes.class);
        ReflectionUtils v3 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v3.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, v0))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodSetDraggingToFullscreenAllowedValid() {
        return ReflectionUtils.validateReflection$window_release("DividerAttributes.Builder#setDraggingToFullscreenAllowed is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda16());
    }

    static final boolean isMethodSetDraggingToFullscreenAllowedValid$lambda$50() {
        Class v0 = DividerAttributes$Builder.class;
        Method v2 = v0.getMethod("setDraggingToFullscreenAllowed", Boolean.TYPE);
        ReflectionUtils v3 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if((v3.isPublic$window_release(v2)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v2, v0))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodSetEmbeddedActivityWindowInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setEmbeddedActivityWindowInfoCallback is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda3(this));
    }

    static final boolean isMethodSetEmbeddedActivityWindowInfoCallbackValid$lambda$40(SafeActivityEmbeddingComponentProvider arg3) {
        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("setEmbeddedActivityWindowInfoCallback", Executor.class, Consumer.class);
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0.isPublic$window_release(v3);
    }

    private final boolean isMethodSetEmbeddingRulesValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setEmbeddingRules is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda52(this));
    }

    static final boolean isMethodSetEmbeddingRulesValid$lambda$1(SafeActivityEmbeddingComponentProvider arg3) {
        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("setEmbeddingRules", Set.class);
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0.isPublic$window_release(v3);
    }

    private final boolean isMethodSetSplitInfoCallbackJavaConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda40(this));
    }

    static final boolean isMethodSetSplitInfoCallbackJavaConsumerValid$lambda$3(SafeActivityEmbeddingComponentProvider arg3) {
        Class v0 = arg3.consumerAdapter.consumerClassOrNull$window_release();
        if(v0 == null) {
            return 0;
        }

        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", v0);
        ReflectionUtils v0_1 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0_1.isPublic$window_release(v3);
    }

    private final boolean isMethodSetSplitInfoCallbackWindowConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda41(this));
    }

    static final boolean isMethodSetSplitInfoCallbackWindowConsumerValid$lambda$13(SafeActivityEmbeddingComponentProvider arg3) {
        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", Consumer.class);
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0.isPublic$window_release(v3);
    }

    private final boolean isMethodSplitAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda54(this));
    }

    static final boolean isMethodSplitAttributesCalculatorValid$lambda$15(SafeActivityEmbeddingComponentProvider arg5) {
        Method v0 = arg5.getActivityEmbeddingComponentClass().getMethod("setSplitAttributesCalculator", Function.class);
        Method v5 = arg5.getActivityEmbeddingComponentClass().getMethod("clearSplitAttributesCalculator");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if(v2.isPublic$window_release(v0)) {
            ReflectionUtils v0_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v5);
            if(v0_1.isPublic$window_release(v5)) {
                return 1;
            }
        }

        return 0;
    }

    private final boolean isMethodSplitInfoGetTokenValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getToken is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda10());
    }

    static final boolean isMethodSplitInfoGetTokenValid$lambda$28() {
        Method v0 = SplitInfo.class.getMethod("getToken");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, IBinder.class))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodUnregisterActivityStackCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("unregisterActivityStackCallback is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda61(this));
    }

    static final boolean isMethodUnregisterActivityStackCallbackValid$lambda$31(SafeActivityEmbeddingComponentProvider arg3) {
        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("unregisterActivityStackCallback", Consumer.class);
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0.isPublic$window_release(v3);
    }

    private final boolean isMethodUpdateActivityStackAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("updateActivityStackAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda9(this));
    }

    static final boolean isMethodUpdateActivityStackAttributesValid$lambda$59(SafeActivityEmbeddingComponentProvider arg3) {
        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("updateActivityStackAttributes", ActivityStack$Token.class, ActivityStackAttributes.class);
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0.isPublic$window_release(v3);
    }

    private final boolean isMethodUpdateSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("#updateSplitAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda22(this));
    }

    static final boolean isMethodUpdateSplitAttributesValid$lambda$27(SafeActivityEmbeddingComponentProvider arg3) {
        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("updateSplitAttributes", IBinder.class, SplitAttributes.class);
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0.isPublic$window_release(v3);
    }

    private final boolean isMethodUpdateSplitAttributesWithTokenValid() {
        return ReflectionUtils.validateReflection$window_release("updateSplitAttributes is not valid", new SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda56(this));
    }

    static final boolean isMethodUpdateSplitAttributesWithTokenValid$lambda$33(SafeActivityEmbeddingComponentProvider arg3) {
        Method v3 = arg3.getActivityEmbeddingComponentClass().getMethod("updateSplitAttributes", SplitInfo$Token.class, SplitAttributes.class);
        ReflectionUtils v0 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v3);
        return v0.isPublic$window_release(v3);
    }

    private final boolean isOverlayFeatureValid() {
        if((this.isActivityStackGetTagValid()) && (this.isMethodGetActivityStackTokenValid()) && (this.isClassParentContainerInfoValid()) && (this.isMethodGetParentContainerInfoValid()) && (this.isMethodSetActivityStackAttributesCalculatorValid()) && (this.isMethodClearActivityStackAttributesCalculatorValid()) && (this.isMethodUpdateActivityStackAttributesValid()) && (this.isClassActivityStackAttributesValid()) && (this.isClassActivityStackAttributesBuilderValid()) && (this.isClassActivityStackAttributesCalculatorParamsValid())) {
            return 1;
        }

        return 0;
    }
}

