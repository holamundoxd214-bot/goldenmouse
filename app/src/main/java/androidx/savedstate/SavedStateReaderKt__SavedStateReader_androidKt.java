package androidx.savedstate;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\u001A!\u0010\u0000\u001A\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\u0010\u0004\u001A\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0002\b\u0005\u001A\u0015\u0010\u0006\u001A\u00020\u0007*\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0002\b\b\u001A3\u0010\t\u001A\u00020\n*\u00060\u0002j\u0002`\u00032\n\u0010\u000B\u001A\u00060\fj\u0002`\r2\u0010\u0010\u000E\u001A\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u000FH\u0002¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2={"contentDeepEquals", "", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "other", "contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt", "contentDeepHashCode", "", "contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt", "contentDeepToString", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt", "savedstate"}, k=5, mv={2, 0, 0}, xi=0x30, xs="androidx/savedstate/SavedStateReaderKt") final class SavedStateReaderKt__SavedStateReader_androidKt {
    public static final boolean access$contentDeepEquals(Bundle arg0, Bundle arg1) {
        return SavedStateReaderKt__SavedStateReader_androidKt.contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(arg0, arg1);
    }

    public static final int access$contentDeepHashCode(Bundle arg0) {
        return SavedStateReaderKt__SavedStateReader_androidKt.contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(arg0);
    }

    public static final void access$contentDeepToString(Bundle arg0, StringBuilder arg1, List arg2) {
        SavedStateReaderKt__SavedStateReader_androidKt.contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(arg0, arg1, arg2);
    }

    private static final boolean contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(Bundle arg6, Bundle arg7) {
        if(arg6 == arg7) {
            return 1;
        }

        if(arg6.size() != arg7.size()) {
            return 0;
        }

        Iterator v1 = arg6.keySet().iterator();
        do {
            if(!v1.hasNext()) {
                return 1;
            }

            Object v2 = v1.next();
            Object v4 = arg6.get(((String)v2));
            v2 = arg7.get(((String)v2));
            if(v4 == v2) {
                continue;
            }

            if(Intrinsics.areEqual(v4, v2)) {
                continue;
            }

            if(v4 == null) {
                return 0;
            }

            if(v2 == null) {
            }
            else {
                if(((v4 instanceof Bundle)) && ((v2 instanceof Bundle))) {
                    if(SavedStateReaderKt__SavedStateReader_androidKt.contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(((Bundle)v4), ((Bundle)v2))) {
                        continue;
                    }

                    return 0;
                }

                if(((v4 instanceof Object[])) && ((v2 instanceof Object[]))) {
                    if(ArraysKt.contentDeepEquals(((Object[])v4), ((Object[])v2))) {
                        continue;
                    }

                    return 0;
                }

                if(((v4 instanceof byte[])) && ((v2 instanceof byte[]))) {
                    if(Arrays.equals(((byte[])v4), ((byte[])v2))) {
                        continue;
                    }

                    return 0;
                }

                if(((v4 instanceof short[])) && ((v2 instanceof short[]))) {
                    if(Arrays.equals(((short[])v4), ((short[])v2))) {
                        continue;
                    }

                    return 0;
                }

                if(((v4 instanceof int[])) && ((v2 instanceof int[]))) {
                    if(Arrays.equals(((int[])v4), ((int[])v2))) {
                        continue;
                    }

                    return 0;
                }

                if(((v4 instanceof long[])) && ((v2 instanceof long[]))) {
                    if(Arrays.equals(((long[])v4), ((long[])v2))) {
                        continue;
                    }

                    return 0;
                }

                if(((v4 instanceof float[])) && ((v2 instanceof float[]))) {
                    if(Arrays.equals(((float[])v4), ((float[])v2))) {
                        continue;
                    }

                    return 0;
                }

                if(((v4 instanceof double[])) && ((v2 instanceof double[]))) {
                    if(Arrays.equals(((double[])v4), ((double[])v2))) {
                        continue;
                    }

                    return 0;
                }

                if(((v4 instanceof char[])) && ((v2 instanceof char[]))) {
                    if(Arrays.equals(((char[])v4), ((char[])v2))) {
                        continue;
                    }

                    return 0;
                }

                if(((v4 instanceof boolean[])) && ((v2 instanceof boolean[]))) {
                    if(Arrays.equals(((boolean[])v4), ((boolean[])v2))) {
                        continue;
                    }

                    return 0;
                }

                if(Intrinsics.areEqual(v4, v2)) {
                    continue;
                }
            }

            return 0;
        }
        while(true);

        return 0;
    }

    private static final int contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(Bundle arg4) {
        int v2_1;
        Iterator v0 = arg4.keySet().iterator();
        int v1;
        for(v1 = 1; v0.hasNext(); v1 = v1 * 0x1F + v2_1) {
            Object v2 = arg4.get(v0.next());
            if((v2 instanceof Bundle)) {
                v2_1 = SavedStateReaderKt__SavedStateReader_androidKt.contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(((Bundle)v2));
            }
            else if((v2 instanceof Object[])) {
                v2_1 = ArraysKt.contentDeepHashCode(((Object[])v2));
            }
            else if((v2 instanceof byte[])) {
                v2_1 = Arrays.hashCode(((byte[])v2));
            }
            else if((v2 instanceof short[])) {
                v2_1 = Arrays.hashCode(((short[])v2));
            }
            else if((v2 instanceof int[])) {
                v2_1 = Arrays.hashCode(((int[])v2));
            }
            else if((v2 instanceof long[])) {
                v2_1 = Arrays.hashCode(((long[])v2));
            }
            else if((v2 instanceof float[])) {
                v2_1 = Arrays.hashCode(((float[])v2));
            }
            else if((v2 instanceof double[])) {
                v2_1 = Arrays.hashCode(((double[])v2));
            }
            else if((v2 instanceof char[])) {
                v2_1 = Arrays.hashCode(((char[])v2));
            }
            else if((v2 instanceof boolean[])) {
                v2_1 = Arrays.hashCode(((boolean[])v2));
            }
            else if(v2 != null) {
                v2_1 = v2.hashCode();
            }
            else {
                v2_1 = 0;
            }
        }

        return v1;
    }

    private static final void contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(Bundle arg5, StringBuilder arg6, List arg7) {
        String v1_2;
        if(arg7.contains(arg5)) {
            arg6.append("[...]");
            return;
        }

        arg7.add(arg5);
        arg6.append('[');
        Iterator v0 = arg5.keySet().iterator();
        int v1;
        for(v1 = 0; v0.hasNext(); v1 = v2) {
            int v2 = v1 + 1;
            Object v3 = v0.next();
            if(v1 != 0) {
                arg6.append(", ");
            }

            arg6.append((((String)v3)) + '=');
            Object v1_1 = arg5.get(((String)v3));
            if(v1_1 == null) {
                arg6.append("null");
            }
            else if((v1_1 instanceof Bundle)) {
                SavedStateReaderKt__SavedStateReader_androidKt.contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(((Bundle)v1_1), arg6, arg7);
            }
            else if((v1_1 instanceof Object[])) {
                arg6.append(ArraysKt.contentDeepToString(((Object[])v1_1)));
            }
            else {
                String v4 = "toString(...)";
                if((v1_1 instanceof byte[])) {
                    v1_2 = Arrays.toString(((byte[])v1_1));
                    Intrinsics.checkNotNullExpressionValue(v1_2, v4);
                    arg6.append(v1_2);
                }
                else if((v1_1 instanceof short[])) {
                    v1_2 = Arrays.toString(((short[])v1_1));
                    Intrinsics.checkNotNullExpressionValue(v1_2, v4);
                    arg6.append(v1_2);
                }
                else if((v1_1 instanceof int[])) {
                    v1_2 = Arrays.toString(((int[])v1_1));
                    Intrinsics.checkNotNullExpressionValue(v1_2, v4);
                    arg6.append(v1_2);
                }
                else if((v1_1 instanceof long[])) {
                    v1_2 = Arrays.toString(((long[])v1_1));
                    Intrinsics.checkNotNullExpressionValue(v1_2, v4);
                    arg6.append(v1_2);
                }
                else if((v1_1 instanceof float[])) {
                    v1_2 = Arrays.toString(((float[])v1_1));
                    Intrinsics.checkNotNullExpressionValue(v1_2, v4);
                    arg6.append(v1_2);
                }
                else if((v1_1 instanceof double[])) {
                    v1_2 = Arrays.toString(((double[])v1_1));
                    Intrinsics.checkNotNullExpressionValue(v1_2, v4);
                    arg6.append(v1_2);
                }
                else if((v1_1 instanceof char[])) {
                    v1_2 = Arrays.toString(((char[])v1_1));
                    Intrinsics.checkNotNullExpressionValue(v1_2, v4);
                    arg6.append(v1_2);
                }
                else if((v1_1 instanceof boolean[])) {
                    v1_2 = Arrays.toString(((boolean[])v1_1));
                    Intrinsics.checkNotNullExpressionValue(v1_2, v4);
                    arg6.append(v1_2);
                }
                else {
                    arg6.append(v1_1.toString());
                }
            }
        }

        arg6.append(']');
        arg7.remove(CollectionsKt.getLastIndex(arg7));
    }
}

