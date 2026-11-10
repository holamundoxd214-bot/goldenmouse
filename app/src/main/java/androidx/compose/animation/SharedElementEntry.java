package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\n\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010A\u001A\u0004\u0018\u00010B2\u0006\u0010C\u001A\u00020BJ\u0010\u0010J\u001A\u00020K2\u0006\u0010L\u001A\u00020MH\u0016J\b\u0010h\u001A\u00020KH\u0016J\b\u0010i\u001A\u00020KH\u0016J\b\u0010j\u001A\u00020KH\u0016R+\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\n8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00118V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u001F\u0010 \u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER+\u0010\r\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\n8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001A\u001A\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R+\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u00048F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b(\u0010\u001A\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R+\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\u00068F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001A\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b2\u0010\u001A\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R+\u0010\t\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\n8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b5\u0010\u001A\u001A\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R+\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\f8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b:\u0010\u001A\u001A\u0004\b6\u00107\"\u0004\b8\u00109R+\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u000F8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b?\u0010\u001A\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u0010@\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b@\u0010\u0016R\u001C\u0010D\u001A\u0004\u0018\u00010EX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001C\u0010N\u001A\u0004\u0018\u00010\u0000X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0011\u0010S\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\bT\u0010\u0016R\u001C\u0010U\u001A\u0004\u0018\u00010VX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bW\u0010X\"\u0004\bY\u0010ZR/\u0010\\\u001A\u0004\u0018\u00010[2\b\u0010\u0014\u001A\u0004\u0018\u00010[8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\ba\u0010\u001A\u001A\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010b\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bc\u0010\u0016R\u0014\u0010d\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\be\u0010\u0016R\u0011\u0010f\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\bg\u0010\u0016¨\u0006k"}, d2={"Landroidx/compose/animation/SharedElementEntry;", "Landroidx/compose/animation/LayerRenderer;", "Landroidx/compose/runtime/RememberObserver;", "sharedElement", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeholderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "renderOnlyWhenVisible", "", "overlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "renderInOverlayDuringTransition", "userState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "zIndex", "", "<init>", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;ZLandroidx/compose/animation/SharedTransitionScope$OverlayClip;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;F)V", "<set-?>", "isAttached", "()Z", "setAttached", "(Z)V", "isAttached$delegate", "Landroidx/compose/runtime/MutableState;", "getZIndex", "()F", "setZIndex", "(F)V", "zIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getRenderInOverlayDuringTransition", "setRenderInOverlayDuringTransition", "renderInOverlayDuringTransition$delegate", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "setSharedElement", "(Landroidx/compose/animation/SharedElement;)V", "sharedElement$delegate", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "setBoundsAnimation", "(Landroidx/compose/animation/BoundsAnimation;)V", "boundsAnimation$delegate", "getPlaceholderSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "setPlaceholderSize", "(Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;)V", "placeholderSize$delegate", "getRenderOnlyWhenVisible", "setRenderOnlyWhenVisible", "renderOnlyWhenVisible$delegate", "getOverlayClip", "()Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "setOverlayClip", "(Landroidx/compose/animation/SharedTransitionScope$OverlayClip;)V", "overlayClip$delegate", "getUserState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "setUserState", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;)V", "userState$delegate", "isEnabled", "calculateTargetBounds", "Landroidx/compose/ui/geometry/Rect;", "previousTargetBoundsBeforeLosingTarget", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay$animation", "()Landroidx/compose/ui/graphics/Path;", "setClipPathInOverlay$animation", "(Landroidx/compose/ui/graphics/Path;)V", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "parentState", "getParentState", "()Landroidx/compose/animation/SharedElementEntry;", "setParentState", "(Landroidx/compose/animation/SharedElementEntry;)V", "target", "getTarget", "boundsProvider", "Landroidx/compose/animation/BoundsProvider;", "getBoundsProvider", "()Landroidx/compose/animation/BoundsProvider;", "setBoundsProvider", "(Landroidx/compose/animation/BoundsProvider;)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layer$delegate", "shouldRenderAtAll", "getShouldRenderAtAll", "shouldRenderInOverlay", "getShouldRenderInOverlay$animation", "shouldRenderInPlace", "getShouldRenderInPlace", "onRemembered", "onForgotten", "onAbandoned", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SharedElementEntry implements LayerRenderer, RememberObserver {
    public static final int $stable = 8;
    private final MutableState boundsAnimation$delegate;
    private BoundsProvider boundsProvider;
    private Path clipPathInOverlay;
    private final MutableState isAttached$delegate;
    private final MutableState layer$delegate;
    private final MutableState overlayClip$delegate;
    private SharedElementEntry parentState;
    private final MutableState placeholderSize$delegate;
    private final MutableState renderInOverlayDuringTransition$delegate;
    private final MutableState renderOnlyWhenVisible$delegate;
    private final MutableState sharedElement$delegate;
    private final MutableState userState$delegate;
    private final MutableFloatState zIndex$delegate;

    static {
    }

    public SharedElementEntry(SharedElement arg4, BoundsAnimation arg5, PlaceholderSize arg6, boolean arg7, OverlayClip arg8, boolean arg9, SharedContentState arg10, float arg11) {
        super();
        this.isAttached$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.zIndex$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg11);
        this.renderInOverlayDuringTransition$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(arg9), null, 2, null);
        this.sharedElement$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
        this.boundsAnimation$delegate = SnapshotStateKt.mutableStateOf$default(arg5, null, 2, null);
        this.placeholderSize$delegate = SnapshotStateKt.mutableStateOf$default(arg6, null, 2, null);
        this.renderOnlyWhenVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(arg7), null, 2, null);
        this.overlayClip$delegate = SnapshotStateKt.mutableStateOf$default(arg8, null, 2, null);
        this.userState$delegate = SnapshotStateKt.mutableStateOf$default(arg10, null, 2, null);
        this.layer$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public final Rect calculateTargetBounds(Rect arg5) {
        return this.getUserState().getConfig$animation().alternativeTargetBoundsInTransitionScopeAfterRemoval-cSwnlzA(this.getUserState(), arg5, IntSizeKt.toSize-ozmzZPI(this.getSharedElement().getScope().getLookaheadRoot$animation().getSize-YbymL2g()));
    }

    public void drawInOverlay(DrawScope arg9) {
        GraphicsLayer v0 = this.getLayer();
        if(v0 == null) {
        }
        else {
            Rect v1 = this.getSharedElement().getState$animation().getCurrentBounds();
            if(v1 == null) {
            }
            else if(this.getShouldRenderInOverlay$animation()) {
                long v1_1 = v1.getTopLeft-F1C5BW0();
                float v3 = Float.intBitsToFloat(((int)(v1_1 >> 0x20)));
                float v1_2 = Float.intBitsToFloat(((int)(v1_1 & 0xFFFFFFFFL)));
                Path v8 = this.clipPathInOverlay;
                if(v8 != null) {
                    int v2 = ClipOp.Companion.getIntersect-rtfAjoo();
                    DrawContext v4 = arg9.getDrawContext();
                    long v5 = v4.getSize-NH-jbRc();
                    v4.getCanvas().save();
                    try {
                        v4.getTransform().clipPath-mtrdD-E(v8, v2);
                        arg9.getDrawContext().getTransform().translate(v3, v1_2);
                    }
                    catch(Throwable v8_1) {
                        goto label_51;
                    }

                    try {
                        GraphicsLayerKt.drawLayer(arg9, v0);
                        goto label_33;
                    }
                    catch(Throwable v8_1) {
                        try {
                            arg9.getDrawContext().getTransform().translate(-v3, -v1_2);
                            throw v8_1;
                        label_33:
                            arg9.getDrawContext().getTransform().translate(-v3, -v1_2);
                        }
                        catch(Throwable v8_1) {
                        label_51:
                            v4.getCanvas().restore();
                            v4.setSize-uvyYCjk(v5);
                            throw v8_1;
                        }
                    }

                    v4.getCanvas().restore();
                    v4.setSize-uvyYCjk(v5);
                    return;
                }
                else {
                    arg9.getDrawContext().getTransform().translate(v3, v1_2);
                    try {
                        GraphicsLayerKt.drawLayer(arg9, v0);
                    }
                    catch(Throwable v8_1) {
                        arg9.getDrawContext().getTransform().translate(-v3, -v1_2);
                        throw v8_1;
                    }

                    arg9.getDrawContext().getTransform().translate(-v3, -v1_2);
                    return;
                }
            }
        }
    }

    public final BoundsAnimation getBoundsAnimation() {
        return this.boundsAnimation$delegate.getValue();
    }

    public final BoundsProvider getBoundsProvider() {
        return this.boundsProvider;
    }

    public final Path getClipPathInOverlay$animation() {
        return this.clipPathInOverlay;
    }

    public final GraphicsLayer getLayer() {
        return this.layer$delegate.getValue();
    }

    public final OverlayClip getOverlayClip() {
        return this.overlayClip$delegate.getValue();
    }

    public SharedElementEntry getParentState() {
        return this.parentState;
    }

    public final PlaceholderSize getPlaceholderSize() {
        return this.placeholderSize$delegate.getValue();
    }

    public final boolean getRenderInOverlayDuringTransition() {
        return this.renderInOverlayDuringTransition$delegate.getValue().booleanValue();
    }

    public final boolean getRenderOnlyWhenVisible() {
        return this.renderOnlyWhenVisible$delegate.getValue().booleanValue();
    }

    public final SharedElement getSharedElement() {
        return this.sharedElement$delegate.getValue();
    }

    private final boolean getShouldRenderAtAll() {
        if(!this.getBoundsAnimation().getTarget() && (!this.getSharedElement().getState$animation().getMatchIsOrHasBeenConfigured() || (this.getSharedElement().getState$animation().getActiveMatchFound())) && (this.getRenderOnlyWhenVisible())) {
            return 0;
        }

        return 1;
    }

    public final boolean getShouldRenderInOverlay$animation() {
        if((this.getShouldRenderAtAll()) && (this.getSharedElement().getBoundsTransformIsActive()) && (this.isEnabled()) && (this.getRenderInOverlayDuringTransition()) && (this.getSharedElement().getScope().isTransitionActive())) {
            return 1;
        }

        return 0;
    }

    public final boolean getShouldRenderInPlace() {
        if((this.getSharedElement().getBoundsTransformIsActive()) && ((this.getShouldRenderInOverlay$animation()) || !this.getShouldRenderAtAll())) {
            return 0;
        }

        return 1;
    }

    public final boolean getTarget() {
        return this.getBoundsAnimation().getTarget();
    }

    public final SharedContentState getUserState() {
        return this.userState$delegate.getValue();
    }

    public float getZIndex() {
        return this.zIndex$delegate.getFloatValue();
    }

    public final boolean isAttached() {
        return this.isAttached$delegate.getValue().booleanValue();
    }

    public final boolean isEnabled() {
        SharedContentState v0 = this.getUserState();
        if((this.isAttached()) && (v0.isEnabledByUser$animation())) {
            return 1;
        }

        return 0;
    }

    public void onAbandoned() {
    }

    public void onForgotten() {
        this.getSharedElement().getScope().onEntryRemoved$animation(this);
        this.getSharedElement().invalidateTargetBoundsProvider();
    }

    public void onRemembered() {
        this.getSharedElement().getScope().onEntryAdded$animation(this);
        this.getSharedElement().invalidateTargetBoundsProvider();
    }

    public final void setAttached(boolean arg1) {
        this.isAttached$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setBoundsAnimation(BoundsAnimation arg1) {
        this.boundsAnimation$delegate.setValue(arg1);
    }

    public final void setBoundsProvider(BoundsProvider arg1) {
        this.boundsProvider = arg1;
    }

    public final void setClipPathInOverlay$animation(Path arg1) {
        this.clipPathInOverlay = arg1;
    }

    public final void setLayer(GraphicsLayer arg1) {
        this.layer$delegate.setValue(arg1);
    }

    public final void setOverlayClip(OverlayClip arg1) {
        this.overlayClip$delegate.setValue(arg1);
    }

    public void setParentState(SharedElementEntry arg1) {
        this.parentState = arg1;
    }

    public final void setPlaceholderSize(PlaceholderSize arg1) {
        this.placeholderSize$delegate.setValue(arg1);
    }

    public final void setRenderInOverlayDuringTransition(boolean arg1) {
        this.renderInOverlayDuringTransition$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setRenderOnlyWhenVisible(boolean arg1) {
        this.renderOnlyWhenVisible$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setSharedElement(SharedElement arg1) {
        this.sharedElement$delegate.setValue(arg1);
    }

    public final void setUserState(SharedContentState arg1) {
        this.userState$delegate.setValue(arg1);
    }

    public void setZIndex(float arg1) {
        this.zIndex$delegate.setFloatValue(arg1);
    }
}

