package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.view.KeyEvent;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyMapping_androidKt;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001A\u0017\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u0014\u0010\u0006\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000\u001A\u0014\u0010\n\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u000B\u001A\u00020\tH\u0000¨\u0006\f²\u0006\n\u0010\r\u001A\u00020\u000EX\u008A\u008E\u0002"}, d2={"isCopyKeyEvent", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "isCopyKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "selectionMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "addSelectionContainerTextContextMenuComponents", "selectionManager", "foundation", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionManager_androidKt {
    public static Unit $r8$lambda$2OsR-_1hldJzG06e_umVP2ufEtQ(SelectionManager arg0) {
        return SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$1$0$2(arg0);
    }

    public static Unit $r8$lambda$30DtrCaSPfEAjU_JPrTptEFKtz8(Density arg0, MutableState arg1, DpSize arg2) {
        return SelectionManager_androidKt.selectionMagnifier$lambda$0$4$0$1(arg0, arg1, arg2);
    }

    public static Offset $r8$lambda$Fpm2yjTSNI_8zm1zwbGGfV5RrgY(Function0 arg0, Density arg1) {
        return SelectionManager_androidKt.selectionMagnifier$lambda$0$4$0$0(arg0, arg1);
    }

    public static Offset $r8$lambda$KvsqlggAcHdVNqoOWC3qdyO0HtQ(SelectionManager arg0, MutableState arg1) {
        return SelectionManager_androidKt.selectionMagnifier$lambda$0$3$0(arg0, arg1);
    }

    public static boolean $r8$lambda$XD53zag51HmnPtj4NJu8U3J8vXQ(SelectionManager arg0) {
        return SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$1$0$1(arg0);
    }

    public static Unit $r8$lambda$YanxVJCifIIW_G4GF71PoyMSH8w(SelectionManager arg0, Context arg1, TextContextMenuBuilderScope arg2) {
        return SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$1(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$a0hwUcQKYICvwDn6MSUNp9mAO8E(SelectionManager arg0) {
        return SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$1$0$0(arg0);
    }

    public static Modifier $r8$lambda$iwA0dx_n9-fzsSBlN45F1GiadJk(Density arg0, MutableState arg1, Function0 arg2) {
        return SelectionManager_androidKt.selectionMagnifier$lambda$0$4$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$jwPJcTIPkrNi5yJFQNf27Xk5TfE(Function0 arg0, Function0 arg1, TextContextMenuSession arg2) {
        return SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$0(arg0, arg1, arg2);
    }

    public static final Modifier addSelectionContainerTextContextMenuComponents(Modifier arg1, SelectionManager arg2) {
        return TextContextMenuModifier_androidKt.addTextContextMenuComponentsWithContext(arg1, new SelectionManager_androidKt$$ExternalSyntheticLambda2(arg2));
    }

    static final Unit addSelectionContainerTextContextMenuComponents$lambda$0(SelectionManager arg10, TextContextMenuBuilderScope arg11, Context arg12) {
        Pair v0 = arg10.getContextTextAndSelection$foundation();
        Object v1 = null;
        Object v2 = v0 != null ? v0.getFirst() : v1;
        Object v6 = v2;
        if(v0 != null) {
            v1 = v0.getSecond();
        }

        PlatformSelectionBehaviors_androidKt.addPlatformTextContextMenuItems-71BSaZU(arg11, arg12, false, ((CharSequence)v6), v1, arg10.getPlatformSelectionBehaviors$foundation(), new SelectionManager_androidKt$$ExternalSyntheticLambda3(arg10, arg12));
        return Unit.INSTANCE;
    }

    private static final Unit addSelectionContainerTextContextMenuComponents$lambda$0$1(SelectionManager arg14, Context arg15, TextContextMenuBuilderScope arg16) {
        arg16.separator();
        SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$default(arg16, arg15, TextContextMenuItems.Copy, arg14.isNonEmptySelection$foundation(), null, new SelectionManager_androidKt$$ExternalSyntheticLambda7(arg14), 8, null);
        SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem(arg16, arg15, TextContextMenuItems.SelectAll, arg14.isEntireContainerSelected$foundation() ^ 1, new SelectionManager_androidKt$$ExternalSyntheticLambda8(arg14), new SelectionManager_androidKt$$ExternalSyntheticLambda9(arg14));
        arg16.separator();
        return Unit.INSTANCE;
    }

    private static final Unit addSelectionContainerTextContextMenuComponents$lambda$0$1$0$0(SelectionManager arg1) {
        arg1.copy$foundation();
        if(arg1.isInTouchMode()) {
            arg1.onRelease();
        }

        return Unit.INSTANCE;
    }

    private static final boolean addSelectionContainerTextContextMenuComponents$lambda$0$1$0$1(SelectionManager arg1) {
        if(arg1.getShowToolbar$foundation()) {
            if(!arg1.isInTouchMode()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final Unit addSelectionContainerTextContextMenuComponents$lambda$0$1$0$2(SelectionManager arg0) {
        arg0.selectAll$foundation();
        return Unit.INSTANCE;
    }

    private static final void addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem(TextContextMenuBuilderScope arg1, Context arg2, TextContextMenuItems arg3, boolean arg4, Function0 arg5, Function0 arg6) {
        ContextMenu_androidKt.textItem(arg1, arg2.getResources(), arg3, arg4, new SelectionManager_androidKt$$ExternalSyntheticLambda0(arg6, arg5));
    }

    private static final Unit addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$0(Function0 arg0, Function0 arg1, TextContextMenuSession arg2) {
        arg0.invoke();
        boolean v0 = arg1 != null ? arg1.invoke().booleanValue() : true;
        if(v0) {
            arg2.close();
        }

        return Unit.INSTANCE;
    }

    static void addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem$default(TextContextMenuBuilderScope arg6, Context arg7, TextContextMenuItems arg8, boolean arg9, Function0 arg10, Function0 arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents$lambda$0$selectionContainerItem(arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static final boolean isCopyKeyEvent-ZmokQxo(KeyEvent arg1) {
        if(KeyMapping_androidKt.getPlatformDefaultKeyMapping().map-ZmokQxo(arg1) == KeyCommand.COPY) {
            return 1;
        }

        return 0;
    }

    public static final Modifier selectionMagnifier(Modifier arg3, SelectionManager arg4) {
        Object v2 = null;
        if(!Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, v2)) {
            return arg3;
        }

        return ComposedModifierKt.composed$default(arg3, ((Function1)v2), new SelectionManager_androidKt$$ExternalSyntheticLambda4(arg4), 1, v2);
    }

    static final Modifier selectionMagnifier$lambda$0(SelectionManager arg4, Modifier arg5, Composer arg6, int arg7) {
        SelectionManager_androidKt$$ExternalSyntheticLambda6 v1_2;
        int v0 = -1914520728;
        arg6.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg6, "C51@2356L7,52@2393L41,54@2501L68,55@2603L540:SelectionManager.android.kt#eksfi3");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg7, -1, "androidx.compose.foundation.text.selection.selectionMagnifier.<anonymous> (SelectionManager.android.kt:51)");
        }

        ProvidableCompositionLocal v7 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v7_1 = arg6.consume(((CompositionLocal)v7));
        ComposerKt.sourceInformationMarkerEnd(arg6);
        String v1 = "CC(remember):SelectionManager.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg6, 0xA0218AD1, v1);
        Object v0_1 = arg6.rememberedValue();
        if(v0_1 == Composer.Companion.getEmpty()) {
            MutableState v0_2 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), null, 2, null);
            arg6.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        ComposerKt.sourceInformationMarkerStart(arg6, -1608411028, v1);
        boolean v2 = arg6.changedInstance(arg4);
        Object v3 = arg6.rememberedValue();
        if((v2) || v3 == Composer.Companion.getEmpty()) {
            SelectionManager_androidKt$$ExternalSyntheticLambda5 v3_1 = new SelectionManager_androidKt$$ExternalSyntheticLambda5(arg4, ((MutableState)v0_1));
            arg6.updateRememberedValue(v3_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        ComposerKt.sourceInformationMarkerStart(arg6, 0xA021A704, v1);
        boolean v4 = arg6.changed(v7_1);
        Object v1_1 = arg6.rememberedValue();
        if((v4) || v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new SelectionManager_androidKt$$ExternalSyntheticLambda6(((Density)v7_1), ((MutableState)v0_1));
            arg6.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        Modifier v4_1 = SelectionMagnifierKt.animatedSelectionMagnifier(arg5, ((Function0)v3), ((Function1)v1_2));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg6.endReplaceGroup();
        return v4_1;
    }

    private static final long selectionMagnifier$lambda$0$1(MutableState arg2) {
        return ((State)arg2).getValue().unbox-impl();
    }

    private static final void selectionMagnifier$lambda$0$2(MutableState arg0, long arg1) {
        arg0.setValue(IntSize.box-impl(arg1));
    }

    private static final Offset selectionMagnifier$lambda$0$3$0(SelectionManager arg2, MutableState arg3) {
        return Offset.box-impl(SelectionManagerKt.calculateSelectionMagnifierCenterAndroid-O0kMr_c(arg2, SelectionManager_androidKt.selectionMagnifier$lambda$0$1(arg3)));
    }

    private static final Modifier selectionMagnifier$lambda$0$4$0(Density arg15, MutableState arg16, Function0 arg17) {
        return Magnifier_androidKt.magnifier-jPUL71Q$default(Modifier.Companion, new SelectionManager_androidKt$$ExternalSyntheticLambda10(arg17), null, new SelectionManager_androidKt$$ExternalSyntheticLambda1(arg15, arg16), 0f, true, 0, 0f, 0f, false, PlatformMagnifierFactory.Companion.getForCurrentPlatform(), 490, null);
    }

    private static final Offset selectionMagnifier$lambda$0$4$0$0(Function0 arg0, Density arg1) {
        return arg0.invoke();
    }

    private static final Unit selectionMagnifier$lambda$0$4$0$1(Density arg6, MutableState arg7, DpSize arg8) {
        SelectionManager_androidKt.selectionMagnifier$lambda$0$2(arg7, IntSize.constructor-impl((((long)arg6.roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(arg8.unbox-impl())))) << 0x20 | (((long)arg6.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(arg8.unbox-impl())))) & 0xFFFFFFFFL));
        return Unit.INSTANCE;
    }
}

