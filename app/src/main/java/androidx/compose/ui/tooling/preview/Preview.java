package androidx.compose.ui.tooling.preview;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.jvm.internal.RepeatableContainer;

@Documented @Repeatable(value=Container.class) @Retention(value=RetentionPolicy.CLASS) @Target(value={ElementType.METHOD, ElementType.ANNOTATION_TYPE}) @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0082\u0001\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\b\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0003\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\r\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0006R\u000F\u0010\u0002\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0014R\u000F\u0010\u0004\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0014R\u000F\u0010\u0005\u001A\u00020\u0006¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0015R\u000F\u0010\u0007\u001A\u00020\u0006¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0015R\u000F\u0010\b\u001A\u00020\u0006¢\u0006\u0006\u001A\u0004\b\b\u0010\u0015R\u000F\u0010\t\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\t\u0010\u0014R\u000F\u0010\n\u001A\u00020\u000B¢\u0006\u0006\u001A\u0004\b\n\u0010\u0016R\u000F\u0010\f\u001A\u00020\r¢\u0006\u0006\u001A\u0004\b\f\u0010\u0017R\u000F\u0010\u000E\u001A\u00020\r¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u0017R\u000F\u0010\u000F\u001A\u00020\u0010¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0018R\u000F\u0010\u0011\u001A\u00020\u0006¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0015R\u000F\u0010\u0012\u001A\u00020\u0003¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0014R\u000F\u0010\u0013\u001A\u00020\u0006¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0015¨\u0006\u0019"}, d2={"Landroidx/compose/ui/tooling/preview/Preview;", "", "name", "", "group", "apiLevel", "", "widthDp", "heightDp", "locale", "fontScale", "", "showSystemUi", "", "showBackground", "backgroundColor", "", "uiMode", "device", "wallpaper", "()Ljava/lang/String;", "()I", "()F", "()Z", "()J", "ui-tooling-preview"}, k=1, mv={2, 0, 0}, xi=0x30) @MustBeDocumented @kotlin.annotation.Repeatable @kotlin.annotation.Retention(value=AnnotationRetention.BINARY) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION}) @public interface Preview {
    @Retention(value=RetentionPolicy.CLASS) @Target(value={ElementType.METHOD, ElementType.ANNOTATION_TYPE}) @Metadata(k=3, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.BINARY) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION}) @RepeatableContainer @public interface Container {
        Preview[] value();
    }

    int apiLevel();

    long backgroundColor();

    String device();

    float fontScale();

    String group();

    int heightDp();

    String locale();

    String name();

    boolean showBackground();

    boolean showSystemUi();

    int uiMode();

    int wallpaper();

    int widthDp();
}

