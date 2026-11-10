package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo$Builder;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShortcutInfoCompat {
    class Api33Impl {
        private Api33Impl() {
            super();
        }

        static void setExcludedFromSurfaces(ShortcutInfo$Builder arg0, int arg1) {
            arg0.setExcludedFromSurfaces(arg1);
        }
    }

    public class Builder {
        private Map mCapabilityBindingParams;
        private Set mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder(Context arg2, ShortcutInfo arg3) {
            super();
            ShortcutInfoCompat v0 = new ShortcutInfoCompat();
            this.mInfo = v0;
            v0.mContext = arg2;
            v0.mId = arg3.getId();
            v0.mPackageName = arg3.getPackage();
            Intent[] v1 = arg3.getIntents();
            v0.mIntents = Arrays.copyOf(((Object[])v1), v1.length);
            v0.mActivity = arg3.getActivity();
            v0.mLabel = arg3.getShortLabel();
            v0.mLongLabel = arg3.getLongLabel();
            v0.mDisabledMessage = arg3.getDisabledMessage();
            if(Build$VERSION.SDK_INT >= 28) {
                v0.mDisabledReason = arg3.getDisabledReason();
            }
            else {
                int v1_1 = arg3.isEnabled() ? 0 : 3;
                v0.mDisabledReason = v1_1;
            }

            v0.mCategories = arg3.getCategories();
            v0.mPersons = ShortcutInfoCompat.getPersonsFromExtra(arg3.getExtras());
            v0.mUser = arg3.getUserHandle();
            v0.mLastChangedTimestamp = arg3.getLastChangedTimestamp();
            if(Build$VERSION.SDK_INT >= 30) {
                v0.mIsCached = arg3.isCached();
            }

            v0.mIsDynamic = arg3.isDynamic();
            v0.mIsPinned = arg3.isPinned();
            v0.mIsDeclaredInManifest = arg3.isDeclaredInManifest();
            v0.mIsImmutable = arg3.isImmutable();
            v0.mIsEnabled = arg3.isEnabled();
            v0.mHasKeyFieldsOnly = arg3.hasKeyFieldsOnly();
            v0.mLocusId = ShortcutInfoCompat.getLocusId(arg3);
            v0.mRank = arg3.getRank();
            v0.mExtras = arg3.getExtras();
        }

        public Builder(Context arg2, String arg3) {
            super();
            ShortcutInfoCompat v0 = new ShortcutInfoCompat();
            this.mInfo = v0;
            v0.mContext = arg2;
            v0.mId = arg3;
        }

        public Builder(ShortcutInfoCompat arg4) {
            super();
            ShortcutInfoCompat v0 = new ShortcutInfoCompat();
            this.mInfo = v0;
            v0.mContext = arg4.mContext;
            v0.mId = arg4.mId;
            v0.mPackageName = arg4.mPackageName;
            v0.mIntents = Arrays.copyOf(arg4.mIntents, arg4.mIntents.length);
            v0.mActivity = arg4.mActivity;
            v0.mLabel = arg4.mLabel;
            v0.mLongLabel = arg4.mLongLabel;
            v0.mDisabledMessage = arg4.mDisabledMessage;
            v0.mDisabledReason = arg4.mDisabledReason;
            v0.mIcon = arg4.mIcon;
            v0.mIsAlwaysBadged = arg4.mIsAlwaysBadged;
            v0.mUser = arg4.mUser;
            v0.mLastChangedTimestamp = arg4.mLastChangedTimestamp;
            v0.mIsCached = arg4.mIsCached;
            v0.mIsDynamic = arg4.mIsDynamic;
            v0.mIsPinned = arg4.mIsPinned;
            v0.mIsDeclaredInManifest = arg4.mIsDeclaredInManifest;
            v0.mIsImmutable = arg4.mIsImmutable;
            v0.mIsEnabled = arg4.mIsEnabled;
            v0.mLocusId = arg4.mLocusId;
            v0.mIsLongLived = arg4.mIsLongLived;
            v0.mHasKeyFieldsOnly = arg4.mHasKeyFieldsOnly;
            v0.mRank = arg4.mRank;
            if(arg4.mPersons != null) {
                v0.mPersons = Arrays.copyOf(arg4.mPersons, arg4.mPersons.length);
            }

            if(arg4.mCategories != null) {
                v0.mCategories = new HashSet(arg4.mCategories);
            }

            if(arg4.mExtras != null) {
                v0.mExtras = arg4.mExtras;
            }

            v0.mExcludedSurfaces = arg4.mExcludedSurfaces;
        }

        public Builder addCapabilityBinding(String arg2) {
            if(this.mCapabilityBindings == null) {
                this.mCapabilityBindings = new HashSet();
            }

            this.mCapabilityBindings.add(arg2);
            return this;
        }

        public Builder addCapabilityBinding(String arg3, String arg4, List arg5) {
            this.addCapabilityBinding(arg3);
            if(!arg5.isEmpty()) {
                if(this.mCapabilityBindingParams == null) {
                    this.mCapabilityBindingParams = new HashMap();
                }

                if(this.mCapabilityBindingParams.get(arg3) == null) {
                    this.mCapabilityBindingParams.put(arg3, new HashMap());
                }

                this.mCapabilityBindingParams.get(arg3).put(arg4, arg5);
            }

            return this;
        }

        public ShortcutInfoCompat build() {
            String[] v6_1;
            if(!TextUtils.isEmpty(this.mInfo.mLabel)) {
                if(this.mInfo.mIntents != null && this.mInfo.mIntents.length != 0) {
                    if(this.mIsConversation) {
                        if(this.mInfo.mLocusId == null) {
                            this.mInfo.mLocusId = new LocusIdCompat(this.mInfo.mId);
                        }

                        this.mInfo.mIsLongLived = true;
                    }

                    if(this.mCapabilityBindings != null) {
                        if(this.mInfo.mCategories == null) {
                            this.mInfo.mCategories = new HashSet();
                        }

                        this.mInfo.mCategories.addAll(this.mCapabilityBindings);
                    }

                    if(this.mCapabilityBindingParams != null) {
                        if(this.mInfo.mExtras == null) {
                            this.mInfo.mExtras = new PersistableBundle();
                        }

                        Iterator v0 = this.mCapabilityBindingParams.keySet().iterator();
                    label_50:
                        if(!v0.hasNext()) {
                            goto label_84;
                        }

                        Object v1 = v0.next();
                        Object v2 = this.mCapabilityBindingParams.get(v1);
                        this.mInfo.mExtras.putStringArray(((String)v1), ((Map)v2).keySet().toArray(new String[0]));
                        Iterator v3 = ((Map)v2).keySet().iterator();
                        while(true) {
                            if(!v3.hasNext()) {
                                goto label_50;
                            }

                            Object v4 = v3.next();
                            Object v6 = ((Map)v2).get(v4);
                            PersistableBundle v7 = this.mInfo.mExtras;
                            String v4_1 = (((String)v1)) + "/" + (((String)v4));
                            if(v6 == null) {
                                v6_1 = new String[0];
                            }
                            else {
                                Object[] v6_2 = ((List)v6).toArray(new String[0]);
                            }

                            v7.putStringArray(v4_1, v6_1);
                        }
                    }

                label_84:
                    if(this.mSliceUri != null) {
                        if(this.mInfo.mExtras == null) {
                            this.mInfo.mExtras = new PersistableBundle();
                        }

                        this.mInfo.mExtras.putString("extraSliceUri", UriCompat.toSafeString(this.mSliceUri));
                    }

                    return this.mInfo;
                }

                throw new IllegalArgumentException("Shortcut must have an intent");
            }

            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        public Builder setActivity(ComponentName arg2) {
            this.mInfo.mActivity = arg2;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public Builder setCategories(Set arg2) {
            ArraySet v0 = new ArraySet();
            v0.addAll(((Collection)arg2));
            this.mInfo.mCategories = ((Set)v0);
            return this;
        }

        public Builder setDisabledMessage(CharSequence arg2) {
            this.mInfo.mDisabledMessage = arg2;
            return this;
        }

        public Builder setExcludedFromSurfaces(int arg2) {
            this.mInfo.mExcludedSurfaces = arg2;
            return this;
        }

        public Builder setExtras(PersistableBundle arg2) {
            this.mInfo.mExtras = arg2;
            return this;
        }

        public Builder setIcon(IconCompat arg2) {
            this.mInfo.mIcon = arg2;
            return this;
        }

        public Builder setIntent(Intent arg3) {
            return this.setIntents(new Intent[]{arg3});
        }

        public Builder setIntents(Intent[] arg2) {
            this.mInfo.mIntents = arg2;
            return this;
        }

        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        public Builder setLocusId(LocusIdCompat arg2) {
            this.mInfo.mLocusId = arg2;
            return this;
        }

        public Builder setLongLabel(CharSequence arg2) {
            this.mInfo.mLongLabel = arg2;
            return this;
        }

        @Deprecated public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        public Builder setLongLived(boolean arg2) {
            this.mInfo.mIsLongLived = arg2;
            return this;
        }

        public Builder setPerson(Person arg3) {
            return this.setPersons(new Person[]{arg3});
        }

        public Builder setPersons(Person[] arg2) {
            this.mInfo.mPersons = arg2;
            return this;
        }

        public Builder setRank(int arg2) {
            this.mInfo.mRank = arg2;
            return this;
        }

        public Builder setShortLabel(CharSequence arg2) {
            this.mInfo.mLabel = arg2;
            return this;
        }

        public Builder setSliceUri(Uri arg1) {
            this.mSliceUri = arg1;
            return this;
        }

        public Builder setTransientExtras(Bundle arg2) {
            this.mInfo.mTransientExtras = Preconditions.checkNotNull(arg2);
            return this;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Surface {
    }

    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    ShortcutInfoCompat() {
        super();
        this.mIsEnabled = true;
    }

    Intent addToIntent(Intent arg4) {
        arg4.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[this.mIntents.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if(this.mIcon != null) {
            Drawable v1 = null;
            if(this.mIsAlwaysBadged) {
                PackageManager v0 = this.mContext.getPackageManager();
                ComponentName v2 = this.mActivity;
                if(v2 != null) {
                    try {
                        v1 = v0.getActivityIcon(v2);
                        goto label_20;
                    }
                    catch(PackageManager$NameNotFoundException ) {
                    label_20:
                        if(v1 != null) {
                            goto label_24;
                        }

                        v1 = this.mContext.getApplicationInfo().loadIcon(v0);
                        goto label_24;
                    }
                }

                goto label_20;
            }

        label_24:
            this.mIcon.addToShortcutIntent(arg4, v1, this.mContext);
        }

        return arg4;
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        PersistableBundle v0 = this.mExtras;
        if(v0 == null) {
            v0 = new PersistableBundle();
            this.mExtras = v0;
        }

        Person[] v1 = this.mPersons;
        if(v1 != null && v1.length > 0) {
            v0.putInt("extraPersonCount", v1.length);
            int v0_1;
            for(v0_1 = 0; v0_1 < this.mPersons.length; v0_1 = v3) {
                int v3 = v0_1 + 1;
                this.mExtras.putPersistableBundle("extraPerson_" + v3, this.mPersons[v0_1].toPersistableBundle());
            }
        }

        LocusIdCompat v0_2 = this.mLocusId;
        if(v0_2 != null) {
            this.mExtras.putString("extraLocusId", v0_2.getId());
        }

        this.mExtras.putBoolean("extraLongLived", this.mIsLongLived);
        return this.mExtras;
    }

    static List fromShortcuts(Context arg3, List arg4) {
        ArrayList v0 = new ArrayList(arg4.size());
        Iterator v4 = arg4.iterator();
        while(v4.hasNext()) {
            ((List)v0).add(new Builder(arg3, v4.next()).build());
        }

        return ((List)v0);
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public Set getCategories() {
        return this.mCategories;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public Intent getIntent() {
        return this.mIntents[this.mIntents.length - 1];
    }

    public Intent[] getIntents() {
        return Arrays.copyOf(this.mIntents, this.mIntents.length);
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    static LocusIdCompat getLocusId(ShortcutInfo arg2) {
        if(Build$VERSION.SDK_INT >= 29) {
            if(arg2.getLocusId() == null) {
                return null;
            }

            return LocusIdCompat.toLocusIdCompat(arg2.getLocusId());
        }

        return ShortcutInfoCompat.getLocusIdFromExtra(arg2.getExtras());
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle arg2) {
        LocusIdCompat v0 = null;
        if(arg2 == null) {
            return v0;
        }

        String v2 = arg2.getString("extraLocusId");
        if(v2 == null) {
            return v0;
        }

        return new LocusIdCompat(v2);
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    static boolean getLongLivedFromExtra(PersistableBundle arg2) {
        if(arg2 != null) {
            String v0 = "extraLongLived";
            if(!arg2.containsKey(v0)) {
            }
            else {
                return arg2.getBoolean(v0);
            }
        }

        return 0;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    static Person[] getPersonsFromExtra(PersistableBundle arg5) {
        if(arg5 != null) {
            String v0 = "extraPersonCount";
            if(!arg5.containsKey(v0)) {
            }
            else {
                int v0_1 = arg5.getInt(v0);
                Person[] v1 = new Person[v0_1];
                int v2;
                for(v2 = 0; v2 < v0_1; v2 = v4) {
                    int v4 = v2 + 1;
                    v1[v2] = Person.fromPersistableBundle(arg5.getPersistableBundle("extraPerson_" + v4));
                }

                return v1;
            }
        }

        return null;
    }

    public int getRank() {
        return this.mRank;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isExcludedFromSurfaces(int arg1) {
        if((this.mExcludedSurfaces & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo$Builder v0 = new ShortcutInfo$Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat v1 = this.mIcon;
        if(v1 != null) {
            v0.setIcon(v1.toIcon(this.mContext));
        }

        if(!TextUtils.isEmpty(this.mLongLabel)) {
            v0.setLongLabel(this.mLongLabel);
        }

        if(!TextUtils.isEmpty(this.mDisabledMessage)) {
            v0.setDisabledMessage(this.mDisabledMessage);
        }

        ComponentName v1_1 = this.mActivity;
        if(v1_1 != null) {
            v0.setActivity(v1_1);
        }

        Set v1_2 = this.mCategories;
        if(v1_2 != null) {
            v0.setCategories(v1_2);
        }

        v0.setRank(this.mRank);
        PersistableBundle v1_3 = this.mExtras;
        if(v1_3 != null) {
            v0.setExtras(v1_3);
        }

        if(Build$VERSION.SDK_INT >= 29) {
            Person[] v1_4 = this.mPersons;
            if(v1_4 != null && v1_4.length > 0) {
                int v1_5 = v1_4.length;
                android.app.Person[] v2 = new android.app.Person[v1_5];
                int v3;
                for(v3 = 0; v3 < v1_5; ++v3) {
                    v2[v3] = this.mPersons[v3].toAndroidPerson();
                }

                v0.setPersons(v2);
            }

            LocusIdCompat v1_6 = this.mLocusId;
            if(v1_6 != null) {
                v0.setLocusId(v1_6.toLocusId());
            }

            v0.setLongLived(this.mIsLongLived);
        }
        else {
            v0.setExtras(this.buildLegacyExtrasBundle());
        }

        if(Build$VERSION.SDK_INT >= 33) {
            Api33Impl.setExcludedFromSurfaces(v0, this.mExcludedSurfaces);
        }

        return v0.build();
    }
}

