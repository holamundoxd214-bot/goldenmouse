package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.WindowManager$LayoutParams;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001AR\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0011\u0010\n\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000BH\u0007¢\u0006\u0004\b\f\u0010\r\u001AD\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u000F2\u0010\b\u0002\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0011\u0010\n\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000BH\u0007¢\u0006\u0002\u0010\u0010\u001A \u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0015H\u0002\u001A(\u0010 \u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u001B2\u0011\u0010\n\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000BH\u0001¢\u0006\u0002\u0010\"\u001A+\u0010#\u001A\u00020\u00012\u0006\u0010$\u001A\u00020%2\u0013\b\b\u0010\n\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000BH\u0083\b¢\u0006\u0002\u0010&\u001A\f\u0010\'\u001A\u00020\u0015*\u00020(H\u0000\u001A\u0014\u0010)\u001A\u00020\u0012*\u00020\t2\u0006\u0010*\u001A\u00020\u0015H\u0002\u001A\f\u0010+\u001A\u00020,*\u00020-H\u0002\u001A\u001C\u0010.\u001A\u00020\u00152\u0006\u0010/\u001A\u00020(2\n\b\u0002\u00100\u001A\u0004\u0018\u00010\u001BH\u0007\"\u000E\u0010\u0011\u001A\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u001A\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001AX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u001A\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00150\u001AX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u001D¨\u00061²\u0006\u0015\u00102\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000BX\u008A\u0084\u0002"}, d2={"Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupPropertiesBaseFlags", "", "createFlags", "focusable", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "clippingEnabled", "LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalIsInPopupLayout", "getLocalIsInPopupLayout", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "Landroid/view/View;", "flagsWithSecureFlagInherited", "isParentFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "isPopupLayout", "view", "testTag", "ui", "currentContent"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal LocalIsInPopupLayout = null;
    private static final ProvidableCompositionLocal LocalPopupTestTag = null;
    private static final int PopupPropertiesBaseFlags = 0x40000;

    static {
        AndroidPopup_androidKt.LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, AndroidPopup_androidKt$LocalPopupTestTag$1.INSTANCE, 1, null);
        AndroidPopup_androidKt.LocalIsInPopupLayout = CompositionLocalKt.compositionLocalOf$default(null, AndroidPopup_androidKt$LocalIsInPopupLayout$1.INSTANCE, 1, null);
    }

    public static final void Popup(PopupPositionProvider arg28, Function0 arg29, PopupProperties arg30, Function2 arg31, Composer arg32, int arg33, int arg34) {
        PopupProperties v3_6;
        Function0 v2_4;
        AndroidPopup_androidKt$Popup$7$1 v3_4;
        AndroidPopup_androidKt$Popup$3$1 v5_4;
        AndroidPopup_androidKt$Popup$2$1 v8_5;
        PopupLayout v4_3;
        int v26;
        int v9;
        PopupProperties v8;
        int v6;
        Function0 v5;
        int v2;
        PopupPositionProvider v1 = arg28;
        Function2 v12 = arg31;
        int v13 = arg33;
        int v0 = 0x96600711;
        Composer v14 = arg32.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(Popup)P(2,1,3)299@13430L7,300@13469L7,301@13513L7,302@13568L7,303@13604L28,304@13659L29,305@13724L21,305@13707L38,307@13875L7,308@13905L1203,338@15144L388,338@15114L418,353@15549L219,353@15538L230,362@15814L126,362@15774L166,374@16531L147,374@16503L175,387@16947L573,395@17528L99,384@16856L771:AndroidPopup.android.kt#2oxthz");
        if((v13 & 6) == 0) {
            v2 = v14.changed(v1) ? 4 : 2;
            v2 |= v13;
        }
        else {
            v2 = v13;
        }

        int v3 = arg34 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v13 & 0x30) == 0) {
            v5 = arg29;
            v6 = v14.changedInstance(v5) ? 0x20 : 16;
            v2 |= v6;
        }
        else {
        label_32:
            v5 = arg29;
        }

        v6 = arg34 & 4;
        if(v6 != 0) {
            v2 |= 0x180;
            goto label_47;
        }
        else if((v13 & 0x180) == 0) {
            v8 = arg30;
            v9 = v14.changed(v8) ? 0x100 : 0x80;
            v2 |= v9;
        }
        else {
        label_47:
            v8 = arg30;
        }

        if((v13 & 0xC00) == 0) {
            v9 = v14.changedInstance(v12) ? 0x800 : 0x400;
            v2 |= v9;
        }

        boolean v9_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v14.shouldExecute(v9_1, v2 & 1)) {
            Function0 v18 = v3 != 0 ? null : v5;
            PopupProperties v19 = v6 != 0 ? new PopupProperties(false, false, false, false, 15, null) : v8;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:298)");
            }

            ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalView();
            v3 = 0x789C5F52;
            String v5_1 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, v3, v5_1);
            Object v0_2 = v14.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v14);
            ProvidableCompositionLocal v6_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v14, v3, v5_1);
            Object v6_2 = v14.consume(((CompositionLocal)v6_1));
            ComposerKt.sourceInformationMarkerEnd(v14);
            ProvidableCompositionLocal v8_1 = AndroidPopup_androidKt.LocalPopupTestTag;
            ComposerKt.sourceInformationMarkerStart(v14, v3, v5_1);
            Object v8_2 = v14.consume(((CompositionLocal)v8_1));
            ComposerKt.sourceInformationMarkerEnd(v14);
            Object v20 = v8_2;
            v8_1 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v14, v3, v5_1);
            v8_2 = v14.consume(((CompositionLocal)v8_1));
            ComposerKt.sourceInformationMarkerEnd(v14);
            Object v21 = v8_2;
            CompositionContext v8_3 = ComposablesKt.rememberCompositionContext(v14, 0);
            State v10 = SnapshotStateKt.rememberUpdatedState(v12, v14, v2 >> 9 & 14);
            Object[] v4 = new Object[0];
            String v15 = "CC(remember):AndroidPopup.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, 0x7E7AC446, v15);
            Object v7 = v14.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                AndroidPopup_androidKt$Popup$popupId$1$1 v7_1 = AndroidPopup_androidKt$Popup$popupId$1$1.INSTANCE;
                v14.updateRememberedValue(v7_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            v7 = RememberSaveableKt.rememberSaveable(v4, ((Function0)v7), v14, 0x30);
            ProvidableCompositionLocal v4_1 = AndroidPopup_androidKt.LocalIsInPopupLayout;
            ComposerKt.sourceInformationMarkerStart(v14, v3, v5_1);
            Object v3_1 = v14.consume(((CompositionLocal)v4_1));
            ComposerKt.sourceInformationMarkerEnd(v14);
            boolean v3_2 = ((Boolean)v3_1).booleanValue();
            ComposerKt.sourceInformationMarkerStart(v14, 0x7E7ADF84, v15);
            Object v4_2 = v14.rememberedValue();
            if(v4_2 == Composer.Companion.getEmpty()) {
                v26 = v2;
                CompositionContext v27 = v8_3;
                v13 = 0x20;
                boolean v8_4 = v3_2;
                v3_1 = v20;
                PopupLayout v0_3 = new PopupLayout(v18, v19, ((String)v3_1), v0_2, v6_2, v1, ((UUID)v7), v8_4, null, 0x100, null);
                v1 = v1;
                v9 = 1;
                v0_3.setContent(v27, ComposableLambdaKt.composableLambdaInstance(-297523940, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(v0_3, v10)));
                v14.updateRememberedValue(v0_3);
                v4_3 = v0_3;
            }
            else {
                v26 = v2;
                v9 = 1;
                v3_1 = v20;
                v13 = 0x20;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 2122020661, v15);
            boolean v0_4 = v14.changedInstance(v4_3);
            v2 = v26;
            int v5_2 = v2 & 0x70;
            int v11 = v5_2 == v13 ? v9 : 0;
            v0 = (((int)v0_4)) | v11;
            v6 = v2 & 0x380;
            v11 = v6 == 0x100 ? v9 : 0;
            v7 = v21;
            v0 = v0 | v11 | v14.changed(v3_1) | v14.changed(((Enum)v7).ordinal());
            v8_2 = v14.rememberedValue();
            if(v0 != 0 || v8_2 == Composer.Companion.getEmpty()) {
                v8_5 = new AndroidPopup_androidKt$Popup$2$1(v4_3, v18, v19, v3_1, ((LayoutDirection)v21));
                v14.updateRememberedValue(v8_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            EffectsKt.DisposableEffect(v4_3, ((Function1)v8_5), v14, 0);
            ComposerKt.sourceInformationMarkerStart(v14, 2122033452, v15);
            v0_4 = v14.changedInstance(v4_3);
            v11 = v5_2 == v13 ? v9 : 0;
            v0 = (((int)v0_4)) | v11;
            v11 = v6 == 0x100 ? v9 : 0;
            v0 = v0 | v11 | v14.changed(v3_1) | v14.changed(((Enum)v7).ordinal());
            Object v5_3 = v14.rememberedValue();
            if(v0 != 0 || v5_3 == Composer.Companion.getEmpty()) {
                v8_2 = v21;
                v5_4 = new AndroidPopup_androidKt$Popup$3$1(v4_3, v18, v19, v3_1, ((LayoutDirection)v21));
                v14.updateRememberedValue(v5_4);
            }
            else {
                v8_2 = v21;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            EffectsKt.SideEffect(((Function0)v5_4), v14, 0);
            ComposerKt.sourceInformationMarkerStart(v14, 0x7E7BC9EF, v15);
            v0_4 = v14.changedInstance(v4_3);
            v2 &= 14;
            v11 = v2 == 4 ? v9 : 0;
            v3_1 = v14.rememberedValue();
            if(((((int)v0_4)) | v11) != 0 || v3_1 == Composer.Companion.getEmpty()) {
                AndroidPopup_androidKt$Popup$4$1 v3_3 = new AndroidPopup_androidKt$Popup$4$1(v4_3, v1);
                v14.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            EffectsKt.DisposableEffect(v1, ((Function1)v3_1), v14, v2);
            ComposerKt.sourceInformationMarkerStart(v14, 2122064804, v15);
            v0_4 = v14.changedInstance(v4_3);
            Object v2_1 = v14.rememberedValue();
            if((v0_4) || v2_1 == Composer.Companion.getEmpty()) {
                AndroidPopup_androidKt$Popup$5$1 v2_2 = new AndroidPopup_androidKt$Popup$5$1(v4_3, null);
                v14.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            EffectsKt.LaunchedEffect(v4_3, ((Function2)v2_1), v14, 0);
            Companion v0_5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v14, 2122078542, v15);
            boolean v2_3 = v14.changedInstance(v4_3);
            v3_1 = v14.rememberedValue();
            if((v2_3) || v3_1 == Composer.Companion.getEmpty()) {
                v3_4 = new AndroidPopup_androidKt$Popup$7$1(v4_3);
                v14.updateRememberedValue(v3_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            Modifier v0_6 = OnGloballyPositionedModifierKt.onGloballyPositioned(((Modifier)v0_5), ((Function1)v3_4));
            ComposerKt.sourceInformationMarkerStart(v14, 2122096660, v15);
            v2 = v14.changedInstance(v4_3) | v14.changed(((Enum)v7).ordinal());
            v3_1 = v14.rememberedValue();
            if(v2 != 0 || v3_1 == Composer.Companion.getEmpty()) {
                AndroidPopup_androidKt$Popup$8$1 v3_5 = new AndroidPopup_androidKt$Popup$8$1(v4_3, ((LayoutDirection)v8_2));
                v14.updateRememberedValue(v3_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            v2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v14, 0));
            CompositionLocalMap v4_4 = v14.getCurrentCompositionLocalMap();
            v0_6 = ComposedModifierKt.materializeModifier(v14, v0_6);
            v5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v14, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v14.startReusableNode();
            if(v14.getInserting()) {
                v14.createNode(v5);
            }
            else {
                v14.useNode();
            }

            Composer v5_5 = Updater.constructor-impl(v14);
            Updater.set-impl(v5_5, v3_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_5, v4_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v5_5, Integer.valueOf(v2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v5_5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v5_5, v0_6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v14, 0xC6E23529, "C:AndroidPopup.android.kt#2oxthz");
            ComposerKt.sourceInformationMarkerEnd(v14);
            v14.endNode();
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_4 = v18;
            v3_6 = v19;
        }
        else {
            v14.skipToGroupEnd();
            v2_4 = v5;
            v3_6 = v8;
        }

        ScopeUpdateScope v7_2 = v14.endRestartGroup();
        if(v7_2 != null) {
            v7_2.updateScope(new AndroidPopup_androidKt$Popup$9(v1, v2_4, v3_6, arg31, arg33, arg34));
        }
    }

    private static final Function2 Popup$lambda$0(State arg0) {
        return arg0.getValue();
    }

    public static final void Popup-K5zGePQ(Alignment arg26, long arg27, Function0 arg29, PopupProperties arg30, Function2 arg31, Composer arg32, int arg33, int arg34) {
        PopupProperties v5_2;
        Function0 v4_1;
        long v2_1;
        Alignment v1_1;
        Function2 v15_1;
        PopupProperties v14;
        int v13;
        Function0 v11;
        int v10;
        long v8;
        Alignment v3;
        int v4;
        int v7 = arg33;
        int v0 = 71005054;
        Composer v12 = arg32.startRestartGroup(v0);
        ComposerKt.sourceInformation(v12, "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)271@12454L82,273@12542L166:AndroidPopup.android.kt#2oxthz");
        int v1 = arg34 & 1;
        if(v1 != 0) {
            v4 = v7 | 6;
            v3 = arg26;
        }
        else if((v7 & 6) == 0) {
            v3 = arg26;
            v4 = v12.changed(v3) ? 4 : 2;
            v4 |= v7;
        }
        else {
            v3 = arg26;
            v4 = v7;
        }

        int v5 = arg34 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_38;
        }
        else if((v7 & 0x30) == 0) {
            v8 = arg27;
            v10 = v12.changed(v8) ? 0x20 : 16;
            v4 |= v10;
        }
        else {
        label_38:
            v8 = arg27;
        }

        v10 = arg34 & 4;
        if(v10 != 0) {
            v4 |= 0x180;
            goto label_53;
        }
        else if((v7 & 0x180) == 0) {
            v11 = arg29;
            v13 = v12.changedInstance(v11) ? 0x100 : 0x80;
            v4 |= v13;
        }
        else {
        label_53:
            v11 = arg29;
        }

        v13 = arg34 & 8;
        if(v13 != 0) {
            v4 |= 0xC00;
            goto label_68;
        }
        else if((v7 & 0xC00) == 0) {
            v14 = arg30;
            int v15 = v12.changed(v14) ? 0x800 : 0x400;
            v4 |= v15;
        }
        else {
        label_68:
            v14 = arg30;
        }

        if((v7 & 0x6000) == 0) {
            v15_1 = arg31;
            int v16 = v12.changedInstance(v15_1) ? 0x4000 : 0x2000;
            v4 |= v16;
        }
        else {
            v15_1 = arg31;
        }

        int v17 = 0;
        boolean v2 = (v4 & 9363) != 9362 ? true : false;
        if(v12.shouldExecute(v2, v4 & 1)) {
            v1_1 = v1 != 0 ? Alignment.Companion.getTopStart() : v3;
            v2_1 = v5 != 0 ? IntOffset.constructor-impl(0) : v8;
            DefaultConstructorMarker v5_1 = null;
            Function0 v9 = v10 != 0 ? ((Function0)v5_1) : v11;
            PopupProperties v10_1 = v13 != 0 ? new PopupProperties(false, false, false, false, 15, null) : v14;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:269)");
            }

            ComposerKt.sourceInformationMarkerStart(v12, -483613200, "CC(remember):AndroidPopup.android.kt#9igjgp");
            v0 = (v4 & 14) == 4 ? 1 : 0;
            if((v4 & 0x70) == 0x20) {
                v17 = 1;
            }

            Object v6 = v12.rememberedValue();
            if((v0 | v17) != 0 || v6 == Composer.Companion.getEmpty()) {
                AlignmentOffsetPositionProvider v6_1 = new AlignmentOffsetPositionProvider(v1_1, v2_1, v5_1);
                v12.updateRememberedValue(v6_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            AndroidPopup_androidKt.Popup(v6, v9, v10_1, v15_1, v12, v4 >> 3 & 0x1FF0, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_1 = v9;
            v5_2 = v10_1;
        }
        else {
            v12.skipToGroupEnd();
            v1_1 = v3;
            v2_1 = v8;
            v4_1 = v11;
            v5_2 = v14;
        }

        ScopeUpdateScope v9_1 = v12.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new AndroidPopup_androidKt$Popup$1(v1_1, v2_1, v4_1, v5_2, arg31, v7, arg34));
        }
    }

    public static final void PopupTestTag(String arg4, Function2 arg5, Composer arg6, int arg7) {
        int v1;
        int v0 = 0x50EA043D;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(PopupTestTag)P(1)441@19264L75:AndroidPopup.android.kt#2oxthz");
        if((arg7 & 6) == 0) {
            v1 = arg6.changed(arg4) ? 4 : 2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            int v2 = arg6.changedInstance(arg5) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:440)");
            }

            CompositionLocalKt.CompositionLocalProvider(AndroidPopup_androidKt.LocalPopupTestTag.provides(arg4), arg5, arg6, v1 & 0x70 | ProvidedValue.$stable);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_47;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_47:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new AndroidPopup_androidKt$PopupTestTag$1(arg4, arg5, arg7));
        }
    }

    private static final void SimpleStack(Modifier arg6, Function2 arg7, Composer arg8, int arg9) {
        AndroidPopup_androidKt$SimpleStack$1$1 v0_1;
        ComposerKt.sourceInformationMarkerStart(arg8, 0x190FFB5, "CC(SimpleStack)P(1)449@19649L899,449@19602L946:AndroidPopup.android.kt#2oxthz");
        ComposerKt.sourceInformationMarkerStart(arg8, 0xE14FFA58, "CC(remember):AndroidPopup.android.kt#9igjgp");
        Object v0 = arg8.rememberedValue();
        if(v0 == Composer.Companion.getEmpty()) {
            v0_1 = AndroidPopup_androidKt$SimpleStack$1$1.INSTANCE;
            arg8.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        ComposerKt.sourceInformationMarkerStart(arg8, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int v1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(arg8, 0));
        CompositionLocalMap v2 = arg8.getCurrentCompositionLocalMap();
        arg6 = ComposedModifierKt.materializeModifier(arg8, arg6);
        Function0 v3 = ComposeUiNode.Companion.getConstructor();
        arg9 = (arg9 << 3 & 0x70 | (arg9 >> 3 & 14 | 0x180)) << 6 & 0x380 | 6;
        ComposerKt.sourceInformationMarkerStart(arg8, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if(!(arg8.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }

        arg8.startReusableNode();
        if(arg8.getInserting()) {
            arg8.createNode(v3);
        }
        else {
            arg8.useNode();
        }

        Composer v3_1 = Updater.constructor-impl(arg8);
        Updater.set-impl(v3_1, v0_1, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(v3_1, v2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl(v3_1, Integer.valueOf(v1), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl(v3_1, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl(v3_1, arg6, ComposeUiNode.Companion.getSetModifier());
        arg7.invoke(arg8, Integer.valueOf(arg9 >> 6 & 14));
        arg8.endNode();
        ComposerKt.sourceInformationMarkerEnd(arg8);
        ComposerKt.sourceInformationMarkerEnd(arg8);
        ComposerKt.sourceInformationMarkerEnd(arg8);
    }

    public static final Function2 access$Popup$lambda$0(State arg0) {
        return AndroidPopup_androidKt.Popup$lambda$0(arg0);
    }

    public static final int access$createFlags(boolean arg0, SecureFlagPolicy arg1, boolean arg2) {
        return AndroidPopup_androidKt.createFlags(arg0, arg1, arg2);
    }

    public static final int access$flagsWithSecureFlagInherited(PopupProperties arg0, boolean arg1) {
        return AndroidPopup_androidKt.flagsWithSecureFlagInherited(arg0, arg1);
    }

    public static final IntRect access$toIntBounds(Rect arg0) {
        return AndroidPopup_androidKt.toIntBounds(arg0);
    }

    private static final int createFlags(boolean arg1, SecureFlagPolicy arg2, boolean arg3) {
        int v1 = !arg1 ? 0x40008 : 0x40000;
        if(arg2 == SecureFlagPolicy.SecureOn) {
            v1 |= 0x2000;
        }

        if(!arg3) {
            v1 |= 0x200;
        }

        return v1;
    }

    private static final int flagsWithSecureFlagInherited(PopupProperties arg1, boolean arg2) {
        if((arg1.getInheritSecurePolicy$ui()) && (arg2)) {
            return arg1.getFlags$ui() | 0x2000;
        }

        if((arg1.getInheritSecurePolicy$ui()) && !arg2) {
            return arg1.getFlags$ui() & 0xFFFFDFFF;
        }

        return arg1.getFlags$ui();
    }

    public static final ProvidableCompositionLocal getLocalIsInPopupLayout() {
        return AndroidPopup_androidKt.LocalIsInPopupLayout;
    }

    public static final ProvidableCompositionLocal getLocalPopupTestTag() {
        return AndroidPopup_androidKt.LocalPopupTestTag;
    }

    public static final boolean isFlagSecureEnabled(View arg1) {
        ViewGroup$LayoutParams v1 = arg1.getRootView().getLayoutParams();
        if((v1 instanceof WindowManager$LayoutParams)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null && (((WindowManager$LayoutParams)v1).flags & 0x2000) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isPopupLayout(View arg1, String arg2) {
        if(((arg1 instanceof PopupLayout)) && (arg2 == null || (Intrinsics.areEqual(arg2, ((PopupLayout)arg1).getTestTag())))) {
            return 1;
        }

        return 0;
    }

    public static boolean isPopupLayout$default(View arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = null;
        }

        return AndroidPopup_androidKt.isPopupLayout(arg0, arg1);
    }

    private static final IntRect toIntBounds(Rect arg4) {
        return new IntRect(arg4.left, arg4.top, arg4.right, arg4.bottom);
    }
}

