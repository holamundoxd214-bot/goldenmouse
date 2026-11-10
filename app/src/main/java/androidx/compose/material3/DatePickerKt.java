package androidx.compose.material3;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000Æ\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\b\u001Aw\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001AE\u0010\u0013\u001A\u00020\u00032\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001CH\u0007¢\u0006\u0004\b\u001D\u0010\u001E\u001AO\u0010\u001F\u001A\u00020\u00032\n\u0010 \u001A\u00060!j\u0002`\"2\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001C¢\u0006\u0004\b#\u0010$\u001A\u0081\u0001\u0010%\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0013\u0010\r\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0013\u0010&\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*2\u0011\u0010+\u001A\r\u0012\u0004\u0012\u00020\u00010\u000B¢\u0006\u0002\b\fH\u0001¢\u0006\u0004\b,\u0010-\u001A;\u0010.\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010/\u001A\u00020\u001A2\u0012\u00100\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u0001012\u0006\u0010\b\u001A\u00020\tH\u0001¢\u0006\u0004\b2\u00103\u001A£\u0001\u00104\u001A\u00020\u00012\b\u00105\u001A\u0004\u0018\u00010\u00152\u0006\u00106\u001A\u00020\u00152\u0006\u0010/\u001A\u00020\u001A2#\u00107\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001A\u00020>2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\b\u001A\u00020\t2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b?\u0010@\u001A\u008D\u0001\u0010A\u001A\u00020\u00012\b\u00105\u001A\u0004\u0018\u00010\u00152\u0006\u00106\u001A\u00020\u00152!\u00107\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001A\u00020>2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u0010B\u001AW\u0010C\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000B¢\u0006\u0002\b\f2\u0006\u0010D\u001A\u00020E2\u0006\u0010F\u001A\u00020E2\u0006\u0010G\u001A\u00020*2\u0011\u0010+\u001A\r\u0012\u0004\u0012\u00020\u00010\u000B¢\u0006\u0002\b\fH\u0001¢\u0006\u0004\bH\u0010I\u001A\u008D\u0001\u0010J\u001A\u00020\u00012\u0006\u0010K\u001A\u00020L2\b\u00105\u001A\u0004\u0018\u00010\u00152!\u00107\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001A\u00020>2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u0010M\u001AI\u0010N\u001A\u00020\u00012\u0006\u0010K\u001A\u00020L2!\u0010;\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001A\u00020>2\u0006\u0010\u0017\u001A\u00020\u0018H\u0080@¢\u0006\u0002\u0010O\u001A\u001D\u0010P\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\t2\u0006\u0010=\u001A\u00020>H\u0001¢\u0006\u0002\u0010Q\u001A\u0082\u0001\u0010R\u001A\u00020\u00012\u0006\u0010S\u001A\u00020T2!\u00107\u001A\u001D\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012\u0006\u0010U\u001A\u00020\u00152\b\u0010V\u001A\u0004\u0018\u00010\u00152\b\u0010W\u001A\u0004\u0018\u00010\u00152\b\u0010X\u001A\u0004\u0018\u00010Y2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\b\u001A\u00020\t2\n\u0010 \u001A\u00060!j\u0002`\"H\u0001¢\u0006\u0002\u0010Z\u001A\u0010\u0010[\u001A\u00020\\2\u0006\u0010\u0017\u001A\u00020\u0018H\u0000\u001A7\u0010]\u001A\u0004\u0018\u00010^2\u0006\u0010_\u001A\u00020\u000F2\u0006\u0010`\u001A\u00020\u000F2\u0006\u0010a\u001A\u00020\u000F2\u0006\u0010b\u001A\u00020\u000F2\u0006\u0010c\u001A\u00020\u000FH\u0003¢\u0006\u0002\u0010d\u001Ac\u0010e\u001A\u00020\u00012\u0006\u0010f\u001A\u00020^2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010g\u001A\u00020\u000F2\f\u0010h\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B2\u0006\u0010i\u001A\u00020\u000F2\u0006\u0010j\u001A\u00020\u000F2\u0006\u0010k\u001A\u00020\u000F2\u0006\u0010l\u001A\u00020\u000F2\u0006\u0010m\u001A\u00020^2\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u0010n\u001A`\u0010o\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u00106\u001A\u00020\u00152!\u0010p\u001A\u001D\u0012\u0013\u0012\u00110\\¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020\u0001012\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010=\u001A\u00020>2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u0010r\u001AS\u0010s\u001A\u00020\u00012\u0006\u0010f\u001A\u00020^2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010g\u001A\u00020\u000F2\u0006\u0010t\u001A\u00020\u000F2\f\u0010h\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B2\u0006\u0010j\u001A\u00020\u000F2\u0006\u0010m\u001A\u00020^2\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u0010u\u001Ag\u0010v\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010w\u001A\u00020\u000F2\u0006\u0010x\u001A\u00020\u000F2\u0006\u0010y\u001A\u00020\u000F2\u0006\u0010z\u001A\u00020^2\f\u0010{\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B2\f\u0010|\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B2\f\u0010}\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B2\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u0010~\u001AB\u0010\u007F\u001A\u00020\u00012\f\u0010h\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B2\u0007\u0010\u0080\u0001\u001A\u00020\u000F2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0011\u0010+\u001A\r\u0012\u0004\u0012\u00020\u00010\u000B¢\u0006\u0002\b\fH\u0003¢\u0006\u0003\u0010\u0081\u0001\u001AD\u0010\u0082\u0001\u001A\u00020\u00012\f\u0010h\u001A\b\u0012\u0004\u0012\u00020\u00010\u000B2\b\u0010\u0083\u0001\u001A\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001A\u00020^2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010j\u001A\u00020\u000FH\u0003¢\u0006\u0003\u0010\u0086\u0001\"\u001A\u0010\u0087\u0001\u001A\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008A\u0001\u001A\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u001A\u0010\u008B\u0001\u001A\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008A\u0001\u001A\u0006\b\u008C\u0001\u0010\u0089\u0001\"\u001A\u0010\u008D\u0001\u001A\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008A\u0001\u001A\u0006\b\u008E\u0001\u0010\u0089\u0001\"\u0018\u0010\u008F\u0001\u001A\u00030\u0090\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0010\u0010\u0093\u0001\u001A\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0094\u0001\u001A\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\u0095\u0001\u001A\u00020*X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008A\u0001\"\u000F\u0010\u0096\u0001\u001A\u00020\\X\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u0097\u0001\u001A\u00020\\X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001²\u0006\n\u0010y\u001A\u00020\u000FX\u008A\u008E\u0002"}, d2={"DatePicker", "", "state", "Landroidx/compose/material3/DatePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "colors", "Landroidx/compose/material3/DatePickerColors;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "rememberDatePickerState", "initialSelectedDateMillis", "", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "DateEntryContainer", "modeToggleButton", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "Landroidx/compose/ui/unit/Dp;", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "onDisplayModeChange", "Lkotlin/Function1;", "DisplayModeToggleButton-iUJLfQg", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "selectedDateMillis", "displayedMonthMillis", "onDateSelectionChange", "Lkotlin/ParameterName;", "name", "dateInMillis", "onDisplayedMonthChange", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "SwitchableDateEntryContent-KaiTk9E", "(Ljava/lang/Long;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "(Ljava/lang/Long;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/internal/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "todayMillis", "startDateMillis", "endDateMillis", "rangeSelectionInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "(Landroidx/compose/material3/internal/CalendarMonth;Lkotlin/jvm/functions/Function1;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Ljava/util/Locale;Landroidx/compose/runtime/Composer;I)V", "numberOfMonthsInRange", "", "dayContentDescription", "", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Day", "text", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconButtonWithTooltip", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "()F", "F", "MonthYearHeight", "getMonthYearHeight", "DatePickerHorizontalPadding", "getDatePickerHorizontalPadding", "DatePickerModeTogglePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "DatePickerHeadlinePadding", "YearsVerticalPadding", "MaxCalendarRows", "YearsInRow", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DatePickerKt {
    private static final PaddingValues DatePickerHeadlinePadding = null;
    private static final float DatePickerHorizontalPadding = 0f;
    private static final PaddingValues DatePickerModeTogglePadding = null;
    private static final PaddingValues DatePickerTitlePadding = null;
    private static final int MaxCalendarRows = 6;
    private static final float MonthYearHeight = 0f;
    private static final float RecommendedSizeForAccessibility = 0f;
    private static final int YearsInRow = 3;
    private static final float YearsVerticalPadding;

    static {
        DatePickerKt.RecommendedSizeForAccessibility = Dp.constructor-impl(48f);
        DatePickerKt.MonthYearHeight = Dp.constructor-impl(56f);
        DatePickerKt.DatePickerHorizontalPadding = Dp.constructor-impl(12f);
        DatePickerKt.DatePickerModeTogglePadding = PaddingKt.PaddingValues-a9UjIt4$default(0f, 0f, Dp.constructor-impl(12f), Dp.constructor-impl(12f), 3, null);
        DatePickerKt.DatePickerTitlePadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl(24f), Dp.constructor-impl(16f), Dp.constructor-impl(12f), 0f, 8, null);
        DatePickerKt.DatePickerHeadlinePadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl(24f), 0f, Dp.constructor-impl(12f), Dp.constructor-impl(12f), 2, null);
        DatePickerKt.YearsVerticalPadding = Dp.constructor-impl(16f);
    }

    public static final void DateEntryContainer-au3_HiA(Modifier arg20, Function2 arg21, Function2 arg22, Function2 arg23, DatePickerColors arg24, TextStyle arg25, float arg26, Function2 arg27, Composer arg28, int arg29) {
        Composer v0_1;
        DatePickerKt$$ExternalSyntheticLambda29 v10_2;
        int v12;
        TextStyle v7_1;
        DatePickerColors v6_1;
        Function2 v5_1;
        Function2 v4_1;
        Function2 v3;
        int v2;
        Function2 v8 = arg27;
        int v9 = arg29;
        int v0 = 0x5BBD4DD3;
        Composer v1 = arg28.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(DateEntryContainer)N(modifier,title,headline,modeToggleButton,colors,headlineTextStyle,headerMinHeight:c#ui.unit.Dp,content)1356@63459L236,1352@63311L1910:DatePicker.kt#uh7d8r");
        Modifier v10 = arg20;
        if((v9 & 6) == 0) {
            v2 = v1.changed(v10) ? 4 : 2;
            v2 |= v9;
        }
        else {
            v2 = v9;
        }

        if((v9 & 0x30) == 0) {
            v3 = arg21;
            int v4 = v1.changedInstance(v3) ? 0x20 : 16;
            v2 |= v4;
        }
        else {
            v3 = arg21;
        }

        if((v9 & 0x180) == 0) {
            v4_1 = arg22;
            int v5 = v1.changedInstance(v4_1) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
            v4_1 = arg22;
        }

        if((v9 & 0xC00) == 0) {
            v5_1 = arg23;
            int v6 = v1.changedInstance(v5_1) ? 0x800 : 0x400;
            v2 |= v6;
        }
        else {
            v5_1 = arg23;
        }

        if((v9 & 0x6000) == 0) {
            v6_1 = arg24;
            int v7 = v1.changed(v6_1) ? 0x4000 : 0x2000;
            v2 |= v7;
        }
        else {
            v6_1 = arg24;
        }

        if((0x30000 & v9) == 0) {
            v7_1 = arg25;
            int v11 = v1.changed(v7_1) ? 0x20000 : 0x10000;
            v2 |= v11;
        }
        else {
            v7_1 = arg25;
        }

        if((0x180000 & v9) == 0) {
            v12 = v1.changed(arg26) ? 0x100000 : 0x80000;
            v2 |= v12;
        }

        if((0xC00000 & v9) == 0) {
            v12 = v1.changedInstance(v8) ? 0x800000 : 0x400000;
            v2 |= v12;
        }

        boolean v12_1 = (0x492493 & v2) != 4793490 ? true : false;
        if(v1.shouldExecute(v12_1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1351)");
            }

            int v28 = v2;
            Modifier v11_1 = SizeKt.sizeIn-qDBjuR0$default(v10, DatePickerModalTokens.INSTANCE.getContainerWidth-D9Ej5fM(), 0f, 0f, 0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(v1, 0x61A161DF, "CC(remember):DatePicker.kt#9igjgp");
            Object v10_1 = v1.rememberedValue();
            if(v10_1 == Composer.Companion.getEmpty()) {
                v10_2 = new DatePickerKt$$ExternalSyntheticLambda29();
                v1.updateRememberedValue(v10_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v10 = BackgroundKt.background-bw27NRU$default(SemanticsModifierKt.semantics$default(v11_1, false, ((Function1)v10_2), 1, null), v6_1.getContainerColor-0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(v1, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy v11_2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), v1, 0);
            ComposerKt.sourceInformationMarkerStart(v1, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v2 = ComposablesKt.getCurrentCompositeKeyHash(v1, 0);
            CompositionLocalMap v12_2 = v1.getCurrentCompositionLocalMap();
            v10 = ComposedModifierKt.materializeModifier(v1, v10);
            Function0 v13 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v1, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v13);
            }
            else {
                v1.useNode();
            }

            Composer v13_1 = Updater.constructor-impl(v1);
            Updater.set-impl(v13_1, v11_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v13_1, v12_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v11_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v13_1.getInserting()) || !Intrinsics.areEqual(v13_1.rememberedValue(), Integer.valueOf(v2))) {
                v13_1.updateRememberedValue(Integer.valueOf(v2));
                v13_1.apply(Integer.valueOf(v2), v11_3);
            }

            Updater.set-impl(v13_1, v10, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v1, 0x6D250EDA, "C1370@64014L1183,1364@63763L1434,1396@65206L9:DatePicker.kt#uh7d8r");
            DatePickerKt.DatePickerHeader-pc5RIQQ(Modifier.Companion, arg21, v6_1.getTitleContentColor-0d7_KjU(), v6_1.getHeadlineContentColor-0d7_KjU(), arg26, ComposableLambdaKt.rememberComposableLambda(-1658370654, true, new DatePickerKt$DateEntryContainer$2$1(v4_1, v5_1, v3, v6_1, v7_1), v1, 54), v1, v28 & 0x70 | 0x30006 | 0xE000 & v28 >> 6);
            v0_1 = v1;
            v8.invoke(v0_1, Integer.valueOf(v28 >> 21 & 14));
            ComposerKt.sourceInformationMarkerEnd(v0_1);
            ComposerKt.sourceInformationMarkerEnd(v0_1);
            v0_1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v0_1);
            ComposerKt.sourceInformationMarkerEnd(v0_1);
            ComposerKt.sourceInformationMarkerEnd(v0_1);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_250;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v0_1 = v1;
            v0_1.skipToGroupEnd();
        }

    label_250:
        ScopeUpdateScope v10_3 = v0_1.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new DatePickerKt$$ExternalSyntheticLambda30(arg20, arg21, arg22, arg23, arg24, arg25, arg26, v8, v9));
        }
    }

    static final Unit DateEntryContainer_au3_HiA$lambda$10(Modifier arg11, Function2 arg12, Function2 arg13, Function2 arg14, DatePickerColors arg15, TextStyle arg16, float arg17, Function2 arg18, int arg19, Composer arg20, int arg21) {
        DatePickerKt.DateEntryContainer-au3_HiA(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    static final Unit DateEntryContainer_au3_HiA$lambda$8$lambda$7(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContainer(arg1, true);
        return Unit.INSTANCE;
    }

    public static final void DatePicker(DatePickerState arg27, Modifier arg28, DatePickerFormatter arg29, DatePickerColors arg30, Function2 arg31, Function2 arg32, boolean arg33, FocusRequester arg34, Composer arg35, int arg36, int arg37) {
        DatePickerColors v4_4;
        Function2 v5_4;
        Modifier v2_6;
        FocusRequester v8_1;
        DatePickerFormatter v3_1;
        Composer v19;
        ComposableLambda v2_4;
        DatePickerFormatter v31;
        DatePickerColors v15_2;
        boolean v4_1;
        int v6_1;
        Modifier v11_1;
        Function2 v12_1;
        FocusRequester v5_1;
        FocusRequester v4_3;
        int v28;
        DatePickerColors v5_2;
        boolean v15_1;
        int v14;
        Function2 v13_1;
        int v12;
        Function2 v11;
        int v8;
        DatePickerColors v7_2;
        boolean v7_1;
        int v7;
        Modifier v6;
        int v4;
        DatePickerState v1 = arg27;
        DatePickerFormatter v0 = arg29;
        int v9 = arg36;
        int v10 = arg37;
        Composer v3 = arg35.startRestartGroup(1105472031);
        ComposerKt.sourceInformation(v3, "C(DatePicker)N(state,modifier,dateFormatter,colors,title,headline,showModeToggle,focusRequester)192@9028L207,216@9909L5,219@10018L701,199@9240L1479:DatePicker.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v4 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v4 = v3.changed(v1) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v4 = v9;
        }

        int v5 = v10 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_37;
        }
        else if((v9 & 0x30) == 0) {
            v6 = arg28;
            v7 = v3.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_37:
            v6 = arg28;
        }

        if((v9 & 0x180) == 0) {
            if((v10 & 4) == 0) {
                v7_1 = (v9 & 0x200) == 0 ? v3.changed(v0) : v3.changedInstance(v0);
                if(!v7_1) {
                    goto label_50;
                }

                v7 = 0x100;
            }
            else {
            label_50:
                v7 = 0x80;
            }

            v4 |= v7;
        }

        if((v9 & 0xC00) == 0) {
            if((v10 & 8) == 0) {
                v7_2 = arg30;
                if(v3.changed(v7_2)) {
                    v8 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v7_2 = arg30;
            label_62:
                v8 = 0x400;
            }

            v4 |= v8;
        }
        else {
            v7_2 = arg30;
        }

        v8 = v10 & 16;
        if(v8 != 0) {
            v4 |= 0x6000;
            goto label_80;
        }
        else if((v9 & 0x6000) == 0) {
            v11 = arg31;
            v12 = v3.changedInstance(v11) ? 0x4000 : 0x2000;
            v4 |= v12;
        }
        else {
        label_80:
            v11 = arg31;
        }

        v12 = v10 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v4 |= v13;
            goto label_96;
        }
        else if((v13 & v9) == 0) {
            v13_1 = arg32;
            v14 = v3.changedInstance(v13_1) ? 0x20000 : 0x10000;
            v4 |= v14;
        }
        else {
        label_96:
            v13_1 = arg32;
        }

        v14 = v10 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v4 |= v15;
            goto label_112;
        }
        else if((v15 & v9) == 0) {
            v15_1 = arg33;
            int v16 = v3.changed(v15_1) ? 0x100000 : 0x80000;
            v4 |= v16;
        }
        else {
        label_112:
            v15_1 = arg33;
        }

        int v2 = v10 & 0x80;
        int v17 = 0xC00000;
        if(v2 != 0) {
            v4 |= v17;
        }
        else {
            FocusRequester v0_1 = arg34;
            if((v9 & v17) == 0) {
                v17 = v3.changed(v0_1) ? 0x800000 : 0x400000;
                v4 |= v17;
            }
        }

        v17 = v2;
        int v35 = v5;
        boolean v0_2 = (v4 & 0x492493) != 4793490 ? true : false;
        if(v3.shouldExecute(v0_2, v4 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "170@8134L47,171@8233L8,172@8282L224,179@8550L335,189@8961L29");
            String v2_1 = "CC(remember):DatePicker.kt#9igjgp";
            if((v9 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v35 != 0) {
                    Companion v6_2 = Modifier.Companion;
                }

                if((v10 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(v3, 1501703950, v2_1);
                    Object v0_3 = v3.rememberedValue();
                    if(v0_3 == Composer.Companion.getEmpty()) {
                        v0 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                        v3.updateRememberedValue(v0);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    v4 &= -897;
                }
                else {
                    v0 = arg29;
                }

                if((v10 & 8) != 0) {
                    v5_2 = DatePickerDefaults.INSTANCE.colors(v3, 6);
                    v4 &= 0xFFFFE3FF;
                }
                else {
                    v5_2 = v7_2;
                }

                if(v8 != 0) {
                    v28 = v4;
                    v4_1 = true;
                    ComposableLambda v11_2 = ComposableLambdaKt.rememberComposableLambda(0x62B01493, true, new DatePickerKt$DatePicker$2(v1, v5_2), v3, 54);
                    v7 = 54;
                }
                else {
                    v28 = v4;
                    v4_1 = true;
                    v7 = 54;
                }

                if(v12 != 0) {
                    ComposableLambda v13_2 = ComposableLambdaKt.rememberComposableLambda(1439279037, v4_1, new DatePickerKt$DatePicker$3(v1, v0, v5_2), v3, v7);
                }

                if(v14 != 0) {
                    v15_1 = true;
                }

                if(v17 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v3, 1501730396, v2_1);
                    Object v4_2 = v3.rememberedValue();
                    if(v4_2 == Composer.Companion.getEmpty()) {
                        v4_3 = new FocusRequester();
                        v3.updateRememberedValue(v4_3);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                    DatePickerColors v12_2 = v5_2;
                    Object v5_3 = v4_3;
                    v4_1 = v15_1;
                    v15_2 = v12_2;
                    v12_1 = v11;
                    v11_1 = v6;
                    v6_1 = v28;
                    goto label_244;
                }

                v12_1 = v11;
                v4_1 = v15_1;
                v15_2 = v5_2;
                v11_1 = v6;
                v6_1 = v28;
                v5_1 = arg34;
            }
            else {
                v3.skipToGroupEnd();
                if((v10 & 4) != 0) {
                    v4 &= -897;
                }

                if((v10 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                v0 = arg29;
                v5_1 = arg34;
                v12_1 = v11;
                v11_1 = v6;
                v6_1 = v4;
                v4_1 = v15_1;
                v15_2 = v7_2;
            }

        label_244:
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1105472031, v6_1, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:190)");
            }

            Locale v7_3 = v1.getLocale();
            ComposerKt.sourceInformationMarkerStart(v3, 0x59829F6E, v2_1);
            boolean v2_2 = v3.changed(v7_3);
            Object v7_4 = v3.rememberedValue();
            if((v2_2) || v7_4 == Composer.Companion.getEmpty()) {
                CalendarModel v2_3 = (v1 instanceof BaseDatePickerStateImpl) ? v1.getCalendarModel() : CalendarModel_androidKt.createCalendarModel(v1.getLocale());
                CalendarModel v7_5 = v2_3;
                v3.updateRememberedValue(v7_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            if(v4_1) {
                v3.startReplaceGroup(0xD6D706B7);
                ComposerKt.sourceInformation(v3, "205@9418L364");
                v31 = v0;
                v2_4 = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new DatePickerKt$DatePicker$5(v1, v15_2), v3, 54);
                v3.endReplaceGroup();
            }
            else {
                v31 = v0;
                v3.startReplaceGroup(0xD6DCF0DF);
                v3.endReplaceGroup();
                v2_4 = null;
            }

            ComposableLambda v14_1 = v2_4;
            TextStyle v16_1 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), v3, 6);
            float v17_1 = DatePickerModalTokens.INSTANCE.getHeaderContainerHeight-D9Ej5fM();
            DatePickerKt$DatePicker$6 v0_4 = new DatePickerKt$DatePicker$6(v1, v7_4, v31, v15_2, v5_1);
            DatePickerFormatter v1_1 = v31;
            FocusRequester v2_5 = v5_1;
            v5 = v6_1 >> 9;
            v19 = v3;
            DatePickerKt.DateEntryContainer-au3_HiA(v11_1, v12_1, v13_1, ((Function2)v14_1), v15_2, v16_1, v17_1, ComposableLambdaKt.rememberComposableLambda(0xAFB7E16E, true, v0_4, v3, 54), v19, v6_1 >> 3 & 14 | 0xD80000 | v5 & 0x70 | v5 & 0x380 | 0xE000 & v6_1 << 3);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v1_1;
            v8_1 = v2_5;
            v7_1 = v4_1;
            v2_6 = v11_1;
            v5_4 = v12_1;
            v4_4 = v15_2;
        }
        else {
            v19 = v3;
            v19.skipToGroupEnd();
            v3_1 = arg29;
            v8_1 = arg34;
            v2_6 = v6;
            v4_4 = v7_2;
            v5_4 = v11;
            v7_1 = v15_1;
        }

        Function2 v6_3 = v13_1;
        ScopeUpdateScope v11_3 = v19.endRestartGroup();
        if(v11_3 != null) {
            v11_3.updateScope(new DatePickerKt$$ExternalSyntheticLambda0(arg27, v2_6, v3_1, v4_4, v5_4, v6_3, v7_1, v8_1, v9, v10));
        }
    }

    static final Unit DatePicker$lambda$3(DatePickerState arg12, Modifier arg13, DatePickerFormatter arg14, DatePickerColors arg15, Function2 arg16, Function2 arg17, boolean arg18, FocusRequester arg19, int arg20, int arg21, Composer arg22, int arg23) {
        DatePickerKt.DatePicker(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    private static final void DatePickerContent(Long arg25, long arg26, Function1 arg28, Function1 arg29, CalendarModel arg30, IntRange arg31, DatePickerFormatter arg32, SelectableDates arg33, DatePickerColors arg34, Composer arg35, int arg36) {
        DatePickerKt$$ExternalSyntheticLambda20 v5_3;
        CoroutineScope v0_3;
        int v15;
        int v14;
        int v9;
        long v1 = arg26;
        CalendarModel v6 = arg30;
        IntRange v7 = arg31;
        DatePickerFormatter v8 = arg32;
        DatePickerColors v10 = arg34;
        int v0 = arg36;
        Composer v12 = arg35.startRestartGroup(-434467002);
        ComposerKt.sourceInformation(v12, "C(DatePickerContent)N(selectedDateMillis,displayedMonthMillis,onDateSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)1540@71327L64,1543@71481L466,1543@71454L493,1555@71974L24,1556@72045L25,1556@72028L42,1557@72075L5753:DatePicker.kt#uh7d8r");
        if((v0 & 6) == 0) {
            v9 = v12.changed(arg25) ? 4 : 2;
            v9 |= v0;
        }
        else {
            v9 = v0;
        }

        if((v0 & 0x30) == 0) {
            int v11 = v12.changed(v1) ? 0x20 : 16;
            v9 |= v11;
        }

        if((v0 & 0x180) == 0) {
            int v13 = v12.changedInstance(arg28) ? 0x100 : 0x80;
            v9 |= v13;
        }

        if((v0 & 0xC00) == 0) {
            v14 = v12.changedInstance(arg29) ? 0x800 : 0x400;
            v9 |= v14;
        }

        if((v0 & 0x6000) == 0) {
            v14 = v12.changedInstance(v6) ? 0x4000 : 0x2000;
            v9 |= v14;
        }

        if((0x30000 & v0) == 0) {
            v14 = v12.changedInstance(v7) ? 0x20000 : 0x10000;
            v9 |= v14;
        }

        if((0x180000 & v0) == 0) {
            boolean v14_1 = (0x200000 & v0) == 0 ? v12.changed(v8) : v12.changedInstance(v8);
            v14 = v14_1 ? 0x100000 : 0x80000;
            v9 |= v14;
        }

        if((0xC00000 & v0) == 0) {
            v15 = v12.changed(arg33) ? 0x800000 : 0x400000;
            v9 |= v15;
        }

        if((0x6000000 & v0) == 0) {
            v15 = v12.changed(v10) ? 0x4000000 : 0x2000000;
            v9 |= v15;
        }

        boolean v5 = (0x2492493 & v9) != 0x2492492 ? true : false;
        if(v12.shouldExecute(v5, v9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-434467002, v9, -1, "androidx.compose.material3.DatePickerContent (DatePicker.kt:1537)");
            }

            CalendarMonth v3 = v6.getMonth(v1);
            int v5_1 = RangesKt.coerceAtLeast(v3.indexIn(v7), 0);
            CalendarMonth v20 = v3;
            LazyListState v3_1 = LazyListStateKt.rememberLazyListState(v5_1, 0, v12, 0, 2);
            Integer v0_1 = Integer.valueOf(v5_1);
            String v1_1 = "CC(remember):DatePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, 0xC9B430F8, v1_1);
            int v2 = v12.changed(v3_1) | v12.changed(v5_1);
            Object v15_1 = v12.rememberedValue();
            if(v2 != 0 || v15_1 == Composer.Companion.getEmpty()) {
                DatePickerKt$DatePickerContent$1$1 v15_2 = new DatePickerKt$DatePickerContent$1$1(v3_1, v5_1, null);
                v12.updateRememberedValue(v15_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            EffectsKt.LaunchedEffect(v0_1, ((Function2)v15_1), v12, 0);
            ComposerKt.sourceInformationMarkerStart(v12, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v12, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v0_2 = v12.rememberedValue();
            if(v0_2 == Composer.Companion.getEmpty()) {
                v0_3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v12);
                v12.updateRememberedValue(v0_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            Object[] v2_1 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(v12, -910920257, v1_1);
            Object v5_2 = v12.rememberedValue();
            if(v5_2 == Composer.Companion.getEmpty()) {
                v5_3 = new DatePickerKt$$ExternalSyntheticLambda20();
                v12.updateRememberedValue(v5_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            Object v2_2 = RememberSaveableKt.rememberSaveable(v2_1, ((Function0)v5_3), v12, 0x30);
            String v15_3 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v12, 0xE32F0E82, v15_3);
            Companion v5_4 = Modifier.Companion;
            int v16 = v9;
            MeasurePolicy v4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), v12, 0);
            ComposerKt.sourceInformationMarkerStart(v12, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v17 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
            CompositionLocalMap v9_1 = v12.getCurrentCompositionLocalMap();
            Modifier v5_5 = ComposedModifierKt.materializeModifier(v12, ((Modifier)v5_4));
            Function0 v7_1 = ComposeUiNode.Companion.getConstructor();
            String v21 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            String v10_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v10_1);
            if(!(v12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12.startReusableNode();
            if(v12.getInserting()) {
                v12.createNode(v7_1);
            }
            else {
                v12.useNode();
            }

            Composer v6_1 = Updater.constructor-impl(v12);
            Updater.set-impl(v6_1, v4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_1, v9_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v4_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v6_1.getInserting()) || !Intrinsics.areEqual(v6_1.rememberedValue(), Integer.valueOf(v17))) {
                v6_1.updateRememberedValue(Integer.valueOf(v17));
                v6_1.apply(Integer.valueOf(v17), v4_1);
            }

            Updater.set-impl(v6_1, v5_5, ComposeUiNode.Companion.getSetModifier());
            String v5_6 = "C89@4556L9:Column.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v12, 0xE9125B67, v5_6);
            ComposerKt.sourceInformationMarkerStart(v12, 0xE0FD4111, "C1568@72610L511,1580@73155L520,1592@73717L42,1558@72092L1707,1596@73809L4013:DatePicker.kt#uh7d8r");
            Companion v6_2 = Modifier.Companion;
            float v7_2 = DatePickerKt.DatePickerHorizontalPadding;
            String v17_1 = v10_1;
            Modifier v6_3 = PaddingKt.padding-VpY3zN4$default(((Modifier)v6_2), v7_2, 0f, 2, null);
            boolean v10_2 = v3_1.getCanScrollForward();
            boolean v11_1 = v3_1.getCanScrollBackward();
            boolean v19 = DatePickerKt.DatePickerContent$lambda$26(((MutableState)v2_2));
            String v4_2 = v8.formatMonthYear(Long.valueOf(arg26), arg30.getLocale());
            if(v4_2 == null) {
                v4_2 = "-";
            }

            ComposerKt.sourceInformationMarkerStart(v12, 0xBCEF918F, v1_1);
            v9 = v12.changedInstance(v0_3) | v12.changed(v3_1);
            String v22 = v4_2;
            Object v4_3 = v12.rememberedValue();
            if(v9 != 0 || v4_3 == Composer.Companion.getEmpty()) {
                DatePickerKt$$ExternalSyntheticLambda21 v4_4 = new DatePickerKt$$ExternalSyntheticLambda21(v0_3, v3_1);
                v12.updateRememberedValue(v4_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerStart(v12, 0xBCEFD5B8, v1_1);
            v9 = v12.changedInstance(v0_3) | v12.changed(v3_1);
            Object v23 = v4_3;
            v4_3 = v12.rememberedValue();
            if(v9 != 0 || v4_3 == Composer.Companion.getEmpty()) {
                DatePickerKt$$ExternalSyntheticLambda23 v4_5 = new DatePickerKt$$ExternalSyntheticLambda23(v0_3, v3_1);
                v12.updateRememberedValue(v4_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerStart(v12, 0xBCF01A1A, v1_1);
            boolean v1_2 = v12.changed(v2_2);
            Object v9_2 = v12.rememberedValue();
            if((v1_2) || v9_2 == Composer.Companion.getEmpty()) {
                DatePickerKt$$ExternalSyntheticLambda24 v9_3 = new DatePickerKt$$ExternalSyntheticLambda24(((MutableState)v2_2));
                v12.updateRememberedValue(v9_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            int v1_3 = v16 & 0xE000000;
            String v13_1 = v15_3;
            v15_1 = v4_3;
            int v4_6 = v16;
            Object v16_1 = v9_2;
            Modifier v9_4 = v6_3;
            String v6_4 = v13_1;
            v13_1 = v22;
            Object v22_1 = v0_3;
            String v0_4 = v17_1;
            DatePickerKt.MonthsNavigation(v9_4, v10_2, v11_1, v19, v13_1, v23, ((Function0)v15_1), ((Function0)v16_1), arg34, v12, v1_3 | 6);
            v10 = arg34;
            v12 = v12;
            ComposerKt.sourceInformationMarkerStart(v12, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Companion v9_5 = Modifier.Companion;
            MeasurePolicy v11_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            v13_1 = v21;
            ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v13_1);
            v14 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
            CompositionLocalMap v15_4 = v12.getCurrentCompositionLocalMap();
            v9_4 = ComposedModifierKt.materializeModifier(v12, ((Modifier)v9_5));
            v17 = v1_3;
            Function0 v1_4 = ComposeUiNode.Companion.getConstructor();
            v16_1 = v2_2;
            ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v0_4);
            if(!(v12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12.startReusableNode();
            if(v12.getInserting()) {
                v12.createNode(v1_4);
            }
            else {
                v12.useNode();
            }

            Composer v1_5 = Updater.constructor-impl(v12);
            Updater.set-impl(v1_5, v11_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_5, v15_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v2_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_5.getInserting()) || !Intrinsics.areEqual(v1_5.rememberedValue(), Integer.valueOf(v14))) {
                v1_5.updateRememberedValue(Integer.valueOf(v14));
                v1_5.apply(Integer.valueOf(v14), v2_3);
            }

            Updater.set-impl(v1_5, v9_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v12, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v12, 0xB069DB48, "C1597@73827L684,1613@74711L7,1615@74836L7,1617@74971L7,1627@75521L2291,1618@75018L2794:DatePicker.kt#uh7d8r");
            v9 = 2;
            Modifier v1_6 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, v7_2, 0f, v9, null);
            ComposerKt.sourceInformationMarkerStart(v12, 0xE32F0E82, v6_4);
            MeasurePolicy v2_4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), v12, 0);
            ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v13_1);
            int v6_5 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
            CompositionLocalMap v7_3 = v12.getCurrentCompositionLocalMap();
            v1_6 = ComposedModifierKt.materializeModifier(v12, v1_6);
            Function0 v11_3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v0_4);
            if(!(v12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12.startReusableNode();
            if(v12.getInserting()) {
                v12.createNode(v11_3);
            }
            else {
                v12.useNode();
            }

            Composer v0_5 = Updater.constructor-impl(v12);
            Updater.set-impl(v0_5, v2_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_5, v7_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v2_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v0_5.getInserting()) || !Intrinsics.areEqual(v0_5.rememberedValue(), Integer.valueOf(v6_5))) {
                v0_5.updateRememberedValue(Integer.valueOf(v6_5));
                v0_5.apply(Integer.valueOf(v6_5), v2_3);
            }

            Updater.set-impl(v0_5, v1_6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v12, 0xE9125B67, v5_6);
            ComposerKt.sourceInformationMarkerStart(v12, 1070154161, "C1598@73923L31,1599@73971L526:DatePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(v10, arg30, v12, v4_6 >> 24 & 14 | v4_6 >> 9 & 0x70);
            DatePickerKt.HorizontalMonthsList(v3_1, arg25, arg28, arg29, arg30, arg31, v8, arg33, v10, v12, v4_6 << 3 & 0x70 | v4_6 & 0x380 | v4_6 & 0x1C00 | 0xE000 & v4_6 | 0x70000 & v4_6 | 0x380000 & v4_6 | 0x1C00000 & v4_6 | v17);
            LazyListState v5_7 = v3_1;
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            v12.endNode();
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            FiniteAnimationSpec v1_7 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v12, 6);
            FiniteAnimationSpec v3_2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v12, 6);
            FiniteAnimationSpec v6_6 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v12, 6);
            AnimatedVisibilityKt.AnimatedVisibility(DatePickerKt.DatePickerContent$lambda$26(((MutableState)v16_1)), ClipKt.clipToBounds(Modifier.Companion), EnterExitTransitionKt.expandVertically$default(v6_6, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn(v1_7, 0.6f)), EnterExitTransitionKt.shrinkVertically$default(v6_6, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(v3_2, 0f, v9, null)), null, ComposableLambdaKt.rememberComposableLambda(1193716082, true, new DatePickerKt$DatePickerContent$2$4$2(arg26, v16_1, v22_1, v5_7, arg31, v20, arg33, arg30, arg34), v12, 54), v12, 0x30030, 16);
            v12 = v12;
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            v12.endNode();
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            v12.endNode();
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerEnd(v12);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_548;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v12.skipToGroupEnd();
        }

    label_548:
        ScopeUpdateScope v12_1 = v12.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new DatePickerKt$$ExternalSyntheticLambda25(arg25, arg26, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg36));
        }
    }

    static final MutableState DatePickerContent$lambda$25$lambda$24() {
        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
    }

    private static final boolean DatePickerContent$lambda$26(MutableState arg0) {
        return ((State)arg0).getValue().booleanValue();
    }

    private static final void DatePickerContent$lambda$27(MutableState arg0, boolean arg1) {
        arg0.setValue(Boolean.valueOf(arg1));
    }

    static final Unit DatePickerContent$lambda$36$lambda$29$lambda$28(CoroutineScope arg8, LazyListState arg9) {
        BuildersKt.launch$default(arg8, null, null, new DatePickerKt$DatePickerContent$2$1$1$1(arg9, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit DatePickerContent$lambda$36$lambda$31$lambda$30(CoroutineScope arg8, LazyListState arg9) {
        BuildersKt.launch$default(arg8, null, null, new DatePickerKt$DatePickerContent$2$2$1$1(arg9, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit DatePickerContent$lambda$36$lambda$33$lambda$32(MutableState arg1) {
        DatePickerKt.DatePickerContent$lambda$27(arg1, DatePickerKt.DatePickerContent$lambda$26(arg1) ^ 1);
        return Unit.INSTANCE;
    }

    static final Unit DatePickerContent$lambda$37(Long arg13, long arg14, Function1 arg16, Function1 arg17, CalendarModel arg18, IntRange arg19, DatePickerFormatter arg20, SelectableDates arg21, DatePickerColors arg22, int arg23, Composer arg24, int arg25) {
        DatePickerKt.DatePickerContent(arg13, arg14, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg24, RecomposeScopeImplKt.updateChangedFlags(arg23 | 1));
        return Unit.INSTANCE;
    }

    public static final void DatePickerHeader-pc5RIQQ(Modifier arg17, Function2 arg18, long arg19, long arg21, float arg23, Function2 arg24, Composer arg25, int arg26) {
        Modifier v12;
        int v4;
        int v3;
        Modifier v1 = arg17;
        Function2 v2 = arg18;
        float v7 = arg23;
        Function2 v8 = arg24;
        int v9 = arg26;
        int v0 = 2020490761;
        Composer v14 = arg25.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(DatePickerHeader)N(modifier,title,titleContentColor:c#ui.graphics.Color,headlineContentColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,content)1685@78288L540:DatePicker.kt#uh7d8r");
        if((v9 & 6) == 0) {
            v3 = v14.changed(v1) ? 4 : 2;
            v3 |= v9;
        }
        else {
            v3 = v9;
        }

        if((v9 & 0x30) == 0) {
            v4 = v14.changedInstance(v2) ? 0x20 : 16;
            v3 |= v4;
        }

        long v10 = arg19;
        if((v9 & 0x180) == 0) {
            v4 = v14.changed(v10) ? 0x100 : 0x80;
            v3 |= v4;
        }

        long v5 = arg21;
        if((v9 & 0xC00) == 0) {
            v4 = v14.changed(v5) ? 0x800 : 0x400;
            v3 |= v4;
        }

        if((v9 & 0x6000) == 0) {
            v4 = v14.changed(v7) ? 0x4000 : 0x2000;
            v3 |= v4;
        }

        if((0x30000 & v9) == 0) {
            v4 = v14.changedInstance(v8) ? 0x20000 : 0x10000;
            v3 |= v4;
        }

        boolean v4_1 = (74899 & v3) != 74898 ? true : false;
        if(v14.shouldExecute(v4_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1677)");
            }

            Object v0_1 = null;
            if(v2 != null) {
                v12 = SizeKt.defaultMinSize-VpY3zN4$default(Modifier.Companion, 0f, v7, 1, v0_1);
            }
            else {
                Companion v12_1 = Modifier.Companion;
            }

            Modifier v0_2 = SizeKt.fillMaxWidth$default(v1, 0f, 1, v0_1).then(v12);
            HorizontalOrVertical v4_2 = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(v14, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy v4_3 = ColumnKt.columnMeasurePolicy(((Vertical)v4_2), Alignment.Companion.getStart(), v14, 6);
            ComposerKt.sourceInformationMarkerStart(v14, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v12_2 = ComposablesKt.getCurrentCompositeKeyHash(v14, 0);
            CompositionLocalMap v13 = v14.getCurrentCompositionLocalMap();
            v0_2 = ComposedModifierKt.materializeModifier(v14, v0_2);
            Function0 v15 = ComposeUiNode.Companion.getConstructor();
            int v16 = v3;
            ComposerKt.sourceInformationMarkerStart(v14, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v14.startReusableNode();
            if(v14.getInserting()) {
                v14.createNode(v15);
            }
            else {
                v14.useNode();
            }

            Composer v1_1 = Updater.constructor-impl(v14);
            Updater.set-impl(v1_1, v4_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_1, v13, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_1.getInserting()) || !Intrinsics.areEqual(v1_1.rememberedValue(), Integer.valueOf(v12_2))) {
                v1_1.updateRememberedValue(Integer.valueOf(v12_2));
                v1_1.apply(Integer.valueOf(v12_2), v3_1);
            }

            Updater.set-impl(v1_1, v0_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v14, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v14, 396879060, "C1695@78730L92:DatePicker.kt#uh7d8r");
            if(v2 != null) {
                v14.startReplaceGroup(0x17A81FEB);
                ComposerKt.sourceInformation(v14, "1690@78518L5,1691@78622L89,1691@78536L175");
                ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(v10, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont(), v14, 6), ComposableLambdaKt.rememberComposableLambda(0x5021D8C2, true, new DatePickerKt$DatePickerHeader$1$1(v2), v14, 54), v14, v16 >> 6 & 14 | 0x180);
                v14.endReplaceGroup();
            }
            else {
                v14.startReplaceGroup(0x17AC3B03);
                v14.endReplaceGroup();
            }

            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(v5)), v8, v14, ProvidedValue.$stable | v16 >> 12 & 0x70);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            v14.endNode();
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_193;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v14.skipToGroupEnd();
        }

    label_193:
        ScopeUpdateScope v10_1 = v14.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new DatePickerKt$$ExternalSyntheticLambda2(arg17, v2, arg19, v5, v7, v8, v9));
        }
    }

    static final Unit DatePickerHeader_pc5RIQQ$lambda$39(Modifier arg11, Function2 arg12, long arg13, long arg15, float arg17, Function2 arg18, int arg19, Composer arg20, int arg21) {
        DatePickerKt.DatePickerHeader-pc5RIQQ(arg11, arg12, arg13, arg15, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    public static final DatePickerState DatePickerState-sHin3Bw(Locale arg8, Long arg9, Long arg10, IntRange arg11, int arg12, SelectableDates arg13) {
        return new DatePickerStateImpl(arg9, arg10, arg11, arg12, arg13, arg8, null);
    }

    public static DatePickerState DatePickerState-sHin3Bw$default(Locale arg0, Long arg1, Long arg2, IntRange arg3, int arg4, SelectableDates arg5, int arg6, Object arg7) {
        if((arg6 & 2) != 0) {
            arg1 = null;
        }

        if((arg6 & 4) != 0) {
            arg2 = arg1;
        }

        if((arg6 & 8) != 0) {
            arg3 = DatePickerDefaults.INSTANCE.getYearRange();
        }

        if((arg6 & 16) != 0) {
            arg4 = DisplayMode.Companion.getPicker-jFl-4v0();
        }

        if((arg6 & 0x20) != 0) {
            arg5 = DatePickerDefaults.INSTANCE.getAllDates();
        }

        return DatePickerKt.DatePickerState-sHin3Bw(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    private static final void Day(String arg21, Modifier arg22, boolean arg23, Function0 arg24, boolean arg25, boolean arg26, boolean arg27, boolean arg28, String arg29, DatePickerColors arg30, Composer arg31, int arg32) {
        DatePickerKt$$ExternalSyntheticLambda4 v4_1;
        DatePickerColors v13_1;
        int v13;
        boolean v12_1;
        int v12;
        boolean v8_1;
        int v8;
        boolean v6_1;
        int v6;
        int v5;
        Modifier v2 = arg22;
        boolean v3 = arg23;
        boolean v0 = arg27;
        String v1 = arg29;
        int v10 = arg32;
        Composer v7 = arg31.startRestartGroup(0xC7A70680);
        ComposerKt.sourceInformation(v7, "C(Day)N(text,modifier,selected,onClick,animateChecked,enabled,today,inRange,description,colors)2012@92261L124,2017@92471L5,2020@92530L83,2031@92927L867,2004@91851L1943:DatePicker.kt#uh7d8r");
        String v9 = arg21;
        if((v10 & 6) == 0) {
            v5 = v7.changed(v9) ? 4 : 2;
            v5 |= v10;
        }
        else {
            v5 = v10;
        }

        if((v10 & 0x30) == 0) {
            v6 = v7.changed(v2) ? 0x20 : 16;
            v5 |= v6;
        }

        if((v10 & 0x180) == 0) {
            v6 = v7.changed(v3) ? 0x100 : 0x80;
            v5 |= v6;
        }

        Function0 v11 = arg24;
        if((v10 & 0xC00) == 0) {
            v6 = v7.changedInstance(v11) ? 0x800 : 0x400;
            v5 |= v6;
        }

        if((v10 & 0x6000) == 0) {
            v6_1 = arg25;
            v8 = v7.changed(v6_1) ? 0x4000 : 0x2000;
            v5 |= v8;
        }
        else {
            v6_1 = arg25;
        }

        if((0x30000 & v10) == 0) {
            v8_1 = arg26;
            v12 = v7.changed(v8_1) ? 0x20000 : 0x10000;
            v5 |= v12;
        }
        else {
            v8_1 = arg26;
        }

        if((0x180000 & v10) == 0) {
            v12 = v7.changed(v0) ? 0x100000 : 0x80000;
            v5 |= v12;
        }

        if((0xC00000 & v10) == 0) {
            v12_1 = arg28;
            v13 = v7.changed(v12_1) ? 0x800000 : 0x400000;
            v5 |= v13;
        }
        else {
            v12_1 = arg28;
        }

        if((0x6000000 & v10) == 0) {
            v13 = v7.changed(v1) ? 0x4000000 : 0x2000000;
            v5 |= v13;
        }

        if((0x30000000 & v10) == 0) {
            v13_1 = arg30;
            int v15 = v7.changed(v13_1) ? 0x20000000 : 0x10000000;
            v5 |= v15;
        }
        else {
            v13_1 = arg30;
        }

        int v16 = 0;
        boolean v14 = (306783379 & v5) != 306783378 ? true : false;
        if(v7.shouldExecute(v14, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xC7A70680, v5, -1, "androidx.compose.material3.Day (DatePicker.kt:2003)");
            }

            ComposerKt.sourceInformationMarkerStart(v7, 2046803100, "CC(remember):DatePicker.kt#9igjgp");
            if((0xE000000 & v5) == 0x4000000) {
                v16 = 1;
            }

            Object v4 = v7.rememberedValue();
            if(v16 != 0 || v4 == Composer.Companion.getEmpty()) {
                v4_1 = new DatePickerKt$$ExternalSyntheticLambda4(v1);
                v7.updateRememberedValue(v4_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v7);
            Modifier v15_1 = SemanticsModifierKt.semantics(v2, true, ((Function1)v4_1));
            Shape v14_1 = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getDateContainerShape(), v7, 6);
            int v4_2 = v5 >> 6;
            int v0_1 = v4_2 & 14 | v5 >> 12 & 0x70 | v4_2 & 0x380 | v5 >> 18 & 0x1C00;
            boolean v5_1 = v8_1;
            v8 = v0_1;
            v0_1 = v4_2;
            long v16_1 = v13_1.dayContainerColor$material3(v3, v5_1, v6_1, v7, v8).getValue().unbox-impl();
            BorderStroke v3_1 = !arg27 || (arg23) ? null : BorderStrokeKt.BorderStroke-cXLIe8U(DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineWidth-D9Ej5fM(), arg30.getTodayDateBorderColor-0d7_KjU());
            SurfaceKt.Surface-d85dljk(arg23, arg24, v15_1, arg26, v14_1, v16_1, 0, 0f, 0f, v3_1, null, ComposableLambdaKt.rememberComposableLambda(0x4322B196, true, new DatePickerKt$Day$2(v9, arg30, arg27, arg23, v12_1, arg26), v7, 54), v7, v0_1 & 7294, 0x30, 0x5C0);
            v7 = v7;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_216;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v7.skipToGroupEnd();
        }

    label_216:
        ScopeUpdateScope v12_2 = v7.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new DatePickerKt$$ExternalSyntheticLambda5(arg21, v2, arg23, arg24, arg25, arg26, arg27, arg28, v1, arg30, arg32));
        }
    }

    static final Unit Day$lambda$61$lambda$60(String arg3, SemanticsPropertyReceiver arg4) {
        SemanticsPropertiesKt.setText(arg4, new AnnotatedString(arg3, null, 2, null));
        SemanticsPropertiesKt.setRole-kuIjeqM(arg4, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Day$lambda$62(String arg13, Modifier arg14, boolean arg15, Function0 arg16, boolean arg17, boolean arg18, boolean arg19, boolean arg20, String arg21, DatePickerColors arg22, int arg23, Composer arg24, int arg25) {
        DatePickerKt.Day(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg24, RecomposeScopeImplKt.updateChangedFlags(arg23 | 1));
        return Unit.INSTANCE;
    }

    public static final void DisplayModeToggleButton-iUJLfQg(Modifier arg6, int arg7, Function1 arg8, DatePickerColors arg9, Composer arg10, int arg11) {
        int v2;
        int v1;
        int v0 = 0xA8E70E7B;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(DisplayModeToggleButton)N(modifier,displayMode:c#material3.DisplayMode,onDisplayModeChange,colors)1407@65496L658,1407@65415L739:DatePicker.kt#uh7d8r");
        if((arg11 & 6) == 0) {
            v1 = arg10.changed(arg6) ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v2 = arg10.changed(arg7) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg8) ? 0x100 : 0x80;
            v1 |= v2;
        }

        if((arg11 & 0xC00) == 0) {
            v2 = arg10.changed(arg9) ? 0x800 : 0x400;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 0x493) != 1170 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1406)");
            }

            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(arg9.getHeadlineContentColor-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(0x989D71BB, true, new DatePickerKt$DisplayModeToggleButton$1(arg7, arg8, arg6), arg10, 54), arg10, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_70;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_70:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new DatePickerKt$$ExternalSyntheticLambda19(arg6, arg7, arg8, arg9, arg11));
        }
    }

    static final Unit DisplayModeToggleButton_iUJLfQg$lambda$11(Modifier arg6, int arg7, Function1 arg8, DatePickerColors arg9, int arg10, Composer arg11, int arg12) {
        DatePickerKt.DisplayModeToggleButton-iUJLfQg(arg6, arg7, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }

    private static final void HorizontalMonthsList(LazyListState arg18, Long arg19, Function1 arg20, Function1 arg21, CalendarModel arg22, IntRange arg23, DatePickerFormatter arg24, SelectableDates arg25, DatePickerColors arg26, Composer arg27, int arg28) {
        DatePickerKt$HorizontalMonthsList$2$1 v0_4;
        DatePickerColors v9_1;
        SelectableDates v8_2;
        int v8;
        Function1 v5_1;
        Long v4;
        int v2;
        LazyListState v1 = arg18;
        CalendarModel v3 = arg22;
        IntRange v6 = arg23;
        DatePickerFormatter v7 = arg24;
        int v11 = arg28;
        int v0 = 0x891A68CB;
        Composer v12 = arg27.startRestartGroup(v0);
        ComposerKt.sourceInformation(v12, "C(HorizontalMonthsList)N(lazyListState,selectedDateMillis,onDateSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)1714@79349L159,1720@79570L5,1720@79577L1422,1720@79513L1486,1752@81035L229,1752@81005L259:DatePicker.kt#uh7d8r");
        if((v11 & 6) == 0) {
            v2 = v12.changed(v1) ? 4 : 2;
            v2 |= v11;
        }
        else {
            v2 = v11;
        }

        if((v11 & 0x30) == 0) {
            v4 = arg19;
            int v5 = v12.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
            v4 = arg19;
        }

        if((v11 & 0x180) == 0) {
            v5_1 = arg20;
            v8 = v12.changedInstance(v5_1) ? 0x100 : 0x80;
            v2 |= v8;
        }
        else {
            v5_1 = arg20;
        }

        Function1 v15 = arg21;
        if((v11 & 0xC00) == 0) {
            v8 = v12.changedInstance(v15) ? 0x800 : 0x400;
            v2 |= v8;
        }

        if((v11 & 0x6000) == 0) {
            v8 = v12.changedInstance(v3) ? 0x4000 : 0x2000;
            v2 |= v8;
        }

        if((0x30000 & v11) == 0) {
            v8 = v12.changedInstance(v6) ? 0x20000 : 0x10000;
            v2 |= v8;
        }

        if((0x180000 & v11) == 0) {
            boolean v8_1 = (0x200000 & v11) == 0 ? v12.changed(v7) : v12.changedInstance(v7);
            v8 = v8_1 ? 0x100000 : 0x80000;
            v2 |= v8;
        }

        if((0xC00000 & v11) == 0) {
            v8_2 = arg25;
            int v9 = v12.changed(v8_2) ? 0x800000 : 0x400000;
            v2 |= v9;
        }
        else {
            v8_2 = arg25;
        }

        if((0x6000000 & v11) == 0) {
            v9_1 = arg26;
            int v10 = v12.changed(v9_1) ? 0x4000000 : 0x2000000;
            v2 |= v10;
        }
        else {
            v9_1 = arg26;
        }

        int v16 = 0;
        boolean v10_1 = (0x2492493 & v2) != 0x2492492 ? true : false;
        if(v12.shouldExecute(v10_1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1711)");
            }

            CalendarDate v0_1 = v3.getToday();
            String v14 = "CC(remember):DatePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, -1406952310, v14);
            v10_1 = v12.changed(v6);
            Object v13 = v12.rememberedValue();
            if((v10_1) || v13 == Composer.Companion.getEmpty()) {
                CalendarMonth v10_2 = v3.getMonth(v6.getFirst(), 1);
                v12.updateRememberedValue(v10_2);
                CalendarMonth v13_1 = v10_2;
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            TextStyle v11_1 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), v12, 6);
            DatePickerColors v10_3 = v9_1;
            SelectableDates v9_2 = v8_2;
            DatePickerFormatter v8_3 = v7;
            Long v7_1 = v4;
            Object v4_1 = v13;
            int v13_2 = v2;
            DatePickerKt$HorizontalMonthsList$1 v0_2 = new DatePickerKt$HorizontalMonthsList$1(v1, v6, v3, ((CalendarMonth)v4_1), v5_1, v0_1, v7_1, v8_3, v9_2, v10_3);
            v6 = v6;
            TextKt.ProvideTextStyle(v11_1, ComposableLambdaKt.rememberComposableLambda(1504086906, true, v0_2, v12, 54), v12, 0x30);
            ComposerKt.sourceInformationMarkerStart(v12, 0xAC246F90, v14);
            int v7_2 = v13_2 & 14;
            v0 = v7_2 == 4 ? 1 : 0;
            if((v13_2 & 0x1C00) == 0x800) {
                v16 = 1;
            }

            v0 = v0 | v16 | v12.changedInstance(v3) | v12.changedInstance(v6);
            Object v1_1 = v12.rememberedValue();
            if(v0 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                v1 = arg18;
                v0_4 = new DatePickerKt$HorizontalMonthsList$2$1(v1, v15, v3, v6, null);
                v12.updateRememberedValue(v0_4);
            }
            else {
                Object v0_3 = v1_1;
                v1 = arg18;
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            EffectsKt.LaunchedEffect(v1, ((Function2)v0_4), v12, v7_2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_202;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v12.skipToGroupEnd();
        }

    label_202:
        ScopeUpdateScope v11_2 = v12.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new DatePickerKt$$ExternalSyntheticLambda16(v1, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg28));
        }
    }

    static final Unit HorizontalMonthsList$lambda$42(LazyListState arg12, Long arg13, Function1 arg14, Function1 arg15, CalendarModel arg16, IntRange arg17, DatePickerFormatter arg18, SelectableDates arg19, DatePickerColors arg20, int arg21, Composer arg22, int arg23) {
        DatePickerKt.HorizontalMonthsList(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg22, RecomposeScopeImplKt.updateChangedFlags(arg21 | 1));
        return Unit.INSTANCE;
    }

    private static final void IconButtonWithTooltip(Function0 arg19, ImageVector arg20, String arg21, Modifier arg22, boolean arg23, Composer arg24, int arg25, int arg26) {
        Modifier v4_2;
        boolean v5_4;
        Modifier v5_2;
        boolean v9;
        int v8;
        Modifier v7;
        int v5;
        ImageVector v4;
        Function0 v1;
        int v2;
        String v3 = arg21;
        int v6 = arg25;
        int v0 = 0xEA0FDA63;
        Composer v10 = arg24.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(IconButtonWithTooltip)N(onClick,icon,contentDescription,modifier,enabled)2282@102053L60,2283@102133L45,2284@102196L22,2285@102226L175,2280@101986L415:DatePicker.kt#uh7d8r");
        if((arg26 & 1) != 0) {
            v2 = v6 | 6;
            v1 = arg19;
        }
        else if((v6 & 6) == 0) {
            v1 = arg19;
            v2 = v10.changedInstance(v1) ? 4 : 2;
            v2 |= v6;
        }
        else {
            v1 = arg19;
            v2 = v6;
        }

        if((arg26 & 2) != 0) {
            v2 |= 0x30;
            goto label_39;
        }
        else if((v6 & 0x30) == 0) {
            v4 = arg20;
            v5 = v10.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_39:
            v4 = arg20;
        }

        if((arg26 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v6 & 0x180) == 0) {
            v5 = v10.changed(v3) ? 0x100 : 0x80;
            v2 |= v5;
        }

        v5 = arg26 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v6 & 0xC00) == 0) {
            v7 = arg22;
            v8 = v10.changed(v7) ? 0x800 : 0x400;
            v2 |= v8;
        }
        else {
        label_66:
            v7 = arg22;
        }

        v8 = arg26 & 16;
        if(v8 != 0) {
            v2 |= 0x6000;
            goto label_81;
        }
        else if((v6 & 0x6000) == 0) {
            v9 = arg23;
            int v11 = v10.changed(v9) ? 0x4000 : 0x2000;
            v2 |= v11;
        }
        else {
        label_81:
            v9 = arg23;
        }

        boolean v11_1 = (v2 & 9363) != 9362 ? true : false;
        if(v10.shouldExecute(v11_1, v2 & 1)) {
            if(v5 != 0) {
                Companion v5_1 = Modifier.Companion;
            }
            else {
                v5_2 = v7;
            }

            boolean v14 = v8 != 0 ? true : v9;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.IconButtonWithTooltip (DatePicker.kt:2279)");
            }

            PopupPositionProvider v15 = TooltipDefaults.INSTANCE.rememberTooltipPositionProvider-Hu5FAss(TooltipAnchorPosition.Companion.getAbove-lOKsHw4(), 0f, v10, 390, 2);
            ComposableLambda v16 = ComposableLambdaKt.rememberComposableLambda(0xE4CDD54E, true, new DatePickerKt$IconButtonWithTooltip$1(v3), v10, 54);
            Companion v2_1 = ((Companion)v5_2);
            String v5_3 = v3;
            boolean v3_1 = v14;
            TooltipKt.TooltipBox(v15, v16, TooltipKt.rememberTooltipState(false, false, null, v10, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(0xBCF34366, true, new DatePickerKt$IconButtonWithTooltip$2(v1, ((Modifier)v2_1), v3_1, v4, v5_3), v10, 54), v10, 0x6000030, 0xF8);
            v10 = v10;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v4_1 = v2_1;
            v5_4 = v3_1;
        }
        else {
            v10.skipToGroupEnd();
            v4_2 = v7;
            v5_4 = v9;
        }

        ScopeUpdateScope v8_1 = v10.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new DatePickerKt$$ExternalSyntheticLambda28(arg19, arg20, arg21, v4_2, v5_4, v6, arg26));
        }
    }

    static final Unit IconButtonWithTooltip$lambda$71(Function0 arg8, ImageVector arg9, String arg10, Modifier arg11, boolean arg12, int arg13, int arg14, Composer arg15, int arg16) {
        DatePickerKt.IconButtonWithTooltip(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    public static final void Month(CalendarMonth arg35, Function1 arg36, long arg37, Long arg39, Long arg40, SelectedRangeInfo arg41, DatePickerFormatter arg42, SelectableDates arg43, DatePickerColors arg44, Locale arg45, Composer arg46, int arg47) {
        String v33;
        Companion v11_2;
        Composer v10_2;
        int v22;
        String v5_6;
        boolean v16_1;
        int v46;
        Object v0_6;
        boolean v0_7;
        int v30;
        String v29;
        boolean v15_3;
        String v18_1;
        int v28;
        String v27;
        Modifier v0_1;
        Object v3_2;
        int v23;
        boolean v14_1;
        int v14;
        int v15;
        CalendarMonth v13;
        Function1 v2 = arg36;
        long v3 = arg37;
        Long v5 = arg39;
        Long v6 = arg40;
        SelectedRangeInfo v7 = arg41;
        DatePickerFormatter v8 = arg42;
        SelectableDates v9 = arg43;
        DatePickerColors v10 = arg44;
        Locale v11 = arg45;
        int v0 = arg47;
        Composer v12 = arg46.startRestartGroup(-333300603);
        ComposerKt.sourceInformation(v12, "C(Month)N(month,onDateSelectionChange,todayMillis,startDateMillis,endDateMillis,rangeSelectionInfo,dateFormatter,selectableDates,colors,locale)1856@84862L5585:DatePicker.kt#uh7d8r");
        if((v0 & 6) == 0) {
            v13 = arg35;
            v15 = v12.changed(v13) ? 4 : 2;
            v15 |= v0;
        }
        else {
            v13 = arg35;
            v15 = v0;
        }

        if((v0 & 0x30) == 0) {
            int v16 = v12.changedInstance(v2) ? 0x20 : 16;
            v15 |= v16;
        }

        if((v0 & 0x180) == 0) {
            v14 = v12.changed(v3) ? 0x100 : 0x80;
            v15 |= v14;
        }

        if((v0 & 0xC00) == 0) {
            v14 = v12.changed(v5) ? 0x800 : 0x400;
            v15 |= v14;
        }

        if((v0 & 0x6000) == 0) {
            v14 = v12.changed(v6) ? 0x4000 : 0x2000;
            v15 |= v14;
        }

        if((0x30000 & v0) == 0) {
            v14 = v12.changed(v7) ? 0x20000 : 0x10000;
            v15 |= v14;
        }

        if((0x180000 & v0) == 0) {
            v14_1 = (0x200000 & v0) == 0 ? v12.changed(v8) : v12.changedInstance(v8);
            v14 = v14_1 ? 0x100000 : 0x80000;
            v15 |= v14;
        }

        if((0xC00000 & v0) == 0) {
            v14 = v12.changed(v9) ? 0x800000 : 0x400000;
            v15 |= v14;
        }

        if((0x6000000 & v0) == 0) {
            v14 = v12.changed(v10) ? 0x4000000 : 0x2000000;
            v15 |= v14;
        }

        if((0x30000000 & v0) == 0) {
            v14 = v12.changedInstance(v11) ? 0x20000000 : 0x10000000;
            v15 |= v14;
        }

        v14 = v15;
        boolean v1 = (306783379 & v14) != 306783378 ? true : false;
        if(v12.shouldExecute(v1, v14 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-333300603, v14, -1, "androidx.compose.material3.Month (DatePicker.kt:1844)");
            }

            String v1_1 = "CC(remember):DatePicker.kt#9igjgp";
            if(v7 != null) {
                v12.startReplaceGroup(606579709);
                ComposerKt.sourceInformation(v12, "1847@84643L143");
                Companion v15_1 = Modifier.Companion;
                v23 = 0x70000;
                ComposerKt.sourceInformationMarkerStart(v12, 1820683604, v1_1);
                v0 = (v14 & v23) == 0x20000 ? 1 : 0;
                int v3_1 = (0xE000000 & v14) == 0x4000000 ? 1 : 0;
                v0 |= v3_1;
                v3_2 = v12.rememberedValue();
                if(v0 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                    DatePickerKt$$ExternalSyntheticLambda11 v3_3 = new DatePickerKt$$ExternalSyntheticLambda11(v7, v10);
                    v12.updateRememberedValue(v3_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v12);
                v0_1 = DrawModifierKt.drawWithContent(((Modifier)v15_1), ((Function1)v3_2));
                v12.endReplaceGroup();
            }
            else {
                v23 = 0x70000;
                v12.startReplaceGroup(606771165);
                v12.endReplaceGroup();
                Companion v0_2 = Modifier.Companion;
            }

            v0_1 = SizeKt.requiredHeight-3ABfNKs(Modifier.Companion, Dp.constructor-impl(DatePickerKt.RecommendedSizeForAccessibility * 6f)).then(v0_1);
            HorizontalOrVertical v3_4 = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(v12, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy v3_5 = ColumnKt.columnMeasurePolicy(((Vertical)v3_4), Alignment.Companion.getStart(), v12, 6);
            String v15_2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v15_2);
            int v18 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
            CompositionLocalMap v4 = v12.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(v12, v0_1);
            Function0 v5_1 = ComposeUiNode.Companion.getConstructor();
            String v7_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v7_1);
            if(!(v12.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12.startReusableNode();
            if(v12.getInserting()) {
                v12.createNode(v5_1);
            }
            else {
                v12.useNode();
            }

            Composer v5_2 = Updater.constructor-impl(v12);
            Updater.set-impl(v5_2, v3_5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_2, v4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_2.getInserting()) || !Intrinsics.areEqual(v5_2.rememberedValue(), Integer.valueOf(v18))) {
                v5_2.updateRememberedValue(Integer.valueOf(v18));
                v5_2.apply(Integer.valueOf(v18), v3_6);
            }

            Updater.set-impl(v5_2, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v12, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
            String v3_7 = "C:DatePicker.kt#uh7d8r";
            ComposerKt.sourceInformationMarkerStart(v12, 392093417, v3_7);
            v12.startReplaceGroup(-680088486);
            ComposerKt.sourceInformation(v12, "*1863@85155L5276");
            v0 = 0;
            int v4_1 = 0;
            int v5_3 = 6;
            while(v4_1 < v5_3) {
                v18 = v0;
                int v25 = v4_1;
                Modifier v5_4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0f, 1, null);
                HorizontalOrVertical v4_2 = Arrangement.INSTANCE.getSpaceEvenly();
                androidx.compose.ui.Alignment$Vertical v6_1 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(v12, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy v0_3 = RowKt.rowMeasurePolicy(((Horizontal)v4_2), v6_1, v12, 54);
                ComposerKt.sourceInformationMarkerStart(v12, -1323940314, v15_2);
                int v10_1 = ComposablesKt.getCurrentCompositeKeyHash(v12, 0);
                CompositionLocalMap v6_2 = v12.getCurrentCompositionLocalMap();
                v5_4 = ComposedModifierKt.materializeModifier(v12, v5_4);
                Function0 v4_3 = ComposeUiNode.Companion.getConstructor();
                int v19 = v10_1;
                ComposerKt.sourceInformationMarkerStart(v12, 0xD6BD0031, v7_1);
                if(!(v12.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v12.startReusableNode();
                if(v12.getInserting()) {
                    v12.createNode(v4_3);
                }
                else {
                    v12.useNode();
                }

                Composer v4_4 = Updater.constructor-impl(v12);
                Updater.set-impl(v4_4, v0_3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v4_4, v6_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v0_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v4_4.getInserting()) || !Intrinsics.areEqual(v4_4.rememberedValue(), Integer.valueOf(v19))) {
                    v4_4.updateRememberedValue(Integer.valueOf(v19));
                    v4_4.apply(Integer.valueOf(v19), v0_4);
                }

                Updater.set-impl(v4_4, v5_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v12, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v12, 0x225F022E, v3_7);
                v12.startReplaceGroup(0x5BF28C75);
                String v0_5 = "";
                ComposerKt.sourceInformation(v12, v0_5);
                v4_1 = v18;
                v5_3 = 0;
                while(v5_3 < 7) {
                    if(v4_1 < v13.getDaysFromStartOfWeekToFirstOfMonth() || v4_1 >= v13.getDaysFromStartOfWeekToFirstOfMonth() + v13.getNumberOfDays()) {
                        v29 = v0_5;
                        v33 = v1_1;
                        v27 = v3_7;
                        v28 = v4_1;
                        v30 = v5_3;
                        v10_2 = v12;
                        v22 = v14;
                        v5_6 = v15_2;
                        v10_2.startReplaceGroup(0x2261A7F0);
                        ComposerKt.sourceInformation(v10_2, "1886@86494L7,1887@86589L7,1879@86044L617");
                        Modifier v1_3 = SizeKt.sizeIn-qDBjuR0$default(Modifier.Companion, DatePickerModalTokens.INSTANCE.getDateContainerWidth-D9Ej5fM(), DatePickerModalTokens.INSTANCE.getDateContainerHeight-D9Ej5fM(), 0f, 0f, 12, null);
                        ProvidableCompositionLocal v3_8 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                        ComposerKt.sourceInformationMarkerStart(v10_2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        v3_2 = v10_2.consume(((CompositionLocal)v3_8));
                        ComposerKt.sourceInformationMarkerEnd(v10_2);
                        float v3_9 = ((Dp)v3_2).unbox-impl();
                        ProvidableCompositionLocal v11_3 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                        ComposerKt.sourceInformationMarkerStart(v10_2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object v4_6 = v10_2.consume(((CompositionLocal)v11_3));
                        ComposerKt.sourceInformationMarkerEnd(v10_2);
                        SpacerKt.Spacer(SizeKt.size-VpY3zN4(v1_3, v3_9, ((Dp)v4_6).unbox-impl()), v10_2, 0);
                        v10_2.endReplaceGroup();
                    }
                    else {
                        v12.startReplaceGroup(0x22724843);
                        ComposerKt.sourceInformation(v12, "1911@87935L366,1928@88871L39,1934@89278L567,1924@88619L1726");
                        int v6_3 = v4_1 - v13.getDaysFromStartOfWeekToFirstOfMonth();
                        v27 = v3_7;
                        v28 = v4_1;
                        v3 = v13.getStartUtcTimeMillis() + (((long)v6_3)) * 86400000;
                        boolean v13_1 = v3 == arg37 ? true : false;
                        if(arg39 == null) {
                            goto label_346;
                        }
                        else if(v3 == arg39.longValue()) {
                            v10_1 = v14;
                            v14_1 = true;
                        }
                        else {
                        label_346:
                            v10_1 = v14;
                            v14_1 = false;
                        }

                        if(arg40 == null) {
                            goto label_355;
                        }
                        else if(v3 == arg40.longValue()) {
                            v18_1 = v15_2;
                            v15_3 = true;
                        }
                        else {
                        label_355:
                            v18_1 = v15_2;
                            v15_3 = false;
                        }

                        if(arg41 != null) {
                            v29 = v0_5;
                            v12.startReplaceGroup(0x22791803);
                            ComposerKt.sourceInformation(v12, "1899@87271L435");
                            ComposerKt.sourceInformationMarkerStart(v12, 0x5BF367B4, v1_1);
                            v30 = v5_3;
                            v0 = (v10_1 & v23) == 0x20000 ? 1 : 0;
                            v0 |= v12.changed(v3);
                            Object v5_5 = v12.rememberedValue();
                            if(v0 != 0 || v5_5 == Composer.Companion.getEmpty()) {
                                long v19_1 = arg39 != null ? arg39.longValue() : 0x7FFFFFFFFFFFFFFFL;
                                if(v3 >= v19_1) {
                                    v19_1 = arg40 != null ? arg40.longValue() : -9223372036854775808L;
                                    if(v3 > v19_1) {
                                        goto label_397;
                                    }

                                    v0_7 = true;
                                }
                                else {
                                label_397:
                                    v0_7 = false;
                                }

                                v46 = v6_3;
                                v5_3 = 2;
                                MutableState v0_8 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(v0_7), null, v5_3, null);
                                v12.updateRememberedValue(v0_8);
                            }
                            else {
                                v0_6 = v5_5;
                                v46 = v6_3;
                                v5_3 = 2;
                            }

                            ComposerKt.sourceInformationMarkerEnd(v12);
                            v0_7 = ((MutableState)v0_6).getValue().booleanValue();
                            v12.endReplaceGroup();
                            v16_1 = v0_7;
                        }
                        else {
                            v29 = v0_5;
                            v30 = v5_3;
                            v46 = v6_3;
                            v5_3 = 2;
                            v12.startReplaceGroup(578890300);
                            v12.endReplaceGroup();
                            v16_1 = false;
                        }

                        v0 = 0x20;
                        Composer v20 = v12;
                        boolean v12_1 = arg41 != null ? true : false;
                        v0 = v10_1;
                        v5_6 = v18_1;
                        String v12_2 = DatePickerKt.dayContentDescription(v12_1, v13_1, v14_1, v15_3, v16_1, v20, 0);
                        boolean v18_2 = v13_1;
                        boolean v19_2 = v14_1;
                        boolean v21 = v15_3;
                        boolean v32 = v16_1;
                        String v13_2 = v8.formatDate(Long.valueOf(v3), v11, true);
                        if(v13_2 == null) {
                            v13_2 = v29;
                        }

                        v22 = v0;
                        v0_5 = v12_2;
                        v10_2 = v20;
                        String v6_4 = v13_2;
                        String v11_1 = CalendarLocale_jvmKt.toLocalString$default(v46 + 1, 0, 0, false, v11, 7, null);
                        Companion v12_3 = Modifier.Companion;
                        if((v19_2) || (v21)) {
                            v13_2 = v11_1;
                            v11_2 = v12_3;
                            v12_1 = true;
                        }
                        else {
                            v13_2 = v11_1;
                            v11_2 = v12_3;
                            v12_1 = false;
                        }

                        ComposerKt.sourceInformationMarkerStart(v10_2, 0x5BF42E28, v1_1);
                        v14 = (v22 & 0x70) == 0x20 ? 1 : 0;
                        v14 |= v10_2.changed(v3);
                        Object v15_4 = v10_2.rememberedValue();
                        if(v14 != 0 || v15_4 == Composer.Companion.getEmpty()) {
                            DatePickerKt$$ExternalSyntheticLambda22 v15_5 = new DatePickerKt$$ExternalSyntheticLambda22(v2, v3);
                            v10_2.updateRememberedValue(v15_5);
                        }

                        ComposerKt.sourceInformationMarkerEnd(v10_2);
                        ComposerKt.sourceInformationMarkerStart(v10_2, 0x5BF46318, v1_1);
                        v14_1 = v10_2.changed(v3);
                        v33 = v1_1;
                        int v1_2 = (v22 & 0x1C00000) == 0x800000 ? 1 : 0;
                        v1_2 |= ((int)v14_1);
                        Object v14_2 = v10_2.rememberedValue();
                        if(v1_2 != 0 || v14_2 == Composer.Companion.getEmpty()) {
                            boolean v4_5 = !v9.isSelectableYear(arg35.getYear()) || !v9.isSelectableDate(v3) ? false : true;
                            Boolean v14_3 = Boolean.valueOf(v4_5);
                            v10_2.updateRememberedValue(v14_3);
                        }

                        v1 = ((Boolean)v14_2).booleanValue();
                        ComposerKt.sourceInformationMarkerEnd(v10_2);
                        if(v0_5 != null) {
                            v6_4 = v0_5 + ", " + v6_4;
                        }

                        DatePickerKt.Day(v13_2, ((Modifier)v11_2), v12_1, v15_4, v19_2, v1, v18_2, v32, v6_4, arg44, v10_2, v22 << 3 & 0x70000000 | 0x30);
                        v10_2 = v10_2;
                        v10_2.endReplaceGroup();
                    }

                    v13 = arg35;
                    v2 = arg36;
                    v11 = arg45;
                    v4_1 = v28 + 1;
                    v15_2 = v5_6;
                    v12 = v10_2;
                    v14 = v22;
                    v0_5 = v29;
                    v1_1 = v33;
                    v5_3 = v30 + 1;
                    v3_7 = v27;
                }

                v28 = v4_1;
                v12.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(v12);
                ComposerKt.sourceInformationMarkerEnd(v12);
                v12.endNode();
                ComposerKt.sourceInformationMarkerEnd(v12);
                ComposerKt.sourceInformationMarkerEnd(v12);
                ComposerKt.sourceInformationMarkerEnd(v12);
                v13 = arg35;
                v2 = arg36;
                v11 = arg45;
                v4_1 = v25 + 1;
                v0 = v28;
                v5_3 = 6;
                v1_1 = v1_1;
            }

            v10_2 = v12;
            v10_2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(v10_2);
            ComposerKt.sourceInformationMarkerEnd(v10_2);
            v10_2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v10_2);
            ComposerKt.sourceInformationMarkerEnd(v10_2);
            ComposerKt.sourceInformationMarkerEnd(v10_2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_653;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v10_2 = v12;
            v10_2.skipToGroupEnd();
        }

    label_653:
        ScopeUpdateScope v13_3 = v10_2.endRestartGroup();
        if(v13_3 != null) {
            v13_3.updateScope(new DatePickerKt$$ExternalSyntheticLambda27(arg35, arg36, arg37, arg39, arg40, arg41, v8, v9, arg44, arg45, arg47));
        }
    }

    static final Unit Month$lambda$51$lambda$50(SelectedRangeInfo arg2, DatePickerColors arg3, ContentDrawScope arg4) {
        DateRangePickerKt.drawRangeBackground-mxwnekA(arg4, arg2, arg3.getDayInSelectionRangeContainerColor-0d7_KjU());
        arg4.drawContent();
        return Unit.INSTANCE;
    }

    static final Unit Month$lambda$58$lambda$57$lambda$54$lambda$53(Function1 arg0, long arg1) {
        arg0.invoke(Long.valueOf(arg1));
        return Unit.INSTANCE;
    }

    static final Unit Month$lambda$59(CalendarMonth arg14, Function1 arg15, long arg16, Long arg18, Long arg19, SelectedRangeInfo arg20, DatePickerFormatter arg21, SelectableDates arg22, DatePickerColors arg23, Locale arg24, int arg25, Composer arg26, int arg27) {
        DatePickerKt.Month(arg14, arg15, arg16, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg26, RecomposeScopeImplKt.updateChangedFlags(arg25 | 1));
        return Unit.INSTANCE;
    }

    private static final void MonthsNavigation(Modifier arg17, boolean arg18, boolean arg19, boolean arg20, String arg21, Function0 arg22, Function0 arg23, Function0 arg24, DatePickerColors arg25, Composer arg26, int arg27) {
        Horizontal v9_2;
        int v9;
        Function0 v7_1;
        int v7;
        int v6;
        Modifier v1 = arg17;
        boolean v2 = arg18;
        boolean v3 = arg19;
        boolean v5 = arg20;
        String v0 = arg21;
        Function0 v11 = arg22;
        Function0 v12 = arg23;
        DatePickerColors v13 = arg25;
        int v14 = arg27;
        int v4 = 0xD1DEC6D6;
        Composer v8 = arg26.startRestartGroup(v4);
        ComposerKt.sourceInformation(v8, "C(MonthsNavigation)N(modifier,nextAvailable,previousAvailable,yearPickerVisible,yearPickerText,onNextClicked,onPreviousClicked,onYearPickerButtonClicked,colors)2192@98798L2005:DatePicker.kt#uh7d8r");
        if((v14 & 6) == 0) {
            v6 = v8.changed(v1) ? 4 : 2;
            v6 |= v14;
        }
        else {
            v6 = v14;
        }

        if((v14 & 0x30) == 0) {
            v7 = v8.changed(v2) ? 0x20 : 16;
            v6 |= v7;
        }

        if((v14 & 0x180) == 0) {
            v7 = v8.changed(v3) ? 0x100 : 0x80;
            v6 |= v7;
        }

        if((v14 & 0xC00) == 0) {
            v7 = v8.changed(v5) ? 0x800 : 0x400;
            v6 |= v7;
        }

        if((v14 & 0x6000) == 0) {
            v7 = v8.changed(v0) ? 0x4000 : 0x2000;
            v6 |= v7;
        }

        if((0x30000 & v14) == 0) {
            v7 = v8.changedInstance(v11) ? 0x20000 : 0x10000;
            v6 |= v7;
        }

        if((0x180000 & v14) == 0) {
            v7 = v8.changedInstance(v12) ? 0x100000 : 0x80000;
            v6 |= v7;
        }

        if((0xC00000 & v14) == 0) {
            v7_1 = arg24;
            v9 = v8.changedInstance(v7_1) ? 0x800000 : 0x400000;
            v6 |= v9;
        }
        else {
            v7_1 = arg24;
        }

        if((0x6000000 & v14) == 0) {
            v9 = v8.changed(v13) ? 0x4000000 : 0x2000000;
            v6 |= v9;
        }

        boolean v9_1 = (0x2492493 & v6) != 0x2492492 ? true : false;
        if(v8.shouldExecute(v9_1, v6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v4, v6, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2191)");
            }

            Modifier v4_1 = SizeKt.requiredHeight-3ABfNKs(SizeKt.fillMaxWidth$default(v1, 0f, 1, null), DatePickerKt.MonthYearHeight);
            if(v5) {
                v9_2 = Arrangement.INSTANCE.getStart();
            }
            else {
                HorizontalOrVertical v9_3 = Arrangement.INSTANCE.getSpaceBetween();
            }

            androidx.compose.ui.Alignment$Vertical v10 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(v8, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v9_4 = RowKt.rowMeasurePolicy(v9_2, v10, v8, 0x30);
            ComposerKt.sourceInformationMarkerStart(v8, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v10_1 = ComposablesKt.getCurrentCompositeKeyHash(v8, 0);
            CompositionLocalMap v15 = v8.getCurrentCompositionLocalMap();
            v4_1 = ComposedModifierKt.materializeModifier(v8, v4_1);
            Function0 v1_1 = ComposeUiNode.Companion.getConstructor();
            int v16 = v6;
            ComposerKt.sourceInformationMarkerStart(v8, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v8.startReusableNode();
            if(v8.getInserting()) {
                v8.createNode(v1_1);
            }
            else {
                v8.useNode();
            }

            Composer v1_2 = Updater.constructor-impl(v8);
            Updater.set-impl(v1_2, v9_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_2, v15, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_2.getInserting()) || !Intrinsics.areEqual(v1_2.rememberedValue(), Integer.valueOf(v10_1))) {
                v1_2.updateRememberedValue(Integer.valueOf(v10_1));
                v1_2.apply(Integer.valueOf(v10_1), v5_1);
            }

            Updater.set-impl(v1_2, v4_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v8, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v8, 0x10BDD4BE, "C2203@99266L567,2203@99178L655:DatePicker.kt#uh7d8r");
            int v15_1 = 54;
            DatePickerKt.YearPickerMenuButton(v7_1, arg20, null, ComposableLambdaKt.rememberComposableLambda(619076006, true, new DatePickerKt$MonthsNavigation$1$1(v0, v13), v8, v15_1), v8, v16 >> 21 & 14 | 0xC00 | v16 >> 6 & 0x70, 4);
            if(!arg20) {
                v8.startReplaceGroup(0x10C94108);
                ComposerKt.sourceInformation(v8, "2219@100054L733,2219@99971L816");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(v13.getNavigationContentColor-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(0xF85A08F7, true, new DatePickerKt$MonthsNavigation$1$2(v12, v3, v11, v2), v8, v15_1), v8, ProvidedValue.$stable | 0x30);
                v8.endReplaceGroup();
            }
            else {
                v8.startReplaceGroup(0x10D59250);
                v8.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            v8.endNode();
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_233;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v8.skipToGroupEnd();
        }

    label_233:
        ScopeUpdateScope v15_2 = v8.endRestartGroup();
        if(v15_2 != null) {
            v15_2.updateScope(new DatePickerKt$$ExternalSyntheticLambda6(arg17, v2, v3, arg20, arg21, v11, v12, arg24, v13, v14));
        }
    }

    static final Unit MonthsNavigation$lambda$69(Modifier arg12, boolean arg13, boolean arg14, boolean arg15, String arg16, Function0 arg17, Function0 arg18, Function0 arg19, DatePickerColors arg20, int arg21, Composer arg22, int arg23) {
        DatePickerKt.MonthsNavigation(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg22, RecomposeScopeImplKt.updateChangedFlags(arg21 | 1));
        return Unit.INSTANCE;
    }

    private static final void SwitchableDateEntryContent-KaiTk9E(Long arg26, long arg27, int arg29, Function1 arg30, Function1 arg31, CalendarModel arg32, IntRange arg33, DatePickerFormatter arg34, SelectableDates arg35, DatePickerColors arg36, FocusRequester arg37, Composer arg38, int arg39, int arg40) {
        Composer v8_1;
        DatePickerKt$$ExternalSyntheticLambda14 v6_2;
        DatePickerKt$$ExternalSyntheticLambda13 v3_2;
        int v3;
        int v16;
        SelectableDates v15_2;
        int v15;
        IntRange v11_1;
        int v7;
        int v4;
        DatePickerFormatter v8 = arg34;
        int v13 = arg39;
        Composer v12 = arg38.startRestartGroup(-2053685029);
        ComposerKt.sourceInformation(v12, "C(SwitchableDateEntryContent)N(selectedDateMillis,displayedMonthMillis,displayMode:c#material3.DisplayMode,onDateSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)1446@66942L7,1449@67152L7,1451@67264L7,1453@67385L7,1455@67503L7,1459@67617L216,1465@67860L1708,1497@69626L1136,1456@67515L3247:DatePicker.kt#uh7d8r");
        if((v13 & 6) == 0) {
            v4 = v12.changed(arg26) ? 4 : 2;
            v4 |= v13;
        }
        else {
            v4 = v13;
        }

        if((v13 & 0x30) == 0) {
            v7 = v12.changed(arg27) ? 0x20 : 16;
            v4 |= v7;
        }

        int v14 = arg29;
        if((v13 & 0x180) == 0) {
            v7 = v12.changed(v14) ? 0x100 : 0x80;
            v4 |= v7;
        }

        if((v13 & 0xC00) == 0) {
            int v9 = v12.changedInstance(arg30) ? 0x800 : 0x400;
            v4 |= v9;
        }

        if((v13 & 0x6000) == 0) {
            int v10 = v12.changedInstance(arg31) ? 0x4000 : 0x2000;
            v4 |= v10;
        }

        if((0x30000 & v13) == 0) {
            int v11 = v12.changedInstance(arg32) ? 0x20000 : 0x10000;
            v4 |= v11;
        }

        if((0x180000 & v13) == 0) {
            v11_1 = arg33;
            v15 = v12.changedInstance(v11_1) ? 0x100000 : 0x80000;
            v4 |= v15;
        }
        else {
            v11_1 = arg33;
        }

        if((0xC00000 & v13) == 0) {
            boolean v15_1 = (0x1000000 & v13) == 0 ? v12.changed(v8) : v12.changedInstance(v8);
            v15 = v15_1 ? 0x800000 : 0x400000;
            v4 |= v15;
        }

        if((0x6000000 & v13) == 0) {
            v15_2 = arg35;
            v16 = v12.changed(v15_2) ? 0x4000000 : 0x2000000;
            v4 |= v16;
        }
        else {
            v15_2 = arg35;
        }

        DatePickerColors v2 = arg36;
        if((v13 & 0x30000000) == 0) {
            v16 = v12.changed(v2) ? 0x20000000 : 0x10000000;
            v4 |= v16;
        }

        FocusRequester v0 = arg37;
        if((arg40 & 6) == 0) {
            int v17 = v12.changed(v0) ? 4 : 2;
            v3 = arg40 | v17;
        }
        else {
            v3 = arg40;
        }

        boolean v0_1 = (v4 & 306783379) != 306783378 || (v3 & 3) != 2 ? true : false;
        if(v12.shouldExecute(v0_1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2053685029, v4, v3, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1443)");
            }

            ProvidableCompositionLocal v0_2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_3 = v12.consume(((CompositionLocal)v0_2));
            ComposerKt.sourceInformationMarkerEnd(v12);
            int v0_4 = -((Density)v0_3).roundToPx-0680j_4(Dp.constructor-impl(48f));
            FiniteAnimationSpec v1 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v12, 6);
            FiniteAnimationSpec v2_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v12, 6);
            v16 = v4;
            FiniteAnimationSpec v4_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v12, 6);
            FiniteAnimationSpec v5 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v12, 6);
            DisplayMode v24 = DisplayMode.box-impl(v14);
            Companion v6 = Modifier.Companion;
            String v7_1 = "CC(remember):DatePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, 2093685971, v7_1);
            Object v3_1 = v12.rememberedValue();
            if(v3_1 == Composer.Companion.getEmpty()) {
                v3_2 = new DatePickerKt$$ExternalSyntheticLambda13();
                v12.updateRememberedValue(v3_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            Modifier v17_1 = SemanticsModifierKt.semantics$default(((Modifier)v6), false, ((Function1)v3_2), 1, null);
            ComposerKt.sourceInformationMarkerStart(v12, 0x7CCB4107, v7_1);
            v3 = v12.changedInstance(v4_1) | v12.changedInstance(v1) | v12.changedInstance(v2_1) | v12.changed(v0_4) | v12.changedInstance(v5);
            Object v6_1 = v12.rememberedValue();
            if(v3 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                v6_2 = new DatePickerKt$$ExternalSyntheticLambda14(v4_1, v1, v2_1, v0_4, v5);
                v12.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            v8_1 = v12;
            AnimatedContentKt.AnimatedContent(v24, v17_1, v6_2, null, "DatePickerDisplayModeAnimation", null, ComposableLambdaKt.rememberComposableLambda(1838500091, true, new DatePickerKt$SwitchableDateEntryContent$3(arg26, arg27, arg30, arg31, arg32, v11_1, arg34, v15_2, arg36, arg37), v12, 54), v8_1, v16 >> 6 & 14 | 0x186000, 40);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_253;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v8_1 = v12;
            v8_1.skipToGroupEnd();
        }

    label_253:
        ScopeUpdateScope v15_3 = v8_1.endRestartGroup();
        if(v15_3 != null) {
            v15_3.updateScope(new DatePickerKt$$ExternalSyntheticLambda15(arg26, arg27, v14, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, v13, arg40));
        }
    }

    static final Unit SwitchableDateEntryContent_KaiTk9E$lambda$14$lambda$13(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContainer(arg1, true);
        return Unit.INSTANCE;
    }

    static final ContentTransform SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20(FiniteAnimationSpec arg4, FiniteAnimationSpec arg5, FiniteAnimationSpec arg6, int arg7, FiniteAnimationSpec arg8, AnimatedContentTransitionScope arg9) {
        Object v1 = null;
        int v2 = 2;
        ContentTransform v4 = DisplayMode.equals-impl0(arg9.getTargetState().unbox-impl(), DisplayMode.Companion.getInput-jFl-4v0()) ? AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(arg4, new DatePickerKt$$ExternalSyntheticLambda7()).plus(EnterExitTransitionKt.fadeIn$default(arg5, 0f, v2, v1)), EnterExitTransitionKt.fadeOut$default(arg6, 0f, v2, v1).plus(EnterExitTransitionKt.slideOutVertically(arg4, new DatePickerKt$$ExternalSyntheticLambda8(arg7)))) : AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(arg4, new DatePickerKt$$ExternalSyntheticLambda9(arg7)).plus(EnterExitTransitionKt.fadeIn$default(arg5, 0f, v2, v1)), EnterExitTransitionKt.slideOutVertically(arg4, new DatePickerKt$$ExternalSyntheticLambda10()).plus(EnterExitTransitionKt.fadeOut$default(arg6, 0f, v2, v1)));
        return arg9.using(v4, AnimatedContentKt.SizeTransform(true, new DatePickerKt$$ExternalSyntheticLambda12(arg8)));
    }

    static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$15(int arg0) {
        return arg0;
    }

    static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$16(int arg0, int arg1) {
        return arg0;
    }

    static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$17(int arg0, int arg1) {
        return arg0;
    }

    static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$18(int arg0) {
        return arg0;
    }

    static final FiniteAnimationSpec SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$19(FiniteAnimationSpec arg0, IntSize arg1, IntSize arg2) {
        return arg0;
    }

    static final Unit SwitchableDateEntryContent_KaiTk9E$lambda$22(Long arg16, long arg17, int arg19, Function1 arg20, Function1 arg21, CalendarModel arg22, IntRange arg23, DatePickerFormatter arg24, SelectableDates arg25, DatePickerColors arg26, FocusRequester arg27, int arg28, int arg29, Composer arg30, int arg31) {
        DatePickerKt.SwitchableDateEntryContent-KaiTk9E(arg16, arg17, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), RecomposeScopeImplKt.updateChangedFlags(arg29));
        return Unit.INSTANCE;
    }

    public static final void WeekDays(DatePickerColors arg38, CalendarModel arg39, Composer arg40, int arg41) {
        Composer v26;
        DatePickerKt$$ExternalSyntheticLambda31 v13_2;
        int v6;
        int v5;
        DatePickerColors v0 = arg38;
        CalendarModel v1 = arg39;
        int v2 = arg41;
        int v3 = 0x91C365D1;
        Composer v4 = arg40.startRestartGroup(v3);
        ComposerKt.sourceInformation(v4, "C(WeekDays)N(colors,calendarModel)1793@82488L5,1795@82499L1567:DatePicker.kt#uh7d8r");
        if((v2 & 6) == 0) {
            v5 = v4.changed(v0) ? 4 : 2;
            v5 |= v2;
        }
        else {
            v5 = v2;
        }

        if((v2 & 0x30) == 0) {
            v6 = v4.changedInstance(v1) ? 0x20 : 16;
            v5 |= v6;
        }

        boolean v8 = false;
        boolean v6_1 = (v5 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v6_1, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v5, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1782)");
            }

            v3 = v1.getFirstDayOfWeek();
            List v5_1 = v1.getWeekdayNames();
            ArrayList v6_2 = new ArrayList();
            --v3;
            int v7 = v5_1.size();
            int v10;
            for(v10 = v3; v10 < v7; ++v10) {
                v6_2.add(v5_1.get(v10));
            }

            for(v7 = 0; v7 < v3; ++v7) {
                v6_2.add(v5_1.get(v7));
            }

            TextStyle v25 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont(), v4, 6);
            Modifier v3_1 = SizeKt.fillMaxWidth$default(SizeKt.defaultMinSize-VpY3zN4$default(Modifier.Companion, 0f, DatePickerKt.RecommendedSizeForAccessibility, 1, null), 0f, 1, null);
            HorizontalOrVertical v5_2 = Arrangement.INSTANCE.getSpaceEvenly();
            androidx.compose.ui.Alignment$Vertical v7_1 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(v4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v5_3 = RowKt.rowMeasurePolicy(((Horizontal)v5_2), v7_1, v4, 54);
            String v9 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v4, -1323940314, v9);
            int v11 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
            CompositionLocalMap v12 = v4.getCurrentCompositionLocalMap();
            v3_1 = ComposedModifierKt.materializeModifier(v4, v3_1);
            Function0 v13 = ComposeUiNode.Companion.getConstructor();
            String v15 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v4, 0xD6BD0031, v15);
            if(!(v4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v4.startReusableNode();
            if(v4.getInserting()) {
                v4.createNode(v13);
            }
            else {
                v4.useNode();
            }

            Composer v10_1 = Updater.constructor-impl(v4);
            Updater.set-impl(v10_1, v5_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_1, v12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_1.getInserting()) || !Intrinsics.areEqual(v10_1.rememberedValue(), Integer.valueOf(v11))) {
                v10_1.updateRememberedValue(Integer.valueOf(v11));
                v10_1.apply(Integer.valueOf(v11), v5_4);
            }

            Updater.set-impl(v10_1, v3_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v4, 0x2D62D477, "C:DatePicker.kt#uh7d8r");
            v4.startReplaceGroup(0x176CE23);
            ComposerKt.sourceInformation(v4, "*1804@82866L33,1814@83567L7,1815@83650L7,1802@82784L1266");
            ArrayList v3_2 = v6_2;
            v5 = v3_2.size();
            v6 = 0;
            while(v6 < v5) {
                Object v10_2 = ((List)v3_2).get(v6);
                Companion v11_1 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v4, 1806140369, "CC(remember):DatePicker.kt#9igjgp");
                boolean v12_1 = v4.changed(v10_2);
                Object v13_1 = v4.rememberedValue();
                if((v12_1) || v13_1 == Composer.Companion.getEmpty()) {
                    v13_2 = new DatePickerKt$$ExternalSyntheticLambda31(((Pair)v10_2));
                    v4.updateRememberedValue(v13_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                Modifier v11_2 = SizeKt.sizeIn-qDBjuR0$default(SemanticsModifierKt.clearAndSetSemantics(((Modifier)v11_1), ((Function1)v13_2)), DatePickerModalTokens.INSTANCE.getDateContainerWidth-D9Ej5fM(), DatePickerModalTokens.INSTANCE.getDateContainerHeight-D9Ej5fM(), 0f, 0f, 12, null);
                ProvidableCompositionLocal v12_2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object v12_3 = v4.consume(((CompositionLocal)v12_2));
                ComposerKt.sourceInformationMarkerEnd(v4);
                float v12_4 = ((Dp)v12_3).unbox-impl();
                ProvidableCompositionLocal v7_2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object v7_3 = v4.consume(((CompositionLocal)v7_2));
                ComposerKt.sourceInformationMarkerEnd(v4);
                Modifier v7_4 = SizeKt.size-VpY3zN4(v11_2, v12_4, ((Dp)v7_3).unbox-impl());
                Alignment v11_3 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(v4, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy v11_4 = BoxKt.maybeCachedBoxMeasurePolicy(v11_3, v8);
                ComposerKt.sourceInformationMarkerStart(v4, -1323940314, v9);
                int v13_3 = ComposablesKt.getCurrentCompositeKeyHash(v4, ((int)v8));
                CompositionLocalMap v14 = v4.getCurrentCompositionLocalMap();
                v7_4 = ComposedModifierKt.materializeModifier(v4, v7_4);
                Function0 v12_5 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4, 0xD6BD0031, v15);
                if(!(v4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4.startReusableNode();
                if(v4.getInserting()) {
                    v4.createNode(v12_5);
                }
                else {
                    v4.useNode();
                }

                Composer v8_1 = Updater.constructor-impl(v4);
                Updater.set-impl(v8_1, v11_4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v8_1, v14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v11_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v8_1.getInserting()) || !Intrinsics.areEqual(v8_1.rememberedValue(), Integer.valueOf(v13_3))) {
                    v8_1.updateRememberedValue(Integer.valueOf(v13_3));
                    v8_1.apply(Integer.valueOf(v13_3), v11_5);
                }

                Updater.set-impl(v8_1, v7_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v4, -1708069020, "C1819@83771L265:DatePicker.kt#uh7d8r");
                TextKt.Text-Nvy7gAk(((Pair)v10_2).getSecond(), SizeKt.wrapContentSize$default(Modifier.Companion, null, false, 3, null), v0.getWeekdayContentColor-0d7_KjU(), null, 0, null, null, null, 0, null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0, 0, false, 0, 0, null, v25, v4, 0x30, 0, 130040);
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                ++v6;
                v4 = v4;
                v9 = v9;
                v8 = false;
                v5 = v5;
                v15 = v15;
            }

            v26 = v4;
            v26.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(v26);
            ComposerKt.sourceInformationMarkerEnd(v26);
            v26.endNode();
            ComposerKt.sourceInformationMarkerEnd(v26);
            ComposerKt.sourceInformationMarkerEnd(v26);
            ComposerKt.sourceInformationMarkerEnd(v26);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_308;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v26 = v4;
            v26.skipToGroupEnd();
        }

    label_308:
        ScopeUpdateScope v3_3 = v26.endRestartGroup();
        if(v3_3 != null) {
            v3_3.updateScope(new DatePickerKt$$ExternalSyntheticLambda32(v0, v1, v2));
        }
    }

    static final Unit WeekDays$lambda$48$lambda$47$lambda$45$lambda$44(Pair arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentDescription(arg1, arg0.getFirst());
        return Unit.INSTANCE;
    }

    static final Unit WeekDays$lambda$49(DatePickerColors arg0, CalendarModel arg1, int arg2, Composer arg3, int arg4) {
        DatePickerKt.WeekDays(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final void Year(String arg23, Modifier arg24, boolean arg25, boolean arg26, Function0 arg27, boolean arg28, String arg29, DatePickerColors arg30, Composer arg31, int arg32) {
        Composer v17;
        DatePickerKt$$ExternalSyntheticLambda17 v4_3;
        BorderStroke v13_2;
        int v14;
        int v11;
        int v10;
        String v7;
        Modifier v2 = arg24;
        boolean v3 = arg25;
        boolean v6 = arg26;
        boolean v8 = arg28;
        String v0 = arg29;
        DatePickerColors v5 = arg30;
        int v1 = arg32;
        int v4 = -1153850597;
        Composer v9 = arg31.startRestartGroup(v4);
        ComposerKt.sourceInformation(v9, "C(Year)N(text,modifier,selected,currentYear,onClick,enabled,description,colors)2130@96589L394,2148@97358L112,2153@97566L5,2154@97596L58,2156@97693L638,2141@96988L1343:DatePicker.kt#uh7d8r");
        if((v1 & 6) == 0) {
            v7 = arg23;
            v10 = v9.changed(v7) ? 4 : 2;
            v10 |= v1;
        }
        else {
            v7 = arg23;
            v10 = v1;
        }

        if((v1 & 0x30) == 0) {
            v11 = v9.changed(v2) ? 0x20 : 16;
            v10 |= v11;
        }

        if((v1 & 0x180) == 0) {
            v11 = v9.changed(v3) ? 0x100 : 0x80;
            v10 |= v11;
        }

        int v13 = 0x800;
        if((v1 & 0xC00) == 0) {
            v11 = v9.changed(v6) ? v13 : 0x400;
            v10 |= v11;
        }

        if((v1 & 0x6000) == 0) {
            v14 = v9.changedInstance(arg27) ? 0x4000 : 0x2000;
            v10 |= v14;
        }

        if((0x30000 & v1) == 0) {
            v14 = v9.changed(v8) ? 0x20000 : 0x10000;
            v10 |= v14;
        }

        if((0x180000 & v1) == 0) {
            v14 = v9.changed(v0) ? 0x100000 : 0x80000;
            v10 |= v14;
        }

        if((0xC00000 & v1) == 0) {
            v14 = v9.changed(v5) ? 0x800000 : 0x400000;
            v10 |= v14;
        }

        int v16 = 0;
        boolean v14_1 = (0x492493 & v10) != 4793490 ? true : false;
        if(v9.shouldExecute(v14_1, v10 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v4, v10, -1, "androidx.compose.material3.Year (DatePicker.kt:2128)");
            }

            String v14_2 = "CC(remember):DatePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, 0xD35D6965, v14_2);
            v4 = (v10 & 0x1C00) == v13 ? 1 : 0;
            v13 = (v10 & 0x380) == 0x100 ? 1 : 0;
            v4 |= v13;
            Object v13_1 = v9.rememberedValue();
            if(v4 != 0 || v13_1 == Composer.Companion.getEmpty()) {
                BorderStroke v4_1 = !v6 || (v3) ? null : BorderStrokeKt.BorderStroke-cXLIe8U(DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineWidth-D9Ej5fM(), v5.getTodayDateBorderColor-0d7_KjU());
                v13_2 = v4_1;
                v9.updateRememberedValue(v13_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerStart(v9, 0xD35DC86B, v14_2);
            if((0x380000 & v10) == 0x100000) {
                v16 = 1;
            }

            Object v4_2 = v9.rememberedValue();
            if(v16 != 0 || v4_2 == Composer.Companion.getEmpty()) {
                v4_3 = new DatePickerKt$$ExternalSyntheticLambda17(v0);
                v9.updateRememberedValue(v4_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            Modifier v12 = SemanticsModifierKt.semantics(v2, true, ((Function1)v4_3));
            v4 = v10 >> 6;
            v16 = v4 & 14;
            v17 = v9;
            SurfaceKt.Surface-d85dljk(arg25, arg27, v12, arg28, ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), v9, 6), v5.yearContainerColor$material3(v3, v8, v9, v16 | v10 >> 12 & 0x70 | v10 >> 15 & 0x380).getValue().unbox-impl(), 0, 0f, 0f, v13_2, null, ComposableLambdaKt.rememberComposableLambda(-564400443, true, new DatePickerKt$Year$2(v7, v5, v6, arg25, v8), v9, 54), v17, v16 | v10 >> 9 & 0x70 | v4 & 0x1C00, 0x30, 0x5C0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_205;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v17 = v9;
            v17.skipToGroupEnd();
        }

    label_205:
        ScopeUpdateScope v10_1 = v17.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new DatePickerKt$$ExternalSyntheticLambda18(arg23, v2, arg25, arg26, arg27, arg28, arg29, arg30, v1));
        }
    }

    static final Unit Year$lambda$66$lambda$65(String arg3, SemanticsPropertyReceiver arg4) {
        SemanticsPropertiesKt.setText(arg4, new AnnotatedString(arg3, null, 2, null));
        SemanticsPropertiesKt.setRole-kuIjeqM(arg4, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Year$lambda$67(String arg11, Modifier arg12, boolean arg13, boolean arg14, Function0 arg15, boolean arg16, String arg17, DatePickerColors arg18, int arg19, Composer arg20, int arg21) {
        DatePickerKt.Year(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    private static final void YearPicker(Modifier arg19, long arg20, Function1 arg22, SelectableDates arg23, CalendarModel arg24, IntRange arg25, DatePickerColors arg26, Composer arg27, int arg28) {
        int v3;
        int v2;
        int v9 = arg28;
        int v0 = 0xB34B779C;
        Composer v1 = arg27.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(YearPicker)N(modifier,displayedMonthMillis,onYearSelected,selectableDates,calendarModel,yearRange,colors)2069@94140L5,2069@94147L2061,2069@94066L2142:DatePicker.kt#uh7d8r");
        Modifier v15 = arg19;
        if((v9 & 6) == 0) {
            v2 = v1.changed(v15) ? 4 : 2;
            v2 |= v9;
        }
        else {
            v2 = v9;
        }

        long v12 = arg20;
        if((v9 & 0x30) == 0) {
            v3 = v1.changed(v12) ? 0x20 : 16;
            v2 |= v3;
        }

        Function1 v4 = arg22;
        if((v9 & 0x180) == 0) {
            v3 = v1.changedInstance(v4) ? 0x100 : 0x80;
            v2 |= v3;
        }

        SelectableDates v5 = arg23;
        if((v9 & 0xC00) == 0) {
            v3 = v1.changed(v5) ? 0x800 : 0x400;
            v2 |= v3;
        }

        CalendarModel v6 = arg24;
        if((v9 & 0x6000) == 0) {
            v3 = v1.changedInstance(v6) ? 0x4000 : 0x2000;
            v2 |= v3;
        }

        IntRange v7 = arg25;
        if((0x30000 & v9) == 0) {
            v3 = v1.changedInstance(v7) ? 0x20000 : 0x10000;
            v2 |= v3;
        }

        DatePickerColors v8 = arg26;
        if((0x180000 & v9) == 0) {
            v3 = v1.changed(v8) ? 0x100000 : 0x80000;
            v2 |= v3;
        }

        boolean v3_1 = (0x92493 & v2) != 0x92492 ? true : false;
        if(v1.shouldExecute(v3_1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:2068)");
            }

            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont(), v1, 6), ComposableLambdaKt.rememberComposableLambda(1301915789, true, new DatePickerKt$YearPicker$1(v6, v12, v7, v15, v8, v4, v5), v1, 54), v1, 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_111;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
        }

    label_111:
        ScopeUpdateScope v10 = v1.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new DatePickerKt$$ExternalSyntheticLambda3(arg19, arg20, arg22, arg23, arg24, arg25, arg26, v9));
        }
    }

    static final Unit YearPicker$lambda$63(Modifier arg11, long arg12, Function1 arg14, SelectableDates arg15, CalendarModel arg16, IntRange arg17, DatePickerColors arg18, int arg19, Composer arg20, int arg21) {
        DatePickerKt.YearPicker(arg11, arg12, arg14, arg15, arg16, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    private static final void YearPickerMenuButton(Function0 arg20, boolean arg21, Modifier arg22, Function2 arg23, Composer arg24, int arg25, int arg26) {
        Companion v18;
        int v8;
        Modifier v7;
        int v6;
        Function0 v1;
        int v3;
        boolean v2 = arg21;
        Function2 v4 = arg23;
        int v5 = arg25;
        int v0 = 0xD5AF6EFF;
        Composer v15 = arg24.startRestartGroup(v0);
        ComposerKt.sourceInformation(v15, "C(YearPickerMenuButton)N(onClick,expanded,modifier,content)2252@101224L7,2252@101174L58,2255@101289L454,2248@101045L698:DatePicker.kt#uh7d8r");
        if((arg26 & 1) != 0) {
            v3 = v5 | 6;
            v1 = arg20;
        }
        else if((v5 & 6) == 0) {
            v1 = arg20;
            v3 = v15.changedInstance(v1) ? 4 : 2;
            v3 |= v5;
        }
        else {
            v1 = arg20;
            v3 = v5;
        }

        if((arg26 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v5 & 0x30) == 0) {
            v6 = v15.changed(v2) ? 0x20 : 16;
            v3 |= v6;
        }

        v6 = arg26 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_52;
        }
        else if((v5 & 0x180) == 0) {
            v7 = arg22;
            v8 = v15.changed(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_52:
            v7 = arg22;
        }

        if((arg26 & 8) != 0) {
            v3 |= 0xC00;
        }
        else if((v5 & 0xC00) == 0) {
            v8 = v15.changedInstance(v4) ? 0x800 : 0x400;
            v3 |= v8;
        }

        boolean v8_1 = (v3 & 0x493) != 1170 ? true : false;
        if(v15.shouldExecute(v8_1, v3 & 1)) {
            if(v6 != 0) {
                v18 = Modifier.Companion;
            }
            else {
                Modifier v18_1 = v7;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2247)");
            }

            RoundedCornerShape v0_1 = RoundedCornerShapeKt.getCircleShape();
            ButtonDefaults v6_1 = ButtonDefaults.INSTANCE;
            ProvidableCompositionLocal v7_1 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v7_2 = v15.consume(((CompositionLocal)v7_1));
            ComposerKt.sourceInformationMarkerEnd(v15);
            ButtonColors v10 = v6_1.textButtonColors-ro_MJ88(0, ((Color)v7_2).unbox-impl(), 0, 0, v15, 0x6000, 13);
            Companion v7_3 = v18;
            ButtonKt.TextButton(v1, ((Modifier)v7_3), false, v0_1, v10, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1899489890, true, new DatePickerKt$YearPickerMenuButton$1(v4, v2), v15, 54), v15, v3 & 14 | 0x301B0000 | v3 >> 3 & 0x70, 388);
            v15 = v15;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_135;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v15.skipToGroupEnd();
        }

    label_135:
        Modifier v3_1 = v7;
        ScopeUpdateScope v7_4 = v15.endRestartGroup();
        if(v7_4 != null) {
            v7_4.updateScope(new DatePickerKt$$ExternalSyntheticLambda33(arg20, v2, v3_1, v4, v5, arg26));
        }
    }

    static final Unit YearPickerMenuButton$lambda$70(Function0 arg7, boolean arg8, Modifier arg9, Function2 arg10, int arg11, int arg12, Composer arg13, int arg14) {
        DatePickerKt.YearPickerMenuButton(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public static final void access$DatePickerContent(Long arg0, long arg1, Function1 arg3, Function1 arg4, CalendarModel arg5, IntRange arg6, DatePickerFormatter arg7, SelectableDates arg8, DatePickerColors arg9, Composer arg10, int arg11) {
        DatePickerKt.DatePickerContent(arg0, arg1, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static final boolean access$DatePickerContent$lambda$26(MutableState arg0) {
        return DatePickerKt.DatePickerContent$lambda$26(arg0);
    }

    public static final void access$DatePickerContent$lambda$27(MutableState arg0, boolean arg1) {
        DatePickerKt.DatePickerContent$lambda$27(arg0, arg1);
    }

    public static final void access$IconButtonWithTooltip(Function0 arg0, ImageVector arg1, String arg2, Modifier arg3, boolean arg4, Composer arg5, int arg6, int arg7) {
        DatePickerKt.IconButtonWithTooltip(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final void access$SwitchableDateEntryContent-KaiTk9E(Long arg0, long arg1, int arg3, Function1 arg4, Function1 arg5, CalendarModel arg6, IntRange arg7, DatePickerFormatter arg8, SelectableDates arg9, DatePickerColors arg10, FocusRequester arg11, Composer arg12, int arg13, int arg14) {
        DatePickerKt.SwitchableDateEntryContent-KaiTk9E(arg0, arg1, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    public static final void access$Year(String arg0, Modifier arg1, boolean arg2, boolean arg3, Function0 arg4, boolean arg5, String arg6, DatePickerColors arg7, Composer arg8, int arg9) {
        DatePickerKt.Year(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public static final void access$YearPicker(Modifier arg0, long arg1, Function1 arg3, SelectableDates arg4, CalendarModel arg5, IntRange arg6, DatePickerColors arg7, Composer arg8, int arg9) {
        DatePickerKt.YearPicker(arg0, arg1, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public static final PaddingValues access$getDatePickerHeadlinePadding$p() {
        return DatePickerKt.DatePickerHeadlinePadding;
    }

    public static final PaddingValues access$getDatePickerTitlePadding$p() {
        return DatePickerKt.DatePickerTitlePadding;
    }

    public static final float access$getYearsVerticalPadding$p() {
        return DatePickerKt.YearsVerticalPadding;
    }

    private static final String dayContentDescription(boolean arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, Composer arg8, int arg9) {
        int v1 = 502032503;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(dayContentDescription)N(rangeSelectionEnabled,isToday,isStartDate,isEndDate,isInRange):DatePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1972)");
        }

        StringBuilder v9 = new StringBuilder();
        if(arg3) {
            arg8.startReplaceGroup(0x3A14EF97);
            ComposerKt.sourceInformation(arg8, "");
            if(arg5) {
                arg8.startReplaceGroup(1416909399);
                ComposerKt.sourceInformation(arg8, "1977@90977L56");
                v9.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_picker_start_headline), arg8, 0));
                arg8.endReplaceGroup();
            }
            else if(arg6) {
                arg8.startReplaceGroup(0x547461F5);
                ComposerKt.sourceInformation(arg8, "1979@91102L54");
                v9.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_picker_end_headline), arg8, 0));
                arg8.endReplaceGroup();
            }
            else if(arg7) {
                arg8.startReplaceGroup(0x54747154);
                ComposerKt.sourceInformation(arg8, "1981@91225L53");
                v9.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_picker_day_in_range), arg8, 0));
                arg8.endReplaceGroup();
            }
            else {
                arg8.startReplaceGroup(0x3A1AC4EB);
                arg8.endReplaceGroup();
            }

            arg8.endReplaceGroup();
        }
        else {
            arg8.startReplaceGroup(0x3A1ADC2B);
            arg8.endReplaceGroup();
        }

        if(arg4) {
            arg8.startReplaceGroup(1416920485);
            ComposerKt.sourceInformation(arg8, "1986@91426L54");
            if(v9.length() > 0) {
                v9.append(", ");
            }

            v9.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_picker_today_description), arg8, 0));
            arg8.endReplaceGroup();
        }
        else {
            arg8.startReplaceGroup(975029291);
            arg8.endReplaceGroup();
        }

        String v3 = v9.length() == 0 ? null : v9.toString();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return v3;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerKt.DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerKt.DatePickerModeTogglePadding;
    }

    public static final float getMonthYearHeight() {
        return DatePickerKt.MonthYearHeight;
    }

    public static final float getRecommendedSizeForAccessibility() {
        return DatePickerKt.RecommendedSizeForAccessibility;
    }

    public static final int numberOfMonthsInRange(IntRange arg1) {
        return (arg1.getLast() - arg1.getFirst() + 1) * 12;
    }

    public static final DatePickerState rememberDatePickerState-EU0dCGE(Long arg14, Long arg15, IntRange arg16, int arg17, SelectableDates arg18, Composer arg19, int arg20, int arg21) {
        DatePickerKt$$ExternalSyntheticLambda1 v4_2;
        Composer v0 = arg19;
        int v1 = arg20;
        int v3 = 2065763010;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(rememberDatePickerState)N(initialSelectedDateMillis,initialDisplayedMonthMillis,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)374@15968L15,375@16072L384,375@15995L461:DatePicker.kt#uh7d8r");
        if((arg21 & 1) != 0) {
            arg14 = null;
        }

        Long v5 = arg14;
        Long v6 = (arg21 & 2) != 0 ? v5 : arg15;
        IntRange v7 = (arg21 & 4) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : arg16;
        int v8 = (arg21 & 8) != 0 ? DisplayMode.Companion.getPicker-jFl-4v0() : arg17;
        SelectableDates v9 = (arg21 & 16) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : arg18;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:373)");
        }

        Locale v10 = CalendarLocale_androidKt.defaultLocale(v0, 0);
        Object[] v2 = new Object[0];
        Saver v3_1 = DatePickerStateImpl.Companion.Saver(v9, v10);
        ComposerKt.sourceInformationMarkerStart(v0, 0x3709A582, "CC(remember):DatePicker.kt#9igjgp");
        int v11 = 4;
        int v12 = 1;
        int v4 = (v1 & 14 ^ 6) > v11 && (v0.changed(v5)) || (v1 & 6) == v11 ? 1 : 0;
        int v13 = 0x20;
        v11 = (v1 & 0x70 ^ 0x30) > v13 && (v0.changed(v6)) || (v1 & 0x30) == v13 ? 1 : 0;
        v4 = v4 | v11 | v0.changedInstance(v7);
        v13 = 0x800;
        v11 = (v1 & 0x1C00 ^ 0xC00) > v13 && (v0.changed(v8)) || (v1 & 0xC00) == v13 ? 1 : 0;
        v4 |= v11;
        v13 = 0x4000;
        if((0xE000 & v1 ^ 0x6000) <= v13 || !v0.changed(v9)) {
            if((v1 & 0x6000) == v13) {
            }
            else {
                v12 = 0;
            }
        }

        v1 = v4 | v12 | v0.changedInstance(v10);
        Object v4_1 = v0.rememberedValue();
        if(v1 != 0 || v4_1 == Composer.Companion.getEmpty()) {
            v4_2 = new DatePickerKt$$ExternalSyntheticLambda1(v5, v6, v7, v8, v9, v10);
            v0.updateRememberedValue(v4_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        Object v14 = RememberSaveableKt.rememberSaveable(v2, v3_1, ((Function0)v4_2), v0, 0);
        ((DatePickerStateImpl)v14).setSelectableDates(v9);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((DatePickerState)v14);
    }

    static final DatePickerStateImpl rememberDatePickerState_EU0dCGE$lambda$5$lambda$4(Long arg8, Long arg9, IntRange arg10, int arg11, SelectableDates arg12, Locale arg13) {
        return new DatePickerStateImpl(arg8, arg9, arg10, arg11, arg12, arg13, null);
    }

    public static final Object updateDisplayedMonth(LazyListState arg2, Function1 arg3, CalendarModel arg4, IntRange arg5, Continuation arg6) {
        Object v2 = SnapshotStateKt.snapshotFlow(new DatePickerKt$$ExternalSyntheticLambda26(arg2)).collect(new DatePickerKt$updateDisplayedMonth$3(arg2, arg3, arg4, arg5), arg6);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    static final int updateDisplayedMonth$lambda$43(LazyListState arg0) {
        return arg0.getFirstVisibleItemIndex();
    }
}

