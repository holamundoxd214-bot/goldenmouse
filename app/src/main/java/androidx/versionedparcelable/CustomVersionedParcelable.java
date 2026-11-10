package androidx.versionedparcelable;

public abstract class CustomVersionedParcelable implements VersionedParcelable {
    public CustomVersionedParcelable() {
        super();
    }

    public void onPostParceling() {
    }

    public void onPreParceling(boolean arg1) {
    }
}

