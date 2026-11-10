package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A;\u0010\u0000\u001A\u00020\u00012.\u0010\u0002\u001A\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair[] arg6) {
        Object v3_1;
        Object v4;
        Intrinsics.checkNotNullParameter(arg6, "pairs");
        ContentValues v0 = new ContentValues(arg6.length);
        int v1 = arg6.length;
        int v2;
        for(v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                return v0;
            }

            Pair v3 = arg6[v2];
            v4 = v3.component1();
            v3_1 = v3.component2();
            if(v3_1 == null) {
                v0.putNull(((String)v4));
            }
            else if((v3_1 instanceof String)) {
                v0.put(((String)v4), ((String)v3_1));
            }
            else if((v3_1 instanceof Integer)) {
                v0.put(((String)v4), ((Integer)v3_1));
            }
            else if((v3_1 instanceof Long)) {
                v0.put(((String)v4), ((Long)v3_1));
            }
            else if((v3_1 instanceof Boolean)) {
                v0.put(((String)v4), ((Boolean)v3_1));
            }
            else if((v3_1 instanceof Float)) {
                v0.put(((String)v4), ((Float)v3_1));
            }
            else if((v3_1 instanceof Double)) {
                v0.put(((String)v4), ((Double)v3_1));
            }
            else if((v3_1 instanceof byte[])) {
                v0.put(((String)v4), ((byte[])v3_1));
            }
            else if((v3_1 instanceof Byte)) {
                v0.put(((String)v4), ((Byte)v3_1));
            }
            else if((v3_1 instanceof Short)) {
                v0.put(((String)v4), ((Short)v3_1));
            }
            else {
                break;
            }
        }

        throw new IllegalArgumentException("Illegal value type " + v3_1.getClass().getCanonicalName() + " for key \"" + (((String)v4)) + "\"");
        return v0;
    }
}

