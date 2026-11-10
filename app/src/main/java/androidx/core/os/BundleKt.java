package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A=\u0010\u0000\u001A\u00020\u00012.\u0010\u0002\u001A\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001A\u0006\u0010\u0000\u001A\u00020\u0001¨\u0006\b"}, d2={"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class BundleKt {
    @Deprecated(message="This method does not provide type safety at compile time. Use the platform `Bundle` class directly instead.") public static final Bundle bundleOf(Pair[] arg9) {
        String v7;
        String v6;
        Object v3_1;
        Object v4;
        Intrinsics.checkNotNullParameter(arg9, "pairs");
        Bundle v0 = new Bundle(arg9.length);
        int v1 = arg9.length;
        int v2;
        for(v2 = 0; true; ++v2) {
            if(v2 >= v1) {
                return v0;
            }

            Pair v3 = arg9[v2];
            v4 = v3.component1();
            v3_1 = v3.component2();
            if(v3_1 == null) {
                v0.putString(((String)v4), null);
            }
            else if((v3_1 instanceof Boolean)) {
                v0.putBoolean(((String)v4), ((Boolean)v3_1).booleanValue());
            }
            else if((v3_1 instanceof Byte)) {
                v0.putByte(((String)v4), ((Number)v3_1).byteValue());
            }
            else if((v3_1 instanceof Character)) {
                v0.putChar(((String)v4), ((Character)v3_1).charValue());
            }
            else if((v3_1 instanceof Double)) {
                v0.putDouble(((String)v4), ((Number)v3_1).doubleValue());
            }
            else if((v3_1 instanceof Float)) {
                v0.putFloat(((String)v4), ((Number)v3_1).floatValue());
            }
            else if((v3_1 instanceof Integer)) {
                v0.putInt(((String)v4), ((Number)v3_1).intValue());
            }
            else if((v3_1 instanceof Long)) {
                v0.putLong(((String)v4), ((Number)v3_1).longValue());
            }
            else if((v3_1 instanceof Short)) {
                v0.putShort(((String)v4), ((Number)v3_1).shortValue());
            }
            else if((v3_1 instanceof Bundle)) {
                v0.putBundle(((String)v4), ((Bundle)v3_1));
            }
            else if((v3_1 instanceof CharSequence)) {
                v0.putCharSequence(((String)v4), ((CharSequence)v3_1));
            }
            else if((v3_1 instanceof Parcelable)) {
                v0.putParcelable(((String)v4), ((Parcelable)v3_1));
            }
            else if((v3_1 instanceof boolean[])) {
                v0.putBooleanArray(((String)v4), ((boolean[])v3_1));
            }
            else if((v3_1 instanceof byte[])) {
                v0.putByteArray(((String)v4), ((byte[])v3_1));
            }
            else if((v3_1 instanceof char[])) {
                v0.putCharArray(((String)v4), ((char[])v3_1));
            }
            else if((v3_1 instanceof double[])) {
                v0.putDoubleArray(((String)v4), ((double[])v3_1));
            }
            else if((v3_1 instanceof float[])) {
                v0.putFloatArray(((String)v4), ((float[])v3_1));
            }
            else if((v3_1 instanceof int[])) {
                v0.putIntArray(((String)v4), ((int[])v3_1));
            }
            else if((v3_1 instanceof long[])) {
                v0.putLongArray(((String)v4), ((long[])v3_1));
            }
            else if((v3_1 instanceof short[])) {
                v0.putShortArray(((String)v4), ((short[])v3_1));
            }
            else {
                v6 = "\"";
                v7 = " for key \"";
                if((v3_1 instanceof Object[])) {
                    Class v5 = v3_1.getClass().getComponentType();
                    Intrinsics.checkNotNull(v5);
                    if(Parcelable.class.isAssignableFrom(v5)) {
                        Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                        v0.putParcelableArray(((String)v4), ((Parcelable[])v3_1));
                    }
                    else if(String.class.isAssignableFrom(v5)) {
                        Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                        v0.putStringArray(((String)v4), ((String[])v3_1));
                    }
                    else if(CharSequence.class.isAssignableFrom(v5)) {
                        Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                        v0.putCharSequenceArray(((String)v4), ((CharSequence[])v3_1));
                    }
                    else if(Serializable.class.isAssignableFrom(v5)) {
                        v0.putSerializable(((String)v4), ((Serializable)v3_1));
                    }
                    else {
                        throw new IllegalArgumentException("Illegal value array type " + v5.getCanonicalName() + v7 + (((String)v4)) + v6);
                    }
                }
                else if((v3_1 instanceof Serializable)) {
                    v0.putSerializable(((String)v4), ((Serializable)v3_1));
                }
                else if((v3_1 instanceof IBinder)) {
                    v0.putBinder(((String)v4), ((IBinder)v3_1));
                }
                else if((v3_1 instanceof Size)) {
                    v0.putSize(((String)v4), ((Size)v3_1));
                }
                else if((v3_1 instanceof SizeF)) {
                    v0.putSizeF(((String)v4), ((SizeF)v3_1));
                }
                else {
                    break;
                }
            }
        }

        throw new IllegalArgumentException("Illegal value type " + v3_1.getClass().getCanonicalName() + v7 + (((String)v4)) + v6);
        return v0;
    }

    public static final Bundle bundleOf() {
        return new Bundle(0);
    }
}

