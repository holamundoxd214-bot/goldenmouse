package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build$VERSION;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationChannelGroupCompat {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static NotificationChannelGroup createNotificationChannelGroup(String arg1, CharSequence arg2) {
            return new NotificationChannelGroup(arg1, arg2);
        }

        static List getChannels(NotificationChannelGroup arg0) {
            return arg0.getChannels();
        }

        static String getGroup(NotificationChannel arg0) {
            return arg0.getGroup();
        }

        static String getId(NotificationChannelGroup arg0) {
            return arg0.getId();
        }

        static CharSequence getName(NotificationChannelGroup arg0) {
            return arg0.getName();
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static String getDescription(NotificationChannelGroup arg0) {
            return arg0.getDescription();
        }

        static boolean isBlocked(NotificationChannelGroup arg0) {
            return arg0.isBlocked();
        }

        static void setDescription(NotificationChannelGroup arg0, String arg1) {
            arg0.setDescription(arg1);
        }
    }

    public class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(String arg2) {
            super();
            this.mGroup = new NotificationChannelGroupCompat(arg2);
        }

        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        public Builder setDescription(String arg2) {
            this.mGroup.mDescription = arg2;
            return this;
        }

        public Builder setName(CharSequence arg2) {
            this.mGroup.mName = arg2;
            return this;
        }
    }

    private boolean mBlocked;
    private List mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    NotificationChannelGroupCompat(NotificationChannelGroup arg2) {
        this(arg2, Collections.emptyList());
    }

    NotificationChannelGroupCompat(NotificationChannelGroup arg3, List arg4) {
        this(Api26Impl.getId(arg3));
        this.mName = Api26Impl.getName(arg3);
        int v1 = 28;
        if(Build$VERSION.SDK_INT >= v1) {
            this.mDescription = Api28Impl.getDescription(arg3);
        }

        if(Build$VERSION.SDK_INT >= v1) {
            this.mBlocked = Api28Impl.isBlocked(arg3);
            this.mChannels = this.getChannelsCompat(Api26Impl.getChannels(arg3));
            return;
        }

        this.mChannels = this.getChannelsCompat(arg4);
    }

    NotificationChannelGroupCompat(String arg2) {
        super();
        this.mChannels = Collections.emptyList();
        this.mId = Preconditions.checkNotNull(arg2);
    }

    public List getChannels() {
        return this.mChannels;
    }

    private List getChannelsCompat(List arg5) {
        ArrayList v0 = new ArrayList();
        Iterator v5 = arg5.iterator();
        while(v5.hasNext()) {
            Object v1 = v5.next();
            if(!this.mId.equals(Api26Impl.getGroup(((NotificationChannel)v1)))) {
                continue;
            }

            ((List)v0).add(new NotificationChannelCompat(((NotificationChannel)v1)));
        }

        return ((List)v0);
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannelGroup getNotificationChannelGroup() {
        NotificationChannelGroup v0 = Api26Impl.createNotificationChannelGroup(this.mId, this.mName);
        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.setDescription(v0, this.mDescription);
        }

        return v0;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }
}

