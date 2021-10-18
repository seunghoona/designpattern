package decorator.api;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 입력 스크림에 있는 대문자를 전부 소문자로 변경하는 데코레이러를 만들어 봅시다.
 */
public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i <off+result ; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}
