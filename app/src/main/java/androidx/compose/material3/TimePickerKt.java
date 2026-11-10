package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
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
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.LineHeightStyle$Trim;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1={"\u0000Ü\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A5\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000B\u001A)\u0010\f\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0002\u0010\r\u001A+\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\u0012\u001A\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001A \u0010\u0017\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0013H\u0007\u001A3\u0010\u001B\u001A\u00020\u0001*\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020!H\u0002¢\u0006\u0004\b\"\u0010#\u001AJ\u0010$\u001A\u00020\u0001*\u00020%2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020\u001D2\u0006\u0010&\u001A\u00020\u00132\u0006\u0010 \u001A\u00020!2\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u001D0(H\u0082@¢\u0006\u0004\b)\u0010*\u001A1\u0010/\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020%2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0006\u0010&\u001A\u00020\u0013H\u0001¢\u0006\u0002\u00100\u001A1\u00101\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020%2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0006\u0010&\u001A\u00020\u0013H\u0001¢\u0006\u0002\u00100\u001A%\u00102\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u0003H\u0003¢\u0006\u0002\u00103\u001A\u001D\u00104\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0003¢\u0006\u0002\u00105\u001A\u001D\u00106\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0003¢\u0006\u0002\u00105\u001A\u001D\u00107\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0003¢\u0006\u0002\u00105\u001A%\u00108\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0003¢\u0006\u0002\u00109\u001A%\u0010:\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0003¢\u0006\u0002\u00109\u001A=\u0010;\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010<\u001A\u00020=2\u0006\u0010>\u001A\u00020?2\u0006\u0010@\u001A\u00020?H\u0003¢\u0006\u0002\u0010A\u001AQ\u0010B\u001A\u00020\u00012\u0006\u0010C\u001A\u00020\u00132\u0006\u0010D\u001A\u00020?2\f\u0010E\u001A\b\u0012\u0004\u0012\u00020\u00010F2\u0006\u0010\u0006\u001A\u00020\u00072\u001C\u0010G\u001A\u0018\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00010H¢\u0006\u0002\bJ¢\u0006\u0002\bKH\u0003¢\u0006\u0002\u0010L\u001A\u0015\u0010M\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0003¢\u0006\u0002\u0010N\u001A7\u0010O\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010P\u001A\u00020\u00102\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010Q\u001A\u00020R2\u0006\u0010\u0006\u001A\u00020\u0007H\u0003¢\u0006\u0004\bS\u0010T\u001A-\u0010U\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020%2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010&\u001A\u00020\u0013H\u0001¢\u0006\u0002\u0010V\u001A\u001C\u0010W\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001A\u00020%2\u0006\u0010\u0006\u001A\u00020\u0007H\u0002\u001A-\u0010X\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020%2\u0006\u0010P\u001A\u00020\u00102\u0006\u0010&\u001A\u00020\u0013H\u0003¢\u0006\u0002\u0010Y\u001Ah\u0010Z\u001A\u00020\u00012\u0006\u0010Q\u001A\u00020R2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010P\u001A\u00020[2\u0006\u0010\\\u001A\u00020[2\u0006\u0010]\u001A\u00020\u00102\f\u0010^\u001A\b\u0012\u0004\u0012\u00020\u00130_2!\u0010`\u001A\u001D\u0012\u0013\u0012\u00110[¢\u0006\f\ba\u0012\b\bb\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u00010HH\u0002¢\u0006\u0004\bc\u0010d\u001A_\u0010e\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010P\u001A\u00020[2\u0012\u0010f\u001A\u000E\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\u00010H2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010Q\u001A\u00020R2\b\b\u0002\u0010g\u001A\u00020h2\b\b\u0002\u0010i\u001A\u00020j2\u0006\u0010\u0006\u001A\u00020\u0007H\u0003¢\u0006\u0004\bk\u0010l\u001A4\u0010m\u001A\u00020\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0001\u0010n\u001A\u00020\u001D2\u0011\u0010G\u001A\r\u0012\u0004\u0012\u00020\u00010F¢\u0006\u0002\bJH\u0003¢\u0006\u0002\u0010o\u001A\'\u0010p\u001A\u00020q2\u0006\u0010Q\u001A\u00020R2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010r\u001A\u00020\u0010H\u0001¢\u0006\u0004\bs\u0010t\u001A(\u0010u\u001A\u00020\u001D2\u0006\u0010v\u001A\u00020\u001D2\u0006\u0010w\u001A\u00020\u001D2\u0006\u0010x\u001A\u00020\u00102\u0006\u0010y\u001A\u00020\u0010H\u0002\u001A\u0018\u0010z\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001DH\u0002\u001A\u0016\u0010\u009D\u0001\u001A\u00020\u0005*\u00020\u00052\u0007\u0010\u009D\u0001\u001A\u00020\u0013H\u0003\"\u0015\u0010\u0015\u001A\u00020\u0013*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016\"\u0018\u0010\u0018\u001A\u00020\u0010*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A\"\u0018\u0010+\u001A\u00020,*\u00020%8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b-\u0010.\"\u001A\u0010{\u001A\u00020\t8AX\u0080\u0004¢\u0006\f\u0012\u0004\b|\u0010}\u001A\u0004\b~\u0010\u007F\"\u000F\u0010\u0080\u0001\u001A\u00020\u001DX\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u0081\u0001\u001A\u00020\u001DX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0082\u0001\u001A\u00030\u0083\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u0084\u0001\u001A\u00020\u001DX\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u0085\u0001\u001A\u00020\u001DX\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u0086\u0001\u001A\u00020\u001DX\u0082T¢\u0006\u0002\n\u0000\"\u000F\u0010\u0087\u0001\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000F\u0010\u0088\u0001\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0089\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0013\u0010\u008C\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0013\u0010\u008D\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0013\u0010\u008E\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0013\u0010\u008F\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0013\u0010\u0090\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0013\u0010\u0091\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0010\u0010\u0092\u0001\u001A\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0094\u0001\u001A\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0095\u0001\u001A\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0096\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0013\u0010\u0097\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0013\u0010\u0098\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u0013\u0010\u0099\u0001\u001A\u00030\u008A\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008B\u0001\"\u001B\u0010\u009A\u0001\u001A\u00030\u008A\u0001X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008B\u0001\u001A\u0006\b\u009B\u0001\u0010\u009C\u0001¨\u0006\u009E\u0001²\u0006\u000B\u0010\u009F\u0001\u001A\u00020\u0013X\u008A\u0084\u0002²\u0006\u000B\u0010 \u0001\u001A\u00020[X\u008A\u008E\u0002²\u0006\u000B\u0010¡\u0001\u001A\u00020[X\u008A\u008E\u0002²\u0006\u000B\u0010 \u001A\u00030¢\u0001X\u008A\u008E\u0002²\u0006\u000B\u0010£\u0001\u001A\u00020!X\u008A\u008E\u0002²\u0006\f\u0010¤\u0001\u001A\u00030¥\u0001X\u008A\u008E\u0002²\u0006\u000B\u0010¦\u0001\u001A\u00020\u0013X\u008A\u0084\u0002"}, d2={"TimePicker", "", "state", "Landroidx/compose/material3/TimePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/compose/material3/TimePickerColors;", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "rememberTimePickerState", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "isPm", "(Landroidx/compose/material3/TimePickerState;)Z", "TimePickerState", "hourForDisplay", "getHourForDisplay", "(Landroidx/compose/material3/TimePickerState;)I", "moveSelector", "x", "", "y", "maxDist", "center", "Landroidx/compose/ui/unit/IntOffset;", "moveSelector-d3b8Pxo", "(Landroidx/compose/material3/TimePickerState;FFFJ)V", "onTap", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "onTap-uYHVD98", "(Landroidx/compose/material3/AnalogTimePickerState;FFFZJLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos", "(Landroidx/compose/material3/AnalogTimePickerState;)J", "VerticalTimePicker", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "HorizontalTimePicker", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "ClockDisplayNumbers", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalPeriodToggle", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Lkotlin/Function0;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "TimeSelector", "value", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "TimeSelector-SAnMeKU", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "drawSelector", "ClockText", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "timeInputOnChange", "Landroidx/compose/ui/text/input/TextFieldValue;", "prevValue", "max", "userOverride", "Landroidx/compose/ui/node/Ref;", "onNewValue", "Lkotlin/ParameterName;", "name", "timeInputOnChange-_K77t-0", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILandroidx/compose/ui/node/Ref;Lkotlin/jvm/functions/Function1;)V", "TimePickerTextField", "onValueChange", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-1vLObsk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "CircularLayout", "radiusToSizeRatio", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "numberContentDescription", "", "number", "numberContentDescription-dSwYdS4", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "dist", "x1", "y1", "x2", "y2", "atan", "defaultTimePickerLayoutType", "getDefaultTimePickerLayoutType$annotations", "()V", "getDefaultTimePickerLayoutType", "(Landroidx/compose/runtime/Composer;I)I", "FullCircle", "HalfCircle", "QuarterCircle", "", "RadiansPerMinute", "RadiansPerHour", "SeparatorZIndex", "OuterCircleToSizeRatio", "InnerCircleToSizeRatio", "ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "SupportLabelTop", "TimeInputBottomPadding", "MaxDistance", "MinimumInteractiveSize", "Minutes", "Landroidx/collection/IntList;", "Hours", "ExtraHours", "PeriodToggleMargin", "TimePickerMaxHeight", "TimePickerMidHeight", "ClockDialMidContainerSize", "ClockDialMinContainerSize", "getClockDialMinContainerSize", "()F", "visible", "material3", "a11yServicesEnabled", "hourValue", "minuteValue", "Landroidx/compose/ui/geometry/Offset;", "parentCenter", "boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "selected"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TimePickerKt {
    private static final float ClockDialMidContainerSize = 0f;
    private static final float ClockDialMinContainerSize = 0f;
    private static final float ClockDisplayBottomMargin = 0f;
    private static final float ClockFaceBottomMargin = 0f;
    private static final float DisplaySeparatorWidth = 0f;
    private static final IntList ExtraHours = null;
    private static final float FullCircle = 6.283185f;
    private static final float HalfCircle = 3.141593f;
    private static final IntList Hours = null;
    private static final float InnerCircleToSizeRatio = 0f;
    private static final float MaxDistance = 0f;
    private static final float MinimumInteractiveSize = 0f;
    private static final IntList Minutes = null;
    private static final float OuterCircleToSizeRatio = 0f;
    private static final float PeriodToggleMargin = 0f;
    private static final double QuarterCircle = 1.570796;
    private static final float RadiansPerHour = 0.523599f;
    private static final float RadiansPerMinute = 0.10472f;
    private static final float SeparatorZIndex = 2f;
    private static final float SupportLabelTop;
    private static final float TimeInputBottomPadding;
    private static final float TimePickerMaxHeight;
    private static final float TimePickerMidHeight;

    static {
        TimePickerKt.OuterCircleToSizeRatio = Dp.constructor-impl(101f) / TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM();
        TimePickerKt.InnerCircleToSizeRatio = Dp.constructor-impl(69f) / TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM();
        TimePickerKt.ClockDisplayBottomMargin = Dp.constructor-impl(36f);
        TimePickerKt.ClockFaceBottomMargin = Dp.constructor-impl(24f);
        TimePickerKt.DisplaySeparatorWidth = Dp.constructor-impl(24f);
        TimePickerKt.SupportLabelTop = Dp.constructor-impl(7f);
        TimePickerKt.TimeInputBottomPadding = Dp.constructor-impl(24f);
        TimePickerKt.MaxDistance = Dp.constructor-impl(74f);
        TimePickerKt.MinimumInteractiveSize = Dp.constructor-impl(48f);
        int v0 = 12;
        TimePickerKt.Minutes = IntListKt.intListOf(new int[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55});
        IntList v1 = IntListKt.intListOf(new int[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        TimePickerKt.Hours = v1;
        MutableIntList v2 = new MutableIntList(v1._size);
        int[] v3 = v1.content;
        int v1_1 = v1._size;
        int v4;
        for(v4 = 0; v4 < v1_1; ++v4) {
            v2.add(v3[v4] % v0 + v0);
        }

        TimePickerKt.ExtraHours = ((IntList)v2);
        TimePickerKt.PeriodToggleMargin = Dp.constructor-impl(12f);
        TimePickerKt.TimePickerMaxHeight = Dp.constructor-impl(384f);
        TimePickerKt.TimePickerMidHeight = Dp.constructor-impl(330f);
        TimePickerKt.ClockDialMidContainerSize = Dp.constructor-impl(238f);
        TimePickerKt.ClockDialMinContainerSize = Dp.constructor-impl(200f);
    }

    private static final void CircularLayout(Modifier arg8, float arg9, Function2 arg10, Composer arg11, int arg12, int arg13) {
        TimePickerKt$CircularLayout$1$1 v0_2;
        Companion v8;
        int v3;
        int v2;
        int v0 = 0xC1F2F375;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(CircularLayout)N(modifier,radiusToSizeRatio,content)1979@76688L1660,1979@76641L1707:TimePicker.kt#uh7d8r");
        int v1 = arg13 & 1;
        if(v1 != 0) {
            v2 = arg12 | 6;
        }
        else if((arg12 & 6) == 0) {
            v2 = arg11.changed(arg8) ? 4 : 2;
            v2 |= arg12;
        }
        else {
            v2 = arg12;
        }

        int v4 = 0x20;
        if((arg13 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((arg12 & 0x30) == 0) {
            v3 = arg11.changed(arg9) ? v4 : 16;
            v2 |= v3;
        }

        if((arg13 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((arg12 & 0x180) == 0) {
            v3 = arg11.changedInstance(arg10) ? 0x100 : 0x80;
            v2 |= v3;
        }

        int v7 = 1;
        boolean v3_1 = (v2 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v3_1, v2 & 1)) {
            if(v1 != 0) {
                v8 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1978)");
            }

            ComposerKt.sourceInformationMarkerStart(arg11, 0x11040D91, "CC(remember):TimePicker.kt#9igjgp");
            if((v2 & 0x70) == v4) {
            }
            else {
                v7 = 0;
            }

            Object v0_1 = arg11.rememberedValue();
            if(v7 != 0 || v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = new TimePickerKt$CircularLayout$1$1(arg9);
                arg11.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            v1 = v2 >> 6 & 14 | v2 << 3 & 0x70;
            ComposerKt.sourceInformationMarkerStart(arg11, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v2 = ComposablesKt.getCurrentCompositeKeyHash(arg11, 0);
            CompositionLocalMap v3_2 = arg11.getCurrentCompositionLocalMap();
            Modifier v4_1 = ComposedModifierKt.materializeModifier(arg11, ((Modifier)v8));
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
            v1 = v1 << 6 & 0x380 | 6;
            ComposerKt.sourceInformationMarkerStart(arg11, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(arg11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg11.startReusableNode();
            if(arg11.getInserting()) {
                arg11.createNode(v5);
            }
            else {
                arg11.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(arg11);
            Updater.set-impl(v5_1, v0_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v3_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v0_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v2))) {
                v5_1.updateRememberedValue(Integer.valueOf(v2));
                v5_1.apply(Integer.valueOf(v2), v0_3);
            }

            Updater.set-impl(v5_1, v4_1, ComposeUiNode.Companion.getSetModifier());
            arg10.invoke(arg11, Integer.valueOf(v1 >> 6 & 14));
            arg11.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_140;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_140:
        Modifier v2_1 = ((Modifier)v8);
        ScopeUpdateScope v8_1 = arg11.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new TimePickerKt$$ExternalSyntheticLambda26(v2_1, arg9, arg10, arg12, arg13));
        }
    }

    static final Unit CircularLayout$lambda$96(Modifier arg6, float arg7, Function2 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        TimePickerKt.CircularLayout(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    private static final void ClockDisplayNumbers(TimePickerState arg7, TimePickerColors arg8, Composer arg9, int arg10) {
        int v1_1;
        int v0 = 0xC84BBA8B;
        arg9 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg9, "C(ClockDisplayNumbers)N(state,colors)1175@49425L5,1178@49561L775,1174@49341L995:TimePicker.kt#uh7d8r");
        int v2 = 2;
        if((arg10 & 6) == 0) {
            boolean v1 = (arg10 & 8) == 0 ? arg9.changed(arg7) : arg9.changedInstance(arg7);
            v1_1 = v1 ? 4 : v2;
            v1_1 |= arg10;
        }
        else {
            v1_1 = arg10;
        }

        if((arg10 & 0x30) == 0) {
            int v3 = arg9.changed(arg8) ? 0x20 : 16;
            v1_1 |= v3;
        }

        boolean v3_1 = (v1_1 & 19) != 18 ? true : false;
        if(arg9.shouldExecute(v3_1, v1_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1_1, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:1173)");
            }

            ProvidedValue[] v0_1 = new ProvidedValue[v2];
            v0_1[0] = TextKt.getLocalTextStyle().provides(TypographyKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont(), arg9, 6));
            v0_1[1] = CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr);
            CompositionLocalKt.CompositionLocalProvider(v0_1, ComposableLambdaKt.rememberComposableLambda(0xE3839F4B, true, new TimePickerKt$ClockDisplayNumbers$1(arg7, arg8), arg9, 54), arg9, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_68;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg9.skipToGroupEnd();
        }

    label_68:
        ScopeUpdateScope v9 = arg9.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new TimePickerKt$$ExternalSyntheticLambda32(arg7, arg8, arg10));
        }
    }

    static final Unit ClockDisplayNumbers$lambda$35(TimePickerState arg0, TimePickerColors arg1, int arg2, Composer arg3, int arg4) {
        TimePickerKt.ClockDisplayNumbers(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final void ClockFace(Modifier arg18, AnalogTimePickerState arg19, TimePickerColors arg20, boolean arg21, Composer arg22, int arg23) {
        int v6;
        int v5;
        Modifier v1 = arg18;
        AnalogTimePickerState v2 = arg19;
        TimePickerColors v0 = arg20;
        boolean v4 = arg21;
        int v8 = arg23;
        int v3 = -478841003;
        Composer v14 = arg22.startRestartGroup(v3);
        ComposerKt.sourceInformation(v14, "C(ClockFace)N(modifier,state,colors,autoSwitchToMinute)1602@63170L7,1607@63371L7,1608@63386L2054,1593@62800L2640:TimePicker.kt#uh7d8r");
        if((v8 & 6) == 0) {
            v5 = v14.changed(v1) ? 4 : 2;
            v5 |= v8;
        }
        else {
            v5 = v8;
        }

        if((v8 & 0x30) == 0) {
            v6 = v14.changedInstance(v2) ? 0x20 : 16;
            v5 |= v6;
        }

        if((v8 & 0x180) == 0) {
            v6 = v14.changed(v0) ? 0x100 : 0x80;
            v5 |= v6;
        }

        if((v8 & 0xC00) == 0) {
            v6 = v14.changed(v4) ? 0x800 : 0x400;
            v5 |= v6;
        }

        boolean v6_1 = (v5 & 0x493) != 1170 ? true : false;
        if(v14.shouldExecute(v6_1, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v5, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1591)");
            }

            v2 = arg19;
            CrossfadeKt.Crossfade(v2.getClockFaceValues(), TimePickerKt.drawSelector(BackgroundKt.background-bw27NRU(v1, v0.getClockDialColor-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()).then(new ClockDialModifier(arg19, v4, arg19.getSelection-yecRtBI(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v14, 6), null)), v2, v0), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v14, 6), null, ComposableLambdaKt.rememberComposableLambda(747010833, true, new TimePickerKt$ClockFace$1(v0, v2, v4), v14, 54), v14, 0x6000, 8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_95;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v14.skipToGroupEnd();
        }

    label_95:
        ScopeUpdateScope v6_2 = v14.endRestartGroup();
        if(v6_2 != null) {
            v6_2.updateScope(new TimePickerKt$$ExternalSyntheticLambda0(v1, v2, arg20, v4, v8));
        }
    }

    static final Unit ClockFace$lambda$60(Modifier arg6, AnalogTimePickerState arg7, TimePickerColors arg8, boolean arg9, int arg10, Composer arg11, int arg12) {
        TimePickerKt.ClockFace(arg6, arg7, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }

    private static final void ClockText(Modifier arg31, AnalogTimePickerState arg32, int arg33, boolean arg34, Composer arg35, int arg36) {
        Composer v27;
        TimePickerKt$$ExternalSyntheticLambda6 v4_6;
        State v4_3;
        MutableState v9_1;
        MutableState v7_2;
        int v7;
        int v5;
        Modifier v1 = arg31;
        AnalogTimePickerState v2 = arg32;
        int v3 = arg33;
        int v0 = arg36;
        int v4 = -206784607;
        Composer v10 = arg35.startRestartGroup(v4);
        ComposerKt.sourceInformation(v10, "C(ClockText)N(modifier,state,value,autoSwitchToMinute)1728@67678L5,1729@67724L7,1731@67805L40,1732@67870L43,1733@67940L38,1734@67995L24,1736@68057L143,1744@68267L268,1757@68741L215,1765@69135L612,1753@68613L1344:TimePicker.kt#uh7d8r");
        int v6 = 2;
        if((v0 & 6) == 0) {
            v5 = v10.changed(v1) ? 4 : v6;
            v5 |= v0;
        }
        else {
            v5 = v0;
        }

        if((v0 & 0x30) == 0) {
            v7 = v10.changedInstance(v2) ? 0x20 : 16;
            v5 |= v7;
        }

        if((v0 & 0x180) == 0) {
            v7 = v10.changed(v3) ? 0x100 : 0x80;
            v5 |= v7;
        }

        boolean v12 = arg34;
        if((v0 & 0xC00) == 0) {
            v7 = v10.changed(v12) ? 0x800 : 0x400;
            v5 |= v7;
        }

        int v13 = v5;
        boolean v5_1 = (v13 & 0x493) != 1170 ? true : false;
        if(v10.shouldExecute(v5_1, v13 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v4, v13, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1727)");
            }

            TextStyle v26 = TypographyKt.getValue(TimePickerTokens.INSTANCE.getClockDialLabelTextFont(), v10, 6);
            ProvidableCompositionLocal v4_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v10, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_2 = v10.consume(((CompositionLocal)v4_1));
            ComposerKt.sourceInformationMarkerEnd(v10);
            float v5_2 = ((Density)v4_2).toPx-0680j_4(TimePickerKt.MaxDistance);
            String v8 = "CC(remember):TimePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v10, -1151501687, v8);
            Object v7_1 = v10.rememberedValue();
            SnapshotMutationPolicy v14 = null;
            if(v7_1 == Composer.Companion.getEmpty()) {
                v7_2 = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), v14, v6, v14);
                v10.updateRememberedValue(v7_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            ComposerKt.sourceInformationMarkerStart(v10, -1151499604, v8);
            Object v9 = v10.rememberedValue();
            if(v9 == Composer.Companion.getEmpty()) {
                v9_1 = SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), v14, v6, v14);
                v10.updateRememberedValue(v9_1);
            }

            Object v11 = v9;
            ComposerKt.sourceInformationMarkerEnd(v10);
            ComposerKt.sourceInformationMarkerStart(v10, 0xBB5D8B67, v8);
            v9 = v10.rememberedValue();
            if(v9 == Composer.Companion.getEmpty()) {
                v9_1 = SnapshotStateKt.mutableStateOf$default(Rect.Companion.getZero(), v14, v6, v14);
                v10.updateRememberedValue(v9_1);
            }

            Object v15 = v9;
            ComposerKt.sourceInformationMarkerEnd(v10);
            ComposerKt.sourceInformationMarkerStart(v10, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v10, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v6_1 = v10.rememberedValue();
            if(v6_1 == Composer.Companion.getEmpty()) {
                CoroutineScope v6_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v10);
                v10.updateRememberedValue(v6_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            ComposerKt.sourceInformationMarkerEnd(v10);
            String v0_1 = TimePickerKt.numberContentDescription-dSwYdS4(v2.getSelection-yecRtBI(), v2.is24hour(), v3, v10, v13 & 0x380);
            int v20 = v13;
            Object v13_1 = v6_1;
            float v21 = v5_2;
            String v12_1 = v8;
            Object v14_1 = v4_2;
            String v19 = v0_1;
            Object v0_2 = v7_2;
            String v22 = CalendarLocale_jvmKt.toLocalString$default(v3, 0, 0, false, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(v10, 0xBB5DB52D, v12_1);
            boolean v3_1 = v10.changed(v2);
            v4_2 = v10.rememberedValue();
            if((v3_1) || v4_2 == Composer.Companion.getEmpty()) {
                v4_3 = SnapshotStateKt.derivedStateOf(new TimePickerKt$$ExternalSyntheticLambda3(v2, ((Density)v14_1), ((MutableState)v15)));
                v10.updateRememberedValue(v4_3);
            }

            v9 = v4_3;
            ComposerKt.sourceInformationMarkerEnd(v10);
            Alignment v14_2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(v10, 0xBB5DF038, v12_1);
            Object v3_2 = v10.rememberedValue();
            if(v3_2 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda4 v3_3 = new TimePickerKt$$ExternalSyntheticLambda4(((MutableState)v11), ((MutableState)v15), ((MutableState)v0_2));
                v10.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            Modifier v15_1 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(OnGloballyPositionedModifierKt.onGloballyPositioned(v1, ((Function1)v3_2))), TimePickerKt.MinimumInteractiveSize), false, null, 3, null);
            ComposerKt.sourceInformationMarkerStart(v10, 0xBB5E2305, v12_1);
            v5_2 = v21;
            v3 = v10.changedInstance(v13_1) | v10.changedInstance(v2) | v10.changed(v5_2);
            v4 = (v20 & 0x1C00) == 0x800 ? 1 : 0;
            v3 = v3 | v4 | v10.changed(v9);
            v4_2 = v10.rememberedValue();
            if(v3 != 0 || v4_2 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda5 v2_1 = new TimePickerKt$$ExternalSyntheticLambda5(v13_1, arg32, v5_2, arg34, v0_2, v11, ((State)v9));
                v10.updateRememberedValue(v2_1);
                TimePickerKt$$ExternalSyntheticLambda5 v4_4 = v2_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            Modifier v0_3 = SemanticsModifierKt.semantics(v15_1, true, ((Function1)v4_2));
            ComposerKt.sourceInformationMarkerStart(v10, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v2_2 = BoxKt.maybeCachedBoxMeasurePolicy(v14_2, false);
            ComposerKt.sourceInformationMarkerStart(v10, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v3 = ComposablesKt.getCurrentCompositeKeyHash(v10, 0);
            CompositionLocalMap v4_5 = v10.getCurrentCompositionLocalMap();
            v0_3 = ComposedModifierKt.materializeModifier(v10, v0_3);
            Function0 v5_3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v10, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v10.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v10.startReusableNode();
            if(v10.getInserting()) {
                v10.createNode(v5_3);
            }
            else {
                v10.useNode();
            }

            Composer v5_4 = Updater.constructor-impl(v10);
            Updater.set-impl(v5_4, v2_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_4, v4_5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v2_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_4.getInserting()) || !Intrinsics.areEqual(v5_4.rememberedValue(), Integer.valueOf(v3))) {
                v5_4.updateRememberedValue(Integer.valueOf(v3));
                v5_4.apply(Integer.valueOf(v3), v2_3);
            }

            Updater.set-impl(v5_4, v0_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v10, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v10, 0xCC5D6BC2, "C1784@69840L48,1782@69765L186:TimePicker.kt#uh7d8r");
            Companion v0_4 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v10, -2106152649, v12_1);
            String v2_4 = v19;
            v3_1 = v10.changed(v2_4);
            v4_2 = v10.rememberedValue();
            if((v3_1) || v4_2 == Composer.Companion.getEmpty()) {
                v4_6 = new TimePickerKt$$ExternalSyntheticLambda6(v2_4);
                v10.updateRememberedValue(v4_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v10);
            v27 = v10;
            TextKt.Text-Nvy7gAk(v22, SemanticsModifierKt.clearAndSetSemantics(((Modifier)v0_4), ((Function1)v4_6)), 0, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, v26, v27, 0, 0, 0x1FFFC);
            ComposerKt.sourceInformationMarkerEnd(v27);
            ComposerKt.sourceInformationMarkerEnd(v27);
            v27.endNode();
            ComposerKt.sourceInformationMarkerEnd(v27);
            ComposerKt.sourceInformationMarkerEnd(v27);
            ComposerKt.sourceInformationMarkerEnd(v27);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_323;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v27 = v10;
            v27.skipToGroupEnd();
        }

    label_323:
        ScopeUpdateScope v6_3 = v27.endRestartGroup();
        if(v6_3 != null) {
            v6_3.updateScope(new TimePickerKt$$ExternalSyntheticLambda7(v1, arg32, arg33, arg34, arg36));
        }
    }

    private static final long ClockText$lambda$64(MutableState arg2) {
        return ((State)arg2).getValue().unbox-impl();
    }

    private static final void ClockText$lambda$65(MutableState arg0, long arg1) {
        arg0.setValue(Offset.box-impl(arg1));
    }

    private static final long ClockText$lambda$67(MutableState arg2) {
        return ((State)arg2).getValue().unbox-impl();
    }

    private static final void ClockText$lambda$68(MutableState arg0, long arg1) {
        arg0.setValue(IntOffset.box-impl(arg1));
    }

    private static final Rect ClockText$lambda$70(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void ClockText$lambda$71(MutableState arg0, Rect arg1) {
        arg0.setValue(arg1);
    }

    static final boolean ClockText$lambda$74$lambda$73(AnalogTimePickerState arg4, Density arg5, MutableState arg6) {
        long v0 = TimePickerKt.getSelectorPos(arg4);
        return TimePickerKt.ClockText$lambda$70(arg6).contains-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(arg5.toPx-0680j_4(DpOffset.getY-D9Ej5fM(v0))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg5.toPx-0680j_4(DpOffset.getX-D9Ej5fM(v0))))) << 0x20));
    }

    private static final boolean ClockText$lambda$75(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit ClockText$lambda$77$lambda$76(MutableState arg2, MutableState arg3, MutableState arg4, LayoutCoordinates arg5) {
        LayoutCoordinates v0 = arg5.getParentCoordinates();
        long v0_1 = v0 != null ? IntSizeKt.getCenter-ozmzZPI(v0.getSize-YbymL2g()) : IntOffset.Companion.getZero-nOcc-ac();
        TimePickerKt.ClockText$lambda$68(arg2, v0_1);
        TimePickerKt.ClockText$lambda$71(arg3, LayoutCoordinatesKt.boundsInParent(arg5));
        TimePickerKt.ClockText$lambda$65(arg4, TimePickerKt.ClockText$lambda$70(arg3).getCenter-F1C5BW0());
        return Unit.INSTANCE;
    }

    static final Unit ClockText$lambda$80$lambda$79(CoroutineScope arg7, AnalogTimePickerState arg8, float arg9, boolean arg10, MutableState arg11, MutableState arg12, State arg13, SemanticsPropertyReceiver arg14) {
        SemanticsPropertiesKt.onClick$default(arg14, null, new TimePickerKt$$ExternalSyntheticLambda28(arg7, arg8, arg9, arg10, arg11, arg12), 1, null);
        SemanticsPropertiesKt.setSelected(arg14, TimePickerKt.ClockText$lambda$75(arg13));
        return Unit.INSTANCE;
    }

    static final boolean ClockText$lambda$80$lambda$79$lambda$78(CoroutineScope arg7, AnalogTimePickerState arg8, float arg9, boolean arg10, MutableState arg11, MutableState arg12) {
        BuildersKt.launch$default(arg7, null, null, new TimePickerKt$ClockText$2$1$1$1(arg8, arg9, arg10, arg11, arg12, null), 3, null);
        return 1;
    }

    static final Unit ClockText$lambda$83$lambda$82$lambda$81(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentDescription(arg1, arg0);
        return Unit.INSTANCE;
    }

    static final Unit ClockText$lambda$84(Modifier arg6, AnalogTimePickerState arg7, int arg8, boolean arg9, int arg10, Composer arg11, int arg12) {
        TimePickerKt.ClockText(arg6, arg7, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }

    private static final void DisplaySeparator(Modifier arg40, Composer arg41, int arg42) {
        Composer v25;
        int v4;
        Modifier v0 = arg40;
        int v1 = arg42;
        int v2 = 2100674302;
        Composer v3 = arg41.startRestartGroup(v2);
        ComposerKt.sourceInformation(v3, "C(DisplaySeparator)N(modifier)1381@55968L7,1390@56286L2,1390@56241L172:TimePicker.kt#uh7d8r");
        int v5 = 2;
        if((v1 & 6) == 0) {
            v4 = v3.changed(v0) ? 4 : v5;
            v4 |= v1;
        }
        else {
            v4 = v1;
        }

        boolean v5_1 = (v4 & 3) != v5 ? true : false;
        if(v3.shouldExecute(v5_1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v4, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1379)");
            }

            ProvidableCompositionLocal v2_1 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_2 = v3.consume(((CompositionLocal)v2_1));
            ComposerKt.sourceInformationMarkerEnd(v3);
            TextStyle v24 = TextStyle.copy-p1EtxEg$default(v2_2, 0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, null, null, new LineHeightStyle(androidx.compose.ui.text.style.LineHeightStyle$Alignment.Companion.getCenter-PIaL0Z0(), Trim.Companion.getBoth-EVpEnUU(), null), 0, 0, null, 0xEF7FFF, null);
            ComposerKt.sourceInformationMarkerStart(v3, 0x6C22C00, "CC(remember):TimePicker.kt#9igjgp");
            v2_2 = v3.rememberedValue();
            if(v2_2 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda9 v2_3 = new TimePickerKt$$ExternalSyntheticLambda9();
                v3.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            Modifier v2_4 = SemanticsModifierKt.clearAndSetSemantics(v0, ((Function1)v2_2));
            Alignment v4_1 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(v3, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v4_2 = BoxKt.maybeCachedBoxMeasurePolicy(v4_1, false);
            ComposerKt.sourceInformationMarkerStart(v3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v5 = ComposablesKt.getCurrentCompositeKeyHash(v3, 0);
            CompositionLocalMap v6 = v3.getCurrentCompositionLocalMap();
            v2_4 = ComposedModifierKt.materializeModifier(v3, v2_4);
            Function0 v7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v3, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v3.startReusableNode();
            if(v3.getInserting()) {
                v3.createNode(v7);
            }
            else {
                v3.useNode();
            }

            Composer v7_1 = Updater.constructor-impl(v3);
            Updater.set-impl(v7_1, v4_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v7_1, v6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v4_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v7_1.getInserting()) || !Intrinsics.areEqual(v7_1.rememberedValue(), Integer.valueOf(v5))) {
                v7_1.updateRememberedValue(Integer.valueOf(v5));
                v7_1.apply(Integer.valueOf(v5), v4_3);
            }

            Updater.set-impl(v7_1, v2_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v3, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v3, 0x7D432E05, "C1391@56386L5,1391@56337L70:TimePicker.kt#uh7d8r");
            v25 = v3;
            TextKt.Text-Nvy7gAk(":", null, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), v3, 6), null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, v24, v25, 6, 0, 0x1FFFA);
            ComposerKt.sourceInformationMarkerEnd(v25);
            ComposerKt.sourceInformationMarkerEnd(v25);
            v25.endNode();
            ComposerKt.sourceInformationMarkerEnd(v25);
            ComposerKt.sourceInformationMarkerEnd(v25);
            ComposerKt.sourceInformationMarkerEnd(v25);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_179;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v25 = v3;
            v25.skipToGroupEnd();
        }

    label_179:
        ScopeUpdateScope v2_5 = v25.endRestartGroup();
        if(v2_5 != null) {
            v2_5.updateScope(new TimePickerKt$$ExternalSyntheticLambda10(v0, v1));
        }
    }

    static final Unit DisplaySeparator$lambda$52$lambda$51(SemanticsPropertyReceiver arg0) {
        return Unit.INSTANCE;
    }

    static final Unit DisplaySeparator$lambda$54(Modifier arg0, int arg1, Composer arg2, int arg3) {
        TimePickerKt.DisplaySeparator(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private static final void HorizontalClockDisplay(TimePickerState arg23, TimePickerColors arg24, Composer arg25, int arg26) {
        int v5_1;
        TimePickerState v0 = arg23;
        TimePickerColors v1 = arg24;
        int v2 = arg26;
        int v3 = 0x2D089E69;
        Composer v4 = arg25.startRestartGroup(v3);
        ComposerKt.sourceInformation(v4, "C(HorizontalClockDisplay)N(state,colors)1134@47955L591:TimePicker.kt#uh7d8r");
        if((v2 & 6) == 0) {
            boolean v5 = (v2 & 8) == 0 ? v4.changed(v0) : v4.changedInstance(v0);
            v5_1 = v5 ? 4 : 2;
            v5_1 |= v2;
        }
        else {
            v5_1 = v2;
        }

        if((v2 & 0x30) == 0) {
            int v6 = v4.changed(v1) ? 0x20 : 16;
            v5_1 |= v6;
        }

        boolean v6_1 = (v5_1 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v6_1, v5_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v5_1, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:1133)");
            }

            HorizontalOrVertical v3_1 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(v4, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Companion v6_2 = Modifier.Companion;
            MeasurePolicy v3_2 = ColumnKt.columnMeasurePolicy(((Vertical)v3_1), Alignment.Companion.getStart(), v4, 6);
            int v7 = -1323940314;
            String v10 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v4, v7, v10);
            int v11 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
            CompositionLocalMap v12 = v4.getCurrentCompositionLocalMap();
            Modifier v6_3 = ComposedModifierKt.materializeModifier(v4, ((Modifier)v6_2));
            Function0 v13 = ComposeUiNode.Companion.getConstructor();
            int v14 = 0xD6BD0031;
            String v15 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v4, v14, v15);
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

            Composer v9 = Updater.constructor-impl(v4);
            Updater.set-impl(v9, v3_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v9, v12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v9.getInserting()) || !Intrinsics.areEqual(v9.rememberedValue(), Integer.valueOf(v11))) {
                v9.updateRememberedValue(Integer.valueOf(v11));
                v9.apply(Integer.valueOf(v11), v3_3);
            }

            Updater.set-impl(v9, v6_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v4, 0x3B841FE2, "C1135@48014L34:TimePicker.kt#uh7d8r");
            TimePickerKt.ClockDisplayNumbers(v0, v1, v4, v5_1 & 0x7E);
            if(!v0.is24hour()) {
                v4.startReplaceGroup(0x3B851021);
                ComposerKt.sourceInformation(v4, "1137@48092L438");
                Modifier v3_4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0f, TimePickerKt.PeriodToggleMargin, 0f, 0f, 13, null);
                ComposerKt.sourceInformationMarkerStart(v4, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy v6_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v4, v7, v10);
                v7 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
                CompositionLocalMap v8 = v4.getCurrentCompositionLocalMap();
                v3_4 = ComposedModifierKt.materializeModifier(v4, v3_4);
                Function0 v9_1 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4, v14, v15);
                if(!(v4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4.startReusableNode();
                if(v4.getInserting()) {
                    v4.createNode(v9_1);
                }
                else {
                    v4.useNode();
                }

                v9 = Updater.constructor-impl(v4);
                Updater.set-impl(v9, v6_4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v9, v8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v6_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v9.getInserting()) || !Intrinsics.areEqual(v9.rememberedValue(), Integer.valueOf(v7))) {
                    v9.updateRememberedValue(Integer.valueOf(v7));
                    v9.apply(Integer.valueOf(v7), v6_5);
                }

                Updater.set-impl(v9, v3_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v4, 1710314390, "C1138@48169L347:TimePicker.kt#uh7d8r");
                v5_1 <<= 3;
                TimePickerKt.HorizontalPeriodToggle(SizeKt.size-VpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.getPeriodSelectorHorizontalContainerWidth-D9Ej5fM(), TimePickerTokens.INSTANCE.getPeriodSelectorHorizontalContainerHeight-D9Ej5fM()), v0, v1, v4, v5_1 & 0x380 | (v5_1 & 0x70 | 6));
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(999020143);
                v4.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            v4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_209;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v4.skipToGroupEnd();
        }

    label_209:
        ScopeUpdateScope v3_5 = v4.endRestartGroup();
        if(v3_5 != null) {
            v3_5.updateScope(new TimePickerKt$$ExternalSyntheticLambda19(v0, v1, v2));
        }
    }

    static final Unit HorizontalClockDisplay$lambda$31(TimePickerState arg0, TimePickerColors arg1, int arg2, Composer arg3, int arg4) {
        TimePickerKt.HorizontalClockDisplay(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final void HorizontalPeriodToggle(Modifier arg9, TimePickerState arg10, TimePickerColors arg11, Composer arg12, int arg13) {
        TimePickerColors v3;
        TimePickerState v2;
        Modifier v1_2;
        int v1_1;
        boolean v1;
        int v12;
        int v0 = 0x4B2CA0B7;
        Composer v7 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(v7, "C(HorizontalPeriodToggle)N(modifier,state,colors)1207@50498L1014,1235@51559L5,1237@51590L207:TimePicker.kt#uh7d8r");
        if((arg13 & 6) == 0) {
            v12 = v7.changed(arg9) ? 4 : 2;
            v12 |= arg13;
        }
        else {
            v12 = arg13;
        }

        if((arg13 & 0x30) == 0) {
            v1 = (arg13 & 0x40) == 0 ? v7.changed(arg10) : v7.changedInstance(arg10);
            v1_1 = v1 ? 0x20 : 16;
            v12 |= v1_1;
        }

        if((arg13 & 0x180) == 0) {
            v1_1 = v7.changed(arg11) ? 0x100 : 0x80;
            v12 |= v1_1;
        }

        v1 = (v12 & 0x93) != 0x92 ? true : false;
        if(v7.shouldExecute(v1, v12 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v12, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1206)");
            }

            ComposerKt.sourceInformationMarkerStart(v7, 0x328766AD, "CC(remember):TimePicker.kt#9igjgp");
            Object v0_1 = v7.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 v0_2 = TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.INSTANCE;
                v7.updateRememberedValue(v0_2);
            }

            Object v4 = v0_1;
            ComposerKt.sourceInformationMarkerEnd(v7);
            Shape v0_3 = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), v7, 6);
            Intrinsics.checkNotNull(v0_3, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            v1_2 = arg9;
            v2 = arg10;
            v3 = arg11;
            TimePickerKt.PeriodToggleImpl(v1_2, v2, v3, ((MeasurePolicy)v4), ShapesKt.start$default(((CornerBasedShape)v0_3), null, 1, null), ShapesKt.end$default(((CornerBasedShape)v0_3), null, 1, null), v7, v12 & 14 | 0xC00 | v12 & 0x70 | v12 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_89;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1_2 = arg9;
            v2 = arg10;
            v3 = arg11;
            v7.skipToGroupEnd();
        }

    label_89:
        ScopeUpdateScope v9 = v7.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new TimePickerKt$$ExternalSyntheticLambda36(v1_2, v2, v3, arg13));
        }
    }

    static final Unit HorizontalPeriodToggle$lambda$37(Modifier arg0, TimePickerState arg1, TimePickerColors arg2, int arg3, Composer arg4, int arg5) {
        TimePickerKt.HorizontalPeriodToggle(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final void HorizontalTimePicker(AnalogTimePickerState arg16, Modifier arg17, TimePickerColors arg18, boolean arg19, Composer arg20, int arg21, int arg22) {
        Modifier v2_2;
        TimePickerColors v3_3;
        TimePickerColors v2_1;
        Companion v7_3;
        Modifier v3_2;
        int v9;
        boolean v8_1;
        int v8;
        TimePickerColors v7_1;
        Modifier v5;
        int v2;
        AnalogTimePickerState v1 = arg16;
        int v6 = arg21;
        int v0 = 0x555F4751;
        Composer v4 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v4, "C(HorizontalTimePicker)N(state,modifier,colors,autoSwitchToMinute)982@42004L27,981@41961L418:TimePicker.kt#uh7d8r");
        if((arg22 & 1) != 0) {
            v2 = v6 | 6;
        }
        else if((v6 & 6) == 0) {
            v2 = v4.changedInstance(v1) ? 4 : 2;
            v2 |= v6;
        }
        else {
            v2 = v6;
        }

        int v3 = arg22 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_35;
        }
        else if((v6 & 0x30) == 0) {
            v5 = arg17;
            int v7 = v4.changed(v5) ? 0x20 : 16;
            v2 |= v7;
        }
        else {
        label_35:
            v5 = arg17;
        }

        if((v6 & 0x180) == 0) {
            if((arg22 & 4) == 0) {
                v7_1 = arg18;
                if(v4.changed(v7_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_46;
                }
            }
            else {
                v7_1 = arg18;
            label_46:
                v8 = 0x80;
            }

            v2 |= v8;
        }
        else {
            v7_1 = arg18;
        }

        if((arg22 & 8) != 0) {
            v2 |= 0xC00;
            goto label_64;
        }
        else if((v6 & 0xC00) == 0) {
            v8_1 = arg19;
            v9 = v4.changed(v8_1) ? 0x800 : 0x400;
            v2 |= v9;
        }
        else {
        label_64:
            v8_1 = arg19;
        }

        boolean v9_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v4.shouldExecute(v9_1, v2 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "978@41910L8");
            int v10 = 6;
            if((v6 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v3_1 = Modifier.Companion;
                }
                else {
                    v3_2 = v5;
                }

                if((arg22 & 4) != 0) {
                    v7_3 = ((Companion)v3_2);
                    v3 = v2 & -897;
                    v2_1 = TimePickerDefaults.INSTANCE.colors(v4, v10);
                    goto label_110;
                }

                Companion v15 = ((Companion)v3_2);
                v3 = v2;
                v2_1 = v7_1;
                v7_3 = v15;
            }
            else {
                v4.skipToGroupEnd();
                if((arg22 & 4) != 0) {
                    v2 &= -897;
                }

                v3 = v2;
                v2_1 = v7_1;
                Modifier v7_2 = v5;
            }

        label_110:
            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:980)");
            }

            ComposerKt.sourceInformationMarkerStart(v4, 2058016684, "CC(remember):TimePicker.kt#9igjgp");
            Object v0_1 = v4.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda29 v0_2 = new TimePickerKt$$ExternalSyntheticLambda29();
                v4.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            Modifier v0_3 = SemanticsModifierKt.semantics$default(((Modifier)v7_3), false, ((Function1)v0_1), 1, null);
            androidx.compose.ui.Alignment$Vertical v5_1 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(v4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v5_2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), v5_1, v4, 0x30);
            ComposerKt.sourceInformationMarkerStart(v4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v9 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
            CompositionLocalMap v11 = v4.getCurrentCompositionLocalMap();
            v0_3 = ComposedModifierKt.materializeModifier(v4, v0_3);
            Function0 v12 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v4, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v4.startReusableNode();
            if(v4.getInserting()) {
                v4.createNode(v12);
            }
            else {
                v4.useNode();
            }

            Composer v12_1 = Updater.constructor-impl(v4);
            Updater.set-impl(v12_1, v5_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v12_1, v11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v12_1.getInserting()) || !Intrinsics.areEqual(v12_1.rememberedValue(), Integer.valueOf(v9))) {
                v12_1.updateRememberedValue(Integer.valueOf(v9));
                v12_1.apply(Integer.valueOf(v9), v5_3);
            }

            Updater.set-impl(v12_1, v0_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v4, 0x56084E62, "C985@42105L37,986@42151L59,987@42219L154:TimePicker.kt#uh7d8r");
            TimePickerKt.HorizontalClockDisplay(v1, v2_1, v4, v3 & 14 | v3 >> 3 & 0x70);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, TimePickerKt.ClockDisplayBottomMargin), v4, v10);
            TimePickerKt.ClockFace(Modifier.Companion.then(new ClockFaceSizeModifier()), v1, v2_1, v8_1, v4, v3 << 3 & 0x70 | v3 & 0x380 | v3 & 0x1C00);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            v4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_3 = v2_1;
            v2_2 = ((Modifier)v7_3);
        }
        else {
            v4.skipToGroupEnd();
            v2_2 = v5;
            v3_3 = v7_1;
        }

        ScopeUpdateScope v7_4 = v4.endRestartGroup();
        if(v7_4 != null) {
            v7_4.updateScope(new TimePickerKt$$ExternalSyntheticLambda30(arg16, v2_2, v3_3, arg19, v6, arg22));
        }
    }

    static final Unit HorizontalTimePicker$lambda$13$lambda$12(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setTraversalGroup(arg1, true);
        return Unit.INSTANCE;
    }

    static final Unit HorizontalTimePicker$lambda$15(AnalogTimePickerState arg7, Modifier arg8, TimePickerColors arg9, boolean arg10, int arg11, int arg12, Composer arg13, int arg14) {
        TimePickerKt.HorizontalTimePicker(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    private static final void PeriodToggleImpl(Modifier arg23, TimePickerState arg24, TimePickerColors arg25, MeasurePolicy arg26, Shape arg27, Shape arg28, Composer arg29, int arg30) {
        TimePickerKt$$ExternalSyntheticLambda21 v7_4;
        int v8;
        Shape v5_2;
        int v5_1;
        int v3;
        Modifier v1 = arg23;
        TimePickerState v2 = arg24;
        MeasurePolicy v4 = arg26;
        int v7 = arg30;
        int v0 = 1374241901;
        Composer v13 = arg29.startRestartGroup(v0);
        ComposerKt.sourceInformation(v13, "C(PeriodToggleImpl)N(modifier,state,colors,measurePolicy,startShape,endShape)1305@53644L5,1306@53699L41,1310@53820L128,1307@53745L1360:TimePicker.kt#uh7d8r");
        if((v7 & 6) == 0) {
            v3 = v13.changed(v1) ? 4 : 2;
            v3 |= v7;
        }
        else {
            v3 = v7;
        }

        if((v7 & 0x30) == 0) {
            boolean v5 = (v7 & 0x40) == 0 ? v13.changed(v2) : v13.changedInstance(v2);
            v5_1 = v5 ? 0x20 : 16;
            v3 |= v5_1;
        }

        TimePickerColors v11 = arg25;
        if((v7 & 0x180) == 0) {
            v5_1 = v13.changed(v11) ? 0x100 : 0x80;
            v3 |= v5_1;
        }

        if((v7 & 0xC00) == 0) {
            v5_1 = v13.changed(v4) ? 0x800 : 0x400;
            v3 |= v5_1;
        }

        Shape v9 = arg27;
        if((v7 & 0x6000) == 0) {
            v5_1 = v13.changed(v9) ? 0x4000 : 0x2000;
            v3 |= v5_1;
        }

        if((0x30000 & v7) == 0) {
            v5_2 = arg28;
            v8 = v13.changed(v5_2) ? 0x20000 : 0x10000;
            v3 |= v8;
        }
        else {
            v5_2 = arg28;
        }

        int v15 = 1;
        boolean v8_1 = (74899 & v3) != 74898 ? true : false;
        if(v13.shouldExecute(v8_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1301)");
            }

            BorderStroke v0_1 = BorderStrokeKt.BorderStroke-cXLIe8U(TimePickerTokens.INSTANCE.getPeriodSelectorOutlineWidth-D9Ej5fM(), v11.getPeriodSelectorBorderColor-0d7_KjU());
            Shape v6 = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), v13, 6);
            Intrinsics.checkNotNull(v6, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            String v7_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_time_picker_period_toggle_description), v13, 0);
            String v10 = "CC(remember):TimePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v13, 2091524749, v10);
            v8_1 = v13.changed(v7_1);
            Object v14 = v13.rememberedValue();
            if((v8_1) || v14 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda20 v14_1 = new TimePickerKt$$ExternalSyntheticLambda20(v7_1);
                v13.updateRememberedValue(v14_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            Modifier v0_2 = BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(v1, false, ((Function1)v14), 1, null)), v0_1, v6);
            ComposerKt.sourceInformationMarkerStart(v13, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v6_1 = ComposablesKt.getCurrentCompositeKeyHash(v13, 0);
            CompositionLocalMap v8_2 = v13.getCurrentCompositionLocalMap();
            v0_2 = ComposedModifierKt.materializeModifier(v13, v0_2);
            Function0 v14_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v13, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v13.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v13.startReusableNode();
            if(v13.getInserting()) {
                v13.createNode(v14_2);
            }
            else {
                v13.useNode();
            }

            Composer v7_2 = Updater.constructor-impl(v13);
            Updater.set-impl(v7_2, v4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v7_2, v8_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v8_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v7_2.getInserting()) || !Intrinsics.areEqual(v7_2.rememberedValue(), Integer.valueOf(v6_1))) {
                v7_2.updateRememberedValue(Integer.valueOf(v6_1));
                v7_2.apply(Integer.valueOf(v6_1), v8_3);
            }

            Updater.set-impl(v7_2, v0_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v13, 0x64025515, "C1321@54231L120,1318@54118L367,1330@54498L219,1339@54840L121,1336@54730L358:TimePicker.kt#uh7d8r");
            v8 = TimePickerKt.isPm(v2) ^ 1;
            ComposerKt.sourceInformationMarkerStart(v13, 0xF2B5CB7C, v10);
            v0 = v3 & 0x70;
            if(v0 != 0x20) {
                if((v3 & 0x40) != 0 && (v13.changedInstance(v2))) {
                    goto label_177;
                }

                v6_1 = 0;
            }
            else {
            label_177:
                v6_1 = 1;
            }

            Object v7_3 = v13.rememberedValue();
            if(v6_1 != 0 || v7_3 == Composer.Companion.getEmpty()) {
                v7_4 = new TimePickerKt$$ExternalSyntheticLambda21(v2);
                v13.updateRememberedValue(v7_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            int v14_3 = v3 << 3 & 0x1C00;
            v6_1 = v14_3;
            TimePickerKt.ToggleItem(((boolean)v8), v9, v7_4, v11, ComposableSingletons$TimePickerKt.INSTANCE.getLambda$1425358052$material3(), v13, v3 >> 9 & 0x70 | 0x6000 | v14_3);
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId(Modifier.Companion, "Spacer"), 2f), 0f, 1, null), arg25.getPeriodSelectorBorderColor-0d7_KjU(), null, 2, null), v13, 0);
            v8_1 = TimePickerKt.isPm(v2);
            ComposerKt.sourceInformationMarkerStart(v13, 0xF2B6179D, v10);
            if(v0 != 0x20 && ((v3 & 0x40) == 0 || !v13.changedInstance(v2))) {
                v15 = 0;
            }

            Object v0_3 = v13.rememberedValue();
            if(v15 != 0 || v0_3 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda23 v0_4 = new TimePickerKt$$ExternalSyntheticLambda23(v2);
                v13.updateRememberedValue(v0_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            TimePickerKt.ToggleItem(v8_1, v5_2, v0_3, arg25, ComposableSingletons$TimePickerKt.INSTANCE.getLambda$-1179219109$material3(), v13, v3 >> 12 & 0x70 | 0x6000 | v6_1);
            ComposerKt.sourceInformationMarkerEnd(v13);
            v13.endNode();
            ComposerKt.sourceInformationMarkerEnd(v13);
            ComposerKt.sourceInformationMarkerEnd(v13);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_256;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v13.skipToGroupEnd();
        }

    label_256:
        ScopeUpdateScope v8_4 = v13.endRestartGroup();
        if(v8_4 != null) {
            v8_4.updateScope(new TimePickerKt$$ExternalSyntheticLambda24(v1, v2, arg25, v4, arg27, arg28, arg30));
        }
    }

    static final Unit PeriodToggleImpl$lambda$41$lambda$40(String arg1, SemanticsPropertyReceiver arg2) {
        SemanticsPropertiesKt.setTraversalGroup(arg2, true);
        SemanticsPropertiesKt.setContentDescription(arg2, arg1);
        return Unit.INSTANCE;
    }

    static final Unit PeriodToggleImpl$lambda$46$lambda$43$lambda$42(TimePickerState arg1) {
        if(TimePickerKt.isPm(arg1)) {
            arg1.setHour(arg1.getHour() - 12);
        }

        return Unit.INSTANCE;
    }

    static final Unit PeriodToggleImpl$lambda$46$lambda$45$lambda$44(TimePickerState arg1) {
        if(!TimePickerKt.isPm(arg1)) {
            arg1.setHour(arg1.getHour() + 12);
        }

        return Unit.INSTANCE;
    }

    static final Unit PeriodToggleImpl$lambda$47(Modifier arg8, TimePickerState arg9, TimePickerColors arg10, MeasurePolicy arg11, Shape arg12, Shape arg13, int arg14, Composer arg15, int arg16) {
        TimePickerKt.PeriodToggleImpl(arg8, arg9, arg10, arg11, arg12, arg13, arg15, RecomposeScopeImplKt.updateChangedFlags(arg14 | 1));
        return Unit.INSTANCE;
    }

    public static final void TimeInput(TimePickerState arg7, Modifier arg8, TimePickerColors arg9, Composer arg10, int arg11, int arg12) {
        Companion v8;
        int v3;
        int v1;
        int v0 = -760850373;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(TimeInput)N(state,modifier,colors)275@13528L38:TimePicker.kt#uh7d8r");
        if((arg12 & 1) != 0) {
            v1 = arg11 | 6;
        }
        else if((arg11 & 6) == 0) {
            boolean v1_1 = (arg11 & 8) == 0 ? arg10.changed(arg7) : arg10.changedInstance(arg7);
            v1 = v1_1 ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        int v2 = arg12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((arg11 & 0x30) == 0) {
            v3 = arg10.changed(arg8) ? 0x20 : 16;
            v1 |= v3;
        }

        if((arg11 & 0x180) == 0) {
            v3 = (arg12 & 4) != 0 || !arg10.changed(arg9) ? 0x80 : 0x100;
            v1 |= v3;
        }

        boolean v3_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v3_1, v1 & 1)) {
            arg10.startDefaults();
            ComposerKt.sourceInformation(arg10, "273@13510L8");
            int v4 = 6;
            if((arg11 & 1) == 0 || (arg10.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v8 = Modifier.Companion;
                }

                if((arg12 & 4) == 0) {
                    goto label_73;
                }

                arg9 = TimePickerDefaults.INSTANCE.colors(arg10, v4);
            label_72:
                v1 &= -897;
            }
            else {
                arg10.skipToGroupEnd();
                if((arg12 & 4) != 0) {
                    goto label_72;
                }
            }

        label_73:
            arg10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.TimeInput (TimePicker.kt:274)");
            }

            TimePickerKt.TimeInputImpl(((Modifier)v8), arg9, arg7, arg10, v1 >> 3 & 0x7E | v1 << v4 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_90;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_90:
        Modifier v3_2 = ((Modifier)v8);
        TimePickerColors v4_1 = arg9;
        ScopeUpdateScope v8_1 = arg10.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new TimePickerKt$$ExternalSyntheticLambda18(arg7, v3_2, v4_1, arg11, arg12));
        }
    }

    static final Unit TimeInput$lambda$5(TimePickerState arg6, Modifier arg7, TimePickerColors arg8, int arg9, int arg10, Composer arg11, int arg12) {
        TimePickerKt.TimeInput(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    private static final void TimeInputImpl(Modifier arg51, TimePickerColors arg52, TimePickerState arg53, Composer arg54, int arg55) {
        TimePickerColors v4_4;
        Modifier v6_2;
        MutableState v10_3;
        Object v17;
        MutableState v12;
        TimePickerKt$TimeInputImpl$1$1 v5_2;
        Ref v10_2;
        TimePickerKt$$ExternalSyntheticLambda22 v10_1;
        int v15_2;
        TimePickerKt$$ExternalSyntheticLambda11 v15_1;
        int v14;
        int v4;
        int v3;
        Modifier v0 = arg51;
        TimePickerColors v7 = arg52;
        TimePickerState v2 = arg53;
        int v8 = arg55;
        int v1 = 0xE3A608FB;
        Composer v9 = arg54.startRestartGroup(v1);
        ComposerKt.sourceInformation(v9, "C(TimeInputImpl)N(modifier,colors,state)1002@42753L35,1002@42701L87,1005@42873L37,1005@42821L89,1007@42935L27,1009@43044L177,1009@43003L218,1017@43227L4621:TimePicker.kt#uh7d8r");
        if((v8 & 6) == 0) {
            v3 = v9.changed(v0) ? 4 : 2;
            v3 |= v8;
        }
        else {
            v3 = v8;
        }

        if((v8 & 0x30) == 0) {
            v4 = v9.changed(v7) ? 0x20 : 16;
            v3 |= v4;
        }

        int v5 = 0x100;
        if((v8 & 0x180) == 0) {
            boolean v4_1 = (v8 & 0x200) == 0 ? v9.changed(v2) : v9.changedInstance(v2);
            v4 = v4_1 ? v5 : 0x80;
            v3 |= v4;
        }

        int v11 = v3;
        boolean v3_1 = (v11 & 0x93) != 0x92 ? true : false;
        if(v9.shouldExecute(v3_1, v11 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v11, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:997)");
            }

            Object[] v1_1 = new Object[0];
            Saver v3_2 = TextFieldValue.Companion.getSaver();
            String v6 = "CC(remember):TimePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, -1840782178, v6);
            v4 = v11 & 0x380;
            if(v4 != v5) {
                if((v11 & 0x200) != 0 && (v9.changedInstance(v2))) {
                    goto label_71;
                }

                v14 = 0;
            }
            else {
            label_71:
                v14 = 1;
            }

            Object v15 = v9.rememberedValue();
            if(v14 != 0 || v15 == Composer.Companion.getEmpty()) {
                v15_1 = new TimePickerKt$$ExternalSyntheticLambda11(v2);
                v9.updateRememberedValue(v15_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            MutableState v1_2 = RememberSaveableKt.rememberSaveable(v1_1, v3_2, ((Function0)v15_1), v9, 0);
            Object[] v3_3 = new Object[0];
            Saver v14_1 = TextFieldValue.Companion.getSaver();
            ComposerKt.sourceInformationMarkerStart(v9, 0x9247F3A0, v6);
            if(v4 != v5) {
                if((v11 & 0x200) != 0 && (v9.changedInstance(v2))) {
                    goto label_95;
                }

                v15_2 = 0;
            }
            else {
            label_95:
                v15_2 = 1;
            }

            Object v10 = v9.rememberedValue();
            if(v15_2 != 0 || v10 == Composer.Companion.getEmpty()) {
                v10_1 = new TimePickerKt$$ExternalSyntheticLambda22(v2);
                v9.updateRememberedValue(v10_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            MutableState v3_4 = RememberSaveableKt.rememberSaveable(v3_3, v14_1, ((Function0)v10_1), v9, 0);
            ComposerKt.sourceInformationMarkerStart(v9, 0x9247FB56, v6);
            v10 = v9.rememberedValue();
            if(v10 == Composer.Companion.getEmpty()) {
                v10_2 = new Ref();
                v9.updateRememberedValue(v10_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            Integer v14_2 = Integer.valueOf(v2.getHour());
            Integer v15_3 = Integer.valueOf(v2.getMinute());
            ComposerKt.sourceInformationMarkerStart(v9, 0x9248098C, v6);
            int v6_1 = v9.changedInstance(v10_2) | v9.changed(v1_2);
            if(v4 != v5) {
                if((v11 & 0x200) != 0 && (v9.changedInstance(v2))) {
                    goto label_133;
                }

                v4 = 0;
            }
            else {
            label_133:
                v4 = 1;
            }

            v4 = v4 | v6_1 | v9.changed(v3_4);
            Object v5_1 = v9.rememberedValue();
            if(v4 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                MutableState v4_2 = v1_2;
                TimePickerKt$TimeInputImpl$1$1 v1_3 = new TimePickerKt$TimeInputImpl$1$1(v10_2, v2, v4_2, v3_4, null);
                v17 = v10_2;
                v10_3 = v4_2;
                v12 = v3_4;
                v5_2 = v1_3;
                v9.updateRememberedValue(v5_2);
            }
            else {
                v12 = v3_4;
                v17 = v10_2;
                v10_3 = v1_2;
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            EffectsKt.LaunchedEffect(v14_2, v15_3, ((Function2)v5_2), v9, 0);
            Modifier v1_4 = PaddingKt.padding-qDBjuR0$default(v0, 0f, 0f, 0f, TimePickerKt.TimeInputBottomPadding, 7, null);
            v6_2 = v0;
            androidx.compose.ui.Alignment$Vertical v0_1 = Alignment.Companion.getTop();
            ComposerKt.sourceInformationMarkerStart(v9, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v0_2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), v0_1, v9, 0x30);
            String v2_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v9, -1323940314, v2_1);
            v3 = ComposablesKt.getCurrentCompositeKeyHash(v9, 0);
            CompositionLocalMap v4_3 = v9.getCurrentCompositionLocalMap();
            v1_4 = ComposedModifierKt.materializeModifier(v9, v1_4);
            Function0 v5_3 = ComposeUiNode.Companion.getConstructor();
            String v15_4 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, 0xD6BD0031, v15_4);
            if(!(v9.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v9.startReusableNode();
            if(v9.getInserting()) {
                v9.createNode(v5_3);
            }
            else {
                v9.useNode();
            }

            Composer v5_4 = Updater.constructor-impl(v9);
            Updater.set-impl(v5_4, v0_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_4, v4_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v0_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_4.getInserting()) || !Intrinsics.areEqual(v5_4.rememberedValue(), Integer.valueOf(v3))) {
                v5_4.updateRememberedValue(Integer.valueOf(v3));
                v5_4.apply(Integer.valueOf(v3), v0_3);
            }

            Updater.set-impl(v5_4, v1_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v9, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v9, 0xAD64A0EB, "C1022@43428L5,1031@43794L3669,1027@43572L3891:TimePicker.kt#uh7d8r");
            v14 = 6;
            v4_4 = v7;
            v1_2 = v10_3;
            String v10_4 = v2_1;
            v2 = arg53;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TextStyle.copy-p1EtxEg$default(TypographyKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldLabelTextFont(), v9, v14), v7.timeSelectorContentColor-vNxB06k$material3(true), 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, null, null, null, 0, 0, null, 0xFF7FFE, null)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(1306700887, true, new TimePickerKt$TimeInputImpl$2$1(v1_2, v2, v17, v4_4, v12), v9, 54), v9, ProvidedValue.$stable | 0x30);
            if(!v2.is24hour()) {
                v9.startReplaceGroup(0xADA13BCF);
                ComposerKt.sourceInformation(v9, "1120@47508L324");
                v0 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, TimePickerKt.PeriodToggleMargin, 0f, 0f, 0f, 14, null);
                ComposerKt.sourceInformationMarkerStart(v9, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy v1_5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v9, -1323940314, v10_4);
                v3 = ComposablesKt.getCurrentCompositeKeyHash(v9, 0);
                CompositionLocalMap v5_5 = v9.getCurrentCompositionLocalMap();
                v0 = ComposedModifierKt.materializeModifier(v9, v0);
                Function0 v7_1 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v9, 0xD6BD0031, v15_4);
                if(!(v9.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v9.startReusableNode();
                if(v9.getInserting()) {
                    v9.createNode(v7_1);
                }
                else {
                    v9.useNode();
                }

                Composer v7_2 = Updater.constructor-impl(v9);
                Updater.set-impl(v7_2, v1_5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v7_2, v5_5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v1_6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v7_2.getInserting()) || !Intrinsics.areEqual(v7_2.rememberedValue(), Integer.valueOf(v3))) {
                    v7_2.updateRememberedValue(Integer.valueOf(v3));
                    v7_2.apply(Integer.valueOf(v3), v1_6);
                }

                Updater.set-impl(v7_2, v0, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v9, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v9, 1377011131, "C1121@47576L242:TimePicker.kt#uh7d8r");
                TimePickerKt.VerticalPeriodToggle(SizeKt.size-VpY3zN4(Modifier.Companion, TimeInputTokens.INSTANCE.getPeriodSelectorContainerWidth-D9Ej5fM(), TimeInputTokens.INSTANCE.getPeriodSelectorContainerHeight-D9Ej5fM()), v2, v4_4, v9, v11 >> 3 & 0x70 | v14 | v11 << 3 & 0x380);
                ComposerKt.sourceInformationMarkerEnd(v9);
                ComposerKt.sourceInformationMarkerEnd(v9);
                v9.endNode();
                ComposerKt.sourceInformationMarkerEnd(v9);
                ComposerKt.sourceInformationMarkerEnd(v9);
                ComposerKt.sourceInformationMarkerEnd(v9);
                v9.endReplaceGroup();
            }
            else {
                v9.startReplaceGroup(-1381607893);
                v9.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            v9.endNode();
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_394;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v6_2 = v0;
            v4_4 = v7;
            v9.skipToGroupEnd();
        }

    label_394:
        ScopeUpdateScope v0_4 = v9.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new TimePickerKt$$ExternalSyntheticLambda31(v6_2, v4_4, v2, v8));
        }
    }

    private static final TextFieldValue TimeInputImpl$hourTextValue(TimePickerState arg8) {
        return new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(TimePickerKt.getHourForDisplay(arg8), 2, 0, false, null, 14, null), 0, null, 6, null);
    }

    static final MutableState TimeInputImpl$lambda$17$lambda$16(TimePickerState arg2) {
        return SnapshotStateKt.mutableStateOf$default(TimePickerKt.TimeInputImpl$hourTextValue(arg2), null, 2, null);
    }

    private static final TextFieldValue TimeInputImpl$lambda$18(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void TimeInputImpl$lambda$19(MutableState arg0, TextFieldValue arg1) {
        arg0.setValue(arg1);
    }

    static final MutableState TimeInputImpl$lambda$21$lambda$20(TimePickerState arg2) {
        return SnapshotStateKt.mutableStateOf$default(TimePickerKt.TimeInputImpl$minuteTextValue(arg2), null, 2, null);
    }

    private static final TextFieldValue TimeInputImpl$lambda$22(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void TimeInputImpl$lambda$23(MutableState arg0, TextFieldValue arg1) {
        arg0.setValue(arg1);
    }

    static final Unit TimeInputImpl$lambda$28(Modifier arg0, TimePickerColors arg1, TimePickerState arg2, int arg3, Composer arg4, int arg5) {
        TimePickerKt.TimeInputImpl(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    private static final TextFieldValue TimeInputImpl$minuteTextValue(TimePickerState arg8) {
        return new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(arg8.getMinute(), 2, 0, false, null, 14, null), 0, null, 6, null);
    }

    public static final void TimePicker-mT9BvqQ(TimePickerState arg17, Modifier arg18, TimePickerColors arg19, int arg20, Composer arg21, int arg22, int arg23) {
        TimePickerColors v3_1;
        Modifier v2_3;
        Modifier v7_5;
        TimePickerColors v8_1;
        AnalogTimePickerState v11_1;
        int v10_1;
        Composer v9_2;
        TimePickerColors v2_2;
        Modifier v4_1;
        int v15;
        int v14;
        TimePickerColors v6_1;
        Companion v4_2;
        int v9;
        int v8;
        TimePickerColors v7_1;
        int v7;
        Modifier v6;
        int v2;
        TimePickerState v1 = arg17;
        int v5 = arg22;
        int v0 = 0xDB16704C;
        Composer v10 = arg21.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(TimePicker)N(state,modifier,colors,layoutType:c#material3.TimePickerLayoutType)225@11775L35,226@11834L27,228@11885L62,230@11994L181,230@11953L222:TimePicker.kt#uh7d8r");
        int v3 = 4;
        if((arg23 & 1) != 0) {
            v2 = v5 | 6;
        }
        else if((v5 & 6) == 0) {
            boolean v2_1 = (v5 & 8) == 0 ? v10.changed(v1) : v10.changedInstance(v1);
            v2 = v2_1 ? v3 : 2;
            v2 |= v5;
        }
        else {
            v2 = v5;
        }

        int v4 = arg23 & 2;
        if(v4 != 0) {
            v2 |= 0x30;
            goto label_40;
        }
        else if((v5 & 0x30) == 0) {
            v6 = arg18;
            v7 = v10.changed(v6) ? 0x20 : 16;
            v2 |= v7;
        }
        else {
        label_40:
            v6 = arg18;
        }

        if((v5 & 0x180) == 0) {
            if((arg23 & 4) == 0) {
                v7_1 = arg19;
                if(v10.changed(v7_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_51;
                }
            }
            else {
                v7_1 = arg19;
            label_51:
                v8 = 0x80;
            }

            v2 |= v8;
        }
        else {
            v7_1 = arg19;
        }

        if((v5 & 0xC00) == 0) {
            if((arg23 & 8) == 0) {
                v8 = arg20;
                if(v10.changed(v8)) {
                    v9 = 0x800;
                }
                else {
                    goto label_65;
                }
            }
            else {
                v8 = arg20;
            label_65:
                v9 = 0x400;
            }

            v2 |= v9;
        }
        else {
            v8 = arg20;
        }

        boolean v9_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v10.shouldExecute(v9_1, v2 & 1)) {
            v10.startDefaults();
            ComposerKt.sourceInformation(v10, "222@11658L8,223@11726L12");
            if((v5 & 1) == 0 || (v10.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v4_2 = Modifier.Companion;
                }
                else {
                    v4_1 = v6;
                }

                v9 = 6;
                if((arg23 & 4) != 0) {
                    v6_1 = TimePickerDefaults.INSTANCE.colors(v10, v9);
                    v2 &= -897;
                }
                else {
                    v6_1 = v7_1;
                }

                if((arg23 & 8) != 0) {
                    v15 = v2 & 0xFFFFE3FF;
                    v2_2 = v6_1;
                    v14 = TimePickerDefaults.INSTANCE.layoutType-sDNSZnc(v10, v9);
                    goto label_121;
                }

                v15 = v2;
                v2_2 = v6_1;
            label_120:
                v14 = v8;
            }
            else {
                v10.skipToGroupEnd();
                if((arg23 & 4) != 0) {
                    v2 &= -897;
                }

                if((arg23 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                v15 = v2;
                v4_1 = v6;
                v2_2 = v7_1;
                goto label_120;
            }

        label_121:
            v10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v15, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:224)");
            }

            v9_2 = v10;
            State v0_1 = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, v9_2, 0, 7);
            String v7_2 = "CC(remember):TimePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9_2, 0x6F3BB847, v7_2);
            Object v6_2 = v9_2.rememberedValue();
            if(v6_2 == Composer.Companion.getEmpty()) {
                Ref v6_3 = new Ref();
                v9_2.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v9_2);
            ComposerKt.sourceInformationMarkerStart(v9_2, 0x6F3BBECA, v7_2);
            v8 = v15 & 14;
            if(v8 != v3) {
                if((v15 & 8) != 0 && (v9_2.changed(v1))) {
                    goto label_156;
                }

                v10_1 = 0;
            }
            else {
            label_156:
                v10_1 = 1;
            }

            Object v11 = v9_2.rememberedValue();
            if(v10_1 != 0 || v11 == Composer.Companion.getEmpty()) {
                v11_1 = new AnalogTimePickerState(v1, ((Ref)v6_2));
                v9_2.updateRememberedValue(v11_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v9_2);
            Integer v10_2 = Integer.valueOf(v1.getHour());
            Integer v13 = Integer.valueOf(v1.getMinute());
            ComposerKt.sourceInformationMarkerStart(v9_2, 1866190049, v7_2);
            v7 = v9_2.changedInstance(v6_2) | v9_2.changedInstance(v11_1);
            if(v8 != v3) {
                if((v15 & 8) != 0 && (v9_2.changedInstance(v1))) {
                    goto label_184;
                }

                v3 = 0;
            }
            else {
            label_184:
                v3 = 1;
            }

            v3 |= v7;
            Object v7_3 = v9_2.rememberedValue();
            if(v3 != 0 || v7_3 == Composer.Companion.getEmpty()) {
                TimePickerKt$TimePicker$1$1 v7_4 = new TimePickerKt$TimePicker$1$1(((Ref)v6_2), v11_1, v1, null);
                v9_2.updateRememberedValue(v7_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v9_2);
            EffectsKt.LaunchedEffect(v10_2, v13, ((Function2)v7_3), v9_2, 0);
            if(TimePickerLayoutType.equals-impl0(v14, TimePickerLayoutType.Companion.getVertical-QJTpgSE())) {
                v9_2.startReplaceGroup(2017551219);
                ComposerKt.sourceInformation(v9_2, "239@12240L179");
                v8_1 = v2_2;
                v7_5 = ((Modifier)v4_2);
                TimePickerKt.VerticalTimePicker(v11_1, v7_5, v8_1, TimePickerKt.TimePicker_mT9BvqQ$lambda$0(v0_1) ^ 1, v9_2, v15 & 0x3F0, 0);
                v9_2 = v9_2;
                v9_2.endReplaceGroup();
            }
            else {
                v8_1 = v2_2;
                v7_5 = ((Modifier)v4_2);
                v9_2.startReplaceGroup(2017750673);
                ComposerKt.sourceInformation(v9_2, "246@12441L181");
                TimePickerKt.HorizontalTimePicker(v11_1, v7_5, v8_1, TimePickerKt.TimePicker_mT9BvqQ$lambda$0(v0_1) ^ 1, v9_2, v15 & 0x3F0, 0);
                v9_2 = v9_2;
                v9_2.endReplaceGroup();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_3 = v7_5;
            v3_1 = v8_1;
            v4 = v14;
        }
        else {
            v9_2 = v10;
            v9_2.skipToGroupEnd();
            v2_3 = v6;
            v3_1 = v7_1;
            v4 = v8;
        }

        ScopeUpdateScope v7_6 = v9_2.endRestartGroup();
        if(v7_6 != null) {
            v7_6.updateScope(new TimePickerKt$$ExternalSyntheticLambda8(v1, v2_3, v3_1, v4, v5, arg23));
        }
    }

    public static final TimePickerState TimePickerState(int arg1, int arg2, boolean arg3) {
        return new TimePickerStateImpl(arg1, arg2, arg3);
    }

    private static final void TimePickerTextField-1vLObsk(Modifier arg114, TextFieldValue arg115, Function1 arg116, TimePickerState arg117, int arg118, KeyboardOptions arg119, KeyboardActions arg120, TimePickerColors arg121, Composer arg122, int arg123, int arg124) {
        KeyboardOptions v6_7;
        KeyboardActions v7_3;
        TimePickerKt$TimePickerTextField$2$1 v6_6;
        int v3_4;
        Object v15_2;
        int v1_2;
        KeyboardActions v12;
        int v15;
        KeyboardOptions v14_1;
        int v11;
        int v9;
        int v4;
        Modifier v1 = arg114;
        TextFieldValue v2 = arg115;
        TimePickerState v5 = arg117;
        int v6 = arg118;
        TimePickerColors v7 = arg121;
        int v0 = arg123;
        int v10 = arg124;
        Composer v8 = arg122.startRestartGroup(0x4D6FCE7E);
        ComposerKt.sourceInformation(v8, "C(TimePickerTextField)N(modifier,value,onValueChange,state,selection:c#material3.TimePickerSelectionMode,keyboardOptions,keyboardActions,colors)1867@72322L39,1868@72387L29,1870@72477L243,1876@72773L3414,1962@76225L103,1962@76193L135:TimePicker.kt#uh7d8r");
        int v105 = 4;
        int v106 = 2;
        if((v10 & 1) != 0) {
            v4 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v4 = v8.changed(v1) ? v105 : v106;
            v4 |= v0;
        }
        else {
            v4 = v0;
        }

        if((v10 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            v9 = v8.changed(v2) ? 0x20 : 16;
            v4 |= v9;
        }

        if((v10 & 4) != 0) {
            v4 |= 0x180;
        }
        else if((v0 & 0x180) == 0) {
            v11 = v8.changedInstance(arg116) ? 0x100 : 0x80;
            v4 |= v11;
        }

        if((v10 & 8) != 0) {
            v4 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            boolean v11_1 = (v0 & 0x1000) == 0 ? v8.changed(v5) : v8.changedInstance(v5);
            v11 = v11_1 ? 0x800 : 0x400;
            v4 |= v11;
        }

        if((v10 & 16) != 0) {
            v4 |= 0x6000;
        }
        else if((v0 & 0x6000) == 0) {
            v11 = v8.changed(v6) ? 0x4000 : 0x2000;
            v4 |= v11;
        }

        v11 = v10 & 0x20;
        int v14 = 0x30000;
        if(v11 != 0) {
            v4 |= v14;
            goto label_98;
        }
        else if((v14 & v0) == 0) {
            v14_1 = arg119;
            v15 = v8.changed(v14_1) ? 0x20000 : 0x10000;
            v4 |= v15;
        }
        else {
        label_98:
            v14_1 = arg119;
        }

        v15 = v10 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v4 |= v16;
            v12 = arg120;
        }
        else {
            v12 = arg120;
            if((v0 & v16) == 0) {
                v16 = v8.changed(v12) ? 0x100000 : 0x80000;
                v4 |= v16;
            }
        }

        int v17 = 0xC00000;
        if((v10 & 0x80) != 0) {
            v4 |= v17;
        }
        else if((v0 & v17) == 0) {
            int v13 = v8.changed(v7) ? 0x800000 : 0x400000;
            v4 |= v13;
        }

        boolean v3 = (0x492493 & v4) != 4793490 ? true : false;
        if(v8.shouldExecute(v3, v4 & 1)) {
            KeyboardOptions v108 = v11 != 0 ? KeyboardOptions.Companion.getDefault() : v14_1;
            KeyboardActions v109 = v15 != 0 ? KeyboardActions.Companion.getDefault() : v12;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x4D6FCE7E, v4, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1866)");
            }

            String v11_2 = "CC(remember):TimePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v8, 0xB0B65E05, v11_2);
            Object v3_1 = v8.rememberedValue();
            if(v3_1 == Composer.Companion.getEmpty()) {
                MutableInteractionSource v3_2 = InteractionSourceKt.MutableInteractionSource();
                v8.updateRememberedValue(v3_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerStart(v8, 0xB0B6661B, v11_2);
            Object v12_1 = v8.rememberedValue();
            if(v12_1 == Composer.Companion.getEmpty()) {
                FocusRequester v12_2 = new FocusRequester();
                v8.updateRememberedValue(v12_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            Object v111 = v12_1;
            String v10_1 = v11_2;
            TextFieldColors v11_3 = OutlinedTextFieldDefaults.INSTANCE.colors-0hiis_0(v7.timeSelectorContentColor-vNxB06k$material3(true), 0, 0, 0, v7.timeSelectorContainerColor-vNxB06k$material3(true), v7.timeSelectorContainerColor-vNxB06k$material3(true), 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, v8, 0, 0, 0, 0, 0xC00, 0x7FFFFFCE, 0xFFF);
            Composer v12_3 = v8;
            boolean v13_1 = TimePickerSelectionMode.equals-impl0(v6, v5.getSelection-yecRtBI());
            ComposerKt.sourceInformationMarkerStart(v12_3, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy v14_2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), v12_3, 0);
            ComposerKt.sourceInformationMarkerStart(v12_3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v0 = ComposablesKt.getCurrentCompositeKeyHash(v12_3, 0);
            CompositionLocalMap v8_1 = v12_3.getCurrentCompositionLocalMap();
            Modifier v15_1 = ComposedModifierKt.materializeModifier(v12_3, v1);
            int v120 = v0;
            Function0 v0_1 = ComposeUiNode.Companion.getConstructor();
            Object v16_1 = v3_1;
            ComposerKt.sourceInformationMarkerStart(v12_3, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v12_3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v12_3.startReusableNode();
            if(v12_3.getInserting()) {
                v12_3.createNode(v0_1);
            }
            else {
                v12_3.useNode();
            }

            Composer v0_2 = Updater.constructor-impl(v12_3);
            Updater.set-impl(v0_2, v14_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_2, v8_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v1_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v0_2.getInserting()) || !Intrinsics.areEqual(v0_2.rememberedValue(), Integer.valueOf(v120))) {
                v0_2.updateRememberedValue(Integer.valueOf(v120));
                v0_2.apply(Integer.valueOf(v120), v1_1);
            }

            Updater.set-impl(v0_2, v15_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v12_3, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v12_3, 2023499365, "C1893@73347L240,1901@73597L2050,1948@75744L2,1950@75783L244,1957@76094L5,1958@76165L5,1947@75657L524:TimePicker.kt#uh7d8r");
            v0 = 6;
            if(!v13_1) {
                v12_3.startReplaceGroup(0x789B01D4);
                ComposerKt.sourceInformation(v12_3, "1878@72840L450");
                Modifier v3_3 = SizeKt.size-VpY3zN4(Modifier.Companion, TimeInputTokens.INSTANCE.getTimeFieldContainerWidth-D9Ej5fM(), TimeInputTokens.INSTANCE.getTimeFieldContainerHeight-D9Ej5fM());
                v1_2 = TimePickerSelectionMode.equals-impl0(v6, TimePickerSelectionMode.Companion.getHour-yecRtBI()) ? TimePickerKt.getHourForDisplay(v5) : v5.getMinute();
                int v8_2 = v4 >> 3;
                v8_2 = v8_2 & 0x1C00 | (v8_2 & 0x380 | v0) | v4 >> 9 & 0xE000;
                v9 = v4;
                v4 = v1_2;
                v1_2 = v9;
                v9 = v8_2;
                v8 = v12_3;
                v15_2 = v16_1;
                v12_1 = v111;
                TimePickerKt.TimeSelector-SAnMeKU(v3_3, v4, v5, v6, v7, v8, v9);
                v3_4 = v6;
                v8.endReplaceGroup();
            }
            else {
                v1_2 = v4;
                v3_4 = v6;
                v8 = v12_3;
                v15_2 = v16_1;
                v12_1 = v111;
                v8.startReplaceGroup(0x78A1F52E);
                v8.endReplaceGroup();
            }

            v4 = TimePickerSelectionMode.equals-impl0(v3_4, TimePickerSelectionMode.Companion.getMinute-yecRtBI()) ? Strings.constructor-impl(string.m3c_time_picker_minute_text_field) : Strings.constructor-impl(string.m3c_time_picker_hour_text_field);
            String v4_1 = Strings_androidKt.getString-2EP1pXo(v4, v8, 0);
            Modifier v6_1 = TimePickerKt.visible(Modifier.Companion, v13_1);
            ComposerKt.sourceInformationMarkerStart(v8, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v7_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v8, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v9 = ComposablesKt.getCurrentCompositeKeyHash(v8, 0);
            CompositionLocalMap v5_1 = v8.getCurrentCompositionLocalMap();
            v6_1 = ComposedModifierKt.materializeModifier(v8, v6_1);
            Function0 v13_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v8, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v8.startReusableNode();
            if(v8.getInserting()) {
                v8.createNode(v13_2);
            }
            else {
                v8.useNode();
            }

            v0_2 = Updater.constructor-impl(v8);
            Updater.set-impl(v0_2, v7_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_2, v5_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v0_2.getInserting()) || !Intrinsics.areEqual(v0_2.rememberedValue(), Integer.valueOf(v9))) {
                v0_2.updateRememberedValue(Integer.valueOf(v9));
                v0_2.apply(Integer.valueOf(v9), v5_2);
            }

            Updater.set-impl(v0_2, v6_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v8, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v8, 0x6A90777F, "C1908@73940L48,1912@74190L7,1919@74491L11,1920@74559L11,1924@74721L916,1902@73643L1994:TimePicker.kt#uh7d8r");
            Modifier v0_3 = SizeKt.size-VpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.Companion, ((FocusRequester)v12_1)), TimeInputTokens.INSTANCE.getTimeFieldContainerWidth-D9Ej5fM(), TimeInputTokens.INSTANCE.getTimeFieldContainerHeight-D9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(v8, 0x5604C68A, v10_1);
            boolean v5_3 = v8.changed(v4_1);
            Object v6_2 = v8.rememberedValue();
            if((v5_3) || v6_2 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda33 v6_3 = new TimePickerKt$$ExternalSyntheticLambda33(v4_1);
                v8.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            v0_3 = SemanticsModifierKt.semantics$default(v0_3, false, ((Function1)v6_2), 1, null);
            ProvidableCompositionLocal v5_4 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(v8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v5_5 = v8.consume(((CompositionLocal)v5_4));
            ComposerKt.sourceInformationMarkerEnd(v8);
            Object v7_2 = v5_5;
            androidx.compose.ui.graphics.Brush$Companion v16_2 = Brush.Companion;
            Pair[] v6_4 = new Pair[6];
            v6_4[0] = TuplesKt.to(Float.valueOf(0f), Color.box-impl(Color.Companion.getTransparent-0d7_KjU()));
            v6_4[1] = TuplesKt.to(Float.valueOf(0.1f), Color.box-impl(Color.Companion.getTransparent-0d7_KjU()));
            v6_4[v106] = TuplesKt.to(Float.valueOf(0.1f), Color.box-impl(MaterialTheme.INSTANCE.getColorScheme(v8, 6).getPrimary-0d7_KjU()));
            v6_4[3] = TuplesKt.to(Float.valueOf(0.9f), Color.box-impl(MaterialTheme.INSTANCE.getColorScheme(v8, 6).getPrimary-0d7_KjU()));
            v6_4[v105] = TuplesKt.to(Float.valueOf(0.9f), Color.box-impl(Color.Companion.getTransparent-0d7_KjU()));
            v6_4[5] = TuplesKt.to(Float.valueOf(1f), Color.box-impl(Color.Companion.getTransparent-0d7_KjU()));
            Brush v16_3 = androidx.compose.ui.graphics.Brush$Companion.verticalGradient-8A-3gB4$default(v16_2, v6_4, 0f, 0f, 0, 14, null);
            int v5_6 = v1_2 >> 3;
            v6 = v1_2 << 3;
            int v119 = v1_2;
            Object v112 = v12_1;
            BasicTextFieldKt.BasicTextField(v2, arg116, v0_3, true, false, ((TextStyle)v7_2), v108, v109, true, 0, 0, null, null, ((MutableInteractionSource)v15_2), v16_3, ComposableLambdaKt.rememberComposableLambda(1007938103, true, new TimePickerKt$TimePickerTextField$1$1$2(v2, ((MutableInteractionSource)v15_2), v11_3), v8, 54), v8, v5_6 & 0x70 | (v5_6 & 14 | 0x6000C00) | 0x380000 & v6 | v6 & 0x1C00000, 0x30C00, 0x1E10);
            KeyboardOptions v3_5 = v108;
            KeyboardActions v2_1 = v109;
            v8 = v8;
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            v8.endNode();
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            Modifier v4_2 = OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0f, TimePickerKt.SupportLabelTop, 1, null);
            String v6_5 = v10_1;
            ComposerKt.sourceInformationMarkerStart(v8, 0x45F5E6D6, v6_5);
            v5_5 = v8.rememberedValue();
            if(v5_5 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda34 v5_7 = new TimePickerKt$$ExternalSyntheticLambda34();
                v8.updateRememberedValue(v5_7);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            Modifier v5_8 = SemanticsModifierKt.clearAndSetSemantics(v4_2, ((Function1)v5_5));
            v4 = TimePickerSelectionMode.equals-impl0(arg118, TimePickerSelectionMode.Companion.getHour-yecRtBI()) ? Strings.constructor-impl(string.m3c_time_picker_hour) : Strings.constructor-impl(string.m3c_time_picker_minute);
            v0 = arg118;
            TextKt.Text-Nvy7gAk(Strings_androidKt.getString-2EP1pXo(v4, v8, 0), v5_8, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextColor(), v8, 6), null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, TypographyKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextFont(), v8, 6), v8, 0, 0, 0x1FFF8);
            v8 = v8;
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            v8.endNode();
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            TimePickerSelectionMode v4_3 = TimePickerSelectionMode.box-impl(arg117.getSelection-yecRtBI());
            ComposerKt.sourceInformationMarkerStart(v8, -1330100699, v6_5);
            v1_2 = v119;
            if((v1_2 & 0x1C00) != 0x800) {
                if((v1_2 & 0x1000) != 0) {
                    v5 = arg117;
                    if(v8.changedInstance(v5)) {
                        goto label_728;
                    }
                }
                else {
                    v5 = arg117;
                }

                v10 = 0;
            }
            else {
                v5 = arg117;
            label_728:
                v10 = 1;
            }

            v1_2 = (v1_2 & 0xE000) == 0x4000 ? 1 : 0;
            v6_2 = v8.rememberedValue();
            if((v1_2 | v10) != 0 || v6_2 == Composer.Companion.getEmpty()) {
                v6_6 = new TimePickerKt$TimePickerTextField$2$1(v5, v0, v112, null);
                v8.updateRememberedValue(v6_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            EffectsKt.LaunchedEffect(v4_3, ((Function2)v6_6), v8, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_3 = v2_1;
            v6_7 = v3_5;
        }
        else {
            v8.skipToGroupEnd();
            v7_3 = v12;
            v6_7 = v14_1;
        }

        ScopeUpdateScope v11_4 = v8.endRestartGroup();
        if(v11_4 != null) {
            v11_4.updateScope(new TimePickerKt$$ExternalSyntheticLambda35(arg114, arg115, arg116, v5, arg118, v6_7, v7_3, arg121, arg123, arg124));
        }
    }

    static final Unit TimePickerTextField_1vLObsk$lambda$92$lambda$89$lambda$88$lambda$87(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentDescription(arg1, arg0);
        return Unit.INSTANCE;
    }

    static final Unit TimePickerTextField_1vLObsk$lambda$92$lambda$91$lambda$90(SemanticsPropertyReceiver arg0) {
        return Unit.INSTANCE;
    }

    static final Unit TimePickerTextField_1vLObsk$lambda$94(Modifier arg12, TextFieldValue arg13, Function1 arg14, TimePickerState arg15, int arg16, KeyboardOptions arg17, KeyboardActions arg18, TimePickerColors arg19, int arg20, int arg21, Composer arg22, int arg23) {
        TimePickerKt.TimePickerTextField-1vLObsk(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit TimePicker_mT9BvqQ$lambda$4(TimePickerState arg7, Modifier arg8, TimePickerColors arg9, int arg10, int arg11, int arg12, Composer arg13, int arg14) {
        TimePickerKt.TimePicker-mT9BvqQ(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    private static final void TimeSelector-SAnMeKU(Modifier arg27, int arg28, TimePickerState arg29, int arg30, TimePickerColors arg31, Composer arg32, int arg33) {
        Composer v23;
        TimePickerKt$$ExternalSyntheticLambda1 v5_2;
        TimePickerKt$$ExternalSyntheticLambda37 v11_1;
        boolean v7_1;
        int v7;
        int v5;
        Modifier v1 = arg27;
        TimePickerState v3 = arg29;
        int v4 = arg30;
        TimePickerColors v0 = arg31;
        int v8 = arg33;
        int v2 = 0xBB920EAF;
        Composer v9 = arg32.startRestartGroup(v2);
        ComposerKt.sourceInformation(v9, "C(TimeSelector)N(modifier,value,state,selection:c#material3.TimePickerSelectionMode,colors)1406@56730L214,1418@57168L124,1428@57503L5,1422@57312L117,1430@57548L498,1416@57084L962:TimePicker.kt#uh7d8r");
        if((v8 & 6) == 0) {
            v5 = v9.changed(v1) ? 4 : 2;
            v5 |= v8;
        }
        else {
            v5 = v8;
        }

        if((v8 & 0x30) == 0) {
            v7 = v9.changed(arg28) ? 0x20 : 16;
            v5 |= v7;
        }

        if((v8 & 0x180) == 0) {
            v7_1 = (v8 & 0x200) == 0 ? v9.changed(v3) : v9.changedInstance(v3);
            v7 = v7_1 ? 0x100 : 0x80;
            v5 |= v7;
        }

        if((v8 & 0xC00) == 0) {
            v7 = v9.changed(v4) ? 0x800 : 0x400;
            v5 |= v7;
        }

        if((v8 & 0x6000) == 0) {
            v7 = v9.changed(v0) ? 0x4000 : 0x2000;
            v5 |= v7;
        }

        v7_1 = (v5 & 9363) != 9362 ? true : false;
        if(v9.shouldExecute(v7_1, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v5, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1403)");
            }

            boolean v12 = TimePickerSelectionMode.equals-impl0(v3.getSelection-yecRtBI(), v4);
            v2 = TimePickerSelectionMode.equals-impl0(v4, TimePickerSelectionMode.Companion.getHour-yecRtBI()) ? Strings.constructor-impl(string.m3c_time_picker_hour_selection) : Strings.constructor-impl(string.m3c_time_picker_minute_selection);
            String v2_1 = Strings_androidKt.getString-2EP1pXo(v2, v9, 0);
            long v15 = v0.timeSelectorContainerColor-vNxB06k$material3(v12);
            long v6 = v0.timeSelectorContentColor-vNxB06k$material3(v12);
            String v10 = "CC(remember):TimePicker.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, 0x1F497D4B, v10);
            boolean v13 = v9.changed(v2_1);
            Object v11 = v9.rememberedValue();
            if((v13) || v11 == Composer.Companion.getEmpty()) {
                v11_1 = new TimePickerKt$$ExternalSyntheticLambda37(v2_1);
                v9.updateRememberedValue(v11_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            Modifier v11_2 = SemanticsModifierKt.semantics(v1, true, ((Function1)v11_1));
            Shape v13_1 = ShapesKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), v9, 6);
            ComposerKt.sourceInformationMarkerStart(v9, 0x1F498F44, v10);
            v2 = (v5 & 0x1C00) == 0x800 ? 1 : 0;
            if((v5 & 0x380) != 0x100) {
                if((v5 & 0x200) != 0 && (v9.changedInstance(v3))) {
                    goto label_127;
                }

                v5 = 0;
            }
            else {
            label_127:
                v5 = 1;
            }

            v2 |= v5;
            Object v5_1 = v9.rememberedValue();
            if(v2 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                v5_2 = new TimePickerKt$$ExternalSyntheticLambda1(v4, v3);
                v9.updateRememberedValue(v5_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            v23 = v9;
            SurfaceKt.Surface-d85dljk(v12, v5_2, v11_2, false, v13_1, v15, 0, 0f, 0f, null, null, ComposableLambdaKt.rememberComposableLambda(0xA7F27559, true, new TimePickerKt$TimeSelector$3(v4, v3, arg28, v6), v9, 54), v23, 0, 0x30, 0x7C8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_169;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v23 = v9;
            v23.skipToGroupEnd();
        }

    label_169:
        ScopeUpdateScope v7_2 = v23.endRestartGroup();
        if(v7_2 != null) {
            v7_2.updateScope(new TimePickerKt$$ExternalSyntheticLambda2(v1, arg28, arg29, arg30, arg31, v8));
        }
    }

    static final Unit TimeSelector_SAnMeKU$lambda$56$lambda$55(String arg1, SemanticsPropertyReceiver arg2) {
        SemanticsPropertiesKt.setRole-kuIjeqM(arg2, Role.Companion.getRadioButton-o7Vup1c());
        SemanticsPropertiesKt.setContentDescription(arg2, arg1);
        return Unit.INSTANCE;
    }

    static final Unit TimeSelector_SAnMeKU$lambda$58$lambda$57(int arg1, TimePickerState arg2) {
        if(!TimePickerSelectionMode.equals-impl0(arg1, arg2.getSelection-yecRtBI())) {
            arg2.setSelection-6_8s6DQ(arg1);
        }

        return Unit.INSTANCE;
    }

    static final Unit TimeSelector_SAnMeKU$lambda$59(Modifier arg7, int arg8, TimePickerState arg9, int arg10, TimePickerColors arg11, int arg12, Composer arg13, int arg14) {
        TimePickerKt.TimeSelector-SAnMeKU(arg7, arg8, arg9, arg10, arg11, arg13, RecomposeScopeImplKt.updateChangedFlags(arg12 | 1));
        return Unit.INSTANCE;
    }

    private static final void ToggleItem(boolean arg20, Shape arg21, Function0 arg22, TimePickerColors arg23, Function3 arg24, Composer arg25, int arg26) {
        Composer v16;
        int v9;
        int v3;
        boolean v1 = arg20;
        TimePickerColors v4 = arg23;
        int v6 = arg26;
        int v0 = 0x5AD3830B;
        Composer v2 = arg25.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(ToggleItem)N(checked,shape,onClick,colors,content)1365@55539L22,1371@55730L125,1363@55431L431:TimePicker.kt#uh7d8r");
        int v5 = 4;
        if((v6 & 6) == 0) {
            v3 = v2.changed(v1) ? v5 : 2;
            v3 |= v6;
        }
        else {
            v3 = v6;
        }

        if((v6 & 0x30) == 0) {
            int v8 = v2.changed(arg21) ? 0x20 : 16;
            v3 |= v8;
        }

        if((v6 & 0x180) == 0) {
            v9 = v2.changedInstance(arg22) ? 0x100 : 0x80;
            v3 |= v9;
        }

        if((v6 & 0xC00) == 0) {
            v9 = v2.changed(v4) ? 0x800 : 0x400;
            v3 |= v9;
        }

        if((v6 & 0x6000) == 0) {
            int v10 = v2.changedInstance(arg24) ? 0x4000 : 0x2000;
            v3 |= v10;
        }

        boolean v10_1 = (v3 & 9363) != 9362 ? true : false;
        if(v2.shouldExecute(v10_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1359)");
            }

            long v10_2 = v4.periodSelectorContentColor-vNxB06k$material3(v1);
            long v8_1 = v4.periodSelectorContainerColor-vNxB06k$material3(v1);
            Companion v0_1 = Modifier.Companion;
            float v15 = v1 ? 0f : 1f;
            Modifier v0_2 = ZIndexModifierKt.zIndex(((Modifier)v0_1), v15);
            Object v15_1 = null;
            v0_2 = SizeKt.fillMaxSize$default(v0_2, 0f, 1, v15_1);
            ComposerKt.sourceInformationMarkerStart(v2, 0xF3FF2221, "CC(remember):TimePicker.kt#9igjgp");
            v5 = (v3 & 14) == v5 ? 1 : 0;
            Object v12 = v2.rememberedValue();
            if(v5 != 0 || v12 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda16 v12_1 = new TimePickerKt$$ExternalSyntheticLambda16(v1);
                v2.updateRememberedValue(v12_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            ButtonKt.TextButton(arg22, SemanticsModifierKt.semantics$default(v0_2, false, ((Function1)v12), 1, v15_1), false, arg21, ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(v8_1, v10_2, 0, 0, v2, 0x6000, 12), null, null, PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)), null, arg24, v2, v3 >> 6 & 14 | 0xC00000 | v3 << 6 & 0x1C00 | v3 << 15 & 0x70000000, 356);
            v16 = v2;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_145;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v16 = v2;
            v16.skipToGroupEnd();
        }

    label_145:
        ScopeUpdateScope v7 = v16.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new TimePickerKt$$ExternalSyntheticLambda17(v1, arg21, arg22, v4, arg24, v6));
        }
    }

    static final Unit ToggleItem$lambda$49$lambda$48(boolean arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setSelected(arg1, arg0);
        return Unit.INSTANCE;
    }

    static final Unit ToggleItem$lambda$50(boolean arg7, Shape arg8, Function0 arg9, TimePickerColors arg10, Function3 arg11, int arg12, Composer arg13, int arg14) {
        TimePickerKt.ToggleItem(arg7, arg8, arg9, arg10, arg11, arg13, RecomposeScopeImplKt.updateChangedFlags(arg12 | 1));
        return Unit.INSTANCE;
    }

    private static final void VerticalClockDisplay(TimePickerState arg23, TimePickerColors arg24, Composer arg25, int arg26) {
        int v5_1;
        TimePickerState v0 = arg23;
        TimePickerColors v1 = arg24;
        int v2 = arg26;
        int v3 = 2054675515;
        Composer v4 = arg25.startRestartGroup(v3);
        ComposerKt.sourceInformation(v4, "C(VerticalClockDisplay)N(state,colors)1154@48651L586:TimePicker.kt#uh7d8r");
        if((v2 & 6) == 0) {
            boolean v5 = (v2 & 8) == 0 ? v4.changed(v0) : v4.changedInstance(v0);
            v5_1 = v5 ? 4 : 2;
            v5_1 |= v2;
        }
        else {
            v5_1 = v2;
        }

        if((v2 & 0x30) == 0) {
            int v6 = v4.changed(v1) ? 0x20 : 16;
            v5_1 |= v6;
        }

        boolean v6_1 = (v5_1 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v6_1, v5_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v5_1, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:1153)");
            }

            HorizontalOrVertical v3_1 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(v4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Companion v6_2 = Modifier.Companion;
            MeasurePolicy v3_2 = RowKt.rowMeasurePolicy(((Horizontal)v3_1), Alignment.Companion.getTop(), v4, 6);
            int v7 = -1323940314;
            String v10 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v4, v7, v10);
            int v11 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
            CompositionLocalMap v12 = v4.getCurrentCompositionLocalMap();
            Modifier v6_3 = ComposedModifierKt.materializeModifier(v4, ((Modifier)v6_2));
            Function0 v13 = ComposeUiNode.Companion.getConstructor();
            int v14 = 0xD6BD0031;
            String v15 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v4, v14, v15);
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

            Composer v9 = Updater.constructor-impl(v4);
            Updater.set-impl(v9, v3_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v9, v12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v9.getInserting()) || !Intrinsics.areEqual(v9.rememberedValue(), Integer.valueOf(v11))) {
                v9.updateRememberedValue(Integer.valueOf(v11));
                v9.apply(Integer.valueOf(v11), v3_3);
            }

            Updater.set-impl(v9, v6_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v4, 0x51506F42, "C1155@48709L34:TimePicker.kt#uh7d8r");
            TimePickerKt.ClockDisplayNumbers(v0, v1, v4, v5_1 & 0x7E);
            if(!v0.is24hour()) {
                v4.startReplaceGroup(0x51515F81);
                ComposerKt.sourceInformation(v4, "1157@48787L434");
                Modifier v3_4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, TimePickerKt.PeriodToggleMargin, 0f, 0f, 0f, 14, null);
                ComposerKt.sourceInformationMarkerStart(v4, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy v6_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v4, v7, v10);
                v7 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
                CompositionLocalMap v8 = v4.getCurrentCompositionLocalMap();
                v3_4 = ComposedModifierKt.materializeModifier(v4, v3_4);
                Function0 v9_1 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4, v14, v15);
                if(!(v4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4.startReusableNode();
                if(v4.getInserting()) {
                    v4.createNode(v9_1);
                }
                else {
                    v4.useNode();
                }

                v9 = Updater.constructor-impl(v4);
                Updater.set-impl(v9, v6_4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v9, v8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v6_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v9.getInserting()) || !Intrinsics.areEqual(v9.rememberedValue(), Integer.valueOf(v7))) {
                    v9.updateRememberedValue(Integer.valueOf(v7));
                    v9.apply(Integer.valueOf(v7), v6_5);
                }

                Updater.set-impl(v9, v3_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
                ComposerKt.sourceInformationMarkerStart(v4, 0x801A93B8, "C1158@48866L341:TimePicker.kt#uh7d8r");
                v5_1 <<= 3;
                TimePickerKt.VerticalPeriodToggle(SizeKt.size-VpY3zN4(Modifier.Companion, TimePickerTokens.INSTANCE.getPeriodSelectorVerticalContainerWidth-D9Ej5fM(), TimePickerTokens.INSTANCE.getPeriodSelectorVerticalContainerHeight-D9Ej5fM()), v0, v1, v4, v5_1 & 0x380 | (v5_1 & 0x70 | 6));
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(0x515816CB);
                v4.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            v4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_209;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v4.skipToGroupEnd();
        }

    label_209:
        ScopeUpdateScope v3_5 = v4.endRestartGroup();
        if(v3_5 != null) {
            v3_5.updateScope(new TimePickerKt$$ExternalSyntheticLambda12(v0, v1, v2));
        }
    }

    static final Unit VerticalClockDisplay$lambda$34(TimePickerState arg0, TimePickerColors arg1, int arg2, Composer arg3, int arg4) {
        TimePickerKt.VerticalClockDisplay(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final void VerticalPeriodToggle(Modifier arg9, TimePickerState arg10, TimePickerColors arg11, Composer arg12, int arg13) {
        TimePickerColors v3;
        TimePickerState v2;
        Modifier v1_2;
        TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 v0_2;
        int v1_1;
        boolean v1;
        int v12;
        int v0 = 0x8ED0CF25;
        Composer v7 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(v7, "C(VerticalPeriodToggle)N(modifier,state,colors)1253@51957L1022,1281@53026L5,1283@53057L208:TimePicker.kt#uh7d8r");
        if((arg13 & 6) == 0) {
            v12 = v7.changed(arg9) ? 4 : 2;
            v12 |= arg13;
        }
        else {
            v12 = arg13;
        }

        if((arg13 & 0x30) == 0) {
            v1 = (arg13 & 0x40) == 0 ? v7.changed(arg10) : v7.changedInstance(arg10);
            v1_1 = v1 ? 0x20 : 16;
            v12 |= v1_1;
        }

        if((arg13 & 0x180) == 0) {
            v1_1 = v7.changed(arg11) ? 0x100 : 0x80;
            v12 |= v1_1;
        }

        v1 = (v12 & 0x93) != 0x92 ? true : false;
        if(v7.shouldExecute(v1, v12 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v12, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1252)");
            }

            ComposerKt.sourceInformationMarkerStart(v7, 500805987, "CC(remember):TimePicker.kt#9igjgp");
            Object v0_1 = v7.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.INSTANCE;
                v7.updateRememberedValue(v0_2);
            }

            Object v4 = v0_2;
            ComposerKt.sourceInformationMarkerEnd(v7);
            Shape v0_3 = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), v7, 6);
            Intrinsics.checkNotNull(v0_3, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            v1_2 = arg9;
            v2 = arg10;
            v3 = arg11;
            TimePickerKt.PeriodToggleImpl(v1_2, v2, v3, ((MeasurePolicy)v4), ShapesKt.top$default(((CornerBasedShape)v0_3), null, 1, null), ShapesKt.bottom$default(((CornerBasedShape)v0_3), null, 1, null), v7, v12 & 14 | 0xC00 | v12 & 0x70 | v12 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_89;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1_2 = arg9;
            v2 = arg10;
            v3 = arg11;
            v7.skipToGroupEnd();
        }

    label_89:
        ScopeUpdateScope v9 = v7.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new TimePickerKt$$ExternalSyntheticLambda27(v1_2, v2, v3, arg13));
        }
    }

    static final Unit VerticalPeriodToggle$lambda$39(Modifier arg0, TimePickerState arg1, TimePickerColors arg2, int arg3, Composer arg4, int arg5) {
        TimePickerKt.VerticalPeriodToggle(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final void VerticalTimePicker(AnalogTimePickerState arg16, Modifier arg17, TimePickerColors arg18, boolean arg19, Composer arg20, int arg21, int arg22) {
        Modifier v2_2;
        TimePickerColors v3_3;
        Modifier v7_2;
        TimePickerColors v2_1;
        Companion v7_3;
        Modifier v3_2;
        int v9;
        boolean v8_1;
        int v8;
        TimePickerColors v7_1;
        Modifier v5;
        int v2;
        AnalogTimePickerState v1 = arg16;
        int v6 = arg21;
        int v0 = 0x4A7B40BF;
        Composer v4 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v4, "C(VerticalTimePicker)N(state,modifier,colors,autoSwitchToMinute)959@41242L27,958@41196L544:TimePicker.kt#uh7d8r");
        if((arg22 & 1) != 0) {
            v2 = v6 | 6;
        }
        else if((v6 & 6) == 0) {
            v2 = v4.changedInstance(v1) ? 4 : 2;
            v2 |= v6;
        }
        else {
            v2 = v6;
        }

        int v3 = arg22 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_35;
        }
        else if((v6 & 0x30) == 0) {
            v5 = arg17;
            int v7 = v4.changed(v5) ? 0x20 : 16;
            v2 |= v7;
        }
        else {
        label_35:
            v5 = arg17;
        }

        if((v6 & 0x180) == 0) {
            if((arg22 & 4) == 0) {
                v7_1 = arg18;
                if(v4.changed(v7_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_46;
                }
            }
            else {
                v7_1 = arg18;
            label_46:
                v8 = 0x80;
            }

            v2 |= v8;
        }
        else {
            v7_1 = arg18;
        }

        if((arg22 & 8) != 0) {
            v2 |= 0xC00;
            goto label_64;
        }
        else if((v6 & 0xC00) == 0) {
            v8_1 = arg19;
            v9 = v4.changed(v8_1) ? 0x800 : 0x400;
            v2 |= v9;
        }
        else {
        label_64:
            v8_1 = arg19;
        }

        boolean v9_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v4.shouldExecute(v9_1, v2 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "955@41145L8");
            int v10 = 6;
            if((v6 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v3_1 = Modifier.Companion;
                }
                else {
                    v3_2 = v5;
                }

                if((arg22 & 4) != 0) {
                    v7_3 = ((Companion)v3_2);
                    v3 = v2 & -897;
                    v2_1 = TimePickerDefaults.INSTANCE.colors(v4, v10);
                    goto label_110;
                }

                Companion v15 = ((Companion)v3_2);
                v3 = v2;
                v2_1 = v7_1;
                v7_3 = v15;
            }
            else {
                v4.skipToGroupEnd();
                if((arg22 & 4) != 0) {
                    v2 &= -897;
                }

                v3 = v2;
                v2_1 = v7_1;
                v7_2 = v5;
            }

        label_110:
            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:957)");
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0x98AE30FA, "CC(remember):TimePicker.kt#9igjgp");
            Object v0_1 = v4.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                TimePickerKt$$ExternalSyntheticLambda13 v0_2 = new TimePickerKt$$ExternalSyntheticLambda13();
                v4.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            Modifier v0_3 = SemanticsModifierKt.semantics$default(v7_2, false, ((Function1)v0_1), 1, null);
            androidx.compose.ui.Alignment$Horizontal v5_1 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(v4, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy v5_2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), v5_1, v4, 0x30);
            ComposerKt.sourceInformationMarkerStart(v4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v9 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
            CompositionLocalMap v11 = v4.getCurrentCompositionLocalMap();
            v0_3 = ComposedModifierKt.materializeModifier(v4, v0_3);
            Function0 v12 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v4, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v4.startReusableNode();
            if(v4.getInserting()) {
                v4.createNode(v12);
            }
            else {
                v4.useNode();
            }

            Composer v12_1 = Updater.constructor-impl(v4);
            Updater.set-impl(v12_1, v5_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v12_1, v11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v12_1.getInserting()) || !Intrinsics.areEqual(v12_1.rememberedValue(), Integer.valueOf(v9))) {
                v12_1.updateRememberedValue(Integer.valueOf(v9));
                v12_1.apply(Integer.valueOf(v9), v5_3);
            }

            Updater.set-impl(v12_1, v0_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v4, 1720573003, "C962@41347L52,963@41408L60,964@41477L191,970@41677L57:TimePicker.kt#uh7d8r");
            TimePickerKt.VerticalClockDisplay(v1, v2_1, v4, v3 & 14 | v3 >> 3 & 0x70);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, TimePickerKt.ClockDisplayBottomMargin), v4, v10);
            TimePickerKt.ClockFace(SizeKt.size-3ABfNKs(Modifier.Companion, TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM()), v1, v2_1, v8_1, v4, v3 << 3 & 0x70 | v10 | v3 & 0x380 | v3 & 0x1C00);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, TimePickerKt.ClockFaceBottomMargin), v4, v10);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            v4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_3 = v2_1;
            v2_2 = v7_2;
        }
        else {
            v4.skipToGroupEnd();
            v2_2 = v5;
            v3_3 = v7_1;
        }

        ScopeUpdateScope v7_4 = v4.endRestartGroup();
        if(v7_4 != null) {
            v7_4.updateScope(new TimePickerKt$$ExternalSyntheticLambda14(arg16, v2_2, v3_3, arg19, v6, arg22));
        }
    }

    static final Unit VerticalTimePicker$lambda$11(AnalogTimePickerState arg7, Modifier arg8, TimePickerColors arg9, boolean arg10, int arg11, int arg12, Composer arg13, int arg14) {
        TimePickerKt.VerticalTimePicker(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    static final Unit VerticalTimePicker$lambda$9$lambda$8(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setTraversalGroup(arg1, true);
        return Unit.INSTANCE;
    }

    public static final void access$CircularLayout(Modifier arg0, float arg1, Function2 arg2, Composer arg3, int arg4, int arg5) {
        TimePickerKt.CircularLayout(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final void access$ClockText(Modifier arg0, AnalogTimePickerState arg1, int arg2, boolean arg3, Composer arg4, int arg5) {
        TimePickerKt.ClockText(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final long access$ClockText$lambda$64(MutableState arg2) {
        return TimePickerKt.ClockText$lambda$64(arg2);
    }

    public static final long access$ClockText$lambda$67(MutableState arg2) {
        return TimePickerKt.ClockText$lambda$67(arg2);
    }

    public static final void access$DisplaySeparator(Modifier arg0, Composer arg1, int arg2) {
        TimePickerKt.DisplaySeparator(arg0, arg1, arg2);
    }

    public static final TextFieldValue access$TimeInputImpl$hourTextValue(TimePickerState arg0) {
        return TimePickerKt.TimeInputImpl$hourTextValue(arg0);
    }

    public static final TextFieldValue access$TimeInputImpl$lambda$18(MutableState arg0) {
        return TimePickerKt.TimeInputImpl$lambda$18(arg0);
    }

    public static final void access$TimeInputImpl$lambda$19(MutableState arg0, TextFieldValue arg1) {
        TimePickerKt.TimeInputImpl$lambda$19(arg0, arg1);
    }

    public static final TextFieldValue access$TimeInputImpl$lambda$22(MutableState arg0) {
        return TimePickerKt.TimeInputImpl$lambda$22(arg0);
    }

    public static final void access$TimeInputImpl$lambda$23(MutableState arg0, TextFieldValue arg1) {
        TimePickerKt.TimeInputImpl$lambda$23(arg0, arg1);
    }

    public static final TextFieldValue access$TimeInputImpl$minuteTextValue(TimePickerState arg0) {
        return TimePickerKt.TimeInputImpl$minuteTextValue(arg0);
    }

    public static final void access$TimePickerTextField-1vLObsk(Modifier arg0, TextFieldValue arg1, Function1 arg2, TimePickerState arg3, int arg4, KeyboardOptions arg5, KeyboardActions arg6, TimePickerColors arg7, Composer arg8, int arg9, int arg10) {
        TimePickerKt.TimePickerTextField-1vLObsk(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static final void access$TimeSelector-SAnMeKU(Modifier arg0, int arg1, TimePickerState arg2, int arg3, TimePickerColors arg4, Composer arg5, int arg6) {
        TimePickerKt.TimeSelector-SAnMeKU(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static final float access$atan(float arg0, float arg1) {
        return TimePickerKt.atan(arg0, arg1);
    }

    public static final float access$getClockDialMidContainerSize$p() {
        return TimePickerKt.ClockDialMidContainerSize;
    }

    public static final float access$getDisplaySeparatorWidth$p() {
        return TimePickerKt.DisplaySeparatorWidth;
    }

    public static final IntList access$getExtraHours$p() {
        return TimePickerKt.ExtraHours;
    }

    public static final IntList access$getHours$p() {
        return TimePickerKt.Hours;
    }

    public static final float access$getInnerCircleToSizeRatio$p() {
        return TimePickerKt.InnerCircleToSizeRatio;
    }

    public static final float access$getMaxDistance$p() {
        return TimePickerKt.MaxDistance;
    }

    public static final IntList access$getMinutes$p() {
        return TimePickerKt.Minutes;
    }

    public static final float access$getOuterCircleToSizeRatio$p() {
        return TimePickerKt.OuterCircleToSizeRatio;
    }

    public static final float access$getTimePickerMaxHeight$p() {
        return TimePickerKt.TimePickerMaxHeight;
    }

    public static final float access$getTimePickerMidHeight$p() {
        return TimePickerKt.TimePickerMidHeight;
    }

    public static final void access$moveSelector-d3b8Pxo(TimePickerState arg0, float arg1, float arg2, float arg3, long arg4) {
        TimePickerKt.moveSelector-d3b8Pxo(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Object access$onTap-uYHVD98(AnalogTimePickerState arg0, float arg1, float arg2, float arg3, boolean arg4, long arg5, AnimationSpec arg7, Continuation arg8) {
        return TimePickerKt.onTap-uYHVD98(arg0, arg1, arg2, arg3, arg4, arg5, arg7, arg8);
    }

    public static final void access$timeInputOnChange-_K77t-0(int arg0, TimePickerState arg1, TextFieldValue arg2, TextFieldValue arg3, int arg4, Ref arg5, Function1 arg6) {
        TimePickerKt.timeInputOnChange-_K77t-0(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private static final float atan(float arg2, float arg3) {
        arg2 = (((float)Math.atan2(((double)arg2), ((double)arg3)))) - 1.570796f;
        if(arg2 < 0f) {
            arg2 += 6.283185f;
        }

        return arg2;
    }

    private static final float dist(float arg2, float arg3, int arg4, int arg5) {
        return ((float)Math.hypot(((double)((((float)arg4)) - arg2)), ((double)((((float)arg5)) - arg3))));
    }

    private static final Modifier drawSelector(Modifier arg1, AnalogTimePickerState arg2, TimePickerColors arg3) {
        return DrawModifierKt.drawWithContent(arg1, new TimePickerKt$$ExternalSyntheticLambda15(arg2, arg3));
    }

    static final Unit drawSelector$lambda$61(AnalogTimePickerState arg29, TimePickerColors arg30, ContentDrawScope arg31) {
        long v12 = Offset.constructor-impl((((long)Float.floatToRawIntBits(arg31.toPx-0680j_4(DpOffset.getY-D9Ej5fM(TimePickerKt.getSelectorPos(arg29)))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg31.toPx-0680j_4(DpOffset.getX-D9Ej5fM(TimePickerKt.getSelectorPos(arg29)))))) << 0x20);
        float v11 = arg31.toPx-0680j_4(TimePickerTokens.INSTANCE.getClockDialSelectorHandleContainerSize-D9Ej5fM()) / 2f * (((float)arg31.roundToPx-0680j_4(arg29.getCurrentDiameter-D9Ej5fM()))) / (((float)arg31.roundToPx-0680j_4(TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM())));
        long v3 = arg30.getSelectorColor-0d7_KjU();
        DrawScope.drawCircle-VaOC9Bg$default(arg31, Color.Companion.getBlack-0d7_KjU(), v11, v12, 0f, null, null, BlendMode.Companion.getClear-0nO6VwU(), 56, null);
        arg31.drawContent();
        DrawScope.drawCircle-VaOC9Bg$default(arg31, v3, v11, v12, 0f, null, null, BlendMode.Companion.getXor-0nO6VwU(), 56, null);
        DrawScope.drawLine-NGM6Ib0$default(arg31, v3, androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk(arg31.getSize-NH-jbRc()), Offset.minus-MK-Hz9U(v12, Offset.constructor-impl((((long)Float.floatToRawIntBits((((float)Math.sin(((double)arg29.getCurrentAngle())))) * v11))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits((((float)Math.cos(((double)arg29.getCurrentAngle())))) * v11))) << 0x20)), arg31.toPx-0680j_4(TimePickerTokens.INSTANCE.getClockDialSelectorTrackContainerWidth-D9Ej5fM()), 0, null, 0f, null, BlendMode.Companion.getSrcOver-0nO6VwU(), 0xF0, null);
        DrawScope.drawCircle-VaOC9Bg$default(arg31, v3, arg31.toPx-0680j_4(TimePickerTokens.INSTANCE.getClockDialSelectorCenterContainerSize-D9Ej5fM()) / 2f, androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk(arg31.getSize-NH-jbRc()), 0f, null, null, 0, 120, null);
        DrawScope.drawCircle-VaOC9Bg$default(arg31, arg30.clockDialContentColor-vNxB06k$material3(true), v11, v12, 0f, null, null, BlendMode.Companion.getDstOver-0nO6VwU(), 56, null);
        return Unit.INSTANCE;
    }

    public static final float getClockDialMinContainerSize() {
        return TimePickerKt.ClockDialMinContainerSize;
    }

    public static final int getDefaultTimePickerLayoutType(Composer arg3, int arg4) {
        int v1 = 0x19F80E5C;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(<get-defaultTimePickerLayoutType>)2051@79436L29:TimePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.<get-defaultTimePickerLayoutType> (TimePicker.kt:2051)");
        }

        arg4 = TimePicker_androidKt.defaultTimePickerLayoutType(arg3, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return arg4;
    }

    public static void getDefaultTimePickerLayoutType$annotations() {
    }

    public static final int getHourForDisplay(TimePickerState arg2) {
        if(arg2.is24hour()) {
            return arg2.getHour() % 24;
        }

        int v1 = 12;
        if(arg2.getHour() % v1 == 0) {
            return v1;
        }

        if(TimePickerKt.isPm(arg2)) {
            return arg2.getHour() - v1;
        }

        return arg2.getHour();
    }

    public static final long getSelectorPos(AnalogTimePickerState arg6) {
        float v2 = 2f;
        float v0 = Dp.constructor-impl(Dp.constructor-impl(TimePickerTokens.INSTANCE.getClockDialSelectorHandleContainerSize-D9Ej5fM() / v2) * (arg6.getCurrentDiameter-D9Ej5fM() / TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM()));
        float v1 = !arg6.is24hour() || !TimePickerKt.isPm(arg6) || !TimePickerSelectionMode.equals-impl0(arg6.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI()) ? Dp.constructor-impl(arg6.getCurrentDiameter-D9Ej5fM() * TimePickerKt.OuterCircleToSizeRatio) : Dp.constructor-impl(arg6.getCurrentDiameter-D9Ej5fM() * TimePickerKt.InnerCircleToSizeRatio);
        v0 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.box-impl(Dp.constructor-impl(v1 - v0)), Dp.box-impl(Dp.constructor-impl(0f))).unbox-impl() + v0);
        return DpOffset.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(Dp.constructor-impl((((float)Math.cos(((double)arg6.getCurrentAngle())))) * v0) + Dp.constructor-impl(arg6.getCurrentDiameter-D9Ej5fM() / v2))))) << 0x20 | (((long)Float.floatToRawIntBits(Dp.constructor-impl(Dp.constructor-impl(v0 * (((float)Math.sin(((double)arg6.getCurrentAngle()))))) + Dp.constructor-impl(arg6.getCurrentDiameter-D9Ej5fM() / v2))))) & 0xFFFFFFFFL);
    }

    public static final boolean isPm(TimePickerState arg1) {
        if(arg1.getHour() >= 12) {
            return 1;
        }

        return 0;
    }

    private static final void moveSelector-d3b8Pxo(TimePickerState arg2, float arg3, float arg4, float arg5, long arg6) {
        int v4;
        if((TimePickerSelectionMode.equals-impl0(arg2.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI())) && (arg2.is24hour())) {
            arg3 = TimePickerKt.dist(arg3, arg4, IntOffset.getX-impl(arg6), IntOffset.getY-impl(arg6));
            int v6 = 12;
            if(TimePickerKt.isPm(arg2)) {
                v4 = arg2.getHour();
                if(arg3 >= arg5) {
                }
                else {
                    v6 = 0;
                }

                arg2.setHour(v4 - v6);
                return;
            }
            else {
                v4 = arg2.getHour();
                if(arg3 < arg5) {
                }
                else {
                    v6 = 0;
                }

                arg2.setHour(v4 + v6);
            }
        }
    }

    public static final String numberContentDescription-dSwYdS4(int arg3, boolean arg4, int arg5, Composer arg6, int arg7) {
        int v1 = 0xB93D3B4;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(numberContentDescription)N(selection:c#material3.TimePickerSelectionMode,is24Hour,number)2029@78784L21:TimePicker.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:2019)");
        }

        if(TimePickerSelectionMode.equals-impl0(arg3, TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
            arg3 = Strings.constructor-impl(string.m3c_time_picker_minute_suffix);
        }
        else if(arg4) {
            arg3 = Strings.constructor-impl(string.m3c_time_picker_hour_24h_suffix);
        }
        else {
            arg3 = Strings.constructor-impl(string.m3c_time_picker_hour_suffix);
        }

        String v3 = Strings_androidKt.getString-qBjtwXw(arg3, new Object[]{Integer.valueOf(arg5)}, arg6, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return v3;
    }

    private static final Object onTap-uYHVD98(AnalogTimePickerState arg13, float arg14, float arg15, float arg16, boolean arg17, long arg18, AnimationSpec arg20, Continuation arg21) {
        Object v14;
        boolean v13;
        Object v13_1;
        boolean v14_1;
        Object v12;
        float v3_1;
        TimePickerKt$onTap$1 v1_1;
        int v3;
        Continuation v0 = arg21;
        if((v0 instanceof TimePickerKt$onTap$1)) {
            Continuation v1 = v0;
            v3 = 0x80000000;
            if((((TimePickerKt$onTap$1)v1).label & v3) != 0) {
                ((TimePickerKt$onTap$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_1 = new TimePickerKt$onTap$1(v0);
        }

        Object v0_1 = v1_1.result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = v1_1.label;
        int v4 = 2;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            float v0_2 = TimePickerKt.atan(arg15 - (((float)IntOffset.getY-impl(arg18))), arg14 - (((float)IntOffset.getX-impl(arg18))));
            if(TimePickerSelectionMode.equals-impl0(arg13.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
                v3_1 = 0.10472f;
                v0_2 = (((float)Math.rint(((double)(v0_2 / v3_1 / 5f))))) * 5f;
            }
            else {
                v3_1 = 0.523599f;
                v0_2 = ((float)Math.rint(((double)(v0_2 / v3_1))));
            }

            TimePickerKt.moveSelector-d3b8Pxo(arg13, arg14, arg15, arg16, arg18);
            v1_1.L$0 = arg13;
            v14_1 = arg17;
            v1_1.Z$0 = v14_1;
            v1_1.label = 1;
            if(arg13.rotateTo(v0_2 * v3_1, arg20, true, ((Continuation)v1_1)) == v2) {
                return v2;
            }

        label_79:
            if(!TimePickerSelectionMode.equals-impl0(((AnalogTimePickerState)v13_1).getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
                goto label_98;
            }

            if(!v14_1) {
                goto label_98;
            }

            v1_1.L$0 = v13_1;
            v1_1.Z$0 = v14_1;
            v1_1.label = v4;
            if(DelayKt.delay(100, ((Continuation)v1_1)) == v2) {
                return v2;
            }

            boolean v12_1 = v14_1;
            AnalogTimePickerState v14_2 = ((AnalogTimePickerState)v13_1);
            v13 = v12_1;
        label_95:
            v12 = v14;
            v14_1 = v13;
            v13_1 = v12;
        }
        else if(v3 == 1) {
            v13 = v1_1.Z$0;
            v14 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            v12 = v14;
            v14_1 = v13;
            v13_1 = v12;
            goto label_79;
        }
        else if(v3 == v4) {
            v13 = v1_1.Z$0;
            v14 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            goto label_95;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_98:
        if(v14_1) {
            ((AnalogTimePickerState)v13_1).setSelection-6_8s6DQ(TimePickerSelectionMode.Companion.getMinute-yecRtBI());
        }

        return Unit.INSTANCE;
    }

    public static final TimePickerState rememberTimePickerState(int arg6, int arg7, boolean arg8, Composer arg9, int arg10, int arg11) {
        TimePickerKt$$ExternalSyntheticLambda25 v0_2;
        int v1 = 0x49C6094D;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberTimePickerState)N(initialHour,initialMinute,is24Hour)586@29390L14,589@29526L185,589@29472L239:TimePicker.kt#uh7d8r");
        int v0 = 4;
        if((arg11 & v0) != 0) {
            arg8 = TimeFormat_androidKt.is24HourFormat(arg9, 0);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:587)");
        }

        Object[] v11 = new Object[0];
        Saver v1_1 = TimePickerStateImpl.Companion.Saver();
        ComposerKt.sourceInformationMarkerStart(arg9, 0xF0690DE6, "CC(remember):TimePicker.kt#9igjgp");
        int v4 = 1;
        v0 = (arg10 & 14 ^ 6) > v0 && (arg9.changed(0)) || (arg10 & 6) == v0 ? 1 : 0;
        int v5 = 0x20;
        int v3 = (arg10 & 0x70 ^ 0x30) > v5 && (arg9.changed(0)) || (arg10 & 0x30) == v5 ? 1 : 0;
        v0 |= v3;
        v5 = 0x100;
        if((arg10 & 0x380 ^ 0x180) <= v5 || !arg9.changed(arg8)) {
            if((arg10 & 0x180) == v5) {
            }
            else {
                v4 = 0;
            }
        }

        arg10 = v0 | v4;
        Object v0_1 = arg9.rememberedValue();
        if(arg10 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new TimePickerKt$$ExternalSyntheticLambda25(0, 0, arg8);
            arg9.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v6 = RememberSaveableKt.rememberSaveable(v11, v1_1, ((Function0)v0_2), arg9, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((TimePickerState)v6);
    }

    static final TimePickerStateImpl rememberTimePickerState$lambda$7$lambda$6(int arg1, int arg2, boolean arg3) {
        return new TimePickerStateImpl(arg1, arg2, arg3);
    }

    private static final void timeInputOnChange-_K77t-0(int arg8, TimePickerState arg9, TextFieldValue arg10, TextFieldValue arg11, int arg12, Ref arg13, Function1 arg14) {
        int v10;
        int v0 = 0;
        arg13.setValue(Boolean.valueOf(false));
        if(Intrinsics.areEqual(arg10.getText(), arg11.getText())) {
            arg14.invoke(arg10);
            return;
        }

        int v13 = 12;
        if(arg10.getText().length() == 0) {
            if(TimePickerSelectionMode.equals-impl0(arg8, TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
                if((TimePickerKt.isPm(arg9)) && !arg9.is24hour()) {
                    v0 = v13;
                }

                arg9.setHour(v0);
            }
            else {
                arg9.setMinute(0);
            }

            arg14.invoke(TextFieldValue.copy-3r_uNRQ$default(arg10, "", 0, null, 6, null));
            return;
        }

        TextFieldValue v1 = arg10;
        try {
            if(v1.getText().length() == 3 && TextRange.getStart-impl(v1.getSelection-d9O1mEE()) == 1) {
                v10 = CharsKt.digitToInt(v1.getText().charAt(0));
            label_49:
                if(v10 > arg12) {
                    return;
                }
            }
            else {
                v10 = Integer.parseInt(v1.getText());
                goto label_49;
            }

            if(TimePickerSelectionMode.equals-impl0(arg8, TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
                if(v10 != v13 || !TimePickerKt.isPm(arg9)) {
                    if(v10 == v13 && !TimePickerKt.isPm(arg9) && !arg9.is24hour()) {
                        v13 = 0;
                        goto label_72;
                    }

                    if(!TimePickerKt.isPm(arg9) || (arg9.is24hour())) {
                        v13 = 0;
                    }
                    else {
                    }

                    v13 += v10;
                }
                else {
                }

            label_72:
                arg9.setHour(v13);
                if(v10 <= 1) {
                    goto label_81;
                }

                if(arg9.is24hour()) {
                    goto label_81;
                }

                arg9.setSelection-6_8s6DQ(TimePickerSelectionMode.Companion.getMinute-yecRtBI());
            }
            else {
                arg9.setMinute(v10);
            }

        label_81:
            if(v1.getText().length() <= 2) {
                arg10 = v1;
            }
            else {
                goto label_87;
            }

        label_97:
            arg14.invoke(arg10);
            return;
        label_87:
            arg10 = TextFieldValue.copy-3r_uNRQ$default(v1, String.valueOf(v1.getText().charAt(0)), 0, null, 6, null);
            goto label_97;
        }
        catch(IllegalArgumentException ) {
            return;
        }
    }

    private static final Modifier visible(Modifier arg2, boolean arg3) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            TimePickerKt$visible$$inlined$debugInspectorInfo$1 v1 = new TimePickerKt$visible$$inlined$debugInspectorInfo$1(arg3);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg2.then(new VisibleModifier(arg3, v1_1));
    }
}

