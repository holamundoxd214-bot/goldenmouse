package androidx.window.embedding;

import android.os.Bundle;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.embedding.ActivityStack$Token;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0001¢\u0006\u0002\b\u0016J\u0014\u0010\u0017\u001A\u00020\u0011*\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J\u0019\u0010\u001A\u001A\u00020\u0011*\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u0019H\u0000¢\u0006\u0002\b\u001BJ\u0013\u0010\u001C\u001A\u0004\u0018\u00010\u001D*\u00020\u0013H\u0000¢\u0006\u0002\b\u001EJ\u000E\u0010\u001F\u001A\u0004\u0018\u00010\u0019*\u00020\u0013H\u0002J\u0014\u0010 \u001A\u00020!*\u00020\u00132\u0006\u0010\"\u001A\u00020\u0005H\u0002J\u001C\u0010#\u001A\u00020\u0011*\u00020\u00132\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010$\u001A\u00020!H\u0002J\u001D\u0010%\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010&\u001A\u00020\'H\u0001¢\u0006\u0002\b(R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Landroidx/window/embedding/ActivityEmbeddingOptionsImpl;", "", "<init>", "()V", "KEY_EMBEDDING_BOUNDS", "", "KEY_EMBEDDING_BOUNDS_ALIGNMENT", "KEY_EMBEDDING_BOUNDS_WIDTH", "KEY_EMBEDDING_BOUNDS_HEIGHT", "DIMENSION_TYPE_EXPANDED", "DIMENSION_TYPE_HINGE", "DIMENSION_TYPE_RATIO", "DIMENSION_TYPE_PIXEL", "KEY_EMBEDDING_BOUNDS_DIMENSION_TYPE", "KEY_EMBEDDING_BOUNDS_DIMENSION_VALUE", "KEY_ACTIVITY_STACK_ALIGNMENT", "setOverlayCreateParams", "", "options", "Landroid/os/Bundle;", "overlayCreateParams", "Landroidx/window/embedding/OverlayCreateParams;", "setOverlayCreateParams$window_release", "putEmbeddingBounds", "embeddingBounds", "Landroidx/window/embedding/EmbeddingBounds;", "putActivityStackAlignment", "putActivityStackAlignment$window_release", "getOverlayAttributes", "Landroidx/window/embedding/OverlayAttributes;", "getOverlayAttributes$window_release", "getEmbeddingBounds", "getDimension", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "key", "putDimension", "dimension", "setActivityStackToken", "activityStackToken", "Landroidx/window/extensions/embedding/ActivityStack$Token;", "setActivityStackToken$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActivityEmbeddingOptionsImpl {
    private static final String DIMENSION_TYPE_EXPANDED = "expanded";
    private static final String DIMENSION_TYPE_HINGE = "hinge";
    private static final String DIMENSION_TYPE_PIXEL = "pixel";
    private static final String DIMENSION_TYPE_RATIO = "ratio";
    public static final ActivityEmbeddingOptionsImpl INSTANCE = null;
    private static final String KEY_ACTIVITY_STACK_ALIGNMENT = "androidx.window.embedding.ActivityStackAlignment";
    private static final String KEY_EMBEDDING_BOUNDS = "androidx.window.embedding.EmbeddingBounds";
    private static final String KEY_EMBEDDING_BOUNDS_ALIGNMENT = "androidx.window.embedding.EmbeddingBounds.alignment";
    private static final String KEY_EMBEDDING_BOUNDS_DIMENSION_TYPE = "androidx.window.embedding.EmbeddingBounds.dimension_type";
    private static final String KEY_EMBEDDING_BOUNDS_DIMENSION_VALUE = "androidx.window.embedding.EmbeddingBounds.dimension_value";
    private static final String KEY_EMBEDDING_BOUNDS_HEIGHT = "androidx.window.embedding.EmbeddingBounds.height";
    private static final String KEY_EMBEDDING_BOUNDS_WIDTH = "androidx.window.embedding.EmbeddingBounds.width";

    static {
        ActivityEmbeddingOptionsImpl.INSTANCE = new ActivityEmbeddingOptionsImpl();
    }

    private ActivityEmbeddingOptionsImpl() {
        super();
    }

    private final Dimension getDimension(Bundle arg2, String arg3) {
        Bundle v1 = arg2.getBundle(arg3);
        Intrinsics.checkNotNull(v1);
        String v2 = v1.getString("androidx.window.embedding.EmbeddingBounds.dimension_type");
        if(v2 != null) {
            String v0 = "androidx.window.embedding.EmbeddingBounds.dimension_value";
            switch(v2.hashCode()) {
                case -1939100487: {
                    goto label_28;
                }
                case 99283243: {
                    goto label_23;
                }
                case 106680966: {
                    goto label_16;
                }
                case 108285963: {
                    goto label_9;
                }
            }

            goto label_33;
        label_23:
            if(v2.equals("hinge")) {
                return Dimension.DIMENSION_HINGE;
            label_9:
                if(v2.equals("ratio")) {
                    return Dimension.Companion.ratio(v1.getFloat(v0));
                label_28:
                    if(v2.equals("expanded")) {
                        return Dimension.DIMENSION_EXPANDED;
                    label_16:
                        if(v2.equals("pixel")) {
                            return Dimension.Companion.pixel(v1.getInt(v0));
                        }
                    }
                }
            }
        }

    label_33:
        throw new IllegalArgumentException("Illegal type " + v2);
    }

    private final EmbeddingBounds getEmbeddingBounds(Bundle arg5) {
        arg5 = arg5.getBundle("androidx.window.embedding.EmbeddingBounds");
        if(arg5 == null) {
            return null;
        }

        return new EmbeddingBounds(new Alignment(arg5.getInt("androidx.window.embedding.EmbeddingBounds.alignment")), this.getDimension(arg5, "androidx.window.embedding.EmbeddingBounds.width"), this.getDimension(arg5, "androidx.window.embedding.EmbeddingBounds.height"));
    }

    public final OverlayAttributes getOverlayAttributes$window_release(Bundle arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        EmbeddingBounds v1 = this.getEmbeddingBounds(arg2);
        if(v1 == null) {
            return null;
        }

        return new OverlayAttributes(v1);
    }

    public final void putActivityStackAlignment$window_release(Bundle arg1, EmbeddingBounds arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "embeddingBounds");
        arg1.putInt("androidx.window.embedding.ActivityStackAlignment", arg2.getAlignment().getValue$window_release());
    }

    private final void putDimension(Bundle arg4, String arg5, Dimension arg6) {
        Bundle v3 = new Bundle();
        String v1 = "androidx.window.embedding.EmbeddingBounds.dimension_type";
        if(Intrinsics.areEqual(arg6, Dimension.DIMENSION_EXPANDED)) {
            v3.putString(v1, "expanded");
        }
        else if(Intrinsics.areEqual(arg6, Dimension.DIMENSION_HINGE)) {
            v3.putString(v1, "hinge");
        }
        else {
            String v2 = "androidx.window.embedding.EmbeddingBounds.dimension_value";
            if((arg6 instanceof Ratio)) {
                v3.putString(v1, "ratio");
                v3.putFloat(v2, ((Ratio)arg6).getValue$window_release());
            }
            else if((arg6 instanceof Pixel)) {
                v3.putString(v1, "pixel");
                v3.putInt(v2, ((Pixel)arg6).getValue$window_release());
            }
        }

        arg4.putBundle(arg5, v3);
    }

    private final void putEmbeddingBounds(Bundle arg4, EmbeddingBounds arg5) {
        Bundle v3 = new Bundle();
        v3.putInt("androidx.window.embedding.EmbeddingBounds.alignment", arg5.getAlignment().getValue$window_release());
        ActivityEmbeddingOptionsImpl v0 = ActivityEmbeddingOptionsImpl.INSTANCE;
        v0.putDimension(v3, "androidx.window.embedding.EmbeddingBounds.width", arg5.getWidth());
        v0.putDimension(v3, "androidx.window.embedding.EmbeddingBounds.height", arg5.getHeight());
        arg4.putBundle("androidx.window.embedding.EmbeddingBounds", v3);
    }

    public final void setActivityStackToken$window_release(Bundle arg1, ActivityStack$Token arg2) {
        Intrinsics.checkNotNullParameter(arg1, "options");
        Intrinsics.checkNotNullParameter(arg2, "activityStackToken");
        arg1.putBundle("androidx.window.extensions.embedding.ActivityStackToken", arg2.toBundle());
    }

    public final void setOverlayCreateParams$window_release(Bundle arg3, OverlayCreateParams arg4) {
        Intrinsics.checkNotNullParameter(arg3, "options");
        Intrinsics.checkNotNullParameter(arg4, "overlayCreateParams");
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(8);
        arg3.putString("androidx.window.extensions.embedding.OverlayTag", arg4.getTag());
        this.putEmbeddingBounds(arg3, arg4.getOverlayAttributes().getBounds());
    }
}

