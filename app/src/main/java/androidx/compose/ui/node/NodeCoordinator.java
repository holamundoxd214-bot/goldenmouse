package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.FrameRateCategory;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000À\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\b\u001C\b!\u0018\u0000 Ç\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004Æ\u0002Ç\u0002B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u00103\u001A\u0004\u0018\u00010\u00152\u0006\u00104\u001A\u00020\fH\u0002J-\u00105\u001A\u0002062\u0006\u00107\u001A\u0002082\u0006\u00104\u001A\u00020\f2\u0012\u00109\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002060:H\u0086\bJ:\u00105\u001A\u000206\"\u0006\b\u0000\u0010;\u0018\u00012\f\u0010<\u001A\b\u0012\u0004\u0012\u0002H;0=2\u0012\u00109\u001A\u000E\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u0002060:H\u0086\b¢\u0006\u0004\b>\u0010?J\u001B\u0010@\u001A\u00020\f2\n\u0010<\u001A\u0006\u0012\u0002\b\u00030=H\u0002¢\u0006\u0004\bA\u0010BJ\u001B\u0010C\u001A\u0004\u0018\u00010\u00152\n\u0010<\u001A\u0006\u0012\u0002\b\u00030=¢\u0006\u0004\bD\u0010EJ\u0006\u0010U\u001A\u00020\fJ\r\u0010\\\u001A\u000206H\u0010¢\u0006\u0002\b]J\b\u0010q\u001A\u000206H&J\u0018\u0010v\u001A\u0002062\u0006\u0010w\u001A\u0002082\u0006\u0010x\u001A\u000208H\u0014J\u000F\u0010\u0087\u0001\u001A\u000206H\u0000¢\u0006\u0003\b\u0088\u0001J0\u0010§\u0001\u001A\u00030¨\u00012\b\u0010©\u0001\u001A\u00030\u0099\u00012\u0010\b\u0004\u00109\u001A\n\u0012\u0005\u0012\u00030¨\u00010ª\u0001H\u0084\b¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0007\u0010­\u0001\u001A\u000206J\u0007\u0010®\u0001\u001A\u000206J=\u0010¯\u0001\u001A\u0002062\u0006\u0010z\u001A\u00020y2\u0006\u0010\u007F\u001A\u00020%2\u0019\u0010N\u001A\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bMH\u0014¢\u0006\u0006\b°\u0001\u0010±\u0001J,\u0010¯\u0001\u001A\u0002062\u0006\u0010z\u001A\u00020y2\u0006\u0010\u007F\u001A\u00020%2\b\u0010²\u0001\u001A\u00030³\u0001H\u0014¢\u0006\u0006\b°\u0001\u0010´\u0001JI\u0010µ\u0001\u001A\u0002062\u0006\u0010z\u001A\u00020y2\u0006\u0010\u007F\u001A\u00020%2\u0019\u0010N\u001A\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM2\n\u0010¶\u0001\u001A\u0005\u0018\u00010³\u0001H\u0002¢\u0006\u0006\b·\u0001\u0010¸\u0001J\u0007\u0010¹\u0001\u001A\u000206JG\u0010º\u0001\u001A\u0002062\u0006\u0010z\u001A\u00020y2\u0006\u0010\u007F\u001A\u00020%2\u0019\u0010N\u001A\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM2\n\u0010²\u0001\u001A\u0005\u0018\u00010³\u0001¢\u0006\u0006\b»\u0001\u0010¸\u0001J\u001D\u0010¼\u0001\u001A\u0002062\b\u0010½\u0001\u001A\u00030¾\u00012\n\u0010¿\u0001\u001A\u0005\u0018\u00010³\u0001J\u001F\u0010À\u0001\u001A\u0002062\b\u0010½\u0001\u001A\u00030¾\u00012\n\u0010¿\u0001\u001A\u0005\u0018\u00010³\u0001H\u0002J\u001F\u0010Á\u0001\u001A\u0002062\b\u0010½\u0001\u001A\u00030¾\u00012\n\u0010¿\u0001\u001A\u0005\u0018\u00010³\u0001H\u0016J\u0007\u0010Â\u0001\u001A\u000206J-\u0010Ê\u0001\u001A\u0002062\u0019\u0010N\u001A\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM2\t\b\u0002\u0010Ë\u0001\u001A\u00020\fJ\u0014\u0010Ì\u0001\u001A\u0002062\t\b\u0002\u0010Í\u0001\u001A\u00020\fH\u0002JA\u0010Ø\u0001\u001A\u0002062\b\u0010Ù\u0001\u001A\u00030Ú\u00012\b\u0010Û\u0001\u001A\u00030Ü\u00012\b\u0010Ý\u0001\u001A\u00030Þ\u00012\b\u0010ß\u0001\u001A\u00030à\u00012\u0007\u0010á\u0001\u001A\u00020\f¢\u0006\u0006\bâ\u0001\u0010ã\u0001JI\u0010ä\u0001\u001A\u000206*\u0004\u0018\u00010\u00152\b\u0010Ù\u0001\u001A\u00030Ú\u00012\b\u0010Û\u0001\u001A\u00030Ü\u00012\b\u0010Ý\u0001\u001A\u00030Þ\u00012\b\u0010ß\u0001\u001A\u00030à\u00012\u0007\u0010á\u0001\u001A\u00020\fH\u0002¢\u0006\u0006\bå\u0001\u0010æ\u0001J[\u0010ç\u0001\u001A\u000206*\u0004\u0018\u00010\u00152\b\u0010Ù\u0001\u001A\u00030Ú\u00012\b\u0010Û\u0001\u001A\u00030Ü\u00012\b\u0010Ý\u0001\u001A\u00030Þ\u00012\b\u0010ß\u0001\u001A\u00030à\u00012\u0007\u0010á\u0001\u001A\u00020\f2\u0007\u0010è\u0001\u001A\u00020%2\u0007\u0010é\u0001\u001A\u00020\fH\u0002¢\u0006\u0006\bê\u0001\u0010ë\u0001JR\u0010ì\u0001\u001A\u000206*\u0004\u0018\u00010\u00152\b\u0010Ù\u0001\u001A\u00030Ú\u00012\b\u0010Û\u0001\u001A\u00030Ü\u00012\b\u0010Ý\u0001\u001A\u00030Þ\u00012\b\u0010ß\u0001\u001A\u00030à\u00012\u0007\u0010á\u0001\u001A\u00020\f2\u0007\u0010è\u0001\u001A\u00020%H\u0002¢\u0006\u0006\bí\u0001\u0010î\u0001JR\u0010ï\u0001\u001A\u000206*\u0004\u0018\u00010\u00152\b\u0010Ù\u0001\u001A\u00030Ú\u00012\b\u0010Û\u0001\u001A\u00030Ü\u00012\b\u0010Ý\u0001\u001A\u00030Þ\u00012\b\u0010ß\u0001\u001A\u00030à\u00012\u0007\u0010á\u0001\u001A\u00020\f2\u0007\u0010è\u0001\u001A\u00020%H\u0002¢\u0006\u0006\bð\u0001\u0010î\u0001J,\u0010ñ\u0001\u001A\u00020\f*\u0004\u0018\u00010\u00152\b\u0010Û\u0001\u001A\u00030Ü\u00012\b\u0010ß\u0001\u001A\u00030à\u0001H\u0002¢\u0006\u0006\bò\u0001\u0010ó\u0001JC\u0010ô\u0001\u001A\u0002062\b\u0010Ù\u0001\u001A\u00030Ú\u00012\b\u0010Û\u0001\u001A\u00030Ü\u00012\b\u0010Ý\u0001\u001A\u00030Þ\u00012\b\u0010ß\u0001\u001A\u00030à\u00012\u0007\u0010á\u0001\u001A\u00020\fH\u0016¢\u0006\u0006\bõ\u0001\u0010ã\u0001J\b\u0010ö\u0001\u001A\u00030÷\u0001J\u001D\u0010ø\u0001\u001A\u00030Ü\u00012\b\u0010ù\u0001\u001A\u00030Ü\u0001H\u0016¢\u0006\u0006\bú\u0001\u0010û\u0001J\u001D\u0010ü\u0001\u001A\u00030Ü\u00012\b\u0010ý\u0001\u001A\u00030Ü\u0001H\u0016¢\u0006\u0006\bþ\u0001\u0010û\u0001J\u001D\u0010ÿ\u0001\u001A\u00030Ü\u00012\b\u0010\u0080\u0002\u001A\u00030Ü\u0001H\u0016¢\u0006\u0006\b\u0081\u0002\u0010û\u0001J\u001D\u0010\u0082\u0002\u001A\u00030Ü\u00012\b\u0010ý\u0001\u001A\u00030Ü\u0001H\u0016¢\u0006\u0006\b\u0083\u0002\u0010û\u0001J\r\u0010\u0084\u0002\u001A\u00020\u0000*\u00020\u0003H\u0002J&\u0010\u0085\u0002\u001A\u00030Ü\u00012\u0007\u0010\u0086\u0002\u001A\u00020\u00032\b\u0010\u0087\u0002\u001A\u00030Ü\u0001H\u0016¢\u0006\u0006\b\u0088\u0002\u0010\u0089\u0002J/\u0010\u0085\u0002\u001A\u00030Ü\u00012\u0007\u0010\u0086\u0002\u001A\u00020\u00032\b\u0010\u0087\u0002\u001A\u00030Ü\u00012\u0007\u0010\u008A\u0002\u001A\u00020\fH\u0016¢\u0006\u0006\b\u008B\u0002\u0010\u008C\u0002J%\u0010\u008D\u0002\u001A\u0002062\u0007\u0010\u0086\u0002\u001A\u00020\u00032\b\u0010\u008E\u0002\u001A\u00030\u008F\u0002H\u0016¢\u0006\u0006\b\u0090\u0002\u0010\u0091\u0002J\u001C\u0010\u0092\u0002\u001A\u0002062\b\u0010\u008E\u0002\u001A\u00030\u008F\u0002H\u0016¢\u0006\u0006\b\u0093\u0002\u0010\u0094\u0002J%\u0010\u0095\u0002\u001A\u0002062\u0007\u0010\u0096\u0002\u001A\u00020\u00002\b\u0010\u008E\u0002\u001A\u00030\u008F\u0002H\u0002¢\u0006\u0006\b\u0097\u0002\u0010\u0098\u0002J%\u0010\u0099\u0002\u001A\u0002062\u0007\u0010\u0096\u0002\u001A\u00020\u00002\b\u0010\u008E\u0002\u001A\u00030\u008F\u0002H\u0002¢\u0006\u0006\b\u009A\u0002\u0010\u0098\u0002J\u001C\u0010\u009B\u0002\u001A\u00030÷\u00012\u0007\u0010\u0086\u0002\u001A\u00020\u00032\u0007\u0010\u009C\u0002\u001A\u00020\fH\u0016J/\u0010\u009D\u0002\u001A\u00030Ü\u00012\u0007\u0010\u0096\u0002\u001A\u00020\u00002\b\u0010\u009E\u0002\u001A\u00030Ü\u00012\u0007\u0010\u008A\u0002\u001A\u00020\fH\u0002¢\u0006\u0006\b\u009F\u0002\u0010 \u0002J%\u0010\u009D\u0002\u001A\u0002062\u0007\u0010\u0096\u0002\u001A\u00020\u00002\b\u0010¡\u0002\u001A\u00030\u008E\u00012\u0007\u0010\u009C\u0002\u001A\u00020\fH\u0002J\u001D\u0010¢\u0002\u001A\u00030Ü\u00012\b\u0010ý\u0001\u001A\u00030Ü\u0001H\u0016¢\u0006\u0006\b£\u0002\u0010û\u0001J)\u0010¤\u0002\u001A\u0002062\b\u0010½\u0001\u001A\u00030¾\u00012\u0013\u00109\u001A\u000F\u0012\u0005\u0012\u00030¾\u0001\u0012\u0004\u0012\u0002060:H\u0084\bJ\'\u0010¥\u0002\u001A\u00030Ü\u00012\u0007\u0010z\u001A\u00030Ü\u00012\t\b\u0002\u0010\u008A\u0002\u001A\u00020\fH\u0016¢\u0006\u0006\b¦\u0002\u0010§\u0002J\'\u0010¨\u0002\u001A\u00030Ü\u00012\u0007\u0010z\u001A\u00030Ü\u00012\t\b\u0002\u0010\u008A\u0002\u001A\u00020\fH\u0016¢\u0006\u0006\b©\u0002\u0010§\u0002J\u001D\u0010ª\u0002\u001A\u0002062\b\u0010½\u0001\u001A\u00030¾\u00012\b\u0010«\u0002\u001A\u00030¬\u0002H\u0004J\u0007\u0010­\u0002\u001A\u000206J\u0007\u0010®\u0002\u001A\u000206J-\u0010¯\u0002\u001A\u0002062\b\u0010°\u0002\u001A\u00030\u008E\u00012\u0007\u0010\u009C\u0002\u001A\u00020\f2\t\b\u0002\u0010±\u0002\u001A\u00020\fH\u0000¢\u0006\u0003\b²\u0002J\u001C\u0010³\u0002\u001A\u0002062\b\u0010°\u0002\u001A\u00030\u008E\u00012\u0007\u0010\u009C\u0002\u001A\u00020\fH\u0002J\u001C\u0010´\u0002\u001A\u00020\f2\b\u0010Û\u0001\u001A\u00030Ü\u0001H\u0004¢\u0006\u0006\bµ\u0002\u0010¶\u0002J\u001C\u0010·\u0002\u001A\u00020\f2\b\u0010Û\u0001\u001A\u00030Ü\u0001H\u0004¢\u0006\u0006\b¸\u0002\u0010¶\u0002J\t\u0010¹\u0002\u001A\u000206H\u0016J\t\u0010º\u0002\u001A\u000206H\u0016J\u0018\u0010»\u0002\u001A\u00020\u00002\u0007\u0010¼\u0002\u001A\u00020\u0000H\u0000¢\u0006\u0003\b½\u0002J\u0007\u0010¾\u0002\u001A\u00020\fJ\u001D\u0010¿\u0002\u001A\u00030Ü\u00012\b\u0010Û\u0001\u001A\u00030Ü\u0001H\u0002¢\u0006\u0006\bÀ\u0002\u0010û\u0001J\u001D\u0010Á\u0002\u001A\u00030Ö\u00012\b\u0010Õ\u0001\u001A\u00030Ö\u0001H\u0004¢\u0006\u0006\bÂ\u0002\u0010û\u0001J&\u0010Ã\u0002\u001A\u00020%2\b\u0010Û\u0001\u001A\u00030Ü\u00012\b\u0010Õ\u0001\u001A\u00030Ö\u0001H\u0004¢\u0006\u0006\bÄ\u0002\u0010Å\u0002R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001A\u0010\u000B\u001A\u00020\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0014\u001A\u00020\u0015X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u001C\u0010\u0018\u001A\u0004\u0018\u00010\u0000X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001C\u0010\u001D\u001A\u0004\u0018\u00010\u0000X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001CR\u0014\u0010 \u001A\u00020!8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020%8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020%8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b)\u0010\'R\u0016\u0010*\u001A\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b+\u0010,R\u0014\u0010-\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b.\u0010/R\u0014\u00100\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b1\u0010\u000ER\u000E\u00102\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010F\u001A\u00020G8F¢\u0006\u0006\u001A\u0004\bH\u0010IR\u000E\u0010J\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000RD\u0010N\u001A\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM2\u0019\u0010K\u001A\u0015\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000206\u0018\u00010:¢\u0006\u0002\bM@BX\u0084\u000E¢\u0006\b\n\u0000\u001A\u0004\bO\u0010PR\u000E\u0010Q\u001A\u00020RX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010S\u001A\u00020!X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010T\u001A\u00020%X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010V\u001A\u00020W8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bX\u0010YR\u0016\u0010Z\u001A\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b[\u0010,R\u0014\u0010^\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b_\u0010\u000ER\u0014\u0010`\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b`\u0010\u000ER\u0010\u0010a\u001A\u0004\u0018\u00010bX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010c\u001A\u00020b2\u0006\u0010K\u001A\u00020b8P@PX\u0090\u000E¢\u0006\f\u001A\u0004\bd\u0010e\"\u0004\bf\u0010gR&\u0010i\u001A\u0004\u0018\u00010h2\b\u0010K\u001A\u0004\u0018\u00010h@dX¦\u000E¢\u0006\f\u001A\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010n\u001A\n\u0012\u0004\u0012\u00020p\u0018\u00010oX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010r\u001A\b\u0012\u0004\u0012\u00020p0s8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bt\u0010uR&\u0010z\u001A\u00020y2\u0006\u0010K\u001A\u00020y@TX\u0096\u000E¢\u0006\u0010\n\u0002\u0010~\u001A\u0004\b{\u0010I\"\u0004\b|\u0010}R\'\u0010\u007F\u001A\u00020%2\u0006\u0010K\u001A\u00020%@DX\u0086\u000E¢\u0006\u0011\n\u0000\u001A\u0005\b\u0080\u0001\u0010\'\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001A\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0084\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0015\u0010\u0089\u0001\u001A\u0004\u0018\u00010\u00038F¢\u0006\u0007\u001A\u0005\b\u008A\u0001\u0010/R\u0015\u0010\u008B\u0001\u001A\u0004\u0018\u00010\u00038F¢\u0006\u0007\u001A\u0005\b\u008C\u0001\u0010/R\u0012\u0010\u008D\u0001\u001A\u0005\u0018\u00010\u008E\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u008F\u0001\u001A\u00030\u008E\u00018DX\u0084\u0004¢\u0006\b\u001A\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0092\u0001\u001A\u00030\u0093\u00018BX\u0082\u0004¢\u0006\b\u001A\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0012\u0010\u0096\u0001\u001A\u0005\u0018\u00010\u0097\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0017\u0010\u0098\u0001\u001A\u00030\u0099\u00018@X\u0080\u0004¢\u0006\u0007\u001A\u0005\b\u009A\u0001\u0010IR \u0010\u009B\u0001\u001A\u00030\u009C\u0001X\u0080\u000E¢\u0006\u0012\n\u0000\u001A\u0006\b\u009D\u0001\u0010\u009E\u0001\"\u0006\b\u009F\u0001\u0010 \u0001R\u001D\u0010¡\u0001\u001A\u00020\fX\u0080\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b¢\u0001\u0010\u000E\"\u0005\b£\u0001\u0010\u0010R\u001D\u0010¤\u0001\u001A\u00020\fX\u0080\u000E¢\u0006\u0010\n\u0000\u001A\u0005\b¥\u0001\u0010\u000E\"\u0005\b¦\u0001\u0010\u0010R\u0012\u0010Ã\u0001\u001A\u0005\u0018\u00010³\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010Ä\u0001\u001A\u0005\u0018\u00010¾\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R(\u0010Å\u0001\u001A\u001B\u0012\u0005\u0012\u00030¾\u0001\u0012\u0007\u0012\u0005\u0018\u00010³\u0001\u0012\u0004\u0012\u000206\u0018\u00010Æ\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R.\u0010Ç\u0001\u001A\u0019\u0012\u0005\u0012\u00030¾\u0001\u0012\u0007\u0012\u0005\u0018\u00010³\u0001\u0012\u0004\u0012\u0002060Æ\u00018BX\u0082\u0004¢\u0006\b\u001A\u0006\bÈ\u0001\u0010É\u0001R\u0016\u0010Î\u0001\u001A\t\u0012\u0004\u0012\u0002060ª\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010Ï\u0001\u001A\u00020\f2\u0006\u0010K\u001A\u00020\f@BX\u0080\u000E¢\u0006\t\n\u0000\u001A\u0005\bÐ\u0001\u0010\u000ER\'\u0010²\u0001\u001A\u0005\u0018\u00010Ñ\u00012\t\u0010K\u001A\u0005\u0018\u00010Ñ\u0001@BX\u0086\u000E¢\u0006\n\n\u0000\u001A\u0006\bÒ\u0001\u0010Ó\u0001R\u0012\u0010¶\u0001\u001A\u0005\u0018\u00010³\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010Ô\u0001\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\bÔ\u0001\u0010\u000ER\u0014\u0010Õ\u0001\u001A\u00030Ö\u00018F¢\u0006\u0007\u001A\u0005\b×\u0001\u0010I¨\u0006È\u0002"}, d2={"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "forcePlaceWithLookaheadOffset", "", "getForcePlaceWithLookaheadOffset$ui", "()Z", "setForcePlaceWithLookaheadOffset$ui", "(Z)V", "forceMeasureWithLookaheadConstraints", "getForceMeasureWithLookaheadConstraints$ui", "setForceMeasureWithLookaheadConstraints$ui", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui", "setWrappedBy$ui", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "parent", "getParent", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "introducesMotionFrameOfReference", "getIntroducesMotionFrameOfReference", "released", "headNode", "includeTail", "visitNodes", "", "mask", "", "block", "Lkotlin/Function1;", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "hasNode", "hasNode-H91voCI", "(I)Z", "head", "head-H91voCI", "(I)Landroidx/compose/ui/Modifier$Node;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "isClipping", "value", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "lastLayerAlpha", "isTransparent", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "replace", "replace$ui", "hasMeasureResult", "getHasMeasureResult", "isAttached", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "measureResult", "getMeasureResult$ui", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui", "(Landroidx/compose/ui/layout/MeasureResult;)V", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "oldAlignmentLines", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/layout/AlignmentLine;", "ensureLookaheadDelegateCreated", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "onMeasureResultChanged", "width", "height", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "zIndex", "getZIndex", "setZIndex", "(F)V", "parentData", "", "getParentData", "()Ljava/lang/Object;", "onCoordinatesUsed", "onCoordinatesUsed$ui", "parentLayoutCoordinates", "getParentLayoutCoordinates", "parentCoordinates", "getParentCoordinates", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "lastMeasurementConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastMeasurementConstraints-msEJaDk$ui", "lastShape", "Landroidx/compose/ui/graphics/Shape;", "getLastShape$ui", "()Landroidx/compose/ui/graphics/Shape;", "setLastShape$ui", "(Landroidx/compose/ui/graphics/Shape;)V", "lastClip", "getLastClip$ui", "setLastClip$ui", "wasLayerBlockInvoked", "getWasLayerBlockInvoked$ui", "setWasLayerBlockInvoked$ui", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Lkotlin/Function0;", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "onMeasured", "onUnplaced", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "explicitLayer", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "releaseLayer", "placeSelfApparentToRealOffset", "placeSelfApparentToRealOffset-MLgxB_4", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "drawContainedDrawModifiers", "performDraw", "onPlaced", "drawBlockParentLayer", "drawBlockCanvas", "_drawBlock", "Lkotlin/Function2;", "drawBlock", "getDrawBlock", "()Lkotlin/jvm/functions/Function2;", "updateLayerBlock", "forceUpdateLayerParameters", "updateLayerParameters", "invokeOnLayoutChange", "invalidateParentLayer", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui", "Landroidx/compose/ui/node/OwnedLayer;", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "isValidOwnerScope", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "hitTest", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "hitTest-qzLsGqo", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hit", "hit-5ShdDok", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "outOfBoundsHit", "distanceFromEdge", "isHitInMinimumTouchTargetBetter", "outOfBoundsHit-8NAm7pk", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZFZ)V", "hitNear", "hitNear-Fh5PU_I", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZF)V", "speculativeHit", "speculativeHit-Fh5PU_I", "isInExpandedTouchBounds", "isInExpandedTouchBounds-ThD-n1k", "(Landroidx/compose/ui/Modifier$Node;JI)Z", "hitTestChild", "hitTestChild-qzLsGqo", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "(J)J", "localToScreen", "relativeToLocal", "localToScreen-MK-Hz9U", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "toCoordinator", "localPositionOf", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "transformToAncestor", "ancestor", "transformToAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "localBoundingBoxOf", "clipBounds", "ancestorToLocal", "offset", "ancestorToLocal-S_NoaFU", "(Landroidx/compose/ui/node/NodeCoordinator;JZ)J", "rect", "localToRoot", "localToRoot-MK-Hz9U", "withPositionTranslation", "toParentPosition", "toParentPosition-8S9VItk", "(JZ)J", "fromParentPosition", "fromParentPosition-8S9VItk", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "onLayoutNodeDetach", "onRelease", "rectInParent", "bounds", "clipToMinimumTouchTargetSize", "rectInParent$ui", "fromParentRect", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "(J)Z", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "invalidateLayer", "onLayoutModifierNodeChanged", "findCommonAncestor", "other", "findCommonAncestor$ui", "shouldSharePointerInputWithSiblings", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "distanceInMinimumTouchTarget", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "HitTestSource", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements LayoutCoordinates, Measurable, OwnerScope {
    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2={"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "<init>", "()V", "ExpectAttachedLayoutCoordinates", "", "UnmeasuredError", "onCommitAffectingLayerParams", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayer", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "getSemanticsSource", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&J\u0010\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fH&J7\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "childHitTest", "", "layoutNode", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "childHitTest-qzLsGqo", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface HitTestSource {
        void childHitTest-qzLsGqo(LayoutNode arg1, long arg2, HitTestResult arg3, int arg4, boolean arg5);

        int entityType-OLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Node arg1);

        boolean shouldHitTestChildren(LayoutNode arg1);
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    private static final HitTestSource PointerInputSource = null;
    private static final HitTestSource SemanticsSource = null;
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private Function2 _drawBlock;
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private Canvas drawBlockCanvas;
    private GraphicsLayer drawBlockParentLayer;
    private GraphicsLayer explicitLayer;
    private boolean forceMeasureWithLookaheadConstraints;
    private boolean forcePlaceWithLookaheadOffset;
    private static final ReusableGraphicsLayerScope graphicsLayerScope;
    private final Function0 invalidateParentLayer;
    private boolean isClipping;
    private boolean lastClip;
    private float lastLayerAlpha;
    private boolean lastLayerDrawingWasSkipped;
    private Shape lastShape;
    private OwnedLayer layer;
    private Function1 layerBlock;
    private Density layerDensity;
    private LayoutDirection layerLayoutDirection;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private MutableObjectIntMap oldAlignmentLines;
    private static final Function1 onCommitAffectingLayer;
    private static final Function1 onCommitAffectingLayerParams;
    private long position;
    private boolean released;
    private static final LayerPositionalProperties tmpLayerPositionalProperties;
    private static final float[] tmpMatrix;
    private boolean wasLayerBlockInvoked;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    static {
        NodeCoordinator.Companion = new Companion(null);
        NodeCoordinator.onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
        NodeCoordinator.onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
        NodeCoordinator.graphicsLayerScope = new ReusableGraphicsLayerScope();
        NodeCoordinator.tmpLayerPositionalProperties = new LayerPositionalProperties();
        NodeCoordinator.tmpMatrix = Matrix.constructor-impl$default(null, 1, null);
        NodeCoordinator.PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
        NodeCoordinator.SemanticsSource = new NodeCoordinator$Companion$SemanticsSource$1();
    }

    public NodeCoordinator(LayoutNode arg3) {
        super();
        this.layoutNode = arg3;
        this.layerDensity = this.getLayoutNode().getDensity();
        this.layerLayoutDirection = this.getLayoutNode().getLayoutDirection();
        this.lastLayerAlpha = 0.8f;
        this.position = IntOffset.Companion.getZero-nOcc-ac();
        this.lastShape = RectangleShapeKt.getRectangleShape();
        this.invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);
    }

    public static final void access$drawContainedDrawModifiers(NodeCoordinator arg0, Canvas arg1, GraphicsLayer arg2) {
        arg0.drawContainedDrawModifiers(arg1, arg2);
    }

    public static final Canvas access$getDrawBlockCanvas$p(NodeCoordinator arg0) {
        return arg0.drawBlockCanvas;
    }

    public static final GraphicsLayer access$getDrawBlockParentLayer$p(NodeCoordinator arg0) {
        return arg0.drawBlockParentLayer;
    }

    public static final ReusableGraphicsLayerScope access$getGraphicsLayerScope$cp() {
        return NodeCoordinator.graphicsLayerScope;
    }

    public static final Function1 access$getOnCommitAffectingLayer$cp() {
        return NodeCoordinator.onCommitAffectingLayer;
    }

    public static final HitTestSource access$getPointerInputSource$cp() {
        return NodeCoordinator.PointerInputSource;
    }

    public static final HitTestSource access$getSemanticsSource$cp() {
        return NodeCoordinator.SemanticsSource;
    }

    public static final OwnerSnapshotObserver access$getSnapshotObserver(NodeCoordinator arg0) {
        return arg0.getSnapshotObserver();
    }

    public static final Node access$headNode(NodeCoordinator arg0, boolean arg1) {
        return arg0.headNode(arg1);
    }

    public static final void access$outOfBoundsHit-8NAm7pk(NodeCoordinator arg0, Node arg1, HitTestSource arg2, long arg3, HitTestResult arg5, int arg6, boolean arg7, float arg8, boolean arg9) {
        arg0.outOfBoundsHit-8NAm7pk(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9);
    }

    public static final void access$setDrawBlockCanvas$p(NodeCoordinator arg0, Canvas arg1) {
        arg0.drawBlockCanvas = arg1;
    }

    public static final void access$setDrawBlockParentLayer$p(NodeCoordinator arg0, GraphicsLayer arg1) {
        arg0.drawBlockParentLayer = arg1;
    }

    public static final void access$setLastLayerDrawingWasSkipped$p(NodeCoordinator arg0, boolean arg1) {
        arg0.lastLayerDrawingWasSkipped = arg1;
    }

    public static final void access$setMeasurementConstraints-BRTryo0(NodeCoordinator arg0, long arg1) {
        arg0.setMeasurementConstraints-BRTryo0(arg1);
    }

    private final void ancestorToLocal(NodeCoordinator arg2, MutableRect arg3, boolean arg4) {
        if(arg2 == this) {
            return;
        }

        NodeCoordinator v0 = this.wrappedBy;
        if(v0 != null) {
            v0.ancestorToLocal(arg2, arg3, arg4);
        }

        this.fromParentRect(arg3, arg4);
    }

    private final long ancestorToLocal-S_NoaFU(NodeCoordinator arg3, long arg4, boolean arg6) {
        if(arg3 == this) {
            return arg4;
        }

        NodeCoordinator v0 = this.wrappedBy;
        if(v0 != null) {
            if(Intrinsics.areEqual(arg3, v0)) {
            }
            else {
                return this.fromParentPosition-8S9VItk(v0.ancestorToLocal-S_NoaFU(arg3, arg4, arg6), arg6);
            }
        }

        return this.fromParentPosition-8S9VItk(arg4, arg6);
    }

    protected final long calculateMinimumTouchTargetPadding-E7KxVPU(long arg7) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(Math.max(0f, (Float.intBitsToFloat(((int)(arg7 >> 0x20))) - (((float)this.getMeasuredWidth()))) / 2f)))) << 0x20 | (((long)Float.floatToRawIntBits(Math.max(0f, (Float.intBitsToFloat(((int)(arg7 & 0xFFFFFFFFL))) - (((float)this.getMeasuredHeight()))) / 2f)))) & 0xFFFFFFFFL);
    }

    protected final float distanceInMinimumTouchTarget-tz77jQw(long arg8, long arg10) {
        int v1 = 0x20;
        float v2 = Infinityf;
        long v3 = 0xFFFFFFFFL;
        if(Float.compare(((float)this.getMeasuredWidth()), Float.intBitsToFloat(((int)(arg10 >> v1)))) >= 0 && (((float)this.getMeasuredHeight())) >= Float.intBitsToFloat(((int)(arg10 & v3)))) {
            return v2;
        }

        arg10 = this.calculateMinimumTouchTargetPadding-E7KxVPU(arg10);
        float v0 = Float.intBitsToFloat(((int)(arg10 >> v1)));
        float v10 = Float.intBitsToFloat(((int)(arg10 & v3)));
        long v7 = this.offsetFromEdge-MK-Hz9U(arg8);
        if((v0 > 0f || v10 > 0f) && (Float.intBitsToFloat(((int)(v7 >> v1))) <= v0 && Float.intBitsToFloat(((int)(v7 & v3))) <= v10)) {
            return Offset.getDistanceSquared-impl(v7);
        }

        return v2;
    }

    public final void draw(Canvas arg4, GraphicsLayer arg5) {
        OwnedLayer v0 = this.layer;
        if(v0 != null) {
            v0.drawLayer(arg4, arg5);
            return;
        }

        float v0_1 = ((float)IntOffset.getX-impl(this.getPosition-nOcc-ac()));
        float v1 = ((float)IntOffset.getY-impl(this.getPosition-nOcc-ac()));
        arg4.translate(v0_1, v1);
        this.drawContainedDrawModifiers(arg4, arg5);
        arg4.translate(-v0_1, -v1);
    }

    protected final void drawBorder(Canvas arg9, Paint arg10) {
        arg9.drawRect(0.5f, 0.5f, (((float)(((int)(this.getMeasuredSize-YbymL2g() >> 0x20))))) - 0.5f, (((float)(((int)(this.getMeasuredSize-YbymL2g() & 0xFFFFFFFFL))))) - 0.5f, arg10);
    }

    private final void drawContainedDrawModifiers(Canvas arg9, GraphicsLayer arg10) {
        Node v6 = this.head-H91voCI(NodeKind.constructor-impl(4));
        if(v6 == null) {
            this.performDraw(arg9, arg10);
            return;
        }

        this.getLayoutNode().getMDrawScope$ui().draw-eZhPAX0$ui(arg9, IntSizeKt.toSize-ozmzZPI(this.getSize-YbymL2g()), this, v6, arg10);
    }

    public abstract void ensureLookaheadDelegateCreated();

    public final NodeCoordinator findCommonAncestor$ui(NodeCoordinator arg5) {
        LayoutNode v0 = arg5.getLayoutNode();
        LayoutNode v1 = this.getLayoutNode();
        if(v0 == v1) {
            Node v0_1 = arg5.getTail();
            Node v1_1 = this.getTail();
            int v2 = NodeKind.constructor-impl(2);
            if(!((DelegatableNode)v1_1).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
            }

            for(v1_1 = ((DelegatableNode)v1_1).getNode().getParent$ui(); v1_1 != null; v1_1 = v1_1.getParent$ui()) {
                if((v1_1.getKindSet$ui() & v2) != 0 && v1_1 == v0_1) {
                    return arg5;
                }
            }
        }
        else {
            while(v0.getDepth$ui() > v1.getDepth$ui()) {
                v0 = v0.getParent$ui();
                Intrinsics.checkNotNull(v0);
            }

            while(v1.getDepth$ui() > v0.getDepth$ui()) {
                v1 = v1.getParent$ui();
                Intrinsics.checkNotNull(v1);
            }

            while(true) {
                if(v0 == v1) {
                    goto label_44;
                }

                v0 = v0.getParent$ui();
                v1 = v1.getParent$ui();
                if(v0 != null && v1 != null) {
                    continue;
                }

                break;
            }

            throw new IllegalArgumentException("layouts are not part of the same hierarchy");
        label_44:
            if(v1 == this.getLayoutNode()) {
                return this;
            }

            if(v0 != arg5.getLayoutNode()) {
                return v0.getInnerCoordinator$ui();
            }

            return arg5;
        }

        return this;
    }

    public long fromParentPosition-8S9VItk(long arg3, boolean arg5) {
        if((arg5) || !this.isPlacedUnderMotionFrameOfReference()) {
            arg3 = IntOffsetKt.minus-Nv-tHpc(arg3, this.getPosition-nOcc-ac());
        }
        else {
        }

        OwnedLayer v2 = this.layer;
        if(v2 != null) {
            return v2.mapOffset-8S9VItk(arg3, true);
        }

        return arg3;
    }

    public static long fromParentPosition-8S9VItk$default(NodeCoordinator arg0, long arg1, boolean arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            return arg0.fromParentPosition-8S9VItk(arg1, true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
    }

    private final void fromParentRect(MutableRect arg5, boolean arg6) {
        float v0 = ((float)IntOffset.getX-impl(this.getPosition-nOcc-ac()));
        arg5.setLeft(arg5.getLeft() - v0);
        arg5.setRight(arg5.getRight() - v0);
        v0 = ((float)IntOffset.getY-impl(this.getPosition-nOcc-ac()));
        arg5.setTop(arg5.getTop() - v0);
        arg5.setBottom(arg5.getBottom() - v0);
        OwnedLayer v0_1 = this.layer;
        if(v0_1 != null) {
            v0_1.mapBounds(arg5, true);
            if((this.isClipping) && (arg6)) {
                arg5.intersect(0f, 0f, ((float)(((int)(this.getSize-YbymL2g() >> 0x20)))), ((float)(((int)(this.getSize-YbymL2g() & 0xFFFFFFFFL)))));
                arg5.isEmpty();
            }
        }
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return this.getLayoutNode().getLayoutDelegate$ui().getAlignmentLinesOwner$ui();
    }

    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    public LayoutCoordinates getCoordinates() {
        return this;
    }

    public float getDensity() {
        return this.getLayoutNode().getDensity().getDensity();
    }

    private final Function2 getDrawBlock() {
        Function2 v0 = this._drawBlock;
        if(v0 == null) {
            NodeCoordinator$drawBlock$1 v1 = new NodeCoordinator$drawBlock$1(this, new NodeCoordinator$drawBlock$drawBlockCallToDrawModifiers$1(this));
            this._drawBlock = ((Function2)v1);
            return ((Function2)v1);
        }

        return v0;
    }

    public float getFontScale() {
        return this.getLayoutNode().getDensity().getFontScale();
    }

    public final boolean getForceMeasureWithLookaheadConstraints$ui() {
        return this.forceMeasureWithLookaheadConstraints;
    }

    public final boolean getForcePlaceWithLookaheadOffset$ui() {
        return this.forcePlaceWithLookaheadOffset;
    }

    public boolean getHasMeasureResult() {
        if(this._measureResult != null) {
            return 1;
        }

        return 0;
    }

    public boolean getIntroducesMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference();
    }

    public final boolean getLastClip$ui() {
        return this.lastClip;
    }

    public final boolean getLastLayerDrawingWasSkipped$ui() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final long getLastMeasurementConstraints-msEJaDk$ui() {
        return this.getMeasurementConstraints-msEJaDk();
    }

    public final Shape getLastShape$ui() {
        return this.lastShape;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    protected final Function1 getLayerBlock() {
        return this.layerBlock;
    }

    public LayoutDirection getLayoutDirection() {
        return this.getLayoutNode().getLayoutDirection();
    }

    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public abstract LookaheadDelegate getLookaheadDelegate();

    public MeasureResult getMeasureResult$ui() {
        MeasureResult v1 = this._measureResult;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier".toString());
    }

    public final long getMinimumTouchTargetSize-NH-jbRc() {
        return this.layerDensity.toSize-XkaWNTQ(this.getLayoutNode().getViewConfiguration().getMinimumTouchTargetSize-MYxV2XQ());
    }

    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    public final LayoutCoordinates getParentCoordinates() {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }

        this.onCoordinatesUsed$ui();
        return this.wrappedBy;
    }

    public Object getParentData() {
        int v1 = 0x40;
        Node v2 = null;
        if(this.getLayoutNode().getNodes$ui().has-H91voCI$ui(NodeKind.constructor-impl(v1))) {
            this.getTail();
            ObjectRef v0 = new ObjectRef();
            Node v3;
            for(v3 = this.getLayoutNode().getNodes$ui().getTail$ui(); v3 != null; v3 = v3.getParent$ui()) {
                if((NodeKind.constructor-impl(v1) & v3.getKindSet$ui()) != 0) {
                    int v4 = NodeKind.constructor-impl(v1);
                    MutableVector v6 = ((MutableVector)v2);
                    Node v5 = v3;
                    while(true) {
                    label_21:
                        if(v5 != null) {
                            if((v5 instanceof ParentDataModifierNode)) {
                                v0.element = ((ParentDataModifierNode)v5).modifyParentData(this.getLayoutNode().getDensity(), v0.element);
                            }
                            else if((v5.getKindSet$ui() & v4) != 0 && ((v5 instanceof DelegatingNode))) {
                                Node v7 = v5.getDelegate$ui();
                                int v9 = 0;
                                while(v7 != null) {
                                    if((v7.getKindSet$ui() & v4) != 0) {
                                        ++v9;
                                        if(v9 == 1) {
                                            v5 = v7;
                                        }
                                        else {
                                            if(v6 == null) {
                                                v6 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v5 != null) {
                                                if(v6 != null) {
                                                    v6.add(v5);
                                                }

                                                v5 = v2;
                                            }

                                            if(v6 == null) {
                                                goto label_59;
                                            }

                                            v6.add(v7);
                                        }
                                    }

                                label_59:
                                    v7 = v7.getChild$ui();
                                }

                                if(v9 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_65;
                    }

                    v5 = DelegatableNodeKt.pop(v6);
                    goto label_21;
                }

            label_65:
            }

            return v0.element;
        }

        return v2;
    }

    public final LayoutCoordinates getParentLayoutCoordinates() {
        if(!this.isAttached()) {
            StringBuilder v0 = new StringBuilder("LayoutCoordinate operations are only valid when isAttached is true");
            LayoutNode v1;
            for(v1 = this.getLayoutNode(); v1 != null; v1 = v1.getParent$ui()) {
                Intrinsics.checkNotNullExpressionValue(v0.append('\n'), "append(...)");
                v0.append("|");
                v0.append(v1);
                v0.append(" isAttached=");
                v0.append(v1.isAttached());
                v0.append(" modifier=");
                v0.append(v1.getModifier());
                v0.append(" tail=");
                v0.append(this.getTail());
            }

            InlineClassHelperKt.throwIllegalStateException(v0.toString());
        }

        this.onCoordinatesUsed$ui();
        return this.getLayoutNode().getOuterCoordinator$ui().wrappedBy;
    }

    public long getPosition-nOcc-ac() {
        return this.position;
    }

    public Set getProvidedAlignmentLines() {
        LinkedHashSet v0 = null;
        LinkedHashSet v1 = v0;
        while(this != null) {
            MeasureResult v2 = this._measureResult;
            Map v2_1 = v2 != null ? v2.getAlignmentLines() : ((Map)v0);
            if(v2_1 != null && (v2_1.isEmpty() ^ 1) == 1) {
                if(v1 == null) {
                    v1 = new LinkedHashSet();
                }

                ((Set)v1).addAll(v2_1.keySet());
            }

            this = this.wrapped;
        }

        if(v1 == null) {
            return SetsKt.emptySet();
        }

        return ((Set)v1);
    }

    protected final MutableRect getRectCache() {
        MutableRect v0 = this._rectCache;
        if(v0 == null) {
            v0 = new MutableRect(0f, 0f, 0f, 0f);
            this._rectCache = v0;
        }

        return v0;
    }

    public final long getSize-YbymL2g() {
        return this.getMeasuredSize-YbymL2g();
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(this.getLayoutNode()).getSnapshotObserver();
    }

    public abstract Node getTail();

    public final boolean getWasLayerBlockInvoked$ui() {
        return this.wasLayerBlockInvoked;
    }

    public final NodeCoordinator getWrapped$ui() {
        return this.wrapped;
    }

    public final NodeCoordinator getWrappedBy$ui() {
        return this.wrappedBy;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    private final boolean hasNode-H91voCI(int arg2) {
        Node v1 = this.headNode(NodeKindKt.getIncludeSelfInTraversal-H91voCI(arg2));
        if(v1 != null && (DelegatableNodeKt.has-64DMado(((DelegatableNode)v1), arg2))) {
            return 1;
        }

        return 0;
    }

    public final Node head-H91voCI(int arg3) {
        boolean v0 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(arg3);
        Node v1 = this.getTail();
        if(v0) {
            goto label_7;
        }
        else {
            v1 = v1.getParent$ui();
            if(v1 == null) {
            }
            else {
            label_7:
                Node v2 = this.headNode(v0);
                while(v2 != null) {
                    if((v2.getAggregateChildKindSet$ui() & arg3) == 0) {
                        return null;
                    }

                    if((v2.getKindSet$ui() & arg3) != 0) {
                        return v2;
                    }
                    else if(v2 != v1) {
                        v2 = v2.getChild$ui();
                        continue;
                    }

                    return null;
                }
            }
        }

        return null;
    }

    private final Node headNode(boolean arg2) {
        if(this.getLayoutNode().getOuterCoordinator$ui() == this) {
            return this.getLayoutNode().getNodes$ui().getHead$ui();
        }

        this = this.wrappedBy;
        Node v0 = null;
        if(arg2) {
            if(this != null) {
                Node v1 = this.getTail();
                if(v1 != null) {
                    return v1.getChild$ui();
                }
            }

            return v0;
        }

        if(this != null) {
            return this.getTail();
        }

        return v0;
    }

    private final void hit-5ShdDok(Node arg8, HitTestSource arg9, long arg10, HitTestResult arg12, int arg13, boolean arg14) {
        if(arg8 == null) {
            this.hitTestChild-qzLsGqo(arg9, arg10, arg12, arg13, arg14);
            return;
        }

        int v0 = arg12.hitDepth;
        arg12.removeNodesInRange(arg12.hitDepth + 1, arg12.size());
        ++arg12.hitDepth;
        arg12.values.add(arg8);
        arg12.distanceFromEdgeAndFlags.add(HitTestResultKt.DistanceAndFlags(-1f, arg14, false));
        this.hit-5ShdDok(NodeCoordinatorKt.access$nextUntil-hw7D004(((DelegatableNode)arg8), arg9.entityType-OLwlOKw(), NodeKind.constructor-impl(2)), arg9, arg10, arg12, arg13, arg14);
        arg12.hitDepth = v0;
    }

    private final void hitNear-Fh5PU_I(Node arg12, HitTestSource arg13, long arg14, HitTestResult arg16, int arg17, boolean arg18, float arg19) {
        if(arg12 == null) {
            this.hitTestChild-qzLsGqo(arg13, arg14, arg16, arg17, arg18);
            return;
        }

        int v10 = arg16.hitDepth;
        arg16.removeNodesInRange(arg16.hitDepth + 1, arg16.size());
        ++arg16.hitDepth;
        arg16.values.add(arg12);
        arg16.distanceFromEdgeAndFlags.add(HitTestResultKt.DistanceAndFlags(arg19, arg18, false));
        this.outOfBoundsHit-8NAm7pk(NodeCoordinatorKt.access$nextUntil-hw7D004(((DelegatableNode)arg12), arg13.entityType-OLwlOKw(), NodeKind.constructor-impl(2)), arg13, arg14, arg16, arg17, arg18, arg19, true);
        arg16.hitDepth = v10;
    }

    public final void hitTest-qzLsGqo(HitTestSource arg14, long arg15, HitTestResult arg17, int arg18, boolean arg19) {
        boolean v7;
        long v3 = arg15;
        HitTestResult v5 = arg17;
        int v6 = arg18;
        Node v1 = this.head-H91voCI(arg14.entityType-OLwlOKw());
        boolean v8 = false;
        int v9 = 0x7F800000;
        int v10 = 0x7FFFFFFF;
        if(!this.withinLayerBounds-k-4lQ0M(v3)) {
            if(PointerType.equals-impl0(v6, PointerType.Companion.getTouch-T8wyACA())) {
                float v0 = this.distanceInMinimumTouchTarget-tz77jQw(v3, this.getMinimumTouchTargetSize-NH-jbRc());
                if((Float.floatToRawIntBits(v0) & v10) < v9 && (v5.isHitInMinimumTouchTargetBetter(v0, false))) {
                    this.hitNear-Fh5PU_I(v1, arg14, v3, v5, v6, false, v0);
                }
            }

            return;
        }

        if(v1 == null) {
            this.hitTestChild-qzLsGqo(arg14, arg15, arg17, arg18, arg19);
            return;
        }

        if(this.isPointerInBounds-k-4lQ0M(v3)) {
            this.hit-5ShdDok(v1, arg14, v3, arg17, arg18, arg19);
            return;
        }

        v5 = arg17;
        v6 = arg18;
        float v2 = !PointerType.equals-impl0(v6, PointerType.Companion.getTouch-T8wyACA()) ? Infinityf : this.distanceInMinimumTouchTarget-tz77jQw(v3, this.getMinimumTouchTargetSize-NH-jbRc());
        if((Float.floatToRawIntBits(v2) & v10) < v9) {
            v7 = arg19;
            if(v5.isHitInMinimumTouchTargetBetter(v2, v7)) {
                v8 = true;
            }
        }
        else {
            v7 = arg19;
        }

        this.outOfBoundsHit-8NAm7pk(v1, arg14, v3, v5, v6, v7, v2, v8);
    }

    public void hitTestChild-qzLsGqo(HitTestSource arg7, long arg8, HitTestResult arg10, int arg11, boolean arg12) {
        this = this.wrapped;
        if(this != null) {
            this.hitTest-qzLsGqo(arg7, NodeCoordinator.fromParentPosition-8S9VItk$default(this, arg8, false, 2, null), arg10, arg11, arg12);
        }
    }

    public void invalidateLayer() {
        OwnedLayer v0 = this.layer;
        if(v0 != null) {
            v0.invalidate();
            return;
        }

        this = this.wrappedBy;
        if(this != null) {
            this.invalidateLayer();
        }
    }

    public boolean isAttached() {
        return this.getTail().isAttached();
    }

    private final boolean isInExpandedTouchBounds-ThD-n1k(Node arg9, long arg10, int arg12) {
        if(arg9 == null) {
            return 0;
        }

        if(!PointerType.equals-impl0(arg12, PointerType.Companion.getStylus-T8wyACA()) && !PointerType.equals-impl0(arg12, PointerType.Companion.getEraser-T8wyACA())) {
            return 0;
        }

        arg12 = 16;
        int v1 = NodeKind.constructor-impl(arg12);
        Node v2 = null;
        MutableVector v3 = ((MutableVector)v2);
        while(true) {
        label_16:
            if(arg9 == null) {
                return 0;
            }

            if((arg9 instanceof PointerInputModifierNode)) {
                long v1_1 = ((PointerInputModifierNode)arg9).getTouchBoundsExpansion-RZrCHBk();
                int v9 = ((int)(arg10 >> 0x20));
                if(Float.intBitsToFloat(v9) >= (((float)(-TouchBoundsExpansion.computeLeft-impl$ui(v1_1, this.getLayoutDirection())))) && Float.intBitsToFloat(v9) < (((float)(this.getMeasuredWidth() + TouchBoundsExpansion.computeRight-impl$ui(v1_1, this.getLayoutDirection()))))) {
                    v9 = ((int)(arg10 & 0xFFFFFFFFL));
                    if(Float.intBitsToFloat(v9) >= (((float)(-TouchBoundsExpansion.getTop-impl(v1_1)))) && Float.intBitsToFloat(v9) < (((float)(this.getMeasuredHeight() + TouchBoundsExpansion.getBottom-impl(v1_1))))) {
                        return 1;
                    }
                }

                return 0;
            }

            if((arg9.getKindSet$ui() & v1) != 0 && ((arg9 instanceof DelegatingNode))) {
                Node v4 = arg9.getDelegate$ui();
                int v6 = 0;
                while(v4 != null) {
                    if((v4.getKindSet$ui() & v1) != 0) {
                        ++v6;
                        if(v6 == 1) {
                            arg9 = v4;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[arg12], 0);
                            }

                            if(arg9 != null) {
                                if(v3 != null) {
                                    v3.add(arg9);
                                }

                                arg9 = v2;
                            }

                            if(v3 == null) {
                                goto label_79;
                            }

                            v3.add(v4);
                        }
                    }

                label_79:
                    v4 = v4.getChild$ui();
                }

                if(v6 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        arg9 = DelegatableNodeKt.pop(v3);
        goto label_16;
        return 0;
    }

    protected final boolean isPointerInBounds-k-4lQ0M(long arg4) {
        float v0 = Float.intBitsToFloat(((int)(arg4 >> 0x20)));
        float v4 = Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL)));
        if(v0 >= 0f && v4 >= 0f && v0 < (((float)this.getMeasuredWidth())) && v4 < (((float)this.getMeasuredHeight()))) {
            return 1;
        }

        return 0;
    }

    public final boolean isTransparent() {
        if(this.layer != null && this.lastLayerAlpha <= 0f) {
            return 1;
        }

        this = this.wrappedBy;
        if(this != null) {
            return this.isTransparent();
        }

        return 0;
    }

    public boolean isValidOwnerScope() {
        if(this.layer != null && !this.released && (this.getLayoutNode().isAttached())) {
            return 1;
        }

        return 0;
    }

    public Rect localBoundingBoxOf(LayoutCoordinates arg9, boolean arg10) {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }

        if(!arg9.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates " + arg9 + " is not attached!");
        }

        NodeCoordinator v0 = this.toCoordinator(arg9);
        v0.onCoordinatesUsed$ui();
        NodeCoordinator v1 = this.findCommonAncestor$ui(v0);
        MutableRect v3 = this.getRectCache();
        v3.setLeft(0f);
        v3.setTop(0f);
        v3.setRight(((float)(((int)(arg9.getSize-YbymL2g() >> 0x20)))));
        v3.setBottom(((float)(((int)(arg9.getSize-YbymL2g() & 0xFFFFFFFFL)))));
        NodeCoordinator v2 = v0;
        while(v2 != v1) {
            boolean v4 = arg10;
            NodeCoordinator.rectInParent$ui$default(v2, v3, v4, false, 4, null);
            if(v3.isEmpty()) {
                return Rect.Companion.getZero();
            }

            v2 = v2.wrappedBy;
            Intrinsics.checkNotNull(v2);
            arg10 = v4;
        }

        this.ancestorToLocal(v1, v3, arg10);
        return MutableRectKt.toRect(v3);
    }

    public long localPositionOf-R5De75A(LayoutCoordinates arg2, long arg3) {
        return this.localPositionOf-S_NoaFU(arg2, arg3, true);
    }

    public long localPositionOf-S_NoaFU(LayoutCoordinates arg3, long arg4, boolean arg6) {
        if((arg3 instanceof LookaheadLayoutCoordinates)) {
            ((LookaheadLayoutCoordinates)arg3).getCoordinator().onCoordinatesUsed$ui();
            return Offset.constructor-impl(((LookaheadLayoutCoordinates)arg3).localPositionOf-S_NoaFU(((LayoutCoordinates)this), Offset.constructor-impl(arg4 ^ -9223372034707292160L), arg6) ^ -9223372034707292160L);
        }

        NodeCoordinator v3 = this.toCoordinator(arg3);
        v3.onCoordinatesUsed$ui();
        NodeCoordinator v0 = this.findCommonAncestor$ui(v3);
        while(v3 != v0) {
            arg4 = v3.toParentPosition-8S9VItk(arg4, arg6);
            v3 = v3.wrappedBy;
            Intrinsics.checkNotNull(v3);
        }

        return this.ancestorToLocal-S_NoaFU(v0, arg4, arg6);
    }

    public long localToRoot-MK-Hz9U(long arg8) {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }

        this.onCoordinatesUsed$ui();
        NodeCoordinator v1 = this;
        long v2 = arg8;
        while(v1 != null) {
            if(ComposeUiFlags.isRectManagerOffsetUsageFromLayoutCoordinatesEnabled) {
                LayoutNode v7 = v1.getLayoutNode();
                if(v1 == v7.getOuterCoordinator$ui() && !v7.getHasPositionalLayerTransformationsInOffsetFromRoot$ui()) {
                    long v7_1 = LayoutNodeKt.requireOwner(v7).getRectManager().getOffsetFromRectListFor-Bjo55l4(v7);
                    if(!IntOffset.equals-impl0(v7_1, IntOffset.Companion.getMax-nOcc-ac())) {
                        return IntOffsetKt.plus-Nv-tHpc(v2, v7_1);
                    }
                }
            }

            v2 = NodeCoordinator.toParentPosition-8S9VItk$default(v1, v2, false, 2, null);
            v1 = v1.wrappedBy;
        }

        return v2;
    }

    public long localToScreen-MK-Hz9U(long arg2) {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }

        return LayoutNodeKt.requireOwner(this.getLayoutNode()).localToScreen-MK-Hz9U(this.localToRoot-MK-Hz9U(arg2));
    }

    public long localToWindow-MK-Hz9U(long arg1) {
        return LayoutNodeKt.requireOwner(this.getLayoutNode()).calculatePositionInWindow-MK-Hz9U(this.localToRoot-MK-Hz9U(arg1));
    }

    private final long offsetFromEdge-MK-Hz9U(long arg6) {
        int v0 = 0x20;
        float v1 = Float.intBitsToFloat(((int)(arg6 >> v0)));
        if(v1 < 0f) {
            v1 = -v1;
        }
        else {
            v1 -= ((float)this.getMeasuredWidth());
        }

        v1 = Math.max(0f, v1);
        long v3 = 0xFFFFFFFFL;
        float v6 = Float.intBitsToFloat(((int)(arg6 & v3)));
        float v5 = v6 < 0f ? -v6 : v6 - (((float)this.getMeasuredHeight()));
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(v1))) << v0 | (((long)Float.floatToRawIntBits(Math.max(0f, v5)))) & v3);
    }

    public final void onCoordinatesUsed$ui() {
        this.getLayoutNode().getLayoutDelegate$ui().onCoordinatesUsed();
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer v0 = this.layer;
        if(v0 != null) {
            v0.invalidate();
        }
    }

    public final void onLayoutNodeDetach() {
        this.releaseLayer();
        if(this.getLayoutNode().isPlaced()) {
            this.onUnplaced();
        }
    }

    protected void onMeasureResultChanged(int arg10, int arg11) {
        OwnedLayer v0 = this.layer;
        long v1 = 0xFFFFFFFFL;
        int v3 = 0x20;
        if(v0 != null) {
            v0.resize-ozmzZPI(IntSize.constructor-impl((((long)arg10)) << v3 | (((long)arg11)) & v1));
        }
        else if(this.getLayoutNode().isPlaced()) {
            NodeCoordinator v0_1 = this.wrappedBy;
            if(v0_1 != null) {
                v0_1.invalidateLayer();
            }
        }

        this.setMeasuredSize-ozmzZPI(IntSize.constructor-impl((((long)arg11)) & v1 | (((long)arg10)) << v3));
        if(this.layerBlock != null) {
            this.updateLayerParameters(false);
        }

        arg10 = NodeKind.constructor-impl(4);
        boolean v0_2 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(arg10);
        Node v1_1 = this.getTail();
        if(v0_2) {
            goto label_38;
        }
        else {
            v1_1 = v1_1.getParent$ui();
            if(v1_1 == null) {
            }
            else {
            label_38:
                Node v0_3;
                for(v0_3 = this.headNode(v0_2); v0_3 != null; v0_3 = v0_3.getChild$ui()) {
                    if((v0_3.getAggregateChildKindSet$ui() & arg10) == 0) {
                        break;
                    }

                    if((v0_3.getKindSet$ui() & arg10) != 0) {
                        Node v2 = null;
                        Node v3_1 = v0_3;
                        MutableVector v4 = ((MutableVector)v2);
                        while(true) {
                        label_49:
                            if(v3_1 != null) {
                                if((v3_1 instanceof DrawModifierNode)) {
                                    ((DrawModifierNode)v3_1).onMeasureResultChanged();
                                }
                                else if((v3_1.getKindSet$ui() & arg10) != 0 && ((v3_1 instanceof DelegatingNode))) {
                                    Node v5 = v3_1.getDelegate$ui();
                                    int v6 = 0;
                                    while(v5 != null) {
                                        if((v5.getKindSet$ui() & arg10) != 0) {
                                            ++v6;
                                            if(v6 == 1) {
                                                v3_1 = v5;
                                            }
                                            else {
                                                if(v4 == null) {
                                                    v4 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v3_1 != null) {
                                                    if(v4 != null) {
                                                        v4.add(v3_1);
                                                    }

                                                    v3_1 = v2;
                                                }

                                                if(v4 == null) {
                                                    goto label_82;
                                                }

                                                v4.add(v5);
                                            }
                                        }

                                    label_82:
                                        v5 = v5.getChild$ui();
                                    }

                                    if(v6 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_88;
                        }

                        v3_1 = DelegatableNodeKt.pop(v4);
                        goto label_49;
                    }

                label_88:
                    if(v0_3 == v1_1) {
                        break;
                    }
                }
            }
        }

        Owner v10 = this.getLayoutNode().getOwner$ui();
        if(v10 != null) {
            v10.onLayoutChange(this.getLayoutNode());
        }
    }

    public final void onMeasured() {
        Node v7;
        int v0 = 0x80;
        if(this.hasNode-H91voCI(NodeKind.constructor-impl(v0))) {
            androidx.compose.runtime.snapshots.Snapshot$Companion v1 = Snapshot.Companion;
            Snapshot v2 = v1.getCurrentThreadSnapshot();
            Node v3 = null;
            Function1 v4 = v2 != null ? v2.getReadObserver() : ((Function1)v3);
            Snapshot v5 = v1.makeCurrentNonObservable(v2);
            try {
                v0 = NodeKind.constructor-impl(v0);
                boolean v6 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(v0);
                if(v6) {
                    v7 = this.getTail();
                    goto label_21;
                }
                else {
                    v7 = this.getTail().getParent$ui();
                    if(v7 == null) {
                    }
                    else {
                    label_21:
                        Node v6_1;
                        for(v6_1 = this.headNode(v6); v6_1 != null; v6_1 = v6_1.getChild$ui()) {
                            if((v6_1.getAggregateChildKindSet$ui() & v0) == 0) {
                                break;
                            }

                            if((v6_1.getKindSet$ui() & v0) != 0) {
                                MutableVector v9 = ((MutableVector)v3);
                                Node v8 = v6_1;
                                while(true) {
                                label_31:
                                    if(v8 != null) {
                                        if((v8 instanceof LayoutAwareModifierNode)) {
                                            ((LayoutAwareModifierNode)v8).onRemeasured-ozmzZPI(this.getMeasuredSize-YbymL2g());
                                        }
                                        else if((v8.getKindSet$ui() & v0) != 0 && ((v8 instanceof DelegatingNode))) {
                                            Node v10 = v8.getDelegate$ui();
                                            int v12 = 0;
                                            while(v10 != null) {
                                                if((v10.getKindSet$ui() & v0) != 0) {
                                                    ++v12;
                                                    if(v12 == 1) {
                                                        v8 = v10;
                                                    }
                                                    else {
                                                        if(v9 == null) {
                                                            v9 = new MutableVector(new Node[16], 0);
                                                        }

                                                        if(v8 != null) {
                                                            if(v9 != null) {
                                                                v9.add(v8);
                                                            }

                                                            v8 = v3;
                                                        }

                                                        if(v9 == null) {
                                                            goto label_66;
                                                        }

                                                        v9.add(v10);
                                                    }
                                                }

                                            label_66:
                                                v10 = v10.getChild$ui();
                                            }

                                            if(v12 != 1) {
                                                break;
                                            }

                                            continue;
                                        }

                                        break;
                                    }

                                    goto label_72;
                                }

                                v8 = DelegatableNodeKt.pop(v9);
                                goto label_31;
                            }

                        label_72:
                            if(v6_1 == v7) {
                                break;
                            }
                        }
                    }
                }
            }
            catch(Throwable v15) {
                v1.restoreNonObservable(v2, v5, v4);
                throw v15;
            }

            v1.restoreNonObservable(v2, v5, v4);
            return;
        }
    }

    public final void onPlaced() {
        int v0 = NodeKind.constructor-impl(0x400000);
        boolean v1 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(v0);
        Node v2 = this.getTail();
        if(v1) {
            goto label_9;
        }
        else {
            v2 = v2.getParent$ui();
            if(v2 == null) {
            }
            else {
            label_9:
                Node v1_1;
                for(v1_1 = this.headNode(v1); v1_1 != null; v1_1 = v1_1.getChild$ui()) {
                    if((v1_1.getAggregateChildKindSet$ui() & v0) == 0) {
                        return;
                    }

                    if((v1_1.getKindSet$ui() & v0) != 0) {
                        Node v3 = null;
                        Node v4 = v1_1;
                        MutableVector v5 = ((MutableVector)v3);
                        while(true) {
                        label_20:
                            if(v4 != null) {
                                if((v4 instanceof LayoutAwareModifierNode)) {
                                    ((LayoutAwareModifierNode)v4).onPlaced(this);
                                }
                                else if((v4.getKindSet$ui() & v0) != 0 && ((v4 instanceof DelegatingNode))) {
                                    Node v6 = v4.getDelegate$ui();
                                    int v8 = 0;
                                    while(v6 != null) {
                                        if((v6.getKindSet$ui() & v0) != 0) {
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

                                                    v4 = v3;
                                                }

                                                if(v5 == null) {
                                                    goto label_55;
                                                }

                                                v5.add(v6);
                                            }
                                        }

                                    label_55:
                                        v6 = v6.getChild$ui();
                                    }

                                    if(v8 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_61;
                        }

                        v4 = DelegatableNodeKt.pop(v5);
                        goto label_20;
                    }

                label_61:
                    if(v1_1 == v2) {
                        return;
                    }
                }
            }
        }
    }

    public final void onRelease() {
        this.released = true;
        this.invalidateParentLayer.invoke();
        this.releaseLayer();
        if(!IntOffset.equals-impl0(this.getPosition-nOcc-ac(), IntOffset.Companion.getZero-nOcc-ac())) {
            this.getLayoutNode().onCoordinatorPositionChanged$ui();
        }
    }

    public final void onUnplaced() {
        int v0 = 0x100000;
        if(this.hasNode-H91voCI(NodeKind.constructor-impl(v0))) {
            v0 = NodeKind.constructor-impl(v0);
            boolean v1 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(v0);
            Node v2 = this.getTail();
            if(v1) {
            }
            else {
                v2 = v2.getParent$ui();
                if(v2 == null) {
                    return;
                }
            }

            Node v10;
            for(v10 = this.headNode(v1); v10 != null; v10 = v10.getChild$ui()) {
                if((v10.getAggregateChildKindSet$ui() & v0) == 0) {
                    return;
                }

                if((v10.getKindSet$ui() & v0) != 0) {
                    Node v1_1 = null;
                    Node v3 = v10;
                    MutableVector v4 = ((MutableVector)v1_1);
                    while(true) {
                    label_23:
                        if(v3 != null) {
                            if((v3 instanceof UnplacedAwareModifierNode)) {
                                ((UnplacedAwareModifierNode)v3).onUnplaced();
                            }
                            else if((v3.getKindSet$ui() & v0) != 0 && ((v3 instanceof DelegatingNode))) {
                                Node v5 = v3.getDelegate$ui();
                                int v7 = 0;
                                while(v5 != null) {
                                    if((v5.getKindSet$ui() & v0) != 0) {
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

                                                v3 = v1_1;
                                            }

                                            if(v4 == null) {
                                                goto label_57;
                                            }

                                            v4.add(v5);
                                        }
                                    }

                                label_57:
                                    v5 = v5.getChild$ui();
                                }

                                if(v7 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_63;
                    }

                    v3 = DelegatableNodeKt.pop(v4);
                    goto label_23;
                }

            label_63:
                if(v10 == v2) {
                    return;
                }
            }
        }
    }

    private final void outOfBoundsHit-8NAm7pk(Node arg12, HitTestSource arg13, long arg14, HitTestResult arg16, int arg17, boolean arg18, float arg19, boolean arg20) {
        if(arg12 == null) {
            this.hitTestChild-qzLsGqo(arg13, arg14, arg16, arg17, arg18);
            return;
        }

        int v7 = arg17;
        if(this.isInExpandedTouchBounds-ThD-n1k(arg12, arg14, v7)) {
            arg16.hitExpandedTouchBounds(arg12, arg18, new NodeCoordinator$outOfBoundsHit$1(this, arg12, arg13, arg14, arg16, v7, arg18, arg19, arg20));
            return;
        }

        if(arg20) {
            this.hitNear-Fh5PU_I(arg12, arg13, arg14, arg16, arg17, arg18, arg19);
            return;
        }

        this.speculativeHit-Fh5PU_I(arg12, arg13, arg14, arg16, arg17, arg18, arg19);
    }

    public void performDraw(Canvas arg1, GraphicsLayer arg2) {
        this = this.wrapped;
        if(this != null) {
            this.draw(arg1, arg2);
        }
    }

    protected final Placeable performingMeasure-K40F9xA(long arg1, Function0 arg3) {
        this.setMeasurementConstraints-BRTryo0(arg1);
        return arg3.invoke();
    }

    protected void placeAt-f8xVGno(long arg12, float arg14, GraphicsLayer arg15) {
        if(this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate v12 = this.getLookaheadDelegate();
            Intrinsics.checkNotNull(v12);
            this.placeSelf-MLgxB_4(v12.getPosition-nOcc-ac(), arg14, null, arg15);
            return;
        }

        this.placeSelf-MLgxB_4(arg12, arg14, null, arg15);
    }

    protected void placeAt-f8xVGno(long arg7, float arg9, Function1 arg10) {
        if(this.forcePlaceWithLookaheadOffset) {
            LookaheadDelegate v1 = this.getLookaheadDelegate();
            Intrinsics.checkNotNull(v1);
            this.placeSelf-MLgxB_4(v1.getPosition-nOcc-ac(), arg9, arg10, null);
            return;
        }

        this.placeSelf-MLgxB_4(arg7, arg9, arg10, null);
    }

    private final void placeSelf-MLgxB_4(long arg7, float arg9, Function1 arg10, GraphicsLayer arg11) {
        OwnedLayer v10_1;
        int v0 = 2;
        GraphicsLayer v2 = null;
        if(arg11 != null) {
            int v10 = arg10 == null ? 1 : 0;
            if(v10 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("both ways to create layers shouldn\'t be used together");
            }

            if(this.explicitLayer != arg11) {
                this.explicitLayer = v2;
                NodeCoordinator.updateLayerBlock$default(this, ((Function1)v2), false, v0, v2);
                this.explicitLayer = arg11;
            }

            if(this.layer != null) {
                goto label_38;
            }

            v10_1 = LayoutNodeKt.requireOwner(this.getLayoutNode()).createLayer(this.getDrawBlock(), this.invalidateParentLayer, arg11);
            v10_1.resize-ozmzZPI(this.getMeasuredSize-YbymL2g());
            v10_1.move--gyyYBs(arg7);
            this.layer = v10_1;
            this.getLayoutNode().setInnerLayerCoordinatorIsDirty$ui(true);
            this.invalidateParentLayer.invoke();
        }
        else {
            if(this.explicitLayer != null) {
                this.explicitLayer = v2;
                NodeCoordinator.updateLayerBlock$default(this, ((Function1)v2), false, v0, v2);
            }

            NodeCoordinator.updateLayerBlock$default(this, arg10, false, v0, v2);
        }

    label_38:
        if(!IntOffset.equals-impl0(this.getPosition-nOcc-ac(), arg7)) {
            LayoutNodeKt.requireOwner(this.getLayoutNode()).voteFrameRate(FrameRateCategory.Companion.getHigh-NSsRyOo());
            this.setPosition--gyyYBs(arg7);
            this.getLayoutNode().getLayoutDelegate$ui().getMeasurePassDelegate$ui().notifyChildrenUsingCoordinatesWhilePlacing();
            v10_1 = this.layer;
            if(v10_1 != null) {
                v10_1.move--gyyYBs(arg7);
            }
            else {
                NodeCoordinator v7 = this.wrappedBy;
                if(v7 != null) {
                    v7.invalidateLayer();
                }
            }

            this.getLayoutNode().onCoordinatorPositionChanged$ui();
            this.invalidateAlignmentLinesFromPositionChange(this);
            Owner v7_1 = this.getLayoutNode().getOwner$ui();
            if(v7_1 == null) {
                goto label_66;
            }

            v7_1.onLayoutChange(this.getLayoutNode());
        }

    label_66:
        this.zIndex = arg9;
        if(this == this.getLayoutNode().getOuterCoordinator$ui()) {
            RectManager.onLayoutPositionChanged$default(LayoutNodeKt.requireOwner(this.getLayoutNode()).getRectManager(), this.getLayoutNode(), false, v0, v2);
        }

        if(!this.isPlacingForAlignment$ui()) {
            this.captureRulersIfNeeded$ui(this.getMeasureResult$ui());
        }
    }

    public final void placeSelfApparentToRealOffset-MLgxB_4(long arg3, float arg5, Function1 arg6, GraphicsLayer arg7) {
        this.placeSelf-MLgxB_4(IntOffset.plus-qkQi6aY(arg3, this.getApparentToRealOffset-nOcc-ac()), arg5, arg6, arg7);
    }

    public final void rectInParent$ui(MutableRect arg9, boolean arg10, boolean arg11) {
        float v10_1;
        OwnedLayer v0 = this.layer;
        if(v0 != null) {
            if(this.isClipping) {
                long v1 = 0xFFFFFFFFL;
                int v3 = 0x20;
                if(arg11) {
                    long v10 = this.getMinimumTouchTargetSize-NH-jbRc();
                    float v4 = Float.intBitsToFloat(((int)(v10 >> v3))) / 2f;
                    v10_1 = Float.intBitsToFloat(((int)(v10 & v1))) / 2f;
                    arg9.intersect(-v4, -v10_1, (((float)(((int)(this.getSize-YbymL2g() >> v3))))) + v4, (((float)(((int)(v1 & this.getSize-YbymL2g()))))) + v10_1);
                }
                else if(arg10) {
                    arg9.intersect(0f, 0f, ((float)(((int)(this.getSize-YbymL2g() >> v3)))), ((float)(((int)(v1 & this.getSize-YbymL2g())))));
                }

                if(!arg9.isEmpty()) {
                    goto label_45;
                }

                return;
            }

        label_45:
            v0.mapBounds(arg9, false);
        }

        v10_1 = ((float)IntOffset.getX-impl(this.getPosition-nOcc-ac()));
        arg9.setLeft(arg9.getLeft() + v10_1);
        arg9.setRight(arg9.getRight() + v10_1);
        float v8 = ((float)IntOffset.getY-impl(this.getPosition-nOcc-ac()));
        arg9.setTop(arg9.getTop() + v8);
        arg9.setBottom(arg9.getBottom() + v8);
    }

    public static void rectInParent$ui$default(NodeCoordinator arg0, MutableRect arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            arg0.rectInParent$ui(arg1, arg2, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
    }

    public final void releaseLayer() {
        if(this.layer != null) {
            GraphicsLayer v1 = null;
            if(this.explicitLayer != null) {
                this.explicitLayer = v1;
            }

            NodeCoordinator.updateLayerBlock$default(this, ((Function1)v1), false, 2, v1);
            LayoutNode.requestRelayout$ui$default(this.getLayoutNode(), false, 1, v1);
        }
    }

    public void replace$ui() {
        GraphicsLayer v0 = this.explicitLayer;
        if(v0 != null) {
            this.placeAt-f8xVGno(this.getPosition-nOcc-ac(), this.zIndex, v0);
            return;
        }

        this.placeAt-f8xVGno(this.getPosition-nOcc-ac(), this.zIndex, this.layerBlock);
    }

    public long screenToLocal-MK-Hz9U(long arg2) {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }

        return this.localPositionOf-R5De75A(LayoutCoordinatesKt.findRootCoordinates(this), LayoutNodeKt.requireOwner(this.getLayoutNode()).screenToLocal-MK-Hz9U(arg2));
    }

    public final void setForceMeasureWithLookaheadConstraints$ui(boolean arg1) {
        this.forceMeasureWithLookaheadConstraints = arg1;
    }

    public final void setForcePlaceWithLookaheadOffset$ui(boolean arg1) {
        this.forcePlaceWithLookaheadOffset = arg1;
    }

    public final void setLastClip$ui(boolean arg1) {
        this.lastClip = arg1;
    }

    public final void setLastShape$ui(Shape arg1) {
        this.lastShape = arg1;
    }

    protected abstract void setLookaheadDelegate(LookaheadDelegate arg1);

    public void setMeasureResult$ui(MeasureResult arg4) {
        MeasureResult v0 = this._measureResult;
        if(arg4 != v0) {
            this._measureResult = arg4;
            if(v0 == null || arg4.getWidth() != v0.getWidth() || arg4.getHeight() != v0.getHeight()) {
                this.onMeasureResultChanged(arg4.getWidth(), arg4.getHeight());
            }

            MutableObjectIntMap v0_1 = this.oldAlignmentLines;
            if(v0_1 != null) {
                Intrinsics.checkNotNull(v0_1);
                if(!v0_1.isNotEmpty()) {
                    goto label_18;
                }
            }
            else {
            label_18:
                if(!arg4.getAlignmentLines().isEmpty()) {
                    goto label_21;
                }

                return;
            }

        label_21:
            if(NodeCoordinatorKt.access$compareEquals(this.oldAlignmentLines, arg4.getAlignmentLines())) {
                return;
            }

            this.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            v0_1 = this.oldAlignmentLines;
            if(v0_1 == null) {
                v0_1 = ObjectIntMapKt.mutableObjectIntMapOf();
                this.oldAlignmentLines = v0_1;
            }

            v0_1.clear();
            Iterator v3 = arg4.getAlignmentLines().entrySet().iterator();
            while(v3.hasNext()) {
                Object v4 = v3.next();
                v0_1.set(((Map$Entry)v4).getKey(), ((Map$Entry)v4).getValue().intValue());
            }
        }
    }

    protected void setPosition--gyyYBs(long arg1) {
        this.position = arg1;
    }

    public final void setWasLayerBlockInvoked$ui(boolean arg1) {
        this.wasLayerBlockInvoked = arg1;
    }

    public final void setWrapped$ui(NodeCoordinator arg1) {
        this.wrapped = arg1;
    }

    public final void setWrappedBy$ui(NodeCoordinator arg1) {
        this.wrappedBy = arg1;
    }

    protected final void setZIndex(float arg1) {
        this.zIndex = arg1;
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        int v0 = 16;
        Node v10 = this.headNode(NodeKindKt.getIncludeSelfInTraversal-H91voCI(NodeKind.constructor-impl(v0)));
        if(v10 == null) {
            return 0;
        }

        if(v10.isAttached()) {
            int v2 = NodeKind.constructor-impl(v0);
            if(!((DelegatableNode)v10).getNode().isAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }

            v10 = ((DelegatableNode)v10).getNode();
            if((v10.getAggregateChildKindSet$ui() & v2) == 0) {
                return 0;
            }

            while(v10 != null) {
                if((v10.getKindSet$ui() & v2) != 0) {
                    Node v3 = null;
                    Node v4 = v10;
                    MutableVector v5 = ((MutableVector)v3);
                    while(true) {
                    label_26:
                        if(v4 != null) {
                            if((v4 instanceof PointerInputModifierNode)) {
                                if(((PointerInputModifierNode)v4).sharePointerInputWithSiblings()) {
                                    return 1;
                                }
                            }
                            else if((v4.getKindSet$ui() & v2) != 0 && ((v4 instanceof DelegatingNode))) {
                                Node v6 = v4.getDelegate$ui();
                                int v8 = 0;
                                while(v6 != null) {
                                    if((v6.getKindSet$ui() & v2) != 0) {
                                        ++v8;
                                        if(v8 == 1) {
                                            v4 = v6;
                                        }
                                        else {
                                            if(v5 == null) {
                                                v5 = new MutableVector(new Node[v0], 0);
                                            }

                                            if(v4 != null) {
                                                if(v5 != null) {
                                                    v5.add(v4);
                                                }

                                                v4 = v3;
                                            }

                                            if(v5 == null) {
                                                goto label_59;
                                            }

                                            v5.add(v6);
                                        }
                                    }

                                label_59:
                                    v6 = v6.getChild$ui();
                                }

                                if(v8 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_65;
                    }

                    v4 = DelegatableNodeKt.pop(v5);
                    goto label_26;
                }

            label_65:
                v10 = v10.getChild$ui();
            }
        }

        return 0;
    }

    private final void speculativeHit-Fh5PU_I(Node arg11, HitTestSource arg12, long arg13, HitTestResult arg15, int arg16, boolean arg17, float arg18) {
        if(arg11 == null) {
            this.hitTestChild-qzLsGqo(arg12, arg13, arg15, arg16, arg17);
            return;
        }

        if(arg12.interceptOutOfBoundsChildEvents(arg11)) {
            arg15.speculativeHit(arg11, arg18, arg17, new NodeCoordinator$speculativeHit$1(this, arg11, arg12, arg13, arg15, arg16, arg17, arg18));
            return;
        }

        this.outOfBoundsHit-8NAm7pk(NodeCoordinatorKt.access$nextUntil-hw7D004(((DelegatableNode)arg11), arg12.entityType-OLwlOKw(), NodeKind.constructor-impl(2)), arg12, arg13, arg15, arg16, arg17, arg18, false);
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates arg1) {
        LayoutCoordinates v0 = (arg1 instanceof LookaheadLayoutCoordinates) ? arg1 : null;
        if(v0 != null) {
            this = ((LookaheadLayoutCoordinates)v0).getCoordinator();
            if(this == null) {
            }
            else {
                return this;
            }
        }

        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return arg1;
    }

    public long toParentPosition-8S9VItk(long arg3, boolean arg5) {
        OwnedLayer v0 = this.layer;
        if(v0 != null) {
            arg3 = v0.mapOffset-8S9VItk(arg3, false);
        }

        if(!arg5 && (this.isPlacedUnderMotionFrameOfReference())) {
            return arg3;
        }

        return IntOffsetKt.plus-Nv-tHpc(arg3, this.getPosition-nOcc-ac());
    }

    public static long toParentPosition-8S9VItk$default(NodeCoordinator arg0, long arg1, boolean arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            return arg0.toParentPosition-8S9VItk(arg1, true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
    }

    public final Rect touchBoundsInRoot() {
        if(!this.isAttached()) {
            return Rect.Companion.getZero();
        }

        LayoutCoordinates v0 = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect v1 = this.getRectCache();
        long v2 = this.calculateMinimumTouchTargetPadding-E7KxVPU(this.getMinimumTouchTargetSize-NH-jbRc());
        int v4 = ((int)(v2 >> 0x20));
        v1.setLeft(-Float.intBitsToFloat(v4));
        int v2_1 = ((int)(v2 & 0xFFFFFFFFL));
        v1.setTop(-Float.intBitsToFloat(v2_1));
        v1.setRight((((float)this.getMeasuredWidth())) + Float.intBitsToFloat(v4));
        v1.setBottom((((float)this.getMeasuredHeight())) + Float.intBitsToFloat(v2_1));
        while(this != (((NodeCoordinator)v0))) {
            this.rectInParent$ui(v1, false, true);
            if(v1.isEmpty()) {
                return Rect.Companion.getZero();
            }

            this = this.wrappedBy;
            Intrinsics.checkNotNull(this);
        }

        return MutableRectKt.toRect(v1);
    }

    public void transformFrom-EL8BTi8(LayoutCoordinates arg2, float[] arg3) {
        NodeCoordinator v2 = this.toCoordinator(arg2);
        v2.onCoordinatesUsed$ui();
        NodeCoordinator v0 = this.findCommonAncestor$ui(v2);
        Matrix.reset-impl(arg3);
        v2.transformToAncestor-EL8BTi8(v0, arg3);
        this.transformFromAncestor-EL8BTi8(v0, arg3);
    }

    private final void transformFromAncestor-EL8BTi8(NodeCoordinator arg7, float[] arg8) {
        if(!Intrinsics.areEqual(arg7, this)) {
            NodeCoordinator v0 = this.wrappedBy;
            Intrinsics.checkNotNull(v0);
            v0.transformFromAncestor-EL8BTi8(arg7, arg8);
            if(!IntOffset.equals-impl0(this.getPosition-nOcc-ac(), IntOffset.Companion.getZero-nOcc-ac())) {
                float[] v0_1 = NodeCoordinator.tmpMatrix;
                Matrix.reset-impl(v0_1);
                Matrix.translate-impl$default(v0_1, -(((float)IntOffset.getX-impl(this.getPosition-nOcc-ac()))), -(((float)IntOffset.getY-impl(this.getPosition-nOcc-ac()))), 0f, 4, null);
                Matrix.timesAssign-58bKbWc(arg8, v0_1);
            }

            OwnedLayer v6 = this.layer;
            if(v6 == null) {
                return;
            }

            v6.inverseTransform-58bKbWc(arg8);
        }
    }

    private final void transformToAncestor-EL8BTi8(NodeCoordinator arg10, float[] arg11) {
        while(!Intrinsics.areEqual(this, arg10)) {
            OwnedLayer v0 = this.layer;
            if(v0 != null) {
                v0.transform-58bKbWc(arg11);
            }

            long v0_1 = this.getPosition-nOcc-ac();
            if(!IntOffset.equals-impl0(v0_1, IntOffset.Companion.getZero-nOcc-ac())) {
                float[] v3 = NodeCoordinator.tmpMatrix;
                Matrix.reset-impl(v3);
                Matrix.translate-impl$default(v3, ((float)IntOffset.getX-impl(v0_1)), ((float)IntOffset.getY-impl(v0_1)), 0f, 4, null);
                Matrix.timesAssign-58bKbWc(arg11, v3);
            }

            this = this.wrappedBy;
            Intrinsics.checkNotNull(this);
        }
    }

    public void transformToScreen-58bKbWc(float[] arg7) {
        Owner v0 = LayoutNodeKt.requireOwner(this.getLayoutNode());
        NodeCoordinator v1 = this.toCoordinator(LayoutCoordinatesKt.findRootCoordinates(this));
        this.transformToAncestor-EL8BTi8(v1, arg7);
        if((v0 instanceof MatrixPositionCalculator)) {
            ((MatrixPositionCalculator)v0).localToScreen-58bKbWc(arg7);
            return;
        }

        long v0_1 = LayoutCoordinatesKt.positionOnScreen(((LayoutCoordinates)v1));
        if((0x7FFFFFFF7FFFFFFFL & v0_1) != 0x7FC000007FC00000L) {
            Matrix.translate-impl(arg7, Float.intBitsToFloat(((int)(v0_1 >> 0x20))), Float.intBitsToFloat(((int)(v0_1 & 0xFFFFFFFFL))), 0f);
        }
    }

    public final void updateLayerBlock(Function1 arg12, boolean arg13) {
        OwnedLayer v12;
        int v2 = arg12 == null || this.explicitLayer == null ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("layerBlock can\'t be provided when explicitLayer is provided");
        }

        LayoutNode v2_1 = this.getLayoutNode();
        int v13 = (arg13) || this.layerBlock != arg12 || !Intrinsics.areEqual(this.layerDensity, v2_1.getDensity()) || this.layerLayoutDirection != v2_1.getLayoutDirection() ? 1 : 0;
        this.layerDensity = v2_1.getDensity();
        this.layerLayoutDirection = v2_1.getLayoutDirection();
        Object v4 = null;
        if((v2_1.isAttached()) && arg12 != null) {
            this.layerBlock = arg12;
            if(this.layer == null) {
                v12 = Owner.createLayer$default(LayoutNodeKt.requireOwner(v2_1), this.getDrawBlock(), this.invalidateParentLayer, null, 4, null);
                v12.resize-ozmzZPI(this.getMeasuredSize-YbymL2g());
                v12.move--gyyYBs(this.getPosition-nOcc-ac());
                this.layer = v12;
                NodeCoordinator.updateLayerParameters$default(this, false, 1, v4);
                v2_1.setInnerLayerCoordinatorIsDirty$ui(true);
                this.invalidateParentLayer.invoke();
                return;
            }
            else {
                if(v13 != 0) {
                    NodeCoordinator.updateLayerParameters$default(this, false, 1, v4);
                }

                return;
            }
        }

        this.layerBlock = ((Function1)v4);
        v12 = this.layer;
        if(v12 != null) {
            if(!MatrixKt.isIdentity-58bKbWc(v12.getUnderlyingMatrix-sQKQjiQ())) {
                v2_1.onCoordinatorPositionChanged$ui();
            }

            v12.destroy();
            v2_1.setInnerLayerCoordinatorIsDirty$ui(true);
            this.invalidateParentLayer.invoke();
            if(!this.isAttached()) {
                goto label_76;
            }

            if(!v2_1.isPlaced()) {
                goto label_76;
            }

            Owner v12_1 = v2_1.getOwner$ui();
            if(v12_1 == null) {
                goto label_76;
            }

            v12_1.onLayoutChange(v2_1);
        }

    label_76:
        this.layer = ((OwnedLayer)v4);
        this.lastLayerDrawingWasSkipped = false;
    }

    public static void updateLayerBlock$default(NodeCoordinator arg0, Function1 arg1, boolean arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            arg0.updateLayerBlock(arg1, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
    }

    private final void updateLayerParameters(boolean arg10) {
        if(this.explicitLayer != null) {
        }
        else {
            OwnedLayer v0 = this.layer;
            Function1 v1 = this.layerBlock;
            int v2 = 1;
            if(v0 == null) {
                if(v1 == null) {
                }
                else {
                    v2 = 0;
                }

                if(v2 != 0) {
                    return;
                }

                InlineClassHelperKt.throwIllegalStateException("null layer with a non-null layerBlock");
            }
            else if(v1 != null) {
                ReusableGraphicsLayerScope v4 = NodeCoordinator.graphicsLayerScope;
                v4.reset();
                v4.setGraphicsDensity$ui(this.getLayoutNode().getDensity());
                v4.setLayoutDirection$ui(this.getLayoutNode().getLayoutDirection());
                v4.setSize-uvyYCjk(IntSizeKt.toSize-ozmzZPI(this.getSize-YbymL2g()));
                OwnerSnapshotObserver.access$getObserver$p(this.getSnapshotObserver()).observeReads(this, NodeCoordinator.onCommitAffectingLayerParams, new NodeCoordinator$updateLayerParameters$1(v1, this));
                LayerPositionalProperties v1_1 = this.layerPositionalProperties;
                if(v1_1 == null) {
                    v1_1 = new LayerPositionalProperties();
                    this.layerPositionalProperties = v1_1;
                }

                LayerPositionalProperties v5 = NodeCoordinator.tmpLayerPositionalProperties;
                v5.copyFrom(v1_1);
                v1_1.copyFrom(v4);
                v0.updateLayerProperties(v4);
                boolean v0_1 = this.isClipping;
                this.isClipping = v4.getClip();
                this.lastLayerAlpha = v4.getAlpha();
                boolean v1_2 = v5.hasSameValuesAs(v1_1);
                if((arg10) && (!v1_2 || v0_1 != this.isClipping)) {
                    Owner v10 = this.getLayoutNode().getOwner$ui();
                    if(v10 == null) {
                        goto label_52;
                    }

                    v10.onLayoutChange(this.getLayoutNode());
                }

            label_52:
                if(v1_2) {
                    return;
                }

                LayoutNode v10_1 = this.getLayoutNode();
                LayoutNodeLayoutDelegate v0_2 = v10_1.getLayoutDelegate$ui();
                Object v4_1 = null;
                if(v0_2.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                    if((v0_2.getCoordinatesAccessedDuringModifierPlacement()) || (v0_2.getCoordinatesAccessedDuringPlacement())) {
                        LayoutNode.requestRelayout$ui$default(v10_1, false, 1, v4_1);
                    }

                    v0_2.getMeasurePassDelegate$ui().notifyChildrenUsingCoordinatesWhilePlacing();
                }

                v10_1.onCoordinatorPositionChanged$ui();
                Owner v0_3 = LayoutNodeKt.requireOwner(v10_1);
                RectManager v1_3 = v0_3.getRectManager();
                if(this == v10_1.getOuterCoordinator$ui()) {
                    RectManager.onLayoutPositionChanged$default(v1_3, v10_1, false, 2, v4_1);
                }
                else {
                    v1_3.onLayoutLayerPositionalPropertiesChanged(v10_1);
                }

                if(v10_1.getGloballyPositionedObservers() <= 0) {
                    return;
                }

                v0_3.requestOnPositionedCallback(v10_1);
                return;
            }
            else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("updateLayerParameters requires a non-null layerBlock");
                throw new KotlinNothingValueException();
            }
        }
    }

    static void updateLayerParameters$default(NodeCoordinator arg0, boolean arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            arg0.updateLayerParameters(true);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
    }

    public final void visitNodes(int arg2, boolean arg3, Function1 arg4) {
        Node v0 = this.getTail();
        if(arg3) {
            goto label_6;
        }
        else {
            v0 = v0.getParent$ui();
            if(v0 == null) {
            }
            else {
            label_6:
                Node v1 = this.headNode(arg3);
                while(v1 != null) {
                    if((v1.getAggregateChildKindSet$ui() & arg2) == 0) {
                    }
                    else {
                        if((v1.getKindSet$ui() & arg2) != 0) {
                            arg4.invoke(v1);
                        }

                        if(v1 == v0) {
                            return;
                        }

                        v1 = v1.getChild$ui();
                        continue;
                    }

                    return;
                }
            }
        }
    }

    public final void visitNodes-aLcG6gQ(int arg10, Function1 arg11) {
        boolean v0 = NodeKindKt.getIncludeSelfInTraversal-H91voCI(arg10);
        Node v1 = this.getTail();
        if(v0) {
            goto label_7;
        }
        else {
            v1 = v1.getParent$ui();
            if(v1 == null) {
            }
            else {
            label_7:
                Node v9;
                for(v9 = this.headNode(v0); v9 != null; v9 = v9.getChild$ui()) {
                    if((v9.getAggregateChildKindSet$ui() & arg10) == 0) {
                        return;
                    }

                    if((v9.getKindSet$ui() & arg10) != 0) {
                        Node v0_1 = null;
                        Node v2 = v9;
                        MutableVector v3 = ((MutableVector)v0_1);
                        while(true) {
                        label_19:
                            if(v2 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v2 instanceof Object)) {
                                    arg11.invoke(v2);
                                }
                                else if((v2.getKindSet$ui() & arg10) != 0 && ((v2 instanceof DelegatingNode))) {
                                    Node v4 = v2.getDelegate$ui();
                                    int v6 = 0;
                                    while(v4 != null) {
                                        if((v4.getKindSet$ui() & arg10) != 0) {
                                            ++v6;
                                            if(v6 == 1) {
                                                v2 = v4;
                                            }
                                            else {
                                                if(v3 == null) {
                                                    v3 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v2 != null) {
                                                    if(v3 != null) {
                                                        v3.add(v2);
                                                    }

                                                    v2 = v0_1;
                                                }

                                                if(v3 == null) {
                                                    goto label_63;
                                                }

                                                v3.add(v4);
                                            }
                                        }

                                    label_63:
                                        v4 = v4.getChild$ui();
                                    }

                                    if(v6 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_70;
                        }

                        v2 = DelegatableNodeKt.pop(v3);
                        goto label_19;
                    }

                label_70:
                    if(v9 == v1) {
                        return;
                    }
                }
            }
        }
    }

    public long windowToLocal-MK-Hz9U(long arg4) {
        if(!this.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }

        LayoutCoordinates v0 = LayoutCoordinatesKt.findRootCoordinates(this);
        return this.localPositionOf-R5De75A(v0, Offset.minus-MK-Hz9U(LayoutNodeKt.requireOwner(this.getLayoutNode()).calculateLocalPosition-MK-Hz9U(arg4), LayoutCoordinatesKt.positionInRoot(v0)));
    }

    protected final void withPositionTranslation(Canvas arg4, Function1 arg5) {
        float v0 = ((float)IntOffset.getX-impl(this.getPosition-nOcc-ac()));
        float v3 = ((float)IntOffset.getY-impl(this.getPosition-nOcc-ac()));
        arg4.translate(v0, v3);
        arg5.invoke(arg4);
        arg4.translate(-v0, -v3);
    }

    protected final boolean withinLayerBounds-k-4lQ0M(long arg5) {
        if(Long.compare((0x7F8000007F800000L ^ arg5 & 0x7F8000007F800000L) - 0x100000001L & -9223372034707292160L, 0) == 0) {
            OwnedLayer v0 = this.layer;
            if(v0 != null && (this.isClipping)) {
                if(v0.isInLayer-k-4lQ0M(arg5)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        return 0;
    }
}

