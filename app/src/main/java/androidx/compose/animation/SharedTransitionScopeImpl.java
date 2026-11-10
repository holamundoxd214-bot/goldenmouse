package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002:\u0001~B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u001E\u001A\u00020\u001F*\u00020\u001F2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00120\u000BH\u0016J\"\u0010!\u001A\u00020\u001F*\u00020\u001F2\u0006\u0010\"\u001A\u00020#2\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00120\u000BH\u0016JD\u0010%\u001A\u00020\u001F*\u00020\u001F2\u0006\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020)2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020#2\u0006\u0010/\u001A\u000200H\u0016J\\\u00101\u001A\u00020\u001F*\u00020\u001F2\u0006\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020)2\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002052\u0006\u0010*\u001A\u00020+2\u0006\u00106\u001A\u0002072\u0006\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020#2\u0006\u0010/\u001A\u000200H\u0016JD\u00108\u001A\u00020\u001F*\u00020\u001F2\u0006\u0010&\u001A\u00020\'2\u0006\u00109\u001A\u00020\u00122\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020#2\u0006\u0010/\u001A\u000200H\u0016JS\u0010:\u001A\u00020\u001F*\u00020\u001F2\u0006\u0010&\u001A\u00020\'2\u0006\u00109\u001A\u00020\u00122\b\b\u0002\u0010*\u001A\u00020+2\b\b\u0002\u0010,\u001A\u00020-2\b\b\u0002\u0010.\u001A\u00020\u00122\b\b\u0002\u0010\"\u001A\u00020#2\b\b\u0002\u0010/\u001A\u000200H\u0000¢\u0006\u0002\b;J\u0010\u0010<\u001A\u0002002\u0006\u0010=\u001A\u00020>H\u0016J\r\u0010A\u001A\u00020\fH\u0000¢\u0006\u0002\bBJp\u0010C\u001A\u00020\u001F\"\u0004\b\u0000\u0010D*\u00020\u001F2\u0006\u0010&\u001A\u00020\'2\u000E\u0010E\u001A\n\u0012\u0004\u0012\u0002HD\u0018\u00010F2\u0012\u00109\u001A\u000E\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u00020\u00120G2\u0006\u0010*\u001A\u00020+2\b\b\u0002\u0010,\u001A\u00020-2\u0006\u0010H\u001A\u00020\u00122\u0006\u0010.\u001A\u00020\u00122\u0006\u0010\"\u001A\u00020#2\u0006\u0010/\u001A\u000200H\u0002JM\u0010I\u001A\u00020J2\u0006\u0010%\u001A\u00020K2\u0006\u0010L\u001A\u00020M2\u0006\u0010,\u001A\u00020-2\u0006\u0010H\u001A\u00020\u00122\u0006\u0010&\u001A\u00020\'2\u0006\u0010/\u001A\u0002002\u0006\u0010\"\u001A\u00020#2\u0006\u0010.\u001A\u00020\u0012H\u0003¢\u0006\u0002\u0010NJ\u0010\u0010b\u001A\u00020K2\u0006\u0010c\u001A\u00020aH\u0002J\u0015\u0010d\u001A\u00020\f2\u0006\u0010e\u001A\u00020fH\u0000¢\u0006\u0002\bgJ\u0015\u0010h\u001A\u00020\f2\u0006\u0010i\u001A\u00020JH\u0000¢\u0006\u0002\bjJ\u0015\u0010k\u001A\u00020\f2\u0006\u0010i\u001A\u00020JH\u0000¢\u0006\u0002\blJ\u0015\u0010m\u001A\u00020\f2\u0006\u0010n\u001A\u00020^H\u0000¢\u0006\u0002\boJ\u0015\u0010p\u001A\u00020\f2\u0006\u0010n\u001A\u00020^H\u0000¢\u0006\u0002\bqJ,\u0010r\u001A\u00020s*\u00020P2\u0006\u0010t\u001A\u00020P2\u0006\u0010u\u001A\u00020s2\u0006\u0010v\u001A\u00020\u0012H\u0096\u0001¢\u0006\u0004\bw\u0010xJ\r\u0010y\u001A\u00020P*\u00020PH\u0096\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\"\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R+\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u00128V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R,\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u000E\"\u0004\b\u001D\u0010\u0010R\u001A\u0010?\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b@\u0010\u000ER$\u0010Q\u001A\u00020P2\u0006\u0010O\u001A\u00020P8@@@X\u0080\u000E¢\u0006\f\u001A\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001A\u0004\u0018\u00010P2\b\u0010O\u001A\u0004\u0018\u00010P@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\bW\u0010SR$\u0010X\u001A\u00020P2\u0006\u0010O\u001A\u00020P8@@@X\u0080\u000E¢\u0006\f\u001A\u0004\bY\u0010S\"\u0004\bZ\u0010UR\u0010\u0010[\u001A\u0004\u0018\u00010PX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001A\b\u0012\u0004\u0012\u00020^0]X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010_\u001A\u000E\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020K0`X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010z\u001A\u00020P*\u00020{X\u0096\u0005¢\u0006\u0006\u001A\u0004\b|\u0010}¨\u0006\u007F"}, d2={"Landroidx/compose/animation/SharedTransitionScopeImpl;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "lookaheadScope", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "invalidateOverlay", "Lkotlin/Function0;", "", "getInvalidateOverlay", "()Lkotlin/jvm/functions/Function0;", "setInvalidateOverlay", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "isTransitionActive", "()Z", "setTransitionActive", "(Z)V", "isTransitionActive$delegate", "Landroidx/compose/runtime/MutableState;", "testBlockToRun", "getTestBlockToRun$annotations", "()V", "getTestBlockToRun", "setTestBlockToRun", "skipToLookaheadSize", "Landroidx/compose/ui/Modifier;", "enabled", "renderInSharedTransitionScopeOverlay", "zIndexInOverlay", "", "renderInOverlay", "sharedElement", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "placeholderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "renderInOverlayDuringTransition", "clipInOverlayDuringTransition", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "sharedBounds", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "sharedElementWithCallerManagedVisibility", "visible", "sharedBoundsWithCallerManagedVisibility", "sharedBoundsWithCallerManagedVisibility$animation", "OverlayClip", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "observeAnimatingBlock", "getObserveAnimatingBlock$animation", "updateTransitionActiveness", "updateTransitionActiveness$animation", "sharedBoundsImpl", "T", "parentTransition", "Landroidx/compose/animation/core/Transition;", "Lkotlin/Function1;", "renderOnlyWhenVisible", "rememberSharedElementState", "Landroidx/compose/animation/SharedElementEntry;", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/animation/SharedTransitionScope$OverlayClip;FZLandroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedElementEntry;", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "root", "getRoot$animation", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setRoot$animation", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "nullableRoot", "getNullableRoot$animation", "lookaheadRoot", "getLookaheadRoot$animation", "setLookaheadRoot$animation", "_nullableLookaheadRoot", "renderers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/LayerRenderer;", "sharedElements", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "", "sharedElementsFor", "key", "drawInOverlay", "scope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawInOverlay$animation", "onEntryRemoved", "sharedElementState", "onEntryRemoved$animation", "onEntryAdded", "onEntryAdded$animation", "onLayerRendererCreated", "renderer", "onLayerRendererCreated$animation", "onLayerRendererRemoved", "onLayerRendererRemoved$animation", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "toLookaheadCoordinates", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ShapeBasedClip", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SharedTransitionScopeImpl implements SharedTransitionScope, LookaheadScope {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/animation/SharedTransitionScopeImpl$ShapeBasedClip;", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(Landroidx/compose/ui/graphics/Shape;)V", "getClipShape", "()Landroidx/compose/ui/graphics/Shape;", "path", "Landroidx/compose/ui/graphics/Path;", "getClipPath", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ShapeBasedClip implements OverlayClip {
        private final Shape clipShape;
        private final Path path;

        public ShapeBasedClip(Shape arg1) {
            super();
            this.clipShape = arg1;
            this.path = AndroidPath_androidKt.Path();
        }

        public Path getClipPath(SharedContentState arg4, Rect arg5, LayoutDirection arg6, Density arg7) {
            this.path.reset();
            OutlineKt.addOutline(this.path, this.clipShape.createOutline-Pq9zytI(arg5.getSize-NH-jbRc(), arg6, arg7));
            this.path.translate-k-4lQ0M(arg5.getTopLeft-F1C5BW0());
            return this.path;
        }

        public final Shape getClipShape() {
            return this.clipShape;
        }
    }

    public static final int $stable;
    private LayoutCoordinates _nullableLookaheadRoot;
    private final CoroutineScope coroutineScope;
    private Function0 invalidateOverlay;
    private final MutableState isTransitionActive$delegate;
    private LayoutCoordinates nullableRoot;
    private final Function0 observeAnimatingBlock;
    private final SnapshotStateList renderers;
    private final SnapshotStateMap sharedElements;
    private Function0 testBlockToRun;

    static {
    }

    public SharedTransitionScopeImpl(LookaheadScope arg2, CoroutineScope arg3) {
        super();
        this.$$delegate_0 = arg2;
        this.coroutineScope = arg3;
        this.isTransitionActive$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.observeAnimatingBlock = new SharedTransitionScopeImpl$observeAnimatingBlock$1(this);
        this.renderers = SnapshotStateKt.mutableStateListOf();
        this.sharedElements = SnapshotStateKt.mutableStateMapOf();
    }

    public OverlayClip OverlayClip(Shape arg1) {
        return new ShapeBasedClip(arg1);
    }

    public static final SnapshotStateMap access$getSharedElements$p(SharedTransitionScopeImpl arg0) {
        return arg0.sharedElements;
    }

    public static final SharedElementEntry access$rememberSharedElementState(SharedTransitionScopeImpl arg0, SharedElement arg1, BoundsAnimation arg2, PlaceholderSize arg3, boolean arg4, SharedContentState arg5, OverlayClip arg6, float arg7, boolean arg8, Composer arg9, int arg10) {
        return arg0.rememberSharedElementState(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static final SharedElement access$sharedElementsFor(SharedTransitionScopeImpl arg0, Object arg1) {
        return arg0.sharedElementsFor(arg1);
    }

    public final void drawInOverlay$animation(ContentDrawScope arg5) {
        SnapshotStateList v0 = this.renderers;
        if(((List)v0).size() > 1) {
            CollectionsKt.sortWith(((List)v0), new SharedTransitionScopeImpl$drawInOverlay$$inlined$sortBy$1());
        }

        SnapshotStateList v4 = this.renderers;
        int v0_1 = v4.size();
        int v1;
        for(v1 = 0; v1 < v0_1; ++v1) {
            ((List)v4).get(v1).drawInOverlay(arg5);
        }
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final Function0 getInvalidateOverlay() {
        return this.invalidateOverlay;
    }

    public final LayoutCoordinates getLookaheadRoot$animation() {
        LayoutCoordinates v1 = this._nullableLookaheadRoot;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.".toString());
    }

    public LayoutCoordinates getLookaheadScopeCoordinates(PlacementScope arg1) {
        return this.$$delegate_0.getLookaheadScopeCoordinates(arg1);
    }

    public final LayoutCoordinates getNullableRoot$animation() {
        return this.nullableRoot;
    }

    public final Function0 getObserveAnimatingBlock$animation() {
        return this.observeAnimatingBlock;
    }

    public final LayoutCoordinates getRoot$animation() {
        LayoutCoordinates v1 = this.nullableRoot;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.".toString());
    }

    public final Function0 getTestBlockToRun() {
        return this.testBlockToRun;
    }

    public static void getTestBlockToRun$annotations() {
    }

    public boolean isTransitionActive() {
        return this.isTransitionActive$delegate.getValue().booleanValue();
    }

    public long localLookaheadPositionOf-au-aQtc(LayoutCoordinates arg1, LayoutCoordinates arg2, long arg3, boolean arg5) {
        return this.$$delegate_0.localLookaheadPositionOf-au-aQtc(arg1, arg2, arg3, arg5);
    }

    public final void onEntryAdded$animation(SharedElementEntry arg7) {
        int v3;
        arg7.getSharedElement().addEntry(arg7);
        this.updateTransitionActiveness$animation();
        Iterator v0 = this.renderers.iterator();
        int v1;
        for(v1 = 0; true; ++v1) {
            v3 = -1;
            if(!v0.hasNext()) {
                break;
            }

            Object v2 = v0.next();
            Object v5 = null;
            if((v2 instanceof SharedElementEntry)) {
            }
            else {
                v2 = v5;
            }

            if(v2 != null) {
                SharedElement v5_1 = ((SharedElementEntry)v2).getSharedElement();
            }

            if(Intrinsics.areEqual(v5_1, arg7.getSharedElement())) {
                goto label_24;
            }
        }

        v1 = v3;
    label_24:
        if(v1 != this.renderers.size() - 1) {
            if(v1 == v3) {
            }
            else {
                this.renderers.add(v1 + 1, arg7);
                return;
            }
        }

        this.renderers.add(arg7);
    }

    public final void onEntryRemoved$animation(SharedElementEntry arg8) {
        SharedElement v0 = arg8.getSharedElement();
        v0.removeEntry(arg8);
        this.updateTransitionActiveness$animation();
        this.renderers.remove(arg8);
        if(v0.getAllEntries().isEmpty()) {
            BuildersKt.launch$default(v0.getScope().coroutineScope, null, null, new SharedTransitionScopeImpl$onEntryRemoved$1$1(v0, arg8, null), 3, null);
        }
    }

    public final void onLayerRendererCreated$animation(LayerRenderer arg1) {
        this.renderers.add(arg1);
    }

    public final void onLayerRendererRemoved$animation(LayerRenderer arg1) {
        this.renderers.remove(arg1);
    }

    private final SharedElementEntry rememberSharedElementState(SharedElement arg11, BoundsAnimation arg12, PlaceholderSize arg13, boolean arg14, SharedContentState arg15, OverlayClip arg16, float arg17, boolean arg18, Composer arg19, int arg20) {
        Composer v9 = arg19;
        int v1 = 864401334;
        ComposerKt.sourceInformationMarkerStart(v9, v1, "C(rememberSharedElementState)P(6!1,2,4,5!1,7)1311@72514L504:SharedTransitionScope.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg20, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedElementState (SharedTransitionScope.kt:1311)");
        }

        ComposerKt.sourceInformationMarkerStart(v9, 1761007534, "CC(remember):SharedTransitionScope.kt#9igjgp");
        Object v0 = v9.rememberedValue();
        if(v0 == Composer.Companion.getEmpty()) {
            SharedElementEntry v0_1 = new SharedElementEntry(arg11, arg12, arg13, arg14, arg16, arg18, arg15, arg17);
            v9.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v9);
        arg15.setInternalState$animation(((SharedElementEntry)v0));
        ((SharedElementEntry)v0).setSharedElement(arg11);
        ((SharedElementEntry)v0).setRenderOnlyWhenVisible(arg14);
        ((SharedElementEntry)v0).setBoundsAnimation(arg12);
        ((SharedElementEntry)v0).setPlaceholderSize(arg13);
        ((SharedElementEntry)v0).setOverlayClip(arg16);
        ((SharedElementEntry)v0).setZIndex(arg17);
        ((SharedElementEntry)v0).setRenderInOverlayDuringTransition(arg18);
        ((SharedElementEntry)v0).setUserState(arg15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v9);
        return ((SharedElementEntry)v0);
    }

    public Modifier renderInSharedTransitionScopeOverlay(Modifier arg2, float arg3, Function0 arg4) {
        return arg2.then(new RenderInTransitionOverlayNodeElement(this, arg4, arg3));
    }

    public final void setInvalidateOverlay(Function0 arg1) {
        this.invalidateOverlay = arg1;
    }

    public final void setLookaheadRoot$animation(LayoutCoordinates arg1) {
        this._nullableLookaheadRoot = arg1;
    }

    public final void setRoot$animation(LayoutCoordinates arg1) {
        this.nullableRoot = arg1;
    }

    public final void setTestBlockToRun(Function0 arg1) {
        this.testBlockToRun = arg1;
    }

    private void setTransitionActive(boolean arg1) {
        this.isTransitionActive$delegate.setValue(Boolean.valueOf(arg1));
    }

    public Modifier sharedBounds(Modifier arg12, SharedContentState arg13, AnimatedVisibilityScope arg14, EnterTransition arg15, ExitTransition arg16, BoundsTransform arg17, ResizeMode arg18, PlaceholderSize arg19, boolean arg20, float arg21, OverlayClip arg22) {
        return ComposedModifierKt.composed$default(this.sharedBoundsImpl(arg12, arg13, arg14.getTransition(), SharedTransitionScopeImpl$sharedBounds$1.INSTANCE, arg17, arg19, false, arg20, arg21, arg22), null, new SharedTransitionScopeImpl$sharedBounds$2(arg14, arg15, arg16, arg13, arg18), 1, null);
    }

    private final Modifier sharedBoundsImpl(Modifier arg12, SharedContentState arg13, Transition arg14, Function1 arg15, BoundsTransform arg16, PlaceholderSize arg17, boolean arg18, boolean arg19, float arg20, OverlayClip arg21) {
        return ComposedModifierKt.composed$default(arg12, null, new SharedTransitionScopeImpl$sharedBoundsImpl$1(arg13, arg14, arg15, this, arg17, arg18, arg21, arg20, arg19, arg16), 1, null);
    }

    static Modifier sharedBoundsImpl$default(SharedTransitionScopeImpl arg12, Modifier arg13, SharedContentState arg14, Transition arg15, Function1 arg16, BoundsTransform arg17, PlaceholderSize arg18, boolean arg19, boolean arg20, float arg21, OverlayClip arg22, int arg23, Object arg24) {
        PlaceholderSize v7 = (arg23 & 16) != 0 ? PlaceholderSize.Companion.getContentSize() : arg18;
        return arg12.sharedBoundsImpl(arg13, arg14, arg15, arg16, arg17, v7, arg19, arg20, arg21, arg22);
    }

    public final Modifier sharedBoundsWithCallerManagedVisibility$animation(Modifier arg13, SharedContentState arg14, boolean arg15, BoundsTransform arg16, PlaceholderSize arg17, boolean arg18, float arg19, OverlayClip arg20) {
        return this.sharedBoundsImpl(arg13, arg14, null, new SharedTransitionScopeImpl$sharedBoundsWithCallerManagedVisibility$1(arg15), arg16, arg17, false, arg18, arg19, arg20);
    }

    public static Modifier sharedBoundsWithCallerManagedVisibility$animation$default(SharedTransitionScopeImpl arg9, Modifier arg10, SharedContentState arg11, boolean arg12, BoundsTransform arg13, PlaceholderSize arg14, boolean arg15, float arg16, OverlayClip arg17, int arg18, Object arg19) {
        if((arg18 & 4) != 0) {
            arg13 = SharedTransitionDefaults.INSTANCE.getBoundsTransform();
        }

        BoundsTransform v4 = arg13;
        if((arg18 & 8) != 0) {
            arg14 = PlaceholderSize.Companion.getContentSize();
        }

        PlaceholderSize v5 = arg14;
        boolean v6 = (arg18 & 16) != 0 ? true : arg15;
        float v7 = (arg18 & 0x20) != 0 ? 0f : arg16;
        OverlayClip v8 = (arg18 & 0x40) != 0 ? SharedTransitionScopeKt.access$getParentClip$p() : arg17;
        return arg9.sharedBoundsWithCallerManagedVisibility$animation(arg10, arg11, arg12, v4, v5, v6, v7, v8);
    }

    public Modifier sharedElement(Modifier arg12, SharedContentState arg13, AnimatedVisibilityScope arg14, BoundsTransform arg15, PlaceholderSize arg16, boolean arg17, float arg18, OverlayClip arg19) {
        return this.sharedBoundsImpl(arg12, arg13, arg14.getTransition(), SharedTransitionScopeImpl$sharedElement$1.INSTANCE, arg15, arg16, true, arg17, arg18, arg19);
    }

    public Modifier sharedElementWithCallerManagedVisibility(Modifier arg13, SharedContentState arg14, boolean arg15, BoundsTransform arg16, PlaceholderSize arg17, boolean arg18, float arg19, OverlayClip arg20) {
        return this.sharedBoundsImpl(arg13, arg14, null, new SharedTransitionScopeImpl$sharedElementWithCallerManagedVisibility$1(arg15), arg16, arg17, true, arg18, arg19, arg20);
    }

    private final SharedElement sharedElementsFor(Object arg2) {
        SharedElement v0_1;
        Object v0 = this.sharedElements.get(arg2);
        if(v0 == null) {
            v0_1 = new SharedElement(arg2, this);
            this.sharedElements.put(arg2, v0_1);
        }

        return v0_1;
    }

    public Modifier skipToLookaheadSize(Modifier arg3, Function0 arg4) {
        return arg3.then(new SkipToLookaheadSizeElement(null, arg4, 1, null));
    }

    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates arg1) {
        return this.$$delegate_0.toLookaheadCoordinates(arg1);
    }

    public final void updateTransitionActiveness$animation() {
        Iterator v0_1;
        SnapshotStateMap v0 = this.sharedElements;
        boolean v2 = false;
        if(((Map)v0).isEmpty()) {
        }
        else {
            v0_1 = ((Map)v0).entrySet().iterator();
            do {
                if(v0_1.hasNext()) {
                    if(!v0_1.next().getValue().isAnimating()) {
                        continue;
                    }

                    break;
                }

                goto label_14;
            }
            while(true);

            v2 = true;
        }

    label_14:
        if(v2 != this.isTransitionActive()) {
            this.setTransitionActive(v2);
            if(!v2) {
                v0_1 = this.sharedElements.entrySet().iterator();
                while(v0_1.hasNext()) {
                    v0_1.next().getValue().onSharedTransitionFinished();
                }
            }
        }

        Iterator v3 = this.sharedElements.entrySet().iterator();
        while(v3.hasNext()) {
            v3.next().getValue().updateMatch$animation();
        }
    }
}

