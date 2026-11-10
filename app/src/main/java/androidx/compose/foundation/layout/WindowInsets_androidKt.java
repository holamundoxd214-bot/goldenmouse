package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R$id;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b/\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0000\".\u0010\n\u001A\u00020\t*\u00020\u000B2\u0006\u0010\b\u001A\u00020\t8F@FX\u0086\u000E¢\u0006\u0012\u0012\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011\".\u0010\n\u001A\u00020\t*\u00020\u00122\u0006\u0010\b\u001A\u00020\t8F@FX\u0087\u000E¢\u0006\u0012\u0012\u0004\b\f\u0010\u0013\u001A\u0004\b\u000E\u0010\u0014\"\u0004\b\u0010\u0010\u0015\"\u0015\u0010\u0016\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A\"\u0015\u0010\u001B\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001A\"\u0015\u0010\u001D\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001A\"\u0015\u0010\u001F\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b \u0010\u001A\"\u0015\u0010!\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b\"\u0010\u001A\"\u0015\u0010#\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b$\u0010\u001A\"\u0015\u0010%\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b&\u0010\u001A\"\u0015\u0010\'\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b(\u0010\u001A\"\u0015\u0010)\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b*\u0010\u001A\"\u0015\u0010+\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b,\u0010\u001A\"\u0017\u0010-\u001A\u0004\u0018\u00010.*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b/\u00100\"\u0015\u00101\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b2\u0010\u001A\"\u0015\u00103\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b4\u0010\u001A\"\u0015\u00105\u001A\u00020\u0017*\u00020\u00188G¢\u0006\u0006\u001A\u0004\b6\u0010\u001A\"\u001E\u00107\u001A\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u00109\u001A\u0004\b:\u0010\u001A\"\u001E\u0010;\u001A\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b<\u00109\u001A\u0004\b=\u0010\u001A\"\u001E\u0010>\u001A\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u00109\u001A\u0004\b@\u0010\u001A\"\u001E\u0010A\u001A\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u00109\u001A\u0004\bC\u0010\u001A\"\u001E\u0010D\u001A\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u00109\u001A\u0004\bF\u0010\u001A\"\u001E\u0010G\u001A\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u00109\u001A\u0004\bG\u0010I\"\u001E\u0010J\u001A\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bK\u00109\u001A\u0004\bJ\u0010I\"\u001E\u0010L\u001A\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u00109\u001A\u0004\bN\u0010I\"\u001E\u0010O\u001A\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bP\u00109\u001A\u0004\bQ\u0010I\"\u001E\u0010R\u001A\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bS\u00109\u001A\u0004\bT\u0010I\"\u001E\u0010U\u001A\u00020\t*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bV\u00109\u001A\u0004\bU\u0010I\"\u001E\u0010W\u001A\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u00109\u001A\u0004\bY\u0010\u001A\"\u001E\u0010Z\u001A\u00020\u0017*\u00020\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b[\u00109\u001A\u0004\b\\\u0010\u001A¨\u0006]"}, d2={"toInsetsValues", "Landroidx/compose/foundation/layout/InsetsValues;", "Landroidx/core/graphics/Insets;", "ValueInsets", "Landroidx/compose/foundation/layout/ValueInsets;", "insets", "name", "", "value", "", "consumeWindowInsets", "Landroidx/compose/ui/platform/AbstractComposeView;", "getConsumeWindowInsets$annotations", "(Landroidx/compose/ui/platform/AbstractComposeView;)V", "getConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;)Z", "setConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;Z)V", "Landroidx/compose/ui/platform/ComposeView;", "(Landroidx/compose/ui/platform/ComposeView;)V", "(Landroidx/compose/ui/platform/ComposeView;)Z", "(Landroidx/compose/ui/platform/ComposeView;Z)V", "captionBar", "Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/foundation/layout/WindowInsets$Companion;", "getCaptionBar", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "displayCutout", "getDisplayCutout", "ime", "getIme", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "statusBars", "getStatusBars", "systemBars", "getSystemBars", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "waterfall", "getWaterfall", "cutoutPath", "Landroidx/compose/ui/graphics/Path;", "getCutoutPath", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Path;", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "safeContent", "getSafeContent", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)V", "getCaptionBarIgnoringVisibility", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility$annotations", "getNavigationBarsIgnoringVisibility", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility$annotations", "getStatusBarsIgnoringVisibility", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility$annotations", "getSystemBarsIgnoringVisibility", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility$annotations", "getTappableElementIgnoringVisibility", "isCaptionBarVisible", "isCaptionBarVisible$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Z", "isImeVisible", "isImeVisible$annotations", "areStatusBarsVisible", "getAreStatusBarsVisible$annotations", "getAreStatusBarsVisible", "areNavigationBarsVisible", "getAreNavigationBarsVisible$annotations", "getAreNavigationBarsVisible", "areSystemBarsVisible", "getAreSystemBarsVisible$annotations", "getAreSystemBarsVisible", "isTappableElementVisible", "isTappableElementVisible$annotations", "imeAnimationSource", "getImeAnimationSource$annotations", "getImeAnimationSource", "imeAnimationTarget", "getImeAnimationTarget$annotations", "getImeAnimationTarget", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowInsets_androidKt {
    public static final ValueInsets ValueInsets(Insets arg1, String arg2) {
        return new ValueInsets(WindowInsets_androidKt.toInsetsValues(arg1), arg2);
    }

    public static final boolean getAreNavigationBarsVisible(Companion arg2, Composer arg3, int arg4) {
        int v0 = 710310464;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-areNavigationBarsVisible>)313@12383L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-areNavigationBarsVisible> (WindowInsets.android.kt:313)");
        }

        boolean v2 = WindowInsetsHolder.Companion.current(arg3, 6).getNavigationBars().isVisible();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static void getAreNavigationBarsVisible$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final boolean getAreStatusBarsVisible(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x6028C080;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-areStatusBarsVisible>)303@12065L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-areStatusBarsVisible> (WindowInsets.android.kt:303)");
        }

        boolean v2 = WindowInsetsHolder.Companion.current(arg3, 6).getStatusBars().isVisible();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static void getAreStatusBarsVisible$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final boolean getAreSystemBarsVisible(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x76582F20;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-areSystemBarsVisible>)321@12689L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-areSystemBarsVisible> (WindowInsets.android.kt:321)");
        }

        boolean v2 = WindowInsetsHolder.Companion.current(arg3, 6).getSystemBars().isVisible();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static void getAreSystemBarsVisible$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final WindowInsets getCaptionBar(Companion arg2, Composer arg3, int arg4) {
        int v0 = -1832025528;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-captionBar>)141@5205L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-captionBar> (WindowInsets.android.kt:141)");
        }

        AndroidWindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getCaptionBar();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final WindowInsets getCaptionBarIgnoringVisibility(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x98CF328A;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-captionBarIgnoringVisibility>)236@9557L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-captionBarIgnoringVisibility> (WindowInsets.android.kt:236)");
        }

        ValueInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getCaptionBarIgnoringVisibility();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static void getCaptionBarIgnoringVisibility$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final boolean getConsumeWindowInsets(AbstractComposeView arg1) {
        Object v1 = arg1.getTag(id.consume_window_insets_tag);
        if((v1 instanceof Boolean)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((Boolean)v1).booleanValue();
        }

        return 0;
    }

    public static final boolean getConsumeWindowInsets(ComposeView arg1) {
        Object v1 = arg1.getTag(id.consume_window_insets_tag);
        if((v1 instanceof Boolean)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            return ((Boolean)v1).booleanValue();
        }

        return 0;
    }

    public static void getConsumeWindowInsets$annotations(AbstractComposeView arg0) {
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use AbstractComposeView.consumeWindowInsets") public static void getConsumeWindowInsets$annotations(ComposeView arg0) {
    }

    public static final Path getCutoutPath(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0xE4EC7BD1;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-cutoutPath>)204@8139L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-cutoutPath> (WindowInsets.android.kt:204)");
        }

        Path v2 = WindowInsetsHolder.Companion.current(arg3, 6).getCutoutPath();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static final WindowInsets getDisplayCutout(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x4EF71D3C;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-displayCutout>)148@5545L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-displayCutout> (WindowInsets.android.kt:148)");
        }

        AndroidWindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getDisplayCutout();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final WindowInsets getIme(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0xA8909C1C;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-ime>)160@6171L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-ime> (WindowInsets.android.kt:160)");
        }

        AndroidWindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getIme();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final WindowInsets getImeAnimationSource(Companion arg2, Composer arg3, int arg4) {
        int v0 = -1126064918;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-imeAnimationSource>)340@13433L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-imeAnimationSource> (WindowInsets.android.kt:340)");
        }

        ValueInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getImeAnimationSource();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static void getImeAnimationSource$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final WindowInsets getImeAnimationTarget(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0xE4348656;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-imeAnimationTarget>)350@13889L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-imeAnimationTarget> (WindowInsets.android.kt:350)");
        }

        ValueInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getImeAnimationTarget();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static void getImeAnimationTarget$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final WindowInsets getMandatorySystemGestures(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x51A0CDFC;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-mandatorySystemGestures>)169@6505L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-mandatorySystemGestures> (WindowInsets.android.kt:169)");
        }

        AndroidWindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getMandatorySystemGestures();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final WindowInsets getNavigationBars(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x5F23B556;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-navigationBars>)176@6853L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-navigationBars> (WindowInsets.android.kt:176)");
        }

        AndroidWindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getNavigationBars();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final WindowInsets getNavigationBarsIgnoringVisibility(Companion arg2, Composer arg3, int arg4) {
        int v0 = -1990981160;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-navigationBarsIgnoringVisibility>)247@10046L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-navigationBarsIgnoringVisibility> (WindowInsets.android.kt:247)");
        }

        ValueInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getNavigationBarsIgnoringVisibility();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static void getNavigationBarsIgnoringVisibility$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final WindowInsets getSafeContent(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x8733903C;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-safeContent>)226@9223L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-safeContent> (WindowInsets.android.kt:226)");
        }

        WindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getSafeContent();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static final WindowInsets getSafeDrawing(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0xFD0D961C;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-safeDrawing>)211@8491L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-safeDrawing> (WindowInsets.android.kt:211)");
        }

        WindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getSafeDrawing();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static final WindowInsets getSafeGestures(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0xA0F9B59C;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-safeGestures>)219@8914L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-safeGestures> (WindowInsets.android.kt:219)");
        }

        WindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getSafeGestures();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static final WindowInsets getStatusBars(Companion arg2, Composer arg3, int arg4) {
        int v0 = -675090670;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-statusBars>)180@7060L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-statusBars> (WindowInsets.android.kt:180)");
        }

        AndroidWindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getStatusBars();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final WindowInsets getStatusBarsIgnoringVisibility(Companion arg2, Composer arg3, int arg4) {
        int v0 = 594020756;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-statusBarsIgnoringVisibility>)257@10413L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-statusBarsIgnoringVisibility> (WindowInsets.android.kt:257)");
        }

        ValueInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getStatusBarsIgnoringVisibility();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static void getStatusBarsIgnoringVisibility$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final WindowInsets getSystemBars(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0xEF22BA4C;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-systemBars>)184@7263L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-systemBars> (WindowInsets.android.kt:184)");
        }

        AndroidWindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getSystemBars();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final WindowInsets getSystemBarsIgnoringVisibility(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x5D41650E;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-systemBarsIgnoringVisibility>)268@10776L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-systemBarsIgnoringVisibility> (WindowInsets.android.kt:268)");
        }

        ValueInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getSystemBarsIgnoringVisibility();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static void getSystemBarsIgnoringVisibility$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final WindowInsets getSystemGestures(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x3AF63DE0;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-systemGestures>)188@7474L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-systemGestures> (WindowInsets.android.kt:188)");
        }

        AndroidWindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getSystemGestures();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final WindowInsets getTappableElement(Companion arg2, Composer arg3, int arg4) {
        int v0 = -1994205284;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-tappableElement>)192@7691L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-tappableElement> (WindowInsets.android.kt:192)");
        }

        AndroidWindowInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getTappableElement();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final WindowInsets getTappableElementIgnoringVisibility(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0xA742E4BC;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-tappableElementIgnoringVisibility>)279@11147L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-tappableElementIgnoringVisibility> (WindowInsets.android.kt:279)");
        }

        ValueInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getTappableElementIgnoringVisibility();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static void getTappableElementIgnoringVisibility$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final WindowInsets getWaterfall(Companion arg2, Composer arg3, int arg4) {
        int v0 = 1943241020;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-waterfall>)196@7908L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-waterfall> (WindowInsets.android.kt:196)");
        }

        ValueInsets v2 = WindowInsetsHolder.Companion.current(arg3, 6).getWaterfall();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((WindowInsets)v2);
    }

    public static final boolean isCaptionBarVisible(Companion arg2, Composer arg3, int arg4) {
        int v0 = -501076620;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-isCaptionBarVisible>)287@11471L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-isCaptionBarVisible> (WindowInsets.android.kt:287)");
        }

        boolean v2 = WindowInsetsHolder.Companion.current(arg3, 6).getCaptionBar().isVisible();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static void isCaptionBarVisible$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final boolean isImeVisible(Companion arg2, Composer arg3, int arg4) {
        int v0 = 0x905391A0;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-isImeVisible>)295@11770L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-isImeVisible> (WindowInsets.android.kt:295)");
        }

        boolean v2 = WindowInsetsHolder.Companion.current(arg3, 6).getIme().isVisible();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static void isImeVisible$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final boolean isTappableElementVisible(Companion arg2, Composer arg3, int arg4) {
        int v0 = -1737201120;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-isTappableElementVisible>)330@13006L9:WindowInsets.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.foundation.layout.<get-isTappableElementVisible> (WindowInsets.android.kt:330)");
        }

        boolean v2 = WindowInsetsHolder.Companion.current(arg3, 6).getTappableElement().isVisible();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public static void isTappableElementVisible$annotations(Companion arg0, Composer arg1, int arg2) {
    }

    public static final void setConsumeWindowInsets(AbstractComposeView arg1, boolean arg2) {
        arg1.setTag(id.consume_window_insets_tag, Boolean.valueOf(arg2));
    }

    public static final void setConsumeWindowInsets(ComposeView arg1, boolean arg2) {
        arg1.setTag(id.consume_window_insets_tag, Boolean.valueOf(arg2));
    }

    public static final InsetsValues toInsetsValues(Insets arg4) {
        return new InsetsValues(arg4.left, arg4.top, arg4.right, arg4.bottom);
    }
}

