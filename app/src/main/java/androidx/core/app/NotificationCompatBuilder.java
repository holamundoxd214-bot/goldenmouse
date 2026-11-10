package androidx.core.app;

import android.app.Notification$Action$Builder;
import android.app.Notification$BubbleMetadata;
import android.app.Notification$Builder;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    class Api24Impl {
        private Api24Impl() {
            super();
        }

        static Notification$Action$Builder setAllowGeneratedReplies(Notification$Action$Builder arg0, boolean arg1) {
            return arg0.setAllowGeneratedReplies(arg1);
        }

        static Notification$Builder setCustomBigContentView(Notification$Builder arg0, RemoteViews arg1) {
            return arg0.setCustomBigContentView(arg1);
        }

        static Notification$Builder setCustomContentView(Notification$Builder arg0, RemoteViews arg1) {
            return arg0.setCustomContentView(arg1);
        }

        static Notification$Builder setCustomHeadsUpContentView(Notification$Builder arg0, RemoteViews arg1) {
            return arg0.setCustomHeadsUpContentView(arg1);
        }

        static Notification$Builder setRemoteInputHistory(Notification$Builder arg0, CharSequence[] arg1) {
            return arg0.setRemoteInputHistory(arg1);
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static Notification$Builder createBuilder(Context arg1, String arg2) {
            return new Notification$Builder(arg1, arg2);
        }

        static Notification$Builder setBadgeIconType(Notification$Builder arg0, int arg1) {
            return arg0.setBadgeIconType(arg1);
        }

        static Notification$Builder setColorized(Notification$Builder arg0, boolean arg1) {
            return arg0.setColorized(arg1);
        }

        static Notification$Builder setGroupAlertBehavior(Notification$Builder arg0, int arg1) {
            return arg0.setGroupAlertBehavior(arg1);
        }

        static Notification$Builder setSettingsText(Notification$Builder arg0, CharSequence arg1) {
            return arg0.setSettingsText(arg1);
        }

        static Notification$Builder setShortcutId(Notification$Builder arg0, String arg1) {
            return arg0.setShortcutId(arg1);
        }

        static Notification$Builder setTimeoutAfter(Notification$Builder arg0, long arg1) {
            return arg0.setTimeoutAfter(arg1);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Notification$Builder addPerson(Notification$Builder arg0, Person arg1) {
            return arg0.addPerson(arg1);
        }

        static Notification$Action$Builder setSemanticAction(Notification$Action$Builder arg0, int arg1) {
            return arg0.setSemanticAction(arg1);
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static Notification$Builder setAllowSystemGeneratedContextualActions(Notification$Builder arg0, boolean arg1) {
            return arg0.setAllowSystemGeneratedContextualActions(arg1);
        }

        static Notification$Builder setBubbleMetadata(Notification$Builder arg0, Notification$BubbleMetadata arg1) {
            return arg0.setBubbleMetadata(arg1);
        }

        static Notification$Action$Builder setContextual(Notification$Action$Builder arg0, boolean arg1) {
            return arg0.setContextual(arg1);
        }

        static Notification$Builder setLocusId(Notification$Builder arg0, Object arg1) {
            return arg0.setLocusId(((LocusId)arg1));
        }
    }

    class Api31Impl {
        private Api31Impl() {
            super();
        }

        static Notification$Action$Builder setAuthenticationRequired(Notification$Action$Builder arg0, boolean arg1) {
            return arg0.setAuthenticationRequired(arg1);
        }

        static Notification$Builder setForegroundServiceBehavior(Notification$Builder arg0, int arg1) {
            return arg0.setForegroundServiceBehavior(arg1);
        }
    }

    final class Api36Impl {
        private Api36Impl() {
            super();
        }

        static Notification$Builder setShortCriticalText(Notification$Builder arg0, String arg1) {
            return arg0.setShortCriticalText(arg1);
        }
    }

    final class Api37Impl {
        private Api37Impl() {
            super();
        }

        static Notification$Action$Builder setEmphasisHint(Notification$Action$Builder arg0, int arg1) {
            return arg0.setEmphasisHint(arg1);
        }

        static Notification$Action$Builder setStyleHint(Notification$Action$Builder arg0, int arg1) {
            return arg0.setStyleHint(arg1);
        }
    }

    private RemoteViews mBigContentView;
    private final Notification$Builder mBuilder;
    private final Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    NotificationCompatBuilder(Builder arg14) {
        List v0_3;
        Iterator v0_2;
        super();
        this.mExtras = new Bundle();
        this.mBuilderCompat = arg14;
        Context v0 = arg14.mContext;
        this.mContext = v0;
        Notification$Builder v1 = Api26Impl.createBuilder(arg14.mContext, arg14.mChannelId);
        this.mBuilder = v1;
        Notification v2 = arg14.mNotification;
        Notification$Builder v3 = v1.setWhen(v2.when).setSmallIcon(v2.icon, v2.iconLevel).setContent(v2.contentView).setTicker(v2.tickerText, arg14.mTickerView).setVibrate(v2.vibrate).setLights(v2.ledARGB, v2.ledOnMS, v2.ledOffMS);
        int v5 = 2;
        boolean v4 = (v2.flags & v5) != 0 ? true : false;
        v3 = v3.setOngoing(v4);
        v4 = (v2.flags & 8) != 0 ? true : false;
        v3 = v3.setOnlyAlertOnce(v4);
        v4 = (v2.flags & 16) != 0 ? true : false;
        v3 = v3.setAutoCancel(v4).setDefaults(v2.defaults).setContentTitle(arg14.mContentTitle).setContentText(arg14.mContentText).setContentInfo(arg14.mContentInfo).setContentIntent(arg14.mContentIntent).setDeleteIntent(v2.deleteIntent);
        PendingIntent v4_1 = arg14.mFullScreenIntent;
        boolean v8 = (v2.flags & 0x80) != 0 ? true : false;
        v3.setFullScreenIntent(v4_1, v8).setNumber(arg14.mNumber).setProgress(arg14.mProgressMax, arg14.mProgress, arg14.mProgressIndeterminate);
        Uri v4_2 = null;
        Icon v0_1 = arg14.mLargeIcon == null ? ((Icon)v4_2) : arg14.mLargeIcon.toIcon(v0);
        v1.setLargeIcon(v0_1);
        v1.setSubText(arg14.mSubText).setUsesChronometer(arg14.mUseChronometer).setPriority(arg14.mPriority);
        if((arg14.mStyle instanceof CallStyle)) {
            v0_2 = arg14.mStyle.getActionsListWithSystemActions().iterator();
            while(v0_2.hasNext()) {
                this.addAction(v0_2.next());
            }
        }
        else {
            v0_2 = arg14.mActions.iterator();
            while(v0_2.hasNext()) {
                this.addAction(v0_2.next());
            }
        }

        if(arg14.mExtras != null) {
            this.mExtras.putAll(arg14.mExtras);
        }

        this.mContentView = arg14.mContentView;
        this.mBigContentView = arg14.mBigContentView;
        this.mBuilder.setShowWhen(arg14.mShowWhen);
        this.mBuilder.setLocalOnly(arg14.mLocalOnly);
        this.mBuilder.setGroup(arg14.mGroupKey);
        this.mBuilder.setSortKey(arg14.mSortKey);
        this.mBuilder.setGroupSummary(arg14.mGroupSummary);
        this.mGroupAlertBehavior = arg14.mGroupAlertBehavior;
        this.mBuilder.setCategory(arg14.mCategory);
        this.mBuilder.setColor(arg14.mColor);
        this.mBuilder.setVisibility(arg14.mVisibility);
        this.mBuilder.setPublicVersion(arg14.mPublicVersion);
        this.mBuilder.setSound(v2.sound, v2.audioAttributes);
        int v1_1 = 28;
        if(Build$VERSION.SDK_INT < v1_1) {
            v0_3 = NotificationCompatBuilder.combineLists(NotificationCompatBuilder.getPeople(arg14.mPersonList), arg14.mPeople);
        }
        else {
            ArrayList v0_4 = arg14.mPeople;
        }

        if(v0_3 != null && !v0_3.isEmpty()) {
            v0_2 = v0_3.iterator();
            while(v0_2.hasNext()) {
                this.mBuilder.addPerson(v0_2.next());
            }
        }

        this.mHeadsUpContentView = arg14.mHeadsUpContentView;
        if(arg14.mInvisibleActions.size() > 0) {
            String v3_1 = "android.car.EXTENSIONS";
            Bundle v0_5 = arg14.getExtras().getBundle(v3_1);
            if(v0_5 == null) {
                v0_5 = new Bundle();
            }

            Bundle v8_1 = new Bundle(v0_5);
            Bundle v9 = new Bundle();
            int v10;
            for(v10 = 0; v10 < arg14.mInvisibleActions.size(); ++v10) {
                v9.putBundle(Integer.toString(v10), NotificationCompatJellybean.getBundleForAction(arg14.mInvisibleActions.get(v10)));
            }

            v0_5.putBundle("invisible_actions", v9);
            v8_1.putBundle("invisible_actions", v9);
            arg14.getExtras().putBundle(v3_1, v0_5);
            this.mExtras.putBundle(v3_1, v8_1);
        }

        if(arg14.mSmallIcon != null) {
            this.mBuilder.setSmallIcon(arg14.mSmallIcon);
        }

        this.mBuilder.setExtras(arg14.mExtras);
        Api24Impl.setRemoteInputHistory(this.mBuilder, arg14.mRemoteInputHistory);
        if(arg14.mContentView != null) {
            Api24Impl.setCustomContentView(this.mBuilder, arg14.mContentView);
        }

        if(arg14.mBigContentView != null) {
            Api24Impl.setCustomBigContentView(this.mBuilder, arg14.mBigContentView);
        }

        if(arg14.mHeadsUpContentView != null) {
            Api24Impl.setCustomHeadsUpContentView(this.mBuilder, arg14.mHeadsUpContentView);
        }

        Api26Impl.setBadgeIconType(this.mBuilder, arg14.mBadgeIcon);
        Api26Impl.setSettingsText(this.mBuilder, arg14.mSettingsText);
        Api26Impl.setShortcutId(this.mBuilder, arg14.mShortcutId);
        Api26Impl.setTimeoutAfter(this.mBuilder, arg14.mTimeout);
        Api26Impl.setGroupAlertBehavior(this.mBuilder, arg14.mGroupAlertBehavior);
        if(arg14.mColorizedSet) {
            Api26Impl.setColorized(this.mBuilder, arg14.mColorized);
        }

        if(!TextUtils.isEmpty(arg14.mChannelId)) {
            this.mBuilder.setSound(v4_2).setDefaults(0).setLights(0, 0, 0).setVibrate(((long[])v4_2));
        }

        if(Build$VERSION.SDK_INT >= v1_1) {
            v0_2 = arg14.mPersonList.iterator();
            while(v0_2.hasNext()) {
                Api28Impl.addPerson(this.mBuilder, v0_2.next().toAndroidPerson());
            }
        }

        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, arg14.mAllowSystemGeneratedContextualActions);
            Api29Impl.setBubbleMetadata(this.mBuilder, BubbleMetadata.toPlatform(arg14.mBubbleMetadata));
            if(arg14.mLocusId != null) {
                Api29Impl.setLocusId(this.mBuilder, arg14.mLocusId.toLocusId());
            }
        }

        if(Build$VERSION.SDK_INT >= 0x1F && arg14.mFgsDeferBehavior != 0) {
            Api31Impl.setForegroundServiceBehavior(this.mBuilder, arg14.mFgsDeferBehavior);
        }

        if(Build$VERSION.SDK_INT >= 36) {
            Api36Impl.setShortCriticalText(this.mBuilder, arg14.mShortCriticalText);
        }

        if(arg14.mSilent) {
            this.mGroupAlertBehavior = this.mBuilderCompat.mGroupSummary ? v5 : 1;
            this.mBuilder.setVibrate(((long[])v4_2));
            this.mBuilder.setSound(v4_2);
            v2.defaults &= -2;
            v2.defaults &= -3;
            this.mBuilder.setDefaults(v2.defaults);
            if(TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                this.mBuilder.setGroup("silent");
            }

            Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
        }
    }

    private void addAction(Action arg6) {
        IconCompat v0 = arg6.getIconCompat();
        Icon v0_1 = v0 != null ? v0.toIcon() : null;
        Notification$Action$Builder v1 = new Notification$Action$Builder(v0_1, arg6.getTitle(), arg6.getActionIntent());
        if(arg6.getRemoteInputs() != null) {
            RemoteInput[] v0_2 = androidx.core.app.RemoteInput.fromCompat(arg6.getRemoteInputs());
            int v2 = v0_2.length;
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                v1.addRemoteInput(v0_2[v3]);
            }
        }

        Bundle v0_3 = arg6.getExtras() != null ? new Bundle(arg6.getExtras()) : new Bundle();
        v0_3.putBoolean("android.support.allowGeneratedReplies", arg6.getAllowGeneratedReplies());
        Api24Impl.setAllowGeneratedReplies(v1, arg6.getAllowGeneratedReplies());
        v0_3.putInt("android.support.action.semanticAction", arg6.getSemanticAction());
        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.setSemanticAction(v1, arg6.getSemanticAction());
        }

        if(Build$VERSION.SDK_INT >= 29) {
            Api29Impl.setContextual(v1, arg6.isContextual());
        }

        if(Build$VERSION.SDK_INT >= 0x1F) {
            Api31Impl.setAuthenticationRequired(v1, arg6.isAuthenticationRequired());
        }

        if(Build$VERSION.SDK_INT >= 37) {
            Api37Impl.setEmphasisHint(v1, arg6.getEmphasisHint());
            Api37Impl.setStyleHint(v1, arg6.getStyleHint());
        }

        v0_3.putBoolean("android.support.action.showsUserInterface", arg6.getShowsUserInterface());
        v1.addExtras(v0_3);
        this.mBuilder.addAction(v1.build());
    }

    public Notification build() {
        Style v0 = this.mBuilderCompat.mStyle;
        if(v0 != null) {
            v0.apply(((NotificationBuilderWithBuilderAccessor)this));
        }

        RemoteViews v1 = v0 != null ? v0.makeContentView(((NotificationBuilderWithBuilderAccessor)this)) : null;
        Notification v2 = this.buildInternal();
        if(v1 != null) {
            v2.contentView = v1;
        }
        else if(this.mBuilderCompat.mContentView != null) {
            v2.contentView = this.mBuilderCompat.mContentView;
        }

        if(v0 != null) {
            v1 = v0.makeBigContentView(((NotificationBuilderWithBuilderAccessor)this));
            if(v1 != null) {
                v2.bigContentView = v1;
            }
        }

        if(v0 != null) {
            RemoteViews v3 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(((NotificationBuilderWithBuilderAccessor)this));
            if(v3 != null) {
                v2.headsUpContentView = v3;
            }
        }

        if(v0 != null) {
            Bundle v3_1 = NotificationCompat.getExtras(v2);
            if(v3_1 != null) {
                v0.addCompatExtras(v3_1);
            }
        }

        return v2;
    }

    protected Notification buildInternal() {
        return this.mBuilder.build();
    }

    private static List combineLists(List arg3, List arg4) {
        if(arg3 == null) {
            return arg4;
        }

        if(arg4 == null) {
            return arg3;
        }

        ArraySet v0 = new ArraySet(arg3.size() + arg4.size());
        v0.addAll(((Collection)arg3));
        v0.addAll(((Collection)arg4));
        return new ArrayList(((Collection)v0));
    }

    public Notification$Builder getBuilder() {
        return this.mBuilder;
    }

    Context getContext() {
        return this.mContext;
    }

    private static List getPeople(List arg2) {
        if(arg2 == null) {
            return null;
        }

        ArrayList v0 = new ArrayList(arg2.size());
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            v0.add(v2.next().resolveToLegacyUri());
        }

        return ((List)v0);
    }

    private void removeSoundAndVibration(Notification arg1) {
        arg1.sound = null;
        arg1.vibrate = null;
        arg1.defaults &= -2;
        arg1.defaults &= -3;
    }
}

