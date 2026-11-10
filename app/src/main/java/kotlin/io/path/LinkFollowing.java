package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\u0080\u0004¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\u0080\u0004R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0007R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0007R\u0015\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lkotlin/io/path/LinkFollowing;", "", "<init>", "()V", "nofollowLinkOption", "", "Ljava/nio/file/LinkOption;", "[Ljava/nio/file/LinkOption;", "followLinkOption", "nofollowVisitOption", "", "Ljava/nio/file/FileVisitOption;", "followVisitOption", "toLinkOptions", "followLinks", "", "(Z)[Ljava/nio/file/LinkOption;", "toVisitOptions", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) public final class LinkFollowing {
    public static final LinkFollowing INSTANCE;
    private static final LinkOption[] followLinkOption;
    private static final Set followVisitOption;
    private static final LinkOption[] nofollowLinkOption;
    private static final Set nofollowVisitOption;

    static {
        LinkFollowing.INSTANCE = new LinkFollowing();
        LinkFollowing.nofollowLinkOption = new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        LinkFollowing.followLinkOption = new LinkOption[0];
        LinkFollowing.nofollowVisitOption = SetsKt.emptySet();
        LinkFollowing.followVisitOption = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);
    }

    private LinkFollowing() {
        super();
    }

    public final LinkOption[] toLinkOptions(boolean arg1) {
        if(arg1) {
            return LinkFollowing.followLinkOption;
        }

        return LinkFollowing.nofollowLinkOption;
    }

    public final Set toVisitOptions(boolean arg1) {
        if(arg1) {
            return LinkFollowing.followVisitOption;
        }

        return LinkFollowing.nofollowVisitOption;
    }
}

