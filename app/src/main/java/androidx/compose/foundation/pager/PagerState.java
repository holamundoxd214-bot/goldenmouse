package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ScrollIndicatorState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002wz\b\'\u0018\u00002\u00020\u0001B)\b\u0000\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u001D\b\u0016\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\u0010\u00100\u001A\u00020\u00052\u0006\u00101\u001A\u00020\u0005H\u0002J\b\u0010|\u001A\u00020\u0003H\u0002J%\u0010§\u0001\u001A\u00030¨\u00012\u0007\u0010©\u0001\u001A\u00020\u00032\t\b\u0003\u0010ª\u0001\u001A\u00020\u0005H\u0086@¢\u0006\u0003\u0010«\u0001J!\u0010¬\u0001\u001A\u00030¨\u0001*\u00030­\u00012\u0007\u0010©\u0001\u001A\u00020\u00032\t\b\u0003\u0010ª\u0001\u001A\u00020\u0005J\u0015\u0010®\u0001\u001A\u00030¨\u0001*\u00030­\u00012\u0006\u0010n\u001A\u00020\u0003J+\u0010¯\u0001\u001A\u00030¨\u00012\u0007\u0010©\u0001\u001A\u00020\u00032\u0007\u0010°\u0001\u001A\u00020\u00052\u0007\u0010±\u0001\u001A\u00020\fH\u0000¢\u0006\u0003\b²\u0001J\u001E\u0010µ\u0001\u001A\u00030¨\u00012\t\b\u0001\u0010©\u0001\u001A\u00020\u00032\t\b\u0003\u0010ª\u0001\u001A\u00020\u0005J7\u0010¶\u0001\u001A\u00030¨\u00012\u0007\u0010©\u0001\u001A\u00020\u00032\t\b\u0003\u0010ª\u0001\u001A\u00020\u00052\u0010\b\u0002\u0010·\u0001\u001A\t\u0012\u0004\u0012\u00020\u00050¸\u0001H\u0086@¢\u0006\u0003\u0010¹\u0001J\u0011\u0010º\u0001\u001A\u00030¨\u0001H\u0082@¢\u0006\u0003\u0010»\u0001JK\u0010¼\u0001\u001A\u00030¨\u00012\b\u0010½\u0001\u001A\u00030¾\u00012.\u0010¿\u0001\u001A)\b\u0001\u0012\u0005\u0012\u00030­\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030¨\u00010Á\u0001\u0012\u0007\u0012\u0005\u0018\u00010Â\u00010À\u0001¢\u0006\u0003\bÃ\u0001H\u0096@¢\u0006\u0003\u0010Ä\u0001J\u0011\u0010Å\u0001\u001A\u00020\u00052\u0006\u00101\u001A\u00020\u0005H\u0016J-\u0010Ù\u0001\u001A\u00030¨\u00012\u0007\u0010Ú\u0001\u001A\u00020\u00102\u0007\u0010Û\u0001\u001A\u00020\f2\t\b\u0002\u0010Ü\u0001\u001A\u00020\fH\u0000¢\u0006\u0003\bÝ\u0001J\u0013\u0010Þ\u0001\u001A\u00030¨\u00012\u0007\u0010Ú\u0001\u001A\u00020\u0010H\u0002J\r\u0010ß\u0001\u001A\u00020\u0003*\u00020\u0003H\u0002J\u0012\u0010à\u0001\u001A\u00020\f2\u0007\u0010á\u0001\u001A\u00020\u0005H\u0002J\u000F\u0010â\u0001\u001A\u00020\fH\u0000¢\u0006\u0003\bã\u0001J\u001B\u0010ä\u0001\u001A\u00030¨\u00012\u0006\u00101\u001A\u00020\u00052\u0007\u0010å\u0001\u001A\u00020BH\u0002J\u0013\u0010æ\u0001\u001A\u00030¨\u00012\u0007\u0010å\u0001\u001A\u00020BH\u0002J\u001B\u0010ç\u0001\u001A\u00020\u00032\u0007\u0010è\u0001\u001A\u00020\f2\u0007\u0010å\u0001\u001A\u00020BH\u0002J\u0010\u0010é\u0001\u001A\u00020\u00052\u0007\u0010©\u0001\u001A\u00020\u0003J#\u0010ê\u0001\u001A\u00020\u00032\b\u0010ë\u0001\u001A\u00030ì\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0000¢\u0006\u0003\bí\u0001R\u001E\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\f@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\"\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\u0010@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u00188@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u000E\u0010 \u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\"\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u0003@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u0016R\u001E\u0010$\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u0003@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b%\u0010\u0016R\u001A\u0010&\u001A\u00020\'X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010\u001B\"\u0004\b)\u0010\u001DR\u001A\u0010*\u001A\u00020\'X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b+\u0010\u001B\"\u0004\b,\u0010\u001DR\u000E\u0010-\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001A\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b3\u0010\u0016R\u001E\u00104\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u0003@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b5\u0010\u0016R\u000E\u00106\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u00107\u001A\u00020\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b8\u0010\u000F\"\u0004\b9\u0010:R\u000E\u0010;\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010<\u001A\u0004\u0018\u00010=X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010>\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010?\u001A\b\u0012\u0004\u0012\u00020\u00100@X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010A\u001A\u00020B8F¢\u0006\u0006\u001A\u0004\bC\u0010DR\u0014\u0010E\u001A\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bF\u0010\u0016R\u0014\u0010G\u001A\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bH\u0010\u0016R\u001A\u0010I\u001A\u00020JX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010O\u001A\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bP\u0010\u0016R\u001A\u0010Q\u001A\u00020\u0003X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bR\u0010\u0016\"\u0004\bS\u0010TR\u0014\u0010U\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bV\u0010WR\u0014\u0010X\u001A\u00020YX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bZ\u0010[R\u0011\u0010\\\u001A\u00020]8F¢\u0006\u0006\u001A\u0004\b^\u0010_R\u0011\u0010\u0002\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b`\u0010\u0016R+\u0010a\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bd\u0010e\u001A\u0004\bb\u0010\u0016\"\u0004\bc\u0010TR+\u0010f\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bi\u0010e\u001A\u0004\bg\u0010\u0016\"\u0004\bh\u0010TR\u001B\u0010j\u001A\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010m\u001A\u0004\bk\u0010\u0016R\u001B\u0010n\u001A\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bp\u0010m\u001A\u0004\bo\u0010\u0016R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\bq\u0010WR\u0014\u0010r\u001A\u00020sX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bt\u0010uR\u0010\u0010v\u001A\u00020wX\u0082\u0004¢\u0006\u0004\n\u0002\u0010xR\u0010\u0010y\u001A\u00020zX\u0082\u0004¢\u0006\u0004\n\u0002\u0010{R\u0015\u0010}\u001A\u00020~X\u0080\u0004¢\u0006\t\n\u0000\u001A\u0005\b\u007F\u0010\u0080\u0001R\u0018\u0010\u0081\u0001\u001A\u00030\u0082\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0085\u0001\u001A\u00030\u0086\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0087\u0001\u0010\u0088\u0001R7\u0010\u008A\u0001\u001A\u0005\u0018\u00010\u0089\u00012\t\u0010\u0017\u001A\u0005\u0018\u00010\u0089\u00018@@BX\u0080\u008E\u0002¢\u0006\u0017\n\u0005\b\u008F\u0001\u0010\u001F\u001A\u0006\b\u008B\u0001\u0010\u008C\u0001\"\u0006\b\u008D\u0001\u0010\u008E\u0001R\u0018\u0010\u0090\u0001\u001A\u00030\u0091\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0092\u0001\u0010\u0093\u0001R!\u0010\u0094\u0001\u001A\u00030\u0095\u0001X\u0080\u000E¢\u0006\u0013\n\u0003\u0010\u0098\u0001\u001A\u0005\b\u0096\u0001\u0010\u001B\"\u0005\b\u0097\u0001\u0010\u001DR\u0018\u0010\u0099\u0001\u001A\u00030\u009A\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u009B\u0001\u0010\u009C\u0001R!\u0010\u009D\u0001\u001A\u00030\u009E\u00018@X\u0080\u0084\u0002¢\u0006\u0010\u001A\u0006\b¡\u0001\u0010¢\u0001*\u0006\b\u009F\u0001\u0010 \u0001R\u001A\u0010£\u0001\u001A\u00030¤\u0001X\u0080\u0004¢\u0006\f\n\u0002\u0010\u001F\u001A\u0006\b¥\u0001\u0010¦\u0001R\u001A\u0010³\u0001\u001A\u00030¤\u0001X\u0080\u0004¢\u0006\f\n\u0002\u0010\u001F\u001A\u0006\b´\u0001\u0010¦\u0001R\u0016\u0010Æ\u0001\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\bÆ\u0001\u0010\u000FR/\u0010Ç\u0001\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\f8F@BX\u0086\u008E\u0002¢\u0006\u0015\n\u0005\bÊ\u0001\u0010\u001F\u001A\u0005\bÈ\u0001\u0010\u000F\"\u0005\bÉ\u0001\u0010:R/\u0010Ë\u0001\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\f8F@BX\u0086\u008E\u0002¢\u0006\u0015\n\u0005\bÎ\u0001\u0010\u001F\u001A\u0005\bÌ\u0001\u0010\u000F\"\u0005\bÍ\u0001\u0010:R\u0015\u0010Ï\u0001\u001A\b\u0012\u0004\u0012\u00020\f0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010Ð\u0001\u001A\b\u0012\u0004\u0012\u00020\f0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Ñ\u0001\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\bÒ\u0001\u0010\u000FR\u0016\u0010Ó\u0001\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\bÔ\u0001\u0010\u000FR\u001A\u0010Õ\u0001\u001A\u0005\u0018\u00010Ö\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b×\u0001\u0010Ø\u0001¨\u0006î\u0001"}, d2={"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "currentPage", "", "currentPageOffsetFraction", "", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "<init>", "(IFLandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "(IF)V", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation", "()Z", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "pageCount", "getPageCount", "()I", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "upDownDifference", "getUpDownDifference-F1C5BW0$foundation", "()J", "setUpDownDifference-k-4lQ0M$foundation", "(J)V", "upDownDifference$delegate", "Landroidx/compose/runtime/MutableState;", "scrollPosition", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "firstVisiblePage", "getFirstVisiblePage$foundation", "firstVisiblePageOffset", "getFirstVisiblePageOffset$foundation", "maxScrollOffset", "", "getMaxScrollOffset$foundation", "setMaxScrollOffset$foundation", "minScrollOffset", "getMinScrollOffset$foundation", "setMinScrollOffset$foundation", "accumulator", "previousPassDelta", "scrollableState", "performScroll", "delta", "numMeasurePasses", "getNumMeasurePasses$foundation", "layoutWithMeasurement", "getLayoutWithMeasurement$foundation", "layoutWithoutMeasurement", "prefetchingEnabled", "getPrefetchingEnabled$foundation", "setPrefetchingEnabled$foundation", "(Z)V", "indexToPrefetch", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasPrefetchingForward", "pagerLayoutInfoState", "Landroidx/compose/runtime/MutableState;", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "pageSpacing", "getPageSpacing$foundation", "pageSize", "getPageSize$foundation", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation", "(Landroidx/compose/ui/unit/Density;)V", "pageSizeWithSpacing", "getPageSizeWithSpacing$foundation", "latestPageSizeWithSpacing", "getLatestPageSizeWithSpacing$foundation", "setLatestPageSizeWithSpacing$foundation", "(I)V", "positionThresholdFraction", "getPositionThresholdFraction$foundation", "()F", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "getCurrentPage", "programmaticScrollTargetPage", "getProgrammaticScrollTargetPage", "setProgrammaticScrollTargetPage", "programmaticScrollTargetPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "settledPageState", "getSettledPageState", "setSettledPageState", "settledPageState$delegate", "settledPage", "getSettledPage", "settledPage$delegate", "Landroidx/compose/runtime/State;", "targetPage", "getTargetPage", "targetPage$delegate", "getCurrentPageOffsetFraction", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "pagerCacheWindow", "androidx/compose/foundation/pager/PagerState$pagerCacheWindow$1", "Landroidx/compose/foundation/pager/PagerState$pagerCacheWindow$1;", "_scrollIndicatorState", "androidx/compose/foundation/pager/PagerState$_scrollIndicatorState$1", "Landroidx/compose/foundation/pager/PagerState$_scrollIndicatorState$1;", "calculateScrollOffset", "cacheWindowLogic", "Landroidx/compose/foundation/pager/PagerCacheWindowLogic;", "getCacheWindowLogic$foundation", "()Landroidx/compose/foundation/pager/PagerCacheWindowLogic;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "premeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "getPremeasureConstraints-msEJaDk$foundation", "setPremeasureConstraints-BRTryo0$foundation", "J", "pinnedPages", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedPages$foundation", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation$delegate", "(Landroidx/compose/foundation/pager/PagerState;)Ljava/lang/Object;", "getNearestRange$foundation", "()Lkotlin/ranges/IntRange;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation", "()Landroidx/compose/runtime/MutableState;", "scrollToPage", "", "page", "pageOffsetFraction", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCurrentPage", "Landroidx/compose/foundation/gestures/ScrollScope;", "updateTargetPage", "snapToItem", "offsetFraction", "forceRemeasure", "snapToItem$foundation", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation", "requestScrollToPage", "animateScrollToPage", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitScrollDependencies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "isScrollInProgress", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "isLastScrollForwardState", "isLastScrollBackwardState", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "scrollIndicatorState", "Landroidx/compose/foundation/ScrollIndicatorState;", "getScrollIndicatorState", "()Landroidx/compose/foundation/ScrollIndicatorState;", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation", "tryRunPrefetch", "coerceInPageRange", "isGestureActionMatchesScroll", "scrollDelta", "isNotGestureAction", "isNotGestureAction$foundation", "notifyPrefetch", "info", "cancelPrefetchIfVisibleItemsChanged", "calculatePrefetchIndex", "forward", "getOffsetDistanceInPages", "matchScrollPositionWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "matchScrollPositionWithKey$foundation", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class PagerState implements ScrollableState {
    public static final int $stable;
    private final PagerState$_scrollIndicatorState$1 _scrollIndicatorState;
    private float accumulator;
    private PagerMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final PagerCacheWindowLogic cacheWindowLogic;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int firstVisiblePage;
    private int firstVisiblePageOffset;
    private boolean hasLookaheadOccurred;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState isLastScrollBackwardState;
    private final MutableState isLastScrollForwardState;
    private int latestPageSizeWithSpacing;
    private int layoutWithMeasurement;
    private int layoutWithoutMeasurement;
    private long maxScrollOffset;
    private final MutableState measurementScopeInvalidator;
    private long minScrollOffset;
    private final PagerState$pagerCacheWindow$1 pagerCacheWindow;
    private MutableState pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final MutableState placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private float previousPassDelta;
    private final MutableIntState programmaticScrollTargetPage$delegate;
    private final MutableState remeasurement$delegate;
    private final RemeasurementModifier remeasurementModifier;
    private final PagerScrollPosition scrollPosition;
    private final ScrollableState scrollableState;
    private final State settledPage$delegate;
    private final MutableIntState settledPageState$delegate;
    private final State targetPage$delegate;
    private final MutableState upDownDifference$delegate;
    private boolean wasPrefetchingForward;

    static {
    }

    public PagerState() {
        this(0, 0f, null, 7, null);
    }

    public PagerState(int arg1, float arg2, PrefetchScheduler arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(0, 0f, arg3);
    }

    public PagerState(int arg2, float arg3) {
        this(arg2, arg3, null);
    }

    public PagerState(int arg13, float arg14, PrefetchScheduler arg15) {
        super();
        double v0 = ((double)arg14);
        int v2 = Double.compare(-0.5, v0);
        int v4 = 0;
        Boolean v5 = Boolean.valueOf(false);
        if(v2 <= 0 && v0 <= 0.5) {
            v4 = 1;
        }

        if(v4 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("currentPageOffsetFraction " + arg14 + " is not within the range -0.5 to 0.5");
        }

        this.upDownDifference$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), null, 2, null);
        PagerScrollPosition v0_1 = new PagerScrollPosition(arg13, arg14, this);
        this.scrollPosition = v0_1;
        this.firstVisiblePage = arg13;
        this.maxScrollOffset = 0x7FFFFFFFFFFFFFFFL;
        this.scrollableState = ScrollableStateKt.ScrollableState(new PagerState$$ExternalSyntheticLambda0(this));
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.pagerLayoutInfoState = SnapshotStateKt.mutableStateOf(PagerStateKt.getEmptyLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this.density = PagerStateKt.access$getUnitDensity$p();
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.programmaticScrollTargetPage$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
        this.settledPageState$delegate = SnapshotIntStateKt.mutableIntStateOf(arg13);
        this.settledPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$$ExternalSyntheticLambda1(this));
        this.targetPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new PagerState$$ExternalSyntheticLambda2(this));
        LazyLayoutPrefetchState v13 = new LazyLayoutPrefetchState(arg15, new PagerState$$ExternalSyntheticLambda3(this));
        this.prefetchState = v13;
        PagerState$pagerCacheWindow$1 v14 = new PagerState$pagerCacheWindow$1(this);
        this.pagerCacheWindow = v14;
        this._scrollIndicatorState = new PagerState$_scrollIndicatorState$1(this);
        this.cacheWindowLogic = new PagerCacheWindowLogic(((LazyLayoutCacheWindow)v14), v13, new PagerState$$ExternalSyntheticLambda4(this));
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.remeasurement$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.remeasurementModifier = new PagerState$remeasurementModifier$1(this);
        this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.pinnedPages = new LazyLayoutPinnedItemList();
        v0_1.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.constructor-impl$default(null, 1, null);
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(v5, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(v5, null, 2, null);
        this.isLastScrollForwardState = SnapshotStateKt.mutableStateOf$default(v5, null, 2, null);
        this.isLastScrollBackwardState = SnapshotStateKt.mutableStateOf$default(v5, null, 2, null);
    }

    public PagerState(int arg1, float arg2, int arg3, DefaultConstructorMarker arg4) {
        this(0, 0f);
    }

    public static final Object access$awaitScrollDependencies(PagerState arg0, Continuation arg1) {
        return arg0.awaitScrollDependencies(arg1);
    }

    public static final int access$calculateScrollOffset(PagerState arg0) {
        return arg0.calculateScrollOffset();
    }

    public static final int access$coerceInPageRange(PagerState arg0, int arg1) {
        return arg0.coerceInPageRange(arg1);
    }

    public static final void access$setRemeasurement(PagerState arg0, Remeasurement arg1) {
        arg0.setRemeasurement(arg1);
    }

    public final Object animateScrollToPage(int arg12, float arg13, AnimationSpec arg14, Continuation arg15) {
        Object v14;
        int v2;
        Continuation v0;
        if((arg15 instanceof PagerState$animateScrollToPage$1)) {
            v0 = arg15;
            v2 = 0x80000000;
            if((((PagerState$animateScrollToPage$1)v0).label & v2) != 0) {
                ((PagerState$animateScrollToPage$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            PagerState$animateScrollToPage$1 v0_1 = new PagerState$animateScrollToPage$1(this, arg15);
        }

        Continuation v4 = v0;
        Object v15 = ((PagerState$animateScrollToPage$1)v4).result;
        Object v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((PagerState$animateScrollToPage$1)v4).label;
        v2 = 2;
        int v3 = 1;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v15);
            if(arg12 != this.getCurrentPage() || this.getCurrentPageOffsetFraction() != arg13) {
                if(this.getPageCount() == 0) {
                    goto label_42;
                }

                goto label_44;
            }
            else {
            }

        label_42:
            return Unit.INSTANCE;
        label_44:
            ((PagerState$animateScrollToPage$1)v4).L$0 = arg14;
            ((PagerState$animateScrollToPage$1)v4).I$0 = arg12;
            ((PagerState$animateScrollToPage$1)v4).F$0 = arg13;
            ((PagerState$animateScrollToPage$1)v4).label = 1;
            if(this.awaitScrollDependencies(v4) != v0_2) {
            label_32:
                AnimationSpec v9 = ((AnimationSpec)v14);
                double v14_1 = ((double)arg13);
                if(Double.compare(-0.5, v14_1) > 0 || v14_1 > 0.5) {
                    v3 = 0;
                }
                else {
                }

                if(v3 == 0) {
                    InlineClassHelperKt.throwIllegalArgumentException("pageOffsetFraction " + arg13 + " is not within the range -0.5 to 0.5");
                }

                PagerState$animateScrollToPage$3 v3_1 = new PagerState$animateScrollToPage$3(this, this.coerceInPageRange(arg12), arg13 * (((float)this.getPageSizeWithSpacing$foundation())), v9, null);
                ((PagerState$animateScrollToPage$1)v4).L$0 = null;
                ((PagerState$animateScrollToPage$1)v4).label = v2;
                if(ScrollableState.scroll$default(this, null, ((Function2)v3_1), v4, 1, null) != v0_2) {
                    goto label_88;
                }
            }

            return v0_2;
        }
        else if(v1 == 1) {
            arg13 = ((PagerState$animateScrollToPage$1)v4).F$0;
            arg12 = ((PagerState$animateScrollToPage$1)v4).I$0;
            v14 = ((PagerState$animateScrollToPage$1)v4).L$0;
            ResultKt.throwOnFailure(v15);
            goto label_32;
        }
        else if(v1 == v2) {
            ResultKt.throwOnFailure(v15);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_88:
        return Unit.INSTANCE;
    }

    public static Object animateScrollToPage$default(PagerState arg1, int arg2, float arg3, AnimationSpec arg4, Continuation arg5, int arg6, Object arg7) {
        SpringSpec v4;
        if(arg7 == null) {
            if((arg6 & 4) != 0) {
                v4 = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
            }

            return arg1.animateScrollToPage(arg2, 0f, ((AnimationSpec)v4), arg5);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
    }

    public final void applyMeasureResult$foundation(PagerMeasureResult arg3, boolean arg4, boolean arg5) {
        this.prefetchState.setIdealNestedPrefetchCount$foundation(arg3.getVisiblePagesInfo().size());
        this.latestPageSizeWithSpacing = arg3.getPageSize() + arg3.getPageSpacing();
        if(!arg4 && (this.hasLookaheadOccurred)) {
            this.approachLayoutInfo = arg3;
            return;
        }

        if(arg4) {
            this.hasLookaheadOccurred = true;
        }

        PagerScrollPosition v4 = this.scrollPosition;
        if(arg5) {
            v4.updateCurrentPageOffsetFraction(arg3.getCurrentPageOffsetFraction());
        }
        else {
            v4.updateFromMeasureResult(arg3);
            if(!ComposeFoundationFlags.isCacheWindowForPagerEnabled) {
                this.cancelPrefetchIfVisibleItemsChanged(arg3);
            }
            else if(this.prefetchingEnabled) {
                this.cacheWindowLogic.onVisibleItemsChanged(arg3);
            }
        }

        this.pagerLayoutInfoState.setValue(arg3);
        this.setCanScrollForward(arg3.getCanScrollForward());
        this.setCanScrollBackward(arg3.getCanScrollBackward());
        MeasuredPage v4_1 = arg3.getFirstVisiblePage();
        if(v4_1 != null) {
            this.firstVisiblePage = v4_1.getIndex();
        }

        this.firstVisiblePageOffset = arg3.getFirstVisiblePageScrollOffset();
        this.tryRunPrefetch(arg3);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset(arg3, this.getPageCount());
        this.minScrollOffset = RangesKt.coerceAtMost(PagerStateKt.access$calculateNewMinScrollOffset(arg3, this.getPageCount()), this.maxScrollOffset);
    }

    public static void applyMeasureResult$foundation$default(PagerState arg0, PagerMeasureResult arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            arg0.applyMeasureResult$foundation(arg1, arg2, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
    }

    private final Object awaitScrollDependencies(Continuation arg3) {
        if(this.pagerLayoutInfoState.getValue() == PagerStateKt.getEmptyLayoutInfo()) {
            Object v2 = this.awaitLayoutModifier.waitForFirstLayout(arg3);
            if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v2;
            }

            return Unit.INSTANCE;
        }

        return Unit.INSTANCE;
    }

    static final int cacheWindowLogic$lambda$0(PagerState arg0) {
        return arg0.getPageCount();
    }

    private final int calculatePrefetchIndex(boolean arg1, PagerLayoutInfo arg2) {
        if(arg1) {
            int v0 = arg2.getBeyondViewportPageCount() + 1;
            if(v0 < 0) {
                return 0x7FFFFFFF;
            }

            return CollectionsKt.last(arg2.getVisiblePagesInfo()).getIndex() + v0;
        }

        return CollectionsKt.first(arg2.getVisiblePagesInfo()).getIndex() - arg2.getBeyondViewportPageCount() - 1;
    }

    private final int calculateScrollOffset() {
        long v0 = (((long)this.getPageSizeWithSpacing$foundation())) * (((long)this.firstVisiblePage)) + (((long)this.firstVisiblePageOffset));
        long v2 = 0x7FFFFFFF;
        if(v0 > v2) {
            v0 = v2;
        }

        return ((int)v0);
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo arg3) {
        int v1 = -1;
        if(this.indexToPrefetch != v1 && !arg3.getVisiblePagesInfo().isEmpty() && this.indexToPrefetch != this.calculatePrefetchIndex(this.wasPrefetchingForward, arg3)) {
            this.indexToPrefetch = v1;
            PrefetchHandle v3 = this.currentPrefetchHandle;
            if(v3 != null) {
                v3.cancel();
            }

            this.currentPrefetchHandle = null;
        }
    }

    private final int coerceInPageRange(int arg3) {
        if(this.getPageCount() > 0) {
            return RangesKt.coerceIn(arg3, 0, this.getPageCount() - 1);
        }

        return 0;
    }

    public float dispatchRawDelta(float arg1) {
        return this.scrollableState.dispatchRawDelta(arg1);
    }

    public final PagerMeasureResult getApproachLayoutInfo$foundation() {
        return this.approachLayoutInfo;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation() {
        return this.awaitLayoutModifier;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation() {
        return this.beyondBoundsInfo;
    }

    public final PagerCacheWindowLogic getCacheWindowLogic$foundation() {
        return this.cacheWindowLogic;
    }

    public final boolean getCanScrollBackward() {
        return this.canScrollBackward$delegate.getValue().booleanValue();
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward$delegate.getValue().booleanValue();
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.getCurrentPageOffsetFraction();
    }

    public final Density getDensity$foundation() {
        return this.density;
    }

    public final int getFirstVisiblePage$foundation() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageOffset$foundation() {
        return this.firstVisiblePageOffset;
    }

    public final boolean getHasLookaheadOccurred$foundation() {
        return this.hasLookaheadOccurred;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation() {
        return this.internalInteractionSource;
    }

    public boolean getLastScrolledBackward() {
        return this.isLastScrollBackwardState.getValue().booleanValue();
    }

    public boolean getLastScrolledForward() {
        return this.isLastScrollForwardState.getValue().booleanValue();
    }

    public final int getLatestPageSizeWithSpacing$foundation() {
        return this.latestPageSizeWithSpacing;
    }

    public final PagerLayoutInfo getLayoutInfo() {
        return this.pagerLayoutInfoState.getValue();
    }

    public final int getLayoutWithMeasurement$foundation() {
        return this.layoutWithMeasurement;
    }

    public final long getMaxScrollOffset$foundation() {
        return this.maxScrollOffset;
    }

    public final MutableState getMeasurementScopeInvalidator-zYiylxw$foundation() {
        return this.measurementScopeInvalidator;
    }

    public final long getMinScrollOffset$foundation() {
        return this.minScrollOffset;
    }

    public final IntRange getNearestRange$foundation() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    private static Object getNearestRange$foundation$delegate(PagerState arg0) {
        return arg0.scrollPosition.getNearestRangeState();
    }

    public final int getNumMeasurePasses$foundation() {
        return this.layoutWithMeasurement + this.layoutWithoutMeasurement;
    }

    public final float getOffsetDistanceInPages(int arg3) {
        int v0 = 0;
        if(arg3 >= 0 && arg3 <= this.getPageCount()) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("page " + arg3 + " is not within the range 0 to " + this.getPageCount());
        }

        return (((float)(arg3 - this.getCurrentPage()))) - this.getCurrentPageOffsetFraction();
    }

    public abstract int getPageCount();

    public final int getPageSize$foundation() {
        return this.pagerLayoutInfoState.getValue().getPageSize();
    }

    public final int getPageSizeWithSpacing$foundation() {
        return this.getPageSize$foundation() + this.getPageSpacing$foundation();
    }

    public final int getPageSpacing$foundation() {
        return this.pagerLayoutInfoState.getValue().getPageSpacing();
    }

    public final LazyLayoutPinnedItemList getPinnedPages$foundation() {
        return this.pinnedPages;
    }

    public final MutableState getPlacementScopeInvalidator-zYiylxw$foundation() {
        return this.placementScopeInvalidator;
    }

    public final float getPositionThresholdFraction$foundation() {
        return Math.min(this.density.toPx-0680j_4(PagerStateKt.getDefaultPositionThreshold()), (((float)this.getPageSize$foundation())) / 2f) / (((float)this.getPageSize$foundation()));
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation() {
        return this.prefetchingEnabled;
    }

    public final long getPremeasureConstraints-msEJaDk$foundation() {
        return this.premeasureConstraints;
    }

    private final int getProgrammaticScrollTargetPage() {
        return this.programmaticScrollTargetPage$delegate.getIntValue();
    }

    public final Remeasurement getRemeasurement$foundation() {
        return this.remeasurement$delegate.getValue();
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation() {
        return this.remeasurementModifier;
    }

    public ScrollIndicatorState getScrollIndicatorState() {
        return this._scrollIndicatorState;
    }

    public final int getSettledPage() {
        return this.settledPage$delegate.getValue().intValue();
    }

    private final int getSettledPageState() {
        return this.settledPageState$delegate.getIntValue();
    }

    public final int getTargetPage() {
        return this.targetPage$delegate.getValue().intValue();
    }

    public final long getUpDownDifference-F1C5BW0$foundation() {
        return this.upDownDifference$delegate.getValue().unbox-impl();
    }

    private final boolean isGestureActionMatchesScroll(float arg5) {
        if(this.getLayoutInfo().getOrientation() == Orientation.Vertical) {
            if(Math.signum(arg5) == Math.signum(-Float.intBitsToFloat(((int)(this.getUpDownDifference-F1C5BW0$foundation() & 0xFFFFFFFFL))))) {
            }
            else {
                goto label_24;
            }
        }
        else if(Math.signum(arg5) == Math.signum(-Float.intBitsToFloat(((int)(this.getUpDownDifference-F1C5BW0$foundation() >> 0x20))))) {
        }
        else {
        label_24:
            if(this.isNotGestureAction$foundation()) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    public final boolean isNotGestureAction$foundation() {
        if((((int)Float.intBitsToFloat(((int)(this.getUpDownDifference-F1C5BW0$foundation() >> 0x20))))) == 0 && (((int)Float.intBitsToFloat(((int)(this.getUpDownDifference-F1C5BW0$foundation() & 0xFFFFFFFFL))))) == 0) {
            return 1;
        }

        return 0;
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final int matchScrollPositionWithKey$foundation(PagerLazyLayoutItemProvider arg1, int arg2) {
        return this.scrollPosition.matchPageWithKey(arg1, arg2);
    }

    public static int matchScrollPositionWithKey$foundation$default(PagerState arg2, PagerLazyLayoutItemProvider arg3, int arg4, int arg5, Object arg6) {
        int v1;
        if(arg6 == null) {
            if((arg5 & 2) != 0) {
                Companion v4 = Snapshot.Companion;
                Snapshot v5 = v4.getCurrentThreadSnapshot();
                Function1 v6 = v5 != null ? v5.getReadObserver() : null;
                Snapshot v0 = v4.makeCurrentNonObservable(v5);
                try {
                    v1 = arg2.scrollPosition.getCurrentPage();
                }
                catch(Throwable v2) {
                    v4.restoreNonObservable(v5, v0, v6);
                    throw v2;
                }

                v4.restoreNonObservable(v5, v0, v6);
                arg4 = v1;
            }

            return arg2.matchScrollPositionWithKey$foundation(arg3, arg4);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: matchScrollPositionWithKey");
    }

    private final void notifyPrefetch(float arg9, PagerLayoutInfo arg10) {
        PrefetchHandle v8;
        if(!this.prefetchingEnabled) {
        }
        else if(!arg10.getVisiblePagesInfo().isEmpty()) {
            boolean v0 = arg9 > 0f ? true : false;
            int v2 = this.calculatePrefetchIndex(v0, arg10);
            if(v2 < 0) {
                return;
            }

            if(v2 >= this.getPageCount()) {
                return;
            }

            if(v2 != this.indexToPrefetch) {
                if(this.wasPrefetchingForward != v0) {
                    PrefetchHandle v1 = this.currentPrefetchHandle;
                    if(v1 != null) {
                        v1.cancel();
                    }
                }

                this.wasPrefetchingForward = v0;
                this.indexToPrefetch = v2;
                this.currentPrefetchHandle = LazyLayoutPrefetchState.schedulePrecompositionAndPremeasure-VKLhPVY$default(this.prefetchState, v2, this.premeasureConstraints, null, 4, null);
            }

            if(v0) {
                if((((float)(CollectionsKt.last(arg10.getVisiblePagesInfo()).getOffset() + (arg10.getPageSize() + arg10.getPageSpacing()) - arg10.getViewportEndOffset()))) >= arg9) {
                    return;
                }

                v8 = this.currentPrefetchHandle;
                if(v8 == null) {
                    return;
                }

                v8.markAsUrgent();
                return;
            }

            if((((float)(arg10.getViewportStartOffset() - CollectionsKt.first(arg10.getVisiblePagesInfo()).getOffset()))) >= -arg9) {
                return;
            }

            v8 = this.currentPrefetchHandle;
            if(v8 == null) {
                return;
            }

            v8.markAsUrgent();
        }
    }

    private final float performScroll(float arg12) {
        Float v11_1;
        long v0 = PagerScrollPositionKt.currentAbsoluteScrollOffset(this);
        float v2 = this.accumulator + arg12;
        long v3 = MathKt.roundToLong(v2);
        this.accumulator = v2 - (((float)v3));
        if(Math.abs(arg12) < 0.0001f) {
            return arg12;
        }

        long v5 = v0 + v3;
        long v2_1 = RangesKt.coerceIn(v5, this.minScrollOffset, this.maxScrollOffset);
        int v4 = Long.compare(v5, v2_1);
        boolean v5_1 = false;
        v4 = v4 != 0 ? 1 : 0;
        v2_1 -= v0;
        float v0_1 = ((float)v2_1);
        this.previousPassDelta = v0_1;
        if(Math.abs(v2_1) != 0) {
            MutableState v1 = this.isLastScrollForwardState;
            boolean v8 = v0_1 > 0f ? true : false;
            v1.setValue(Boolean.valueOf(v8));
            v1 = this.isLastScrollBackwardState;
            if(v0_1 < 0f) {
                v5_1 = true;
            }

            v1.setValue(Boolean.valueOf(v5_1));
        }

        int v1_1 = ((int)v2_1);
        int v5_2 = -v1_1;
        PagerMeasureResult v0_2 = this.pagerLayoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(v5_2);
        if(v0_2 != null) {
            PagerMeasureResult v7 = this.approachLayoutInfo;
            if(v7 != null) {
                PagerMeasureResult v8_1 = null;
                PagerMeasureResult v5_3 = v7 != null ? v7.copyWithScrollDeltaWithoutRemeasure(v5_2) : v8_1;
                if(v5_3 != null) {
                    this.approachLayoutInfo = v5_3;
                    goto label_58;
                }

                v0_2 = v8_1;
            }
        }

    label_58:
        if(v0_2 != null) {
            this.applyMeasureResult$foundation(v0_2, this.hasLookaheadOccurred, true);
            ObservableScopeInvalidator.invalidateScope-impl(this.placementScopeInvalidator);
            ++this.layoutWithoutMeasurement;
        }
        else {
            this.scrollPosition.applyScrollDelta(v1_1);
            Remeasurement v0_3 = this.getRemeasurement$foundation();
            if(v0_3 != null) {
                v0_3.forceRemeasure();
            }

            ++this.layoutWithMeasurement;
        }

        if(v4 != 0) {
            Long v11 = Long.valueOf(v2_1);
        }
        else {
            v11_1 = Float.valueOf(arg12);
        }

        return ((Number)v11_1).floatValue();
    }

    static final Unit prefetchState$lambda$0(PagerState arg4, NestedPrefetchScope arg5) {
        Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        Function1 v2 = v1 != null ? v1.getReadObserver() : null;
        Snapshot v3 = v0.makeCurrentNonObservable(v1);
        try {
            arg5.schedulePrecomposition(arg4.firstVisiblePage);
        }
        catch(Throwable v4) {
            v0.restoreNonObservable(v1, v3, v2);
            throw v4;
        }

        v0.restoreNonObservable(v1, v3, v2);
        return Unit.INSTANCE;
    }

    public final void requestScrollToPage(int arg8, float arg9) {
        if(this.isScrollInProgress()) {
            BuildersKt.launch$default(this.pagerLayoutInfoState.getValue().getCoroutineScope(), null, null, new PagerState$requestScrollToPage$1(this, null), 3, null);
        }

        this.snapToItem$foundation(arg8, arg9, false);
    }

    public static void requestScrollToPage$default(PagerState arg0, int arg1, float arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            arg0.requestScrollToPage(arg1, 0f);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestScrollToPage");
    }

    public Object scroll(MutatePriority arg1, Function2 arg2, Continuation arg3) {
        return PagerState.scroll$suspendImpl(this, arg1, arg2, arg3);
    }

    static Object scroll$suspendImpl(PagerState arg5, MutatePriority arg6, Function2 arg7, Continuation arg8) {
        Object v5;
        int v2;
        Continuation v0;
        if((arg8 instanceof PagerState$scroll$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((PagerState$scroll$1)v0).label & v2) != 0) {
                ((PagerState$scroll$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            PagerState$scroll$1 v0_1 = new PagerState$scroll$1(arg5, arg8);
        }

        Object v8 = ((PagerState$scroll$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((PagerState$scroll$1)v0).label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            ((PagerState$scroll$1)v0).L$0 = arg5;
            ((PagerState$scroll$1)v0).L$1 = arg6;
            ((PagerState$scroll$1)v0).L$2 = arg7;
            ((PagerState$scroll$1)v0).label = 1;
            if(arg5.awaitScrollDependencies(v0) == v1) {
                return v1;
            }
            else {
            label_43:
                if(!((PagerState)v5).isScrollInProgress()) {
                    ((PagerState)v5).setSettledPageState(((PagerState)v5).getCurrentPage());
                }

                ScrollableState v8_1 = ((PagerState)v5).scrollableState;
                ((PagerState$scroll$1)v0).L$0 = v5;
                ((PagerState$scroll$1)v0).L$1 = null;
                ((PagerState$scroll$1)v0).L$2 = null;
                ((PagerState$scroll$1)v0).label = v3;
                if(v8_1.scroll(((MutatePriority)v6), ((Function2)v7), v0) != v1) {
                    goto label_56;
                }

                return v1;
            }
        }
        else if(v2 == 1) {
            Object v7 = ((PagerState$scroll$1)v0).L$2;
            Object v6 = ((PagerState$scroll$1)v0).L$1;
            v5 = ((PagerState$scroll$1)v0).L$0;
            ResultKt.throwOnFailure(v8);
            goto label_43;
        }
        else if(v2 == v3) {
            v5 = ((PagerState$scroll$1)v0).L$0;
            ResultKt.throwOnFailure(v8);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_56:
        ((PagerState)v5).setProgrammaticScrollTargetPage(-1);
        return Unit.INSTANCE;
    }

    public final Object scrollToPage(int arg7, float arg8, Continuation arg9) {
        Object v6 = ScrollableState.scroll$default(this, null, new PagerState$scrollToPage$2(this, arg8, arg7, null), arg9, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object scrollToPage$default(PagerState arg0, int arg1, float arg2, Continuation arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            return arg0.scrollToPage(arg1, 0f, arg3);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
    }

    static final float scrollableState$lambda$0(PagerState arg0, float arg1) {
        return arg0.performScroll(arg1);
    }

    private final void setCanScrollBackward(boolean arg1) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setCanScrollForward(boolean arg1) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setDensity$foundation(Density arg1) {
        this.density = arg1;
    }

    public final void setLatestPageSizeWithSpacing$foundation(int arg1) {
        this.latestPageSizeWithSpacing = arg1;
    }

    public final void setMaxScrollOffset$foundation(long arg1) {
        this.maxScrollOffset = arg1;
    }

    public final void setMinScrollOffset$foundation(long arg1) {
        this.minScrollOffset = arg1;
    }

    public final void setPrefetchingEnabled$foundation(boolean arg1) {
        this.prefetchingEnabled = arg1;
    }

    public final void setPremeasureConstraints-BRTryo0$foundation(long arg1) {
        this.premeasureConstraints = arg1;
    }

    private final void setProgrammaticScrollTargetPage(int arg1) {
        this.programmaticScrollTargetPage$delegate.setIntValue(arg1);
    }

    private final void setRemeasurement(Remeasurement arg1) {
        this.remeasurement$delegate.setValue(arg1);
    }

    private final void setSettledPageState(int arg1) {
        this.settledPageState$delegate.setIntValue(arg1);
    }

    public final void setUpDownDifference-k-4lQ0M$foundation(long arg1) {
        this.upDownDifference$delegate.setValue(Offset.box-impl(arg1));
    }

    static final int settledPage_delegate$lambda$0(PagerState arg1) {
        if(arg1.isScrollInProgress()) {
            return arg1.getSettledPageState();
        }

        return arg1.getCurrentPage();
    }

    public final void snapToItem$foundation(int arg2, float arg3, boolean arg4) {
        if(this.scrollPosition.getCurrentPage() != arg2 || this.scrollPosition.getCurrentPageOffsetFraction() != arg3) {
            this.cacheWindowLogic.resetStrategy();
        }
        else {
        }

        this.scrollPosition.requestPositionAndForgetLastKnownKey(arg2, arg3);
        if(arg4) {
            Remeasurement v1 = this.getRemeasurement$foundation();
            if(v1 != null) {
                v1.forceRemeasure();
            }

            return;
        }

        ObservableScopeInvalidator.invalidateScope-impl(this.measurementScopeInvalidator);
    }

    static final int targetPage_delegate$lambda$0(PagerState arg2) {
        int v0;
        if(!arg2.isScrollInProgress()) {
            v0 = arg2.getCurrentPage();
        }
        else if(arg2.getProgrammaticScrollTargetPage() != -1) {
            v0 = arg2.getProgrammaticScrollTargetPage();
        }
        else if(Math.abs(arg2.getCurrentPageOffsetFraction()) < Math.abs(arg2.getPositionThresholdFraction$foundation())) {
            v0 = arg2.getCurrentPage();
        }
        else if(arg2.getLastScrolledForward()) {
            v0 = arg2.firstVisiblePage + 1;
        }
        else {
            v0 = arg2.firstVisiblePage;
        }

        return arg2.coerceInPageRange(v0);
    }

    private final void tryRunPrefetch(PagerMeasureResult arg7) {
        Companion v0 = Snapshot.Companion;
        Snapshot v1 = v0.getCurrentThreadSnapshot();
        Function1 v2 = v1 != null ? v1.getReadObserver() : null;
        Snapshot v3 = v0.makeCurrentNonObservable(v1);
        try {
            if(this.prefetchingEnabled) {
                goto label_11;
            }
        }
        catch(Throwable v6) {
            goto label_39;
        }

        v0.restoreNonObservable(v1, v3, v2);
        return;
        try {
        label_11:
            if(arg7.getBeyondViewportPageCount() < this.getPageCount()) {
                goto label_16;
            }
        }
        catch(Throwable v6) {
            goto label_39;
        }

        v0.restoreNonObservable(v1, v3, v2);
        return;
        try {
        label_16:
            if(Math.abs(this.previousPassDelta) > 0.5f) {
                goto label_22;
            }
        }
        catch(Throwable v6) {
            goto label_39;
        }

        v0.restoreNonObservable(v1, v3, v2);
        return;
        try {
        label_22:
            if(this.isGestureActionMatchesScroll(this.previousPassDelta)) {
                goto label_27;
            }
        }
        catch(Throwable v6) {
            goto label_39;
        }

        v0.restoreNonObservable(v1, v3, v2);
        return;
        try {
        label_27:
            if(ComposeFoundationFlags.isCacheWindowForPagerEnabled) {
                this.cacheWindowLogic.onScroll(this.previousPassDelta, arg7);
            }
            else {
                this.notifyPrefetch(this.previousPassDelta, ((PagerLayoutInfo)arg7));
            }
        }
        catch(Throwable v6) {
        label_39:
            v0.restoreNonObservable(v1, v3, v2);
            throw v6;
        }

        v0.restoreNonObservable(v1, v3, v2);
    }

    public final void updateCurrentPage(ScrollScope arg1, int arg2, float arg3) {
        this.snapToItem$foundation(arg2, arg3, true);
    }

    public static void updateCurrentPage$default(PagerState arg0, ScrollScope arg1, int arg2, float arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            arg0.updateCurrentPage(arg1, arg2, 0f);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCurrentPage");
    }

    public final void updateTargetPage(ScrollScope arg1, int arg2) {
        this.setProgrammaticScrollTargetPage(this.coerceInPageRange(arg2));
    }
}

