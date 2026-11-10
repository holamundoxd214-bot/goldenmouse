package androidx.core.os;

import android.os.BadParcelableException;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ParcelCompat {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static List readParcelableList(Parcel arg0, List arg1, ClassLoader arg2) {
            return arg0.readParcelableList(arg1, arg2);
        }

        static void writeBoolean(Parcel arg0, boolean arg1) {
            arg0.writeBoolean(arg1);
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static Parcelable$Creator readParcelableCreator(Parcel arg0, ClassLoader arg1) {
            return arg0.readParcelableCreator(arg1);
        }
    }

    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static Object[] readArray(Parcel arg0, ClassLoader arg1, Class arg2) {
            return arg0.readArray(arg1, arg2);
        }

        static ArrayList readArrayList(Parcel arg0, ClassLoader arg1, Class arg2) {
            return arg0.readArrayList(arg1, arg2);
        }

        static HashMap readHashMap(Parcel arg0, ClassLoader arg1, Class arg2, Class arg3) {
            return arg0.readHashMap(arg1, arg2, arg3);
        }

        static void readList(Parcel arg0, List arg1, ClassLoader arg2, Class arg3) {
            arg0.readList(arg1, arg2, arg3);
        }

        static void readMap(Parcel arg0, Map arg1, ClassLoader arg2, Class arg3, Class arg4) {
            arg0.readMap(arg1, arg2, arg3, arg4);
        }

        static Parcelable readParcelable(Parcel arg0, ClassLoader arg1, Class arg2) {
            return arg0.readParcelable(arg1, arg2);
        }

        static Object[] readParcelableArray(Parcel arg0, ClassLoader arg1, Class arg2) {
            return arg0.readParcelableArray(arg1, arg2);
        }

        static Parcelable$Creator readParcelableCreator(Parcel arg0, ClassLoader arg1, Class arg2) {
            return arg0.readParcelableCreator(arg1, arg2);
        }

        static List readParcelableList(Parcel arg0, List arg1, ClassLoader arg2, Class arg3) {
            return arg0.readParcelableList(arg1, arg2, arg3);
        }

        static Serializable readSerializable(Parcel arg0, ClassLoader arg1, Class arg2) {
            return arg0.readSerializable(arg1, arg2);
        }

        static SparseArray readSparseArray(Parcel arg0, ClassLoader arg1, Class arg2) {
            return arg0.readSparseArray(arg1, arg2);
        }
    }

    private ParcelCompat() {
        super();
    }

    public static Object[] readArray(Parcel arg2, ClassLoader arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.readArray(arg2, arg3, arg4);
        }

        return arg2.readArray(arg3);
    }

    public static ArrayList readArrayList(Parcel arg2, ClassLoader arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.readArrayList(arg2, arg3, arg4);
        }

        return arg2.readArrayList(arg3);
    }

    public static boolean readBoolean(Parcel arg0) {
        if(arg0.readInt() != 0) {
            return 1;
        }

        return 0;
    }

    public static HashMap readHashMap(Parcel arg2, ClassLoader arg3, Class arg4, Class arg5) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.readHashMap(arg2, arg3, arg4, arg5);
        }

        return arg2.readHashMap(arg3);
    }

    public static void readList(Parcel arg2, List arg3, ClassLoader arg4, Class arg5) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api33Impl.readList(arg2, arg3, arg4, arg5);
            return;
        }

        arg2.readList(arg3, arg4);
    }

    public static void readMap(Parcel arg2, Map arg3, ClassLoader arg4, Class arg5, Class arg6) {
        if(Build$VERSION.SDK_INT >= 34) {
            Api33Impl.readMap(arg2, arg3, arg4, arg5, arg6);
            return;
        }

        arg2.readMap(arg3, arg4);
    }

    public static Parcelable readParcelable(Parcel arg2, ClassLoader arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.readParcelable(arg2, arg3, arg4);
        }

        Parcelable v2 = arg2.readParcelable(arg3);
        if(v2 != null) {
            if(arg4.isInstance(v2)) {
            }
            else {
                throw new BadParcelableException("Parcelable " + v2.getClass() + " is not a subclass of required class " + arg4.getName() + " provided in the parameter");
            }
        }

        return v2;
    }

    @Deprecated public static Object[] readParcelableArray(Parcel arg2, ClassLoader arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.readParcelableArray(arg2, arg3, arg4);
        }

        Parcelable[] v2 = arg2.readParcelableArray(arg3);
        if(arg4.isAssignableFrom(Parcelable.class)) {
            return ((Object[])v2);
        }

        Object v3 = Array.newInstance(arg4, v2.length);
        int v0 = 0;
        while(v0 < v2.length) {
            try {
                v3[v0] = arg4.cast(v2[v0]);
                ++v0;
                continue;
            }
            catch(ClassCastException ) {
                throw new BadParcelableException("Parcelable at index " + v0 + " is not a subclass of required class " + arg4.getName() + " provided in the parameter");
            }
        }

        return ((Object[])v3);
    }

    public static Parcelable[] readParcelableArrayTyped(Parcel arg2, ClassLoader arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.readParcelableArray(arg2, arg3, arg4);
        }

        return arg2.readParcelableArray(arg3);
    }

    public static Parcelable$Creator readParcelableCreator(Parcel arg2, ClassLoader arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.readParcelableCreator(arg2, arg3, arg4);
        }

        return Api30Impl.readParcelableCreator(arg2, arg3);
    }

    public static List readParcelableList(Parcel arg2, List arg3, ClassLoader arg4, Class arg5) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.readParcelableList(arg2, arg3, arg4, arg5);
        }

        return Api29Impl.readParcelableList(arg2, arg3, arg4);
    }

    public static Serializable readSerializable(Parcel arg2, ClassLoader arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 33) {
            return Api33Impl.readSerializable(arg2, arg3, arg4);
        }

        return arg2.readSerializable();
    }

    public static SparseArray readSparseArray(Parcel arg2, ClassLoader arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.readSparseArray(arg2, arg3, arg4);
        }

        return arg2.readSparseArray(arg3);
    }

    public static void writeBoolean(Parcel arg2, boolean arg3) {
        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.writeBoolean(arg2, arg3);
            return;
        }

        arg2.writeInt(((int)arg3));
    }
}

