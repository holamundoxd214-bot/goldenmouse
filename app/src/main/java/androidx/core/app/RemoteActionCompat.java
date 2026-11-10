package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build$VERSION;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

public final class RemoteActionCompat implements VersionedParcelable {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static RemoteAction createRemoteAction(Icon arg1, CharSequence arg2, CharSequence arg3, PendingIntent arg4) {
            return new RemoteAction(arg1, arg2, arg3, arg4);
        }

        static PendingIntent getActionIntent(RemoteAction arg0) {
            return arg0.getActionIntent();
        }

        static CharSequence getContentDescription(RemoteAction arg0) {
            return arg0.getContentDescription();
        }

        static Icon getIcon(RemoteAction arg0) {
            return arg0.getIcon();
        }

        static CharSequence getTitle(RemoteAction arg0) {
            return arg0.getTitle();
        }

        static boolean isEnabled(RemoteAction arg0) {
            return arg0.isEnabled();
        }

        static void setEnabled(RemoteAction arg0, boolean arg1) {
            arg0.setEnabled(arg1);
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static void setShouldShowIcon(RemoteAction arg0, boolean arg1) {
            arg0.setShouldShowIcon(arg1);
        }

        static boolean shouldShowIcon(RemoteAction arg0) {
            return arg0.shouldShowIcon();
        }
    }

    public PendingIntent mActionIntent;
    public CharSequence mContentDescription;
    public boolean mEnabled;
    public IconCompat mIcon;
    public boolean mShouldShowIcon;
    public CharSequence mTitle;

    public RemoteActionCompat() {
        super();
    }

    public RemoteActionCompat(RemoteActionCompat arg2) {
        super();
        Preconditions.checkNotNull(arg2);
        this.mIcon = arg2.mIcon;
        this.mTitle = arg2.mTitle;
        this.mContentDescription = arg2.mContentDescription;
        this.mActionIntent = arg2.mActionIntent;
        this.mEnabled = arg2.mEnabled;
        this.mShouldShowIcon = arg2.mShouldShowIcon;
    }

    public RemoteActionCompat(IconCompat arg1, CharSequence arg2, CharSequence arg3, PendingIntent arg4) {
        super();
        this.mIcon = Preconditions.checkNotNull(arg1);
        this.mTitle = Preconditions.checkNotNull(arg2);
        this.mContentDescription = Preconditions.checkNotNull(arg3);
        this.mActionIntent = Preconditions.checkNotNull(arg4);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    public static RemoteActionCompat createFromRemoteAction(RemoteAction arg5) {
        Preconditions.checkNotNull(arg5);
        RemoteActionCompat v0 = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(arg5)), Api26Impl.getTitle(arg5), Api26Impl.getContentDescription(arg5), Api26Impl.getActionIntent(arg5));
        v0.setEnabled(Api26Impl.isEnabled(arg5));
        if(Build$VERSION.SDK_INT >= 28) {
            v0.setShouldShowIcon(Api28Impl.shouldShowIcon(arg5));
        }

        return v0;
    }

    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean arg1) {
        this.mEnabled = arg1;
    }

    public void setShouldShowIcon(boolean arg1) {
        this.mShouldShowIcon = arg1;
    }

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    public RemoteAction toRemoteAction() {
        RemoteAction v0 = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(v0, this.isEnabled());
        if(Build$VERSION.SDK_INT >= 28) {
            Api28Impl.setShouldShowIcon(v0, this.shouldShowIcon());
        }

        return v0;
    }
}

