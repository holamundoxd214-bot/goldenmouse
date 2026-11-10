package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class LocalBroadcastManager {
    final class BroadcastRecord {
        final Intent intent;
        final ArrayList receivers;

        BroadcastRecord(Intent arg1, ArrayList arg2) {
            super();
            this.intent = arg1;
            this.receivers = arg2;
        }
    }

    final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter arg1, BroadcastReceiver arg2) {
            super();
            this.filter = arg1;
            this.receiver = arg2;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder(0x80);
            v0.append("Receiver{");
            v0.append(this.receiver);
            v0.append(" filter=");
            v0.append(this.filter);
            if(this.dead) {
                v0.append(" DEAD");
            }

            v0.append("}");
            return v0.toString();
        }
    }

    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private final HashMap mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private static LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final ArrayList mPendingBroadcasts;
    private final HashMap mReceivers;

    static {
        LocalBroadcastManager.mLock = new Object();
    }

    private LocalBroadcastManager(Context arg2) {
        super();
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = arg2;
        this.mHandler = new Handler(arg2.getMainLooper()) {
            public void handleMessage(Message arg3) {
                if(arg3.what != 1) {
                    super.handleMessage(arg3);
                    return;
                }

                LocalBroadcastManager.this.executePendingBroadcasts();
            }
        };
    }

    void executePendingBroadcasts() {
        int v3;
        BroadcastRecord[] v2;
    label_0:
        HashMap v0 = this.mReceivers;
        __monitor_enter(v0);
        try {
            int v1 = this.mPendingBroadcasts.size();
            if(v1 <= 0) {
                __monitor_exit(v0);
                return;
            }

            v2 = new BroadcastRecord[v1];
            this.mPendingBroadcasts.toArray(((Object[])v2));
            this.mPendingBroadcasts.clear();
            __monitor_exit(v0);
            v0 = null;
            v3 = 0;
        }
        catch(Throwable v10) {
            try {
            label_34:
                __monitor_exit(v0);
            }
            catch(Throwable v10) {
                goto label_34;
            }

            throw v10;
        }

        while(true) {
            if(v3 >= v1) {
                goto label_0;
            }

            BroadcastRecord v4 = v2[v3];
            int v5 = v4.receivers.size();
            int v6;
            for(v6 = 0; v6 < v5; ++v6) {
                Object v7 = v4.receivers.get(v6);
                if(!((ReceiverRecord)v7).dead) {
                    ((ReceiverRecord)v7).receiver.onReceive(this.mAppContext, v4.intent);
                }
            }

            ++v3;
        }
    }

    public static LocalBroadcastManager getInstance(Context arg2) {
        Object v0 = LocalBroadcastManager.mLock;
        __monitor_enter(v0);
        try {
            LocalBroadcastManager v1 = LocalBroadcastManager.mInstance;
            if(v1 == null) {
                v1 = new LocalBroadcastManager(arg2.getApplicationContext());
                LocalBroadcastManager.mInstance = v1;
            }

            __monitor_exit(v0);
            return v1;
        label_11:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_11;
        }

        throw v2;
    }

    public void registerReceiver(BroadcastReceiver arg7, IntentFilter arg8) {
        ArrayList v2_1;
        HashMap v0 = this.mReceivers;
        __monitor_enter(v0);
        try {
            ReceiverRecord v1 = new ReceiverRecord(arg8, arg7);
            Object v2 = this.mReceivers.get(arg7);
            if(v2 == null) {
                v2_1 = new ArrayList(1);
                this.mReceivers.put(arg7, v2_1);
            }

            v2_1.add(v1);
            int v7;
            for(v7 = 0; v7 < arg8.countActions(); ++v7) {
                String v2_2 = arg8.getAction(v7);
                Object v4 = this.mActions.get(v2_2);
                if(v4 == null) {
                    ArrayList v4_1 = new ArrayList(1);
                    this.mActions.put(v2_2, v4_1);
                }

                ((ArrayList)v4).add(v1);
            }

            __monitor_exit(v0);
            return;
        label_30:
            __monitor_exit(v0);
        }
        catch(Throwable v6) {
            goto label_30;
        }

        throw v6;
    }

    public boolean sendBroadcast(Intent arg19) {
        Object v17;
        LocalBroadcastManager v0 = this;
        Intent v1 = arg19;
        String v2 = "Action list: ";
        String v3 = "Resolving type ";
        HashMap v4 = v0.mReceivers;
        __monitor_enter(v4);
        try {
            String v6 = v1.getAction();
            String v7 = v1.resolveTypeIfNeeded(v0.mAppContext.getContentResolver());
            Uri v9 = v1.getData();
            String v8 = v1.getScheme();
            Set v10 = v1.getCategories();
            int v14 = (v1.getFlags() & 8) != 0 ? 1 : 0;
            if(v14 != 0) {
                Log.v("LocalBroadcastManager", v3 + v7 + " scheme " + v8 + " of intent " + v1);
            }

            Object v3_1 = v0.mActions.get(v1.getAction());
            if(v3_1 != null) {
                if(v14 != 0) {
                    Log.v("LocalBroadcastManager", v2 + v3_1);
                }

                ArrayList v2_1 = null;
                int v15 = 0;
                while(v15 < ((ArrayList)v3_1).size()) {
                    Object v5 = ((ArrayList)v3_1).get(v15);
                    if(v14 != 0) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + ((ReceiverRecord)v5).filter);
                    }

                    if(((ReceiverRecord)v5).broadcasting) {
                        if(v14 != 0) {
                            Log.v("LocalBroadcastManager", "  Filter\'s target already added");
                        }

                        v17 = v3_1;
                    }
                    else {
                        Object v12 = v5;
                        int v5_1 = v5.filter.match(v6, v7, v8, v9, v10, "LocalBroadcastManager");
                        if(v5_1 >= 0) {
                            if(v14 != 0) {
                                v17 = v3_1;
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(v5_1));
                            }
                            else {
                                v17 = v3_1;
                            }

                            if(v2_1 == null) {
                                v2_1 = new ArrayList();
                            }

                            v2_1.add(v12);
                            ((ReceiverRecord)v12).broadcasting = true;
                            goto label_119;
                        }

                        v17 = v3_1;
                        if(v14 == 0) {
                            goto label_119;
                        }

                        if(v5_1 == -4) {
                            v3 = "category";
                        }
                        else if(v5_1 == -3) {
                            v3 = "action";
                        }
                        else if(v5_1 == -2) {
                            v3 = "data";
                        }
                        else if(v5_1 != -1) {
                            v3 = "unknown reason";
                        }
                        else {
                            v3 = "type";
                        }

                        Log.v("LocalBroadcastManager", "  Filter did not match: " + v3);
                    }

                label_119:
                    ++v15;
                    v3_1 = v17;
                }

                if(v2_1 == null) {
                    goto label_143;
                }

                int v3_2;
                for(v3_2 = 0; v3_2 < v2_1.size(); ++v3_2) {
                    v2_1.get(v3_2).broadcasting = false;
                }

                v0.mPendingBroadcasts.add(new BroadcastRecord(v1, v2_1));
                if(!v0.mHandler.hasMessages(1)) {
                    v0.mHandler.sendEmptyMessage(1);
                }

                __monitor_exit(v4);
                return 1;
            }

        label_143:
            __monitor_exit(v4);
            return 0;
        label_147:
            __monitor_exit(v4);
        }
        catch(Throwable v0_1) {
            goto label_147;
        }

        throw v0_1;
    }

    public void sendBroadcastSync(Intent arg1) {
        if(this.sendBroadcast(arg1)) {
            this.executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(BroadcastReceiver arg12) {
        HashMap v0 = this.mReceivers;
        __monitor_enter(v0);
        try {
            Object v1 = this.mReceivers.remove(arg12);
            if(v1 == null) {
                __monitor_exit(v0);
                return;
            }

            int v2;
            for(v2 = ((ArrayList)v1).size() - 1; v2 >= 0; --v2) {
                Object v4 = ((ArrayList)v1).get(v2);
                ((ReceiverRecord)v4).dead = true;
                int v5;
                for(v5 = 0; v5 < ((ReceiverRecord)v4).filter.countActions(); ++v5) {
                    String v6 = ((ReceiverRecord)v4).filter.getAction(v5);
                    Object v7 = this.mActions.get(v6);
                    if(v7 != null) {
                        int v8;
                        for(v8 = ((ArrayList)v7).size() - 1; v8 >= 0; --v8) {
                            Object v9 = ((ArrayList)v7).get(v8);
                            if(((ReceiverRecord)v9).receiver == arg12) {
                                ((ReceiverRecord)v9).dead = true;
                                ((ArrayList)v7).remove(v8);
                            }
                        }

                        if(((ArrayList)v7).size() > 0) {
                            goto label_36;
                        }

                        this.mActions.remove(v6);
                    }

                label_36:
                }
            }

            __monitor_exit(v0);
            return;
        label_43:
            __monitor_exit(v0);
        }
        catch(Throwable v11) {
            goto label_43;
        }

        throw v11;
    }
}

