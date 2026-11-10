package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region$Op;
import android.graphics.Region;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u0000 º\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002º\u0001B9\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000E\u0010\u0016\u001A\n\u0018\u00010\u000Fj\u0004\u0018\u0001`\u0017J\b\u0010d\u001A\u00020eH\u0016J\b\u0010f\u001A\u00020\u001AH\u0016J\b\u0010g\u001A\u00020\u001AH\u0016J\b\u0010h\u001A\u00020\u001AH\u0016J\u0018\u0010i\u001A\u00020\u001A2\u0006\u0010j\u001A\u00020\u000B2\u0006\u0010k\u001A\u00020\u000BH\u0014J\u0006\u0010l\u001A\u00020\u001AJ0\u0010m\u001A\u00020\u001A2\u0006\u0010n\u001A\u00020!2\u0006\u0010o\u001A\u00020\u000B2\u0006\u0010p\u001A\u00020\u000B2\u0006\u0010q\u001A\u00020\u000B2\u0006\u0010r\u001A\u00020\u000BH\u0014J\n\u0010s\u001A\u0004\u0018\u00010tH\u0016J\u0010\u0010u\u001A\u00020\u001A2\u0006\u0010v\u001A\u00020!H\u0016J\b\u0010w\u001A\u00020\u001AH\u0014J\b\u0010x\u001A\u00020\u001AH\u0014J\u001E\u0010y\u001A\u0004\u0018\u00010z2\b\u0010\\\u001A\u0004\u0018\u00010J2\b\u0010{\u001A\u0004\u0018\u00010|H\u0016J\u0018\u0010}\u001A\u00020\u001A2\u0006\u0010~\u001A\u00020\u000F2\u0006\u0010\u007F\u001A\u00020\u000FH\u0016J%\u0010\u0080\u0001\u001A\u00020!2\u0006\u0010~\u001A\u00020\u000F2\t\u0010\u0081\u0001\u001A\u0004\u0018\u00010|2\u0007\u0010\u0082\u0001\u001A\u00020!H\u0016J\u0007\u0010\u0083\u0001\u001A\u00020\u001AJ\u0012\u0010\u0084\u0001\u001A\u00020\u001A2\u0007\u0010\u0085\u0001\u001A\u00020\u000BH\u0014J\u0015\u0010\u0086\u0001\u001A\u00020!2\n\u0010\u0087\u0001\u001A\u0005\u0018\u00010\u0088\u0001H\u0016J$\u0010\u008D\u0001\u001A\u00020\u000B2\u0007\u0010\u008E\u0001\u001A\u00020\u000B2\u0007\u0010\u008F\u0001\u001A\u00020\u000B2\u0007\u0010\u0090\u0001\u001A\u00020\u000BH\u0002J\t\u0010\u0091\u0001\u001A\u00020!H\u0016J+\u0010\u0092\u0001\u001A\u00020!2\u0006\u0010~\u001A\u00020\u000F2\u0006\u0010\u007F\u001A\u00020\u000F2\u0007\u0010\u0093\u0001\u001A\u00020\u000B2\u0007\u0010\u0094\u0001\u001A\u00020\u000BH\u0016J\t\u0010\u0095\u0001\u001A\u00020\u000BH\u0016J+\u0010\u0096\u0001\u001A\u00020\u001A2\u0006\u0010~\u001A\u00020\u000F2\u0006\u0010\u007F\u001A\u00020\u000F2\u0007\u0010\u0093\u0001\u001A\u00020\u000B2\u0007\u0010\u0094\u0001\u001A\u00020\u000BH\u0016J\u001A\u0010\u0097\u0001\u001A\u00020\u001A2\u0006\u0010\u007F\u001A\u00020\u000F2\u0007\u0010\u0094\u0001\u001A\u00020\u000BH\u0016JG\u0010\u0098\u0001\u001A\u00020\u001A2\u0006\u0010\u007F\u001A\u00020\u000F2\u0007\u0010\u0099\u0001\u001A\u00020\u000B2\u0007\u0010\u009A\u0001\u001A\u00020\u000B2\u0007\u0010\u009B\u0001\u001A\u00020\u000B2\u0007\u0010\u009C\u0001\u001A\u00020\u000B2\u0007\u0010\u0094\u0001\u001A\u00020\u000B2\u0007\u0010\u009D\u0001\u001A\u00020JH\u0016J>\u0010\u0098\u0001\u001A\u00020\u001A2\u0006\u0010\u007F\u001A\u00020\u000F2\u0007\u0010\u0099\u0001\u001A\u00020\u000B2\u0007\u0010\u009A\u0001\u001A\u00020\u000B2\u0007\u0010\u009B\u0001\u001A\u00020\u000B2\u0007\u0010\u009C\u0001\u001A\u00020\u000B2\u0007\u0010\u0094\u0001\u001A\u00020\u000BH\u0016J5\u0010\u009E\u0001\u001A\u00020\u001A2\u0006\u0010\u007F\u001A\u00020\u000F2\u0007\u0010\u009F\u0001\u001A\u00020\u000B2\u0007\u0010 \u0001\u001A\u00020\u000B2\u0007\u0010\u009D\u0001\u001A\u00020J2\u0007\u0010\u0094\u0001\u001A\u00020\u000BH\u0016J.\u0010¡\u0001\u001A\u00020!2\u0006\u0010\u007F\u001A\u00020\u000F2\b\u0010¢\u0001\u001A\u00030£\u00012\b\u0010¤\u0001\u001A\u00030£\u00012\u0007\u0010\u009D\u0001\u001A\u00020!H\u0016J%\u0010¥\u0001\u001A\u00020!2\u0006\u0010\u007F\u001A\u00020\u000F2\b\u0010¢\u0001\u001A\u00030£\u00012\b\u0010¤\u0001\u001A\u00030£\u0001H\u0016J\t\u0010¦\u0001\u001A\u00020!H\u0016J\u001A\u0010§\u0001\u001A\u00020O2\u0007\u0010¨\u0001\u001A\u00020\u000F2\u0006\u0010N\u001A\u00020OH\u0016J\u0011\u0010©\u0001\u001A\u00020O2\u0006\u0010N\u001A\u00020OH\u0002J\u0014\u0010ª\u0001\u001A\u00030«\u00012\b\u0010¬\u0001\u001A\u00030«\u0001H\u0002J\u008E\u0001\u0010­\u0001\u001A\u0003H®\u0001\"\u0005\b\u0000\u0010®\u00012\u0007\u0010\u0018\u001A\u0003H®\u00012k\u0010¯\u0001\u001Af\u0012\u0015\u0012\u00130\u000B¢\u0006\u000E\b±\u0001\u0012\t\b²\u0001\u0012\u0004\b\b(o\u0012\u0015\u0012\u00130\u000B¢\u0006\u000E\b±\u0001\u0012\t\b²\u0001\u0012\u0004\b\b(p\u0012\u0015\u0012\u00130\u000B¢\u0006\u000E\b±\u0001\u0012\t\b²\u0001\u0012\u0004\b\b(q\u0012\u0015\u0012\u00130\u000B¢\u0006\u000E\b±\u0001\u0012\t\b²\u0001\u0012\u0004\b\b(r\u0012\u0005\u0012\u0003H®\u00010°\u0001H\u0082\b¢\u0006\u0003\u0010³\u0001J3\u0010´\u0001\u001A\u00030µ\u0001*\u00030µ\u00012\u0007\u0010¶\u0001\u001A\u00020\u000B2\u0007\u0010·\u0001\u001A\u00020\u000B2\u0007\u0010¸\u0001\u001A\u00020\u000B2\u0007\u0010¹\u0001\u001A\u00020\u000BH\u0002R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00192\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019@DX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u000E\u0010 \u001A\u00020!X\u0082\u000E¢\u0006\u0002\n\u0000R0\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00192\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019@DX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u001D\"\u0004\b$\u0010\u001FR0\u0010%\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00192\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019@DX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u001D\"\u0004\b\'\u0010\u001FR$\u0010)\u001A\u00020(2\u0006\u0010\u0018\u001A\u00020(@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010.\u001A\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001A\u0018\u00010/X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001A\u0002042\u0006\u0010\u0018\u001A\u000204@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010:\u001A\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001A\u0018\u00010/X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b;\u00101\"\u0004\b<\u00103R(\u0010>\u001A\u0004\u0018\u00010=2\b\u0010\u0018\u001A\u0004\u0018\u00010=@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR(\u0010D\u001A\u0004\u0018\u00010C2\b\u0010\u0018\u001A\u0004\u0018\u00010C@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000E\u0010I\u001A\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001A\u00020LX\u0082\u000E¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010N\u001A\u0004\u0018\u00010OX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010P\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010Q\u0012\u0004\u0012\u00020\u001A\u0018\u00010/j\u0004\u0018\u0001`RX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010S\u001A\u00020T8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bU\u0010VR\u0014\u0010W\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010X\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010Y\u001A\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001A\u0018\u00010/X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bZ\u00101\"\u0004\b[\u00103R\u000E\u0010\\\u001A\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010]\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010^\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010_\u001A\u00020`X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010a\u001A\u00020!X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010b\u001A\u00020!8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bb\u0010cR\u0015\u0010\u0089\u0001\u001A\u00030\u008A\u0001¢\u0006\n\n\u0000\u001A\u0006\b\u008B\u0001\u0010\u008C\u0001¨\u0006»\u0001"}, d2={"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHash", "", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "view", "Landroid/view/View;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;ILandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroid/view/View;Landroidx/compose/ui/node/Owner;)V", "getView", "()Landroid/view/View;", "getInteropView", "Landroidx/compose/ui/viewinterop/InteropView;", "value", "Lkotlin/Function0;", "", "update", "getUpdate", "()Lkotlin/jvm/functions/Function0;", "setUpdate", "(Lkotlin/jvm/functions/Function0;)V", "hasUpdateBlock", "", "reset", "getReset", "setReset", "release", "getRelease", "setRelease", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "onModifierChanged", "Lkotlin/Function1;", "getOnModifierChanged$ui", "()Lkotlin/jvm/functions/Function1;", "setOnModifierChanged$ui", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "onDensityChanged", "getOnDensityChanged$ui", "setOnDensityChanged$ui", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "position", "", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "insets", "Landroidx/core/view/WindowInsetsCompat;", "bringIntoViewRequester", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/viewinterop/BringIntoViewRequester;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "runUpdate", "runInvalidate", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui", "setOnRequestDisallowInterceptTouchEvent$ui", "location", "lastWidthMeasureSpec", "lastHeightMeasureSpec", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "isDrawing", "isValidOwnerScope", "()Z", "getAccessibilityClassName", "", "onReuse", "onDeactivate", "onRelease", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "remeasure", "onLayout", "changed", "l", "t", "r", "b", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "requestDisallowInterceptTouchEvent", "disallowIntercept", "onAttachedToWindow", "onDetachedFromWindow", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "onDescendantInvalidated", "child", "target", "requestChildRectangleOnScreen", "rectangle", "immediate", "invalidateOrDefer", "onWindowVisibilityChanged", "visibility", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "obtainMeasureSpec", "min", "max", "preferred", "shouldDelayChildPressedState", "onStartNestedScroll", "axes", "type", "getNestedScrollAxes", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "consumed", "onNestedPreScroll", "dx", "dy", "onNestedFling", "velocityX", "", "velocityY", "onNestedPreFling", "isNestedScrollingEnabled", "onApplyWindowInsets", "v", "insetToLayoutPosition", "insetBounds", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "insetValue", "T", "block", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "inset", "Landroidx/core/graphics/Insets;", "left", "top", "right", "bottom", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public class AndroidViewHolder extends ViewGroup implements ComposeNodeLifecycleCallback, OwnerScope, NestedScrollingParent3, OnApplyWindowInsetsListener {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/ui/viewinterop/AndroidViewHolder$Companion;", "", "<init>", "()V", "OnCommitAffectingUpdate", "Lkotlin/Function1;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Function1 OnCommitAffectingUpdate;
    private Function1 bringIntoViewRequester;
    private final int compositeKeyHash;
    private Density density;
    private final NestedScrollDispatcher dispatcher;
    private boolean hasUpdateBlock;
    private WindowInsetsCompat insets;
    private boolean isDrawing;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    private Function1 onDensityChanged;
    private Function1 onModifierChanged;
    private Function1 onRequestDisallowInterceptTouchEvent;
    private final Owner owner;
    private final int[] position;
    private Function0 release;
    private Function0 reset;
    private final Function0 runInvalidate;
    private final Function0 runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    private long size;
    private Function0 update;
    private final View view;

    static {
        AndroidViewHolder.Companion = new Companion(null);
        AndroidViewHolder.$stable = 8;
        AndroidViewHolder.OnCommitAffectingUpdate = AndroidViewHolder$Companion$OnCommitAffectingUpdate$1.INSTANCE;
    }

    public AndroidViewHolder(Context arg1, CompositionContext arg2, int arg3, NestedScrollDispatcher arg4, View arg5, Owner arg6) {
        super(arg1);
        this.compositeKeyHash = arg3;
        this.dispatcher = arg4;
        this.view = arg5;
        this.owner = arg6;
        if(arg2 != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, arg2);
        }

        this.setSaveFromParentEnabled(false);
        this.addView(arg5);
        ViewCompat.setWindowInsetsAnimationCallback(this, new Callback() {
            public WindowInsetsCompat onProgress(WindowInsetsCompat arg1, List arg2) {
                return AndroidViewHolder.access$insetToLayoutPosition(AndroidViewHolder.this, arg1);
            }

            public BoundsCompat onStart(WindowInsetsAnimationCompat arg1, BoundsCompat arg2) {
                return AndroidViewHolder.access$insetBounds(AndroidViewHolder.this, arg2);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(this, this);
        this.update = AndroidViewHolder$update$1.INSTANCE;
        this.reset = AndroidViewHolder$reset$1.INSTANCE;
        this.release = AndroidViewHolder$release$1.INSTANCE;
        this.modifier = Modifier.Companion;
        this.density = DensityKt.Density$default(1f, 0f, 2, null);
        this.position = new int[2];
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.runUpdate = new AndroidViewHolder$runUpdate$1(this);
        this.runInvalidate = new AndroidViewHolder$runInvalidate$1(this);
        this.location = new int[2];
        this.lastWidthMeasureSpec = 0x80000000;
        this.lastHeightMeasureSpec = 0x80000000;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        LayoutNode v2 = new LayoutNode(false, 0, 3, null);
        v2.setInteropViewFactoryHolder$ui(this);
        Modifier v1 = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll(Modifier.Companion, AndroidViewHolder_androidKt.access$getNoOpScrollConnection$p(), this.dispatcher), true, AndroidViewHolder$layoutNode$1$coreModifier$1.INSTANCE), this), new AndroidViewHolder$layoutNode$1$coreModifier$2(this, v2, this)), new AndroidViewHolder$layoutNode$1$coreModifier$3(this, v2)).then(new BringIntoViewElement(new AndroidViewHolder$layoutNode$1$coreModifier$4(this)));
        v2.setCompositeKeyHash(this.compositeKeyHash);
        v2.setModifier(this.modifier.then(v1));
        this.onModifierChanged = new AndroidViewHolder$layoutNode$1$1(v2, v1);
        v2.setDensity(this.density);
        this.onDensityChanged = new AndroidViewHolder$layoutNode$1$2(v2);
        v2.setOnAttach$ui(new AndroidViewHolder$layoutNode$1$3(this, v2));
        v2.setOnDetach$ui(new AndroidViewHolder$layoutNode$1$4(this));
        v2.setMeasurePolicy(new AndroidViewHolder$layoutNode$1$5(this, v2));
        this.layoutNode = v2;
    }

    public static final NestedScrollDispatcher access$getDispatcher$p(AndroidViewHolder arg0) {
        return arg0.dispatcher;
    }

    public static final boolean access$getHasUpdateBlock$p(AndroidViewHolder arg0) {
        return arg0.hasUpdateBlock;
    }

    public static final WindowInsetsCompat access$getInsets$p(AndroidViewHolder arg0) {
        return arg0.insets;
    }

    public static final Function1 access$getOnCommitAffectingUpdate$cp() {
        return AndroidViewHolder.OnCommitAffectingUpdate;
    }

    public static final Owner access$getOwner$p(AndroidViewHolder arg0) {
        return arg0.owner;
    }

    public static final int[] access$getPosition$p(AndroidViewHolder arg0) {
        return arg0.position;
    }

    public static final Function0 access$getRunUpdate$p(AndroidViewHolder arg0) {
        return arg0.runUpdate;
    }

    public static final long access$getSize$p(AndroidViewHolder arg2) {
        return arg2.size;
    }

    public static final OwnerSnapshotObserver access$getSnapshotObserver(AndroidViewHolder arg0) {
        return arg0.getSnapshotObserver();
    }

    public static final BoundsCompat access$insetBounds(AndroidViewHolder arg0, BoundsCompat arg1) {
        return arg0.insetBounds(arg1);
    }

    public static final WindowInsetsCompat access$insetToLayoutPosition(AndroidViewHolder arg0, WindowInsetsCompat arg1) {
        return arg0.insetToLayoutPosition(arg1);
    }

    public static final int access$obtainMeasureSpec(AndroidViewHolder arg0, int arg1, int arg2, int arg3) {
        return arg0.obtainMeasureSpec(arg1, arg2, arg3);
    }

    public static final void access$setBringIntoViewRequester$p(AndroidViewHolder arg0, Function1 arg1) {
        arg0.bringIntoViewRequester = arg1;
    }

    public static final void access$setDrawing$p(AndroidViewHolder arg0, boolean arg1) {
        arg0.isDrawing = arg1;
    }

    public static final void access$setSize$p(AndroidViewHolder arg0, long arg1) {
        arg0.size = arg1;
    }

    public boolean gatherTransparentRegion(Region arg10) {
        if(arg10 == null) {
            return 1;
        }

        this.getLocationInWindow(this.location);
        arg10.op(this.location[0], this.location[1], this.location[0] + this.getWidth(), this.location[1] + this.getHeight(), Region$Op.DIFFERENCE);
        return 1;
    }

    public CharSequence getAccessibilityClassName() {
        return this.getClass().getName();
    }

    public final Density getDensity() {
        return this.density;
    }

    public final View getInteropView() {
        return this.view;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public ViewGroup$LayoutParams getLayoutParams() {
        ViewGroup$LayoutParams v1 = this.view.getLayoutParams();
        if(v1 == null) {
            v1 = new ViewGroup$LayoutParams(-1, -1);
        }

        return v1;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    public final Function1 getOnDensityChanged$ui() {
        return this.onDensityChanged;
    }

    public final Function1 getOnModifierChanged$ui() {
        return this.onModifierChanged;
    }

    public final Function1 getOnRequestDisallowInterceptTouchEvent$ui() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final Function0 getRelease() {
        return this.release;
    }

    public final Function0 getReset() {
        return this.reset;
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        if(!this.isAttachedToWindow()) {
            InlineClassHelperKt.throwIllegalStateException("Expected AndroidViewHolder to be attached when observing reads.");
        }

        return this.owner.getSnapshotObserver();
    }

    public final Function0 getUpdate() {
        return this.update;
    }

    public final View getView() {
        return this.view;
    }

    private final Insets inset(Insets arg2, int arg3, int arg4, int arg5, int arg6) {
        int v1 = arg2.left - arg3;
        arg3 = 0;
        if(v1 < 0) {
            v1 = 0;
        }

        int v0 = arg2.top - arg4;
        if(v0 < 0) {
            v0 = 0;
        }

        arg4 = arg2.right - arg5;
        if(arg4 < 0) {
            arg4 = 0;
        }

        int v2 = arg2.bottom - arg6;
        if(v2 < 0) {
        }
        else {
            arg3 = v2;
        }

        return Insets.of(v1, v0, arg4, arg3);
    }

    private final BoundsCompat insetBounds(BoundsCompat arg17) {
        int v4;
        int v3_1;
        int v6;
        int v5;
        AndroidViewHolder v0 = this;
        NodeCoordinator v1 = v0.layoutNode.getInnerCoordinator$ui();
        if(!v1.isAttached()) {
        }
        else {
            NodeCoordinator v2 = v1;
            long v3 = IntOffsetKt.round-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(((LayoutCoordinates)v2)));
            v5 = IntOffset.getX-impl(v3);
            v6 = 0;
            if(v5 < 0) {
                v5 = 0;
            }

            v3_1 = IntOffset.getY-impl(v3);
            if(v3_1 < 0) {
                v3_1 = 0;
            }

            long v7 = LayoutCoordinatesKt.findRootCoordinates(((LayoutCoordinates)v2)).getSize-YbymL2g();
            v4 = ((int)(v7 >> 0x20));
            int v7_1 = ((int)(v7 & 0xFFFFFFFFL));
            long v11 = v1.getSize-YbymL2g();
            long v1_1 = IntOffsetKt.round-k-4lQ0M(v1.localToRoot-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)(((int)(v11 & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)(((int)(v11 >> 0x20))))))) << 0x20)));
            v4 -= IntOffset.getX-impl(v1_1);
            if(v4 < 0) {
                v4 = 0;
            }

            v7_1 -= IntOffset.getY-impl(v1_1);
            if(v7_1 < 0) {
            }
            else {
                v6 = v7_1;
            }

            if(v5 == 0 && v3_1 == 0 && v4 == 0 && v6 == 0) {
                return arg17;
            }

            goto label_55;
        }

        return arg17;
    label_55:
        return new BoundsCompat(v0.inset(arg17.getLowerBound(), v5, v3_1, v4, v6), this.inset(arg17.getUpperBound(), v5, v3_1, v4, v6));
    }

    private final WindowInsetsCompat insetToLayoutPosition(WindowInsetsCompat arg15) {
        int v2;
        int v1_1;
        int v4;
        int v3;
        if(!arg15.hasInsets()) {
        }
        else {
            NodeCoordinator v14 = this.layoutNode.getInnerCoordinator$ui();
            if(!v14.isAttached()) {
            }
            else {
                NodeCoordinator v0 = v14;
                long v1 = IntOffsetKt.round-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(((LayoutCoordinates)v0)));
                v3 = IntOffset.getX-impl(v1);
                v4 = 0;
                if(v3 < 0) {
                    v3 = 0;
                }

                v1_1 = IntOffset.getY-impl(v1);
                if(v1_1 < 0) {
                    v1_1 = 0;
                }

                long v5 = LayoutCoordinatesKt.findRootCoordinates(((LayoutCoordinates)v0)).getSize-YbymL2g();
                v2 = ((int)(v5 >> 0x20));
                int v5_1 = ((int)(v5 & 0xFFFFFFFFL));
                long v9 = v14.getSize-YbymL2g();
                long v6 = IntOffsetKt.round-k-4lQ0M(v14.localToRoot-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)(((int)(v9 & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)(((int)(v9 >> 0x20))))))) << 0x20)));
                v2 -= IntOffset.getX-impl(v6);
                if(v2 < 0) {
                    v2 = 0;
                }

                v5_1 -= IntOffset.getY-impl(v6);
                if(v5_1 < 0) {
                }
                else {
                    v4 = v5_1;
                }

                if(v3 == 0 && v1_1 == 0 && v2 == 0 && v4 == 0) {
                    return arg15;
                }

                goto label_57;
            }
        }

        return arg15;
    label_57:
        return arg15.inset(v3, v1_1, v2, v4);
    }

    private final Object insetValue(Object arg15, Function4 arg16) {
        int v2;
        int v1_1;
        int v4;
        int v3;
        NodeCoordinator v14 = this.layoutNode.getInnerCoordinator$ui();
        if(!v14.isAttached()) {
        }
        else {
            NodeCoordinator v0 = v14;
            long v1 = IntOffsetKt.round-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(((LayoutCoordinates)v0)));
            v3 = IntOffset.getX-impl(v1);
            v4 = 0;
            if(v3 < 0) {
                v3 = 0;
            }

            v1_1 = IntOffset.getY-impl(v1);
            if(v1_1 < 0) {
                v1_1 = 0;
            }

            long v5 = LayoutCoordinatesKt.findRootCoordinates(((LayoutCoordinates)v0)).getSize-YbymL2g();
            v2 = ((int)(v5 >> 0x20));
            int v5_1 = ((int)(v5 & 0xFFFFFFFFL));
            long v9 = v14.getSize-YbymL2g();
            long v6 = IntOffsetKt.round-k-4lQ0M(v14.localToRoot-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)(((int)(v9 & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)(((int)(v9 >> 0x20))))))) << 0x20)));
            v2 -= IntOffset.getX-impl(v6);
            if(v2 < 0) {
                v2 = 0;
            }

            v5_1 -= IntOffset.getY-impl(v6);
            if(v5_1 < 0) {
            }
            else {
                v4 = v5_1;
            }

            if(v3 == 0 && v1_1 == 0 && v2 == 0 && v4 == 0) {
                return arg15;
            }

            goto label_54;
        }

        return arg15;
    label_54:
        return arg16.invoke(Integer.valueOf(v3), Integer.valueOf(v1_1), Integer.valueOf(v2), Integer.valueOf(v4));
    }

    public ViewParent invalidateChildInParent(int[] arg1, Rect arg2) {
        super.invalidateChildInParent(arg1, arg2);
        this.invalidateOrDefer();
        return null;
    }

    public final void invalidateOrDefer() {
        if(this.isDrawing) {
            this.view.postOnAnimation(new AndroidViewHolder$$ExternalSyntheticLambda0(this.runInvalidate));
            return;
        }

        this.layoutNode.invalidateLayer$ui();
    }

    static final void invalidateOrDefer$lambda$0(Function0 arg0) {
        arg0.invoke();
    }

    public boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    public boolean isValidOwnerScope() {
        return this.isAttachedToWindow();
    }

    private final int obtainMeasureSpec(int arg2, int arg3, int arg4) {
        int v1 = 0x40000000;
        if(arg4 < 0) {
            if(arg2 == arg3) {
            }
            else {
                int v0 = 0x7FFFFFFF;
                if(arg4 == -2 && arg3 != v0) {
                    return View$MeasureSpec.makeMeasureSpec(arg3, 0x80000000);
                }

                if(arg4 == -1 && arg3 != v0) {
                    return View$MeasureSpec.makeMeasureSpec(arg3, v1);
                }

                return View$MeasureSpec.makeMeasureSpec(0, 0);
            }
        }

        return View$MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(arg4, arg2, arg3), v1);
    }

    public WindowInsetsCompat onApplyWindowInsets(View arg1, WindowInsetsCompat arg2) {
        this.insets = new WindowInsetsCompat(arg2);
        return this.insetToLayoutPosition(arg2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.runUpdate.invoke();
    }

    public void onDeactivate() {
        this.reset.invoke();
        this.removeAllViewsInLayout();
    }

    public void onDescendantInvalidated(View arg1, View arg2) {
        super.onDescendantInvalidated(arg1, arg2);
        this.invalidateOrDefer();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getSnapshotObserver().clear$ui(this);
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        this.view.layout(0, 0, arg4 - arg2, arg5 - arg3);
    }

    protected void onMeasure(int arg3, int arg4) {
        if(this.view.getParent() != this) {
            this.setMeasuredDimension(View$MeasureSpec.getSize(arg3), View$MeasureSpec.getSize(arg4));
            return;
        }

        if(this.view.getVisibility() == 8) {
            this.setMeasuredDimension(0, 0);
            return;
        }

        this.view.measure(arg3, arg4);
        this.setMeasuredDimension(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
        this.lastWidthMeasureSpec = arg3;
        this.lastHeightMeasureSpec = arg4;
    }

    public boolean onNestedFling(View arg14, float arg15, float arg16, boolean arg17) {
        if(!this.isNestedScrollingEnabled()) {
            return 0;
        }

        BuildersKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AndroidViewHolder$onNestedFling$1(arg17, this, VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(arg15), AndroidViewHolder_androidKt.access$toComposeVelocity(arg16)), null), 3, null);
        return 0;
    }

    public boolean onNestedPreFling(View arg8, float arg9, float arg10) {
        if(!this.isNestedScrollingEnabled()) {
            return 0;
        }

        BuildersKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AndroidViewHolder$onNestedPreFling$1(this, VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(arg9), AndroidViewHolder_androidKt.access$toComposeVelocity(arg10)), null), 3, null);
        return 0;
    }

    public void onNestedPreScroll(View arg5, int arg6, int arg7, int[] arg8, int arg9) {
        if(!this.isNestedScrollingEnabled()) {
            return;
        }

        long v4 = this.dispatcher.dispatchPreScroll-OzD1aCk(Offset.constructor-impl((((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg7)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg6)))) << 0x20), AndroidViewHolder_androidKt.access$toNestedScrollSource(arg9));
        arg8[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(v4 >> 0x20))));
        arg8[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(v4 & 0xFFFFFFFFL))));
    }

    public void onNestedScroll(View arg7, int arg8, int arg9, int arg10, int arg11, int arg12) {
        if(!this.isNestedScrollingEnabled()) {
            return;
        }

        this.dispatcher.dispatchPostScroll-DzOQY0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg9)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg8)))) << 0x20), Offset.constructor-impl((((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg11)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg10)))) << 0x20), AndroidViewHolder_androidKt.access$toNestedScrollSource(arg12));
    }

    public void onNestedScroll(View arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int[] arg16) {
        if(!this.isNestedScrollingEnabled()) {
            return;
        }

        long v9 = this.dispatcher.dispatchPostScroll-DzOQY0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg12)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg11)))) << 0x20), Offset.constructor-impl((((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg14)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(AndroidViewHolder_androidKt.access$toComposeOffset(arg13)))) << 0x20), AndroidViewHolder_androidKt.access$toNestedScrollSource(arg15));
        arg16[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(v9 >> 0x20))));
        arg16[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Float.intBitsToFloat(((int)(v9 & 0xFFFFFFFFL))));
    }

    public void onNestedScrollAccepted(View arg1, View arg2, int arg3, int arg4) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(arg1, arg2, arg3, arg4);
    }

    public void onRelease() {
        this.release.invoke();
    }

    public void onReuse() {
        if(this.view.getParent() != this) {
            this.addView(this.view);
            return;
        }

        this.reset.invoke();
    }

    public boolean onStartNestedScroll(View arg1, View arg2, int arg3, int arg4) {
        if((arg3 & 2) == 0) {
            if((arg3 & 1) != 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void onStopNestedScroll(View arg1, int arg2) {
        this.nestedScrollingParentHelper.onStopNestedScroll(arg1, arg2);
    }

    protected void onWindowVisibilityChanged(int arg1) {
        super.onWindowVisibilityChanged(arg1);
    }

    public final void remeasure() {
        int v0 = this.lastWidthMeasureSpec;
        int v1 = 0x80000000;
        if(v0 != v1) {
            int v2 = this.lastHeightMeasureSpec;
            if(v2 == v1) {
            }
            else {
                this.measure(v0, v2);
            }
        }
    }

    public boolean requestChildRectangleOnScreen(View arg1, Rect arg2, boolean arg3) {
        androidx.compose.ui.geometry.Rect v1;
        Function1 v0 = this.bringIntoViewRequester;
        if(v0 != null) {
            if(arg2 != null) {
                v1 = RectHelper_androidKt.toComposeRect(arg2);
            }
            else {
                Object v1_1 = null;
            }

            v0.invoke(v1);
        }

        return 1;
    }

    public void requestDisallowInterceptTouchEvent(boolean arg3) {
        Function1 v0 = this.onRequestDisallowInterceptTouchEvent;
        if(v0 != null) {
            v0.invoke(Boolean.valueOf(arg3));
        }

        super.requestDisallowInterceptTouchEvent(arg3);
    }

    public final void setDensity(Density arg2) {
        if(arg2 != this.density) {
            this.density = arg2;
            Function1 v1 = this.onDensityChanged;
            if(v1 != null) {
                v1.invoke(arg2);
            }
        }
    }

    public final void setLifecycleOwner(LifecycleOwner arg2) {
        if(arg2 != this.lifecycleOwner) {
            this.lifecycleOwner = arg2;
            ViewTreeLifecycleOwner.set(((View)this), arg2);
        }
    }

    public final void setModifier(Modifier arg2) {
        if(arg2 != this.modifier) {
            this.modifier = arg2;
            Function1 v1 = this.onModifierChanged;
            if(v1 != null) {
                v1.invoke(arg2);
            }
        }
    }

    public final void setOnDensityChanged$ui(Function1 arg1) {
        this.onDensityChanged = arg1;
    }

    public final void setOnModifierChanged$ui(Function1 arg1) {
        this.onModifierChanged = arg1;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui(Function1 arg1) {
        this.onRequestDisallowInterceptTouchEvent = arg1;
    }

    protected final void setRelease(Function0 arg1) {
        this.release = arg1;
    }

    protected final void setReset(Function0 arg1) {
        this.reset = arg1;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner arg2) {
        if(arg2 != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = arg2;
            ViewTreeSavedStateRegistryOwner.set(((View)this), arg2);
        }
    }

    protected final void setUpdate(Function0 arg1) {
        this.update = arg1;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public boolean shouldDelayChildPressedState() {
        return 1;
    }
}

