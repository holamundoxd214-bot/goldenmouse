package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build$VERSION;
import android.provider.Settings$System;
import androidx.core.util.Preconditions;

public class NotificationChannelCompat {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static boolean canBypassDnd(NotificationChannel arg0) {
            return arg0.canBypassDnd();
        }

        static boolean canShowBadge(NotificationChannel arg0) {
            return arg0.canShowBadge();
        }

        static NotificationChannel createNotificationChannel(String arg1, CharSequence arg2, int arg3) {
            return new NotificationChannel(arg1, arg2, arg3);
        }

        static void enableLights(NotificationChannel arg0, boolean arg1) {
            arg0.enableLights(arg1);
        }

        static void enableVibration(NotificationChannel arg0, boolean arg1) {
            arg0.enableVibration(arg1);
        }

        static AudioAttributes getAudioAttributes(NotificationChannel arg0) {
            return arg0.getAudioAttributes();
        }

        static String getDescription(NotificationChannel arg0) {
            return arg0.getDescription();
        }

        static String getGroup(NotificationChannel arg0) {
            return arg0.getGroup();
        }

        static String getId(NotificationChannel arg0) {
            return arg0.getId();
        }

        static int getImportance(NotificationChannel arg0) {
            return arg0.getImportance();
        }

        static int getLightColor(NotificationChannel arg0) {
            return arg0.getLightColor();
        }

        static int getLockscreenVisibility(NotificationChannel arg0) {
            return arg0.getLockscreenVisibility();
        }

        static CharSequence getName(NotificationChannel arg0) {
            return arg0.getName();
        }

        static Uri getSound(NotificationChannel arg0) {
            return arg0.getSound();
        }

        static long[] getVibrationPattern(NotificationChannel arg0) {
            return arg0.getVibrationPattern();
        }

        static void setDescription(NotificationChannel arg0, String arg1) {
            arg0.setDescription(arg1);
        }

        static void setGroup(NotificationChannel arg0, String arg1) {
            arg0.setGroup(arg1);
        }

        static void setLightColor(NotificationChannel arg0, int arg1) {
            arg0.setLightColor(arg1);
        }

        static void setShowBadge(NotificationChannel arg0, boolean arg1) {
            arg0.setShowBadge(arg1);
        }

        static void setSound(NotificationChannel arg0, Uri arg1, AudioAttributes arg2) {
            arg0.setSound(arg1, arg2);
        }

        static void setVibrationPattern(NotificationChannel arg0, long[] arg1) {
            arg0.setVibrationPattern(arg1);
        }

        static boolean shouldShowLights(NotificationChannel arg0) {
            return arg0.shouldShowLights();
        }

        static boolean shouldVibrate(NotificationChannel arg0) {
            return arg0.shouldVibrate();
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static boolean canBubble(NotificationChannel arg0) {
            return arg0.canBubble();
        }
    }

    class Api30Impl {
        private Api30Impl() {
            super();
        }

        static String getConversationId(NotificationChannel arg0) {
            return arg0.getConversationId();
        }

        static String getParentChannelId(NotificationChannel arg0) {
            return arg0.getParentChannelId();
        }

        static boolean isImportantConversation(NotificationChannel arg0) {
            return arg0.isImportantConversation();
        }

        static void setConversationId(NotificationChannel arg0, String arg1, String arg2) {
            arg0.setConversationId(arg1, arg2);
        }
    }

    public class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(String arg2, int arg3) {
            super();
            this.mChannel = new NotificationChannelCompat(arg2, arg3);
        }

        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        public Builder setConversationId(String arg3, String arg4) {
            if(Build$VERSION.SDK_INT >= 30) {
                this.mChannel.mParentId = arg3;
                this.mChannel.mConversationId = arg4;
            }

            return this;
        }

        public Builder setDescription(String arg2) {
            this.mChannel.mDescription = arg2;
            return this;
        }

        public Builder setGroup(String arg2) {
            this.mChannel.mGroupId = arg2;
            return this;
        }

        public Builder setImportance(int arg2) {
            this.mChannel.mImportance = arg2;
            return this;
        }

