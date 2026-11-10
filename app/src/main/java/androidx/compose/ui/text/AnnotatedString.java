package androidx.compose.ui.text;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 D2\u00020\u0001:\u0005@ABCDB)\b\u0000\u0012\u0016\u0010\u0002\u001A\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tB=\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0014\b\u0002\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u00040\u0003\u0012\u0014\b\u0002\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u0003¢\u0006\u0004\b\b\u0010\u000EB)\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0016\b\u0002\u0010\u0002\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003¢\u0006\u0004\b\b\u0010\u000FJ\u0011\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u001BH\u0096\u0002J\u0018\u0010!\u001A\u00020\u00002\u0006\u0010\"\u001A\u00020\u001B2\u0006\u0010#\u001A\u00020\u001BH\u0016J\u0015\u0010!\u001A\u00020\u00002\u0006\u0010$\u001A\u00020%¢\u0006\u0004\b&\u0010\'J\u0011\u0010(\u001A\u00020\u00002\u0006\u0010)\u001A\u00020\u0000H\u0087\u0002J*\u0010*\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010+\u001A\u00020\u00072\u0006\u0010,\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020\u001BJ\u001E\u0010.\u001A\u00020/2\u0006\u0010+\u001A\u00020\u00072\u0006\u0010,\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020\u001BJ\"\u0010*\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010,\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020\u001BJ\"\u00100\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00040\u00032\u0006\u0010,\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020\u001BJ$\u00102\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00040\u00032\u0006\u0010,\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020\u001BH\u0007J\"\u00104\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u00040\u00032\u0006\u0010,\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020\u001BJ\u0016\u00106\u001A\u00020/2\u0006\u0010,\u001A\u00020\u001B2\u0006\u0010-\u001A\u00020\u001BJ\u0013\u00107\u001A\u00020/2\b\u0010)\u001A\u0004\u0018\u000108H\u0096\u0002J\b\u00109\u001A\u00020\u001BH\u0016J\b\u0010:\u001A\u00020\u0007H\u0016J\u000E\u0010;\u001A\u00020/2\u0006\u0010)\u001A\u00020\u0000J*\u0010<\u001A\u00020\u00002\"\u0010=\u001A\u001E\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040>J0\u0010?\u001A\u00020\u00002(\u0010=\u001A$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u00030>R$\u0010\u0002\u001A\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0011R\u001D\u0010\n\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u00040\u00038F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0011R\"\u0010\u0017\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0011R\u001D\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00038F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006E"}, d2={"Landroidx/compose/ui/text/AnnotatedString;", "", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "text", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "spanStyles", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/util/List;)V", "getAnnotations$ui_text", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "spanStylesOrNull", "getSpanStylesOrNull$ui_text", "getSpanStyles", "paragraphStylesOrNull", "getParagraphStylesOrNull$ui_text", "getParagraphStyles", "length", "", "getLength", "()I", "get", "", "index", "subSequence", "startIndex", "endIndex", "range", "Landroidx/compose/ui/text/TextRange;", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", "plus", "other", "getStringAnnotations", "tag", "start", "end", "hasStringAnnotations", "", "getTtsAnnotations", "Landroidx/compose/ui/text/TtsAnnotation;", "getUrlAnnotations", "Landroidx/compose/ui/text/UrlAnnotation;", "getLinkAnnotations", "Landroidx/compose/ui/text/LinkAnnotation;", "hasLinkAnnotations", "equals", "", "hashCode", "toString", "hasEqualAnnotations", "mapAnnotations", "transform", "Lkotlin/Function1;", "flatMapAnnotations", "Range", "Builder", "Annotation", "ExhaustiveAnnotation", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnnotatedString implements CharSequence {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\b\u0002\u0003\u0004\u0005\u0006\u0007\b\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/text/AnnotatedString$Annotation;", "", "Landroidx/compose/ui/text/AnnotatedString$ExhaustiveAnnotation;", "Landroidx/compose/ui/text/Bullet;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/ui/text/ParagraphStyle;", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/StringAnnotation;", "Landroidx/compose/ui/text/TtsAnnotation;", "Landroidx/compose/ui/text/UrlAnnotation;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Annotation {
    }

    @Metadata(d1={"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002UVB\u0011\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\n¢\u0006\u0004\b\u0005\u0010\u000BJ\u000E\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0007\u001A\u00020\bJ\u0015\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u001BH\u0007¢\u0006\u0002\b\u0017J\u0012\u0010\u0017\u001A\u00020\u00002\b\u0010\u0007\u001A\u0004\u0018\u00010\u001CH\u0016J\"\u0010\u0017\u001A\u00020\u00002\b\u0010\u0007\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004H\u0016J\u0010\u0010\u0017\u001A\u00020\u00002\u0006\u0010\u001A\u001A\u00020\u001BH\u0016J\u000E\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0007\u001A\u00020\nJ\u001E\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0007\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004J\u001E\u0010\u001F\u001A\u00020\u00182\u0006\u0010 \u001A\u00020!2\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004J\u001E\u0010\u001F\u001A\u00020\u00182\u0006\u0010 \u001A\u00020\"2\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004J&\u0010#\u001A\u00020\u00182\u0006\u0010$\u001A\u00020\b2\u0006\u0010%\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004J\u001E\u0010&\u001A\u00020\u00182\u0006\u0010\'\u001A\u00020(2\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004J \u0010)\u001A\u00020\u00182\u0006\u0010*\u001A\u00020+2\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004H\u0007J\u001E\u0010,\u001A\u00020\u00182\u0006\u0010-\u001A\u00020.2\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004J\u001E\u0010,\u001A\u00020\u00182\u0006\u0010/\u001A\u0002002\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004J\u001E\u00101\u001A\u00020\u00182\u0006\u00102\u001A\u0002032\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004J-\u00101\u001A\u00020\u00182\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u0002052\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004¢\u0006\u0004\b6\u00107J\u000E\u00108\u001A\u00020\u00042\u0006\u0010 \u001A\u00020!J\u000E\u00108\u001A\u00020\u00042\u0006\u0010 \u001A\u00020\"J\u000E\u00109\u001A\u00020\u00042\u0006\u00102\u001A\u000203JD\u0010<\u001A\u0002H=\"\b\b\u0000\u0010=*\u00020\u00112\b\b\u0002\u00104\u001A\u0002052\b\b\u0002\u00102\u001A\u0002032\u0017\u0010>\u001A\u0013\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u0002H=0?¢\u0006\u0002\b@¢\u0006\u0004\bA\u0010BJ>\u0010C\u001A\u0002H=\"\b\b\u0000\u0010=*\u00020\u0011*\u00020;2\n\b\u0002\u00102\u001A\u0004\u0018\u0001032\u0017\u0010>\u001A\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H=0?¢\u0006\u0002\b@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001A\u00020\u00042\u0006\u0010$\u001A\u00020\b2\u0006\u0010%\u001A\u00020\bJ\u000E\u0010F\u001A\u00020\u00042\u0006\u0010\'\u001A\u00020(J\u0010\u0010G\u001A\u00020\u00042\u0006\u0010*\u001A\u00020+H\u0007J\u000E\u0010H\u001A\u00020\u00042\u0006\u0010I\u001A\u00020JJ\u0006\u0010K\u001A\u00020\u0018J\u000E\u0010K\u001A\u00020\u00182\u0006\u0010L\u001A\u00020\u0004J\u0006\u0010M\u001A\u00020\nJ1\u0010N\u001A\u00020\u00182\"\u0010O\u001A\u001E\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130P\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130P0?H\u0000¢\u0006\u0002\bQJ7\u0010R\u001A\u00020\u00182(\u0010O\u001A$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130P\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130P0S0?H\u0000¢\u0006\u0002\bTR\u0012\u0010\u0007\u001A\u00060\fj\u0002`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u000E\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u0012\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00100\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u000E\u0010:\u001A\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2={"Landroidx/compose/ui/text/AnnotatedString$Builder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "capacity", "", "<init>", "(I)V", "text", "", "(Ljava/lang/String;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "styleStack", "", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "", "annotations", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "length", "getLength", "()I", "append", "", "deprecated_append_returning_void", "char", "", "", "start", "end", "addStyle", "style", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/ParagraphStyle;", "addStringAnnotation", "tag", "annotation", "addTtsAnnotation", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "addUrlAnnotation", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "addLink", "url", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "clickable", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "addBullet", "bullet", "Landroidx/compose/ui/text/Bullet;", "indentation", "Landroidx/compose/ui/unit/TextUnit;", "addBullet-r9BaKPg", "(Landroidx/compose/ui/text/Bullet;JII)V", "pushStyle", "pushBullet", "bulletScope", "Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;", "withBulletList", "R", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "withBulletList-o2QH7mI", "(JLandroidx/compose/ui/text/Bullet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withBulletListItem", "(Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;Landroidx/compose/ui/text/Bullet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "pushStringAnnotation", "pushTtsAnnotation", "pushUrlAnnotation", "pushLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "pop", "index", "toAnnotatedString", "mapAnnotations", "transform", "Landroidx/compose/ui/text/AnnotatedString$Range;", "mapAnnotations$ui_text", "flatMapAnnotations", "", "flatMapAnnotations$ui_text", "MutableRange", "BulletScope", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder implements Appendable {
        @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R&\u0010\b\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/AnnotatedString$Builder$BulletScope;", "", "builder", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString$Builder;)V", "getBuilder$ui_text", "()Landroidx/compose/ui/text/AnnotatedString$Builder;", "bulletListSettingStack", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/text/Bullet;", "getBulletListSettingStack$ui_text", "()Ljava/util/List;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BulletScope {
            public static final int $stable = 8;
            private final Builder builder;
            private final List bulletListSettingStack;

            static {
            }

            public BulletScope(Builder arg1) {
                super();
                this.builder = arg1;
                this.bulletListSettingStack = new ArrayList();
            }

            public final Builder getBuilder$ui_text() {
                return this.builder;
            }

            public final List getBulletListSettingStack$ui_text() {
                return this.bulletListSettingStack;
            }
        }

        @Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0082\b\u0018\u0000 &*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001&B+\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u0005J0\u0010\u0015\u001A\b\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00180\u001A2\b\b\u0002\u0010\u0017\u001A\u00020\u0005J\u000E\u0010\u001B\u001A\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u001C\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001E\u001A\u00020\bHÆ\u0003J<\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00028\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001A\u00020\"2\b\u0010#\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010$\u001A\u00020\u0005HÖ\u0001J\t\u0010%\u001A\u00020\bHÖ\u0001R\u0013\u0010\u0003\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0006\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u000F\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006\'"}, d2={"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "T", "", "item", "start", "", "end", "tag", "", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "()I", "getEnd", "setEnd", "(I)V", "getTag", "()Ljava/lang/String;", "toRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "defaultEnd", "R", "transform", "Lkotlin/Function1;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "equals", "", "other", "hashCode", "toString", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class MutableRange {
            @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00060\b¨\u0006\t"}, d2={"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange$Companion;", "", "<init>", "()V", "fromRange", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "T", "range", "Landroidx/compose/ui/text/AnnotatedString$Range;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
                public Companion(DefaultConstructorMarker arg1) {
                    this();
                }

                private Companion() {
                    super();
                }

                public final MutableRange fromRange(Range arg4) {
                    return new MutableRange(arg4.getItem(), arg4.getStart(), arg4.getEnd(), arg4.getTag());
                }
            }

            public static final Companion Companion;
            private int end;
            private final Object item;
            private final int start;
            private final String tag;

            static {
                MutableRange.Companion = new Companion(null);
            }

            public MutableRange(Object arg1, int arg2, int arg3, String arg4, int arg5, DefaultConstructorMarker arg6) {
                if((arg5 & 4) != 0) {
                    arg3 = 0x80000000;
                }

                if((arg5 & 8) != 0) {
                    arg4 = "";
                }

                this(arg1, arg2, arg3, arg4);
            }

            public MutableRange(Object arg1, int arg2, int arg3, String arg4) {
                super();
                this.item = arg1;
                this.start = arg2;
                this.end = arg3;
                this.tag = arg4;
            }

            public final Object component1() {
                return this.item;
            }

            public final int component2() {
                return this.start;
            }

            public final int component3() {
                return this.end;
            }

            public final String component4() {
                return this.tag;
            }

            public final MutableRange copy(Object arg1, int arg2, int arg3, String arg4) {
                return new MutableRange(arg1, arg2, arg3, arg4);
            }

            public static MutableRange copy$default(MutableRange arg0, Object arg1, int arg2, int arg3, String arg4, int arg5, Object arg6) {
                if((arg5 & 1) != 0) {
                    arg1 = arg0.item;
                }

                if((arg5 & 2) != 0) {
                    arg2 = arg0.start;
                }

                if((arg5 & 4) != 0) {
                    arg3 = arg0.end;
                }

                if((arg5 & 8) != 0) {
                    arg4 = arg0.tag;
                }

                return arg0.copy(arg1, arg2, arg3, arg4);
            }

            public boolean equals(Object arg5) {
                if(this == (((MutableRange)arg5))) {
                    return 1;
                }

                if(!(arg5 instanceof MutableRange)) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.item, ((MutableRange)arg5).item)) {
                    return 0;
                }

                if(this.start != ((MutableRange)arg5).start) {
                    return 0;
                }

                if(this.end != ((MutableRange)arg5).end) {
                    return 0;
                }

                if(!Intrinsics.areEqual(this.tag, ((MutableRange)arg5).tag)) {
                    return 0;
                }

                return 1;
            }

            public final int getEnd() {
                return this.end;
            }

            public final Object getItem() {
                return this.item;
            }

            public final int getStart() {
                return this.start;
            }

            public final String getTag() {
                return this.tag;
            }

            public int hashCode() {
                Object v0 = this.item;
                int v0_1 = v0 == null ? 0 : v0.hashCode();
                return ((v0_1 * 0x1F + Integer.hashCode(this.start)) * 0x1F + Integer.hashCode(this.end)) * 0x1F + this.tag.hashCode();
            }

            public final void setEnd(int arg1) {
                this.end = arg1;
            }

            public final Range toRange(int arg4) {
                int v0 = this.end;
                int v1 = 0x80000000;
                if(v0 == v1) {
                }
                else {
                    arg4 = v0;
                }

                v0 = arg4 != v1 ? 1 : 0;
                if(v0 == 0) {
                    InlineClassHelperKt.throwIllegalStateException("Item.end should be set first");
                }

                return new Range(this.item, this.start, arg4, this.tag);
            }

            public final Range toRange(Function1 arg3, int arg4) {
                int v0 = this.end;
                int v1 = 0x80000000;
                if(v0 == v1) {
                }
                else {
                    arg4 = v0;
                }

                v0 = arg4 != v1 ? 1 : 0;
                if(v0 == 0) {
                    InlineClassHelperKt.throwIllegalStateException("Item.end should be set first");
                }

                return new Range(arg3.invoke(this.item), this.start, arg4, this.tag);
            }

            public static Range toRange$default(MutableRange arg0, int arg1, int arg2, Object arg3) {
                if((arg2 & 1) != 0) {
                    arg1 = 0x80000000;
                }

                return arg0.toRange(arg1);
            }

            public static Range toRange$default(MutableRange arg0, Function1 arg1, int arg2, int arg3, Object arg4) {
                if((arg3 & 2) != 0) {
                    arg2 = 0x80000000;
                }

                return arg0.toRange(arg1, arg2);
            }

            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
            }
        }

        public static final int $stable = 8;
        private final List annotations;
        private final BulletScope bulletScope;
        private final List styleStack;
        private final StringBuilder text;

        static {
        }

        public Builder(AnnotatedString arg4) {
            this(0, 1, null);
            this.append(arg4);
        }

        public Builder(int arg1, int arg2, DefaultConstructorMarker arg3) {
            if((arg2 & 1) != 0) {
                arg1 = 16;
            }

            this(arg1);
        }

        public Builder() {
            this(0, 1, null);
        }

        public Builder(int arg2) {
            super();
            this.text = new StringBuilder(arg2);
            this.styleStack = new ArrayList();
            this.annotations = new ArrayList();
            this.bulletScope = new BulletScope(this);
        }

        public Builder(String arg4) {
            this(0, 1, null);
            this.append(arg4);
        }

        public final void addBullet(Bullet arg8, int arg9, int arg10) {
            this.annotations.add(new MutableRange(arg8, arg9, arg10, null, 8, null));
        }

        public final void addBullet-r9BaKPg(Bullet arg17, long arg18, int arg20, int arg21) {
            this.annotations.add(new MutableRange(new ParagraphStyle(0, 0, 0, new TextIndent(arg18, arg18, null), null, null, 0, 0, null, 503, null), arg20, arg21, null, 8, null));
            this.annotations.add(new MutableRange(arg17, arg20, arg21, null, 8, null));
        }

        public final void addLink(Clickable arg8, int arg9, int arg10) {
            this.annotations.add(new MutableRange(arg8, arg9, arg10, null, 8, null));
        }

        public final void addLink(Url arg8, int arg9, int arg10) {
            this.annotations.add(new MutableRange(arg8, arg9, arg10, null, 8, null));
        }

        public final void addStringAnnotation(String arg2, String arg3, int arg4, int arg5) {
            this.annotations.add(new MutableRange(StringAnnotation.box-impl(StringAnnotation.constructor-impl(arg3)), arg4, arg5, arg2));
        }

        public final void addStyle(SpanStyle arg8, int arg9, int arg10) {
            this.annotations.add(new MutableRange(arg8, arg9, arg10, null, 8, null));
        }

        public final void addStyle(ParagraphStyle arg8, int arg9, int arg10) {
            this.annotations.add(new MutableRange(arg8, arg9, arg10, null, 8, null));
        }

        public final void addTtsAnnotation(TtsAnnotation arg8, int arg9, int arg10) {
            this.annotations.add(new MutableRange(arg8, arg9, arg10, null, 8, null));
        }

        @Deprecated(message="Use LinkAnnotation API for links instead", replaceWith="<_subannotation>") public final void addUrlAnnotation(UrlAnnotation arg8, int arg9, int arg10) {
            this.annotations.add(new MutableRange(arg8, arg9, arg10, null, 8, null));
        }

        public final void append(String arg1) {
            this.text.append(arg1);
        }

        public final void append(AnnotatedString arg10, int arg11, int arg12) {
            int v0 = this.text.length();
            this.text.append(arg10.getText(), arg11, arg12);
            List v10 = AnnotatedStringKt.getLocalAnnotations$default(arg10, arg11, arg12, null, 4, null);
            if(v10 != null) {
                arg11 = v10.size();
                for(arg12 = 0; arg12 < arg11; ++arg12) {
                    Object v1 = v10.get(arg12);
                    this.annotations.add(new MutableRange(((Range)v1).getItem(), ((Range)v1).getStart() + v0, ((Range)v1).getEnd() + v0, ((Range)v1).getTag()));
                }
            }
        }

        public Builder append(char arg2) {
            this.text.append(arg2);
            return this;
        }

        public final void append(AnnotatedString arg10) {
            int v0 = this.text.length();
            this.text.append(arg10.getText());
            List v10 = arg10.getAnnotations$ui_text();
            if(v10 != null) {
                int v1 = v10.size();
                int v2;
                for(v2 = 0; v2 < v1; ++v2) {
                    Object v3 = v10.get(v2);
                    this.annotations.add(new MutableRange(((Range)v3).getItem(), ((Range)v3).getStart() + v0, ((Range)v3).getEnd() + v0, ((Range)v3).getTag()));
                }
            }
        }

        public Builder append(CharSequence arg2) {
            if((arg2 instanceof AnnotatedString)) {
                this.append(((AnnotatedString)arg2));
                return this;
            }

            this.text.append(arg2);
            return this;
        }

        public Builder append(CharSequence arg2, int arg3, int arg4) {
            if((arg2 instanceof AnnotatedString)) {
                this.append(((AnnotatedString)arg2), arg3, arg4);
                return this;
            }

            this.text.append(arg2, arg3, arg4);
            return this;
        }

        public Appendable append(char arg1) {
            return this.append(arg1);
        }

        public Appendable append(CharSequence arg1) {
            return this.append(arg1);
        }

        public Appendable append(CharSequence arg1, int arg2, int arg3) {
            return this.append(arg1, arg2, arg3);
        }

        @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced by the append(Char) method that returns an Appendable. This method must be kept around for binary compatibility.") public final void append(char arg1) {
            this.append(arg1);
        }

        public final void flatMapAnnotations$ui_text(Function1 arg13) {
            List v0 = this.annotations;
            ArrayList v1 = new ArrayList(v0.size());
            int v2 = v0.size();
            int v4;
            for(v4 = 0; v4 < v2; ++v4) {
                Object v5 = arg13.invoke(MutableRange.toRange$default(v0.get(v4), 0, 1, null));
                ArrayList v6 = new ArrayList(((List)v5).size());
                int v7 = v5.size();
                int v8;
                for(v8 = 0; v8 < v7; ++v8) {
                    v6.add(MutableRange.Companion.fromRange(((List)v5).get(v8)));
                }

                CollectionsKt.addAll(v1, ((Iterable)v6));
            }

            this.annotations.clear();
            this.annotations.addAll(((Collection)v1));
        }

        public final int getLength() {
            return this.text.length();
        }

        public final void mapAnnotations$ui_text(Function1 arg7) {
            int v0 = this.annotations.size();
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                this.annotations.set(v2, MutableRange.Companion.fromRange(arg7.invoke(MutableRange.toRange$default(this.annotations.get(v2), 0, 1, null))));
            }
        }

        public final void pop() {
            if(this.styleStack.isEmpty()) {
                InlineClassHelperKt.throwIllegalStateException("Nothing to pop.");
            }

            this.styleStack.remove(this.styleStack.size() - 1).setEnd(this.text.length());
        }

        public final void pop(int arg4) {
            int v0 = arg4 < this.styleStack.size() ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalStateException(arg4 + " should be less than " + this.styleStack.size());
            }

            while(this.styleStack.size() - 1 >= arg4) {
                this.pop();
            }
        }

        public final int pushBullet(Bullet arg8) {
            MutableRange v0 = new MutableRange(arg8, this.text.length(), 0, null, 12, null);
            this.styleStack.add(v0);
            this.annotations.add(v0);
            return this.styleStack.size() - 1;
        }

        public final int pushLink(LinkAnnotation arg8) {
            MutableRange v0 = new MutableRange(arg8, this.text.length(), 0, null, 12, null);
            this.styleStack.add(v0);
            this.annotations.add(v0);
            return this.styleStack.size() - 1;
        }

        public final int pushStringAnnotation(String arg8, String arg9) {
            MutableRange v0 = new MutableRange(StringAnnotation.box-impl(StringAnnotation.constructor-impl(arg9)), this.text.length(), 0, arg8, 4, null);
            this.styleStack.add(v0);
            this.annotations.add(v0);
            return this.styleStack.size() - 1;
        }

        public final int pushStyle(ParagraphStyle arg8) {
            MutableRange v0 = new MutableRange(arg8, this.text.length(), 0, null, 12, null);
            this.styleStack.add(v0);
            this.annotations.add(v0);
            return this.styleStack.size() - 1;
        }

        public final int pushStyle(SpanStyle arg8) {
            MutableRange v0 = new MutableRange(arg8, this.text.length(), 0, null, 12, null);
            this.styleStack.add(v0);
            this.annotations.add(v0);
            return this.styleStack.size() - 1;
        }

        public final int pushTtsAnnotation(TtsAnnotation arg8) {
            MutableRange v0 = new MutableRange(arg8, this.text.length(), 0, null, 12, null);
            this.styleStack.add(v0);
            this.annotations.add(v0);
            return this.styleStack.size() - 1;
        }

        @Deprecated(message="Use LinkAnnotation API for links instead", replaceWith="<_subannotation>") public final int pushUrlAnnotation(UrlAnnotation arg8) {
            MutableRange v0 = new MutableRange(arg8, this.text.length(), 0, null, 12, null);
            this.styleStack.add(v0);
            this.annotations.add(v0);
            return this.styleStack.size() - 1;
        }

        public final AnnotatedString toAnnotatedString() {
            String v0 = this.text.toString();
            List v1 = this.annotations;
            ArrayList v2 = new ArrayList(v1.size());
            int v3 = v1.size();
            int v4;
            for(v4 = 0; v4 < v3; ++v4) {
                v2.add(v1.get(v4).toRange(this.text.length()));
            }

            return new AnnotatedString(v0, ((List)v2));
        }

        public final Object withBulletList-o2QH7mI(long arg21, Bullet arg23, Function1 arg24) {
            long v5;
            Builder v1 = this;
            Object v0 = CollectionsKt.lastOrNull(v1.bulletScope.getBulletListSettingStack$ui_text());
            if(v0 != null) {
                long v2 = ((Pair)v0).getFirst().unbox-impl();
                if(!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(v2), TextUnit.getType-UIouoOA(arg21))) {
                    InlineClassHelperKt.throwIllegalStateException("Indentation unit types of nested bullet lists must match. Current " + TextUnit.toString-impl(v2) + " and previous is " + TextUnit.toString-impl(arg21));
                }

                long v4 = TextUnit.getType-UIouoOA(arg21);
                if(TextUnitType.equals-impl0(v4, TextUnitType.Companion.getSp-UIouoOA())) {
                    v2 = TextUnitKt.getSp(TextUnit.getValue-impl(arg21) + TextUnit.getValue-impl(v2));
                }
                else if(TextUnitType.equals-impl0(v4, TextUnitType.Companion.getEm-UIouoOA())) {
                    v2 = TextUnitKt.getEm(TextUnit.getValue-impl(arg21) + TextUnit.getValue-impl(v2));
                }
                else {
                    v2 = arg21;
                }

                v5 = v2;
            }
            else {
                v5 = arg21;
            }

            int v2_1 = v1.pushStyle(new ParagraphStyle(0, 0, 0, new TextIndent(v5, v5, null), null, null, 0, 0, null, 503, null));
            v1.bulletScope.getBulletListSettingStack$ui_text().add(new Pair(TextUnit.box-impl(v5), arg23));
            try {
                v0 = arg24.invoke(v1.bulletScope);
            }
            catch(Throwable v0_1) {
                if(!v1.bulletScope.getBulletListSettingStack$ui_text().isEmpty()) {
                    v1.bulletScope.getBulletListSettingStack$ui_text().remove(CollectionsKt.getLastIndex(v1.bulletScope.getBulletListSettingStack$ui_text()));
                }

                v1.pop(v2_1);
                throw v0_1;
            }

            if(!v1.bulletScope.getBulletListSettingStack$ui_text().isEmpty()) {
                v1.bulletScope.getBulletListSettingStack$ui_text().remove(CollectionsKt.getLastIndex(v1.bulletScope.getBulletListSettingStack$ui_text()));
            }

            v1.pop(v2_1);
            return v0;
        }

        public static Object withBulletList-o2QH7mI$default(Builder arg0, long arg1, Bullet arg3, Function1 arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = Bullet.Companion.getDefaultIndentation-XSAIIZE();
            }

            if((arg5 & 2) != 0) {
                arg3 = Bullet.Companion.getDefault();
            }

            return arg0.withBulletList-o2QH7mI(arg1, arg3, arg4);
        }

        public final Object withBulletListItem(BulletScope arg20, Bullet arg21, Function1 arg22) {
            Bullet v0_1;
            Object v0 = CollectionsKt.lastOrNull(arg20.getBulletListSettingStack$ui_text());
            long v1 = v0 != null ? ((Pair)v0).getFirst().unbox-impl() : Bullet.Companion.getDefaultIndentation-XSAIIZE();
            long v4 = v1;
            if(arg21 == null) {
                if(v0 != null) {
                    v0 = ((Pair)v0).getSecond();
                    if(v0 == null) {
                        goto label_13;
                    }

                    goto label_17;
                }

            label_13:
                v0_1 = Bullet.Companion.getDefault();
            }
            else {
                v0_1 = arg21;
            }

        label_17:
            int v1_1 = arg20.getBuilder$ui_text().pushStyle(new ParagraphStyle(0, 0, 0, new TextIndent(v4, v4, null), null, null, 0, 0, null, 503, null));
            int v2 = arg20.getBuilder$ui_text().pushBullet(v0_1);
            try {
                v0 = arg22.invoke(arg20.getBuilder$ui_text());
            }
            catch(Throwable v0_2) {
                arg20.getBuilder$ui_text().pop(v2);
                arg20.getBuilder$ui_text().pop(v1_1);
                throw v0_2;
            }

            arg20.getBuilder$ui_text().pop(v2);
            arg20.getBuilder$ui_text().pop(v1_1);
            return v0;
        }

        public static Object withBulletListItem$default(Builder arg0, BulletScope arg1, Bullet arg2, Function1 arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg2 = null;
            }

            return arg0.withBulletListItem(arg1, arg2, arg3);
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/text/AnnotatedString$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/AnnotatedString;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.text.AnnotatedString$Companion {
        public androidx.compose.ui.text.AnnotatedString$Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private androidx.compose.ui.text.AnnotatedString$Companion() {
            super();
        }

        public final Saver getSaver() {
            return AnnotatedString.Saver;
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/ui/text/AnnotatedString$ExhaustiveAnnotation;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "<init>", "()V", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class ExhaustiveAnnotation implements Annotation {
        public ExhaustiveAnnotation() {
            super();
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0012\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\'\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\t\u0010\u000BJ\u000E\u0010\u0014\u001A\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001A\u00020\bHÆ\u0003J<\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00028\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001D\u001A\u00020\u0005HÖ\u0001J\t\u0010\u001E\u001A\u00020\bHÖ\u0001R\u0013\u0010\u0003\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001F"}, d2={"Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "", "item", "start", "", "end", "tag", "", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "(Ljava/lang/Object;II)V", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "()I", "getEnd", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Range;", "equals", "", "other", "hashCode", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Range {
        public static final int $stable;
        private final int end;
        private final Object item;
        private final int start;
        private final String tag;

        static {
        }

        public Range(Object arg2, int arg3, int arg4) {
            this(arg2, arg3, arg4, "");
        }

        public Range(Object arg1, int arg2, int arg3, String arg4) {
            super();
            this.item = arg1;
            this.start = arg2;
            this.end = arg3;
            this.tag = arg4;
            int v0 = arg2 <= arg3 ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("Reversed range is not supported");
            }
        }

        public final Object component1() {
            return this.item;
        }

        public final int component2() {
            return this.start;
        }

        public final int component3() {
            return this.end;
        }

        public final String component4() {
            return this.tag;
        }

        public final Range copy(Object arg1, int arg2, int arg3, String arg4) {
            return new Range(arg1, arg2, arg3, arg4);
        }

        public static Range copy$default(Range arg0, Object arg1, int arg2, int arg3, String arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.item;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.start;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.end;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.tag;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((Range)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Range)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.item, ((Range)arg5).item)) {
                return 0;
            }

            if(this.start != ((Range)arg5).start) {
                return 0;
            }

            if(this.end != ((Range)arg5).end) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.tag, ((Range)arg5).tag)) {
                return 0;
            }

            return 1;
        }

        public final int getEnd() {
            return this.end;
        }

        public final Object getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            Object v0 = this.item;
            int v0_1 = v0 == null ? 0 : v0.hashCode();
            return ((v0_1 * 0x1F + Integer.hashCode(this.start)) * 0x1F + Integer.hashCode(this.end)) * 0x1F + this.tag.hashCode();
        }

        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
        }
    }

    public static final int $stable;
    public static final androidx.compose.ui.text.AnnotatedString$Companion Companion;
    private static final Saver Saver;
    private final List annotations;
    private final List paragraphStylesOrNull;
    private final List spanStylesOrNull;
    private final String text;

    static {
        AnnotatedString.Companion = new androidx.compose.ui.text.AnnotatedString$Companion(null);
        AnnotatedString.Saver = SaversKt.getAnnotatedStringSaver();
    }

    public AnnotatedString(String arg1, List arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = CollectionsKt.emptyList();
        }

        this(arg1, arg2);
    }

    public AnnotatedString(String arg2, List arg3) {
        if(((Collection)arg3).isEmpty()) {
            arg3 = null;
        }

        this(arg3, arg2);
    }

    public AnnotatedString(String arg1, List arg2, List arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = CollectionsKt.emptyList();
        }

        if((arg4 & 4) != 0) {
            arg3 = CollectionsKt.emptyList();
        }

        this(arg1, arg2, arg3);
    }

    public AnnotatedString(List arg8, String arg9) {
        int v5_1;
        List v3_1;
        ArrayList v4;
        int v2;
        super();
        this.annotations = arg8;
        this.text = arg9;
        List v0 = null;
        if(arg8 != null) {
            int v1 = arg8.size();
            v2 = 0;
            ArrayList v3 = ((ArrayList)v0);
            v4 = v3;
            while(v2 < v1) {
                Object v5 = arg8.get(v2);
                if((((Range)v5).getItem() instanceof SpanStyle)) {
                    if(v3 == null) {
                        v3 = new ArrayList();
                    }

                    Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>");
                    ((List)v3).add(v5);
                }
                else {
                    if(!(((Range)v5).getItem() instanceof ParagraphStyle)) {
                        goto label_32;
                    }

                    if(v4 == null) {
                        v4 = new ArrayList();
                    }

                    Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>");
                    ((List)v4).add(v5);
                }

            label_32:
                ++v2;
            }
        }
        else {
            v3_1 = v0;
            List v4_1 = v3_1;
        }

        this.spanStylesOrNull = v3_1;
        this.paragraphStylesOrNull = ((List)v4);
        if(v4 != null) {
            v0 = CollectionsKt.sortedWith(((Iterable)v4), new AnnotatedString$special$$inlined$sortedBy$1());
        }

        List v7 = v0;
        if(v7 != null) {
            if(((Collection)v7).isEmpty()) {
            }
            else {
                MutableIntList v7_1 = IntListKt.mutableIntListOf(CollectionsKt.first(v0).getEnd());
                int v8 = v0.size();
                for(v2 = 1; v2 < v8; ++v2) {
                    Object v3_2 = v0.get(v2);
                    while(true) {
                        MutableIntList v4_2 = v7_1;
                        if(((IntList)v4_2)._size != 0) {
                            v5_1 = v7_1.last();
                            if(((Range)v3_2).getStart() >= v5_1) {
                                v7_1.removeAt(((IntList)v4_2)._size - 1);
                                continue;
                            }
                            else {
                                break;
                            }
                        }

                        goto label_81;
                    }

                    int v4_3 = ((Range)v3_2).getEnd() <= v5_1 ? 1 : 0;
                    if(v4_3 == 0) {
                        InlineClassHelperKt.throwIllegalArgumentException("Paragraph overlap not allowed, end " + ((Range)v3_2).getEnd() + " should be less than or equal to " + v5_1);
                    }

                label_81:
                    v7_1.add(((Range)v3_2).getEnd());
                }
            }
        }
    }

    public AnnotatedString(String arg1, List arg2, List arg3) {
        this(AnnotatedStringKt.access$constructAnnotationsFromSpansAndParagraphs(arg2, arg3), arg1);
    }

    public static final Saver access$getSaver$cp() {
        return AnnotatedString.Saver;
    }

    public final char charAt(int arg1) {
        return this.get(arg1);
    }

    public boolean equals(Object arg5) {
        if(this == (((AnnotatedString)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AnnotatedString)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.text, ((AnnotatedString)arg5).text)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.annotations, ((AnnotatedString)arg5).annotations)) {
            return 0;
        }

        return 1;
    }

    public final AnnotatedString flatMapAnnotations(Function1 arg2) {
        Builder v0 = new Builder(this);
        v0.flatMapAnnotations$ui_text(arg2);
        return v0.toAnnotatedString();
    }

    public char get(int arg1) {
        return this.text.charAt(arg1);
    }

    public final List getAnnotations$ui_text() {
        return this.annotations;
    }

    public int getLength() {
        return this.text.length();
    }

    public final List getLinkAnnotations(int arg7, int arg8) {
        List v0_1;
        List v6 = this.annotations;
        if(v6 != null) {
            ArrayList v0 = new ArrayList(v6.size());
            int v1 = v6.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = v6.get(v2);
                Object v4 = v3;
                if(((((Range)v4).getItem() instanceof LinkAnnotation)) && (AnnotatedStringKt.intersect(arg7, arg8, ((Range)v4).getStart(), ((Range)v4).getEnd()))) {
                    v0.add(v3);
                }
            }
        }
        else {
            v0_1 = CollectionsKt.emptyList();
        }

        Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return v0_1;
    }

    public final List getParagraphStyles() {
        List v0 = this.paragraphStylesOrNull;
        if(v0 == null) {
            v0 = CollectionsKt.emptyList();
        }

        return v0;
    }

    public final List getParagraphStylesOrNull$ui_text() {
        return this.paragraphStylesOrNull;
    }

    public final List getSpanStyles() {
        List v0 = this.spanStylesOrNull;
        if(v0 == null) {
            v0 = CollectionsKt.emptyList();
        }

        return v0;
    }

    public final List getSpanStylesOrNull$ui_text() {
        return this.spanStylesOrNull;
    }

    public final List getStringAnnotations(String arg7, int arg8, int arg9) {
        List v6 = this.annotations;
        if(v6 != null) {
            ArrayList v0 = new ArrayList(v6.size());
            int v1 = v6.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = v6.get(v2);
                if(((((Range)v3).getItem() instanceof StringAnnotation)) && (Intrinsics.areEqual(arg7, ((Range)v3).getTag())) && (AnnotatedStringKt.intersect(arg8, arg9, ((Range)v3).getStart(), ((Range)v3).getEnd()))) {
                    v0.add(StringAnnotationKt.unbox(((Range)v3)));
                }
            }

            return ((List)v0);
        }

        return CollectionsKt.emptyList();
    }

    public final List getStringAnnotations(int arg7, int arg8) {
        List v6 = this.annotations;
        if(v6 != null) {
            ArrayList v0 = new ArrayList(v6.size());
            int v1 = v6.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = v6.get(v2);
                if(((((Range)v3).getItem() instanceof StringAnnotation)) && (AnnotatedStringKt.intersect(arg7, arg8, ((Range)v3).getStart(), ((Range)v3).getEnd()))) {
                    v0.add(StringAnnotationKt.unbox(((Range)v3)));
                }
            }

            return ((List)v0);
        }

        return CollectionsKt.emptyList();
    }

    public final String getText() {
        return this.text;
    }

    public final List getTtsAnnotations(int arg7, int arg8) {
        ArrayList v0;
        List v6 = this.annotations;
        if(v6 != null) {
            v0 = new ArrayList(v6.size());
            int v1 = v6.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = v6.get(v2);
                Object v4 = v3;
                if(((((Range)v4).getItem() instanceof TtsAnnotation)) && (AnnotatedStringKt.intersect(arg7, arg8, ((Range)v4).getStart(), ((Range)v4).getEnd()))) {
                    v0.add(v3);
                }
            }
        }
        else {
            List v0_1 = CollectionsKt.emptyList();
        }

        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return ((List)v0);
    }

    @Deprecated(message="Use LinkAnnotation API instead", replaceWith="<_subannotation>") public final List getUrlAnnotations(int arg7, int arg8) {
        List v0_1;
        List v6 = this.annotations;
        if(v6 != null) {
            ArrayList v0 = new ArrayList(v6.size());
            int v1 = v6.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = v6.get(v2);
                Object v4 = v3;
                if(((((Range)v4).getItem() instanceof UrlAnnotation)) && (AnnotatedStringKt.intersect(arg7, arg8, ((Range)v4).getStart(), ((Range)v4).getEnd()))) {
                    v0.add(v3);
                }
            }
        }
        else {
            v0_1 = CollectionsKt.emptyList();
        }

        Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return v0_1;
    }

    public final boolean hasEqualAnnotations(AnnotatedString arg1) {
        return Intrinsics.areEqual(this.annotations, arg1.annotations);
    }

    public final boolean hasLinkAnnotations(int arg6, int arg7) {
        List v5 = this.annotations;
        if(v5 != null) {
            int v1 = v5.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = v5.get(v2);
                if(((((Range)v3).getItem() instanceof LinkAnnotation)) && (AnnotatedStringKt.intersect(arg6, arg7, ((Range)v3).getStart(), ((Range)v3).getEnd()))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public final boolean hasStringAnnotations(String arg6, int arg7, int arg8) {
        List v5 = this.annotations;
        if(v5 != null) {
            int v1 = v5.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = v5.get(v2);
                if(((((Range)v3).getItem() instanceof StringAnnotation)) && (Intrinsics.areEqual(arg6, ((Range)v3).getTag())) && (AnnotatedStringKt.intersect(arg7, arg8, ((Range)v3).getStart(), ((Range)v3).getEnd()))) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public int hashCode() {
        int v0 = this.text.hashCode() * 0x1F;
        List v1 = this.annotations;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return v0 + v1_1;
    }

    public final int length() {
        return this.getLength();
    }

    public final AnnotatedString mapAnnotations(Function1 arg2) {
        Builder v0 = new Builder(this);
        v0.mapAnnotations$ui_text(arg2);
        return v0.toAnnotatedString();
    }

    public final AnnotatedString plus(AnnotatedString arg2) {
        Builder v0 = new Builder(this);
        v0.append(arg2);
        return v0.toAnnotatedString();
    }

    public AnnotatedString subSequence(int arg3, int arg4) {
        int v0 = arg3 <= arg4 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start (" + arg3 + ") should be less or equal to end (" + arg4 + ')');
        }

        if(arg3 == 0 && arg4 == this.text.length()) {
            return this;
        }

        String v0_1 = this.text.substring(arg3, arg4);
        Intrinsics.checkNotNullExpressionValue(v0_1, "substring(...)");
        return new AnnotatedString(AnnotatedStringKt.access$filterRanges(this.annotations, arg3, arg4), v0_1);
    }

    public CharSequence subSequence(int arg1, int arg2) {
        return this.subSequence(arg1, arg2);
    }

    public final AnnotatedString subSequence-5zc-tL8(long arg2) {
        return this.subSequence(TextRange.getMin-impl(arg2), TextRange.getMax-impl(arg2));
    }

    public String toString() {
        return this.text;
    }
}

