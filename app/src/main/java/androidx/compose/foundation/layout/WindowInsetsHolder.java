package androidx.compose.foundation.layout;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.R$id;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u0000 Q2\u00020\u0001:\u0001QB\u001B\b\u0002\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010I\u001A\u00020J2\u0006\u0010\u0004\u001A\u00020\u0005J\u000E\u0010K\u001A\u00020J2\u0006\u0010\u0004\u001A\u00020\u0005J\u0018\u0010L\u001A\u00020J2\u0006\u0010M\u001A\u00020\u00032\b\b\u0002\u0010N\u001A\u00020FJ\u000E\u0010O\u001A\u00020J2\u0006\u0010M\u001A\u00020\u0003J\u000E\u0010P\u001A\u00020J2\u0006\u0010M\u001A\u00020\u0003R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u000E\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000BR\u0011\u0010\u0010\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000BR\u0011\u0010\u0012\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000BR\u0011\u0010\u0014\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000BR\u0011\u0010\u0016\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000BR\u0011\u0010\u0018\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u000BR\u0011\u0010\u001A\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u000BR\u0011\u0010\u001C\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR/\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010 \u001A\u0004\u0018\u00010!8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\'\u0010(\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010)\u001A\u00020*¢\u0006\b\n\u0000\u001A\u0004\b+\u0010,R\u0011\u0010-\u001A\u00020*¢\u0006\b\n\u0000\u001A\u0004\b.\u0010,R\u0011\u0010/\u001A\u00020*¢\u0006\b\n\u0000\u001A\u0004\b0\u0010,R\u0011\u00101\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b2\u0010\u001FR\u0011\u00103\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b4\u0010\u001FR\u0011\u00105\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b6\u0010\u001FR\u0011\u00107\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b8\u0010\u001FR\u0011\u00109\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b:\u0010\u001FR\u0011\u0010;\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b<\u0010\u001FR\u0011\u0010=\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b>\u0010\u001FR\u0017\u0010?\u001A\u00020@¢\u0006\u000E\n\u0000\u0012\u0004\bA\u0010B\u001A\u0004\bC\u0010DR\u000E\u0010E\u001A\u00020FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010G\u001A\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2={"Landroidx/compose/foundation/layout/WindowInsetsHolder;", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "view", "Landroid/view/View;", "<init>", "(Landroidx/core/view/WindowInsetsCompat;Landroid/view/View;)V", "captionBar", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getCaptionBar", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "displayCutout", "getDisplayCutout", "ime", "getIme", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "statusBars", "getStatusBars", "systemBars", "getSystemBars", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "waterfall", "Landroidx/compose/foundation/layout/ValueInsets;", "getWaterfall", "()Landroidx/compose/foundation/layout/ValueInsets;", "<set-?>", "Landroidx/compose/ui/graphics/Path;", "cutoutPath", "getCutoutPath", "()Landroidx/compose/ui/graphics/Path;", "setCutoutPath", "(Landroidx/compose/ui/graphics/Path;)V", "cutoutPath$delegate", "Landroidx/compose/runtime/MutableState;", "safeDrawing", "Landroidx/compose/foundation/layout/WindowInsets;", "getSafeDrawing", "()Landroidx/compose/foundation/layout/WindowInsets;", "safeGestures", "getSafeGestures", "safeContent", "getSafeContent", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility", "imeAnimationTarget", "getImeAnimationTarget", "imeAnimationSource", "getImeAnimationSource", "consumes", "", "getConsumes$annotations", "()V", "getConsumes", "()Z", "accessCount", "", "insetsListener", "Landroidx/compose/foundation/layout/InsetsListener;", "incrementAccessors", "", "decrementAccessors", "update", "windowInsets", "types", "updateImeAnimationSource", "updateImeAnimationTarget", "Companion", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowInsetsHolder {
    @Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\tH\u0007J\r\u0010\f\u001A\u00020\u0007H\u0007¢\u0006\u0002\u0010\rJ\u000E\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0006J\"\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\"\u0010\u0018\u001A\u00020\u00192\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0002R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/layout/WindowInsetsHolder$Companion;", "", "<init>", "()V", "viewMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "testInsets", "", "setUseTestInsets", "", "current", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsetsHolder;", "getOrCreateFor", "view", "systemInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "type", "", "name", "", "valueInsetsIgnoringVisibility", "Landroidx/compose/foundation/layout/ValueInsets;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public static DisposableEffectResult $r8$lambda$yqmEbBIkZ6fFW2ULnWGsR44QoF8(WindowInsetsHolder arg0, View arg1, DisposableEffectScope arg2) {
            return Companion.current$lambda$0$0(arg0, arg1, arg2);
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final AndroidWindowInsets access$systemInsets(Companion arg0, WindowInsetsCompat arg1, int arg2, String arg3) {
            return arg0.systemInsets(arg1, arg2, arg3);
        }

        public static final ValueInsets access$valueInsetsIgnoringVisibility(Companion arg0, WindowInsetsCompat arg1, int arg2, String arg3) {
            return arg0.valueInsetsIgnoringVisibility(arg1, arg2, arg3);
        }

        public final WindowInsetsHolder current(Composer arg4, int arg5) {
            WindowInsetsHolder$Companion$$ExternalSyntheticLambda0 v1_2;
            int v1 = 0xAE8C36EA;
            ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(current)575@23670L7,578@23762L125,578@23737L150:WindowInsets.android.kt#2w3rfo");
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:574)");
            }

            ProvidableCompositionLocal v5 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v5_1 = arg4.consume(((CompositionLocal)v5));
            ComposerKt.sourceInformationMarkerEnd(arg4);
            WindowInsetsHolder v3 = this.getOrCreateFor(((View)v5_1));
            ComposerKt.sourceInformationMarkerStart(arg4, 0x3C5A3907, "CC(remember):WindowInsets.android.kt#9igjgp");
            int v0 = arg4.changedInstance(v3) | arg4.changedInstance(v5_1);
            Object v1_1 = arg4.rememberedValue();
            if(v0 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = new WindowInsetsHolder$Companion$$ExternalSyntheticLambda0(v3, ((View)v5_1));
                arg4.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg4);
            EffectsKt.DisposableEffect(v3, ((Function1)v1_2), arg4, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            ComposerKt.sourceInformationMarkerEnd(arg4);
            return v3;
        }

        private static final DisposableEffectResult current$lambda$0$0(WindowInsetsHolder arg0, View arg1, DisposableEffectScope arg2) {
            arg0.incrementAccessors(arg1);
            return new WindowInsetsHolder$Companion$current$lambda$0$0$$inlined$onDispose$1(arg0, arg1);
        }

        public final WindowInsetsHolder getOrCreateFor(View arg4) {
            WeakHashMap v3 = WindowInsetsHolder.viewMap;
            __monitor_enter(v3);
            try {
                WeakHashMap v0 = WindowInsetsHolder.viewMap;
                Object v1 = ((Map)v0).get(arg4);
                if(v1 == null) {
                    WindowInsetsHolder v1_1 = new WindowInsetsHolder(null, arg4, null);
                    ((Map)v0).put(arg4, v1_1);
                }

                __monitor_exit(v3);
                return ((WindowInsetsHolder)v1);
            }
            catch(Throwable v4) {
                __monitor_exit(v3);
                throw v4;
            }
        }

        public final void setUseTestInsets(boolean arg1) {
            WindowInsetsHolder.testInsets = arg1;
        }

        private final AndroidWindowInsets systemInsets(WindowInsetsCompat arg1, int arg2, String arg3) {
            AndroidWindowInsets v0 = new AndroidWindowInsets(arg2, arg3);
            if(arg1 != null) {
                v0.update$foundation_layout(arg1, arg2);
            }

            return v0;
        }

        private final ValueInsets valueInsetsIgnoringVisibility(WindowInsetsCompat arg1, int arg2, String arg3) {
            Insets v0;
            if(arg1 != null) {
                v0 = arg1.getInsetsIgnoringVisibility(arg2);
                if(v0 == null) {
                    goto label_3;
                }
            }
            else {
            label_3:
                v0 = Insets.NONE;
            }

            return WindowInsets_androidKt.ValueInsets(v0, arg3);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private int accessCount;
    private final AndroidWindowInsets captionBar;
    private final ValueInsets captionBarIgnoringVisibility;
    private final boolean consumes;
    private final MutableState cutoutPath$delegate;
    private final AndroidWindowInsets displayCutout;
    private final AndroidWindowInsets ime;
    private final ValueInsets imeAnimationSource;
    private final ValueInsets imeAnimationTarget;
    private final InsetsListener insetsListener;
    private final AndroidWindowInsets mandatorySystemGestures;
    private final AndroidWindowInsets navigationBars;
    private final ValueInsets navigationBarsIgnoringVisibility;
    private final WindowInsets safeContent;
    private final WindowInsets safeDrawing;
    private final WindowInsets safeGestures;
    private final AndroidWindowInsets statusBars;
    private final ValueInsets statusBarsIgnoringVisibility;
    private final AndroidWindowInsets systemBars;
    private final ValueInsets systemBarsIgnoringVisibility;
    private final AndroidWindowInsets systemGestures;
    private final AndroidWindowInsets tappableElement;
    private final ValueInsets tappableElementIgnoringVisibility;
    private static boolean testInsets;
    private static final WeakHashMap viewMap;
    private final ValueInsets waterfall;

    static {
        WindowInsetsHolder.Companion = new Companion(null);
        WindowInsetsHolder.$stable = 8;
        WindowInsetsHolder.viewMap = new WeakHashMap();
    }

    private WindowInsetsHolder(WindowInsetsCompat arg17, View arg18) {
        Path v14_2;
        Insets v12_1;
        WindowInsetsHolder v0 = this;
        WindowInsetsCompat v1 = arg17;
        super();
        Companion v2 = WindowInsetsHolder.Companion;
        AndroidWindowInsets v3 = Companion.access$systemInsets(v2, v1, Type.captionBar(), "captionBar");
        v0.captionBar = v3;
        AndroidWindowInsets v4 = Companion.access$systemInsets(v2, v1, Type.displayCutout(), "displayCutout");
        v0.displayCutout = v4;
        AndroidWindowInsets v5 = Companion.access$systemInsets(v2, v1, Type.ime(), "ime");
        v0.ime = v5;
        AndroidWindowInsets v6 = Companion.access$systemInsets(v2, v1, Type.mandatorySystemGestures(), "mandatorySystemGestures");
        v0.mandatorySystemGestures = v6;
        AndroidWindowInsets v7 = Companion.access$systemInsets(v2, v1, Type.navigationBars(), "navigationBars");
        v0.navigationBars = v7;
        AndroidWindowInsets v8 = Companion.access$systemInsets(v2, v1, Type.statusBars(), "statusBars");
        v0.statusBars = v8;
        AndroidWindowInsets v9 = Companion.access$systemInsets(v2, v1, Type.systemBars(), "systemBars");
        v0.systemBars = v9;
        AndroidWindowInsets v10 = Companion.access$systemInsets(v2, v1, Type.systemGestures(), "systemGestures");
        v0.systemGestures = v10;
        AndroidWindowInsets v11 = Companion.access$systemInsets(v2, v1, Type.tappableElement(), "tappableElement");
        v0.tappableElement = v11;
        if(v1 != null) {
            DisplayCutoutCompat v12 = v1.getDisplayCutout();
            if(v12 != null) {
                v12_1 = v12.getWaterfallInsets();
                if(v12_1 == null) {
                    goto label_45;
                }
            }
            else {
                goto label_45;
            }
        }
        else {
        label_45:
            v12_1 = Insets.NONE;
        }

        ValueInsets v12_2 = WindowInsets_androidKt.ValueInsets(v12_1, "waterfall");
        v0.waterfall = v12_2;
        SnapshotMutationPolicy v13 = null;
        if(v1 != null) {
            DisplayCutoutCompat v14 = v1.getDisplayCutout();
            if(v14 != null) {
                android.graphics.Path v14_1 = v14.getCutoutPath();
                if(v14_1 != null) {
                    v14_2 = AndroidPath_androidKt.asComposePath(v14_1);
                }
                else {
                    goto label_57;
                }
            }
            else {
                goto label_57;
            }
        }
        else {
        label_57:
            Object v14_3 = v13;
        }

        v0.cutoutPath$delegate = SnapshotStateKt.mutableStateOf$default(v14_2, v13, 2, v13);
        WindowInsets v14_4 = WindowInsetsKt.union(WindowInsetsKt.union(v9, v5), v4);
        v0.safeDrawing = v14_4;
        WindowInsets v12_3 = WindowInsetsKt.union(WindowInsetsKt.union(WindowInsetsKt.union(v11, v6), v10), ((WindowInsets)v12_2));
        v0.safeGestures = v12_3;
        v0.safeContent = WindowInsetsKt.union(v14_4, v12_3);
        v0.captionBarIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(v2, v1, Type.captionBar(), "captionBarIgnoringVisibility");
        v0.navigationBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(v2, v1, Type.navigationBars(), "navigationBarsIgnoringVisibility");
        v0.statusBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(v2, v1, Type.statusBars(), "statusBarsIgnoringVisibility");
        v0.systemBarsIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(v2, v1, Type.systemBars(), "systemBarsIgnoringVisibility");
        v0.tappableElementIgnoringVisibility = Companion.access$valueInsetsIgnoringVisibility(v2, v1, Type.tappableElement(), "tappableElementIgnoringVisibility");
        v0.imeAnimationTarget = WindowInsets_androidKt.ValueInsets(Insets.NONE, "imeAnimationTarget");
        v0.imeAnimationSource = WindowInsets_androidKt.ValueInsets(Insets.NONE, "imeAnimationSource");
        ViewParent v1_1 = arg18.getParent();
        if((v1_1 instanceof View)) {
        }
        else {
            v1_1 = null;
        }

        Object v1_2 = v1_1 != null ? ((View)v1_1).getTag(id.consume_window_insets_tag) : null;
        Object v13_1 = (v1_2 instanceof Boolean) ? v1_2 : null;
        boolean v1_3 = v13_1 != null ? ((Boolean)v13_1).booleanValue() : false;
        v0.consumes = v1_3;
        v0.insetsListener = new InsetsListener(v0);
        WindowInsetsCompat v0_1 = ViewCompat.getRootWindowInsets(arg18);
        if(v0_1 != null) {
            v3.setVisible(v0_1.isVisible(Type.captionBar()));
            v4.setVisible(v0_1.isVisible(Type.displayCutout()));
            v5.setVisible(v0_1.isVisible(Type.ime()));
            v6.setVisible(v0_1.isVisible(Type.mandatorySystemGestures()));
            v7.setVisible(v0_1.isVisible(Type.navigationBars()));
            v8.setVisible(v0_1.isVisible(Type.statusBars()));
            v9.setVisible(v0_1.isVisible(Type.systemBars()));
            v10.setVisible(v0_1.isVisible(Type.systemGestures()));
            v11.setVisible(v0_1.isVisible(Type.tappableElement()));
        }
    }

    public WindowInsetsHolder(WindowInsetsCompat arg1, View arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public static final WeakHashMap access$getViewMap$cp() {
        return WindowInsetsHolder.viewMap;
    }

    public static final void access$setTestInsets$cp(boolean arg0) {
        WindowInsetsHolder.testInsets = arg0;
    }

    public final void decrementAccessors(View arg2) {
        int v0 = this.accessCount - 1;
        this.accessCount = v0;
        if(v0 == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(arg2, null);
            ViewCompat.setWindowInsetsAnimationCallback(arg2, null);
            arg2.removeOnAttachStateChangeListener(this.insetsListener);
        }
    }

    public final AndroidWindowInsets getCaptionBar() {
        return this.captionBar;
    }

    public final ValueInsets getCaptionBarIgnoringVisibility() {
        return this.captionBarIgnoringVisibility;
    }

    public final boolean getConsumes() {
        return this.consumes;
    }

    public static void getConsumes$annotations() {
    }

    public final Path getCutoutPath() {
        return this.cutoutPath$delegate.getValue();
    }

    public final AndroidWindowInsets getDisplayCutout() {
        return this.displayCutout;
    }

    public final AndroidWindowInsets getIme() {
        return this.ime;
    }

    public final ValueInsets getImeAnimationSource() {
        return this.imeAnimationSource;
    }

    public final ValueInsets getImeAnimationTarget() {
        return this.imeAnimationTarget;
    }

    public final AndroidWindowInsets getMandatorySystemGestures() {
        return this.mandatorySystemGestures;
    }

    public final AndroidWindowInsets getNavigationBars() {
        return this.navigationBars;
    }

    public final ValueInsets getNavigationBarsIgnoringVisibility() {
        return this.navigationBarsIgnoringVisibility;
    }

    public final WindowInsets getSafeContent() {
        return this.safeContent;
    }

    public final WindowInsets getSafeDrawing() {
        return this.safeDrawing;
    }

    public final WindowInsets getSafeGestures() {
        return this.safeGestures;
    }

    public final AndroidWindowInsets getStatusBars() {
        return this.statusBars;
    }

    public final ValueInsets getStatusBarsIgnoringVisibility() {
        return this.statusBarsIgnoringVisibility;
    }

    public final AndroidWindowInsets getSystemBars() {
        return this.systemBars;
    }

    public final ValueInsets getSystemBarsIgnoringVisibility() {
        return this.systemBarsIgnoringVisibility;
    }

    public final AndroidWindowInsets getSystemGestures() {
        return this.systemGestures;
    }

    public final AndroidWindowInsets getTappableElement() {
        return this.tappableElement;
    }

    public final ValueInsets getTappableElementIgnoringVisibility() {
        return this.tappableElementIgnoringVisibility;
    }

    public final ValueInsets getWaterfall() {
        return this.waterfall;
    }

    public final void incrementAccessors(View arg2) {
        if(this.accessCount == 0) {
            ViewCompat.setOnApplyWindowInsetsListener(arg2, this.insetsListener);
            if(arg2.isAttachedToWindow()) {
                arg2.requestApplyInsets();
            }

            arg2.addOnAttachStateChangeListener(this.insetsListener);
            ViewCompat.setWindowInsetsAnimationCallback(arg2, this.insetsListener);
        }

        ++this.accessCount;
    }

    private final void setCutoutPath(Path arg1) {
        this.cutoutPath$delegate.setValue(arg1);
    }

    public final void update(WindowInsetsCompat arg2, int arg3) {
        Path v2_3;
        Insets v0;
        if(WindowInsetsHolder.testInsets) {
            android.view.WindowInsets v2 = arg2.toWindowInsets();
            Intrinsics.checkNotNull(v2);
            arg2 = WindowInsetsCompat.toWindowInsetsCompat(v2);
        }

        this.captionBar.update$foundation_layout(arg2, arg3);
        this.ime.update$foundation_layout(arg2, arg3);
        this.displayCutout.update$foundation_layout(arg2, arg3);
        this.navigationBars.update$foundation_layout(arg2, arg3);
        this.statusBars.update$foundation_layout(arg2, arg3);
        this.systemBars.update$foundation_layout(arg2, arg3);
        this.systemGestures.update$foundation_layout(arg2, arg3);
        this.tappableElement.update$foundation_layout(arg2, arg3);
        this.mandatorySystemGestures.update$foundation_layout(arg2, arg3);
        if(arg3 == 0) {
            this.captionBarIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(arg2.getInsetsIgnoringVisibility(Type.captionBar())));
            this.navigationBarsIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(arg2.getInsetsIgnoringVisibility(Type.navigationBars())));
            this.statusBarsIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(arg2.getInsetsIgnoringVisibility(Type.statusBars())));
            this.systemBarsIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(arg2.getInsetsIgnoringVisibility(Type.systemBars())));
            this.tappableElementIgnoringVisibility.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(arg2.getInsetsIgnoringVisibility(Type.tappableElement())));
            DisplayCutoutCompat v2_1 = arg2.getDisplayCutout();
            ValueInsets v3 = this.waterfall;
            if(v2_1 != null) {
                v0 = v2_1.getWaterfallInsets();
                if(v0 == null) {
                    goto label_54;
                }
            }
            else {
            label_54:
                v0 = Insets.NONE;
            }

            v3.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(v0));
            if(v2_1 != null) {
                android.graphics.Path v2_2 = v2_1.getCutoutPath();
                if(v2_2 != null) {
                    v2_3 = AndroidPath_androidKt.asComposePath(v2_2);
                }
                else {
                    goto label_62;
                }
            }
            else {
            label_62:
                v2_3 = null;
            }

            this.setCutoutPath(v2_3);
        }

        Snapshot.Companion.sendApplyNotifications();
    }

    public static void update$default(WindowInsetsHolder arg0, WindowInsetsCompat arg1, int arg2, int arg3, Object arg4) {
        arg0.update(arg1, 0);
    }

    public final void updateImeAnimationSource(WindowInsetsCompat arg2) {
        this.imeAnimationSource.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(arg2.getInsets(Type.ime())));
    }

    public final void updateImeAnimationTarget(WindowInsetsCompat arg2) {
        this.imeAnimationTarget.setValue$foundation_layout(WindowInsets_androidKt.toInsetsValues(arg2.getInsets(Type.ime())));
    }
}

