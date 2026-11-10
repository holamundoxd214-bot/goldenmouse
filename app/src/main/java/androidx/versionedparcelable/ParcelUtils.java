package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParcelUtils {
    private static final String INNER_BUNDLE_KEY = "a";

    private ParcelUtils() {
        super();
    }

    public static VersionedParcelable fromInputStream(InputStream arg2) {
        return new VersionedParcelStream(arg2, null).readVersionedParcelable();
    }

    public static VersionedParcelable fromParcelable(Parcelable arg1) {
        if((arg1 instanceof ParcelImpl)) {
            return ((ParcelImpl)arg1).getVersionedParcel();
        }

        throw new IllegalArgumentException("Invalid parcel");
    }

    public static VersionedParcelable getVersionedParcelable(Bundle arg1, String arg2) {
        VersionedParcelable v0 = null;
        try {
            Parcelable v1 = arg1.getParcelable(arg2);
            if(v1 == null) {
                return v0;
            }

            ((Bundle)v1).setClassLoader(ParcelUtils.class.getClassLoader());
            return ParcelUtils.fromParcelable(((Bundle)v1).getParcelable("a"));
        }
        catch(RuntimeException ) {
            return v0;
        }
    }

    public static List getVersionedParcelableList(Bundle arg1, String arg2) {
        ArrayList v0 = new ArrayList();
        try {
            Parcelable v1 = arg1.getParcelable(arg2);
            ((Bundle)v1).setClassLoader(ParcelUtils.class.getClassLoader());
            Iterator v1_1 = ((Bundle)v1).getParcelableArrayList("a").iterator();
            while(v1_1.hasNext()) {
                ((List)v0).add(ParcelUtils.fromParcelable(v1_1.next()));
            }
        }
        catch(RuntimeException ) {
            return null;
        }

        return ((List)v0);
    }

    public static void putVersionedParcelable(Bundle arg2, String arg3, VersionedParcelable arg4) {
        if(arg4 == null) {
            return;
        }

        Bundle v0 = new Bundle();
        v0.putParcelable("a", ParcelUtils.toParcelable(arg4));
        arg2.putParcelable(arg3, ((Parcelable)v0));
    }

    public static void putVersionedParcelableList(Bundle arg3, String arg4, List arg5) {
        Bundle v0 = new Bundle();
        ArrayList v1 = new ArrayList();
        Iterator v5 = arg5.iterator();
        while(v5.hasNext()) {
            v1.add(ParcelUtils.toParcelable(v5.next()));
        }

        v0.putParcelableArrayList("a", v1);
        arg3.putParcelable(arg4, ((Parcelable)v0));
    }

    public static void toOutputStream(VersionedParcelable arg2, OutputStream arg3) {
        VersionedParcelStream v0 = new VersionedParcelStream(null, arg3);
        v0.writeVersionedParcelable(arg2);
        v0.closeField();
    }

    public static Parcelable toParcelable(VersionedParcelable arg1) {
        return new ParcelImpl(arg1);
    }
}

