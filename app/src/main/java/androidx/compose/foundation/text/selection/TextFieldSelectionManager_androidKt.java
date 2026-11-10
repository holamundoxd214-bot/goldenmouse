package androidx.compose.foundation.text.selection;

import android.content.Context;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.foundation.internal.ClipboardUtils;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifier_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A\u001C\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0000\u001A\u0012\u0010\u0007\u001A\u00020\b*\u00020\u0003H\u0080@¢\u0006\u0002\u0010\t\u001A\u0014\u0010\n\u001A\u00020\b*\u00020\u00032\u0006\u0010\u000B\u001A\u00020\bH\u0000¨\u0006\f²\u0006\n\u0010\r\u001A\u00020\u000EX\u008A\u008E\u0002"}, d2={"textFieldMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "addBasicTextFieldTextContextMenuComponents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "hasAvailableTextToPaste", "", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSelectionHandleInVisibleBound", "isStartHandle", "foundation", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldSelectionManager_androidKt {
    public static Unit $r8$lambda$4zMkYZkzJ3JUI3nG7OUxsOrPwgw(Function0 arg0, Function0 arg1, TextContextMenuSession arg2) {
        return TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$B5fjhVanZ-pzUqFRYI2LUFYsfhQ(TextFieldSelectionManager arg0) {
        return TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$3$0$2(arg0);
    }

    public static Offset $r8$lambda$JpY2BEdbaYXXBlfmIIL3PhNMq2k(Function0 arg0, Density arg1) {
        return TextFieldSelectionManager_androidKt.textFieldMagnifier$lambda$0$4$0$0(arg0, arg1);
    }

    public static Unit $r8$lambda$O3gpt9U0UUPSLBiYKD4JSGqgvbU(TextFieldSelectionManager arg0) {
        return TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$3$0$1(arg0);
    }

    public static Unit $r8$lambda$Pl73b0Aa9OwO3CbZLOenA9hM92w(Density arg0, MutableState arg1, DpSize arg2) {
        return TextFieldSelectionManager_androidKt.textFieldMagnifier$lambda$0$4$0$1(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$gCl98yKeJHmQGrt_JNRFlbG_UYg(CoroutineScope arg0, Function1 arg1) {
        return TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem$1(arg0, arg1);
    }

    public static boolean $r8$lambda$iWAPEYVpjDgvImG1NlfXwlLzccY(TextFieldSelectionManager arg0) {
        return TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$3$0$0(arg0);
    }

    public static Unit $r8$lambda$odeuMv56G2j37D6NWQQDhNLJ6OY(TextFieldSelectionManager arg0, CoroutineScope arg1, Context arg2, TextContextMenuBuilderScope arg3) {
        return TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$3(arg0, arg1, arg2, arg3);
    }

    public static Modifier $r8$lambda$p0awMpkbwJLkzwaWkz6O-PU9k3A(Density arg0, MutableState arg1, Function0 arg2) {
        return TextFieldSelectionManager_androidKt.textFieldMagnifier$lambda$0$4$0(arg0, arg1, arg2);
    }

    public static Offset $r8$lambda$yf4gFANTn-ZHjH9FYaSwy7vKDbY(TextFieldSelectionManager arg0, MutableState arg1) {
        return TextFieldSelectionManager_androidKt.textFieldMagnifier$lambda$0$3$0(arg0, arg1);
    }

    public static final Modifier addBasicTextFieldTextContextMenuComponents(Modifier arg1, TextFieldSelectionManager arg2, CoroutineScope arg3) {
        return TextContextMenuModifier_androidKt.addTextContextMenuComponentsWithContext(arg1, new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda1(arg2, arg3));
    }

    static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0(TextFieldSelectionManager arg7, CoroutineScope arg8, TextContextMenuBuilderScope arg9, Context arg10) {
        boolean v2 = arg7.getEditable();
        AnnotatedString v0 = arg7.getTransformedText$foundation();
        TextRange v1 = null;
        String v0_1 = v0 != null ? v0.getText() : ((String)v1);
        String v3 = v0_1;
        TextRange v0_2 = arg7.getLatestSelection-MzsxiRA$foundation();
        if(v0_2 != null) {
            long v0_3 = v0_2.unbox-impl();
            OffsetMapping v4 = arg7.getOffsetMapping$foundation();
            v1 = TextRange.box-impl(TextRangeKt.TextRange(v4.originalToTransformed(TextRange.getStart-impl(v0_3)), v4.originalToTransformed(TextRange.getEnd-impl(v0_3))));
        }

        PlatformSelectionBehaviors_androidKt.addPlatformTextContextMenuItems-71BSaZU(arg9, arg10, v2, ((CharSequence)v3), v1, arg7.getPlatformSelectionBehaviors$foundation(), new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda5(arg7, arg8, arg10));
        return Unit.INSTANCE;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$3(TextFieldSelectionManager arg16, CoroutineScope arg17, Context arg18, TextContextMenuBuilderScope arg19) {
        arg19.separator();
        TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem(arg19, arg17, arg18, TextContextMenuItems.Cut, arg16.canShowCutMenuItem$foundation(), new TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$2$1$1(arg16, null));
        TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem(arg19, arg17, arg18, TextContextMenuItems.Copy, arg16.canShowCopyMenuItem$foundation(), new TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$2$1$2(arg16, null));
        TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem(arg19, arg17, arg18, TextContextMenuItems.Paste, arg16.canShowPasteMenuItem$foundation(), new TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$2$1$3(arg16, null));
        TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem(arg19, arg18, TextContextMenuItems.SelectAll, arg16.canShowSelectAllMenuItem$foundation(), new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda0(arg16), new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda3(arg16));
        TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$default(arg19, arg18, TextContextMenuItems.Autofill, arg16.canShowAutofillMenuItem$foundation(), null, new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4(arg16), 8, null);
        arg19.separator();
        return Unit.INSTANCE;
    }

    private static final boolean addBasicTextFieldTextContextMenuComponents$lambda$0$3$0$0(TextFieldSelectionManager arg0) {
        return arg0.getTextToolbarShown$foundation() ^ 1;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$3$0$1(TextFieldSelectionManager arg0) {
        arg0.selectAll$foundation();
        return Unit.INSTANCE;
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$3$0$2(TextFieldSelectionManager arg0) {
        arg0.autofill$foundation();
        return Unit.INSTANCE;
    }

    private static final void addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem(TextContextMenuBuilderScope arg1, Context arg2, TextContextMenuItems arg3, boolean arg4, Function0 arg5, Function0 arg6) {
        ContextMenu_androidKt.textItem(arg1, arg2.getResources(), arg3, arg4, new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda8(arg6, arg5));
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$0(Function0 arg0, Function0 arg1, TextContextMenuSession arg2) {
        arg0.invoke();
        boolean v0 = arg1 != null ? arg1.invoke().booleanValue() : true;
        if(v0) {
            arg2.close();
        }

        return Unit.INSTANCE;
    }

    static void addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$default(TextContextMenuBuilderScope arg6, Context arg7, TextContextMenuItems arg8, boolean arg9, Function0 arg10, Function0 arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem(arg6, arg7, arg8, arg9, arg10, arg11);
    }

    private static final void addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem(TextContextMenuBuilderScope arg8, CoroutineScope arg9, Context arg10, TextContextMenuItems arg11, boolean arg12, Function1 arg13) {
        TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldItem$default(arg8, arg10, arg11, arg12, null, new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda2(arg9, arg13), 8, null);
    }

    private static final Unit addBasicTextFieldTextContextMenuComponents$lambda$0$textFieldSuspendItem$1(CoroutineScope arg6, Function1 arg7) {
        BuildersKt.launch$default(arg6, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$textFieldSuspendItem$1$1(arg7, null), 1, null);
        return Unit.INSTANCE;
    }

    public static final Object hasAvailableTextToPaste(TextFieldSelectionManager arg0, Continuation arg1) {
        Clipboard v0 = arg0.getClipboard$foundation();
        boolean v0_1 = v0 != null ? ClipboardUtils.hasText(v0) : false;
        return Boxing.boxBoolean(v0_1);
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager arg0, boolean arg1) {
        return TextFieldSelectionManagerKt.isSelectionHandleInVisibleBoundDefault(arg0, arg1);
    }

    public static final Modifier textFieldMagnifier(Modifier arg3, TextFieldSelectionManager arg4) {
        Object v2 = null;
        if(!Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, v2)) {
            return arg3;
        }

        return ComposedModifierKt.composed$default(arg3, ((Function1)v2), new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda9(arg4), 1, v2);
    }

    static final Modifier textFieldMagnifier$lambda$0(TextFieldSelectionManager arg4, Modifier arg5, Composer arg6, int arg7) {
        TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda7 v1_2;
        TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda6 v3_1;
        MutableState v0_2;
        int v0 = 1980580247;
        arg6.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg6, "C54@2523L7,55@2560L41,57@2668L68,58@2770L540:TextFieldSelectionManager.android.kt#eksfi3");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg7, -1, "androidx.compose.foundation.text.selection.textFieldMagnifier.<anonymous> (TextFieldSelectionManager.android.kt:54)");
        }

        ProvidableCompositionLocal v7 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v7_1 = arg6.consume(((CompositionLocal)v7));
        ComposerKt.sourceInformationMarkerEnd(arg6);
        String v1 = "CC(remember):TextFieldSelectionManager.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg6, 0x27C34140, v1);
        Object v0_1 = arg6.rememberedValue();
        if(v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), null, 2, null);
            arg6.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        ComposerKt.sourceInformationMarkerStart(arg6, 0x27C34EDB, v1);
        boolean v2 = arg6.changedInstance(arg4);
        Object v3 = arg6.rememberedValue();
        if((v2) || v3 == Composer.Companion.getEmpty()) {
            v3_1 = new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda6(arg4, v0_2);
            arg6.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        ComposerKt.sourceInformationMarkerStart(arg6, 0x27C35D73, v1);
        boolean v4 = arg6.changed(v7_1);
        Object v1_1 = arg6.rememberedValue();
        if((v4) || v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda7(((Density)v7_1), v0_2);
            arg6.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        Modifier v4_1 = SelectionMagnifierKt.animatedSelectionMagnifier(arg5, ((Function0)v3_1), ((Function1)v1_2));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg6.endReplaceGroup();
        return v4_1;
    }

    private static final long textFieldMagnifier$lambda$0$1(MutableState arg2) {
        return ((State)arg2).getValue().unbox-impl();
    }

    private static final void textFieldMagnifier$lambda$0$2(MutableState arg0, long arg1) {
        arg0.setValue(IntSize.box-impl(arg1));
    }

    private static final Offset textFieldMagnifier$lambda$0$3$0(TextFieldSelectionManager arg2, MutableState arg3) {
        return Offset.box-impl(TextFieldSelectionManagerKt.calculateSelectionMagnifierCenterAndroid-O0kMr_c(arg2, TextFieldSelectionManager_androidKt.textFieldMagnifier$lambda$0$1(arg3)));
    }

    private static final Modifier textFieldMagnifier$lambda$0$4$0(Density arg15, MutableState arg16, Function0 arg17) {
        return Magnifier_androidKt.magnifier-jPUL71Q$default(Modifier.Companion, new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda10(arg17), null, new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda11(arg15, arg16), 0f, true, 0, 0f, 0f, false, PlatformMagnifierFactory.Companion.getForCurrentPlatform(), 490, null);
    }

    private static final Offset textFieldMagnifier$lambda$0$4$0$0(Function0 arg0, Density arg1) {
        return arg0.invoke();
    }

    private static final Unit textFieldMagnifier$lambda$0$4$0$1(Density arg6, MutableState arg7, DpSize arg8) {
        TextFieldSelectionManager_androidKt.textFieldMagnifier$lambda$0$2(arg7, IntSize.constructor-impl((((long)arg6.roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(arg8.unbox-impl())))) << 0x20 | (((long)arg6.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(arg8.unbox-impl())))) & 0xFFFFFFFFL));
        return Unit.INSTANCE;
    }
}

