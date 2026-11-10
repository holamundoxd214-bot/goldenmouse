package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0086\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\r\u001A@\u0010\u0000\u001A\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0018\u00010\u00012\u0012\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\u00012\u0012\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u0001H\u0002\u001A \u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u0001*\u00020\t2\u0006\u0010\n\u001A\u00020\u0007H\u0000\u001A*\u0010\u000B\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0002\u0018\u00010\u0001*\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u001AD\u0010\u000F\u001A\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0018\u00010\u0001*\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0016\b\u0002\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002\u001A\u001C\u0010\u0013\u001A\u00020\t*\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u001Aa\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00150\u0001\"\u0004\b\u0000\u0010\u0015*\u00020\t2\u0006\u0010\n\u001A\u00020\u00072>\b\u0004\u0010\u0016\u001A8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001B\u0012\u0004\u0012\u0002H\u00150\u0017H\u0080\b\u001A\u0014\u0010\u001C\u001A\u00020\t*\u00020\t2\b\b\u0002\u0010\u001D\u001A\u00020\u001E\u001A\u0014\u0010\u001F\u001A\u00020\t*\u00020\t2\b\b\u0002\u0010\u001D\u001A\u00020\u001E\u001A\u0014\u0010 \u001A\u00020\t*\u00020\t2\b\b\u0002\u0010\u001D\u001A\u00020\u001E\u001A\u0014\u0010!\u001A\u00020\t*\u00020\t2\b\b\u0002\u0010\u001D\u001A\u00020\u001E\u001A=\u0010\"\u001A\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u0010&\u001A\u00020\u00052\u0017\u0010\u0016\u001A\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b\'H\u0086\b¢\u0006\u0002\u0010(\u001A?\u0010\"\u001A\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u0010&\u001A\u00020\u00072\u0019\b\u0004\u0010\u0016\u001A\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b\'H\u0086\b¢\u0006\u0002\u0010)\u001AG\u0010*\u001A\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020,2\u0019\b\u0004\u0010\u0016\u001A\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b\'H\u0086\b¢\u0006\u0002\u0010.\u001A?\u0010*\u001A\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u0010/\u001A\u0002002\u0019\b\u0004\u0010\u0016\u001A\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b\'H\u0086\b¢\u0006\u0002\u00101\u001A?\u0010*\u001A\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u00102\u001A\u0002032\u0019\b\u0004\u0010\u0016\u001A\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b\'H\u0087\b¢\u0006\u0002\u00104\u001A=\u00105\u001A\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u00106\u001A\u0002072\u0017\u0010\u0016\u001A\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b\'H\u0086\b¢\u0006\u0002\u00108\u001AD\u00109\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00152\u0016\u0010:\u001A\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00150\u0002\u0018\u00010\u00012\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u001A\"\u0010;\u001A\u00020\t2\u0006\u0010<\u001A\u00020,2\u0006\u0010=\u001A\u00020\u00052\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u0007\u001A\u0016\u0010;\u001A\u00020\t2\u0006\u0010<\u001A\u00020,2\u0006\u0010\u001B\u001A\u00020\u0007\u001A\"\u0010>\u001A\u00020\t2\u0017\u0010?\u001A\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020@0\u0011¢\u0006\u0002\b\'H\u0086\b\u001A(\u0010A\u001A\u00020\u00122\u0006\u0010B\u001A\u00020\r2\u0006\u0010C\u001A\u00020\r2\u0006\u0010D\u001A\u00020\r2\u0006\u0010E\u001A\u00020\rH\u0000\u001A(\u0010F\u001A\u00020\u00122\u0006\u0010G\u001A\u00020\r2\u0006\u0010H\u001A\u00020\r2\u0006\u0010I\u001A\u00020\r2\u0006\u0010J\u001A\u00020\rH\u0000\u001A\b\u0010L\u001A\u00020\tH\u0000\"\u000E\u0010K\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2={"constructAnnotationsFromSpansAndParagraphs", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "spanStyles", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "normalizedParagraphStyles", "Landroidx/compose/ui/text/AnnotatedString;", "defaultParagraphStyle", "getLocalParagraphStyles", "start", "", "end", "getLocalAnnotations", "predicate", "Lkotlin/Function1;", "", "substringWithoutParagraphStyles", "mapEachParagraphStyle", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "annotatedString", "paragraphStyle", "toUpperCase", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "toLowerCase", "capitalize", "decapitalize", "withStyle", "R", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "style", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/SpanStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/ParagraphStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withAnnotation", "tag", "", "annotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/TtsAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/UrlAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/LinkAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "filterRanges", "ranges", "AnnotatedString", "text", "spanStyle", "buildAnnotatedString", "builder", "", "contains", "baseStart", "baseEnd", "targetStart", "targetEnd", "intersect", "lStart", "lEnd", "rStart", "rEnd", "EmptyAnnotatedString", "emptyAnnotatedString", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnnotatedStringKt {
    private static final AnnotatedString EmptyAnnotatedString;

    static {
        AnnotatedStringKt.EmptyAnnotatedString = new AnnotatedString("", null, 2, null);
    }

    public static final AnnotatedString AnnotatedString(String arg5, ParagraphStyle arg6) {
        return new AnnotatedString(arg5, CollectionsKt.emptyList(), CollectionsKt.listOf(new Range(arg6, 0, arg5.length())));
    }

    public static final AnnotatedString AnnotatedString(String arg4, SpanStyle arg5, ParagraphStyle arg6) {
        List v5 = CollectionsKt.listOf(new Range(arg5, 0, arg4.length()));
        List v6 = arg6 == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(new Range(arg6, 0, arg4.length()));
        return new AnnotatedString(arg4, v5, v6);
    }

    public static AnnotatedString AnnotatedString$default(String arg0, SpanStyle arg1, ParagraphStyle arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = null;
        }

        return AnnotatedStringKt.AnnotatedString(arg0, arg1, arg2);
    }

    public static final List access$constructAnnotationsFromSpansAndParagraphs(List arg0, List arg1) {
        return AnnotatedStringKt.constructAnnotationsFromSpansAndParagraphs(arg0, arg1);
    }

    public static final List access$filterRanges(List arg0, int arg1, int arg2) {
        return AnnotatedStringKt.filterRanges(arg0, arg1, arg2);
    }

    public static final AnnotatedString access$substringWithoutParagraphStyles(AnnotatedString arg0, int arg1, int arg2) {
        return AnnotatedStringKt.substringWithoutParagraphStyles(arg0, arg1, arg2);
    }

    public static final AnnotatedString buildAnnotatedString(Function1 arg4) {
        Builder v0 = new Builder(0, 1, null);
        arg4.invoke(v0);
        return v0.toAnnotatedString();
    }

    public static final AnnotatedString capitalize(AnnotatedString arg1, LocaleList arg2) {
        return JvmAnnotatedString_jvmKt.transform(arg1, new AnnotatedStringKt$$ExternalSyntheticLambda1(arg2));
    }

    public static AnnotatedString capitalize$default(AnnotatedString arg0, LocaleList arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = LocaleList.Companion.getCurrent();
        }

        return AnnotatedStringKt.capitalize(arg0, arg1);
    }

    static final String capitalize$lambda$0(LocaleList arg1, String arg2, int arg3, int arg4) {
        String v0 = "substring(...)";
        if(arg3 == 0) {
            arg2 = arg2.substring(arg3, arg4);
            Intrinsics.checkNotNullExpressionValue(arg2, v0);
            return StringKt.capitalize(arg2, arg1);
        }

        String v1 = arg2.substring(arg3, arg4);
        Intrinsics.checkNotNullExpressionValue(v1, v0);
        return v1;
    }

    private static final List constructAnnotationsFromSpansAndParagraphs(List arg5, List arg6) {
        if((arg5.isEmpty()) && (arg6.isEmpty())) {
            return null;
        }

        if(arg6.isEmpty()) {
            return arg5;
        }

        if(arg5.isEmpty()) {
            return arg6;
        }

        ArrayList v0 = new ArrayList(arg5.size() + arg6.size());
        int v1 = arg5.size();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            v0.add(arg5.get(v3));
        }

        int v5 = arg6.size();
        while(v2 < v5) {
            v0.add(arg6.get(v2));
            ++v2;
        }

        return ((List)v0);
    }

    public static final boolean contains(int arg2, int arg3, int arg4, int arg5) {
        if(arg2 <= arg4 && arg5 <= arg3) {
            if(arg3 == arg5) {
                arg4 = arg4 == arg5 ? 1 : 0;
                arg2 = arg2 == arg3 ? 1 : 0;
                if(arg4 != arg2) {
                    return 0;
                }
            }

            return 1;
        }

        return 0;
    }

    public static final AnnotatedString decapitalize(AnnotatedString arg1, LocaleList arg2) {
        return JvmAnnotatedString_jvmKt.transform(arg1, new AnnotatedStringKt$$ExternalSyntheticLambda0(arg2));
    }

    public static AnnotatedString decapitalize$default(AnnotatedString arg0, LocaleList arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = LocaleList.Companion.getCurrent();
        }

        return AnnotatedStringKt.decapitalize(arg0, arg1);
    }

    static final String decapitalize$lambda$0(LocaleList arg1, String arg2, int arg3, int arg4) {
        String v0 = "substring(...)";
        if(arg3 == 0) {
            arg2 = arg2.substring(arg3, arg4);
            Intrinsics.checkNotNullExpressionValue(arg2, v0);
            return StringKt.decapitalize(arg2, arg1);
        }

        String v1 = arg2.substring(arg3, arg4);
        Intrinsics.checkNotNullExpressionValue(v1, v0);
        return v1;
    }

    public static final AnnotatedString emptyAnnotatedString() {
        return AnnotatedStringKt.EmptyAnnotatedString;
    }

    private static final List filterRanges(List arg10, int arg11, int arg12) {
        ArrayList v1_2;
        int v0 = 0;
        int v1 = arg11 <= arg12 ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start (" + arg11 + ") should be less than or equal to end (" + arg12 + ')');
        }

        List v1_1 = null;
        if(arg10 == null) {
            return v1_1;
        }

        ArrayList v2 = new ArrayList(arg10.size());
        int v3 = arg10.size();
        while(v0 < v3) {
            Object v4 = arg10.get(v0);
            if(AnnotatedStringKt.intersect(arg11, arg12, ((Range)v4).getStart(), ((Range)v4).getEnd())) {
                v2.add(new Range(((Range)v4).getItem(), Math.max(arg11, ((Range)v4).getStart()) - arg11, Math.min(arg12, ((Range)v4).getEnd()) - arg11, ((Range)v4).getTag()));
            }

            ++v0;
        }

        if(((Collection)v2).isEmpty()) {
        }
        else {
            v1_2 = v2;
        }

        return ((List)v1_2);
    }

    private static final List getLocalAnnotations(AnnotatedString arg9, int arg10, int arg11, Function1 arg12) {
        ArrayList v9;
        List v0 = null;
        if(arg10 == arg11) {
            return v0;
        }

        List v1 = arg9.getAnnotations$ui_text();
        if(v1 == null) {
            return v0;
        }

        int v0_1 = 0;
        if(arg10 == 0 && arg11 >= arg9.getText().length()) {
            if(arg12 == null) {
                return v1;
            }
            else {
                v9 = new ArrayList(v1.size());
                arg10 = v1.size();
                while(v0_1 < arg10) {
                    Object v11 = v1.get(v0_1);
                    if(arg12.invoke(v11.getItem()).booleanValue()) {
                        v9.add(v11);
                    }

                    ++v0_1;
                }

                return ((List)v9);
            }
        }

        v9 = new ArrayList(v1.size());
        int v2 = v1.size();
        while(v0_1 < v2) {
            Object v3 = v1.get(v0_1);
            boolean v4 = arg12 != null ? arg12.invoke(((Range)v3).getItem()).booleanValue() : true;
            if((v4) && (AnnotatedStringKt.intersect(arg10, arg11, ((Range)v3).getStart(), ((Range)v3).getEnd()))) {
                v9.add(new Range(((Range)v3).getItem(), RangesKt.coerceIn(((Range)v3).getStart(), arg10, arg11) - arg10, RangesKt.coerceIn(((Range)v3).getEnd(), arg10, arg11) - arg10, ((Range)v3).getTag()));
            }

            ++v0_1;
        }

        return ((List)v9);
    }

    static List getLocalAnnotations$default(AnnotatedString arg0, int arg1, int arg2, Function1 arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        return AnnotatedStringKt.getLocalAnnotations(arg0, arg1, arg2, arg3);
    }

    private static final List getLocalParagraphStyles(AnnotatedString arg8, int arg9, int arg10) {
        List v0 = null;
        if(arg9 == arg10) {
            return v0;
        }

        List v1 = arg8.getParagraphStylesOrNull$ui_text();
        if(v1 == null) {
            return v0;
        }

        if(arg9 == 0 && arg10 >= arg8.getText().length()) {
            return v1;
        }

        ArrayList v8 = new ArrayList(v1.size());
        int v0_1 = v1.size();
        int v2;
        for(v2 = 0; v2 < v0_1; ++v2) {
            Object v3 = v1.get(v2);
            if(AnnotatedStringKt.intersect(arg9, arg10, ((Range)v3).getStart(), ((Range)v3).getEnd())) {
                ArrayList v4 = v8;
                Object v6 = ((Range)v3).getItem();
                int v7 = ((Range)v3).getStart();
                if(v7 < arg9) {
                    v7 = arg9;
                }

                if(v7 > arg10) {
                    v7 = arg10;
                }

                v7 -= arg9;
                int v3_1 = ((Range)v3).getEnd();
                if(v3_1 < arg9) {
                    v3_1 = arg9;
                }

                if(v3_1 > arg10) {
                    v3_1 = arg10;
                }

                ((Collection)v4).add(new Range(v6, v7, v3_1 - arg9));
            }
        }

        return ((List)v8);
    }

    public static final boolean intersect(int arg4, int arg5, int arg6, int arg7) {
        int v0 = 1;
        int v2 = arg4 == arg5 ? 1 : 0;
        int v3 = arg6 == arg7 ? 1 : 0;
        v2 |= v3;
        v3 = arg4 == arg6 ? 1 : 0;
        v2 &= v3;
        arg4 = arg4 < arg7 ? 1 : 0;
        if(arg6 < arg5) {
        }
        else {
            v0 = 0;
        }

        return arg4 & v0 | v2;
    }

    public static final List mapEachParagraphStyle(AnnotatedString arg7, ParagraphStyle arg8, Function2 arg9) {
        List v8 = AnnotatedStringKt.normalizedParagraphStyles(arg7, arg8);
        ArrayList v0 = new ArrayList(v8.size());
        int v1 = v8.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = v8.get(v2);
            v0.add(arg9.invoke(AnnotatedStringKt.substringWithoutParagraphStyles(arg7, ((Range)v3).getStart(), ((Range)v3).getEnd()), v3));
        }

        return ((List)v0);
    }

    public static final List normalizedParagraphStyles(AnnotatedString arg16, ParagraphStyle arg17) {
        Object v10;
        ParagraphStyle v0 = arg17;
        List v1 = arg16.getParagraphStylesOrNull$ui_text();
        if(v1 != null) {
            v1 = CollectionsKt.sortedWith(((Iterable)v1), new AnnotatedStringKt$normalizedParagraphStyles$$inlined$sortedBy$1());
            if(v1 == null) {
                goto label_7;
            }
        }
        else {
        label_7:
            v1 = CollectionsKt.emptyList();
        }

        ArrayList v2 = new ArrayList();
        ArrayDeque v3 = new ArrayDeque();
        int v4 = v1.size();
        int v6 = 0;
        int v7 = 0;
        while(true) {
            if(v6 < v4) {
                Object v9 = v1.get(v6);
                Range v8 = Range.copy$default(((Range)v9), v0.merge(((Range)v9).getItem()), 0, 0, null, 14, null);
                while(true) {
                label_28:
                    if(v7 < v8.getStart()) {
                        ArrayDeque v9_1 = v3;
                        if(!((Collection)v9_1).isEmpty()) {
                            v10 = v3.last();
                            if(v8.getStart() < ((Range)v10).getEnd()) {
                                ((List)v2).add(new Range(((Range)v10).getItem(), v7, v8.getStart()));
                                v7 = v8.getStart();
                                continue;
                            }
                            else {
                                break;
                            }
                        }
                    }

                    goto label_57;
                }

                ((List)v2).add(new Range(((Range)v10).getItem(), v7, ((Range)v10).getEnd()));
                v7 = ((Range)v10).getEnd();
                break;
            label_57:
                if(v7 < v8.getStart()) {
                    ((List)v2).add(new Range(v0, v7, v8.getStart()));
                    v7 = v8.getStart();
                }

                v9 = v3.lastOrNull();
                if(v9 != null) {
                    if(((Range)v9).getStart() == v8.getStart() && ((Range)v9).getEnd() == v8.getEnd()) {
                        v3.removeLast();
                        v3.add(new Range(((Range)v9).getItem().merge(v8.getItem()), v8.getStart(), v8.getEnd()));
                        goto label_120;
                    }

                    if(((Range)v9).getStart() == ((Range)v9).getEnd()) {
                        ((List)v2).add(new Range(((Range)v9).getItem(), ((Range)v9).getStart(), ((Range)v9).getEnd()));
                        v3.removeLast();
                        v3.add(new Range(v8.getItem(), v8.getStart(), v8.getEnd()));
                        goto label_120;
                    }

                    if(((Range)v9).getEnd() >= v8.getEnd()) {
                        v3.add(new Range(((Range)v9).getItem().merge(v8.getItem()), v8.getStart(), v8.getEnd()));
                        goto label_120;
                    }

                    throw new IllegalArgumentException();
                }
                else {
                    v3.add(new Range(v8.getItem(), v8.getStart(), v8.getEnd()));
                }

            label_120:
                ++v6;
                continue;
            }

            goto label_122;
        }

        while(true) {
            if(((Collection)v9_1).isEmpty()) {
                goto label_28;
            }

            if(v7 != v3.last().getEnd()) {
                goto label_28;
            }

            v3.removeLast();
        }

        do {
        label_122:
            if(v7 <= arg16.getText().length()) {
                ArrayDeque v1_1 = v3;
                if(!((Collection)v1_1).isEmpty()) {
                    Object v4_1 = v3.last();
                    ((List)v2).add(new Range(((Range)v4_1).getItem(), v7, ((Range)v4_1).getEnd()));
                    v7 = ((Range)v4_1).getEnd();
                    while(true) {
                    label_135:
                        if(((Collection)v1_1).isEmpty()) {
                            goto label_122;
                        }

                        if(v7 != v3.last().getEnd()) {
                            goto label_122;
                        }

                        goto label_140;
                    }
                }
            }

            goto label_142;
        }
        while(true);

    label_140:
        v3.removeLast();
        goto label_135;
    label_142:
        if(v7 < arg16.getText().length()) {
            ((List)v2).add(new Range(v0, v7, arg16.getText().length()));
        }

        if(((List)v2).isEmpty()) {
            ((List)v2).add(new Range(v0, 0, 0));
        }

        return ((List)v2);
    }

    private static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString arg3, int arg4, int arg5) {
        String v1;
        if(arg4 != arg5) {
            v1 = arg3.getText().substring(arg4, arg5);
            Intrinsics.checkNotNullExpressionValue(v1, "substring(...)");
        }
        else {
            v1 = "";
        }

        List v3 = AnnotatedStringKt.getLocalAnnotations(arg3, arg4, arg5, new AnnotatedStringKt$$ExternalSyntheticLambda3());
        if(v3 == null) {
            v3 = CollectionsKt.emptyList();
        }

        return new AnnotatedString(v1, v3);
    }

    static final boolean substringWithoutParagraphStyles$lambda$0(Annotation arg0) {
        return arg0 instanceof ParagraphStyle ^ 1;
    }

    public static final AnnotatedString toLowerCase(AnnotatedString arg1, LocaleList arg2) {
        return JvmAnnotatedString_jvmKt.transform(arg1, new AnnotatedStringKt$$ExternalSyntheticLambda4(arg2));
    }

    public static AnnotatedString toLowerCase$default(AnnotatedString arg0, LocaleList arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = LocaleList.Companion.getCurrent();
        }

        return AnnotatedStringKt.toLowerCase(arg0, arg1);
    }

    static final String toLowerCase$lambda$0(LocaleList arg0, String arg1, int arg2, int arg3) {
        arg1 = arg1.substring(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(arg1, "substring(...)");
        return StringKt.toLowerCase(arg1, arg0);
    }

    public static final AnnotatedString toUpperCase(AnnotatedString arg1, LocaleList arg2) {
        return JvmAnnotatedString_jvmKt.transform(arg1, new AnnotatedStringKt$$ExternalSyntheticLambda2(arg2));
    }

    public static AnnotatedString toUpperCase$default(AnnotatedString arg0, LocaleList arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = LocaleList.Companion.getCurrent();
        }

        return AnnotatedStringKt.toUpperCase(arg0, arg1);
    }

    static final String toUpperCase$lambda$0(LocaleList arg0, String arg1, int arg2, int arg3) {
        arg1 = arg1.substring(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(arg1, "substring(...)");
        return StringKt.toUpperCase(arg1, arg0);
    }

    public static final Object withAnnotation(Builder arg0, TtsAnnotation arg1, Function1 arg2) {
        Object v2_1;
        int v1 = arg0.pushTtsAnnotation(arg1);
        try {
            v2_1 = arg2.invoke(arg0);
        }
        catch(Throwable v2) {
            arg0.pop(v1);
            throw v2;
        }

        arg0.pop(v1);
        return v2_1;
    }

    @Deprecated(message="Use LinkAnnotation API for links instead", replaceWith="<_subannotation>") public static final Object withAnnotation(Builder arg0, UrlAnnotation arg1, Function1 arg2) {
        Object v2_1;
        int v1 = arg0.pushUrlAnnotation(arg1);
        try {
            v2_1 = arg2.invoke(arg0);
        }
        catch(Throwable v2) {
            arg0.pop(v1);
            throw v2;
        }

        arg0.pop(v1);
        return v2_1;
    }

    public static final Object withAnnotation(Builder arg0, String arg1, String arg2, Function1 arg3) {
        Object v2_1;
        int v1 = arg0.pushStringAnnotation(arg1, arg2);
        try {
            v2_1 = arg3.invoke(arg0);
        }
        catch(Throwable v2) {
            arg0.pop(v1);
            throw v2;
        }

        arg0.pop(v1);
        return v2_1;
    }

    public static final Object withLink(Builder arg0, LinkAnnotation arg1, Function1 arg2) {
        Object v2_1;
        int v1 = arg0.pushLink(arg1);
        try {
            v2_1 = arg2.invoke(arg0);
        }
        catch(Throwable v2) {
            arg0.pop(v1);
            throw v2;
        }

        arg0.pop(v1);
        return v2_1;
    }

    public static final Object withStyle(Builder arg0, ParagraphStyle arg1, Function1 arg2) {
        Object v2_1;
        int v1 = arg0.pushStyle(arg1);
        try {
            v2_1 = arg2.invoke(arg0);
        }
        catch(Throwable v2) {
            arg0.pop(v1);
            throw v2;
        }

        arg0.pop(v1);
        return v2_1;
    }

    public static final Object withStyle(Builder arg0, SpanStyle arg1, Function1 arg2) {
        Object v2_1;
        int v1 = arg0.pushStyle(arg1);
        try {
            v2_1 = arg2.invoke(arg0);
        }
        catch(Throwable v2) {
            arg0.pop(v1);
            throw v2;
        }

        arg0.pop(v1);
        return v2_1;
    }
}

