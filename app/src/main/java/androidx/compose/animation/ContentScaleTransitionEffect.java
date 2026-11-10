package androidx.compose.animation;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081\b\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0018\u0010\f\u001A\u0006\u0012\u0002\b\u00030\r8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001C"}, d2={"Landroidx/compose/animation/ContentScaleTransitionEffect;", "Landroidx/compose/animation/TransitionEffect;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "<init>", "(Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "key", "Landroidx/compose/animation/TransitionEffectKey;", "getKey$animation", "()Landroidx/compose/animation/TransitionEffectKey;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Key", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContentScaleTransitionEffect extends TransitionEffect {
    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/animation/ContentScaleTransitionEffect$Key;", "Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/ContentScaleTransitionEffect;", "<init>", "()V", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Key implements TransitionEffectKey {
        public Key(DefaultConstructorMarker arg1) {
            this();
        }

        private Key() {
            super();
        }
    }

    public static final int $stable;
    public static final Key Key;
    private final Alignment alignment;
    private final ContentScale contentScale;

    static {
        ContentScaleTransitionEffect.Key = new Key(null);
    }

    public ContentScaleTransitionEffect(ContentScale arg2, Alignment arg3) {
        super(null);
        this.contentScale = arg2;
        this.alignment = arg3;
    }

    public final ContentScale component1() {
        return this.contentScale;
    }

    public final Alignment component2() {
        return this.alignment;
    }

    public final ContentScaleTransitionEffect copy(ContentScale arg1, Alignment arg2) {
        return new ContentScaleTransitionEffect(arg1, arg2);
    }

    public static ContentScaleTransitionEffect copy$default(ContentScaleTransitionEffect arg0, ContentScale arg1, Alignment arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.contentScale;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.alignment;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((ContentScaleTransitionEffect)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ContentScaleTransitionEffect)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.contentScale, ((ContentScaleTransitionEffect)arg5).contentScale)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.alignment, ((ContentScaleTransitionEffect)arg5).alignment)) {
            return 0;
        }

        return 1;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public TransitionEffectKey getKey$animation() {
        return ContentScaleTransitionEffect.Key;
    }

    public int hashCode() {
        return this.contentScale.hashCode() * 0x1F + this.alignment.hashCode();
    }

    public String toString() {
        return "ContentScaleTransitionEffect(contentScale=" + this.contentScale + ", alignment=" + this.alignment + ')';
    }
}

