package androidx.profileinstaller;

class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    WritableFileSection(FileSectionType arg1, int arg2, byte[] arg3, boolean arg4) {
        super();
        this.mType = arg1;
        this.mExpectedInflateSize = arg2;
        this.mContents = arg3;
        this.mNeedsCompression = arg4;
    }
}

