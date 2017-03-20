package ch.heigvd.res.stpatrick;

import java.io.*;

/**
 * The responsibility of this class is to read characters from an input
 * reader, to process them, and to write them to an output writer except
 * the letter e or E.
 * 
 * Note: clients do not instantiate this class directly. They obtain instances
 * of this class via the StreamProcessorsFactory.
 * 
 * @author Christopher Meier
 */
class ERemoverStreamProcessor implements IStreamProcessor {

  @Override
  public void process(Reader in, Writer out) throws IOException {
    BufferedReader br = new BufferedReader(in);
    BufferedWriter bw = new BufferedWriter(out);
    int c = br.read();
    while (c != -1) {
      if(Character.toUpperCase(c) != 'E')
        bw.write(c);
      c = br.read();
    }
    bw.flush();
  }

}
