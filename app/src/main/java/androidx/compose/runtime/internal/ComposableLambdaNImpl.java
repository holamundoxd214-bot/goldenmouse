package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0012\u001A\u00020\u0013H\u0002J\u0010\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J\u000E\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0018\u001A\u00020\rJ\u0010\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u0003H\u0002J(\u0010\u001B\u001A\u0004\u0018\u00010\r2\u0016\u0010\u001C\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u001D\"\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0002\u0010\u001ER\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/compose/runtime/internal/ComposableLambdaNImpl;", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "key", "", "tracked", "", "arity", "<init>", "(IZI)V", "getKey", "()I", "getArity", "_block", "", "scope", "Landroidx/compose/runtime/RecomposeScope;", "scopes", "", "trackWrite", "", "trackRead", "composer", "Landroidx/compose/runtime/Composer;", "update", "block", "realParamCount", "params", "invoke", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ComposableLambdaNImpl implements ComposableLambdaN {
    public static final int $stable;
    private Object _block;
    private final int arity;
    private final int key;
    private RecomposeScope scope;
    private List scopes;
    private final boolean tracked;

    static {
    }

    public ComposableLambdaNImpl(int arg1, boolean arg2, int arg3) {
        super();
        this.key = arg1;
        this.tracked = arg2;
        this.arity = arg3;
    }

    public int getArity() {
        return this.arity;
    }

    public final int getKey() {
        return this.key;
    }

    public Object invoke(Object[] arg8) {
        int v0 = this.realParamCount(arg8.length);
        Object v1 = arg8[v0];
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        Object[] v2 = ArraysKt.slice(arg8, RangesKt.until(0, arg8.length - 1)).toArray(new Object[0]);
        Object v3 = arg8[arg8.length - 1];
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
        int v3_1 = ((Integer)v3).intValue();
        Composer v1_1 = ((Composer)v1).startRestartGroup(this.key);
        this.trackRead(v1_1);
        int v4 = v1_1.changed(this) ? ComposableLambdaKt.differentBits(v0) : ComposableLambdaKt.sameBits(v0);
        v3_1 |= v4;
        Object v4_1 = this._block;
        Intrinsics.checkNotNull(v4_1, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        SpreadBuilder v5 = new SpreadBuilder(2);
        v5.addSpread(v2);
        v5.add(Integer.valueOf(v3_1));
        Object v2_1 = ((FunctionN)v4_1).invoke(v5.toArray(new Object[v5.size()]));
        ScopeUpdateScope v1_2 = v1_1.endRestartGroup();
        if(v1_2 != null) {
            v1_2.updateScope(new ComposableLambdaNImpl$$ExternalSyntheticLambda0(arg8, v0, this));
        }

        return v2_1;
    }

    static final Unit invoke$lambda$0(Object[] arg6, int arg7, ComposableLambdaNImpl arg8, Composer arg9, int arg10) {
        arg10 = 0;
        Object[] v0 = ArraysKt.slice(arg6, RangesKt.until(0, arg7)).toArray(new Object[0]);
        Object v1 = arg6[arg7 + 1];
        String v2 = "null cannot be cast to non-null type kotlin.Int";
        Intrinsics.checkNotNull(v1, v2);
        int v1_1 = RecomposeScopeImplKt.updateChangedFlags(((Integer)v1).intValue());
        int v3 = arg6.length - arg7 - 2;
        Object[] v4 = new Object[v3];
        while(arg10 < v3) {
            Object v5 = arg6[arg7 + 2 + arg10];
            Intrinsics.checkNotNull(v5, v2);
            v4[arg10] = Integer.valueOf(RecomposeScopeImplKt.updateChangedFlags(((Integer)v5).intValue()));
            ++arg10;
        }

        SpreadBuilder v6 = new SpreadBuilder(4);
        v6.addSpread(v0);
        v6.add(arg9);
        v6.add(Integer.valueOf(v1_1 | 1));
        v6.addSpread(v4);
        arg8.invoke(v6.toArray(new Object[v6.size()]));
        return Unit.INSTANCE;
    }

    private final int realParamCount(int arg2) {
        arg2 += -2;
        int v1;
        for(v1 = 1; v1 * 10 < arg2; ++v1) {
            --arg2;
        }

        return arg2;
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

    public final void update(Object arg3) {
        if(!Intrinsics.areEqual(arg3, this._block)) {
            int v0 = this._block == null ? 1 : 0;
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
            this._block = arg3;
            if(v0 != 0) {
                return;
            }

            this.trackWrite();
        }
    }
}

