package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000\u008C\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0001\u0018\u0000 ¦\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\b¥\u0003¦\u0003§\u0003¨\u0003B\u001B\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010C\u001A\u00020DH\u0002J\b\u0010K\u001A\u00020DH\u0002J\r\u0010O\u001A\u00020DH\u0000¢\u0006\u0002\bPJ\u001D\u0010Q\u001A\u00020D2\u0012\u0010R\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020D0SH\u0086\bJ#\u0010T\u001A\u00020D2\u0018\u0010R\u001A\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020D0UH\u0086\bJ\u0015\u0010h\u001A\n\u0018\u00010ij\u0004\u0018\u0001`jH\u0017¢\u0006\u0002\u0010kJ\u001E\u0010}\u001A\u00020D2\u0006\u0010~\u001A\u00020\f2\u0006\u0010\u007F\u001A\u00020\u0000H\u0000¢\u0006\u0003\b\u0080\u0001J\u0012\u0010\u0081\u0001\u001A\u00030\u0082\u00012\u0006\u0010\u007F\u001A\u00020\u0000H\u0002J\u000F\u0010\u0083\u0001\u001A\u00020DH\u0000¢\u0006\u0003\b\u0084\u0001J \u0010\u0085\u0001\u001A\u00020D2\u0006\u0010~\u001A\u00020\f2\u0007\u0010\u0086\u0001\u001A\u00020\fH\u0000¢\u0006\u0003\b\u0087\u0001J\u000F\u0010\u0088\u0001\u001A\u00020DH\u0000¢\u0006\u0003\b\u0089\u0001J\u0012\u0010\u008A\u0001\u001A\u00020D2\u0007\u0010\u008B\u0001\u001A\u00020\u0000H\u0002J*\u0010\u008C\u0001\u001A\u00020D2\u0007\u0010\u008D\u0001\u001A\u00020\f2\u0007\u0010\u008E\u0001\u001A\u00020\f2\u0007\u0010\u0086\u0001\u001A\u00020\fH\u0000¢\u0006\u0003\b\u008F\u0001J\t\u0010\u0090\u0001\u001A\u00020\nH\u0016J\u000F\u0010\u0094\u0001\u001A\u00020DH\u0000¢\u0006\u0003\b\u0095\u0001J\u000F\u0010\u0096\u0001\u001A\u00020DH\u0000¢\u0006\u0003\b\u0097\u0001J\n\u0010\u009E\u0001\u001A\u00030\u0099\u0001H\u0002J\u0017\u0010\u009F\u0001\u001A\u00020D2\u0006\u0010]\u001A\u00020\\H\u0000¢\u0006\u0003\b \u0001J\u000F\u0010¡\u0001\u001A\u00020DH\u0000¢\u0006\u0003\b¢\u0001J\n\u0010ª\u0001\u001A\u00030\u0082\u0001H\u0016J\u0014\u0010­\u0001\u001A\u00030\u0082\u00012\b\b\u0002\u0010m\u001A\u00020\fH\u0002J\n\u0010¶\u0001\u001A\u00030µ\u0001H\u0002J\u0010\u0010·\u0001\u001A\u00020\f2\u0007\u0010¸\u0001\u001A\u00020\fJ\u0010\u0010¹\u0001\u001A\u00020\f2\u0007\u0010º\u0001\u001A\u00020\fJ\u0010\u0010»\u0001\u001A\u00020\f2\u0007\u0010¸\u0001\u001A\u00020\fJ\u0010\u0010¼\u0001\u001A\u00020\f2\u0007\u0010º\u0001\u001A\u00020\fJ\u0010\u0010½\u0001\u001A\u00020\f2\u0007\u0010¸\u0001\u001A\u00020\fJ\u0010\u0010¾\u0001\u001A\u00020\f2\u0007\u0010º\u0001\u001A\u00020\fJ\u0010\u0010¿\u0001\u001A\u00020\f2\u0007\u0010¸\u0001\u001A\u00020\fJ\u0010\u0010À\u0001\u001A\u00020\f2\u0007\u0010º\u0001\u001A\u00020\fJ\u0012\u0010Ý\u0001\u001A\u00030Þ\u00012\b\u0010ß\u0001\u001A\u00030à\u0001J\t\u0010á\u0001\u001A\u00020DH\u0002J\u000F\u0010\u009B\u0002\u001A\u00020DH\u0000¢\u0006\u0003\b\u009C\u0002J\u0013\u0010§\u0002\u001A\u00020D2\b\u0010¢\u0002\u001A\u00030\u009E\u0002H\u0002J\t\u0010¨\u0002\u001A\u00020DH\u0002J\u000F\u0010©\u0002\u001A\u00020DH\u0000¢\u0006\u0003\bª\u0002J!\u0010½\u0002\u001A\u00020D2\u0007\u0010¾\u0002\u001A\u00020\f2\u0007\u0010¿\u0002\u001A\u00020\fH\u0000¢\u0006\u0003\bÀ\u0002J\u000F\u0010Á\u0002\u001A\u00020DH\u0000¢\u0006\u0003\bÂ\u0002J\u000F\u0010Ã\u0002\u001A\u00020DH\u0000¢\u0006\u0003\bÄ\u0002J%\u0010Å\u0002\u001A\u00020D2\b\u0010Æ\u0002\u001A\u00030Ç\u00022\n\u0010È\u0002\u001A\u0005\u0018\u00010É\u0002H\u0000¢\u0006\u0003\bÊ\u0002J=\u0010Ë\u0002\u001A\u00020D2\b\u0010Ì\u0002\u001A\u00030Í\u00022\b\u0010Î\u0002\u001A\u00030Ï\u00022\n\b\u0002\u0010Ð\u0002\u001A\u00030Ñ\u00022\t\b\u0002\u0010Ò\u0002\u001A\u00020\nH\u0000¢\u0006\u0006\bÓ\u0002\u0010Ô\u0002J=\u0010Õ\u0002\u001A\u00020D2\b\u0010Ì\u0002\u001A\u00030Í\u00022\b\u0010Ö\u0002\u001A\u00030Ï\u00022\n\b\u0002\u0010Ð\u0002\u001A\u00030Ñ\u00022\t\b\u0002\u0010Ò\u0002\u001A\u00020\nH\u0000¢\u0006\u0006\b×\u0002\u0010Ô\u0002J\u0018\u0010Ø\u0002\u001A\u00020D2\u0007\u0010Ù\u0002\u001A\u00020\u0000H\u0000¢\u0006\u0003\bÚ\u0002J0\u0010Û\u0002\u001A\u00020D2\t\b\u0002\u0010Ü\u0002\u001A\u00020\n2\t\b\u0002\u0010Ý\u0002\u001A\u00020\n2\t\b\u0002\u0010Þ\u0002\u001A\u00020\nH\u0000¢\u0006\u0003\bß\u0002J0\u0010à\u0002\u001A\u00020D2\t\b\u0002\u0010Ü\u0002\u001A\u00020\n2\t\b\u0002\u0010Ý\u0002\u001A\u00020\n2\t\b\u0002\u0010Þ\u0002\u001A\u00020\nH\u0000¢\u0006\u0003\bá\u0002J\u000F\u0010â\u0002\u001A\u00020DH\u0000¢\u0006\u0003\bã\u0002J\u000F\u0010ä\u0002\u001A\u00020DH\u0000¢\u0006\u0003\bå\u0002J\u000F\u0010æ\u0002\u001A\u00020DH\u0000¢\u0006\u0003\bç\u0002J*\u0010|\u001A\u0003Hè\u0002\"\u0005\b\u0000\u0010è\u00022\u000E\u0010R\u001A\n\u0012\u0005\u0012\u0003Hè\u00020é\u0002H\u0080\b¢\u0006\u0006\bê\u0002\u0010ë\u0002J\u001A\u0010ì\u0002\u001A\u00020D2\t\b\u0002\u0010Ü\u0002\u001A\u00020\nH\u0000¢\u0006\u0003\bí\u0002J\u001A\u0010î\u0002\u001A\u00020D2\t\b\u0002\u0010Ü\u0002\u001A\u00020\nH\u0000¢\u0006\u0003\bï\u0002J\u000F\u0010ð\u0002\u001A\u00020DH\u0000¢\u0006\u0003\bñ\u0002J\u0010\u0010ò\u0002\u001A\t\u0012\u0005\u0012\u00030ó\u00020>H\u0016J\u000F\u0010ô\u0002\u001A\u00020DH\u0000¢\u0006\u0003\bõ\u0002J\u001D\u0010ö\u0002\u001A\u00020\n2\f\b\u0002\u0010÷\u0002\u001A\u0005\u0018\u00010ø\u0002H\u0000¢\u0006\u0003\bù\u0002J\u001D\u0010ú\u0002\u001A\u00020\n2\f\b\u0002\u0010÷\u0002\u001A\u0005\u0018\u00010ø\u0002H\u0000¢\u0006\u0003\bû\u0002J\u000F\u0010\u0084\u0003\u001A\u00020DH\u0000¢\u0006\u0003\b\u0085\u0003J\u000F\u0010\u0086\u0003\u001A\u00020DH\u0000¢\u0006\u0003\b\u0087\u0003J\u000F\u0010\u0088\u0003\u001A\u00020DH\u0000¢\u0006\u0003\b\u0089\u0003J\u0012\u0010\u008A\u0003\u001A\u00020D2\t\b\u0002\u0010\u008B\u0003\u001A\u00020\nJ\u0007\u0010\u008C\u0003\u001A\u00020DJ\u0012\u0010\u008D\u0003\u001A\u00020D2\t\b\u0002\u0010\u008B\u0003\u001A\u00020\nJ\u000F\u0010\u008E\u0003\u001A\u00020DH\u0000¢\u0006\u0003\b\u008F\u0003J\t\u0010\u0090\u0003\u001A\u00020DH\u0016J\t\u0010\u0091\u0003\u001A\u00020DH\u0016J%\u0010\u0092\u0003\u001A\u00020D2\u0013\u0010R\u001A\u000F\u0012\u0005\u0012\u00030\u0093\u0003\u0012\u0004\u0012\u00020D0SH\u0080\b¢\u0006\u0003\b\u0094\u0003J%\u0010\u0095\u0003\u001A\u00020D2\u0013\u0010R\u001A\u000F\u0012\u0005\u0012\u00030\u0082\u0002\u0012\u0004\u0012\u00020D0SH\u0080\b¢\u0006\u0003\b\u0096\u0003J\u000F\u0010\u0097\u0003\u001A\u00020DH\u0000¢\u0006\u0003\b\u0098\u0003J\t\u0010\u0099\u0003\u001A\u00020DH\u0002J\u000F\u0010\u009A\u0003\u001A\u00020DH\u0000¢\u0006\u0003\b\u009B\u0003J\t\u0010¢\u0003\u001A\u00020DH\u0016J\t\u0010£\u0003\u001A\u00020DH\u0016J\t\u0010¤\u0003\u001A\u00020DH\u0016R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u00020\fX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001C\u0010\u0018\u001A\u00020\u0019X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u001E\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001C\u0010\u001F\u001A\u00020 X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u001E\u001A\u0004\b!\u0010\u001B\"\u0004\b\"\u0010\u001DR\u001C\u0010#\u001A\u00020\u0019X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u001E\u001A\u0004\b$\u0010\u001B\"\u0004\b%\u0010\u001DR\u001A\u0010&\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001A\u0010)\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001A\u0010,\u001A\u00020\fX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0012R\u001A\u0010/\u001A\u00020\nX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R(\u00103\u001A\u0004\u0018\u00010\u00002\b\u00102\u001A\u0004\u0018\u00010\u0000@BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b4\u00105\"\u0004\b6\u00107R\u0013\u00108\u001A\u0004\u0018\u00010\n8F¢\u0006\u0006\u001A\u0004\b8\u00109R\u000E\u0010:\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010;\u001A\b\u0012\u0004\u0012\u00020\u00000<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010=\u001A\b\u0012\u0004\u0012\u00020\u00000>8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b?\u0010@R\u0016\u0010A\u001A\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010E\u001A\b\u0012\u0004\u0012\u00020F0>8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bG\u0010@R\u001A\u0010H\u001A\b\u0012\u0004\u0012\u00020F0>8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bI\u0010@R\u000E\u0010J\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010L\u001A\b\u0012\u0004\u0012\u00020\u00000B8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bM\u0010NR\u001A\u0010V\u001A\b\u0012\u0004\u0012\u00020\u00000>8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bW\u0010@R\u0010\u0010X\u001A\u0004\u0018\u00010\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010Y\u001A\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bZ\u00105R\"\u0010]\u001A\u0004\u0018\u00010\\2\b\u0010[\u001A\u0004\u0018\u00010\\@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b^\u0010_R$\u0010`\u001A\n\u0018\u00010aj\u0004\u0018\u0001`bX\u0080\u000E¢\u0006\u0010\n\u0002\u0010g\u001A\u0004\bc\u0010d\"\u0004\be\u0010fR\u0014\u0010l\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bl\u0010\u0015R\u001A\u0010m\u001A\u00020\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bn\u0010\u0010\"\u0004\bo\u0010\u0012R\u0014\u0010p\u001A\u00020q8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\br\u0010sR\u0016\u0010t\u001A\u0004\u0018\u00010u8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bv\u0010wR\u0014\u0010x\u001A\u00020y8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bz\u0010{R\u000E\u0010|\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u001D\u0010\u0091\u0001\u001A\u00020\nX\u0080\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b\u0092\u0001\u0010\u0015\"\u0005\b\u0093\u0001\u0010\u0017R\u0012\u0010\u0098\u0001\u001A\u0005\u0018\u00010\u0099\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u009A\u0001\u001A\u0005\u0018\u00010\u0099\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u009B\u0001\u0010\u009C\u0001R\u000F\u0010\u009D\u0001\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0015\u0010£\u0001\u001A\b\u0012\u0004\u0012\u00020\u00000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000F\u0010¤\u0001\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010¥\u0001\u001A\b\u0012\u0004\u0012\u00020\u00000B8@X\u0081\u0004¢\u0006\u000F\u0012\u0006\b¦\u0001\u0010§\u0001\u001A\u0005\b¨\u0001\u0010NR\u0016\u0010©\u0001\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b©\u0001\u0010\u0015R\u0016\u0010«\u0001\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\b¬\u0001\u0010\u0015R+\u0010¯\u0001\u001A\u00030®\u00012\u0007\u0010[\u001A\u00030®\u0001@VX\u0096\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R\u0012\u0010´\u0001\u001A\u0005\u0018\u00010µ\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010Â\u0001\u001A\u00030Á\u00012\u0007\u0010[\u001A\u00030Á\u0001@VX\u0096\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R+\u0010È\u0001\u001A\u00030Ç\u00012\u0007\u0010[\u001A\u00030Ç\u0001@VX\u0096\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R+\u0010Î\u0001\u001A\u00030Í\u00012\u0007\u0010[\u001A\u00030Í\u0001@VX\u0096\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R+\u0010Ô\u0001\u001A\u00030Ó\u00012\u0007\u0010[\u001A\u00030Ó\u0001@VX\u0096\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R\u001A\u0010Ù\u0001\u001A\u0005\u0018\u00010Ú\u00018BX\u0082\u0004¢\u0006\b\u001A\u0006\bÛ\u0001\u0010Ü\u0001R\u0016\u0010º\u0001\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\bâ\u0001\u0010\u0010R\u0016\u0010¸\u0001\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\bã\u0001\u0010\u0010R\u0016\u0010ä\u0001\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\bå\u0001\u0010\u0015R\u0018\u0010æ\u0001\u001A\u00030ç\u00018@X\u0080\u0004¢\u0006\b\u001A\u0006\bè\u0001\u0010é\u0001R\u0016\u0010ê\u0001\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\bê\u0001\u0010\u0015R\u0013\u0010ë\u0001\u001A\u00020\n8F¢\u0006\u0007\u001A\u0005\bë\u0001\u0010\u0015R\u0016\u0010ì\u0001\u001A\u00020\f8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\bí\u0001\u0010\u0010R\u0018\u0010î\u0001\u001A\u00030ï\u00018@X\u0080\u0004¢\u0006\b\u001A\u0006\bð\u0001\u0010ñ\u0001R\u0018\u0010ò\u0001\u001A\u00030ï\u00018@X\u0080\u0004¢\u0006\b\u001A\u0006\bó\u0001\u0010ñ\u0001R \u0010ô\u0001\u001A\u00030ï\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bõ\u0001\u0010ñ\u0001\"\u0006\bö\u0001\u0010÷\u0001R\u0010\u0010ø\u0001\u001A\u00030ï\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R)\u0010ù\u0001\u001A\u00020\n8\u0000@\u0000X\u0081\u000E¢\u0006\u0018\n\u0000\u0012\u0006\bú\u0001\u0010§\u0001\u001A\u0005\bû\u0001\u0010\u0015\"\u0005\bü\u0001\u0010\u0017R\u0018\u0010ý\u0001\u001A\u00030þ\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\bÿ\u0001\u0010\u0080\u0002R\u0018\u0010\u0081\u0002\u001A\u00030\u0082\u00028@X\u0080\u0004¢\u0006\b\u001A\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0018\u0010\u0085\u0002\u001A\u00030\u0086\u0002X\u0080\u0004¢\u0006\n\n\u0000\u001A\u0006\b\u0087\u0002\u0010\u0088\u0002R\u0018\u0010\u0089\u0002\u001A\u00030\u0082\u00028@X\u0080\u0004¢\u0006\b\u001A\u0006\b\u008A\u0002\u0010\u0084\u0002R\u0018\u0010\u008B\u0002\u001A\u00030\u008C\u00028BX\u0082\u0004¢\u0006\b\u001A\u0006\b\u008D\u0002\u0010\u008E\u0002R\"\u0010\u008F\u0002\u001A\u0005\u0018\u00010\u0090\u0002X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u0091\u0002\u0010\u0092\u0002\"\u0006\b\u0093\u0002\u0010\u0094\u0002R\u0012\u0010\u0095\u0002\u001A\u0005\u0018\u00010\u0082\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u001D\u0010\u0096\u0002\u001A\u00020\nX\u0080\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b\u0097\u0002\u0010\u0015\"\u0005\b\u0098\u0002\u0010\u0017R\u001A\u0010\u0099\u0002\u001A\u0005\u0018\u00010\u0082\u00028@X\u0080\u0004¢\u0006\b\u001A\u0006\b\u009A\u0002\u0010\u0084\u0002R\u0010\u0010\u009D\u0002\u001A\u00030\u009E\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u009F\u0002\u001A\u0005\u0018\u00010\u009E\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010 \u0002\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\b¡\u0002\u0010\u0015R+\u0010¢\u0002\u001A\u00030\u009E\u00022\u0007\u0010[\u001A\u00030\u009E\u00028V@VX\u0096\u000E¢\u0006\u0010\u001A\u0006\b£\u0002\u0010¤\u0002\"\u0006\b¥\u0002\u0010¦\u0002R\u0018\u0010«\u0002\u001A\u00030¬\u00028VX\u0096\u0004¢\u0006\b\u001A\u0006\b­\u0002\u0010®\u0002R-\u0010¯\u0002\u001A\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020D\u0018\u00010SX\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b°\u0002\u0010±\u0002\"\u0006\b²\u0002\u0010³\u0002R-\u0010´\u0002\u001A\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020D\u0018\u00010SX\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\bµ\u0002\u0010±\u0002\"\u0006\b¶\u0002\u0010³\u0002R\u001D\u0010·\u0002\u001A\u00020\nX\u0080\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b¸\u0002\u0010\u0015\"\u0005\b¹\u0002\u0010\u0017R\'\u0010º\u0002\u001A\u00020\f2\u0006\u0010[\u001A\u00020\f@FX\u0086\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b»\u0002\u0010\u0010\"\u0005\b¼\u0002\u0010\u0012R\u0016\u0010ü\u0002\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\bý\u0002\u0010\u0015R\u0016\u0010þ\u0002\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\bÿ\u0002\u0010\u0015R\u0016\u0010\u0080\u0003\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\b\u0081\u0003\u0010\u0015R\u0016\u0010\u0082\u0003\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001A\u0005\b\u0083\u0003\u0010\u0015R\u0019\u0010\u009C\u0003\u001A\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u009D\u0003\u0010\u009E\u0003R\u001C\u0010\u009F\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050>8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b \u0003\u0010@R \u0010¡\u0003\u001A\u00020\n2\u0006\u0010[\u001A\u00020\n@RX\u0096\u000E¢\u0006\t\n\u0000\u001A\u0005\b¡\u0003\u0010\u0015¨\u0006©\u0003"}, d2={"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/semantics/SemanticsInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "<init>", "(ZI)V", "getSemanticsId", "()I", "setSemanticsId", "(I)V", "hasPositionalLayerTransformationsInOffsetFromRoot", "getHasPositionalLayerTransformationsInOffsetFromRoot$ui", "()Z", "setHasPositionalLayerTransformationsInOffsetFromRoot$ui", "(Z)V", "lastOffsetFromParent", "Landroidx/compose/ui/unit/IntOffset;", "getLastOffsetFromParent-nOcc-ac$ui", "()J", "setLastOffsetFromParent--gyyYBs$ui", "(J)V", "J", "lastSize", "Landroidx/compose/ui/unit/IntSize;", "getLastSize-YbymL2g$ui", "setLastSize-ozmzZPI$ui", "outerToInnerOffset", "getOuterToInnerOffset-nOcc-ac$ui", "setOuterToInnerOffset--gyyYBs$ui", "outerToInnerOffsetDirty", "getOuterToInnerOffsetDirty$ui", "setOuterToInnerOffsetDirty$ui", "addedToRectList", "getAddedToRectList$ui", "setAddedToRectList$ui", "compositeKeyHash", "getCompositeKeyHash", "setCompositeKeyHash", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui", "setVirtualLookaheadRoot$ui", "newRoot", "lookaheadRoot", "getLookaheadRoot$ui", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "virtualChildrenCount", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "foldedChildren", "", "getFoldedChildren$ui", "()Ljava/util/List;", "_unfoldedChildren", "Landroidx/compose/runtime/collection/MutableVector;", "recreateUnfoldedChildrenIfDirty", "", "childMeasurables", "Landroidx/compose/ui/layout/Measurable;", "getChildMeasurables$ui", "childLookaheadMeasurables", "getChildLookaheadMeasurables$ui", "unfoldedVirtualChildrenListDirty", "invalidateUnfoldedVirtualChildren", "_children", "get_children$ui", "()Landroidx/compose/runtime/collection/MutableVector;", "updateChildrenIfDirty", "updateChildrenIfDirty$ui", "forEachChild", "block", "Lkotlin/Function1;", "forEachChildIndexed", "Lkotlin/Function2;", "children", "getChildren$ui", "_foldedParent", "parent", "getParent$ui", "value", "Landroidx/compose/ui/node/Owner;", "owner", "getOwner$ui", "()Landroidx/compose/ui/node/Owner;", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "()Landroid/view/View;", "isAttached", "depth", "getDepth$ui", "setDepth$ui", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LookaheadPassDelegate;", "getLookaheadPassDelegate$ui", "()Landroidx/compose/ui/node/LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/MeasurePassDelegate;", "getMeasurePassDelegate$ui", "()Landroidx/compose/ui/node/MeasurePassDelegate;", "ignoreRemeasureRequests", "insertAt", "index", "instance", "insertAt$ui", "exceptionMessageForParentingOrOwnership", "", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui", "removeAt", "count", "removeAt$ui", "removeAll", "removeAll$ui", "onChildRemoved", "child", "move", "from", "to", "move$ui", "isTransparent", "isSemanticsInvalidated", "isSemanticsInvalidated$ui", "setSemanticsInvalidated$ui", "requestAutofill", "requestAutofill$ui", "invalidateSemantics", "invalidateSemantics$ui", "_semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "semanticsConfiguration", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isCurrentlyCalculatingSemanticsConfiguration", "calculateSemanticsConfiguration", "attach", "attach$ui", "detach", "detach$ui", "_zSortedChildren", "zSortedChildrenInvalidated", "zSortedChildren", "getZSortedChildren$annotations", "()V", "getZSortedChildren", "isValidOwnerScope", "toString", "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui", "debugTreeToString", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getOrCreateIntrinsicsPolicy", "minLookaheadIntrinsicWidth", "height", "minLookaheadIntrinsicHeight", "width", "maxLookaheadIntrinsicWidth", "maxLookaheadIntrinsicHeight", "minIntrinsicWidth", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "traceContext", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "getTraceContext", "()Landroidx/compose/runtime/tooling/CompositionErrorContext;", "rethrowWithComposeStackTrace", "", "e", "", "onDensityOrLayoutDirectionChanged", "getWidth", "getHeight", "alignmentLinesRequired", "getAlignmentLinesRequired$ui", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "isPlaced", "isPlacedByParent", "placeOrder", "getPlaceOrder$ui", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui", "intrinsicsUsageByParent", "getIntrinsicsUsageByParent$ui", "setIntrinsicsUsageByParent$ui", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "previousIntrinsicsUsageByParent", "canMultiMeasure", "getCanMultiMeasure$ui$annotations", "getCanMultiMeasure$ui", "setCanMultiMeasure$ui", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui", "()Landroidx/compose/ui/node/NodeChain;", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator$ui", "()Landroidx/compose/ui/node/NodeCoordinator;", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "outerCoordinator", "getOuterCoordinator$ui", "zIndex", "", "getZIndex", "()F", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "_innerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui", "setInnerLayerCoordinatorIsDirty$ui", "innerLayerCoordinator", "getInnerLayerCoordinator$ui", "invalidateLayer", "invalidateLayer$ui", "_modifier", "Landroidx/compose/ui/Modifier;", "pendingModifier", "applyingModifierOnAttach", "getApplyingModifierOnAttach$ui", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "applyModifier", "resetModifierState", "invalidateParentData", "invalidateParentData$ui", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "onAttach", "getOnAttach$ui", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui", "setOnDetach$ui", "needsOnGloballyPositionedDispatch", "getNeedsOnGloballyPositionedDispatch$ui", "setNeedsOnGloballyPositionedDispatch$ui", "globallyPositionedObservers", "getGloballyPositionedObservers", "setGloballyPositionedObservers", "place", "x", "y", "place$ui", "replace", "replace$ui", "lookaheadReplace", "lookaheadReplace$ui", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw$ui", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "hitTest-6fMxITs$ui", "(JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hitTestSemantics", "hitSemanticsEntities", "hitTestSemantics-6fMxITs$ui", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui", "requestRemeasure", "forceRequest", "scheduleMeasureAndLayout", "invalidateIntrinsics", "requestRemeasure$ui", "requestLookaheadRemeasure", "requestLookaheadRemeasure$ui", "invalidateMeasurements", "invalidateMeasurements$ui", "invalidateOnPositioned", "invalidateOnPositioned$ui", "onCoordinatorPositionChanged", "onCoordinatorPositionChanged$ui", "T", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requestRelayout", "requestRelayout$ui", "requestLookaheadRelayout", "requestLookaheadRelayout$ui", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "invalidateLayers", "invalidateLayers$ui", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui", "remeasure", "remeasure-_Sx5XlM$ui", "measurePending", "getMeasurePending$ui", "layoutPending", "getLayoutPending$ui", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui", "markLayoutPending", "markLayoutPending$ui", "markMeasurePending", "markMeasurePending$ui", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui", "invalidateSubtree", "isRootOfInvalidation", "invalidateMeasurementForSubtree", "invalidateDrawForSubtree", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui", "forceRemeasure", "onLayoutComplete", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinator$ui", "forEachCoordinatorIncludingInner", "forEachCoordinatorIncludingInner$ui", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui", "clearSubtreePlacementIntrinsicsUsage", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/semantics/SemanticsInfo;", "childrenInfo", "getChildrenInfo", "isDeactivated", "onReuse", "onDeactivate", "onRelease", "NoIntrinsicsMeasurePolicy", "Companion", "LayoutState", "UsageByParent", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutNode implements ComposeNodeLifecycleCallback, LayoutInfo, Remeasurement, ComposeUiNode, InteroperableComposeUiNode, OnLayoutCompletedListener, OwnerScope, SemanticsInfo {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u0007X\u0080T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u001A\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\u0013j\b\u0012\u0004\u0012\u00020\u000B`\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2={"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "<init>", "()V", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "getNotPlacedPlaceOrder$ui$annotations", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ZComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getZComparator$ui", "()Ljava/util/Comparator;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Function0 getConstructor$ui() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui() {
            return LayoutNode.DummyViewConfiguration;
        }

        public static void getNotPlacedPlaceOrder$ui$annotations() {
        }

        public final Comparator getZComparator$ui() {
            return LayoutNode.ZComparator;
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "<init>", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum LayoutState {
        public static final enum LayoutState Idle;
        public static final enum LayoutState LayingOut;
        public static final enum LayoutState LookaheadLayingOut;
        public static final enum LayoutState LookaheadMeasuring;
        public static final enum LayoutState Measuring;

        private static final LayoutState[] $values() {
            return new LayoutState[]{LayoutState.Measuring, LayoutState.LookaheadMeasuring, LayoutState.LayingOut, LayoutState.LookaheadLayingOut, LayoutState.Idle};
        }

        static {
            LayoutState.Measuring = new LayoutState("Measuring", 0);
            LayoutState.LookaheadMeasuring = new LayoutState("LookaheadMeasuring", 1);
            LayoutState.LayingOut = new LayoutState("LayingOut", 2);
            LayoutState.LookaheadLayingOut = new LayoutState("LookaheadLayingOut", 3);
            LayoutState.Idle = new LayoutState("Idle", 4);
            LayoutState[] v0 = LayoutState.$values();
            LayoutState.$VALUES = v0;
            LayoutState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private LayoutState(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return LayoutState.$ENTRIES;
        }

        public static LayoutState valueOf(String arg1) {
            return Enum.valueOf(LayoutState.class, arg1);
        }

        public static LayoutState[] values() {
            return LayoutState.$VALUES.clone();
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b!\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001A\u00020\u0007*\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\f\u001A\u00020\rH\u0016J\"\u0010\u000E\u001A\u00020\u0007*\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\u000F\u001A\u00020\rH\u0016J\"\u0010\u0010\u001A\u00020\u0007*\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\f\u001A\u00020\rH\u0016J\"\u0010\u0011\u001A\u00020\u0007*\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\u000F\u001A\u00020\rH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "<init>", "(Ljava/lang/String;)V", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        public static final int $stable;
        private final String error;

        static {
        }

        public NoIntrinsicsMeasurePolicy(String arg1) {
            super();
            this.error = arg1;
        }

        public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, List arg2, int arg3) {
            return this.maxIntrinsicHeight(arg1, arg2, arg3).intValue();
        }

        public Void maxIntrinsicHeight(IntrinsicMeasureScope arg1, List arg2, int arg3) {
            throw new IllegalStateException(this.error.toString());
        }

        public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3) {
            return this.maxIntrinsicWidth(arg1, arg2, arg3).intValue();
        }

        public Void maxIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3) {
            throw new IllegalStateException(this.error.toString());
        }

        public int minIntrinsicHeight(IntrinsicMeasureScope arg1, List arg2, int arg3) {
            return this.minIntrinsicHeight(arg1, arg2, arg3).intValue();
        }

        public Void minIntrinsicHeight(IntrinsicMeasureScope arg1, List arg2, int arg3) {
            throw new IllegalStateException(this.error.toString());
        }

        public int minIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3) {
            return this.minIntrinsicWidth(arg1, arg2, arg3).intValue();
        }

        public Void minIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3) {
            throw new IllegalStateException(this.error.toString());
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "<init>", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum UsageByParent {
        public static final enum UsageByParent InLayoutBlock;
        public static final enum UsageByParent InMeasureBlock;
        public static final enum UsageByParent NotUsed;

        private static final UsageByParent[] $values() {
            return new UsageByParent[]{UsageByParent.InMeasureBlock, UsageByParent.InLayoutBlock, UsageByParent.NotUsed};
        }

        static {
            UsageByParent.InMeasureBlock = new UsageByParent("InMeasureBlock", 0);
            UsageByParent.InLayoutBlock = new UsageByParent("InLayoutBlock", 1);
            UsageByParent.NotUsed = new UsageByParent("NotUsed", 2);
            UsageByParent[] v0 = UsageByParent.$values();
            UsageByParent.$VALUES = v0;
            UsageByParent.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private UsageByParent(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return UsageByParent.$ENTRIES;
        }

        public static UsageByParent valueOf(String arg1) {
            return Enum.valueOf(UsageByParent.class, arg1);
        }

        public static UsageByParent[] values() {
            return UsageByParent.$VALUES.clone();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutState.values().length];
            try {
                v0[LayoutState.Idle.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                WhenMappings.$EnumSwitchMapping$0 = v0;
                return;
            }
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Function0 Constructor = null;
    private static final ViewConfiguration DummyViewConfiguration = null;
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = null;
    public static final int NotPlacedPlaceOrder = 0x7FFFFFFF;
    private static final Comparator ZComparator;
    private final MutableVectorWithMutationTracking _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private Modifier _modifier;
    private SemanticsConfiguration _semanticsConfiguration;
    private MutableVector _unfoldedChildren;
    private final MutableVector _zSortedChildren;
    private boolean addedToRectList;
    private boolean canMultiMeasure;
    private int compositeKeyHash;
    private CompositionLocalMap compositionLocalMap;
    private Density density;
    private int depth;
    private int globallyPositionedObservers;
    private boolean hasPositionalLayerTransformationsInOffsetFromRoot;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private boolean isCurrentlyCalculatingSemanticsConfiguration;
    private boolean isDeactivated;
    private boolean isSemanticsInvalidated;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;
    private long lastOffsetFromParent;
    private long lastSize;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LayoutNode lookaheadRoot;
    private MeasurePolicy measurePolicy;
    private boolean needsOnGloballyPositionedDispatch;
    private final NodeChain nodes;
    private Function1 onAttach;
    private Function1 onDetach;
    private long outerToInnerOffset;
    private boolean outerToInnerOffsetDirty;
    private Owner owner;
    private Modifier pendingModifier;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;

    static {
        LayoutNode.Companion = new Companion(null);
        LayoutNode.$stable = 8;
        LayoutNode.ErrorMeasurePolicy = new LayoutNode$Companion$ErrorMeasurePolicy$1();
        LayoutNode.Constructor = LayoutNode$Companion$Constructor$1.INSTANCE;
        LayoutNode.DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
        LayoutNode.ZComparator = new LayoutNode$$ExternalSyntheticLambda0();
    }

    public LayoutNode(boolean arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = SemanticsModifierKt.generateSemanticsId();
        }

        this(false, arg2);
    }

    public LayoutNode() {
        this(false, 0, 3, null);
    }

    public LayoutNode(boolean arg5, int arg6) {
        super();
        this.isVirtual = arg5;
        this.semanticsId = arg6;
        this.lastOffsetFromParent = IntOffset.Companion.getMax-nOcc-ac();
        this.lastSize = IntSize.Companion.getZero-YbymL2g();
        this.outerToInnerOffset = IntOffset.Companion.getMax-nOcc-ac();
        this.outerToInnerOffsetDirty = true;
        this._foldedChildren = new MutableVectorWithMutationTracking(new MutableVector(new LayoutNode[16], 0), new LayoutNode$_foldedChildren$1(this));
        this._zSortedChildren = new MutableVector(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = LayoutNode.ErrorMeasurePolicy;
        this.density = LayoutNodeKt.access$getDefaultDensity$p();
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = LayoutNode.DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.Companion.getEmpty();
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = UsageByParent.NotUsed;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this._modifier = Modifier.Companion;
    }

    static final int ZComparator$lambda$0(LayoutNode arg2, LayoutNode arg3) {
        if(arg2.getZIndex() == arg3.getZIndex()) {
            return Intrinsics.compare(arg2.getPlaceOrder$ui(), arg3.getPlaceOrder$ui());
        }

        return Float.compare(arg2.getZIndex(), arg3.getZIndex());
    }

    public static final Function0 access$getConstructor$cp() {
        return LayoutNode.Constructor;
    }

    public static final ViewConfiguration access$getDummyViewConfiguration$cp() {
        return LayoutNode.DummyViewConfiguration;
    }

    public static final Comparator access$getZComparator$cp() {
        return LayoutNode.ZComparator;
    }

    public static final void access$setIgnoreRemeasureRequests$p(LayoutNode arg0, boolean arg1) {
        arg0.ignoreRemeasureRequests = arg1;
    }

    private final void applyModifier(Modifier arg6) {
        boolean v0 = this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(16));
        boolean v2 = this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(0x400));
        this._modifier = arg6;
        this.nodes.updateFrom$ui(arg6);
        boolean v6 = this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(16));
        boolean v1 = this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(0x400));
        this.layoutDelegate.updateParentData();
        if(this.lookaheadRoot == null && (this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(0x200)))) {
            this.setLookaheadRoot(this);
        }

        if(v0 == v6) {
            if(v2 != v1) {
            }
            else {
                return;
            }
        }

        LayoutNodeKt.requireOwner(this).getRectManager().updateFlagsFor(this, v1, v6);
    }

    public final void attach$ui(Owner arg7) {
        Owner v4_1;
        int v1 = 0;
        int v0 = this.owner == null ? 1 : 0;
        Object v3 = null;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Cannot attach " + this + " as it already is attached.  Tree: " + LayoutNode.debugTreeToString$default(this, 0, 1, v3));
        }

        LayoutNode v0_1 = this._foldedParent;
        if(v0_1 != null) {
            if(v0_1 != null) {
                Owner v0_2 = v0_1.owner;
            }
            else {
                Object v0_3 = v3;
            }

            if(Intrinsics.areEqual(v0_3, arg7)) {
                goto label_30;
            }

            v0 = 0;
        }
        else {
        label_30:
            v0 = 1;
        }

        if(v0 == 0) {
            StringBuilder v0_4 = new StringBuilder("Attaching to a different owner(").append(arg7).append(") than the parent\'s owner(");
            LayoutNode v4 = this.getParent$ui();
            if(v4 != null) {
                v4_1 = v4.owner;
            }
            else {
                Object v4_2 = v3;
            }

            v0_4 = v0_4.append(v4_1).append("). This tree: ").append(LayoutNode.debugTreeToString$default(this, 0, 1, v3)).append(" Parent tree: ");
            v4 = this._foldedParent;
            String v4_3 = v4 != null ? LayoutNode.debugTreeToString$default(v4, 0, 1, v3) : ((String)v3);
            InlineClassHelperKt.throwIllegalStateException(v0_4.append(v4_3).toString());
        }

        v0_1 = this.getParent$ui();
        if(v0_1 == null) {
            this.getMeasurePassDelegate$ui().setPlaced$ui(true);
            RectManager.onLayoutPositionChanged$default(arg7.getRectManager(), this, false, 2, v3);
            LookaheadPassDelegate v4_4 = this.getLookaheadPassDelegate$ui();
            if(v4_4 != null) {
                v4_4.onAttachedToNullParent();
            }
        }

        NodeCoordinator v4_5 = this.getOuterCoordinator$ui();
        NodeCoordinator v5 = v0_1 != null ? v0_1.getInnerCoordinator$ui() : ((NodeCoordinator)v3);
        v4_5.setWrappedBy$ui(v5);
        this.owner = arg7;
        int v4_6 = v0_1 != null ? v0_1.depth : -1;
        this.depth = v4_6 + 1;
        Modifier v2 = this.pendingModifier;
        if(v2 != null) {
            this.applyModifier(v2);
        }

        this.pendingModifier = ((Modifier)v3);
        int v3_1 = 8;
        if(!ComposeUiFlags.isSemanticAutofillEnabled && (this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(v3_1)))) {
            this.invalidateSemantics$ui();
        }

        arg7.onPreAttach(this);
        if(this.isVirtualLookaheadRoot) {
            this.setLookaheadRoot(this);
        }
        else {
            LayoutNode v2_1 = this._foldedParent;
            if(v2_1 != null) {
                v2_1 = v2_1.lookaheadRoot;
                if(v2_1 == null) {
                    goto label_102;
                }
            }
            else {
            label_102:
                v2_1 = this.lookaheadRoot;
            }

            this.setLookaheadRoot(v2_1);
            if(this.lookaheadRoot != null) {
                goto label_112;
            }

            if(!this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(0x200))) {
                goto label_112;
            }

            this.setLookaheadRoot(this);
        }

    label_112:
        if(!this.isDeactivated()) {
            this.nodes.markAsAttached();
        }

        MutableVector v2_2 = this._foldedChildren.getVector();
        Object[] v4_7 = v2_2.content;
        int v2_3 = v2_2.getSize();
        while(v1 < v2_3) {
            v4_7[v1].attach$ui(arg7);
            ++v1;
        }

        if(!this.isDeactivated()) {
            this.nodes.runAttachLifecycle();
        }

        this.invalidateMeasurements$ui();
        if(v0_1 != null) {
            v0_1.invalidateMeasurements$ui();
        }

        Function1 v0_5 = this.onAttach;
        if(v0_5 != null) {
            v0_5.invoke(arg7);
        }

        this.layoutDelegate.updateParentData();
        if((ComposeUiFlags.isSemanticAutofillEnabled) && !this.isDeactivated() && (this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(v3_1)))) {
            this.invalidateSemantics$ui();
        }

        arg7.onPostAttach(this);
    }

    private final SemanticsConfiguration calculateSemanticsConfiguration() {
        this.isCurrentlyCalculatingSemanticsConfiguration = true;
        ObjectRef v0 = new ObjectRef();
        v0.element = new SemanticsConfiguration();
        OwnerSnapshotObserver v1 = LayoutNodeKt.requireOwner(this).getSnapshotObserver();
        OwnerSnapshotObserver.access$getObserver$p(v1).observeReads(this, OwnerSnapshotObserver.access$getOnCommitAffectingSemantics$p(v1), new LayoutNode$calculateSemanticsConfiguration$1(this, v0));
        this.isCurrentlyCalculatingSemanticsConfiguration = false;
        return v0.element;
    }

    public final void clearSubtreeIntrinsicsUsage$ui() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector v5 = this.get_children$ui();
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v1;
        for(v1 = 0; v1 < v5_1; ++v1) {
            Object v2 = v0[v1];
            if(((LayoutNode)v2).intrinsicsUsageByParent != UsageByParent.NotUsed) {
                ((LayoutNode)v2).clearSubtreeIntrinsicsUsage$ui();
            }
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector v5 = this.get_children$ui();
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v1;
        for(v1 = 0; v1 < v5_1; ++v1) {
            Object v2 = v0[v1];
            if(((LayoutNode)v2).intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                ((LayoutNode)v2).clearSubtreePlacementIntrinsicsUsage();
            }
        }
    }

    private final String debugTreeToString(int arg7) {
        StringBuilder v0 = new StringBuilder();
        int v2;
        for(v2 = 0; v2 < arg7; ++v2) {
            v0.append("  ");
        }

        v0.append("|-");
        v0.append(this.toString());
        v0.append('\n');
        MutableVector v6 = this.get_children$ui();
        Object[] v2_1 = v6.content;
        int v6_1 = v6.getSize();
        int v3;
        for(v3 = 0; v3 < v6_1; ++v3) {
            v0.append(v2_1[v3].debugTreeToString(arg7 + 1));
        }

        String v6_2 = v0.toString();
        if(arg7 == 0) {
            v6_2 = v6_2.substring(0, v6_2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(v6_2, "substring(...)");
        }

        return v6_2;
    }

    static String debugTreeToString$default(LayoutNode arg0, int arg1, int arg2, Object arg3) {
        return arg0.debugTreeToString(0);
    }

    public final void detach$ui() {
        Owner v0 = this.owner;
        Object v3 = null;
        if(v0 == null) {
            StringBuilder v0_1 = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            this = this.getParent$ui();
            if(this != null) {
                String v3_1 = LayoutNode.debugTreeToString$default(this, 0, 1, v3);
            }

            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(v0_1.append(((String)v3)).toString());
            throw new KotlinNothingValueException();
        }

        LayoutNode v4 = this.getParent$ui();
        if(v4 != null) {
            v4.invalidateLayer$ui();
            v4.invalidateMeasurements$ui();
            this.getMeasurePassDelegate$ui().setMeasuredByParent$ui(UsageByParent.NotUsed);
            LookaheadPassDelegate v4_1 = this.getLookaheadPassDelegate$ui();
            if(v4_1 != null) {
                v4_1.setMeasuredByParent$ui(UsageByParent.NotUsed);
            }
        }

        this.layoutDelegate.resetAlignmentLines();
        NodeCoordinator v4_2 = this.getOuterCoordinator$ui();
        NodeCoordinator v5 = this.getInnerCoordinator$ui().getWrapped$ui();
        while(!Intrinsics.areEqual(v4_2, v5)) {
            if(v4_2 == null) {
                break;
            }

            v4_2.onLayoutNodeDetach();
            v4_2 = v4_2.getWrapped$ui();
        }

        Function1 v4_3 = this.onDetach;
        if(v4_3 != null) {
            v4_3.invoke(v0);
        }

        int v5_1 = 8;
        if(!ComposeUiFlags.isSemanticAutofillEnabled && (this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(v5_1)))) {
            this.invalidateSemantics$ui();
        }

        this.nodes.runDetachLifecycle$ui();
        this.ignoreRemeasureRequests = true;
        MutableVector v1 = this._foldedChildren.getVector();
        Object[] v4_4 = v1.content;
        int v1_1 = v1.getSize();
        int v6;
        for(v6 = 0; v6 < v1_1; ++v6) {
            v4_4[v6].detach$ui();
        }

        this.ignoreRemeasureRequests = false;
        this.nodes.markAsDetached$ui();
        v0.onDetach(this);
        v0.getRectManager().remove(this);
        this.owner = ((Owner)v3);
        this.setLookaheadRoot(((LayoutNode)v3));
        this.depth = 0;
        this.getMeasurePassDelegate$ui().onNodeDetached();
        LookaheadPassDelegate v1_2 = this.getLookaheadPassDelegate$ui();
        if(v1_2 != null) {
            v1_2.onNodeDetached();
        }

        if((ComposeUiFlags.isSemanticAutofillEnabled) && (this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(v5_1)))) {
            SemanticsConfiguration v1_3 = this._semanticsConfiguration;
            this._semanticsConfiguration = ((SemanticsConfiguration)v3);
            this.isSemanticsInvalidated = false;
            v0.getSemanticsOwner().notifySemanticsChange$ui(((SemanticsInfo)this), v1_3);
            v0.onSemanticsChange();
        }
    }

    public final void dispatchOnPositionedCallbacks$ui() {
        if(this.getLayoutState$ui() == LayoutState.Idle && !this.getLayoutPending$ui() && !this.getMeasurePending$ui()) {
            if(this.isDeactivated()) {
            }
            else if(!this.isPlaced()) {
            }
            else {
                NodeChain v10 = this.nodes;
                int v0 = 0x100;
                int v1 = NodeKind.constructor-impl(v0);
                if((NodeChain.access$getAggregateChildKindSet(v10) & v1) != 0) {
                    Node v10_1;
                    for(v10_1 = v10.getHead$ui(); v10_1 != null; v10_1 = v10_1.getChild$ui()) {
                        if((v10_1.getKindSet$ui() & v1) != 0) {
                            Node v2 = null;
                            Node v3 = v10_1;
                            MutableVector v4 = ((MutableVector)v2);
                            while(true) {
                            label_27:
                                if(v3 != null) {
                                    if((v3 instanceof GlobalPositionAwareModifierNode)) {
                                        ((GlobalPositionAwareModifierNode)v3).onGloballyPositioned(DelegatableNodeKt.requireCoordinator-64DMado(v3, NodeKind.constructor-impl(v0)));
                                    }
                                    else if((v3.getKindSet$ui() & v1) != 0 && ((v3 instanceof DelegatingNode))) {
                                        Node v5 = v3.getDelegate$ui();
                                        int v7 = 0;
                                        while(v5 != null) {
                                            if((v5.getKindSet$ui() & v1) != 0) {
                                                ++v7;
                                                if(v7 == 1) {
                                                    v3 = v5;
                                                }
                                                else {
                                                    if(v4 == null) {
                                                        v4 = new MutableVector(new Node[16], 0);
                                                    }

                                                    if(v3 != null) {
                                                        if(v4 != null) {
                                                            v4.add(v3);
                                                        }

                                                        v3 = v2;
                                                    }

                                                    if(v4 == null) {
                                                        goto label_64;
                                                    }

                                                    v4.add(v5);
                                                }
                                            }

                                        label_64:
                                            v5 = v5.getChild$ui();
                                        }

                                        if(v7 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_70;
                            }

                            v3 = DelegatableNodeKt.pop(v4);
                            goto label_27;
                        }

                    label_70:
                        if((v10_1.getAggregateChildKindSet$ui() & v1) == 0) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void draw$ui(Canvas arg2, GraphicsLayer arg3) {
        Unit v1;
        try {
            this.getOuterCoordinator$ui().draw(arg2, arg3);
            v1 = Unit.INSTANCE;
            return;
        }
        catch(Throwable v2) {
            ((LayoutNode)v1).rethrowWithComposeStackTrace(v2);
            throw new KotlinNothingValueException();
        }
    }

    private final String exceptionMessageForParentingOrOwnership(LayoutNode arg5) {
        Object v3 = null;
        StringBuilder v4 = new StringBuilder("Cannot insert ").append(arg5).append(" because it already has a parent or an owner. This tree: ").append(LayoutNode.debugTreeToString$default(this, 0, 1, v3)).append(" Other tree: ");
        arg5 = arg5._foldedParent;
        if(arg5 != null) {
            String v3_1 = LayoutNode.debugTreeToString$default(arg5, 0, 1, v3);
        }

        return v4.append(((String)v3)).toString();
    }

    public final void forEachChild(Function1 arg4) {
        MutableVector v3 = this.get_children$ui();
        Object[] v0 = v3.content;
        int v3_1 = v3.getSize();
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            arg4.invoke(v0[v1]);
        }
    }

    public final void forEachChildIndexed(Function2 arg5) {
        MutableVector v4 = this.get_children$ui();
        Object[] v0 = v4.content;
        int v4_1 = v4.getSize();
        int v1;
        for(v1 = 0; v1 < v4_1; ++v1) {
            arg5.invoke(Integer.valueOf(v1), v0[v1]);
        }
    }

    public final void forEachCoordinator$ui(Function1 arg3) {
        NodeCoordinator v0 = this.getOuterCoordinator$ui();
        NodeCoordinator v2 = this.getInnerCoordinator$ui();
        while(v0 != v2) {
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            arg3.invoke(v0);
            v0 = ((LayoutModifierNodeCoordinator)v0).getWrapped$ui();
        }
    }

    public final void forEachCoordinatorIncludingInner$ui(Function1 arg3) {
        NodeCoordinator v0 = this.getOuterCoordinator$ui();
        NodeCoordinator v2 = this.getInnerCoordinator$ui().getWrapped$ui();
        while(!Intrinsics.areEqual(v0, v2)) {
            if(v0 == null) {
                return;
            }

            arg3.invoke(v0);
            v0 = v0.getWrapped$ui();
        }
    }

    public void forceRemeasure() {
        LayoutNode v1;
        if(this.lookaheadRoot != null) {
            v1 = this;
            LayoutNode.requestLookaheadRemeasure$ui$default(v1, false, false, false, 5, null);
        }
        else {
            v1 = this;
            LayoutNode.requestRemeasure$ui$default(v1, false, false, false, 5, null);
        }

        Constraints v13 = v1.layoutDelegate.getLastConstraints-DWUhwKw();
        Owner v0 = v1.owner;
        if(v13 != null) {
            if(v0 != null) {
                v0.measureAndLayout-0kLqBqw(v1, v13.unbox-impl());
                return;
            }
        }
        else if(v0 != null) {
            Owner.measureAndLayout$default(v0, false, 1, null);
        }
    }

    public final boolean getAddedToRectList$ui() {
        return this.addedToRectList;
    }

    public final boolean getAlignmentLinesRequired$ui() {
        LayoutNodeLayoutDelegate v2 = this.layoutDelegate;
        if(!v2.getAlignmentLinesOwner$ui().getAlignmentLines().getRequired$ui()) {
            AlignmentLinesOwner v2_1 = v2.getLookaheadAlignmentLinesOwner$ui();
            if(v2_1 != null) {
                AlignmentLines v2_2 = v2_1.getAlignmentLines();
                if(v2_2 != null && (v2_2.getRequired$ui())) {
                    return 1;
                }
            }

            return 0;
        }

        return 1;
    }

    public final boolean getApplyingModifierOnAttach$ui() {
        if(this.pendingModifier != null) {
            return 1;
        }

        return 0;
    }

    public final boolean getCanMultiMeasure$ui() {
        return this.canMultiMeasure;
    }

    @Deprecated(message="Temporary API to support ConstraintLayout prototyping.") public static void getCanMultiMeasure$ui$annotations() {
    }

    public final List getChildLookaheadMeasurables$ui() {
        LookaheadPassDelegate v0 = this.getLookaheadPassDelegate$ui();
        Intrinsics.checkNotNull(v0);
        return v0.getChildDelegates$ui();
    }

    public final List getChildMeasurables$ui() {
        return this.getMeasurePassDelegate$ui().getChildDelegates$ui();
    }

    public final List getChildren$ui() {
        return this.get_children$ui().asMutableList();
    }

    public List getChildrenInfo() {
        return this.getChildren$ui();
    }

    public int getCompositeKeyHash() {
        return this.compositeKeyHash;
    }

    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    public LayoutCoordinates getCoordinates() {
        return this.getInnerCoordinator$ui();
    }

    public Density getDensity() {
        return this.density;
    }

    public final int getDepth$ui() {
        return this.depth;
    }

    public final List getFoldedChildren$ui() {
        return this._foldedChildren.getVector().asMutableList();
    }

    public final int getGloballyPositionedObservers() {
        return this.globallyPositionedObservers;
    }

    public final boolean getHasFixedInnerContentConstraints$ui() {
        long v0 = this.getInnerCoordinator$ui().getLastMeasurementConstraints-msEJaDk$ui();
        if((Constraints.getHasFixedWidth-impl(v0)) && (Constraints.getHasFixedHeight-impl(v0))) {
            return 1;
        }

        return 0;
    }

    public final boolean getHasPositionalLayerTransformationsInOffsetFromRoot$ui() {
        return this.hasPositionalLayerTransformationsInOffsetFromRoot;
    }

    public int getHeight() {
        return this.layoutDelegate.getHeight$ui();
    }

    public final NodeCoordinator getInnerCoordinator$ui() {
        return this.nodes.getInnerCoordinator$ui();
    }

    public final NodeCoordinator getInnerLayerCoordinator$ui() {
        if(this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator v0 = this.getInnerCoordinator$ui();
            NodeCoordinator v1 = this.getOuterCoordinator$ui().getWrappedBy$ui();
            NodeCoordinator v2 = null;
            this._innerLayerCoordinator = v2;
            while(!Intrinsics.areEqual(v0, v1)) {
                OwnedLayer v3 = v0 != null ? v0.getLayer() : ((OwnedLayer)v2);
                if(v3 != null) {
                    this._innerLayerCoordinator = v0;
                    break;
                }

                if(v0 != null) {
                    v0 = v0.getWrappedBy$ui();
                    continue;
                }

                Object v0_1 = v2;
            }
        }

        NodeCoordinator v4 = this._innerLayerCoordinator;
        if(v4 != null) {
            if(v4.getLayer() != null) {
            }
            else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("layer was not set");
                throw new KotlinNothingValueException();
            }
        }

        return v4;
    }

    public final boolean getInnerLayerCoordinatorIsDirty$ui() {
        return this.innerLayerCoordinatorIsDirty;
    }

    public View getInteropView() {
        AndroidViewHolder v0 = this.interopViewFactoryHolder;
        if(v0 != null) {
            return v0.getInteropView();
        }

        return null;
    }

    public final AndroidViewHolder getInteropViewFactoryHolder$ui() {
        return this.interopViewFactoryHolder;
    }

    public final UsageByParent getIntrinsicsUsageByParent$ui() {
        return this.intrinsicsUsageByParent;
    }

    public final long getLastOffsetFromParent-nOcc-ac$ui() {
        return this.lastOffsetFromParent;
    }

    public final long getLastSize-YbymL2g$ui() {
        return this.lastSize;
    }

    public final LayoutNodeLayoutDelegate getLayoutDelegate$ui() {
        return this.layoutDelegate;
    }

    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final boolean getLayoutPending$ui() {
        return this.layoutDelegate.getLayoutPending$ui();
    }

    public final LayoutState getLayoutState$ui() {
        return this.layoutDelegate.getLayoutState$ui();
    }

    public final boolean getLookaheadLayoutPending$ui() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui();
    }

    public final boolean getLookaheadMeasurePending$ui() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui();
    }

    public final LookaheadPassDelegate getLookaheadPassDelegate$ui() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui();
    }

    public final LayoutNode getLookaheadRoot$ui() {
        return this.lookaheadRoot;
    }

    public final LayoutNodeDrawScope getMDrawScope$ui() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui() {
        return this.layoutDelegate.getMeasurePassDelegate$ui();
    }

    public final boolean getMeasurePending$ui() {
        return this.layoutDelegate.getMeasurePending$ui();
    }

    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    public final UsageByParent getMeasuredByParent$ui() {
        return this.getMeasurePassDelegate$ui().getMeasuredByParent$ui();
    }

    public final UsageByParent getMeasuredByParentInLookahead$ui() {
        LookaheadPassDelegate v0 = this.getLookaheadPassDelegate$ui();
        if(v0 != null) {
            UsageByParent v0_1 = v0.getMeasuredByParent$ui();
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return UsageByParent.NotUsed;
    }

    public Modifier getModifier() {
        return this._modifier;
    }

    public List getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    public final boolean getNeedsOnGloballyPositionedDispatch$ui() {
        return this.needsOnGloballyPositionedDispatch;
    }

    public final NodeChain getNodes$ui() {
        return this.nodes;
    }

    public final Function1 getOnAttach$ui() {
        return this.onAttach;
    }

    public final Function1 getOnDetach$ui() {
        return this.onDetach;
    }

    private final IntrinsicsPolicy getOrCreateIntrinsicsPolicy() {
        IntrinsicsPolicy v0 = this.intrinsicsPolicy;
        if(v0 == null) {
            v0 = new IntrinsicsPolicy(this, this.getMeasurePolicy());
            this.intrinsicsPolicy = v0;
        }

        return v0;
    }

    public final NodeCoordinator getOuterCoordinator$ui() {
        return this.nodes.getOuterCoordinator$ui();
    }

    public final long getOuterToInnerOffset-nOcc-ac$ui() {
        return this.outerToInnerOffset;
    }

    public final boolean getOuterToInnerOffsetDirty$ui() {
        return this.outerToInnerOffsetDirty;
    }

    public final Owner getOwner$ui() {
        return this.owner;
    }

    public final LayoutNode getParent$ui() {
        for(this = this._foldedParent; this != null; this = this._foldedParent) {
            if(!this.isVirtual) {
                return this;
            }
        }

        return this;
    }

    public LayoutInfo getParentInfo() {
        return this.getParentInfo();
    }

    public SemanticsInfo getParentInfo() {
        return this.getParent$ui();
    }

    public final int getPlaceOrder$ui() {
        return this.getMeasurePassDelegate$ui().getPlaceOrder();
    }

    public SemanticsConfiguration getSemanticsConfiguration() {
        if((this.isAttached()) && !this.isDeactivated()) {
            if(!this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(8))) {
            }
            else {
                if(!ComposeUiFlags.isSemanticAutofillEnabled && this._semanticsConfiguration == null) {
                    this._semanticsConfiguration = this.calculateSemanticsConfiguration();
                }

                return this._semanticsConfiguration;
            }
        }

        return null;
    }

    public int getSemanticsId() {
        return this.semanticsId;
    }

    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui() {
        return this.subcompositionsState;
    }

    private final CompositionErrorContext getTraceContext() {
        return this.getCompositionLocalMap().get(CompositionErrorContextKt.getLocalCompositionErrorContext());
    }

    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public int getWidth() {
        return this.layoutDelegate.getWidth$ui();
    }

    private final float getZIndex() {
        return this.getMeasurePassDelegate$ui().getZIndex$ui();
    }

    public final MutableVector getZSortedChildren() {
        if(this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            this._zSortedChildren.addAll(this._zSortedChildren.getSize(), this.get_children$ui());
            this._zSortedChildren.sortWith(LayoutNode.ZComparator);
            this.zSortedChildrenInvalidated = false;
        }

        return this._zSortedChildren;
    }

    public static void getZSortedChildren$annotations() {
    }

    public final MutableVector get_children$ui() {
        this.updateChildrenIfDirty$ui();
        if(this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }

        MutableVector v1 = this._unfoldedChildren;
        Intrinsics.checkNotNull(v1);
        return v1;
    }

    public final void hitTest-6fMxITs$ui(long arg14, HitTestResult arg16, int arg17, boolean arg18) {
        this.getOuterCoordinator$ui().hitTest-qzLsGqo(NodeCoordinator.Companion.getPointerInputSource(), NodeCoordinator.fromParentPosition-8S9VItk$default(this.getOuterCoordinator$ui(), arg14, false, 2, null), arg16, arg17, arg18);
    }

    public static void hitTest-6fMxITs$ui$default(LayoutNode arg6, long arg7, HitTestResult arg9, int arg10, boolean arg11, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg10 = PointerType.Companion.getUnknown-T8wyACA();
        }

        arg6.hitTest-6fMxITs$ui(arg7, arg9, arg10, true);
    }

    public final void hitTestSemantics-6fMxITs$ui(long arg14, HitTestResult arg16, int arg17, boolean arg18) {
        this.getOuterCoordinator$ui().hitTest-qzLsGqo(NodeCoordinator.Companion.getSemanticsSource(), NodeCoordinator.fromParentPosition-8S9VItk$default(this.getOuterCoordinator$ui(), arg14, false, 2, null), arg16, PointerType.Companion.getTouch-T8wyACA(), arg18);
    }

    public static void hitTestSemantics-6fMxITs$ui$default(LayoutNode arg6, long arg7, HitTestResult arg9, int arg10, boolean arg11, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg10 = PointerType.Companion.getTouch-T8wyACA();
        }

        arg6.hitTestSemantics-6fMxITs$ui(arg7, arg9, arg10, true);
    }

    public final Object ignoreRemeasureRequests$ui(Function0 arg2) {
        this.ignoreRemeasureRequests = true;
        Object v2 = arg2.invoke();
        this.ignoreRemeasureRequests = false;
        return v2;
    }

    public final void insertAt$ui(int arg3, LayoutNode arg4) {
        int v0 = arg4._foldedParent == null || arg4.owner == null ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException(this.exceptionMessageForParentingOrOwnership(arg4));
        }

        arg4._foldedParent = this;
        this._foldedChildren.add(arg3, arg4);
        this.onZSortedChildrenInvalidated$ui();
        if(arg4.isVirtual) {
            ++this.virtualChildrenCount;
        }

        this.invalidateUnfoldedVirtualChildren();
        Owner v3 = this.owner;
        if(v3 != null) {
            arg4.attach$ui(v3);
        }

        if(arg4.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(this.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
        }

        if(arg4.globallyPositionedObservers > 0) {
            this.setGloballyPositionedObservers(this.globallyPositionedObservers + 1);
        }
    }

    public final void invalidateDrawForSubtree(boolean arg11) {
        if(arg11) {
            LayoutNode v11 = this.getParent$ui();
            if(v11 != null) {
                v11.invalidateLayer$ui();
            }
        }

        NodeChain v11_1 = this.nodes;
        int v0 = 2;
        int v1 = NodeKind.constructor-impl(v0);
        if((NodeChain.access$getAggregateChildKindSet(v11_1) & v1) != 0) {
            Node v11_2;
            for(v11_2 = v11_1.getHead$ui(); v11_2 != null; v11_2 = v11_2.getChild$ui()) {
                if((v11_2.getKindSet$ui() & v1) != 0) {
                    Node v2 = null;
                    Node v4 = v11_2;
                    MutableVector v5 = ((MutableVector)v2);
                    while(true) {
                    label_19:
                        if(v4 != null) {
                            if((v4 instanceof LayoutModifierNode)) {
                                OwnedLayer v4_1 = DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)v4), NodeKind.constructor-impl(v0)).getLayer();
                                if(v4_1 != null) {
                                    v4_1.invalidate();
                                }
                            }
                            else if((v4.getKindSet$ui() & v1) != 0 && ((v4 instanceof DelegatingNode))) {
                                Node v6 = v4.getDelegate$ui();
                                int v7 = 0;
                                while(v6 != null) {
                                    if((v6.getKindSet$ui() & v1) != 0) {
                                        ++v7;
                                        if(v7 == 1) {
                                            v4 = v6;
                                        }
                                        else {
                                            if(v5 == null) {
                                                v5 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v4 != null) {
                                                if(v5 != null) {
                                                    v5.add(v4);
                                                }

                                                v4 = v2;
                                            }

                                            if(v5 == null) {
                                                goto label_56;
                                            }

                                            v5.add(v6);
                                        }
                                    }

                                label_56:
                                    v6 = v6.getChild$ui();
                                }

                                if(v7 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_62;
                    }

                    v4 = DelegatableNodeKt.pop(v5);
                    goto label_19;
                }

            label_62:
                if((v11_2.getAggregateChildKindSet$ui() & v1) == 0) {
                    break;
                }
            }
        }

        MutableVector v10 = this.get_children$ui();
        Object[] v11_3 = v10.content;
        int v10_1 = v10.getSize();
        for(v0 = 0; v0 < v10_1; ++v0) {
            v11_3[v0].invalidateDrawForSubtree(false);
        }
    }

    public static void invalidateDrawForSubtree$default(LayoutNode arg0, boolean arg1, int arg2, Object arg3) {
        arg0.invalidateDrawForSubtree(true);
    }

    public final void invalidateLayer$ui() {
        NodeCoordinator v0 = this.getInnerLayerCoordinator$ui();
        if(v0 != null) {
            v0.invalidateLayer();
            return;
        }

        this = this.getParent$ui();
        if(this != null) {
            this.invalidateLayer$ui();
        }
    }

    public final void invalidateLayers$ui() {
        NodeCoordinator v0 = this.getOuterCoordinator$ui();
        NodeCoordinator v1 = this.getInnerCoordinator$ui();
        while(v0 != v1) {
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            OwnedLayer v2 = ((LayoutModifierNodeCoordinator)v0).getLayer();
            if(v2 != null) {
                v2.invalidate();
            }

            v0 = ((LayoutModifierNodeCoordinator)v0).getWrapped$ui();
        }

        OwnedLayer v3 = this.getInnerCoordinator$ui().getLayer();
        if(v3 != null) {
            v3.invalidate();
        }
    }

    public final void invalidateMeasurementForSubtree() {
        int v1 = 0;
        LayoutNode.requestRemeasure$ui$default(this, false, false, false, 7, null);
        MutableVector v6 = this.get_children$ui();
        Object[] v0 = v6.content;
        int v6_1 = v6.getSize();
        while(v1 < v6_1) {
            v0[v1].invalidateMeasurementForSubtree();
            ++v1;
        }
    }

    public final void invalidateMeasurements$ui() {
        if(this.isVirtual) {
            this = this.getParent$ui();
            if(this != null) {
                this.invalidateMeasurements$ui();
            }

            return;
        }

        if(this.lookaheadRoot != null) {
            LayoutNode.requestLookaheadRemeasure$ui$default(this, false, false, false, 7, null);
            return;
        }

        LayoutNode.requestRemeasure$ui$default(this, false, false, false, 7, null);
    }

    public final void invalidateOnPositioned$ui() {
        if(this.globallyPositionedObservers != 0 && !this.getLayoutPending$ui() && !this.getMeasurePending$ui()) {
            if(this.needsOnGloballyPositionedDispatch) {
            }
            else {
                LayoutNodeKt.requireOwner(this).requestOnPositionedCallback(this);
            }
        }
    }

    public final void invalidateParentData$ui() {
        this.layoutDelegate.invalidateParentData();
    }

    public final void invalidateSemantics$ui() {
        if(this.isCurrentlyCalculatingSemanticsConfiguration) {
            return;
        }

        if(!ComposeUiFlags.isSemanticAutofillEnabled) {
            this._semanticsConfiguration = null;
            LayoutNodeKt.requireOwner(this).onSemanticsChange();
            return;
        }

        if(!this.nodes.isUpdating$ui()) {
            if(this.getApplyingModifierOnAttach$ui()) {
            }
            else {
                SemanticsConfiguration v0 = this._semanticsConfiguration;
                this._semanticsConfiguration = this.calculateSemanticsConfiguration();
                this.isSemanticsInvalidated = false;
                Owner v1 = LayoutNodeKt.requireOwner(this);
                v1.getSemanticsOwner().notifySemanticsChange$ui(((SemanticsInfo)this), v0);
                v1.onSemanticsChange();
                return;
            }
        }

        this.isSemanticsInvalidated = true;
    }

    public final void invalidateSubtree(boolean arg11) {
        if(arg11) {
            LayoutNode v11 = this.getParent$ui();
            if(v11 != null) {
                v11.invalidateLayer$ui();
            }
        }

        this.invalidateSemantics$ui();
        LayoutNode v0 = this;
        LayoutNode.requestRemeasure$ui$default(v0, false, false, false, 7, null);
        NodeChain v10 = v0.nodes;
        int v11_1 = 2;
        int v1 = NodeKind.constructor-impl(v11_1);
        if((NodeChain.access$getAggregateChildKindSet(v10) & v1) != 0) {
            Node v10_1;
            for(v10_1 = v10.getHead$ui(); v10_1 != null; v10_1 = v10_1.getChild$ui()) {
                if((v10_1.getKindSet$ui() & v1) != 0) {
                    Node v2 = null;
                    Node v4 = v10_1;
                    MutableVector v5 = ((MutableVector)v2);
                    while(true) {
                    label_26:
                        if(v4 != null) {
                            if((v4 instanceof LayoutModifierNode)) {
                                OwnedLayer v4_1 = DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)v4), NodeKind.constructor-impl(v11_1)).getLayer();
                                if(v4_1 != null) {
                                    v4_1.invalidate();
                                }
                            }
                            else if((v4.getKindSet$ui() & v1) != 0 && ((v4 instanceof DelegatingNode))) {
                                Node v6 = v4.getDelegate$ui();
                                int v7 = 0;
                                while(v6 != null) {
                                    if((v6.getKindSet$ui() & v1) != 0) {
                                        ++v7;
                                        if(v7 == 1) {
                                            v4 = v6;
                                        }
                                        else {
                                            if(v5 == null) {
                                                v5 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v4 != null) {
                                                if(v5 != null) {
                                                    v5.add(v4);
                                                }

                                                v4 = v2;
                                            }

                                            if(v5 == null) {
                                                goto label_63;
                                            }

                                            v5.add(v6);
                                        }
                                    }

                                label_63:
                                    v6 = v6.getChild$ui();
                                }

                                if(v7 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_69;
                    }

                    v4 = DelegatableNodeKt.pop(v5);
                    goto label_26;
                }

            label_69:
                if((v10_1.getAggregateChildKindSet$ui() & v1) == 0) {
                    break;
                }
            }
        }

        MutableVector v10_2 = v0.get_children$ui();
        Object[] v11_2 = v10_2.content;
        int v10_3 = v10_2.getSize();
        int v0_1;
        for(v0_1 = 0; v0_1 < v10_3; ++v0_1) {
            v11_2[v0_1].invalidateSubtree(false);
        }
    }

    public static void invalidateSubtree$default(LayoutNode arg0, boolean arg1, int arg2, Object arg3) {
        arg0.invalidateSubtree(true);
    }

    private final void invalidateUnfoldedVirtualChildren() {
        if(this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }

        if(this.isVirtual) {
            this = this._foldedParent;
            if(this != null) {
                this.invalidateUnfoldedVirtualChildren();
            }
        }
    }

    public boolean isAttached() {
        if(this.owner != null) {
            return 1;
        }

        return 0;
    }

    public boolean isDeactivated() {
        return this.isDeactivated;
    }

    public boolean isPlaced() {
        return this.getMeasurePassDelegate$ui().isPlaced$ui();
    }

    public final boolean isPlacedByParent() {
        return this.getMeasurePassDelegate$ui().isPlacedByParent();
    }

    public final Boolean isPlacedInLookahead() {
        LookaheadPassDelegate v0 = this.getLookaheadPassDelegate$ui();
        if(v0 != null) {
            return Boolean.valueOf(v0.isPlaced$ui());
        }

        return null;
    }

    public final boolean isSemanticsInvalidated$ui() {
        return this.isSemanticsInvalidated;
    }

    public boolean isTransparent() {
        return this.getOuterCoordinator$ui().isTransparent();
    }

    public boolean isValidOwnerScope() {
        return this.isAttached();
    }

    public final boolean isVirtualLookaheadRoot$ui() {
        return this.isVirtualLookaheadRoot;
    }

    public final boolean lookaheadRemeasure-_Sx5XlM$ui(Constraints arg3) {
        if(arg3 != null && this.lookaheadRoot != null) {
            LookaheadPassDelegate v2 = this.getLookaheadPassDelegate$ui();
            Intrinsics.checkNotNull(v2);
            return v2.remeasure-BRTryo0(arg3.unbox-impl());
        }

        return 0;
    }

    public static boolean lookaheadRemeasure-_Sx5XlM$ui$default(LayoutNode arg0, Constraints arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.layoutDelegate.getLastLookaheadConstraints-DWUhwKw();
        }

        return arg0.lookaheadRemeasure-_Sx5XlM$ui(arg1);
    }

    public final void lookaheadReplace$ui() {
        if(this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            this.clearSubtreePlacementIntrinsicsUsage();
        }

        LookaheadPassDelegate v2 = this.getLookaheadPassDelegate$ui();
        Intrinsics.checkNotNull(v2);
        v2.replace();
    }

    public final void markLayoutPending$ui() {
        this.layoutDelegate.markLayoutPending$ui();
    }

    public final void markLookaheadLayoutPending$ui() {
        this.layoutDelegate.markLookaheadLayoutPending$ui();
    }

    public final void markLookaheadMeasurePending$ui() {
        this.layoutDelegate.markLookaheadMeasurePending$ui();
    }

    public final void markMeasurePending$ui() {
        this.layoutDelegate.markMeasurePending$ui();
    }

    public final int maxIntrinsicHeight(int arg1) {
        return this.getOrCreateIntrinsicsPolicy().maxIntrinsicHeight(arg1);
    }

    public final int maxIntrinsicWidth(int arg1) {
        return this.getOrCreateIntrinsicsPolicy().maxIntrinsicWidth(arg1);
    }

    public final int maxLookaheadIntrinsicHeight(int arg1) {
        return this.getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicHeight(arg1);
    }

    public final int maxLookaheadIntrinsicWidth(int arg1) {
        return this.getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicWidth(arg1);
    }

    public final int minIntrinsicHeight(int arg1) {
        return this.getOrCreateIntrinsicsPolicy().minIntrinsicHeight(arg1);
    }

    public final int minIntrinsicWidth(int arg1) {
        return this.getOrCreateIntrinsicsPolicy().minIntrinsicWidth(arg1);
    }

    public final int minLookaheadIntrinsicHeight(int arg1) {
        return this.getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicHeight(arg1);
    }

    public final int minLookaheadIntrinsicWidth(int arg1) {
        return this.getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicWidth(arg1);
    }

    public final void move$ui(int arg5, int arg6, int arg7) {
        if(arg5 == arg6) {
            return;
        }

        int v0;
        for(v0 = 0; v0 < arg7; ++v0) {
            int v1 = arg5 > arg6 ? arg5 + v0 : arg5;
            int v2 = arg5 > arg6 ? arg6 + v0 : arg6 + arg7 - 2;
            this._foldedChildren.add(v2, this._foldedChildren.removeAt(v1));
        }

        this.onZSortedChildrenInvalidated$ui();
        this.invalidateUnfoldedVirtualChildren();
        this.invalidateMeasurements$ui();
    }

    private final void onChildRemoved(LayoutNode arg5) {
        if(arg5.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(this.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }

        if(this.owner != null) {
            arg5.detach$ui();
        }

        LayoutNode v0 = null;
        arg5._foldedParent = v0;
        if(arg5.globallyPositionedObservers > 0) {
            this.setGloballyPositionedObservers(this.globallyPositionedObservers - 1);
        }

        arg5.getOuterCoordinator$ui().setWrappedBy$ui(((NodeCoordinator)v0));
        if(arg5.isVirtual) {
            --this.virtualChildrenCount;
            MutableVector v5 = arg5._foldedChildren.getVector();
            Object[] v1 = v5.content;
            int v5_1 = v5.getSize();
            int v2;
            for(v2 = 0; v2 < v5_1; ++v2) {
                v1[v2].getOuterCoordinator$ui().setWrappedBy$ui(((NodeCoordinator)v0));
            }
        }

        this.invalidateUnfoldedVirtualChildren();
        this.onZSortedChildrenInvalidated$ui();
    }

    public final void onCoordinatorPositionChanged$ui() {
        this.outerToInnerOffsetDirty = true;
        Owner v0 = this.owner;
        if(v0 != null) {
            RectManager v0_1 = v0.getRectManager();
            if(v0_1 != null) {
                v0_1.invalidateCallbacksFor(this);
            }
        }
    }

    public void onDeactivate() {
        AndroidViewHolder v0 = this.interopViewFactoryHolder;
        if(v0 != null) {
            v0.onDeactivate();
        }

        LayoutNodeSubcompositionsState v0_1 = this.subcompositionsState;
        if(v0_1 != null) {
            v0_1.onDeactivate();
        }

        this.isDeactivated = true;
        this.resetModifierState();
        if(this.isAttached()) {
            if(!ComposeUiFlags.isSemanticAutofillEnabled) {
                this.invalidateSemantics$ui();
            }
            else {
                this._semanticsConfiguration = null;
                this.isSemanticsInvalidated = false;
            }
        }

        Owner v0_2 = this.owner;
        if(v0_2 != null) {
            v0_2.onLayoutNodeDeactivated(this);
        }
    }

    private final void onDensityOrLayoutDirectionChanged() {
        this.invalidateMeasurements$ui();
        LayoutNode v0 = this.getParent$ui();
        if(v0 != null) {
            v0.invalidateLayer$ui();
        }

        this.invalidateLayers$ui();
    }

    public void onLayoutComplete() {
        NodeCoordinator v0 = this.getInnerCoordinator$ui();
        int v1 = NodeKind.constructor-impl(0x400000);
        boolean v2 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(v1);
        Node v3 = v0.getTail();
        if(v2) {
            goto label_10;
        }
        else {
            v3 = v3.getParent$ui();
            if(v3 == null) {
            }
            else {
            label_10:
                Node v0_1;
                for(v0_1 = v0.headNode(v2); v0_1 != null; v0_1 = v0_1.getChild$ui()) {
                    if((v0_1.getAggregateChildKindSet$ui() & v1) == 0) {
                        return;
                    }

                    if((v0_1.getKindSet$ui() & v1) != 0) {
                        Node v2_1 = null;
                        Node v4 = v0_1;
                        MutableVector v5 = ((MutableVector)v2_1);
                        while(true) {
                        label_21:
                            if(v4 != null) {
                                if((v4 instanceof LayoutAwareModifierNode)) {
                                    ((LayoutAwareModifierNode)v4).onPlaced(this.getInnerCoordinator$ui());
                                }
                                else if((v4.getKindSet$ui() & v1) != 0 && ((v4 instanceof DelegatingNode))) {
                                    Node v6 = v4.getDelegate$ui();
                                    int v8 = 0;
                                    while(v6 != null) {
                                        if((v6.getKindSet$ui() & v1) != 0) {
                                            ++v8;
                                            if(v8 == 1) {
                                                v4 = v6;
                                            }
                                            else {
                                                if(v5 == null) {
                                                    v5 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v4 != null) {
                                                    if(v5 != null) {
                                                        v5.add(v4);
                                                    }

                                                    v4 = v2_1;
                                                }

                                                if(v5 == null) {
                                                    goto label_56;
                                                }

                                                v5.add(v6);
                                            }
                                        }

                                    label_56:
                                        v6 = v6.getChild$ui();
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

                        v4 = DelegatableNodeKt.pop(v5);
                        goto label_21;
                    }

                label_62:
                    if(v0_1 == v3) {
                        return;
                    }
                }
            }
        }
    }

    public void onRelease() {
        AndroidViewHolder v0 = this.interopViewFactoryHolder;
        if(v0 != null) {
            v0.onRelease();
        }

        LayoutNodeSubcompositionsState v0_1 = this.subcompositionsState;
        if(v0_1 != null) {
            v0_1.onRelease();
        }

        NodeCoordinator v0_2 = this.getOuterCoordinator$ui();
        NodeCoordinator v2 = this.getInnerCoordinator$ui().getWrapped$ui();
        while(!Intrinsics.areEqual(v0_2, v2)) {
            if(v0_2 == null) {
                return;
            }

            v0_2.onRelease();
            v0_2 = v0_2.getWrapped$ui();
        }
    }

    public void onReuse() {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("onReuse is only expected on attached node");
        }

        AndroidViewHolder v0 = this.interopViewFactoryHolder;
        if(v0 != null) {
            v0.onReuse();
        }

        LayoutNodeSubcompositionsState v0_1 = this.subcompositionsState;
        if(v0_1 != null) {
            v0_1.onReuse();
        }

        this.isCurrentlyCalculatingSemanticsConfiguration = false;
        if(this.isDeactivated()) {
            this.isDeactivated = false;
            if(!ComposeUiFlags.isSemanticAutofillEnabled) {
                this.invalidateSemantics$ui();
            }
        }
        else {
            this.resetModifierState();
        }

        int v0_2 = this.getSemanticsId();
        Owner v1 = this.owner;
        if(v1 != null) {
            RectManager v1_1 = v1.getRectManager();
            if(v1_1 != null) {
                v1_1.remove(this);
            }
        }

        this.setSemanticsId(SemanticsModifierKt.generateSemanticsId());
        v1 = this.owner;
        if(v1 != null) {
            v1.onPreLayoutNodeReused(this, v0_2);
        }

        this.nodes.markAsAttached();
        this.nodes.runAttachLifecycle();
        if((ComposeUiFlags.isSemanticAutofillEnabled) && (this.nodes.has-H91voCI$ui(NodeKind.constructor-impl(8)))) {
            this.invalidateSemantics$ui();
        }

        this.rescheduleRemeasureOrRelayout$ui(this);
        v1 = this.owner;
        if(v1 != null) {
            v1.onPostLayoutNodeReused(this, v0_2);
        }

        Owner v0_3 = this.owner;
        if(v0_3 != null) {
            RectManager v0_4 = v0_3.getRectManager();
            if(v0_4 != null) {
                v0_4.onLayoutPositionChanged(this, true);
            }
        }
    }

    public final void onZSortedChildrenInvalidated$ui() {
        if(this.isVirtual) {
            this = this.getParent$ui();
            if(this != null) {
                this.onZSortedChildrenInvalidated$ui();
            }

            return;
        }

        this.zSortedChildrenInvalidated = true;
    }

    public final void place$ui(int arg9, int arg10) {
        PlacementScope v0_2;
        if(this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            this.clearSubtreePlacementIntrinsicsUsage();
        }

        LayoutNode v0 = this.getParent$ui();
        if(v0 != null) {
            NodeCoordinator v0_1 = v0.getInnerCoordinator$ui();
            if(v0_1 != null) {
                v0_2 = v0_1.getPlacementScope();
                if(v0_2 == null) {
                    goto label_10;
                }
            }
            else {
                goto label_10;
            }
        }
        else {
        label_10:
            v0_2 = LayoutNodeKt.requireOwner(this).getPlacementScope();
        }

        PlacementScope.placeRelative$default(v0_2, this.getMeasurePassDelegate$ui(), arg9, arg10, 0f, 4, null);
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if(this.unfoldedVirtualChildrenListDirty) {
            int v0 = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector v1 = this._unfoldedChildren;
            if(v1 == null) {
                v1 = new MutableVector(new LayoutNode[16], 0);
                this._unfoldedChildren = v1;
            }

            v1.clear();
            MutableVector v2 = this._foldedChildren.getVector();
            Object[] v3 = v2.content;
            int v2_1 = v2.getSize();
            while(v0 < v2_1) {
                Object v4 = v3[v0];
                if(((LayoutNode)v4).isVirtual) {
                    v1.addAll(v1.getSize(), ((LayoutNode)v4).get_children$ui());
                }
                else {
                    v1.add(v4);
                }

                ++v0;
            }

            this.layoutDelegate.markChildrenDirty();
        }
    }

    public final boolean remeasure-_Sx5XlM$ui(Constraints arg3) {
        if(arg3 != null) {
            if(this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
                this.clearSubtreeIntrinsicsUsage$ui();
            }

            return this.getMeasurePassDelegate$ui().remeasure-BRTryo0(arg3.unbox-impl());
        }

        return 0;
    }

    public static boolean remeasure-_Sx5XlM$ui$default(LayoutNode arg0, Constraints arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.layoutDelegate.getLastConstraints-DWUhwKw();
        }

        return arg0.remeasure-_Sx5XlM$ui(arg1);
    }

    public final void removeAll$ui() {
        MutableVectorWithMutationTracking v1;
        int v0;
        for(v0 = this._foldedChildren.getVector().getSize() - 1; true; --v0) {
            v1 = this._foldedChildren;
            if(-1 >= v0) {
                break;
            }

            this.onChildRemoved(v1.getVector().content[v0]);
        }

        v1.clear();
    }

    public final void removeAt$ui(int arg4, int arg5) {
        int v1 = arg5 >= 0 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("count (" + arg5 + ") must be greater than 0");
        }

        arg5 = arg5 + arg4 - 1;
        if(arg4 <= arg5) {
            while(true) {
                this.onChildRemoved(this._foldedChildren.getVector().content[arg5]);
                this._foldedChildren.removeAt(arg5);
                if(arg5 != arg4) {
                    --arg5;
                    continue;
                }

                return;
            }
        }
    }

    public final void replace$ui() {
        if(this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            this.clearSubtreePlacementIntrinsicsUsage();
        }

        this.getMeasurePassDelegate$ui().replace();
    }

    public final void requestAutofill$ui() {
        if(this.isCurrentlyCalculatingSemanticsConfiguration) {
            return;
        }

        LayoutNodeKt.requireOwner(this).requestAutofill(this);
    }

    public final void requestLookaheadRelayout$ui(boolean arg3) {
        if(!this.isVirtual) {
            Owner v0 = this.owner;
            if(v0 != null) {
                v0.onRequestRelayout(this, true, arg3);
            }
        }
    }

    public static void requestLookaheadRelayout$ui$default(LayoutNode arg0, boolean arg1, int arg2, Object arg3) {
        arg0.requestLookaheadRelayout$ui(false);
    }

    public final void requestLookaheadRemeasure$ui(boolean arg4, boolean arg5, boolean arg6) {
        int v0 = this.lookaheadRoot != null ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Lookahead measure cannot be requested on a node that is not a part of the LookaheadScope");
        }

        Owner v0_1 = this.owner;
        if(v0_1 == null) {
        }
        else if(!this.ignoreRemeasureRequests && !this.isVirtual) {
            v0_1.onRequestMeasure(this, true, arg4, arg5);
            if(arg6) {
                LookaheadPassDelegate v3 = this.getLookaheadPassDelegate$ui();
                Intrinsics.checkNotNull(v3);
                v3.invalidateIntrinsicsParent(arg4);
            }
        }
    }

    public static void requestLookaheadRemeasure$ui$default(LayoutNode arg1, boolean arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        arg1.requestLookaheadRemeasure$ui(false, true, true);
    }

    public final void requestRelayout$ui(boolean arg8) {
        if(!this.isVirtual) {
            Owner v1 = this.owner;
            if(v1 != null) {
                Owner.onRequestRelayout$default(v1, this, false, arg8, 2, null);
            }
        }
    }

    public static void requestRelayout$ui$default(LayoutNode arg0, boolean arg1, int arg2, Object arg3) {
        arg0.requestRelayout$ui(false);
    }

    public final void requestRemeasure$ui(boolean arg9, boolean arg10, boolean arg11) {
        if(!this.ignoreRemeasureRequests && !this.isVirtual) {
            Owner v1 = this.owner;
            if(v1 == null) {
            }
            else {
                LayoutNode v2 = this;
                boolean v4 = arg9;
                Owner.onRequestMeasure$default(v1, v2, false, v4, arg10, 2, null);
                if(arg11) {
                    v2.getMeasurePassDelegate$ui().invalidateIntrinsicsParent(v4);
                }
            }
        }
    }

    public static void requestRemeasure$ui$default(LayoutNode arg1, boolean arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        arg1.requestRemeasure$ui(false, true, true);
    }

    public final void rescheduleRemeasureOrRelayout$ui(LayoutNode arg14) {
        if(WhenMappings.$EnumSwitchMapping$0[arg14.getLayoutState$ui().ordinal()] == 1) {
            if(arg14.getLookaheadMeasurePending$ui()) {
                LayoutNode.requestLookaheadRemeasure$ui$default(arg14, true, false, false, 6, null);
                return;
            }

            LayoutNode v1 = arg14;
            if(v1.getLookaheadLayoutPending$ui()) {
                v1.requestLookaheadRelayout$ui(true);
            }

            if(v1.getMeasurePending$ui()) {
                LayoutNode.requestRemeasure$ui$default(v1, true, false, false, 6, null);
                return;
            }

            if(v1.getLayoutPending$ui()) {
                v1.requestRelayout$ui(true);
            }

            return;
        }

        throw new IllegalStateException("Unexpected state " + arg14.getLayoutState$ui());
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui();
    }

    public final void resetSubtreeIntrinsicsUsage$ui() {
        MutableVector v5 = this.get_children$ui();
        Object[] v0 = v5.content;
        int v5_1 = v5.getSize();
        int v1;
        for(v1 = 0; v1 < v5_1; ++v1) {
            Object v2 = v0[v1];
            UsageByParent v3 = ((LayoutNode)v2).previousIntrinsicsUsageByParent;
            ((LayoutNode)v2).intrinsicsUsageByParent = v3;
            if(v3 != UsageByParent.NotUsed) {
                ((LayoutNode)v2).resetSubtreeIntrinsicsUsage$ui();
            }
        }
    }

    public final Void rethrowWithComposeStackTrace(Throwable arg2) {
        CompositionErrorContext v0 = this.getTraceContext();
        if(v0 != null) {
            v0.attachComposeStackTrace(arg2, this);
        }

        throw arg2;
    }

    public final void setAddedToRectList$ui(boolean arg1) {
        this.addedToRectList = arg1;
    }

    public final void setCanMultiMeasure$ui(boolean arg1) {
        this.canMultiMeasure = arg1;
    }

    public void setCompositeKeyHash(int arg1) {
        this.compositeKeyHash = arg1;
    }

    public void setCompositionLocalMap(CompositionLocalMap arg9) {
        this.compositionLocalMap = arg9;
        this.setDensity(arg9.get(CompositionLocalsKt.getLocalDensity()));
        this.setLayoutDirection(arg9.get(CompositionLocalsKt.getLocalLayoutDirection()));
        this.setViewConfiguration(arg9.get(CompositionLocalsKt.getLocalViewConfiguration()));
        NodeChain v8 = this.nodes;
        int v9 = NodeKind.constructor-impl(0x8000);
        if((NodeChain.access$getAggregateChildKindSet(v8) & v9) != 0) {
            Node v8_1;
            for(v8_1 = v8.getHead$ui(); v8_1 != null; v8_1 = v8_1.getChild$ui()) {
                if((v8_1.getKindSet$ui() & v9) != 0) {
                    Node v0 = null;
                    Node v1 = v8_1;
                    MutableVector v2 = ((MutableVector)v0);
                    while(true) {
                    label_24:
                        if(v1 != null) {
                            if((v1 instanceof CompositionLocalConsumerModifierNode)) {
                                v1 = ((CompositionLocalConsumerModifierNode)v1).getNode();
                                if(v1.isAttached()) {
                                    NodeKindKt.autoInvalidateUpdatedNode(v1);
                                }
                                else {
                                    v1.setUpdatedNodeAwaitingAttachForInvalidation$ui(true);
                                }
                            }
                            else if((v1.getKindSet$ui() & v9) != 0 && ((v1 instanceof DelegatingNode))) {
                                Node v3 = v1.getDelegate$ui();
                                int v6 = 0;
                                while(v3 != null) {
                                    if((v3.getKindSet$ui() & v9) != 0) {
                                        ++v6;
                                        if(v6 == 1) {
                                            v1 = v3;
                                        }
                                        else {
                                            if(v2 == null) {
                                                v2 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v1 != null) {
                                                if(v2 != null) {
                                                    v2.add(v1);
                                                }

                                                v1 = v0;
                                            }

                                            if(v2 == null) {
                                                goto label_63;
                                            }

                                            v2.add(v3);
                                        }
                                    }

                                label_63:
                                    v3 = v3.getChild$ui();
                                }

                                if(v6 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_69;
                    }

                    v1 = DelegatableNodeKt.pop(v2);
                    goto label_24;
                }

            label_69:
                if((v8_1.getAggregateChildKindSet$ui() & v9) == 0) {
                    return;
                }
            }
        }
    }

    public void setDensity(Density arg2) {
        if(!Intrinsics.areEqual(this.density, arg2)) {
            this.density = arg2;
            this.onDensityOrLayoutDirectionChanged();
            Node v1;
            for(v1 = this.nodes.getHead$ui(); v1 != null; v1 = v1.getChild$ui()) {
                v1.onDensityChange();
            }
        }
    }

    public final void setDepth$ui(int arg1) {
        this.depth = arg1;
    }

    public final void setGloballyPositionedObservers(int arg3) {
        LayoutNode v0_1;
        int v0 = this.globallyPositionedObservers;
        if(v0 != arg3) {
            if(arg3 > 0 && v0 == 0) {
                v0_1 = this.getParent$ui();
                if(v0_1 != null) {
                    v0_1.setGloballyPositionedObservers(v0_1.globallyPositionedObservers + 1);
                }
            }

            if(arg3 == 0 && this.globallyPositionedObservers > 0) {
                v0_1 = this.getParent$ui();
                if(v0_1 != null) {
                    v0_1.setGloballyPositionedObservers(v0_1.globallyPositionedObservers - 1);
                }
            }

            this.globallyPositionedObservers = arg3;
        }
    }

    public final void setHasPositionalLayerTransformationsInOffsetFromRoot$ui(boolean arg1) {
        this.hasPositionalLayerTransformationsInOffsetFromRoot = arg1;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui(boolean arg1) {
        this.innerLayerCoordinatorIsDirty = arg1;
    }

    public final void setInteropViewFactoryHolder$ui(AndroidViewHolder arg1) {
        this.interopViewFactoryHolder = arg1;
    }

    public final void setIntrinsicsUsageByParent$ui(UsageByParent arg1) {
        this.intrinsicsUsageByParent = arg1;
    }

    public final void setLastOffsetFromParent--gyyYBs$ui(long arg1) {
        this.lastOffsetFromParent = arg1;
    }

    public final void setLastSize-ozmzZPI$ui(long arg1) {
        this.lastSize = arg1;
    }

    public void setLayoutDirection(LayoutDirection arg2) {
        if(this.layoutDirection != arg2) {
            this.layoutDirection = arg2;
            this.onDensityOrLayoutDirectionChanged();
            Node v1;
            for(v1 = this.nodes.getHead$ui(); v1 != null; v1 = v1.getChild$ui()) {
                v1.onLayoutDirectionChange();
            }
        }
    }

    private final void setLookaheadRoot(LayoutNode arg3) {
        if(!Intrinsics.areEqual(arg3, this.lookaheadRoot)) {
            this.lookaheadRoot = arg3;
            LayoutNodeLayoutDelegate v0 = this.layoutDelegate;
            if(arg3 != null) {
                v0.ensureLookaheadDelegateCreated$ui();
                NodeCoordinator v3 = this.getOuterCoordinator$ui();
                NodeCoordinator v0_1 = this.getInnerCoordinator$ui().getWrapped$ui();
                while(!Intrinsics.areEqual(v3, v0_1)) {
                    if(v3 == null) {
                        break;
                    }

                    v3.ensureLookaheadDelegateCreated();
                    v3 = v3.getWrapped$ui();
                }
            }
            else {
                v0.onRemovedFromLookaheadScope();
            }

            this.invalidateMeasurements$ui();
        }
    }

    public void setMeasurePolicy(MeasurePolicy arg2) {
        if(!Intrinsics.areEqual(this.measurePolicy, arg2)) {
            this.measurePolicy = arg2;
            IntrinsicsPolicy v2 = this.intrinsicsPolicy;
            if(v2 != null) {
                v2.updateFrom(this.getMeasurePolicy());
            }

            this.invalidateMeasurements$ui();
        }
    }

    public void setModifier(Modifier arg3) {
        int v0 = !this.isVirtual || this.getModifier() == Modifier.Companion ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Modifiers are not supported on virtual LayoutNodes");
        }

        if(this.isDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("modifier is updated when deactivated");
        }

        if(this.isAttached()) {
            this.applyModifier(arg3);
            if(this.isSemanticsInvalidated) {
                this.invalidateSemantics$ui();
            }

            return;
        }

        this.pendingModifier = arg3;
    }

    public final void setNeedsOnGloballyPositionedDispatch$ui(boolean arg1) {
        this.needsOnGloballyPositionedDispatch = arg1;
    }

    public final void setOnAttach$ui(Function1 arg1) {
        this.onAttach = arg1;
    }

    public final void setOnDetach$ui(Function1 arg1) {
        this.onDetach = arg1;
    }

    public final void setOuterToInnerOffset--gyyYBs$ui(long arg1) {
        this.outerToInnerOffset = arg1;
    }

    public final void setOuterToInnerOffsetDirty$ui(boolean arg1) {
        this.outerToInnerOffsetDirty = arg1;
    }

    public void setSemanticsId(int arg1) {
        this.semanticsId = arg1;
    }

    public final void setSemanticsInvalidated$ui(boolean arg1) {
        this.isSemanticsInvalidated = arg1;
    }

    public final void setSubcompositionsState$ui(LayoutNodeSubcompositionsState arg1) {
        this.subcompositionsState = arg1;
    }

    public void setViewConfiguration(ViewConfiguration arg10) {
        if(!Intrinsics.areEqual(this.viewConfiguration, arg10)) {
            this.viewConfiguration = arg10;
            NodeChain v9 = this.nodes;
            int v10 = 16;
            int v0 = NodeKind.constructor-impl(v10);
            if((NodeChain.access$getAggregateChildKindSet(v9) & v0) != 0) {
                Node v9_1;
                for(v9_1 = v9.getHead$ui(); v9_1 != null; v9_1 = v9_1.getChild$ui()) {
                    if((v9_1.getKindSet$ui() & v0) != 0) {
                        Node v1 = null;
                        Node v2 = v9_1;
                        MutableVector v3 = ((MutableVector)v1);
                        while(true) {
                        label_18:
                            if(v2 != null) {
                                if((v2 instanceof PointerInputModifierNode)) {
                                    ((PointerInputModifierNode)v2).onViewConfigurationChange();
                                }
                                else if((v2.getKindSet$ui() & v0) != 0 && ((v2 instanceof DelegatingNode))) {
                                    Node v4 = v2.getDelegate$ui();
                                    int v6 = 0;
                                    while(v4 != null) {
                                        if((v4.getKindSet$ui() & v0) != 0) {
                                            ++v6;
                                            if(v6 == 1) {
                                                v2 = v4;
                                            }
                                            else {
                                                if(v3 == null) {
                                                    v3 = new MutableVector(new Node[v10], 0);
                                                }

                                                if(v2 != null) {
                                                    if(v3 != null) {
                                                        v3.add(v2);
                                                    }

                                                    v2 = v1;
                                                }

                                                if(v3 == null) {
                                                    goto label_51;
                                                }

                                                v3.add(v4);
                                            }
                                        }

                                    label_51:
                                        v4 = v4.getChild$ui();
                                    }

                                    if(v6 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_57;
                        }

                        v2 = DelegatableNodeKt.pop(v3);
                        goto label_18;
                    }

                label_57:
                    if((v9_1.getAggregateChildKindSet$ui() & v0) == 0) {
                        return;
                    }
                }
            }
        }
    }

    public final void setVirtualLookaheadRoot$ui(boolean arg1) {
        this.isVirtualLookaheadRoot = arg1;
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + this.getChildren$ui().size() + " measurePolicy: " + this.getMeasurePolicy() + " deactivated: " + this.isDeactivated();
    }

    public final void updateChildrenIfDirty$ui() {
        if(this.virtualChildrenCount > 0) {
            this.recreateUnfoldedChildrenIfDirty();
        }
    }
}

