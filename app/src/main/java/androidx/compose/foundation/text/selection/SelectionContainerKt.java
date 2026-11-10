package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A*\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001A \u0010\b\u001A\u00020\u00012\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\t\u001AJ\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0014\u0010\f\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u000F¨\u0006\u0010²\u0006\f\u0010\n\u001A\u0004\u0018\u00010\u000BX\u008A\u008E\u0002"}, d2={"SelectionContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DisableSelection", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionContainerKt {
    public static DisposableEffectResult $r8$lambda$2EIBWb8v88TrFksIy09IdJHYHI8(SelectionManager arg0, DisposableEffectScope arg1) {
        return SelectionContainerKt.SelectionContainer$lambda$10$0(arg0, arg1);
    }

    public static Offset $r8$lambda$AU720SDslMmBTUx4jCFR1TntiWo(SelectionManager arg0) {
        return SelectionContainerKt.SelectionContainer$lambda$9$0$0$0$0$1$0(arg0);
    }

    public static Unit $r8$lambda$Co9olC61YK1sJxj5r_ZWgxbnHB8(SelectionRegistrarImpl arg0, Function2 arg1, SelectionManager arg2, Composer arg3, int arg4) {
        return SelectionContainerKt.SelectionContainer$lambda$9$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static SelectionRegistrarImpl $r8$lambda$LHnVllxhuLdOG6mB7hEGfv47lXg() {
        return SelectionContainerKt.SelectionContainer$lambda$5$0();
    }

    public static Unit $r8$lambda$NmUDO3A_zr0NaqOrxDS3kLV2hec(MutableState arg0, Selection arg1) {
        return SelectionContainerKt.SelectionContainer$lambda$3$0(arg0, arg1);
    }

    public static Unit $r8$lambda$T0cVbDxf0gWx-wZhJp5MzrPfznI(Function2 arg0, SelectionManager arg1, Composer arg2, int arg3) {
        return SelectionContainerKt.SelectionContainer$lambda$9$0$0(arg0, arg1, arg2, arg3);
    }

    public static Offset $r8$lambda$U1IaQ6tSyriBo6mh0kWuUX557sY(SelectionManager arg0) {
        return SelectionContainerKt.SelectionContainer$lambda$9$0$0$0$0$1$1(arg0);
    }

    public static Unit $r8$lambda$syYRcAulwyDVp840vp4uR2xJiQ4(CoroutineScope arg0, Clipboard arg1, AnnotatedString arg2) {
        return SelectionContainerKt.SelectionContainer$lambda$7$0(arg0, arg1, arg2);
    }

    public static final void DisableSelection(Function2 arg4, Composer arg5, int arg6) {
        int v1;
        int v0 = 0xBAB396E3;
        arg5 = arg5.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(DisableSelection)N(content)74@3108L82:SelectionContainer.kt#eksfi3");
        int v2 = 2;
        if((arg6 & 6) == 0) {
            v1 = arg5.changedInstance(arg4) ? 4 : v2;
            v1 |= arg6;
        }
        else {
            v1 = arg6;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg5.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:73)");
            }

            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null), arg4, arg5, v1 << 3 & 0x70 | ProvidedValue.$stable);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_41;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_41:
        ScopeUpdateScope v5 = arg5.endRestartGroup();
        if(v5 != null) {
            v5.updateScope(new SelectionContainerKt$$ExternalSyntheticLambda0(arg4, arg6));
        }
    }

    static final Unit DisableSelection$lambda$0(Function2 arg0, int arg1, Composer arg2, int arg3) {
        SelectionContainerKt.DisableSelection(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public static final void SelectionContainer(Modifier arg17, Selection arg18, Function1 arg19, Function2 arg20, Composer arg21, int arg22, int arg23) {
        CoroutineScope v14_1;
        Modifier v6_2;
        int v9;
        Modifier v7;
        int v8;
        Selection v2 = arg18;
        Function1 v3 = arg19;
        Function2 v4 = arg20;
        int v5 = arg22;
        int v0 = 0xC9497470;
        Composer v1 = arg21.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(SelectionContainer)N(modifier,selection,onSelectionChange,children)95@3856L28,95@3801L83,97@3904L44,99@3985L7,100@4018L24,101@4092L7,103@4136L345,112@4525L7,122@4906L136,134@5420L2468,134@5363L2525,190@7920L106,190@7894L132:SelectionContainer.kt#eksfi3");
        int v6 = arg23 & 1;
        if(v6 != 0) {
            v8 = v5 | 6;
            v7 = arg17;
        }
        else if((v5 & 6) == 0) {
            v7 = arg17;
            v8 = v1.changed(v7) ? 4 : 2;
            v8 |= v5;
        }
        else {
            v7 = arg17;
            v8 = v5;
        }

        if((v5 & 0x30) == 0) {
            v9 = v1.changed(v2) ? 0x20 : 16;
            v8 |= v9;
        }

        if((v5 & 0x180) == 0) {
            v9 = v1.changedInstance(v3) ? 0x100 : 0x80;
            v8 |= v9;
        }

        if((v5 & 0xC00) == 0) {
            v9 = v1.changedInstance(v4) ? 0x800 : 0x400;
            v8 |= v9;
        }

        boolean v9_1 = (v8 & 0x493) != 1170 ? true : false;
        if(v1.shouldExecute(v9_1, v8 & 1)) {
            if(v6 != 0) {
                Companion v6_1 = Modifier.Companion;
            }
            else {
                v6_2 = v7;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v8, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:93)");
            }

            Object[] v0_1 = new Object[0];
            Saver v7_1 = SelectionRegistrarImpl.Companion.getSaver();
            String v9_2 = "CC(remember):SelectionContainer.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, -1665249940, v9_2);
            Object v8_1 = v1.rememberedValue();
            if(v8_1 == Composer.Companion.getEmpty()) {
                SelectionContainerKt$$ExternalSyntheticLambda4 v8_2 = new SelectionContainerKt$$ExternalSyntheticLambda4();
                v1.updateRememberedValue(v8_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            Object v0_2 = RememberSaveableKt.rememberSaveable(v0_1, v7_1, ((Function0)v8_1), v1, 0x180);
            ComposerKt.sourceInformationMarkerStart(v1, 0x9CBE537C, v9_2);
            Object v7_2 = v1.rememberedValue();
            if(v7_2 == Composer.Companion.getEmpty()) {
                SelectionManager v7_3 = new SelectionManager(((SelectionRegistrarImpl)v0_2));
                v1.updateRememberedValue(v7_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ProvidableCompositionLocal v8_3 = CompositionLocalsKt.getLocalClipboard();
            int v10 = 0x789C5F52;
            String v13 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, v10, v13);
            v8_1 = v1.consume(((CompositionLocal)v8_3));
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v1, 0x28C0FDC4, "CC(remember):Effects.kt#9igjgp");
            Object v14 = v1.rememberedValue();
            if(v14 == Composer.Companion.getEmpty()) {
                v14_1 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v1);
                v1.updateRememberedValue(v14_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ProvidableCompositionLocal v15 = CompositionLocalsKt.getLocalHapticFeedback();
            ComposerKt.sourceInformationMarkerStart(v1, v10, v13);
            Object v15_1 = v1.consume(((CompositionLocal)v15));
            ComposerKt.sourceInformationMarkerEnd(v1);
            ((SelectionManager)v7_2).setHapticFeedBack(((HapticFeedback)v15_1));
            ComposerKt.sourceInformationMarkerStart(v1, -1665240663, v9_2);
            int v15_2 = v1.changed(v14_1) | v1.changed(v8_1);
            Object v11 = v1.rememberedValue();
            LocaleList v12 = null;
            if(v15_2 != 0 || v11 == Composer.Companion.getEmpty()) {
                if(ClipboardUtils_androidKt.isWriteSupported(((Clipboard)v8_1))) {
                    SelectionContainerKt$$ExternalSyntheticLambda5 v11_1 = new SelectionContainerKt$$ExternalSyntheticLambda5(v14_1, ((Clipboard)v8_1));
                }
                else {
                    v11 = v12;
                }

                v1.updateRememberedValue(v11);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ((SelectionManager)v7_2).setOnCopyHandler(((Function1)v11));
            v8_3 = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(v1, v10, v13);
            v8_1 = v1.consume(((CompositionLocal)v8_3));
            ComposerKt.sourceInformationMarkerEnd(v1);
            ((SelectionManager)v7_2).setTextToolbar(((TextToolbar)v8_1));
            ((SelectionManager)v7_2).setOnSelectionChange(v3);
            ((SelectionManager)v7_2).setSelection(v2);
            v10 = 54;
            if(ComposeFoundationFlags.isSmartSelectionEnabled) {
                v1.startReplaceGroup(-82280708);
                ComposerKt.sourceInformation(v1, "118@4777L69");
                ((SelectionManager)v7_2).setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.StaticText, v12, v1, v10));
                ((SelectionManager)v7_2).setCoroutineScope$foundation(v14_1);
            }
            else {
                v1.startReplaceGroup(0xFAD0FAD2);
            }

            v1.endReplaceGroup();
            new SelectionContainerKt$$ExternalSyntheticLambda6(((SelectionManager)v7_2));
            ((SelectionManager)v7_2).isNonEmptySelection$foundation();
            ComposerKt.sourceInformationMarkerStart(v1, 0x47648F82, "CC(rememberClipboardEventsHandler)N(onPaste,onCopy,onCut,isEnabled):ClipboardEventsHandler.jvm.kt#423gt5");
            ComposerKt.sourceInformationMarkerEnd(v1);
            SimpleLayoutKt.SimpleLayout(v6_2.then(((SelectionManager)v7_2).getModifier()), ComposableLambdaKt.rememberComposableLambda(0x94BCD666, true, new SelectionContainerKt$$ExternalSyntheticLambda7(((SelectionManager)v7_2), ((SelectionRegistrarImpl)v0_2), v4), v1, v10), v1, 0x30, 0);
            ComposerKt.sourceInformationMarkerStart(v1, 0x9CC049BA, v9_2);
            boolean v0_3 = v1.changedInstance(v7_2);
            v8_1 = v1.rememberedValue();
            if((v0_3) || v8_1 == Composer.Companion.getEmpty()) {
                SelectionContainerKt$$ExternalSyntheticLambda8 v8_4 = new SelectionContainerKt$$ExternalSyntheticLambda8(((SelectionManager)v7_2));
                v1.updateRememberedValue(v8_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            EffectsKt.DisposableEffect(v7_2, ((Function1)v8_1), v1, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_203;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
            v6_2 = v7;
        }

    label_203:
        ScopeUpdateScope v7_4 = v1.endRestartGroup();
        if(v7_4 != null) {
            v7_4.updateScope(new SelectionContainerKt$$ExternalSyntheticLambda9(((Companion)v6_2), v2, v3, v4, v5, arg23));
        }
    }

    public static final void SelectionContainer(Modifier arg8, Function2 arg9, Composer arg10, int arg11, int arg12) {
        Function2 v4;
        SelectionContainerKt$$ExternalSyntheticLambda10 v0_3;
        MutableState v10_2;
        Companion v8;
        int v2;
        int v0 = 1949207773;
        Composer v5 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(SelectionContainer)N(modifier,content)57@2606L45,61@2764L18,58@2656L161:SelectionContainer.kt#eksfi3");
        int v10 = arg12 & 1;
        int v1 = 2;
        if(v10 != 0) {
            v2 = arg11 | 6;
        }
        else if((arg11 & 6) == 0) {
            v2 = v5.changed(arg8) ? 4 : v1;
            v2 |= arg11;
        }
        else {
            v2 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            int v3 = v5.changedInstance(arg9) ? 0x20 : 16;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 19) != 18 ? true : false;
        if(v5.shouldExecute(v3_1, v2 & 1)) {
            if(v10 != 0) {
                v8 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:56)");
            }

            String v0_1 = "CC(remember):SelectionContainer.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v5, 0x22BED78A, v0_1);
            Object v10_1 = v5.rememberedValue();
            if(v10_1 == Composer.Companion.getEmpty()) {
                v10_2 = SnapshotStateKt.mutableStateOf$default(null, null, v1, null);
                v5.updateRememberedValue(v10_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            v1 = v2;
            Selection v2_1 = SelectionContainerKt.SelectionContainer$lambda$1(v10_2);
            ComposerKt.sourceInformationMarkerStart(v5, 0x22BEEB2F, v0_1);
            Object v0_2 = v5.rememberedValue();
            if(v0_2 == Composer.Companion.getEmpty()) {
                v0_3 = new SelectionContainerKt$$ExternalSyntheticLambda10(v10_2);
                v5.updateRememberedValue(v0_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            int v6 = v1 & 14 | 0x180 | v1 << 6 & 0x1C00;
            Modifier v1_1 = ((Modifier)v8);
            v4 = arg9;
            SelectionContainerKt.SelectionContainer(v1_1, v2_1, v0_3, v4, v5, v6, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg8 = v1_1;
        }
        else {
            v4 = arg9;
            v5.skipToGroupEnd();
        }

        ScopeUpdateScope v9 = v5.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new SelectionContainerKt$$ExternalSyntheticLambda11(arg8, v4, arg11, arg12));
        }
    }

    private static final Selection SelectionContainer$lambda$1(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final DisposableEffectResult SelectionContainer$lambda$10$0(SelectionManager arg0, DisposableEffectScope arg1) {
        return new SelectionContainerKt$SelectionContainer$lambda$10$0$$inlined$onDispose$1(arg0);
    }

    static final Unit SelectionContainer$lambda$11(Modifier arg7, Selection arg8, Function1 arg9, Function2 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        SelectionContainerKt.SelectionContainer(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    private static final void SelectionContainer$lambda$2(MutableState arg0, Selection arg1) {
        arg0.setValue(arg1);
    }

    private static final Unit SelectionContainer$lambda$3$0(MutableState arg0, Selection arg1) {
        SelectionContainerKt.SelectionContainer$lambda$2(arg0, arg1);
        return Unit.INSTANCE;
    }

    static final Unit SelectionContainer$lambda$4(Modifier arg0, Function2 arg1, int arg2, int arg3, Composer arg4, int arg5) {
        SelectionContainerKt.SelectionContainer(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1), arg3);
        return Unit.INSTANCE;
    }

    private static final SelectionRegistrarImpl SelectionContainer$lambda$5$0() {
        return new SelectionRegistrarImpl();
    }

    private static final Unit SelectionContainer$lambda$7$0(CoroutineScope arg6, Clipboard arg7, AnnotatedString arg8) {
        BuildersKt.launch$default(arg6, null, CoroutineStart.UNDISPATCHED, new SelectionContainerKt$SelectionContainer$3$1$1(arg7, arg8, null), 1, null);
        return Unit.INSTANCE;
    }

    static final AnnotatedString SelectionContainer$lambda$8(SelectionManager arg0) {
        return arg0.getSelectedText$foundation();
    }

    static final Unit SelectionContainer$lambda$9(SelectionManager arg4, SelectionRegistrarImpl arg5, Function2 arg6, Composer arg7, int arg8) {
        ComposerKt.sourceInformation(arg7, "C135@5455L2427,135@5430L2452:SelectionContainer.kt#eksfi3");
        boolean v0 = (arg8 & 3) != 2 ? true : false;
        if(arg7.shouldExecute(v0, arg8 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x94BCD666, arg8, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:135)");
            }

            ContextMenu_androidKt.ContextMenuArea(arg4, ComposableLambdaKt.rememberComposableLambda(0xEF05E6F7, true, new SelectionContainerKt$$ExternalSyntheticLambda12(arg5, arg6, arg4), arg7, 54), arg7, 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_30;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_30:
        return Unit.INSTANCE;
    }

    private static final Unit SelectionContainer$lambda$9$0(SelectionRegistrarImpl arg4, Function2 arg5, SelectionManager arg6, Composer arg7, int arg8) {
        ComposerKt.sourceInformation(arg7, "C136@5542L2330,136@5469L2403:SelectionContainer.kt#eksfi3");
        boolean v0 = (arg8 & 3) != 2 ? true : false;
        if(arg7.shouldExecute(v0, arg8 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xEF05E6F7, arg8, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:136)");
            }

            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(arg4), ComposableLambdaKt.rememberComposableLambda(610483127, true, new SelectionContainerKt$$ExternalSyntheticLambda3(arg5, arg6), arg7, 54), arg7, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_33;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_33:
        return Unit.INSTANCE;
    }

    private static final Unit SelectionContainer$lambda$9$0$0(Function2 arg16, SelectionManager arg17, Composer arg18, int arg19) {
        SelectionContainerKt$$ExternalSyntheticLambda1 v5_2;
        SelectionContainerKt$$ExternalSyntheticLambda1 v1_4;
        SelectionManager v0 = arg17;
        Composer v9 = arg18;
        int v1 = arg19;
        ComposerKt.sourceInformation(v9, "C137@5560L10:SelectionContainer.kt#eksfi3");
        int v5 = 2;
        boolean v2 = (v1 & 3) != v5 ? true : false;
        if(v9.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(610483127, v1, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:137)");
            }

            arg16.invoke(v9, Integer.valueOf(0));
            if(!v0.isInTouchMode() || !v0.getHasFocus() || (v0.isTriviallyCollapsedSelection$foundation())) {
                v9.startReplaceGroup(2005806539);
            }
            else {
                v9.startReplaceGroup(-1736224054);
                String v1_1 = "";
                ComposerKt.sourceInformation(v9, v1_1);
                Selection v12 = v0.getSelection();
                if(v12 == null) {
                    v9.startReplaceGroup(0x77E70677);
                }
                else {
                    v9.startReplaceGroup(0x77E70678);
                    ComposerKt.sourceInformation(v9, v1_1);
                    v9.startReplaceGroup(0x988358C2);
                    ComposerKt.sourceInformation(v9, "*146@5961L137,151@6197L385,179@7634L127,172@7196L596");
                    Boolean[] v1_2 = new Boolean[v5];
                    v1_2[0] = Boolean.valueOf(true);
                    v1_2[1] = Boolean.valueOf(false);
                    List v13 = CollectionsKt.listOf(((Object[])v1_2));
                    int v14 = v13.size();
                    int v15;
                    for(v15 = 0; v15 < v14; ++v15) {
                        v2 = v13.get(v15).booleanValue();
                        String v3 = "CC(remember):SelectionContainer.kt#9igjgp";
                        ComposerKt.sourceInformationMarkerStart(v9, 0xE4453957, v3);
                        boolean v1_3 = v9.changed(v2);
                        Object v4 = v9.rememberedValue();
                        if((v1_3) || v4 == Composer.Companion.getEmpty()) {
                            TextDragObserver v4_1 = v0.handleDragObserver(v2);
                            v9.updateRememberedValue(v4_1);
                        }

                        ComposerKt.sourceInformationMarkerEnd(v9);
                        ComposerKt.sourceInformationMarkerStart(v9, 0xE44557CF, v3);
                        v1_3 = v9.changed(v2);
                        Object v5_1 = v9.rememberedValue();
                        if((v1_3) || v5_1 == Composer.Companion.getEmpty()) {
                            if(v2) {
                                v1_4 = new SelectionContainerKt$$ExternalSyntheticLambda1(v0);
                            }
                            else {
                                SelectionContainerKt$$ExternalSyntheticLambda2 v1_5 = new SelectionContainerKt$$ExternalSyntheticLambda2(v0);
                            }

                            v5_2 = v1_4;
                            v9.updateRememberedValue(v5_2);
                        }

                        ComposerKt.sourceInformationMarkerEnd(v9);
                        ResolvedTextDirection v1_6 = v2 ? v12.getStart().getDirection() : v12.getEnd().getDirection();
                        float v6 = v2 ? v0.getStartHandleLineHeight() : v0.getEndHandleLineHeight();
                        float v7 = v6;
                        SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 v6_1 = new SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(((Function0)v5_2));
                        boolean v5_3 = v12.getHandlesCrossed();
                        Companion v8 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart(v9, 0xE4460A6D, v3);
                        boolean v3_1 = v9.changedInstance(v4);
                        Object v10 = v9.rememberedValue();
                        if((v3_1) || v10 == Composer.Companion.getEmpty()) {
                            SelectionContainerKt$SelectionContainer$5$1$1$1$1$1$1 v10_1 = new SelectionContainerKt$SelectionContainer$5$1$1$1$1$1$1(((TextDragObserver)v4));
                            v9.updateRememberedValue(v10_1);
                        }

                        ComposerKt.sourceInformationMarkerEnd(v9);
                        AndroidSelectionHandles_androidKt.SelectionHandle-wLIcFTc(v6_1, v2, v1_6, v5_3, 0, v7, SuspendingPointerInputFilterKt.pointerInput(((Modifier)v8), v4, ((PointerInputEventHandler)v10)), v9, 0, 16);
                    }

                    v9.endReplaceGroup();
                }

                v9.endReplaceGroup();
            }

            v9.endReplaceGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_137;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v9.skipToGroupEnd();
        }

    label_137:
        return Unit.INSTANCE;
    }

    private static final Offset SelectionContainer$lambda$9$0$0$0$0$1$0(SelectionManager arg2) {
        Offset v2 = arg2.getStartHandlePosition-_m7T9-E();
        long v0 = v2 != null ? v2.unbox-impl() : Offset.Companion.getUnspecified-F1C5BW0();
        return Offset.box-impl(v0);
    }

    private static final Offset SelectionContainer$lambda$9$0$0$0$0$1$1(SelectionManager arg2) {
        Offset v2 = arg2.getEndHandlePosition-_m7T9-E();
        long v0 = v2 != null ? v2.unbox-impl() : Offset.Companion.getUnspecified-F1C5BW0();
        return Offset.box-impl(v0);
    }
}

