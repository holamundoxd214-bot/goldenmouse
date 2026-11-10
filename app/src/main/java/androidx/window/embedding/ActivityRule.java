package androidx.window.embedding;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B+\b\u0000\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u0006H\u0080\u0002¢\u0006\u0002\b\u0011J\u0013\u0010\u0012\u001A\u00020\b2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\u0003H\u0016R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u0019"}, d2={"Landroidx/window/embedding/ActivityRule;", "Landroidx/window/embedding/EmbeddingRule;", "tag", "", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "alwaysExpand", "", "<init>", "(Ljava/lang/String;Ljava/util/Set;Z)V", "getFilters", "()Ljava/util/Set;", "getAlwaysExpand", "()Z", "plus", "filter", "plus$window_release", "equals", "other", "", "hashCode", "", "toString", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActivityRule extends EmbeddingRule {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\u000B\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nJ\u0010\u0010\f\u001A\u00020\u00002\b\u0010\u0007\u001A\u0004\u0018\u00010\bJ\u0006\u0010\r\u001A\u00020\u000ER\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/window/embedding/ActivityRule$Builder;", "", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "<init>", "(Ljava/util/Set;)V", "tag", "", "alwaysExpand", "", "setAlwaysExpand", "setTag", "build", "Landroidx/window/embedding/ActivityRule;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private boolean alwaysExpand;
        private final Set filters;
        private String tag;

        public Builder(Set arg2) {
            Intrinsics.checkNotNullParameter(arg2, "filters");
            super();
            this.filters = arg2;
        }

        public final ActivityRule build() {
            return new ActivityRule(this.tag, this.filters, this.alwaysExpand);
        }

        public final Builder setAlwaysExpand(boolean arg2) {
            this.alwaysExpand = arg2;
            return this;
        }

        public final Builder setTag(String arg2) {
            this.tag = arg2;
            return this;
        }
    }

    private final boolean alwaysExpand;
    private final Set filters;

    public ActivityRule(String arg2, Set arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg3, "filters");
        super(arg2);
        this.filters = arg3;
        this.alwaysExpand = arg4;
    }

    public ActivityRule(String arg1, Set arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, false);
    }

    public boolean equals(Object arg5) {
        if(this == (((ActivityRule)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ActivityRule)) {
            return 0;
        }

        if(!super.equals(arg5)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.filters, ((ActivityRule)arg5).filters)) {
            return 0;
        }

        if(this.alwaysExpand != ((ActivityRule)arg5).alwaysExpand) {
            return 0;
        }

        return 1;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    public final Set getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (super.hashCode() * 0x1F + this.filters.hashCode()) * 0x1F + Boolean.hashCode(this.alwaysExpand);
    }

    public final ActivityRule plus$window_release(ActivityFilter arg4) {
        Intrinsics.checkNotNullParameter(arg4, "filter");
        return new ActivityRule(this.getTag(), SetsKt.plus(this.filters, arg4), this.alwaysExpand);
    }

    public String toString() {
        return "ActivityRule:{tag={" + this.getTag() + "},filters={" + this.filters + "}, alwaysExpand={" + this.alwaysExpand + "}}";
    }
}

