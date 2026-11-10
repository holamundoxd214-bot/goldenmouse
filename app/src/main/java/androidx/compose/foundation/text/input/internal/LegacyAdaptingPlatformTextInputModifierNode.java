package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001F\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u000E\u0010#\u001A\u00020$2\u0006\u0010\u0006\u001A\u00020\u0007J\b\u0010)\u001A\u00020$H\u0016J\b\u0010*\u001A\u00020$H\u0016J\u0010\u0010+\u001A\u00020$2\u0006\u0010,\u001A\u00020\u0017H\u0016J8\u0010-\u001A\u0004\u0018\u00010.2\'\u0010/\u001A#\b\u0001\u0012\u0004\u0012\u000201\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0006\u0012\u0004\u0018\u00010400¢\u0006\u0002\b5H\u0016¢\u0006\u0002\u00106R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u00020\tX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\n\u001A\u00020\u000BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u00178V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001F\u001A\u0004\u0018\u00010 8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0014\u0010%\u001A\u00020&8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(¨\u00067"}, d2={"Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;", "serviceAdapter", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "<init>", "(Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "getLegacyTextFieldState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setLegacyTextFieldState", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "getTextFieldSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "setTextFieldSelectionManager", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "setServiceAdapter", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "launchTextInputSession", "Lkotlinx/coroutines/Job;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSession;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LegacyAdaptingPlatformTextInputModifierNode extends Node implements LegacyPlatformTextInputNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, PlatformTextInputModifierNode {
    public static final int $stable = 8;
    private final MutableState layoutCoordinates$delegate;
    private LegacyTextFieldState legacyTextFieldState;
    private LegacyPlatformTextInputServiceAdapter serviceAdapter;
    private TextFieldSelectionManager textFieldSelectionManager;

    static {
    }

    public LegacyAdaptingPlatformTextInputModifierNode(LegacyPlatformTextInputServiceAdapter arg1, LegacyTextFieldState arg2, TextFieldSelectionManager arg3) {
        super();
        this.serviceAdapter = arg1;
        this.legacyTextFieldState = arg2;
        this.textFieldSelectionManager = arg3;
        this.layoutCoordinates$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates$delegate.getValue();
    }

    public LegacyTextFieldState getLegacyTextFieldState() {
        return this.legacyTextFieldState;
    }

    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), CompositionLocalsKt.getLocalSoftwareKeyboardController());
    }

    public TextFieldSelectionManager getTextFieldSelectionManager() {
        return this.textFieldSelectionManager;
    }

    public ViewConfiguration getViewConfiguration() {
        return CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), CompositionLocalsKt.getLocalViewConfiguration());
    }

    public Job launchTextInputSession(Function2 arg9) {
        Job v1 = null;
        if(!this.isAttached()) {
            return v1;
        }

        return BuildersKt.launch$default(this.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new LegacyAdaptingPlatformTextInputModifierNode$launchTextInputSession$1(this, arg9, ((Continuation)v1)), 1, null);
    }

    public void onAttach() {
        this.serviceAdapter.registerModifier(((LegacyPlatformTextInputNode)this));
    }

    public void onDetach() {
        this.serviceAdapter.unregisterModifier(((LegacyPlatformTextInputNode)this));
    }

    public void onGloballyPositioned(LayoutCoordinates arg1) {
        this.setLayoutCoordinates(arg1);
    }

    private void setLayoutCoordinates(LayoutCoordinates arg1) {
        this.layoutCoordinates$delegate.setValue(arg1);
    }

    public void setLegacyTextFieldState(LegacyTextFieldState arg1) {
        this.legacyTextFieldState = arg1;
    }

    public final void setServiceAdapter(LegacyPlatformTextInputServiceAdapter arg3) {
        if(this.isAttached()) {
            this.serviceAdapter.stopInput();
            this.serviceAdapter.unregisterModifier(this);
        }

        this.serviceAdapter = arg3;
        if(this.isAttached()) {
            this.serviceAdapter.registerModifier(((LegacyPlatformTextInputNode)this));
        }
    }

    public void setTextFieldSelectionManager(TextFieldSelectionManager arg1) {
        this.textFieldSelectionManager = arg1;
    }
}

