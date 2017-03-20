package ch.heigvd.res.stpatrick;

import java.io.*;

/**
 * Created by christopher on 20.03.17.
 */
public class RemoveAStreamDecorator implements IStreamDecoratorController {
    @Override
    public Reader decorateReader(Reader inputReader) {
        return inputReader;
    }

    @Override
    public Writer decorateWriter(Writer outputWriter) {
        return new BufferedWriter(outputWriter) {
            @Override
            public void write(char[] chars, int i, int i1) throws IOException {
                int end = i + i1;
                for(; i < end; i++ ) {
                    write(chars[i]);
                }
            }

            @Override
            public void write(String s, int i, int i1) throws IOException {
                int end = i + i1;
                for(; i < end; i++ ) {
                    write(s.charAt(i));
                }
            }

            @Override
            public void write(int i) throws IOException {
                if(Character.toUpperCase(i) != 'A')
                    super.write(i);
            }
        };
    }
}
