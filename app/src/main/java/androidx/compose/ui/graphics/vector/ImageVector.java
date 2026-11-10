package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u001B\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002,-B[\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010)\u001A\u00020\u00112\b\u0010*\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001A\u00020\u0013H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u001B\u0010\u0019R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0019R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0019R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0013\u0010\f\u001A\u00020\r¢\u0006\n\n\u0002\u0010\"\u001A\u0004\b \u0010!R\u0013\u0010\u000E\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010%\u001A\u0004\b#\u0010$R\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u0014\u0010\u0012\u001A\u00020\u0013X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b(\u0010$¨\u0006."}, d2={"Landroidx/compose/ui/graphics/vector/ImageVector;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "root", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "autoMirror", "", "genId", "", "<init>", "(Ljava/lang/String;FFFFLandroidx/compose/ui/graphics/vector/VectorGroup;JIZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getDefaultWidth-D9Ej5fM", "()F", "F", "getDefaultHeight-D9Ej5fM", "getViewportWidth", "getViewportHeight", "getRoot", "()Landroidx/compose/ui/graphics/vector/VectorGroup;", "getTintColor-0d7_KjU", "()J", "J", "getTintBlendMode-0nO6VwU", "()I", "I", "getAutoMirror", "()Z", "getGenId$ui", "equals", "other", "hashCode", "Builder", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ImageVector {
    @Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001EBO\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011BG\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u0010\u0010\u0012Jf\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\b2\b\b\u0002\u0010!\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020\b2\b\b\u0002\u0010#\u001A\u00020\b2\b\b\u0002\u0010$\u001A\u00020\b2\b\b\u0002\u0010%\u001A\u00020\b2\b\b\u0002\u0010&\u001A\u00020\b2\u000E\b\u0002\u0010\'\u001A\b\u0012\u0004\u0012\u00020)0(J\u0006\u0010*\u001A\u00020\u0000J¡\u0001\u0010+\u001A\u00020\u00002\f\u0010,\u001A\b\u0012\u0004\u0012\u00020)0(2\b\b\u0002\u0010-\u001A\u00020.2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010/\u001A\u0004\u0018\u0001002\b\b\u0002\u00101\u001A\u00020\b2\n\b\u0002\u00102\u001A\u0004\u0018\u0001002\b\b\u0002\u00103\u001A\u00020\b2\b\b\u0002\u00104\u001A\u00020\b2\b\b\u0002\u00105\u001A\u0002062\b\b\u0002\u00107\u001A\u0002082\b\b\u0002\u00109\u001A\u00020\b2\b\b\u0002\u0010:\u001A\u00020\b2\b\b\u0002\u0010;\u001A\u00020\b2\b\b\u0002\u0010<\u001A\u00020\b¢\u0006\u0004\b=\u0010>J\u0006\u0010?\u001A\u00020@J\b\u0010A\u001A\u00020BH\u0002J\f\u0010C\u001A\u00020D*\u00020\u0018H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0016\u001A\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001C\u001A\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006F"}, d2={"Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "autoMirror", "", "<init>", "(Ljava/lang/String;FFFFJIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;FFFFJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "J", "I", "nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "Lkotlin/collections/ArrayList;", "root", "isConsumed", "currentGroup", "getCurrentGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "addGroup", "rotate", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "clearGroup", "addPath", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "addPath-oIyEayM", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFF)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ensureNotConsumed", "", "asVectorGroup", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "GroupParams", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001D\b\u0002\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\u0005\u0012\b\b\u0002\u0010\n\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0005\u0012\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r\u0012\u000E\b\u0002\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001A\u0010\u0006\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0019\"\u0004\b\u001D\u0010\u001BR\u001A\u0010\u0007\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u0019\"\u0004\b\u001F\u0010\u001BR\u001A\u0010\b\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001BR\u001A\u0010\t\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001BR\u001A\u0010\n\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001BR\u001A\u0010\u000B\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0019\"\u0004\b\'\u0010\u001BR \u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b,\u0010)\"\u0004\b-\u0010+¨\u0006."}, d2={"Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "", "name", "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", "<init>", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRotate", "()F", "setRotate", "(F)V", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getClipPathData", "()Ljava/util/List;", "setClipPathData", "(Ljava/util/List;)V", "getChildren", "setChildren", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class GroupParams {
            private List children;
            private List clipPathData;
            private String name;
            private float pivotX;
            private float pivotY;
            private float rotate;
            private float scaleX;
            private float scaleY;
            private float translationX;
            private float translationY;

            public GroupParams(String arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, List arg11, List arg12, int arg13, DefaultConstructorMarker arg14) {
                ArrayList v12;
                if((arg13 & 1) != 0) {
                    arg3 = "";
                }

                float v1 = 1f;
                if((arg13 & 16) != 0) {
                    arg7 = v1;
                }

                if((arg13 & 0x20) != 0) {
                    arg8 = v1;
                }

                if((arg13 & 0x100) != 0) {
                    arg11 = VectorKt.getEmptyPath();
                }

                if((arg13 & 0x200) != 0) {
                    v12 = new ArrayList();
                }

                this(arg3, 0f, 0f, 0f, arg7, arg8, 0f, 0f, arg11, ((List)v12));
            }

            public GroupParams() {
                this(null, 0f, 0f, 0f, 0f, 0f, 0f, 0f, null, null, 0x3FF, null);
            }

            public GroupParams(String arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, List arg9, List arg10) {
                super();
                this.name = arg1;
                this.rotate = arg2;
                this.pivotX = arg3;
                this.pivotY = arg4;
                this.scaleX = arg5;
                this.scaleY = arg6;
                this.translationX = arg7;
                this.translationY = arg8;
                this.clipPathData = arg9;
                this.children = arg10;
            }

            public final List getChildren() {
                return this.children;
            }

            public final List getClipPathData() {
                return this.clipPathData;
            }

            public final String getName() {
                return this.name;
            }

            public final float getPivotX() {
                return this.pivotX;
            }

            public final float getPivotY() {
                return this.pivotY;
            }

            public final float getRotate() {
                return this.rotate;
            }

            public final float getScaleX() {
                return this.scaleX;
            }

            public final float getScaleY() {
                return this.scaleY;
            }

            public final float getTranslationX() {
                return this.translationX;
            }

            public final float getTranslationY() {
                return this.translationY;
            }

            public final void setChildren(List arg1) {
                this.children = arg1;
            }

            public final void setClipPathData(List arg1) {
                this.clipPathData = arg1;
            }

            public final void setName(String arg1) {
                this.name = arg1;
            }

            public final void setPivotX(float arg1) {
                this.pivotX = arg1;
            }

            public final void setPivotY(float arg1) {
                this.pivotY = arg1;
            }

            public final void setRotate(float arg1) {
                this.rotate = arg1;
            }

            public final void setScaleX(float arg1) {
                this.scaleX = arg1;
            }

            public final void setScaleY(float arg1) {
                this.scaleY = arg1;
            }

            public final void setTranslationX(float arg1) {
                this.translationX = arg1;
            }

            public final void setTranslationY(float arg1) {
                this.translationY = arg1;
            }
        }

        public static final int $stable = 8;
        private final boolean autoMirror;
        private final float defaultHeight;
        private final float defaultWidth;
        private boolean isConsumed;
        private final String name;
        private final ArrayList nodes;
        private GroupParams root;
        private final int tintBlendMode;
        private final long tintColor;
        private final float viewportHeight;
        private final float viewportWidth;

        static {
        }

        public Builder(String arg12, float arg13, float arg14, float arg15, float arg16, long arg17, int arg19, boolean arg20, int arg21, DefaultConstructorMarker arg22) {
            int v0 = arg21;
            if((v0 & 1) != 0) {
                arg12 = "";
            }

            String v1 = arg12;
            long v6 = (v0 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
            int v8 = (v0 & 0x40) != 0 ? BlendMode.Companion.getSrcIn-0nO6VwU() : arg19;
            boolean v9 = (v0 & 0x80) != 0 ? false : arg20;
            this(v1, arg13, arg14, arg15, arg16, v6, v8, v9, null);
        }

        private Builder(String arg12, float arg13, float arg14, float arg15, float arg16, long arg17, int arg19) {
            this(arg12, arg13, arg14, arg15, arg16, arg17, arg19, false, null);
        }

        public Builder(String arg1, float arg2, float arg3, float arg4, float arg5, long arg6, int arg8, boolean arg9, DefaultConstructorMarker arg10) {
            this(arg1, arg2, arg3, arg4, arg5, arg6, arg8, arg9);
        }

        public Builder(String arg11, float arg12, float arg13, float arg14, float arg15, long arg16, int arg18, int arg19, DefaultConstructorMarker arg20) {
            if((arg19 & 1) != 0) {
                arg11 = "";
            }

            String v1 = arg11;
            long v6 = (arg19 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg16;
            int v8 = (arg19 & 0x40) != 0 ? BlendMode.Companion.getSrcIn-0nO6VwU() : arg18;
            this(v1, arg12, arg13, arg14, arg15, v6, v8, null);
        }

        @Deprecated(level=DeprecationLevel.HIDDEN, message="Replace with ImageVector.Builder that consumes an optional auto mirror parameter", replaceWith="<_subannotation>") public Builder(String arg1, float arg2, float arg3, float arg4, float arg5, long arg6, int arg8, DefaultConstructorMarker arg9) {
            this(arg1, arg2, arg3, arg4, arg5, arg6, arg8);
        }

        private Builder(String arg14, float arg15, float arg16, float arg17, float arg18, long arg19, int arg21, boolean arg22) {
            super();
            this.name = arg14;
            this.defaultWidth = arg15;
            this.defaultHeight = arg16;
            this.viewportWidth = arg17;
            this.viewportHeight = arg18;
            this.tintColor = arg19;
            this.tintBlendMode = arg21;
            this.autoMirror = arg22;
            ArrayList v14 = new ArrayList();
            this.nodes = v14;
            GroupParams v0 = new GroupParams(null, 0f, 0f, 0f, 0f, 0f, 0f, 0f, null, null, 0x3FF, null);
            this.root = v0;
            ImageVectorKt.access$push(v14, v0);
        }

        public final Builder addGroup(String arg14, float arg15, float arg16, float arg17, float arg18, float arg19, float arg20, float arg21, List arg22) {
            this.ensureNotConsumed();
            ImageVectorKt.access$push(this.nodes, new GroupParams(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, null, 0x200, null));
            return this;
        }

        public static Builder addGroup$default(Builder arg2, String arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, List arg11, int arg12, Object arg13) {
            if((arg12 & 1) != 0) {
                arg3 = "";
            }

            float v1 = 1f;
            if((arg12 & 16) != 0) {
                arg7 = v1;
            }

            if((arg12 & 0x20) != 0) {
                arg8 = v1;
            }

            if((arg12 & 0x100) != 0) {
                arg11 = VectorKt.getEmptyPath();
            }

            return arg2.addGroup(arg3, 0f, 0f, 0f, arg7, arg8, 0f, 0f, arg11);
        }

        public final Builder addPath-oIyEayM(List arg18, int arg19, String arg20, Brush arg21, float arg22, Brush arg23, float arg24, float arg25, int arg26, int arg27, float arg28, float arg29, float arg30, float arg31) {
            this.ensureNotConsumed();
            this.getCurrentGroup().getChildren().add(new VectorPath(arg20, arg18, arg19, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, null));
            return this;
        }

        public static Builder addPath-oIyEayM$default(Builder arg15, List arg16, int arg17, String arg18, Brush arg19, float arg20, Brush arg21, float arg22, float arg23, int arg24, int arg25, float arg26, float arg27, float arg28, float arg29, int arg30, Object arg31) {
            int v0 = arg30;
            int v1 = (v0 & 2) != 0 ? VectorKt.getDefaultFillType() : arg17;
            String v2 = (v0 & 4) != 0 ? "" : arg18;
            Brush v4 = null;
            Brush v3 = (v0 & 8) != 0 ? v4 : arg19;
            float v6 = 1f;
            float v5 = (v0 & 16) != 0 ? v6 : arg20;
            if((v0 & 0x20) != 0) {
            }
            else {
                v4 = arg21;
            }

            float v7 = (v0 & 0x40) != 0 ? v6 : arg22;
            float v8 = (v0 & 0x80) != 0 ? 0f : arg23;
            int v10 = (v0 & 0x100) != 0 ? VectorKt.getDefaultStrokeLineCap() : arg24;
            int v11 = (v0 & 0x200) != 0 ? VectorKt.getDefaultStrokeLineJoin() : arg25;
            float v12 = (v0 & 0x400) != 0 ? 4f : arg26;
            float v13 = (v0 & 0x800) != 0 ? 0f : arg27;
            if((v0 & 0x1000) != 0) {
            }
            else {
                v6 = arg28;
            }

            float v31 = (v0 & 0x2000) != 0 ? 0f : arg29;
            return arg15.addPath-oIyEayM(arg16, v1, v2, v3, v5, v4, v7, v8, v10, v11, v12, v13, v6, v31);
        }

        private final VectorGroup asVectorGroup(GroupParams arg12) {
            return new VectorGroup(arg12.getName(), arg12.getRotate(), arg12.getPivotX(), arg12.getPivotY(), arg12.getScaleX(), arg12.getScaleY(), arg12.getTranslationX(), arg12.getTranslationY(), arg12.getClipPathData(), arg12.getChildren());
        }

        public final ImageVector build() {
            Builder v0 = this;
            v0.ensureNotConsumed();
            while(v0.nodes.size() > 1) {
                v0.clearGroup();
            }

            ImageVector v3 = new ImageVector(v0.name, v0.defaultWidth, v0.defaultHeight, v0.viewportWidth, v0.viewportHeight, v0.asVectorGroup(v0.root), v0.tintColor, v0.tintBlendMode, v0.autoMirror, 0, 0x200, null);
            v0.isConsumed = true;
            return v3;
        }

        public final Builder clearGroup() {
            this.ensureNotConsumed();
            this.getCurrentGroup().getChildren().add(this.asVectorGroup(ImageVectorKt.access$pop(this.nodes)));
            return this;
        }

        private final void ensureNotConsumed() {
            if(this.isConsumed) {
                InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
        }

        private final GroupParams getCurrentGroup() {
            return ImageVectorKt.access$peek(this.nodes);
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00060\u0001j\u0002`\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000B"}, d2={"Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "", "<init>", "()V", "imageVectorCount", "", "lock", "Landroidx/compose/ui/platform/SynchronizedObject;", "Ljava/lang/Object;", "generateImageVectorId", "generateImageVectorId$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int generateImageVectorId$ui() {
            int v0_1;
            Object v2 = ImageVector.lock;
            __monitor_enter(v2);
            try {
                v0_1 = ImageVector.imageVectorCount;
                ImageVector.imageVectorCount = v0_1 + 1;
            }
            catch(Throwable v0) {
                __monitor_exit(v2);
                throw v0;
            }

            __monitor_exit(v2);
            return v0_1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final boolean autoMirror;
    private final float defaultHeight;
    private final float defaultWidth;
    private final int genId;
    private static int imageVectorCount;
    private static final Object lock;
    private final String name;
    private final VectorGroup root;
    private final int tintBlendMode;
    private final long tintColor;
    private final float viewportHeight;
    private final float viewportWidth;

    static {
        Companion v0 = new Companion(null);
        ImageVector.Companion = v0;
        ImageVector.lock = v0;
    }

    private ImageVector(String arg1, float arg2, float arg3, float arg4, float arg5, VectorGroup arg6, long arg7, int arg9, boolean arg10, int arg11) {
        super();
        this.name = arg1;
        this.defaultWidth = arg2;
        this.defaultHeight = arg3;
        this.viewportWidth = arg4;
        this.viewportHeight = arg5;
        this.root = arg6;
        this.tintColor = arg7;
        this.tintBlendMode = arg9;
        this.autoMirror = arg10;
        this.genId = arg11;
    }

    public ImageVector(String arg15, float arg16, float arg17, float arg18, float arg19, VectorGroup arg20, long arg21, int arg23, boolean arg24, int arg25, int arg26, DefaultConstructorMarker arg27) {
        int v12 = (arg26 & 0x200) != 0 ? ImageVector.Companion.generateImageVectorId$ui() : arg25;
        this(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg23, arg24, v12, null);
    }

    public ImageVector(String arg1, float arg2, float arg3, float arg4, float arg5, VectorGroup arg6, long arg7, int arg9, boolean arg10, int arg11, DefaultConstructorMarker arg12) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg9, arg10, arg11);
    }

    public static final int access$getImageVectorCount$cp() {
        return ImageVector.imageVectorCount;
    }

    public static final Object access$getLock$cp() {
        return ImageVector.lock;
    }

    public static final void access$setImageVectorCount$cp(int arg0) {
        ImageVector.imageVectorCount = arg0;
    }

    public boolean equals(Object arg8) {
        if(this == (((ImageVector)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof ImageVector)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.name, ((ImageVector)arg8).name)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.defaultWidth, ((ImageVector)arg8).defaultWidth)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.defaultHeight, ((ImageVector)arg8).defaultHeight)) {
            return 0;
        }

        if(this.viewportWidth == ((ImageVector)arg8).viewportWidth && this.viewportHeight == ((ImageVector)arg8).viewportHeight) {
            if(!Intrinsics.areEqual(this.root, ((ImageVector)arg8).root)) {
                return 0;
            }
            else if(!Color.equals-impl0(this.tintColor, ((ImageVector)arg8).tintColor)) {
                return 0;
            }
            else if(!BlendMode.equals-impl0(this.tintBlendMode, ((ImageVector)arg8).tintBlendMode)) {
                return 0;
            }
            else if(this.autoMirror != ((ImageVector)arg8).autoMirror) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final boolean getAutoMirror() {
        return this.autoMirror;
    }

    public final float getDefaultHeight-D9Ej5fM() {
        return this.defaultHeight;
    }

    public final float getDefaultWidth-D9Ej5fM() {
        return this.defaultWidth;
    }

    public final int getGenId$ui() {
        return this.genId;
    }

    public final String getName() {
        return this.name;
    }

    public final VectorGroup getRoot() {
        return this.root;
    }

    public final int getTintBlendMode-0nO6VwU() {
        return this.tintBlendMode;
    }

    public final long getTintColor-0d7_KjU() {
        return this.tintColor;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 0x1F + Dp.hashCode-impl(this.defaultWidth)) * 0x1F + Dp.hashCode-impl(this.defaultHeight)) * 0x1F + Float.hashCode(this.viewportWidth)) * 0x1F + Float.hashCode(this.viewportHeight)) * 0x1F + this.root.hashCode()) * 0x1F + Color.hashCode-impl(this.tintColor)) * 0x1F + BlendMode.hashCode-impl(this.tintBlendMode)) * 0x1F + Boolean.hashCode(this.autoMirror);
    }
}

