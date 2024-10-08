package hgp.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.spi.CharsetProvider;
import java.util.*;



    class Ibm924Charset extends Charset {
        public Ibm924Charset() {
            super("IBM-924", new String[] { "IBM924", "Cp924", "Cp-924" });
        }

        @Override public boolean contains(Charset cs) {
            return cs.name().equals("IBM-924"); // It isn't even a subset of ASCII!
        }

        @Override public CharsetDecoder newDecoder() {
            return new CharsetDecoder(this, 1F, 1F) {
                @Override protected CoderResult decodeLoop(ByteBuffer from, CharBuffer to) {
                    while (from.hasRemaining()) {
                        if (!to.hasRemaining()) return CoderResult.OVERFLOW;
                        byte c = from.get();
                        char d = IBM924[c & 0xFF];
                        to.put(d);
                    }

                    return CoderResult.UNDERFLOW;
                }
            };
        }

        @Override public CharsetEncoder newEncoder() {
            return new CharsetEncoder(this, 1F, 1F) {
                @Override protected CoderResult encodeLoop(CharBuffer from, ByteBuffer to) {
                    while (from.hasRemaining()) {
                        if (!to.hasRemaining()) return CoderResult.OVERFLOW;
                        char d = from.get();
                        Byte v = (Byte) LOOKUP.get(d);
                        if (v == null) {
                            // 'un'consume the character we consumed
                            from.position(from.position() - 1);
                            return CoderResult.unmappableForLength(1);
                        }
                        to.put(v.byteValue());
                    }

                    return CoderResult.UNDERFLOW;
                }
            };
        }

        // SOURCE: https://github.com/unicode-org/icu-data/blob/main/charset/data/ucm/ibm-924_P100-1998.ucm
        private static final char[] IBM924 = {
                '\u0000', '\u0001', '\u0002', '\u0003', '\u009C', '\u0009', '\u0086', '\u007F',
                '\u0097', '\u008D', '\u008E', '\u000B', '\u000C', '\r', '\u000E', '\u000F',
                '\u0010','\u0011','\u0012','\u0013', '\u009D','\u0085','\u0008','\u0087',
                '\u0018','\u0019','\u0092','\u008F', '\u001C','\u001D','\u001E','\u001F',
                '\u0080','\u0081','\u0082','\u0083', '\u0084','\n','\u0017','\u001B',
                '\u0088','\u0089','\u008A','\u008B', '\u008C','\u0005', '\u0006', '\u0007',
                '\u0090', '\u0091', '\u0016', '\u0093', '\u0094', '\u0095', '\u0096', '\u0004',
                '\u0098', '\u0099', '\u009A', '\u009B', '\u0014', '\u0015', '\u009E', '\u001A',
                '\u0020', '\u00A0', '\u00E2', '\u00E4', '\u00E0', '\u00E1', '\u00E3', '\u00E5',
                '\u00E7', '\u00F1', '\u00DD', '\u002E', '\u003C', '\u0028', '\u002B', '\u007C',
                '\u0026', '\u00E9', '\u00EA', '\u00EB', '\u00E8', '\u00ED', '\u00EE', '\u00EF',
                '\u00EC', '\u00DF', '\u0021', '\u0024', '\u002A', '\u0029', '\u003B', '\u005E',
                '\u002D', '\u002F', '\u00C2', '\u00C4', '\u00C0', '\u00C1', '\u00C3', '\u00C5',
                '\u00C7', '\u00D1', '\u0160', '\u002C', '\u0025', '\u005F', '\u003E', '\u003F',
                '\u00F8', '\u00C9', '\u00CA', '\u00CB', '\u00C8', '\u00CD', '\u00CE', '\u00CF',
                '\u00CC', '\u0060', '\u003A', '\u0023', '\u0040', '\'', '\u003D', '\u0022',
                '\u00D8', '\u0061', '\u0062', '\u0063', '\u0064', '\u0065', '\u0066', '\u0067',
                '\u0068', '\u0069', '\u00AB', '\u00BB', '\u00F0', '\u00FD', '\u00FE', '\u00B1',
                '\u00B0', '\u006A', '\u006B', '\u006C', '\u006D', '\u006E', '\u006F', '\u0070',
                '\u0071', '\u0072', '\u00AA', '\u00BA', '\u00E6', '\u017E', '\u00C6', '\u20AC',
                '\u00B5', '\u007E', '\u0073', '\u0074', '\u0075', '\u0076', '\u0077', '\u0078',
                '\u0079', '\u007A', '\u00A1', '\u00BF', '\u00D0', '\u005B', '\u00DE', '\u00AE',
                '\u00A2', '\u00A3', '\u00A5', '\u00B7', '\u00A9', '\u00A7', '\u00B6', '\u0152',
                '\u0153', '\u0178', '\u00AC', '\u0161', '\u00AF', '\u005D', '\u017D', '\u00D7',
                '\u007B', '\u0041', '\u0042', '\u0043', '\u0044', '\u0045', '\u0046', '\u0047',
                '\u0048', '\u0049', '\u00AD', '\u00F4', '\u00F6', '\u00F2', '\u00F3', '\u00F5',
                '\u007D', '\u004A', '\u004B', '\u004C', '\u004D', '\u004E', '\u004F', '\u0050',
                '\u0051', '\u0052', '\u00B9', '\u00FB', '\u00FC', '\u00F9', '\u00FA', '\u00FF',
                '\\', '\u00F7', '\u0053', '\u0054', '\u0055', '\u0056', '\u0057', '\u0058',
                '\u0059', '\u005A', '\u00B2', '\u00D4', '\u00D6', '\u00D2', '\u00D3', '\u00D5',
                '\u0030', '\u0031', '\u0032', '\u0033', '\u0034', '\u0035', '\u0036', '\u0037',
                '\u0038', '\u0039', '\u00B3', '\u00DB', '\u00DC', '\u00D9', '\u00DA', '\u009F',
        };

        private static final Map<Object, Object> LOOKUP;
        static {
            Map<Character, Byte> map = new HashMap<>();
            for (int i = 0; i < IBM924.length; i++) map.put(IBM924[i], (byte) i);
            LOOKUP = Collections.unmodifiableMap(map);
        }
    }

