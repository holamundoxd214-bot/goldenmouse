package androidx.compose.ui.layout;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R+\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00078V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR+\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00078V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\r\u001A\u0004\b\u000E\u0010\t\"\u0004\b\u000F\u0010\u000BR+\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0006\u001A\u00020\u00118V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0006\u001A\u00020\u00198V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u001F\u0010 \u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER+\u0010!\u001A\u00020\u00112\u0006\u0010\u0006\u001A\u00020\u00118V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001A\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u0014\u0010%\u001A\u00020&X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010(R\u0014\u0010)\u001A\u00020&X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b*\u0010(R\u001C\u0010+\u001A\u00020,X\u0086\u000E¢\u0006\u0010\n\u0002\u0010/\u001A\u0004\b-\u0010\u001C\"\u0004\b.\u0010\u001ER\u001C\u00100\u001A\u00020,X\u0086\u000E¢\u0006\u0010\n\u0002\u0010/\u001A\u0004\b1\u0010\u001C\"\u0004\b2\u0010\u001ER\u001C\u00103\u001A\u00020,X\u0086\u000E¢\u0006\u0010\n\u0002\u0010/\u001A\u0004\b4\u0010\u001C\"\u0004\b5\u0010\u001ER\u001C\u00106\u001A\u00020,X\u0086\u000E¢\u0006\u0010\n\u0002\u0010/\u001A\u0004\b7\u0010\u001C\"\u0004\b8\u0010\u001E¨\u00069"}, d2={"Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "Landroidx/compose/ui/layout/PlatformWindowInsetsAnimation;", "name", "", "<init>", "(Ljava/lang/String;)V", "<set-?>", "", "isVisible", "()Z", "setVisible", "(Z)V", "isVisible$delegate", "Landroidx/compose/runtime/MutableState;", "isAnimating", "setAnimating", "isAnimating$delegate", "", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "", "durationMillis", "getDurationMillis", "()J", "setDurationMillis", "(J)V", "durationMillis$delegate", "Landroidx/compose/runtime/MutableLongState;", "alpha", "getAlpha", "setAlpha", "alpha$delegate", "source", "Landroidx/compose/ui/layout/RectRulers;", "getSource", "()Landroidx/compose/ui/layout/RectRulers;", "target", "getTarget", "current", "Landroidx/compose/ui/layout/ValueInsets;", "getCurrent-hdzbrEE", "setCurrent-Ynlvx88", "J", "maximum", "getMaximum-hdzbrEE", "setMaximum-Ynlvx88", "sourceValueInsets", "getSourceValueInsets-hdzbrEE", "setSourceValueInsets-Ynlvx88", "targetValueInsets", "getTargetValueInsets-hdzbrEE", "setTargetValueInsets-Ynlvx88", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowWindowInsetsAnimationValues implements PlatformWindowInsetsAnimation {
    public static final int $stable = 8;
    private final MutableFloatState alpha$delegate;
    private long current;
    private final MutableLongState durationMillis$delegate;
    private final MutableFloatState fraction$delegate;
    private final MutableState isAnimating$delegate;
    private final MutableState isVisible$delegate;
    private long maximum;
    private final RectRulers source;
    private long sourceValueInsets;
    private final RectRulers target;
    private long targetValueInsets;

    static {
    }

    public WindowWindowInsetsAnimationValues(String arg4) {
        super();
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
        this.isAnimating$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.fraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0f);
        this.durationMillis$delegate = SnapshotLongStateKt.mutableLongStateOf(0);
        this.alpha$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(1f);
        this.source = RectRulersKt.RectRulers(arg4 + " source");
        this.target = RectRulersKt.RectRulers(arg4 + " target");
        this.current = ValueInsets_androidKt.getUnsetValueInsets();
        this.maximum = ValueInsets_androidKt.getUnsetValueInsets();
        this.sourceValueInsets = ValueInsets_androidKt.getUnsetValueInsets();
        this.targetValueInsets = ValueInsets_androidKt.getUnsetValueInsets();
    }

    public float getAlpha() {
        return this.alpha$delegate.getFloatValue();
    }

    public final long getCurrent-hdzbrEE() {
        return this.current;
    }

    public long getDurationMillis() {
        return this.durationMillis$delegate.getLongValue();
    }

    public float getFraction() {
        return this.fraction$delegate.getFloatValue();
    }

    public final long getMaximum-hdzbrEE() {
        return this.maximum;
    }

    public RectRulers getSource() {
        return this.source;
    }

    public final long getSourceValueInsets-hdzbrEE() {
        return this.sourceValueInsets;
    }

    public RectRulers getTarget() {
        return this.target;
    }

    public final long getTargetValueInsets-hdzbrEE() {
        return this.targetValueInsets;
    }

    public boolean isAnimating() {
        return this.isAnimating$delegate.getValue().booleanValue();
    }

    public boolean isVisible() {
        return this.isVisible$delegate.getValue().booleanValue();
    }

    public void setAlpha(float arg1) {
        this.alpha$delegate.setFloatValue(arg1);
    }

    public void setAnimating(boolean arg1) {
        this.isAnimating$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setCurrent-Ynlvx88(long arg1) {
        this.current = arg1;
    }

    public void setDurationMillis(long arg1) {
        this.durationMillis$delegate.setLongValue(arg1);
    }

    public void setFraction(float arg1) {
        this.fraction$delegate.setFloatValue(arg1);
    }

    public final void setMaximum-Ynlvx88(long arg1) {
        this.maximum = arg1;
    }

    public final void setSourceValueInsets-Ynlvx88(long arg1) {
        this.sourceValueInsets = arg1;
    }

    public final void setTargetValueInsets-Ynlvx88(long arg1) {
        this.targetValueInsets = arg1;
    }

    public void setVisible(boolean arg1) {
        this.isVisible$delegate.setValue(Boolean.valueOf(arg1));
    }
}

