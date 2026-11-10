package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

public class Utf8Old extends Utf8 {
    class Cache {
        final CharsetDecoder decoder;
        final CharsetEncoder encoder;
        CharSequence lastInput;
        ByteBuffer lastOutput;

        Cache() {
            super();
            this.lastInput = null;
            this.lastOutput = null;
            this.encoder = StandardCharsets.UTF_8.newEncoder();
            this.decoder = StandardCharsets.UTF_8.newDecoder();
        }
    }

    private static final ThreadLocal CACHE;

    static {
        Utf8Old.CACHE = ThreadLocal.withInitial(new Utf8Old$$ExternalSyntheticLambda0());
    }

    public Utf8Old() {
        super();
    }

    public String decodeUtf8(ByteBuffer arg1, int arg2, int arg3) {
        CharsetDecoder v0 = Utf8Old.CACHE.get().decoder;
        v0.reset();
        arg1 = arg1.duplicate();
        arg1.position(arg2);
        arg1.limit(arg2 + arg3);
        try {
            return v0.decode(arg1).toString();
        }
        catch(CharacterCodingException v0_1) {
            throw new IllegalArgumentException("Bad encoding", ((Throwable)v0_1));
        }
    }

    public void encodeUtf8(CharSequence arg3, ByteBuffer arg4) {
        Object v0 = Utf8Old.CACHE.get();
        if(((Cache)v0).lastInput != arg3) {
            this.encodedLength(arg3);
        }

        arg4.put(((Cache)v0).lastOutput);
    }

    public int encodedLength(CharSequence arg4) {
        CharBuffer v4;
        Object v3 = Utf8Old.CACHE.get();
        int v0 = ((int)((((float)arg4.length())) * ((Cache)v3).encoder.maxBytesPerChar()));
        if(((Cache)v3).lastOutput == null || ((Cache)v3).lastOutput.capacity() < v0) {
            ((Cache)v3).lastOutput = ByteBuffer.allocate(Math.max(0x80, v0));
        }

        ((Cache)v3).lastOutput.clear();
        ((Cache)v3).lastInput = arg4;
        if((arg4 instanceof CharBuffer)) {
        }
        else {
            v4 = CharBuffer.wrap(arg4);
        }

        CoderResult v4_1 = ((Cache)v3).encoder.encode(v4, ((Cache)v3).lastOutput, true);
        if(v4_1.isError()) {
            try {
                v4_1.throwException();
            }
            catch(CharacterCodingException v3_1) {
                throw new IllegalArgumentException("bad character encoding", ((Throwable)v3_1));
            }
        }

        ((Cache)v3).lastOutput.flip();
        return ((Cache)v3).lastOutput.remaining();
    }

    static Cache lambda$static$0() {
        return new Cache();
    }
}

