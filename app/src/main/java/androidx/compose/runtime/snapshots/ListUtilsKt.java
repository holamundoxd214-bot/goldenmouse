package androidx.compose.runtime.snapshots;

import androidx.collection.ObjectList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A8\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A8\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A\u001E\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000\u001A>\u0010\t\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001A\u0014\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\nH\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001AD\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\r0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\r0\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A8\u0010\u000F\u001A\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00100\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A8\u0010\u0012\u001A\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00100\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A8\u0010\u0013\u001A\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00100\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001AP\u0010\u0014\u001A\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00160\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001Ab\u0010\u0018\u001A\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001B2\b\b\u0002\u0010\u001D\u001A\u00020\u001B2\b\b\u0002\u0010\u001E\u001A\u00020\u000B2\b\b\u0002\u0010\u001F\u001A\u00020\u001B2\u0016\b\u0002\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001B\u0018\u00010\u0005H\u0000\u001A}\u0010 \u001A\u0002H!\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010!*\u00060\"j\u0002`#*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010$\u001A\u0002H!2\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001B2\b\b\u0002\u0010\u001D\u001A\u00020\u001B2\b\b\u0002\u0010\u001E\u001A\u00020\u000B2\b\b\u0002\u0010\u001F\u001A\u00020\u001B2\u0016\b\u0002\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001B\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010%\u001A9\u0010&\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\"j\u0002`#2\u0006\u0010\'\u001A\u0002H\u00022\u0014\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001B\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010(\u001AF\u0010)\u001A\b\u0012\u0004\u0012\u0002H\r0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001AS\u0010*\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\'\u0010\u0011\u001A#\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00100\nH\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¨\u0006."}, d2={"fastForEach", "", "T", "", "action", "Lkotlin/Function1;", "Landroidx/collection/ObjectList;", "fastToSet", "", "fastForEachIndexed", "Lkotlin/Function2;", "", "fastMap", "R", "transform", "fastAny", "", "predicate", "fastNone", "fastAll", "fastGroupBy", "", "K", "keySelector", "fastJoinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "fastJoinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "appendElement", "element", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastMapNotNull", "fastFilterIndexed", "Lkotlin/ParameterName;", "name", "index", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ListUtilsKt {
    private static final void appendElement(Appendable arg0, Object arg1, Function1 arg2) {
        if(arg2 != null) {
            arg0.append(arg2.invoke(arg1));
            return;
        }

        boolean v2 = arg1 == null ? true : arg1 instanceof CharSequence;
        if(v2) {
            arg0.append(((CharSequence)arg1));
            return;
        }

        if((arg1 instanceof Character)) {
            arg0.append(((Character)arg1).charValue());
            return;
        }

        arg0.append(arg1.toString());
    }

    public static final boolean fastAll(List arg4, Function1 arg5) {
        int v0 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!arg5.invoke(arg4.get(v2)).booleanValue()) {
                return 0;
            }
        }

        return 1;
    }

    public static final boolean fastAny(List arg4, Function1 arg5) {
        int v0 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(arg5.invoke(arg4.get(v2)).booleanValue()) {
                return 1;
            }
        }

        return 0;
    }

    public static final List fastFilterIndexed(List arg5, Function2 arg6) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = arg5.get(v2);
            if(arg6.invoke(Integer.valueOf(v2), v3).booleanValue()) {
                v0.add(v3);
            }
        }

        return ((List)v0);
    }

    public static final void fastForEach(ObjectList arg3, Function1 arg4) {
        IntRange v0 = RangesKt.until(0, arg3._size);
        int v1 = v0.getFirst();
        int v0_1 = v0.getLast();
        if(v1 <= v0_1) {
            while(true) {
                arg4.invoke(arg3.get(v1));
                if(v1 != v0_1) {
                    ++v1;
                    continue;
                }

                return;
            }
        }
    }

    public static final void fastForEach(List arg3, Function1 arg4) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4.invoke(arg3.get(v1));
        }
    }

    public static final void fastForEachIndexed(List arg4, Function2 arg5) {
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.invoke(Integer.valueOf(v1), arg4.get(v1));
        }
    }

    public static final Map fastGroupBy(List arg7, Function1 arg8) {
        HashMap v0 = new HashMap(arg7.size());
        int v1 = arg7.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = arg7.get(v2);
            Object v4 = arg8.invoke(v3);
            HashMap v5 = v0;
            Object v6 = ((Map)v5).get(v4);
            if(v6 == null) {
                ArrayList v6_1 = new ArrayList();
                ((Map)v5).put(v4, v6_1);
            }

            ((ArrayList)v6).add(v3);
        }

        return ((Map)v0);
    }

    private static final Appendable fastJoinTo(List arg4, Appendable arg5, CharSequence arg6, CharSequence arg7, CharSequence arg8, int arg9, CharSequence arg10, Function1 arg11) {
        arg5.append(arg7);
        int v7 = arg4.size();
        int v0 = 0;
        int v1 = 0;
        while(v0 < v7) {
            Object v2 = arg4.get(v0);
            ++v1;
            if(v1 > 1) {
                arg5.append(arg6);
            }

            if(arg9 >= 0 && v1 > arg9) {
                break;
            }

            ListUtilsKt.appendElement(arg5, v2, arg11);
            ++v0;
        }

        if(arg9 >= 0 && v1 > arg9) {
            arg5.append(arg10);
        }

        arg5.append(arg8);
        return arg5;
    }

    static Appendable fastJoinTo$default(List arg6, Appendable arg7, CharSequence arg8, CharSequence arg9, CharSequence arg10, int arg11, CharSequence arg12, Function1 arg13, int arg14, Object arg15) {
        String v4;
        CharSequence v1_1;
        CharSequence v0_1;
        if((arg14 & 2) != 0) {
            String v0 = ", ";
        }
        else {
            v0_1 = arg8;
        }

        String v2 = "";
        if((arg14 & 4) != 0) {
            String v1 = v2;
        }
        else {
            v1_1 = arg9;
        }

        if((arg14 & 8) != 0) {
        }
        else {
            CharSequence v2_1 = arg10;
        }

        int v3 = (arg14 & 16) != 0 ? -1 : arg11;
        if((arg14 & 0x20) != 0) {
            v4 = "...";
        }
        else {
            CharSequence v4_1 = arg12;
        }

        Function1 v15 = (arg14 & 0x40) != 0 ? null : arg13;
        return ListUtilsKt.fastJoinTo(arg6, arg7, ((String)v0_1), ((String)v1_1), v2, v3, v4, v15);
    }

    public static final String fastJoinToString(List arg9, CharSequence arg10, CharSequence arg11, CharSequence arg12, int arg13, CharSequence arg14, Function1 arg15) {
        return ListUtilsKt.fastJoinTo(arg9, new StringBuilder(), arg10, arg11, arg12, arg13, arg14, arg15).toString();
    }

    public static String fastJoinToString$default(List arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, int arg5, CharSequence arg6, Function1 arg7, int arg8, Object arg9) {
        String v6;
        String v4;
        String v3;
        String v2;
        if((arg8 & 1) != 0) {
            v2 = ", ";
        }

        String v0 = "";
        if((arg8 & 2) != 0) {
            v3 = v0;
        }

        if((arg8 & 4) != 0) {
            v4 = v0;
        }

        if((arg8 & 8) != 0) {
            arg5 = -1;
        }

        if((arg8 & 16) != 0) {
            v6 = "...";
        }

        if((arg8 & 0x20) != 0) {
            arg7 = null;
        }

        return ListUtilsKt.fastJoinToString(arg1, ((CharSequence)v2), ((CharSequence)v3), ((CharSequence)v4), arg5, ((CharSequence)v6), arg7);
    }

    public static final List fastMap(List arg5, Function1 arg6) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(arg6.invoke(arg5.get(v2)));
        }

        return ((List)v0);
    }

    public static final List fastMapNotNull(List arg5, Function1 arg6) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = arg6.invoke(arg5.get(v2));
            if(v3 != null) {
                v0.add(v3);
            }
        }

        return ((List)v0);
    }

    public static final boolean fastNone(List arg4, Function1 arg5) {
        int v0 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(arg5.invoke(arg4.get(v2)).booleanValue()) {
                return 0;
            }
        }

        return 1;
    }

    public static final Set fastToSet(List arg4) {
        HashSet v0 = new HashSet(arg4.size());
        int v1 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(arg4.get(v2));
        }

        return ((Set)v0);
    }
}

