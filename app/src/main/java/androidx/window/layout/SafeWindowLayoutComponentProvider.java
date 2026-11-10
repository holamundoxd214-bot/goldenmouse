package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000E\u001A\u00020\u000FH\u0002J\r\u0010\u0010\u001A\u00020\u000FH\u0001¢\u0006\u0002\b\u0011J\r\u0010\u0012\u001A\u00020\u000FH\u0001¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001A\u00020\u000FH\u0001¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001A\u00020\u000FH\u0001¢\u0006\u0002\b\u0017J\b\u0010\u0018\u001A\u00020\u000FH\u0002J\b\u0010\u0019\u001A\u00020\u000FH\u0002J\b\u0010\u001A\u001A\u00020\u000FH\u0002J\b\u0010\u001B\u001A\u00020\u000FH\u0002J\b\u0010\u001C\u001A\u00020\u000FH\u0002J\b\u0010\u001D\u001A\u00020\u000FH\u0002J\b\u0010\u001E\u001A\u00020\u000FH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001A\u0004\u0018\u00010\u000B8F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0018\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030 8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0018\u0010#\u001A\u0006\u0012\u0002\b\u00030 8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b$\u0010\"R\u0018\u0010%\u001A\u0006\u0012\u0002\b\u00030 8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\"R\u0018\u0010\'\u001A\u0006\u0012\u0002\b\u00030 8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b(\u0010\"¨\u0006)"}, d2={"Landroidx/window/layout/SafeWindowLayoutComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "<init>", "(Ljava/lang/ClassLoader;Landroidx/window/core/ConsumerAdapter;)V", "safeWindowExtensionsProvider", "Landroidx/window/SafeWindowExtensionsProvider;", "windowLayoutComponent", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "getWindowLayoutComponent", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "canUseWindowLayoutComponent", "", "isWindowLayoutComponentAccessible", "isWindowLayoutComponentAccessible$window_release", "hasValidVendorApiLevel1", "hasValidVendorApiLevel1$window_release", "hasValidVendorApiLevel2", "hasValidVendorApiLevel2$window_release", "hasValidVendorApiLevel6", "hasValidVendorApiLevel6$window_release", "isWindowLayoutProviderValid", "isFoldingFeatureValid", "isMethodWindowLayoutInfoListenerJavaConsumerValid", "isMethodWindowLayoutInfoListenerWindowConsumerValid", "isDisplayFoldFeatureValid", "isSupportedWindowFeaturesValid", "isGetSupportedWindowFeaturesValid", "displayFoldFeatureClass", "Ljava/lang/Class;", "getDisplayFoldFeatureClass", "()Ljava/lang/Class;", "supportedWindowFeaturesClass", "getSupportedWindowFeaturesClass", "foldingFeatureClass", "getFoldingFeatureClass", "windowLayoutComponentClass", "getWindowLayoutComponentClass", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SafeWindowLayoutComponentProvider {
    private final ConsumerAdapter consumerAdapter;
    private final ClassLoader loader;
    private final SafeWindowExtensionsProvider safeWindowExtensionsProvider;

    public SafeWindowLayoutComponentProvider(ClassLoader arg2, ConsumerAdapter arg3) {
        Intrinsics.checkNotNullParameter(arg2, "loader");
        Intrinsics.checkNotNullParameter(arg3, "consumerAdapter");
        super();
        this.loader = arg2;
        this.consumerAdapter = arg3;
        this.safeWindowExtensionsProvider = new SafeWindowExtensionsProvider(arg2);
    }

    private final boolean canUseWindowLayoutComponent() {
        if(!this.isWindowLayoutComponentAccessible$window_release()) {
            return 0;
        }

        int v0 = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
        if(v0 < 1) {
            return 0;
        }

        if(v0 == 1) {
            return this.hasValidVendorApiLevel1$window_release();
        }

        if(v0 < 5) {
            return this.hasValidVendorApiLevel2$window_release();
        }

        return this.hasValidVendorApiLevel6$window_release();
    }

    private final Class getDisplayFoldFeatureClass() {
        Class v1 = this.loader.loadClass("androidx.window.extensions.layout.DisplayFoldFeature");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }

    private final Class getFoldingFeatureClass() {
        Class v1 = this.loader.loadClass("androidx.window.extensions.layout.FoldingFeature");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }

    private final Class getSupportedWindowFeaturesClass() {
        Class v1 = this.loader.loadClass("androidx.window.extensions.layout.SupportedWindowFeatures");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }

    public final WindowLayoutComponent getWindowLayoutComponent() {
        WindowLayoutComponent v0 = null;
        if(this.canUseWindowLayoutComponent()) {
            try {
                return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
            }
            catch(UnsupportedOperationException ) {
                return v0;
            }
        }

        return v0;
    }

    private final Class getWindowLayoutComponentClass() {
        Class v1 = this.loader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        Intrinsics.checkNotNullExpressionValue(v1, "loadClass(...)");
        return v1;
    }

    public final boolean hasValidVendorApiLevel1$window_release() {
        return this.isMethodWindowLayoutInfoListenerJavaConsumerValid();
    }

    public final boolean hasValidVendorApiLevel2$window_release() {
        if((this.hasValidVendorApiLevel1$window_release()) && (this.isMethodWindowLayoutInfoListenerWindowConsumerValid())) {
            return 1;
        }

        return 0;
    }

    public final boolean hasValidVendorApiLevel6$window_release() {
        if((this.hasValidVendorApiLevel2$window_release()) && (this.isDisplayFoldFeatureValid()) && (this.isSupportedWindowFeaturesValid()) && (this.isGetSupportedWindowFeaturesValid())) {
            return 1;
        }

        return 0;
    }

    private final boolean isDisplayFoldFeatureValid() {
        return ReflectionUtils.validateReflection$window_release("DisplayFoldFeature is not valid", new SafeWindowLayoutComponentProvider$$ExternalSyntheticLambda3(this));
    }

    static final boolean isDisplayFoldFeatureValid$lambda$4(SafeWindowLayoutComponentProvider arg6) {
        Class v6 = arg6.getDisplayFoldFeatureClass();
        Method v1 = v6.getMethod("getType");
        Method v3 = v6.getMethod("hasProperty", Integer.TYPE);
        Method v6_1 = v6.getMethod("hasProperties", int[].class);
        ReflectionUtils v4 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v1);
        if((v4.isPublic$window_release(v1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v1, Integer.TYPE))) {
            ReflectionUtils v1_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v3);
            if((v1_1.isPublic$window_release(v3)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v3, Boolean.TYPE))) {
                v1_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v6_1);
                if((v1_1.isPublic$window_release(v6_1)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v6_1, Boolean.TYPE))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isFoldingFeatureValid() {
        return ReflectionUtils.validateReflection$window_release("FoldingFeature class is not valid", new SafeWindowLayoutComponentProvider$$ExternalSyntheticLambda1(this));
    }

    static final boolean isFoldingFeatureValid$lambda$1(SafeWindowLayoutComponentProvider arg5) {
        Class v5 = arg5.getFoldingFeatureClass();
        Method v1 = v5.getMethod("getBounds");
        Method v2 = v5.getMethod("getType");
        Method v5_1 = v5.getMethod("getState");
        ReflectionUtils v3 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v1);
        if((v3.doesReturn$window_release(v1, Reflection.getOrCreateKotlinClass(Rect.class))) && (ReflectionUtils.INSTANCE.isPublic$window_release(v1))) {
            ReflectionUtils v1_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v2);
            if((v1_1.doesReturn$window_release(v2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) && (ReflectionUtils.INSTANCE.isPublic$window_release(v2))) {
                v1_1 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(v5_1);
                if((v1_1.doesReturn$window_release(v5_1, Reflection.getOrCreateKotlinClass(Integer.TYPE))) && (ReflectionUtils.INSTANCE.isPublic$window_release(v5_1))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private final boolean isGetSupportedWindowFeaturesValid() {
        return ReflectionUtils.validateReflection$window_release("WindowLayoutComponent#getSupportedWindowFeatures is not valid", new SafeWindowLayoutComponentProvider$$ExternalSyntheticLambda4(this));
    }

    static final boolean isGetSupportedWindowFeaturesValid$lambda$6(SafeWindowLayoutComponentProvider arg4) {
        Method v0 = arg4.getWindowLayoutComponentClass().getMethod("getSupportedWindowFeatures");
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, arg4.getSupportedWindowFeaturesClass()))) {
            return 1;
        }

        return 0;
    }

    private final boolean isMethodWindowLayoutInfoListenerJavaConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new SafeWindowLayoutComponentProvider$$ExternalSyntheticLambda5(this));
    }

    static final boolean isMethodWindowLayoutInfoListenerJavaConsumerValid$lambda$2(SafeWindowLayoutComponentProvider arg5) {
        Class v0 = arg5.consumerAdapter.consumerClassOrNull$window_release();
        if(v0 == null) {
            return 0;
        }

        Class v5 = arg5.getWindowLayoutComponentClass();
        Method v2 = v5.getMethod("addWindowLayoutInfoListener", Activity.class, v0);
        Method v5_1 = v5.getMethod("removeWindowLayoutInfoListener", v0);
        ReflectionUtils v0_1 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v2);
        if(v0_1.isPublic$window_release(v2)) {
            v0_1 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v5_1);
            if(v0_1.isPublic$window_release(v5_1)) {
                return 1;
            }
        }

        return 0;
    }

    private final boolean isMethodWindowLayoutInfoListenerWindowConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new SafeWindowLayoutComponentProvider$$ExternalSyntheticLambda6(this));
    }

    static final boolean isMethodWindowLayoutInfoListenerWindowConsumerValid$lambda$3(SafeWindowLayoutComponentProvider arg5) {
        Class v5 = arg5.getWindowLayoutComponentClass();
        Class[] v0 = new Class[2];
        v0[0] = Context.class;
        Class v1 = Consumer.class;
        v0[1] = v1;
        Method v0_1 = v5.getMethod("addWindowLayoutInfoListener", v0);
        Method v5_1 = v5.getMethod("removeWindowLayoutInfoListener", v1);
        ReflectionUtils v1_1 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0_1);
        if(v1_1.isPublic$window_release(v0_1)) {
            ReflectionUtils v0_2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(v5_1);
            if(v0_2.isPublic$window_release(v5_1)) {
                return 1;
            }
        }

        return 0;
    }

    private final boolean isSupportedWindowFeaturesValid() {
        return ReflectionUtils.validateReflection$window_release("SupportedWindowFeatures is not valid", new SafeWindowLayoutComponentProvider$$ExternalSyntheticLambda2(this));
    }

    static final boolean isSupportedWindowFeaturesValid$lambda$5(SafeWindowLayoutComponentProvider arg5) {
        Method v0 = arg5.getSupportedWindowFeaturesClass().getMethod("getDisplayFoldFeatures");
        Type v2 = v0.getGenericReturnType();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        v2 = ((ParameterizedType)v2).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type java.lang.Class<*>");
        ReflectionUtils v3 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v3.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, List.class)) && (Intrinsics.areEqual(v2, arg5.getDisplayFoldFeatureClass()))) {
            return 1;
        }

        return 0;
    }

    public final boolean isWindowLayoutComponentAccessible$window_release() {
        if((this.safeWindowExtensionsProvider.isWindowExtensionsValid$window_release()) && (this.isWindowLayoutProviderValid()) && (this.isFoldingFeatureValid())) {
            return 1;
        }

        return 0;
    }

    private final boolean isWindowLayoutProviderValid() {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getWindowLayoutComponent is not valid", new SafeWindowLayoutComponentProvider$$ExternalSyntheticLambda0(this));
    }

    static final boolean isWindowLayoutProviderValid$lambda$0(SafeWindowLayoutComponentProvider arg4) {
        Method v0 = arg4.safeWindowExtensionsProvider.getWindowExtensionsClass$window_release().getMethod("getWindowLayoutComponent");
        Class v4 = arg4.getWindowLayoutComponentClass();
        ReflectionUtils v2 = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(v0);
        if((v2.isPublic$window_release(v0)) && (ReflectionUtils.INSTANCE.doesReturn$window_release(v0, v4))) {
            return 1;
        }

        return 0;
    }
}

