package androidx.core.app;

import android.app.Notification$Action$Builder;
import android.app.Notification$Action;
import android.app.Notification$BigPictureStyle;
import android.app.Notification$BigTextStyle;
import android.app.Notification$BubbleMetadata$Builder;
import android.app.Notification$BubbleMetadata;
import android.app.Notification$Builder;
import android.app.Notification$CallStyle;
import android.app.Notification$DecoratedCustomViewStyle;
import android.app.Notification$InboxStyle;
import android.app.Notification$MessagingStyle$Message;
import android.app.Notification$MessagingStyle;
import android.app.Notification$Metric$FixedDate;
import android.app.Notification$Metric$FixedFloat;
import android.app.Notification$Metric$FixedInt;
import android.app.Notification$Metric$FixedText;
import android.app.Notification$Metric$FixedTime;
import android.app.Notification$Metric$MetricValue;
import android.app.Notification$Metric$TimeDifference;
import android.app.Notification$Metric;
import android.app.Notification$MetricStyle;
import android.app.Notification$ProgressStyle$Point;
import android.app.Notification$ProgressStyle$Segment;
import android.app.Notification$ProgressStyle;
import android.app.Notification$Style;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput$Builder;
import android.content.Context;
import android.content.LocusId;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes$Builder;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Annotation;
import android.text.ParcelableSpan;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback$$ExternalSyntheticThrowIAE2;
import androidx.annotation.ReplaceWith;
import androidx.core.R$color;
import androidx.core.R$dimen;
import androidx.core.R$drawable;
import androidx.core.R$id;
import androidx.core.R$integer;
import androidx.core.R$layout;
import androidx.core.R$string;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.os.BundleCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class NotificationCompat {
    public class Action {
        public final class Builder {
            class Api24Impl {
                private Api24Impl() {
                    super();
                }

                static boolean getAllowGeneratedReplies(Notification$Action arg0) {
                    return arg0.getAllowGeneratedReplies();
                }
            }

            class Api28Impl {
                private Api28Impl() {
                    super();
                }

                static int getSemanticAction(Notification$Action arg0) {
                    return arg0.getSemanticAction();
                }
            }

            class Api29Impl {
                private Api29Impl() {
                    super();
                }

                static boolean isContextual(Notification$Action arg0) {
                    return arg0.isContextual();
                }
            }

            class Api31Impl {
                private Api31Impl() {
                    super();
                }

                static boolean isAuthenticationRequired(Notification$Action arg0) {
                    return arg0.isAuthenticationRequired();
                }
            }

            class Api37Impl {
                private Api37Impl() {
                    super();
                }

                static int getEmphasisHint(Notification$Action arg0) {
                    return arg0.getEmphasisHint();
                }

                static int getStyleHint(Notification$Action arg0) {
                    return arg0.getStyleHint();
                }
            }

            private boolean mAllowGeneratedReplies;
            private boolean mAuthenticationRequired;
            private int mEmphasisHint;
            private final Bundle mExtras;
            private final IconCompat mIcon;
            private final PendingIntent mIntent;
            private boolean mIsContextual;
            private ArrayList mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private int mStyleHint;
            private final CharSequence mTitle;

            public Builder(int arg13, CharSequence arg14, PendingIntent arg15) {
                IconCompat v0_1;
                Resources v0 = null;
                if(arg13 == 0) {
                }
                else {
                    v0_1 = IconCompat.createWithResource(v0, "", arg13);
                }

                this(v0_1, arg14, arg15, new Bundle(), null, true, 0, true, false, false);
            }

            private Builder(IconCompat arg2, CharSequence arg3, PendingIntent arg4, Bundle arg5, RemoteInput[] arg6, boolean arg7, int arg8, boolean arg9, boolean arg10, boolean arg11) {
                super();
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = arg2;
                this.mTitle = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg3);
                this.mIntent = arg4;
                this.mExtras = arg5;
                ArrayList v2 = arg6 == null ? null : new ArrayList(Arrays.asList(((Object[])arg6)));
                this.mRemoteInputs = v2;
                this.mAllowGeneratedReplies = arg7;
                this.mSemanticAction = arg8;
                this.mShowsUserInterface = arg9;
                this.mIsContextual = arg10;
                this.mAuthenticationRequired = arg11;
            }

            public Builder(Action arg12) {
                this(arg12.getIconCompat(), arg12.title, arg12.actionIntent, new Bundle(arg12.mExtras), arg12.getRemoteInputs(), arg12.getAllowGeneratedReplies(), arg12.getSemanticAction(), arg12.mShowsUserInterface, arg12.isContextual(), arg12.isAuthenticationRequired());
            }

            public Builder(IconCompat arg12, CharSequence arg13, PendingIntent arg14) {
                this(arg12, arg13, arg14, new Bundle(), null, true, 0, true, false, false);
            }

            public Builder addExtras(Bundle arg2) {
                if(arg2 != null) {
                    this.mExtras.putAll(arg2);
                }

                return this;
            }

            public Builder addRemoteInput(RemoteInput arg2) {
                ArrayList v0 = this.mRemoteInputs;
                if(v0 == null) {
                    v0 = new ArrayList();
                    this.mRemoteInputs = v0;
                }

                if(arg2 != null) {
                    v0.add(arg2);
                }

                return this;
            }

            public Action build() {
                RemoteInput[] v11;
                Builder v0 = this;
                v0.checkContextualActionNullFields();
                ArrayList v1 = new ArrayList();
                ArrayList v2 = new ArrayList();
                ArrayList v3 = v0.mRemoteInputs;
                if(v3 != null) {
                    Iterator v3_1 = v3.iterator();
                    while(v3_1.hasNext()) {
                        Object v4 = v3_1.next();
                        if(((RemoteInput)v4).isDataOnly()) {
                            ((List)v1).add(v4);
                        }
                        else {
                            ((List)v2).add(v4);
                        }
                    }
                }

                Object[] v4_1 = null;
                if(((List)v1).isEmpty()) {
                    v11 = ((RemoteInput[])v4_1);
                }
                else {
                    Object[] v11_1 = ((List)v1).toArray(new RemoteInput[((List)v1).size()]);
                }

                if(((List)v2).isEmpty()) {
                }
                else {
                    v4_1 = ((List)v2).toArray(new RemoteInput[((List)v2).size()]);
                }

                return new Action(v0.mIcon, v0.mTitle, v0.mIntent, v0.mExtras, v4_1, v11, v0.mAllowGeneratedReplies, v0.mSemanticAction, v0.mShowsUserInterface, v0.mIsContextual, v0.mEmphasisHint, v0.mStyleHint, v0.mAuthenticationRequired);
            }

            private void checkContextualActionNullFields() {
                if(!this.mIsContextual) {
                }
                else {
                    if(this.mIntent != null) {
                        return;
                    }

                    goto label_6;
                }

                return;
            label_6:
                throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
            }

            public Builder extend(Extender arg1) {
                arg1.extend(this);
                return this;
            }

            public static Builder fromAndroidAction(Notification$Action arg5) {
                Builder v1 = arg5.getIcon() != null ? new Builder(IconCompat.createFromIconOrNullIfZeroResId(arg5.getIcon()), arg5.title, arg5.actionIntent) : new Builder(arg5.icon, arg5.title, arg5.actionIntent);
                android.app.RemoteInput[] v0 = arg5.getRemoteInputs();
                if(v0 != null && v0.length != 0) {
                    int v2 = v0.length;
                    int v3;
                    for(v3 = 0; v3 < v2; ++v3) {
                        v1.addRemoteInput(RemoteInput.fromPlatform(v0[v3]));
                    }
                }

                v1.mAllowGeneratedReplies = Api24Impl.getAllowGeneratedReplies(arg5);
                if(Build$VERSION.SDK_INT >= 28) {
                    v1.setSemanticAction(Api28Impl.getSemanticAction(arg5));
                }

                if(Build$VERSION.SDK_INT >= 29) {
                    v1.setContextual(Api29Impl.isContextual(arg5));
                }

                if(Build$VERSION.SDK_INT >= 0x1F) {
                    v1.setAuthenticationRequired(Api31Impl.isAuthenticationRequired(arg5));
                }

                if(Build$VERSION.SDK_INT >= 37) {
                    v1.setStyleHint(Api37Impl.getStyleHint(arg5));
                    v1.setEmphasisHint(Api37Impl.getEmphasisHint(arg5));
                }

                v1.addExtras(arg5.getExtras());
                return v1;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder setAllowGeneratedReplies(boolean arg1) {
                this.mAllowGeneratedReplies = arg1;
                return this;
            }

            public Builder setAuthenticationRequired(boolean arg1) {
                this.mAuthenticationRequired = arg1;
                return this;
            }

            public Builder setContextual(boolean arg1) {
                this.mIsContextual = arg1;
                return this;
            }

            public Builder setEmphasisHint(int arg1) {
                this.mEmphasisHint = arg1;
                return this;
            }

            public Builder setSemanticAction(int arg1) {
                this.mSemanticAction = arg1;
                return this;
            }

            public Builder setShowsUserInterface(boolean arg1) {
                this.mShowsUserInterface = arg1;
                return this;
            }

            public Builder setStyleHint(int arg1) {
                this.mStyleHint = arg1;
                return this;
            }
        }

        @Retention(value=RetentionPolicy.SOURCE) @public interface Emphasis {
        }

        public interface Extender {
            Builder extend(Builder arg1);
        }

        @Retention(value=RetentionPolicy.SOURCE) @public interface SemanticAction {
        }

        @Retention(value=RetentionPolicy.SOURCE) @public interface Style {
        }

        public final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
                super();
                this.mFlags = 1;
            }

            public WearableExtender(Action arg3) {
                super();
                this.mFlags = 1;
                Bundle v3 = arg3.getExtras().getBundle("android.wearable.EXTENSIONS");
                if(v3 != null) {
                    this.mFlags = v3.getInt("flags", 1);
                    this.mInProgressLabel = v3.getCharSequence("inProgressLabel");
                    this.mConfirmLabel = v3.getCharSequence("confirmLabel");
                    this.mCancelLabel = v3.getCharSequence("cancelLabel");
                }
            }

            public WearableExtender clone() {
                WearableExtender v0 = new WearableExtender();
                v0.mFlags = this.mFlags;
                v0.mInProgressLabel = this.mInProgressLabel;
                v0.mConfirmLabel = this.mConfirmLabel;
                v0.mCancelLabel = this.mCancelLabel;
                return v0;
            }

            public Object clone() throws CloneNotSupportedException {
                return this.clone();
            }

            public Builder extend(Builder arg4) {
                Bundle v0 = new Bundle();
                int v1 = this.mFlags;
                if(v1 != 1) {
                    v0.putInt("flags", v1);
                }

                CharSequence v1_1 = this.mInProgressLabel;
                if(v1_1 != null) {
                    v0.putCharSequence("inProgressLabel", v1_1);
                }

                v1_1 = this.mConfirmLabel;
                if(v1_1 != null) {
                    v0.putCharSequence("confirmLabel", v1_1);
                }

                CharSequence v3 = this.mCancelLabel;
                if(v3 != null) {
                    v0.putCharSequence("cancelLabel", v3);
                }

                arg4.getExtras().putBundle("android.wearable.EXTENSIONS", v0);
                return arg4;
            }

            @Deprecated public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            @Deprecated public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                if((this.mFlags & 4) != 0) {
                    return 1;
                }

                return 0;
            }

            public boolean getHintLaunchesActivity() {
                if((this.mFlags & 2) != 0) {
                    return 1;
                }

                return 0;
            }

            @Deprecated public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                if((this.mFlags & 1) != 0) {
                    return 1;
                }

                return 0;
            }

            public WearableExtender setAvailableOffline(boolean arg2) {
                this.setFlag(1, arg2);
                return this;
            }

            @Deprecated public WearableExtender setCancelLabel(CharSequence arg1) {
                this.mCancelLabel = arg1;
                return this;
            }

            @Deprecated public WearableExtender setConfirmLabel(CharSequence arg1) {
                this.mConfirmLabel = arg1;
                return this;
            }

            private void setFlag(int arg2, boolean arg3) {
                int v0 = this.mFlags;
                if(arg3) {
                    this.mFlags = arg2 | v0;
                    return;
                }

                this.mFlags = ~arg2 & v0;
            }

            public WearableExtender setHintDisplayActionInline(boolean arg2) {
                this.setFlag(4, arg2);
                return this;
            }

            public WearableExtender setHintLaunchesActivity(boolean arg2) {
                this.setFlag(2, arg2);
                return this;
            }

            @Deprecated public WearableExtender setInProgressLabel(CharSequence arg1) {
                this.mInProgressLabel = arg1;
                return this;
            }
        }

        public static final int EMPHASIS_AUTO = 0;
        public static final int EMPHASIS_PRIMARY = 1;
        public static final int EMPHASIS_SECONDARY = 2;
        static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_PAUSE = 14;
        public static final int SEMANTIC_ACTION_PLAY = 13;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_STOP = 15;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public static final int STYLE_AUTO = 0;
        public static final int STYLE_ICON_AND_TEXT = 2;
        public static final int STYLE_ICON_ONLY = 3;
        public static final int STYLE_TEXT_ONLY = 1;
        public PendingIntent actionIntent;
        @Deprecated public int icon;
        private boolean mAllowGeneratedReplies;
        private boolean mAuthenticationRequired;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        private final int mEmphasisHint;
        final Bundle mExtras;
        private IconCompat mIcon;
        private final boolean mIsContextual;
        private final RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        private final int mStyleHint;
        public CharSequence title;

        Action(int arg3, CharSequence arg4, PendingIntent arg5, Bundle arg6, RemoteInput[] arg7, RemoteInput[] arg8, boolean arg9, int arg10, boolean arg11, boolean arg12, int arg13, int arg14, boolean arg15) {
            IconCompat v0_1;
            Resources v0 = null;
            if(arg3 == 0) {
            }
            else {
                v0_1 = IconCompat.createWithResource(v0, "", arg3);
            }

            this(v0_1, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
        }

        Action(IconCompat arg3, CharSequence arg4, PendingIntent arg5, Bundle arg6, RemoteInput[] arg7, RemoteInput[] arg8, boolean arg9, int arg10, boolean arg11, boolean arg12, int arg13, int arg14, boolean arg15) {
            super();
            this.mShowsUserInterface = true;
            this.mIcon = arg3;
            if(arg3 != null && arg3.getType() == 2) {
                this.icon = arg3.getResId();
            }

            this.title = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg4);
            this.actionIntent = arg5;
            if(arg6 != null) {
            }
            else {
                arg6 = new Bundle();
            }

            this.mExtras = arg6;
            this.mRemoteInputs = arg7;
            this.mDataOnlyRemoteInputs = arg8;
            this.mAllowGeneratedReplies = arg9;
            this.mSemanticAction = arg10;
            this.mShowsUserInterface = arg11;
            this.mIsContextual = arg12;
            this.mEmphasisHint = arg13;
            this.mStyleHint = arg14;
            this.mAuthenticationRequired = arg15;
        }

        public Action(int arg3, CharSequence arg4, PendingIntent arg5) {
            IconCompat v0_1;
            Resources v0 = null;
            if(arg3 == 0) {
            }
            else {
                v0_1 = IconCompat.createWithResource(v0, "", arg3);
            }

            this(v0_1, arg4, arg5);
        }

        public Action(IconCompat arg15, CharSequence arg16, PendingIntent arg17) {
            this(arg15, arg16, arg17, new Bundle(), null, null, true, 0, true, false, 0, 0, false);
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        public int getEmphasisHint() {
            return this.mEmphasisHint;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        @Deprecated public int getIcon() {
            return this.icon;
        }

        public IconCompat getIconCompat() {
            IconCompat v0 = this.mIcon;
            if(v0 == null) {
                int v1 = this.icon;
                if(v1 != 0) {
                    v0 = IconCompat.createWithResource(null, "", v1);
                    this.mIcon = v0;
                }
            }

            return v0;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        public int getStyleHint() {
            return this.mStyleHint;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isAuthenticationRequired() {
            return this.mAuthenticationRequired;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }
    }

    class androidx.core.app.NotificationCompat$Api24Impl {
        private androidx.core.app.NotificationCompat$Api24Impl() {
            super();
        }

        static boolean getAllowGeneratedReplies(Notification$Action arg0) {
            return arg0.getAllowGeneratedReplies();
        }
    }

    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static int getBadgeIconType(Notification arg0) {
            return arg0.getBadgeIconType();
        }

        static String getChannelId(Notification arg0) {
            return arg0.getChannelId();
        }

        static int getGroupAlertBehavior(Notification arg0) {
            return arg0.getGroupAlertBehavior();
        }

        static CharSequence getSettingsText(Notification arg0) {
            return arg0.getSettingsText();
        }

        static String getShortcutId(Notification arg0) {
            return arg0.getShortcutId();
        }

        static long getTimeoutAfter(Notification arg2) {
            return arg2.getTimeoutAfter();
        }
    }

    class androidx.core.app.NotificationCompat$Api28Impl {
        private androidx.core.app.NotificationCompat$Api28Impl() {
            super();
        }

        static int getSemanticAction(Notification$Action arg0) {
            return arg0.getSemanticAction();
        }
    }

    class androidx.core.app.NotificationCompat$Api29Impl {
        private androidx.core.app.NotificationCompat$Api29Impl() {
            super();
        }

        static boolean getAllowSystemGeneratedContextualActions(Notification arg0) {
            return arg0.getAllowSystemGeneratedContextualActions();
        }

        static Notification$BubbleMetadata getBubbleMetadata(Notification arg0) {
            return arg0.getBubbleMetadata();
        }

        static int getEditChoicesBeforeSending(android.app.RemoteInput arg0) {
            return arg0.getEditChoicesBeforeSending();
        }

        static LocusId getLocusId(Notification arg0) {
            return arg0.getLocusId();
        }

        static boolean isContextual(Notification$Action arg0) {
            return arg0.isContextual();
        }
    }

    class Api36Impl {
        private Api36Impl() {
            super();
        }

        static boolean hasPromotableCharacteristics(Notification arg0) {
            return arg0.hasPromotableCharacteristics();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface BadgeIconType {
    }

    public class BigPictureStyle extends androidx.core.app.NotificationCompat$Style {
        class androidx.core.app.NotificationCompat$BigPictureStyle$Api31Impl {
            private androidx.core.app.NotificationCompat$BigPictureStyle$Api31Impl() {
                super();
            }

            static void setBigPicture(Notification$BigPictureStyle arg0, Icon arg1) {
                arg0.bigPicture(arg1);
            }

            static void setContentDescription(Notification$BigPictureStyle arg0, CharSequence arg1) {
                arg0.setContentDescription(arg1);
            }

            static void showBigPictureWhenCollapsed(Notification$BigPictureStyle arg0, boolean arg1) {
                arg0.showBigPictureWhenCollapsed(arg1);
            }
        }

        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private CharSequence mPictureContentDescription;
        private IconCompat mPictureIcon;
        private boolean mShowBigPictureWhenCollapsed;

        public BigPictureStyle() {
            super();
        }

        public BigPictureStyle(androidx.core.app.NotificationCompat$Builder arg1) {
            super();
            this.setBuilder(arg1);
        }

        public void apply(NotificationBuilderWithBuilderAccessor arg6) {
            Context v3_1;
            Notification$BigPictureStyle v0 = new Notification$BigPictureStyle(arg6.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            int v2 = 0x1F;
            Bitmap v3 = null;
            if(this.mPictureIcon != null) {
                if(Build$VERSION.SDK_INT >= v2) {
                    Context v1 = (arg6 instanceof NotificationCompatBuilder) ? arg6.getContext() : ((Context)v3);
                    androidx.core.app.NotificationCompat$BigPictureStyle$Api31Impl.setBigPicture(v0, this.mPictureIcon.toIcon(v1));
                }
                else {
                    if(this.mPictureIcon.getType() != 1) {
                        goto label_28;
                    }

                    v0 = v0.bigPicture(this.mPictureIcon.getBitmap());
                }
            }

        label_28:
            if(this.mBigLargeIconSet) {
                if(this.mBigLargeIcon == null) {
                    v0.bigLargeIcon(v3);
                }
                else {
                    if((arg6 instanceof NotificationCompatBuilder)) {
                        v3_1 = ((NotificationCompatBuilder)arg6).getContext();
                    }

                    v0.bigLargeIcon(this.mBigLargeIcon.toIcon(v3_1));
                }
            }

            if(this.mSummaryTextSet) {
                v0.setSummaryText(this.mSummaryText);
            }

            if(Build$VERSION.SDK_INT >= v2) {
                androidx.core.app.NotificationCompat$BigPictureStyle$Api31Impl.showBigPictureWhenCollapsed(v0, this.mShowBigPictureWhenCollapsed);
                androidx.core.app.NotificationCompat$BigPictureStyle$Api31Impl.setContentDescription(v0, this.mPictureContentDescription);
            }
        }

        private static IconCompat asIconCompat(Parcelable arg1) {
            if(arg1 != null) {
                if((arg1 instanceof Icon)) {
                    return IconCompat.createFromIcon(((Icon)arg1));
                }
                else if((arg1 instanceof Bitmap)) {
                    return IconCompat.createWithBitmap(((Bitmap)arg1));
                }
            }

            return null;
        }

        public BigPictureStyle bigLargeIcon(Bitmap arg1) {
            IconCompat v1 = arg1 == null ? null : IconCompat.createWithBitmap(arg1);
            this.mBigLargeIcon = v1;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigLargeIcon(Icon arg1) {
            IconCompat v1 = arg1 == null ? null : IconCompat.createFromIcon(arg1);
            this.mBigLargeIcon = v1;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap arg1) {
            IconCompat v1 = arg1 == null ? null : IconCompat.createWithBitmap(arg1);
            this.mPictureIcon = v1;
            return this;
        }

        public BigPictureStyle bigPicture(Icon arg1) {
            this.mPictureIcon = IconCompat.createFromIcon(arg1);
            return this;
        }

        protected void clearCompatExtraKeys(Bundle arg1) {
            super.clearCompatExtraKeys(arg1);
            arg1.remove("android.largeIcon.big");
            arg1.remove("android.picture");
            arg1.remove("android.pictureIcon");
            arg1.remove("android.showBigPictureWhenCollapsed");
        }

        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public static IconCompat getPictureIcon(Bundle arg1) {
            if(arg1 == null) {
                return null;
            }

            Parcelable v0 = arg1.getParcelable("android.picture");
            if(v0 != null) {
                return BigPictureStyle.asIconCompat(v0);
            }

            return BigPictureStyle.asIconCompat(arg1.getParcelable("android.pictureIcon"));
        }

        protected void restoreFromCompatExtras(Bundle arg3) {
            super.restoreFromCompatExtras(arg3);
            String v0 = "android.largeIcon.big";
            if(arg3.containsKey(v0)) {
                this.mBigLargeIcon = BigPictureStyle.asIconCompat(arg3.getParcelable(v0));
                this.mBigLargeIconSet = true;
            }

            this.mPictureIcon = BigPictureStyle.getPictureIcon(arg3);
            this.mShowBigPictureWhenCollapsed = arg3.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public BigPictureStyle setBigContentTitle(CharSequence arg1) {
            this.mBigContentTitle = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            return this;
        }

        public BigPictureStyle setContentDescription(CharSequence arg1) {
            this.mPictureContentDescription = arg1;
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence arg1) {
            this.mSummaryText = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle showBigPictureWhenCollapsed(boolean arg1) {
            this.mShowBigPictureWhenCollapsed = arg1;
            return this;
        }
    }

    public class BigTextStyle extends androidx.core.app.NotificationCompat$Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private CharSequence mBigText;

        public BigTextStyle() {
            super();
        }

        public BigTextStyle(androidx.core.app.NotificationCompat$Builder arg1) {
            super();
            this.setBuilder(arg1);
        }

        public void addCompatExtras(Bundle arg1) {
            super.addCompatExtras(arg1);
        }

        public void apply(NotificationBuilderWithBuilderAccessor arg2) {
            Notification$BigTextStyle v2 = new Notification$BigTextStyle(arg2.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if(this.mSummaryTextSet) {
                v2.setSummaryText(this.mSummaryText);
            }
        }

        public BigTextStyle bigText(CharSequence arg1) {
            this.mBigText = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            return this;
        }

        protected void clearCompatExtraKeys(Bundle arg1) {
            super.clearCompatExtraKeys(arg1);
            arg1.remove("android.bigText");
        }

        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        protected void restoreFromCompatExtras(Bundle arg2) {
            super.restoreFromCompatExtras(arg2);
            this.mBigText = arg2.getCharSequence("android.bigText");
        }

        public BigTextStyle setBigContentTitle(CharSequence arg1) {
            this.mBigContentTitle = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence arg1) {
            this.mSummaryText = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public final class BubbleMetadata {
        class androidx.core.app.NotificationCompat$BubbleMetadata$Api29Impl {
            private androidx.core.app.NotificationCompat$BubbleMetadata$Api29Impl() {
                super();
            }

            static BubbleMetadata fromPlatform(Notification$BubbleMetadata arg3) {
                BubbleMetadata v0 = null;
                if(arg3 == null) {
                    return v0;
                }

                if(arg3.getIntent() == null) {
                    return v0;
                }

                androidx.core.app.NotificationCompat$BubbleMetadata$Builder v0_1 = new androidx.core.app.NotificationCompat$BubbleMetadata$Builder(arg3.getIntent(), IconCompat.createFromIcon(arg3.getIcon())).setAutoExpandBubble(arg3.getAutoExpandBubble()).setDeleteIntent(arg3.getDeleteIntent()).setSuppressNotification(arg3.isNotificationSuppressed());
                if(arg3.getDesiredHeight() != 0) {
                    v0_1.setDesiredHeight(arg3.getDesiredHeight());
                }

                if(arg3.getDesiredHeightResId() != 0) {
                    v0_1.setDesiredHeightResId(arg3.getDesiredHeightResId());
                }

                return v0_1.build();
            }

            static Notification$BubbleMetadata toPlatform(BubbleMetadata arg2) {
                Notification$BubbleMetadata v0 = null;
                if(arg2 == null) {
                    return v0;
                }

                if(arg2.getIntent() == null) {
                    return v0;
                }

                Notification$BubbleMetadata$Builder v0_1 = new Notification$BubbleMetadata$Builder().setIcon(arg2.getIcon().toIcon()).setIntent(arg2.getIntent()).setDeleteIntent(arg2.getDeleteIntent()).setAutoExpandBubble(arg2.getAutoExpandBubble()).setSuppressNotification(arg2.isNotificationSuppressed());
                if(arg2.getDesiredHeight() != 0) {
                    v0_1.setDesiredHeight(arg2.getDesiredHeight());
                }

                if(arg2.getDesiredHeightResId() != 0) {
                    v0_1.setDesiredHeightResId(arg2.getDesiredHeightResId());
                }

                return v0_1.build();
            }
        }

        class Api30Impl {
            private Api30Impl() {
                super();
            }

            static BubbleMetadata fromPlatform(Notification$BubbleMetadata arg3) {
                if(arg3 == null) {
                    return null;
                }

                androidx.core.app.NotificationCompat$BubbleMetadata$Builder v0 = arg3.getShortcutId() != null ? new androidx.core.app.NotificationCompat$BubbleMetadata$Builder(arg3.getShortcutId()) : new androidx.core.app.NotificationCompat$BubbleMetadata$Builder(arg3.getIntent(), IconCompat.createFromIcon(arg3.getIcon()));
                v0.setAutoExpandBubble(arg3.getAutoExpandBubble()).setDeleteIntent(arg3.getDeleteIntent()).setSuppressNotification(arg3.isNotificationSuppressed());
                if(arg3.getDesiredHeight() != 0) {
                    v0.setDesiredHeight(arg3.getDesiredHeight());
                }

                if(arg3.getDesiredHeightResId() != 0) {
                    v0.setDesiredHeightResId(arg3.getDesiredHeightResId());
                }

                return v0.build();
            }

            static Notification$BubbleMetadata toPlatform(BubbleMetadata arg3) {
                if(arg3 == null) {
                    return null;
                }

                Notification$BubbleMetadata$Builder v0 = arg3.getShortcutId() != null ? new Notification$BubbleMetadata$Builder(arg3.getShortcutId()) : new Notification$BubbleMetadata$Builder(arg3.getIntent(), arg3.getIcon().toIcon());
                v0.setDeleteIntent(arg3.getDeleteIntent()).setAutoExpandBubble(arg3.getAutoExpandBubble()).setSuppressNotification(arg3.isNotificationSuppressed());
                if(arg3.getDesiredHeight() != 0) {
                    v0.setDesiredHeight(arg3.getDesiredHeight());
                }

                if(arg3.getDesiredHeightResId() != 0) {
                    v0.setDesiredHeightResId(arg3.getDesiredHeightResId());
                }

                return v0.build();
            }
        }

        public final class androidx.core.app.NotificationCompat$BubbleMetadata$Builder {
            private PendingIntent mDeleteIntent;
            private int mDesiredHeight;
            private int mDesiredHeightResId;
            private int mFlags;
            private IconCompat mIcon;
            private PendingIntent mPendingIntent;
            private String mShortcutId;

            public androidx.core.app.NotificationCompat$BubbleMetadata$Builder(PendingIntent arg1, IconCompat arg2) {
                super();
                if(arg1 != null) {
                    if(arg2 != null) {
                        this.mPendingIntent = arg1;
                        this.mIcon = arg2;
                        return;
                    }

                    throw new NullPointerException("Bubbles require non-null icon");
                }

                throw new NullPointerException("Bubble requires non-null pending intent");
            }

            public androidx.core.app.NotificationCompat$BubbleMetadata$Builder(String arg2) {
                super();
                if(!TextUtils.isEmpty(((CharSequence)arg2))) {
                    this.mShortcutId = arg2;
                    return;
                }

                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            @Deprecated public androidx.core.app.NotificationCompat$BubbleMetadata$Builder() {
                super();
            }

            public BubbleMetadata build() {
                String v0 = this.mShortcutId;
                if(v0 == null) {
                    if(this.mPendingIntent != null) {
                    }
                    else {
                        throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                    }
                }

                if(v0 == null) {
                    if(this.mIcon != null) {
                    }
                    else {
                        throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                    }
                }

                BubbleMetadata v1 = new BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, this.mShortcutId, null);
                v1.setFlags(this.mFlags);
                return v1;
            }

            public androidx.core.app.NotificationCompat$BubbleMetadata$Builder setAutoExpandBubble(boolean arg2) {
                this.setFlag(1, arg2);
                return this;
            }

            public androidx.core.app.NotificationCompat$BubbleMetadata$Builder setDeleteIntent(PendingIntent arg1) {
                this.mDeleteIntent = arg1;
                return this;
            }

            public androidx.core.app.NotificationCompat$BubbleMetadata$Builder setDesiredHeight(int arg2) {
                this.mDesiredHeight = Math.max(arg2, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            public androidx.core.app.NotificationCompat$BubbleMetadata$Builder setDesiredHeightResId(int arg1) {
                this.mDesiredHeightResId = arg1;
                this.mDesiredHeight = 0;
                return this;
            }

            private androidx.core.app.NotificationCompat$BubbleMetadata$Builder setFlag(int arg2, boolean arg3) {
                int v0 = this.mFlags;
                if(arg3) {
                    this.mFlags = arg2 | v0;
                    return this;
                }

                this.mFlags = ~arg2 & v0;
                return this;
            }

            public androidx.core.app.NotificationCompat$BubbleMetadata$Builder setIcon(IconCompat arg2) {
                if(this.mShortcutId == null) {
                    if(arg2 != null) {
                        this.mIcon = arg2;
                        return this;
                    }

                    throw new NullPointerException("Bubbles require non-null icon");
                }

                throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public androidx.core.app.NotificationCompat$BubbleMetadata$Builder setIntent(PendingIntent arg2) {
                if(this.mShortcutId == null) {
                    if(arg2 != null) {
                        this.mPendingIntent = arg2;
                        return this;
                    }

                    throw new NullPointerException("Bubble requires non-null pending intent");
                }

                throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
            }

            public androidx.core.app.NotificationCompat$BubbleMetadata$Builder setSuppressNotification(boolean arg2) {
                this.setFlag(2, arg2);
                return this;
            }
        }

        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private PendingIntent mDeleteIntent;
        private int mDesiredHeight;
        private int mDesiredHeightResId;
        private int mFlags;
        private IconCompat mIcon;
        private PendingIntent mPendingIntent;
        private String mShortcutId;

        private BubbleMetadata(PendingIntent arg1, PendingIntent arg2, IconCompat arg3, int arg4, int arg5, int arg6, String arg7) {
            super();
            this.mPendingIntent = arg1;
            this.mIcon = arg3;
            this.mDesiredHeight = arg4;
            this.mDesiredHeightResId = arg5;
            this.mDeleteIntent = arg2;
            this.mFlags = arg6;
            this.mShortcutId = arg7;
        }

        BubbleMetadata(PendingIntent arg1, PendingIntent arg2, IconCompat arg3, int arg4, int arg5, int arg6, String arg7, NotificationCompat-IA arg8) {
            this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public static BubbleMetadata fromPlatform(Notification$BubbleMetadata arg3) {
            BubbleMetadata v0 = null;
            if(arg3 == null) {
                return v0;
            }

            if(Build$VERSION.SDK_INT >= 30) {
                return Api30Impl.fromPlatform(arg3);
            }

            if(Build$VERSION.SDK_INT == 29) {
                return androidx.core.app.NotificationCompat$BubbleMetadata$Api29Impl.fromPlatform(arg3);
            }

            return v0;
        }

        public boolean getAutoExpandBubble() {
            if((this.mFlags & 1) != 0) {
                return 1;
            }

            return 0;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        public IconCompat getIcon() {
            return this.mIcon;
        }

        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        public String getShortcutId() {
            return this.mShortcutId;
        }

        public boolean isNotificationSuppressed() {
            if((this.mFlags & 2) != 0) {
                return 1;
            }

            return 0;
        }

        public void setFlags(int arg1) {
            this.mFlags = arg1;
        }

        public static Notification$BubbleMetadata toPlatform(BubbleMetadata arg3) {
            Notification$BubbleMetadata v0 = null;
            if(arg3 == null) {
                return v0;
            }

            if(Build$VERSION.SDK_INT >= 30) {
                return Api30Impl.toPlatform(arg3);
            }

            if(Build$VERSION.SDK_INT == 29) {
                return androidx.core.app.NotificationCompat$BubbleMetadata$Api29Impl.toPlatform(arg3);
            }

            return v0;
        }
    }

    public class androidx.core.app.NotificationCompat$Builder {
        class androidx.core.app.NotificationCompat$Builder$Api24Impl {
            private androidx.core.app.NotificationCompat$Builder$Api24Impl() {
                super();
            }

            static RemoteViews createBigContentView(Notification$Builder arg0) {
                return arg0.createHeadsUpContentView();
            }

            static RemoteViews createContentView(Notification$Builder arg0) {
                return arg0.createContentView();
            }

            static RemoteViews createHeadsUpContentView(Notification$Builder arg0) {
                return arg0.createHeadsUpContentView();
            }

            static Notification$Builder recoverBuilder(Context arg0, Notification arg1) {
                return Notification$Builder.recoverBuilder(arg0, arg1);
            }
        }

        private static final int MAX_CHARSEQUENCE_LENGTH = 0x1400;
        public ArrayList mActions;
        boolean mAllowSystemGeneratedContextualActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        BubbleMetadata mBubbleMetadata;
        String mCategory;
        String mChannelId;
        boolean mChronometerCountDown;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        RemoteViews mContentView;
        public Context mContext;
        Bundle mExtras;
        int mFgsDeferBehavior;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList mInvisibleActions;
        IconCompat mLargeIcon;
        boolean mLocalOnly;
        LocusIdCompat mLocusId;
        Notification mNotification;
        int mNumber;
        @Deprecated public ArrayList mPeople;
        public ArrayList mPersonList;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        CharSequence[] mRemoteInputHistory;
        CharSequence mSettingsText;
        String mShortCriticalText;
        String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        Object mSmallIcon;
        String mSortKey;
        androidx.core.app.NotificationCompat$Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        static String -$$Nest$smsafeCharSequenceToString(CharSequence arg0) {
            return androidx.core.app.NotificationCompat$Builder.safeCharSequenceToString(arg0);
        }

        @Deprecated public androidx.core.app.NotificationCompat$Builder(Context arg3) {
            this(arg3, null);
        }

        public androidx.core.app.NotificationCompat$Builder(Context arg4, String arg5) {
            super();
            this.mActions = new ArrayList();
            this.mPersonList = new ArrayList();
            this.mInvisibleActions = new ArrayList();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mFgsDeferBehavior = 0;
            Notification v2 = new Notification();
            this.mNotification = v2;
            this.mContext = arg4;
            this.mChannelId = arg5;
            v2.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        public androidx.core.app.NotificationCompat$Builder(Context arg6, Notification arg7) {
            int v2;
            this(arg6, NotificationCompat.getChannelId(arg7));
            Bundle v6 = arg7.extras;
            androidx.core.app.NotificationCompat$Style v0 = androidx.core.app.NotificationCompat$Style.extractStyleFromNotification(arg7);
            this.setContentTitle(NotificationCompat.getContentTitle(arg7)).setContentText(NotificationCompat.getContentText(arg7)).setContentInfo(NotificationCompat.getContentInfo(arg7)).setSubText(NotificationCompat.getSubText(arg7)).setSettingsText(NotificationCompat.getSettingsText(arg7)).setStyle(v0).setGroup(NotificationCompat.getGroup(arg7)).setGroupSummary(NotificationCompat.isGroupSummary(arg7)).setLocusId(NotificationCompat.getLocusId(arg7)).setWhen(arg7.when).setShowWhen(NotificationCompat.getShowWhen(arg7)).setUsesChronometer(NotificationCompat.getUsesChronometer(arg7)).setAutoCancel(NotificationCompat.getAutoCancel(arg7)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(arg7)).setOngoing(NotificationCompat.getOngoing(arg7)).setLocalOnly(NotificationCompat.getLocalOnly(arg7)).setLargeIcon(arg7.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(arg7)).setCategory(NotificationCompat.getCategory(arg7)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(arg7)).setNumber(arg7.number).setTicker(arg7.tickerText).setContentIntent(arg7.contentIntent).setDeleteIntent(arg7.deleteIntent).setFullScreenIntent(arg7.fullScreenIntent, NotificationCompat.getHighPriority(arg7)).setSound(arg7.sound, arg7.audioStreamType).setSilent(NotificationCompat.isSilent(arg7)).setVibrate(arg7.vibrate).setLights(arg7.ledARGB, arg7.ledOnMS, arg7.ledOffMS).setDefaults(arg7.defaults).setPriority(arg7.priority).setColor(NotificationCompat.getColor(arg7)).setVisibility(NotificationCompat.getVisibility(arg7)).setPublicVersion(NotificationCompat.getPublicVersion(arg7)).setSortKey(NotificationCompat.getSortKey(arg7)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(arg7)).setShortcutId(NotificationCompat.getShortcutId(arg7)).setProgress(v6.getInt("android.progressMax"), v6.getInt("android.progress"), v6.getBoolean("android.progressIndeterminate")).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(arg7)).setSmallIcon(arg7.icon, arg7.iconLevel).addExtras(androidx.core.app.NotificationCompat$Builder.getExtrasWithoutDuplicateData(arg7, v0));
            this.mSmallIcon = arg7.getSmallIcon();
            Icon v0_1 = arg7.getLargeIcon();
            if(v0_1 != null) {
                this.mLargeIcon = IconCompat.createFromIcon(v0_1);
            }

            int v1 = 0;
            if(arg7.actions != null && arg7.actions.length != 0) {
                Notification$Action[] v0_2 = arg7.actions;
                v2 = v0_2.length;
                int v3;
                for(v3 = 0; v3 < v2; ++v3) {
                    this.addAction(Builder.fromAndroidAction(v0_2[v3]).build());
                }
            }

            List v0_3 = NotificationCompat.getInvisibleActions(arg7);
            if(!v0_3.isEmpty()) {
                Iterator v0_4 = v0_3.iterator();
                while(v0_4.hasNext()) {
                    this.addInvisibleAction(v0_4.next());
                }
            }

            String[] v0_5 = arg7.extras.getStringArray("android.people");
            if(v0_5 != null && v0_5.length != 0) {
                v2 = v0_5.length;
                while(v1 < v2) {
                    this.addPerson(v0_5[v1]);
                    ++v1;
                }
            }

            if(Build$VERSION.SDK_INT >= 28) {
                ArrayList v7 = arg7.extras.getParcelableArrayList("android.people.list");
                if(v7 != null && !v7.isEmpty()) {
                    Iterator v7_1 = v7.iterator();
                    while(v7_1.hasNext()) {
                        this.addPerson(Person.fromAndroidPerson(v7_1.next()));
                    }
                }
            }

            String v7_2 = "android.chronometerCountDown";
            if(v6.containsKey(v7_2)) {
                this.setChronometerCountDown(v6.getBoolean(v7_2));
            }

            v7_2 = "android.colorized";
            if(v6.containsKey(v7_2)) {
                this.setColorized(v6.getBoolean(v7_2));
            }

            if(Build$VERSION.SDK_INT >= 36) {
                v7_2 = "android.shortCriticalText";
                if(v6.containsKey(v7_2)) {
                    this.setShortCriticalText(v6.getString(v7_2));
                }
            }
        }

        public androidx.core.app.NotificationCompat$Builder addAction(Action arg2) {
            if(arg2 != null) {
                this.mActions.add(arg2);
            }

            return this;
        }

        public androidx.core.app.NotificationCompat$Builder addAction(int arg3, CharSequence arg4, PendingIntent arg5) {
            this.mActions.add(new Action(arg3, arg4, arg5));
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder addExtras(Bundle arg2) {
            if(arg2 != null) {
                Bundle v0 = this.mExtras;
                if(v0 == null) {
                    this.mExtras = new Bundle(arg2);
                    return this;
                }
                else {
                    v0.putAll(arg2);
                }
            }

            return this;
        }

        public androidx.core.app.NotificationCompat$Builder addInvisibleAction(Action arg2) {
            if(arg2 != null) {
                this.mInvisibleActions.add(arg2);
            }

            return this;
        }

        public androidx.core.app.NotificationCompat$Builder addInvisibleAction(int arg3, CharSequence arg4, PendingIntent arg5) {
            this.mInvisibleActions.add(new Action(arg3, arg4, arg5));
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$Builder addPerson(String arg2) {
            if(arg2 != null && !arg2.isEmpty()) {
                this.mPeople.add(arg2);
            }

            return this;
        }

        public androidx.core.app.NotificationCompat$Builder addPerson(Person arg2) {
            if(arg2 != null) {
                this.mPersonList.add(arg2);
            }

            return this;
        }

        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        public androidx.core.app.NotificationCompat$Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder clearInvisibleActions() {
            this.mInvisibleActions.clear();
            String v1 = "android.car.EXTENSIONS";
            Bundle v0 = this.mExtras.getBundle(v1);
            if(v0 != null) {
                Bundle v2 = new Bundle(v0);
                v2.remove("invisible_actions");
                this.mExtras.putBundle(v1, v2);
            }

            return this;
        }

        public androidx.core.app.NotificationCompat$Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        public RemoteViews createBigContentView() {
            if(this.mBigContentView != null && (this.useExistingRemoteView())) {
                return this.mBigContentView;
            }

            NotificationCompatBuilder v0 = new NotificationCompatBuilder(this);
            androidx.core.app.NotificationCompat$Style v1 = this.mStyle;
            if(v1 != null) {
                RemoteViews v1_1 = v1.makeBigContentView(((NotificationBuilderWithBuilderAccessor)v0));
                if(v1_1 != null) {
                    return v1_1;
                }
            }

            return androidx.core.app.NotificationCompat$Builder$Api24Impl.createBigContentView(androidx.core.app.NotificationCompat$Builder$Api24Impl.recoverBuilder(this.mContext, v0.build()));
        }

        public RemoteViews createContentView() {
            if(this.mContentView != null && (this.useExistingRemoteView())) {
                return this.mContentView;
            }

            NotificationCompatBuilder v0 = new NotificationCompatBuilder(this);
            androidx.core.app.NotificationCompat$Style v1 = this.mStyle;
            if(v1 != null) {
                RemoteViews v1_1 = v1.makeContentView(((NotificationBuilderWithBuilderAccessor)v0));
                if(v1_1 != null) {
                    return v1_1;
                }
            }

            return androidx.core.app.NotificationCompat$Builder$Api24Impl.createContentView(androidx.core.app.NotificationCompat$Builder$Api24Impl.recoverBuilder(this.mContext, v0.build()));
        }

        public RemoteViews createHeadsUpContentView() {
            if(this.mHeadsUpContentView != null && (this.useExistingRemoteView())) {
                return this.mHeadsUpContentView;
            }

            NotificationCompatBuilder v0 = new NotificationCompatBuilder(this);
            androidx.core.app.NotificationCompat$Style v1 = this.mStyle;
            if(v1 != null) {
                RemoteViews v1_1 = v1.makeHeadsUpContentView(((NotificationBuilderWithBuilderAccessor)v0));
                if(v1_1 != null) {
                    return v1_1;
                }
            }

            return androidx.core.app.NotificationCompat$Builder$Api24Impl.createHeadsUpContentView(androidx.core.app.NotificationCompat$Builder$Api24Impl.recoverBuilder(this.mContext, v0.build()));
        }

        public androidx.core.app.NotificationCompat$Builder extend(androidx.core.app.NotificationCompat$Extender arg1) {
            arg1.extend(this);
            return this;
        }

        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        public BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        public int getColor() {
            return this.mColor;
        }

        public RemoteViews getContentView() {
            return this.mContentView;
        }

        public Bundle getExtras() {
            Bundle v0 = this.mExtras;
            if(v0 == null) {
                v0 = new Bundle();
                this.mExtras = v0;
            }

            return v0;
        }

        private static Bundle getExtrasWithoutDuplicateData(Notification arg3, androidx.core.app.NotificationCompat$Style arg4) {
            if(arg3.extras == null) {
                return null;
            }

            Bundle v0 = new Bundle(arg3.extras);
            v0.remove("android.title");
            v0.remove("android.text");
            v0.remove("android.infoText");
            v0.remove("android.subText");
            if(Build$VERSION.SDK_INT >= 36) {
                v0.remove("android.shortCriticalText");
            }

            v0.remove("android.intent.extra.CHANNEL_ID");
            v0.remove("android.intent.extra.CHANNEL_GROUP_ID");
            v0.remove("android.showWhen");
            v0.remove("android.progress");
            v0.remove("android.progressMax");
            v0.remove("android.progressIndeterminate");
            v0.remove("android.chronometerCountDown");
            v0.remove("android.colorized");
            v0.remove("android.people.list");
            v0.remove("android.people");
            v0.remove("android.support.sortKey");
            v0.remove("android.support.groupKey");
            v0.remove("android.support.isGroupSummary");
            v0.remove("android.support.localOnly");
            v0.remove("android.support.actionExtras");
            String v3 = "android.car.EXTENSIONS";
            Bundle v1 = v0.getBundle(v3);
            if(v1 != null) {
                Bundle v2 = new Bundle(v1);
                v2.remove("invisible_actions");
                v0.putBundle(v3, v2);
            }

            if(arg4 != null) {
                arg4.clearCompatExtraKeys(v0);
            }

            return v0;
        }

        public int getForegroundServiceBehavior() {
            return this.mFgsDeferBehavior;
        }

        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @Deprecated public Notification getNotification() {
            return this.build();
        }

        public int getPriority() {
            return this.mPriority;
        }

        public long getWhenIfShowing() {
            if(this.mShowWhen) {
                return this.mNotification.when;
            }

            return 0;
        }

        protected static CharSequence limitCharSequenceLength(CharSequence arg2) {
            if(arg2 == null) {
            }
            else {
                int v1 = 0x1400;
                if(arg2.length() > v1) {
                    arg2 = arg2.subSequence(0, v1);
                }
            }

            return arg2;
        }

        private static String safeCharSequenceToString(CharSequence arg0) {
            if(arg0 == null) {
                return null;
            }

            return androidx.core.app.NotificationCompat$Builder.safeString(arg0.toString());
        }

        private static String safeString(String arg2) {
            if(arg2 == null) {
            }
            else {
                int v1 = 0x1400;
                if(arg2.length() > v1) {
                    arg2 = arg2.substring(0, v1);
                }
            }

            return arg2;
        }

        public androidx.core.app.NotificationCompat$Builder setAllowSystemGeneratedContextualActions(boolean arg1) {
            this.mAllowSystemGeneratedContextualActions = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setAutoCancel(boolean arg2) {
            this.setFlag(16, arg2);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setBadgeIconType(int arg1) {
            this.mBadgeIcon = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setBubbleMetadata(BubbleMetadata arg1) {
            this.mBubbleMetadata = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setCategory(String arg1) {
            this.mCategory = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setChannelId(String arg1) {
            this.mChannelId = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setChronometerCountDown(boolean arg3) {
            this.mChronometerCountDown = arg3;
            this.getExtras().putBoolean("android.chronometerCountDown", arg3);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setColor(int arg1) {
            this.mColor = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setColorized(boolean arg1) {
            this.mColorized = arg1;
            this.mColorizedSet = true;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setContent(RemoteViews arg2) {
            this.mNotification.contentView = arg2;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setContentInfo(CharSequence arg1) {
            this.mContentInfo = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setContentIntent(PendingIntent arg1) {
            this.mContentIntent = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setContentText(CharSequence arg1) {
            this.mContentText = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setContentTitle(CharSequence arg1) {
            this.mContentTitle = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setCustomBigContentView(RemoteViews arg1) {
            this.mBigContentView = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setCustomContentView(RemoteViews arg1) {
            this.mContentView = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setCustomHeadsUpContentView(RemoteViews arg1) {
            this.mHeadsUpContentView = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setDefaults(int arg2) {
            this.mNotification.defaults = arg2;
            if((arg2 & 4) != 0) {
                this.mNotification.flags |= 1;
            }

            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setDeleteIntent(PendingIntent arg2) {
            this.mNotification.deleteIntent = arg2;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setExtras(Bundle arg1) {
            this.mExtras = arg1;
            return this;
        }

        private void setFlag(int arg1, boolean arg2) {
            Notification v0 = this.mNotification;
            if(arg2) {
                v0.flags |= arg1;
                return;
            }

            v0.flags &= ~arg1;
        }

        public androidx.core.app.NotificationCompat$Builder setForegroundServiceBehavior(int arg1) {
            this.mFgsDeferBehavior = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setFullScreenIntent(PendingIntent arg1, boolean arg2) {
            this.mFullScreenIntent = arg1;
            this.setFlag(0x80, arg2);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setGroup(String arg1) {
            this.mGroupKey = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setGroupAlertBehavior(int arg1) {
            this.mGroupAlertBehavior = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setGroupSummary(boolean arg1) {
            this.mGroupSummary = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setLargeIcon(Bitmap arg2) {
            IconCompat v2 = arg2 == null ? null : IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, arg2));
            this.mLargeIcon = v2;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setLargeIcon(Icon arg1) {
            IconCompat v1 = arg1 == null ? null : IconCompat.createFromIcon(arg1);
            this.mLargeIcon = v1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setLights(int arg2, int arg3, int arg4) {
            this.mNotification.ledARGB = arg2;
            this.mNotification.ledOnMS = arg3;
            this.mNotification.ledOffMS = arg4;
            arg2 = this.mNotification.ledOnMS == 0 || this.mNotification.ledOffMS == 0 ? 0 : 1;
            this.mNotification.flags = arg2 | this.mNotification.flags & -2;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setLocalOnly(boolean arg1) {
            this.mLocalOnly = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setLocusId(LocusIdCompat arg1) {
            this.mLocusId = arg1;
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setNumber(int arg1) {
            this.mNumber = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setOngoing(boolean arg2) {
            this.setFlag(2, arg2);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setOnlyAlertOnce(boolean arg2) {
            this.setFlag(8, arg2);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setPriority(int arg1) {
            this.mPriority = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setProgress(int arg1, int arg2, boolean arg3) {
            this.mProgressMax = arg1;
            this.mProgress = arg2;
            this.mProgressIndeterminate = arg3;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setPublicVersion(Notification arg1) {
            this.mPublicVersion = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setRemoteInputHistory(CharSequence[] arg1) {
            this.mRemoteInputHistory = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setRequestPromotedOngoing(boolean arg3) {
            this.getExtras().putBoolean("android.requestPromotedOngoing", arg3);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setSettingsText(CharSequence arg1) {
            this.mSettingsText = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setShortCriticalText(String arg3) {
            this.mShortCriticalText = arg3;
            if(Build$VERSION.SDK_INT < 36) {
                this.getExtras().putString("android.shortCriticalText", arg3);
            }

            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setShortcutId(String arg1) {
            this.mShortcutId = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setShortcutInfo(ShortcutInfoCompat arg3) {
            if(arg3 == null) {
            }
            else {
                this.mShortcutId = arg3.getId();
                if(this.mLocusId == null) {
                    if(arg3.getLocusId() != null) {
                        this.mLocusId = arg3.getLocusId();
                    }
                    else if(arg3.getId() != null) {
                        this.mLocusId = new LocusIdCompat(arg3.getId());
                    }
                }

                if(this.mContentTitle != null) {
                    return this;
                }

                this.setContentTitle(arg3.getShortLabel());
            }

            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setShowWhen(boolean arg1) {
            this.mShowWhen = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setSilent(boolean arg1) {
            this.mSilent = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setSmallIcon(int arg2, int arg3) {
            this.mNotification.icon = arg2;
            this.mNotification.iconLevel = arg3;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setSmallIcon(int arg2) {
            this.mNotification.icon = arg2;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setSmallIcon(IconCompat arg2) {
            this.mSmallIcon = arg2.toIcon(this.mContext);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setSortKey(String arg1) {
            this.mSortKey = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setSound(Uri arg2, int arg3) {
            this.mNotification.sound = arg2;
            this.mNotification.audioStreamType = arg3;
            this.mNotification.audioAttributes = new AudioAttributes$Builder().setContentType(4).setLegacyStreamType(arg3).build();
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setSound(Uri arg2) {
            this.mNotification.sound = arg2;
            this.mNotification.audioStreamType = -1;
            this.mNotification.audioAttributes = new AudioAttributes$Builder().setContentType(4).setUsage(5).build();
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setStyle(androidx.core.app.NotificationCompat$Style arg2) {
            if(this.mStyle != arg2) {
                this.mStyle = arg2;
                if(arg2 != null) {
                    arg2.setBuilder(this);
                }
            }

            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setSubText(CharSequence arg1) {
            this.mSubText = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setTicker(CharSequence arg2) {
            this.mNotification.tickerText = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$Builder setTicker(CharSequence arg2, RemoteViews arg3) {
            this.mNotification.tickerText = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg2);
            this.mTickerView = arg3;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setTimeoutAfter(long arg1) {
            this.mTimeout = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setUsesChronometer(boolean arg1) {
            this.mUseChronometer = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setVibrate(long[] arg2) {
            this.mNotification.vibrate = arg2;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setVisibility(int arg1) {
            this.mVisibility = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$Builder setWhen(long arg2) {
            this.mNotification.when = arg2;
            return this;
        }

        private boolean useExistingRemoteView() {
            androidx.core.app.NotificationCompat$Style v0 = this.mStyle;
            if(v0 != null) {
                if(!v0.displayCustomViewInline()) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }
    }

    public class CallStyle extends androidx.core.app.NotificationCompat$Style {
        class androidx.core.app.NotificationCompat$CallStyle$Api28Impl {
            private androidx.core.app.NotificationCompat$CallStyle$Api28Impl() {
                super();
            }

            static Notification$Builder addPerson(Notification$Builder arg0, android.app.Person arg1) {
                return arg0.addPerson(arg1);
            }

            static Parcelable castToParcelable(android.app.Person arg0) {
                return arg0;
            }
        }

        class androidx.core.app.NotificationCompat$CallStyle$Api31Impl {
            private androidx.core.app.NotificationCompat$CallStyle$Api31Impl() {
                super();
            }

            static Notification$CallStyle forIncomingCall(android.app.Person arg0, PendingIntent arg1, PendingIntent arg2) {
                return Notification$CallStyle.forIncomingCall(arg0, arg1, arg2);
            }

            static Notification$CallStyle forOngoingCall(android.app.Person arg0, PendingIntent arg1) {
                return Notification$CallStyle.forOngoingCall(arg0, arg1);
            }

            static Notification$CallStyle forScreeningCall(android.app.Person arg0, PendingIntent arg1, PendingIntent arg2) {
                return Notification$CallStyle.forScreeningCall(arg0, arg1, arg2);
            }

            static Notification$CallStyle setAnswerButtonColorHint(Notification$CallStyle arg0, int arg1) {
                return arg0.setAnswerButtonColorHint(arg1);
            }

            static Notification$Action$Builder setAuthenticationRequired(Notification$Action$Builder arg0, boolean arg1) {
                return arg0.setAuthenticationRequired(arg1);
            }

            static Notification$CallStyle setDeclineButtonColorHint(Notification$CallStyle arg0, int arg1) {
                return arg0.setDeclineButtonColorHint(arg1);
            }

            static Notification$CallStyle setIsVideo(Notification$CallStyle arg0, boolean arg1) {
                return arg0.setIsVideo(arg1);
            }

            static Notification$CallStyle setVerificationIcon(Notification$CallStyle arg0, Icon arg1) {
                return arg0.setVerificationIcon(arg1);
            }

            static Notification$CallStyle setVerificationText(Notification$CallStyle arg0, CharSequence arg1) {
                return arg0.setVerificationText(arg1);
            }
        }

        @Retention(value=RetentionPolicy.SOURCE) @public interface CallType {
        }

        public static final int CALL_TYPE_INCOMING = 1;
        public static final int CALL_TYPE_ONGOING = 2;
        public static final int CALL_TYPE_SCREENING = 3;
        public static final int CALL_TYPE_UNKNOWN = 0;
        private static final String KEY_ACTION_PRIORITY = "key_action_priority";
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$CallStyle";
        private Integer mAnswerButtonColor;
        private PendingIntent mAnswerIntent;
        private int mCallType;
        private Integer mDeclineButtonColor;
        private PendingIntent mDeclineIntent;
        private PendingIntent mHangUpIntent;
        private boolean mIsVideo;
        private Person mPerson;
        private IconCompat mVerificationIcon;
        private CharSequence mVerificationText;

        public CallStyle() {
            super();
        }

        private CallStyle(int arg2, Person arg3, PendingIntent arg4, PendingIntent arg5, PendingIntent arg6) {
            super();
            if(arg3 != null && !TextUtils.isEmpty(arg3.getName())) {
                this.mCallType = arg2;
                this.mPerson = arg3;
                this.mAnswerIntent = arg6;
                this.mDeclineIntent = arg5;
                this.mHangUpIntent = arg4;
                return;
            }

            throw new IllegalArgumentException("person must have a non-empty a name");
        }

        public CallStyle(androidx.core.app.NotificationCompat$Builder arg1) {
            super();
            this.setBuilder(arg1);
        }

        public void addCompatExtras(Bundle arg4) {
            super.addCompatExtras(arg4);
            arg4.putInt("android.callType", this.mCallType);
            arg4.putBoolean("android.callIsVideo", this.mIsVideo);
            if(this.mPerson != null) {
                int v0 = Build$VERSION.SDK_INT;
                Person v1 = this.mPerson;
                if(v0 >= 28) {
                    arg4.putParcelable("android.callPerson", androidx.core.app.NotificationCompat$CallStyle$Api28Impl.castToParcelable(v1.toAndroidPerson()));
                }
                else {
                    arg4.putParcelable("android.callPersonCompat", v1.toBundle());
                }
            }

            IconCompat v0_1 = this.mVerificationIcon;
            if(v0_1 != null) {
                arg4.putParcelable("android.verificationIcon", v0_1.toIcon(this.mBuilder.mContext));
            }

            arg4.putCharSequence("android.verificationText", this.mVerificationText);
            arg4.putParcelable("android.answerIntent", this.mAnswerIntent);
            arg4.putParcelable("android.declineIntent", this.mDeclineIntent);
            arg4.putParcelable("android.hangUpIntent", this.mHangUpIntent);
            Integer v0_2 = this.mAnswerButtonColor;
            if(v0_2 != null) {
                arg4.putInt("android.answerColor", v0_2.intValue());
            }

            Integer v3 = this.mDeclineButtonColor;
            if(v3 != null) {
                arg4.putInt("android.declineColor", v3.intValue());
            }
        }

        public void apply(NotificationBuilderWithBuilderAccessor arg5) {
            int v0;
            Notification$CallStyle v2 = null;
            if(Build$VERSION.SDK_INT >= 0x1F) {
                v0 = this.mCallType;
                if(v0 == 1) {
                    v2 = androidx.core.app.NotificationCompat$CallStyle$Api31Impl.forIncomingCall(this.mPerson.toAndroidPerson(), this.mDeclineIntent, this.mAnswerIntent);
                }
                else if(v0 != 2) {
                    int v1 = 3;
                    if(v0 != v1) {
                        String v0_1 = "NotifCompat";
                        if(Log.isLoggable(v0_1, v1)) {
                            Log.d(v0_1, "Unrecognized call type in CallStyle: " + String.valueOf(this.mCallType));
                        }
                    }
                    else {
                        v2 = androidx.core.app.NotificationCompat$CallStyle$Api31Impl.forScreeningCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent, this.mAnswerIntent);
                    }
                }
                else {
                    v2 = androidx.core.app.NotificationCompat$CallStyle$Api31Impl.forOngoingCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent);
                }

                if(v2 != null) {
                    v2.setBuilder(arg5.getBuilder());
                    Integer v5 = this.mAnswerButtonColor;
                    if(v5 != null) {
                        androidx.core.app.NotificationCompat$CallStyle$Api31Impl.setAnswerButtonColorHint(v2, v5.intValue());
                    }

                    v5 = this.mDeclineButtonColor;
                    if(v5 != null) {
                        androidx.core.app.NotificationCompat$CallStyle$Api31Impl.setDeclineButtonColorHint(v2, v5.intValue());
                    }

                    androidx.core.app.NotificationCompat$CallStyle$Api31Impl.setVerificationText(v2, this.mVerificationText);
                    IconCompat v5_1 = this.mVerificationIcon;
                    if(v5_1 != null) {
                        androidx.core.app.NotificationCompat$CallStyle$Api31Impl.setVerificationIcon(v2, v5_1.toIcon(this.mBuilder.mContext));
                    }

                    androidx.core.app.NotificationCompat$CallStyle$Api31Impl.setIsVideo(v2, this.mIsVideo);
                }

                return;
            }

            Notification$Builder v5_2 = arg5.getBuilder();
            Person v0_2 = this.mPerson;
            CharSequence v0_3 = v0_2 != null ? v0_2.getName() : ((CharSequence)v2);
            v5_2.setContentTitle(v0_3);
            if(this.mBuilder.mExtras != null) {
                String v1_1 = "android.text";
                if(this.mBuilder.mExtras.containsKey(v1_1)) {
                    CharSequence v2_1 = this.mBuilder.mExtras.getCharSequence(v1_1);
                }
            }

            if((((CharSequence)v2)) == null) {
                String v2_2 = this.getDefaultText();
            }

            v5_2.setContentText(((CharSequence)v2));
            v0_2 = this.mPerson;
            if(v0_2 != null) {
                if(v0_2.getIcon() != null) {
                    v5_2.setLargeIcon(this.mPerson.getIcon().toIcon(this.mBuilder.mContext));
                }

                v0 = Build$VERSION.SDK_INT;
                Person v4 = this.mPerson;
                if(v0 >= 28) {
                    androidx.core.app.NotificationCompat$CallStyle$Api28Impl.addPerson(v5_2, v4.toAndroidPerson());
                    goto label_101;
                }

                v5_2.addPerson(v4.getUri());
            }

        label_101:
            v5_2.setCategory("call");
        }

        public boolean displayCustomViewInline() {
            return 1;
        }

        public static CallStyle forIncomingCall(Person arg6, PendingIntent arg7, PendingIntent arg8) {
            return new CallStyle(1, arg6, null, Objects.requireNonNull(arg7, "declineIntent is required"), Objects.requireNonNull(arg8, "answerIntent is required"));
        }

        public static CallStyle forOngoingCall(Person arg6, PendingIntent arg7) {
            return new CallStyle(2, arg6, Objects.requireNonNull(arg7, "hangUpIntent is required"), null, null);
        }

        public static CallStyle forScreeningCall(Person arg6, PendingIntent arg7, PendingIntent arg8) {
            return new CallStyle(3, arg6, Objects.requireNonNull(arg7, "hangUpIntent is required"), null, Objects.requireNonNull(arg8, "answerIntent is required"));
        }

        public ArrayList getActionsListWithSystemActions() {
            Action v0 = this.makeNegativeAction();
            Action v1 = this.makeAnswerAction();
            ArrayList v2 = new ArrayList(3);
            v2.add(v0);
            ArrayList v0_1 = this.mBuilder.mActions;
            int v4 = 2;
            if(v0_1 != null) {
                Iterator v0_2 = ((List)v0_1).iterator();
                while(v0_2.hasNext()) {
                    Object v5 = v0_2.next();
                    if(((Action)v5).isContextual()) {
                        v2.add(v5);
                    }
                    else if(this.isActionAddedByCallStyle(((Action)v5))) {
                    }
                    else {
                        v2.add(v5);
                        --v4;
                    }

                    if(v1 == null) {
                        continue;
                    }

                    if(v4 != 1) {
                        continue;
                    }

                    v2.add(v1);
                    --v4;
                }
            }

            if(v1 != null && v4 >= 1) {
                v2.add(v1);
            }

            return v2;
        }

        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        private String getDefaultText() {
            int v0 = this.mCallType;
            if(v0 != 1) {
                if(v0 != 2) {
                    if(v0 != 3) {
                        return null;
                    }

                    return this.mBuilder.mContext.getResources().getString(string.call_notification_screening_text);
                }

                return this.mBuilder.mContext.getResources().getString(string.call_notification_ongoing_text);
            }

            return this.mBuilder.mContext.getResources().getString(string.call_notification_incoming_text);
        }

        private boolean isActionAddedByCallStyle(Action arg1) {
            if(arg1 != null && (arg1.getExtras().getBoolean("key_action_priority"))) {
                return 1;
            }

            return 0;
        }

        private Action makeAction(int arg3, int arg4, Integer arg5, int arg6, PendingIntent arg7) {
            if(arg5 == null) {
                arg5 = Integer.valueOf(ContextCompat.getColor(this.mBuilder.mContext, arg6));
            }

            SpannableStringBuilder v6 = new SpannableStringBuilder();
            v6.append(this.mBuilder.mContext.getResources().getString(arg4));
            v6.setSpan(new ForegroundColorSpan(arg5.intValue()), 0, v6.length(), 18);
            Action v2 = new Builder(IconCompat.createWithResource(this.mBuilder.mContext, arg3), ((CharSequence)v6), arg7).build();
            v2.getExtras().putBoolean("key_action_priority", true);
            return v2;
        }

        private Action makeAnswerAction() {
            int v0 = drawable.ic_call_answer_video;
            int v1 = drawable.ic_call_answer;
            if(this.mAnswerIntent == null) {
                return null;
            }

            boolean v2 = this.mIsVideo;
            int v4 = v2 ? v0 : v1;
            v0 = v2 ? string.call_notification_answer_video_action : string.call_notification_answer_action;
            return this.makeAction(v4, v0, this.mAnswerButtonColor, color.call_notification_answer_color, this.mAnswerIntent);
        }

        private Action makeNegativeAction() {
            int v1 = drawable.ic_call_decline;
            if(this.mDeclineIntent == null) {
                return this.makeAction(v1, string.call_notification_hang_up_action, this.mDeclineButtonColor, color.call_notification_decline_color, this.mHangUpIntent);
            }

            return this.makeAction(v1, string.call_notification_decline_action, this.mDeclineButtonColor, color.call_notification_decline_color, this.mDeclineIntent);
        }

        protected void restoreFromCompatExtras(Bundle arg4) {
            String v0;
            super.restoreFromCompatExtras(arg4);
            this.mCallType = arg4.getInt("android.callType");
            this.mIsVideo = arg4.getBoolean("android.callIsVideo");
            if(Build$VERSION.SDK_INT >= 28) {
                v0 = "android.callPerson";
                if(arg4.containsKey(v0)) {
                    this.mPerson = Person.fromAndroidPerson(arg4.getParcelable(v0));
                }
                else {
                    goto label_17;
                }
            }
            else {
            label_17:
                v0 = "android.callPersonCompat";
                if(arg4.containsKey(v0)) {
                    this.mPerson = Person.fromBundle(arg4.getBundle(v0));
                }
            }

            v0 = "android.verificationIcon";
            if(arg4.containsKey(v0)) {
                this.mVerificationIcon = IconCompat.createFromIcon(arg4.getParcelable(v0));
            }
            else {
                v0 = "android.verificationIconCompat";
                if(arg4.containsKey(v0)) {
                    this.mVerificationIcon = IconCompat.createFromBundle(arg4.getBundle(v0));
                }
            }

            this.mVerificationText = arg4.getCharSequence("android.verificationText");
            this.mAnswerIntent = arg4.getParcelable("android.answerIntent");
            this.mDeclineIntent = arg4.getParcelable("android.declineIntent");
            this.mHangUpIntent = arg4.getParcelable("android.hangUpIntent");
            v0 = "android.answerColor";
            Integer v2 = null;
            Integer v0_1 = arg4.containsKey(v0) ? Integer.valueOf(arg4.getInt(v0)) : v2;
            this.mAnswerButtonColor = v0_1;
            v0 = "android.declineColor";
            if(arg4.containsKey(v0)) {
                v2 = Integer.valueOf(arg4.getInt(v0));
            }

            this.mDeclineButtonColor = v2;
        }

        public CallStyle setAnswerButtonColorHint(int arg1) {
            this.mAnswerButtonColor = Integer.valueOf(arg1);
            return this;
        }

        public CallStyle setDeclineButtonColorHint(int arg1) {
            this.mDeclineButtonColor = Integer.valueOf(arg1);
            return this;
        }

        public CallStyle setIsVideo(boolean arg1) {
            this.mIsVideo = arg1;
            return this;
        }

        public CallStyle setVerificationIcon(Bitmap arg1) {
            this.mVerificationIcon = IconCompat.createWithBitmap(arg1);
            return this;
        }

        public CallStyle setVerificationIcon(Icon arg1) {
            IconCompat v1 = arg1 == null ? null : IconCompat.createFromIcon(arg1);
            this.mVerificationIcon = v1;
            return this;
        }

        public CallStyle setVerificationText(CharSequence arg1) {
            this.mVerificationText = arg1;
            return this;
        }
    }

    public final class CarExtender implements androidx.core.app.NotificationCompat$Extender {
        class androidx.core.app.NotificationCompat$CarExtender$Api29Impl {
            private androidx.core.app.NotificationCompat$CarExtender$Api29Impl() {
                super();
            }

            static int getEditChoicesBeforeSending(android.app.RemoteInput arg0) {
                return arg0.getEditChoicesBeforeSending();
            }
        }

        @Deprecated public class UnreadConversation {
            public class androidx.core.app.NotificationCompat$CarExtender$UnreadConversation$Builder {
                private long mLatestTimestamp;
                private final List mMessages;
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public androidx.core.app.NotificationCompat$CarExtender$UnreadConversation$Builder(String arg2) {
                    super();
                    this.mMessages = new ArrayList();
                    this.mParticipant = arg2;
                }

                public androidx.core.app.NotificationCompat$CarExtender$UnreadConversation$Builder addMessage(String arg2) {
                    if(arg2 != null) {
                        this.mMessages.add(arg2);
                    }

                    return this;
                }

                public UnreadConversation build() {
                    return new UnreadConversation(this.mMessages.toArray(new String[this.mMessages.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                public androidx.core.app.NotificationCompat$CarExtender$UnreadConversation$Builder setLatestTimestamp(long arg1) {
                    this.mLatestTimestamp = arg1;
                    return this;
                }

                public androidx.core.app.NotificationCompat$CarExtender$UnreadConversation$Builder setReadPendingIntent(PendingIntent arg1) {
                    this.mReadPendingIntent = arg1;
                    return this;
                }

                public androidx.core.app.NotificationCompat$CarExtender$UnreadConversation$Builder setReplyAction(PendingIntent arg1, RemoteInput arg2) {
                    this.mRemoteInput = arg2;
                    this.mReplyPendingIntent = arg1;
                    return this;
                }
            }

            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            UnreadConversation(String[] arg1, RemoteInput arg2, PendingIntent arg3, PendingIntent arg4, String[] arg5, long arg6) {
                super();
                this.mMessages = arg1;
                this.mRemoteInput = arg2;
                this.mReadPendingIntent = arg4;
                this.mReplyPendingIntent = arg3;
                this.mParticipants = arg5;
                this.mLatestTimestamp = arg6;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public String getParticipant() {
                String[] v1 = this.mParticipants;
                if(v1.length > 0) {
                    return v1[0];
                }

                return null;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String KEY_AUTHOR = "author";
        private static final String KEY_MESSAGES = "messages";
        private static final String KEY_ON_READ = "on_read";
        private static final String KEY_ON_REPLY = "on_reply";
        private static final String KEY_PARTICIPANTS = "participants";
        private static final String KEY_REMOTE_INPUT = "remote_input";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIMESTAMP = "timestamp";
        private int mColor;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        public CarExtender() {
            super();
            this.mColor = 0;
        }

        public CarExtender(Notification arg3) {
            super();
            this.mColor = 0;
            Bundle v3 = NotificationCompat.getExtras(arg3) == null ? null : NotificationCompat.getExtras(arg3).getBundle("android.car.EXTENSIONS");
            if(v3 != null) {
                this.mLargeIcon = v3.getParcelable("large_icon");
                this.mColor = v3.getInt("app_color", 0);
                this.mUnreadConversation = CarExtender.getUnreadConversationFromBundle(v3.getBundle("car_conversation"));
            }
        }

        public androidx.core.app.NotificationCompat$Builder extend(androidx.core.app.NotificationCompat$Builder arg4) {
            Bundle v0 = new Bundle();
            Bitmap v1 = this.mLargeIcon;
            if(v1 != null) {
                v0.putParcelable("large_icon", ((Parcelable)v1));
            }

            int v1_1 = this.mColor;
            if(v1_1 != 0) {
                v0.putInt("app_color", v1_1);
            }

            UnreadConversation v3 = this.mUnreadConversation;
            if(v3 != null) {
                v0.putBundle("car_conversation", CarExtender.getBundleForUnreadConversation(v3));
            }

            arg4.getExtras().putBundle("android.car.EXTENSIONS", v0);
            return arg4;
        }

        private static Bundle getBundleForUnreadConversation(UnreadConversation arg8) {
            Bundle v0 = new Bundle();
            int v2 = 0;
            String v1 = arg8.getParticipants() == null || arg8.getParticipants().length <= 1 ? null : arg8.getParticipants()[0];
            int v3 = arg8.getMessages().length;
            Parcelable[] v4 = new Parcelable[v3];
            while(v2 < v3) {
                Bundle v5 = new Bundle();
                v5.putString("text", arg8.getMessages()[v2]);
                v5.putString("author", v1);
                v4[v2] = ((Parcelable)v5);
                ++v2;
            }

            v0.putParcelableArray("messages", v4);
            RemoteInput v1_1 = arg8.getRemoteInput();
            if(v1_1 != null) {
                RemoteInput$Builder v2_1 = new RemoteInput$Builder(v1_1.getResultKey());
                v2_1.setLabel(v1_1.getLabel());
                v2_1.setChoices(v1_1.getChoices());
                v2_1.setAllowFreeFormInput(v1_1.getAllowFreeFormInput());
                v2_1.addExtras(v1_1.getExtras());
                v0.putParcelable("remote_input", v2_1.build());
            }

            v0.putParcelable("on_reply", arg8.getReplyPendingIntent());
            v0.putParcelable("on_read", arg8.getReadPendingIntent());
            v0.putStringArray("participants", arg8.getParticipants());
            v0.putLong("timestamp", arg8.getLatestTimestamp());
            return v0;
        }

        public int getColor() {
            return this.mColor;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @Deprecated public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        private static UnreadConversation getUnreadConversationFromBundle(Bundle arg21) {
            RemoteInput v9;
            String[] v8;
            Bundle v0 = arg21;
            UnreadConversation v1 = null;
            if(v0 == null) {
                return v1;
            }

            Parcelable[] v2 = v0.getParcelableArray("messages");
            int v3 = 0;
            if(v2 != null) {
                int v4 = v2.length;
                String[] v5 = new String[v4];
                int v6;
                for(v6 = 0; v6 < v4; ++v6) {
                    Parcelable v7 = v2[v6];
                    if(!(v7 instanceof Bundle)) {
                    }
                    else {
                        String v7_1 = ((Bundle)v7).getString("text");
                        v5[v6] = v7_1;
                        if(v7_1 == null) {
                            return v1;
                        }

                        goto label_21;
                    }

                    return v1;
                label_21:
                }

                v8 = v5;
            }
            else {
                v8 = ((String[])v1);
            }

            Parcelable v11 = v0.getParcelable("on_read");
            Parcelable v10 = v0.getParcelable("on_reply");
            Parcelable v2_1 = v0.getParcelable("remote_input");
            String[] v12 = v0.getStringArray("participants");
            if(v12 != null) {
                if(v12.length != 1) {
                }
                else {
                    if(v2_1 != null) {
                        String v14 = ((android.app.RemoteInput)v2_1).getResultKey();
                        CharSequence v15 = ((android.app.RemoteInput)v2_1).getLabel();
                        CharSequence[] v16 = ((android.app.RemoteInput)v2_1).getChoices();
                        boolean v17 = ((android.app.RemoteInput)v2_1).getAllowFreeFormInput();
                        if(Build$VERSION.SDK_INT >= 29) {
                            v3 = androidx.core.app.NotificationCompat$CarExtender$Api29Impl.getEditChoicesBeforeSending(((android.app.RemoteInput)v2_1));
                        }

                        v9 = new RemoteInput(v14, v15, v16, v17, v3, ((android.app.RemoteInput)v2_1).getExtras(), null);
                    }
                    else {
                        v9 = ((RemoteInput)v1);
                    }

                    return new UnreadConversation(v8, v9, ((PendingIntent)v10), ((PendingIntent)v11), v12, v0.getLong("timestamp"));
                }
            }

            return v1;
        }

        public CarExtender setColor(int arg1) {
            this.mColor = arg1;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap arg1) {
            this.mLargeIcon = arg1;
            return this;
        }

        @Deprecated public CarExtender setUnreadConversation(UnreadConversation arg1) {
            this.mUnreadConversation = arg1;
            return this;
        }
    }

    public class DecoratedCustomViewStyle extends androidx.core.app.NotificationCompat$Style {
        class androidx.core.app.NotificationCompat$DecoratedCustomViewStyle$Api24Impl {
            private androidx.core.app.NotificationCompat$DecoratedCustomViewStyle$Api24Impl() {
                super();
            }

            static Notification$Style createDecoratedCustomViewStyle() {
                return new Notification$DecoratedCustomViewStyle();
            }
        }

        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        public DecoratedCustomViewStyle() {
            super();
        }

        public void apply(NotificationBuilderWithBuilderAccessor arg1) {
            arg1.getBuilder().setStyle(androidx.core.app.NotificationCompat$DecoratedCustomViewStyle$Api24Impl.createDecoratedCustomViewStyle());
        }

        private RemoteViews createRemoteViews(RemoteViews arg7, boolean arg8) {
            int v2 = 0;
            RemoteViews v0 = this.applyStandardTemplate(true, layout.notification_template_custom_big, false);
            v0.removeAllViews(id.actions);
            List v1 = DecoratedCustomViewStyle.getNonContextualActions(this.mBuilder.mActions);
            if(!arg8 || v1 == null) {
            label_23:
                v2 = 8;
            }
            else {
                int v8 = Math.min(v1.size(), 3);
                if(v8 > 0) {
                    int v3;
                    for(v3 = 0; v3 < v8; ++v3) {
                        v0.addView(id.actions, this.generateActionButton(v1.get(v3)));
                    }
                }
                else {
                    goto label_23;
                }
            }

            v0.setViewVisibility(id.actions, v2);
            v0.setViewVisibility(id.action_divider, v2);
            this.buildIntoRemoteViews(v0, arg7);
            return v0;
        }

        public boolean displayCustomViewInline() {
            return 1;
        }

        private RemoteViews generateActionButton(Action arg6) {
            int v0 = arg6.actionIntent == null ? 1 : 0;
            String v2 = this.mBuilder.mContext.getPackageName();
            int v3 = v0 != 0 ? layout.notification_action_tombstone : layout.notification_action;
            RemoteViews v1 = new RemoteViews(v2, v3);
            IconCompat v2_1 = arg6.getIconCompat();
            if(v2_1 != null) {
                v1.setImageViewBitmap(id.action_image, this.createColoredBitmap(v2_1, color.notification_action_color_filter));
            }

            v1.setTextViewText(id.action_text, arg6.title);
            if(v0 == 0) {
                v1.setOnClickPendingIntent(id.action_container, arg6.actionIntent);
            }

            v1.setContentDescription(id.action_container, arg6.title);
            return v1;
        }

        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        private static List getNonContextualActions(List arg3) {
            if(arg3 == null) {
                return null;
            }

            ArrayList v0 = new ArrayList();
            Iterator v3 = arg3.iterator();
            while(v3.hasNext()) {
                Object v1 = v3.next();
                if(((Action)v1).isContextual()) {
                    continue;
                }

                ((List)v0).add(v1);
            }

            return ((List)v0);
        }

        public static List getTextsFromContentView(Context arg3, Notification arg4) {
            ApplicationInfo v3_1;
            Context v2;
            RemoteViews v4;
            if(!Notification$DecoratedCustomViewStyle.class.getName().equals(arg4.extras.getString("android.template"))) {
                return Collections.emptyList();
            }

            if(arg4.contentView == null && arg4.bigContentView == null && arg4.headsUpContentView == null) {
                return Collections.emptyList();
            }

            if(arg4.bigContentView != null) {
                v4 = arg4.bigContentView;
            }
            else if(arg4.contentView != null) {
                v4 = arg4.contentView;
            }
            else {
                v4 = arg4.headsUpContentView;
            }

            String v0 = v4.getPackage();
            try {
                v2 = arg3.createPackageContext(v0, 0);
                v3_1 = arg3.getPackageManager().getApplicationInfo(v0, 0);
            }
            catch(PackageManager$NameNotFoundException v3) {
                throw new RuntimeException(((Throwable)v3));
            }

            v2.setTheme(v3_1.theme);
            View v3_2 = v4.apply(v2, null);
            ArrayList v4_1 = new ArrayList();
            DecoratedCustomViewStyle.getTextsFromViewTraversal(v3_2, v4_1);
            return ((List)v4_1);
        }

        private static void getTextsFromViewTraversal(View arg4, ArrayList arg5) {
            if(!(arg4 instanceof ViewGroup)) {
            }
            else {
                int v0 = 0;
                while(true) {
                    View v1 = arg4;
                    if(v0 < ((ViewGroup)v1).getChildCount()) {
                        v1 = ((ViewGroup)v1).getChildAt(v0);
                        if((v1 instanceof TextView)) {
                            CharSequence v2 = v1.getText();
                            if(v2 != null && v2.length() > 0) {
                                arg5.add(v2);
                            }
                        }

                        if((v1 instanceof ViewGroup)) {
                            DecoratedCustomViewStyle.getTextsFromViewTraversal(v1, arg5);
                        }

                        ++v0;
                        continue;
                    }

                    return;
                }
            }
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor arg1) {
            return null;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor arg1) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor arg1) {
            return null;
        }
    }

    public interface androidx.core.app.NotificationCompat$Extender {
        androidx.core.app.NotificationCompat$Builder extend(androidx.core.app.NotificationCompat$Builder arg1);
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface GroupAlertBehavior {
    }

    public class InboxStyle extends androidx.core.app.NotificationCompat$Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList mTexts;

        public InboxStyle() {
            super();
            this.mTexts = new ArrayList();
        }

        public InboxStyle(androidx.core.app.NotificationCompat$Builder arg2) {
            super();
            this.mTexts = new ArrayList();
            this.setBuilder(arg2);
        }

        public InboxStyle addLine(CharSequence arg2) {
            if(arg2 != null) {
                this.mTexts.add(androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg2));
            }

            return this;
        }

        public void apply(NotificationBuilderWithBuilderAccessor arg2) {
            Notification$InboxStyle v2 = new Notification$InboxStyle(arg2.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if(this.mSummaryTextSet) {
                v2.setSummaryText(this.mSummaryText);
            }

            Iterator v1 = this.mTexts.iterator();
            while(v1.hasNext()) {
                v2.addLine(v1.next());
            }
        }

        protected void clearCompatExtraKeys(Bundle arg1) {
            super.clearCompatExtraKeys(arg1);
            arg1.remove("android.textLines");
        }

        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        protected void restoreFromCompatExtras(Bundle arg3) {
            super.restoreFromCompatExtras(arg3);
            this.mTexts.clear();
            String v0 = "android.textLines";
            if(arg3.containsKey(v0)) {
                Collections.addAll(this.mTexts, arg3.getCharSequenceArray(v0));
            }
        }

        public InboxStyle setBigContentTitle(CharSequence arg1) {
            this.mBigContentTitle = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence arg1) {
            this.mSummaryText = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(arg1);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    public class MessagingStyle extends androidx.core.app.NotificationCompat$Style {
        class androidx.core.app.NotificationCompat$MessagingStyle$Api24Impl {
            private androidx.core.app.NotificationCompat$MessagingStyle$Api24Impl() {
                super();
            }

            static Notification$MessagingStyle addMessage(Notification$MessagingStyle arg0, Notification$MessagingStyle$Message arg1) {
                return arg0.addMessage(arg1);
            }

            static Notification$MessagingStyle createMessagingStyle(CharSequence arg1) {
                return new Notification$MessagingStyle(arg1);
            }

            static Notification$MessagingStyle setConversationTitle(Notification$MessagingStyle arg0, CharSequence arg1) {
                return arg0.setConversationTitle(arg1);
            }
        }

        class androidx.core.app.NotificationCompat$MessagingStyle$Api26Impl {
            private androidx.core.app.NotificationCompat$MessagingStyle$Api26Impl() {
                super();
            }

            static Notification$MessagingStyle addHistoricMessage(Notification$MessagingStyle arg0, Notification$MessagingStyle$Message arg1) {
                return arg0.addHistoricMessage(arg1);
            }
        }

        class androidx.core.app.NotificationCompat$MessagingStyle$Api28Impl {
            private androidx.core.app.NotificationCompat$MessagingStyle$Api28Impl() {
                super();
            }

            static Notification$MessagingStyle createMessagingStyle(android.app.Person arg1) {
                return new Notification$MessagingStyle(arg1);
            }

            static Person getUserPerson(Bundle arg0, String arg1) {
                Parcelable v0 = arg0.getParcelable(arg1);
                if((v0 instanceof android.app.Person)) {
                    return Person.fromAndroidPerson(((android.app.Person)v0));
                }

                return null;
            }

            static Notification$MessagingStyle setGroupConversation(Notification$MessagingStyle arg0, boolean arg1) {
                return arg0.setGroupConversation(arg1);
            }
        }

        public final class Message {
            class androidx.core.app.NotificationCompat$MessagingStyle$Message$Api24Impl {
                private androidx.core.app.NotificationCompat$MessagingStyle$Message$Api24Impl() {
                    super();
                }

                static Notification$MessagingStyle$Message createMessage(CharSequence arg1, long arg2, CharSequence arg4) {
                    return new Notification$MessagingStyle$Message(arg1, arg2, arg4);
                }

                static Notification$MessagingStyle$Message setData(Notification$MessagingStyle$Message arg0, String arg1, Uri arg2) {
                    return arg0.setData(arg1, arg2);
                }
            }

            class androidx.core.app.NotificationCompat$MessagingStyle$Message$Api28Impl {
                private androidx.core.app.NotificationCompat$MessagingStyle$Message$Api28Impl() {
                    super();
                }

                static Parcelable castToParcelable(android.app.Person arg0) {
                    return arg0;
                }

                static Notification$MessagingStyle$Message createMessage(CharSequence arg1, long arg2, android.app.Person arg4) {
                    return new Notification$MessagingStyle$Message(arg1, arg2, arg4);
                }

                static void setExtras(Notification$MessagingStyle$Message arg0, Bundle arg1) {
                    arg0.getExtras().putAll(arg1);
                }
            }

            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_EXTRAS_BUNDLE = "extras";
            static final String KEY_NOTIFICATION_PERSON = "sender_person";
            static final String KEY_PERSON = "person";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            private String mDataMimeType;
            private Uri mDataUri;
            private Bundle mExtras;
            private final Person mPerson;
            private final CharSequence mText;
            private final long mTimestamp;

            public Message(CharSequence arg2, long arg3, Person arg5) {
                super();
                this.mExtras = new Bundle();
                this.mText = arg2;
                this.mTimestamp = arg3;
                this.mPerson = arg5;
            }

            @Deprecated public Message(CharSequence arg2, long arg3, CharSequence arg5) {
                this(arg2, arg3, new androidx.core.app.Person$Builder().setName(arg5).build());
            }

            static Bundle[] getBundleArrayForMessages(List arg4) {
                Bundle[] v0 = new Bundle[arg4.size()];
                int v1 = arg4.size();
                int v2;
                for(v2 = 0; v2 < v1; ++v2) {
                    v0[v2] = arg4.get(v2).toBundle();
                }

                return v0;
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            static Message getMessageFromBundle(Bundle arg10) {
                Person v3_1;
                String v0 = "uri";
                String v1 = "extras";
                String v2 = "type";
                String v3 = "sender";
                String v4 = "sender_person";
                String v5 = "person";
                String v6 = "time";
                String v7 = "text";
                Message v8 = null;
                try {
                    if(arg10.containsKey(v7)) {
                        if(!arg10.containsKey(v6)) {
                        }
                        else {
                            if(arg10.containsKey(v5)) {
                                v3_1 = Person.fromBundle(arg10.getBundle(v5));
                            }
                            else {
                                if((arg10.containsKey(v4)) && Build$VERSION.SDK_INT >= 28) {
                                    v3_1 = Person.fromAndroidPerson(arg10.getParcelable(v4));
                                    goto label_36;
                                }

                                if(arg10.containsKey(v3)) {
                                    v3_1 = new androidx.core.app.Person$Builder().setName(arg10.getCharSequence(v3)).build();
                                    goto label_36;
                                }

                                v3_1 = ((Person)v8);
                            }

                        label_36:
                            Message v4_1 = new Message(arg10.getCharSequence(v7), arg10.getLong(v6), v3_1);
                            if((arg10.containsKey(v2)) && (arg10.containsKey(v0))) {
                                v4_1.setData(arg10.getString(v2), arg10.getParcelable(v0));
                            }

                            if(arg10.containsKey(v1)) {
                                v4_1.getExtras().putAll(arg10.getBundle(v1));
                            }

                            return v4_1;
                        }
                    }
                }
                catch(ClassCastException ) {
                }

                return v8;
            }

            static List getMessagesFromBundleArray(Parcelable[] arg4) {
                ArrayList v0 = new ArrayList(arg4.length);
                int v1;
                for(v1 = 0; v1 < arg4.length; ++v1) {
                    Parcelable v2 = arg4[v1];
                    if((v2 instanceof Bundle)) {
                        Message v2_1 = Message.getMessageFromBundle(((Bundle)v2));
                        if(v2_1 != null) {
                            ((List)v0).add(v2_1);
                        }
                    }
                }

                return ((List)v0);
            }

            public Person getPerson() {
                return this.mPerson;
            }

            @Deprecated public CharSequence getSender() {
                Person v0 = this.mPerson;
                if(v0 == null) {
                    return null;
                }

                return v0.getName();
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public Message setData(String arg1, Uri arg2) {
                this.mDataMimeType = arg1;
                this.mDataUri = arg2;
                return this;
            }

            Notification$MessagingStyle$Message toAndroidMessage() {
                CharSequence v2_1;
                Notification$MessagingStyle$Message v0_1;
                long v4;
                CharSequence v1;
                Person v0 = this.getPerson();
                android.app.Person v2 = null;
                int v3 = 28;
                if(Build$VERSION.SDK_INT >= v3) {
                    v1 = this.getText();
                    v4 = this.getTimestamp();
                    if(v0 == null) {
                    }
                    else {
                        v2 = v0.toAndroidPerson();
                    }

                    v0_1 = androidx.core.app.NotificationCompat$MessagingStyle$Message$Api28Impl.createMessage(v1, v4, v2);
                }
                else {
                    v1 = this.getText();
                    v4 = this.getTimestamp();
                    if(v0 == null) {
                    }
                    else {
                        v2_1 = v0.getName();
                    }

                    v0_1 = androidx.core.app.NotificationCompat$MessagingStyle$Message$Api24Impl.createMessage(v1, v4, v2_1);
                }

                if(this.getDataMimeType() != null) {
                    androidx.core.app.NotificationCompat$MessagingStyle$Message$Api24Impl.setData(v0_1, this.getDataMimeType(), this.getDataUri());
                }

                if(Build$VERSION.SDK_INT >= v3) {
                    Bundle v6 = this.mExtras;
                    if(v6 != null) {
                        androidx.core.app.NotificationCompat$MessagingStyle$Message$Api28Impl.setExtras(v0_1, v6);
                    }
                }

                return v0_1;
            }

            private Bundle toBundle() {
                Bundle v0 = new Bundle();
                CharSequence v1 = this.mText;
                if(v1 != null) {
                    v0.putCharSequence("text", v1);
                }

                v0.putLong("time", this.mTimestamp);
                Person v1_1 = this.mPerson;
                if(v1_1 != null) {
                    v0.putCharSequence("sender", v1_1.getName());
                    int v1_2 = Build$VERSION.SDK_INT;
                    Person v2 = this.mPerson;
                    if(v1_2 >= 28) {
                        v0.putParcelable("sender_person", androidx.core.app.NotificationCompat$MessagingStyle$Message$Api28Impl.castToParcelable(v2.toAndroidPerson()));
                    }
                    else {
                        v0.putBundle("person", v2.toBundle());
                    }
                }

                String v1_3 = this.mDataMimeType;
                if(v1_3 != null) {
                    v0.putString("type", v1_3);
                }

                Uri v1_4 = this.mDataUri;
                if(v1_4 != null) {
                    v0.putParcelable("uri", ((Parcelable)v1_4));
                }

                Bundle v4 = this.mExtras;
                if(v4 != null) {
                    v0.putBundle("extras", v4);
                }

                return v0;
            }
        }

        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";
        private CharSequence mConversationTitle;
        private final List mHistoricMessages;
        private Boolean mIsGroupConversation;
        private final List mMessages;
        private Person mUser;

        MessagingStyle() {
            super();
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
        }

        public MessagingStyle(Person arg2) {
            super();
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            if(!TextUtils.isEmpty(arg2.getName())) {
                this.mUser = arg2;
                return;
            }

            throw new IllegalArgumentException("User\'s name must not be empty.");
        }

        @Deprecated public MessagingStyle(CharSequence arg2) {
            super();
            this.mMessages = new ArrayList();
            this.mHistoricMessages = new ArrayList();
            this.mUser = new androidx.core.app.Person$Builder().setName(arg2).build();
        }

        public void addCompatExtras(Bundle arg3) {
            super.addCompatExtras(arg3);
            if(Build$VERSION.SDK_INT < 28) {
                arg3.putCharSequence("android.selfDisplayName", this.mUser.getName());
                arg3.putBundle("android.messagingStyleUser", this.mUser.toBundle());
                arg3.putCharSequence("android.hiddenConversationTitle", this.mConversationTitle);
                if(this.mConversationTitle != null && (this.mIsGroupConversation.booleanValue())) {
                    arg3.putCharSequence("android.conversationTitle", this.mConversationTitle);
                }

                if(!this.mMessages.isEmpty()) {
                    arg3.putParcelableArray("android.messages", Message.getBundleArrayForMessages(this.mMessages));
                }

                if(!this.mHistoricMessages.isEmpty()) {
                    arg3.putParcelableArray("android.messages.historic", Message.getBundleArrayForMessages(this.mHistoricMessages));
                }

                Boolean v2 = this.mIsGroupConversation;
                if(v2 == null) {
                    return;
                }

                arg3.putBoolean("android.isGroupConversation", v2.booleanValue());
            }
        }

        public MessagingStyle addHistoricMessage(Message arg2) {
            if(arg2 != null) {
                this.mHistoricMessages.add(arg2);
                if(this.mHistoricMessages.size() > 25) {
                    this.mHistoricMessages.remove(0);
                }
            }

            return this;
        }

        public MessagingStyle addMessage(Message arg2) {
            if(arg2 != null) {
                this.mMessages.add(arg2);
                if(this.mMessages.size() > 25) {
                    this.mMessages.remove(0);
                }
            }

            return this;
        }

        public MessagingStyle addMessage(CharSequence arg2, long arg3, Person arg5) {
            this.addMessage(new Message(arg2, arg3, arg5));
            return this;
        }

        @Deprecated public MessagingStyle addMessage(CharSequence arg4, long arg5, CharSequence arg7) {
            this.mMessages.add(new Message(arg4, arg5, new androidx.core.app.Person$Builder().setName(arg7).build()));
            if(this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }

            return this;
        }

        public void apply(NotificationBuilderWithBuilderAccessor arg6) {
            this.setGroupConversation(this.isGroupConversation());
            int v0 = Build$VERSION.SDK_INT;
            Person v1 = this.mUser;
            int v2 = 28;
            Notification$MessagingStyle v0_1 = v0 >= v2 ? androidx.core.app.NotificationCompat$MessagingStyle$Api28Impl.createMessagingStyle(v1.toAndroidPerson()) : androidx.core.app.NotificationCompat$MessagingStyle$Api24Impl.createMessagingStyle(v1.getName());
            Iterator v1_1 = this.mMessages.iterator();
            while(v1_1.hasNext()) {
                androidx.core.app.NotificationCompat$MessagingStyle$Api24Impl.addMessage(v0_1, v1_1.next().toAndroidMessage());
            }

            v1_1 = this.mHistoricMessages.iterator();
            while(v1_1.hasNext()) {
                androidx.core.app.NotificationCompat$MessagingStyle$Api26Impl.addHistoricMessage(v0_1, v1_1.next().toAndroidMessage());
            }

            if((this.mIsGroupConversation.booleanValue()) || Build$VERSION.SDK_INT >= v2) {
                androidx.core.app.NotificationCompat$MessagingStyle$Api24Impl.setConversationTitle(v0_1, this.mConversationTitle);
            }

            if(Build$VERSION.SDK_INT >= v2) {
                androidx.core.app.NotificationCompat$MessagingStyle$Api28Impl.setGroupConversation(v0_1, this.mIsGroupConversation.booleanValue());
            }

            ((Notification$Style)v0_1).setBuilder(arg6.getBuilder());
        }

        protected void clearCompatExtraKeys(Bundle arg1) {
            super.clearCompatExtraKeys(arg1);
            arg1.remove("android.messagingStyleUser");
            arg1.remove("android.selfDisplayName");
            arg1.remove("android.conversationTitle");
            arg1.remove("android.hiddenConversationTitle");
            arg1.remove("android.messages");
            arg1.remove("android.messages.historic");
            arg1.remove("android.isGroupConversation");
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification arg1) {
            androidx.core.app.NotificationCompat$Style v1 = androidx.core.app.NotificationCompat$Style.extractStyleFromNotification(arg1);
            if((v1 instanceof MessagingStyle)) {
                return ((MessagingStyle)v1);
            }

            return null;
        }

        private Message findLatestIncomingMessage() {
            int v0;
            for(v0 = this.mMessages.size() - 1; true; --v0) {
                List v1 = this.mMessages;
                if(v0 < 0) {
                    break;
                }

                Object v1_1 = v1.get(v0);
                if(((Message)v1_1).getPerson() != null && !TextUtils.isEmpty(((Message)v1_1).getPerson().getName())) {
                    return ((Message)v1_1);
                }
            }

            if(!v1.isEmpty()) {
                return this.mMessages.get(this.mMessages.size() - 1);
            }

            return null;
        }

        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public List getHistoricMessages() {
            return this.mHistoricMessages;
        }

        public List getMessages() {
            return this.mMessages;
        }

        public Person getUser() {
            return this.mUser;
        }

        @Deprecated public CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        private boolean hasMessagesWithoutSender() {
            int v0;
            for(v0 = this.mMessages.size() - 1; v0 >= 0; --v0) {
                Object v2 = this.mMessages.get(v0);
                if(((Message)v2).getPerson() != null && ((Message)v2).getPerson().getName() == null) {
                    return 1;
                }
            }

            return 0;
        }

        public boolean isGroupConversation() {
            if(this.mBuilder != null && this.mBuilder.mContext.getApplicationInfo().targetSdkVersion < 28 && this.mIsGroupConversation == null) {
                if(this.mConversationTitle != null) {
                    return 1;
                }
                else {
                    return 0;
                }
            }

            Boolean v3 = this.mIsGroupConversation;
            if(v3 != null) {
                return v3.booleanValue();
            }

            return 0;
        }

        private TextAppearanceSpan makeFontColorSpan(int arg7) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(arg7), null);
        }

        private CharSequence makeMessageLine(Message arg7) {
            CharSequence v3_1;
            CharSequence v2_1;
            BidiFormatter v0 = BidiFormatter.getInstance();
            SpannableStringBuilder v1 = new SpannableStringBuilder();
            String v3 = "";
            if(arg7.getPerson() == null) {
                String v2 = v3;
            }
            else {
                v2_1 = arg7.getPerson().getName();
            }

            int v5 = 0xFF000000;
            if(TextUtils.isEmpty(v2_1)) {
                v2_1 = this.mUser.getName();
                if(this.mBuilder.getColor() != 0) {
                    v5 = this.mBuilder.getColor();
                }
            }

            v2_1 = v0.unicodeWrap(v2_1);
            v1.append(v2_1);
            v1.setSpan(this.makeFontColorSpan(v5), v1.length() - v2_1.length(), v1.length(), 33);
            if(arg7.getText() == null) {
            }
            else {
                v3_1 = arg7.getText();
            }

            v1.append("  ").append(v0.unicodeWrap(v3_1));
            return ((CharSequence)v1);
        }

        protected void restoreFromCompatExtras(Bundle arg3) {
            Person v0_1;
            String v0;
            super.restoreFromCompatExtras(arg3);
            this.mMessages.clear();
            if(Build$VERSION.SDK_INT >= 28) {
                v0 = "android.messagingUser";
                if(arg3.containsKey(v0)) {
                    v0_1 = androidx.core.app.NotificationCompat$MessagingStyle$Api28Impl.getUserPerson(arg3, v0);
                }
                else {
                    goto label_11;
                }
            }
            else {
            label_11:
                v0_1 = null;
            }

            if(v0_1 != null) {
                this.mUser = v0_1;
            }
            else {
                v0 = "android.messagingStyleUser";
                this.mUser = arg3.containsKey(v0) ? Person.fromBundle(arg3.getBundle(v0)) : new androidx.core.app.Person$Builder().setName(arg3.getString("android.selfDisplayName")).build();
            }

            CharSequence v0_2 = arg3.getCharSequence("android.conversationTitle");
            this.mConversationTitle = v0_2;
            if(v0_2 == null) {
                this.mConversationTitle = arg3.getCharSequence("android.hiddenConversationTitle");
            }

            Parcelable[] v0_3 = arg3.getParcelableArray("android.messages");
            if(v0_3 != null) {
                this.mMessages.addAll(Message.getMessagesFromBundleArray(v0_3));
            }

            v0_3 = arg3.getParcelableArray("android.messages.historic");
            if(v0_3 != null) {
                this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray(v0_3));
            }

            v0 = "android.isGroupConversation";
            if(arg3.containsKey(v0)) {
                this.mIsGroupConversation = Boolean.valueOf(arg3.getBoolean(v0));
            }
        }

        public MessagingStyle setConversationTitle(CharSequence arg1) {
            this.mConversationTitle = arg1;
            return this;
        }

        public MessagingStyle setGroupConversation(boolean arg1) {
            this.mIsGroupConversation = Boolean.valueOf(arg1);
            return this;
        }
    }

    public final class Metric {
        public final class FixedDate extends MetricValue {
            @Retention(value=RetentionPolicy.SOURCE) @public interface Format {
            }

            public static final int FORMAT_AUTOMATIC = 0;
            public static final int FORMAT_LONG_DATE = 1;
            public static final int FORMAT_SHORT_DATE = 2;
            private static final String KEY_FORMAT = "format";
            private static final String KEY_VALUE = "value";
            private final int mFormat;
            private final LocalDate mValue;

            static FixedDate -$$Nest$smfromBundle(Bundle arg0) {
                return FixedDate.fromBundle(arg0);
            }

            public FixedDate(LocalDate arg2) {
                this(arg2, 0);
            }

            public FixedDate(LocalDate arg3, int arg4) {
                super(null);
                this.mValue = Objects.requireNonNull(arg3);
                boolean v3 = arg4 < 0 || arg4 > 2 ? false : true;
                Preconditions.checkArgument(v3, "Invalid format: %s", new Object[]{Integer.valueOf(arg4)});
                this.mFormat = arg4;
            }

            public boolean equals(Object arg5) {
                if(!(arg5 instanceof FixedDate)) {
                    return 0;
                }

                if(this == (((FixedDate)arg5))) {
                    return 1;
                }

                if((Objects.equals(this.mValue, ((FixedDate)arg5).mValue)) && this.mFormat == ((FixedDate)arg5).mFormat) {
                    return 1;
                }

                return 0;
            }

            private static FixedDate fromBundle(Bundle arg3) {
                String v0 = "value";
                FixedDate v2 = null;
                LocalDate v0_1 = arg3.containsKey(v0) ? LocalDate.ofEpochDay(arg3.getLong(v0)) : ((LocalDate)v2);
                if(v0_1 != null) {
                    return new FixedDate(v0_1, arg3.getInt("format", 0));
                }

                return v2;
            }

            public int getFormat() {
                return this.mFormat;
            }

            public LocalDate getValue() {
                return this.mValue;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{this.mValue, Integer.valueOf(this.mFormat)});
            }

            void toBundle(Bundle arg4) {
                arg4.putLong("value", this.mValue.toEpochDay());
                arg4.putInt("format", this.mFormat);
            }

            public String toString() {
                return this.getClass().getSimpleName() + "{mValue=" + this.mValue + ", mFormat=" + this.mFormat + "}";
            }
        }

        public final class FixedFloat extends MetricValue {
            private static final int DEFAULT_MAX_FRACTION_DIGITS = 2;
            private static final int DEFAULT_MIN_FRACTION_DIGITS = 0;
            private static final String KEY_MAX_FRACTION_DIGITS = "maxDigits";
            private static final String KEY_MIN_FRACTION_DIGITS = "minDigits";
            private static final String KEY_UNIT = "unit";
            private static final String KEY_VALUE = "value";
            private static final int LOWER_BOUND_FRACTION_DIGITS = 0;
            private static final int UPPER_BOUND_FRACTION_DIGITS = 6;
            private final int mMaxFractionDigits;
            private final int mMinFractionDigits;
            private final String mUnit;
            private final float mValue;

            static FixedFloat -$$Nest$smfromBundle(Bundle arg0) {
                return FixedFloat.fromBundle(arg0);
            }

            public FixedFloat(float arg2) {
                this(arg2, null);
            }

            public FixedFloat(float arg3, CharSequence arg4) {
                this(arg3, arg4, 0, 2);
            }

            public FixedFloat(float arg5, CharSequence arg6, int arg7, int arg8) {
                super(null);
                this.mValue = arg5;
                this.mUnit = androidx.core.app.NotificationCompat$Builder.-$$Nest$smsafeCharSequenceToString(arg6);
                int v5 = 6;
                boolean v6 = true;
                boolean v1 = arg7 < 0 || arg7 > v5 ? false : true;
                Preconditions.checkArgument(v1, "Invalid minFractionDigits: %s", new Object[]{Integer.valueOf(arg7)});
                boolean v5_1 = arg8 < 0 || arg8 > v5 ? false : true;
                Preconditions.checkArgument(v5_1, "Invalid maxFractionDigits: %s", new Object[]{Integer.valueOf(arg8)});
                if(arg7 <= arg8) {
                }
                else {
                    v6 = false;
                }

                Preconditions.checkArgument(v6, "Invalid minFractionDigits/maxFractionDigits: %s/%s", new Object[]{Integer.valueOf(arg7), Integer.valueOf(arg8)});
                this.mMinFractionDigits = arg7;
                this.mMaxFractionDigits = arg8;
            }

            public boolean equals(Object arg5) {
                if(!(arg5 instanceof FixedFloat)) {
                    return 0;
                }

                if(this == (((FixedFloat)arg5))) {
                    return 1;
                }

                if(this.mValue == ((FixedFloat)arg5).mValue && (Objects.equals(this.mUnit, ((FixedFloat)arg5).mUnit)) && this.mMinFractionDigits == ((FixedFloat)arg5).mMinFractionDigits && this.mMaxFractionDigits == ((FixedFloat)arg5).mMaxFractionDigits) {
                    return 1;
                }

                return 0;
            }

            private static FixedFloat fromBundle(Bundle arg6) {
                return new FixedFloat(arg6.getFloat("value"), arg6.getString("unit"), arg6.getInt("minDigits", 0), arg6.getInt("maxDigits", 2));
            }

            public int getMaxFractionDigits() {
                return this.mMaxFractionDigits;
            }

            public int getMinFractionDigits() {
                return this.mMinFractionDigits;
            }

            public CharSequence getUnit() {
                return this.mUnit;
            }

            public float getValue() {
                return this.mValue;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{Float.valueOf(this.mValue), this.mUnit, Integer.valueOf(this.mMinFractionDigits), Integer.valueOf(this.mMaxFractionDigits)});
            }

            void toBundle(Bundle arg3) {
                arg3.putFloat("value", this.mValue);
                arg3.putString("unit", this.mUnit);
                arg3.putInt("minDigits", this.mMinFractionDigits);
                arg3.putInt("maxDigits", this.mMaxFractionDigits);
            }

            public String toString() {
                return this.getClass().getSimpleName() + "{mValue=" + this.mValue + ", mUnit=" + this.mUnit + ", mMinFractionDigits=" + this.mMinFractionDigits + ", mMaxFractionDigits=" + this.mMaxFractionDigits + "}";
            }
        }

        public final class FixedInt extends MetricValue {
            private static final String KEY_UNIT = "unit";
            private static final String KEY_VALUE = "value";
            private final String mUnit;
            private final int mValue;

            static FixedInt -$$Nest$smfromBundle(Bundle arg0) {
                return FixedInt.fromBundle(arg0);
            }

            public FixedInt(int arg2) {
                this(arg2, null);
            }

            public FixedInt(int arg2, CharSequence arg3) {
                super(null);
                this.mValue = arg2;
                this.mUnit = androidx.core.app.NotificationCompat$Builder.-$$Nest$smsafeCharSequenceToString(arg3);
            }

            public boolean equals(Object arg5) {
                if(!(arg5 instanceof FixedInt)) {
                    return 0;
                }

                if(this == (((FixedInt)arg5))) {
                    return 1;
                }

                if(this.mValue == ((FixedInt)arg5).mValue && (Objects.equals(this.mUnit, ((FixedInt)arg5).mUnit))) {
                    return 1;
                }

                return 0;
            }

            private static FixedInt fromBundle(Bundle arg3) {
                return new FixedInt(arg3.getInt("value"), arg3.getString("unit"));
            }

            public CharSequence getUnit() {
                return this.mUnit;
            }

            public int getValue() {
                return this.mValue;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{Integer.valueOf(this.mValue), this.mUnit});
            }

            void toBundle(Bundle arg3) {
                arg3.putInt("value", this.mValue);
                arg3.putString("unit", this.mUnit);
            }

            public String toString() {
                return this.getClass().getSimpleName() + "{mValue=" + this.mValue + ", mUnit=" + this.mUnit + "}";
            }
        }

        public final class FixedText extends MetricValue {
            private static final String KEY_UNIT = "unit";
            private static final String KEY_VALUE = "value";
            private final String mUnit;
            private final String mValue;

            static FixedText -$$Nest$smfromBundle(Bundle arg0) {
                return FixedText.fromBundle(arg0);
            }

            public FixedText(CharSequence arg2) {
                this(arg2, null);
            }

            public FixedText(CharSequence arg2, CharSequence arg3) {
                super(null);
                this.mValue = androidx.core.app.NotificationCompat$Builder.-$$Nest$smsafeCharSequenceToString(Objects.requireNonNull(arg2));
                this.mUnit = androidx.core.app.NotificationCompat$Builder.-$$Nest$smsafeCharSequenceToString(arg3);
            }

            public boolean equals(Object arg5) {
                if(!(arg5 instanceof FixedText)) {
                    return 0;
                }

                if(this == (((FixedText)arg5))) {
                    return 1;
                }

                if((Objects.equals(this.mValue, ((FixedText)arg5).mValue)) && (Objects.equals(this.mUnit, ((FixedText)arg5).mUnit))) {
                    return 1;
                }

                return 0;
            }

            private static FixedText fromBundle(Bundle arg3) {
                return new FixedText(arg3.getString("value", ""), arg3.getString("unit"));
            }

            public CharSequence getUnit() {
                return this.mUnit;
            }

            public CharSequence getValue() {
                return this.mValue;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{this.mValue, this.mUnit});
            }

            void toBundle(Bundle arg3) {
                arg3.putString("value", this.mValue);
                arg3.putString("unit", this.mUnit);
            }

            public String toString() {
                return this.getClass().getSimpleName() + "{mValue=" + this.mValue + ", mUnit=" + this.mUnit + "}";
            }
        }

        public final class FixedTime extends MetricValue {
            private static final String KEY_VALUE = "value";
            private final LocalTime mValue;

            static FixedTime -$$Nest$smfromBundle(Bundle arg0) {
                return FixedTime.fromBundle(arg0);
            }

            public FixedTime(LocalTime arg2) {
                super(null);
                this.mValue = Objects.requireNonNull(arg2).truncatedTo(ChronoUnit.SECONDS);
            }

            public boolean equals(Object arg2) {
                if(!(arg2 instanceof FixedTime)) {
                    return 0;
                }

                if(this == (((FixedTime)arg2))) {
                    return 1;
                }

                return Objects.equals(this.mValue, ((FixedTime)arg2).mValue);
            }

            private static FixedTime fromBundle(Bundle arg3) {
                String v0 = "value";
                FixedTime v2 = null;
                LocalTime v3 = arg3.containsKey(v0) ? LocalTime.ofSecondOfDay(arg3.getLong(v0)) : ((LocalTime)v2);
                if(v3 != null) {
                    return new FixedTime(v3);
                }

                return v2;
            }

            public LocalTime getValue() {
                return this.mValue;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{this.mValue});
            }

            void toBundle(Bundle arg3) {
                arg3.putLong("value", ((long)this.mValue.toSecondOfDay()));
            }

            public String toString() {
                return this.getClass().getSimpleName() + "{mValue=" + this.mValue + "}";
            }
        }

        public abstract class MetricValue {
            private static final String KEY_TYPE = "_type";
            private static final int TYPE_FIXED_DATE = 2;
            private static final int TYPE_FIXED_FLOAT = 5;
            private static final int TYPE_FIXED_INT = 4;
            private static final int TYPE_FIXED_TEXT = 6;
            private static final int TYPE_FIXED_TIME = 3;
            private static final int TYPE_TIME_DIFFERENCE = 1;

            static MetricValue -$$Nest$smfromBundle(Bundle arg0) {
                return MetricValue.fromBundle(arg0);
            }

            static Bundle -$$Nest$smtoBundle(MetricValue arg0) {
                return MetricValue.toBundle(arg0);
            }

            private MetricValue() {
                super();
            }

            MetricValue(NotificationCompat-IA arg1) {
                this();
            }

            private static MetricValue fromBundle(Bundle arg1) {
                switch(arg1.getInt("_type")) {
                    case 1: {
                        goto label_15;
                    }
                    case 2: {
                        goto label_13;
                    }
                    case 3: {
                        goto label_11;
                    }
                    case 4: {
                        goto label_9;
                    }
                    case 5: {
                        goto label_7;
                    }
                    case 6: {
                        goto label_5;
                    }
                }

                return null;
            label_5:
                return FixedText.-$$Nest$smfromBundle(arg1);
            label_7:
                return FixedFloat.-$$Nest$smfromBundle(arg1);
            label_9:
                return FixedInt.-$$Nest$smfromBundle(arg1);
            label_11:
                return FixedTime.-$$Nest$smfromBundle(arg1);
            label_13:
                return FixedDate.-$$Nest$smfromBundle(arg1);
            label_15:
                return TimeDifference.-$$Nest$smfromBundle(arg1);
            }

            private static Bundle toBundle(MetricValue arg3) {
                Bundle v0 = new Bundle();
                String v2 = "_type";
                if((arg3 instanceof TimeDifference)) {
                    v0.putInt(v2, 1);
                }
                else if((arg3 instanceof FixedDate)) {
                    v0.putInt(v2, 2);
                }
                else if((arg3 instanceof FixedTime)) {
                    v0.putInt(v2, 3);
                }
                else if((arg3 instanceof FixedInt)) {
                    v0.putInt(v2, 4);
                }
                else if((arg3 instanceof FixedFloat)) {
                    v0.putInt(v2, 5);
                }
                else if((arg3 instanceof FixedText)) {
                    v0.putInt(v2, 6);
                }
                else {
                    goto label_34;
                }

                arg3.toBundle(v0);
                return v0;
            label_34:
                throw new AssertionError("Impossible MetricValue subclass: " + arg3);
            }

            abstract void toBundle(Bundle arg1);
        }

        public final class TimeDifference extends MetricValue {
            @Retention(value=RetentionPolicy.SOURCE) @public interface androidx.core.app.NotificationCompat$Metric$TimeDifference$Format {
            }

            public static final int FORMAT_ADAPTIVE = 1;
            public static final int FORMAT_CHRONOMETER = 2;
            private static final String KEY_COUNT_DOWN = "countDown";
            private static final String KEY_FORMAT = "format";
            private static final String KEY_PAUSED_DURATION = "pausedDuration";
            private static final String KEY_ZERO_ELAPSED_REALTIME = "zeroElapsedRealtime";
            private static final String KEY_ZERO_TIME = "zeroTime";
            private final boolean mCountDown;
            private final int mFormat;
            private final Duration mPausedDuration;
            private final Long mZeroElapsedRealtime;
            private final Instant mZeroTime;

            static TimeDifference -$$Nest$smfromBundle(Bundle arg0) {
                return TimeDifference.fromBundle(arg0);
            }

            private TimeDifference(Instant arg6, Long arg7, Duration arg8, boolean arg9, int arg10) {
                super(null);
                boolean v0 = false;
                int v2 = arg6 != null ? 1 : 0;
                int v3 = arg7 != null ? 1 : 0;
                v2 += v3;
                v3 = arg8 != null ? 1 : 0;
                boolean v2_1 = v2 + v3 == 1 ? true : false;
                Preconditions.checkArgument(v2_1, "Exactly one of zeroTime, zeroElapsedRealtime, or pausedDuration must be present; received %s,%s,%s", new Object[]{arg6, arg7, arg8});
                if(arg10 >= 1 && arg10 <= 2) {
                    v0 = true;
                }

                Preconditions.checkArgument(v0, "Invalid format: %s", new Object[]{Integer.valueOf(arg10)});
                this.mZeroTime = arg6;
                this.mZeroElapsedRealtime = arg7;
                this.mPausedDuration = arg8;
                this.mCountDown = arg9;
                this.mFormat = arg10;
            }

            public boolean equals(Object arg5) {
                if(!(arg5 instanceof TimeDifference)) {
                    return 0;
                }

                if(this == (((TimeDifference)arg5))) {
                    return 1;
                }

                if((Objects.equals(this.mZeroTime, ((TimeDifference)arg5).mZeroTime)) && (Objects.equals(this.mZeroElapsedRealtime, ((TimeDifference)arg5).mZeroElapsedRealtime)) && (Objects.equals(this.mPausedDuration, ((TimeDifference)arg5).mPausedDuration)) && this.mCountDown == ((TimeDifference)arg5).mCountDown && this.mFormat == ((TimeDifference)arg5).mFormat) {
                    return 1;
                }

                return 0;
            }

            public static TimeDifference forPausedStopwatch(Duration arg6, int arg7) {
                return new TimeDifference(null, null, Objects.requireNonNull(arg6), false, arg7);
            }

            public static TimeDifference forPausedTimer(Duration arg6, int arg7) {
                return new TimeDifference(null, null, Objects.requireNonNull(arg6), true, arg7);
            }

            public static TimeDifference forStopwatch(long arg6, int arg8) {
                return new TimeDifference(null, Long.valueOf(arg6), null, false, arg8);
            }

            public static TimeDifference forStopwatch(Instant arg6, int arg7) {
                return new TimeDifference(Objects.requireNonNull(arg6), null, null, false, arg7);
            }

            public static TimeDifference forTimer(long arg6, int arg8) {
                return new TimeDifference(null, Long.valueOf(arg6), null, true, arg8);
            }

            public static TimeDifference forTimer(Instant arg6, int arg7) {
                return new TimeDifference(Objects.requireNonNull(arg6), null, null, true, arg7);
            }

            private static TimeDifference fromBundle(Bundle arg9) {
                String v0 = "zeroTime";
                TimeDifference v2 = null;
                Instant v4 = arg9.containsKey(v0) ? Instant.ofEpochMilli(arg9.getLong(v0)) : ((Instant)v2);
                v0 = "zeroElapsedRealtime";
                Long v5 = arg9.containsKey(v0) ? Long.valueOf(arg9.getLong(v0)) : ((Long)v2);
                v0 = "pausedDuration";
                Duration v6 = arg9.containsKey(v0) ? Duration.ofMillis(arg9.getLong(v0)) : ((Duration)v2);
                if(v4 == null && v5 == null) {
                    if(v6 != null) {
                    }
                    else {
                        return v2;
                    }
                }

                return new TimeDifference(v4, v5, v6, arg9.getBoolean("countDown"), arg9.getInt("format"));
            }

            public int getFormat() {
                return this.mFormat;
            }

            public Duration getPausedDuration() {
                return this.mPausedDuration;
            }

            public Long getZeroElapsedRealtime() {
                return this.mZeroElapsedRealtime;
            }

            public Instant getZeroTime() {
                return this.mZeroTime;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{this.mZeroTime, this.mZeroElapsedRealtime, this.mPausedDuration, Boolean.valueOf(this.mCountDown), Integer.valueOf(this.mFormat)});
            }

            public boolean isStopwatch() {
                return this.mCountDown ^ 1;
            }

            public boolean isTimer() {
                return this.mCountDown;
            }

            void toBundle(Bundle arg5) {
                Instant v0 = this.mZeroTime;
                if(v0 != null) {
                    arg5.putLong("zeroTime", v0.toEpochMilli());
                }
                else {
                    Long v0_1 = this.mZeroElapsedRealtime;
                    if(v0_1 != null) {
                        arg5.putLong("zeroElapsedRealtime", v0_1.longValue());
                    }
                    else {
                        Duration v0_2 = this.mPausedDuration;
                        if(v0_2 != null) {
                            arg5.putLong("pausedDuration", v0_2.toMillis());
                        }
                    }
                }

                arg5.putBoolean("countDown", this.mCountDown);
                arg5.putInt("format", this.mFormat);
            }

            public String toString() {
                StringBuilder v0 = new StringBuilder("TimeDifference{");
                if(this.mZeroTime != null) {
                    v0.append("mZeroTime=").append(this.mZeroTime);
                }
                else if(this.mZeroElapsedRealtime != null) {
                    v0.append("mZeroElapsedRealtime=").append(this.mZeroElapsedRealtime);
                }
                else if(this.mPausedDuration != null) {
                    v0.append("mPausedDuration=").append(this.mPausedDuration);
                }

                v0.append(", mCountDown=").append(this.mCountDown).append(", mFormat=").append(this.mFormat).append("}");
                return v0.toString();
            }
        }

        private static final String KEY_LABEL = "label";
        private static final String KEY_SEMANTIC_STYLE = "semanticStyle";
        private static final String KEY_VALUE = "value";
        private final String mLabel;
        private final int mSemanticStyle;
        private final MetricValue mValue;

        static Metric -$$Nest$smfromBundle(Bundle arg0) {
            return Metric.fromBundle(arg0);
        }

        static Bundle -$$Nest$smtoBundle(Metric arg0) {
            return Metric.toBundle(arg0);
        }

        public Metric(MetricValue arg2, CharSequence arg3) {
            this(arg2, arg3, 0);
        }

        public Metric(MetricValue arg1, CharSequence arg2, int arg3) {
            super();
            this.mValue = Objects.requireNonNull(arg1);
            String v1 = androidx.core.app.NotificationCompat$Builder.-$$Nest$smsafeCharSequenceToString(Objects.requireNonNull(arg2));
            this.mLabel = v1;
            Preconditions.checkArgument(OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(v1) ^ 1, "Metric label is required");
            this.mSemanticStyle = arg3;
        }

        public boolean equals(Object arg5) {
            if(!(arg5 instanceof Metric)) {
                return 0;
            }

            if(this == (((Metric)arg5))) {
                return 1;
            }

            if((Objects.equals(this.mValue, ((Metric)arg5).mValue)) && (Objects.equals(this.mLabel, ((Metric)arg5).mLabel)) && this.mSemanticStyle == ((Metric)arg5).mSemanticStyle) {
                return 1;
            }

            return 0;
        }

        private static Metric fromBundle(Bundle arg4) {
            Bundle v0 = arg4.getBundle("value");
            Metric v1 = null;
            if(v0 == null) {
                return v1;
            }

            MetricValue v0_1 = MetricValue.-$$Nest$smfromBundle(v0);
            if(v0_1 == null) {
                return v1;
            }

            return new Metric(v0_1, arg4.getString("label"), arg4.getInt("semanticStyle", 0));
        }

        public CharSequence getLabel() {
            return this.mLabel;
        }

        public int getSemanticStyle() {
            return this.mSemanticStyle;
        }

        public MetricValue getValue() {
            return this.mValue;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mValue, this.mLabel, Integer.valueOf(this.mSemanticStyle)});
        }

        private static Bundle toBundle(Metric arg3) {
            Bundle v0 = new Bundle();
            v0.putBundle("value", MetricValue.-$$Nest$smtoBundle(arg3.mValue));
            v0.putString("label", arg3.mLabel);
            v0.putInt("semanticStyle", arg3.mSemanticStyle);
            return v0;
        }

        public String toString() {
            return "Metric{mValue=" + this.mValue + ", mLabel=" + this.mLabel + ", mSemanticStyle=" + this.mSemanticStyle + "}";
        }
    }

    public final class MetricStyle extends androidx.core.app.NotificationCompat$Style {
        final class androidx.core.app.NotificationCompat$MetricStyle$Api37Impl {
            static Notification$Style -$$Nest$smtoPlatformStyle(MetricStyle arg0) {
                return androidx.core.app.NotificationCompat$MetricStyle$Api37Impl.toPlatformStyle(arg0);
            }

            private androidx.core.app.NotificationCompat$MetricStyle$Api37Impl() {
                super();
            }

            private static Notification$Metric toPlatformMetric(Metric arg3) {
                return new Notification$Metric(androidx.core.app.NotificationCompat$MetricStyle$Api37Impl.toPlatformMetricValue(arg3.getValue()), arg3.getLabel(), arg3.getSemanticStyle());
            }

            private static Notification$Metric$MetricValue toPlatformMetricValue(MetricValue arg4) {
                if((arg4 instanceof TimeDifference)) {
                    if(((TimeDifference)arg4).getZeroTime() != null) {
                        if(((TimeDifference)arg4).isTimer()) {
                            return Notification$Metric$TimeDifference.forTimer(((TimeDifference)arg4).getZeroTime(), ((TimeDifference)arg4).getFormat());
                        }

                        return Notification$Metric$TimeDifference.forStopwatch(((TimeDifference)arg4).getZeroTime(), ((TimeDifference)arg4).getFormat());
                    }

                    if(((TimeDifference)arg4).getZeroElapsedRealtime() != null) {
                        if(((TimeDifference)arg4).isTimer()) {
                            return Notification$Metric$TimeDifference.forTimer(((TimeDifference)arg4).getZeroElapsedRealtime().longValue(), ((TimeDifference)arg4).getFormat());
                        }

                        return Notification$Metric$TimeDifference.forStopwatch(((TimeDifference)arg4).getZeroElapsedRealtime().longValue(), ((TimeDifference)arg4).getFormat());
                    }

                    if(((TimeDifference)arg4).getPausedDuration() != null) {
                        if(((TimeDifference)arg4).isTimer()) {
                            return Notification$Metric$TimeDifference.forPausedTimer(((TimeDifference)arg4).getPausedDuration(), ((TimeDifference)arg4).getFormat());
                        }

                        return Notification$Metric$TimeDifference.forPausedStopwatch(((TimeDifference)arg4).getPausedDuration(), ((TimeDifference)arg4).getFormat());
                    }

                    throw new IllegalArgumentException("Unexpected TimeDifference: " + arg4);
                }

                if((arg4 instanceof FixedDate)) {
                    return new Notification$Metric$FixedDate(((FixedDate)arg4).getValue(), ((FixedDate)arg4).getFormat());
                }

                if((arg4 instanceof FixedFloat)) {
                    return new Notification$Metric$FixedFloat(((FixedFloat)arg4).getValue(), ((FixedFloat)arg4).getUnit(), ((FixedFloat)arg4).getMinFractionDigits(), ((FixedFloat)arg4).getMaxFractionDigits());
                }

                if((arg4 instanceof FixedInt)) {
                    return new Notification$Metric$FixedInt(((FixedInt)arg4).getValue(), ((FixedInt)arg4).getUnit());
                }

                if((arg4 instanceof FixedText)) {
                    return new Notification$Metric$FixedText(((FixedText)arg4).getValue(), ((FixedText)arg4).getUnit());
                }

                if((arg4 instanceof FixedTime)) {
                    return new Notification$Metric$FixedTime(((FixedTime)arg4).getValue());
                }

                throw new IllegalArgumentException("Unexpected MetricValue: " + arg4);
            }

            private static Notification$Style toPlatformStyle(MetricStyle arg3) {
                Notification$MetricStyle v0 = new Notification$MetricStyle();
                Iterator v1 = arg3.getMetrics().iterator();
                while(v1.hasNext()) {
                    v0.addMetric(androidx.core.app.NotificationCompat$MetricStyle$Api37Impl.toPlatformMetric(v1.next()));
                }

                v0.setCriticalMetric(arg3.getMetrics().indexOf(arg3.getCriticalMetric()));
                return ((Notification$Style)v0);
            }
        }

        private static final int CRITICAL_METRIC_DEFAULT = 0;
        private static final String EXTRA_METRICS = "android.metrics";
        private static final String EXTRA_METRICS_CRITICAL_INDEX = "android.metrics.criticalIndex";
        public static final int METRIC_INDEX_NONE = -1;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MetricStyle";
        private int mCriticalMetric;
        private final List mMetrics;

        public MetricStyle() {
            super();
            this.mMetrics = new ArrayList();
            this.mCriticalMetric = 0;
        }

        public void addCompatExtras(Bundle arg4) {
            super.addCompatExtras(arg4);
            if(Build$VERSION.SDK_INT >= 37) {
                return;
            }

            ArrayList v0 = new ArrayList();
            Iterator v1 = this.mMetrics.iterator();
            while(v1.hasNext()) {
                v0.add(Metric.-$$Nest$smtoBundle(v1.next()));
            }

            arg4.putParcelableArrayList("android.metrics", v0);
            arg4.putInt("android.metrics.criticalIndex", this.mCriticalMetric);
        }

        public MetricStyle addMetric(Metric arg2) {
            this.mMetrics.add(Objects.requireNonNull(arg2));
            return this;
        }

        public void apply(NotificationBuilderWithBuilderAccessor arg3) {
            this.validate();
            if(Build$VERSION.SDK_INT >= 37) {
                arg3.getBuilder().setStyle(androidx.core.app.NotificationCompat$MetricStyle$Api37Impl.-$$Nest$smtoPlatformStyle(this));
            }
        }

        protected void clearCompatExtraKeys(Bundle arg1) {
            super.clearCompatExtraKeys(arg1);
            arg1.remove("android.metrics");
            arg1.remove("android.metrics.criticalIndex");
        }

        public boolean equals(Object arg5) {
            if(!(arg5 instanceof MetricStyle)) {
                return 0;
            }

            if(this == (((MetricStyle)arg5))) {
                return 1;
            }

            if((Objects.equals(this.mMetrics, ((MetricStyle)arg5).mMetrics)) && this.mCriticalMetric == ((MetricStyle)arg5).mCriticalMetric) {
                return 1;
            }

            return 0;
        }

        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$MetricStyle";
        }

        public Metric getCriticalMetric() {
            int v0 = this.mCriticalMetric;
            if(v0 >= 0 && v0 < this.mMetrics.size()) {
                return this.mMetrics.get(this.mCriticalMetric);
            }

            return null;
        }

        public List getMetrics() {
            return Collections.unmodifiableList(this.mMetrics);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mMetrics, Integer.valueOf(this.mCriticalMetric)});
        }

        protected void restoreFromCompatExtras(Bundle arg3) {
            super.restoreFromCompatExtras(arg3);
            this.mMetrics.clear();
            ArrayList v0 = BundleCompat.getParcelableArrayList(arg3, "android.metrics", Bundle.class);
            if(v0 != null) {
                Iterator v0_1 = v0.iterator();
                while(v0_1.hasNext()) {
                    Object v1 = v0_1.next();
                    if(v1 == null) {
                        continue;
                    }

                    Metric v1_1 = Metric.-$$Nest$smfromBundle(((Bundle)v1));
                    if(v1_1 == null) {
                        continue;
                    }

                    this.addMetric(v1_1);
                }
            }

            this.mCriticalMetric = arg3.getInt("android.metrics.criticalIndex", 0);
        }

        public MetricStyle setCriticalMetric(int arg1) {
            this.mCriticalMetric = arg1;
            return this;
        }

        public MetricStyle setMetrics(List arg3) {
            this.mMetrics.clear();
            Iterator v3 = arg3.iterator();
            while(v3.hasNext()) {
                this.mMetrics.add(Objects.requireNonNull(v3.next()));
            }

            return this;
        }

        public String toString() {
            return "MetricStyle{mMetrics=" + this.mMetrics + ", mCriticalMetric=" + this.mCriticalMetric + "}";
        }

        private void validate() {
            if(!this.mMetrics.isEmpty()) {
                return;
            }

            throw new IllegalArgumentException("A MetricStyle must have at least one Metric");
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface NotificationVisibility {
    }

    public class ProgressStyle extends androidx.core.app.NotificationCompat$Style {
        final class androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl {
            private androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl() {
                super();
            }

            static void setProgress(Notification$ProgressStyle arg0, int arg1) {
                arg0.setProgress(arg1);
            }

            static void setProgressEndIcon(Notification$ProgressStyle arg0, Icon arg1) {
                arg0.setProgressEndIcon(arg1);
            }

            static void setProgressIndeterminate(Notification$ProgressStyle arg0, boolean arg1) {
                arg0.setProgressIndeterminate(arg1);
            }

            static void setProgressPoints(Notification$ProgressStyle arg1, List arg2) {
                Iterator v2 = arg2.iterator();
                while(v2.hasNext()) {
                    arg1.addProgressPoint(androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.toPlatformPoint(v2.next()));
                }
            }

            static void setProgressSegments(Notification$ProgressStyle arg1, List arg2) {
                Iterator v2 = arg2.iterator();
                while(v2.hasNext()) {
                    arg1.addProgressSegment(androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.toPlatformSegment(v2.next()));
                }
            }

            static void setProgressStartIcon(Notification$ProgressStyle arg0, Icon arg1) {
                arg0.setProgressStartIcon(arg1);
            }

            static void setProgressTrackerIcon(Notification$ProgressStyle arg0, Icon arg1) {
                arg0.setProgressTrackerIcon(arg1);
            }

            static void setStyledByProgress(Notification$ProgressStyle arg0, boolean arg1) {
                arg0.setStyledByProgress(arg1);
            }

            static Notification$ProgressStyle$Point toPlatformPoint(Point arg2) {
                return new Notification$ProgressStyle$Point(arg2.getPosition()).setColor(arg2.getColor()).setId(arg2.getId());
            }

            static Notification$ProgressStyle$Segment toPlatformSegment(Segment arg2) {
                return new Notification$ProgressStyle$Segment(arg2.getLength()).setColor(arg2.getColor()).setId(arg2.getId());
            }
        }

        final class androidx.core.app.NotificationCompat$ProgressStyle$Api37Impl {
            private androidx.core.app.NotificationCompat$ProgressStyle$Api37Impl() {
                super();
            }

            static void setProgressPoints(Notification$ProgressStyle arg1, List arg2) {
                Iterator v2 = arg2.iterator();
                while(v2.hasNext()) {
                    arg1.addProgressPoint(androidx.core.app.NotificationCompat$ProgressStyle$Api37Impl.toPlatformPoint(v2.next()));
                }
            }

            static void setProgressSegments(Notification$ProgressStyle arg1, List arg2) {
                Iterator v2 = arg2.iterator();
                while(v2.hasNext()) {
                    arg1.addProgressSegment(androidx.core.app.NotificationCompat$ProgressStyle$Api37Impl.toPlatformSegment(v2.next()));
                }
            }

            static Notification$ProgressStyle$Point toPlatformPoint(Point arg1) {
                return androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.toPlatformPoint(arg1).setSemanticStyle(arg1.getSemanticStyle());
            }

            static Notification$ProgressStyle$Segment toPlatformSegment(Segment arg1) {
                return androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.toPlatformSegment(arg1).setSemanticStyle(arg1.getSemanticStyle());
            }
        }

        public final class Point {
            private int mColor;
            private int mId;
            private int mPosition;
            private int mSemanticStyle;

            public Point(int arg2) {
                super();
                this.mId = 0;
                this.mColor = 0;
                this.mSemanticStyle = 0;
                this.mPosition = arg2;
            }

            public int getColor() {
                return this.mColor;
            }

            public int getId() {
                return this.mId;
            }

            public int getPosition() {
                return this.mPosition;
            }

            public int getSemanticStyle() {
                return this.mSemanticStyle;
            }

            public Point setColor(int arg1) {
                this.mColor = arg1;
                return this;
            }

            public Point setId(int arg1) {
                this.mId = arg1;
                return this;
            }

            public Point setSemanticStyle(int arg1) {
                this.mSemanticStyle = arg1;
                return this;
            }
        }

        public final class Segment {
            private int mColor;
            private int mId;
            private int mLength;
            private int mSemanticStyle;

            public Segment(int arg2) {
                super();
                this.mId = 0;
                this.mColor = 0;
                this.mSemanticStyle = 0;
                this.mLength = arg2;
            }

            public int getColor() {
                return this.mColor;
            }

            public int getId() {
                return this.mId;
            }

            public int getLength() {
                return this.mLength;
            }

            public int getSemanticStyle() {
                return this.mSemanticStyle;
            }

            public Segment setColor(int arg1) {
                this.mColor = arg1;
                return this;
            }

            public Segment setId(int arg1) {
                this.mId = arg1;
                return this;
            }

            public Segment setSemanticStyle(int arg1) {
                this.mSemanticStyle = arg1;
                return this;
            }
        }

        private static final int DEFAULT_PROGRESS_MAX = 100;
        private static final String KEY_ELEMENT_COLOR = "colorInt";
        private static final String KEY_ELEMENT_ID = "id";
        private static final String KEY_ELEMENT_SEMANTIC_STYLE = "semanticStyle";
        private static final String KEY_POINT_POSITION = "position";
        private static final String KEY_SEGMENT_LENGTH = "length";
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$ProgressStyle";
        private IconCompat mEndIcon;
        private boolean mIndeterminate;
        private boolean mIsStyledByProgress;
        private int mProgress;
        private List mProgressPoints;
        private List mProgressSegments;
        private IconCompat mStartIcon;
        private IconCompat mTrackerIcon;

        public ProgressStyle() {
            super();
            this.mProgressSegments = new ArrayList();
            this.mProgressPoints = new ArrayList();
            this.mProgress = 0;
            this.mIsStyledByProgress = true;
        }

        public void addCompatExtras(Bundle arg4) {
            super.addCompatExtras(arg4);
            int v1 = 36;
            if(Build$VERSION.SDK_INT <= v1) {
                arg4.putParcelableArrayList("android.progressSegments", ProgressStyle.getProgressSegmentsAsBundleList(this.mProgressSegments));
                arg4.putParcelableArrayList("android.progressPoints", ProgressStyle.getProgressPointsAsBundleList(this.mProgressPoints));
            }

            if(Build$VERSION.SDK_INT < v1) {
                arg4.putInt("android.progress", this.mProgress);
                arg4.putBoolean("android.progressIndeterminate", this.mIndeterminate);
                arg4.putInt("android.progressMax", this.getProgressMax());
                arg4.putBoolean("android.styledByProgress", this.mIsStyledByProgress);
                Context v0 = this.mBuilder != null ? this.mBuilder.mContext : null;
                if(v0 == null) {
                    return;
                }

                IconCompat v1_1 = this.mTrackerIcon;
                String v2 = "android.progressTrackerIcon";
                if(v1_1 != null) {
                    arg4.putParcelable(v2, v1_1.toIcon(v0));
                }
                else {
                    arg4.remove(v2);
                }

                v1_1 = this.mStartIcon;
                v2 = "android.progressStartIcon";
                if(v1_1 != null) {
                    arg4.putParcelable(v2, v1_1.toIcon(v0));
                }
                else {
                    arg4.remove(v2);
                }

                IconCompat v3 = this.mEndIcon;
                String v1_2 = "android.progressEndIcon";
                if(v3 != null) {
                    arg4.putParcelable(v1_2, v3.toIcon(v0));
                    return;
                }

                arg4.remove(v1_2);
            }
        }

        public ProgressStyle addProgressPoint(Point arg2) {
            if(this.mProgressPoints == null) {
                this.mProgressPoints = new ArrayList();
            }

            if(arg2.getPosition() > 0) {
                this.mProgressPoints.add(arg2);
            }

            return this;
        }

        public ProgressStyle addProgressSegment(Segment arg2) {
            if(this.mProgressSegments == null) {
                this.mProgressSegments = new ArrayList();
            }

            if(arg2.getLength() > 0) {
                this.mProgressSegments.add(arg2);
            }

            return this;
        }

        public void apply(NotificationBuilderWithBuilderAccessor arg5) {
            int v5_1;
            Notification$Builder v0 = arg5.getBuilder();
            if(Build$VERSION.SDK_INT >= 36) {
                Icon v2 = null;
                Context v5 = (arg5 instanceof NotificationCompatBuilder) ? ((NotificationCompatBuilder)arg5).getContext() : ((Context)v2);
                Notification$ProgressStyle v1 = new Notification$ProgressStyle();
                androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.setStyledByProgress(v1, this.mIsStyledByProgress);
                androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.setProgress(v1, this.mProgress);
                androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.setProgressIndeterminate(v1, this.mIndeterminate);
                IconCompat v3 = this.mStartIcon;
                Icon v3_1 = v3 != null ? v3.toIcon(v5) : v2;
                androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.setProgressStartIcon(v1, v3_1);
                v3 = this.mEndIcon;
                v3_1 = v3 != null ? v3.toIcon(v5) : v2;
                androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.setProgressEndIcon(v1, v3_1);
                v3 = this.mTrackerIcon;
                if(v3 != null) {
                    v2 = v3.toIcon(v5);
                }

                androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.setProgressTrackerIcon(v1, v2);
                v5_1 = Build$VERSION.SDK_INT;
                List v2_1 = this.mProgressPoints;
                if(v5_1 >= 37) {
                    androidx.core.app.NotificationCompat$ProgressStyle$Api37Impl.setProgressPoints(v1, v2_1);
                    androidx.core.app.NotificationCompat$ProgressStyle$Api37Impl.setProgressSegments(v1, this.mProgressSegments);
                }
                else {
                    androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.setProgressPoints(v1, v2_1);
                    androidx.core.app.NotificationCompat$ProgressStyle$Api36Impl.setProgressSegments(v1, this.mProgressSegments);
                }

                v0.setStyle(((Notification$Style)v1));
                return;
            }

            v5_1 = this.getProgressMax();
            v0.setProgress(v5_1, Math.min(this.mProgress, v5_1), this.mIndeterminate);
        }

        private static IconCompat asIconCompat(Parcelable arg1) {
            if(arg1 != null) {
                if((arg1 instanceof Icon)) {
                    return IconCompat.createFromIcon(((Icon)arg1));
                }
                else if((arg1 instanceof Bitmap)) {
                    return IconCompat.createWithBitmap(((Bitmap)arg1));
                }
            }

            return null;
        }

        protected void clearCompatExtraKeys(Bundle arg1) {
            super.clearCompatExtraKeys(arg1);
            arg1.remove("android.progressSegments");
            arg1.remove("android.progress");
            arg1.remove("android.styledByProgress");
            arg1.remove("android.progressTrackerIcon");
            arg1.remove("android.progressStartIcon");
            arg1.remove("android.progressEndIcon");
            arg1.remove("android.progressPoints");
            arg1.remove("android.progressIndeterminate");
        }

        public boolean displayCustomViewInline() {
            return 1;
        }

        protected String getClassName() {
            return "androidx.core.app.NotificationCompat$ProgressStyle";
        }

        public int getProgress() {
            return this.mProgress;
        }

        public IconCompat getProgressEndIcon() {
            return this.mEndIcon;
        }

        public int getProgressMax() {
            List v5 = this.mProgressSegments;
            int v0 = 100;
            if(v5 != null) {
                if(v5.isEmpty()) {
                }
                else {
                    int v1 = 0;
                    int v2 = 0;
                    int v3 = 0;
                    while(v1 < v5.size()) {
                        int v4 = v5.get(v1).getLength();
                        if(v4 > 0) {
                            try {
                                v3 = Math.addExact(v3, v4);
                                ++v2;
                            }
                            catch(ArithmeticException ) {
                                return v0;
                            }
                        }

                        ++v1;
                    }

                    if(v2 == 0) {
                        return v0;
                    }

                    return v3;
                }
            }

            return v0;
        }

        public List getProgressPoints() {
            return this.mProgressPoints;
        }

        private static ArrayList getProgressPointsAsBundleList(List arg6) {
            ArrayList v0 = new ArrayList();
            if(arg6 != null && !arg6.isEmpty()) {
                int v1;
                for(v1 = 0; v1 < arg6.size(); ++v1) {
                    Object v2 = arg6.get(v1);
                    if(((Point)v2).getPosition() < 0) {
                    }
                    else {
                        Bundle v3 = new Bundle();
                        v3.putInt("position", ((Point)v2).getPosition());
                        v3.putInt("id", ((Point)v2).getId());
                        v3.putInt("colorInt", ((Point)v2).getColor());
                        v3.putInt("semanticStyle", ((Point)v2).getSemanticStyle());
                        v0.add(v3);
                    }
                }
            }

            return v0;
        }

        private static List getProgressPointsFromBundleList(List arg8) {
            ArrayList v0 = new ArrayList();
            if(arg8 != null && !arg8.isEmpty()) {
                int v2;
                for(v2 = 0; v2 < arg8.size(); ++v2) {
                    Object v3 = arg8.get(v2);
                    int v4 = ((Bundle)v3).getInt("position");
                    if(v4 < 0) {
                    }
                    else {
                        v0.add(new Point(v4).setId(((Bundle)v3).getInt("id")).setColor(((Bundle)v3).getInt("colorInt", 0)).setSemanticStyle(((Bundle)v3).getInt("semanticStyle", 0)));
                    }
                }
            }

            return ((List)v0);
        }

        public List getProgressSegments() {
            return this.mProgressSegments;
        }

        private static ArrayList getProgressSegmentsAsBundleList(List arg6) {
            ArrayList v0 = new ArrayList();
            if(arg6 != null && !arg6.isEmpty()) {
                int v1;
                for(v1 = 0; v1 < arg6.size(); ++v1) {
                    Object v2 = arg6.get(v1);
                    if(((Segment)v2).getLength() <= 0) {
                    }
                    else {
                        Bundle v3 = new Bundle();
                        v3.putInt("length", ((Segment)v2).getLength());
                        v3.putInt("id", ((Segment)v2).getId());
                        v3.putInt("colorInt", ((Segment)v2).getColor());
                        v3.putInt("semanticStyle", ((Segment)v2).getSemanticStyle());
                        v0.add(v3);
                    }
                }
            }

            return v0;
        }

        private static List getProgressSegmentsFromBundleList(List arg8) {
            ArrayList v0 = new ArrayList();
            if(arg8 != null && !arg8.isEmpty()) {
                int v2;
                for(v2 = 0; v2 < arg8.size(); ++v2) {
                    Object v3 = arg8.get(v2);
                    int v4 = ((Bundle)v3).getInt("length");
                    if(v4 <= 0) {
                    }
                    else {
                        v0.add(new Segment(v4).setId(((Bundle)v3).getInt("id")).setColor(((Bundle)v3).getInt("colorInt", 0)).setSemanticStyle(((Bundle)v3).getInt("semanticStyle", 0)));
                    }
                }
            }

            return ((List)v0);
        }

        public IconCompat getProgressStartIcon() {
            return this.mStartIcon;
        }

        public IconCompat getProgressTrackerIcon() {
            return this.mTrackerIcon;
        }

        public boolean isProgressIndeterminate() {
            return this.mIndeterminate;
        }

        public boolean isStyledByProgress() {
            return this.mIsStyledByProgress;
        }

        protected void restoreFromCompatExtras(Bundle arg4) {
            super.restoreFromCompatExtras(arg4);
            Class v0 = Bundle.class;
            this.mProgressSegments = ProgressStyle.getProgressSegmentsFromBundleList(BundleCompat.getParcelableArrayList(arg4, "android.progressSegments", v0));
            this.mProgress = arg4.getInt("android.progress", 0);
            this.mIndeterminate = arg4.getBoolean("android.progressIndeterminate", false);
            this.mIsStyledByProgress = arg4.getBoolean("android.styledByProgress", true);
            this.mProgressPoints = ProgressStyle.getProgressPointsFromBundleList(BundleCompat.getParcelableArrayList(arg4, "android.progressPoints", v0));
            v0 = Icon.class;
            this.mTrackerIcon = ProgressStyle.asIconCompat(BundleCompat.getParcelable(arg4, "android.progressTrackerIcon", v0));
            this.mStartIcon = ProgressStyle.asIconCompat(BundleCompat.getParcelable(arg4, "android.progressStartIcon", v0));
            this.mEndIcon = ProgressStyle.asIconCompat(BundleCompat.getParcelable(arg4, "android.progressEndIcon", v0));
        }

        public ProgressStyle setProgress(int arg1) {
            this.mProgress = arg1;
            return this;
        }

        public ProgressStyle setProgressEndIcon(IconCompat arg1) {
            this.mEndIcon = arg1;
            return this;
        }

        public ProgressStyle setProgressIndeterminate(boolean arg1) {
            this.mIndeterminate = arg1;
            return this;
        }

        public ProgressStyle setProgressPoints(List arg2) {
            if(this.mProgressPoints == null) {
                this.mProgressPoints = new ArrayList();
            }

            this.mProgressPoints.clear();
            Iterator v2 = arg2.iterator();
            while(v2.hasNext()) {
                this.addProgressPoint(v2.next());
            }

            return this;
        }

        public ProgressStyle setProgressSegments(List arg2) {
            if(this.mProgressSegments == null) {
                this.mProgressSegments = new ArrayList();
            }

            this.mProgressSegments.clear();
            Iterator v2 = arg2.iterator();
            while(v2.hasNext()) {
                this.addProgressSegment(v2.next());
            }

            return this;
        }

        public ProgressStyle setProgressStartIcon(IconCompat arg1) {
            this.mStartIcon = arg1;
            return this;
        }

        public ProgressStyle setProgressTrackerIcon(IconCompat arg1) {
            this.mTrackerIcon = arg1;
            return this;
        }

        public ProgressStyle setStyledByProgress(boolean arg1) {
            this.mIsStyledByProgress = arg1;
            return this;
        }
    }

    public final class ProjectedExtender implements androidx.core.app.NotificationCompat$Extender {
        static final String EXTRA_PROJECTED_EXTENDER = "android.projected.EXTENSIONS";
        static final String KEY_CONTENT_INTENT = "content_intent";
        private PendingIntent mContentIntent;

        public ProjectedExtender() {
            super();
        }

        public ProjectedExtender(Notification arg3) {
            super();
            Bundle v3 = NotificationCompat.getExtras(arg3);
            v3 = v3 == null ? null : v3.getBundle("android.projected.EXTENSIONS");
            if(v3 != null) {
                this.mContentIntent = BundleCompat.getParcelable(v3, "content_intent", PendingIntent.class);
            }
        }

        public androidx.core.app.NotificationCompat$Builder extend(androidx.core.app.NotificationCompat$Builder arg3) {
            Bundle v0 = new Bundle();
            PendingIntent v2 = this.mContentIntent;
            if(v2 != null) {
                v0.putParcelable("content_intent", ((Parcelable)v2));
            }

            arg3.getExtras().putBundle("android.projected.EXTENSIONS", v0);
            return arg3;
        }

        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        public ProjectedExtender setContentIntent(PendingIntent arg1) {
            this.mContentIntent = arg1;
            return this;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface SemanticStyle {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface ServiceNotificationBehavior {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface StreamType {
    }

    public abstract class androidx.core.app.NotificationCompat$Style {
        class androidx.core.app.NotificationCompat$Style$Api24Impl {
            private androidx.core.app.NotificationCompat$Style$Api24Impl() {
                super();
            }

            static void setChronometerCountDown(RemoteViews arg0, int arg1, boolean arg2) {
                arg0.setChronometerCountDown(arg1, arg2);
            }
        }

        CharSequence mBigContentTitle;
        protected androidx.core.app.NotificationCompat$Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet;

        public androidx.core.app.NotificationCompat$Style() {
            super();
            this.mSummaryTextSet = false;
        }

        public void addCompatExtras(Bundle arg3) {
            if(this.mSummaryTextSet) {
                arg3.putCharSequence("android.summaryText", this.mSummaryText);
            }

            CharSequence v0 = this.mBigContentTitle;
            if(v0 != null) {
                arg3.putCharSequence("android.title.big", v0);
            }

            String v2 = this.getClassName();
            if(v2 != null) {
                arg3.putString("androidx.core.app.extra.COMPAT_TEMPLATE", v2);
            }
        }

        public void apply(NotificationBuilderWithBuilderAccessor arg1) {
        }

        public RemoteViews applyStandardTemplate(boolean arg12, int arg13, boolean arg14) {
            int v9;
            int v12;
            Resources v0 = this.mBuilder.mContext.getResources();
            RemoteViews v1 = new RemoteViews(this.mBuilder.mContext.getPackageName(), arg13);
            int v7 = 0;
            if(this.mBuilder.mLargeIcon != null) {
                v1.setViewVisibility(id.icon, 0);
                v1.setImageViewBitmap(id.icon, this.createColoredBitmap(this.mBuilder.mLargeIcon, 0));
                if((arg12) && this.mBuilder.mNotification.icon != 0) {
                    v12 = v0.getDimensionPixelSize(dimen.notification_right_icon_size);
                    v1.setImageViewBitmap(id.right_icon, this.createIconWithBackground(this.mBuilder.mNotification.icon, v12, v12 - v0.getDimensionPixelSize(dimen.notification_small_icon_background_padding) * 2, this.mBuilder.getColor()));
                    v1.setViewVisibility(id.right_icon, 0);
                }
            }
            else if((arg12) && this.mBuilder.mNotification.icon != 0) {
                v1.setViewVisibility(id.icon, 0);
                v1.setImageViewBitmap(id.icon, this.createIconWithBackground(this.mBuilder.mNotification.icon, v0.getDimensionPixelSize(dimen.notification_large_icon_width) - v0.getDimensionPixelSize(dimen.notification_big_circle_margin), v0.getDimensionPixelSize(dimen.notification_small_icon_size_as_large), this.mBuilder.getColor()));
            }

            if(this.mBuilder.mContentTitle != null) {
                v1.setTextViewText(id.title, this.mBuilder.mContentTitle);
            }

            arg13 = 1;
            if(this.mBuilder.mContentText != null) {
                v1.setTextViewText(id.text, this.mBuilder.mContentText);
                v12 = 1;
            }
            else {
                v12 = 0;
            }

            int v8 = 8;
            if(this.mBuilder.mContentInfo != null) {
                v1.setTextViewText(id.info, this.mBuilder.mContentInfo);
                v1.setViewVisibility(id.info, 0);
                goto label_91;
            }
            else if(this.mBuilder.mNumber > 0) {
                if(this.mBuilder.mNumber > v0.getInteger(integer.status_bar_notification_info_maxnum)) {
                    v1.setTextViewText(id.info, v0.getString(string.status_bar_notification_info_overflow));
                }
                else {
                    v1.setTextViewText(id.info, NumberFormat.getIntegerInstance().format(((long)this.mBuilder.mNumber)));
                }

                v1.setViewVisibility(id.info, 0);
            label_91:
                v12 = 1;
                v9 = 1;
            }
            else {
                v1.setViewVisibility(id.info, v8);
                v9 = 0;
            }

            if(this.mBuilder.mSubText != null) {
                v1.setTextViewText(id.text, this.mBuilder.mSubText);
                if(this.mBuilder.mContentText != null) {
                    v1.setTextViewText(id.text2, this.mBuilder.mContentText);
                    v1.setViewVisibility(id.text2, 0);
                    if(arg14) {
                        v1.setTextViewTextSize(id.text, 0, ((float)v0.getDimensionPixelSize(dimen.notification_subtext_size)));
                    }

                    v1.setViewPadding(id.line1, 0, 0, 0, 0);
                }
                else {
                    v1.setViewVisibility(id.text2, v8);
                }
            }

            if(this.mBuilder.getWhenIfShowing() == 0) {
                arg13 = v9;
            }
            else if(this.mBuilder.mUseChronometer) {
                v1.setViewVisibility(id.chronometer, 0);
                v1.setLong(id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                v1.setBoolean(id.chronometer, "setStarted", true);
                if(this.mBuilder.mChronometerCountDown) {
                    androidx.core.app.NotificationCompat$Style$Api24Impl.setChronometerCountDown(v1, id.chronometer, this.mBuilder.mChronometerCountDown);
                }
            }
            else {
                v1.setViewVisibility(id.time, 0);
                v1.setLong(id.time, "setTime", this.mBuilder.getWhenIfShowing());
            }

            int v11 = id.right_side;
            arg13 = arg13 != 0 ? 0 : v8;
            v1.setViewVisibility(v11, arg13);
            v11 = id.line3;
            if(v12 != 0) {
            }
            else {
                v7 = v8;
            }

            v1.setViewVisibility(v11, v7);
            return v1;
        }

        public Notification build() {
            androidx.core.app.NotificationCompat$Builder v0 = this.mBuilder;
            if(v0 != null) {
                return v0.build();
            }

            return null;
        }

        public void buildIntoRemoteViews(RemoteViews arg8, RemoteViews arg9) {
            this.hideNormalContent(arg8);
            arg8.removeAllViews(id.notification_main_column);
            arg8.addView(id.notification_main_column, arg9.clone());
            arg8.setViewVisibility(id.notification_main_column, 0);
            arg8.setViewPadding(id.notification_main_column_container, 0, this.calculateTopPadding(), 0, 0);
        }

        private int calculateTopPadding() {
            Resources v4 = this.mBuilder.mContext.getResources();
            int v0 = v4.getDimensionPixelSize(dimen.notification_top_pad);
            int v1 = v4.getDimensionPixelSize(dimen.notification_top_pad_large_text);
            float v4_1 = (androidx.core.app.NotificationCompat$Style.constrain(v4.getConfiguration().fontScale, 1f, 1.3f) - 1f) / 0.3f;
            return Math.round((1f - v4_1) * (((float)v0)) + v4_1 * (((float)v1)));
        }

        protected void clearCompatExtraKeys(Bundle arg1) {
            arg1.remove("android.summaryText");
            arg1.remove("android.title.big");
            arg1.remove("androidx.core.app.extra.COMPAT_TEMPLATE");
        }

        private static float constrain(float arg1, float arg2, float arg3) {
            if(arg1 < arg2) {
                return arg2;
            }

            if(arg1 > arg3) {
                return arg3;
            }

            return arg1;
        }

        static androidx.core.app.NotificationCompat$Style constructCompatStyleByName(String arg2) {
            if(arg2 != null) {
                arg2.hashCode();
                int v1 = -1;
                switch(arg2.hashCode()) {
                    case 2090799565: {
                        if(!arg2.equals("androidx.core.app.NotificationCompat$MessagingStyle")) {
                        }
                        else {
                            v1 = 7;
                        }

                        break;
                    }
                    case -1915466044: {
                        if(!arg2.equals("androidx.core.app.NotificationCompat$ProgressStyle")) {
                        }
                        else {
                            v1 = 0;
                        }

                        break;
                    }
                    case -716705180: {
                        if(!arg2.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) {
                        }
                        else {
                            v1 = 1;
                        }

                        break;
                    }
                    case -171946061: {
                        if(!arg2.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) {
                        }
                        else {
                            v1 = 2;
                        }

                        break;
                    }
                    case -128932575: {
                        if(!arg2.equals("androidx.core.app.NotificationCompat$MetricStyle")) {
                        }
                        else {
                            v1 = 3;
                        }

                        break;
                    }
                    case 714386739: {
                        if(!arg2.equals("androidx.core.app.NotificationCompat$CallStyle")) {
                        }
                        else {
                            v1 = 4;
                        }

                        break;
                    }
                    case 912942987: {
                        if(!arg2.equals("androidx.core.app.NotificationCompat$InboxStyle")) {
                        }
                        else {
                            v1 = 5;
                        }

                        break;
                    }
                    case 919595044: {
                        if(!arg2.equals("androidx.core.app.NotificationCompat$BigTextStyle")) {
                        }
                        else {
                            v1 = 6;
                        }

                        break;
                    }
                    default: {
                        break;
                    }
                }

                switch(v1) {
                    case 0: {
                        goto label_76;
                    }
                    case 1: {
                        goto label_73;
                    }
                    case 2: {
                        goto label_70;
                    }
                    case 3: {
                        goto label_67;
                    }
                    case 4: {
                        goto label_64;
                    }
                    case 5: {
                        goto label_61;
                    }
                    case 6: {
                        goto label_58;
                    }
                    case 7: {
                        goto label_55;
                    }
                }

                return null;
            label_67:
                return new MetricStyle();
            label_70:
                return new BigPictureStyle();
            label_55:
                return new MessagingStyle();
            label_73:
                return new DecoratedCustomViewStyle();
            label_58:
                return new BigTextStyle();
            label_76:
                return new ProgressStyle();
            label_61:
                return new InboxStyle();
            label_64:
                return new CallStyle();
            }

            return null;
        }

        private static androidx.core.app.NotificationCompat$Style constructCompatStyleByPlatformName(String arg3) {
            androidx.core.app.NotificationCompat$Style v0 = null;
            if(arg3 == null) {
                return v0;
            }

            if(arg3.equals(Notification$BigPictureStyle.class.getName())) {
                return new BigPictureStyle();
            }

            if(arg3.equals(Notification$BigTextStyle.class.getName())) {
                return new BigTextStyle();
            }

            if(arg3.equals(Notification$InboxStyle.class.getName())) {
                return new InboxStyle();
            }

            if(Build$VERSION.SDK_INT >= 36 && (arg3.equals(Notification$ProgressStyle.class.getName()))) {
                return new ProgressStyle();
            }

            if(arg3.equals(Notification$MessagingStyle.class.getName())) {
                return new MessagingStyle();
            }

            if(arg3.equals(Notification$DecoratedCustomViewStyle.class.getName())) {
                return new DecoratedCustomViewStyle();
            }

            if(Build$VERSION.SDK_INT >= 37 && (arg3.equals(Notification$MetricStyle.class.getName()))) {
                return new MetricStyle();
            }

            return v0;
        }

        static androidx.core.app.NotificationCompat$Style constructCompatStyleForBundle(Bundle arg1) {
            androidx.core.app.NotificationCompat$Style v0 = androidx.core.app.NotificationCompat$Style.constructCompatStyleByName(arg1.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            if(v0 != null) {
                return v0;
            }

            if(!arg1.containsKey("android.selfDisplayName")) {
                if(arg1.containsKey("android.messagingStyleUser")) {
                }
                else {
                    if(!arg1.containsKey("android.picture")) {
                        if(arg1.containsKey("android.pictureIcon")) {
                        }
                        else if(arg1.containsKey("android.bigText")) {
                            return new BigTextStyle();
                        }
                        else if(arg1.containsKey("android.textLines")) {
                            return new InboxStyle();
                        }
                        else if(arg1.containsKey("android.callType")) {
                            return new CallStyle();
                        }
                        else {
                            if(!arg1.containsKey("android.progressSegments")) {
                                if(arg1.containsKey("android.progressPoints")) {
                                }
                                else if(arg1.containsKey("android.metrics")) {
                                    return new MetricStyle();
                                }
                                else {
                                    return androidx.core.app.NotificationCompat$Style.constructCompatStyleByPlatformName(arg1.getString("android.template"));
                                }
                            }

                            return new ProgressStyle();
                        }
                    }

                    return new BigPictureStyle();
                }
            }

            return new MessagingStyle();
        }

        static androidx.core.app.NotificationCompat$Style constructStyleForExtras(Bundle arg2) {
            androidx.core.app.NotificationCompat$Style v0 = androidx.core.app.NotificationCompat$Style.constructCompatStyleForBundle(arg2);
            androidx.core.app.NotificationCompat$Style v1 = null;
            if(v0 == null) {
                return v1;
            }

            try {
                v0.restoreFromCompatExtras(arg2);
                return v0;
            }
            catch(ClassCastException ) {
                return v1;
            }
        }

        private Bitmap createColoredBitmap(int arg2, int arg3, int arg4) {
            return this.createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, arg2), arg3, arg4);
        }

        private Bitmap createColoredBitmap(IconCompat arg3, int arg4, int arg5) {
            Drawable v2 = arg3.loadDrawable(this.mBuilder.mContext);
            int v3 = arg5 == 0 ? v2.getIntrinsicWidth() : arg5;
            if(arg5 == 0) {
                arg5 = v2.getIntrinsicHeight();
            }

            Bitmap v0 = Bitmap.createBitmap(v3, arg5, Bitmap$Config.ARGB_8888);
            v2.setBounds(0, 0, v3, arg5);
            if(arg4 != 0) {
                v2.mutate().setColorFilter(new PorterDuffColorFilter(arg4, PorterDuff$Mode.SRC_IN));
            }

            v2.draw(new Canvas(v0));
            return v0;
        }

        Bitmap createColoredBitmap(IconCompat arg2, int arg3) {
            return this.createColoredBitmap(arg2, arg3, 0);
        }

        public Bitmap createColoredBitmap(int arg2, int arg3) {
            return this.createColoredBitmap(arg2, arg3, 0);
        }

        private Bitmap createIconWithBackground(int arg2, int arg3, int arg4, int arg5) {
            Bitmap v5 = this.createColoredBitmap(drawable.notification_icon_background, 0, arg3);
            Canvas v0 = new Canvas(v5);
            Drawable v1 = this.mBuilder.mContext.getResources().getDrawable(arg2).mutate();
            v1.setFilterBitmap(true);
            arg3 = (arg3 - arg4) / 2;
            arg4 += arg3;
            v1.setBounds(arg3, arg3, arg4, arg4);
            v1.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff$Mode.SRC_ATOP));
            v1.draw(v0);
            return v5;
        }

        public boolean displayCustomViewInline() {
            return 0;
        }

        public static androidx.core.app.NotificationCompat$Style extractStyleFromNotification(Notification arg0) {
            Bundle v0 = NotificationCompat.getExtras(arg0);
            if(v0 == null) {
                return null;
            }

            return androidx.core.app.NotificationCompat$Style.constructStyleForExtras(v0);
        }

        protected String getClassName() {
            return null;
        }

        private void hideNormalContent(RemoteViews arg2) {
            arg2.setViewVisibility(id.title, 8);
            arg2.setViewVisibility(id.text2, 8);
            arg2.setViewVisibility(id.text, 8);
        }

        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor arg1) {
            return null;
        }

        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor arg1) {
            return null;
        }

        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor arg1) {
            return null;
        }

        protected void restoreFromCompatExtras(Bundle arg3) {
            String v0 = "android.summaryText";
            if(arg3.containsKey(v0)) {
                this.mSummaryText = arg3.getCharSequence(v0);
                this.mSummaryTextSet = true;
            }

            this.mBigContentTitle = arg3.getCharSequence("android.title.big");
        }

        public void setBuilder(androidx.core.app.NotificationCompat$Builder arg2) {
            if(this.mBuilder != arg2) {
                this.mBuilder = arg2;
                if(arg2 != null) {
                    arg2.setStyle(this);
                }
            }
        }
    }

    public final class TvExtender implements androidx.core.app.NotificationCompat$Extender {
        static final String EXTRA_CHANNEL_ID = "channel_id";
        static final String EXTRA_CONTENT_INTENT = "content_intent";
        static final String EXTRA_DELETE_INTENT = "delete_intent";
        private static final String EXTRA_FLAGS = "flags";
        static final String EXTRA_SUPPRESS_SHOW_OVER_APPS = "suppressShowOverApps";
        static final String EXTRA_TV_EXTENDER = "android.tv.EXTENSIONS";
        private static final int FLAG_AVAILABLE_ON_TV = 1;
        private static final String TAG = "TvExtender";
        private String mChannelId;
        private PendingIntent mContentIntent;
        private PendingIntent mDeleteIntent;
        private int mFlags;
        private boolean mSuppressShowOverApps;

        public TvExtender() {
            super();
            this.mFlags = 1;
        }

        public TvExtender(Notification arg2) {
            super();
            Bundle v2 = arg2.extras == null ? null : arg2.extras.getBundle("android.tv.EXTENSIONS");
            if(v2 != null) {
                this.mFlags = v2.getInt("flags");
                this.mChannelId = v2.getString("channel_id");
                this.mSuppressShowOverApps = v2.getBoolean("suppressShowOverApps");
                this.mContentIntent = v2.getParcelable("content_intent");
                this.mDeleteIntent = v2.getParcelable("delete_intent");
            }
        }

        public androidx.core.app.NotificationCompat$Builder extend(androidx.core.app.NotificationCompat$Builder arg4) {
            Bundle v0 = new Bundle();
            v0.putInt("flags", this.mFlags);
            v0.putString("channel_id", this.mChannelId);
            v0.putBoolean("suppressShowOverApps", this.mSuppressShowOverApps);
            PendingIntent v1 = this.mContentIntent;
            if(v1 != null) {
                v0.putParcelable("content_intent", ((Parcelable)v1));
            }

            PendingIntent v3 = this.mDeleteIntent;
            if(v3 != null) {
                v0.putParcelable("delete_intent", ((Parcelable)v3));
            }

            arg4.getExtras().putBundle("android.tv.EXTENSIONS", v0);
            return arg4;
        }

        public String getChannelId() {
            return this.mChannelId;
        }

        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public boolean isAvailableOnTv() {
            if((this.mFlags & 1) != 0) {
                return 1;
            }

            return 0;
        }

        public boolean isSuppressShowOverApps() {
            return this.mSuppressShowOverApps;
        }

        public TvExtender setChannelId(String arg1) {
            this.mChannelId = arg1;
            return this;
        }

        public TvExtender setContentIntent(PendingIntent arg1) {
            this.mContentIntent = arg1;
            return this;
        }

        public TvExtender setDeleteIntent(PendingIntent arg1) {
            this.mDeleteIntent = arg1;
            return this;
        }

        public TvExtender setSuppressShowOverApps(boolean arg1) {
            this.mSuppressShowOverApps = arg1;
            return this;
        }
    }

    public final class androidx.core.app.NotificationCompat$WearableExtender implements androidx.core.app.NotificationCompat$Extender {
        class androidx.core.app.NotificationCompat$WearableExtender$Api24Impl {
            private androidx.core.app.NotificationCompat$WearableExtender$Api24Impl() {
                super();
            }

            static Notification$Action$Builder setAllowGeneratedReplies(Notification$Action$Builder arg0, boolean arg1) {
                return arg0.setAllowGeneratedReplies(arg1);
            }
        }

        class androidx.core.app.NotificationCompat$WearableExtender$Api31Impl {
            private androidx.core.app.NotificationCompat$WearableExtender$Api31Impl() {
                super();
            }

            static Notification$Action$Builder setAuthenticationRequired(Notification$Action$Builder arg0, boolean arg1) {
                return arg0.setAuthenticationRequired(arg1);
            }
        }

        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 0x800005;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 0x20;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 0x40;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        @Deprecated public static final int SCREEN_TIMEOUT_LONG = -1;
        @Deprecated public static final int SCREEN_TIMEOUT_SHORT = 0;
        @Deprecated public static final int SIZE_DEFAULT = 0;
        @Deprecated public static final int SIZE_FULL_SCREEN = 5;
        @Deprecated public static final int SIZE_LARGE = 4;
        @Deprecated public static final int SIZE_MEDIUM = 3;
        @Deprecated public static final int SIZE_SMALL = 2;
        @Deprecated public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList mActions;
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags;
        private int mGravity;
        private int mHintScreenTimeout;
        private ArrayList mPages;

        public androidx.core.app.NotificationCompat$WearableExtender() {
            super();
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            this.mContentIconGravity = 0x800005;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        public androidx.core.app.NotificationCompat$WearableExtender(Notification arg11) {
            super();
            this.mActions = new ArrayList();
            this.mFlags = 1;
            this.mPages = new ArrayList();
            int v1 = 0x800005;
            this.mContentIconGravity = v1;
            int v2 = -1;
            this.mContentActionIndex = v2;
            this.mCustomSizePreset = 0;
            int v4 = 80;
            this.mGravity = v4;
            Bundle v11 = NotificationCompat.getExtras(arg11);
            v11 = v11 != null ? v11.getBundle("android.wearable.EXTENSIONS") : null;
            if(v11 != null) {
                ArrayList v5 = v11.getParcelableArrayList("actions");
                if(v5 != null) {
                    int v6 = v5.size();
                    Action[] v7 = new Action[v6];
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        v7[v8] = NotificationCompat.getActionCompatFromAction(v5.get(v8));
                    }

                    Collections.addAll(this.mActions, ((Object[])v7));
                }

                this.mFlags = v11.getInt("flags", 1);
                this.mDisplayIntent = v11.getParcelable("displayIntent");
                Notification[] v0 = NotificationCompat.getNotificationArrayFromBundle(v11, "pages");
                if(v0 != null) {
                    Collections.addAll(this.mPages, ((Object[])v0));
                }

                this.mBackground = v11.getParcelable("background");
                this.mContentIcon = v11.getInt("contentIcon");
                this.mContentIconGravity = v11.getInt("contentIconGravity", v1);
                this.mContentActionIndex = v11.getInt("contentActionIndex", v2);
                this.mCustomSizePreset = v11.getInt("customSizePreset", 0);
                this.mCustomContentHeight = v11.getInt("customContentHeight");
                this.mGravity = v11.getInt("gravity", v4);
                this.mHintScreenTimeout = v11.getInt("hintScreenTimeout");
                this.mDismissalId = v11.getString("dismissalId");
                this.mBridgeTag = v11.getString("bridgeTag");
            }
        }

        public androidx.core.app.NotificationCompat$WearableExtender addAction(Action arg2) {
            this.mActions.add(arg2);
            return this;
        }

        public androidx.core.app.NotificationCompat$WearableExtender addActions(List arg2) {
            this.mActions.addAll(((Collection)arg2));
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender addPage(Notification arg2) {
            this.mPages.add(arg2);
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender addPages(List arg2) {
            this.mPages.addAll(((Collection)arg2));
            return this;
        }

        public androidx.core.app.NotificationCompat$WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public androidx.core.app.NotificationCompat$WearableExtender clone() {
            androidx.core.app.NotificationCompat$WearableExtender v0 = new androidx.core.app.NotificationCompat$WearableExtender();
            v0.mActions = new ArrayList(this.mActions);
            v0.mFlags = this.mFlags;
            v0.mDisplayIntent = this.mDisplayIntent;
            v0.mPages = new ArrayList(this.mPages);
            v0.mBackground = this.mBackground;
            v0.mContentIcon = this.mContentIcon;
            v0.mContentIconGravity = this.mContentIconGravity;
            v0.mContentActionIndex = this.mContentActionIndex;
            v0.mCustomSizePreset = this.mCustomSizePreset;
            v0.mCustomContentHeight = this.mCustomContentHeight;
            v0.mGravity = this.mGravity;
            v0.mHintScreenTimeout = this.mHintScreenTimeout;
            v0.mDismissalId = this.mDismissalId;
            v0.mBridgeTag = this.mBridgeTag;
            return v0;
        }

        public Object clone() throws CloneNotSupportedException {
            return this.clone();
        }

        public androidx.core.app.NotificationCompat$Builder extend(androidx.core.app.NotificationCompat$Builder arg5) {
            Bundle v0 = new Bundle();
            if(!this.mActions.isEmpty()) {
                ArrayList v1 = new ArrayList(this.mActions.size());
                Iterator v2 = this.mActions.iterator();
                while(v2.hasNext()) {
                    v1.add(androidx.core.app.NotificationCompat$WearableExtender.getActionFromActionCompat(v2.next()));
                }

                v0.putParcelableArrayList("actions", v1);
            }

            int v1_1 = this.mFlags;
            if(v1_1 != 1) {
                v0.putInt("flags", v1_1);
            }

            PendingIntent v1_2 = this.mDisplayIntent;
            if(v1_2 != null) {
                v0.putParcelable("displayIntent", ((Parcelable)v1_2));
            }

            if(!this.mPages.isEmpty()) {
                v0.putParcelableArray("pages", this.mPages.toArray(new Notification[this.mPages.size()]));
            }

            Bitmap v1_3 = this.mBackground;
            if(v1_3 != null) {
                v0.putParcelable("background", ((Parcelable)v1_3));
            }

            v1_1 = this.mContentIcon;
            if(v1_1 != 0) {
                v0.putInt("contentIcon", v1_1);
            }

            v1_1 = this.mContentIconGravity;
            if(v1_1 != 0x800005) {
                v0.putInt("contentIconGravity", v1_1);
            }

            v1_1 = this.mContentActionIndex;
            if(v1_1 != -1) {
                v0.putInt("contentActionIndex", v1_1);
            }

            v1_1 = this.mCustomSizePreset;
            if(v1_1 != 0) {
                v0.putInt("customSizePreset", v1_1);
            }

            v1_1 = this.mCustomContentHeight;
            if(v1_1 != 0) {
                v0.putInt("customContentHeight", v1_1);
            }

            v1_1 = this.mGravity;
            if(v1_1 != 80) {
                v0.putInt("gravity", v1_1);
            }

            v1_1 = this.mHintScreenTimeout;
            if(v1_1 != 0) {
                v0.putInt("hintScreenTimeout", v1_1);
            }

            String v1_4 = this.mDismissalId;
            if(v1_4 != null) {
                v0.putString("dismissalId", v1_4);
            }

            String v4 = this.mBridgeTag;
            if(v4 != null) {
                v0.putString("bridgeTag", v4);
            }

            arg5.getExtras().putBundle("android.wearable.EXTENSIONS", v0);
            return arg5;
        }

        private static Notification$Action getActionFromActionCompat(Action arg4) {
            IconCompat v0 = arg4.getIconCompat();
            Icon v0_1 = v0 == null ? null : v0.toIcon();
            Notification$Action$Builder v1 = new Notification$Action$Builder(v0_1, arg4.getTitle(), arg4.getActionIntent());
            Bundle v0_2 = arg4.getExtras() != null ? new Bundle(arg4.getExtras()) : new Bundle();
            v0_2.putBoolean("android.support.allowGeneratedReplies", arg4.getAllowGeneratedReplies());
            androidx.core.app.NotificationCompat$WearableExtender$Api24Impl.setAllowGeneratedReplies(v1, arg4.getAllowGeneratedReplies());
            if(Build$VERSION.SDK_INT >= 0x1F) {
                androidx.core.app.NotificationCompat$WearableExtender$Api31Impl.setAuthenticationRequired(v1, arg4.isAuthenticationRequired());
            }

            v1.addExtras(v0_2);
            RemoteInput[] v4 = arg4.getRemoteInputs();
            if(v4 != null) {
                android.app.RemoteInput[] v4_1 = RemoteInput.fromCompat(v4);
                int v0_3 = v4_1.length;
                int v2;
                for(v2 = 0; v2 < v0_3; ++v2) {
                    v1.addRemoteInput(v4_1[v2]);
                }
            }

            return v1.build();
        }

        public List getActions() {
            return this.mActions;
        }

        @Deprecated public Bitmap getBackground() {
            return this.mBackground;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        @Deprecated public int getContentIcon() {
            return this.mContentIcon;
        }

        @Deprecated public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            if((this.mFlags & 1) != 0) {
                return 1;
            }

            return 0;
        }

        @Deprecated public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        @Deprecated public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        @Deprecated public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        @Deprecated public int getGravity() {
            return this.mGravity;
        }

        @Deprecated public boolean getHintAmbientBigPicture() {
            if((this.mFlags & 0x20) != 0) {
                return 1;
            }

            return 0;
        }

        @Deprecated public boolean getHintAvoidBackgroundClipping() {
            if((this.mFlags & 16) != 0) {
                return 1;
            }

            return 0;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            if((this.mFlags & 0x40) != 0) {
                return 1;
            }

            return 0;
        }

        @Deprecated public boolean getHintHideIcon() {
            if((this.mFlags & 2) != 0) {
                return 1;
            }

            return 0;
        }

        @Deprecated public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        @Deprecated public boolean getHintShowBackgroundOnly() {
            if((this.mFlags & 4) != 0) {
                return 1;
            }

            return 0;
        }

        @Deprecated public List getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            if((this.mFlags & 8) != 0) {
                return 1;
            }

            return 0;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setBackground(Bitmap arg1) {
            this.mBackground = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$WearableExtender setBridgeTag(String arg1) {
            this.mBridgeTag = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$WearableExtender setContentAction(int arg1) {
            this.mContentActionIndex = arg1;
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setContentIcon(int arg1) {
            this.mContentIcon = arg1;
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setContentIconGravity(int arg1) {
            this.mContentIconGravity = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$WearableExtender setContentIntentAvailableOffline(boolean arg2) {
            this.setFlag(1, arg2);
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setCustomContentHeight(int arg1) {
            this.mCustomContentHeight = arg1;
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setCustomSizePreset(int arg1) {
            this.mCustomSizePreset = arg1;
            return this;
        }

        public androidx.core.app.NotificationCompat$WearableExtender setDismissalId(String arg1) {
            this.mDismissalId = arg1;
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setDisplayIntent(PendingIntent arg1) {
            this.mDisplayIntent = arg1;
            return this;
        }

        private void setFlag(int arg2, boolean arg3) {
            int v0 = this.mFlags;
            if(arg3) {
                this.mFlags = arg2 | v0;
                return;
            }

            this.mFlags = ~arg2 & v0;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setGravity(int arg1) {
            this.mGravity = arg1;
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setHintAmbientBigPicture(boolean arg2) {
            this.setFlag(0x20, arg2);
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setHintAvoidBackgroundClipping(boolean arg2) {
            this.setFlag(16, arg2);
            return this;
        }

        public androidx.core.app.NotificationCompat$WearableExtender setHintContentIntentLaunchesActivity(boolean arg2) {
            this.setFlag(0x40, arg2);
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setHintHideIcon(boolean arg2) {
            this.setFlag(2, arg2);
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setHintScreenTimeout(int arg1) {
            this.mHintScreenTimeout = arg1;
            return this;
        }

        @Deprecated public androidx.core.app.NotificationCompat$WearableExtender setHintShowBackgroundOnly(boolean arg2) {
            this.setFlag(4, arg2);
            return this;
        }

        public androidx.core.app.NotificationCompat$WearableExtender setStartScrollBottom(boolean arg2) {
            this.setFlag(8, arg2);
            return this;
        }
    }

    private static final String ANNOTATION_SEMANTIC_STYLE_KEY = "android.app.notification.semanticStyle";
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_VOICEMAIL = "voicemail";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";
    public static final String EXTRA_CALL_PERSON = "android.callPerson";
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";
    public static final String EXTRA_CALL_TYPE = "android.callType";
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COLORIZED = "android.colorized";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    private static final String EXTRA_MESSAGING_PERSON = "android.messagingUser";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    @Deprecated public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";
    public static final String EXTRA_PREFER_SMALL_ICON = "android.app.preferSmallIcon";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_END_ICON = "android.progressEndIcon";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_PROGRESS_POINTS = "android.progressPoints";
    public static final String EXTRA_PROGRESS_SEGMENTS = "android.progressSegments";
    public static final String EXTRA_PROGRESS_START_ICON = "android.progressStartIcon";
    public static final String EXTRA_PROGRESS_TRACKER_ICON = "android.progressTrackerIcon";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_REQUEST_PROMOTED_ONGOING = "android.requestPromotedOngoing";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHORT_CRITICAL_TEXT = "android.shortCriticalText";
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_STYLED_BY_PROGRESS = "android.styledByProgress";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 0x1000;
    public static final int FLAG_FOREGROUND_SERVICE = 0x40;
    public static final int FLAG_GROUP_SUMMARY = 0x200;
    @Deprecated public static final int FLAG_HIGH_PRIORITY = 0x80;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 0x100;
    public static final int FLAG_NO_CLEAR = 0x20;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int SEMANTIC_STYLE_CAUTION = 3;
    public static final int SEMANTIC_STYLE_DANGER = 4;
    public static final int SEMANTIC_STYLE_INFO = 1;
    public static final int SEMANTIC_STYLE_SAFE = 2;
    public static final int SEMANTIC_STYLE_UNSPECIFIED = 0;
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "NotifCompat";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    @Deprecated public NotificationCompat() {
        super();
    }

    public static ParcelableSpan createSemanticStyleAnnotation(int arg2) {
        return new Annotation("android.app.notification.semanticStyle", String.valueOf(arg2));
    }

    public static Action getAction(Notification arg0, int arg1) {
        return NotificationCompat.getActionCompatFromAction(arg0.actions[arg1]);
    }

    static Action getActionCompatFromAction(Notification$Action arg21) {
        int v19;
        int v18;
        RemoteInput[] v12;
        Notification$Action v0 = arg21;
        android.app.RemoteInput[] v1 = v0.getRemoteInputs();
        int v2 = 29;
        IconCompat v3 = null;
        boolean v4 = false;
        if(v1 == null) {
            v12 = ((RemoteInput[])v3);
        }
        else {
            RemoteInput[] v5 = new RemoteInput[v1.length];
            int v6;
            for(v6 = 0; v6 < v1.length; ++v6) {
                android.app.RemoteInput v7 = v1[v6];
                String v9 = v7.getResultKey();
                CharSequence v10 = v7.getLabel();
                CharSequence[] v11 = v7.getChoices();
                boolean v12_1 = v7.getAllowFreeFormInput();
                int v13 = Build$VERSION.SDK_INT >= v2 ? androidx.core.app.NotificationCompat$Api29Impl.getEditChoicesBeforeSending(v7) : 0;
                v5[v6] = new RemoteInput(v9, v10, v11, v12_1, v13, v7.getExtras(), null);
            }

            v12 = v5;
        }

        boolean v14 = (v0.getExtras().getBoolean("android.support.allowGeneratedReplies")) || (androidx.core.app.NotificationCompat$Api24Impl.getAllowGeneratedReplies(v0)) ? true : false;
        boolean v16 = v0.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        int v1_1 = Build$VERSION.SDK_INT >= 28 ? androidx.core.app.NotificationCompat$Api28Impl.getSemanticAction(v0) : v0.getExtras().getInt("android.support.action.semanticAction", 0);
        int v15 = v1_1;
        boolean v17 = Build$VERSION.SDK_INT >= v2 ? androidx.core.app.NotificationCompat$Api29Impl.isContextual(v0) : false;
        if(Build$VERSION.SDK_INT >= 37) {
            v18 = Api37Impl.getEmphasisHint(v0);
            v19 = Api37Impl.getStyleHint(v0);
        }
        else {
            v18 = 0;
            v19 = 0;
        }

        if(Build$VERSION.SDK_INT >= 0x1F) {
            v4 = Api31Impl.isAuthenticationRequired(v0);
        }

        boolean v20 = v4;
        if(v0.getIcon() == null && v0.icon != 0) {
            return new Action(v0.icon, v0.title, v0.actionIntent, v0.getExtras(), v12, null, v14, v15, v16, v17, v18, v19, v20);
        }

        if(v0.getIcon() == null) {
        }
        else {
            v3 = IconCompat.createFromIconOrNullIfZeroResId(v0.getIcon());
        }

        return new Action(v3, v0.title, v0.actionIntent, v0.getExtras(), v12, null, v14, v15, v16, v17, v18, v19, v20);
    }

    public static int getActionCount(Notification arg1) {
        if(arg1.actions != null) {
            return arg1.actions.length;
        }

        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification arg2) {
        if(Build$VERSION.SDK_INT >= 29) {
            return androidx.core.app.NotificationCompat$Api29Impl.getAllowSystemGeneratedContextualActions(arg2);
        }

        return 0;
    }

    public static boolean getAutoCancel(Notification arg0) {
        if((arg0.flags & 16) != 0) {
            return 1;
        }

        return 0;
    }

    public static int getBadgeIconType(Notification arg0) {
        return Api26Impl.getBadgeIconType(arg0);
    }

    public static BubbleMetadata getBubbleMetadata(Notification arg2) {
        if(Build$VERSION.SDK_INT >= 29) {
            return BubbleMetadata.fromPlatform(androidx.core.app.NotificationCompat$Api29Impl.getBubbleMetadata(arg2));
        }

        return null;
    }

    public static String getCategory(Notification arg0) {
        return arg0.category;
    }

    public static String getChannelId(Notification arg0) {
        return Api26Impl.getChannelId(arg0);
    }

    public static int getColor(Notification arg0) {
        return arg0.color;
    }

    public static CharSequence getContentInfo(Notification arg1) {
        return arg1.extras.getCharSequence("android.infoText");
    }

    public static CharSequence getContentText(Notification arg1) {
        return arg1.extras.getCharSequence("android.text");
    }

    public static CharSequence getContentTitle(Notification arg1) {
        return arg1.extras.getCharSequence("android.title");
    }

    @ReplaceWith(expression="notification.extras") @Deprecated public static Bundle getExtras(Notification arg0) {
        return arg0.extras;
    }

    public static String getGroup(Notification arg0) {
        return arg0.getGroup();
    }

    public static int getGroupAlertBehavior(Notification arg0) {
        return Api26Impl.getGroupAlertBehavior(arg0);
    }

    static boolean getHighPriority(Notification arg0) {
        if((arg0.flags & 0x80) != 0) {
            return 1;
        }

        return 0;
    }

    public static List getInvisibleActions(Notification arg3) {
        ArrayList v0 = new ArrayList();
        Bundle v3 = arg3.extras.getBundle("android.car.EXTENSIONS");
        if(v3 == null) {
        }
        else {
            v3 = v3.getBundle("invisible_actions");
            if(v3 != null) {
                int v1;
                for(v1 = 0; v1 < v3.size(); ++v1) {
                    v0.add(NotificationCompatJellybean.getActionFromBundle(v3.getBundle(Integer.toString(v1))));
                }
            }
        }

        return ((List)v0);
    }

    public static boolean getLocalOnly(Notification arg0) {
        if((arg0.flags & 0x100) != 0) {
            return 1;
        }

        return 0;
    }

    public static LocusIdCompat getLocusId(Notification arg3) {
        LocusIdCompat v2 = null;
        if(Build$VERSION.SDK_INT >= 29) {
            LocusId v3 = androidx.core.app.NotificationCompat$Api29Impl.getLocusId(arg3);
            if(v3 == null) {
                return v2;
            }

            return LocusIdCompat.toLocusIdCompat(v3);
        }

        return v2;
    }

    static Notification[] getNotificationArrayFromBundle(Bundle arg4, String arg5) {
        Parcelable[] v0 = arg4.getParcelableArray(arg5);
        if(!(v0 instanceof Notification[])) {
            if(v0 == null) {
            }
            else {
                Notification[] v1 = new Notification[v0.length];
                int v2;
                for(v2 = 0; v2 < v0.length; ++v2) {
                    v1[v2] = v0[v2];
                }

                arg4.putParcelableArray(arg5, ((Parcelable[])v1));
                return v1;
            }
        }

        return ((Notification[])v0);
    }

    public static boolean getOngoing(Notification arg0) {
        if((arg0.flags & 2) != 0) {
            return 1;
        }

        return 0;
    }

    public static boolean getOnlyAlertOnce(Notification arg0) {
        if((arg0.flags & 8) != 0) {
            return 1;
        }

        return 0;
    }

    public static List getPeople(Notification arg5) {
        ArrayList v0 = new ArrayList();
        if(Build$VERSION.SDK_INT >= 28) {
            ArrayList v5 = arg5.extras.getParcelableArrayList("android.people.list");
            if(v5 != null && !v5.isEmpty()) {
                Iterator v5_1 = v5.iterator();
                while(v5_1.hasNext()) {
                    v0.add(Person.fromAndroidPerson(v5_1.next()));
                }
            }
        }
        else {
            String[] v5_2 = arg5.extras.getStringArray("android.people");
            if(v5_2 != null && v5_2.length != 0) {
                int v1 = v5_2.length;
                int v2;
                for(v2 = 0; v2 < v1; ++v2) {
                    v0.add(new androidx.core.app.Person$Builder().setUri(v5_2[v2]).build());
                }
            }
        }

        return ((List)v0);
    }

    public static Notification getPublicVersion(Notification arg0) {
        return arg0.publicVersion;
    }

    public static CharSequence getSettingsText(Notification arg0) {
        return Api26Impl.getSettingsText(arg0);
    }

    public static String getShortCriticalText(Notification arg1) {
        return arg1.extras.getString("android.shortCriticalText");
    }

    public static String getShortcutId(Notification arg0) {
        return Api26Impl.getShortcutId(arg0);
    }

    public static boolean getShowWhen(Notification arg1) {
        return arg1.extras.getBoolean("android.showWhen");
    }

    public static String getSortKey(Notification arg0) {
        return arg0.getSortKey();
    }

    public static CharSequence getSubText(Notification arg1) {
        return arg1.extras.getCharSequence("android.subText");
    }

    public static long getTimeoutAfter(Notification arg2) {
        return Api26Impl.getTimeoutAfter(arg2);
    }

    public static boolean getUsesChronometer(Notification arg1) {
        return arg1.extras.getBoolean("android.showChronometer");
    }

    public static int getVisibility(Notification arg0) {
        return arg0.visibility;
    }

    public static boolean hasPromotableCharacteristics(Notification arg2) {
        if(Build$VERSION.SDK_INT >= 36) {
            return Api36Impl.hasPromotableCharacteristics(arg2);
        }

        return 0;
    }

    public static boolean isGroupSummary(Notification arg0) {
        if((arg0.flags & 0x200) != 0) {
            return 1;
        }

        return 0;
    }

    public static boolean isRequestPromotedOngoing(Notification arg2) {
        return arg2.extras.getBoolean("android.requestPromotedOngoing", false);
    }

    static boolean isSilent(Notification arg3) {
        if("silent".equals(arg3.getGroup())) {
            return 1;
        }

        if(NotificationCompat.isGroupSummary(arg3)) {
            if(NotificationCompat.getGroupAlertBehavior(arg3) == 2) {
                return 1;
            }

            return 0;
        }

        if(NotificationCompat.getGroupAlertBehavior(arg3) == 1) {
            return 1;
        }

        return 0;
    }

    public static Bitmap reduceLargeIconSize(Context arg8, Bitmap arg9) {
        if(arg9 != null) {
            if(Build$VERSION.SDK_INT >= 27) {
            }
            else {
                Resources v8 = arg8.getResources();
                int v0 = v8.getDimensionPixelSize(dimen.compat_notification_large_icon_max_width);
                int v8_1 = v8.getDimensionPixelSize(dimen.compat_notification_large_icon_max_height);
                if(arg9.getWidth() <= v0 && arg9.getHeight() <= v8_1) {
                    return arg9;
                }

                double v0_1 = Math.min((((double)v0)) / (((double)Math.max(1, arg9.getWidth()))), (((double)v8_1)) / (((double)Math.max(1, arg9.getHeight()))));
                return Bitmap.createScaledBitmap(arg9, ((int)Math.ceil((((double)arg9.getWidth())) * v0_1)), ((int)Math.ceil((((double)arg9.getHeight())) * v0_1)), true);
            }
        }

        return arg9;
    }
}

