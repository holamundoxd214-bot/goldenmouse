package androidx.core.content;

import android.content.LocusId;
import android.os.Build$VERSION;
import androidx.core.util.Preconditions;

public final class LocusIdCompat {
    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static LocusId create(String arg1) {
            return new LocusId(arg1);
        }

        static String getId(LocusId arg0) {
            return arg0.getId();
        }
    }

    private final String mId;
    private final LocusId mWrapped;

    public LocusIdCompat(String arg3) {
        super();
        this.mId = Preconditions.checkStringNotEmpty(((CharSequence)arg3), "id cannot be empty");
        if(Build$VERSION.SDK_INT >= 29) {
            this.mWrapped = Api29Impl.create(arg3);
            return;
        }

        this.mWrapped = null;
    }

    public boolean equals(Object arg5) {
        if(this == (((LocusIdCompat)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        String v4 = this.mId;
        if(v4 == null) {
            if(((LocusIdCompat)arg5).mId == null) {
                return 1;
            }

            return 0;
        }

        return v4.equals(((LocusIdCompat)arg5).mId);
    }

    public String getId() {
        return this.mId;
    }

    private String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    public int hashCode() {
        String v1 = this.mId;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return 0x1F + v1_1;
    }

    public LocusId toLocusId() {
        return this.mWrapped;
    }

    public static LocusIdCompat toLocusIdCompat(LocusId arg2) {
        Preconditions.checkNotNull(arg2, "locusId cannot be null");
        return new LocusIdCompat(Preconditions.checkStringNotEmpty(Api29Impl.getId(arg2), "id cannot be empty"));
    }

    public String toString() {
        return "LocusIdCompat[" + this.getSanitizedId() + "]";
    }
}

