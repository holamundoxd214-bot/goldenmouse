package androidx.graphics.path;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001A\u0010\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0006H\u0002\"\u0016\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\u0007"}, d2={"PathSegmentTypes", "", "Landroidx/graphics/path/PathSegment$Type;", "[Landroidx/graphics/path/PathSegment$Type;", "platformToAndroidXSegmentType", "platformType", "", "graphics-path_release"}, k=2, mv={1, 8, 0}, xi=0x30) public final class PathIteratorImplKt {
    private static final Type[] PathSegmentTypes;

    static {
        PathIteratorImplKt.PathSegmentTypes = Type.values();
    }

    public static final Type[] access$getPathSegmentTypes$p() {
        return PathIteratorImplKt.PathSegmentTypes;
    }

    public static final Type access$platformToAndroidXSegmentType(int arg0) {
        return PathIteratorImplKt.platformToAndroidXSegmentType(arg0);
    }

    private static final Type platformToAndroidXSegmentType(int arg3) {
        switch(arg3) {
            case 0: {
                goto label_21;
            }
            case 1: {
                goto label_19;
            }
            case 2: {
                goto label_17;
            }
            case 3: {
                goto label_15;
            }
            case 4: {
                goto label_13;
            }
            case 5: {
                goto label_11;
            }
            case 6: {
                goto label_9;
            }
        }

        throw new IllegalArgumentException("Unknown path segment type " + arg3);
    label_17:
        return Type.Quadratic;
    label_19:
        return Type.Line;
    label_21:
        return Type.Move;
    label_9:
        return Type.Done;
    label_11:
        return Type.Close;
    label_13:
        return Type.Cubic;
    label_15:
        return Type.Conic;
    }
}

