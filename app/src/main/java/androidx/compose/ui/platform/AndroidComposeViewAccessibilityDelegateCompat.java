package androidx.compose.ui.platform;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.ArraySet;
import androidx.collection.IntIntMapKt;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSet;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterSet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.R$id;
import androidx.compose.ui.R$string;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsNode_androidKt;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$RangeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u008E\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\n\u008E\u0002\u008F\u0002\u0090\u0002\u0091\u0002\u0092\u0002B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010-\u001A\u00020.H\u0002J\u0010\u0010v\u001A\u00020.2\u0006\u0010\u0005\u001A\u00020wH\u0016J\u0010\u0010x\u001A\u00020.2\u0006\u0010\u0005\u001A\u00020wH\u0016J\u0010\u0010y\u001A\u00020.2\u0006\u0010z\u001A\u00020\u0016H\u0016J\u0010\u0010{\u001A\u00020.2\u0006\u0010z\u001A\u00020\u0016H\u0016J*\u0010|\u001A\u00020\u00162\u0006\u0010}\u001A\u00020\u00162\u0006\u0010~\u001A\u00020\f2\u0007\u0010\u007F\u001A\u00030\u0080\u0001H\u0000¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J8\u0010|\u001A\u00020\u00162\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010}\u001A\u00020\u00162\u0006\u0010~\u001A\u00020\f2\u0007\u0010\u007F\u001A\u00030\u0080\u0001H\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\t\u0010\u0085\u0001\u001A\u00020\u0016H\u0002J\u0014\u0010\u0086\u0001\u001A\u0004\u0018\u00010B2\u0007\u0010\u0087\u0001\u001A\u00020\fH\u0002J\u000B\u0010\u0088\u0001\u001A\u0004\u0018\u00010BH\u0002J\u0013\u0010\u0089\u0001\u001A\u00030\u008A\u00012\u0007\u0010\u008B\u0001\u001A\u00020[H\u0002J2\u0010\u008C\u0001\u001A\u00030\u008A\u00012\b\u0010\u008D\u0001\u001A\u00030\u008E\u00012\b\u0010\u008F\u0001\u001A\u00030\u008E\u00012\b\u0010\u0090\u0001\u001A\u00030\u008E\u00012\b\u0010\u0091\u0001\u001A\u00030\u008E\u0001H\u0002J%\u0010\u0092\u0001\u001A\u00020.2\u0007\u0010\u0087\u0001\u001A\u00020\f2\u0007\u0010\u0093\u0001\u001A\u00020B2\b\u0010\u0094\u0001\u001A\u00030\u0095\u0001H\u0002J\u001C\u0010\u0096\u0001\u001A\u00020.2\b\u0010\u008B\u0001\u001A\u00030\u0095\u00012\u0007\u0010\u0093\u0001\u001A\u00020BH\u0002J\u0011\u0010\u0097\u0001\u001A\u0005\u0018\u00010\u0098\u0001*\u00030\u0099\u0001H\u0002J\u001C\u0010\u009A\u0001\u001A\u00020.2\b\u0010\u008B\u0001\u001A\u00030\u0095\u00012\u0007\u0010\u0093\u0001\u001A\u00020BH\u0002J\u0012\u0010\u009B\u0001\u001A\u00020\u00162\u0007\u0010\u0087\u0001\u001A\u00020\fH\u0002J\u0012\u0010\u009C\u0001\u001A\u00020\u00162\u0007\u0010\u0087\u0001\u001A\u00020\fH\u0002JA\u0010\u009D\u0001\u001A\u00020\u00162\u0007\u0010\u0087\u0001\u001A\u00020\f2\u0007\u0010\u009E\u0001\u001A\u00020\f2\u000B\b\u0002\u0010\u009F\u0001\u001A\u0004\u0018\u00010\f2\u0011\b\u0002\u0010 \u0001\u001A\n\u0012\u0004\u0012\u00020j\u0018\u00010+H\u0002¢\u0006\u0003\u0010¡\u0001J\u0012\u0010¢\u0001\u001A\u00020\u00162\u0007\u0010£\u0001\u001A\u00020\u0015H\u0002J\u001B\u0010¤\u0001\u001A\u00020\u00152\u0007\u0010\u0087\u0001\u001A\u00020\f2\u0007\u0010\u009E\u0001\u001A\u00020\fH\u0003JD\u0010¥\u0001\u001A\u00020\u00152\u0007\u0010\u0087\u0001\u001A\u00020\f2\t\u0010¦\u0001\u001A\u0004\u0018\u00010\f2\t\u0010§\u0001\u001A\u0004\u0018\u00010\f2\t\u0010¨\u0001\u001A\u0004\u0018\u00010\f2\t\u0010©\u0001\u001A\u0004\u0018\u00010KH\u0002¢\u0006\u0003\u0010ª\u0001J\u0012\u0010«\u0001\u001A\u00020\u00162\u0007\u0010\u0087\u0001\u001A\u00020\fH\u0002J\'\u0010¬\u0001\u001A\u00020\u00162\u0007\u0010\u0087\u0001\u001A\u00020\f2\u0007\u0010­\u0001\u001A\u00020\f2\n\u0010®\u0001\u001A\u0005\u0018\u00010¯\u0001H\u0002J0\u0010°\u0001\u001A\u00020.2\u0007\u0010\u0087\u0001\u001A\u00020\f2\u0007\u0010\u0093\u0001\u001A\u00020B2\u0007\u0010±\u0001\u001A\u00020j2\n\u0010®\u0001\u001A\u0005\u0018\u00010¯\u0001H\u0002J(\u0010´\u0001\u001A\u00030µ\u00012\b\u0010\u008B\u0001\u001A\u00030\u0095\u00012\b\u0010¶\u0001\u001A\u00030\u008A\u00012\b\u0010·\u0001\u001A\u00030¸\u0001H\u0002J\u0019\u0010¹\u0001\u001A\u00030µ\u0001*\u00030\u008A\u00012\b\u0010¶\u0001\u001A\u00030\u008A\u0001H\u0002J\"\u0010º\u0001\u001A\u0005\u0018\u00010»\u00012\n\u0010¼\u0001\u001A\u0005\u0018\u00010\u0095\u00012\b\u0010½\u0001\u001A\u00030µ\u0001H\u0002J,\u0010¾\u0001\u001A\u00030¿\u0001*\u00030¸\u00012\b\u0010À\u0001\u001A\u00030Á\u00012\b\u0010Â\u0001\u001A\u00030Ã\u0001H\u0002¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J%\u0010Æ\u0001\u001A\u0005\u0018\u00010\u008A\u0001*\u00030¿\u00012\b\u0010Ç\u0001\u001A\u00030\u008E\u00012\b\u0010È\u0001\u001A\u00030\u008E\u0001H\u0002J\u0011\u0010É\u0001\u001A\u0005\u0018\u00010Ê\u0001*\u00030¿\u0001H\u0002J%\u0010Ë\u0001\u001A\u0005\u0018\u00010Ì\u0001*\u00030¿\u00012\b\u0010Ç\u0001\u001A\u00030\u008E\u00012\b\u0010È\u0001\u001A\u00030\u008E\u0001H\u0002J\'\u0010Æ\u0001\u001A\u00030\u008A\u0001*\u00030µ\u00012\n\b\u0002\u0010Ç\u0001\u001A\u00030\u008E\u00012\n\b\u0002\u0010È\u0001\u001A\u00030\u008E\u0001H\u0002J\u0019\u0010Í\u0001\u001A\u00020\u00162\b\u0010£\u0001\u001A\u00030Î\u0001H\u0000¢\u0006\u0003\bÏ\u0001J#\u0010Ð\u0001\u001A\u00020\f2\b\u0010Ñ\u0001\u001A\u00030\u008E\u00012\b\u0010Ò\u0001\u001A\u00030\u008E\u0001H\u0001¢\u0006\u0003\bÓ\u0001J\u0012\u0010Ô\u0001\u001A\u00020.2\u0007\u0010\u0087\u0001\u001A\u00020\fH\u0002J\u0013\u0010Õ\u0001\u001A\u00030Ö\u00012\u0007\u0010×\u0001\u001A\u00020wH\u0016J4\u0010Ø\u0001\u001A\u0005\u0018\u0001HÙ\u0001\"\t\b\u0000\u0010Ù\u0001*\u00020K2\n\u0010©\u0001\u001A\u0005\u0018\u0001HÙ\u00012\t\b\u0001\u0010À\u0001\u001A\u00020\fH\u0002¢\u0006\u0003\u0010Ú\u0001J\u000F\u0010Ý\u0001\u001A\u00020.H\u0000¢\u0006\u0003\bÞ\u0001J\u0013\u0010ß\u0001\u001A\u00020.H\u0080@¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0018\u0010â\u0001\u001A\u00020.2\u0007\u0010ã\u0001\u001A\u00020SH\u0000¢\u0006\u0003\bä\u0001J\u0012\u0010å\u0001\u001A\u00020.2\u0007\u0010ã\u0001\u001A\u00020SH\u0002J\u0012\u0010æ\u0001\u001A\u00020.2\u0007\u0010ã\u0001\u001A\u00020SH\u0002J\u001B\u0010ç\u0001\u001A\u00020.2\u0007\u0010ã\u0001\u001A\u00020S2\u0007\u0010è\u0001\u001A\u00020_H\u0002J\t\u0010é\u0001\u001A\u00020.H\u0002J\t\u0010ê\u0001\u001A\u00020.H\u0002J\u0018\u0010ë\u0001\u001A\u00020.2\r\u0010ì\u0001\u001A\b\u0012\u0004\u0012\u00020[0ZH\u0002J\"\u0010ñ\u0001\u001A\u00020\u00162\u0007\u0010ò\u0001\u001A\u00020\f2\u000E\u0010ó\u0001\u001A\t\u0012\u0005\u0012\u00030ï\u00010+H\u0002J\u0013\u0010ô\u0001\u001A\u00020.2\b\u0010õ\u0001\u001A\u00030ï\u0001H\u0002J&\u0010ö\u0001\u001A\u00020.2\u0007\u0010÷\u0001\u001A\u00020\f2\u0007\u0010\u009F\u0001\u001A\u00020\f2\t\u0010ø\u0001\u001A\u0004\u0018\u00010jH\u0002J\u001C\u0010ù\u0001\u001A\u00020.2\b\u0010ú\u0001\u001A\u00030\u0095\u00012\u0007\u0010û\u0001\u001A\u00020rH\u0002J\u0012\u0010ü\u0001\u001A\u00020\f2\u0007\u0010ò\u0001\u001A\u00020\fH\u0002J.\u0010ý\u0001\u001A\u00020\u00162\b\u0010\u008B\u0001\u001A\u00030\u0095\u00012\u0007\u0010þ\u0001\u001A\u00020\f2\u0007\u0010ÿ\u0001\u001A\u00020\u00162\u0007\u0010\u0080\u0002\u001A\u00020\u0016H\u0002J\u0012\u0010\u0081\u0002\u001A\u00020.2\u0007\u0010÷\u0001\u001A\u00020\fH\u0002J.\u0010\u0082\u0002\u001A\u00020\u00162\b\u0010\u008B\u0001\u001A\u00030\u0095\u00012\u0007\u0010\u0083\u0002\u001A\u00020\f2\u0007\u0010\u0084\u0002\u001A\u00020\f2\u0007\u0010\u0085\u0002\u001A\u00020\u0016H\u0002J\u0013\u0010\u0086\u0002\u001A\u00020\f2\b\u0010\u008B\u0001\u001A\u00030\u0095\u0001H\u0002J\u0013\u0010\u0087\u0002\u001A\u00020\f2\b\u0010\u008B\u0001\u001A\u00030\u0095\u0001H\u0002J\u0013\u0010\u0088\u0002\u001A\u00020\u00162\b\u0010\u008B\u0001\u001A\u00030\u0095\u0001H\u0002J!\u0010\u0089\u0002\u001A\u0005\u0018\u00010\u008A\u00022\n\u0010\u008B\u0001\u001A\u0005\u0018\u00010\u0095\u00012\u0007\u0010þ\u0001\u001A\u00020\fH\u0002J\u0017\u0010\u008B\u0002\u001A\u0004\u0018\u00010j2\n\u0010\u008B\u0001\u001A\u0005\u0018\u00010\u0095\u0001H\u0002J\u0011\u0010\u008C\u0002\u001A\u0005\u0018\u00010\u0099\u0001*\u00030\u008D\u0002H\u0002R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR$\u0010\u000B\u001A\u00020\f8\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u000E\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u000E\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001F\u001A\u00020\u00162\u0006\u0010\u001E\u001A\u00020\u0016@@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001A\u0010$\u001A\u00020%X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0016\u0010*\u001A\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010/\u001A\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b0\u00101R\u0014\u00102\u001A\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b3\u0010!R\u0014\u00104\u001A\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b4\u0010!R\u001E\u00105\u001A\u0004\u0018\u00010\u0016X\u0080\u000E¢\u0006\u0010\n\u0002\u0010:\u001A\u0004\b6\u00107\"\u0004\b8\u00109R\u000E\u0010;\u001A\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010=\u001A\u00060>R\u00020\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010?\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010@\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010A\u001A\u0004\u0018\u00010BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010C\u001A\u0004\u0018\u00010BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010D\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010E\u001A\b\u0012\u0004\u0012\u00020G0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001A\b\u0012\u0004\u0012\u00020G0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010I\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0J0JX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010L\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0M0JX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010N\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010O\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0004\n\u0002\u0010PR\u0014\u0010Q\u001A\b\u0012\u0004\u0012\u00020S0RX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010T\u001A\b\u0012\u0004\u0012\u00020.0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010V\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010W\u001A\u0004\u0018\u00010XX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010Y\u001A\b\u0012\u0004\u0012\u00020[0Z8BX\u0082\u000E¢\u0006\b\n\u0000\u001A\u0004\b\\\u0010]R\u000E\u0010^\u001A\u00020_X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010`\u001A\u00020aX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001A\u0010f\u001A\u00020aX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bg\u0010c\"\u0004\bh\u0010eR\u0014\u0010i\u001A\u00020jX\u0080D¢\u0006\b\n\u0000\u001A\u0004\bk\u0010lR\u0014\u0010m\u001A\u00020jX\u0080D¢\u0006\b\n\u0000\u001A\u0004\bn\u0010lR\u000E\u0010o\u001A\u00020pX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010q\u001A\b\u0012\u0004\u0012\u00020r0FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010s\u001A\u00020rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010t\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010u\u001A\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0089\u0001\u001A\u00030\u008A\u0001*\u00020B8BX\u0082\u0004¢\u0006\b\u001A\u0006\b²\u0001\u0010³\u0001R\u0010\u0010Û\u0001\u001A\u00030Ü\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010í\u0001\u001A\n\u0012\u0005\u0012\u00030ï\u00010î\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010ð\u0001\u001A\u000F\u0012\u0005\u0012\u00030ï\u0001\u0012\u0004\u0012\u00020.0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0093\u0002"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "hoveredVirtualViewId", "", "getHoveredVirtualViewId$ui$annotations", "()V", "getHoveredVirtualViewId$ui", "()I", "setHoveredVirtualViewId$ui", "(I)V", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "", "getOnSendAccessibilityEvent$ui$annotations", "getOnSendAccessibilityEvent$ui", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui", "(Lkotlin/jvm/functions/Function1;)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "value", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui", "()Z", "setAccessibilityForceEnabledForTesting$ui", "(Z)V", "SendRecurringAccessibilityEventsIntervalMillis", "", "getSendRecurringAccessibilityEventsIntervalMillis$ui", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui", "(J)V", "_enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "resetEnabledAccessibilityServiceList", "", "enabledServices", "getEnabledServices", "()Ljava/util/List;", "isEnabled", "isEnabled$ui", "isTouchExplorationEnabled", "requestFromAccessibilityToolForTesting", "getRequestFromAccessibilityToolForTesting$ui", "()Ljava/lang/Boolean;", "setRequestFromAccessibilityToolForTesting$ui", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "handler", "Landroid/os/Handler;", "nodeProvider", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "accessibilityFocusedVirtualViewId", "focusedVirtualViewId", "currentlyAccessibilityFocusedANI", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "currentlyFocusedANI", "sendingFocusAffectingEvent", "pendingHorizontalScrollEvents", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingVerticalScrollEvents", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "labelToActionId", "Landroidx/collection/MutableObjectIntMap;", "accessibilityCursorPosition", "previousTraversedNode", "Ljava/lang/Integer;", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "currentSemanticsNodesInvalidated", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "idToBeforeMap", "Landroidx/collection/MutableIntIntMap;", "getIdToBeforeMap$ui", "()Landroidx/collection/MutableIntIntMap;", "setIdToBeforeMap$ui", "(Landroidx/collection/MutableIntIntMap;)V", "idToAfterMap", "getIdToAfterMap$ui", "setIdToAfterMap$ui", "ExtraDataTestTraversalBeforeVal", "", "getExtraDataTestTraversalBeforeVal$ui", "()Ljava/lang/String;", "ExtraDataTestTraversalAfterVal", "getExtraDataTestTraversalAfterVal$ui", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "checkingForSemanticsChanges", "drawingOrder", "onViewAttachedToWindow", "Landroid/view/View;", "onViewDetachedFromWindow", "onAccessibilityStateChanged", "enabled", "onTouchExplorationStateChanged", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui", "(ZIJ)Z", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "isRequestFromAccessibilityTool", "createNodeInfo", "virtualViewId", "emptyNodeInfoOrNull", "boundsInScreen", "Landroid/graphics/Rect;", "node", "toBoundsInScreen", "left", "", "top", "right", "bottom", "populateAccessibilityNodeInfoProperties", "info", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "setContentInvalid", "toSpannableString", "Landroid/text/SpannableString;", "Landroidx/compose/ui/text/AnnotatedString;", "setText", "isAccessibilityFocused", "requestAccessibilityFocus", "sendEventForVirtualView", "eventType", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendEvent", "event", "createEvent", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "clearAccessibilityFocus", "performActionHelper", "action", "arguments", "Landroid/os/Bundle;", "addExtraDataToAccessibilityNodeInfoHelper", "extraDataKey", "getBoundsInScreen", "(Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)Landroid/graphics/Rect;", "getShapeBounds", "Landroidx/compose/ui/geometry/Rect;", "nodeBoundsInScreen", "shape", "Landroidx/compose/ui/graphics/Shape;", "toBoundsRelativeToNodeBounds", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-12SF9DM", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "toAndroidRect", "leftOffset", "topOffset", "toCornerArray", "", "toRegion", "Landroid/graphics/Region;", "dispatchHoverEvent", "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui", "hitTestSemanticsAt", "x", "y", "hitTestSemanticsAt$ui", "updateHoveredVirtualView", "getAccessibilityNodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "host", "trimToSize", "T", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "onSemanticsChange", "onSemanticsChange$ui", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLayoutChange", "layoutNode", "onLayoutChange$ui", "notifySubtreeAccessibilityStateChangedIfNeeded", "sendTypeViewScrolledAccessibilityEvent", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "checkForSemanticsChanges", "updateSemanticsNodesCopyAndPanes", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "scrollObservationScopes", "", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scheduleScrollEventIfNeededLambda", "registerScrollingId", "id", "oldScrollObservationScopes", "scheduleScrollEventIfNeeded", "scrollObservationScope", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "semanticsNodeIdToAccessibilityVirtualNodeId", "traverseAtGranularity", "granularity", "forward", "extendSelection", "sendPendingTextTraversedAtGranularityEvent", "setAccessibilitySelection", "start", "end", "traversalMode", "getAccessibilitySelectionStart", "getAccessibilitySelectionEnd", "isAccessibilitySelectionExtendable", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "getIterableTextForAccessibility", "getTextForTextField", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Companion", "PendingTextTraversedEvent", "ComposeAccessibilityNodeProvider", "Api24Impl", "Api29Impl", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat implements View$OnAttachStateChangeListener, AccessibilityManager$AccessibilityStateChangeListener, AccessibilityManager$TouchExplorationStateChangeListener {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "<init>", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api24Impl {
        public static final Api24Impl INSTANCE;

        static {
            Api24Impl.INSTANCE = new Api24Impl();
        }

        private Api24Impl() {
            super();
        }

        @JvmStatic public static final void addSetProgressAction(AccessibilityNodeInfoCompat arg2, SemanticsNode arg3) {
            if(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(arg3)) {
                Object v3 = SemanticsConfigurationKt.getOrNull(arg3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetProgress());
                if(v3 != null) {
                    arg2.addAction(new AccessibilityActionCompat(0x102003D, ((AccessibilityAction)v3).getLabel()));
                }
            }
        }
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "<init>", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api29Impl {
        public static final Api29Impl INSTANCE;

        static {
            Api29Impl.INSTANCE = new Api29Impl();
        }

        private Api29Impl() {
            super();
        }

        @JvmStatic public static final void addPageActions(AccessibilityNodeInfoCompat arg3, SemanticsNode arg4) {
            Object v0 = SemanticsConfigurationKt.getOrNull(arg4.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getRole());
            if(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(arg4)) {
                int v1 = Role.Companion.getCarousel-o7Vup1c();
                boolean v0_1 = v0 == null ? false : Role.equals-impl0(((Role)v0).unbox-impl(), v1);
                if(v0_1) {
                    return;
                }

                v0 = SemanticsConfigurationKt.getOrNull(arg4.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageUp());
                if(v0 != null) {
                    arg3.addAction(new AccessibilityActionCompat(0x1020046, ((AccessibilityAction)v0).getLabel()));
                }

                v0 = SemanticsConfigurationKt.getOrNull(arg4.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageDown());
                if(v0 != null) {
                    arg3.addAction(new AccessibilityActionCompat(0x1020047, ((AccessibilityAction)v0).getLabel()));
                }

                v0 = SemanticsConfigurationKt.getOrNull(arg4.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageLeft());
                if(v0 != null) {
                    arg3.addAction(new AccessibilityActionCompat(0x1020048, ((AccessibilityAction)v0).getLabel()));
                }

                Object v4 = SemanticsConfigurationKt.getOrNull(arg4.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageRight());
                if(v4 == null) {
                    return;
                }

                arg3.addAction(new AccessibilityActionCompat(0x1020049, ((AccessibilityAction)v4).getLabel()));
            }
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Companion;", "", "<init>", "()V", "InvalidId", "", "ClassName", "", "TextFieldClassName", "TextClassName", "LogTag", "ExtraDataTestTagKey", "ExtraDataIdKey", "ExtraDataShapeTypeKey", "ExtraDataShapeTypeRectangle", "ExtraDataShapeTypeRounded", "ExtraDataShapeTypeGeneric", "ExtraDataShapeRectKey", "ExtraDataShapeRectCornersKey", "ExtraDataShapeRegionKey", "ParcelSafeTextLength", "AccessibilityCursorPositionUndefined", "AccessibilitySliderStepsCount", "TextTraversedEventTimeoutMillis", "", "AccessibilityActionsResourceIds", "Landroidx/collection/IntList;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\"\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0016J*\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00112\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001A\u00020\u0007H\u0016¨\u0006\u0014"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "createAccessibilityNodeInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "virtualViewId", "", "performAction", "", "action", "arguments", "Landroid/os/Bundle;", "addExtraDataToAccessibilityNodeInfo", "", "info", "extraDataKey", "", "findFocus", "focus", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
        public ComposeAccessibilityNodeProvider(AndroidComposeViewAccessibilityDelegateCompat arg1) {
            AndroidComposeViewAccessibilityDelegateCompat.this = arg1;
            super();
        }

        public void addExtraDataToAccessibilityNodeInfo(int arg1, AccessibilityNodeInfoCompat arg2, String arg3, Bundle arg4) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(arg1, arg2, arg3, arg4);
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int arg3) {
            AccessibilityNodeInfoCompat v0 = AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(arg3);
            AndroidComposeViewAccessibilityDelegateCompat v2 = AndroidComposeViewAccessibilityDelegateCompat.this;
            if(v2.sendingFocusAffectingEvent) {
                if(arg3 == v2.accessibilityFocusedVirtualViewId) {
                    v2.currentlyAccessibilityFocusedANI = v0;
                }

                if(arg3 != v2.focusedVirtualViewId) {
                    return v0;
                }

                v2.currentlyFocusedANI = v0;
            }

            return v0;
        }

        public AccessibilityNodeInfoCompat findFocus(int arg3) {
            if(arg3 != 1) {
                if(arg3 == 2) {
                    return this.createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityFocusedVirtualViewId);
                }

                throw new IllegalArgumentException("Unknown focus type: " + arg3);
            }

            if(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId == 0x80000000) {
                return null;
            }

            return this.createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
        }

        public boolean performAction(int arg1, int arg2, Bundle arg3) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(arg1, arg2, arg3);
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "<init>", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getAction", "()I", "getGranularity", "getFromIndex", "getToIndex", "getTraverseTime", "()J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode arg1, int arg2, int arg3, int arg4, int arg5, long arg6) {
            super();
            this.node = arg1;
            this.action = arg2;
            this.granularity = arg3;
            this.fromIndex = arg4;
            this.toIndex = arg5;
            this.traverseTime = arg6;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    public static final int $stable = 0;
    private static final IntList AccessibilityActionsResourceIds = null;
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final Companion Companion = null;
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataShapeRectCornersKey = "androidx.compose.ui.semantics.shapeCorners";
    public static final String ExtraDataShapeRectKey = "androidx.compose.ui.semantics.shapeRect";
    public static final String ExtraDataShapeRegionKey = "androidx.compose.ui.semantics.shapeRegion";
    public static final int ExtraDataShapeTypeGeneric = 2;
    public static final String ExtraDataShapeTypeKey = "androidx.compose.ui.semantics.shapeType";
    public static final int ExtraDataShapeTypeRectangle = 0;
    public static final int ExtraDataShapeTypeRounded = 1;
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    public static final int InvalidId = 0x80000000;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    private long SendRecurringAccessibilityEventsIntervalMillis;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private List _enabledServices;
    private int accessibilityCursorPosition;
    private int accessibilityFocusedVirtualViewId;
    private boolean accessibilityForceEnabledForTesting;
    private final AccessibilityManager accessibilityManager;
    private SparseArrayCompat actionIdToLabel;
    private final Channel boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private AccessibilityNodeInfoCompat currentlyAccessibilityFocusedANI;
    private AccessibilityNodeInfoCompat currentlyFocusedANI;
    private final MutableIntIntMap drawingOrder;
    private int focusedVirtualViewId;
    private final Handler handler;
    private int hoveredVirtualViewId;
    private MutableIntIntMap idToAfterMap;
    private MutableIntIntMap idToBeforeMap;
    private SparseArrayCompat labelToActionId;
    private ComposeAccessibilityNodeProvider nodeProvider;
    private Function1 onSendAccessibilityEvent;
    private MutableIntSet paneDisplayed;
    private final MutableIntObjectMap pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private final MutableIntObjectMap pendingVerticalScrollEvents;
    private MutableIntObjectMap previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private Boolean requestFromAccessibilityToolForTesting;
    private final Function1 scheduleScrollEventIfNeededLambda;
    private final List scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private boolean sendingFocusAffectingEvent;
    private final ArraySet subtreeChangedLayoutNodes;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;

    static {
        AndroidComposeViewAccessibilityDelegateCompat.Companion = new Companion(null);
        AndroidComposeViewAccessibilityDelegateCompat.$stable = 8;
        AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds = IntListKt.intListOf(new int[]{id.accessibility_custom_action_0, id.accessibility_custom_action_1, id.accessibility_custom_action_2, id.accessibility_custom_action_3, id.accessibility_custom_action_4, id.accessibility_custom_action_5, id.accessibility_custom_action_6, id.accessibility_custom_action_7, id.accessibility_custom_action_8, id.accessibility_custom_action_9, id.accessibility_custom_action_10, id.accessibility_custom_action_11, id.accessibility_custom_action_12, id.accessibility_custom_action_13, id.accessibility_custom_action_14, id.accessibility_custom_action_15, id.accessibility_custom_action_16, id.accessibility_custom_action_17, id.accessibility_custom_action_18, id.accessibility_custom_action_19, id.accessibility_custom_action_20, id.accessibility_custom_action_21, id.accessibility_custom_action_22, id.accessibility_custom_action_23, id.accessibility_custom_action_24, id.accessibility_custom_action_25, id.accessibility_custom_action_26, id.accessibility_custom_action_27, id.accessibility_custom_action_28, id.accessibility_custom_action_29, id.accessibility_custom_action_30, id.accessibility_custom_action_31});
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView arg5) {
        super();
        this.view = arg5;
        this.hoveredVirtualViewId = 0x80000000;
        this.onSendAccessibilityEvent = new AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1(this);
        Object v1 = arg5.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = ((AccessibilityManager)v1);
        this.SendRecurringAccessibilityEventsIntervalMillis = 100;
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new ComposeAccessibilityNodeProvider(this);
        this.accessibilityFocusedVirtualViewId = 0x80000000;
        this.focusedVirtualViewId = 0x80000000;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap(0, 1, null);
        this.pendingVerticalScrollEvents = new MutableIntObjectMap(0, 1, null);
        this.actionIdToLabel = new SparseArrayCompat(0, 1, null);
        this.labelToActionId = new SparseArrayCompat(0, 1, null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet(0, 1, null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.paneDisplayed = new MutableIntSet(0, 1, null);
        this.idToBeforeMap = new MutableIntIntMap(0, 1, null);
        this.idToAfterMap = new MutableIntIntMap(0, 1, null);
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(arg5.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.drawingOrder = IntIntMapKt.mutableIntIntMapOf();
        arg5.addOnAttachStateChangeListener(this);
        this.semanticsChangeChecker = new AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0(this);
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1(this);
    }

    public static final void access$addExtraDataToAccessibilityNodeInfoHelper(AndroidComposeViewAccessibilityDelegateCompat arg0, int arg1, AccessibilityNodeInfoCompat arg2, String arg3, Bundle arg4) {
        arg0.addExtraDataToAccessibilityNodeInfoHelper(arg1, arg2, arg3, arg4);
    }

    public static final Rect access$boundsInScreen(AndroidComposeViewAccessibilityDelegateCompat arg0, SemanticsNodeWithAdjustedBounds arg1) {
        return arg0.boundsInScreen(arg1);
    }

    public static final AccessibilityNodeInfoCompat access$createNodeInfo(AndroidComposeViewAccessibilityDelegateCompat arg0, int arg1) {
        return arg0.createNodeInfo(arg1);
    }

    public static final int access$getAccessibilityFocusedVirtualViewId$p(AndroidComposeViewAccessibilityDelegateCompat arg0) {
        return arg0.accessibilityFocusedVirtualViewId;
    }

    public static final IntObjectMap access$getCurrentSemanticsNodes(AndroidComposeViewAccessibilityDelegateCompat arg0) {
        return arg0.getCurrentSemanticsNodes();
    }

    public static final AccessibilityNodeInfoCompat access$getCurrentlyAccessibilityFocusedANI$p(AndroidComposeViewAccessibilityDelegateCompat arg0) {
        return arg0.currentlyAccessibilityFocusedANI;
    }

    public static final AccessibilityNodeInfoCompat access$getCurrentlyFocusedANI$p(AndroidComposeViewAccessibilityDelegateCompat arg0) {
        return arg0.currentlyFocusedANI;
    }

    public static final int access$getFocusedVirtualViewId$p(AndroidComposeViewAccessibilityDelegateCompat arg0) {
        return arg0.focusedVirtualViewId;
    }

    public static final MutableIntObjectMap access$getPendingHorizontalScrollEvents$p(AndroidComposeViewAccessibilityDelegateCompat arg0) {
        return arg0.pendingHorizontalScrollEvents;
    }

    public static final MutableIntObjectMap access$getPendingVerticalScrollEvents$p(AndroidComposeViewAccessibilityDelegateCompat arg0) {
        return arg0.pendingVerticalScrollEvents;
    }

    public static final boolean access$getSendingFocusAffectingEvent$p(AndroidComposeViewAccessibilityDelegateCompat arg0) {
        return arg0.sendingFocusAffectingEvent;
    }

    public static final void access$notifySubtreeAccessibilityStateChangedIfNeeded(AndroidComposeViewAccessibilityDelegateCompat arg0, LayoutNode arg1) {
        arg0.notifySubtreeAccessibilityStateChangedIfNeeded(arg1);
    }

    public static final boolean access$performActionHelper(AndroidComposeViewAccessibilityDelegateCompat arg0, int arg1, int arg2, Bundle arg3) {
        return arg0.performActionHelper(arg1, arg2, arg3);
    }

    public static final void access$scheduleScrollEventIfNeeded(AndroidComposeViewAccessibilityDelegateCompat arg0, ScrollObservationScope arg1) {
        arg0.scheduleScrollEventIfNeeded(arg1);
    }

    public static final int access$semanticsNodeIdToAccessibilityVirtualNodeId(AndroidComposeViewAccessibilityDelegateCompat arg0, int arg1) {
        return arg0.semanticsNodeIdToAccessibilityVirtualNodeId(arg1);
    }

    public static final void access$setCurrentlyAccessibilityFocusedANI$p(AndroidComposeViewAccessibilityDelegateCompat arg0, AccessibilityNodeInfoCompat arg1) {
        arg0.currentlyAccessibilityFocusedANI = arg1;
    }

    public static final void access$setCurrentlyFocusedANI$p(AndroidComposeViewAccessibilityDelegateCompat arg0, AccessibilityNodeInfoCompat arg1) {
        arg0.currentlyFocusedANI = arg1;
    }

    private final void addExtraDataToAccessibilityNodeInfoHelper(int arg18, AccessibilityNodeInfoCompat arg19, String arg20, Bundle arg21) {
        androidx.compose.ui.geometry.Rect v3_3;
        Object v1_2;
        int v10;
        int v6_1;
        int v4_1;
        int v0_1;
        AndroidComposeViewAccessibilityDelegateCompat v0 = this;
        int v1 = arg18;
        AccessibilityNodeInfoCompat v2 = arg19;
        String v3 = arg20;
        Bundle v4 = arg21;
        Object v5 = v0.getCurrentSemanticsNodes().get(v1);
        if(v5 != null) {
            SemanticsNode v5_1 = ((SemanticsNodeWithAdjustedBounds)v5).getSemanticsNode();
            if(v5_1 == null) {
            }
            else {
                String v6 = v0.getIterableTextForAccessibility(v5_1);
                int v8 = -1;
                if(Intrinsics.areEqual(v3, v0.ExtraDataTestTraversalBeforeVal)) {
                    v0_1 = v0.idToBeforeMap.getOrDefault(v1, v8);
                    if(v0_1 != v8) {
                        v2.getExtras().putInt(v3, v0_1);
                        return;
                    }
                }
                else if(Intrinsics.areEqual(v3, v0.ExtraDataTestTraversalAfterVal)) {
                    v0_1 = v0.idToAfterMap.getOrDefault(v1, v8);
                    if(v0_1 != v8) {
                        v2.getExtras().putInt(v3, v0_1);
                        return;
                    }
                }
                else {
                    if((v5_1.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) && v4 != null && (Intrinsics.areEqual(v3, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY"))) {
                        v1 = v4.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", v8);
                        v4_1 = v4.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", v8);
                        if(v4_1 > 0 && v1 >= 0) {
                            v6_1 = v6 != null ? v6.length() : 0x7FFFFFFF;
                            if(v1 >= v6_1) {
                                goto label_79;
                            }

                            TextLayoutResult v6_2 = SemanticsUtils_androidKt.getTextLayoutResult(v5_1.getUnmergedConfig$ui());
                            if(v6_2 == null) {
                                return;
                            }

                            ArrayList v8_1 = new ArrayList();
                            int v9;
                            for(v9 = 0; v9 < v4_1; ++v9) {
                                v10 = v1 + v9;
                                if(v10 >= v6_2.getLayoutInput().getText().length()) {
                                    ((List)v8_1).add(null);
                                }
                                else {
                                    ((List)v8_1).add(v0.toScreenCoords(v5_1, v6_2.getBoundingBox(v10)));
                                }
                            }

                            v2.getExtras().putParcelableArray(v3, ((Collection)v8_1).toArray(new RectF[0]));
                            return;
                        }

                    label_79:
                        Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
                        return;
                    }

                    if((v5_1.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getTestTag())) && v4 != null && (Intrinsics.areEqual(v3, "androidx.compose.ui.semantics.testTag"))) {
                        Object v0_2 = SemanticsConfigurationKt.getOrNull(v5_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getTestTag());
                        if(v0_2 != null) {
                            v2.getExtras().putCharSequence(v3, ((CharSequence)v0_2));
                            return;
                        }
                        else {
                            return;
                        }
                    }

                    if(Intrinsics.areEqual(v3, "androidx.compose.ui.semantics.id")) {
                        v2.getExtras().putInt(v3, v5_1.getId());
                        return;
                    }

                    String v1_1 = "androidx.compose.ui.semantics.shapeType";
                    v6_1 = 2;
                    String v8_2 = "androidx.compose.ui.semantics.shapeRegion";
                    String v9_1 = "androidx.compose.ui.semantics.shapeCorners";
                    String v10_1 = "androidx.compose.ui.semantics.shapeRect";
                    if(Intrinsics.areEqual(v3, v1_1)) {
                        Object v3_1 = SemanticsConfigurationKt.getOrNull(v5_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getShape());
                        if(v3_1 == null) {
                            return;
                        }

                        androidx.compose.ui.geometry.Rect v4_2 = v0.getShapeBounds(v5_1, v0.getBoundsInScreen(v2), ((Shape)v3_1));
                        Outline v3_2 = v0.createOutline-12SF9DM(((Shape)v3_1), v4_2.getSize-NH-jbRc(), v5_1.getLayoutInfo().getLayoutDirection());
                        if((v3_2 instanceof Rectangle)) {
                            v2.getExtras().putInt(v1_1, 0);
                            v2.getExtras().putParcelable(v10_1, v0.toAndroidRect(v3_2, v4_2.getLeft(), v4_2.getTop()));
                            return;
                        }

                        if((v3_2 instanceof Rounded)) {
                            v2.getExtras().putInt(v1_1, 1);
                            v2.getExtras().putParcelable(v10_1, v0.toAndroidRect(v3_2, v4_2.getLeft(), v4_2.getTop()));
                            v2.getExtras().putFloatArray(v9_1, v0.toCornerArray(v3_2));
                            return;
                        }

                        if((v3_2 instanceof Generic)) {
                            v2.getExtras().putInt(v1_1, v6_1);
                            v2.getExtras().putParcelable(v8_2, v0.toRegion(v3_2, v4_2.getLeft(), v4_2.getTop()));
                            return;
                        }

                        throw new NoWhenBranchMatchedException();
                    }

                    if(Intrinsics.areEqual(v3, v10_1)) {
                        v1_2 = SemanticsConfigurationKt.getOrNull(v5_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getShape());
                        if(v1_2 == null) {
                            return;
                        }

                        v3_3 = v0.getShapeBounds(v5_1, v0.getBoundsInScreen(v2), ((Shape)v1_2));
                        Rect v0_3 = v0.toAndroidRect(v0.createOutline-12SF9DM(((Shape)v1_2), v3_3.getSize-NH-jbRc(), v5_1.getLayoutInfo().getLayoutDirection()), v3_3.getLeft(), v3_3.getTop());
                        if(v0_3 == null) {
                            return;
                        }

                        v2.getExtras().putParcelable(v10_1, ((Parcelable)v0_3));
                        return;
                    }

                    if(Intrinsics.areEqual(v3, v9_1)) {
                        v1_2 = SemanticsConfigurationKt.getOrNull(v5_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getShape());
                        if(v1_2 == null) {
                            return;
                        }

                        float[] v0_4 = v0.toCornerArray(v0.createOutline-12SF9DM(((Shape)v1_2), v0.getShapeBounds(v5_1, v0.getBoundsInScreen(v2), ((Shape)v1_2)).getSize-NH-jbRc(), v5_1.getLayoutInfo().getLayoutDirection()));
                        if(v0_4 == null) {
                            return;
                        }

                        v2.getExtras().putFloatArray(v9_1, v0_4);
                        return;
                    }

                    if(Intrinsics.areEqual(v3, v8_2)) {
                        v1_2 = SemanticsConfigurationKt.getOrNull(v5_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getShape());
                        if(v1_2 == null) {
                            return;
                        }

                        v3_3 = v0.getShapeBounds(v5_1, v0.getBoundsInScreen(v2), ((Shape)v1_2));
                        Region v0_5 = v0.toRegion(v0.createOutline-12SF9DM(((Shape)v1_2), v3_3.getSize-NH-jbRc(), v5_1.getLayoutInfo().getLayoutDirection()), v3_3.getLeft(), v3_3.getTop());
                        if(v0_5 == null) {
                            return;
                        }

                        v2.getExtras().putParcelable(v8_2, ((Parcelable)v0_5));
                        return;
                    }

                    ScatterSet v0_6 = v5_1.getUnmergedConfig$ui().getAccessibilityExtraKeys$ui();
                    if(v0_6 == null) {
                        return;
                    }

                    Object[] v1_3 = v0_6.elements;
                    long[] v0_7 = v0_6.metadata;
                    v4_1 = v0_7.length - v6_1;
                    if(v4_1 < 0) {
                        return;
                    }

                    for(v6_1 = 0; true; ++v6_1) {
                        long v8_3 = v0_7[v6_1];
                        if((~v8_3 << 7 & v8_3 & -9187201950435737472L) != -9187201950435737472L) {
                            int v11 = 8;
                            v10 = 8 - (~(v6_1 - v4_1) >>> 0x1F);
                            int v12;
                            for(v12 = 0; v12 < v10; ++v12) {
                                if((0xFF & v8_3) < 0x80) {
                                    Object v13 = v1_3[(v6_1 << 3) + v12];
                                    String v14 = ((SemanticsPropertyKey)v13).getAccessibilityExtraKey$ui();
                                    if(Intrinsics.areEqual(v14, v3)) {
                                        v13 = SemanticsConfigurationKt.getOrNull(v5_1.getUnmergedConfig$ui(), ((SemanticsPropertyKey)v13));
                                        if((v13 instanceof Serializable)) {
                                            v2.getExtras().putSerializable(v14, ((Serializable)v13));
                                        }
                                        else if((v13 instanceof Parcelable)) {
                                            v2.getExtras().putParcelable(v14, ((Parcelable)v13));
                                        }
                                        else {
                                            throw new IllegalStateException("Accessibility extra values must be either Serializable or Parcelable.");
                                        }
                                    }
                                }

                                v8_3 >>= v11;
                            }

                            if(v10 != v11) {
                                return;
                            }
                        }

                        if(v6_1 == v4_1) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds arg4) {
        IntRect v4 = arg4.getAdjustedBounds();
        return this.toBoundsInScreen(((float)v4.getLeft()), ((float)v4.getTop()), ((float)v4.getRight()), ((float)v4.getBottom()));
    }

    public final Object boundsUpdatesEventLoop$ui(Continuation arg11) {
        int v7;
        Object v6;
        Object v2_1;
        MutableIntSet v11_2;
        int v2;
        Continuation v0;
        if((arg11 instanceof AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)) {
            v0 = arg11;
            v2 = 0x80000000;
            if((((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).label & v2) != 0) {
                ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 v0_1 = new AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1(this, arg11);
        }

        Object v11 = ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).label;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v11);
            try {
                v11_2 = new MutableIntSet(0, 1, null);
                ChannelIterator v2_2 = this.boundsUpdateChannel.iterator();
                goto label_41;
            }
            catch(Throwable v11_1) {
                goto label_91;
            }

        label_25:
            v11 = v6;
            try {
            label_41:
                ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).L$0 = v11_2;
                ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).L$1 = v2_1;
                ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).label = 1;
                v6 = ((ChannelIterator)v2_1).hasNext(v0);
                if(v6 == v1) {
                    return v1;
                }
                else {
                    Object v9 = v6;
                    v6 = v11_2;
                    v11 = v9;
                }

                goto label_50;
            }
            catch(Throwable v11_1) {
                goto label_91;
            }

            return v1;
        }
        else if(v2 == 1) {
            v2_1 = ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).L$1;
            v6 = ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v11);
            }
            catch(Throwable v11_1) {
                goto label_91;
            }
        }
        else if(v2 == v4) {
            v2_1 = ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).L$1;
            v6 = ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v11);
                goto label_25;
            }
            catch(Throwable v11_1) {
                goto label_91;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_50:
            if(!((Boolean)v11).booleanValue()) {
                goto label_85;
            }

            ((ChannelIterator)v2_1).next();
            if(this.isEnabled$ui()) {
                int v11_3 = this.subtreeChangedLayoutNodes.size();
                v7 = 0;
                goto label_58;
            }

            goto label_72;
        }
        catch(Throwable v11_1) {
            goto label_91;
        }

    label_85:
        this.subtreeChangedLayoutNodes.clear();
        return Unit.INSTANCE;
        try {
        label_58:
            while(v7 < v11_3) {
                Object v8 = this.subtreeChangedLayoutNodes.valueAt(v7);
                this.sendSubtreeChangeAccessibilityEvents(((LayoutNode)v8), ((MutableIntSet)v6));
                this.sendTypeViewScrolledAccessibilityEvent(((LayoutNode)v8));
                ++v7;
            }

            ((MutableIntSet)v6).clear();
            if(!this.checkingForSemanticsChanges) {
                this.checkingForSemanticsChanges = true;
                this.handler.post(this.semanticsChangeChecker);
            }

        label_72:
            this.subtreeChangedLayoutNodes.clear();
            this.pendingHorizontalScrollEvents.clear();
            this.pendingVerticalScrollEvents.clear();
            long v7_1 = this.SendRecurringAccessibilityEventsIntervalMillis;
            ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).L$0 = v6;
            ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).L$1 = v2_1;
            ((AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1)v0).label = v4;
            if(DelayKt.delay(v7_1, v0) != v1) {
                goto label_25;
            }

            return v1;
        }
        catch(Throwable v11_1) {
        label_91:
            this.subtreeChangedLayoutNodes.clear();
            throw v11_1;
        }
    }

    public final boolean canScroll-0AR0LA0$ui(boolean arg7, int arg8, long arg9) {
        if(!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return 0;
        }

        return this.canScroll-moWRBKg(this.getCurrentSemanticsNodes(), arg7, arg8, arg9);
    }

    private final boolean canScroll-moWRBKg(IntObjectMap arg21, boolean arg22, int arg23, long arg24) {
        SemanticsPropertyKey v1_1;
        IntObjectMap v0 = arg21;
        boolean v1 = arg22;
        int v2 = arg23;
        long v3 = arg24;
        if(!Offset.equals-impl0(v3, Offset.Companion.getUnspecified-F1C5BW0()) && ((0x7FFFFFFF7FFFFFFFL & v3) + 0x7FFFFF007FFFFFL & -9223372034707292160L) == 0) {
            if(v1) {
                v1_1 = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
            }
            else if(!v1) {
                v1_1 = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
            }
            else {
                goto label_107;
            }

            Object[] v7 = v0.values;
            long[] v0_1 = v0.metadata;
            int v8 = v0_1.length - 2;
            if(v8 >= 0) {
                int v9 = 0;
                boolean v10 = false;
                while(true) {
                    long v11 = v0_1[v9];
                    if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                        int v14 = 8;
                        int v13 = 8 - (~(v9 - v8) >>> 0x1F);
                        int v15;
                        for(v15 = 0; v15 < v13; ++v15) {
                            if((v11 & 0xFF) < 0x80) {
                                Object v16 = v7[(v9 << 3) + v15];
                                if(!IntRectKt.toRect(((SemanticsNodeWithAdjustedBounds)v16).getAdjustedBounds()).contains-k-4lQ0M(v3)) {
                                }
                                else {
                                    Object v5 = SemanticsConfigurationKt.getOrNull(((SemanticsNodeWithAdjustedBounds)v16).getSemanticsNode().getUnmergedConfig$ui(), v1_1);
                                    if(v5 == null) {
                                    }
                                    else {
                                        int v6 = ((ScrollAxisRange)v5).getReverseScrolling() ? -v2 : v2;
                                        if(v2 == 0 && (((ScrollAxisRange)v5).getReverseScrolling())) {
                                            v6 = -1;
                                        }

                                        if(v6 >= 0) {
                                            if(((ScrollAxisRange)v5).getValue().invoke().floatValue() < ((ScrollAxisRange)v5).getMaxValue().invoke().floatValue()) {
                                                goto label_88;
                                            }

                                            goto label_91;
                                        }
                                        else if(((ScrollAxisRange)v5).getValue().invoke().floatValue() > 0f) {
                                        }
                                        else {
                                            goto label_91;
                                        }

                                    label_88:
                                        v10 = true;
                                    }
                                }
                            }

                        label_91:
                            v11 >>= v14;
                        }

                        if(v13 == v14) {
                            goto label_100;
                        }

                        return v10;
                    }

                label_100:
                    if(v9 == v8) {
                        return v10;
                    }

                    ++v9;
                }

                return v10;
            }

            return 0;
        label_107:
            throw new NoWhenBranchMatchedException();
        }

        return 0;
    }

    private final void checkForSemanticsChanges() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if(this.isEnabled$ui()) {
                this.sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
        }
        catch(Throwable v2) {
            Trace.endSection();
            throw v2;
        }

        Trace.endSection();
        Trace.beginSection("sendSemanticsPropertyChangeEvents");
        try {
            this.sendSemanticsPropertyChangeEvents(this.getCurrentSemanticsNodes());
        }
        catch(Throwable v2) {
            Trace.endSection();
            throw v2;
        }

        Trace.endSection();
        Trace.beginSection("updateSemanticsNodesCopyAndPanes");
        try {
            this.updateSemanticsNodesCopyAndPanes();
        }
        catch(Throwable v2) {
            Trace.endSection();
            throw v2;
        }

        Trace.endSection();
    }

    private final boolean clearAccessibilityFocus(int arg9) {
        if(this.isAccessibilityFocused(arg9)) {
            this.accessibilityFocusedVirtualViewId = 0x80000000;
            this.currentlyAccessibilityFocusedANI = null;
            this.view.invalidate();
            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, arg9, 0x10000, null, null, 12, null);
            return 1;
        }

        return 0;
    }

    private final AccessibilityEvent createEvent(int arg3, int arg4) {
        AccessibilityEvent v4 = AccessibilityEvent.obtain(arg4);
        v4.setEnabled(true);
        v4.setClassName("android.view.View");
        v4.setPackageName(this.view.getContext().getPackageName());
        v4.setSource(this.view, arg3);
        if(this.isEnabled$ui()) {
            Object v2 = this.getCurrentSemanticsNodes().get(arg3);
            if(v2 != null) {
                v4.setPassword(((SemanticsNodeWithAdjustedBounds)v2).getSemanticsNode().getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPassword()));
                AccessibilityEventCompat.setAccessibilityDataSensitive(v4, Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(((SemanticsNodeWithAdjustedBounds)v2).getSemanticsNode().getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getIsSensitiveData()), Boolean.valueOf(true)));
            }
        }

        return v4;
    }

    private final AccessibilityNodeInfoCompat createNodeInfo(int arg7) {
        Integer v1_2;
        State v0_3;
        ViewTreeOwners v0 = this.view.getViewTreeOwners();
        AccessibilityNodeInfoCompat v1 = null;
        if(v0 != null) {
            LifecycleOwner v0_1 = v0.getLifecycleOwner();
            if(v0_1 != null) {
                Lifecycle v0_2 = v0_1.getLifecycle();
                if(v0_2 != null) {
                    v0_3 = v0_2.getCurrentState();
                }
                else {
                    goto label_10;
                }
            }
            else {
                goto label_10;
            }
        }
        else {
        label_10:
            v0_3 = ((State)v1);
        }

        if(v0_3 == State.DESTROYED) {
            return this.emptyNodeInfoOrNull();
        }

        Object v0_4 = this.getCurrentSemanticsNodes().get(arg7);
        if(v0_4 == null) {
            return this.emptyNodeInfoOrNull();
        }

        SemanticsNode v2 = ((SemanticsNodeWithAdjustedBounds)v0_4).getSemanticsNode();
        boolean v3 = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v2.getConfig(), SemanticsProperties.INSTANCE.getIsSensitiveData()), Boolean.valueOf(true));
        if((v3) && !this.isRequestFromAccessibilityTool()) {
            return v1;
        }

        AccessibilityNodeInfoCompat v4 = AccessibilityNodeInfoCompat.obtain();
        v4.setAccessibilityDataSensitive(v3);
        int v3_1 = -1;
        if(arg7 == v3_1) {
            ViewParent v3_2 = this.view.getParentForAccessibility();
            if((v3_2 instanceof View)) {
                ViewParent v1_1 = v3_2;
            }

            v4.setParent(((View)v1));
        }
        else {
            SemanticsNode v5 = v2.getParent();
            if(v5 != null) {
                v1_2 = Integer.valueOf(v5.getId());
            }

            if(v1_2 == null) {
                goto label_64;
            }

            int v1_3 = ((Number)v1_2).intValue();
            if(v1_3 == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            }
            else {
                v3_1 = v1_3;
            }

            v4.setParent(this.view, v3_1);
        }

        v4.setSource(this.view, arg7);
        v4.setBoundsInScreen(this.boundsInScreen(((SemanticsNodeWithAdjustedBounds)v0_4)));
        this.populateAccessibilityNodeInfoProperties(arg7, v4, v2);
        return v4;
    label_64:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + arg7 + " has null parent");
        throw new KotlinNothingValueException();
    }

    private final Outline createOutline-12SF9DM(Shape arg1, long arg2, LayoutDirection arg4) {
        return arg1.createOutline-Pq9zytI(arg2, arg4, this.view.getDensity());
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int arg2, Integer arg3, Integer arg4, Integer arg5, CharSequence arg6) {
        AccessibilityEvent v1 = this.createEvent(arg2, 0x2000);
        if(arg3 != null) {
            v1.setFromIndex(((Number)arg3).intValue());
        }

        if(arg4 != null) {
            v1.setToIndex(((Number)arg4).intValue());
        }

        if(arg5 != null) {
            v1.setItemCount(((Number)arg5).intValue());
        }

        if(arg6 != null) {
            v1.getText().add(arg6);
        }

        return v1;
    }

    public final boolean dispatchHoverEvent$ui(MotionEvent arg6) {
        if(!this.isTouchExplorationEnabled()) {
            return 0;
        }

        int v0 = arg6.getAction();
        int v4 = 0x80000000;
        if(v0 != 7 && v0 != 9) {
            if(v0 != 10) {
                return 0;
            }
            else if(this.hoveredVirtualViewId != v4) {
                this.updateHoveredVirtualView(v4);
                return 1;
            }
            else {
                return this.view.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(arg6);
            }
        }

        v0 = this.hitTestSemanticsAt$ui(arg6.getX(), arg6.getY());
        boolean v6 = this.view.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(arg6);
        this.updateHoveredVirtualView(v0);
        if(v0 == v4) {
            return v6;
        }

        return 1;
    }

    private final AccessibilityNodeInfoCompat emptyNodeInfoOrNull() {
        if(!this.accessibilityManager.isEnabled()) {
            return AccessibilityNodeInfoCompat.obtain();
        }

        return null;
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui() {
        return this.accessibilityForceEnabledForTesting;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View arg1) {
        return this.nodeProvider;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode arg3) {
        if(!arg3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getContentDescription()) && (arg3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getTextSelectionRange()))) {
            return TextRange.getEnd-impl(arg3.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getTextSelectionRange()).unbox-impl());
        }

        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode arg3) {
        if(!arg3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getContentDescription()) && (arg3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getTextSelectionRange()))) {
            return TextRange.getStart-impl(arg3.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getTextSelectionRange()).unbox-impl());
        }

        return this.accessibilityCursorPosition;
    }

    private final Rect getBoundsInScreen(AccessibilityNodeInfoCompat arg1) {
        Rect v0 = new Rect();
        arg1.getBoundsInScreen(v0);
        return v0;
    }

    private final IntObjectMap getCurrentSemanticsNodes() {
        if(this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsOwnerKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner(), -1, AndroidComposeViewAccessibilityDelegateCompat$currentSemanticsNodes$1.INSTANCE);
            if(this.isEnabled$ui()) {
                AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$setTraversalValues(this.currentSemanticsNodes, this.idToBeforeMap, this.idToAfterMap, this.view.getContext().getResources());
            }
        }

        return this.currentSemanticsNodes;
    }

    private final List getEnabledServices() {
        List v0 = this._enabledServices;
        if(v0 == null) {
            v0 = this.accessibilityManager.getEnabledAccessibilityServiceList(-1);
            this._enabledServices = v0;
        }

        return v0;
    }

    public final String getExtraDataTestTraversalAfterVal$ui() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    public final String getExtraDataTestTraversalBeforeVal$ui() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    public final int getHoveredVirtualViewId$ui() {
        return this.hoveredVirtualViewId;
    }

    public static void getHoveredVirtualViewId$ui$annotations() {
    }

    public final MutableIntIntMap getIdToAfterMap$ui() {
        return this.idToAfterMap;
    }

    public final MutableIntIntMap getIdToBeforeMap$ui() {
        return this.idToBeforeMap;
    }

    private final String getIterableTextForAccessibility(SemanticsNode arg10) {
        String v0 = null;
        if(arg10 == null) {
            return v0;
        }

        if(arg10.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default(arg10.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", null, null, 0, null, null, 62, null);
        }

        if(arg10.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            AnnotatedString v9 = this.getTextForTextField(arg10.getUnmergedConfig$ui());
            if(v9 != null) {
                return v9.getText();
            }

            return v0;
        }

        Object v9_1 = SemanticsConfigurationKt.getOrNull(arg10.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getText());
        if(v9_1 != null) {
            v9_1 = CollectionsKt.firstOrNull(((List)v9_1));
            if(v9_1 != null) {
                return ((AnnotatedString)v9_1).getText();
            }
        }

        return v0;
    }

    private final TextSegmentIterator getIteratorForGranularity(SemanticsNode arg5, int arg6) {
        PageTextSegmentIterator v4_3;
        TextSegmentIterator v0 = null;
        if(arg5 == null) {
            return v0;
        }

        String v1 = this.getIterableTextForAccessibility(arg5);
        String v2 = v1;
        if(v2 != null) {
            if(((CharSequence)v2).length() == 0) {
            }
            else {
                if(arg6 == 1) {
                    CharacterTextSegmentIterator v4_5 = CharacterTextSegmentIterator.Companion.getInstance(this.view.getContext().getResources().getConfiguration().locale);
                    v4_5.initialize(v1);
                }
                else if(arg6 != 2) {
                    int v4 = 4;
                    if(arg6 != v4) {
                        if(arg6 == 8) {
                            ParagraphTextSegmentIterator v4_1 = ParagraphTextSegmentIterator.Companion.getInstance();
                            ((AbstractTextSegmentIterator)v4_1).initialize(v1);
                            goto label_64;
                        }
                        else if(arg6 != 16) {
                            return v0;
                        }
                    }

                    if(!arg5.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                        return v0;
                    }

                    TextLayoutResult v2_1 = SemanticsUtils_androidKt.getTextLayoutResult(arg5.getUnmergedConfig$ui());
                    if(v2_1 == null) {
                        return v0;
                    }

                    if(arg6 == v4) {
                        LineTextSegmentIterator v4_2 = LineTextSegmentIterator.Companion.getInstance();
                        v4_2.initialize(v1, v2_1);
                        goto label_64;
                    }

                    v4_3 = PageTextSegmentIterator.Companion.getInstance();
                    v4_3.initialize(v1, v2_1, arg5);
                }
                else {
                    WordTextSegmentIterator v4_4 = WordTextSegmentIterator.Companion.getInstance(this.view.getContext().getResources().getConfiguration().locale);
                    v4_4.initialize(v1);
                }

            label_64:
                return ((TextSegmentIterator)v4_3);
            }
        }

        return v0;
    }

    public final Function1 getOnSendAccessibilityEvent$ui() {
        return this.onSendAccessibilityEvent;
    }

    public static void getOnSendAccessibilityEvent$ui$annotations() {
    }

    public final Boolean getRequestFromAccessibilityToolForTesting$ui() {
        return this.requestFromAccessibilityToolForTesting;
    }

    public final long getSendRecurringAccessibilityEventsIntervalMillis$ui() {
        return this.SendRecurringAccessibilityEventsIntervalMillis;
    }

    private final androidx.compose.ui.geometry.Rect getShapeBounds(SemanticsNode arg11, Rect arg12, Shape arg13) {
        AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1 v0 = new AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1(arg13);
        LayoutNode v11 = arg11.getLayoutNode$ui();
        NodeChain v13 = v11.getNodes$ui();
        int v1 = NodeKind.constructor-impl(8);
        Node v4 = null;
        if((v13.getAggregateChildKindSet() & v1) != 0) {
            Node v13_1;
            for(v13_1 = v13.getHead$ui(); v13_1 != null; v13_1 = v13_1.getChild$ui()) {
                if((v13_1.getKindSet$ui() & v1) != 0) {
                    Node v2 = v13_1;
                    MutableVector v6 = ((MutableVector)v4);
                    while(true) {
                    label_19:
                        if(v2 != null) {
                            if((v2 instanceof SemanticsModifierNode)) {
                                v2.applySemantics(v0);
                                if(v0.getHasMatchedShape()) {
                                    v4 = v2;
                                    goto label_67;
                                }
                            }
                            else if((v2.getKindSet$ui() & v1) != 0 && ((v2 instanceof DelegatingNode))) {
                                Node v7 = v2.getDelegate$ui();
                                int v8 = 0;
                                while(v7 != null) {
                                    if((v7.getKindSet$ui() & v1) != 0) {
                                        ++v8;
                                        if(v8 == 1) {
                                            v2 = v7;
                                        }
                                        else {
                                            if(v6 == null) {
                                                v6 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v2 != null) {
                                                if(v6 != null) {
                                                    v6.add(v2);
                                                }

                                                v2 = v4;
                                            }

                                            if(v6 == null) {
                                                goto label_56;
                                            }

                                            v6.add(v7);
                                        }
                                    }

                                label_56:
                                    v7 = v7.getChild$ui();
                                }

                                if(v8 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_62;
                    }

                    v2 = DelegatableNodeKt.pop(v6);
                    goto label_19;
                }

            label_62:
                if((v13_1.getAggregateChildKindSet$ui() & v1) == 0) {
                    break;
                }
            }
        }

    label_67:
        if(v4 != null) {
            v13_1 = ((SemanticsModifierNode)v4).getNode();
            if(v13_1 != null && (v13_1.isAttached())) {
                androidx.compose.ui.geometry.Rect v11_1 = LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.requireLayoutCoordinates(((DelegatableNode)v4)));
                return this.toBoundsRelativeToNodeBounds(this.toBoundsInScreen(v11_1.getLeft(), v11_1.getTop(), v11_1.getRight(), v11_1.getBottom()), arg12);
            }
        }

        return LayoutCoordinatesKt.boundsInWindow(v11.getOuterCoordinator$ui(), false);
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration arg1) {
        return SemanticsConfigurationKt.getOrNull(arg1, SemanticsProperties.INSTANCE.getEditableText());
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public final int hitTestSemanticsAt$ui(float arg13, float arg14) {
        int v14;
        Owner.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult v7 = new HitTestResult();
        LayoutNode.hitTestSemantics-6fMxITs$ui$default(this.view.getRoot(), Offset.constructor-impl((((long)Float.floatToRawIntBits(arg14))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg13))) << 0x20), v7, 0, false, 12, null);
        int v13 = CollectionsKt.getLastIndex(v7);
        while(true) {
            v14 = 0x80000000;
            if(-1 < v13) {
                LayoutNode v0 = DelegatableNodeKt.requireLayoutNode(v7.get(v13));
                if(this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(v0) != null) {
                    return v14;
                }
                else {
                    if(!v0.getNodes$ui().has-H91voCI$ui(NodeKind.constructor-impl(8))) {
                    }
                    else {
                        v14 = this.semanticsNodeIdToAccessibilityVirtualNodeId(v0.getSemanticsId());
                        SemanticsNode v0_1 = SemanticsNodeKt.SemanticsNode(v0, false);
                        if(!SemanticsOwnerKt.isImportantForAccessibility(v0_1)) {
                        }
                        else {
                            if(SemanticsNode_androidKt.isAccessibilityIgnoredLink(v0_1)) {
                                goto label_51;
                            }

                            return v14;
                        }
                    }

                label_51:
                    --v13;
                    continue;
                }
            }

            return v14;
        }

        return v14;
    }

    private final boolean isAccessibilityFocused(int arg1) {
        if(this.accessibilityFocusedVirtualViewId == arg1) {
            return 1;
        }

        return 0;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode arg2) {
        if(!arg2.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getContentDescription()) && (arg2.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getEditableText()))) {
            return 1;
        }

        return 0;
    }

    public final boolean isEnabled$ui() {
        if(!this.accessibilityForceEnabledForTesting && (!this.accessibilityManager.isEnabled() || (this.getEnabledServices().isEmpty()))) {
            return 0;
        }

        return 1;
    }

    private final boolean isRequestFromAccessibilityTool() {
        Boolean v0 = this.requestFromAccessibilityToolForTesting;
        if(Intrinsics.areEqual(v0, Boolean.valueOf(true))) {
            return 1;
        }

        if(Intrinsics.areEqual(v0, Boolean.valueOf(false))) {
            return 0;
        }

        return AccessibilityManagerCompat.isRequestFromAccessibilityTool(this.accessibilityManager);
    }

    private final boolean isTouchExplorationEnabled() {
        if(!this.accessibilityForceEnabledForTesting && (!this.accessibilityManager.isEnabled() || !this.accessibilityManager.isTouchExplorationEnabled())) {
            return 0;
        }

        return 1;
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode arg2) {
        if(this.subtreeChangedLayoutNodes.add(arg2)) {
            this.boundsUpdateChannel.trySend-JP2dKIU(Unit.INSTANCE);
        }
    }

    public void onAccessibilityStateChanged(boolean arg1) {
        this.resetEnabledAccessibilityServiceList();
    }

    public final void onLayoutChange$ui(LayoutNode arg2) {
        this.currentSemanticsNodesInvalidated = true;
        if(!this.isEnabled$ui()) {
            return;
        }

        this.notifySubtreeAccessibilityStateChangedIfNeeded(arg2);
    }

    public final void onSemanticsChange$ui() {
        this.currentSemanticsNodesInvalidated = true;
        if((this.isEnabled$ui()) && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    public void onTouchExplorationStateChanged(boolean arg1) {
        this.resetEnabledAccessibilityServiceList();
    }

    public void onViewAttachedToWindow(View arg2) {
        if(this.accessibilityManager.isEnabled()) {
            this.resetEnabledAccessibilityServiceList();
        }

        this.accessibilityManager.addAccessibilityStateChangeListener(this);
        this.accessibilityManager.addTouchExplorationStateChangeListener(((AccessibilityManager$TouchExplorationStateChangeListener)this));
    }

    public void onViewDetachedFromWindow(View arg2) {
        this.handler.removeCallbacks(this.semanticsChangeChecker);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this);
        this.accessibilityManager.removeTouchExplorationStateChangeListener(((AccessibilityManager$TouchExplorationStateChangeListener)this));
    }

    private final boolean performActionHelper(int arg13, int arg14, Bundle arg15) {
        Object v14_1;
        SemanticsConfiguration v14;
        SemanticsNode v13_2;
        Function v13_1;
        String v12_2;
        Function v12_1;
        int v15;
        Object v13;
        Object v12;
        AndroidComposeViewAccessibilityDelegateCompat v5_2;
        Object v4_2;
        float v12_5;
        int v12_3;
        List v4;
        SemanticsNode v0_1;
        Object v0 = this.getCurrentSemanticsNodes().get(arg13);
        boolean v1 = false;
        if(v0 != null) {
            v0_1 = ((SemanticsNodeWithAdjustedBounds)v0).getSemanticsNode();
            if(v0_1 == null) {
            }
            else {
                if((Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getIsSensitiveData()), Boolean.valueOf(true))) && !this.isRequestFromAccessibilityTool()) {
                    return 0;
                }

                if(arg14 != 0x40) {
                    if(arg14 != 0x80) {
                        int v2 = 0x100;
                        if(arg14 != v2 && arg14 != 0x200) {
                            if(arg14 == 0x4000) {
                                goto label_632;
                            }
                            else if(arg14 == 0x20000) {
                                goto label_610;
                            }
                            else if(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(v0_1)) {
                                return 0;
                            }
                            else if(arg14 != 1) {
                                v2 = 2;
                                if(arg14 != v2) {
                                    v4 = null;
                                    switch(arg14) {
                                        case 16: {
                                            goto label_557;
                                        }
                                        case 32: {
                                            goto label_546;
                                        }
                                        case 4096: 
                                        case 8192: {
                                            goto label_321;
                                        }
                                        case 32768: {
                                            goto label_310;
                                        }
                                        case 65536: {
                                            goto label_299;
                                        }
                                        case 262144: {
                                            goto label_288;
                                        }
                                        case 524288: {
                                            goto label_277;
                                        }
                                        case 1048576: {
                                            goto label_266;
                                        }
                                        case 2097152: {
                                            goto label_246;
                                        }
                                        case 16908342: {
                                            goto label_140;
                                        }
                                        case 16908349: {
                                            goto label_122;
                                        }
                                        case 16908372: {
                                            goto label_111;
                                        }
                                    }

                                    switch(arg14) {
                                        case 16908344: 
                                        case 16908345: 
                                        case 16908346: 
                                        case 16908347: {
                                        label_321:
                                            v12_3 = arg14 == 0x1000 ? 1 : 0;
                                            arg13 = arg14 == 0x2000 ? 1 : 0;
                                            v15 = arg14 == 0x1020039 ? 1 : 0;
                                            v2 = arg14 == 0x102003B ? 1 : 0;
                                            int v4_1 = arg14 == 0x1020038 ? 1 : 0;
                                            arg14 = arg14 == 0x102003A ? 1 : 0;
                                            int v5 = v15 != 0 || v2 != 0 || v12_3 != 0 || arg13 != 0 ? 1 : 0;
                                            arg14 = v4_1 != 0 || arg14 != 0 || v12_3 != 0 || arg13 != 0 ? 1 : 0;
                                            if(v12_3 != 0 || arg13 != 0) {
                                                v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
                                                Object v6 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetProgress());
                                                if(v12 != null && v6 != null) {
                                                    float v14_2 = RangesKt.coerceAtLeast(((ProgressBarRangeInfo)v12).getRange().getEndInclusive().floatValue(), ((ProgressBarRangeInfo)v12).getRange().getStart().floatValue());
                                                    float v15_1 = RangesKt.coerceAtMost(((ProgressBarRangeInfo)v12).getRange().getStart().floatValue(), ((ProgressBarRangeInfo)v12).getRange().getEndInclusive().floatValue());
                                                    if(((ProgressBarRangeInfo)v12).getSteps() > 0) {
                                                        v14_2 -= v15_1;
                                                        v15_1 = ((float)(((ProgressBarRangeInfo)v12).getSteps() + 1));
                                                    }
                                                    else {
                                                        v14_2 -= v15_1;
                                                        v15_1 = 20f;
                                                    }

                                                    v14_2 /= v15_1;
                                                    if(arg13 != 0) {
                                                        v14_2 = -v14_2;
                                                    }

                                                    v13_1 = ((AccessibilityAction)v6).getAction();
                                                    if(v13_1 != null) {
                                                        return ((Function1)v13_1).invoke(Float.valueOf(((ProgressBarRangeInfo)v12).getCurrent() + v14_2)).booleanValue();
                                                    }

                                                    return 0;
                                                }
                                            }

                                            long v6_1 = LayoutCoordinatesKt.boundsInParent(v0_1.getLayoutInfo().getCoordinates()).getSize-NH-jbRc();
                                            Float v12_4 = SemanticsUtils_androidKt.getScrollViewportLength(v0_1.getUnmergedConfig$ui());
                                            Object v3 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getScrollBy());
                                            if(v3 == null) {
                                                return 0;
                                            }

                                            Object v8 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                                            if(v8 != null && v5 != 0) {
                                                float v5_1 = v12_4 != null ? v12_4.floatValue() : Float.intBitsToFloat(((int)(v6_1 >> 0x20)));
                                                if(v15 != 0 || arg13 != 0) {
                                                    v5_1 = -v5_1;
                                                }

                                                if(((ScrollAxisRange)v8).getReverseScrolling()) {
                                                    v5_1 = -v5_1;
                                                }

                                                if((AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isRtl(v0_1)) && (v15 != 0 || v2 != 0)) {
                                                    v5_1 = -v5_1;
                                                }

                                                if(!AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(((ScrollAxisRange)v8), v5_1)) {
                                                    goto label_489;
                                                }

                                                if(!v0_1.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getPageLeft())) {
                                                    if(v0_1.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getPageRight())) {
                                                    }
                                                    else {
                                                        v12_1 = ((AccessibilityAction)v3).getAction();
                                                        if(v12_1 != null) {
                                                            return ((Function2)v12_1).invoke(Float.valueOf(v5_1), Float.valueOf(0f)).booleanValue();
                                                        }
                                                        else {
                                                            return 0;
                                                        }
                                                    }
                                                }

                                                v12 = v5_1 > 0f ? SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageRight()) : SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageLeft());
                                                if(v12 != null) {
                                                    v12_1 = ((AccessibilityAction)v12).getAction();
                                                    if(v12_1 != null) {
                                                        return ((Function0)v12_1).invoke().booleanValue();
                                                    }
                                                }

                                                return 0;
                                            }

                                        label_489:
                                            Object v15_2 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                                            if(v15_2 != null && arg14 != 0) {
                                                v12_5 = v12_4 != null ? v12_4.floatValue() : Float.intBitsToFloat(((int)(v6_1 & 0xFFFFFFFFL)));
                                                if(v4_1 != 0 || arg13 != 0) {
                                                    v12_5 = -v12_5;
                                                }

                                                if(((ScrollAxisRange)v15_2).getReverseScrolling()) {
                                                    v12_5 = -v12_5;
                                                }

                                                if(!AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$canScroll(((ScrollAxisRange)v15_2), v12_5)) {
                                                    return 0;
                                                }

                                                if(!v0_1.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getPageUp())) {
                                                    if(v0_1.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getPageDown())) {
                                                    }
                                                    else {
                                                        v13_1 = ((AccessibilityAction)v3).getAction();
                                                        if(v13_1 != null) {
                                                            return ((Function2)v13_1).invoke(Float.valueOf(0f), Float.valueOf(v12_5)).booleanValue();
                                                        }
                                                        else {
                                                            return 0;
                                                        }
                                                    }
                                                }

                                                v12 = v12_5 > 0f ? SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageDown()) : SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageUp());
                                                if(v12 == null) {
                                                    return 0;
                                                }

                                                v12_1 = ((AccessibilityAction)v12).getAction();
                                                if(v12_1 == null) {
                                                    return 0;
                                                }

                                                return ((Function0)v12_1).invoke().booleanValue();
                                            }

                                            return 0;
                                        label_546:
                                            v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnLongClick());
                                            if(v12 != null) {
                                                v12_1 = ((AccessibilityAction)v12).getAction();
                                                if(v12_1 != null) {
                                                    return ((Function0)v12_1).invoke().booleanValue();
                                                }
                                            }

                                            return 0;
                                        label_557:
                                            v14_1 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnClick());
                                            if(v14_1 != null) {
                                                Function v14_3 = ((AccessibilityAction)v14_1).getAction();
                                                if(v14_3 != null) {
                                                    v4_2 = ((Function0)v14_3).invoke();
                                                }
                                            }

                                            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, arg13, 1, null, null, 12, null);
                                            if(v4_2 != null) {
                                                return ((Boolean)v4_2).booleanValue();
                                            }

                                            return 0;
                                        label_578:
                                            v5_2 = this;
                                            if(Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getFocused()), Boolean.valueOf(true))) {
                                                v5_2.view.getFocusOwner().clearFocus-I7lrPNg(false, true, true, FocusDirection.Companion.getExit-dhqQ-8s());
                                                return 1;
                                            }

                                            return 0;
                                        label_593:
                                            v5_2 = this;
                                            if(v5_2.view.isInTouchMode()) {
                                                v5_2.view.requestFocusFromTouch();
                                            }

                                            v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getRequestFocus());
                                            if(v12 != null) {
                                                v12_1 = ((AccessibilityAction)v12).getAction();
                                                if(v12_1 != null) {
                                                    return ((Function0)v12_1).invoke().booleanValue();
                                                }
                                            }

                                            return 0;
                                        label_610:
                                            v5_2 = this;
                                            v12_3 = -1;
                                            arg13 = arg15 != null ? arg15.getInt("ACTION_ARGUMENT_SELECTION_START_INT", v12_3) : v12_3;
                                            if(arg15 != null) {
                                                v12_3 = arg15.getInt("ACTION_ARGUMENT_SELECTION_END_INT", v12_3);
                                            }

                                            boolean v12_6 = v5_2.setAccessibilitySelection(v0_1, arg13, v12_3, false);
                                            if(v12_6) {
                                                AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v5_2, v5_2.semanticsNodeIdToAccessibilityVirtualNodeId(v0_1.getId()), 0, null, null, 12, null);
                                            }

                                            return v12_6;
                                        label_632:
                                            v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCopyText());
                                            if(v12 != null) {
                                                v12_1 = ((AccessibilityAction)v12).getAction();
                                                if(v12_1 != null) {
                                                    return ((Function0)v12_1).invoke().booleanValue();
                                                }
                                            }

                                            return 0;
                                        }
                                        default: {
                                            switch(arg14) {
                                                case 16908358: {
                                                    goto label_100;
                                                }
                                                case 16908359: {
                                                    goto label_89;
                                                }
                                                case 16908360: {
                                                    goto label_78;
                                                }
                                                case 16908361: {
                                                    goto label_67;
                                                }
                                            }

                                            v12 = this.actionIdToLabel.get(arg13);
                                            if(v12 != null) {
                                                v12 = ((SparseArrayCompat)v12).get(arg14);
                                                if(v12 == null) {
                                                }
                                                else {
                                                    v13 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCustomActions());
                                                    if(v13 == null) {
                                                        return 0;
                                                    }
                                                    else {
                                                        arg14 = v13.size();
                                                        v15 = 0;
                                                        goto label_55;
                                                    label_67:
                                                        v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageRight());
                                                        if(v12 != null) {
                                                            v12_1 = ((AccessibilityAction)v12).getAction();
                                                            if(v12_1 != null) {
                                                                return ((Function0)v12_1).invoke().booleanValue();
                                                            }
                                                        }

                                                        return 0;
                                                    label_78:
                                                        v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageLeft());
                                                        if(v12 != null) {
                                                            v12_1 = ((AccessibilityAction)v12).getAction();
                                                            if(v12_1 != null) {
                                                                return ((Function0)v12_1).invoke().booleanValue();
                                                            }
                                                        }

                                                        return 0;
                                                    label_89:
                                                        v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageDown());
                                                        if(v12 != null) {
                                                            v12_1 = ((AccessibilityAction)v12).getAction();
                                                            if(v12_1 != null) {
                                                                return ((Function0)v12_1).invoke().booleanValue();
                                                            }
                                                        }

                                                        return 0;
                                                    label_100:
                                                        v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPageUp());
                                                        if(v12 != null) {
                                                            v12_1 = ((AccessibilityAction)v12).getAction();
                                                            if(v12_1 != null) {
                                                                return ((Function0)v12_1).invoke().booleanValue();
                                                            }
                                                        }

                                                        return 0;
                                                    label_111:
                                                        v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnImeAction());
                                                        if(v12 != null) {
                                                            v12_1 = ((AccessibilityAction)v12).getAction();
                                                            if(v12_1 != null) {
                                                                return ((Function0)v12_1).invoke().booleanValue();
                                                            }
                                                        }

                                                        return 0;
                                                    label_122:
                                                        if(arg15 != null) {
                                                            v12_2 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
                                                            if(!arg15.containsKey(v12_2)) {
                                                            }
                                                            else {
                                                                v13 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetProgress());
                                                                if(v13 != null) {
                                                                    v13_1 = ((AccessibilityAction)v13).getAction();
                                                                    if(v13_1 != null) {
                                                                        return ((Function1)v13_1).invoke(Float.valueOf(arg15.getFloat(v12_2))).booleanValue();
                                                                    }
                                                                }
                                                            }
                                                        }

                                                        return 0;
                                                    label_140:
                                                        v13_2 = v0_1.getParent();
                                                        if(v13_2 != null) {
                                                            v14 = v13_2.getUnmergedConfig$ui();
                                                            if(v14 != null) {
                                                                v14_1 = SemanticsConfigurationKt.getOrNull(v14, SemanticsActions.INSTANCE.getScrollBy());
                                                                goto label_149;
                                                            label_246:
                                                                v12_2 = arg15 != null ? arg15.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE") : ((String)v4);
                                                                v13 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetText());
                                                                if(v13 != null) {
                                                                    v13_1 = ((AccessibilityAction)v13).getAction();
                                                                    if(v13_1 != null) {
                                                                        if(v12_2 == null) {
                                                                            v12_2 = "";
                                                                        }

                                                                        return ((Function1)v13_1).invoke(new AnnotatedString(v12_2, v4, v2, ((DefaultConstructorMarker)v4))).booleanValue();
                                                                    }
                                                                }

                                                                return 0;
                                                            label_266:
                                                                v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getDismiss());
                                                                if(v12 != null) {
                                                                    v12_1 = ((AccessibilityAction)v12).getAction();
                                                                    if(v12_1 != null) {
                                                                        return ((Function0)v12_1).invoke().booleanValue();
                                                                    }
                                                                }

                                                                return 0;
                                                            label_277:
                                                                v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCollapse());
                                                                if(v12 != null) {
                                                                    v12_1 = ((AccessibilityAction)v12).getAction();
                                                                    if(v12_1 != null) {
                                                                        return ((Function0)v12_1).invoke().booleanValue();
                                                                    }
                                                                }

                                                                return 0;
                                                            label_288:
                                                                v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getExpand());
                                                                if(v12 != null) {
                                                                    v12_1 = ((AccessibilityAction)v12).getAction();
                                                                    if(v12_1 != null) {
                                                                        return ((Function0)v12_1).invoke().booleanValue();
                                                                    }
                                                                }

                                                                return 0;
                                                            label_299:
                                                                v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCutText());
                                                                if(v12 != null) {
                                                                    v12_1 = ((AccessibilityAction)v12).getAction();
                                                                    if(v12_1 != null) {
                                                                        return ((Function0)v12_1).invoke().booleanValue();
                                                                    }
                                                                }

                                                                return 0;
                                                            label_310:
                                                                v12 = SemanticsConfigurationKt.getOrNull(v0_1.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPasteText());
                                                                if(v12 != null) {
                                                                    v12_1 = ((AccessibilityAction)v12).getAction();
                                                                    if(v12_1 != null) {
                                                                        return ((Function0)v12_1).invoke().booleanValue();
                                                                    }
                                                                }

                                                                return 0;
                                                            }
                                                            else {
                                                                goto label_148;
                                                            }
                                                        }
                                                        else {
                                                            goto label_148;
                                                        }

                                                        goto label_149;
                                                    }
                                                }
                                            }

                                            return 0;
                                        }
                                    }
                                }
                                else {
                                    goto label_578;
                                }
                            }
                            else {
                                goto label_593;
                            }
                        }

                        v5_2 = this;
                        if(arg15 != null) {
                            v12_3 = arg15.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
                            boolean v13_3 = arg15.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
                            if(arg14 == v2) {
                                v1 = true;
                            }

                            return v5_2.traverseAtGranularity(v0_1, v12_3, v1, v13_3);
                        }

                        return 0;
                    }

                    return this.clearAccessibilityFocus(arg13);
                }

                return this.requestAccessibilityFocus(arg13);
            }
        }

        return 0;
    label_55:
        while(v15 < arg14) {
            v0 = ((List)v13).get(v15);
            if(Intrinsics.areEqual(((CustomAccessibilityAction)v0).getLabel(), v12)) {
                return ((CustomAccessibilityAction)v0).getAction().invoke().booleanValue();
            }

            ++v15;
        }

        return 0;
    label_148:
        v14_1 = v4;
    label_149:
        while(v13_2 != null) {
            if(v14_1 != null) {
            }
            else {
                v13_2 = v13_2.getParent();
                if(v13_2 == null) {
                    goto label_148;
                }

                v14 = v13_2.getUnmergedConfig$ui();
                if(v14 == null) {
                    goto label_148;
                }

                v14_1 = SemanticsConfigurationKt.getOrNull(v14, SemanticsActions.INSTANCE.getScrollBy());
                continue;
            }

            break;
        }

        if(v13_2 == null) {
            androidx.compose.ui.geometry.Rect v13_4 = v0_1.getBoundsInRoot();
            return this.view.requestRectangleOnScreen(new Rect(((int)(((float)Math.floor(((double)v13_4.getLeft()))))), ((int)(((float)Math.floor(((double)v13_4.getTop()))))), MathKt.roundToInt(((float)Math.ceil(((double)v13_4.getRight())))), MathKt.roundToInt(((float)Math.ceil(((double)v13_4.getBottom()))))));
        }

        androidx.compose.ui.geometry.Rect v12_7 = LayoutCoordinatesKt.boundsInParent(v13_2.getLayoutInfo().getCoordinates());
        LayoutCoordinates v15_3 = v13_2.getLayoutInfo().getCoordinates().getParentLayoutCoordinates();
        long v4_3 = v15_3 != null ? LayoutCoordinatesKt.positionInRoot(v15_3) : Offset.Companion.getZero-F1C5BW0();
        v12_7 = v12_7.translate-k-4lQ0M(v4_3);
        androidx.compose.ui.geometry.Rect v15_4 = RectKt.Rect-tz77jQw(v0_1.getPositionInRoot-F1C5BW0(), IntSizeKt.toSize-ozmzZPI(v0_1.getSize-YbymL2g()));
        Object v2_1 = SemanticsConfigurationKt.getOrNull(v13_2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        v13 = SemanticsConfigurationKt.getOrNull(v13_2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        float v4_4 = AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$scrollDelta(v15_4.getLeft() - v12_7.getLeft(), v15_4.getRight() - v12_7.getRight());
        if(v2_1 != null && (((ScrollAxisRange)v2_1).getReverseScrolling())) {
            v4_4 = -v4_4;
        }

        if(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isRtl(v0_1)) {
            v4_4 = -v4_4;
        }

        v12_5 = AndroidComposeViewAccessibilityDelegateCompat.performActionHelper$scrollDelta(v15_4.getTop() - v12_7.getTop(), v15_4.getBottom() - v12_7.getBottom());
        if(v13 != null && (((ScrollAxisRange)v13).getReverseScrolling())) {
            v12_5 = -v12_5;
        }

        if(v14_1 != null) {
            v13_1 = ((AccessibilityAction)v14_1).getAction();
            if(v13_1 != null && (((Function2)v13_1).invoke(Float.valueOf(v4_4), Float.valueOf(v12_5)).booleanValue())) {
                return 1;
            }
        }

        return 0;
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange arg2, float arg3) {
        if(arg3 < 0f && arg2.getValue().invoke().floatValue() > 0f || arg3 > 0f && arg2.getValue().invoke().floatValue() < arg2.getMaxValue().invoke().floatValue()) {
            return 1;
        }

        return 0;
    }

    private static final float performActionHelper$scrollDelta(float arg2, float arg3) {
        if(Math.signum(arg2) == Math.signum(arg3)) {
            if(Math.abs(arg2) < Math.abs(arg3)) {
                return arg2;
            }

            return arg3;
        }

        return 0;
    }

    private final void populateAccessibilityNodeInfoProperties(int arg23, AccessibilityNodeInfoCompat arg24, SemanticsNode arg25) {
        int v9_6;
        int v5_2;
        boolean v5_1;
        int v6_4;
        boolean v8_2;
        CharSequence v6_3;
        int v7_1;
        boolean v9_3;
        int v12;
        AndroidComposeViewAccessibilityDelegateCompat v0 = this;
        int v1 = arg23;
        AccessibilityNodeInfoCompat v2 = arg24;
        SemanticsNode v3 = arg25;
        Resources v4 = v0.view.getContext().getResources();
        v2.setClassName("android.view.View");
        if(v3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            v2.setClassName("android.widget.EditText");
        }

        if(v3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getText())) {
            v2.setClassName("android.widget.TextView");
        }

        Object v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getRole());
        if(v5 != null) {
            ((Role)v5).unbox-impl();
            if(!v3.isFake$ui() && !v3.getReplacedChildren$ui().isEmpty()) {
                goto label_67;
            }

            if(Role.equals-impl0(((Role)v5).unbox-impl(), Role.Companion.getTab-o7Vup1c())) {
                v2.setRoleDescription(v4.getString(string.tab));
                goto label_67;
            }

            if(Role.equals-impl0(((Role)v5).unbox-impl(), Role.Companion.getSwitch-o7Vup1c())) {
                v2.setRoleDescription(v4.getString(string.switch_role));
                goto label_67;
            }

            String v6 = SemanticsUtils_androidKt.toLegacyClassName-V4PA4sw(((Role)v5).unbox-impl());
            if((Role.equals-impl0(((Role)v5).unbox-impl(), Role.Companion.getImage-o7Vup1c())) && !v3.isUnmergedLeafNode$ui() && !v3.getUnmergedConfig$ui().isMergingSemanticsOfDescendants()) {
                goto label_67;
            }

            v2.setClassName(((CharSequence)v6));
        }

    label_67:
        v2.setPackageName(v0.view.getContext().getPackageName());
        v2.setImportantForAccessibility(SemanticsOwnerKt.isImportantForAccessibility(v3));
        boolean v6_1 = v0.isRequestFromAccessibilityTool();
        List v7 = v3.getReplacedChildren$ui();
        int v8 = v7.size();
        int v10 = 0;
        int v11 = 0;
        while(true) {
            v12 = -1;
            if(v10 >= v8) {
                break;
            }

            Object v14 = v7.get(v10);
            if(v0.getCurrentSemanticsNodes().containsKey(((SemanticsNode)v14).getId())) {
                Object v9 = v0.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(((SemanticsNode)v14).getLayoutNode$ui());
                if(((SemanticsNode)v14).getId() == v12) {
                }
                else {
                    if(v9 != null) {
                        v2.addChild(((View)v9));
                    }
                    else {
                        v9 = v0.getCurrentSemanticsNodes().get(((SemanticsNode)v14).getId());
                        if(v9 != null) {
                            SemanticsNode v9_1 = ((SemanticsNodeWithAdjustedBounds)v9).getSemanticsNode();
                            if(v9_1 != null) {
                                SemanticsConfiguration v9_2 = v9_1.getConfig();
                                if(v9_2 != null) {
                                    v9_3 = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v9_2, SemanticsProperties.INSTANCE.getIsSensitiveData()), Boolean.valueOf(true));
                                }
                                else {
                                    goto label_112;
                                }
                            }
                            else {
                                goto label_112;
                            }
                        }
                        else {
                        label_112:
                            v9_3 = false;
                        }

                        if(!v6_1 && (v9_3)) {
                            goto label_118;
                        }

                        v2.addChild(v0.view, ((SemanticsNode)v14).getId());
                    }

                label_118:
                    v0.drawingOrder.put(((SemanticsNode)v14).getId(), v11);
                    ++v11;
                }
            }

            ++v10;
        }

        if(v1 == v0.accessibilityFocusedVirtualViewId) {
            v2.setAccessibilityFocused(true);
            v2.addAction(AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        }
        else {
            v2.setAccessibilityFocused(false);
            v2.addAction(AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }

        v0.setText(v3, v2);
        v0.setContentInvalid(v3, v2);
        v2.setStateDescription(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$getInfoStateDescriptionOrNull(v3, v4));
        v2.setCheckable(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$getInfoIsCheckable(v3));
        Object v6_2 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getToggleableState());
        if(v6_2 != null) {
            if(v6_2 == ToggleableState.On) {
                v2.setChecked(true);
            }
            else if(v6_2 == ToggleableState.Off) {
                v2.setChecked(false);
            }
        }

        v6_2 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getSelected());
        if(v6_2 != null) {
            v6_1 = ((Boolean)v6_2).booleanValue();
            v7_1 = Role.Companion.getTab-o7Vup1c();
            boolean v7_2 = v5 == null ? false : Role.equals-impl0(((Role)v5).unbox-impl(), v7_1);
            if(v7_2) {
                v2.setSelected(v6_1);
                goto label_174;
            }

            v2.setChecked(v6_1);
        }

    label_174:
        DefaultConstructorMarker v7_3 = null;
        if(!v3.getUnmergedConfig$ui().isMergingSemanticsOfDescendants() || (v3.getReplacedChildren$ui().isEmpty())) {
            v6_2 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getContentDescription());
            if(v6_2 != null) {
                v6_2 = CollectionsKt.firstOrNull(((List)v6_2));
            }
            else {
                v6_3 = ((CharSequence)v7_3);
            }

            v2.setContentDescription(((CharSequence)v6_2));
        }

        v6_2 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getTestTag());
        if(v6_2 != null) {
            SemanticsNode v8_1 = v3;
            while(true) {
                if(v8_1 == null) {
                    break;
                }
                else if(v8_1.getUnmergedConfig$ui().contains(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId())) {
                    v8_2 = v8_1.getUnmergedConfig$ui().get(SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId()).booleanValue();
                }
                else {
                    v8_1 = v8_1.getParent();
                    continue;
                }

                goto label_211;
            }

            v8_2 = false;
        label_211:
            if(!v8_2) {
                goto label_213;
            }

            v2.setViewIdResourceName(((String)v6_2));
        }

    label_213:
        if(SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHeading()) != null) {
            v2.setHeading(true);
        }

        if(v1 != v12) {
            v6_4 = v0.drawingOrder.getOrDefault(v3.getId(), v12);
            if(v6_4 != v12) {
                v2.setDrawingOrder(v6_4);
            }
            else {
                Integer.valueOf(Log.w("AccessibilityDelegate", "Drawing order is not available, was AccessibilityNodeInfo requested for a child node before its parent?"));
            }
        }

        v2.setPassword(v3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPassword()));
        v2.setEditable(v3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getIsEditable()));
        v6_2 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getMaxTextLength());
        v6_4 = v6_2 != null ? ((Integer)v6_2).intValue() : v12;
        v2.setMaxTextLength(v6_4);
        v2.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(v3));
        v2.setFocusable(v3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getFocused()));
        v8 = 2;
        if(v2.isFocusable()) {
            v2.setFocused(v3.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getFocused()).booleanValue());
            if(v2.isFocused()) {
                v2.addAction(v8);
                v0.focusedVirtualViewId = v1;
            }
            else {
                v2.addAction(1);
            }
        }

        v2.setVisibleToUser(SemanticsOwnerKt.isHidden(v3) ^ 1);
        v6_2 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getLiveRegion());
        if(v6_2 != null) {
            v6_4 = ((LiveRegionMode)v6_2).unbox-impl();
            v6_4 = (LiveRegionMode.equals-impl0(v6_4, LiveRegionMode.Companion.getPolite-0phEisY())) || !LiveRegionMode.equals-impl0(v6_4, LiveRegionMode.Companion.getAssertive-0phEisY()) ? 1 : v8;
            v2.setLiveRegion(v6_4);
        }

        v2.setClickable(false);
        v6_2 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnClick());
        if(v6_2 != null) {
            v9_3 = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getSelected()), Boolean.valueOf(true));
            v10 = Role.Companion.getTab-o7Vup1c();
            boolean v10_1 = v5 == null ? false : Role.equals-impl0(((Role)v5).unbox-impl(), v10);
            if(!v10_1) {
                v10 = Role.Companion.getRadioButton-o7Vup1c();
                v5_1 = v5 == null ? false : Role.equals-impl0(((Role)v5).unbox-impl(), v10);
                if(v5_1) {
                    goto label_329;
                }

                v5_2 = 0;
            }
            else {
            label_329:
                v5_2 = 1;
            }

            if(v5_2 != 0) {
                if(v5_2 != 0 && !v9_3) {
                    goto label_336;
                }

                v5_1 = false;
            }
            else {
            label_336:
                v5_1 = true;
            }

            v2.setClickable(v5_1);
            if(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(v3)) {
                goto label_349;
            }

            if(!v2.isClickable()) {
                goto label_349;
            }

            v2.addAction(new AccessibilityActionCompat(16, ((AccessibilityAction)v6_2).getLabel()));
        }

    label_349:
        v2.setLongClickable(false);
        v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnLongClick());
        if(v5 != null) {
            v2.setLongClickable(true);
            if(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(v3)) {
                v2.addAction(new AccessibilityActionCompat(0x20, ((AccessibilityAction)v5).getLabel()));
            }
        }

        v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCopyText());
        if(v5 != null) {
            v2.addAction(new AccessibilityActionCompat(0x4000, ((AccessibilityAction)v5).getLabel()));
        }

        if(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(v3)) {
            v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetText());
            if(v5 != null) {
                v2.addAction(new AccessibilityActionCompat(0x200000, ((AccessibilityAction)v5).getLabel()));
            }

            v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getOnImeAction());
            if(v5 != null) {
                v2.addAction(new AccessibilityActionCompat(0x1020054, ((AccessibilityAction)v5).getLabel()));
            }

            v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCutText());
            if(v5 != null) {
                v2.addAction(new AccessibilityActionCompat(0x10000, ((AccessibilityAction)v5).getLabel()));
            }

            v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getPasteText());
            if(v5 == null) {
                goto label_434;
            }

            if(!v2.isFocused()) {
                goto label_434;
            }

            if(!v0.view.getClipboardManager().hasText()) {
                goto label_434;
            }

            v2.addAction(new AccessibilityActionCompat(0x8000, ((AccessibilityAction)v5).getLabel()));
        }

    label_434:
        String v5_3 = v0.getIterableTextForAccessibility(v3);
        if(v5_3 != null) {
            if(((CharSequence)v5_3).length() == 0) {
            }
            else {
                v2.setTextSelection(v0.getAccessibilitySelectionStart(v3), v0.getAccessibilitySelectionEnd(v3));
                v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getSetSelection());
                if(v5 != null) {
                    v5_3 = ((AccessibilityAction)v5).getLabel();
                }
                else {
                    CharSequence v5_4 = ((CharSequence)v7_3);
                }

                v2.addAction(new AccessibilityActionCompat(0x20000, ((CharSequence)v5_3)));
                v2.addAction(0x100);
                v2.addAction(0x200);
                v2.setMovementGranularities(11);
                v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getContentDescription());
                if(v5 != null && !((Collection)v5).isEmpty()) {
                    goto label_477;
                }

                if(!v3.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                    goto label_477;
                }

                if(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$excludeLineAndPageGranularities(v3)) {
                    goto label_477;
                }

                v2.setMovementGranularities(v2.getMovementGranularities() | 20);
            }
        }

    label_477:
        ArrayList v5_5 = new ArrayList();
        ((List)v5_5).add("androidx.compose.ui.semantics.id");
        v6_3 = v2.getText();
        if(v6_3 != null) {
            if(v6_3.length() == 0) {
            }
            else if(v3.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                ((List)v5_5).add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
            }
        }

        if(v3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getTestTag())) {
            ((List)v5_5).add("androidx.compose.ui.semantics.testTag");
        }

        if(v3.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getShape())) {
            ((List)v5_5).add("androidx.compose.ui.semantics.shapeType");
            ((List)v5_5).add("androidx.compose.ui.semantics.shapeRect");
            ((List)v5_5).add("androidx.compose.ui.semantics.shapeCorners");
            ((List)v5_5).add("androidx.compose.ui.semantics.shapeRegion");
        }

        ScatterSet v6_5 = v3.getUnmergedConfig$ui().getAccessibilityExtraKeys$ui();
        if(v6_5 != null) {
            Object[] v9_4 = v6_5.elements;
            long[] v6_6 = v6_5.metadata;
            v10 = v6_6.length - v8;
            if(v10 >= 0) {
                for(v8 = 0; true; ++v8) {
                    long v14_1 = v6_6[v8];
                    if((~v14_1 << 7 & v14_1 & -9187201950435737472L) != -9187201950435737472L) {
                        int v13 = 8;
                        v12 = 8 - (~(v8 - v10) >>> 0x1F);
                        long v16 = v14_1;
                        int v14_2;
                        for(v14_2 = 0; v14_2 < v12; ++v14_2) {
                            if((v16 & 0xFF) < 0x80) {
                                String v15 = v9_4[(v8 << 3) + v14_2].getAccessibilityExtraKey$ui();
                                if(v15 != null) {
                                    ((List)v5_5).add(v15);
                                }
                            }

                            v16 >>= v13;
                        }

                        if(v12 != v13) {
                            break;
                        }
                    }

                    if(v8 == v10) {
                        break;
                    }
                }
            }
        }

        v2.setAvailableExtraData(((List)v5_5));
        v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if(v5 != null) {
            if(v3.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                v2.setClassName("android.widget.SeekBar");
            }
            else {
                v2.setClassName("android.widget.ProgressBar");
            }

            if(v5 != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                v2.setRangeInfo(RangeInfoCompat.obtain(1, ((ProgressBarRangeInfo)v5).getRange().getStart().floatValue(), ((ProgressBarRangeInfo)v5).getRange().getEndInclusive().floatValue(), ((ProgressBarRangeInfo)v5).getCurrent()));
            }

            if(!v3.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                goto label_618;
            }

            if(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(v3)) {
                goto label_618;
            }

            if(((ProgressBarRangeInfo)v5).getCurrent() < RangesKt.coerceAtLeast(((ProgressBarRangeInfo)v5).getRange().getEndInclusive().floatValue(), ((ProgressBarRangeInfo)v5).getRange().getStart().floatValue())) {
                v2.addAction(AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            }

            if(((ProgressBarRangeInfo)v5).getCurrent() <= RangesKt.coerceAtMost(((ProgressBarRangeInfo)v5).getRange().getStart().floatValue(), ((ProgressBarRangeInfo)v5).getRange().getEndInclusive().floatValue())) {
                goto label_618;
            }

            v2.addAction(AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
        }

    label_618:
        Api24Impl.addSetProgressAction(arg24, arg25);
        CollectionInfo_androidKt.setCollectionInfo(v3, v2);
        CollectionInfo_androidKt.setCollectionItemInfo(v3, v2);
        v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        v6_2 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getScrollBy());
        if(v5 != null && v6_2 != null) {
            if(!CollectionInfo_androidKt.hasCollectionInfo(v3)) {
                v2.setClassName("android.widget.HorizontalScrollView");
            }

            if(((ScrollAxisRange)v5).getMaxValue().invoke().floatValue() > 0f) {
                v2.setScrollable(true);
            }

            if(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(v3)) {
                goto label_664;
            }

            if(AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(((ScrollAxisRange)v5))) {
                v2.addAction(AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                AccessibilityActionCompat v9_5 = !AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isRtl(v3) ? AccessibilityActionCompat.ACTION_SCROLL_RIGHT : AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                v2.addAction(v9_5);
            }

            if(!AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(((ScrollAxisRange)v5))) {
                goto label_664;
            }

            v2.addAction(AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            AccessibilityActionCompat v5_6 = !AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isRtl(v3) ? AccessibilityActionCompat.ACTION_SCROLL_LEFT : AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
            v2.addAction(v5_6);
        }

    label_664:
        v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if(v5 != null && v6_2 != null) {
            if(!CollectionInfo_androidKt.hasCollectionInfo(v3)) {
                v2.setClassName("android.widget.ScrollView");
            }

            if(((ScrollAxisRange)v5).getMaxValue().invoke().floatValue() > 0f) {
                v2.setScrollable(true);
            }

            if(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(v3)) {
                goto label_694;
            }

            if(AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(((ScrollAxisRange)v5))) {
                v2.addAction(AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                v2.addAction(AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            }

            if(!AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(((ScrollAxisRange)v5))) {
                goto label_694;
            }

            v2.addAction(AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            v2.addAction(AccessibilityActionCompat.ACTION_SCROLL_UP);
        }

    label_694:
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.addPageActions(arg24, arg25);
        }

        v2.setPaneTitle(SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getPaneTitle()));
        if(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(v3)) {
            v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getExpand());
            if(v5 != null) {
                v2.addAction(new AccessibilityActionCompat(0x40000, ((AccessibilityAction)v5).getLabel()));
            }

            v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getCollapse());
            if(v5 != null) {
                v2.addAction(new AccessibilityActionCompat(0x80000, ((AccessibilityAction)v5).getLabel()));
            }

            v5 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsActions.INSTANCE.getDismiss());
            if(v5 != null) {
                v2.addAction(new AccessibilityActionCompat(0x100000, ((AccessibilityAction)v5).getLabel()));
            }

            if(!v3.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                goto label_854;
            }

            v5 = v3.getUnmergedConfig$ui().get(SemanticsActions.INSTANCE.getCustomActions());
            v6_4 = ((List)v5).size();
            IntList v8_3 = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds;
            if(v6_4 < v8_3._size) {
                SparseArrayCompat v6_7 = new SparseArrayCompat(0, 1, v7_3);
                MutableObjectIntMap v12_1 = ObjectIntMapKt.mutableObjectIntMapOf();
                if(v0.labelToActionId.containsKey(v1)) {
                    Object v13_1 = v0.labelToActionId.get(v1);
                    MutableIntList v14_3 = new MutableIntList(0, 1, v7_3);
                    int[] v10_2 = v8_3.content;
                    v8 = v8_3._size;
                    int v15_1;
                    for(v15_1 = 0; v15_1 < v8; ++v15_1) {
                        v14_3.add(v10_2[v15_1]);
                    }

                    ArrayList v8_4 = new ArrayList();
                    v9_6 = v5.size();
                    for(v10 = 0; v10 < v9_6; ++v10) {
                        Object v15_2 = ((List)v5).get(v10);
                        Intrinsics.checkNotNull(v13_1);
                        if(v13_1.containsKey(((CustomAccessibilityAction)v15_2).getLabel())) {
                            v7_1 = ((MutableObjectIntMap)v13_1).get(((CustomAccessibilityAction)v15_2).getLabel());
                            v6_7.put(v7_1, ((CustomAccessibilityAction)v15_2).getLabel());
                            v12_1.set(((CustomAccessibilityAction)v15_2).getLabel(), v7_1);
                            v14_3.remove(v7_1);
                            v2.addAction(new AccessibilityActionCompat(v7_1, ((CustomAccessibilityAction)v15_2).getLabel()));
                        }
                        else {
                            Boolean.valueOf(((List)v8_4).add(v15_2));
                        }
                    }

                    v5_2 = v8_4.size();
                    for(v9_6 = 0; v9_6 < v5_2; ++v9_6) {
                        Object v7_4 = ((List)v8_4).get(v9_6);
                        v10 = v14_3.get(v9_6);
                        v6_7.put(v10, ((CustomAccessibilityAction)v7_4).getLabel());
                        v12_1.set(((CustomAccessibilityAction)v7_4).getLabel(), v10);
                        v2.addAction(new AccessibilityActionCompat(v10, ((CustomAccessibilityAction)v7_4).getLabel()));
                    }
                }
                else {
                    v7_1 = v5.size();
                    for(v9_6 = 0; v9_6 < v7_1; ++v9_6) {
                        Object v8_5 = ((List)v5).get(v9_6);
                        v10 = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds.get(v9_6);
                        v6_7.put(v10, ((CustomAccessibilityAction)v8_5).getLabel());
                        v12_1.set(((CustomAccessibilityAction)v8_5).getLabel(), v10);
                        v2.addAction(new AccessibilityActionCompat(v10, ((CustomAccessibilityAction)v8_5).getLabel()));
                    }
                }

                v0.actionIdToLabel.put(v1, v6_7);
                v0.labelToActionId.put(v1, v12_1);
                goto label_854;
            }

            throw new IllegalStateException("Can\'t have more than " + v8_3._size + " custom actions for one widget");
        }

    label_854:
        v2.setScreenReaderFocusable(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isScreenReaderFocusable(v3, v4));
        int v4_1 = v0.idToBeforeMap.getOrDefault(v1, -1);
        if(v4_1 != -1) {
            View v5_7 = SemanticsUtils_androidKt.semanticsIdToView(v0.view.getAndroidViewsHandler$ui(), v4_1);
            if(v5_7 != null) {
                v2.setTraversalBefore(v5_7);
            }
            else {
                v2.setTraversalBefore(v0.view, v4_1);
            }

            v0.addExtraDataToAccessibilityNodeInfoHelper(v1, v2, v0.ExtraDataTestTraversalBeforeVal, null);
        }

        v4_1 = v0.idToAfterMap.getOrDefault(v1, -1);
        if(v4_1 != -1) {
            View v4_2 = SemanticsUtils_androidKt.semanticsIdToView(v0.view.getAndroidViewsHandler$ui(), v4_1);
            if(v4_2 != null) {
                v2.setTraversalAfter(v4_2);
                v0.addExtraDataToAccessibilityNodeInfoHelper(v1, v2, v0.ExtraDataTestTraversalAfterVal, null);
            }
        }

        Object v0_1 = SemanticsConfigurationKt.getOrNull(v3.getUnmergedConfig$ui(), SemanticsPropertiesAndroid.INSTANCE.getAccessibilityClassName());
        if(v0_1 != null) {
            v2.setClassName(((CharSequence)v0_1));
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange arg2) {
        if(arg2.getValue().invoke().floatValue() > 0f && !arg2.getReverseScrolling() || arg2.getValue().invoke().floatValue() < arg2.getMaxValue().invoke().floatValue() && (arg2.getReverseScrolling())) {
            return 1;
        }

        return 0;
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange arg2) {
        if(arg2.getValue().invoke().floatValue() < arg2.getMaxValue().invoke().floatValue() && !arg2.getReverseScrolling() || arg2.getValue().invoke().floatValue() > 0f && (arg2.getReverseScrolling())) {
            return 1;
        }

        return 0;
    }

    private final boolean registerScrollingId(int arg8, List arg9) {
        boolean v8;
        ScrollObservationScope v9 = SemanticsUtils_androidKt.findById(arg9, arg8);
        if(v9 != null) {
            v8 = false;
        }
        else {
            ScrollObservationScope v0 = new ScrollObservationScope(arg8, this.scrollObservationScopes, null, null, null, null);
            v8 = true;
            v9 = v0;
        }

        this.scrollObservationScopes.add(v9);
        return v8;
    }

    private final boolean requestAccessibilityFocus(int arg8) {
        if(!this.isTouchExplorationEnabled()) {
            return 0;
        }

        if(!this.isAccessibilityFocused(arg8)) {
            int v1 = this.accessibilityFocusedVirtualViewId;
            if(v1 != 0x80000000) {
                AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, v1, 0x10000, null, null, 12, null);
            }

            this.accessibilityFocusedVirtualViewId = arg8;
            this.view.invalidate();
            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, arg8, 0x8000, null, null, 12, null);
            return 1;
        }

        return 0;
    }

    private final void resetEnabledAccessibilityServiceList() {
        this._enabledServices = null;
    }

    private final void scheduleScrollEventIfNeeded(ScrollObservationScope arg5) {
        if(!arg5.isValidOwnerScope()) {
            return;
        }

        this.view.getSnapshotObserver().observer.observeReads(arg5, this.scheduleScrollEventIfNeededLambda, new AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1(arg5, this));
    }

    static final void semanticsChangeChecker$lambda$0(AndroidComposeViewAccessibilityDelegateCompat arg4) {
        Trace.beginSection("measureAndLayout");
        try {
            Owner.measureAndLayout$default(arg4.view, false, 1, null);
        }
        catch(Throwable v4) {
            Trace.endSection();
            throw v4;
        }

        Trace.endSection();
        Trace.beginSection("checkForSemanticsChanges");
        try {
            arg4.checkForSemanticsChanges();
        }
        catch(Throwable v4) {
            Trace.endSection();
            throw v4;
        }

        Trace.endSection();
        arg4.checkingForSemanticsChanges = false;
    }

    private final int semanticsNodeIdToAccessibilityVirtualNodeId(int arg1) {
        if(arg1 == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }

        return arg1;
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode arg17, SemanticsNodeCopy arg18) {
        AndroidComposeViewAccessibilityDelegateCompat v0 = this;
        MutableIntSet v1 = IntSetKt.mutableIntSetOf();
        List v2 = arg17.getReplacedChildren$ui();
        int v3 = v2.size();
        int v4 = 0;
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            Object v6 = v2.get(v5);
            if(v0.getCurrentSemanticsNodes().containsKey(((SemanticsNode)v6).getId())) {
                if(!arg18.getChildren().contains(((SemanticsNode)v6).getId())) {
                    v0.notifySubtreeAccessibilityStateChangedIfNeeded(arg17.getLayoutNode$ui());
                    return;
                }
                else {
                    v1.add(((SemanticsNode)v6).getId());
                }
            }
        }

        MutableIntSet v2_1 = arg18.getChildren();
        int[] v3_1 = ((IntSet)v2_1).elements;
        long[] v2_2 = ((IntSet)v2_1).metadata;
        v5 = v2_2.length - 2;
        if(v5 >= 0) {
            int v6_1;
            for(v6_1 = 0; true; ++v6_1) {
                long v7 = v2_2[v6_1];
                if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                    int v10 = 8;
                    int v9 = 8 - (~(v6_1 - v5) >>> 0x1F);
                    int v11;
                    for(v11 = 0; v11 < v9; ++v11) {
                        if((0xFF & v7) < 0x80 && !v1.contains(v3_1[(v6_1 << 3) + v11])) {
                            v0.notifySubtreeAccessibilityStateChangedIfNeeded(arg17.getLayoutNode$ui());
                            return;
                        }

                        v7 >>= v10;
                    }

                    if(v9 != v10) {
                        break;
                    }
                }

                if(v6_1 == v5) {
                    break;
                }
            }
        }

        List v1_1 = arg17.getReplacedChildren$ui();
        int v2_3 = v1_1.size();
        while(v4 < v2_3) {
            Object v3_2 = v1_1.get(v4);
            Object v5_1 = v0.previousSemanticsNodes.get(((SemanticsNode)v3_2).getId());
            if(v5_1 != null && (v0.getCurrentSemanticsNodes().containsKey(((SemanticsNode)v3_2).getId()))) {
                v0.sendAccessibilitySemanticsStructureChangeEvents(((SemanticsNode)v3_2), ((SemanticsNodeCopy)v5_1));
            }

            ++v4;
        }
    }

    private final boolean sendEvent(AccessibilityEvent arg4) {
        boolean v4_1;
        if(!this.isEnabled$ui()) {
            return 0;
        }

        if(arg4.getEventType() == 0x800 || arg4.getEventType() == 0x8000) {
            this.sendingFocusAffectingEvent = true;
        }

        try {
            v4_1 = this.onSendAccessibilityEvent.invoke(arg4).booleanValue();
        }
        catch(Throwable v4) {
            this.sendingFocusAffectingEvent = false;
            throw v4;
        }

        this.sendingFocusAffectingEvent = false;
        return v4_1;
    }

    private final boolean sendEventForVirtualView(int arg10, int arg11, Integer arg12, List arg13) {
        if(arg10 != 0x80000000) {
            if(!this.isEnabled$ui()) {
            }
            else {
                AccessibilityEvent v10 = this.createEvent(arg10, arg11);
                if(arg12 != null) {
                    v10.setContentChangeTypes(arg12.intValue());
                }

                if(arg13 != null) {
                    v10.setContentDescription(ListUtilsKt.fastJoinToString$default(arg13, ",", null, null, 0, null, null, 62, null));
                }

                return this.sendEvent(v10);
            }
        }

        return 0;
    }

    static boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat arg1, int arg2, int arg3, Integer arg4, List arg5, int arg6, Object arg7) {
        Integer v0 = null;
        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        if((arg6 & 8) != 0) {
            arg5 = ((List)v0);
        }

        return arg1.sendEventForVirtualView(arg2, arg3, arg4, arg5);
    }

    private final void sendPaneChangeEvents(int arg2, int arg3, String arg4) {
        AccessibilityEvent v2 = this.createEvent(this.semanticsNodeIdToAccessibilityVirtualNodeId(arg2), 0x20);
        v2.setContentChangeTypes(arg3);
        if(arg4 != null) {
            v2.getText().add(arg4);
        }

        this.sendEvent(v2);
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int arg6) {
        PendingTextTraversedEvent v0 = this.pendingTextTraversedEvent;
        if(v0 != null) {
            if(arg6 != v0.getNode().getId()) {
                return;
            }
            else if(SystemClock.uptimeMillis() - v0.getTraverseTime() <= 1000) {
                AccessibilityEvent v6 = this.createEvent(this.semanticsNodeIdToAccessibilityVirtualNodeId(v0.getNode().getId()), 0x20000);
                v6.setFromIndex(v0.getFromIndex());
                v6.setToIndex(v0.getToIndex());
                v6.setAction(v0.getAction());
                v6.setMovementGranularity(v0.getGranularity());
                v6.getText().add(this.getIterableTextForAccessibility(v0.getNode()));
                this.sendEvent(v6);
            }
        }

        this.pendingTextTraversedEvent = null;
    }

    private final void sendSemanticsPropertyChangeEvents(IntObjectMap arg51) {
        AccessibilityEvent v5_6;
        int v45;
        int v43;
        String v5_4;
        String v1_6;
        AnnotatedString v1_5;
        String v4_2;
        Object v1_3;
        int v9_1;
        SemanticsNode v32_1;
        int v10_1;
        Object[] v38;
        int v39;
        boolean v30;
        int v8_1;
        int v28;
        int v26;
        long[] v36;
        int[] v29;
        ArrayList v40;
        int v37;
        AndroidComposeViewAccessibilityDelegateCompat v0 = this;
        IntObjectMap v7 = arg51;
        ArrayList v8 = new ArrayList(v0.scrollObservationScopes);
        v0.scrollObservationScopes.clear();
        int[] v9 = v7.keys;
        long[] v10 = v7.metadata;
        int v11 = 2;
        int v12 = v10.length - 2;
        if(v12 >= 0) {
            int v14 = 0;
            while(true) {
                long v1 = v10[v14];
                int v15 = 7;
                long v16 = -9187201950435737472L;
                if((~v1 << v15 & v1 & v16) != v16) {
                    int v4 = 8;
                    int v3 = 8 - (~(v14 - v12) >>> 0x1F);
                    long v18 = v1;
                    int v1_1 = 0;
                    while(v1_1 < v3) {
                        long v20 = 0xFF;
                        long v22 = 0x80;
                        if((v18 & v20) < v22) {
                            int v2 = v9[(v14 << 3) + v1_1];
                            Object v24 = v0.previousSemanticsNodes.get(v2);
                            if(v24 == null) {
                                v37 = v1_1;
                                v40 = v8;
                                v29 = v9;
                                v36 = v10;
                                v26 = v11;
                                v28 = v15;
                                v8_1 = v3;
                            }
                            else {
                                Object v5 = v7.get(v2);
                                SemanticsNode v25 = null;
                                SemanticsNode v5_1 = v5 != null ? ((SemanticsNodeWithAdjustedBounds)v5).getSemanticsNode() : v25;
                                if(v5_1 == null) {
                                    goto label_674;
                                }

                                MutableScatterMap v6 = v5_1.getUnmergedConfig$ui().getProps$ui();
                                v26 = v11;
                                Object[] v11_1 = ((ScatterMap)v6).keys;
                                Object[] v13 = ((ScatterMap)v6).values;
                                long[] v6_1 = ((ScatterMap)v6).metadata;
                                v28 = v15;
                                v15 = v6_1.length - 2;
                                if(v15 >= 0) {
                                    int v31 = v4;
                                    SemanticsNode v29_1 = v5_1;
                                    v30 = false;
                                    int v32 = 0;
                                    while(true) {
                                        long v4_1 = v6_1[v32];
                                        long[] v33 = v6_1;
                                        if((~v4_1 << v28 & v4_1 & v16) != v16) {
                                            int v7_1 = 8 - (~(v32 - v15) >>> 0x1F);
                                            long v34 = v4_1;
                                            v4 = 0;
                                            while(v4 < v7_1) {
                                                if((v34 & v20) < v22) {
                                                    int v5_2 = (v32 << 3) + v4;
                                                    Object v6_2 = v11_1[v5_2];
                                                    v5 = v13[v5_2];
                                                    v37 = v1_1;
                                                    boolean v1_2 = (Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange())) || (Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) ? v0.registerScrollingId(v2, v8) : false;
                                                    if(!v1_2 && (Intrinsics.areEqual(v5, SemanticsConfigurationKt.getOrNull(((SemanticsNodeCopy)v24).getUnmergedConfig(), ((SemanticsPropertyKey)v6_2))))) {
                                                        goto label_111;
                                                    }
                                                    else if(Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getPaneTitle())) {
                                                        Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type kotlin.String");
                                                        if(((SemanticsNodeCopy)v24).getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                                            v0.sendPaneChangeEvents(v2, v31, ((String)v5));
                                                            goto label_111;
                                                        }
                                                        else {
                                                        label_111:
                                                            v39 = v4;
                                                            v40 = v8;
                                                            v36 = v10;
                                                            v38 = v11_1;
                                                            v10_1 = v32;
                                                            v8_1 = v3;
                                                            v32_1 = v29_1;
                                                            v29 = v9;
                                                            v9_1 = v2;
                                                        }
                                                    }
                                                    else {
                                                        v31 = 0x40;
                                                        if(!Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getStateDescription())) {
                                                            if(Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getToggleableState())) {
                                                            }
                                                            else {
                                                                if(Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getProgressBarRangeInfo())) {
                                                                    v39 = v4;
                                                                    v40 = v8;
                                                                    v36 = v10;
                                                                    v8_1 = v3;
                                                                    v10_1 = v32;
                                                                    v32_1 = v29_1;
                                                                    v29 = v9;
                                                                    v9_1 = v2;
                                                                    v38 = v11_1;
                                                                    AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v2), 0x800, Integer.valueOf(v31), null, 8, null);
                                                                    Boolean.valueOf(AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), 0x800, Integer.valueOf(0), null, 8, null));
                                                                }
                                                                else {
                                                                    v39 = v4;
                                                                    v40 = v8;
                                                                    v36 = v10;
                                                                    v38 = v11_1;
                                                                    v10_1 = v32;
                                                                    v8_1 = v3;
                                                                    v32_1 = v29_1;
                                                                    v29 = v9;
                                                                    v9_1 = v2;
                                                                    v2 = 4;
                                                                    if(Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getSelected())) {
                                                                        v1_3 = SemanticsConfigurationKt.getOrNull(v32_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getRole());
                                                                        v4 = Role.Companion.getTab-o7Vup1c();
                                                                        v1_2 = v1_3 == null ? false : Role.equals-impl0(((Role)v1_3).unbox-impl(), v4);
                                                                        if(!v1_2) {
                                                                            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), 0x800, Integer.valueOf(v31), null, 8, null);
                                                                            v1_2 = AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), 0x800, Integer.valueOf(0), null, 8, null);
                                                                        }
                                                                        else if(Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(v32_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getSelected()), Boolean.valueOf(true))) {
                                                                            AccessibilityEvent v1_4 = v0.createEvent(v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), v2);
                                                                            SemanticsNode v2_1 = v32_1.copyWithMergingEnabled$ui();
                                                                            Object v41 = SemanticsConfigurationKt.getOrNull(v2_1.getConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                                                                            String v3_1 = ",";
                                                                            v4_2 = v41 != null ? ListUtilsKt.fastJoinToString$default(((List)v41), v3_1, null, null, 0, null, null, 62, null) : ((String)v25);
                                                                            v41 = SemanticsConfigurationKt.getOrNull(v2_1.getConfig(), SemanticsProperties.INSTANCE.getText());
                                                                            String v2_2 = v41 != null ? ListUtilsKt.fastJoinToString$default(((List)v41), v3_1, null, null, 0, null, null, 62, null) : ((String)v25);
                                                                            if(v4_2 != null) {
                                                                                v1_4.setContentDescription(((CharSequence)v4_2));
                                                                            }

                                                                            if(v2_2 != null) {
                                                                                Boolean.valueOf(v1_4.getText().add(v2_2));
                                                                            }

                                                                            v1_2 = v0.sendEvent(v1_4);
                                                                        }
                                                                        else {
                                                                            v1_2 = AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), 0x800, Integer.valueOf(0), null, 8, null);
                                                                        }

                                                                        Boolean.valueOf(v1_2);
                                                                    }
                                                                    else {
                                                                        if(Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getContentDescription())) {
                                                                            v1_1 = v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1);
                                                                            Integer v2_3 = Integer.valueOf(v2);
                                                                            Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                                                            Boolean.valueOf(v0.sendEventForVirtualView(v1_1, 0x800, v2_3, ((List)v5)));
                                                                            goto label_590;
                                                                        }

                                                                        v2 = 100000;
                                                                        v4_2 = "";
                                                                        if(Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getEditableText())) {
                                                                            if(v32_1.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getSetText())) {
                                                                                v1_5 = v0.getTextForTextField(((SemanticsNodeCopy)v24).getUnmergedConfig());
                                                                                if(v1_5 != null) {
                                                                                }
                                                                                else {
                                                                                    v1_6 = v4_2;
                                                                                }

                                                                                AnnotatedString v5_3 = v0.getTextForTextField(v32_1.getUnmergedConfig$ui());
                                                                                if(v5_3 != null) {
                                                                                }
                                                                                else {
                                                                                    v5_4 = v4_2;
                                                                                }

                                                                                CharSequence v2_4 = v0.trimToSize(((CharSequence)v5_4), v2);
                                                                                v4 = ((CharSequence)v1_5).length();
                                                                                int v6_3 = ((CharSequence)v5_4).length();
                                                                                v3 = RangesKt.coerceAtMost(v4, v6_3);
                                                                                v11 = 0;
                                                                                while(true) {
                                                                                    v31 = v3;
                                                                                    if(v11 < v3) {
                                                                                        v43 = v4;
                                                                                        if(((CharSequence)v1_5).charAt(v11) != ((CharSequence)v5_4).charAt(v11)) {
                                                                                        }
                                                                                        else {
                                                                                            ++v11;
                                                                                            v3 = v31;
                                                                                            v4 = v43;
                                                                                            continue;
                                                                                        }
                                                                                    }
                                                                                    else {
                                                                                        break;
                                                                                    }

                                                                                    goto label_332;
                                                                                }

                                                                                v43 = v4;
                                                                            label_332:
                                                                                v3 = 0;
                                                                                while(true) {
                                                                                    if(v3 < v31 - v11) {
                                                                                        v45 = v3;
                                                                                        if(((CharSequence)v1_5).charAt(v43 - 1 - v3) != ((CharSequence)v5_4).charAt(v6_3 - 1 - v45)) {
                                                                                        }
                                                                                        else {
                                                                                            v3 = v45 + 1;
                                                                                            continue;
                                                                                        }
                                                                                    }
                                                                                    else {
                                                                                        break;
                                                                                    }

                                                                                    goto label_347;
                                                                                }

                                                                                v45 = v3;
                                                                            label_347:
                                                                                v4 = v43 - v45 - v11;
                                                                                v3 = v6_3 - v45 - v11;
                                                                                v43 = v6_3;
                                                                                boolean v44 = ((SemanticsNodeCopy)v24).getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword());
                                                                                boolean v45_1 = v32_1.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPassword());
                                                                                boolean v5_5 = ((SemanticsNodeCopy)v24).getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
                                                                                v6_3 = !v5_5 || (v44) || !v45_1 ? 0 : 1;
                                                                                int v41_1 = !v5_5 || !v44 || (v45_1) ? 0 : 1;
                                                                                if(v6_3 != 0 || v41_1 != 0) {
                                                                                    v31 = v6_3;
                                                                                    v5_6 = v0.createTextSelectionChangedEvent(v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(v43), v2_4);
                                                                                }
                                                                                else {
                                                                                    v31 = v6_3;
                                                                                    v5_6 = v0.createEvent(v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), 16);
                                                                                    v5_6.setFromIndex(v11);
                                                                                    v5_6.setRemovedCount(v4);
                                                                                    v5_6.setAddedCount(v3);
                                                                                    v5_6.setBeforeText(((CharSequence)v1_5));
                                                                                    v5_6.getText().add(v2_4);
                                                                                }

                                                                                v5_6.setClassName("android.widget.EditText");
                                                                                v0.sendEvent(v5_6);
                                                                                if(v31 == 0 && v41_1 == 0) {
                                                                                    goto label_590;
                                                                                }

                                                                                v1 = v32_1.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getTextSelectionRange()).unbox-impl();
                                                                                v5_6.setFromIndex(TextRange.getStart-impl(v1));
                                                                                v5_6.setToIndex(TextRange.getEnd-impl(v1));
                                                                                v0.sendEvent(v5_6);
                                                                                goto label_590;
                                                                            }

                                                                            Boolean.valueOf(AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), 0x800, Integer.valueOf(v26), null, 8, null));
                                                                            goto label_590;
                                                                        }

                                                                        if(Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                                                                            v1_5 = v0.getTextForTextField(v32_1.getUnmergedConfig$ui());
                                                                            if(v1_5 != null) {
                                                                                v1_6 = v1_5.getText();
                                                                                if(v1_6 == null) {
                                                                                }
                                                                                else {
                                                                                    v4_2 = v1_6;
                                                                                }
                                                                            }

                                                                            long v5_7 = v32_1.getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getTextSelectionRange()).unbox-impl();
                                                                            v0.sendEvent(v0.createTextSelectionChangedEvent(v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), Integer.valueOf(TextRange.getStart-impl(v5_7)), Integer.valueOf(TextRange.getEnd-impl(v5_7)), Integer.valueOf(v4_2.length()), v0.trimToSize(((CharSequence)v4_2), v2)));
                                                                            v0.sendPendingTextTraversedAtGranularityEvent(v32_1.getId());
                                                                            goto label_590;
                                                                        }

                                                                        if(!Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange())) {
                                                                            if(Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) {
                                                                            }
                                                                            else {
                                                                                if(Intrinsics.areEqual(v6_2, SemanticsProperties.INSTANCE.getFocused())) {
                                                                                    Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type kotlin.Boolean");
                                                                                    if(((Boolean)v5).booleanValue()) {
                                                                                        v0.sendEvent(v0.createEvent(v0.semanticsNodeIdToAccessibilityVirtualNodeId(v32_1.getId()), 8));
                                                                                    }

                                                                                    Boolean.valueOf(AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v32_1.getId()), 0x800, Integer.valueOf(0), null, 8, null));
                                                                                }
                                                                                else {
                                                                                    if(Intrinsics.areEqual(v6_2, SemanticsActions.INSTANCE.getCustomActions())) {
                                                                                        v1_3 = v32_1.getUnmergedConfig$ui().get(SemanticsActions.INSTANCE.getCustomActions());
                                                                                        Object v2_5 = SemanticsConfigurationKt.getOrNull(((SemanticsNodeCopy)v24).getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions());
                                                                                        if(v2_5 != null) {
                                                                                            LinkedHashSet v3_2 = new LinkedHashSet();
                                                                                            v4 = v1_3.size();
                                                                                            for(v5_2 = 0; v5_2 < v4; ++v5_2) {
                                                                                                ((Set)v3_2).add(((List)v1_3).get(v5_2).getLabel());
                                                                                            }

                                                                                            LinkedHashSet v1_7 = new LinkedHashSet();
                                                                                            v4 = v2_5.size();
                                                                                            for(v5_2 = 0; v5_2 < v4; ++v5_2) {
                                                                                                ((Set)v1_7).add(((List)v2_5).get(v5_2).getLabel());
                                                                                            }

                                                                                            if(((Set)v3_2).containsAll(v1_7)) {
                                                                                                if(!((Set)v1_7).containsAll(((Collection)v3_2))) {
                                                                                                }
                                                                                                else {
                                                                                                    v30 = false;
                                                                                                    goto label_590;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        else {
                                                                                            if(!((Collection)v1_3).isEmpty()) {
                                                                                                goto label_537;
                                                                                            }

                                                                                            goto label_590;
                                                                                        }

                                                                                    label_537:
                                                                                        v30 = true;
                                                                                        goto label_590;
                                                                                    }

                                                                                    if((v5 instanceof AccessibilityAction)) {
                                                                                        if(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$accessibilityEquals(((AccessibilityAction)v5), SemanticsConfigurationKt.getOrNull(((SemanticsNodeCopy)v24).getUnmergedConfig(), ((SemanticsPropertyKey)v6_2)))) {
                                                                                        }
                                                                                        else {
                                                                                            v30 = false;
                                                                                            goto label_590;
                                                                                        }
                                                                                    }

                                                                                    v30 = true;
                                                                                }

                                                                                goto label_590;
                                                                            }
                                                                        }

                                                                        v0.notifySubtreeAccessibilityStateChangedIfNeeded(v32_1.getLayoutNode$ui());
                                                                        ScrollObservationScope v1_8 = SemanticsUtils_androidKt.findById(v0.scrollObservationScopes, v9_1);
                                                                        Intrinsics.checkNotNull(v1_8);
                                                                        v1_8.setHorizontalScrollAxisRange(SemanticsConfigurationKt.getOrNull(v32_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()));
                                                                        v1_8.setVerticalScrollAxisRange(SemanticsConfigurationKt.getOrNull(v32_1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange()));
                                                                        v0.scheduleScrollEventIfNeeded(v1_8);
                                                                    }
                                                                }

                                                                goto label_590;
                                                            }
                                                        }

                                                        v39 = v4;
                                                        v40 = v8;
                                                        v36 = v10;
                                                        v38 = v11_1;
                                                        v10_1 = v32;
                                                        v8_1 = v3;
                                                        v32_1 = v29_1;
                                                        v29 = v9;
                                                        v9_1 = v2;
                                                        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), 0x800, Integer.valueOf(v31), null, 8, null);
                                                        Boolean.valueOf(AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), 0x800, Integer.valueOf(0), null, 8, null));
                                                    }

                                                label_590:
                                                    v11 = 8;
                                                }
                                                else {
                                                    v37 = v1_1;
                                                    v39 = v4;
                                                    v40 = v8;
                                                    v36 = v10;
                                                    v38 = v11_1;
                                                    v10_1 = v32;
                                                    v8_1 = v3;
                                                    v32_1 = v29_1;
                                                    v29 = v9;
                                                    v9_1 = v2;
                                                    v11 = v31;
                                                }

                                                v34 >>= v11;
                                                v4 = v39 + 1;
                                                v3 = v8_1;
                                                v2 = v9_1;
                                                v31 = v11;
                                                v9 = v29;
                                                v29_1 = v32_1;
                                                v1_1 = v37;
                                                v11_1 = v38;
                                                v8 = v40;
                                                v32 = v10_1;
                                                v10 = v36;
                                            }

                                            v37 = v1_1;
                                            v40 = v8;
                                            v36 = v10;
                                            v38 = v11_1;
                                            v10_1 = v32;
                                            v8_1 = v3;
                                            v32_1 = v29_1;
                                            v29 = v9;
                                            v9_1 = v2;
                                            if(v7_1 != v31) {
                                                break;
                                            }
                                        }
                                        else {
                                            v37 = v1_1;
                                            v40 = v8;
                                            v36 = v10;
                                            v38 = v11_1;
                                            v10_1 = v32;
                                            v8_1 = v3;
                                            v32_1 = v29_1;
                                            v29 = v9;
                                            v9_1 = v2;
                                        }

                                        if(v10_1 == v15) {
                                            break;
                                        }

                                        v1_1 = v10_1 + 1;
                                        v3 = v8_1;
                                        v2 = v9_1;
                                        v9 = v29;
                                        v29_1 = v32_1;
                                        v6_1 = v33;
                                        v10 = v36;
                                        v11_1 = v38;
                                        v8 = v40;
                                        v31 = 8;
                                        v32 = v1_1;
                                        v1_1 = v37;
                                    }
                                }
                                else {
                                    v37 = v1_1;
                                    v32_1 = v5_1;
                                    v40 = v8;
                                    v29 = v9;
                                    v36 = v10;
                                    v9_1 = v2;
                                    v8_1 = v3;
                                    v30 = false;
                                }

                                if(!v30) {
                                    v30 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$propertiesDeleted(v32_1, ((SemanticsNodeCopy)v24).getUnmergedConfig());
                                }

                                if(!v30) {
                                    goto label_672;
                                }

                                AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(v0, v0.semanticsNodeIdToAccessibilityVirtualNodeId(v9_1), 0x800, Integer.valueOf(0), null, 8, null);
                            }

                        label_672:
                            v11 = 8;
                            goto label_688;
                        label_674:
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        else {
                            v37 = v1_1;
                            v40 = v8;
                            v29 = v9;
                            v36 = v10;
                            v26 = v11;
                            v28 = v15;
                            v8_1 = v3;
                            v11 = v4;
                        }

                    label_688:
                        v18 >>= v11;
                        v1_1 = v37 + 1;
                        v0 = this;
                        v7 = arg51;
                        v3 = v8_1;
                        v4 = v11;
                        v11 = v26;
                        v15 = v28;
                        v9 = v29;
                        v10 = v36;
                        v8 = v40;
                    }

                    v40 = v8;
                    v29 = v9;
                    v36 = v10;
                    v26 = v11;
                    if(v3 != v4) {
                        return;
                    }
                }
                else {
                    v40 = v8;
                    v29 = v9;
                    v36 = v10;
                    v26 = v11;
                }

                if(v14 == v12) {
                    return;
                }

                ++v14;
                v0 = this;
                v7 = arg51;
                v11 = v26;
                v9 = v29;
                v10 = v36;
                v8 = v40;
            }
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode arg8, MutableIntSet arg9) {
        if(!arg8.isAttached()) {
        }
        else if(this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(arg8)) {
        }
        else {
            if(arg8.getNodes$ui().has-H91voCI$ui(NodeKind.constructor-impl(8))) {
            }
            else {
                arg8 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode(arg8, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1.INSTANCE);
            }

            if(arg8 == null) {
                return;
            }

            SemanticsConfiguration v0 = arg8.getSemanticsConfiguration();
            if(v0 == null) {
                return;
            }

            if(!v0.isMergingSemanticsOfDescendants()) {
                LayoutNode v0_1 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$findClosestParentNode(arg8, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE);
                if(v0_1 != null) {
                    arg8 = v0_1;
                }
            }

            if(arg8 == null) {
                return;
            }

            int v8 = arg8.getSemanticsId();
            if(!arg9.add(v8)) {
                return;
            }

            AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, this.semanticsNodeIdToAccessibilityVirtualNodeId(v8), 0x800, Integer.valueOf(1), null, 8, null);
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode arg4) {
        Object v1;
        Object v0;
        int v4;
        if(!arg4.isAttached()) {
        }
        else if(this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(arg4)) {
        }
        else {
            v4 = arg4.getSemanticsId();
            v0 = this.pendingHorizontalScrollEvents.get(v4);
            v1 = this.pendingVerticalScrollEvents.get(v4);
            if(v0 == null && v1 == null) {
                return;
            }

            goto label_17;
        }

        return;
    label_17:
        AccessibilityEvent v4_1 = this.createEvent(v4, 0x1000);
        if(v0 != null) {
            v4_1.setScrollX(((int)((ScrollAxisRange)v0).getValue().invoke().floatValue()));
            v4_1.setMaxScrollX(((int)((ScrollAxisRange)v0).getMaxValue().invoke().floatValue()));
        }

        if(v1 != null) {
            v4_1.setScrollY(((int)((ScrollAxisRange)v1).getValue().invoke().floatValue()));
            v4_1.setMaxScrollY(((int)((ScrollAxisRange)v1).getMaxValue().invoke().floatValue()));
        }

        this.sendEvent(v4_1);
    }

    public final void setAccessibilityForceEnabledForTesting$ui(boolean arg1) {
        this.accessibilityForceEnabledForTesting = arg1;
        this.currentSemanticsNodesInvalidated = true;
    }

    private final boolean setAccessibilitySelection(SemanticsNode arg9, int arg10, int arg11, boolean arg12) {
        int v1 = 0;
        if((arg9.getUnmergedConfig$ui().contains(SemanticsActions.INSTANCE.getSetSelection())) && (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(arg9))) {
            Function v8 = arg9.getUnmergedConfig$ui().get(SemanticsActions.INSTANCE.getSetSelection()).getAction();
            if(v8 != null) {
                return ((Function3)v8).invoke(Integer.valueOf(arg10), Integer.valueOf(arg11), Boolean.valueOf(arg12)).booleanValue();
            }
            else {
                return 0;
            }
        }

        if(arg10 == arg11 && arg11 == this.accessibilityCursorPosition) {
            return 0;
        }

        String v12 = this.getIterableTextForAccessibility(arg9);
        if(v12 == null) {
            return 0;
        }

        if(arg10 < 0 || arg10 != arg11 || arg11 > v12.length()) {
            arg10 = -1;
        }
        else {
        }

        this.accessibilityCursorPosition = arg10;
        String v7 = v12;
        if(((CharSequence)v7).length() > 0) {
            v1 = 1;
        }

        int v3 = this.semanticsNodeIdToAccessibilityVirtualNodeId(arg9.getId());
        Integer v10 = null;
        Integer v4 = v1 != 0 ? Integer.valueOf(this.accessibilityCursorPosition) : v10;
        Integer v5 = v1 != 0 ? Integer.valueOf(this.accessibilityCursorPosition) : v10;
        if(v1 != 0) {
            v10 = Integer.valueOf(v12.length());
        }

        this.sendEvent(this.createTextSelectionChangedEvent(v3, v4, v5, v10, ((CharSequence)v7)));
        this.sendPendingTextTraversedAtGranularityEvent(arg9.getId());
        return 1;
    }

    private final void setContentInvalid(SemanticsNode arg2, AccessibilityNodeInfoCompat arg3) {
        if(arg2.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getError())) {
            arg3.setContentInvalid(true);
            arg3.setError(SemanticsConfigurationKt.getOrNull(arg2.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    public final void setHoveredVirtualViewId$ui(int arg1) {
        this.hoveredVirtualViewId = arg1;
    }

    public final void setIdToAfterMap$ui(MutableIntIntMap arg1) {
        this.idToAfterMap = arg1;
    }

    public final void setIdToBeforeMap$ui(MutableIntIntMap arg1) {
        this.idToBeforeMap = arg1;
    }

    public final void setOnSendAccessibilityEvent$ui(Function1 arg1) {
        this.onSendAccessibilityEvent = arg1;
    }

    public final void setRequestFromAccessibilityToolForTesting$ui(Boolean arg1) {
        this.requestFromAccessibilityToolForTesting = arg1;
    }

    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui(long arg1) {
        this.SendRecurringAccessibilityEventsIntervalMillis = arg1;
    }

    private final void setText(SemanticsNode arg1, AccessibilityNodeInfoCompat arg2) {
        SpannableString v0;
        AnnotatedString v1 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$getInfoText(arg1);
        if(v1 != null) {
            v0 = this.toSpannableString(v1);
        }
        else {
            CharSequence v0_1 = null;
        }

        arg2.setText(((CharSequence)v0));
    }

    private final Rect toAndroidRect(Outline arg2, float arg3, float arg4) {
        if(!(arg2 instanceof Rectangle)) {
            if((arg2 instanceof Rounded)) {
            }
            else {
                return null;
            }
        }

        return this.toAndroidRect(arg2.getBounds(), arg3, arg4);
    }

    private final Rect toAndroidRect(androidx.compose.ui.geometry.Rect arg4, float arg5, float arg6) {
        return new Rect(((int)(arg4.getLeft() + arg5)), ((int)(arg4.getTop() + arg6)), ((int)(arg4.getRight() + arg5)), ((int)(arg4.getBottom() + arg6)));
    }

    static Rect toAndroidRect$default(AndroidComposeViewAccessibilityDelegateCompat arg1, androidx.compose.ui.geometry.Rect arg2, float arg3, float arg4, int arg5, Object arg6) {
        return arg1.toAndroidRect(arg2, 0f, 0f);
    }

    private final Rect toBoundsInScreen(float arg9, float arg10, float arg11, float arg12) {
        long v9 = this.view.localToScreen-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(arg10))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg9))) << 0x20));
        long v11 = this.view.localToScreen-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(arg12))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg11))) << 0x20));
        int v0 = ((int)(v9 >> 0x20));
        int v2 = ((int)(v11 >> 0x20));
        int v9_1 = ((int)(v9 & 0xFFFFFFFFL));
        int v11_1 = ((int)(v11 & 0xFFFFFFFFL));
        return new Rect(((int)(((float)Math.floor(((double)Math.min(Float.intBitsToFloat(v0), Float.intBitsToFloat(v2))))))), ((int)(((float)Math.floor(((double)Math.min(Float.intBitsToFloat(v9_1), Float.intBitsToFloat(v11_1))))))), ((int)(((float)Math.ceil(((double)Math.max(Float.intBitsToFloat(v0), Float.intBitsToFloat(v2))))))), ((int)(((float)Math.ceil(((double)Math.max(Float.intBitsToFloat(v9_1), Float.intBitsToFloat(v11_1))))))));
    }

    private final androidx.compose.ui.geometry.Rect toBoundsRelativeToNodeBounds(Rect arg3, Rect arg4) {
        float v2 = ((float)(arg3.left - arg4.left));
        float v4 = ((float)(arg3.top - arg4.top));
        return new androidx.compose.ui.geometry.Rect(v2, v4, (((float)arg3.width())) + v2, (((float)arg3.height())) + v4);
    }

    private final float[] toCornerArray(Outline arg6) {
        if((arg6 instanceof Rounded)) {
            return new float[]{Float.intBitsToFloat(((int)(((Rounded)arg6).getRoundRect().getTopLeftCornerRadius-kKHJgLs() >> 0x20))), Float.intBitsToFloat(((int)(((Rounded)arg6).getRoundRect().getTopLeftCornerRadius-kKHJgLs() & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(((Rounded)arg6).getRoundRect().getTopRightCornerRadius-kKHJgLs() >> 0x20))), Float.intBitsToFloat(((int)(((Rounded)arg6).getRoundRect().getTopRightCornerRadius-kKHJgLs() & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(((Rounded)arg6).getRoundRect().getBottomRightCornerRadius-kKHJgLs() >> 0x20))), Float.intBitsToFloat(((int)(((Rounded)arg6).getRoundRect().getBottomRightCornerRadius-kKHJgLs() & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(((Rounded)arg6).getRoundRect().getBottomLeftCornerRadius-kKHJgLs() >> 0x20))), Float.intBitsToFloat(((int)(((Rounded)arg6).getRoundRect().getBottomLeftCornerRadius-kKHJgLs() & 0xFFFFFFFFL)))};
        }

        return null;
    }

    private final Region toRegion(Outline arg9, float arg10, float arg11) {
        if((arg9 instanceof Generic)) {
            Region v0 = new Region(AndroidComposeViewAccessibilityDelegateCompat.toAndroidRect$default(this, ((Generic)arg9).getBounds().translate(arg10, arg11), 0f, 0f, 3, null));
            Region v8 = new Region();
            Path v9 = ((Generic)arg9).getPath();
            if((v9 instanceof AndroidPath)) {
                android.graphics.Path v9_1 = ((AndroidPath)v9).getInternalPath();
                v9_1.offset(arg10, arg11);
                v8.setPath(v9_1, v0);
                return v8;
            }

            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }

        return null;
    }

    private final RectF toScreenCoords(SemanticsNode arg10, androidx.compose.ui.geometry.Rect arg11) {
        RectF v0 = null;
        if(arg10 == null) {
            return v0;
        }

        arg11 = arg11.translate-k-4lQ0M(arg10.getPositionInRoot-F1C5BW0());
        androidx.compose.ui.geometry.Rect v10 = arg10.getBoundsInRoot();
        v10 = arg11.overlaps(v10) ? arg11.intersect(v10) : ((androidx.compose.ui.geometry.Rect)v0);
        if(v10 != null) {
            long v0_1 = this.view.localToScreen-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v10.getTop()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v10.getLeft()))) << 0x20));
            long v9 = this.view.localToScreen-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v10.getBottom()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v10.getRight()))) << 0x20));
            int v2 = ((int)(v0_1 >> 0x20));
            int v4 = ((int)(v9 >> 0x20));
            int v0_2 = ((int)(v0_1 & 0xFFFFFFFFL));
            int v9_1 = ((int)(v9 & 0xFFFFFFFFL));
            return new RectF(Math.min(Float.intBitsToFloat(v2), Float.intBitsToFloat(v4)), Math.min(Float.intBitsToFloat(v0_2), Float.intBitsToFloat(v9_1)), Math.max(Float.intBitsToFloat(v2), Float.intBitsToFloat(v4)), Math.max(Float.intBitsToFloat(v0_2), Float.intBitsToFloat(v9_1)));
        }

        return v0;
    }

    private final SpannableString toSpannableString(AnnotatedString arg4) {
        return this.trimToSize(AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(arg4, this.view.getDensity(), this.view.getFontFamilyResolver(), this.urlSpanCache), 100000);
    }

    private final boolean traverseAtGranularity(SemanticsNode arg13, int arg14, boolean arg15, boolean arg16) {
        int v0 = arg13.getId();
        Integer v1 = this.previousTraversedNode;
        int v2 = -1;
        if(v1 == null || v0 != v1.intValue()) {
            this.accessibilityCursorPosition = v2;
            this.previousTraversedNode = Integer.valueOf(arg13.getId());
        }

        String v0_1 = this.getIterableTextForAccessibility(arg13);
        String v1_1 = v0_1;
        if(v1_1 != null) {
            if(((CharSequence)v1_1).length() == 0) {
            }
            else {
                TextSegmentIterator v1_2 = this.getIteratorForGranularity(arg13, arg14);
                if(v1_2 == null) {
                    return 0;
                }
                else {
                    int v4 = this.getAccessibilitySelectionEnd(arg13);
                    if(v4 == v2) {
                        v4 = arg15 ? 0 : v0_1.length();
                    }

                    int[] v0_2 = arg15 ? v1_2.following(v4) : v1_2.preceding(v4);
                    if(v0_2 == null) {
                        return 0;
                    }

                    int v8 = v0_2[0];
                    int v9 = v0_2[1];
                    if(!arg16 || !this.isAccessibilitySelectionExtendable(arg13)) {
                        v0 = arg15 ? v9 : v8;
                        v2 = v0;
                    }
                    else {
                        v0 = this.getAccessibilitySelectionStart(arg13);
                        if(v0 == v2) {
                            v0 = arg15 ? v8 : v9;
                        }

                        if(arg15) {
                            v2 = v9;
                            goto label_56;
                        }

                        v2 = v8;
                    }

                label_56:
                    int v15 = arg15 ? 0x100 : 0x200;
                    this.pendingTextTraversedEvent = new PendingTextTraversedEvent(arg13, v15, arg14, v8, v9, SystemClock.uptimeMillis());
                    this.setAccessibilitySelection(arg13, v0, v2, true);
                    return 1;
                }
            }
        }

        return 0;
    }

    private final CharSequence trimToSize(CharSequence arg2, int arg3) {
        if(arg3 > 0) {
            if(arg2 != null) {
                if(arg2.length() == 0) {
                }
                else if(arg2.length() <= arg3) {
                    return arg2;
                }
                else {
                    int v1 = arg3 - 1;
                    if((Character.isHighSurrogate(arg2.charAt(v1))) && (Character.isLowSurrogate(arg2.charAt(arg3)))) {
                        arg3 = v1;
                    }

                    CharSequence v1_1 = arg2.subSequence(0, arg3);
                    Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
                    return v1_1;
                }
            }

            return arg2;
        }

        throw new IllegalArgumentException("size should be greater than 0".toString());
    }

    private final void updateHoveredVirtualView(int arg10) {
        int v1 = this.hoveredVirtualViewId;
        if(v1 == arg10) {
            return;
        }

        this.hoveredVirtualViewId = arg10;
        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, arg10, 0x80, null, null, 12, null);
        AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(this, v1, 0x100, null, null, 12, null);
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        String v8_3;
        long v22;
        long v20;
        int v5_1;
        int v4;
        int v15;
        AndroidComposeViewAccessibilityDelegateCompat v0 = this;
        MutableIntSet v1 = new MutableIntSet(0, 1, null);
        MutableIntSet v3 = v0.paneDisplayed;
        int[] v5 = ((IntSet)v3).elements;
        long[] v3_1 = ((IntSet)v3).metadata;
        int v6 = v3_1.length - 2;
        long v7 = 0x80;
        long v9 = 0xFF;
        int v11 = 7;
        long v12 = -9187201950435737472L;
        int v14 = 8;
        if(v6 >= 0) {
            v15 = 0;
            long[] v16 = v3_1;
            while(true) {
                long v2 = v16[v15];
                int[] v18 = v5;
                if((~v2 << v11 & v2 & v12) != v12) {
                    v4 = 8 - (~(v15 - v6) >>> 0x1F);
                    v5_1 = 0;
                    while(v5_1 < v4) {
                        if((v2 & v9) < v7) {
                            v20 = v7;
                            int v7_1 = v18[(v15 << 3) + v5_1];
                            Object v8 = v0.getCurrentSemanticsNodes().get(v7_1);
                            SemanticsNode v8_1 = v8 != null ? ((SemanticsNodeWithAdjustedBounds)v8).getSemanticsNode() : null;
                            if(v8_1 != null) {
                                v22 = v9;
                                if(!v8_1.getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                }
                                else {
                                    goto label_69;
                                }
                            }
                            else {
                                v22 = v9;
                            }

                            v1.add(v7_1);
                            v8 = v0.previousSemanticsNodes.get(v7_1);
                            if(v8 != null) {
                                SemanticsConfiguration v8_2 = ((SemanticsNodeCopy)v8).getUnmergedConfig();
                                if(v8_2 != null) {
                                    v8 = SemanticsConfigurationKt.getOrNull(v8_2, SemanticsProperties.INSTANCE.getPaneTitle());
                                }
                                else {
                                    goto label_63;
                                }
                            }
                            else {
                            label_63:
                                v8_3 = null;
                            }

                            v0.sendPaneChangeEvents(v7_1, 0x20, v8_3);
                        }
                        else {
                            v20 = v7;
                            v22 = v9;
                        }

                    label_69:
                        v2 >>= v14;
                        ++v5_1;
                        v7 = v20;
                        v9 = v22;
                    }

                    v20 = v7;
                    v22 = v9;
                    if(v4 != v14) {
                        break;
                    }
                }
                else {
                    v20 = v7;
                    v22 = v9;
                }

                if(v15 == v6) {
                    break;
                }

                ++v15;
                v5 = v18;
                v7 = v20;
                v9 = v22;
            }
        }
        else {
            v20 = v7;
            v22 = v9;
        }

        v0.paneDisplayed.removeAll(((IntSet)v1));
        v0.previousSemanticsNodes.clear();
        IntObjectMap v1_1 = v0.getCurrentSemanticsNodes();
        int[] v2_1 = v1_1.keys;
        Object[] v3_2 = v1_1.values;
        long[] v1_2 = v1_1.metadata;
        v4 = v1_2.length - 2;
        if(v4 >= 0) {
            v5_1 = 0;
            while(true) {
                long v6_1 = v1_2[v5_1];
                if((~v6_1 << v11 & v6_1 & v12) != v12) {
                    int v8_4 = 8 - (~(v5_1 - v4) >>> 0x1F);
                    int v9_1;
                    for(v9_1 = 0; v9_1 < v8_4; ++v9_1) {
                        if((v6_1 & v22) < v20) {
                            int v10 = (v5_1 << 3) + v9_1;
                            v15 = v2_1[v10];
                            Object v10_1 = v3_2[v10];
                            if((((SemanticsNodeWithAdjustedBounds)v10_1).getSemanticsNode().getUnmergedConfig$ui().contains(SemanticsProperties.INSTANCE.getPaneTitle())) && (v0.paneDisplayed.add(v15))) {
                                v0.sendPaneChangeEvents(v15, 16, ((SemanticsNodeWithAdjustedBounds)v10_1).getSemanticsNode().getUnmergedConfig$ui().get(SemanticsProperties.INSTANCE.getPaneTitle()));
                            }

                            v0.previousSemanticsNodes.set(v15, new SemanticsNodeCopy(((SemanticsNodeWithAdjustedBounds)v10_1).getSemanticsNode(), v0.getCurrentSemanticsNodes()));
                        }

                        v6_1 >>= v14;
                    }

                    if(v8_4 != v14) {
                        break;
                    }
                }

                if(v5_1 == v4) {
                    break;
                }

                ++v5_1;
                v11 = 7;
                v12 = -9187201950435737472L;
            }
        }

        v0.previousSemanticsRoot = new SemanticsNodeCopy(v0.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), v0.getCurrentSemanticsNodes());
    }
}

