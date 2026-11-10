package androidx.core.os;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.ReplaceWith;
import java.io.Serializable;
import java.util.ArrayList;

public final class BundleCompat {
    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static Object getParcelable(Bundle arg0, String arg1, Class arg2) {
            return arg0.getParcelable(arg1, arg2);
        }

        static Object[] getParcelableArray(Bundle arg0, String arg1, Class arg2) {
            return arg0.getParcelableArray(arg1, arg2);
        }

        static ArrayList getParcelableArrayList(Bundle arg0, String arg1, Class arg2) {
            return arg0.getParcelableArrayList(arg1, arg2);
        }

        static Serializable getSerializable(Bundle arg0, String arg1, Class arg2) {
            return arg0.getSerializable(arg1, arg2);
        }

        static SparseArray getSparseParcelableArray(Bundle arg0, String arg1, Class arg2) {
            return arg0.getSparseParcelableArray(arg1, arg2);
        }
    }

    private BundleCompat() {
        super();
    }

    @ReplaceWith(expression="bundle.getBinder(key)") @Deprecated public static IBinder getBinder(Bundle arg0, String arg1) {
        return arg0.getBinder(arg1);
    }

    public static Object getParcelable(Bundle arg2, String arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelable(arg2, arg3, arg4);
        }

        Parcelable v2 = arg2.getParcelable(arg3);
        if(arg4.isInstance(v2)) {
            return v2;
        }

        return null;
    }

    public static Parcelable[] getParcelableArray(Bundle arg2, String arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArray(arg2, arg3, arg4);
        }

        return arg2.getParcelableArray(arg3);
    }

    public static ArrayList getParcelableArrayList(Bundle arg2, String arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArrayList(arg2, arg3, arg4);
        }

        return arg2.getParcelableArrayList(arg3);
    }

    public static Serializable getSerializable(Bundle arg2, String arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.getSerializable(arg2, arg3, arg4);
        }

        Serializable v2 = arg2.getSerializable(arg3);
        if(arg4.isInstance(v2)) {
            return v2;
        }

        return null;
    }

    public static SparseArray getSparseParcelableArray(Bundle arg2, String arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.getSparseParcelableArray(arg2, arg3, arg4);
        }

        return arg2.getSparseParcelableArray(arg3);
    }

    @ReplaceWith(expression="bundle.putBinder(key, binder)") @Deprecated public static void putBinder(Bundle arg0, String arg1, IBinder arg2) {
        arg0.putBinder(arg1, arg2);
    }
}

