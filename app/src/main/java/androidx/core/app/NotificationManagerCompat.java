package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler$Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings$Secure;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.INotificationSideChannel$Stub;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;

public final class NotificationManagerCompat {
    class Api23Impl {
        private Api23Impl() {
            super();
        }

        static List getActiveNotifications(NotificationManager arg0) {
            StatusBarNotification[] v0 = arg0.getActiveNotifications();
            if(v0 == null) {
                return new ArrayList();
            }

            return Arrays.asList(((Object[])v0));
        }
    }

    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static boolean areNotificationsEnabled(NotificationManager arg0) {
            return arg0.areNotificationsEnabled();
        }

        static int getImportance(NotificationManager arg0) {
            return arg0.getImportance();
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static void createNotificationChannel(NotificationManager arg0, NotificationChannel arg1) {
            arg0.createNotificationChannel(arg1);
        }

        static void createNotificationChannelGroup(NotificationManager arg0, NotificationChannelGroup arg1) {
            arg0.createNotificationChannelGroup(arg1);
        }

        static void createNotificationChannelGroups(NotificationManager arg0, List arg1) {
            arg0.createNotificationChannelGroups(arg1);
        }

        static void createNotificationChannels(NotificationManager arg0, List arg1) {
            arg0.createNotificationChannels(arg1);
        }

        static void deleteNotificationChannel(NotificationManager arg0, String arg1) {
            arg0.deleteNotificationChannel(arg1);
        }

        static void deleteNotificationChannelGroup(NotificationManager arg0, String arg1) {
            arg0.deleteNotificationChannelGroup(arg1);
        }

        static String getId(NotificationChannel arg0) {
            return arg0.getId();
        }

        static String getId(NotificationChannelGroup arg0) {
            return arg0.getId();
        }

        static NotificationChannel getNotificationChannel(NotificationManager arg0, String arg1) {
            return arg0.getNotificationChannel(arg1);
        }

        static List getNotificationChannelGroups(NotificationManager arg0) {
            return arg0.getNotificationChannelGroups();
        }

        static List getNotificationChannels(NotificationManager arg0) {
            return arg0.getNotificationChannels();
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static NotificationChannelGroup getNotificationChannelGroup(NotificationManager arg0, String arg1) {
            return arg0.getNotificationChannelGroup(arg1);
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static NotificationChannel getNotificationChannel(NotificationManager arg0, String arg1, String arg2) {
            return arg0.getNotificationChannel(arg1, arg2);
        }

        static String getParentChannelId(NotificationChannel arg0) {
            return arg0.getParentChannelId();
        }
    }

    class Api34Impl {
        private Api34Impl() {
            super();
        }

        static boolean canUseFullScreenIntent(NotificationManager arg0) {
            return arg0.canUseFullScreenIntent();
        }
    }

    class Api36Impl {
        private Api36Impl() {
            super();
        }

        static boolean canPostPromotedNotifications(NotificationManager arg0) {
            return arg0.canPostPromotedNotifications();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface InterruptionFilter {
    }

    public class NotificationWithIdAndTag {
        final int mId;
        Notification mNotification;
        final String mTag;

        public NotificationWithIdAndTag(int arg2, Notification arg3) {
            this(null, arg2, arg3);
        }

        public NotificationWithIdAndTag(String arg1, int arg2, Notification arg3) {
            super();
            this.mTag = arg1;
            this.mId = arg2;
            this.mNotification = arg3;
        }
    }

    class NotifyTask implements Task {
        final int id;
        final Notification notif;
        final String packageName;
        final String tag;

        NotifyTask(String arg1, int arg2, String arg3, Notification arg4) {
            super();
            this.packageName = arg1;
            this.id = arg2;
            this.tag = arg3;
            this.notif = arg4;
        }

        public void send(INotificationSideChannel arg4) throws RemoteException {
            arg4.notify(this.packageName, this.id, this.tag, this.notif);
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("NotifyTask[packageName:");
            v0.append(this.packageName);
            v0.append(", id:").append(this.id);
            v0.append(", tag:").append(this.tag);
            v0.append("]");
            return v0.toString();
        }
    }

    class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        ServiceConnectedEvent(ComponentName arg1, IBinder arg2) {
            super();
            this.componentName = arg1;
            this.iBinder = arg2;
        }
    }

    class SideChannelManager implements ServiceConnection, Handler$Callback {
        class ListenerRecord {
            boolean bound;
            final ComponentName componentName;
            int retryCount;
            INotificationSideChannel service;
            ArrayDeque taskQueue;

            ListenerRecord(ComponentName arg3) {
                super();
                this.bound = false;
                this.taskQueue = new ArrayDeque();
                this.retryCount = 0;
                this.componentName = arg3;
            }
        }

        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map mRecordMap;

        SideChannelManager(Context arg2) {
            super();
            this.mRecordMap = new HashMap();
            this.mCachedEnabledPackages = new HashSet();
            this.mContext = arg2;
            HandlerThread v2 = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = v2;
            v2.start();
            this.mHandler = new Handler(v2.getLooper(), ((Handler$Callback)this));
        }

        private boolean ensureServiceBound(ListenerRecord arg4) {
            if(arg4.bound) {
                return 1;
            }

            arg4.bound = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(arg4.componentName), ((ServiceConnection)this), 33);
            if(arg4.bound) {
                arg4.retryCount = 0;
            }
            else {
                Log.w("NotifManCompat", "Unable to bind to listener " + arg4.componentName);
                this.mContext.unbindService(((ServiceConnection)this));
            }

            return arg4.bound;
        }

        private void ensureServiceUnbound(ListenerRecord arg2) {
            if(arg2.bound) {
                this.mContext.unbindService(((ServiceConnection)this));
                arg2.bound = false;
            }

            arg2.service = null;
        }

        public boolean handleMessage(Message arg4) {
            int v0 = arg4.what;
            if(v0 != 0) {
                if(v0 != 1) {
                    if(v0 != 2) {
                        if(v0 != 3) {
                            return 0;
                        }

                        this.handleRetryListenerQueue(arg4.obj);
                        return 1;
                    }

                    this.handleServiceDisconnected(arg4.obj);
                    return 1;
                }

                this.handleServiceConnected(arg4.obj.componentName, arg4.obj.iBinder);
                return 1;
            }

            this.handleQueueTask(arg4.obj);
            return 1;
        }

        private void handleQueueTask(Task arg4) {
            this.updateListenerMap();
            Iterator v0 = this.mRecordMap.values().iterator();
            while(v0.hasNext()) {
                Object v1 = v0.next();
                ((ListenerRecord)v1).taskQueue.add(arg4);
                this.processListenerQueue(((ListenerRecord)v1));
            }
        }

        private void handleRetryListenerQueue(ComponentName arg2) {
            Object v2 = this.mRecordMap.get(arg2);
            if(v2 != null) {
                this.processListenerQueue(((ListenerRecord)v2));
            }
        }

        private void handleServiceConnected(ComponentName arg2, IBinder arg3) {
            Object v2 = this.mRecordMap.get(arg2);
            if(v2 != null) {
                ((ListenerRecord)v2).service = Stub.asInterface(arg3);
                ((ListenerRecord)v2).retryCount = 0;
                this.processListenerQueue(((ListenerRecord)v2));
            }
        }

        private void handleServiceDisconnected(ComponentName arg2) {
            Object v2 = this.mRecordMap.get(arg2);
            if(v2 != null) {
                this.ensureServiceUnbound(((ListenerRecord)v2));
            }
        }

        public void onServiceConnected(ComponentName arg4, IBinder arg5) {
            String v1 = "NotifManCompat";
            if(Log.isLoggable(v1, 3)) {
                Log.d(v1, "Connected to service " + arg4);
            }

            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(arg4, arg5)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName arg4) {
            String v1 = "NotifManCompat";
            if(Log.isLoggable(v1, 3)) {
                Log.d(v1, "Disconnected from service " + arg4);
            }

            this.mHandler.obtainMessage(2, arg4).sendToTarget();
        }

        private void processListenerQueue(ListenerRecord arg6) {
            String v0 = "NotifManCompat";
            int v1 = 3;
            if(Log.isLoggable(v0, v1)) {
                Log.d(v0, "Processing component " + arg6.componentName + ", " + arg6.taskQueue.size() + " queued tasks");
            }

            if(arg6.taskQueue.isEmpty()) {
                return;
            }

            if((this.ensureServiceBound(arg6)) && arg6.service != null) {
                while(true) {
                    Object v2 = arg6.taskQueue.peek();
                    if(v2 == null) {
                        break;
                    }

                    try {
                        if(Log.isLoggable(v0, v1)) {
                            Log.d(v0, "Sending task " + v2);
                        }

                        ((Task)v2).send(arg6.service);
                        arg6.taskQueue.remove();
                        continue;
                    }
                    catch(RemoteException v1_1) {
                        Log.w(v0, "RemoteException communicating with " + arg6.componentName, ((Throwable)v1_1));
                        break;
                    }
                    catch(DeadObjectException ) {
                        if(!Log.isLoggable(v0, v1)) {
                            break;
                        }

                        Log.d(v0, "Remote service has died: " + arg6.componentName);
                        break;
                    }
                }

                if(!arg6.taskQueue.isEmpty()) {
                    this.scheduleListenerRetry(arg6);
                }

                return;
            }

            this.scheduleListenerRetry(arg6);
        }

        public void queueTask(Task arg2) {
            this.mHandler.obtainMessage(0, arg2).sendToTarget();
        }

        private void scheduleListenerRetry(ListenerRecord arg6) {
            int v2 = 3;
            if(this.mHandler.hasMessages(v2, arg6.componentName)) {
                return;
            }

            ++arg6.retryCount;
            String v4 = "NotifManCompat";
            if(arg6.retryCount > 6) {
                Log.w(v4, "Giving up on delivering " + arg6.taskQueue.size() + " tasks to " + arg6.componentName + " after " + arg6.retryCount + " retries");
                arg6.taskQueue.clear();
                return;
            }

            int v0 = (1 << arg6.retryCount - 1) * 1000;
            if(Log.isLoggable(v4, v2)) {
                Log.d(v4, "Scheduling retry for " + v0 + " ms");
            }

            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(v2, arg6.componentName), ((long)v0));
        }

        private void updateListenerMap() {
            Object v1_2;
            String v4;
            Set v0 = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if(v0.equals(this.mCachedEnabledPackages)) {
            }
            else {
                this.mCachedEnabledPackages = v0;
                List v1 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet v2 = new HashSet();
                Iterator v1_1 = v1.iterator();
                while(true) {
                    v4 = "NotifManCompat";
                    if(!v1_1.hasNext()) {
                        break;
                    }

                    Object v3 = v1_1.next();
                    if(!v0.contains(((ResolveInfo)v3).serviceInfo.packageName)) {
                    }
                    else {
                        ComponentName v5 = new ComponentName(((ResolveInfo)v3).serviceInfo.packageName, ((ResolveInfo)v3).serviceInfo.name);
                        if(((ResolveInfo)v3).serviceInfo.permission != null) {
                            Log.w(v4, "Permission present on component " + v5 + ", not adding listener record.");
                        }
                        else {
                            ((Set)v2).add(v5);
                        }
                    }
                }

                Iterator v0_1 = ((Set)v2).iterator();
                while(true) {
                    int v3_1 = 3;
                    if(!v0_1.hasNext()) {
                        break;
                    }

                    v1_2 = v0_1.next();
                    if(this.mRecordMap.containsKey(v1_2)) {
                        continue;
                    }

                    if(Log.isLoggable(v4, v3_1)) {
                        Log.d(v4, "Adding listener record for " + v1_2);
                    }

                    this.mRecordMap.put(v1_2, new ListenerRecord(((ComponentName)v1_2)));
                }

                v0_1 = this.mRecordMap.entrySet().iterator();
                while(v0_1.hasNext()) {
                    v1_2 = v0_1.next();
                    if(((Set)v2).contains(((Map$Entry)v1_2).getKey())) {
                        continue;
                    }

                    if(Log.isLoggable(v4, v3_1)) {
                        Log.d(v4, "Removing listener record for " + ((Map$Entry)v1_2).getKey());
                    }

                    this.ensureServiceUnbound(((Map$Entry)v1_2).getValue());
                    v0_1.remove();
                }
            }
        }
    }

    interface Task {
        void send(INotificationSideChannel arg1) throws RemoteException;
    }

    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final int INTERRUPTION_FILTER_ALARMS = 4;
    public static final int INTERRUPTION_FILTER_ALL = 1;
    public static final int INTERRUPTION_FILTER_NONE = 3;
    public static final int INTERRUPTION_FILTER_PRIORITY = 2;
    public static final int INTERRUPTION_FILTER_UNKNOWN = 0;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private final Context mContext;
    private final NotificationManager mNotificationManager;
    private static Set sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock;
    private static final Object sLock;
    private static SideChannelManager sSideChannelManager;

    static {
        NotificationManagerCompat.sEnabledNotificationListenersLock = new Object();
        NotificationManagerCompat.sEnabledNotificationListenerPackages = new HashSet();
        NotificationManagerCompat.sLock = new Object();
    }

    NotificationManagerCompat(NotificationManager arg1, Context arg2) {
        super();
        this.mContext = arg2;
        this.mNotificationManager = arg1;
    }

    private NotificationManagerCompat(Context arg2) {
        super();
        this.mContext = arg2;
        this.mNotificationManager = arg2.getSystemService("notification");
    }

    public boolean areNotificationsEnabled() {
        return Api24Impl.areNotificationsEnabled(this.mNotificationManager);
    }

    public boolean canPostPromotedNotifications() {
        if(Build$VERSION.SDK_INT >= 36) {
            return Api36Impl.canPostPromotedNotifications(this.mNotificationManager);
        }

        return 0;
    }

    public boolean canUseFullScreenIntent() {
        if(Build$VERSION.SDK_INT < 29) {
            return 1;
        }

        if(Build$VERSION.SDK_INT < 34) {
            if(this.mContext.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") == 0) {
                return 1;
            }

            return 0;
        }

        return Api34Impl.canUseFullScreenIntent(this.mNotificationManager);
    }

    public void cancel(int arg2) {
        this.cancel(null, arg2);
    }

    public void cancel(String arg1, int arg2) {
        this.mNotificationManager.cancel(arg1, arg2);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void createNotificationChannel(NotificationChannel arg1) {
        Api26Impl.createNotificationChannel(this.mNotificationManager, arg1);
    }

    public void createNotificationChannel(NotificationChannelCompat arg1) {
        this.createNotificationChannel(arg1.getNotificationChannel());
    }

    public void createNotificationChannelGroup(NotificationChannelGroup arg1) {
        Api26Impl.createNotificationChannelGroup(this.mNotificationManager, arg1);
    }

    public void createNotificationChannelGroup(NotificationChannelGroupCompat arg1) {
        this.createNotificationChannelGroup(arg1.getNotificationChannelGroup());
    }

    public void createNotificationChannelGroups(List arg1) {
        Api26Impl.createNotificationChannelGroups(this.mNotificationManager, arg1);
    }

    public void createNotificationChannelGroupsCompat(List arg3) {
        if(!arg3.isEmpty()) {
            ArrayList v0 = new ArrayList(arg3.size());
            Iterator v3 = arg3.iterator();
            while(v3.hasNext()) {
                ((List)v0).add(v3.next().getNotificationChannelGroup());
            }

            Api26Impl.createNotificationChannelGroups(this.mNotificationManager, ((List)v0));
        }
    }

    public void createNotificationChannels(List arg1) {
        Api26Impl.createNotificationChannels(this.mNotificationManager, arg1);
    }

    public void createNotificationChannelsCompat(List arg3) {
        if(!arg3.isEmpty()) {
            ArrayList v0 = new ArrayList(arg3.size());
            Iterator v3 = arg3.iterator();
            while(v3.hasNext()) {
                ((List)v0).add(v3.next().getNotificationChannel());
            }

            Api26Impl.createNotificationChannels(this.mNotificationManager, ((List)v0));
        }
    }

    public void deleteNotificationChannel(String arg1) {
        Api26Impl.deleteNotificationChannel(this.mNotificationManager, arg1);
    }

    public void deleteNotificationChannelGroup(String arg1) {
        Api26Impl.deleteNotificationChannelGroup(this.mNotificationManager, arg1);
    }

    public void deleteUnlistedNotificationChannels(Collection arg5) {
        Iterator v0 = Api26Impl.getNotificationChannels(this.mNotificationManager).iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            if(arg5.contains(Api26Impl.getId(((NotificationChannel)v1)))) {
                continue;
            }

            if(Build$VERSION.SDK_INT >= 30 && (arg5.contains(Api30Impl.getParentChannelId(((NotificationChannel)v1))))) {
                continue;
            }

            Api26Impl.deleteNotificationChannel(this.mNotificationManager, Api26Impl.getId(((NotificationChannel)v1)));
        }
    }

    public static NotificationManagerCompat from(Context arg1) {
        return new NotificationManagerCompat(arg1);
    }

    public List getActiveNotifications() {
        return Api23Impl.getActiveNotifications(this.mNotificationManager);
    }

    public int getCurrentInterruptionFilter() {
        return this.mNotificationManager.getCurrentInterruptionFilter();
    }

    public static Set getEnabledListenerPackages(Context arg6) {
        String v6 = Settings$Secure.getString(arg6.getContentResolver(), "enabled_notification_listeners");
        Object v0 = NotificationManagerCompat.sEnabledNotificationListenersLock;
        __monitor_enter(v0);
        if(v6 != null) {
            try {
                if(!v6.equals(NotificationManagerCompat.sEnabledNotificationListeners)) {
                    String[] v1 = v6.split(":", -1);
                    HashSet v2 = new HashSet(v1.length);
                    int v3 = v1.length;
                    int v4;
                    for(v4 = 0; v4 < v3; ++v4) {
                        ComponentName v5 = ComponentName.unflattenFromString(v1[v4]);
                        if(v5 != null) {
                            ((Set)v2).add(v5.getPackageName());
                        }
                    }

                    NotificationManagerCompat.sEnabledNotificationListenerPackages = ((Set)v2);
                    NotificationManagerCompat.sEnabledNotificationListeners = v6;
                }

            label_27:
                __monitor_exit(v0);
                return NotificationManagerCompat.sEnabledNotificationListenerPackages;
            label_31:
                __monitor_exit(v0);
                goto label_32;
            }
            catch(Throwable v6_1) {
                goto label_31;
            }
        }

        goto label_27;
    label_32:
        throw v6_1;
    }

    public int getImportance() {
        return Api24Impl.getImportance(this.mNotificationManager);
    }

    public NotificationChannel getNotificationChannel(String arg1) {
        return Api26Impl.getNotificationChannel(this.mNotificationManager, arg1);
    }

    public NotificationChannel getNotificationChannel(String arg3, String arg4) {
        if(Build$VERSION.SDK_INT >= 30) {
            return Api30Impl.getNotificationChannel(this.mNotificationManager, arg3, arg4);
        }

        return this.getNotificationChannel(arg3);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String arg1) {
        NotificationChannel v0 = this.getNotificationChannel(arg1);
        if(v0 != null) {
            return new NotificationChannelCompat(v0);
        }

        return null;
    }

    public NotificationChannelCompat getNotificationChannelCompat(String arg1, String arg2) {
        NotificationChannel v0 = this.getNotificationChannel(arg1, arg2);
        if(v0 != null) {
            return new NotificationChannelCompat(v0);
        }

        return null;
    }

    public NotificationChannelGroup getNotificationChannelGroup(String arg3) {
        Object v0;
        if(Build$VERSION.SDK_INT >= 28) {
            return Api28Impl.getNotificationChannelGroup(this.mNotificationManager, arg3);
        }

        Iterator v2 = this.getNotificationChannelGroups().iterator();
        do {
            if(!v2.hasNext()) {
                return null;
            }

            v0 = v2.next();
        }
        while(!Api26Impl.getId(((NotificationChannelGroup)v0)).equals(arg3));

        return ((NotificationChannelGroup)v0);
    }

    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(String arg3) {
        if(Build$VERSION.SDK_INT >= 28) {
            NotificationChannelGroup v2 = this.getNotificationChannelGroup(arg3);
            if(v2 != null) {
                return new NotificationChannelGroupCompat(v2);
            }
        }
        else {
            NotificationChannelGroup v3 = this.getNotificationChannelGroup(arg3);
            if(v3 != null) {
                return new NotificationChannelGroupCompat(v3, this.getNotificationChannels());
            }
        }

        return null;
    }

    public List getNotificationChannelGroups() {
        return Api26Impl.getNotificationChannelGroups(this.mNotificationManager);
    }

    public List getNotificationChannelGroupsCompat() {
        List v0 = this.getNotificationChannelGroups();
        if(!v0.isEmpty()) {
            int v2 = 28;
            List v5 = Build$VERSION.SDK_INT >= v2 ? Collections.emptyList() : this.getNotificationChannels();
            ArrayList v1 = new ArrayList(v0.size());
            Iterator v0_1 = v0.iterator();
            while(v0_1.hasNext()) {
                Object v3 = v0_1.next();
                if(Build$VERSION.SDK_INT >= v2) {
                    ((List)v1).add(new NotificationChannelGroupCompat(((NotificationChannelGroup)v3)));
                    continue;
                }

                ((List)v1).add(new NotificationChannelGroupCompat(((NotificationChannelGroup)v3), v5));
            }

            return ((List)v1);
        }

        return Collections.emptyList();
    }

    public List getNotificationChannels() {
        return Api26Impl.getNotificationChannels(this.mNotificationManager);
    }

    public List getNotificationChannelsCompat() {
        List v3 = this.getNotificationChannels();
        if(!v3.isEmpty()) {
            ArrayList v0 = new ArrayList(v3.size());
            Iterator v3_1 = v3.iterator();
            while(v3_1.hasNext()) {
                ((List)v0).add(new NotificationChannelCompat(v3_1.next()));
            }

            return ((List)v0);
        }

        return Collections.emptyList();
    }

    public void notify(int arg2, Notification arg3) {
        this.notify(null, arg2, arg3);
    }

    public void notify(String arg3, int arg4, Notification arg5) {
        if(NotificationManagerCompat.useSideChannelForNotification(arg5)) {
            this.pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), arg4, arg3, arg5));
            this.mNotificationManager.cancel(arg3, arg4);
            return;
        }

        this.mNotificationManager.notify(arg3, arg4, arg5);
    }

    public void notify(List arg6) {
        int v0 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg6.get(v1);
            this.notify(((NotificationWithIdAndTag)v2).mTag, ((NotificationWithIdAndTag)v2).mId, ((NotificationWithIdAndTag)v2).mNotification);
        }
    }

    private void pushSideChannelQueue(Task arg3) {
        Object v0 = NotificationManagerCompat.sLock;
        __monitor_enter(v0);
        try {
            SideChannelManager v1 = NotificationManagerCompat.sSideChannelManager;
            if(v1 == null) {
                v1 = new SideChannelManager(this.mContext.getApplicationContext());
                NotificationManagerCompat.sSideChannelManager = v1;
            }

            v1.queueTask(arg3);
            __monitor_exit(v0);
            return;
        label_13:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_13;
        }

        throw v2;
    }

    private static boolean useSideChannelForNotification(Notification arg1) {
        Bundle v1 = NotificationCompat.getExtras(arg1);
        if(v1 != null && (v1.getBoolean("android.support.useSideChannel"))) {
            return 1;
        }

        return 0;
    }
}

