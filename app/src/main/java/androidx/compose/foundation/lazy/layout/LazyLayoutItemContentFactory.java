package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0017B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u00012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001J0\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\u0002\b\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\u00012\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001E\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\rR\u00020\u00000\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "<init>", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Lkotlin/jvm/functions/Function0;)V", "getItemProvider", "()Lkotlin/jvm/functions/Function0;", "lambdasCache", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "getContentType", "key", "getContent", "", "Landroidx/compose/runtime/Composable;", "index", "", "contentType", "(ILjava/lang/Object;Ljava/lang/Object;)Lkotlin/jvm/functions/Function2;", "CachedItemContent", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutItemContentFactory {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0001\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00100\u000F¢\u0006\u0002\b\u0011H\u0002¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0004\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u001E\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u0003@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u001D\u0010\u000E\u001A\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000F¢\u0006\u0002\b\u0011X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0012R\u001C\u0010\u0013\u001A\r\u0012\u0004\u0012\u00020\u00100\u000F¢\u0006\u0002\b\u00118F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "", "index", "", "key", "contentType", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;ILjava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "getContentType", "value", "getIndex", "()I", "_content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "createContentLambda", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class CachedItemContent {
        private Function2 _content;
        private final Object contentType;
        private int index;
        private final Object key;

        public static DisposableEffectResult $r8$lambda$xgkon0VB6ZEu0_GfGGkmCwKR0jQ(CachedItemContent arg0, DisposableEffectScope arg1) {
            return CachedItemContent.createContentLambda$lambda$0$0$0(arg0, arg1);
        }

        public CachedItemContent(LazyLayoutItemContentFactory arg1, int arg2, Object arg3, Object arg4) {
            LazyLayoutItemContentFactory.this = arg1;
            super();
            this.key = arg3;
            this.contentType = arg4;
            this.index = arg2;
        }

        public static final void access$set_content$p(CachedItemContent arg0, Function2 arg1) {
            arg0._content = arg1;
        }

        private final Function2 createContentLambda() {
            return ComposableLambdaKt.composableLambdaInstance(0x30C58C04, true, new LazyLayoutItemContentFactory$CachedItemContent$$ExternalSyntheticLambda0(LazyLayoutItemContentFactory.this, this));
        }

        static final Unit createContentLambda$lambda$0(LazyLayoutItemContentFactory arg9, CachedItemContent arg10, Composer arg11, int arg12) {
            LazyLayoutItemContentFactory$CachedItemContent$$ExternalSyntheticLambda1 v12_1;
            Composer v7;
            ComposerKt.sourceInformation(arg11, "C101@3940L244,101@3918L266:LazyLayoutItemContentFactory.kt#wow0x6");
            boolean v0 = (arg12 & 3) != 2 ? true : false;
            if(arg11.shouldExecute(v0, arg12 & 1)) {
                int v1 = -1;
                if(ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(0x30C58C04, arg12, v1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:85)");
                }

                Object v3 = arg9.getItemProvider().invoke();
                arg12 = arg10.index;
                if(arg12 >= ((LazyLayoutItemProvider)v3).getItemCount() || !Intrinsics.areEqual(((LazyLayoutItemProvider)v3).getKey(arg12), arg10.key)) {
                    arg12 = ((LazyLayoutItemProvider)v3).getIndex(arg10.key);
                    if(arg12 != v1) {
                        arg10.index = arg12;
                    }
                }

                int v5 = arg12;
                if(v5 != v1) {
                    arg11.startReplaceGroup(0x9CC61069);
                    ComposerKt.sourceInformation(arg11, "94@3678L205");
                    v7 = arg11;
                    LazyLayoutItemContentFactoryKt.access$SkippableItem-JVlU9Rs(((LazyLayoutItemProvider)v3), StableValue.constructor-impl(arg9.saveableStateHolder), v5, StableValue.constructor-impl(arg10.key), v7, 0);
                }
                else {
                    v7 = arg11;
                    v7.startReplaceGroup(-1668376610);
                }

                v7.endReplaceGroup();
                Object v9 = arg10.key;
                ComposerKt.sourceInformationMarkerStart(v7, 0x1592EA38, "CC(remember):LazyLayoutItemContentFactory.kt#9igjgp");
                boolean v11 = v7.changedInstance(arg10);
                Object v12 = v7.rememberedValue();
                if((v11) || v12 == Composer.Companion.getEmpty()) {
                    v12_1 = new LazyLayoutItemContentFactory$CachedItemContent$$ExternalSyntheticLambda1(arg10);
                    v7.updateRememberedValue(v12_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v7);
                EffectsKt.DisposableEffect(v9, ((Function1)v12_1), v7, 0);
                if(!ComposerKt.isTraceInProgress()) {
                    goto label_71;
                }

                ComposerKt.traceEventEnd();
            }
            else {
                arg11.skipToGroupEnd();
            }

        label_71:
            return Unit.INSTANCE;
        }

        private static final DisposableEffectResult createContentLambda$lambda$0$0$0(CachedItemContent arg0, DisposableEffectScope arg1) {
            return new LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$lambda$0$0$0$$inlined$onDispose$1(arg0);
        }

        public final Function2 getContent() {
            Function2 v0 = this._content;
            if(v0 == null) {
                v0 = this.createContentLambda();
                this._content = v0;
            }

            return v0;
        }

        public final Object getContentType() {
            return this.contentType;
        }

        public final int getIndex() {
            return this.index;
        }

        public final Object getKey() {
            return this.key;
        }
    }

    public static final int $stable = 8;
    private final Function0 itemProvider;
    private final MutableScatterMap lambdasCache;
    private final SaveableStateHolder saveableStateHolder;

    static {
    }

    public LazyLayoutItemContentFactory(SaveableStateHolder arg1, Function0 arg2) {
        super();
        this.saveableStateHolder = arg1;
        this.itemProvider = arg2;
        this.lambdasCache = ScatterMapKt.mutableScatterMapOf();
    }

    public static final SaveableStateHolder access$getSaveableStateHolder$p(LazyLayoutItemContentFactory arg0) {
        return arg0.saveableStateHolder;
    }

    public final Function2 getContent(int arg3, Object arg4, Object arg5) {
        Object v0 = this.lambdasCache.get(arg4);
        if(v0 != null && ((CachedItemContent)v0).getIndex() == arg3 && (Intrinsics.areEqual(((CachedItemContent)v0).getContentType(), arg5))) {
            return ((CachedItemContent)v0).getContent();
        }

        CachedItemContent v0_1 = new CachedItemContent(this, arg3, arg4, arg5);
        this.lambdasCache.set(arg4, v0_1);
        return v0_1.getContent();
    }

    public final Object getContentType(Object arg3) {
        Object v0 = null;
        if(arg3 == null) {
            return v0;
        }

        Object v1 = this.lambdasCache.get(arg3);
        if(v1 != null) {
            return ((CachedItemContent)v1).getContentType();
        }

        Object v2 = this.itemProvider.invoke();
        int v3 = ((LazyLayoutItemProvider)v2).getIndex(arg3);
        if(v3 != -1) {
            return ((LazyLayoutItemProvider)v2).getContentType(v3);
        }

        return v0;
    }

    public final Function0 getItemProvider() {
        return this.itemProvider;
    }
}

