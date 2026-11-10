package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AA\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u000B\u001AK\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000E\u001AS\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0011\u001A{\u0010\u0012\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001A\u00020\u00032\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u0017\u001A\u0085\u0001\u0010\u0012\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001A\u00020\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u0018\u001Aq\u0010\u0012\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u0019\u001A\u008D\u0001\u0010\u0012\u001A\u00020\u0001*\u00020\u00012\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001A\u00020\u00032\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u001A\u001A\u0085\u0001\u0010\u0012\u001A\u00020\u0001*\u00020\u00012\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u001B\u001AA\u0010\u001C\u001A\u00020\u0001*\u00020\u00012\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u001E\b\u0004\u0010\u001D\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u001F\u0012\u0004\u0012\u00020\u00010\u001EH\u0080\b\u001A\f\u0010(\u001A\u00020\u0003*\u00020)H\u0000\u001A\u0010\u0010*\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0010H\u0002\u001A\f\u0010+\u001A\u00020\u0003*\u00020,H\u0002\u001A\f\u0010-\u001A\u00020\u0003*\u00020,H\u0002\u001A\f\u0010.\u001A\u00020\u0003*\u00020,H\u0002\"\u0018\u0010 \u001A\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#\"\u0018\u0010$\u001A\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b%\u0010#\"\u0018\u0010&\u001A\u00020\u0003*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010#¨\u0006/"}, d2={"clickable", "Landroidx/compose/ui/Modifier;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "clickable-XHw0xAI", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "clickable-oSLSa3U", "indication", "Landroidx/compose/foundation/Indication;", "clickable-O2vRcR0", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "hapticFeedbackEnabled", "combinedClickable-f5TDLPQ", "combinedClickable-hoGz1lA", "combinedClickable-cJG_KMw", "combinedClickable-auXiCPI", "combinedClickable-XVZzFYc", "clickableWithIndicationIfNeeded", "createClickable", "Lkotlin/Function2;", "Landroidx/compose/foundation/IndicationNodeFactory;", "isPress", "Landroidx/compose/ui/input/key/KeyEvent;", "isPress-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isClick", "isClick-ZmokQxo", "isEnter", "isEnter-ZmokQxo", "hasScrollableContainer", "Landroidx/compose/ui/node/TraversableNode;", "unsupportedIndicationExceptionMessage", "changedToUp", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "changedToDownIgnoreConsumed", "isMovingIgnoreConsumed", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ClickableKt {
    public static final boolean access$changedToDownIgnoreConsumed(IndirectPointerInputChange arg0) {
        return ClickableKt.changedToDownIgnoreConsumed(arg0);
    }

    public static final boolean access$changedToUp(IndirectPointerInputChange arg0) {
        return ClickableKt.changedToUp(arg0);
    }

    public static final boolean access$isClick-ZmokQxo(KeyEvent arg0) {
        return ClickableKt.isClick-ZmokQxo(arg0);
    }

    public static final boolean access$isMovingIgnoreConsumed(IndirectPointerInputChange arg0) {
        return ClickableKt.isMovingIgnoreConsumed(arg0);
    }

    public static final boolean access$isPress-ZmokQxo(KeyEvent arg0) {
        return ClickableKt.isPress-ZmokQxo(arg0);
    }

    public static final String access$unsupportedIndicationExceptionMessage(Indication arg0) {
        return ClickableKt.unsupportedIndicationExceptionMessage(arg0);
    }

    private static final boolean changedToDownIgnoreConsumed(IndirectPointerInputChange arg1) {
        if(!arg1.getPreviousPressed() && (arg1.getPressed())) {
            return 1;
        }

        return 0;
    }

    private static final boolean changedToUp(IndirectPointerInputChange arg1) {
        if(!arg1.isConsumed() && (arg1.getPreviousPressed()) && !arg1.getPressed()) {
            return 1;
        }

        return 0;
    }

    public static final Modifier clickable-O2vRcR0(Modifier arg11, MutableInteractionSource arg12, Indication arg13, boolean arg14, String arg15, Role arg16, Function0 arg17) {
        Modifier v1_1;
        ClickableElement v1;
        if((arg13 instanceof IndicationNodeFactory)) {
            v1 = new ClickableElement(arg12, arg13, false, arg14, arg15, arg16, arg17, null);
        }
        else if(arg13 == null) {
            v1 = new ClickableElement(arg12, null, false, arg14, arg15, arg16, arg17, null);
        }
        else if(arg12 != null) {
            v1_1 = IndicationKt.indication(Modifier.Companion, arg12, arg13).then(new ClickableElement(arg12, null, false, arg14, arg15, arg16, arg17, null));
        }
        else {
            v1_1 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ClickableKt$clickable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(arg13, arg14, arg15, arg16, arg17), 1, null);
        }

        return arg11.then(v1_1);
    }

    public static Modifier clickable-O2vRcR0$default(Modifier arg7, MutableInteractionSource arg8, Indication arg9, boolean arg10, String arg11, Role arg12, Function0 arg13, int arg14, Object arg15) {
        String v15 = null;
        String v4 = (arg14 & 8) != 0 ? v15 : arg11;
        Role v5 = (arg14 & 16) != 0 ? ((Role)v15) : arg12;
        return ClickableKt.clickable-O2vRcR0(arg7, arg8, arg9, true, v4, v5, arg13);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed") public static final Modifier clickable-XHw0xAI(Modifier arg2, boolean arg3, String arg4, Role arg5, Function0 arg6) {
        ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1(arg3, arg4, arg5, arg6);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, ((Function1)v0), new ClickableKt$$ExternalSyntheticLambda3(arg3, arg4, arg5, arg6));
    }

    public static Modifier clickable-XHw0xAI$default(Modifier arg1, boolean arg2, String arg3, Role arg4, Function0 arg5, int arg6, Object arg7) {
        String v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = ((Role)v0);
        }

        return ClickableKt.clickable-XHw0xAI(arg1, true, arg3, arg4, arg5);
    }

    public static final Modifier clickable-oSLSa3U(Modifier arg9, boolean arg10, String arg11, Role arg12, MutableInteractionSource arg13, Function0 arg14) {
        return arg9.then(new ClickableElement(arg13, null, true, arg10, arg11, arg12, arg14, null));
    }

    public static Modifier clickable-oSLSa3U$default(Modifier arg1, boolean arg2, String arg3, Role arg4, MutableInteractionSource arg5, Function0 arg6, int arg7, Object arg8) {
        Role v6;
        Modifier v3;
        Function0 v8;
        String v5;
        MutableInteractionSource v7;
        String v0 = null;
        if((arg7 & 2) != 0) {
            arg3 = v0;
        }

        if((arg7 & 4) != 0) {
            arg4 = ((Role)v0);
        }

        if((arg7 & 8) != 0) {
            v7 = ((MutableInteractionSource)v0);
            v5 = arg3;
            v8 = arg6;
            v3 = arg1;
            v6 = arg4;
        }
        else {
            v7 = arg5;
            v8 = arg6;
            v5 = arg3;
            v6 = arg4;
            v3 = arg1;
        }

        return ClickableKt.clickable-oSLSa3U(v3, true, v5, v6, v7, v8);
    }

    public static final Modifier clickableWithIndicationIfNeeded(Modifier arg3, MutableInteractionSource arg4, Indication arg5, Function2 arg6) {
        Modifier v4_1;
        Object v4;
        if((arg5 instanceof IndicationNodeFactory)) {
            v4 = arg6.invoke(arg4, arg5);
        }
        else {
            Object v0 = null;
            if(arg5 == null) {
                v4 = arg6.invoke(arg4, v0);
            }
            else if(arg4 != null) {
                v4_1 = IndicationKt.indication(Modifier.Companion, arg4, arg5).then(arg6.invoke(arg4, v0));
            }
            else {
                v4_1 = ComposedModifierKt.composed$default(Modifier.Companion, ((Function1)v0), new ClickableKt$clickableWithIndicationIfNeeded$1(arg5, arg6), 1, v0);
            }
        }

        return arg3.then(((Modifier)v4));
    }

    static final Modifier clickable_XHw0xAI$lambda$1(boolean arg7, String arg8, Role arg9, Function0 arg10, Modifier arg11, Composer arg12, int arg13) {
        int v11 = 0xD2EF1E09;
        arg12.startReplaceGroup(v11);
        ComposerKt.sourceInformation(arg12, "C141@6694L7:Clickable.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v11, arg13, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:141)");
        }

        ProvidableCompositionLocal v11_1 = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v11_2 = arg12.consume(((CompositionLocal)v11_1));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        Object v2 = v11_2;
        if((v2 instanceof IndicationNodeFactory)) {
            arg12.startReplaceGroup(0xA05A7DFE);
            arg12.endReplaceGroup();
            v11_2 = null;
        }
        else {
            arg12.startReplaceGroup(0xA05C8408);
            ComposerKt.sourceInformation(arg12, "150@7141L39");
            ComposerKt.sourceInformationMarkerStart(arg12, 0xD39FFDD0, "CC(remember):Clickable.kt#9igjgp");
            v11_2 = arg12.rememberedValue();
            if(v11_2 == Composer.Companion.getEmpty()) {
                MutableInteractionSource v11_3 = InteractionSourceKt.MutableInteractionSource();
                arg12.updateRememberedValue(v11_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            arg12.endReplaceGroup();
        }

        Object v1 = v11_2;
        Modifier v7 = ClickableKt.clickable-O2vRcR0(Modifier.Companion, ((MutableInteractionSource)v1), ((Indication)v2), arg7, arg8, arg9, arg10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg12.endReplaceGroup();
        return v7;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final Modifier combinedClickable-XVZzFYc(Modifier arg15, MutableInteractionSource arg16, Indication arg17, boolean arg18, String arg19, Role arg20, String arg21, Function0 arg22, Function0 arg23, Function0 arg24) {
        Modifier v1_2;
        CombinedClickableElement v1_1;
        Indication v1 = arg17;
        if((v1 instanceof IndicationNodeFactory)) {
            v1_1 = new CombinedClickableElement(arg16, v1, false, arg18, arg19, arg20, arg24, arg21, arg22, arg23, true, null);
        }
        else if(v1 == null) {
            v1_1 = new CombinedClickableElement(arg16, null, false, arg18, arg19, arg20, arg24, arg21, arg22, arg23, true, null);
        }
        else if(arg16 != null) {
            v1_2 = IndicationKt.indication(Modifier.Companion, arg16, v1).then(new CombinedClickableElement(arg16, null, false, arg18, arg19, arg20, arg24, arg21, arg22, arg23, true, null));
        }
        else {
            v1_2 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ClickableKt$combinedClickable-XVZzFYc$$inlined$clickableWithIndicationIfNeeded$1(v1, arg18, arg19, arg20, arg24, arg21, arg22, arg23), 1, null);
        }

        return arg15.then(v1_2);
    }

    public static Modifier combinedClickable-XVZzFYc$default(Modifier arg10, MutableInteractionSource arg11, Indication arg12, boolean arg13, String arg14, Role arg15, String arg16, Function0 arg17, Function0 arg18, Function0 arg19, int arg20, Object arg21) {
        MutableInteractionSource v1_1;
        Function0 v9;
        Indication v2;
        Modifier v0_1;
        Function0 v8;
        int v0 = arg20;
        String v1 = null;
        String v4 = (v0 & 8) != 0 ? v1 : arg14;
        Role v5 = (v0 & 16) != 0 ? ((Role)v1) : arg15;
        String v6 = (v0 & 0x20) != 0 ? v1 : arg16;
        Function0 v7 = (v0 & 0x40) != 0 ? ((Function0)v1) : arg17;
        if((v0 & 0x80) != 0) {
            v8 = ((Function0)v1);
            v0_1 = arg10;
            v2 = arg12;
            v9 = arg19;
            v1_1 = arg11;
        }
        else {
            v8 = arg18;
            v0_1 = arg10;
            v1_1 = arg11;
            v2 = arg12;
            v9 = arg19;
        }

        return ClickableKt.combinedClickable-XVZzFYc(v0_1, v1_1, v2, true, v4, v5, v6, v7, v8, v9);
    }

    public static final Modifier combinedClickable-auXiCPI(Modifier arg15, MutableInteractionSource arg16, Indication arg17, boolean arg18, String arg19, Role arg20, String arg21, Function0 arg22, Function0 arg23, boolean arg24, Function0 arg25) {
        Modifier v1_2;
        CombinedClickableElement v1_1;
        Indication v1 = arg17;
        if((v1 instanceof IndicationNodeFactory)) {
            v1_1 = new CombinedClickableElement(arg16, v1, false, arg18, arg19, arg20, arg25, arg21, arg22, arg23, arg24, null);
        }
        else if(v1 == null) {
            v1_1 = new CombinedClickableElement(arg16, null, false, arg18, arg19, arg20, arg25, arg21, arg22, arg23, arg24, null);
        }
        else if(arg16 != null) {
            v1_2 = IndicationKt.indication(Modifier.Companion, arg16, v1).then(new CombinedClickableElement(arg16, null, false, arg18, arg19, arg20, arg25, arg21, arg22, arg23, arg24, null));
        }
        else {
            v1_2 = ComposedModifierKt.composed$default(Modifier.Companion, null, new ClickableKt$combinedClickable-auXiCPI$$inlined$clickableWithIndicationIfNeeded$1(v1, arg18, arg19, arg20, arg25, arg21, arg22, arg23, arg24), 1, null);
        }

        return arg15.then(((Modifier)v1_1));
    }

    public static Modifier combinedClickable-auXiCPI$default(Modifier arg2, MutableInteractionSource arg3, Indication arg4, boolean arg5, String arg6, Role arg7, String arg8, Function0 arg9, Function0 arg10, boolean arg11, Function0 arg12, int arg13, Object arg14) {
        String v1 = null;
        if((arg13 & 8) != 0) {
            arg6 = v1;
        }

        if((arg13 & 16) != 0) {
            arg7 = ((Role)v1);
        }

        if((arg13 & 0x20) != 0) {
            arg8 = v1;
        }

        if((arg13 & 0x40) != 0) {
            arg9 = ((Function0)v1);
        }

        if((arg13 & 0x80) != 0) {
            arg10 = ((Function0)v1);
        }

        return ClickableKt.combinedClickable-auXiCPI(arg2, arg3, arg4, true, arg6, arg7, arg8, arg9, arg10, true, arg12);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final Modifier combinedClickable-cJG_KMw(Modifier arg10, boolean arg11, String arg12, Role arg13, String arg14, Function0 arg15, Function0 arg16, Function0 arg17) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1 v1 = new ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1(arg11, arg12, arg13, arg17, arg16, arg15, arg14);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg10, v1_1, new ClickableKt$$ExternalSyntheticLambda1(arg11, arg12, arg13, arg14, arg15, arg16, arg17));
    }

    public static Modifier combinedClickable-cJG_KMw$default(Modifier arg1, boolean arg2, String arg3, Role arg4, String arg5, Function0 arg6, Function0 arg7, Function0 arg8, int arg9, Object arg10) {
        Role v6;
        Modifier v3;
        Function0 v10;
        String v7;
        Function0 v9;
        String v0 = null;
        if((arg9 & 2) != 0) {
            arg3 = v0;
        }

        if((arg9 & 4) != 0) {
            arg4 = ((Role)v0);
        }

        if((arg9 & 8) != 0) {
            arg5 = v0;
        }

        if((arg9 & 16) != 0) {
            arg6 = ((Function0)v0);
        }

        if((arg9 & 0x20) != 0) {
            v9 = ((Function0)v0);
            v7 = arg5;
            v10 = arg8;
            arg5 = arg3;
            arg8 = arg6;
            v3 = arg1;
            v6 = arg4;
        }
        else {
            v9 = arg7;
            v10 = arg8;
            v7 = arg5;
            arg8 = arg6;
            arg5 = arg3;
            v6 = arg4;
            v3 = arg1;
        }

        return ClickableKt.combinedClickable-cJG_KMw(v3, true, arg5, v6, v7, arg8, v9, v10);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced with new overload that only supports IndicationNodeFactory instances inside LocalIndication, and does not use composed") public static final Modifier combinedClickable-f5TDLPQ(Modifier arg11, boolean arg12, String arg13, Role arg14, String arg15, Function0 arg16, Function0 arg17, boolean arg18, Function0 arg19) {
        ClickableKt$combinedClickable-f5TDLPQ$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new ClickableKt$combinedClickable-f5TDLPQ$$inlined$debugInspectorInfo$1(arg12, arg13, arg14, arg19, arg17, arg16, arg15, arg18);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg11, ((Function1)v1), new ClickableKt$$ExternalSyntheticLambda0(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19));
    }

    public static Modifier combinedClickable-f5TDLPQ$default(Modifier arg2, boolean arg3, String arg4, Role arg5, String arg6, Function0 arg7, Function0 arg8, boolean arg9, Function0 arg10, int arg11, Object arg12) {
        String v1 = null;
        if((arg11 & 2) != 0) {
            arg4 = v1;
        }

        if((arg11 & 4) != 0) {
            arg5 = ((Role)v1);
        }

        if((arg11 & 8) != 0) {
            arg6 = v1;
        }

        if((arg11 & 16) != 0) {
            arg7 = ((Function0)v1);
        }

        if((arg11 & 0x20) != 0) {
            arg8 = ((Function0)v1);
        }

        return ClickableKt.combinedClickable-f5TDLPQ(arg2, true, arg4, arg5, arg6, arg7, arg8, true, arg10);
    }

    public static final Modifier combinedClickable-hoGz1lA(Modifier arg13, boolean arg14, String arg15, Role arg16, String arg17, Function0 arg18, Function0 arg19, boolean arg20, MutableInteractionSource arg21, Function0 arg22) {
        return arg13.then(new CombinedClickableElement(arg21, null, true, arg14, arg15, arg16, arg22, arg17, arg18, arg19, arg20, null));
    }

    public static Modifier combinedClickable-hoGz1lA$default(Modifier arg2, boolean arg3, String arg4, Role arg5, String arg6, Function0 arg7, Function0 arg8, boolean arg9, MutableInteractionSource arg10, Function0 arg11, int arg12, Object arg13) {
        String v1 = null;
        if((arg12 & 2) != 0) {
            arg4 = v1;
        }

        if((arg12 & 4) != 0) {
            arg5 = ((Role)v1);
        }

        if((arg12 & 8) != 0) {
            arg6 = v1;
        }

        if((arg12 & 16) != 0) {
            arg7 = ((Function0)v1);
        }

        if((arg12 & 0x20) != 0) {
            arg8 = ((Function0)v1);
        }

        if((arg12 & 0x80) != 0) {
            arg10 = ((MutableInteractionSource)v1);
        }

        return ClickableKt.combinedClickable-hoGz1lA(arg2, true, arg4, arg5, arg6, arg7, arg8, true, arg10, arg11);
    }

    static final Modifier combinedClickable_cJG_KMw$lambda$1(boolean arg13, String arg14, Role arg15, String arg16, Function0 arg17, Function0 arg18, Function0 arg19, Modifier arg20, Composer arg21, int arg22) {
        Composer v0 = arg21;
        int v1 = 0x755F393B;
        v0.startReplaceGroup(v1);
        ComposerKt.sourceInformation(v0, "C471@22649L7:Clickable.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg22, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:471)");
        }

        ProvidableCompositionLocal v1_1 = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_2 = v0.consume(((CompositionLocal)v1_1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        Object v4 = v1_2;
        if((v4 instanceof IndicationNodeFactory)) {
            v0.startReplaceGroup(-1270399604);
            v0.endReplaceGroup();
            v1_2 = null;
        }
        else {
            v0.startReplaceGroup(-1270266986);
            ComposerKt.sourceInformation(v0, "480@23096L39");
            ComposerKt.sourceInformationMarkerStart(v0, -1703537534, "CC(remember):Clickable.kt#9igjgp");
            v1_2 = v0.rememberedValue();
            if(v1_2 == Composer.Companion.getEmpty()) {
                MutableInteractionSource v1_3 = InteractionSourceKt.MutableInteractionSource();
                v0.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v0);
            v0.endReplaceGroup();
        }

        Object v3 = v1_2;
        Modifier v13 = ClickableKt.combinedClickable-auXiCPI(Modifier.Companion, ((MutableInteractionSource)v3), ((Indication)v4), arg13, arg14, arg15, arg16, arg17, arg18, true, arg19);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v0.endReplaceGroup();
        return v13;
    }

    static final Modifier combinedClickable_f5TDLPQ$lambda$1(boolean arg13, String arg14, Role arg15, String arg16, Function0 arg17, Function0 arg18, boolean arg19, Function0 arg20, Modifier arg21, Composer arg22, int arg23) {
        MutableInteractionSource v1_3;
        Composer v0 = arg22;
        int v1 = -1534186401;
        v0.startReplaceGroup(v1);
        ComposerKt.sourceInformation(v0, "C350@16999L7:Clickable.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg23, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:350)");
        }

        ProvidableCompositionLocal v1_1 = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1_2 = v0.consume(((CompositionLocal)v1_1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        Object v4 = v1_2;
        if((v4 instanceof IndicationNodeFactory)) {
            v0.startReplaceGroup(2095040488);
            v0.endReplaceGroup();
            v1_2 = null;
        }
        else {
            v0.startReplaceGroup(2095173106);
            ComposerKt.sourceInformation(v0, "359@17446L39");
            ComposerKt.sourceInformationMarkerStart(v0, 0xB9B4CEA6, "CC(remember):Clickable.kt#9igjgp");
            v1_2 = v0.rememberedValue();
            if(v1_2 == Composer.Companion.getEmpty()) {
                v1_3 = InteractionSourceKt.MutableInteractionSource();
                v0.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v0);
            v0.endReplaceGroup();
        }

        Object v3 = v1_3;
        Modifier v13 = ClickableKt.combinedClickable-auXiCPI(Modifier.Companion, ((MutableInteractionSource)v3), ((Indication)v4), arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v0.endReplaceGroup();
        return v13;
    }

    public static final boolean hasScrollableContainer(TraversableNode arg3) {
        BooleanRef v0 = new BooleanRef();
        TraversableNodeKt.traverseAncestors(((DelegatableNode)arg3), ScrollableContainerNode.TraverseKey, new ClickableKt$$ExternalSyntheticLambda2(v0));
        return v0.element;
    }

    static final boolean hasScrollableContainer$lambda$0(BooleanRef arg2, TraversableNode arg3) {
        boolean v3;
        if(!arg2.element) {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode");
            if(((ScrollableContainerNode)arg3).getEnabled()) {
                goto label_10;
            }
            else {
                v3 = false;
            }
        }
        else {
        label_10:
            v3 = true;
        }

        arg2.element = v3;
        return arg2.element ^ 1;
    }

    private static final boolean isClick-ZmokQxo(KeyEvent arg2) {
        if((KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg2), KeyEventType.Companion.getKeyUp-CS__XNY())) && (ClickableKt.isEnter-ZmokQxo(arg2))) {
            return 1;
        }

        return 0;
    }

    private static final boolean isEnter-ZmokQxo(KeyEvent arg4) {
        long v0 = KeyEvent_androidKt.getKey-ZmokQxo(arg4);
        if(!Key.equals-impl0(v0, Key.Companion.getDirectionCenter-EK5gGoQ()) && !Key.equals-impl0(v0, Key.Companion.getEnter-EK5gGoQ()) && !Key.equals-impl0(v0, Key.Companion.getNumPadEnter-EK5gGoQ())) {
            if(Key.equals-impl0(v0, Key.Companion.getSpacebar-EK5gGoQ())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isMovingIgnoreConsumed(IndirectPointerInputChange arg1) {
        if((arg1.getPreviousPressed()) && (arg1.getPressed())) {
            return 1;
        }

        return 0;
    }

    private static final boolean isPress-ZmokQxo(KeyEvent arg2) {
        if((KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg2), KeyEventType.Companion.getKeyDown-CS__XNY())) && (ClickableKt.isEnter-ZmokQxo(arg2))) {
            return 1;
        }

        return 0;
    }

    private static final String unsupportedIndicationExceptionMessage(Indication arg2) {
        return "clickable only supports IndicationNodeFactory instances provided to LocalIndication, but Indication was provided instead. Either migrate the Indication implementation to implement IndicationNodeFactory, or use the other clickable overload that takes an Indication parameter, and explicitly pass LocalIndication.current there. The Indication instance provided here was: " + arg2;
    }
}

