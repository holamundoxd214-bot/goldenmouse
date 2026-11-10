package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build$VERSION;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executors;

public final class PackageManagerCompat {
    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static boolean areUnusedAppRestrictionsEnabled(Context arg0) {
            return arg0.getPackageManager().isAutoRevokeWhitelisted() ^ 1;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface UnusedAppRestrictionsStatus {
    }

    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    public static final String LOG_TAG = "PackageManagerCompat";

    private PackageManagerCompat() {
        super();
    }

    public static boolean areUnusedAppRestrictionsAvailable(PackageManager arg4) {
        int v0 = Build$VERSION.SDK_INT >= 30 ? 1 : 0;
        int v4 = PackageManagerCompat.getPermissionRevocationVerifierApp(arg4) != null ? 1 : 0;
        if(v0 == 0) {
            if(v4 != 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static String getPermissionRevocationVerifierApp(PackageManager arg4) {
        String v3 = null;
        Iterator v0 = arg4.queryIntentActivities(new Intent("android.intent.action.AUTO_REVOKE_PERMISSIONS").setData(Uri.fromParts("package", "com.example", v3)), 0).iterator();
        while(v0.hasNext()) {
            String v1 = v0.next().activityInfo.packageName;
            if(arg4.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", v1) != 0) {
                continue;
            }
            else if(v3 != null) {
            }
            else {
                v3 = v1;
                continue;
            }

            return v3;
        }

        return v3;
    }

    public static ListenableFuture getUnusedAppRestrictionsStatus(Context arg7) {
        ResolvableFuture v0 = ResolvableFuture.create();
        boolean v1 = UserManagerCompat.isUserUnlocked(arg7);
        String v2 = "PackageManagerCompat";
        Integer v3 = Integer.valueOf(0);
        if(!v1) {
            v0.set(v3);
            Log.e(v2, "User is in locked direct boot mode");
            return ((ListenableFuture)v0);
        }

        if(!PackageManagerCompat.areUnusedAppRestrictionsAvailable(arg7.getPackageManager())) {
            v0.set(Integer.valueOf(1));
            return ((ListenableFuture)v0);
        }

        int v1_1 = arg7.getApplicationInfo().targetSdkVersion;
        int v4 = 30;
        if(v1_1 < v4) {
            v0.set(v3);
            Log.e(v2, "Target SDK version below API 30");
            return ((ListenableFuture)v0);
        }

        int v3_1 = 4;
        int v5 = 2;
        int v6 = 0x1F;
        if(Build$VERSION.SDK_INT >= v6) {
            if(Api30Impl.areUnusedAppRestrictionsEnabled(arg7)) {
                if(v1_1 >= v6) {
                    v3_1 = 5;
                }

                v0.set(Integer.valueOf(v3_1));
                return ((ListenableFuture)v0);
            }

            v0.set(Integer.valueOf(v5));
            return ((ListenableFuture)v0);
        }

        if(Build$VERSION.SDK_INT == v4) {
            if(Api30Impl.areUnusedAppRestrictionsEnabled(arg7)) {
            }
            else {
                v3_1 = v5;
            }

            v0.set(Integer.valueOf(v3_1));
            return ((ListenableFuture)v0);
        }

        UnusedAppRestrictionsBackportServiceConnection v1_2 = new UnusedAppRestrictionsBackportServiceConnection(arg7);
        Objects.requireNonNull(v1_2);
        v0.addListener(new PackageManagerCompat$$ExternalSyntheticLambda0(v1_2), Executors.newSingleThreadExecutor());
        v1_2.connectAndFetchResult(v0);
        return ((ListenableFuture)v0);
    }
}

