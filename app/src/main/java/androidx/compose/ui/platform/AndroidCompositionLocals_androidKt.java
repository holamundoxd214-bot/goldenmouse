package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.compose.ui.res.ResourceIdCache;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A(\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 2\u0011\u0010!\u001A\r\u0012\u0004\u0012\u00020\u001E0\"¢\u0006\u0002\b#H\u0001¢\u0006\u0002\u0010$\u001A\u0015\u0010%\u001A\u00020\u000F2\u0006\u0010&\u001A\u00020\u0006H\u0003¢\u0006\u0002\u0010\'\u001A\u001F\u0010(\u001A\u00020\f2\u0006\u0010&\u001A\u00020\u00062\b\u0010)\u001A\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0002\u0010*\u001A\u0010\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.H\u0002\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u0004\"\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0004\"\u001A\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\f0\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0004\"\u001A\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000F0\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0004\" \u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0004\" \u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00170\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0014\u001A\u0004\b\u0019\u0010\u0004\"\u0017\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001B0\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0004¨\u0006/"}, d2={"LocalConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/content/res/Configuration;", "getLocalConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalContext", "Landroid/content/Context;", "getLocalContext", "LocalResources", "Landroid/content/res/Resources;", "getLocalResources", "LocalImageVectorCache", "Landroidx/compose/ui/res/ImageVectorCache;", "getLocalImageVectorCache", "LocalResourceIdCache", "Landroidx/compose/ui/res/ResourceIdCache;", "getLocalResourceIdCache", "LocalLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner$annotations", "()V", "getLocalLifecycleOwner", "LocalSavedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "getLocalSavedStateRegistryOwner$annotations", "getLocalSavedStateRegistryOwner", "LocalView", "Landroid/view/View;", "getLocalView", "ProvideAndroidCompositionLocals", "", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "obtainResourceIdCache", "context", "(Landroid/content/Context;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/res/ResourceIdCache;", "obtainImageVectorCache", "configuration", "(Landroid/content/Context;Landroid/content/res/Configuration;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/res/ImageVectorCache;", "noLocalProvidedFor", "", "name", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidCompositionLocals_androidKt {
    private static final ProvidableCompositionLocal LocalConfiguration;
    private static final ProvidableCompositionLocal LocalContext;
    private static final ProvidableCompositionLocal LocalImageVectorCache;
    private static final ProvidableCompositionLocal LocalResourceIdCache;
    private static final ProvidableCompositionLocal LocalResources;
    private static final ProvidableCompositionLocal LocalView;

    static {
        AndroidCompositionLocals_androidKt.LocalConfiguration = CompositionLocalKt.compositionLocalOf$default(null, AndroidCompositionLocals_androidKt$LocalConfiguration$1.INSTANCE, 1, null);
        AndroidCompositionLocals_androidKt.LocalContext = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalContext$1.INSTANCE);
        AndroidCompositionLocals_androidKt.LocalResources = CompositionLocalKt.compositionLocalWithComputedDefaultOf(AndroidCompositionLocals_androidKt$LocalResources$1.INSTANCE);
        AndroidCompositionLocals_androidKt.LocalImageVectorCache = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalImageVectorCache$1.INSTANCE);
        AndroidCompositionLocals_androidKt.LocalResourceIdCache = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalResourceIdCache$1.INSTANCE);
        AndroidCompositionLocals_androidKt.LocalView = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalView$1.INSTANCE);
    }

    public static final void ProvideAndroidCompositionLocals(AndroidComposeView arg19, Function2 arg20, Composer arg21, int arg22) {
        DefaultHapticFeedback v8_4;
        int v5;
        AndroidComposeView v0 = arg19;
        Function2 v1 = arg20;
        int v2 = arg22;
        int v3 = 0xE0FCDCE9;
        Composer v4 = arg21.startRestartGroup(v3);
        ComposerKt.sourceInformation(v4, "C(ProvideAndroidCompositionLocals)P(1)101@4340L39,108@4616L102,111@4746L49,111@4723L72,113@4822L184,121@5035L52,122@5114L30,124@5216L7,136@5895L105,125@5261L739:AndroidCompositionLocals.android.kt#itgzvw");
        if((v2 & 6) == 0) {
            v5 = v4.changedInstance(v0) ? 4 : 2;
            v5 |= v2;
        }
        else {
            v5 = v2;
        }

        if((v2 & 0x30) == 0) {
            int v8 = v4.changedInstance(v1) ? 0x20 : 16;
            v5 |= v8;
        }

        boolean v8_1 = (v5 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v8_1, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v5, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:98)");
            }

            Context v3_1 = v0.getContext();
            String v8_2 = "CC(remember):AndroidCompositionLocals.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v4, -1791402608, v8_2);
            Object v5_1 = v4.rememberedValue();
            if(v5_1 == Composer.Companion.getEmpty()) {
                AndroidUriHandler v5_2 = new AndroidUriHandler(v3_1);
                v4.updateRememberedValue(v5_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ViewTreeOwners v9 = v0.getViewTreeOwners();
            if(v9 != null) {
                ComposerKt.sourceInformationMarkerStart(v4, 0x9539804F, v8_2);
                Object v12 = v4.rememberedValue();
                if(v12 == Composer.Companion.getEmpty()) {
                    DisposableSaveableStateRegistry v12_1 = DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry(v0, v9.getSavedStateRegistryOwner());
                    v4.updateRememberedValue(v12_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                Unit v13 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(v4, 0x9539905A, v8_2);
                boolean v14 = v4.changedInstance(v12);
                Object v15 = v4.rememberedValue();
                if((v14) || v15 == Composer.Companion.getEmpty()) {
                    AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1 v15_1 = new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1(((DisposableSaveableStateRegistry)v12));
                    v4.updateRememberedValue(v15_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                int v14_1 = 6;
                EffectsKt.DisposableEffect(v13, ((Function1)v15), v4, v14_1);
                ComposerKt.sourceInformationMarkerStart(v4, 0x95399A61, v8_2);
                Object v8_3 = v4.rememberedValue();
                if(v8_3 == Composer.Companion.getEmpty()) {
                    if(HapticDefaults.INSTANCE.isPremiumVibratorEnabled(v3_1)) {
                        v8_4 = new DefaultHapticFeedback(v0.getView());
                    }
                    else {
                        NoHapticFeedback v8_5 = new NoHapticFeedback();
                    }

                    v4.updateRememberedValue(v8_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                ImageVectorCache v13_1 = AndroidCompositionLocals_androidKt.obtainImageVectorCache(v3_1, v0.getConfiguration(), v4, 0);
                ResourceIdCache v15_2 = AndroidCompositionLocals_androidKt.obtainResourceIdCache(v3_1, v4, 0);
                CompositionLocal v6 = CompositionLocalsKt.getLocalScrollCaptureInProgress();
                ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object v6_1 = v4.consume(v6);
                ComposerKt.sourceInformationMarkerEnd(v4);
                int v6_2 = ((Boolean)v6_1).booleanValue() | v0.getScrollCaptureInProgress$ui();
                ProvidedValue[] v7 = new ProvidedValue[10];
                v7[0] = AndroidCompositionLocals_androidKt.LocalConfiguration.provides(v0.getConfiguration());
                v7[1] = AndroidCompositionLocals_androidKt.LocalContext.provides(v3_1);
                v7[2] = LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(v9.getLifecycleOwner());
                v7[3] = LocalSavedStateRegistryOwnerKt.getLocalSavedStateRegistryOwner().provides(v9.getSavedStateRegistryOwner());
                v7[4] = SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(v12);
                v7[5] = AndroidCompositionLocals_androidKt.LocalView.provides(v0.getView());
                v7[v14_1] = AndroidCompositionLocals_androidKt.LocalImageVectorCache.provides(v13_1);
                v7[7] = AndroidCompositionLocals_androidKt.LocalResourceIdCache.provides(v15_2);
                v7[8] = CompositionLocalsKt.getLocalProvidableScrollCaptureInProgress().provides(Boolean.valueOf(((boolean)v6_2)));
                v7[9] = CompositionLocalsKt.getLocalHapticFeedback().provides(v8_3);
                CompositionLocalKt.CompositionLocalProvider(v7, ComposableLambdaKt.rememberComposableLambda(1059770793, true, new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2(v0, ((AndroidUriHandler)v5_1), v1), v4, 54), v4, ProvidedValue.$stable | 0x30);
                if(!ComposerKt.isTraceInProgress()) {
                    goto label_175;
                }

                ComposerKt.traceEventEnd();
                goto label_175;
            }

            throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
        }
        else {
            v4.skipToGroupEnd();
        }

    label_175:
        ScopeUpdateScope v3_2 = v4.endRestartGroup();
        if(v3_2 != null) {
            v3_2.updateScope(new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3(v0, v1, v2));
        }
    }

    public static final Void access$noLocalProvidedFor(String arg0) {
        return AndroidCompositionLocals_androidKt.noLocalProvidedFor(arg0);
    }

    public static final ProvidableCompositionLocal getLocalConfiguration() {
        return AndroidCompositionLocals_androidKt.LocalConfiguration;
    }

    public static final ProvidableCompositionLocal getLocalContext() {
        return AndroidCompositionLocals_androidKt.LocalContext;
    }

    public static final ProvidableCompositionLocal getLocalImageVectorCache() {
        return AndroidCompositionLocals_androidKt.LocalImageVectorCache;
    }

    public static final ProvidableCompositionLocal getLocalLifecycleOwner() {
        return LocalLifecycleOwnerKt.getLocalLifecycleOwner();
    }

    @Deprecated(message="Moved to lifecycle-runtime-compose library in androidx.lifecycle.compose package.", replaceWith="<_subannotation>") public static void getLocalLifecycleOwner$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalResourceIdCache() {
        return AndroidCompositionLocals_androidKt.LocalResourceIdCache;
    }

    public static final ProvidableCompositionLocal getLocalResources() {
        return AndroidCompositionLocals_androidKt.LocalResources;
    }

    public static final ProvidableCompositionLocal getLocalSavedStateRegistryOwner() {
        return LocalSavedStateRegistryOwnerKt.getLocalSavedStateRegistryOwner();
    }

    @Deprecated(message="Moved to savedstate-compose library in androidx.savedstate.compose package.", replaceWith="<_subannotation>") public static void getLocalSavedStateRegistryOwner$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalView() {
        return AndroidCompositionLocals_androidKt.LocalView;
    }

    private static final Void noLocalProvidedFor(String arg3) {
        throw new IllegalStateException("CompositionLocal " + arg3 + " not present".toString());
    }

    private static final ImageVectorCache obtainImageVectorCache(Context arg3, Configuration arg4, Composer arg5, int arg6) {
        AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$1 v1_3;
        AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 v4_1;
        Configuration v1_2;
        ImageVectorCache v6_1;
        int v1 = 0xE309A0BA;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(obtainImageVectorCache)P(1)175@7103L31,176@7181L88,179@7290L689,198@8019L169,198@7984L204:AndroidCompositionLocals.android.kt#itgzvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:174)");
        }

        String v0 = "CC(remember):AndroidCompositionLocals.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg5, 1193569049, v0);
        Object v6 = arg5.rememberedValue();
        if(v6 == Composer.Companion.getEmpty()) {
            v6_1 = new ImageVectorCache();
            arg5.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        ComposerKt.sourceInformationMarkerStart(arg5, 1193571602, v0);
        Object v1_1 = arg5.rememberedValue();
        if(v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new Configuration();
            if(arg4 != null) {
                v1_2.setTo(arg4);
            }

            arg5.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        ComposerKt.sourceInformationMarkerStart(arg5, 0x4724850B, v0);
        Object v4 = arg5.rememberedValue();
        if(v4 == Composer.Companion.getEmpty()) {
            v4_1 = new AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1(v1_2, v6_1);
            arg5.updateRememberedValue(v4_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        ComposerKt.sourceInformationMarkerStart(arg5, 0x4724DE23, v0);
        boolean v0_1 = arg5.changedInstance(arg3);
        v1_1 = arg5.rememberedValue();
        if((v0_1) || v1_1 == Composer.Companion.getEmpty()) {
            v1_3 = new AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$1(arg3, v4_1);
            arg5.updateRememberedValue(v1_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        EffectsKt.DisposableEffect(v6_1, ((Function1)v1_3), arg5, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return v6_1;
    }

    private static final ResourceIdCache obtainResourceIdCache(Context arg3, Composer arg4, int arg5) {
        ResourceIdCache v5_1;
        int v1 = 0xAF9F6992;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(obtainResourceIdCache)144@6121L30,145@6172L530,162@6741L169,162@6707L203:AndroidCompositionLocals.android.kt#itgzvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.ui.platform.obtainResourceIdCache (AndroidCompositionLocals.android.kt:143)");
        }

        String v0 = "CC(remember):AndroidCompositionLocals.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg4, 0x456B5850, v0);
        Object v5 = arg4.rememberedValue();
        if(v5 == Composer.Companion.getEmpty()) {
            v5_1 = new ResourceIdCache();
            arg4.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        ComposerKt.sourceInformationMarkerStart(arg4, 0x456B60A4, v0);
        Object v1_1 = arg4.rememberedValue();
        if(v1_1 == Composer.Companion.getEmpty()) {
            AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1 v1_2 = new AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1(v5_1);
            arg4.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        ComposerKt.sourceInformationMarkerStart(arg4, 0x456BA65B, v0);
        boolean v0_1 = arg4.changedInstance(arg3);
        Object v2 = arg4.rememberedValue();
        if((v0_1) || v2 == Composer.Companion.getEmpty()) {
            AndroidCompositionLocals_androidKt$obtainResourceIdCache$1$1 v2_1 = new AndroidCompositionLocals_androidKt$obtainResourceIdCache$1$1(arg3, ((AndroidCompositionLocals_androidKt$obtainResourceIdCache$callbacks$1$1)v1_1));
            arg4.updateRememberedValue(v2_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        EffectsKt.DisposableEffect(v5_1, ((Function1)v2), arg4, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v5_1;
    }
}

