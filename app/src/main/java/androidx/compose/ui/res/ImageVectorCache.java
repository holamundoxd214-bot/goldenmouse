package androidx.compose.ui.res;

import android.content.res.Configuration;
import android.content.res.Resources$Theme;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\n\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\u0006H\u0086\u0002J\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FJ\u0019\u0010\u0010\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\bH\u0086\u0002J\u0006\u0010\u0012\u001A\u00020\rR6\u0010\u0004\u001A*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/ui/res/ImageVectorCache;", "", "<init>", "()V", "map", "Ljava/util/HashMap;", "Landroidx/compose/ui/res/ImageVectorCache$Key;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "Lkotlin/collections/HashMap;", "get", "key", "prune", "", "configChanges", "", "set", "imageVectorEntry", "clear", "Key", "ImageVectorEntry", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ImageVectorCache {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "configFlags", "", "<init>", "(Landroidx/compose/ui/graphics/vector/ImageVector;I)V", "getImageVector", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getConfigFlags", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ImageVectorEntry {
        public static final int $stable;
        private final int configFlags;
        private final ImageVector imageVector;

        static {
        }

        public ImageVectorEntry(ImageVector arg1, int arg2) {
            super();
            this.imageVector = arg1;
            this.configFlags = arg2;
        }

        public final ImageVector component1() {
            return this.imageVector;
        }

        public final int component2() {
            return this.configFlags;
        }

        public final ImageVectorEntry copy(ImageVector arg1, int arg2) {
            return new ImageVectorEntry(arg1, arg2);
        }

        public static ImageVectorEntry copy$default(ImageVectorEntry arg0, ImageVector arg1, int arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.imageVector;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.configFlags;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((ImageVectorEntry)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof ImageVectorEntry)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.imageVector, ((ImageVectorEntry)arg5).imageVector)) {
                return 0;
            }

            if(this.configFlags != ((ImageVectorEntry)arg5).configFlags) {
                return 0;
            }

            return 1;
        }

        public final int getConfigFlags() {
            return this.configFlags;
        }

        public final ImageVector getImageVector() {
            return this.imageVector;
        }

        public int hashCode() {
            return this.imageVector.hashCode() * 0x1F + Integer.hashCode(this.configFlags);
        }

        public String toString() {
            return "ImageVectorEntry(imageVector=" + this.imageVector + ", configFlags=" + this.configFlags + ')';
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\n\u0010\u0002\u001A\u00060\u0003R\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\r\u001A\u00060\u0003R\u00020\u0004HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0006HÆ\u0003J!\u0010\u000F\u001A\u00020\u00002\f\b\u0002\u0010\u0002\u001A\u00060\u0003R\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001A\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0016"}, d2={"Landroidx/compose/ui/res/ImageVectorCache$Key;", "", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "id", "", "<init>", "(Landroid/content/res/Resources$Theme;I)V", "getTheme", "()Landroid/content/res/Resources$Theme;", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Key {
        public static final int $stable = 8;
        private final int id;
        private final Resources$Theme theme;

        static {
        }

        public Key(Resources$Theme arg1, int arg2) {
            super();
            this.theme = arg1;
            this.id = arg2;
        }

        public final Resources$Theme component1() {
            return this.theme;
        }

        public final int component2() {
            return this.id;
        }

        public final Key copy(Resources$Theme arg1, int arg2) {
            return new Key(arg1, arg2);
        }

        public static Key copy$default(Key arg0, Resources$Theme arg1, int arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.theme;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.id;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Key)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Key)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.theme, ((Key)arg5).theme)) {
                return 0;
            }

            if(this.id != ((Key)arg5).id) {
                return 0;
            }

            return 1;
        }

        public final int getId() {
            return this.id;
        }

        public final Resources$Theme getTheme() {
            return this.theme;
        }

        public int hashCode() {
            return this.theme.hashCode() * 0x1F + Integer.hashCode(this.id);
        }

        public String toString() {
            return "Key(theme=" + this.theme + ", id=" + this.id + ')';
        }
    }

    public static final int $stable = 8;
    private final HashMap map;

    static {
    }

    public ImageVectorCache() {
        super();
        this.map = new HashMap();
    }

    public final void clear() {
        this.map.clear();
    }

    public final ImageVectorEntry get(Key arg1) {
        Object v0 = this.map.get(arg1);
        if(v0 != null) {
            return ((WeakReference)v0).get();
        }

        return null;
    }

    public final void prune(int arg2) {
        Iterator v1 = this.map.entrySet().iterator();
        while(v1.hasNext()) {
            Object v0 = v1.next().getValue().get();
            if(v0 != null && !Configuration.needNewResources(arg2, ((ImageVectorEntry)v0).getConfigFlags())) {
                continue;
            }

            v1.remove();
        }
    }

    public final void set(Key arg2, ImageVectorEntry arg3) {
        this.map.put(arg2, new WeakReference(arg3));
    }
}

