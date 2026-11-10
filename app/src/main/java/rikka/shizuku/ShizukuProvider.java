package rikka.shizuku;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import moe.shizuku.api.BinderContainer;
import rikka.sui.Sui;

public class ShizukuProvider extends ContentProvider {
    public static final String ACTION_BINDER_RECEIVED = "moe.shizuku.api.action.BINDER_RECEIVED";
    private static final String EXTRA_BINDER = "moe.shizuku.privileged.api.intent.extra.BINDER";
    public static final String MANAGER_APPLICATION_ID = "moe.shizuku.privileged.api";
    public static final String METHOD_GET_BINDER = "getBinder";
    public static final String METHOD_SEND_BINDER = "sendBinder";
    public static final String PERMISSION = "moe.shizuku.manager.permission.API_V23";
    private static final String TAG = "ShizukuProvider";
    private static boolean enableMultiProcess = false;
    private static boolean enableSuiInitialization = true;
    private static boolean isProviderProcess = false;

    static {
    }

    public ShizukuProvider() {
        super();
    }

    public void attachInfo(Context arg1, ProviderInfo arg2) {
        super.attachInfo(arg1, arg2);
        if(!arg2.multiprocess) {
            if(arg2.exported) {
                ShizukuProvider.isProviderProcess = true;
                return;
            }

            throw new IllegalStateException("android:exported must be true");
        }

        throw new IllegalStateException("android:multiprocess must be false");
    }

    public Bundle call(String arg3, String arg4, Bundle arg5) {
        if(Sui.isSui()) {
            Log.w("ShizukuProvider", "Provider called when Sui is available. Are you using Shizuku and Sui at the same time?");
            return new Bundle();
        }

        Bundle v4 = null;
        if(arg5 == null) {
            return v4;
        }

        arg5.setClassLoader(BinderContainer.class.getClassLoader());
        Bundle v0 = new Bundle();
        arg3.hashCode();
        if(!arg3.equals("sendBinder")) {
            if(!arg3.equals("getBinder")) {
            }
            else if(!this.handleGetBinder(v0)) {
                return v4;
            }

            return v0;
        }

        this.handleSendBinder(arg5);
        return v0;
    }

    public final int delete(Uri arg1, String arg2, String[] arg3) {
        return 0;
    }

    public static void disableAutomaticSuiInitialization() {
        ShizukuProvider.enableSuiInitialization = false;
    }

    public static void enableMultiProcessSupport(boolean arg2) {
        StringBuilder v0 = new StringBuilder("Enable built-in multi-process support (from ");
        String v1 = arg2 ? "provider process" : "non-provider process";
        Log.d("ShizukuProvider", v0.append(v1).append(")").toString());
        ShizukuProvider.isProviderProcess = arg2;
        ShizukuProvider.enableMultiProcess = true;
    }

    public final String getType(Uri arg1) {
        return null;
    }

    private boolean handleGetBinder(Bundle arg2) {
        IBinder v1 = Shizuku.getBinder();
        if(v1 != null) {
            if(!v1.pingBinder()) {
            }
            else {
                arg2.putParcelable("moe.shizuku.privileged.api.intent.extra.BINDER", new BinderContainer(v1));
                return 1;
            }
        }

        return 0;
    }

    private void handleSendBinder(Bundle arg5) {
        String v1 = "ShizukuProvider";
        if(Shizuku.pingBinder()) {
            Log.d(v1, "sendBinder is called when already a living binder");
            return;
        }

        String v0 = "moe.shizuku.privileged.api.intent.extra.BINDER";
        Parcelable v5 = arg5.getParcelable(v0);
        if(v5 != null && ((BinderContainer)v5).binder != null) {
            Log.d(v1, "binder received");
            Shizuku.onBinderReceived(((BinderContainer)v5).binder, this.getContext().getPackageName());
            if(ShizukuProvider.enableMultiProcess) {
                Log.d(v1, "broadcast binder");
                this.getContext().sendBroadcast(new Intent("moe.shizuku.api.action.BINDER_RECEIVED").putExtra(v0, v5).setPackage(this.getContext().getPackageName()));
            }
        }
    }

    public final Uri insert(Uri arg1, ContentValues arg2) {
        return null;
    }

    public boolean onCreate() {
        if((ShizukuProvider.enableSuiInitialization) && !Sui.isSui()) {
            Log.d("ShizukuProvider", "Initialize Sui: " + Sui.init(this.getContext().getPackageName()));
        }

        return 1;
    }

    public final Cursor query(Uri arg1, String[] arg2, String arg3, String[] arg4, String arg5) {
        return null;
    }

    public static void requestBinderForNonProviderProcess(Context arg6) {
        Bundle v1_2;
        String v0 = "content://";
        if(ShizukuProvider.isProviderProcess) {
        }
        else {
            String v2 = "ShizukuProvider";
            Log.d(v2, "request binder in non-provider process");
            rikka.shizuku.ShizukuProvider$1 v1 = new BroadcastReceiver() {
                public void onReceive(Context arg2, Intent arg3) {
                    Parcelable v1 = arg3.getParcelableExtra("moe.shizuku.privileged.api.intent.extra.BINDER");
                    if(v1 != null && ((BinderContainer)v1).binder != null) {
                        Log.i("ShizukuProvider", "binder received from broadcast");
                        Shizuku.onBinderReceived(((BinderContainer)v1).binder, arg2.getPackageName());
                    }
                }
            };
            String v5 = "moe.shizuku.api.action.BINDER_RECEIVED";
            if(Build$VERSION.SDK_INT >= 33) {
                arg6.registerReceiver(((BroadcastReceiver)v1), new IntentFilter(v5), 4);
            }
            else {
                arg6.registerReceiver(((BroadcastReceiver)v1), new IntentFilter(v5));
            }

            String v1_1 = null;
            try {
                v1_2 = arg6.getContentResolver().call(Uri.parse(v0 + arg6.getPackageName() + ".shizuku"), "getBinder", v1_1, new Bundle());
                goto label_35;
            }
            catch(Throwable ) {
            label_35:
                if(v1_2 == null) {
                    return;
                }

                v1_2.setClassLoader(BinderContainer.class.getClassLoader());
                Parcelable v0_1 = v1_2.getParcelable("moe.shizuku.privileged.api.intent.extra.BINDER");
                if(v0_1 == null) {
                    return;
                }

                if(((BinderContainer)v0_1).binder == null) {
                    return;
                }

                Log.i(v2, "Binder received from other process");
                Shizuku.onBinderReceived(((BinderContainer)v0_1).binder, arg6.getPackageName());
            }
        }
    }

    public static void setIsProviderProcess(boolean arg0) {
        ShizukuProvider.isProviderProcess = arg0;
    }

    public final int update(Uri arg1, ContentValues arg2, String arg3, String[] arg4) {
        return 0;
    }
}

