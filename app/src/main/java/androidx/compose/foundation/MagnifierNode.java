package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u009B\u0001\u0012\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u001B\b\u0002\u0010\u000B\u001A\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n\u0012\u0016\b\u0002\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\r\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001A\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\b\u001A\u0010\u001BJ\u008F\u0001\u0010S\u001A\u00020\u000E2\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\u0019\u0010\u000B\u001A\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u00122\u0014\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001A\u00020\u000EH\u0016J\b\u0010W\u001A\u00020\u000EH\u0016J\b\u0010X\u001A\u00020\u000EH\u0016J\b\u0010Y\u001A\u00020\u000EH\u0002J\b\u0010Z\u001A\u00020\u000EH\u0002J\b\u0010[\u001A\u00020\u000EH\u0002J\f\u0010\\\u001A\u00020\u000E*\u00020]H\u0016J\u0010\u0010^\u001A\u00020\u000E2\u0006\u0010_\u001A\u00020BH\u0016J\f\u0010`\u001A\u00020\u000E*\u00020aH\u0016R+\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR-\u0010\u000B\u001A\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u001D\"\u0004\b!\u0010\u001FR(\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u001D\"\u0004\b#\u0010\u001FR\u001A\u0010\u000F\u001A\u00020\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001A\u0010\u0011\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001C\u0010\u0013\u001A\u00020\rX\u0086\u000E¢\u0006\u0010\n\u0002\u00100\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001C\u0010\u0014\u001A\u00020\u0015X\u0086\u000E¢\u0006\u0010\n\u0002\u00103\u001A\u0004\b1\u0010%\"\u0004\b2\u0010\'R\u001C\u0010\u0016\u001A\u00020\u0015X\u0086\u000E¢\u0006\u0010\n\u0002\u00103\u001A\u0004\b4\u0010%\"\u0004\b5\u0010\'R\u001A\u0010\u0017\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001A\u0010\u0018\u001A\u00020\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b8\u00109\"\u0004\b:\u0010;R\u0010\u0010<\u001A\u0004\u0018\u00010=X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010>\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010?\u001A\u0004\u0018\u00010@X\u0082\u000E¢\u0006\u0002\n\u0000R/\u0010C\u001A\u0004\u0018\u00010B2\b\u0010A\u001A\u0004\u0018\u00010B8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bH\u0010I\u001A\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0016\u0010J\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010KX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010L\u001A\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bM\u0010-R\u0010\u0010N\u001A\u00020\tX\u0082\u000E¢\u0006\u0004\n\u0002\u00100R\u0010\u0010O\u001A\u0004\u0018\u00010PX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010Q\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010RX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006b"}, d2={"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSourceCenter", "()Lkotlin/jvm/functions/Function1;", "setSourceCenter", "(Lkotlin/jvm/functions/Function1;)V", "getMagnifierCenter", "setMagnifierCenter", "getOnSizeChanged", "setOnSizeChanged", "getZoom", "()F", "setZoom", "(F)V", "getUseTextDefault", "()Z", "setUseTextDefault", "(Z)V", "getSize-MYxV2XQ", "()J", "setSize-EaSLcWc", "(J)V", "J", "getCornerRadius-D9Ej5fM", "setCornerRadius-0680j_4", "F", "getElevation-D9Ej5fM", "setElevation-0680j_4", "getClippingEnabled", "setClippingEnabled", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "view", "Landroid/view/View;", "density", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "anchorPositionInRootState", "Landroidx/compose/runtime/State;", "anchorPositionInRoot", "getAnchorPositionInRoot-F1C5BW0", "sourceCenterInRoot", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "drawSignalChannel", "Lkotlinx/coroutines/channels/Channel;", "update", "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "onAttach", "onDetach", "onObservedReadsChanged", "recreateMagnifier", "updateMagnifier", "updateSizeIfNecessary", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onGloballyPositioned", "coordinates", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MagnifierNode extends Node implements DrawModifierNode, GlobalPositionAwareModifierNode, ObserverModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private State anchorPositionInRootState;
    private boolean clippingEnabled;
    private float cornerRadius;
    private Density density;
    private Channel drawSignalChannel;
    private float elevation;
    private final MutableState layoutCoordinates$delegate;
    private PlatformMagnifier magnifier;
    private Function1 magnifierCenter;
    private Function1 onSizeChanged;
    private PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private Function1 sourceCenter;
    private long sourceCenterInRoot;
    private boolean useTextDefault;
    private View view;
    private float zoom;

    static {
    }

    public MagnifierNode(Function1 arg1, Function1 arg2, Function1 arg3, float arg4, boolean arg5, long arg6, float arg8, float arg9, boolean arg10, PlatformMagnifierFactory arg11, DefaultConstructorMarker arg12) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg8, arg9, arg10, arg11);
    }

    private MagnifierNode(Function1 arg1, Function1 arg2, Function1 arg3, float arg4, boolean arg5, long arg6, float arg8, float arg9, boolean arg10, PlatformMagnifierFactory arg11) {
        super();
        this.sourceCenter = arg1;
        this.magnifierCenter = arg2;
        this.onSizeChanged = arg3;
        this.zoom = arg4;
        this.useTextDefault = arg5;
        this.size = arg6;
        this.cornerRadius = arg8;
        this.elevation = arg9;
        this.clippingEnabled = arg10;
        this.platformMagnifierFactory = arg11;
        this.layoutCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.sourceCenterInRoot = Offset.Companion.getUnspecified-F1C5BW0();
    }

    public MagnifierNode(Function1 arg2, Function1 arg3, Function1 arg4, float arg5, boolean arg6, long arg7, float arg9, float arg10, boolean arg11, PlatformMagnifierFactory arg12, int arg13, DefaultConstructorMarker arg14) {
        Function1 v0 = null;
        if((arg13 & 2) != 0) {
            arg3 = v0;
        }

        if((arg13 & 4) != 0) {
            arg4 = v0;
        }

        if((arg13 & 8) != 0) {
            arg5 = NaNf;
        }

        if((arg13 & 0x20) != 0) {
            arg7 = DpSize.Companion.getUnspecified-MYxV2XQ();
        }

        if((arg13 & 0x40) != 0) {
            arg9 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg13 & 0x80) != 0) {
            arg10 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        if((arg13 & 0x200) != 0) {
            arg12 = PlatformMagnifierFactory.Companion.getForCurrentPlatform();
        }

        this(arg2, arg3, arg4, arg5, false, arg7, arg9, arg10, true, arg12, null);
    }

    public static final Channel access$getDrawSignalChannel$p(MagnifierNode arg0) {
        return arg0.drawSignalChannel;
    }

    public static final PlatformMagnifier access$getMagnifier$p(MagnifierNode arg0) {
        return arg0.magnifier;
    }

    public void applySemantics(SemanticsPropertyReceiver arg3) {
        arg3.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new MagnifierNode$$ExternalSyntheticLambda1(this));
    }

    static final Offset applySemantics$lambda$0(MagnifierNode arg2) {
        return Offset.box-impl(arg2.sourceCenterInRoot);
    }

    public void draw(ContentDrawScope arg1) {
        arg1.drawContent();
        Channel v0 = this.drawSignalChannel;
        if(v0 != null) {
            ChannelResult.box-impl(v0.trySend-JP2dKIU(Unit.INSTANCE));
        }
    }

    private final long getAnchorPositionInRoot-F1C5BW0() {
        State v0 = this.anchorPositionInRootState;
        if(v0 == null) {
            v0 = SnapshotStateKt.derivedStateOf(new MagnifierNode$$ExternalSyntheticLambda2(this));
            this.anchorPositionInRootState = v0;
        }

        if(v0 != null) {
            return v0.getValue().unbox-impl();
        }

        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    static final Offset getAnchorPositionInRoot_F1C5BW0$lambda$0(MagnifierNode arg2) {
        LayoutCoordinates v2 = arg2.getLayoutCoordinates();
        long v0 = v2 != null ? LayoutCoordinatesKt.positionInRoot(v2) : Offset.Companion.getUnspecified-F1C5BW0();
        return Offset.box-impl(v0);
    }

    public final boolean getClippingEnabled() {
        return this.clippingEnabled;
    }

    public final float getCornerRadius-D9Ej5fM() {
        return this.cornerRadius;
    }

    public final float getElevation-D9Ej5fM() {
        return this.elevation;
    }

    private final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates$delegate.getValue();
    }

    public final Function1 getMagnifierCenter() {
        return this.magnifierCenter;
    }

    public final Function1 getOnSizeChanged() {
        return this.onSizeChanged;
    }

    public final PlatformMagnifierFactory getPlatformMagnifierFactory() {
        return this.platformMagnifierFactory;
    }

    public final long getSize-MYxV2XQ() {
        return this.size;
    }

    public final Function1 getSourceCenter() {
        return this.sourceCenter;
    }

    public final boolean getUseTextDefault() {
        return this.useTextDefault;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public void onAttach() {
        this.onObservedReadsChanged();
        this.drawSignalChannel = ChannelKt.Channel$default(0, null, null, 7, null);
        BuildersKt.launch$default(this.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new MagnifierNode$onAttach$1(this, null), 1, null);
    }

    public void onDetach() {
        PlatformMagnifier v0 = this.magnifier;
        if(v0 != null) {
            v0.dismiss();
        }

        this.magnifier = null;
    }

    public void onGloballyPositioned(LayoutCoordinates arg1) {
        this.setLayoutCoordinates(arg1);
    }

    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new MagnifierNode$$ExternalSyntheticLambda0(this));
    }

    static final Unit onObservedReadsChanged$lambda$0(MagnifierNode arg0) {
        arg0.updateMagnifier();
        return Unit.INSTANCE;
    }

    private final void recreateMagnifier() {
        PlatformMagnifier v0 = this.magnifier;
        if(v0 != null) {
            v0.dismiss();
        }

        View v0_1 = this.view;
        if(v0_1 == null) {
            v0_1 = DelegatableNode_androidKt.requireView(this);
        }

        View v2 = v0_1;
        this.view = v2;
        Density v0_2 = this.density;
        if(v0_2 == null) {
            v0_2 = DelegatableNodeKt.requireDensity(this);
        }

        this.density = v0_2;
        this.magnifier = this.platformMagnifierFactory.create-nHHXs2Y(v2, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, v0_2, this.zoom);
        this.updateSizeIfNecessary();
    }

    public final void setClippingEnabled(boolean arg1) {
        this.clippingEnabled = arg1;
    }

    public final void setCornerRadius-0680j_4(float arg1) {
        this.cornerRadius = arg1;
    }

    public final void setElevation-0680j_4(float arg1) {
        this.elevation = arg1;
    }

    private final void setLayoutCoordinates(LayoutCoordinates arg1) {
        this.layoutCoordinates$delegate.setValue(arg1);
    }

    public final void setMagnifierCenter(Function1 arg1) {
        this.magnifierCenter = arg1;
    }

    public final void setOnSizeChanged(Function1 arg1) {
        this.onSizeChanged = arg1;
    }

    public final void setPlatformMagnifierFactory(PlatformMagnifierFactory arg1) {
        this.platformMagnifierFactory = arg1;
    }

    public final void setSize-EaSLcWc(long arg1) {
        this.size = arg1;
    }

    public final void setSourceCenter(Function1 arg1) {
        this.sourceCenter = arg1;
    }

    public final void setUseTextDefault(boolean arg1) {
        this.useTextDefault = arg1;
    }

    public final void setZoom(float arg1) {
        this.zoom = arg1;
    }

    public final void update-5F03MCQ(Function1 arg21, Function1 arg22, float arg23, boolean arg24, long arg25, float arg27, float arg28, boolean arg29, Function1 arg30, PlatformMagnifierFactory arg31) {
        MagnifierNode v0 = this;
        float v1 = arg23;
        boolean v2 = arg24;
        long v3 = arg25;
        float v5 = arg27;
        float v6 = arg28;
        boolean v7 = arg29;
        PlatformMagnifierFactory v8 = arg31;
        float v9 = v0.zoom;
        long v10 = v0.size;
        float v12 = v0.cornerRadius;
        boolean v13 = v0.useTextDefault;
        float v14 = v0.elevation;
        boolean v16 = v0.clippingEnabled;
        PlatformMagnifierFactory v17 = v0.platformMagnifierFactory;
        View v18 = v0.view;
        Density v19 = v0.density;
        v0.sourceCenter = arg21;
        v0.magnifierCenter = arg22;
        v0.zoom = v1;
        v0.useTextDefault = v2;
        v0.size = v3;
        v0.cornerRadius = v5;
        v0.elevation = v6;
        v0.clippingEnabled = v7;
        v0.onSizeChanged = arg30;
        v0.platformMagnifierFactory = v8;
        View v22 = DelegatableNode_androidKt.requireView(v0);
        Density v21 = DelegatableNodeKt.requireDensity(v0);
        if(v0.magnifier != null && (!Magnifier_androidKt.equalsIncludingNaN(v1, v9) && !v8.getCanUpdateZoom() || (!DpSize.equals-impl0(v3, v10) || !Dp.equals-impl0(v5, v12) || !Dp.equals-impl0(v6, v14) || v2 != v13 || v7 != v16 || !Intrinsics.areEqual(v8, v17) || !Intrinsics.areEqual(v22, v18)) || !Intrinsics.areEqual(v21, v19))) {
            v0.recreateMagnifier();
        }

        v0.updateMagnifier();
    }

    private final void updateMagnifier() {
        long v0_2;
        Density v0 = this.density;
        if(v0 == null) {
            v0 = DelegatableNodeKt.requireDensity(this);
            this.density = v0;
        }

        long v1 = this.sourceCenter.invoke(v0).unbox-impl();
        long v3 = 0x7FFFFFFF7FFFFFFFL;
        long v7 = 0x7FC000007FC00000L;
        if((v1 & v3) != v7 && (this.getAnchorPositionInRoot-F1C5BW0() & v3) != v7) {
            this.sourceCenterInRoot = Offset.plus-MK-Hz9U(this.getAnchorPositionInRoot-F1C5BW0(), v1);
            Function1 v1_1 = this.magnifierCenter;
            if(v1_1 != null) {
                Offset v0_1 = Offset.box-impl(v1_1.invoke(v0).unbox-impl());
                if((v0_1.unbox-impl() & v3) != v7) {
                }
                else {
                    v0_1 = null;
                }

                if(v0_1 == null) {
                    goto label_33;
                }

                v0_2 = Offset.plus-MK-Hz9U(this.getAnchorPositionInRoot-F1C5BW0(), v0_1.unbox-impl());
            }
            else {
            label_33:
                v0_2 = Offset.Companion.getUnspecified-F1C5BW0();
            }

            long v5 = v0_2;
            if(this.magnifier == null) {
                this.recreateMagnifier();
            }

            PlatformMagnifier v2 = this.magnifier;
            if(v2 != null) {
                v2.update-Wko1d7g(this.sourceCenterInRoot, v5, this.zoom);
            }

            this.updateSizeIfNecessary();
            return;
        }

        this.sourceCenterInRoot = Offset.Companion.getUnspecified-F1C5BW0();
        PlatformMagnifier v9 = this.magnifier;
        if(v9 != null) {
            v9.dismiss();
        }
    }

    private final void updateSizeIfNecessary() {
        PlatformMagnifier v0 = this.magnifier;
        if(v0 == null) {
        }
        else {
            Density v1 = this.density;
            if(v1 == null) {
            }
            else if(!IntSize.equals-impl(v0.getSize-YbymL2g(), this.previousSize)) {
                Function1 v2 = this.onSizeChanged;
                if(v2 != null) {
                    v2.invoke(DpSize.box-impl(v1.toDpSize-k-rfVVM(IntSizeKt.toSize-ozmzZPI(v0.getSize-YbymL2g()))));
                }

                this.previousSize = IntSize.box-impl(v0.getSize-YbymL2g());
            }
        }
    }
}

