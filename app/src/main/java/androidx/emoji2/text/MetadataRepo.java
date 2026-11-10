package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class MetadataRepo {
    class Node {
        private final SparseArray mChildren;
        private TypefaceEmojiRasterizer mData;

        Node(int arg2) {
            super();
            this.mChildren = new SparseArray(arg2);
        }

        private Node() {
            this(1);
        }

        Node get(int arg1) {
            SparseArray v0 = this.mChildren;
            if(v0 == null) {
                return null;
            }

            return v0.get(arg1);
        }

        final TypefaceEmojiRasterizer getData() {
            return this.mData;
        }

        void put(TypefaceEmojiRasterizer arg3, int arg4, int arg5) {
            Node v0 = this.get(arg3.getCodepointAt(arg4));
            if(v0 == null) {
                v0 = new Node();
                this.mChildren.put(arg3.getCodepointAt(arg4), v0);
            }

            if(arg5 > arg4) {
                v0.put(arg3, arg4 + 1, arg5);
                return;
            }

            v0.mData = arg3;
        }
    }

    private static final int DEFAULT_ROOT_SIZE = 0x400;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    private final char[] mEmojiCharArray;
    private final MetadataList mMetadataList;
    private final Node mRootNode;
    private final Typeface mTypeface;

    private MetadataRepo(Typeface arg2, MetadataList arg3) {
        super();
        this.mTypeface = arg2;
        this.mMetadataList = arg3;
        this.mRootNode = new Node(0x400);
        this.mEmojiCharArray = new char[arg3.listLength() * 2];
        this.constructIndex(arg3);
    }

    private void constructIndex(MetadataList arg6) {
        int v6 = arg6.listLength();
        int v0;
        for(v0 = 0; v0 < v6; ++v0) {
            TypefaceEmojiRasterizer v1 = new TypefaceEmojiRasterizer(this, v0);
            Character.toChars(v1.getId(), this.mEmojiCharArray, v0 * 2);
            this.put(v1);
        }
    }

    public static MetadataRepo create(Typeface arg1, ByteBuffer arg2) throws IOException {
        MetadataRepo v0;
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            v0 = new MetadataRepo(arg1, MetadataListReader.read(arg2));
        }
        catch(Throwable v1) {
            TraceCompat.endSection();
            throw v1;
        }

        TraceCompat.endSection();
        return v0;
    }

    public static MetadataRepo create(AssetManager arg2, String arg3) throws IOException {
        MetadataRepo v1;
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            v1 = new MetadataRepo(Typeface.createFromAsset(arg2, arg3), MetadataListReader.read(arg2, arg3));
        }
        catch(Throwable v2) {
            TraceCompat.endSection();
            throw v2;
        }

        TraceCompat.endSection();
        return v1;
    }

    public static MetadataRepo create(Typeface arg2) {
        MetadataRepo v0;
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            v0 = new MetadataRepo(arg2, new MetadataList());
        }
        catch(Throwable v2) {
            TraceCompat.endSection();
            throw v2;
        }

        TraceCompat.endSection();
        return v0;
    }

    public static MetadataRepo create(Typeface arg1, InputStream arg2) throws IOException {
        MetadataRepo v0;
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            v0 = new MetadataRepo(arg1, MetadataListReader.read(arg2));
        }
        catch(Throwable v1) {
            TraceCompat.endSection();
            throw v1;
        }

        TraceCompat.endSection();
        return v0;
    }

    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    Node getRootNode() {
        return this.mRootNode;
    }

    Typeface getTypeface() {
        return this.mTypeface;
    }

    void put(TypefaceEmojiRasterizer arg5) {
        Preconditions.checkNotNull(arg5, "emoji metadata cannot be null");
        boolean v0 = arg5.getCodepointsLength() > 0 ? true : false;
        Preconditions.checkArgument(v0, "invalid metadata codepoint length");
        this.mRootNode.put(arg5, 0, arg5.getCodepointsLength() - 1);
    }
}

