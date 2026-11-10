package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0005\u0006J\n\u0010\u0002\u001A\u00020\u0003H¦\u0080\u0004J\f\u0010\u0004\u001A\u0004\u0018\u00010\u0003H¦\u0080\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2={"Lkotlin/time/InstantParseResult;", "", "toInstant", "Lkotlin/time/Instant;", "toInstantOrNull", "Success", "Failure", "Lkotlin/time/InstantParseResult$Failure;", "Lkotlin/time/InstantParseResult$Success;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) interface InstantParseResult {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004J\f\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0096\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u000F"}, d2={"Lkotlin/time/InstantParseResult$Failure;", "Lkotlin/time/InstantParseResult;", "error", "", "input", "", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;)V", "getError", "()Ljava/lang/String;", "getInput", "()Ljava/lang/CharSequence;", "toInstant", "Lkotlin/time/Instant;", "toInstantOrNull", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Failure implements InstantParseResult {
        private final String error;
        private final CharSequence input;

        public Failure(String arg2, CharSequence arg3) {
            Intrinsics.checkNotNullParameter(arg2, "error");
            Intrinsics.checkNotNullParameter(arg3, "input");
            super();
            this.error = arg2;
            this.input = arg3;
        }

        public final String getError() {
            return this.error;
        }

        public final CharSequence getInput() {
            return this.input;
        }

        public Instant toInstant() {
            throw new InstantFormatException(this.error + " when parsing an Instant from \"" + InstantKt.truncateForErrorMessage(this.input, 0x40) + '\"');
        }

        public Instant toInstantOrNull() {
            return null;
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001A\u00020\rH\u0096\u0080\u0004J\f\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0096\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u000F"}, d2={"Lkotlin/time/InstantParseResult$Success;", "Lkotlin/time/InstantParseResult;", "epochSeconds", "", "nanosecondsOfSecond", "", "<init>", "(JI)V", "getEpochSeconds", "()J", "getNanosecondsOfSecond", "()I", "toInstant", "Lkotlin/time/Instant;", "toInstantOrNull", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Success implements InstantParseResult {
        private final long epochSeconds;
        private final int nanosecondsOfSecond;

        public Success(long arg1, int arg3) {
            super();
            this.epochSeconds = arg1;
            this.nanosecondsOfSecond = arg3;
        }

        public final long getEpochSeconds() {
            return this.epochSeconds;
        }

        public final int getNanosecondsOfSecond() {
            return this.nanosecondsOfSecond;
        }

        public Instant toInstant() {
            if(this.epochSeconds >= Instant.Companion.getMIN$kotlin_stdlib().getEpochSeconds() && this.epochSeconds <= Instant.Companion.getMAX$kotlin_stdlib().getEpochSeconds()) {
                return Instant.Companion.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
            }

            throw new InstantFormatException("The parsed date is outside the range representable by Instant (Unix epoch second " + this.epochSeconds + ')');
        }

        public Instant toInstantOrNull() {
            if(this.epochSeconds >= Instant.Companion.getMIN$kotlin_stdlib().getEpochSeconds()) {
                if(this.epochSeconds > Instant.Companion.getMAX$kotlin_stdlib().getEpochSeconds()) {
                }
                else {
                    return Instant.Companion.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
                }
            }

            return null;
        }
    }

    Instant toInstant();

    Instant toInstantOrNull();
}

