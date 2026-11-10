package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.retain.LocalRetainedValuesStoreKt;
import androidx.compose.ui.node.Owner;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000ä\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A0\u0010P\u001A\u00020Q2\u0006\u0010R\u001A\u00020S2\u0006\u0010T\u001A\u00020<2\u0011\u0010U\u001A\r\u0012\u0004\u0012\u00020Q0V¢\u0006\u0002\bWH\u0001¢\u0006\u0002\u0010X\u001A\u0010\u0010Y\u001A\u00020Z2\u0006\u0010[\u001A\u00020\\H\u0002\"\u0019\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004\"$\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\u0004\"\"\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\f\u0010\b\u001A\u0004\b\r\u0010\u0004\"\u0019\u0010\u000E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0004\"\"\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0013\u0010\b\u001A\u0004\b\u0014\u0010\u0004\"\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00160\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0004\"\u0017\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00190\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0004\"\u0017\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001C0\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0004\"\u0017\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001F0\u0001¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0004\" \u0010!\u001A\b\u0012\u0004\u0012\u00020\"0\u0001X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b#\u0010\b\u001A\u0004\b$\u0010\u0004\"\u0017\u0010%\u001A\b\u0012\u0004\u0012\u00020&0\u0001¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010\u0004\"\u0017\u0010(\u001A\b\u0012\u0004\u0012\u00020)0\u0001¢\u0006\b\n\u0000\u001A\u0004\b*\u0010\u0004\"\u0017\u0010+\u001A\b\u0012\u0004\u0012\u00020,0\u0001¢\u0006\b\n\u0000\u001A\u0004\b-\u0010\u0004\"\u0017\u0010.\u001A\b\u0012\u0004\u0012\u00020/0\u0001¢\u0006\b\n\u0000\u001A\u0004\b0\u0010\u0004\"$\u00101\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001020\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b3\u0010\b\u001A\u0004\b4\u0010\u0004\"\u0019\u00105\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001060\u0001¢\u0006\b\n\u0000\u001A\u0004\b7\u0010\u0004\"\u0017\u00108\u001A\b\u0012\u0004\u0012\u0002090\u0001¢\u0006\b\n\u0000\u001A\u0004\b:\u0010\u0004\"\u0017\u0010;\u001A\b\u0012\u0004\u0012\u00020<0\u0001¢\u0006\b\n\u0000\u001A\u0004\b=\u0010\u0004\"\u0017\u0010>\u001A\b\u0012\u0004\u0012\u00020?0\u0001¢\u0006\b\n\u0000\u001A\u0004\b@\u0010\u0004\"\u0017\u0010A\u001A\b\u0012\u0004\u0012\u00020B0\u0001¢\u0006\b\n\u0000\u001A\u0004\bC\u0010\u0004\"\u001C\u0010D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010E0\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bF\u0010\u0004\"\u001A\u0010G\u001A\b\u0012\u0004\u0012\u00020H0\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bI\u0010\u0004\"\u0017\u0010J\u001A\b\u0012\u0004\u0012\u00020H0K8F¢\u0006\u0006\u001A\u0004\bL\u0010M\"\u0017\u0010N\u001A\b\u0012\u0004\u0012\u00020H0\u0001¢\u0006\b\n\u0000\u001A\u0004\bO\u0010\u0004¨\u0006]"}, d2={"LocalAccessibilityManager", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/AccessibilityManager;", "getLocalAccessibilityManager", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalAutofill", "Landroidx/compose/ui/autofill/Autofill;", "getLocalAutofill$annotations", "()V", "getLocalAutofill", "LocalAutofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getLocalAutofillTree$annotations", "getLocalAutofillTree", "LocalAutofillManager", "Landroidx/compose/ui/autofill/AutofillManager;", "getLocalAutofillManager", "LocalClipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getLocalClipboardManager$annotations", "getLocalClipboardManager", "LocalClipboard", "Landroidx/compose/ui/platform/Clipboard;", "getLocalClipboard", "LocalGraphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getLocalGraphicsContext", "LocalDensity", "Landroidx/compose/ui/unit/Density;", "getLocalDensity", "LocalFocusManager", "Landroidx/compose/ui/focus/FocusManager;", "getLocalFocusManager", "LocalFontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getLocalFontLoader$annotations", "getLocalFontLoader", "LocalFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getLocalFontFamilyResolver", "LocalHapticFeedback", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getLocalHapticFeedback", "LocalInputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getLocalInputModeManager", "LocalLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLocalLayoutDirection", "LocalTextInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getLocalTextInputService$annotations", "getLocalTextInputService", "LocalSoftwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getLocalSoftwareKeyboardController", "LocalTextToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getLocalTextToolbar", "LocalUriHandler", "Landroidx/compose/ui/platform/UriHandler;", "getLocalUriHandler", "LocalViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getLocalViewConfiguration", "LocalWindowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getLocalWindowInfo", "LocalPointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getLocalPointerIconService", "LocalProvidableScrollCaptureInProgress", "", "getLocalProvidableScrollCaptureInProgress", "LocalScrollCaptureInProgress", "Landroidx/compose/runtime/CompositionLocal;", "getLocalScrollCaptureInProgress", "()Landroidx/compose/runtime/CompositionLocal;", "LocalCursorBlinkEnabled", "getLocalCursorBlinkEnabled", "ProvideCommonCompositionLocals", "", "owner", "Landroidx/compose/ui/node/Owner;", "uriHandler", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/UriHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "noLocalProvidedFor", "", "name", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CompositionLocalsKt {
    private static final ProvidableCompositionLocal LocalAccessibilityManager;
    private static final ProvidableCompositionLocal LocalAutofill;
    private static final ProvidableCompositionLocal LocalAutofillManager;
    private static final ProvidableCompositionLocal LocalAutofillTree;
    private static final ProvidableCompositionLocal LocalClipboard;
    private static final ProvidableCompositionLocal LocalClipboardManager;
    private static final ProvidableCompositionLocal LocalCursorBlinkEnabled;
    private static final ProvidableCompositionLocal LocalDensity;
    private static final ProvidableCompositionLocal LocalFocusManager;
    private static final ProvidableCompositionLocal LocalFontFamilyResolver;
    private static final ProvidableCompositionLocal LocalFontLoader;
    private static final ProvidableCompositionLocal LocalGraphicsContext;
    private static final ProvidableCompositionLocal LocalHapticFeedback;
    private static final ProvidableCompositionLocal LocalInputModeManager;
    private static final ProvidableCompositionLocal LocalLayoutDirection;
    private static final ProvidableCompositionLocal LocalPointerIconService;
    private static final ProvidableCompositionLocal LocalProvidableScrollCaptureInProgress;
    private static final ProvidableCompositionLocal LocalSoftwareKeyboardController;
    private static final ProvidableCompositionLocal LocalTextInputService;
    private static final ProvidableCompositionLocal LocalTextToolbar;
    private static final ProvidableCompositionLocal LocalUriHandler;
    private static final ProvidableCompositionLocal LocalViewConfiguration;
    private static final ProvidableCompositionLocal LocalWindowInfo;

    static {
        CompositionLocalsKt.LocalAccessibilityManager = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalAccessibilityManager$1.INSTANCE);
        CompositionLocalsKt.LocalAutofill = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalAutofill$1.INSTANCE);
        CompositionLocalsKt.LocalAutofillTree = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalAutofillTree$1.INSTANCE);
        CompositionLocalsKt.LocalAutofillManager = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalAutofillManager$1.INSTANCE);
        CompositionLocalsKt.LocalClipboardManager = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalClipboardManager$1.INSTANCE);
        CompositionLocalsKt.LocalClipboard = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalClipboard$1.INSTANCE);
        CompositionLocalsKt.LocalGraphicsContext = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalGraphicsContext$1.INSTANCE);
        CompositionLocalsKt.LocalDensity = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalDensity$1.INSTANCE);
        CompositionLocalsKt.LocalFocusManager = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalFocusManager$1.INSTANCE);
        CompositionLocalsKt.LocalFontLoader = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalFontLoader$1.INSTANCE);
        CompositionLocalsKt.LocalFontFamilyResolver = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalFontFamilyResolver$1.INSTANCE);
        CompositionLocalsKt.LocalHapticFeedback = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalHapticFeedback$1.INSTANCE);
        CompositionLocalsKt.LocalInputModeManager = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalInputModeManager$1.INSTANCE);
        CompositionLocalsKt.LocalLayoutDirection = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalLayoutDirection$1.INSTANCE);
        CompositionLocalsKt.LocalTextInputService = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalTextInputService$1.INSTANCE);
        CompositionLocalsKt.LocalSoftwareKeyboardController = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalSoftwareKeyboardController$1.INSTANCE);
        CompositionLocalsKt.LocalTextToolbar = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalTextToolbar$1.INSTANCE);
        CompositionLocalsKt.LocalUriHandler = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalUriHandler$1.INSTANCE);
        CompositionLocalsKt.LocalViewConfiguration = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalViewConfiguration$1.INSTANCE);
        CompositionLocalsKt.LocalWindowInfo = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalWindowInfo$1.INSTANCE);
        CompositionLocalsKt.LocalPointerIconService = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalPointerIconService$1.INSTANCE);
        CompositionLocalsKt.LocalProvidableScrollCaptureInProgress = CompositionLocalKt.compositionLocalOf$default(null, CompositionLocalsKt$LocalProvidableScrollCaptureInProgress$1.INSTANCE, 1, null);
        CompositionLocalsKt.LocalCursorBlinkEnabled = CompositionLocalKt.staticCompositionLocalOf(CompositionLocalsKt$LocalCursorBlinkEnabled$1.INSTANCE);
    }

    public static final void ProvideCommonCompositionLocals(Owner arg9, UriHandler arg10, Function2 arg11, Composer arg12, int arg13) {
        int v4_1;
        boolean v4;
        int v1_1;
        int v0 = 0x72C96E60;
        arg12 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg12, "C(ProvideCommonCompositionLocals)P(1,2)216@9165L1436:CompositionLocals.kt#itgzvw");
        int v2 = 4;
        int v3 = 2;
        if((arg13 & 6) == 0) {
            boolean v1 = (arg13 & 8) == 0 ? arg12.changed(arg9) : arg12.changedInstance(arg9);
            v1_1 = v1 ? v2 : v3;
            v1_1 |= arg13;
        }
        else {
            v1_1 = arg13;
        }

        int v5 = 16;
        if((arg13 & 0x30) == 0) {
            v4 = (arg13 & 0x40) == 0 ? arg12.changed(arg10) : arg12.changedInstance(arg10);
            v4_1 = v4 ? 0x20 : v5;
            v1_1 |= v4_1;
        }

        if((arg13 & 0x180) == 0) {
            v4_1 = arg12.changedInstance(arg11) ? 0x100 : 0x80;
            v1_1 |= v4_1;
        }

        v4 = (v1_1 & 0x93) != 0x92 ? true : false;
        if(arg12.shouldExecute(v4, v1_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1_1, -1, "androidx.compose.ui.platform.ProvideCommonCompositionLocals (CompositionLocals.kt:215)");
            }

            ProvidedValue[] v0_1 = new ProvidedValue[22];
            v0_1[0] = CompositionLocalsKt.LocalAccessibilityManager.provides(arg9.getAccessibilityManager());
            v0_1[1] = CompositionLocalsKt.LocalAutofill.provides(arg9.getAutofill());
            v0_1[v3] = CompositionLocalsKt.LocalAutofillManager.provides(arg9.getAutofillManager());
            v0_1[3] = CompositionLocalsKt.LocalAutofillTree.provides(arg9.getAutofillTree());
            v0_1[v2] = CompositionLocalsKt.LocalClipboardManager.provides(arg9.getClipboardManager());
            v0_1[5] = CompositionLocalsKt.LocalClipboard.provides(arg9.getClipboard());
            v0_1[6] = CompositionLocalsKt.LocalDensity.provides(arg9.getDensity());
            v0_1[7] = CompositionLocalsKt.LocalFocusManager.provides(arg9.getFocusOwner());
            v0_1[8] = CompositionLocalsKt.LocalFontLoader.providesDefault(arg9.getFontLoader());
            v0_1[9] = CompositionLocalsKt.LocalFontFamilyResolver.providesDefault(arg9.getFontFamilyResolver());
            v0_1[10] = CompositionLocalsKt.LocalHapticFeedback.provides(arg9.getHapticFeedBack());
            v0_1[11] = CompositionLocalsKt.LocalInputModeManager.provides(arg9.getInputModeManager());
            v0_1[12] = CompositionLocalsKt.LocalLayoutDirection.provides(arg9.getLayoutDirection());
            v0_1[13] = CompositionLocalsKt.LocalTextInputService.provides(arg9.getTextInputService());
            v0_1[14] = CompositionLocalsKt.LocalSoftwareKeyboardController.provides(arg9.getSoftwareKeyboardController());
            v0_1[15] = CompositionLocalsKt.LocalTextToolbar.provides(arg9.getTextToolbar());
            v0_1[v5] = CompositionLocalsKt.LocalUriHandler.provides(arg10);
            v0_1[17] = CompositionLocalsKt.LocalViewConfiguration.provides(arg9.getViewConfiguration());
            v0_1[18] = CompositionLocalsKt.LocalWindowInfo.provides(arg9.getWindowInfo());
            v0_1[19] = CompositionLocalsKt.LocalPointerIconService.provides(arg9.getPointerIconService());
            v0_1[20] = CompositionLocalsKt.LocalGraphicsContext.provides(arg9.getGraphicsContext());
            v0_1[21] = LocalRetainedValuesStoreKt.getLocalRetainedValuesStore().provides(arg9.getRetainedValuesStore());
            CompositionLocalKt.CompositionLocalProvider(v0_1, arg11, arg12, v1_1 >> 3 & 0x70 | ProvidedValue.$stable);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_173;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_173:
        ScopeUpdateScope v12 = arg12.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new CompositionLocalsKt$ProvideCommonCompositionLocals$1(arg9, arg10, arg11, arg13));
        }
    }

    public static final Void access$noLocalProvidedFor(String arg0) {
        return CompositionLocalsKt.noLocalProvidedFor(arg0);
    }

    public static final ProvidableCompositionLocal getLocalAccessibilityManager() {
        return CompositionLocalsKt.LocalAccessibilityManager;
    }

    public static final ProvidableCompositionLocal getLocalAutofill() {
        return CompositionLocalsKt.LocalAutofill;
    }

    @Deprecated(message="\n        Use the new semantics-based Autofill APIs androidx.compose.ui.autofill.ContentType and\n        androidx.compose.ui.autofill.ContentDataType instead.\n        ") public static void getLocalAutofill$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalAutofillManager() {
        return CompositionLocalsKt.LocalAutofillManager;
    }

    public static final ProvidableCompositionLocal getLocalAutofillTree() {
        return CompositionLocalsKt.LocalAutofillTree;
    }

    @Deprecated(message="\n        Use the new semantics-based Autofill APIs androidx.compose.ui.autofill.ContentType and\n        androidx.compose.ui.autofill.ContentDataType instead.\n        ") public static void getLocalAutofillTree$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalClipboard() {
        return CompositionLocalsKt.LocalClipboard;
    }

    public static final ProvidableCompositionLocal getLocalClipboardManager() {
        return CompositionLocalsKt.LocalClipboardManager;
    }

    @Deprecated(message="Use LocalClipboard instead which supports suspend functions", replaceWith="<_subannotation>") public static void getLocalClipboardManager$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalCursorBlinkEnabled() {
        return CompositionLocalsKt.LocalCursorBlinkEnabled;
    }

    public static final ProvidableCompositionLocal getLocalDensity() {
        return CompositionLocalsKt.LocalDensity;
    }

    public static final ProvidableCompositionLocal getLocalFocusManager() {
        return CompositionLocalsKt.LocalFocusManager;
    }

    public static final ProvidableCompositionLocal getLocalFontFamilyResolver() {
        return CompositionLocalsKt.LocalFontFamilyResolver;
    }

    public static final ProvidableCompositionLocal getLocalFontLoader() {
        return CompositionLocalsKt.LocalFontLoader;
    }

    @Deprecated(message="LocalFontLoader is replaced with LocalFontFamilyResolver", replaceWith="<_subannotation>") public static void getLocalFontLoader$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalGraphicsContext() {
        return CompositionLocalsKt.LocalGraphicsContext;
    }

    public static final ProvidableCompositionLocal getLocalHapticFeedback() {
        return CompositionLocalsKt.LocalHapticFeedback;
    }

    public static final ProvidableCompositionLocal getLocalInputModeManager() {
        return CompositionLocalsKt.LocalInputModeManager;
    }

    public static final ProvidableCompositionLocal getLocalLayoutDirection() {
        return CompositionLocalsKt.LocalLayoutDirection;
    }

    public static final ProvidableCompositionLocal getLocalPointerIconService() {
        return CompositionLocalsKt.LocalPointerIconService;
    }

    public static final ProvidableCompositionLocal getLocalProvidableScrollCaptureInProgress() {
        return CompositionLocalsKt.LocalProvidableScrollCaptureInProgress;
    }

    public static final CompositionLocal getLocalScrollCaptureInProgress() {
        return CompositionLocalsKt.LocalProvidableScrollCaptureInProgress;
    }

    public static final ProvidableCompositionLocal getLocalSoftwareKeyboardController() {
        return CompositionLocalsKt.LocalSoftwareKeyboardController;
    }

    public static final ProvidableCompositionLocal getLocalTextInputService() {
        return CompositionLocalsKt.LocalTextInputService;
    }

    @Deprecated(message="Use PlatformTextInputModifierNode instead.") public static void getLocalTextInputService$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalTextToolbar() {
        return CompositionLocalsKt.LocalTextToolbar;
    }

    public static final ProvidableCompositionLocal getLocalUriHandler() {
        return CompositionLocalsKt.LocalUriHandler;
    }

    public static final ProvidableCompositionLocal getLocalViewConfiguration() {
        return CompositionLocalsKt.LocalViewConfiguration;
    }

    public static final ProvidableCompositionLocal getLocalWindowInfo() {
        return CompositionLocalsKt.LocalWindowInfo;
    }

    private static final Void noLocalProvidedFor(String arg3) {
        throw new IllegalStateException("CompositionLocal " + arg3 + " not present".toString());
    }
}

