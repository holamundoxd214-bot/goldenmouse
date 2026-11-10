package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material3.tokens.ExpressiveMotionTokens;
import androidx.compose.material3.tokens.StandardMotionTokens;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\ba\u0018\u0000 \n2\u00020\u0001:\u0003\n\u000B\fJ\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&J\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2={"Landroidx/compose/material3/MotionScheme;", "", "defaultSpatialSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "T", "fastSpatialSpec", "slowSpatialSpec", "defaultEffectsSpec", "fastEffectsSpec", "slowEffectsSpec", "Companion", "StandardMotionSchemeImpl", "ExpressiveMotionSchemeImpl", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface MotionScheme {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0006J\r\u0010\u0007\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2={"Landroidx/compose/material3/MotionScheme$Companion;", "", "<init>", "()V", "standard", "Landroidx/compose/material3/MotionScheme;", "standard$material3", "expressive", "expressive$material3", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final MotionScheme expressive$material3() {
            return ExpressiveMotionSchemeImpl.INSTANCE;
        }

        public final MotionScheme standard$material3() {
            return StandardMotionSchemeImpl.INSTANCE;
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/material3/MotionScheme$ExpressiveMotionSchemeImpl;", "Landroidx/compose/material3/MotionScheme;", "<init>", "()V", "defaultSpatialSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "fastSpatialSpec", "slowSpatialSpec", "defaultEffectsSpec", "fastEffectsSpec", "slowEffectsSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "T", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ExpressiveMotionSchemeImpl implements MotionScheme {
        public static final ExpressiveMotionSchemeImpl INSTANCE;
        private static final SpringSpec defaultEffectsSpec;
        private static final SpringSpec defaultSpatialSpec;
        private static final SpringSpec fastEffectsSpec;
        private static final SpringSpec fastSpatialSpec;
        private static final SpringSpec slowEffectsSpec;
        private static final SpringSpec slowSpatialSpec;

        static {
            ExpressiveMotionSchemeImpl.INSTANCE = new ExpressiveMotionSchemeImpl();
            ExpressiveMotionSchemeImpl.defaultSpatialSpec = AnimationSpecKt.spring$default(ExpressiveMotionTokens.INSTANCE.getSpringDefaultSpatialDamping(), ExpressiveMotionTokens.INSTANCE.getSpringDefaultSpatialStiffness(), null, 4, null);
            ExpressiveMotionSchemeImpl.fastSpatialSpec = AnimationSpecKt.spring$default(ExpressiveMotionTokens.INSTANCE.getSpringFastSpatialDamping(), ExpressiveMotionTokens.INSTANCE.getSpringFastSpatialStiffness(), null, 4, null);
            ExpressiveMotionSchemeImpl.slowSpatialSpec = AnimationSpecKt.spring$default(ExpressiveMotionTokens.INSTANCE.getSpringSlowSpatialDamping(), ExpressiveMotionTokens.INSTANCE.getSpringSlowSpatialStiffness(), null, 4, null);
            ExpressiveMotionSchemeImpl.defaultEffectsSpec = AnimationSpecKt.spring$default(ExpressiveMotionTokens.INSTANCE.getSpringDefaultEffectsDamping(), ExpressiveMotionTokens.INSTANCE.getSpringDefaultEffectsStiffness(), null, 4, null);
            ExpressiveMotionSchemeImpl.fastEffectsSpec = AnimationSpecKt.spring$default(ExpressiveMotionTokens.INSTANCE.getSpringFastEffectsDamping(), ExpressiveMotionTokens.INSTANCE.getSpringFastEffectsStiffness(), null, 4, null);
            ExpressiveMotionSchemeImpl.slowEffectsSpec = AnimationSpecKt.spring$default(ExpressiveMotionTokens.INSTANCE.getSpringSlowEffectsDamping(), ExpressiveMotionTokens.INSTANCE.getSpringSlowEffectsStiffness(), null, 4, null);
        }

        private ExpressiveMotionSchemeImpl() {
            super();
        }

        public FiniteAnimationSpec defaultEffectsSpec() {
            SpringSpec v1 = ExpressiveMotionSchemeImpl.defaultEffectsSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.defaultEffectsSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec defaultSpatialSpec() {
            SpringSpec v1 = ExpressiveMotionSchemeImpl.defaultSpatialSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.defaultSpatialSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec fastEffectsSpec() {
            SpringSpec v1 = ExpressiveMotionSchemeImpl.fastEffectsSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.fastEffectsSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec fastSpatialSpec() {
            SpringSpec v1 = ExpressiveMotionSchemeImpl.fastSpatialSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.fastSpatialSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec slowEffectsSpec() {
            SpringSpec v1 = ExpressiveMotionSchemeImpl.slowEffectsSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.slowEffectsSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec slowSpatialSpec() {
            SpringSpec v1 = ExpressiveMotionSchemeImpl.slowSpatialSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.ExpressiveMotionSchemeImpl.slowSpatialSpec>");
            return ((FiniteAnimationSpec)v1);
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016J\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\rH\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/material3/MotionScheme$StandardMotionSchemeImpl;", "Landroidx/compose/material3/MotionScheme;", "<init>", "()V", "defaultSpatialSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "fastSpatialSpec", "slowSpatialSpec", "defaultEffectsSpec", "fastEffectsSpec", "slowEffectsSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "T", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class StandardMotionSchemeImpl implements MotionScheme {
        public static final StandardMotionSchemeImpl INSTANCE;
        private static final SpringSpec defaultEffectsSpec;
        private static final SpringSpec defaultSpatialSpec;
        private static final SpringSpec fastEffectsSpec;
        private static final SpringSpec fastSpatialSpec;
        private static final SpringSpec slowEffectsSpec;
        private static final SpringSpec slowSpatialSpec;

        static {
            StandardMotionSchemeImpl.INSTANCE = new StandardMotionSchemeImpl();
            StandardMotionSchemeImpl.defaultSpatialSpec = AnimationSpecKt.spring$default(StandardMotionTokens.INSTANCE.getSpringDefaultSpatialDamping(), StandardMotionTokens.INSTANCE.getSpringDefaultSpatialStiffness(), null, 4, null);
            StandardMotionSchemeImpl.fastSpatialSpec = AnimationSpecKt.spring$default(StandardMotionTokens.INSTANCE.getSpringFastSpatialDamping(), StandardMotionTokens.INSTANCE.getSpringFastSpatialStiffness(), null, 4, null);
            StandardMotionSchemeImpl.slowSpatialSpec = AnimationSpecKt.spring$default(StandardMotionTokens.INSTANCE.getSpringSlowSpatialDamping(), StandardMotionTokens.INSTANCE.getSpringSlowSpatialStiffness(), null, 4, null);
            StandardMotionSchemeImpl.defaultEffectsSpec = AnimationSpecKt.spring$default(StandardMotionTokens.INSTANCE.getSpringDefaultEffectsDamping(), StandardMotionTokens.INSTANCE.getSpringDefaultEffectsStiffness(), null, 4, null);
            StandardMotionSchemeImpl.fastEffectsSpec = AnimationSpecKt.spring$default(StandardMotionTokens.INSTANCE.getSpringFastEffectsDamping(), StandardMotionTokens.INSTANCE.getSpringFastEffectsStiffness(), null, 4, null);
            StandardMotionSchemeImpl.slowEffectsSpec = AnimationSpecKt.spring$default(StandardMotionTokens.INSTANCE.getSpringSlowEffectsDamping(), StandardMotionTokens.INSTANCE.getSpringSlowEffectsStiffness(), null, 4, null);
        }

        private StandardMotionSchemeImpl() {
            super();
        }

        public FiniteAnimationSpec defaultEffectsSpec() {
            SpringSpec v1 = StandardMotionSchemeImpl.defaultEffectsSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.defaultEffectsSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec defaultSpatialSpec() {
            SpringSpec v1 = StandardMotionSchemeImpl.defaultSpatialSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.defaultSpatialSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec fastEffectsSpec() {
            SpringSpec v1 = StandardMotionSchemeImpl.fastEffectsSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.fastEffectsSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec fastSpatialSpec() {
            SpringSpec v1 = StandardMotionSchemeImpl.fastSpatialSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.fastSpatialSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec slowEffectsSpec() {
            SpringSpec v1 = StandardMotionSchemeImpl.slowEffectsSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.slowEffectsSpec>");
            return ((FiniteAnimationSpec)v1);
        }

        public FiniteAnimationSpec slowSpatialSpec() {
            SpringSpec v1 = StandardMotionSchemeImpl.slowSpatialSpec;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.animation.core.FiniteAnimationSpec<T of androidx.compose.material3.MotionScheme.StandardMotionSchemeImpl.slowSpatialSpec>");
            return ((FiniteAnimationSpec)v1);
        }
    }

    public static final Companion Companion;

    static {
        MotionScheme.Companion = Companion.$$INSTANCE;
    }

    FiniteAnimationSpec defaultEffectsSpec();

    FiniteAnimationSpec defaultSpatialSpec();

    FiniteAnimationSpec fastEffectsSpec();

    FiniteAnimationSpec fastSpatialSpec();

    FiniteAnimationSpec slowEffectsSpec();

    FiniteAnimationSpec slowSpatialSpec();
}

