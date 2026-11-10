package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

public final class ContentInViewNode$launchAnimation$2$1$$ExternalSyntheticLambda0 implements Function1 {
    public ContentInViewNode$launchAnimation$2$1$$ExternalSyntheticLambda0(ContentInViewNode arg1, UpdatableAnimationState arg2, Job arg3, NestedScrollScope arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final Object invoke(Object arg4) {
        return androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, ((Float)arg4).floatValue());
    }
}

