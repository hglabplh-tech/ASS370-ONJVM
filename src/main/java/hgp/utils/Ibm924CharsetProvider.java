package hgp.utils;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ibm924CharsetProvider extends CharsetProvider {
    private static final Charset IBM924 = new Ibm924Charset();
    private static final List<Charset> IBM924_LIST = Collections.singletonList(IBM924);

    public static final Charset ibm924() {
        return IBM924;
    }

    @Override public Iterator<Charset> charsets() {
        return IBM924_LIST.iterator();
    }

    @Override public Charset charsetForName(String charsetName) {
        if (charsetName.equals(IBM924.name())) return IBM924;
        if (IBM924.aliases().contains(charsetName)) return IBM924;

        return null;
    }

    public static void main(String[] args) throws Exception {
        String in = "Hello, World!";
        byte[] b = in.getBytes(ibm924());
        System.out.print(in + " ->");
        for (byte a : b) System.out.printf(" %02X", a);
        System.out.println();
        String in2 = new String(b, ibm924());
        System.out.println("... -> " + in2);
        System.out.println("Equal? " + in.equals(in2));
    }
}
