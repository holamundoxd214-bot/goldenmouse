package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.StrictMode$VmPolicy;
import android.os.StrictMode;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent$PointerCoords;
import android.view.MotionEvent$PointerProperties;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import android.view.ViewTreeObserver$OnTouchModeChangeListener;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.retain.ForgetfulRetainedValuesStore;
import androidx.compose.runtime.retain.RetainedValuesStore;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.R$id;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.autofill.PlatformAutofillManagerImpl;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusOwnerImplKt;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.focus.PlatformFocusOwner;
import androidx.compose.ui.focus.TwoDimensionalFocusSearchKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent_androidKt;
import androidx.compose.ui.input.indirect.IndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.InsetsListener;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.layout.WindowInsetsRulerProvider;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNode$UsageByParent;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner$OnLayoutCompletedListener;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.RootForTest$UncaughtExceptionHandler;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$NewInstanceFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000¢\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001D*\u0002Ù\u0002\b\u0001\u0018\u0000 ÿ\u00042\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000B:\u0006ÿ\u0004\u0080\u0005\u0081\u0005B\u0017\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010M\u001A\u00020NH\u0016J\u0017\u0010^\u001A\u00020\u00162\u0006\u0010_\u001A\u00020`H\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001A\u00020\u00162\u0006\u0010_\u001A\u00020`H\u0002¢\u0006\u0004\bd\u0010bJ\u0017\u0010e\u001A\u00020\u00162\u0006\u0010_\u001A\u00020`H\u0002¢\u0006\u0004\bf\u0010bJ\u0017\u0010g\u001A\u00020\u00162\u0006\u0010_\u001A\u00020`H\u0016¢\u0006\u0004\bh\u0010bJ\u0019\u0010i\u001A\u0004\u0018\u00010$2\u0006\u0010_\u001A\u00020`H\u0002¢\u0006\u0004\bj\u0010kJ\n\u0010l\u001A\u0004\u0018\u00010mH\u0016J\b\u0010n\u001A\u000207H\u0016J\u0012\u0010o\u001A\u0004\u0018\u00010$2\u0006\u0010p\u001A\u00020NH\u0002JA\u0010\u009E\u0002\u001A\u00030\u009F\u00022.\u0010 \u0002\u001A)\b\u0001\u0012\u0005\u0012\u00030¢\u0002\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u009F\u00020£\u0002\u0012\u0007\u0012\u0005\u0018\u00010¤\u00020¡\u0002¢\u0006\u0003\b¥\u0002H\u0096@¢\u0006\u0003\u0010¦\u0002J\u0013\u0010ã\u0002\u001A\u0002072\b\u0010ä\u0002\u001A\u00030å\u0002H\u0016J=\u0010æ\u0002\u001A\u0002072!\u0010ç\u0002\u001A\u001C\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010è\u0002j\r\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u0001`é\u00022\u0006\u0010p\u001A\u00020N2\u0007\u0010ê\u0002\u001A\u00020NH\u0016J\u0013\u0010ë\u0002\u001A\u0002072\b\u0010ì\u0002\u001A\u00030í\u0002H\u0016J.\u0010ò\u0002\u001A\u0002072\b\u0010ó\u0002\u001A\u00030å\u00022\b\u0010ô\u0002\u001A\u00030õ\u00022\u000F\u0010ö\u0002\u001A\n\u0012\u0005\u0012\u00030ø\u00020÷\u0002H\u0016J\u0013\u0010ù\u0002\u001A\u0002072\b\u0010ú\u0002\u001A\u00030û\u0002H\u0016J\u0013\u0010ü\u0002\u001A\u0002072\b\u0010ú\u0002\u001A\u00030û\u0002H\u0016J\u001E\u0010ý\u0002\u001A\u0004\u0018\u00010$2\t\u0010þ\u0002\u001A\u0004\u0018\u00010$2\u0006\u0010p\u001A\u00020NH\u0016J\u001B\u0010ÿ\u0002\u001A\u00020\u00162\u0006\u0010p\u001A\u00020N2\n\u0010\u0080\u0003\u001A\u0005\u0018\u00010å\u0002J\u001B\u0010\u0081\u0003\u001A\u00020\u00162\u0006\u0010p\u001A\u00020N2\n\u0010\u0080\u0003\u001A\u0005\u0018\u00010å\u0002J\u001B\u0010\u0082\u0003\u001A\u00020\u00162\u0006\u0010p\u001A\u00020N2\n\u0010\u0080\u0003\u001A\u0005\u0018\u00010å\u0002J\u001D\u0010\u0083\u0003\u001A\u00020\u00162\u0006\u0010p\u001A\u00020N2\n\u0010\u0080\u0003\u001A\u0005\u0018\u00010å\u0002H\u0016J$\u0010\u0084\u0003\u001A\u00020\u00162\b\u0010_\u001A\u0004\u0018\u00010`2\t\u0010\u0080\u0003\u001A\u0004\u0018\u00010mH\u0016¢\u0006\u0003\b\u0085\u0003J\t\u0010\u0086\u0003\u001A\u000207H\u0016J&\u0010\u0087\u0003\u001A\u0002072\u0007\u0010\u0088\u0003\u001A\u00020\u00162\u0006\u0010p\u001A\u00020N2\n\u0010\u0080\u0003\u001A\u0005\u0018\u00010å\u0002H\u0014J!\u0010\u0087\u0003\u001A\u0002072\n\u0010\u0089\u0003\u001A\u0005\u0018\u00010\u008A\u00032\n\u0010\u008B\u0003\u001A\u0005\u0018\u00010\u008A\u0003H\u0016J\u0012\u0010\u008C\u0003\u001A\u0002072\u0007\u0010\u008D\u0003\u001A\u00020\u0016H\u0016J\u001C\u0010\u008E\u0003\u001A\u00020\u00162\b\u0010\u008F\u0003\u001A\u00030\u0090\u0003H\u0016¢\u0006\u0006\b\u0091\u0003\u0010\u0092\u0003J\u0013\u0010\u0093\u0003\u001A\u00020\u00162\b\u0010\u0094\u0003\u001A\u00030\u0095\u0003H\u0017J\u0013\u0010\u0096\u0003\u001A\u00020\u00162\b\u0010\u0097\u0003\u001A\u00030\u0098\u0003H\u0016J\u0013\u0010\u0099\u0003\u001A\u00020\u00162\b\u0010\u0097\u0003\u001A\u00030\u0098\u0003H\u0016J\u0012\u0010\u009A\u0003\u001A\u0002072\u0007\u0010\u009B\u0003\u001A\u00020\u0016H\u0016J\u0013\u0010\u009C\u0003\u001A\u0002072\b\u0010\u009D\u0003\u001A\u00030è\u0001H\u0016J\u0012\u0010\u009E\u0003\u001A\u0002072\u0007\u0010\u009F\u0003\u001A\u00020|H\u0016J\u0012\u0010 \u0003\u001A\u0002072\u0007\u0010\u009F\u0003\u001A\u00020|H\u0016J\u0012\u0010¡\u0003\u001A\u0002072\u0007\u0010\u009F\u0003\u001A\u00020|H\u0016J\u0012\u0010¢\u0003\u001A\u0002072\u0007\u0010\u009F\u0003\u001A\u00020|H\u0016J\u0007\u0010£\u0003\u001A\u000207J\t\u0010¤\u0003\u001A\u000207H\u0016J\u0018\u0010¥\u0003\u001A\u0002072\r\u0010¦\u0003\u001A\b\u0012\u0004\u0012\u00020706H\u0016JC\u0010§\u0003\u001A\u00020\u00162\b\u0010¨\u0003\u001A\u00030©\u00032\b\u0010ª\u0003\u001A\u00030«\u00032\u001B\u0010¬\u0003\u001A\u0016\u0012\u0005\u0012\u00030­\u0003\u0012\u0004\u0012\u0002070\u008A\u0002¢\u0006\u0003\b¥\u0002H\u0002¢\u0006\u0006\b®\u0003\u0010¯\u0003J\u0012\u0010°\u0003\u001A\u0002072\u0007\u0010±\u0003\u001A\u00020\u0001H\u0002J&\u0010²\u0003\u001A\u0002072\u0007\u0010³\u0003\u001A\u00020N2\b\u0010´\u0003\u001A\u00030µ\u00032\b\u0010¶\u0003\u001A\u00030·\u0003H\u0002J\u0014\u0010¸\u0003\u001A\u0002072\t\u0010¹\u0003\u001A\u0004\u0018\u00010$H\u0016J\u001D\u0010¸\u0003\u001A\u0002072\t\u0010¹\u0003\u001A\u0004\u0018\u00010$2\u0007\u0010º\u0003\u001A\u00020NH\u0016J&\u0010¸\u0003\u001A\u0002072\t\u0010¹\u0003\u001A\u0004\u0018\u00010$2\u0007\u0010»\u0003\u001A\u00020N2\u0007\u0010¼\u0003\u001A\u00020NH\u0016J \u0010¸\u0003\u001A\u0002072\t\u0010¹\u0003\u001A\u0004\u0018\u00010$2\n\u0010½\u0003\u001A\u0005\u0018\u00010¾\u0003H\u0016J)\u0010¸\u0003\u001A\u0002072\t\u0010¹\u0003\u001A\u0004\u0018\u00010$2\u0007\u0010º\u0003\u001A\u00020N2\n\u0010½\u0003\u001A\u0005\u0018\u00010¾\u0003H\u0016J\u0019\u0010¿\u0003\u001A\u0002072\u0007\u0010#\u001A\u00030À\u00032\u0007\u0010Á\u0003\u001A\u00020|J\u0010\u0010Â\u0003\u001A\u0002072\u0007\u0010#\u001A\u00030À\u0003J\u001A\u0010Ã\u0003\u001A\u0002072\u0007\u0010#\u001A\u00030À\u00032\b\u0010Ä\u0003\u001A\u00030Å\u0003J\u0016\u0010Æ\u0003\u001A\u0002072\u000B\b\u0002\u0010Ç\u0003\u001A\u0004\u0018\u00010|H\u0002J\r\u0010È\u0003\u001A\u00020\u0016*\u00020|H\u0002J\u0012\u0010É\u0003\u001A\u0002072\u0007\u0010Ê\u0003\u001A\u00020\u0016H\u0016J%\u0010É\u0003\u001A\u0002072\u0007\u0010Á\u0003\u001A\u00020|2\b\u0010Ë\u0003\u001A\u00030ã\u0001H\u0016¢\u0006\u0006\bÌ\u0003\u0010Í\u0003J\t\u0010Î\u0003\u001A\u000207H\u0002J\u001B\u0010Ï\u0003\u001A\u0002072\u0007\u0010Á\u0003\u001A\u00020|2\u0007\u0010Ð\u0003\u001A\u00020\u0016H\u0016J-\u0010Ñ\u0003\u001A\u0002072\u0007\u0010Á\u0003\u001A\u00020|2\u0007\u0010Ð\u0003\u001A\u00020\u00162\u0007\u0010Ò\u0003\u001A\u00020\u00162\u0007\u0010Æ\u0003\u001A\u00020\u0016H\u0016J$\u0010Ó\u0003\u001A\u0002072\u0007\u0010Á\u0003\u001A\u00020|2\u0007\u0010Ð\u0003\u001A\u00020\u00162\u0007\u0010Ò\u0003\u001A\u00020\u0016H\u0016J\u0012\u0010Ô\u0003\u001A\u0002072\u0007\u0010Á\u0003\u001A\u00020|H\u0016J\t\u0010Õ\u0003\u001A\u000207H\u0016J\u0015\u0010Ö\u0003\u001A\u0002072\n\u0010×\u0003\u001A\u0005\u0018\u00010\u008D\u0001H\u0016J\u001B\u0010Ø\u0003\u001A\u0002072\u0007\u0010Ù\u0003\u001A\u00020N2\u0007\u0010Ú\u0003\u001A\u00020NH\u0014J\u0018\u0010Û\u0003\u001A\u00020N*\u00030Ü\u0003H\u0082\n¢\u0006\u0006\bÝ\u0003\u0010Þ\u0003J\u0018\u0010ß\u0003\u001A\u00020N*\u00030Ü\u0003H\u0082\n¢\u0006\u0006\bà\u0003\u0010Þ\u0003J%\u0010á\u0003\u001A\u00030Ü\u00032\u0007\u0010â\u0003\u001A\u00020N2\u0007\u0010ã\u0003\u001A\u00020NH\u0002¢\u0006\u0006\bä\u0003\u0010å\u0003J\u001C\u0010æ\u0003\u001A\u00030Ü\u00032\u0007\u0010ç\u0003\u001A\u00020NH\u0002¢\u0006\u0006\bè\u0003\u0010é\u0003J6\u0010ê\u0003\u001A\u0002072\u0007\u0010ë\u0003\u001A\u00020\u00162\u0007\u0010ì\u0003\u001A\u00020N2\u0007\u0010í\u0003\u001A\u00020N2\u0007\u0010î\u0003\u001A\u00020N2\u0007\u0010ã\u0003\u001A\u00020NH\u0014J\t\u0010ð\u0003\u001A\u000207H\u0002J\u0013\u0010ñ\u0003\u001A\u0002072\b\u0010Ä\u0003\u001A\u00030Å\u0003H\u0014Ji\u0010ò\u0003\u001A\u00030¬\u00012B\u0010ó\u0003\u001A=\u0012\u0017\u0012\u00150ô\u0003¢\u0006\u000F\bõ\u0003\u0012\n\bö\u0003\u0012\u0005\b\b(Ä\u0003\u0012\u0019\u0012\u0017\u0018\u00010÷\u0003¢\u0006\u000F\bõ\u0003\u0012\n\bö\u0003\u0012\u0005\b\b(ø\u0003\u0012\u0004\u0012\u0002070¡\u00022\r\u0010ù\u0003\u001A\b\u0012\u0004\u0012\u000207062\n\u0010ú\u0003\u001A\u0005\u0018\u00010÷\u0003H\u0016J\u0019\u0010û\u0003\u001A\u00020\u00162\b\u0010ü\u0003\u001A\u00030¬\u0001H\u0000¢\u0006\u0003\bý\u0003J\t\u0010þ\u0003\u001A\u000207H\u0016J\u0012\u0010ÿ\u0003\u001A\u0002072\u0007\u0010Á\u0003\u001A\u00020|H\u0016J\u0012\u0010\u0080\u0004\u001A\u0002072\u0007\u0010Á\u0003\u001A\u00020|H\u0016J\u001B\u0010\u0081\u0004\u001A\u0002072\u0007\u0010Á\u0003\u001A\u00020|2\u0007\u0010\u0082\u0004\u001A\u00020NH\u0016J\u001B\u0010\u0083\u0004\u001A\u0002072\u0007\u0010Á\u0003\u001A\u00020|2\u0007\u0010\u0082\u0004\u001A\u00020NH\u0016J\u0016\u0010\u0084\u0004\u001A\u0002072\u000B\u0010#\u001A\u00070$j\u0003`\u0085\u0004H\u0016J\u0013\u0010\u0086\u0004\u001A\u0002072\b\u0010¦\u0003\u001A\u00030\u0087\u0004H\u0016J\u0013\u0010\u0088\u0004\u001A\u0002072\b\u0010Ä\u0003\u001A\u00030Å\u0003H\u0014J\"\u0010\u0089\u0004\u001A\u0002072\b\u0010ü\u0003\u001A\u00030¬\u00012\u0007\u0010\u008A\u0004\u001A\u00020\u0016H\u0000¢\u0006\u0003\b\u008B\u0004J\u001E\u0010\u008C\u0004\u001A\u0002072\u0015\u0010\u008D\u0004\u001A\u0010\u0012\u0005\u0012\u00030þ\u0001\u0012\u0004\u0012\u0002070\u008A\u0002J\u0010\u0010\u008E\u0004\u001A\u000207H\u0086@¢\u0006\u0003\u0010\u008F\u0004J\u0010\u0010\u0090\u0004\u001A\u000207H\u0086@¢\u0006\u0003\u0010\u008F\u0004J\u0012\u0010\u0091\u0004\u001A\u0002072\u0007\u0010\u009F\u0003\u001A\u00020|H\u0002J\u0012\u0010\u0092\u0004\u001A\u0002072\u0007\u0010\u009F\u0003\u001A\u00020|H\u0002J\t\u0010\u0093\u0004\u001A\u000207H\u0016J\t\u0010\u0094\u0004\u001A\u000207H\u0014J#\u0010\u0095\u0004\u001A\u0004\u0018\u0001002\n\u0010\u0096\u0004\u001A\u0005\u0018\u00010û\u00022\n\u0010\u0097\u0004\u001A\u0005\u0018\u00010\u0098\u0004H\u0002J\t\u0010\u0099\u0004\u001A\u000207H\u0014J\u001E\u0010\u009A\u0004\u001A\u0002072\n\u0010ì\u0002\u001A\u0005\u0018\u00010í\u00022\u0007\u0010\u009B\u0004\u001A\u00020NH\u0016J\u001A\u0010Á\u0001\u001A\u0002072\u000F\u0010\u009C\u0004\u001A\n\u0012\u0005\u0012\u00030\u009E\u00040\u009D\u0004H\u0016J0\u0010\u009F\u0004\u001A\u0002072\b\u0010 \u0004\u001A\u00030¡\u00042\b\u0010¢\u0004\u001A\u00030ð\u00012\u0011\u0010£\u0004\u001A\f\u0012\u0007\u0012\u0005\u0018\u00010¤\u00040÷\u0002H\u0017J\u001C\u0010¥\u0004\u001A\u0002072\u0011\u0010¦\u0004\u001A\f\u0012\u0007\u0012\u0005\u0018\u00010¨\u00040§\u0004H\u0017J\u0013\u0010©\u0004\u001A\u00020\u00162\b\u0010ª\u0004\u001A\u00030Ð\u0002H\u0016J\u0013\u0010«\u0004\u001A\u00020\u00162\b\u0010\u0094\u0003\u001A\u00030\u0095\u0003H\u0002J\u0013\u0010¬\u0004\u001A\u00020\u00162\b\u0010ª\u0004\u001A\u00030Ð\u0002H\u0016J\u0013\u0010­\u0004\u001A\u00020\u00162\b\u0010\u0097\u0003\u001A\u00030Ð\u0002H\u0002J\u001D\u0010®\u0004\u001A\u00030¯\u00042\b\u0010ª\u0004\u001A\u00030Ð\u0002H\u0002¢\u0006\u0006\b°\u0004\u0010±\u0004J\u001D\u0010²\u0004\u001A\u00020\u00162\b\u0010\u0097\u0003\u001A\u00030Ð\u00022\b\u0010³\u0004\u001A\u00030Ð\u0002H\u0002J\u0013\u0010´\u0004\u001A\u00020\u00162\b\u0010\u0097\u0003\u001A\u00030Ð\u0002H\u0002J\u001D\u0010µ\u0004\u001A\u00030¯\u00042\b\u0010ª\u0004\u001A\u00030Ð\u0002H\u0002¢\u0006\u0006\b¶\u0004\u0010±\u0004J1\u0010·\u0004\u001A\u0002072\b\u0010ª\u0004\u001A\u00030Ð\u00022\u0007\u0010¸\u0004\u001A\u00020N2\b\u0010¹\u0004\u001A\u00030è\u00012\t\b\u0002\u0010º\u0004\u001A\u00020\u0016H\u0002J\u0011\u0010»\u0004\u001A\u00020\u00162\u0006\u0010p\u001A\u00020NH\u0016J\u0011\u0010¼\u0004\u001A\u00020\u00162\u0006\u0010p\u001A\u00020NH\u0016J\u0013\u0010½\u0004\u001A\u00020\u00162\b\u0010ª\u0004\u001A\u00030Ð\u0002H\u0002J\u001B\u0010¾\u0004\u001A\u00020\u00132\u0007\u0010¿\u0004\u001A\u00020\u0013H\u0016¢\u0006\u0006\bÀ\u0004\u0010Á\u0004J\u001C\u0010¾\u0004\u001A\u0002072\b\u0010Â\u0004\u001A\u00030ò\u0001H\u0016¢\u0006\u0006\bÃ\u0004\u0010Ä\u0004J\u001B\u0010Å\u0004\u001A\u00020\u00132\u0007\u0010Æ\u0004\u001A\u00020\u0013H\u0016¢\u0006\u0006\bÇ\u0004\u0010Á\u0004J\t\u0010È\u0004\u001A\u000207H\u0002J\u0013\u0010È\u0004\u001A\u0002072\b\u0010ª\u0004\u001A\u00030Ð\u0002H\u0002J\t\u0010É\u0004\u001A\u000207H\u0002J\t\u0010Ê\u0004\u001A\u000207H\u0002J\t\u0010Ë\u0004\u001A\u00020\u0016H\u0016J\u0016\u0010Ì\u0004\u001A\u0005\u0018\u00010Í\u00042\b\u0010Î\u0004\u001A\u00030Ï\u0004H\u0016J\u001B\u0010Ð\u0004\u001A\u00020\u00132\u0007\u0010Ñ\u0004\u001A\u00020\u0013H\u0016¢\u0006\u0006\bÒ\u0004\u0010Á\u0004J\u001B\u0010Ó\u0004\u001A\u00020\u00132\u0007\u0010¿\u0004\u001A\u00020\u0013H\u0016¢\u0006\u0006\bÔ\u0004\u0010Á\u0004J\u0013\u0010Õ\u0004\u001A\u0002072\b\u0010Ö\u0004\u001A\u00030´\u0001H\u0014J\t\u0010×\u0004\u001A\u000207H\u0002J\u0013\u0010Ø\u0004\u001A\u0002072\b\u0010Ö\u0004\u001A\u00030´\u0001H\u0002J\u0012\u0010Ù\u0004\u001A\u0002072\u0007\u0010·\u0002\u001A\u00020NH\u0016J\t\u0010Ú\u0004\u001A\u00020\u0016H\u0002J\u0013\u0010Û\u0004\u001A\u00020\u00162\b\u0010\u0097\u0003\u001A\u00030Ð\u0002H\u0016J\u0013\u0010Ü\u0004\u001A\u00020\u00162\b\u0010\u0097\u0003\u001A\u00030Ð\u0002H\u0002J\u0013\u0010Ý\u0004\u001A\u00020\u00162\b\u0010\u0097\u0003\u001A\u00030Ð\u0002H\u0002J\u001D\u0010Þ\u0004\u001A\u0004\u0018\u00010$2\u0007\u0010ß\u0004\u001A\u00020N2\u0007\u0010à\u0004\u001A\u00020$H\u0002J\u001D\u0010á\u0004\u001A\u00030â\u00042\b\u0010\u0097\u0003\u001A\u00030Ð\u00022\u0007\u0010ã\u0004\u001A\u00020NH\u0017J\u0012\u0010è\u0004\u001A\u0004\u0018\u00010$2\u0007\u0010ß\u0004\u001A\u00020NJ\t\u0010ê\u0004\u001A\u00020\u0016H\u0016J\t\u0010ì\u0004\u001A\u000207H\u0016J\t\u0010í\u0004\u001A\u000207H\u0016J\t\u0010ï\u0004\u001A\u000207H\u0016J\t\u0010ð\u0004\u001A\u000207H\u0016J\u0018\u0010ô\u0004\u001A\u0002072\r\u0010õ\u0004\u001A\b\u0012\u0004\u0012\u00020706H\u0016J\u0013\u0010ö\u0004\u001A\u0002072\b\u0010÷\u0004\u001A\u00030Ö\u0002H\u0017J\u001B\u0010ø\u0004\u001A\u0002072\u0007\u0010ù\u0004\u001A\u00020\u0013H\u0016¢\u0006\u0006\bú\u0004\u0010ú\u0001J\t\u0010û\u0004\u001A\u000207H\u0016J\t\u0010ü\u0004\u001A\u000207H\u0016J\u0012\u0010ý\u0004\u001A\u0002072\u0007\u0010þ\u0004\u001A\u00020\u0016H\u0016R\u0010\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0014R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010\u0017\u001A\u0004\u0018\u00010\u00188\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020 X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020$8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&R\u001C\u0010\'\u001A\u0004\u0018\u00010(X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001A\u0004\u0018\u00010.X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u00101\u001A\u0002002\u0006\u0010/\u001A\u000200@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b2\u00103R\u001A\u00104\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002070605X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00108\u001A\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010<\u001A\u00020;2\u0006\u0010:\u001A\u00020;8V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\bA\u0010B\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000E\u0010C\u001A\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010D\u001A\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bE\u0010FR\u000E\u0010G\u001A\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010I\u001A\u00020JX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bK\u0010LR$\u0010\u000E\u001A\u00020\u000F2\u0006\u0010/\u001A\u00020\u000F@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010S\u001A\u00020TX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bU\u0010VR\u000E\u0010W\u001A\u00020XX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001A\u00020Z8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b[\u0010\\R\u000E\u0010]\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010q\u001A\u00020rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010s\u001A\u00020tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bu\u0010vR\u0011\u0010w\u001A\u00020x¢\u0006\b\n\u0000\u001A\u0004\by\u0010zR\u001A\u0010{\u001A\u00020|X\u0096\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b}\u0010\u001A\u001A\u0004\b~\u0010\u007FR\u001E\u0010\u0080\u0001\u001A\t\u0012\u0004\u0012\u00020|0\u0081\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0084\u0001\u001A\u00030\u0085\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u0088\u0001\u001A\u00030\u0089\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u008A\u0001\u0010\u008B\u0001R\"\u0010\u008C\u0001\u001A\u0005\u0018\u00010\u008D\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u008E\u0001\u0010\u008F\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0092\u0001\u001A\u00030\u0093\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0010\u0010\u0096\u0001\u001A\u00030\u0097\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0098\u0001\u001A\u00030\u0099\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u009A\u0001\u0010\u009B\u0001\"\u0006\b\u009C\u0001\u0010\u009D\u0001R\u0018\u0010\u009E\u0001\u001A\u00030\u009F\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\b \u0001\u0010¡\u0001R\u0018\u0010¢\u0001\u001A\u00030£\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\b¤\u0001\u0010¥\u0001R\u0018\u0010¦\u0001\u001A\u00030§\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\b¨\u0001\u0010©\u0001R\u0017\u0010ª\u0001\u001A\n\u0012\u0005\u0012\u00030¬\u00010«\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010­\u0001\u001A\f\u0012\u0005\u0012\u00030¬\u0001\u0018\u00010«\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u000F\u0010®\u0001\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000F\u0010¯\u0001\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010°\u0001\u001A\u00030±\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010²\u0001\u001A\u00030³\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010µ\u0001\u001A\u00030´\u00012\u0007\u0010:\u001A\u00030´\u00018F@FX\u0086\u008E\u0002¢\u0006\u0017\n\u0005\bº\u0001\u0010B\u001A\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R\u0012\u0010»\u0001\u001A\u0005\u0018\u00010¼\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010½\u0001\u001A\u0005\u0018\u00010¾\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b¿\u0001\u0010À\u0001R\u001A\u0010Á\u0001\u001A\u0005\u0018\u00010Â\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\bÃ\u0001\u0010Ä\u0001R\u001A\u0010Å\u0001\u001A\u0005\u0018\u00010Æ\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\bÇ\u0001\u0010È\u0001R\u000F\u0010É\u0001\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010Ê\u0001\u001A\u00030Ë\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\bÌ\u0001\u0010Í\u0001R\u0018\u0010Î\u0001\u001A\u00030Ï\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\bÐ\u0001\u0010Ñ\u0001R\u0018\u0010Ò\u0001\u001A\u00030Ó\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\bÔ\u0001\u0010Õ\u0001R\'\u0010Ö\u0001\u001A\u00020\u00168VX\u0096\u000E¢\u0006\u0018\n\u0000\u0012\u0005\b×\u0001\u0010\u001A\u001A\u0005\bØ\u0001\u0010F\"\u0006\bÙ\u0001\u0010Ú\u0001R\u0012\u0010Û\u0001\u001A\u0005\u0018\u00010Ü\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010Ý\u0001\u001A\u00030Ü\u00018@X\u0080\u0004¢\u0006\b\u001A\u0006\bÞ\u0001\u0010ß\u0001R\u0012\u0010à\u0001\u001A\u0005\u0018\u00010á\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010â\u0001\u001A\u0005\u0018\u00010ã\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u000F\u0010ä\u0001\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010å\u0001\u001A\u00030æ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010ç\u0001\u001A\u00030è\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\bé\u0001\u0010ê\u0001R\u0016\u0010ë\u0001\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001A\u0005\bì\u0001\u0010FR\u0012\u0010í\u0001\u001A\u00030î\u0001X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010ï\u0001\u001A\u00030ð\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010ñ\u0001\u001A\u00030ò\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ó\u0001R\u0013\u0010ô\u0001\u001A\u00030ò\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ó\u0001R\u0013\u0010õ\u0001\u001A\u00030ò\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ó\u0001R+\u0010ö\u0001\u001A\u00030è\u00018\u0000@\u0000X\u0081\u000E¢\u0006\u0019\n\u0000\u0012\u0005\b÷\u0001\u0010\u001A\u001A\u0006\bø\u0001\u0010ê\u0001\"\u0006\bù\u0001\u0010ú\u0001R\u000F\u0010û\u0001\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010ü\u0001\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0014R\u000F\u0010ý\u0001\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R7\u0010ÿ\u0001\u001A\u0005\u0018\u00010þ\u00012\t\u0010:\u001A\u0005\u0018\u00010þ\u00018B@BX\u0082\u008E\u0002¢\u0006\u0017\n\u0005\b\u0084\u0002\u0010B\u001A\u0006\b\u0080\u0002\u0010\u0081\u0002\"\u0006\b\u0082\u0002\u0010\u0083\u0002R#\u0010\u0085\u0002\u001A\u0005\u0018\u00010þ\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001A\u0006\b\u0086\u0002\u0010\u0081\u0002R\u001F\u0010\u0089\u0002\u001A\u0012\u0012\u0005\u0012\u00030þ\u0001\u0012\u0004\u0012\u000207\u0018\u00010\u008A\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u008B\u0002\u001A\u00030\u008C\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u008D\u0002\u001A\u00030\u008E\u00028\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u008F\u0002\u0010\u001A\u001A\u0006\b\u0090\u0002\u0010\u0091\u0002R\u001A\u0010\u0092\u0002\u001A\n\u0012\u0005\u0012\u00030\u0094\u00020\u0093\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0095\u0002R\u0018\u0010\u0096\u0002\u001A\u00030\u0097\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0098\u0002\u0010\u0099\u0002R\u0018\u0010\u009A\u0002\u001A\u00030\u009B\u00028VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u009C\u0002\u0010\u009D\u0002R!\u0010§\u0002\u001A\u00030¨\u00028\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b©\u0002\u0010\u001A\u001A\u0006\bª\u0002\u0010«\u0002R3\u0010­\u0002\u001A\u00030¬\u00022\u0007\u0010:\u001A\u00030¬\u00028V@RX\u0096\u008E\u0002¢\u0006\u0017\n\u0005\b²\u0002\u0010B\u001A\u0006\b®\u0002\u0010¯\u0002\"\u0006\b°\u0002\u0010±\u0002R\u001C\u0010³\u0002\u001A\u00020N*\u00030´\u00018BX\u0082\u0004¢\u0006\b\u001A\u0006\b´\u0002\u0010µ\u0002R3\u0010·\u0002\u001A\u00030¶\u00022\u0007\u0010:\u001A\u00030¶\u00028V@RX\u0096\u008E\u0002¢\u0006\u0017\n\u0005\b¼\u0002\u0010B\u001A\u0006\b¸\u0002\u0010¹\u0002\"\u0006\bº\u0002\u0010»\u0002R\u0018\u0010½\u0002\u001A\u00030¾\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\b¿\u0002\u0010À\u0002R\u0010\u0010Á\u0002\u001A\u00030Â\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Ã\u0002\u001A\u00030Ä\u00028VX\u0096\u0004¢\u0006\b\u001A\u0006\bÅ\u0002\u0010Æ\u0002R\u0018\u0010Ç\u0002\u001A\u00030È\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\bÉ\u0002\u0010Ê\u0002R\u0018\u0010Ë\u0002\u001A\u00030Ì\u0002X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\bÍ\u0002\u0010Î\u0002R\u0012\u0010Ï\u0002\u001A\u0005\u0018\u00010Ð\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010Ñ\u0002\u001A\u00030è\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0017\u0010Ò\u0002\u001A\n\u0012\u0005\u0012\u00030¬\u00010Ó\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010Ô\u0002\u001A\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u000207\u0018\u0001060«\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Õ\u0002\u001A\u00030Ö\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010×\u0002\u001A\u00030Ö\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u0013\u0010Ø\u0002\u001A\u00030Ù\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Ú\u0002R\u000F\u0010Û\u0002\u001A\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000F\u0010Ü\u0002\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010Ý\u0002\u001A\u00030Þ\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010ß\u0002\u001A\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010à\u0002\u001A\u00030á\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000F\u0010â\u0002\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010î\u0002\u001A\u0005\u0018\u00010ï\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010ð\u0002\u001A\u00020\u00168@X\u0080\u0004¢\u0006\u0007\u001A\u0005\bñ\u0002\u0010FR\u0011\u0010ï\u0003\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010ä\u0004\u001A\u00030å\u0004X\u0096\u0004¢\u0006\n\n\u0000\u001A\u0006\bæ\u0004\u0010ç\u0004R\u0016\u0010é\u0004\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001A\u0005\bé\u0004\u0010FR\u000F\u0010ë\u0004\u001A\u00020NX\u0082\u000E¢\u0006\u0002\n\u0000R\u000F\u0010î\u0004\u001A\u00020NX\u0082\u000E¢\u0006\u0002\n\u0000R\u0019\u0010ñ\u0004\u001A\u0004\u0018\u00010\u00008VX\u0096\u0004¢\u0006\b\u001A\u0006\bò\u0004\u0010ó\u0004¨\u0006\u0082\u0005"}, d2={"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/MatrixPositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/compose/ui/node/OutOfFrameExecutor;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "Landroidx/compose/ui/focus/FocusListener;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "superclassInitComplete", "", "primaryDirectionalMotionAxisOverride", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui$annotations", "()V", "getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui", "()Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "setPrimaryDirectionalMotionAxisOverride-r2epLt8$ui", "(Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;)V", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "frameEndScheduler", "Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$FrameEndScheduler;", "getFrameEndScheduler$ui", "()Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$FrameEndScheduler;", "setFrameEndScheduler$ui", "(Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$FrameEndScheduler;)V", "lifecycleRetainedValuesStoreOwnerEntry", "Landroidx/compose/ui/platform/LifecycleRetainedValuesStoreOwner$RetainedValuesStoreEntry;", "value", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "retainedValuesStore", "getRetainedValuesStore", "()Landroidx/compose/runtime/retain/RetainedValuesStore;", "outOfFrameQueue", "Lkotlin/collections/ArrayDeque;", "Lkotlin/Function0;", "", "outOfFrameRunnable", "Ljava/lang/Runnable;", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "Landroidx/compose/runtime/MutableState;", "frameRateCategoryView", "isArrEnabled", "isArrEnabled$ui", "()Z", "rootSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "getImportantForAutofill", "", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/AndroidDragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/AndroidDragAndDropManager;", "_windowInfo", "Landroidx/compose/ui/platform/LazyWindowInfo;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "processingRequestFocusForNextNonChildView", "moveFocusInChildrenCurrent", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocusInChildrenCurrent-3ESFkO8", "(I)Z", "moveFocusInChildrenViewFocusFix", "moveFocusInChildrenViewFocusFix-3ESFkO8", "moveFocusInChildrenBypassUnfocusableComposeView", "moveFocusInChildrenBypassUnfocusableComposeView-3ESFkO8", "moveFocusInChildren", "moveFocusInChildren-3ESFkO8", "findNextViewInEmbeddedView", "findNextViewInEmbeddedView-3ESFkO8", "(I)Landroid/view/View;", "getEmbeddedViewFocusRect", "Landroidx/compose/ui/geometry/Rect;", "focusTargetAvailable", "findNextNonChildView", "direction", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "insetsListener", "Landroidx/compose/ui/layout/InsetsListener;", "getInsetsListener", "()Landroidx/compose/ui/layout/InsetsListener;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot$annotations", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "layoutNodes", "Landroidx/collection/MutableIntObjectMap;", "getLayoutNodes", "()Landroidx/collection/MutableIntObjectMap;", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "getRectManager", "()Landroidx/compose/ui/spatial/RectManager;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "uncaughtExceptionHandler", "Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "getUncaughtExceptionHandler$ui", "()Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;", "setUncaughtExceptionHandler$ui", "(Landroidx/compose/ui/node/RootForTest$UncaughtExceptionHandler;)V", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "dirtyLayers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/node/OwnedLayer;", "postponedDirtyLayers", "isDrawingContent", "isPendingInteropViewLayoutChangeDispatch", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "Landroid/content/res/Configuration;", "configuration", "getConfiguration", "()Landroid/content/res/Configuration;", "setConfiguration", "(Landroid/content/res/Configuration;)V", "configuration$delegate", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_autofillManager", "Landroidx/compose/ui/autofill/AndroidAutofillManager;", "get_autofillManager$ui", "()Landroidx/compose/ui/autofill/AndroidAutofillManager;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillManager", "Landroidx/compose/ui/autofill/AutofillManager;", "getAutofillManager", "()Landroidx/compose/ui/autofill/AutofillManager;", "observationClearRequested", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "clipboard", "Landroidx/compose/ui/platform/AndroidClipboard;", "getClipboard", "()Landroidx/compose/ui/platform/AndroidClipboard;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "androidViewsHandler", "getAndroidViewsHandler$ui", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "wasMeasuredWithMultipleConstraints", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "", "getMeasureIteration", "()J", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "tmpPositionArray", "", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "viewToWindowMatrix", "windowToViewMatrix", "lastMatrixRecalculationAnimationTime", "getLastMatrixRecalculationAnimationTime$ui$annotations", "getLastMatrixRecalculationAnimationTime$ui", "setLastMatrixRecalculationAnimationTime$ui", "(J)V", "forceUseMatrixCache", "windowPosition", "isRenderNodeCompatible", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "onViewTreeOwnersAvailable", "Lkotlin/Function1;", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "textInputSession", "", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "endApplyChangesListeners", "currentFrameRate", "", "currentFrameRateCategory", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "sendHoverExitEvent", "hoverExitReceived", "indirectPointerNavigationGestureDetector", "Landroidx/compose/ui/platform/IndirectPointerNavigationGestureDetector;", "resendMotionEventOnLayout", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "keyboardModifiersRequireUpdate", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "addFocusables", "views", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "focusableMode", "dispatchProvideStructure", "structure", "Landroid/view/ViewStructure;", "scrollCapture", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCaptureInProgress", "getScrollCaptureInProgress$ui", "onScrollCaptureSearch", "localVisibleRect", "windowOffset", "Landroid/graphics/Point;", "targets", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "focusSearch", "focused", "requestFocusCurrent", "previouslyFocusedRect", "requestFocusViewFocusFix", "requestFocusBypassUnfocusableComposeView", "requestFocus", "requestOwnerFocus", "requestOwnerFocus-7o62pno", "clearOwnerFocus", "onFocusChanged", "gainFocus", "previous", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "current", "onWindowFocusChanged", "hasWindowFocus", "sendKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendIndirectPointerEvent", "indirectPointerEvent", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "forceAccessibilityForTesting", "enable", "setAccessibilityEventBatchIntervalMillis", "intervalMillis", "onPreAttach", "node", "onPostAttach", "onDetach", "requestAutofill", "requestClearInvalidObservations", "onEndApplyChanges", "registerOnEndApplyChangesListener", "listener", "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "clearChildInvalidObservations", "viewGroup", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "addView", "child", "index", "width", "height", "params", "Landroid/view/ViewGroup$LayoutParams;", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "removeAndroidView", "drawAndroidView", "canvas", "Landroid/graphics/Canvas;", "scheduleMeasureAndLayout", "nodeToRemeasure", "childSizeCanAffectParentSize", "measureAndLayout", "sendPointerUpdate", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "dispatchPendingInteropLayoutCallbacks", "forceMeasureTheSubtree", "affectsLookahead", "onRequestMeasure", "forceRequest", "onRequestRelayout", "requestOnPositionedCallback", "measureAndLayoutForTest", "setUncaughtExceptionHandler", "handler", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "component1", "Lkotlin/ULong;", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "pack", "a", "b", "pack-ZIaKswc", "(II)J", "convertMeasureSpec", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "onLayout", "changed", "l", "t", "r", "_rootView", "updatePositionCacheAndDispatch", "onDraw", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "invalidateParentLayer", "explicitLayer", "recycle", "layer", "recycle$ui", "onSemanticsChange", "onLayoutChange", "onLayoutNodeDeactivated", "onPreLayoutNodeReused", "oldSemanticsId", "onPostLayoutNodeReused", "onInteropViewLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "dispatchDraw", "notifyLayerIsDirty", "isDirty", "notifyLayerIsDirty$ui", "setOnViewTreeOwnersAvailable", "callback", "boundsUpdatesContentCaptureEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesAccessibilityEventLoop", "invalidateLayoutNodeMeasurement", "invalidateLayers", "invalidateDescendants", "onAttachedToWindow", "installLocalRetainedValuesStore", "lifecycleOwner", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "onDetachedFromWindow", "onProvideAutofillVirtualStructure", "flags", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "dispatchGenericMotionEvent", "motionEvent", "handleIndirectPointerEvent", "dispatchTouchEvent", "handleRotaryEvent", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "hasChangedDevices", "lastEvent", "isDevicePressEvent", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "canScrollHorizontally", "canScrollVertically", "isInBounds", "localToScreen", "localPosition", "localToScreen-MK-Hz9U", "(J)J", "localTransform", "localToScreen-58bKbWc", "([F)V", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "recalculateWindowPosition", "recalculateWindowViewTransforms", "updateWindowMetrics", "onCheckIsTextEditor", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "calculatePositionInWindow", "calculatePositionInWindow-MK-Hz9U", "onConfigurationChanged", "newConfig", "dispatchConfigurationChangeIfNeeded", "updateConfiguration", "onRtlPropertiesChanged", "autofillSupported", "dispatchHoverEvent", "isBadMotionEvent", "isPositionChanged", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "onResolvePointerIcon", "Landroid/view/PointerIcon;", "pointerIndex", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "findViewByAccessibilityIdTraversal", "isLifecycleInResumedState", "shouldDelayChildPressedState", "sensitiveComponentCount", "incrementSensitiveComponentCount", "decrementSensitiveComponentCount", "keepScreenOnCount", "incrementKeepScreenOnCount", "decrementKeepScreenOnCount", "outOfFrameExecutor", "getOutOfFrameExecutor", "()Landroidx/compose/ui/platform/AndroidComposeView;", "schedule", "block", "voteFrameRate", "frameRate", "dispatchOnScrollChanged", "delta", "dispatchOnScrollChanged-k-4lQ0M", "onGlobalLayout", "onScrollChanged", "onTouchModeChanged", "isInTouchMode", "Companion", "ViewTreeOwners", "RootModifierNode", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidComposeView extends ViewGroup implements ViewTreeObserver$OnGlobalLayoutListener, ViewTreeObserver$OnScrollChangedListener, ViewTreeObserver$OnTouchModeChangeListener, FocusListener, PlatformFocusOwner, MatrixPositionCalculator, OutOfFrameExecutor, Owner, ViewRootForTest, DefaultLifecycleObserver {
    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000F\u001A\u00020\u0010H\u0002J\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u000BH\u0002J\u0010\u0010\u0014\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u000BH\u0002J\u0010\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u0017H\u0007R\u0014\u0010\u0004\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "<init>", "()V", "systemPropertiesClass", "Ljava/lang/Class;", "getBooleanMethod", "Ljava/lang/reflect/Method;", "addChangeCallbackMethod", "composeViews", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/platform/AndroidComposeView;", "systemPropertiesChangedRunnable", "Ljava/lang/Runnable;", "dispatchOnScrollChangedMethod", "getIsShowingLayoutBounds", "", "addNotificationForSysPropsChange", "", "composeView", "removeNotificationForSysPropsChange", "dispatchOnScrollChanged", "viewTreeObserver", "Landroid/view/ViewTreeObserver;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final void access$addNotificationForSysPropsChange(Companion arg0, AndroidComposeView arg1) {
            arg0.addNotificationForSysPropsChange(arg1);
        }

        public static final boolean access$getIsShowingLayoutBounds(Companion arg0) {
            return arg0.getIsShowingLayoutBounds();
        }

        public static final void access$removeNotificationForSysPropsChange(Companion arg0, AndroidComposeView arg1) {
            arg0.removeNotificationForSysPropsChange(arg1);
        }

        private final void addNotificationForSysPropsChange(AndroidComposeView arg8) {
            Method v1_1;
            if(Build$VERSION.SDK_INT > 28) {
                if(AndroidComposeView.systemPropertiesChangedRunnable == null) {
                    AndroidComposeView$Companion$$ExternalSyntheticLambda0 v7 = new AndroidComposeView$Companion$$ExternalSyntheticLambda0();
                    AndroidComposeView.systemPropertiesChangedRunnable = ((Runnable)v7);
                    StrictMode$VmPolicy v0 = StrictMode.getVmPolicy();
                    try {
                        if(AndroidComposeView.systemPropertiesClass == null) {
                            AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                        }

                        Object v2 = null;
                        if(AndroidComposeView.addChangeCallbackMethod == null) {
                            StrictMode.setVmPolicy(StrictMode$VmPolicy.LAX);
                            Class v1 = AndroidComposeView.systemPropertiesClass;
                            v1_1 = v1 != null ? v1.getDeclaredMethod("addChangeCallback", Runnable.class) : ((Method)v2);
                            AndroidComposeView.addChangeCallbackMethod = v1_1;
                        }

                        v1_1 = AndroidComposeView.addChangeCallbackMethod;
                        if(v1_1 != null) {
                            v1_1.invoke(v2, v7);
                        }

                        goto label_35;
                    }
                    catch(Throwable ) {
                    label_35:
                        StrictMode.setVmPolicy(v0);
                    }
                }

                MutableObjectList v7_1 = AndroidComposeView.composeViews;
                __monitor_enter(v7_1);
                try {
                    AndroidComposeView.composeViews.add(arg8);
                }
                catch(Throwable v8) {
                    __monitor_exit(v7_1);
                    throw v8;
                }

                __monitor_exit(v7_1);
                return;
            }
        }

        static final void addNotificationForSysPropsChange$lambda$0() {
            int v1_2;
            Object[] v2;
            MutableObjectList v1_1;
            MutableObjectList v0 = AndroidComposeView.composeViews;
            __monitor_enter(v0);
            try {
                int v3 = 0;
                if(Build$VERSION.SDK_INT < 30) {
                    v1_1 = AndroidComposeView.composeViews;
                    v2 = ((ObjectList)v1_1).content;
                    v1_2 = ((ObjectList)v1_1)._size;
                    while(v3 < v1_2) {
                        Object v4 = v2[v3];
                        boolean v5 = ((AndroidComposeView)v4).getShowLayoutBounds();
                        ((AndroidComposeView)v4).setShowLayoutBounds(AndroidComposeView.Companion.getIsShowingLayoutBounds());
                        if(v5 != ((AndroidComposeView)v4).getShowLayoutBounds()) {
                            ((AndroidComposeView)v4).invalidateDescendants();
                        }

                        ++v3;
                    }
                }
                else {
                    v1_1 = AndroidComposeView.composeViews;
                    v2 = ((ObjectList)v1_1).content;
                    v1_2 = ((ObjectList)v1_1)._size;
                    while(v3 < v1_2) {
                        v2[v3].invalidateDescendants();
                        ++v3;
                    }
                }
            }
            catch(Throwable v1) {
                __monitor_exit(v0);
                throw v1;
            }

            __monitor_exit(v0);
        }

        public final void dispatchOnScrollChanged(ViewTreeObserver arg4) {
            Method v3;
            try {
                if(AndroidComposeView.dispatchOnScrollChangedMethod == null) {
                    v3 = arg4.getClass().getDeclaredMethod("dispatchOnScrollChanged");
                    v3.setAccessible(true);
                    AndroidComposeView.dispatchOnScrollChangedMethod = v3;
                }

                v3 = AndroidComposeView.dispatchOnScrollChangedMethod;
                if(v3 != null) {
                    v3.invoke(arg4);
                }

                return;
            }
            catch(Exception ) {
                return;
            }
        }

        private final boolean getIsShowingLayoutBounds() {
            Method v0_1;
            boolean v6 = false;
            try {
                if(AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                }

                Object v2 = null;
                if(AndroidComposeView.getBooleanMethod == null) {
                    Class v0 = AndroidComposeView.systemPropertiesClass;
                    v0_1 = v0 != null ? v0.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : ((Method)v2);
                    AndroidComposeView.getBooleanMethod = v0_1;
                }

                v0_1 = AndroidComposeView.getBooleanMethod;
                Object v0_2 = v0_1 != null ? v0_1.invoke(v2, "debug.layout", Boolean.valueOf(false)) : v2;
                if((v0_2 instanceof Boolean)) {
                    v2 = v0_2;
                }

                Boolean v0_3 = Boolean.valueOf(true);
                return Intrinsics.areEqual(v2, v0_3);
            }
            catch(Exception ) {
                return v6;
            }
        }

        private final void removeNotificationForSysPropsChange(AndroidComposeView arg2) {
            if(Build$VERSION.SDK_INT > 28) {
                MutableObjectList v1 = AndroidComposeView.composeViews;
                __monitor_enter(v1);
                try {
                    AndroidComposeView.composeViews.remove(arg2);
                }
                catch(Throwable v2) {
                    __monitor_exit(v1);
                    throw v2;
                }

                __monitor_exit(v1);
                return;
            }
        }
    }

    @Metadata(d1={"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0007¢\u0006\u0004\b\t\u0010\nJ#\u00103\u001A\u000204*\u0002052\u0006\u00106\u001A\u0002072\u0006\u00108\u001A\u000209H\u0016¢\u0006\u0004\b:\u0010;J\f\u0010?\u001A\u00020-*\u00020@H\u0016J&\u0010A\u001A\u00020-2\u0006\u0010B\u001A\u00020C2\u000E\u0010D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010F0EH\u0096@¢\u0006\u0002\u0010GJ\u0010\u0010H\u001A\u00020I2\u0006\u0010J\u001A\u00020KH\u0016J\u0010\u0010L\u001A\u00020I2\u0006\u0010J\u001A\u00020KH\u0016J\u0017\u0010M\u001A\u00020I2\u0006\u0010J\u001A\u00020NH\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001A\u00020I2\u0006\u0010J\u001A\u00020NH\u0016¢\u0006\u0004\bR\u0010PR \u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u00128F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0015\u001A\u00020\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR \u0010\u001B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001E0\u001D0\u001C8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u001A\u0010!\u001A\b\u0012\u0004\u0012\u00020#0\"8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%R\u0014\u0010&\u001A\u00020\'8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b(\u0010)R(\u0010*\u001A\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.¢\u0006\u000E\n\u0000\u0012\u0004\b/\u00100\u001A\u0004\b1\u00102R\u0014\u0010<\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b=\u0010>¨\u0006S"}, d2={"Landroidx/compose/ui/platform/AndroidComposeView$RootModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/relocation/BringIntoViewModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/layout/WindowInsetsRulerProvider;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "insetsValues", "Landroidx/collection/ScatterMap;", "", "Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "getInsetsValues", "()Landroidx/collection/ScatterMap;", "generation", "Landroidx/compose/runtime/MutableIntState;", "getGeneration", "()Landroidx/compose/runtime/MutableIntState;", "previousGeneration", "", "getPreviousGeneration", "()I", "setPreviousGeneration", "(I)V", "cutoutRects", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Rect;", "getCutoutRects", "()Landroidx/collection/MutableObjectList;", "cutoutRulers", "", "Landroidx/compose/ui/layout/RectRulers;", "getCutoutRulers", "()Ljava/util/List;", "insetsListener", "Landroidx/compose/ui/layout/InsetsListener;", "getInsetsListener", "()Landroidx/compose/ui/layout/InsetsListener;", "rulerLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRulerLambda$annotations", "()V", "getRulerLambda", "()Lkotlin/jvm/functions/Function1;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "traverseKey", "getTraverseKey", "()Ljava/lang/Object;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "bringIntoView", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRotaryScrollEvent", "", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "onPreRotaryScrollEvent", "onPreKeyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onPreKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onKeyEvent", "onKeyEvent-ZmokQxo", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class RootModifierNode extends Node implements KeyInputModifierNode, RotaryInputModifierNode, WindowInsetsRulerProvider, LayoutModifierNode, SemanticsModifierNode, TraversableNode, BringIntoViewModifierNode {
        private int previousGeneration;
        private final Function1 rulerLambda;

        public RootModifierNode(AndroidComposeView arg1) {
            AndroidComposeView.this = arg1;
            super();
            this.previousGeneration = -1;
            this.rulerLambda = new AndroidComposeView$RootModifierNode$rulerLambda$1(this);
        }

        public void applySemantics(SemanticsPropertyReceiver arg1) {
        }

        public Object bringIntoView(LayoutCoordinates arg3, Function0 arg4, Continuation arg5) {
            long v0 = LayoutCoordinatesKt.positionInRoot(arg3);
            Object v3 = arg4.invoke();
            Rect v3_1 = v3 != null ? ((Rect)v3).translate-k-4lQ0M(v0) : null;
            if(v3_1 != null) {
                AndroidComposeView.this.requestRectangleOnScreen(RectHelper_androidKt.toAndroidRect(v3_1), false);
            }

            return Unit.INSTANCE;
        }

        public MutableObjectList getCutoutRects() {
            return this.getInsetsListener().getDisplayCutouts();
        }

        public List getCutoutRulers() {
            return this.getInsetsListener().getDisplayCutoutRulers();
        }

        public final MutableIntState getGeneration() {
            return this.getInsetsListener().getGeneration();
        }

        public InsetsListener getInsetsListener() {
            return AndroidComposeView.this.getInsetsListener();
        }

        public ScatterMap getInsetsValues() {
            return this.getInsetsListener().getInsetsValues();
        }

        public final int getPreviousGeneration() {
            return this.previousGeneration;
        }

        public final Function1 getRulerLambda() {
            return this.rulerLambda;
        }

        public static void getRulerLambda$annotations() {
        }

        public Object getTraverseKey() {
            return "androidx.compose.ui.layout.WindowInsetsRulers";
        }

        public MeasureResult measure-3p2s80s(MeasureScope arg9, Measurable arg10, long arg11) {
            Placeable v10 = arg10.measure-BRTryo0(arg11);
            return MeasureScope.layout$default(arg9, v10.getWidth(), v10.getHeight(), null, this.rulerLambda, new AndroidComposeView$RootModifierNode$measure$1(v10), 4, null);
        }

        public boolean onKeyEvent-ZmokQxo(KeyEvent arg9) {
            Integer v9_3;
            FocusDirection v0 = FocusInteropUtils_androidKt.toFocusDirection-ZmokQxo(arg9);
            if(v0 != null) {
                if(!KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg9), KeyEventType.Companion.getKeyDown-CS__XNY())) {
                }
                else {
                    String v2 = "null cannot be cast to non-null type android.view.ViewGroup";
                    if(ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
                        FocusTargetNode v9 = AndroidComposeView.this.getFocusOwner().getActiveFocusTargetNode();
                        if(v9 != null && (v9.isInteropViewHost()) && (AndroidComposeView.this.moveFocusInChildren-3ESFkO8(v0.unbox-impl()))) {
                            return 1;
                        }

                        Boolean v9_1 = AndroidComposeView.this.getFocusOwner().focusSearch-ULY8qGw(v0.unbox-impl(), AndroidComposeView.this.getEmbeddedViewFocusRect(), new AndroidComposeView$RootModifierNode$onKeyEvent$focusWasMovedOrCancelled$1(v0));
                        boolean v9_2 = v9_1 != null ? v9_1.booleanValue() : true;
                        if(v9_2) {
                            return 1;
                        }

                        if(FocusOwnerImplKt.is1dFocusSearch-3ESFkO8(v0.unbox-impl())) {
                            v9_3 = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(v0.unbox-impl());
                            int v9_4 = v9_3 != null ? v9_3.intValue() : 2;
                            FocusFinder v3 = FocusFinder.getInstance();
                            View v4 = AndroidComposeView.this.getRootView();
                            Intrinsics.checkNotNull(v4, v2);
                            View v9_5 = v3.findNextFocus(((ViewGroup)v4), AndroidComposeView.this.getView(), v9_4);
                            if(v9_5 != null && !Intrinsics.areEqual(v9_5, AndroidComposeView.this)) {
                                return 0;
                            }

                            return AndroidComposeView.this.getFocusOwner().resetFocus-3ESFkO8(v0.unbox-impl());
                        }

                        return 0;
                    }
                    else {
                        v9_3 = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(v0.unbox-impl());
                        if((ComposeUiFlags.isViewFocusFixEnabled) && (AndroidComposeView.this.hasFocus()) && v9_3 != null && (AndroidComposeView.this.moveFocusInChildren-3ESFkO8(v0.unbox-impl()))) {
                            return 1;
                        }

                        Rect v4_1 = AndroidComposeView.this.getEmbeddedViewFocusRect();
                        Boolean v5 = AndroidComposeView.this.getFocusOwner().focusSearch-ULY8qGw(v0.unbox-impl(), v4_1, new AndroidComposeView$RootModifierNode$onKeyEvent$focusWasMovedOrCancelled$2(v0));
                        boolean v5_1 = v5 != null ? v5.booleanValue() : true;
                        if(v5_1) {
                            return 1;
                        }

                        if(!FocusOwnerImplKt.is1dFocusSearch-3ESFkO8(v0.unbox-impl())) {
                            return 0;
                        }

                        Rect v5_2 = null;
                        if(v9_3 != null) {
                            View v6 = AndroidComposeView.this.findNextNonChildView(v9_3.intValue());
                            if(!Intrinsics.areEqual(v6, AndroidComposeView.this)) {
                            }
                            else {
                                v6 = ((View)v5_2);
                            }

                            if(v6 == null) {
                                goto label_126;
                            }

                            android.graphics.Rect v4_2 = v4_1 != null ? RectHelper_androidKt.toAndroidRect(v4_1) : ((android.graphics.Rect)v5_2);
                            if(v4_2 != null) {
                                View v7 = AndroidComposeView.this.getRootView();
                                Intrinsics.checkNotNull(v7, v2);
                                ((ViewGroup)v7).offsetDescendantRectToMyCoords(AndroidComposeView.this.getView(), v4_2);
                                ((ViewGroup)v7).offsetRectIntoDescendantCoords(v6, v4_2);
                                if(!FocusInteropUtils_androidKt.requestInteropFocus(v6, v9_3, v4_2)) {
                                    goto label_126;
                                }

                                return 1;
                            }

                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid rect");
                            throw new KotlinNothingValueException();
                        }

                    label_126:
                        if(!AndroidComposeView.this.getFocusOwner().clearFocus-I7lrPNg(false, true, false, v0.unbox-impl())) {
                            return 1;
                        }

                        Boolean v8 = AndroidComposeView.this.getFocusOwner().focusSearch-ULY8qGw(v0.unbox-impl(), v5_2, new AndroidComposeView$RootModifierNode$onKeyEvent$1(v0));
                        if(v8 != null) {
                            return v8.booleanValue();
                        }

                        return 1;
                    }
                }
            }

            return 0;
        }

        public boolean onPreKeyEvent-ZmokQxo(KeyEvent arg1) {
            return 0;
        }

        public boolean onPreRotaryScrollEvent(RotaryScrollEvent arg1) {
            return 0;
        }

        public boolean onRotaryScrollEvent(RotaryScrollEvent arg1) {
            return 0;
        }

        public final void setPreviousGeneration(int arg1) {
            this.previousGeneration = arg1;
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2={"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/lifecycle/ViewModelStoreOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "getViewModelStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;
        private final ViewModelStoreOwner viewModelStoreOwner;

        static {
        }

        public ViewTreeOwners(LifecycleOwner arg1, SavedStateRegistryOwner arg2, ViewModelStoreOwner arg3) {
            super();
            this.lifecycleOwner = arg1;
            this.savedStateRegistryOwner = arg2;
            this.viewModelStoreOwner = arg3;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }

        public final ViewModelStoreOwner getViewModelStoreOwner() {
            return this.viewModelStoreOwner;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final AndroidAutofillManager _autofillManager;
    private final InputModeManagerImpl _inputModeManager;
    private View _rootView;
    private final MutableState _viewTreeOwners$delegate;
    private final LazyWindowInfo _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private static Method addChangeCallbackMethod;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboard clipboard;
    private final AndroidClipboardManager clipboardManager;
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private static final MutableObjectList composeViews;
    private final MutableState configuration$delegate;
    private AndroidContentCaptureManager contentCaptureManager;
    private CoroutineContext coroutineContext;
    private float currentFrameRate;
    private float currentFrameRateCategory;
    private final MutableState density$delegate;
    private final MutableObjectList dirtyLayers;
    private static Method dispatchOnScrollChangedMethod;
    private final AndroidDragAndDropManager dragAndDropManager;
    private final MutableObjectList endApplyChangesListeners;
    private final FocusOwner focusOwner;
    private final MutableState fontFamilyResolver$delegate;
    private final ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private FrameEndScheduler frameEndScheduler;
    private View frameRateCategoryView;
    private static Method getBooleanMethod;
    private long globalPosition;
    private final GraphicsContext graphicsContext;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private final IndirectPointerNavigationGestureDetector indirectPointerNavigationGestureDetector;
    private final InsetsListener insetsListener;
    private final boolean isArrEnabled;
    private boolean isDrawingContent;
    private boolean isPendingInteropViewLayoutChangeDispatch;
    private boolean isRenderNodeCompatible;
    private int keepScreenOnCount;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache layerCache;
    private final MutableState layoutDirection$delegate;
    private final MutableIntObjectMap layoutNodes;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private RetainedValuesStoreEntry lifecycleRetainedValuesStoreOwnerEntry;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1 onViewTreeOwnersAvailable;
    private final ArrayDeque outOfFrameQueue;
    private final Runnable outOfFrameRunnable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private MutableObjectList postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private IndirectPointerEventPrimaryDirectionalMotionAxis primaryDirectionalMotionAxisOverride;
    private boolean processingRequestFocusForNextNonChildView;
    private final RectManager rectManager;
    private long relayoutTime;
    private final Function0 resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private RetainedValuesStore retainedValuesStore;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final EmptySemanticsModifier rootSemanticsNode;
    private final ScrollCapture scrollCapture;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private int sensitiveComponentCount;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete;
    private static Runnable systemPropertiesChangedRunnable;
    private static Class systemPropertiesClass;
    private final TextInputService textInputService;
    private final AtomicReference textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private UncaughtExceptionHandler uncaughtExceptionHandler;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;
    private final State viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    static {
        AndroidComposeView.Companion = new Companion(null);
        AndroidComposeView.$stable = 8;
        AndroidComposeView.composeViews = new MutableObjectList(0, 1, null);
    }

    public AndroidComposeView(Context arg17, CoroutineContext arg18) {
        CalculateMatrixToWindowApi29 v8_2;
        AndroidAutofillManager v10;
        AndroidComposeView v0 = this;
        Context v1 = arg17;
        super(arg17);
        v0.lastDownPointerPosition = Offset.Companion.getUnspecified-F1C5BW0();
        v0.superclassInitComplete = true;
        CanvasDrawScope v4 = null;
        v0.sharedDrawScope = new LayoutNodeDrawScope(v4, 1, ((DefaultConstructorMarker)v4));
        v0.retainedValuesStore = ForgetfulRetainedValuesStore.INSTANCE;
        v0.outOfFrameQueue = new ArrayDeque();
        v0.outOfFrameRunnable = new AndroidComposeView$$ExternalSyntheticLambda0(v0);
        v0.density$delegate = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(v1), SnapshotStateKt.referentialEqualityPolicy());
        boolean v3 = !ComposeUiFlags.isAdaptiveRefreshRateEnabled || Build$VERSION.SDK_INT < 35 ? false : true;
        v0.isArrEnabled = v3;
        EmptySemanticsModifier v6 = new EmptySemanticsModifier();
        v0.rootSemanticsNode = v6;
        AndroidComposeView v9 = v0;
        v0.focusOwner = new FocusOwnerImpl(v0, ((Owner)v9));
        v0.coroutineContext = arg18;
        v0.dragAndDropManager = new AndroidDragAndDropManager(new AndroidComposeView$dragAndDropManager$1(v0));
        v0._windowInfo = new LazyWindowInfo();
        v0.canvasHolder = new CanvasHolder();
        v0.viewConfiguration = new AndroidViewConfiguration(android.view.ViewConfiguration.get(v1));
        v0.insetsListener = new InsetsListener(v0);
        LayoutNode v7 = new LayoutNode(false, 0, 3, ((DefaultConstructorMarker)v4));
        v7.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        v7.setDensity(v0.getDensity());
        v7.setViewConfiguration(v0.getViewConfiguration());
        v7.setModifier(new AndroidComposeView$root$1$1(v0).then(v0.getFocusOwner().getModifier()).then(v0.getDragAndDropManager().getModifier()));
        v0.root = v7;
        v0.layoutNodes = IntObjectMapKt.mutableIntObjectMapOf();
        v0.rectManager = new RectManager(v0.getLayoutNodes());
        v0.rootForTest = v0;
        v0.semanticsOwner = new SemanticsOwner(v0.getRoot(), v6, v0.getLayoutNodes());
        AndroidComposeViewAccessibilityDelegateCompat v6_1 = new AndroidComposeViewAccessibilityDelegateCompat(v0);
        v0.composeAccessibilityDelegate = v6_1;
        v0.contentCaptureManager = new AndroidContentCaptureManager(v0, new AndroidComposeView$contentCaptureManager$1(v0));
        v0.accessibilityManager = new AndroidAccessibilityManager(v1);
        v0.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext(v0);
        v0.autofillTree = new AutofillTree();
        v0.dirtyLayers = new MutableObjectList(0, 1, ((DefaultConstructorMarker)v4));
        v0.motionEventAdapter = new MotionEventAdapter();
        v0.pointerInputEventProcessor = new PointerInputEventProcessor(v0.getRoot());
        int v8 = 2;
        v0.configuration$delegate = SnapshotStateKt.mutableStateOf$default(new Configuration(v1.getResources().getConfiguration()), ((SnapshotMutationPolicy)v4), v8, v4);
        AndroidAutofill v7_1 = v0.autofillSupported() ? new AndroidAutofill(v0, v0.getAutofillTree()) : ((AndroidAutofill)v4);
        v0._autofill = v7_1;
        if(v0.autofillSupported()) {
            Object v7_2 = v1.getSystemService(AutofillManager.class);
            if(v7_2 != null) {
                v10 = new AndroidAutofillManager(new PlatformAutofillManagerImpl(((AutofillManager)v7_2)), v0.getSemanticsOwner(), v0, v0.getRectManager(), v1.getPackageName());
            }
            else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Autofill service could not be located.");
                throw new KotlinNothingValueException();
            }
        }
        else {
            v10 = ((AndroidAutofillManager)v4);
        }

        v0._autofillManager = v10;
        v0.clipboardManager = new AndroidClipboardManager(v1);
        v0.clipboard = new AndroidClipboard(v0.getClipboardManager());
        v0.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(v0));
        v0.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(v0.getRoot());
        v0.globalPosition = IntOffset.constructor-impl(0x7FFFFFFF7FFFFFFFL);
        v0.tmpPositionArray = new int[]{0, 0};
        float[] v7_3 = Matrix.constructor-impl$default(((float[])v4), 1, ((DefaultConstructorMarker)v4));
        v0.tmpMatrix = v7_3;
        v0.viewToWindowMatrix = Matrix.constructor-impl$default(((float[])v4), 1, ((DefaultConstructorMarker)v4));
        v0.windowToViewMatrix = Matrix.constructor-impl$default(((float[])v4), 1, ((DefaultConstructorMarker)v4));
        v0.lastMatrixRecalculationAnimationTime = -1;
        v0.windowPosition = Offset.Companion.getInfinite-F1C5BW0();
        v0.isRenderNodeCompatible = true;
        v0._viewTreeOwners$delegate = SnapshotStateKt.mutableStateOf$default(v4, ((SnapshotMutationPolicy)v4), v8, v4);
        v0.viewTreeOwners$delegate = SnapshotStateKt.derivedStateOf(new AndroidComposeView$viewTreeOwners$2(v0));
        TextInputServiceAndroid v10_1 = new TextInputServiceAndroid(v0.getView(), v0);
        v0.legacyTextInputServiceAndroid = v10_1;
        v0.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(v10_1));
        v0.textInputSessionMutex = SessionMutex.constructor-impl();
        v0.softwareKeyboardController = new DelegatingSoftwareKeyboardController(v0.getTextInputService());
        v0.fontLoader = new AndroidFontResourceLoader(v1);
        v0.fontFamilyResolver$delegate = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(v1), SnapshotStateKt.referentialEqualityPolicy());
        LayoutDirection v10_2 = FocusInteropUtils_androidKt.toLayoutDirection(v1.getResources().getConfiguration().getLayoutDirection());
        if(v10_2 == null) {
            v10_2 = LayoutDirection.Ltr;
        }

        v0.layoutDirection$delegate = SnapshotStateKt.mutableStateOf$default(v10_2, ((SnapshotMutationPolicy)v4), v8, v4);
        AndroidComposeView v10_3 = v0;
        v0.hapticFeedBack = new PlatformHapticFeedback(((View)v10_3));
        int v11 = v0.isInTouchMode() ? InputMode.Companion.getTouch-aOaMEAU() : InputMode.Companion.getKeyboard-aOaMEAU();
        v0._inputModeManager = new InputModeManagerImpl(v11, new AndroidComposeView$_inputModeManager$1(v0), ((DefaultConstructorMarker)v4));
        v0.modifierLocalManager = new ModifierLocalManager(((Owner)v9));
        v0.textToolbar = new AndroidTextToolbar(((View)v10_3));
        v0.layerCache = new WeakCache();
        v0.endApplyChangesListeners = new MutableObjectList(0, 1, ((DefaultConstructorMarker)v4));
        v0.resendMotionEventRunnable = new AndroidComposeView$resendMotionEventRunnable$1(v0);
        v0.sendHoverExitEvent = new AndroidComposeView$$ExternalSyntheticLambda1(v0);
        v0.indirectPointerNavigationGestureDetector = new IndirectPointerNavigationGestureDetector(v1, new AndroidComposeView$indirectPointerNavigationGestureDetector$1(v0));
        v0.resendMotionEventOnLayout = new AndroidComposeView$resendMotionEventOnLayout$1(v0);
        v11 = 29;
        if(Build$VERSION.SDK_INT < v11) {
            CalculateMatrixToWindowApi21 v8_1 = new CalculateMatrixToWindowApi21(v7_3, ((DefaultConstructorMarker)v4));
        }
        else {
            v8_2 = new CalculateMatrixToWindowApi29();
        }

        v0.matrixToWindow = ((CalculateMatrixToWindow)v8_2);
        v0.addOnAttachStateChangeListener(v0.contentCaptureManager);
        v0.setWillNotDraw(false);
        v0.setFocusable(true);
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(((View)v10_3), 1, false);
        v0.setFocusableInTouchMode(true);
        v0.setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(((View)v10_3), ((AccessibilityDelegateCompat)v6_1));
        Function1 v5 = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if(v5 != null) {
            v5.invoke(v0);
        }

        v0.setOnDragListener(v0.getDragAndDropManager());
        v0.getRoot().attach$ui(((Owner)v9));
        if(Build$VERSION.SDK_INT >= v11) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(((View)v10_3));
        }

        if(v3) {
            View v3_1 = new View(v1);
            v3_1.setLayoutParams(new ViewGroup$LayoutParams(1, 1));
            v3_1.setTag(id.hide_in_inspector_tag, Boolean.valueOf(true));
            v0.frameRateCategoryView = v3_1;
            v0.addView(v3_1);
        }

        if(Build$VERSION.SDK_INT >= 0x1F) {
            ScrollCapture v4_1 = new ScrollCapture();
        }

        v0.scrollCapture = ((ScrollCapture)v4);
        v0.pointerIconService = new AndroidComposeView$pointerIconService$1(v0);
    }

    public static final void access$addExtraDataToAccessibilityNodeInfoHelper(AndroidComposeView arg0, int arg1, AccessibilityNodeInfo arg2, String arg3) {
        arg0.addExtraDataToAccessibilityNodeInfoHelper(arg1, arg2, arg3);
    }

    public static final boolean access$dispatchGenericMotionEvent$s408734394(AndroidComposeView arg0, MotionEvent arg1) {
        return super.dispatchGenericMotionEvent(arg1);
    }

    public static final boolean access$dispatchKeyEvent$s408734394(AndroidComposeView arg0, KeyEvent arg1) {
        return super.dispatchKeyEvent(arg1);
    }

    public static final View access$findNextNonChildView(AndroidComposeView arg0, int arg1) {
        return arg0.findNextNonChildView(arg1);
    }

    public static final Method access$getAddChangeCallbackMethod$cp() {
        return AndroidComposeView.addChangeCallbackMethod;
    }

    public static final AndroidComposeViewAccessibilityDelegateCompat access$getComposeAccessibilityDelegate$p(AndroidComposeView arg0) {
        return arg0.composeAccessibilityDelegate;
    }

    public static final MutableObjectList access$getComposeViews$cp() {
        return AndroidComposeView.composeViews;
    }

    public static final Method access$getDispatchOnScrollChangedMethod$cp() {
        return AndroidComposeView.dispatchOnScrollChangedMethod;
    }

    public static final Method access$getGetBooleanMethod$cp() {
        return AndroidComposeView.getBooleanMethod;
    }

    public static final MotionEvent access$getPreviousMotionEvent$p(AndroidComposeView arg0) {
        return arg0.previousMotionEvent;
    }

    public static final long access$getRelayoutTime$p(AndroidComposeView arg2) {
        return arg2.relayoutTime;
    }

    public static final AndroidComposeView$resendMotionEventRunnable$1 access$getResendMotionEventRunnable$p(AndroidComposeView arg0) {
        return arg0.resendMotionEventRunnable;
    }

    public static final Runnable access$getSystemPropertiesChangedRunnable$cp() {
        return AndroidComposeView.systemPropertiesChangedRunnable;
    }

    public static final Class access$getSystemPropertiesClass$cp() {
        return AndroidComposeView.systemPropertiesClass;
    }

    public static final ViewTreeOwners access$get_viewTreeOwners(AndroidComposeView arg0) {
        return arg0.get_viewTreeOwners();
    }

    public static final void access$sendSimulatedEvent(AndroidComposeView arg0, MotionEvent arg1, int arg2, long arg3, boolean arg5) {
        arg0.sendSimulatedEvent(arg1, arg2, arg3, arg5);
    }

    public static final void access$setAddChangeCallbackMethod$cp(Method arg0) {
        AndroidComposeView.addChangeCallbackMethod = arg0;
    }

    public static final void access$setDispatchOnScrollChangedMethod$cp(Method arg0) {
        AndroidComposeView.dispatchOnScrollChangedMethod = arg0;
    }

    public static final void access$setGetBooleanMethod$cp(Method arg0) {
        AndroidComposeView.getBooleanMethod = arg0;
    }

    public static final void access$setRelayoutTime$p(AndroidComposeView arg0, long arg1) {
        arg0.relayoutTime = arg1;
    }

    public static final void access$setSystemPropertiesChangedRunnable$cp(Runnable arg0) {
        AndroidComposeView.systemPropertiesChangedRunnable = arg0;
    }

    public static final void access$setSystemPropertiesClass$cp(Class arg0) {
        AndroidComposeView.systemPropertiesClass = arg0;
    }

    public static final boolean access$startDrag-12SF9DM(AndroidComposeView arg0, DragAndDropTransferData arg1, long arg2, Function1 arg4) {
        return arg0.startDrag-12SF9DM(arg1, arg2, arg4);
    }

    public final void addAndroidView(AndroidViewHolder arg3, LayoutNode arg4) {
        this.getAndroidViewsHandler$ui().getHolderToLayoutNode().put(arg3, arg4);
        this.getAndroidViewsHandler$ui().addView(arg3);
        this.getAndroidViewsHandler$ui().getLayoutNodeToHolder().put(arg4, arg3);
        arg3.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(arg3, new AndroidComposeView$addAndroidView$1(this, arg4, this));
    }

    private final void addExtraDataToAccessibilityNodeInfoHelper(int arg4, AccessibilityNodeInfo arg5, String arg6) {
        int v3;
        boolean v0 = Intrinsics.areEqual(arg6, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal$ui());
        AndroidComposeViewAccessibilityDelegateCompat v1 = this.composeAccessibilityDelegate;
        int v2 = -1;
        if(v0) {
            v3 = v1.getIdToBeforeMap$ui().getOrDefault(arg4, v2);
            if(v3 != v2) {
                arg5.getExtras().putInt(arg6, v3);
                return;
            }
        }
        else if(Intrinsics.areEqual(arg6, v1.getExtraDataTestTraversalAfterVal$ui())) {
            v3 = this.composeAccessibilityDelegate.getIdToAfterMap$ui().getOrDefault(arg4, v2);
            if(v3 != v2) {
                arg5.getExtras().putInt(arg6, v3);
            }
        }
    }

    public void addFocusables(ArrayList arg2, int arg3, int arg4) {
        if(ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            if(this.getFocusOwner().hasFocusableContent()) {
                super.addFocusables(arg2, arg3, arg4);
                if(!this.getFocusOwner().hasNonInteropFocusableContent() && arg2 != null) {
                    arg2.remove(this);
                }
            }

            return;
        }

        super.addFocusables(arg2, arg3, arg4);
    }

    public void addView(View arg2) {
        this.addView(arg2, -1);
    }

    public void addView(View arg2, int arg3) {
        Intrinsics.checkNotNull(arg2);
        ViewGroup$LayoutParams v0 = arg2.getLayoutParams();
        if(v0 == null) {
            v0 = this.generateDefaultLayoutParams();
        }

        this.addView(arg2, arg3, v0);
    }

    public void addView(View arg2, int arg3, ViewGroup$LayoutParams arg4) {
        this.addViewInLayout(arg2, arg3, arg4, true);
    }

    public void addView(View arg2, int arg3, int arg4) {
        ViewGroup$LayoutParams v0 = this.generateDefaultLayoutParams();
        v0.width = arg3;
        v0.height = arg4;
        this.addView(arg2, -1, v0);
    }

    public void addView(View arg2, ViewGroup$LayoutParams arg3) {
        this.addView(arg2, -1, arg3);
    }

    public void autofill(SparseArray arg2) {
        if(this.autofillSupported()) {
            if(ComposeUiFlags.isSemanticAutofillEnabled) {
                AndroidAutofillManager v0 = this._autofillManager;
                if(v0 != null) {
                    v0.performAutofill(arg2);
                }
            }

            AndroidAutofill v1 = this._autofill;
            if(v1 == null) {
                return;
            }

            AndroidAutofill_androidKt.performAutofill(v1, arg2);
        }
    }

    private final boolean autofillSupported() {
        return 1;
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation arg1) {
        Object v0 = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui(arg1);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation arg1) {
        Object v0 = this.contentCaptureManager.boundsUpdatesEventLoop$ui(arg1);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public long calculateLocalPosition-MK-Hz9U(long arg1) {
        this.recalculateWindowPosition();
        return Matrix.map-MK-Hz9U(this.windowToViewMatrix, arg1);
    }

    public long calculatePositionInWindow-MK-Hz9U(long arg1) {
        this.recalculateWindowPosition();
        return Matrix.map-MK-Hz9U(this.viewToWindowMatrix, arg1);
    }

    public boolean canScrollHorizontally(int arg5) {
        return this.composeAccessibilityDelegate.canScroll-0AR0LA0$ui(false, arg5, this.lastDownPointerPosition);
    }

    public boolean canScrollVertically(int arg5) {
        return this.composeAccessibilityDelegate.canScroll-0AR0LA0$ui(true, arg5, this.lastDownPointerPosition);
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode arg1) {
        if(!this.wasMeasuredWithMultipleConstraints) {
            LayoutNode v0 = arg1.getParent$ui();
            if(v0 != null && !v0.getHasFixedInnerContentConstraints$ui()) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    private final void clearChildInvalidObservations(ViewGroup arg5) {
        int v0 = arg5.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = arg5.getChildAt(v1);
            if((v2 instanceof AndroidComposeView)) {
                ((AndroidComposeView)v2).onEndApplyChanges();
            }
            else if((v2 instanceof ViewGroup)) {
                this.clearChildInvalidObservations(((ViewGroup)v2));
            }
        }
    }

    public void clearOwnerFocus() {
        if(!this.isFocused() && ((ComposeUiFlags.isViewFocusFixEnabled) || !this.hasFocus())) {
            if(this.hasFocus()) {
                View v0 = this.findFocus();
                if(v0 != null) {
                    v0.clearFocus();
                }

                super.clearFocus();
            }

            return;
        }

        super.clearFocus();
    }

    private final int component1-VKZWuLQ(long arg1) {
        return ((int)ULong.constructor-impl(arg1 >>> 0x20));
    }

    private final int component2-VKZWuLQ(long arg3) {
        return ((int)ULong.constructor-impl(arg3 & 0xFFFFFFFFL));
    }

    private final long convertMeasureSpec-I7RO_PI(int arg4) {
        int v0 = View$MeasureSpec.getMode(arg4);
        arg4 = View$MeasureSpec.getSize(arg4);
        if(v0 != 0x80000000) {
            if(v0 != 0) {
                if(v0 == 0x40000000) {
                    return this.pack-ZIaKswc(arg4, arg4);
                }

                throw new IllegalStateException();
            }

            return this.pack-ZIaKswc(0, 0x7FFFFFFF);
        }

        return this.pack-ZIaKswc(0, arg4);
    }

    public OwnedLayer createLayer(Function2 arg8, Function0 arg9, GraphicsLayer arg10) {
        if(arg10 != null) {
            return new GraphicsLayerOwnerLayer(arg10, null, this, arg8, arg9);
        }

        AndroidComposeView v3 = this;
        Function2 v4 = arg8;
        Function0 v5 = arg9;
        Object v7 = v3.layerCache.pop();
        if(v7 != null) {
            ((OwnedLayer)v7).reuseLayer(v4, v5);
            return ((OwnedLayer)v7);
        }

        return new GraphicsLayerOwnerLayer(v3.getGraphicsContext().createGraphicsLayer(), v3.getGraphicsContext(), v3, v4, v5);
    }

    public void decrementKeepScreenOnCount() {
        --this.keepScreenOnCount;
        View v0 = this.getView();
        boolean v1 = this.keepScreenOnCount > 0 ? true : false;
        v0.setKeepScreenOn(v1);
    }

    public void decrementSensitiveComponentCount() {
        if(Build$VERSION.SDK_INT >= 35) {
            if(this.sensitiveComponentCount == 1) {
                AndroidComposeViewSensitiveContent35.INSTANCE.setContentSensitivity(this.getView(), false);
            }

            --this.sensitiveComponentCount;
        }
    }

    private final void dispatchConfigurationChangeIfNeeded() {
        int v0 = Build$VERSION.SDK_INT;
        if(0x20 <= v0 && v0 < 34) {
            this.updateConfiguration(this.getResources().getConfiguration());
        }
    }

    protected void dispatchDraw(Canvas arg7) {
        View v3_1;
        int v0_2;
        if(!this.isAttachedToWindow()) {
            this.invalidateLayers(this.getRoot());
        }

        Object v3 = null;
        Owner.measureAndLayout$default(this, false, 1, v3);
        Snapshot.Companion.notifyObjectsInitialized();
        this.isDrawingContent = true;
        try {
            CanvasHolder v0_1 = this.canvasHolder;
            Canvas v2 = v0_1.getAndroidCanvas().getInternalCanvas();
            v0_1.getAndroidCanvas().setInternalCanvas(arg7);
            this.getRoot().draw$ui(v0_1.getAndroidCanvas(), ((GraphicsLayer)v3));
            v0_1.getAndroidCanvas().setInternalCanvas(v2);
            if(this.dirtyLayers.isNotEmpty()) {
                v0_2 = this.dirtyLayers.getSize();
                int v2_1;
                for(v2_1 = 0; v2_1 < v0_2; ++v2_1) {
                    this.dirtyLayers.get(v2_1).updateDisplayList();
                }
            }

            if(ViewLayer.Companion.getShouldUseDispatchDraw()) {
                v0_2 = arg7.save();
                arg7.clipRect(0f, 0f, 0f, 0f);
                super.dispatchDraw(arg7);
                arg7.restoreToCount(v0_2);
            }

            this.dirtyLayers.clear();
            this.isDrawingContent = false;
        }
        catch(Throwable v0) {
            UncaughtExceptionHandler v1 = this.uncaughtExceptionHandler;
            if(v1 != null) {
                v1.onUncaughtException(v0);
                goto label_50;
            }

            throw v0;
        }

    label_50:
        MutableObjectList v0_3 = this.postponedDirtyLayers;
        if(v0_3 != null) {
            Intrinsics.checkNotNull(v0_3);
            this.dirtyLayers.addAll(v0_3);
            v0_3.clear();
        }

        if(this.isArrEnabled) {
            Api35Impl.setRequestedFrameRate(this, this.currentFrameRate);
            View v0_4 = this.frameRateCategoryView;
            String v1_1 = "frameRateCategoryView";
            if(v0_4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                v0_4 = ((View)v3);
            }

            Api35Impl.setRequestedFrameRate(v0_4, this.currentFrameRateCategory);
            if(!Float.isNaN(this.currentFrameRateCategory)) {
                v0_4 = this.frameRateCategoryView;
                if(v0_4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                    v0_4 = ((View)v3);
                }

                v0_4.invalidate();
                v0_4 = this.frameRateCategoryView;
                if(v0_4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1_1);
                }
                else {
                    v3_1 = v0_4;
                }

                this.drawChild(arg7, v3_1, this.getDrawingTime());
            }

            this.currentFrameRate = NaNf;
            this.currentFrameRateCategory = NaNf;
        }

        this.getRectManager().dispatchCallbacks();
    }

    public boolean dispatchGenericMotionEvent(MotionEvent arg5) {
        int v2 = 8;
        if(this.hoverExitReceived) {
            this.removeCallbacks(this.sendHoverExitEvent);
            if(arg5.getActionMasked() == v2) {
                this.hoverExitReceived = false;
            }
            else {
                this.sendHoverExitEvent.run();
            }
        }

        if(!this.isBadMotionEvent(arg5)) {
            if(!this.isAttachedToWindow()) {
            }
            else if(arg5.getActionMasked() != v2) {
                if(arg5.isFromSource(0x200000)) {
                    AndroidIndirectPointerEvent v0 = this.motionEventAdapter.convertToIndirectPointerEvent-k92h6UU$ui(arg5, this.primaryDirectionalMotionAxisOverride);
                    if(v0 == null) {
                        this.getFocusOwner().dispatchIndirectPointerCancel();
                        this.indirectPointerNavigationGestureDetector.cancelCurrentEventStream();
                        return 1;
                    }
                    else if(this.handleIndirectPointerEvent(((IndirectPointerEvent)v0))) {
                        return 1;
                    }
                }

                return super.dispatchGenericMotionEvent(arg5);
            }
            else if(arg5.isFromSource(0x400000)) {
                return this.handleRotaryEvent(arg5);
            }
            else if((this.handleMotionEvent-8iAsVTc(arg5) & 1) != 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        return super.dispatchGenericMotionEvent(arg5);
    }

    public boolean dispatchHoverEvent(MotionEvent arg5) {
        if(this.hoverExitReceived) {
            this.removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }

        if(!this.isBadMotionEvent(arg5)) {
            if(!this.isAttachedToWindow()) {
            }
            else {
                this.composeAccessibilityDelegate.dispatchHoverEvent$ui(arg5);
                int v0 = arg5.getActionMasked();
                if(v0 == 7) {
                    if(this.isPositionChanged(arg5)) {
                        goto label_42;
                    }

                    return 0;
                }
                else if(v0 != 10) {
                }
                else if(this.isInBounds(arg5)) {
                    if(arg5.getToolType(0) == 3 && arg5.getButtonState() != 0) {
                        return 0;
                    }

                    MotionEvent v0_1 = this.previousMotionEvent;
                    if(v0_1 != null) {
                        v0_1.recycle();
                    }

                    this.previousMotionEvent = MotionEvent.obtainNoHistory(arg5);
                    this.hoverExitReceived = true;
                    this.postDelayed(this.sendHoverExitEvent, 8);
                    return 0;
                }

            label_42:
                if((this.handleMotionEvent-8iAsVTc(arg5) & 1) == 0) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public boolean dispatchKeyEvent(KeyEvent arg5) {
        if(this.isFocused()) {
            this._windowInfo.setKeyboardModifiers-5xRPYO0(PointerKeyboardModifiers.constructor-impl(arg5.getMetaState()));
            if(!FocusOwner.dispatchKeyEvent-YhN2O0w$default(this.getFocusOwner(), androidx.compose.ui.input.key.KeyEvent.constructor-impl(arg5), null, 2, null)) {
                if(super.dispatchKeyEvent(arg5)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        return this.getFocusOwner().dispatchKeyEvent-YhN2O0w(androidx.compose.ui.input.key.KeyEvent.constructor-impl(arg5), new AndroidComposeView$dispatchKeyEvent$1(this, arg5));
    }

    public boolean dispatchKeyEventPreIme(KeyEvent arg3) {
        if((this.isFocused()) && (this.getFocusOwner().dispatchInterceptedSoftKeyboardEvent-ZmokQxo(androidx.compose.ui.input.key.KeyEvent.constructor-impl(arg3))) || (super.dispatchKeyEventPreIme(arg3))) {
            return 1;
        }

        return 0;
    }

    public void dispatchOnScrollChanged-k-4lQ0M(long arg1) {
        AndroidComposeView.Companion.dispatchOnScrollChanged(this.getViewTreeObserver());
    }

    private final void dispatchPendingInteropLayoutCallbacks() {
        if(this.isPendingInteropViewLayoutChangeDispatch) {
            this.getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    public void dispatchProvideStructure(ViewStructure arg3) {
        if(Build$VERSION.SDK_INT < 28) {
            AndroidComposeViewAssistHelperMethodsO.INSTANCE.setClassName(arg3, this.getView());
            return;
        }

        super.dispatchProvideStructure(arg3);
    }

    public boolean dispatchTouchEvent(MotionEvent arg13) {
        if(this.hoverExitReceived) {
            this.removeCallbacks(this.sendHoverExitEvent);
            MotionEvent v0 = this.previousMotionEvent;
            Intrinsics.checkNotNull(v0);
            if(arg13.getActionMasked() == 0) {
                if(this.hasChangedDevices(arg13, v0)) {
                }
                else {
                    this.hoverExitReceived = false;
                    goto label_16;
                }
            }

            this.sendHoverExitEvent.run();
        }

    label_16:
        if(!this.isBadMotionEvent(arg13)) {
            if(!this.isAttachedToWindow()) {
            }
            else {
                if(arg13.getActionMasked() == 2 && !this.isPositionChanged(arg13)) {
                    return 0;
                }

                int v0_1 = this.handleMotionEvent-8iAsVTc(arg13);
                if((v0_1 & 2) != 0) {
                    this.getParent().requestDisallowInterceptTouchEvent(true);
                }

                int v2 = arg13.getActionMasked() == 0 || arg13.getActionMasked() == 5 ? 1 : 0;
                int v4 = (arg13.isFromSource(0x2002)) || (arg13.isFromSource(0x100008)) ? 1 : 0;
                if(v2 != 0 && v4 != 0) {
                    ViewParent v2_1 = this.getParent();
                    Object v5 = null;
                    if((v2_1 instanceof View)) {
                    }
                    else {
                        v2_1 = ((ViewParent)v5);
                    }

                    if(v2_1 != null) {
                        Object v2_2 = ((View)v2_1).getTag(id.auto_clear_focus_behavior_tag);
                        if(v2_2 == null) {
                            goto label_64;
                        }
                    }
                    else {
                    label_64:
                        AutoClearFocusBehavior v2_3 = AutoClearFocusBehavior.box-impl(AutoClearFocusBehavior.Companion.getDefault-4UtRPd4());
                    }

                    if(!Intrinsics.areEqual(v2_2, AutoClearFocusBehavior.box-impl(AutoClearFocusBehavior.Companion.getCursorBased-4UtRPd4()))) {
                        goto label_93;
                    }

                    FocusTargetNode v2_4 = this.getFocusOwner().getActiveFocusTargetNode();
                    if(v2_4 == null) {
                        goto label_93;
                    }

                    if(LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.requireLayoutCoordinates(((DelegatableNode)v2_4))).contains-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(arg13.getX()))) << 0x20 | (((long)Float.floatToRawIntBits(arg13.getY()))) & 0xFFFFFFFFL))) {
                        goto label_93;
                    }

                    FocusManager.clearFocus$default(this.getFocusOwner(), false, 1, v5);
                }

            label_93:
                if((v0_1 & 1) == 0) {
                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public final void drawAndroidView(AndroidViewHolder arg1, Canvas arg2) {
        this.getAndroidViewsHandler$ui().drawView(arg1, arg2);
    }

    private final View findNextNonChildView(int arg6) {
        View v2_1;
        AndroidComposeView v0 = this;
        FocusFinderCompat v1 = FocusFinderCompat.Companion.getInstance();
        AndroidComposeView v2 = v0;
        do {
        label_4:
            if(v2 == null) {
                return null;
            }

            View v3 = this.getRootView();
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type android.view.ViewGroup");
            v2_1 = v1.findNextFocus(((ViewGroup)v3), v2_1, arg6);
            if(v2_1 == null) {
                goto label_4;
            }
        }
        while(AndroidComposeView_androidKt.access$containsDescendant(((View)v0), v2_1));

        return v2_1;
    }

    private final View findNextViewInEmbeddedView-3ESFkO8(int arg5) {
        FocusTargetNode v0 = this.getFocusOwner().getActiveFocusTargetNode();
        if(v0 != null) {
            Integer v5 = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(arg5);
            if(v5 != null) {
                arg5 = ((Number)v5).intValue();
                View v0_1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)v0)).getInteropView();
                View v1 = this.findFocus();
                FocusFinder v2 = FocusFinder.getInstance();
                View v4 = this.getRootView();
                Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type android.view.ViewGroup");
                v4 = v2.findNextFocus(((ViewGroup)v4), v1, arg5);
                if(v4 != null && v0_1 != null && (AndroidComposeView_androidKt.access$containsDescendant(v0_1, v4))) {
                    return v4;
                }

                return null;
            }

            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid focus direction");
            throw new KotlinNothingValueException();
        }

        throw new IllegalStateException("findNextViewInEmbeddedView called when owner does not have anything focused.".toString());
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int arg5, View arg6) {
        if(Build$VERSION.SDK_INT < 29) {
            int v2 = 0;
            Method v0 = Class.forName("android.view.View").getDeclaredMethod("getAccessibilityViewId");
            v0.setAccessible(true);
            if(Intrinsics.areEqual(v0.invoke(arg6), Integer.valueOf(arg5))) {
                return arg6;
            }
            else if((arg6 instanceof ViewGroup)) {
                int v0_1 = ((ViewGroup)arg6).getChildCount();
                while(v2 < v0_1) {
                    View v1 = this.findViewByAccessibilityIdRootedAtCurrentView(arg5, ((ViewGroup)arg6).getChildAt(v2));
                    if(v1 != null) {
                        return v1;
                    }
                    else {
                        ++v2;
                        continue;
                    }

                    return null;
                }
            }
        }

        return null;
    }

    public final View findViewByAccessibilityIdTraversal(int arg8) {
        View v0 = null;
        try {
            if(Build$VERSION.SDK_INT >= 29) {
                Method v1 = Class.forName("android.view.View").getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                v1.setAccessible(true);
                Object v7 = v1.invoke(this, Integer.valueOf(arg8));
                if((v7 instanceof View)) {
                    return ((View)v7);
                }

                return v0;
            }

            return this.findViewByAccessibilityIdRootedAtCurrentView(arg8, this);
        }
        catch(NoSuchMethodException ) {
            return v0;
        }
    }

    public View focusSearch(View arg7, int arg8) {
        Rect v1_1;
        if(arg7 != null) {
            if(this.measureAndLayoutDelegate.getDuringMeasureLayout$ui()) {
            }
            else {
                View v0 = this.getRootView();
                Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type android.view.ViewGroup");
                v0 = FocusFinder.getInstance().findNextFocus(((ViewGroup)v0), arg7, arg8);
                View v1 = null;
                if(v0 == null || !AndroidComposeView_androidKt.access$containsDescendant(this, v0)) {
                    v0 = v1;
                }
                else {
                }

                if((((AndroidComposeView)arg7)) == this) {
                    v1_1 = this.getFocusOwner().getFocusRect();
                    if(v1_1 == null) {
                        v1_1 = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(arg7, this);
                    }
                }
                else {
                    v1_1 = FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(arg7, this);
                }

                FocusDirection v2 = FocusInteropUtils_androidKt.toFocusDirection(arg8);
                int v2_1 = v2 != null ? v2.unbox-impl() : FocusDirection.Companion.getDown-dhqQ-8s();
                ObjectRef v3 = new ObjectRef();
                if(this.getFocusOwner().focusSearch-ULY8qGw(v2_1, v1_1, new AndroidComposeView$focusSearch$searchResult$1(v3)) == null) {
                    return arg7;
                }

                if(v3.element == null) {
                    if(v0 == null) {
                        return super.focusSearch(arg7, arg8);
                    }
                }
                else if(v0 == null) {
                    return this;
                }
                else if(FocusOwnerImplKt.is1dFocusSearch-3ESFkO8(v2_1)) {
                    if(ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
                        return this;
                    }
                    else {
                        return super.focusSearch(arg7, arg8);
                    }
                }
                else if(TwoDimensionalFocusSearchKt.isBetterCandidate-I7lrPNg(FocusTraversalKt.focusRect(v3.element), FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(v0, ((View)this)), v1_1, v2_1)) {
                    return this;
                }

                return v0;
            }
        }

        return super.focusSearch(arg7, arg8);
    }

    public void focusTargetAvailable() {
        if(this.getFocusOwner().getRootState().getHasFocus()) {
            return;
        }

        this.focusableViewAvailable(this);
    }

    public void forceAccessibilityForTesting(boolean arg1) {
        this.composeAccessibilityDelegate.setAccessibilityForceEnabledForTesting$ui(arg1);
    }

    public void forceMeasureTheSubtree(LayoutNode arg1, boolean arg2) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(arg1, arg2);
    }

    public AccessibilityManager getAccessibilityManager() {
        return this.getAccessibilityManager();
    }

    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui() {
        if(this._androidViewsHandler == null) {
            AndroidViewsHandler v0 = new AndroidViewsHandler(this.getContext());
            this._androidViewsHandler = v0;
            this.addView(((View)v0));
            this.requestLayout();
        }

        AndroidViewsHandler v2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(v2);
        return v2;
    }

    public Autofill getAutofill() {
        return this._autofill;
    }

    public androidx.compose.ui.autofill.AutofillManager getAutofillManager() {
        return this._autofillManager;
    }

    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public AndroidClipboard getClipboard() {
        return this.clipboard;
    }

    public Clipboard getClipboard() {
        return this.getClipboard();
    }

    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public ClipboardManager getClipboardManager() {
        return this.getClipboardManager();
    }

    public final Configuration getConfiguration() {
        return this.configuration$delegate.getValue();
    }

    public final AndroidContentCaptureManager getContentCaptureManager$ui() {
        return this.contentCaptureManager;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public Density getDensity() {
        return this.density$delegate.getValue();
    }

    public AndroidDragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    public DragAndDropManager getDragAndDropManager() {
        return this.getDragAndDropManager();
    }

    public Rect getEmbeddedViewFocusRect() {
        if(this.isFocused()) {
            return this.getFocusOwner().getFocusRect();
        }

        View v0 = this.findFocus();
        if(v0 != null) {
            return FocusInteropUtils_androidKt.calculateFocusRectRelativeTo(v0, ((View)this));
        }

        return null;
    }

    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    public void getFocusedRect(android.graphics.Rect arg5) {
        Rect v0 = this.getEmbeddedViewFocusRect();
        if(v0 != null) {
            arg5.left = Math.round(v0.getLeft());
            arg5.top = Math.round(v0.getTop());
            arg5.right = Math.round(v0.getRight());
            arg5.bottom = Math.round(v0.getBottom());
            return;
        }

        if(!Intrinsics.areEqual(this.getFocusOwner().focusSearch-ULY8qGw(FocusDirection.Companion.getDown-dhqQ-8s(), null, AndroidComposeView$getFocusedRect$1.INSTANCE), Boolean.valueOf(true))) {
            arg5.set(0x80000000, 0x80000000, 0x80000000, 0x80000000);
            return;
        }

        super.getFocusedRect(arg5);
    }

    public Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver$delegate.getValue();
    }

    public ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    @Deprecated(message="fontLoader is deprecated, use fontFamilyResolver", replaceWith="<_subannotation>") public static void getFontLoader$annotations() {
    }

    private final int getFontWeightAdjustmentCompat(Configuration arg2) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            return arg2.fontWeightAdjustment;
        }

        return 0;
    }

    public final FrameEndScheduler getFrameEndScheduler$ui() {
        return this.frameEndScheduler;
    }

    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public boolean getHasPendingMeasureOrLayout() {
        if(!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
            if(!this.outOfFrameQueue.isEmpty()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public int getImportantForAutofill() {
        return 1;
    }

    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public final InsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public static void getLastMatrixRecalculationAnimationTime$ui$annotations() {
    }

    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection$delegate.getValue();
    }

    public MutableIntObjectMap getLayoutNodes() {
        return this.layoutNodes;
    }

    public IntObjectMap getLayoutNodes() {
        return this.getLayoutNodes();
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    public OutOfFrameExecutor getOutOfFrameExecutor() {
        return this.getOutOfFrameExecutor();
    }

    public AndroidComposeView getOutOfFrameExecutor() {
        if(this.isAttachedToWindow()) {
            return this;
        }

        return null;
    }

    public PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(((Owner)this));
    }

    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final IndirectPointerEventPrimaryDirectionalMotionAxis getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui() {
        return this.primaryDirectionalMotionAxisOverride;
    }

    public static void getPrimaryDirectionalMotionAxisOverride-dqNNBbU$ui$annotations() {
    }

    public RectManager getRectManager() {
        return this.rectManager;
    }

    public RetainedValuesStore getRetainedValuesStore() {
        return this.retainedValuesStore;
    }

    public LayoutNode getRoot() {
        return this.root;
    }

    public static void getRoot$annotations() {
    }

    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    public final boolean getScrollCaptureInProgress$ui() {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            ScrollCapture v3 = this.scrollCapture;
            if(v3 != null) {
                return v3.getScrollCaptureInProgress();
            }
        }

        return 0;
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    public boolean getShowLayoutBounds() {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.INSTANCE.isShowingLayoutBounds(((View)this));
        }

        return this.showLayoutBounds;
    }

    public static void getShowLayoutBounds$annotations() {
    }

    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Deprecated(message="Use PlatformTextInputModifierNode instead.") public static void getTextInputService$annotations() {
    }

    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final UncaughtExceptionHandler getUncaughtExceptionHandler$ui() {
        return this.uncaughtExceptionHandler;
    }

    public View getView() {
        return this;
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return this.viewTreeOwners$delegate.getValue();
    }

    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    public final AndroidAutofillManager get_autofillManager$ui() {
        return this._autofillManager;
    }

    private final ViewTreeOwners get_viewTreeOwners() {
        return this._viewTreeOwners$delegate.getValue();
    }

    private final boolean handleIndirectPointerEvent(IndirectPointerEvent arg3) {
        boolean v0 = this.getFocusOwner().dispatchIndirectPointerEvent(arg3);
        if(ComposeUiFlags.isIndirectPointerNavigationGestureDetectorEnabled) {
            this.indirectPointerNavigationGestureDetector.onIndirectPointerEvent(arg3, v0);
            return 1;
        }

        return v0;
    }

    private final int handleMotionEvent-8iAsVTc(MotionEvent arg17) {
        int v0_2;
        int v3;
        Object v8;
        int v7;
        long v4;
        int v2_1;
        MotionEvent v15;
        int v12;
        MotionEvent v2;
        int v10;
        AndroidComposeView v1 = this;
        MotionEvent v0 = arg17;
        v1.removeCallbacks(v1.resendMotionEventRunnable);
        try {
            this.recalculateWindowPosition(arg17);
            v10 = 1;
            v1.forceUseMatrixCache = true;
            v1.measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
        }
        catch(Throwable v0_1) {
            goto label_134;
        }

        try {
            int v11 = v0.getActionMasked();
            v2 = v1.previousMotionEvent;
            v12 = 3;
            if(v2 == null) {
                goto label_19;
            }
            else if(v2.getToolType(0) == v12) {
            }
            else {
                goto label_19;
            }
        }
        catch(Throwable v0_1) {
            goto label_131;
        }

        int v13 = 1;
        goto label_20;
    label_19:
        v13 = 0;
    label_20:
        int v14 = 10;
        if(v2 != null) {
            try {
                if(!v1.hasChangedDevices(v0, v2)) {
                    goto label_40;
                }
                else if(v1.isDevicePressEvent(v2)) {
                }
                else {
                    goto label_29;
                }
            }
            catch(Throwable v0_1) {
                goto label_128;
            }

            try {
                v1.pointerInputEventProcessor.processCancel();
                goto label_40;
            }
            catch(Throwable v0_1) {
                goto label_131;
            }

            try {
            label_29:
                if(v2.getActionMasked() == v14 || v13 == 0) {
                label_40:
                    v15 = v2;
                }
                else {
                    AndroidComposeView.sendSimulatedEvent$default(v1, v2, 10, v2.getEventTime(), false, 8, null);
                    v15 = v2;
                }

            label_41:
                int v1_1 = v0.getToolType(0) == v12 ? 1 : 0;
                v2_1 = 9;
                if(v13 != 0) {
                    goto label_64;
                }
                else if(v1_1 == 0) {
                    goto label_64;
                }
                else if(v11 == v12) {
                    goto label_64;
                }
                else if(v11 == v2_1) {
                    goto label_64;
                }
                else if(this.isInBounds(arg17)) {
                    v4 = v0.getEventTime();
                    v7 = 8;
                    v8 = null;
                    v3 = 9;
                    v1_1 = v2_1;
                    v2 = v0;
                    v0_2 = v1_1;
                    v1 = this;
                    goto label_62;
                }
                else {
                    goto label_64;
                }
            }
            catch(Throwable v0_1) {
            label_128:
                v1 = this;
                goto label_131;
            }
        }
        else {
            goto label_40;
        }

        goto label_41;
        try {
        label_62:
            AndroidComposeView.sendSimulatedEvent$default(v1, v2, v3, v4, false, v7, v8);
            goto label_66;
        label_64:
            v1 = this;
            v0_2 = v2_1;
        label_66:
            if(v15 != null) {
                v15.recycle();
            }

            v2 = v1.previousMotionEvent;
            if(v2 != null && v2.getAction() == v14) {
                v2 = v1.previousMotionEvent;
                v2_1 = v2 != null ? v2.getPointerId(0) : -1;
                if(arg17.getAction() == v0_2 && arg17.getHistorySize() == 0) {
                    if(v2_1 >= 0) {
                        v1.motionEventAdapter.endStream(v2_1);
                    }
                    else {
                    }

                    goto label_121;
                }

                if(arg17.getAction() != 0) {
                    goto label_121;
                }

                if(arg17.getHistorySize() != 0) {
                    goto label_121;
                }

                v0 = v1.previousMotionEvent;
                float v3_1 = NaNf;
                float v0_3 = v0 != null ? v0.getX() : v3_1;
                MotionEvent v4_1 = v1.previousMotionEvent;
                if(v4_1 != null) {
                    v3_1 = v4_1.getY();
                }

                float v4_2 = arg17.getX();
                float v5 = arg17.getY();
                v0_2 = v0_3 != v4_2 || v3_1 != v5 ? 1 : 0;
                MotionEvent v3_2 = v1.previousMotionEvent;
                long v3_3 = v3_2 != null ? v3_2.getEventTime() : -1;
                if(v3_3 != arg17.getEventTime()) {
                }
                else {
                    v10 = 0;
                }

                if(v0_2 == 0 && v10 == 0) {
                    goto label_121;
                }

                if(v2_1 >= 0) {
                    v1.motionEventAdapter.endStream(v2_1);
                }

                v1.pointerInputEventProcessor.clearPreviouslyHitModifierNodes();
            }

        label_121:
            v1.previousMotionEvent = MotionEvent.obtainNoHistory(arg17);
            v0_2 = this.sendMotionEvent-8iAsVTc(arg17);
            goto label_124;
        }
        catch(Throwable v0_1) {
        }

        try {
        label_131:
            Trace.endSection();
            throw v0_1;
        label_124:
            Trace.endSection();
        }
        catch(Throwable v0_1) {
        label_134:
            v1.forceUseMatrixCache = false;
            throw v0_1;
        }

        v1.forceUseMatrixCache = false;
        return v0_2;
    }

    private final boolean handleRotaryEvent(MotionEvent arg9) {
        android.view.ViewConfiguration v0 = android.view.ViewConfiguration.get(this.getContext());
        float v1 = -arg9.getAxisValue(26);
        return this.getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(v0, this.getContext()) * v1, v1 * ViewConfigurationCompat.getScaledHorizontalScrollFactor(v0, this.getContext()), arg9.getEventTime(), arg9.getDeviceId()), new AndroidComposeView$handleRotaryEvent$1(this, arg9));
    }

    private final boolean hasChangedDevices(MotionEvent arg2, MotionEvent arg3) {
        if(arg3.getSource() == arg2.getSource()) {
            if(arg3.getToolType(0) != arg2.getToolType(0)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void incrementKeepScreenOnCount() {
        boolean v1 = true;
        ++this.keepScreenOnCount;
        View v0 = this.getView();
        if(this.keepScreenOnCount > 0) {
        }
        else {
            v1 = false;
        }

        v0.setKeepScreenOn(v1);
    }

    public void incrementSensitiveComponentCount() {
        if(Build$VERSION.SDK_INT >= 35) {
            if(this.sensitiveComponentCount == 0) {
                AndroidComposeViewSensitiveContent35.INSTANCE.setContentSensitivity(this.getView(), true);
            }

            ++this.sensitiveComponentCount;
        }
    }

    private final RetainedValuesStore installLocalRetainedValuesStore(LifecycleOwner arg8, ViewModelStoreOwner arg9) {
        FrameEndScheduler v0 = this.frameEndScheduler;
        if(arg8 != null && arg9 != null) {
            if(v0 == null) {
            }
            else {
                ViewModel v8 = androidx.lifecycle.ViewModelProvider$Companion.create$default(ViewModelProvider.Companion, arg9.getViewModelStore(), new NewInstanceFactory(), null, 4, null).get(Reflection.getOrCreateKotlinClass(LifecycleRetainedValuesStoreOwner.class));
                ViewParent v9 = this.getParent();
                Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type android.view.View");
                RetainedValuesStoreEntry v8_1 = ((LifecycleRetainedValuesStoreOwner)v8).getOrCreateRetainedValuesStoreEntry(((View)v9).getId());
                this.lifecycleRetainedValuesStoreOwnerEntry = v8_1;
                return v8_1.getRetainedValuesStore();
            }
        }

        return null;
    }

    public void invalidateDescendants() {
        this.invalidateLayers(this.getRoot());
    }

    private final void invalidateLayers(LayoutNode arg4) {
        arg4.invalidateLayers$ui();
        MutableVector v4 = arg4.get_children$ui();
        Object[] v0 = v4.content;
        int v4_1 = v4.getSize();
        int v1;
        for(v1 = 0; v1 < v4_1; ++v1) {
            this.invalidateLayers(v0[v1]);
        }
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode arg5) {
        int v3 = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, arg5, false, 2, null);
        MutableVector v5 = arg5.get_children$ui();
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        while(v3 < v5_1) {
            this.invalidateLayoutNodeMeasurement(v0[v3]);
            ++v3;
        }
    }

    public final boolean isArrEnabled$ui() {
        return this.isArrEnabled;
    }

    private final boolean isBadMotionEvent(MotionEvent arg8) {
        int v0 = 0x7FFFFFFF;
        int v3 = 0x7F800000;
        boolean v7 = (Float.floatToRawIntBits(arg8.getX()) & v0) >= v3 || (Float.floatToRawIntBits(arg8.getY()) & v0) >= v3 || (Float.floatToRawIntBits(arg8.getRawX()) & v0) >= v3 || (Float.floatToRawIntBits(arg8.getRawY()) & v0) >= v3 ? true : false;
        if(!v7) {
            int v4 = arg8.getPointerCount();
            int v5;
            for(v5 = 1; v5 < v4; ++v5) {
                if((Float.floatToRawIntBits(arg8.getX(v5)) & v0) >= v3 || (Float.floatToRawIntBits(arg8.getY(v5)) & v0) >= v3) {
                label_44:
                    v7 = true;
                }
                else {
                    if(Build$VERSION.SDK_INT >= 29 && !MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(arg8, v5)) {
                        goto label_44;
                    }

                    v7 = false;
                }

                if(v7) {
                    return v7;
                }
            }
        }

        return v7;
    }

    private final boolean isDevicePressEvent(MotionEvent arg2) {
        if(arg2.getButtonState() != 0) {
            return 1;
        }

        int v1 = arg2.getActionMasked();
        if(v1 != 0 && v1 != 2 && v1 != 6) {
            return 0;
        }

        return 1;
    }

    private final boolean isInBounds(MotionEvent arg4) {
        float v0 = arg4.getX();
        float v4 = arg4.getY();
        if(0f <= v0 && v0 <= (((float)this.getWidth())) && 0f <= v4 && v4 <= (((float)this.getHeight()))) {
            return 1;
        }

        return 0;
    }

    public boolean isLifecycleInResumedState() {
        androidx.lifecycle.Lifecycle$State v1_3;
        ViewTreeOwners v1 = this.getViewTreeOwners();
        if(v1 != null) {
            LifecycleOwner v1_1 = v1.getLifecycleOwner();
            if(v1_1 != null) {
                Lifecycle v1_2 = v1_1.getLifecycle();
                if(v1_2 != null) {
                    v1_3 = v1_2.getCurrentState();
                }
                else {
                    goto label_8;
                }
            }
            else {
                goto label_8;
            }
        }
        else {
        label_8:
            v1_3 = null;
        }

        if(v1_3 == androidx.lifecycle.Lifecycle$State.RESUMED) {
            return 1;
        }

        return 0;
    }

    private final boolean isPositionChanged(MotionEvent arg4) {
        if(arg4.getPointerCount() != 1) {
            return 1;
        }

        MotionEvent v3 = this.previousMotionEvent;
        if(v3 != null && v3.getPointerCount() == arg4.getPointerCount() && arg4.getRawX() == v3.getRawX() && arg4.getRawY() == v3.getRawY()) {
            return 0;
        }

        return 1;
    }

    public void localToScreen-58bKbWc(float[] arg6) {
        this.recalculateWindowPosition();
        Matrix.timesAssign-58bKbWc(arg6, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.access$preTranslate-cG2Xzmc(arg6, Float.intBitsToFloat(((int)(this.windowPosition >> 0x20))), Float.intBitsToFloat(((int)(this.windowPosition & 0xFFFFFFFFL))), this.tmpMatrix);
    }

    public long localToScreen-MK-Hz9U(long arg7) {
        this.recalculateWindowPosition();
        arg7 = Matrix.map-MK-Hz9U(this.viewToWindowMatrix, arg7);
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg7 & 0xFFFFFFFFL))) + Float.intBitsToFloat(((int)(this.windowPosition & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg7 >> 0x20))) + Float.intBitsToFloat(((int)(this.windowPosition >> 0x20)))))) << 0x20);
    }

    public void measureAndLayout(boolean arg4) {
        if(!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
            if(this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            }
            else {
                return;
            }
        }

        Trace.beginSection("AndroidOwner:measureAndLayout");
        Object v0 = null;
        if(arg4) {
            try {
                Function0 v4 = this.resendMotionEventOnLayout;
                goto label_15;
            label_14:
                v4 = ((Function0)v0);
            label_15:
                if(this.measureAndLayoutDelegate.measureAndLayout(v4)) {
                    this.requestLayout();
                }

                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, v0);
                this.dispatchPendingInteropLayoutCallbacks();
                goto label_25;
            }
            catch(Throwable v3) {
                Trace.endSection();
                throw v3;
            }
        }
        else {
            goto label_14;
        }

        goto label_15;
    label_25:
        Trace.endSection();
    }

    public void measureAndLayout-0kLqBqw(LayoutNode arg2, long arg3) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.measureAndLayout-0kLqBqw(arg2, arg3);
            if(!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
                this.dispatchPendingInteropLayoutCallbacks();
            }

            this.getRectManager().dispatchCallbacks();
        }
        catch(Throwable v1) {
            Trace.endSection();
            throw v1;
        }

        Trace.endSection();
    }

    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default(this, false, 1, null);
        Handler v0 = this.getHandler();
        if(v0 != null) {
            v0.removeCallbacks(this.outOfFrameRunnable);
        }

        this.outOfFrameRunnable.run();
    }

    public boolean moveFocusInChildren-3ESFkO8(int arg2) {
        if(ComposeUiFlags.isViewFocusFixEnabled) {
            return this.moveFocusInChildrenViewFocusFix-3ESFkO8(arg2);
        }

        if(ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            return this.moveFocusInChildrenBypassUnfocusableComposeView-3ESFkO8(arg2);
        }

        return this.moveFocusInChildrenCurrent-3ESFkO8(arg2);
    }

    private final boolean moveFocusInChildrenBypassUnfocusableComposeView-3ESFkO8(int arg3) {
        if(!FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getEnter-dhqQ-8s())) {
            if(FocusDirection.equals-impl0(arg3, FocusDirection.Companion.getExit-dhqQ-8s())) {
            }
            else {
                Integer v0 = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(arg3);
                if(v0 != null) {
                    int v0_1 = ((Number)v0).intValue();
                    View v2 = this.findNextViewInEmbeddedView-3ESFkO8(arg3);
                    if(v2 != null) {
                        return FocusInteropUtils_androidKt.requestInteropFocus(v2, Integer.valueOf(v0_1), null);
                    }
                    else {
                        return 0;
                    }
                }
                else {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid focus direction");
                    throw new KotlinNothingValueException();
                }
            }
        }

        return 0;
    }

    private final boolean moveFocusInChildrenCurrent-3ESFkO8(int arg5) {
        if(!FocusDirection.equals-impl0(arg5, FocusDirection.Companion.getEnter-dhqQ-8s())) {
            if(FocusDirection.equals-impl0(arg5, FocusDirection.Companion.getExit-dhqQ-8s())) {
            }
            else {
                Integer v5 = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(arg5);
                if(v5 != null) {
                    arg5 = ((Number)v5).intValue();
                    Rect v0 = this.getEmbeddedViewFocusRect();
                    android.graphics.Rect v0_1 = v0 != null ? RectHelper_androidKt.toAndroidRect(v0) : null;
                    FocusFinderCompat v2 = FocusFinderCompat.Companion.getInstance();
                    View v4 = v0_1 == null ? v2.findNextFocus(this, this.findFocus(), arg5) : v2.findNextFocusFromRect(((ViewGroup)this), v0_1, arg5);
                    if(v4 != null) {
                        return FocusInteropUtils_androidKt.requestInteropFocus(v4, Integer.valueOf(arg5), v0_1);
                    }

                    return 0;
                }
                else {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid focus direction");
                    throw new KotlinNothingValueException();
                }
            }
        }

        return 0;
    }

    private final boolean moveFocusInChildrenViewFocusFix-3ESFkO8(int arg8) {
        if(!FocusDirection.equals-impl0(arg8, FocusDirection.Companion.getEnter-dhqQ-8s()) && !FocusDirection.equals-impl0(arg8, FocusDirection.Companion.getExit-dhqQ-8s())) {
            if(!this.hasFocus()) {
            }
            else {
                AndroidViewsHandler v0 = this._androidViewsHandler;
                if(v0 == null) {
                    return 0;
                }
                else {
                    Integer v2 = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(arg8);
                    if(v2 != null) {
                        int v2_1 = ((Number)v2).intValue();
                        View v3 = this.getRootView();
                        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type android.view.ViewGroup");
                        View v4 = ((ViewGroup)v3).findFocus();
                        if(v4 != null) {
                            View v5 = FocusFinderCompat.Companion.getInstance().findNextFocus(((ViewGroup)v3), v4, v2_1);
                            android.graphics.Rect v6 = null;
                            if(!FocusOwnerImplKt.is1dFocusSearch-3ESFkO8(arg8) || !v0.hasFocus()) {
                                Rect v8 = this.getEmbeddedViewFocusRect();
                                if(v8 != null) {
                                    v6 = RectHelper_androidKt.toAndroidRect(v8);
                                }

                                if(v5 == null) {
                                    goto label_39;
                                }

                                if(v6 == null) {
                                    goto label_39;
                                }

                                ((ViewGroup)v3).offsetDescendantRectToMyCoords(((View)this), v6);
                                ((ViewGroup)v3).offsetRectIntoDescendantCoords(v5, v6);
                            }
                            else {
                            }

                        label_39:
                            if(v5 != null) {
                                if(v5 == v4) {
                                }
                                else {
                                    View v7 = v0.getFocusedChild();
                                    ViewParent v8_1;
                                    for(v8_1 = v5.getParent(); v8_1 != null; v8_1 = v8_1.getParent()) {
                                        if((((View)v8_1)) == v7) {
                                            break;
                                        }
                                    }

                                    if(v8_1 == null) {
                                        return 0;
                                    }

                                    return FocusInteropUtils_androidKt.requestInteropFocus(v5, Integer.valueOf(v2_1), v6);
                                }
                            }

                            return 0;
                        }
                        else {
                            throw new IllegalStateException("view hasFocus but root can\'t find it".toString());
                        }
                    }
                    else {
                        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid focus direction");
                        throw new KotlinNothingValueException();
                    }
                }
            }
        }

        return 0;
    }

    public final void notifyLayerIsDirty$ui(OwnedLayer arg4, boolean arg5) {
        boolean v0 = this.isDrawingContent;
        if(!arg5) {
            if(!v0) {
                this.dirtyLayers.remove(arg4);
                MutableObjectList v3 = this.postponedDirtyLayers;
                if(v3 != null) {
                    v3.remove(arg4);
                }
            }

            return;
        }

        if(!v0) {
            this.dirtyLayers.add(arg4);
            return;
        }

        MutableObjectList v5 = this.postponedDirtyLayers;
        if(v5 == null) {
            v5 = new MutableObjectList(0, 1, null);
            this.postponedDirtyLayers = v5;
        }

        v5.add(arg4);
    }

    protected void onAttachedToWindow() {
        ForgetfulRetainedValuesStore v4_1;
        super.onAttachedToWindow();
        if(Build$VERSION.SDK_INT < 30) {
            this.setShowLayoutBounds(Companion.access$getIsShowingLayoutBounds(AndroidComposeView.Companion));
        }

        if(ComposeUiFlags.areWindowInsetsRulersEnabled) {
            this.insetsListener.onViewAttachedToWindow(this);
        }

        Companion.access$addNotificationForSysPropsChange(AndroidComposeView.Companion, this);
        this._windowInfo.setWindowFocused(this.hasWindowFocus());
        this._windowInfo.setOnInitializeContainerSize(new AndroidComposeView$onAttachedToWindow$1(this));
        this.updateWindowMetrics();
        this.invalidateLayoutNodeMeasurement(this.getRoot());
        this.invalidateLayers(this.getRoot());
        this.getSnapshotObserver().startObserving$ui();
        if(this.autofillSupported()) {
            AndroidAutofill v0 = this._autofill;
            if(v0 != null) {
                AutofillCallback.INSTANCE.register(v0);
            }
        }

        AndroidComposeView v0_1 = this;
        LifecycleOwner v1 = ViewTreeLifecycleOwner.get(((View)v0_1));
        SavedStateRegistryOwner v2 = ViewTreeSavedStateRegistryOwner.get(((View)v0_1));
        ViewModelStoreOwner v3 = ViewTreeViewModelStoreOwner.get(((View)v0_1));
        RetainedValuesStore v4 = this.installLocalRetainedValuesStore(v1, v3);
        if(v4 == null) {
            v4_1 = ForgetfulRetainedValuesStore.INSTANCE;
        }

        this.retainedValuesStore = ((RetainedValuesStore)v4_1);
        ViewTreeOwners v4_2 = this.getViewTreeOwners();
        Function1 v5 = null;
        if(v4_2 == null) {
        label_53:
            if(v1 == null) {
                goto label_126;
            }
            else if(v2 != null) {
                if(v4_2 != null) {
                    LifecycleOwner v4_3 = v4_2.getLifecycleOwner();
                    if(v4_3 != null) {
                        Lifecycle v4_4 = v4_3.getLifecycle();
                        if(v4_4 != null) {
                            v4_4.removeObserver(this);
                        }
                    }
                }

                v1.getLifecycle().addObserver(this);
                v4_2 = new ViewTreeOwners(v1, v2, v3);
                this.set_viewTreeOwners(v4_2);
                Function1 v1_1 = this.onViewTreeOwnersAvailable;
                if(v1_1 != null) {
                    v1_1.invoke(v4_2);
                }

                this.onViewTreeOwnersAvailable = v5;
            }
            else {
                goto label_122;
            }
        }
        else if(v1 != null && v2 != null) {
            if(v1 != v4_2.getLifecycleOwner()) {
                goto label_53;
            }
            else if(v2 != v4_2.getSavedStateRegistryOwner()) {
                goto label_53;
            }
            else if(v3 != v4_2.getViewModelStoreOwner()) {
                goto label_53;
            }
        }

        InputModeManagerImpl v1_2 = this._inputModeManager;
        int v2_1 = this.isInTouchMode() ? InputMode.Companion.getTouch-aOaMEAU() : InputMode.Companion.getKeyboard-aOaMEAU();
        v1_2.setInputMode-iuPiT84(v2_1);
        ViewTreeOwners v1_3 = this.getViewTreeOwners();
        if(v1_3 != null) {
            v1 = v1_3.getLifecycleOwner();
            if(v1 != null) {
                Lifecycle v5_1 = v1.getLifecycle();
            }
        }

        if((((Lifecycle)v5)) != null) {
            ((Lifecycle)v5).addObserver(this);
            ((Lifecycle)v5).addObserver(this.contentCaptureManager);
            this.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.getViewTreeObserver().addOnScrollChangedListener(this);
            this.getViewTreeObserver().addOnTouchModeChangeListener(this);
            if(Build$VERSION.SDK_INT >= 0x1F) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(((View)v0_1));
            }

            AndroidAutofillManager v0_2 = this._autofillManager;
            if(v0_2 != null) {
                this.getFocusOwner().getListeners().add(v0_2);
                this.getSemanticsOwner().getListeners$ui().add(v0_2);
            }

            this.getFocusOwner().getListeners().add(this);
            return;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        throw new KotlinNothingValueException();
    label_122:
        throw new IllegalStateException("Composed into the View which doesn\'t propagateViewTreeSavedStateRegistryOwner!");
    label_126:
        throw new IllegalStateException("Composed into the View which doesn\'t propagate ViewTreeLifecycleOwner!");
    }

    public boolean onCheckIsTextEditor() {
        Object v0 = SessionMutex.getCurrentSession-impl(this.textInputSessionMutex);
        if(v0 == null) {
            return this.legacyTextInputServiceAndroid.isEditorFocused();
        }

        return ((AndroidPlatformTextInputSession)v0).isReadyForConnection();
    }

    protected void onConfigurationChanged(Configuration arg1) {
        super.onConfigurationChanged(arg1);
        this.updateConfiguration(arg1);
    }

    public InputConnection onCreateInputConnection(EditorInfo arg2) {
        Object v0 = SessionMutex.getCurrentSession-impl(this.textInputSessionMutex);
        if(v0 == null) {
            return this.legacyTextInputServiceAndroid.createInputConnection(arg2);
        }

        return ((AndroidPlatformTextInputSession)v0).createInputConnection(arg2);
    }

    public void onCreateVirtualViewTranslationRequests(long[] arg1, int[] arg2, Consumer arg3) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui(arg1, arg2, arg3);
    }

    public void onDetach(LayoutNode arg3) {
        this.getLayoutNodes().remove(arg3.getSemanticsId());
        this.measureAndLayoutDelegate.onNodeDetached(arg3);
        this.requestClearInvalidObservations();
        if((this.autofillSupported()) && (ComposeUiFlags.isSemanticAutofillEnabled)) {
            AndroidAutofillManager v2 = this._autofillManager;
            if(v2 != null) {
                v2.onDetach$ui(((SemanticsInfo)arg3));
            }
        }
    }

    protected void onDetachedFromWindow() {
        Lifecycle v0_3;
        super.onDetachedFromWindow();
        if(ComposeUiFlags.areWindowInsetsRulersEnabled) {
            this.insetsListener.onViewDetachedFromWindow(this);
        }

        Function0 v1 = null;
        if(this.isArrEnabled) {
            View v0 = this.frameRateCategoryView;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("frameRateCategoryView");
                v0 = ((View)v1);
            }

            this.removeView(v0);
        }

        Companion.access$removeNotificationForSysPropsChange(AndroidComposeView.Companion, this);
        this.getSnapshotObserver().stopObserving$ui();
        this._windowInfo.setOnInitializeContainerSize(v1);
        ViewTreeOwners v0_1 = this.getViewTreeOwners();
        if(v0_1 != null) {
            LifecycleOwner v0_2 = v0_1.getLifecycleOwner();
            if(v0_2 != null) {
                v0_3 = v0_2.getLifecycle();
            }
            else {
                goto label_27;
            }
        }
        else {
        label_27:
            v0_3 = ((Lifecycle)v1);
        }

        if(v0_3 != null) {
            v0_3.removeObserver(this.contentCaptureManager);
            v0_3.removeObserver(this);
            if(this.autofillSupported()) {
                AndroidAutofill v0_4 = this._autofill;
                if(v0_4 != null) {
                    AutofillCallback.INSTANCE.unregister(v0_4);
                }
            }

            this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.getViewTreeObserver().removeOnScrollChangedListener(this);
            this.getViewTreeObserver().removeOnTouchModeChangeListener(this);
            RetainedValuesStoreEntry v0_5 = this.lifecycleRetainedValuesStoreOwnerEntry;
            if(v0_5 != null) {
                v0_5.release();
            }

            this.lifecycleRetainedValuesStoreOwnerEntry = ((RetainedValuesStoreEntry)v1);
            if(Build$VERSION.SDK_INT >= 0x1F) {
                AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
            }

            AndroidAutofillManager v0_6 = this._autofillManager;
            if(v0_6 != null) {
                this.getSemanticsOwner().getListeners$ui().remove(v0_6);
                this.getFocusOwner().getListeners().remove(v0_6);
            }

            this.getRectManager().removeScheduledCallback();
            this.getFocusOwner().getListeners().remove(this);
            return;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
        throw new KotlinNothingValueException();
    }

    protected void onDraw(Canvas arg1) {
    }

    public void onEndApplyChanges() {
        MutableObjectList v3;
        if(this.observationClearRequested) {
            this.getSnapshotObserver().clearInvalidObservations$ui();
            this.observationClearRequested = false;
        }

        AndroidViewsHandler v0 = this._androidViewsHandler;
        if(v0 != null) {
            this.clearChildInvalidObservations(((ViewGroup)v0));
        }

        if((this.autofillSupported()) && (ComposeUiFlags.isSemanticAutofillEnabled)) {
            AndroidAutofillManager v0_1 = this._autofillManager;
            if(v0_1 != null) {
                v0_1.onEndApplyChanges$ui();
            }
        }

        while(this.endApplyChangesListeners.isNotEmpty()) {
            if(this.endApplyChangesListeners.get(0) == null) {
                return;
            }

            int v0_2 = this.endApplyChangesListeners.getSize();
            int v2;
            for(v2 = 0; true; ++v2) {
                v3 = this.endApplyChangesListeners;
                if(v2 >= v0_2) {
                    break;
                }

                Object v3_1 = v3.get(v2);
                this.endApplyChangesListeners.set(v2, null);
                if(v3_1 != null) {
                    ((Function0)v3_1).invoke();
                }
            }

            v3.removeRange(0, v0_2);
        }
    }

    public void onFocusChanged(FocusTargetModifierNode arg14, FocusTargetModifierNode arg15) {
        LinkedHashSet v3_1;
        Node v8;
        int v5;
        if((ComposeUiFlags.isOptimizedFocusEventDispatchEnabled) && arg14 != null) {
            int v13 = 0x200000;
            int v0 = NodeKind.constructor-impl(v13);
            String v2 = "visitAncestors called on an unattached node";
            if(!((DelegatableNode)arg14).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException(v2);
            }

            Node v1 = ((DelegatableNode)arg14).getNode();
            LayoutNode v14 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg14));
            Node v3 = null;
            ArrayList v4 = ((ArrayList)v3);
            while(true) {
                v5 = 16;
                if(v14 == null) {
                    break;
                }

                if((v14.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v0) != 0) {
                    while(v1 != null) {
                        if((v1.getKindSet$ui() & v0) != 0) {
                            v8 = v1;
                            MutableVector v9 = ((MutableVector)v3);
                            while(true) {
                            label_29:
                                if(v8 != null) {
                                    if((v8 instanceof IndirectPointerInputModifierNode)) {
                                        if(v4 == null) {
                                            v4 = new ArrayList();
                                        }

                                        ((List)v4).add(v8);
                                    }
                                    else {
                                        if((v8.getKindSet$ui() & v0) == 0) {
                                            break;
                                        }

                                        if(!(v8 instanceof DelegatingNode)) {
                                            break;
                                        }

                                        Node v10 = v8.getDelegate$ui();
                                        int v11 = 0;
                                        while(v10 != null) {
                                            if((v10.getKindSet$ui() & v0) != 0) {
                                                ++v11;
                                                if(v11 == 1) {
                                                    v8 = v10;
                                                }
                                                else {
                                                    if(v9 == null) {
                                                        v9 = new MutableVector(new Node[v5], 0);
                                                    }

                                                    if(v8 != null) {
                                                        if(v9 != null) {
                                                            v9.add(v8);
                                                        }

                                                        v8 = v3;
                                                    }

                                                    if(v9 == null) {
                                                        goto label_63;
                                                    }

                                                    v9.add(v10);
                                                }
                                            }

                                        label_63:
                                            v10 = v10.getChild$ui();
                                        }

                                        if(v11 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_69;
                            }

                            v8 = DelegatableNodeKt.pop(v9);
                            goto label_29;
                        }

                    label_69:
                        v1 = v1.getParent$ui();
                    }
                }

                v14 = v14.getParent$ui();
                if(v14 != null) {
                    NodeChain v1_1 = v14.getNodes$ui();
                    if(v1_1 != null) {
                        v1 = v1_1.getTail$ui();
                        continue;
                    }
                }

                v1 = v3;
            }

            if(v4 == null) {
                return;
            }

            if(arg15 != null) {
                v13 = NodeKind.constructor-impl(v13);
                if(!((DelegatableNode)arg15).getNode().isAttached()) {
                    InlineClassHelperKt.throwIllegalStateException(v2);
                }

                Node v14_1 = ((DelegatableNode)arg15).getNode();
                LayoutNode v15 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg15));
                LinkedHashSet v0_1 = ((LinkedHashSet)v3);
                while(v15 != null) {
                    if((v15.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v13) != 0) {
                        while(v14_1 != null) {
                            if((v14_1.getKindSet$ui() & v13) != 0) {
                                v1 = v14_1;
                                MutableVector v2_1 = ((MutableVector)v3);
                                while(true) {
                                label_102:
                                    if(v1 != null) {
                                        if((v1 instanceof IndirectPointerInputModifierNode)) {
                                            if(v0_1 == null) {
                                                v0_1 = new LinkedHashSet();
                                            }

                                            ((Set)v0_1).add(v1);
                                        }
                                        else {
                                            if((v1.getKindSet$ui() & v13) == 0) {
                                                break;
                                            }

                                            if(!(v1 instanceof DelegatingNode)) {
                                                break;
                                            }

                                            v8 = v1.getDelegate$ui();
                                            int v9_1 = 0;
                                            while(v8 != null) {
                                                if((v8.getKindSet$ui() & v13) != 0) {
                                                    ++v9_1;
                                                    if(v9_1 == 1) {
                                                        v1 = v8;
                                                    }
                                                    else {
                                                        if(v2_1 == null) {
                                                            v2_1 = new MutableVector(new Node[v5], 0);
                                                        }

                                                        if(v1 != null) {
                                                            if(v2_1 != null) {
                                                                v2_1.add(v1);
                                                            }

                                                            v1 = v3;
                                                        }

                                                        if(v2_1 == null) {
                                                            goto label_136;
                                                        }

                                                        v2_1.add(v8);
                                                    }
                                                }

                                            label_136:
                                                v8 = v8.getChild$ui();
                                            }

                                            if(v9_1 != 1) {
                                                break;
                                            }

                                            continue;
                                        }

                                        break;
                                    }

                                    goto label_142;
                                }

                                v1 = DelegatableNodeKt.pop(v2_1);
                                goto label_102;
                            }

                        label_142:
                            v14_1 = v14_1.getParent$ui();
                        }
                    }

                    v15 = v15.getParent$ui();
                    if(v15 != null) {
                        NodeChain v14_2 = v15.getNodes$ui();
                        if(v14_2 != null) {
                            v14_1 = v14_2.getTail$ui();
                            continue;
                        }
                    }

                    v14_1 = v3;
                }

                v3_1 = v0_1;
            }

            v13 = v4.size();
            int v14_3;
            for(v14_3 = 0; v14_3 < v13; ++v14_3) {
                Object v15_1 = ((List)v4).get(v14_3);
                boolean v0_2 = v3_1 != null ? ((Set)v3_1).contains(v15_1) : false;
                if(!v0_2) {
                    ((IndirectPointerInputModifierNode)v15_1).onCancelIndirectPointerInput();
                }
            }
        }
    }

    protected void onFocusChanged(boolean arg1, int arg2, android.graphics.Rect arg3) {
        super.onFocusChanged(arg1, arg2, arg3);
        if(!arg1 && !this.hasFocus()) {
            this.getFocusOwner().releaseFocus();
        }
    }

    public void onGlobalLayout() {
        this.lastMatrixRecalculationAnimationTime = 0;
        this.updatePositionCacheAndDispatch();
        this.dispatchConfigurationChangeIfNeeded();
    }

    public void onInteropViewLayoutChange(View arg1) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    protected void onLayout(boolean arg3, int arg4, int arg5, int arg6, int arg7) {
        this.lastMatrixRecalculationAnimationTime = 0;
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        this.updatePositionCacheAndDispatch();
        if(this._androidViewsHandler != null) {
            this.getAndroidViewsHandler$ui().layout(0, 0, arg6 - arg4, arg7 - arg5);
        }
    }

    public void onLayoutChange(LayoutNode arg2) {
        this.composeAccessibilityDelegate.onLayoutChange$ui(arg2);
        this.contentCaptureManager.onLayoutChange$ui();
    }

    public void onLayoutNodeDeactivated(LayoutNode arg2) {
        if((this.autofillSupported()) && (ComposeUiFlags.isSemanticAutofillEnabled)) {
            AndroidAutofillManager v1 = this._autofillManager;
            if(v1 != null) {
                v1.onLayoutNodeDeactivated$ui(((SemanticsInfo)arg2));
            }
        }
    }

    protected void onMeasure(int arg8, int arg9) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if(!this.isAttachedToWindow()) {
                this.invalidateLayoutNodeMeasurement(this.getRoot());
            }

            long v0 = this.convertMeasureSpec-I7RO_PI(arg8);
            int v2 = ((int)ULong.constructor-impl(v0 >>> 0x20));
            int v0_1 = ((int)ULong.constructor-impl(v0 & 0xFFFFFFFFL));
            long v5 = this.convertMeasureSpec-I7RO_PI(arg9);
            long v8 = Constraints.Companion.fitPrioritizingHeight-Zbe2FdA(v2, v0_1, ((int)ULong.constructor-impl(v5 >>> 0x20)), ((int)ULong.constructor-impl(0xFFFFFFFFL & v5)));
            Constraints v0_2 = this.onMeasureConstraints;
            boolean v1 = false;
            if(v0_2 == null) {
                this.onMeasureConstraints = Constraints.box-impl(v8);
                this.wasMeasuredWithMultipleConstraints = false;
            }
            else {
                if(v0_2 == null) {
                }
                else {
                    v1 = Constraints.equals-impl0(v0_2.unbox-impl(), v8);
                }

                if(v1) {
                    goto label_38;
                }

                this.wasMeasuredWithMultipleConstraints = true;
            }

        label_38:
            this.measureAndLayoutDelegate.updateRootConstraints-BRTryo0(v8);
            this.measureAndLayoutDelegate.measureOnly();
            this.setMeasuredDimension(this.getRoot().getWidth(), this.getRoot().getHeight());
            if(this._androidViewsHandler != null) {
                this.getAndroidViewsHandler$ui().measure(View$MeasureSpec.makeMeasureSpec(this.getRoot().getWidth(), 0x40000000), View$MeasureSpec.makeMeasureSpec(this.getRoot().getHeight(), 0x40000000));
            }
        }
        catch(Throwable v7) {
            Trace.endSection();
            throw v7;
        }

        Trace.endSection();
    }

    public void onPostAttach(LayoutNode arg2) {
        if((this.autofillSupported()) && (ComposeUiFlags.isSemanticAutofillEnabled)) {
            AndroidAutofillManager v1 = this._autofillManager;
            if(v1 != null) {
                v1.onPostAttach$ui(((SemanticsInfo)arg2));
            }
        }
    }

    public void onPostLayoutNodeReused(LayoutNode arg2, int arg3) {
        if((this.autofillSupported()) && (ComposeUiFlags.isSemanticAutofillEnabled)) {
            AndroidAutofillManager v1 = this._autofillManager;
            if(v1 != null) {
                v1.onPostLayoutNodeReused$ui(((SemanticsInfo)arg2), arg3);
            }
        }
    }

    public void onPreAttach(LayoutNode arg2) {
        this.getLayoutNodes().set(arg2.getSemanticsId(), arg2);
    }

    public void onPreLayoutNodeReused(LayoutNode arg2, int arg3) {
        this.getLayoutNodes().remove(arg3);
        this.getLayoutNodes().set(arg2.getSemanticsId(), arg2);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure arg1, int arg2) {
        if((this.autofillSupported()) && arg1 != null) {
            if(ComposeUiFlags.isSemanticAutofillEnabled) {
                AndroidAutofillManager v2 = this._autofillManager;
                if(v2 != null) {
                    v2.populateViewStructure(arg1);
                }
            }

            AndroidAutofill v0 = this._autofill;
            if(v0 == null) {
                return;
            }

            AndroidAutofill_androidKt.populateViewStructure(v0, arg1);
        }
    }

    public void onRequestMeasure(LayoutNode arg2, boolean arg3, boolean arg4, boolean arg5) {
        MeasureAndLayoutDelegate v0 = this.measureAndLayoutDelegate;
        if(arg3) {
            if((v0.requestLookaheadRemeasure(arg2, arg4)) && (arg5)) {
                this.scheduleMeasureAndLayout(arg2);
                return;
            }
        }
        else if((v0.requestRemeasure(arg2, arg4)) && (arg5)) {
            this.scheduleMeasureAndLayout(arg2);
        }
    }

    public void onRequestRelayout(LayoutNode arg4, boolean arg5, boolean arg6) {
        MeasureAndLayoutDelegate v0 = this.measureAndLayoutDelegate;
        LayoutNode v2 = null;
        if(arg5) {
            if(v0.requestLookaheadRelayout(arg4, arg6)) {
                AndroidComposeView.scheduleMeasureAndLayout$default(this, v2, 1, v2);
                return;
            }
        }
        else if(v0.requestRelayout(arg4, arg6)) {
            AndroidComposeView.scheduleMeasureAndLayout$default(this, v2, 1, v2);
        }
    }

    public PointerIcon onResolvePointerIcon(MotionEvent arg3, int arg4) {
        int v0 = arg3.getToolType(arg4);
        if(!arg3.isFromSource(0x2002) && (arg3.isFromSource(0x4002)) && (v0 == 2 || v0 == 4)) {
            androidx.compose.ui.input.pointer.PointerIcon v0_1 = this.getPointerIconService().getStylusHoverIcon();
            if(v0_1 == null) {
                goto label_18;
            }

            return AndroidComposeViewVerificationHelperMethodsN.INSTANCE.toAndroidPointerIcon(this.getContext(), v0_1);
        }

    label_18:
        return super.onResolvePointerIcon(arg3, arg4);
    }

    public void onResume(LifecycleOwner arg2) {
        if(Build$VERSION.SDK_INT < 30) {
            this.setShowLayoutBounds(Companion.access$getIsShowingLayoutBounds(AndroidComposeView.Companion));
        }

        RetainedValuesStoreEntry v2 = this.lifecycleRetainedValuesStoreOwnerEntry;
        if(v2 != null) {
            FrameEndScheduler v1 = this.frameEndScheduler;
            Intrinsics.checkNotNull(v1);
            v2.stopRetainingExitedValues(v1);
        }
    }

    public void onRtlPropertiesChanged(int arg2) {
        if(this.superclassInitComplete) {
            LayoutDirection v2 = FocusInteropUtils_androidKt.toLayoutDirection(arg2);
            if(v2 == null) {
                v2 = LayoutDirection.Ltr;
            }

            this.setLayoutDirection(v2);
        }
    }

    public void onScrollCaptureSearch(android.graphics.Rect arg2, Point arg3, Consumer arg4) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            ScrollCapture v2 = this.scrollCapture;
            if(v2 != null) {
                v2.onScrollCaptureSearch(this, this.getSemanticsOwner(), this.getCoroutineContext(), arg4);
            }
        }
    }

    public void onScrollChanged() {
        this.updatePositionCacheAndDispatch();
    }

    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui();
        this.contentCaptureManager.onSemanticsChange$ui();
    }

    public void onStop(LifecycleOwner arg1) {
        RetainedValuesStoreEntry v0 = this.lifecycleRetainedValuesStoreOwnerEntry;
        if(v0 != null) {
            v0.startRetainingExitedValues();
        }
    }

    public void onTouchModeChanged(boolean arg1) {
        InputModeManagerImpl v0 = this._inputModeManager;
        int v1 = arg1 ? InputMode.Companion.getTouch-aOaMEAU() : InputMode.Companion.getKeyboard-aOaMEAU();
        v0.setInputMode-iuPiT84(v1);
    }

    public void onVirtualViewTranslationResponses(LongSparseArray arg1) {
        this.contentCaptureManager.onVirtualViewTranslationResponses$ui(this.contentCaptureManager, arg1);
    }

    public void onWindowFocusChanged(boolean arg2) {
        this._windowInfo.setWindowFocused(arg2);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(arg2);
        if((arg2) && Build$VERSION.SDK_INT < 30) {
            arg2 = Companion.access$getIsShowingLayoutBounds(AndroidComposeView.Companion);
            if(this.getShowLayoutBounds() != arg2) {
                this.setShowLayoutBounds(arg2);
                this.invalidateDescendants();
            }
        }
    }

    static final void outOfFrameRunnable$lambda$0(AndroidComposeView arg1) {
        Trace.beginSection("AndroidOwner:outOfFrameExecutor");
        try {
            while(!arg1.outOfFrameQueue.isEmpty()) {
                arg1.outOfFrameQueue.removeLast().invoke();
            }
        }
        catch(Throwable v1) {
            Trace.endSection();
            throw v1;
        }

        Trace.endSection();
    }

    private final long pack-ZIaKswc(int arg3, int arg4) {
        return ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(((long)arg3)) << 0x20) | ULong.constructor-impl(((long)arg4)));
    }

    private final void recalculateWindowPosition(MotionEvent arg9) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        this.recalculateWindowViewTransforms();
        long v0 = Matrix.map-MK-Hz9U(this.viewToWindowMatrix, Offset.constructor-impl((((long)Float.floatToRawIntBits(arg9.getY()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg9.getX()))) << 0x20));
        this.windowPosition = Offset.constructor-impl((((long)Float.floatToRawIntBits(arg9.getRawX() - Float.intBitsToFloat(((int)(v0 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(arg9.getRawY() - Float.intBitsToFloat(((int)(v0 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    private final void recalculateWindowPosition() {
        if(!this.forceUseMatrixCache) {
            long v0 = AnimationUtils.currentAnimationTimeMillis();
            if(v0 != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = v0;
                this.recalculateWindowViewTransforms();
                ViewParent v0_1 = this.getParent();
                AndroidComposeView v1 = this;
                while((v0_1 instanceof ViewGroup)) {
                    ViewParent v1_1 = v0_1;
                    v0_1 = v1_1.getParent();
                }

                ((View)v1).getLocationOnScreen(this.tmpPositionArray);
                int[] v0_2 = this.tmpPositionArray;
                float v3 = ((float)v0_2[0]);
                float v5 = ((float)v0_2[1]);
                ((View)v1).getLocationInWindow(v0_2);
                this.windowPosition = Offset.constructor-impl((((long)Float.floatToRawIntBits(v3 - (((float)this.tmpPositionArray[0]))))) << 0x20 | (((long)Float.floatToRawIntBits(v5 - (((float)this.tmpPositionArray[1]))))) & 0xFFFFFFFFL);
            }
        }
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.calculateMatrixToWindow-EL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.invertTo-JiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    public final boolean recycle$ui(OwnedLayer arg2) {
        if(this.viewLayersContainer != null) {
            ViewLayer.Companion.getShouldUseDispatchDraw();
        }

        this.layerCache.push(arg2);
        this.dirtyLayers.remove(arg2);
        return 1;
    }

    public void registerOnEndApplyChangesListener(Function0 arg2) {
        if(!this.endApplyChangesListeners.contains(arg2)) {
            this.endApplyChangesListeners.add(arg2);
        }
    }

    public void registerOnLayoutCompletedListener(OnLayoutCompletedListener arg2) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(arg2);
        AndroidComposeView.scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    public final void removeAndroidView(AndroidViewHolder arg3) {
        this.getAndroidViewsHandler$ui().removeViewInLayout(arg3);
        TypeIntrinsics.asMutableMap(this.getAndroidViewsHandler$ui().getLayoutNodeToHolder()).remove(this.getAndroidViewsHandler$ui().getHolderToLayoutNode().remove(arg3));
        arg3.setImportantForAccessibility(0);
    }

    public void requestAutofill(LayoutNode arg2) {
        if((this.autofillSupported()) && (ComposeUiFlags.isSemanticAutofillEnabled)) {
            AndroidAutofillManager v1 = this._autofillManager;
            if(v1 != null) {
                v1.requestAutofill$ui(((SemanticsInfo)arg2));
            }
        }
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    public boolean requestFocus(int arg2, android.graphics.Rect arg3) {
        if(ComposeUiFlags.isViewFocusFixEnabled) {
            return this.requestFocusViewFocusFix(arg2, arg3);
        }

        if(ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            return this.requestFocusBypassUnfocusableComposeView(arg2, arg3);
        }

        return this.requestFocusCurrent(arg2, arg3);
    }

    public final boolean requestFocusBypassUnfocusableComposeView(int arg6, android.graphics.Rect arg7) {
        boolean v0 = this.isFocused();
        Boolean v2 = Boolean.valueOf(true);
        if(v0) {
            return 1;
        }

        FocusDirection v6 = FocusInteropUtils_androidKt.toFocusDirection(arg6);
        arg6 = v6 != null ? v6.unbox-impl() : FocusDirection.Companion.getEnter-dhqQ-8s();
        FocusOwner v0_1 = this.getFocusOwner();
        Rect v3 = null;
        Rect v7 = arg7 != null ? RectHelper_androidKt.toComposeRect(arg7) : v3;
        if(Intrinsics.areEqual(v0_1.focusSearch-ULY8qGw(arg6, v7, new AndroidComposeView$requestFocusBypassUnfocusableComposeView$requestFocusWithPrevRect$1(arg6)), v2)) {
            return 1;
        }

        if((ComposeUiFlags.isIgnoreInvalidPrevFocusRectEnabled) && (Intrinsics.areEqual(this.getFocusOwner().focusSearch-ULY8qGw(arg6, v3, new AndroidComposeView$requestFocusBypassUnfocusableComposeView$requestFocusWithoutPrevRect$1(arg6)), v2))) {
            return 1;
        }

        if((this.hasFocus()) && (FocusOwnerImplKt.is1dFocusSearch-3ESFkO8(arg6))) {
            return this.getFocusOwner().resetFocus-3ESFkO8(arg6);
        }

        return 0;
    }

    public final boolean requestFocusCurrent(int arg3, android.graphics.Rect arg4) {
        if(this.isFocused()) {
            return 1;
        }

        if(this.getFocusOwner().getRootState().getHasFocus()) {
            return super.requestFocus(arg3, arg4);
        }

        FocusDirection v3 = FocusInteropUtils_androidKt.toFocusDirection(arg3);
        arg3 = v3 != null ? v3.unbox-impl() : FocusDirection.Companion.getEnter-dhqQ-8s();
        FocusOwner v2 = this.getFocusOwner();
        Rect v4 = arg4 != null ? RectHelper_androidKt.toComposeRect(arg4) : null;
        return Intrinsics.areEqual(v2.focusSearch-ULY8qGw(arg3, v4, new AndroidComposeView$requestFocusCurrent$1(arg3)), Boolean.valueOf(true));
    }

    public final boolean requestFocusViewFocusFix(int arg9, android.graphics.Rect arg10) {
        if(this.isFocused()) {
            return 1;
        }

        if(this.processingRequestFocusForNextNonChildView) {
            return 0;
        }

        FocusDirection v0 = FocusInteropUtils_androidKt.toFocusDirection(arg9);
        int v0_1 = v0 != null ? v0.unbox-impl() : FocusDirection.Companion.getEnter-dhqQ-8s();
        if((this.hasFocus()) && (this.moveFocusInChildren-3ESFkO8(v0_1))) {
            return 1;
        }

        BooleanRef v3 = new BooleanRef();
        FocusOwner v4 = this.getFocusOwner();
        Rect v5 = null;
        Rect v6 = arg10 != null ? RectHelper_androidKt.toComposeRect(arg10) : v5;
        Boolean v4_1 = v4.focusSearch-ULY8qGw(v0_1, v6, new AndroidComposeView$requestFocusViewFocusFix$focusSearchResult$1(v3, v0_1));
        if(v4_1 == null) {
            return 0;
        }

        if(v4_1.booleanValue()) {
            return 1;
        }

        if(v3.element) {
            return 0;
        }

        if(arg10 != null && !this.hasFocus() && (Intrinsics.areEqual(this.getFocusOwner().focusSearch-ULY8qGw(v0_1, v5, new AndroidComposeView$requestFocusViewFocusFix$altFocus$1(v0_1)), Boolean.valueOf(true)))) {
            return 1;
        }

        View v10 = this.findNextNonChildView(arg9);
        if(v10 != null) {
            if((((AndroidComposeView)v10)) == this) {
            }
            else {
                this.processingRequestFocusForNextNonChildView = true;
                boolean v9 = v10.requestFocus(arg9);
                this.processingRequestFocusForNextNonChildView = false;
                return v9;
            }
        }

        return 1;
    }

    public void requestOnPositionedCallback(LayoutNode arg2) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(arg2);
        AndroidComposeView.scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    public boolean requestOwnerFocus-7o62pno(FocusDirection arg3, Rect arg4) {
        int v3_1;
        if(!ComposeUiFlags.isBypassUnfocusableComposeViewEnabled) {
            if(!this.isFocused()) {
                if(this.hasFocus()) {
                }
                else {
                    goto label_11;
                }
            }

            return 1;
        }
        else if(this.isFocused()) {
            return 1;
        }

    label_11:
        if(arg3 != null) {
            Integer v3 = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(arg3.unbox-impl());
            if(v3 != null) {
                v3_1 = v3.intValue();
            }
            else {
                goto label_17;
            }
        }
        else {
        label_17:
            v3_1 = 130;
        }

        android.graphics.Rect v4 = arg4 != null ? RectHelper_androidKt.toAndroidRect(arg4) : null;
        return super.requestFocus(v3_1, v4);
    }

    public void schedule(Function0 arg3) {
        boolean v0 = this.outOfFrameQueue.isEmpty();
        this.outOfFrameQueue.addLast(arg3);
        if(v0) {
            Handler v3 = this.getHandler();
            if(v3 != null) {
                v3.postAtFrontOfQueue(this.outOfFrameRunnable);
                return;
            }

            throw new IllegalArgumentException("schedule is called when outOfFrameExecutor is not available (view is detached)".toString());
        }
    }

    private final void scheduleMeasureAndLayout(LayoutNode arg3) {
        if(!this.isLayoutRequested() && (this.isAttachedToWindow())) {
            if(arg3 != null) {
                while(arg3 != null) {
                    if(arg3.getMeasuredByParent$ui() != UsageByParent.InMeasureBlock) {
                        break;
                    }

                    if(!this.childSizeCanAffectParentSize(arg3)) {
                        break;
                    }

                    arg3 = arg3.getParent$ui();
                }

                if(arg3 != this.getRoot()) {
                    goto label_17;
                }

                this.requestLayout();
                return;
            }

        label_17:
            if(this.getWidth() != 0) {
                if(this.getHeight() == 0) {
                }
                else {
                    this.invalidate();
                    return;
                }
            }

            this.requestLayout();
        }
    }

    static void scheduleMeasureAndLayout$default(AndroidComposeView arg0, LayoutNode arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        arg0.scheduleMeasureAndLayout(arg1);
    }

    public long screenToLocal-MK-Hz9U(long arg7) {
        this.recalculateWindowPosition();
        return Matrix.map-MK-Hz9U(this.windowToViewMatrix, Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg7 & 0xFFFFFFFFL))) - Float.intBitsToFloat(((int)(this.windowPosition & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg7 >> 0x20))) - Float.intBitsToFloat(((int)(this.windowPosition >> 0x20)))))) << 0x20));
    }

    static final void sendHoverExitEvent$lambda$0(AndroidComposeView arg3) {
        arg3.hoverExitReceived = false;
        MotionEvent v0 = arg3.previousMotionEvent;
        Intrinsics.checkNotNull(v0);
        if(v0.getActionMasked() == 10) {
            arg3.sendMotionEvent-8iAsVTc(v0);
            return;
        }

        throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
    }

    public boolean sendIndirectPointerEvent(IndirectPointerEvent arg3) {
        if(AndroidIndirectPointerEvent_androidKt.getNativeEvent(arg3).getActionMasked() == 3) {
            this.getFocusOwner().dispatchIndirectPointerCancel();
            return 1;
        }

        return this.handleIndirectPointerEvent(arg3);
    }

    public boolean sendKeyEvent-ZmokQxo(KeyEvent arg3) {
        if(!this.getFocusOwner().dispatchInterceptedSoftKeyboardEvent-ZmokQxo(arg3)) {
            if(FocusOwner.dispatchKeyEvent-YhN2O0w$default(this.getFocusOwner(), arg3, null, 2, null)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final int sendMotionEvent-8iAsVTc(MotionEvent arg10) {
        Object v4_1;
        if(this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.setKeyboardModifiers-5xRPYO0(PointerKeyboardModifiers.constructor-impl(arg10.getMetaState()));
        }

        AndroidComposeView v2 = this;
        PointerInputEvent v0 = this.motionEventAdapter.convertToPointerInputEvent$ui(arg10, ((PositionCalculator)v2));
        int v3 = arg10.getActionMasked();
        if(v0 != null) {
            List v1 = v0.getPointers();
            int v4 = v1.size() - 1;
            int v5 = 5;
            MotionEvent v6 = null;
            if(v4 >= 0) {
                while(true) {
                    int v7 = v4 - 1;
                    v4_1 = v1.get(v4);
                    if(v4_1.getDown()) {
                        if(v3 == 0) {
                            break;
                        }
                        else if(v3 == v5) {
                            break;
                        }
                        else if(!ComposeUiFlags.isCanScrollUsingLastDownEventFixEnabled) {
                            break;
                        }
                    }

                    if(v7 < 0) {
                        goto label_34;
                    }

                    v4 = v7;
                }
            }
            else {
            label_34:
                v4_1 = v6;
            }

            if(v4_1 != null) {
                this.lastDownPointerPosition = ((PointerInputEventData)v4_1).getPosition-F1C5BW0();
            }

            int v1_1 = this.pointerInputEventProcessor.process-BIzXfog(v0, ((PositionCalculator)v2), this.isInBounds(arg10));
            v0.setMotionEvent(v6);
            if(v3 != 0) {
                if(v3 == v5) {
                }
                else {
                    return v1_1;
                }
            }

            if((v1_1 & 1) != 0) {
                return v1_1;
            }

            this.motionEventAdapter.endStream(arg10.getPointerId(arg10.getActionIndex()));
            return v1_1;
        }

        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false, false);
    }

    private final void sendSimulatedEvent(MotionEvent arg18, int arg19, long arg20, boolean arg22) {
        int v10;
        AndroidComposeView v0 = this;
        MotionEvent v1 = arg18;
        int v5 = arg19;
        int v2 = v1.getActionMasked();
        int v3 = -1;
        if(v2 != 1) {
            if(v2 != 6) {
            }
            else {
                v3 = v1.getActionIndex();
            }
        }
        else if(v5 != 9 && v5 != 10) {
            v3 = 0;
        }

        v2 = v1.getPointerCount();
        int v7 = v3 >= 0 ? 1 : 0;
        v2 -= v7;
        if(v2 == 0) {
            return;
        }

        MotionEvent$PointerProperties[] v7_1 = new MotionEvent$PointerProperties[v2];
        int v8;
        for(v8 = 0; v8 < v2; ++v8) {
            v7_1[v8] = new MotionEvent$PointerProperties();
        }

        MotionEvent$PointerCoords[] v8_1 = new MotionEvent$PointerCoords[v2];
        int v9;
        for(v9 = 0; v9 < v2; ++v9) {
            v8_1[v9] = new MotionEvent$PointerCoords();
        }

        for(v9 = 0; v9 < v2; ++v9) {
            v10 = v3 < 0 || v9 < v3 ? 0 : 1;
            v10 += v9;
            v1.getPointerProperties(v10, v7_1[v9]);
            MotionEvent$PointerCoords v11 = v8_1[v9];
            v1.getPointerCoords(v10, v11);
            long v4 = v0.localToScreen-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v11.y))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v11.x))) << 0x20));
            v11.x = Float.intBitsToFloat(((int)(v4 >> 0x20)));
            v11.y = Float.intBitsToFloat(((int)(v4 & 0xFFFFFFFFL)));
        }

        v10 = arg22 ? 0 : v1.getButtonState();
        long v3_1 = v1.getDownTime() == v1.getEventTime() ? arg20 : v1.getDownTime();
        v1 = MotionEvent.obtain(v3_1, arg20, arg19, v2, v7_1, v8_1, v1.getMetaState(), v10, v1.getXPrecision(), v1.getYPrecision(), v1.getDeviceId(), v1.getEdgeFlags(), v1.getSource(), v1.getFlags());
        PointerInputEvent v2_1 = v0.motionEventAdapter.convertToPointerInputEvent$ui(v1, v0);
        Intrinsics.checkNotNull(v2_1);
        v0.pointerInputEventProcessor.process-BIzXfog(v2_1, v0, true);
        v1.recycle();
    }

    static void sendSimulatedEvent$default(AndroidComposeView arg6, MotionEvent arg7, int arg8, long arg9, boolean arg11, int arg12, Object arg13) {
        arg6.sendSimulatedEvent(arg7, arg8, arg9, true);
    }

    public void setAccessibilityEventBatchIntervalMillis(long arg1) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui(arg1);
    }

    public final void setConfiguration(Configuration arg1) {
        this.configuration$delegate.setValue(arg1);
    }

    public final void setContentCaptureManager$ui(AndroidContentCaptureManager arg1) {
        this.contentCaptureManager = arg1;
    }

    public void setCoroutineContext(CoroutineContext arg12) {
        Node v6_1;
        this.coroutineContext = arg12;
        Node v11 = this.getRoot().getNodes$ui().getHead$ui();
        if((v11 instanceof SuspendingPointerInputModifierNode)) {
            v11.resetPointerInputHandler();
        }

        int v12 = 16;
        int v0 = NodeKind.constructor-impl(v12);
        if(!((DelegatableNode)v11).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        MutableVector v1 = new MutableVector(new Node[v12], 0);
        Node v2 = ((DelegatableNode)v11).getNode().getChild$ui();
        if(v2 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v1, ((DelegatableNode)v11).getNode(), false);
        }
        else {
            v1.add(v2);
        }

        while(v1.getSize() != 0) {
            Object v11_1 = v1.removeAt(v1.getSize() - 1);
            if((((Node)v11_1).getAggregateChildKindSet$ui() & v0) != 0) {
                Object v4 = v11_1;
                while(v4 != null) {
                    if(!((Node)v4).isAttached()) {
                        break;
                    }

                    if((((Node)v4).getKindSet$ui() & v0) != 0) {
                        Object v5 = null;
                        Object v6 = v4;
                        MutableVector v7 = ((MutableVector)v5);
                        while(true) {
                        label_45:
                            if(v6 != null) {
                                if((v6 instanceof PointerInputModifierNode)) {
                                    if((v6 instanceof SuspendingPointerInputModifierNode)) {
                                        ((SuspendingPointerInputModifierNode)v6).resetPointerInputHandler();
                                    }
                                }
                                else if((((Node)v6).getKindSet$ui() & v0) != 0 && ((v6 instanceof DelegatingNode))) {
                                    Node v8 = v6.getDelegate$ui();
                                    int v9 = 0;
                                    while(v8 != null) {
                                        if((v8.getKindSet$ui() & v0) != 0) {
                                            ++v9;
                                            if(v9 == 1) {
                                                v6_1 = v8;
                                            }
                                            else {
                                                if(v7 == null) {
                                                    v7 = new MutableVector(new Node[v12], 0);
                                                }

                                                if(v6_1 != null) {
                                                    if(v7 != null) {
                                                        v7.add(v6_1);
                                                    }

                                                    v6 = v5;
                                                }

                                                if(v7 == null) {
                                                    goto label_78;
                                                }

                                                v7.add(v8);
                                            }
                                        }

                                    label_78:
                                        v8 = v8.getChild$ui();
                                    }

                                    if(v9 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_84;
                        }

                        v6_1 = DelegatableNodeKt.pop(v7);
                        goto label_45;
                    }

                label_84:
                    Node v4_1 = v4_1.getChild$ui();
                }
            }

            DelegatableNodeKt.addLayoutNodeChildren(v1, ((Node)v11_1), false);
        }
    }

    private void setDensity(Density arg1) {
        this.density$delegate.setValue(arg1);
    }

    private void setFontFamilyResolver(Resolver arg1) {
        this.fontFamilyResolver$delegate.setValue(arg1);
    }

    public final void setFrameEndScheduler$ui(FrameEndScheduler arg1) {
        this.frameEndScheduler = arg1;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui(long arg1) {
        this.lastMatrixRecalculationAnimationTime = arg1;
    }

    private void setLayoutDirection(LayoutDirection arg1) {
        this.layoutDirection$delegate.setValue(arg1);
    }

    public final void setOnViewTreeOwnersAvailable(Function1 arg2) {
        ViewTreeOwners v0 = this.getViewTreeOwners();
        if(v0 != null) {
            arg2.invoke(v0);
        }

        if(!this.isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = arg2;
        }
    }

    public final void setPrimaryDirectionalMotionAxisOverride-r2epLt8$ui(IndirectPointerEventPrimaryDirectionalMotionAxis arg1) {
        this.primaryDirectionalMotionAxisOverride = arg1;
    }

    public void setShowLayoutBounds(boolean arg1) {
        this.showLayoutBounds = arg1;
    }

    public void setUncaughtExceptionHandler(UncaughtExceptionHandler arg1) {
        this.uncaughtExceptionHandler = arg1;
        this.measureAndLayoutDelegate.setUncaughtExceptionHandler$ui(arg1);
    }

    public final void setUncaughtExceptionHandler$ui(UncaughtExceptionHandler arg1) {
        this.uncaughtExceptionHandler = arg1;
    }

    private final void set_viewTreeOwners(ViewTreeOwners arg1) {
        this._viewTreeOwners$delegate.setValue(arg1);
    }

    public boolean shouldDelayChildPressedState() {
        return 0;
    }

    private final boolean startDrag-12SF9DM(DragAndDropTransferData arg9, long arg10, Function1 arg12) {
        Resources v0 = this.getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(((View)this), arg9, new ComposeDragShadowBuilder(DensityKt.Density(v0.getDisplayMetrics().density, v0.getConfiguration().fontScale), arg10, arg12, null));
    }

    public Object textInputSession(Function2 arg5, Continuation arg6) {
        int v2;
        Continuation v0;
        if((arg6 instanceof AndroidComposeView$textInputSession$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((AndroidComposeView$textInputSession$1)v0).label & v2) != 0) {
                ((AndroidComposeView$textInputSession$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            AndroidComposeView$textInputSession$1 v0_1 = new AndroidComposeView$textInputSession$1(this, arg6);
        }

        Object v6 = ((AndroidComposeView$textInputSession$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((AndroidComposeView$textInputSession$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            AtomicReference v6_1 = this.textInputSessionMutex;
            AndroidComposeView$textInputSession$2 v2_1 = new AndroidComposeView$textInputSession$2(this);
            ((AndroidComposeView$textInputSession$1)v0).label = 1;
            if(SessionMutex.withSessionCancellingPrevious-impl(v6_1, ((Function1)v2_1), arg5, v0) == v1) {
                return v1;
            }
        }
        else if(v2 != 1) {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }
        else {
            ResultKt.throwOnFailure(v6);
        }

        throw new KotlinNothingValueException();
    }

    private final void updateConfiguration(Configuration arg4) {
        Configuration v0 = this.getConfiguration();
        if(!Intrinsics.areEqual(v0, arg4)) {
            this.setConfiguration(new Configuration(arg4));
            if(v0.fontScale != arg4.fontScale || v0.densityDpi != arg4.densityDpi) {
                this.setDensity(AndroidDensity_androidKt.Density(this.getContext()));
            }

            if(AndroidComposeView_androidKt.access$diffForWindowMetricsChanged(v0, arg4)) {
                this.updateWindowMetrics();
            }

            if(this.getFontWeightAdjustmentCompat(v0) == this.getFontWeightAdjustmentCompat(arg4)) {
                return;
            }

            this.setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(this.getContext()));
        }
    }

    private final void updatePositionCacheAndDispatch() {
        this.getLocationOnScreen(this.tmpPositionArray);
        long v0 = this.globalPosition;
        int v2 = IntOffset.getX-impl(v0);
        int v0_1 = IntOffset.getY-impl(v0);
        int[] v1 = this.tmpPositionArray;
        boolean v3 = false;
        int v4 = v1[0];
        if(v2 != v4 || v0_1 != v1[1] || this.lastMatrixRecalculationAnimationTime < 0) {
            this.globalPosition = IntOffset.constructor-impl((((long)v4)) << 0x20 | (((long)v1[1])) & 0xFFFFFFFFL);
            int v1_1 = 0x7FFFFFFF;
            if(v2 != v1_1 && v0_1 != v1_1) {
                this.getRoot().getLayoutDelegate$ui().getMeasurePassDelegate$ui().notifyChildrenUsingCoordinatesWhilePlacing();
                v3 = true;
            }
        }

        this.recalculateWindowPosition();
        View v0_2 = this._rootView;
        if(v0_2 == null) {
            v0_2 = this.getRootView();
            this._rootView = v0_2;
        }

        this.getRectManager().updateOffsets-gTq6Wqs(this.globalPosition, IntOffsetKt.round-k-4lQ0M(this.windowPosition), this.viewToWindowMatrix, v0_2.getWidth(), v0_2.getHeight());
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(v3);
        this.getRectManager().dispatchCallbacks();
    }

    private final void updateWindowMetrics() {
        MutableState v0 = LazyWindowInfo.access$get_containerSize$p(this._windowInfo);
        if(v0 != null) {
            v0.setValue(AndroidWindowInfo_androidKt.calculateWindowSize(((View)this)));
        }
    }

    public void voteFrameRate(float arg3) {
        if(this.isArrEnabled) {
            if(arg3 > 0f) {
                if(!Float.isNaN(this.currentFrameRate) && arg3 <= this.currentFrameRate) {
                    return;
                }

                this.currentFrameRate = arg3;
                return;
            }
            else {
                if(arg3 >= 0f) {
                    return;
                }

                if(!Float.isNaN(this.currentFrameRateCategory) && arg3 >= this.currentFrameRateCategory) {
                    return;
                }

                this.currentFrameRateCategory = arg3;
            }
        }
    }
}

