package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001A\u00020\u0012H\u0002J\u0010\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0015H\u0002J\u000E\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0006\u001A\u00020\u0007J\u001B\u0010\u0017\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002J%\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002J/\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002J9\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002JC\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002JM\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002JW\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002Ja\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002Jk\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002Ju\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0003H\u0096\u0002J\u0087\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\b\u0010#\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0003H\u0096\u0002J\u0091\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\b\u0010#\u001A\u0004\u0018\u00010\u00072\b\u0010%\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0003H\u0096\u0002J\u009B\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\b\u0010#\u001A\u0004\u0018\u00010\u00072\b\u0010%\u001A\u0004\u0018\u00010\u00072\b\u0010&\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0003H\u0096\u0002J¥\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\b\u0010#\u001A\u0004\u0018\u00010\u00072\b\u0010%\u001A\u0004\u0018\u00010\u00072\b\u0010&\u001A\u0004\u0018\u00010\u00072\b\u0010\'\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0003H\u0096\u0002J¯\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\b\u0010#\u001A\u0004\u0018\u00010\u00072\b\u0010%\u001A\u0004\u0018\u00010\u00072\b\u0010&\u001A\u0004\u0018\u00010\u00072\b\u0010\'\u001A\u0004\u0018\u00010\u00072\b\u0010(\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0003H\u0096\u0002J¹\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\b\u0010#\u001A\u0004\u0018\u00010\u00072\b\u0010%\u001A\u0004\u0018\u00010\u00072\b\u0010&\u001A\u0004\u0018\u00010\u00072\b\u0010\'\u001A\u0004\u0018\u00010\u00072\b\u0010(\u001A\u0004\u0018\u00010\u00072\b\u0010)\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0003H\u0096\u0002JÃ\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\b\u0010#\u001A\u0004\u0018\u00010\u00072\b\u0010%\u001A\u0004\u0018\u00010\u00072\b\u0010&\u001A\u0004\u0018\u00010\u00072\b\u0010\'\u001A\u0004\u0018\u00010\u00072\b\u0010(\u001A\u0004\u0018\u00010\u00072\b\u0010)\u001A\u0004\u0018\u00010\u00072\b\u0010*\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0003H\u0096\u0002JÍ\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\b\u0010#\u001A\u0004\u0018\u00010\u00072\b\u0010%\u001A\u0004\u0018\u00010\u00072\b\u0010&\u001A\u0004\u0018\u00010\u00072\b\u0010\'\u001A\u0004\u0018\u00010\u00072\b\u0010(\u001A\u0004\u0018\u00010\u00072\b\u0010)\u001A\u0004\u0018\u00010\u00072\b\u0010*\u001A\u0004\u0018\u00010\u00072\b\u0010+\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0003H\u0096\u0002J×\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u001A\u001A\u0004\u0018\u00010\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u00072\b\u0010\u001C\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00072\b\u0010\u001E\u001A\u0004\u0018\u00010\u00072\b\u0010\u001F\u001A\u0004\u0018\u00010\u00072\b\u0010 \u001A\u0004\u0018\u00010\u00072\b\u0010!\u001A\u0004\u0018\u00010\u00072\b\u0010\"\u001A\u0004\u0018\u00010\u00072\b\u0010#\u001A\u0004\u0018\u00010\u00072\b\u0010%\u001A\u0004\u0018\u00010\u00072\b\u0010&\u001A\u0004\u0018\u00010\u00072\b\u0010\'\u001A\u0004\u0018\u00010\u00072\b\u0010(\u001A\u0004\u0018\u00010\u00072\b\u0010)\u001A\u0004\u0018\u00010\u00072\b\u0010*\u001A\u0004\u0018\u00010\u00072\b\u0010+\u001A\u0004\u0018\u00010\u00072\b\u0010,\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0003H\u0096\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006-"}, d2={"Landroidx/compose/runtime/internal/ComposableLambdaImpl;", "Landroidx/compose/runtime/internal/ComposableLambda;", "key", "", "tracked", "", "block", "", "<init>", "(IZLjava/lang/Object;)V", "getKey", "()I", "_block", "scope", "Landroidx/compose/runtime/RecomposeScope;", "scopes", "", "trackWrite", "", "trackRead", "composer", "Landroidx/compose/runtime/Composer;", "update", "invoke", "c", "changed", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "changed1", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComposableLambdaImpl implements ComposableLambda {
    public static final int $stable;
    private Object _block;
    private final int key;
    private RecomposeScope scope;
    private List scopes;
    private final boolean tracked;

    static {
    }

    public ComposableLambdaImpl(int arg1, boolean arg2, Object arg3) {
        super();
        this.key = arg1;
        this.tracked = arg2;
        this._block = arg3;
    }

    public final int getKey() {
        return this.key;
    }

    public Object invoke(Object arg4, Composer arg5, int arg6) {
        arg5 = arg5.startRestartGroup(this.key);
        this.trackRead(arg5);
        int v0 = arg5.changed(this) ? ComposableLambdaKt.differentBits(1) : ComposableLambdaKt.sameBits(1);
        Object v1 = this._block;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v0_1 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3).invoke(arg4, arg5, Integer.valueOf(v0 | arg6));
        ScopeUpdateScope v5 = arg5.endRestartGroup();
        if(v5 != null) {
            v5.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda16(this, arg4, arg6));
        }

        return v0_1;
    }

    public Object invoke(Object arg4, Object arg5, Composer arg6, int arg7) {
        arg6 = arg6.startRestartGroup(this.key);
        this.trackRead(arg6);
        int v1 = 2;
        int v0 = arg6.changed(this) ? ComposableLambdaKt.differentBits(v1) : ComposableLambdaKt.sameBits(v1);
        Object v1_1 = this._block;
        Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type kotlin.Function4<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v0_1 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1_1, 4).invoke(arg4, arg5, arg6, Integer.valueOf(v0 | arg7));
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda12(this, arg4, arg5, arg7));
        }

        return v0_1;
    }

    public Object invoke(Object arg18, Object arg19, Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Composer arg29, int arg30, int arg31) {
        ComposableLambdaImpl v1 = this;
        Composer v14 = arg29.startRestartGroup(v1.key);
        v1.trackRead(v14);
        int v2 = 11;
        int v0 = v14.changed(v1) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = v1._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function14<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object v15 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 14).invoke(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, v14, Integer.valueOf(arg30), Integer.valueOf(arg31 | v0));
        ScopeUpdateScope v0_1 = v14.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda15(v1, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg30, arg31));
            return v15;
        }

        return v15;
    }

    public Object invoke(Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Composer arg32, int arg33, int arg34) {
        ComposableLambdaImpl v1 = this;
        Composer v15 = arg32.startRestartGroup(v1.key);
        v1.trackRead(v15);
        int v2 = 12;
        int v0 = v15.changed(v1) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = v1._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function15<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object v16 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 15).invoke(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, v15, Integer.valueOf(arg33), Integer.valueOf(arg34 | v0));
        ScopeUpdateScope v0_1 = v15.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda9(v1, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg33, arg34));
        }

        return v16;
    }

    public Object invoke(Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Composer arg34, int arg35, int arg36) {
        ComposableLambdaImpl v1 = this;
        Composer v0 = arg34.startRestartGroup(v1.key);
        v1.trackRead(v0);
        int v3 = 13;
        int v2 = v0.changed(v1) ? ComposableLambdaKt.differentBits(v3) : ComposableLambdaKt.sameBits(v3);
        Object v3_1 = v1._block;
        Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Function16<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object v17 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3_1, 16).invoke(arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, v0, Integer.valueOf(arg35), Integer.valueOf(arg36 | v2));
        ScopeUpdateScope v0_1 = v0.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda0(v1, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg35, arg36));
        }

        return v17;
    }

    public Object invoke(Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Composer arg36, int arg37, int arg38) {
        ComposableLambdaImpl v1 = this;
        Composer v0 = arg36.startRestartGroup(v1.key);
        v1.trackRead(v0);
        int v3 = 14;
        int v2 = v0.changed(v1) ? ComposableLambdaKt.differentBits(v3) : ComposableLambdaKt.sameBits(v3);
        Object v3_1 = v1._block;
        Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Function17<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object v18 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3_1, 17).invoke(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, v0, Integer.valueOf(arg37), Integer.valueOf(arg38 | v2));
        ScopeUpdateScope v0_1 = v0.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda1(v1, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38));
        }

        return v18;
    }

    public Object invoke(Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Composer arg38, int arg39, int arg40) {
        ComposableLambdaImpl v1 = this;
        Composer v0 = arg38.startRestartGroup(v1.key);
        v1.trackRead(v0);
        int v3 = 15;
        int v2 = v0.changed(v1) ? ComposableLambdaKt.differentBits(v3) : ComposableLambdaKt.sameBits(v3);
        Object v3_1 = v1._block;
        Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Function18<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"p15\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object v19 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3_1, 18).invoke(arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, v0, Integer.valueOf(arg39), Integer.valueOf(arg40 | v2));
        ScopeUpdateScope v0_1 = v0.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda11(v1, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg39, arg40));
        }

        return v19;
    }

    public Object invoke(Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Object arg38, Object arg39, Composer arg40, int arg41, int arg42) {
        ComposableLambdaImpl v1 = this;
        Composer v0 = arg40.startRestartGroup(v1.key);
        v1.trackRead(v0);
        int v3 = 16;
        int v2 = v0.changed(v1) ? ComposableLambdaKt.differentBits(v3) : ComposableLambdaKt.sameBits(v3);
        Object v3_1 = v1._block;
        Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Function19<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"p15\")] kotlin.Any?, @[ParameterName(name = \"p16\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object v20 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3_1, 19).invoke(arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, v0, Integer.valueOf(arg41), Integer.valueOf(arg42 | v2));
        ScopeUpdateScope v0_1 = v0.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda4(v1, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg41, arg42));
        }

        return v20;
    }

    public Object invoke(Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Object arg38, Object arg39, Object arg40, Object arg41, Composer arg42, int arg43, int arg44) {
        ComposableLambdaImpl v1 = this;
        Composer v0 = arg42.startRestartGroup(v1.key);
        v1.trackRead(v0);
        int v3 = 17;
        int v2 = v0.changed(v1) ? ComposableLambdaKt.differentBits(v3) : ComposableLambdaKt.sameBits(v3);
        Object v3_1 = v1._block;
        Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Function20<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"p15\")] kotlin.Any?, @[ParameterName(name = \"p16\")] kotlin.Any?, @[ParameterName(name = \"p17\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object v21 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3_1, 20).invoke(arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, v0, Integer.valueOf(arg43), Integer.valueOf(arg44 | v2));
        ScopeUpdateScope v0_1 = v0.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda7(v1, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg43, arg44));
        }

        return v21;
    }

    public Object invoke(Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Object arg38, Object arg39, Object arg40, Object arg41, Object arg42, Object arg43, Composer arg44, int arg45, int arg46) {
        ComposableLambdaImpl v1 = this;
        Composer v0 = arg44.startRestartGroup(v1.key);
        v1.trackRead(v0);
        int v3 = 18;
        int v2 = v0.changed(v1) ? ComposableLambdaKt.differentBits(v3) : ComposableLambdaKt.sameBits(v3);
        Object v3_1 = v1._block;
        Intrinsics.checkNotNull(v3_1, "null cannot be cast to non-null type kotlin.Function21<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"p11\")] kotlin.Any?, @[ParameterName(name = \"p12\")] kotlin.Any?, @[ParameterName(name = \"p13\")] kotlin.Any?, @[ParameterName(name = \"p14\")] kotlin.Any?, @[ParameterName(name = \"p15\")] kotlin.Any?, @[ParameterName(name = \"p16\")] kotlin.Any?, @[ParameterName(name = \"p17\")] kotlin.Any?, @[ParameterName(name = \"p18\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object v22 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3_1, 21).invoke(arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, v0, Integer.valueOf(arg45), Integer.valueOf(arg46 | v2));
        ScopeUpdateScope v0_1 = v0.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda14(v1, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg45, arg46));
        }

        return v22;
    }

    public Object invoke(Object arg9, Object arg10, Object arg11, Composer arg12, int arg13) {
        Composer v6 = arg12.startRestartGroup(this.key);
        this.trackRead(v6);
        int v2 = 3;
        int v0 = v6.changed(this) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = this._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function5<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v7 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 5).invoke(arg9, arg10, arg11, v6, Integer.valueOf(v0 | arg13));
        ScopeUpdateScope v6_1 = v6.endRestartGroup();
        if(v6_1 != null) {
            v6_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda13(this, arg9, arg10, arg11, arg13));
        }

        return v7;
    }

    public Object invoke(Object arg10, Object arg11, Object arg12, Object arg13, Composer arg14, int arg15) {
        Composer v7 = arg14.startRestartGroup(this.key);
        this.trackRead(v7);
        int v2 = 4;
        int v0 = v7.changed(this) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = this._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function6<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v8 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 6).invoke(arg10, arg11, arg12, arg13, v7, Integer.valueOf(v0 | arg15));
        ScopeUpdateScope v7_1 = v7.endRestartGroup();
        if(v7_1 != null) {
            v7_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda5(this, arg10, arg11, arg12, arg13, arg15));
        }

        return v8;
    }

    public Object invoke(Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Composer arg16, int arg17) {
        Composer v8 = arg16.startRestartGroup(this.key);
        this.trackRead(v8);
        int v2 = 5;
        int v0 = v8.changed(this) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = this._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function7<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v9 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 7).invoke(arg11, arg12, arg13, arg14, arg15, v8, Integer.valueOf(arg17 | v0));
        ScopeUpdateScope v8_1 = v8.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda17(this, arg11, arg12, arg13, arg14, arg15, arg17));
        }

        return v9;
    }

    public Object invoke(Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Composer arg18, int arg19) {
        Composer v9 = arg18.startRestartGroup(this.key);
        this.trackRead(v9);
        int v2 = 6;
        int v0 = v9.changed(this) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = this._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function8<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v10 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 8).invoke(arg12, arg13, arg14, arg15, arg16, arg17, v9, Integer.valueOf(arg19 | v0));
        ScopeUpdateScope v9_1 = v9.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda8(this, arg12, arg13, arg14, arg15, arg16, arg17, arg19));
        }

        return v10;
    }

    public Object invoke(Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Composer arg20, int arg21) {
        Composer v10 = arg20.startRestartGroup(this.key);
        this.trackRead(v10);
        int v2 = 7;
        int v0 = v10.changed(this) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = this._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function9<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v11 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 9).invoke(arg13, arg14, arg15, arg16, arg17, arg18, arg19, v10, Integer.valueOf(arg21 | v0));
        ScopeUpdateScope v10_1 = v10.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda6(this, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg21));
        }

        return v11;
    }

    public Object invoke(Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20, Object arg21, Composer arg22, int arg23) {
        Composer v11 = arg22.startRestartGroup(this.key);
        this.trackRead(v11);
        int v2 = 8;
        int v0 = v11.changed(this) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = this._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function10<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v12 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 10).invoke(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, v11, Integer.valueOf(arg23 | v0));
        ScopeUpdateScope v11_1 = v11.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda10(this, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg23));
        }

        return v12;
    }

    public Object invoke(Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20, Object arg21, Object arg22, Object arg23, Composer arg24, int arg25) {
        Composer v12 = arg24.startRestartGroup(this.key);
        this.trackRead(v12);
        int v2 = 9;
        int v0 = v12.changed(this) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = this._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function11<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v13 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 11).invoke(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, v12, Integer.valueOf(arg25 | v0));
        ScopeUpdateScope v12_1 = v12.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda2(this, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg25));
        }

        return v13;
    }

    public Object invoke(Object arg17, Object arg18, Object arg19, Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Composer arg27, int arg28, int arg29) {
        ComposableLambdaImpl v1 = this;
        Composer v13 = arg27.startRestartGroup(v1.key);
        v1.trackRead(v13);
        int v2 = 10;
        int v0 = v13.changed(v1) ? ComposableLambdaKt.differentBits(v2) : ComposableLambdaKt.sameBits(v2);
        Object v2_1 = v1._block;
        Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type kotlin.Function13<@[ParameterName(name = \"p1\")] kotlin.Any?, @[ParameterName(name = \"p2\")] kotlin.Any?, @[ParameterName(name = \"p3\")] kotlin.Any?, @[ParameterName(name = \"p4\")] kotlin.Any?, @[ParameterName(name = \"p5\")] kotlin.Any?, @[ParameterName(name = \"p6\")] kotlin.Any?, @[ParameterName(name = \"p7\")] kotlin.Any?, @[ParameterName(name = \"p8\")] kotlin.Any?, @[ParameterName(name = \"p9\")] kotlin.Any?, @[ParameterName(name = \"p10\")] kotlin.Any?, @[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, @[ParameterName(name = \"changed1\")] kotlin.Int, kotlin.Any?>");
        Object v14 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v2_1, 13).invoke(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, v13, Integer.valueOf(arg28), Integer.valueOf(arg29 | v0));
        ScopeUpdateScope v13_1 = v13.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new ComposableLambdaImpl$$ExternalSyntheticLambda3(v1, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg28));
        }

        return v14;
    }

    public Object invoke(Composer arg3, int arg4) {
        arg3 = arg3.startRestartGroup(this.key);
        this.trackRead(arg3);
        int v0 = arg3.changed(this) ? ComposableLambdaKt.differentBits(0) : ComposableLambdaKt.sameBits(0);
        arg4 |= v0;
        Object v0_1 = this._block;
        Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = \"c\")] androidx.compose.runtime.Composer, @[ParameterName(name = \"changed\")] kotlin.Int, kotlin.Any?>");
        Object v4 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v0_1, 2).invoke(arg3, Integer.valueOf(arg4));
        ScopeUpdateScope v3 = arg3.endRestartGroup();
        if(v3 != null) {
            v3.updateScope(new ComposableLambdaImpl$invoke$1(this));
        }

        return v4;
    }

    public Object invoke(Object arg1, Object arg2) {
        return this.invoke(((Composer)arg1), ((Number)arg2).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3) {
        return this.invoke(arg1, ((Composer)arg2), ((Number)arg3).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) {
        return this.invoke(arg1, arg2, ((Composer)arg3), ((Number)arg4).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        return this.invoke(arg1, arg2, arg3, ((Composer)arg4), ((Number)arg5).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
        return this.invoke(arg1, arg2, arg3, arg4, ((Composer)arg5), ((Number)arg6).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
        return this.invoke(arg1, arg2, arg3, arg4, arg5, ((Composer)arg6), ((Number)arg7).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8) {
        return this.invoke(arg1, arg2, arg3, arg4, arg5, arg6, ((Composer)arg7), ((Number)arg8).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9) {
        return this.invoke(arg1, arg2, arg3, arg4, arg5, arg6, arg7, ((Composer)arg8), ((Number)arg9).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10) {
        return this.invoke(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, ((Composer)arg9), ((Number)arg10).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11) {
        return this.invoke(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, ((Composer)arg10), ((Number)arg11).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13) {
        return this.invoke(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, ((Composer)arg11), ((Number)arg12).intValue(), ((Number)arg13).intValue());
    }

    public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14) {
        return this.invoke(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, ((Composer)arg12), ((Number)arg13).intValue(), ((Number)arg14).intValue());
    }

    public Object invoke(Object arg18, Object arg19, Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32) {
        return this.invoke(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31.intValue(), arg32.intValue());
    }

    public Object invoke(Object arg19, Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34) {
        return this.invoke(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33.intValue(), arg34.intValue());
    }

    public Object invoke(Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36) {
        return this.invoke(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35.intValue(), arg36.intValue());
    }

    public Object invoke(Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Object arg38) {
        return this.invoke(arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37.intValue(), arg38.intValue());
    }

    public Object invoke(Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Object arg38, Object arg39, Object arg40) {
        return this.invoke(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39.intValue(), arg40.intValue());
    }

    public Object invoke(Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Object arg38, Object arg39, Object arg40, Object arg41, Object arg42) {
        return this.invoke(arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41.intValue(), arg42.intValue());
    }

    public Object invoke(Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Object arg38, Object arg39, Object arg40, Object arg41, Object arg42, Object arg43, Object arg44) {
        return this.invoke(arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43.intValue(), arg44.intValue());
    }

    static final Unit invoke$lambda$0(ComposableLambdaImpl arg0, Object arg1, int arg2, Composer arg3, int arg4) {
        arg0.invoke(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2) | 1);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$1(ComposableLambdaImpl arg0, Object arg1, Object arg2, int arg3, Composer arg4, int arg5) {
        arg0.invoke(arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3) | 1);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$10(ComposableLambdaImpl arg16, Object arg17, Object arg18, Object arg19, Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, int arg28, int arg29, Composer arg30, int arg31) {
        arg16.invoke(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28) | 1, RecomposeScopeImplKt.updateChangedFlags(arg29));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$11(ComposableLambdaImpl arg17, Object arg18, Object arg19, Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, int arg30, int arg31, Composer arg32, int arg33) {
        arg17.invoke(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg32, RecomposeScopeImplKt.updateChangedFlags(arg30) | 1, RecomposeScopeImplKt.updateChangedFlags(arg31));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$12(ComposableLambdaImpl arg18, Object arg19, Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, int arg32, int arg33, Composer arg34, int arg35) {
        arg18.invoke(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg34, RecomposeScopeImplKt.updateChangedFlags(arg32) | 1, RecomposeScopeImplKt.updateChangedFlags(arg33));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$13(ComposableLambdaImpl arg19, Object arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, int arg34, int arg35, Composer arg36, int arg37) {
        arg19.invoke(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg36, RecomposeScopeImplKt.updateChangedFlags(arg34) | 1, RecomposeScopeImplKt.updateChangedFlags(arg35));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$14(ComposableLambdaImpl arg20, Object arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, int arg36, int arg37, Composer arg38, int arg39) {
        arg20.invoke(arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg38, RecomposeScopeImplKt.updateChangedFlags(arg36) | 1, RecomposeScopeImplKt.updateChangedFlags(arg37));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$15(ComposableLambdaImpl arg21, Object arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, int arg38, int arg39, Composer arg40, int arg41) {
        arg21.invoke(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg40, RecomposeScopeImplKt.updateChangedFlags(arg38) | 1, RecomposeScopeImplKt.updateChangedFlags(arg39));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$16(ComposableLambdaImpl arg22, Object arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Object arg38, Object arg39, int arg40, int arg41, Composer arg42, int arg43) {
        arg22.invoke(arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg42, RecomposeScopeImplKt.updateChangedFlags(arg40) | 1, RecomposeScopeImplKt.updateChangedFlags(arg41));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$17(ComposableLambdaImpl arg23, Object arg24, Object arg25, Object arg26, Object arg27, Object arg28, Object arg29, Object arg30, Object arg31, Object arg32, Object arg33, Object arg34, Object arg35, Object arg36, Object arg37, Object arg38, Object arg39, Object arg40, Object arg41, int arg42, int arg43, Composer arg44, int arg45) {
        arg23.invoke(arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg44, RecomposeScopeImplKt.updateChangedFlags(arg42) | 1, RecomposeScopeImplKt.updateChangedFlags(arg43));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$2(ComposableLambdaImpl arg6, Object arg7, Object arg8, Object arg9, int arg10, Composer arg11, int arg12) {
        arg6.invoke(arg7, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10) | 1);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$3(ComposableLambdaImpl arg7, Object arg8, Object arg9, Object arg10, Object arg11, int arg12, Composer arg13, int arg14) {
        arg7.invoke(arg8, arg9, arg10, arg11, arg13, RecomposeScopeImplKt.updateChangedFlags(arg12) | 1);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$4(ComposableLambdaImpl arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, int arg14, Composer arg15, int arg16) {
        arg8.invoke(arg9, arg10, arg11, arg12, arg13, arg15, RecomposeScopeImplKt.updateChangedFlags(arg14) | 1);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$5(ComposableLambdaImpl arg10, Object arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, int arg17, Composer arg18, int arg19) {
        arg10.invoke(arg11, arg12, arg13, arg14, arg15, arg16, arg18, RecomposeScopeImplKt.updateChangedFlags(arg17) | 1);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$6(ComposableLambdaImpl arg11, Object arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, int arg19, Composer arg20, int arg21) {
        arg11.invoke(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19) | 1);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$7(ComposableLambdaImpl arg12, Object arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20, int arg21, Composer arg22, int arg23) {
        arg12.invoke(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg22, RecomposeScopeImplKt.updateChangedFlags(arg21) | 1);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$8(ComposableLambdaImpl arg13, Object arg14, Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20, Object arg21, Object arg22, int arg23, Composer arg24, int arg25) {
        arg13.invoke(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg24, RecomposeScopeImplKt.updateChangedFlags(arg23) | 1);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$9(ComposableLambdaImpl arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8, Object arg9, Object arg10, int arg11, Composer arg12, int arg13) {
        arg0.invoke(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg11 | 1, arg11);
        return Unit.INSTANCE;
    }

    private final void trackRead(Composer arg4) {
        if(this.tracked) {
            RecomposeScope v0 = arg4.getRecomposeScope();
            if(v0 != null) {
                arg4.recordUsed(v0);
                if(ComposableLambdaKt.replacableWith(this.scope, v0)) {
                    this.scope = v0;
                    return;
                }
                else {
                    List v4 = this.scopes;
                    if(v4 == null) {
                        ArrayList v4_1 = new ArrayList();
                        this.scopes = ((List)v4_1);
                        ((List)v4_1).add(v0);
                        return;
                    }
                    else {
                        int v3 = v4.size();
                        int v1 = 0;
                        while(true) {
                            if(v1 >= v3) {
                                break;
                            }
                            else if(ComposableLambdaKt.replacableWith(v4.get(v1), v0)) {
                                v4.set(v1, v0);
                                return;
                            }
                            else {
                                ++v1;
                                continue;
                            }

                            return;
                        }

                        v4.add(v0);
                    }
                }
            }
        }
    }

    private final void trackWrite() {
        if(this.tracked) {
            RecomposeScope v0 = this.scope;
            if(v0 != null) {
                v0.invalidate();
                this.scope = null;
            }

            List v3 = this.scopes;
            if(v3 == null) {
                return;
            }

            int v0_1 = v3.size();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                v3.get(v1).invalidate();
            }

            v3.clear();
        }
    }

    public final void update(Object arg2) {
        if(!Intrinsics.areEqual(this._block, arg2)) {
            int v0 = this._block == null ? 1 : 0;
            this._block = arg2;
            if(v0 != 0) {
                return;
            }

            this.trackWrite();
        }
    }
}