        public Builder setLightColor(int arg2) {
            this.mChannel.mLightColor = arg2;
            return this;
        }

        public Builder setLightsEnabled(boolean arg2) {
            this.mChannel.mLights = arg2;
            return this;
        }

        public Builder setName(CharSequence arg2) {
            this.mChannel.mName = arg2;
            return this;
        }

        public Builder setShowBadge(boolean arg2) {
            this.mChannel.mShowBadge = arg2;
            return this;
        }

        public Builder setSound(Uri arg2, AudioAttributes arg3) {
            this.mChannel.mSound = arg2;
            this.mChannel.mAudioAttributes = arg3;
            return this;
        }

        public Builder setVibrationEnabled(boolean arg2) {
            this.mChannel.mVibrationEnabled = arg2;
            return this;
        }

        public Builder setVibrationPattern(long[] arg3) {
            NotificationChannelCompat v0 = this.mChannel;
            boolean v1 = arg3 == null || arg3.length <= 0 ? false : true;
            v0.mVibrationEnabled = v1;
            this.mChannel.mVibrationPattern = arg3;
            return this;
        }
    }

    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    NotificationChannelCompat(NotificationChannel arg4) {
        this(Api26Impl.getId(arg4), Api26Impl.getImportance(arg4));
        this.mName = Api26Impl.getName(arg4);
        this.mDescription = Api26Impl.getDescription(arg4);
        this.mGroupId = Api26Impl.getGroup(arg4);
        this.mShowBadge = Api26Impl.canShowBadge(arg4);
        this.mSound = Api26Impl.getSound(arg4);
        this.mAudioAttributes = Api26Impl.getAudioAttributes(arg4);
        this.mLights = Api26Impl.shouldShowLights(arg4);
        this.mLightColor = Api26Impl.getLightColor(arg4);
        this.mVibrationEnabled = Api26Impl.shouldVibrate(arg4);
        this.mVibrationPattern = Api26Impl.getVibrationPattern(arg4);
        int v1 = 30;
        if(Build$VERSION.SDK_INT >= v1) {
            this.mParentId = Api30Impl.getParentChannelId(arg4);
            this.mConversationId = Api30Impl.getConversationId(arg4);
        }

        this.mBypassDnd = Api26Impl.canBypassDnd(arg4);
        this.mLockscreenVisibility = Api26Impl.getLockscreenVisibility(arg4);
        if(Build$VERSION.SDK_INT >= 29) {
            this.mCanBubble = Api29Impl.canBubble(arg4);
        }

        if(Build$VERSION.SDK_INT >= v1) {
            this.mImportantConversation = Api30Impl.isImportantConversation(arg4);
        }
    }

    NotificationChannelCompat(String arg2, int arg3) {
        super();
        this.mShowBadge = true;
        this.mSound = Settings$System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = Preconditions.checkNotNull(arg2);
        this.mImportance = arg3;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public String getConversationId() {
        return this.mConversationId;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getGroup() {
        return this.mGroupId;
    }

    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannel getNotificationChannel() {
        NotificationChannel v0 = Api26Impl.createNotificationChannel(this.mId, this.mName, this.mImportance);
        Api26Impl.setDescription(v0, this.mDescription);
        Api26Impl.setGroup(v0, this.mGroupId);
        Api26Impl.setShowBadge(v0, this.mShowBadge);
        Api26Impl.setSound(v0, this.mSound, this.mAudioAttributes);
        Api26Impl.enableLights(v0, this.mLights);
        Api26Impl.setLightColor(v0, this.mLightColor);
        Api26Impl.setVibrationPattern(v0, this.mVibrationPattern);
        Api26Impl.enableVibration(v0, this.mVibrationEnabled);
        if(Build$VERSION.SDK_INT >= 30) {
            String v1 = this.mParentId;
            if(v1 != null) {
                String v3 = this.mConversationId;
                if(v3 != null) {
                    Api30Impl.setConversationId(v0, v1, v3);
                }
            }
        }

        return v0;
    }

    public String getParentChannelId() {
        return this.mParentId;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }
}

