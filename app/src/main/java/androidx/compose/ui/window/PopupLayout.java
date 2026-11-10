package androidx.compose.ui.window;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.KeyEvent$DispatcherState;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.R$id;
import androidx.compose.ui.R$string;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

@Metadata(d1={"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u0002:\u0002\u0086\u0001BY\u0012\u000E\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\\\u001A\u00020\u0005J&\u0010V\u001A\u00020\u00052\u0006\u0010]\u001A\u00020^2\u0011\u0010S\u001A\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\bR¢\u0006\u0002\u0010_J\r\u0010`\u001A\u00020\u0005H\u0017¢\u0006\u0002\u0010aJ\b\u0010b\u001A\u00020\u0005H\u0014J\b\u0010c\u001A\u00020\u0005H\u0014J\u001D\u0010d\u001A\u00020\u00052\u0006\u0010e\u001A\u00020f2\u0006\u0010g\u001A\u00020fH\u0010¢\u0006\u0002\bhJ5\u0010i\u001A\u00020\u00052\u0006\u0010j\u001A\u00020\u00132\u0006\u0010k\u001A\u00020f2\u0006\u0010l\u001A\u00020f2\u0006\u0010m\u001A\u00020f2\u0006\u0010n\u001A\u00020fH\u0010¢\u0006\u0002\boJ\u0010\u0010p\u001A\u00020\u00132\u0006\u0010q\u001A\u00020rH\u0016J\b\u0010s\u001A\u00020\u0005H\u0002J\b\u0010t\u001A\u00020\u0005H\u0002J.\u0010u\u001A\u00020\u00052\u000E\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010v\u001A\u00020*J\u0010\u0010w\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0002J\u000E\u0010x\u001A\u00020\u00052\u0006\u00109\u001A\u000208J\u0006\u0010{\u001A\u00020\u0005J\r\u0010|\u001A\u00020\u0005H\u0001¢\u0006\u0002\b}J\u0006\u0010~\u001A\u00020\u0005J\u0006\u0010\u007F\u001A\u00020\u0005J\u0014\u0010\u0080\u0001\u001A\u00020\u00132\t\u0010q\u001A\u0005\u0018\u00010\u0081\u0001H\u0016J\u0011\u0010\u0082\u0001\u001A\u00020\u00052\u0006\u0010v\u001A\u00020fH\u0016J\u0011\u0010\u0083\u0001\u001A\u00020\u00052\u0006\u0010v\u001A\u00020*H\u0002J\t\u0010\u0084\u0001\u001A\u00020\u001FH\u0002J\t\u0010\u0085\u0001\u001A\u00020@H\u0002R\u0016\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u001E\u001A\u00020\u001F8\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b \u0010!\u001A\u0004\b\"\u0010#R\u001A\u0010$\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001A\u0010)\u001A\u00020*X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R/\u00101\u001A\u0004\u0018\u0001002\b\u0010/\u001A\u0004\u0018\u0001008F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b2\u00103\"\u0004\b4\u00105R/\u00109\u001A\u0004\u0018\u0001082\b\u0010/\u001A\u0004\u0018\u0001088B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b>\u00107\u001A\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0010\u0010?\u001A\u0004\u0018\u00010@X\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010A\u001A\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001A\u0004\bB\u0010CR\u0010\u0010F\u001A\u00020GX\u0082\u0004¢\u0006\u0004\n\u0002\u0010HR\u000E\u0010I\u001A\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010K\u001A\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bL\u0010MR\u000E\u0010N\u001A\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001A\u0004\u0018\u00010QX\u0082\u000E¢\u0006\u0002\n\u0000RA\u0010S\u001A\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\bR2\u0011\u0010/\u001A\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\bR8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bX\u00107\u001A\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001E\u0010Z\u001A\u00020\u00132\u0006\u0010Y\u001A\u00020\u0013@RX\u0094\u000E¢\u0006\b\n\u0000\u001A\u0004\b[\u0010CR\u000E\u0010y\u001A\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0087\u0001"}, d2={"Landroidx/compose/ui/window/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/PopupProperties;", "testTag", "", "composeView", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupId", "Ljava/util/UUID;", "isNested", "", "popupLayoutHelper", "Landroidx/compose/ui/window/PopupLayoutHelper;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Ljava/lang/String;Landroid/view/View;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/window/PopupPositionProvider;Ljava/util/UUID;ZLandroidx/compose/ui/window/PopupLayoutHelper;)V", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "windowManager", "Landroid/view/WindowManager;", "params", "Landroid/view/WindowManager$LayoutParams;", "getParams$ui$annotations", "()V", "getParams$ui", "()Landroid/view/WindowManager$LayoutParams;", "positionProvider", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "setPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setParentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "popupContentSize", "getPopupContentSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPopupContentSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "popupContentSize$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setParentLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "parentLayoutCoordinates$delegate", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "canCalculatePosition", "getCanCalculatePosition", "()Z", "canCalculatePosition$delegate", "Landroidx/compose/runtime/State;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "previousWindowVisibleFrame", "Landroid/graphics/Rect;", "subCompositionView", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "backCallback", "", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "value", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "show", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "onAttachedToWindow", "onDetachedFromWindow", "internalOnMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "internalOnMeasure$ui", "internalOnLayout", "changed", "left", "top", "right", "bottom", "internalOnLayout$ui", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "maybeRegisterBackCallback", "maybeUnregisterBackCallback", "updateParameters", "layoutDirection", "updatePopupProperties", "updateParentLayoutCoordinates", "locationOnScreen", "", "pollForLocationOnScreenChange", "updateParentBounds", "updateParentBounds$ui", "updatePosition", "dismiss", "onTouchEvent", "Landroid/view/MotionEvent;", "setLayoutDirection", "superSetLayoutDirection", "createLayoutParams", "getVisibleDisplayBounds", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PopupLayout extends AbstractComposeView implements ViewRootForInspector {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/ui/window/PopupLayout$Companion;", "", "<init>", "()V", "onCommitAffectingPopupPosition", "Lkotlin/Function1;", "Landroidx/compose/ui/window/PopupLayout;", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutDirection.values().length];
            try {
                v0[LayoutDirection.Ltr.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[LayoutDirection.Rtl.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable;
    private static final Companion Companion;
    private Object backCallback;
    private final State canCalculatePosition$delegate;
    private final View composeView;
    private final MutableState content$delegate;
    private final boolean isNested;
    private final int[] locationOnScreen;
    private final float maxSupportedElevation;
    private static final Function1 onCommitAffectingPopupPosition;
    private Function0 onDismissRequest;
    private final WindowManager$LayoutParams params;
    private IntRect parentBounds;
    private final MutableState parentLayoutCoordinates$delegate;
    private LayoutDirection parentLayoutDirection;
    private final MutableState popupContentSize$delegate;
    private final PopupLayoutHelper popupLayoutHelper;
    private PopupPositionProvider positionProvider;
    private final Rect previousWindowVisibleFrame;
    private PopupProperties properties;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final SnapshotStateObserver snapshotStateObserver;
    private String testTag;
    private final WindowManager windowManager;

    static {
        PopupLayout.Companion = new Companion(null);
        PopupLayout.$stable = 8;
        PopupLayout.onCommitAffectingPopupPosition = PopupLayout$Companion$onCommitAffectingPopupPosition$1.INSTANCE;
    }

    public PopupLayout(Function0 arg12, PopupProperties arg13, String arg14, View arg15, Density arg16, PopupPositionProvider arg17, UUID arg18, boolean arg19, PopupLayoutHelper arg20, int arg21, DefaultConstructorMarker arg22) {
        PopupLayoutHelper v10_1;
        PopupLayoutHelperImpl29 v0;
        if((arg21 & 0x100) != 0) {
            if(Build$VERSION.SDK_INT >= 29) {
                v0 = new PopupLayoutHelperImpl29();
            }
            else {
                PopupLayoutHelperImpl v0_1 = new PopupLayoutHelperImpl();
            }

            PopupLayoutHelperImpl29 v10 = v0;
        }
        else {
            v10_1 = arg20;
        }

        this(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, v10_1);
    }

    public PopupLayout(Function0 arg7, PopupProperties arg8, String arg9, View arg10, Density arg11, PopupPositionProvider arg12, UUID arg13, boolean arg14, PopupLayoutHelper arg15) {
        PopupLayout v0 = this;
        super(arg10.getContext(), null, 0, 6, null);
        v0.onDismissRequest = arg7;
        v0.properties = arg8;
        v0.testTag = arg9;
        v0.composeView = arg10;
        v0.isNested = arg14;
        v0.popupLayoutHelper = arg15;
        Object v6 = arg10.getContext().getSystemService("window");
        Intrinsics.checkNotNull(v6, "null cannot be cast to non-null type android.view.WindowManager");
        v0.windowManager = ((WindowManager)v6);
        v0.params = v0.createLayoutParams();
        v0.positionProvider = arg12;
        v0.parentLayoutDirection = LayoutDirection.Ltr;
        v0.popupContentSize$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        v0.parentLayoutCoordinates$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        v0.canCalculatePosition$delegate = SnapshotStateKt.derivedStateOf(new PopupLayout$canCalculatePosition$2(v0));
        float v8 = Dp.constructor-impl(8f);
        v0.maxSupportedElevation = v8;
        v0.previousWindowVisibleFrame = new Rect();
        v0.snapshotStateObserver = new SnapshotStateObserver(new PopupLayout$snapshotStateObserver$1(v0));
        v0.setId(0x1020002);
        ViewTreeLifecycleOwner.set(v0, ViewTreeLifecycleOwner.get(arg10));
        ViewTreeViewModelStoreOwner.set(v0, ViewTreeViewModelStoreOwner.get(arg10));
        ViewTreeSavedStateRegistryOwner.set(v0, ViewTreeSavedStateRegistryOwner.get(arg10));
        v0.setTag(id.compose_view_saveable_id_tag, "Popup:" + arg13);
        v0.setClipChildren(false);
        v0.setElevation(arg11.toPx-0680j_4(v8));
        v0.setOutlineProvider(new androidx.compose.ui.window.PopupLayout$2());
        v0.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons$AndroidPopup_androidKt.INSTANCE.getLambda$-1131826196$ui(), null, 2, null);
        v0.locationOnScreen = new int[2];
    }

    public void Content(Composer arg6, int arg7) {
        int v1;
        int v0 = -857613600;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(Content)592@25262L9:AndroidPopup.android.kt#2oxthz");
        int v2 = 2;
        if((arg7 & 6) == 0) {
            v1 = arg6.changedInstance(this) ? 4 : v2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.ui.window.PopupLayout.Content (AndroidPopup.android.kt:591)");
            }

            this.getContent().invoke(arg6, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_37;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_37:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new PopupLayout$Content$4(this, arg7));
        }
    }

    public static final LayoutCoordinates access$getParentLayoutCoordinates(PopupLayout arg0) {
        return arg0.getParentLayoutCoordinates();
    }

    private final WindowManager$LayoutParams createLayoutParams() {
        WindowManager$LayoutParams v0 = new WindowManager$LayoutParams();
        v0.gravity = 0x800033;
        v0.flags = AndroidPopup_androidKt.flagsWithSecureFlagInherited(this.properties, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        v0.type = 1002;
        v0.token = this.composeView.getApplicationWindowToken();
        v0.width = -2;
        v0.height = -2;
        v0.format = -3;
        v0.setTitle(this.composeView.getContext().getResources().getString(string.default_popup_window_title));
        return v0;
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.set(this, null);
        this.windowManager.removeViewImmediate(this);
    }

    public boolean dispatchKeyEvent(KeyEvent arg4) {
        if(!this.properties.getDismissOnBackPress()) {
            return super.dispatchKeyEvent(arg4);
        }

        if(arg4.getKeyCode() == 4 || arg4.getKeyCode() == 0x6F) {
            KeyEvent$DispatcherState v0 = this.getKeyDispatcherState();
            if(v0 == null) {
                return super.dispatchKeyEvent(arg4);
            }
            else {
                if(arg4.getAction() == 0 && arg4.getRepeatCount() == 0) {
                    v0.startTracking(arg4, this);
                    return 1;
                }

                if(arg4.getAction() != 1) {
                    goto label_32;
                }

                if(!v0.isTracking(arg4)) {
                    goto label_32;
                }

                if(arg4.isCanceled()) {
                    goto label_32;
                }

                Function0 v3 = this.onDismissRequest;
                if(v3 != null) {
                    v3.invoke();
                }

                return 1;
            }
        }

    label_32:
        return super.dispatchKeyEvent(arg4);
    }

    public final boolean getCanCalculatePosition() {
        return this.canCalculatePosition$delegate.getValue().booleanValue();
    }

    private final Function2 getContent() {
        return this.content$delegate.getValue();
    }

    public final WindowManager$LayoutParams getParams$ui() {
        return this.params;
    }

    public static void getParams$ui$annotations() {
    }

    private final LayoutCoordinates getParentLayoutCoordinates() {
        return this.parentLayoutCoordinates$delegate.getValue();
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    public final IntSize getPopupContentSize-bOM6tXw() {
        return this.popupContentSize$delegate.getValue();
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    public final String getTestTag() {
        return this.testTag;
    }

    private final IntRect getVisibleDisplayBounds() {
        Rect v0 = this.previousWindowVisibleFrame;
        this.popupLayoutHelper.getWindowVisibleDisplayFrame(this.composeView, v0);
        return AndroidPopup_androidKt.toIntBounds(v0);
    }

    public void internalOnLayout$ui(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.internalOnLayout$ui(arg1, arg2, arg3, arg4, arg5);
        if(!this.properties.getUsePlatformDefaultWidth()) {
            View v1 = this.getChildAt(0);
            if(v1 == null) {
            }
            else {
                this.params.width = v1.getMeasuredWidth();
                this.params.height = v1.getMeasuredHeight();
                this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
            }
        }
    }

    public void internalOnMeasure$ui(int arg2, int arg3) {
        if(this.properties.getUsePlatformDefaultWidth()) {
            super.internalOnMeasure$ui(arg2, arg3);
            return;
        }

        IntRect v2 = this.getVisibleDisplayBounds();
        super.internalOnMeasure$ui(View$MeasureSpec.makeMeasureSpec(v2.getWidth(), 0x80000000), View$MeasureSpec.makeMeasureSpec(v2.getHeight(), 0x80000000));
    }

    private final void maybeRegisterBackCallback() {
        if(this.properties.getDismissOnBackPress()) {
            if(Build$VERSION.SDK_INT < 33) {
            }
            else {
                if(this.backCallback == null) {
                    this.backCallback = Api33Impl.createBackCallback(this.onDismissRequest);
                }

                Api33Impl.maybeRegisterBackCallback(this, this.backCallback);
            }
        }
    }

    private final void maybeUnregisterBackCallback() {
        if(Build$VERSION.SDK_INT >= 33) {
            Api33Impl.maybeUnregisterBackCallback(this, this.backCallback);
        }

        this.backCallback = null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotStateObserver.start();
        this.maybeRegisterBackCallback();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotStateObserver.stop();
        this.snapshotStateObserver.clear();
        this.maybeUnregisterBackCallback();
    }

    public boolean onTouchEvent(MotionEvent arg5) {
        Function0 v4;
        if(!this.properties.getDismissOnClickOutside()) {
            return super.onTouchEvent(arg5);
        }

        if(arg5 != null && arg5.getAction() == 0 && (arg5.getX() < 0f || arg5.getX() >= (((float)this.getWidth())) || arg5.getY() < 0f || arg5.getY() >= (((float)this.getHeight())))) {
            v4 = this.onDismissRequest;
            if(v4 != null) {
                v4.invoke();
            }

            return 1;
        }

        if(arg5 != null && arg5.getAction() == 4) {
            v4 = this.onDismissRequest;
            if(v4 != null) {
                v4.invoke();
            }

            return 1;
        }

        return super.onTouchEvent(arg5);
    }

    public final void pollForLocationOnScreenChange() {
        if(!this.isAttachedToWindow()) {
        }
        else {
            int[] v0 = this.locationOnScreen;
            int v2 = v0[0];
            int v4 = v0[1];
            this.composeView.getLocationOnScreen(v0);
            v0 = this.locationOnScreen;
            if(v2 == v0[0]) {
                if(v4 != v0[1]) {
                }
                else {
                    return;
                }
            }

            goto label_17;
        }

        return;
    label_17:
        this.updateParentBounds$ui();
    }

    public final void setContent(CompositionContext arg1, Function2 arg2) {
        this.setParentCompositionContext(arg1);
        this.setContent(arg2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    private final void setContent(Function2 arg1) {
        this.content$delegate.setValue(arg1);
    }

    public void setLayoutDirection(int arg1) {
    }

    private final void setParentLayoutCoordinates(LayoutCoordinates arg1) {
        this.parentLayoutCoordinates$delegate.setValue(arg1);
    }

    public final void setParentLayoutDirection(LayoutDirection arg1) {
        this.parentLayoutDirection = arg1;
    }

    public final void setPopupContentSize-fhxjrPA(IntSize arg1) {
        this.popupContentSize$delegate.setValue(arg1);
    }

    public final void setPositionProvider(PopupPositionProvider arg1) {
        this.positionProvider = arg1;
    }

    public final void setTestTag(String arg1) {
        this.testTag = arg1;
    }

    public final void show() {
        this.windowManager.addView(this, this.params);
    }

    private final void superSetLayoutDirection(LayoutDirection arg3) {
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
        int v0 = 1;
        if(v3 == 1) {
            v0 = 0;
        }
        else if(v3 == 2) {
        }
        else {
            throw new NoWhenBranchMatchedException();
        }

        super.setLayoutDirection(v0);
    }

    public final void updateParameters(Function0 arg1, PopupProperties arg2, String arg3, LayoutDirection arg4) {
        this.onDismissRequest = arg1;
        this.testTag = arg3;
        this.updatePopupProperties(arg2);
        this.superSetLayoutDirection(arg4);
    }

    public final void updateParentBounds$ui() {
        LayoutCoordinates v0 = this.getParentLayoutCoordinates();
        if(v0 != null) {
            if(v0.isAttached()) {
            }
            else {
                v0 = null;
            }

            if(v0 == null) {
                return;
            }

            long v1 = v0.getSize-YbymL2g();
            long v3 = this.isNested ? LayoutCoordinatesKt.positionOnScreen(v0) : LayoutCoordinatesKt.positionInWindow(v0);
            IntRect v0_1 = IntRectKt.IntRect-VbeCjmY(IntOffset.constructor-impl((((long)Math.round(Float.intBitsToFloat(((int)(v3 >> 0x20)))))) << 0x20 | 0xFFFFFFFFL & (((long)Math.round(Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL))))))), v1);
            if(Intrinsics.areEqual(v0_1, this.parentBounds)) {
                return;
            }

            this.parentBounds = v0_1;
            this.updatePosition();
        }
    }

    public final void updateParentLayoutCoordinates(LayoutCoordinates arg1) {
        this.setParentLayoutCoordinates(arg1);
        this.updateParentBounds$ui();
    }

    private final void updatePopupProperties(PopupProperties arg3) {
        if(Intrinsics.areEqual(this.properties, arg3)) {
            return;
        }

        if((arg3.getUsePlatformDefaultWidth()) && !this.properties.getUsePlatformDefaultWidth()) {
            this.params.width = -2;
            this.params.height = -2;
        }

        this.properties = arg3;
        this.params.flags = AndroidPopup_androidKt.flagsWithSecureFlagInherited(arg3, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
    }

    public final void updatePosition() {
        IntRect v3 = this.parentBounds;
        if(v3 == null) {
        }
        else {
            IntSize v0 = this.getPopupContentSize-bOM6tXw();
            if(v0 != null) {
                long v6 = v0.unbox-impl();
                IntRect v0_1 = this.getVisibleDisplayBounds();
                int v8 = 0x20;
                long v9 = 0xFFFFFFFFL;
                long v4 = IntSize.constructor-impl((((long)v0_1.getWidth())) << v8 | (((long)v0_1.getHeight())) & v9);
                LongRef v1 = new LongRef();
                v1.element = IntOffset.Companion.getZero-nOcc-ac();
                PopupLayout v2 = this;
                this.snapshotStateObserver.observeReads(v2, PopupLayout.onCommitAffectingPopupPosition, new PopupLayout$updatePosition$1(v1, v2, v3, v4, v6));
                v2.params.x = IntOffset.getX-impl(v1.element);
                v2.params.y = IntOffset.getY-impl(v1.element);
                if(v2.properties.getExcludeFromSystemGesture()) {
                    v2.popupLayoutHelper.setGestureExclusionRects(v2, ((int)(v4 >> v8)), ((int)(v4 & v9)));
                }

                v2.popupLayoutHelper.updateViewLayout(v2.windowManager, v2, v2.params);
            }
        }
    }
}

