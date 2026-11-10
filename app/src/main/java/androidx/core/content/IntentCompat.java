package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;

public final class IntentCompat {
    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static Object[] getParcelableArrayExtra(Intent arg0, String arg1, Class arg2) {
            return arg0.getParcelableArrayExtra(arg1, arg2);
        }

        static ArrayList getParcelableArrayListExtra(Intent arg0, String arg1, Class arg2) {
            return arg0.getParcelableArrayListExtra(arg1, arg2);
        }

        static Object getParcelableExtra(Intent arg0, String arg1, Class arg2) {
            return arg0.getParcelableExtra(arg1, arg2);
        }

        static Serializable getSerializableExtra(Intent arg0, String arg1, Class arg2) {
            return arg0.getSerializableExtra(arg1, arg2);
        }
    }

    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    private IntentCompat() {
        super();
    }

    public static Intent createManageUnusedAppRestrictionsIntent(Context arg4, String arg5) {
        if(PackageManagerCompat.areUnusedAppRestrictionsAvailable(arg4.getPackageManager())) {
            String v2 = null;
            String v3 = "package";
            if(Build$VERSION.SDK_INT >= 0x1F) {
                return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts(v3, arg5, v2));
            }

            Intent v5 = new Intent("android.intent.action.AUTO_REVOKE_PERMISSIONS").setData(Uri.fromParts(v3, arg5, v2));
            if(Build$VERSION.SDK_INT >= 30) {
                return v5;
            }

            return v5.setPackage(Preconditions.checkNotNull(PackageManagerCompat.getPermissionRevocationVerifierApp(arg4.getPackageManager())));
        }

        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    public static Parcelable[] getParcelableArrayExtra(Intent arg2, String arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArrayExtra(arg2, arg3, arg4);
        }

        return arg2.getParcelableArrayExtra(arg3);
    }

    public static ArrayList getParcelableArrayListExtra(Intent arg2, String arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArrayListExtra(arg2, arg3, arg4);
        }

        return arg2.getParcelableArrayListExtra(arg3);
    }

    public static Object getParcelableExtra(Intent arg2, String arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableExtra(arg2, arg3, arg4);
        }

        Parcelable v2 = arg2.getParcelableExtra(arg3);
        if(arg4.isInstance(v2)) {
            return v2;
        }

        return null;
    }

    public static Serializable getSerializableExtra(Intent arg2, String arg3, Class arg4) {
        if(Build$VERSION.SDK_INT >= 34) {
            return Api33Impl.getSerializableExtra(arg2, arg3, arg4);
        }

        Serializable v2 = arg2.getSerializableExtra(arg3);
        if(arg4.isInstance(v2)) {
            return v2;
        }

        return null;
    }

    public static Intent makeMainSelectorActivity(String arg0, String arg1) {
        return Intent.makeMainSelectorActivity(arg0, arg1);
    }
}

