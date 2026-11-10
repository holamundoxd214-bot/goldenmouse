package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001A\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\"\u0010\u0003\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u000E\u0010\u0005\u001A\u00020\u0001*\u00020\u0001H\u0087\u0080\u0004\u001A\u0018\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0018\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\b\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0013\u0010\t\u001A\u00020\n*\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u000B\u001A#\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\b\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u000E\u001AK\u0010\u000F\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0011\u001A\u00020\n2\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r2\u0014\u0010\u0013\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0082\u0088\u0004¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2={"trimMargin", "", "marginPrefix", "replaceIndentByMargin", "newIndent", "trimIndent", "replaceIndent", "prependIndent", "indent", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "getIndentFunction", "Lkotlin/Function1;", "getIndentFunction$StringsKt__IndentKt", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public static String $r8$lambda$3BvvMery65JEhzYBhCrX5rYm0VE(String arg0) {
        return StringsKt__IndentKt.getIndentFunction$lambda$0$StringsKt__IndentKt(arg0);
    }

    public static String $r8$lambda$42ieJlZRMv6w-QjCqSPAMJL39OY(String arg0, String arg1) {
        return StringsKt__IndentKt.prependIndent$lambda$0$StringsKt__IndentKt(arg0, arg1);
    }

    public static String $r8$lambda$fNhk8osE5fmKswSs2oW3GpnF78I(String arg0, String arg1) {
        return StringsKt__IndentKt.getIndentFunction$lambda$1$StringsKt__IndentKt(arg0, arg1);
    }

    public StringsKt__IndentKt() {
        super();
    }

    private static final Function1 getIndentFunction$StringsKt__IndentKt(String arg1) {
        if(arg1.length() == 0) {
            return new StringsKt__IndentKt$$ExternalSyntheticLambda1();
        }

        return new StringsKt__IndentKt$$ExternalSyntheticLambda2(arg1);
    }

    private static final String getIndentFunction$lambda$0$StringsKt__IndentKt(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "line");
        return arg1;
    }

    private static final String getIndentFunction$lambda$1$StringsKt__IndentKt(String arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "line");
        return arg1 + arg2;
    }

    private static final int indentWidth$StringsKt__IndentKt(String arg5) {
        int v3;
        String v0 = arg5;
        int v1 = ((CharSequence)v0).length();
        int v2 = 0;
        while(true) {
            v3 = -1;
            if(v2 >= v1) {
                break;
            }
            else if(!CharsKt.isWhitespace(((CharSequence)v0).charAt(v2))) {
            }
            else {
                ++v2;
                continue;
            }

            goto label_12;
        }

        v2 = v3;
    label_12:
        if(v2 == v3) {
            return arg5.length();
        }

        return v2;
    }

    public static final String prependIndent(String arg10, String arg11) {
        Intrinsics.checkNotNullParameter(arg10, "<this>");
        Intrinsics.checkNotNullParameter(arg11, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence(((CharSequence)arg10)), new StringsKt__IndentKt$$ExternalSyntheticLambda0(arg11)), "\n", null, null, 0, null, null, 62, null);
    }

    public static String prependIndent$default(String arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = "    ";
        }

        return StringsKt.prependIndent(arg0, arg1);
    }

    private static final String prependIndent$lambda$0$StringsKt__IndentKt(String arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "it");
        if(StringsKt.isBlank(arg3)) {
            if(arg3.length() < arg2.length()) {
                return arg2;
            }

            return arg3;
        }

        return arg2 + arg3;
    }

    private static final String reindent$StringsKt__IndentKt(List arg12, int arg13, Function1 arg14, Function1 arg15) {
        int v0 = CollectionsKt.getLastIndex(arg12);
        ArrayList v1 = new ArrayList();
        Iterator v12 = ((Iterable)arg12).iterator();
        int v2;
        for(v2 = 0; v12.hasNext(); v2 = v4) {
            Object v3 = v12.next();
            int v4 = v2 + 1;
            if(v2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            if(v2 != 0 && v2 != v0) {
                goto label_18;
            }
            else if(StringsKt.isBlank(v3)) {
                v3 = null;
            }
            else {
            label_18:
                Object v2_1 = arg15.invoke(v3);
                if(v2_1 != null) {
                    v2_1 = arg14.invoke(v2_1);
                    if(v2_1 == null) {
                    }
                    else {
                        v3 = v2_1;
                    }
                }
            }

            if(v3 != null) {
                ((Collection)v1).add(v3);
            }
        }

        return CollectionsKt.joinTo$default(v1, new StringBuilder(arg13), "\n", null, null, 0, null, null, 0x7C, null).toString();
    }

    public static final String replaceIndent(String arg17, String arg18) {
        String v0 = arg17;
        Intrinsics.checkNotNullParameter(v0, "<this>");
        String v2 = arg18;
        Intrinsics.checkNotNullParameter(v2, "newIndent");
        List v1 = StringsKt.lines(v0);
        List v3 = v1;
        ArrayList v4 = new ArrayList();
        Iterator v5 = ((Iterable)v3).iterator();
        while(v5.hasNext()) {
            Object v6 = v5.next();
            if(StringsKt.isBlank(v6)) {
                continue;
            }

            ((Collection)v4).add(v6);
        }

        ArrayList v5_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v4), 10));
        Iterator v4_1 = ((Iterable)v4).iterator();
        while(v4_1.hasNext()) {
            ((Collection)v5_1).add(Integer.valueOf(StringsKt__IndentKt.indentWidth$StringsKt__IndentKt(v4_1.next())));
        }

        Comparable v4_2 = CollectionsKt.minOrNull(((Iterable)v5_1));
        int v5_2 = 0;
        int v4_3 = v4_2 != null ? ((Integer)v4_2).intValue() : 0;
        int v0_1 = v0.length() + v2.length() * v1.size();
        Function1 v2_1 = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(v2);
        int v1_1 = CollectionsKt.getLastIndex(v1);
        ArrayList v6_1 = new ArrayList();
        Iterator v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            Object v7 = v3_1.next();
            int v8 = v5_2 + 1;
            if(v5_2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            if(v5_2 != 0 && v5_2 != v1_1) {
                goto label_61;
            }
            else if(StringsKt.isBlank(v7)) {
                v7 = null;
            }
            else {
            label_61:
                String v5_3 = StringsKt.drop(((String)v7), v4_3);
                if(v5_3 != null) {
                    Object v5_4 = v2_1.invoke(v5_3);
                    if(v5_4 == null) {
                    }
                    else {
                        v7 = v5_4;
                    }
                }
            }

            if(v7 != null) {
                ((Collection)v6_1).add(v7);
            }

            v5_2 = v8;
        }

        return CollectionsKt.joinTo$default(v6_1, new StringBuilder(v0_1), "\n", null, null, 0, null, null, 0x7C, null).toString();
    }

    public static String replaceIndent$default(String arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = "";
        }

        return StringsKt.replaceIndent(arg0, arg1);
    }

    public static final String replaceIndentByMargin(String arg13, String arg14, String arg15) {
        int v10;
        String v8;
        Intrinsics.checkNotNullParameter(arg13, "<this>");
        Intrinsics.checkNotNullParameter(arg14, "newIndent");
        Intrinsics.checkNotNullParameter(arg15, "marginPrefix");
        if(!StringsKt.isBlank(arg15)) {
            List v0 = StringsKt.lines(arg13);
            int v13 = arg13.length() + arg14.length() * v0.size();
            Function1 v14 = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(arg14);
            int v1 = CollectionsKt.getLastIndex(v0);
            ArrayList v2 = new ArrayList();
            Iterator v0_1 = ((Iterable)v0).iterator();
            int v4 = 0;
            while(v0_1.hasNext()) {
                Object v5 = v0_1.next();
                int v6 = v4 + 1;
                if(v4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }

                Object v7 = v5;
                String v5_1 = null;
                if(v4 != 0 && v4 != v1) {
                    goto label_39;
                }
                else if(StringsKt.isBlank(v7)) {
                    v8 = arg15;
                    v7 = v5_1;
                }
                else {
                label_39:
                    Object v4_1 = v7;
                    int v8_1 = ((CharSequence)v4_1).length();
                    int v9 = 0;
                    while(true) {
                        v10 = -1;
                        if(v9 >= v8_1) {
                            break;
                        }
                        else if(!CharsKt.isWhitespace(((CharSequence)v4_1).charAt(v9))) {
                        }
                        else {
                            ++v9;
                            continue;
                        }

                        goto label_51;
                    }

                    v9 = v10;
                label_51:
                    if(v9 == v10) {
                        v8 = arg15;
                    }
                    else {
                        v8 = arg15;
                        if(StringsKt.startsWith$default(((String)v7), v8, v9, false, 4, null)) {
                            v9 += v8.length();
                            Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type java.lang.String");
                            v5_1 = ((String)v7).substring(v9);
                            Intrinsics.checkNotNullExpressionValue(v5_1, "substring(...)");
                        }
                    }

                    if(v5_1 == null) {
                        goto label_72;
                    }

                    Object v15 = v14.invoke(v5_1);
                    if(v15 == null) {
                        goto label_72;
                    }

                    v7 = v15;
                }

            label_72:
                if(v7 != null) {
                    ((Collection)v2).add(v7);
                }

                v4 = v6;
                arg15 = v8;
            }

            return CollectionsKt.joinTo$default(v2, new StringBuilder(v13), "\n", null, null, 0, null, null, 0x7C, null).toString();
        }

        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static String replaceIndentByMargin$default(String arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = "";
        }

        if((arg3 & 2) != 0) {
            arg2 = "|";
        }

        return StringsKt.replaceIndentByMargin(arg0, arg1, arg2);
    }

    public static final String trimIndent(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.replaceIndent(arg1, "");
    }

    public static final String trimMargin(String arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "marginPrefix");
        return StringsKt.replaceIndentByMargin(arg1, "", arg2);
    }

    public static String trimMargin$default(String arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = "|";
        }

        return StringsKt.trimMargin(arg0, arg1);
    }
}

