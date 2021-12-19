import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * @description:
 * @author:maidang
 * @date:2021/01/06
 **/
public class test {

  public static void main(String[] args) throws Exception {
    flowTypeTest();
  }


  public static void flowTypeTest(){
    long goodsTypeDimensionValue = 1;
    long goodsDerivativeDimensionValue = 12 << 12;
    long activityDimensionTypeValue =11 << 18;
    long payDimensionTypeValue = 1 << 24;
    long logisticsDimensionTypeValue =1 << 28;

  }

  public static final String unCompress(String compressedStr) {
    if (compressedStr == null) {
      return null;
    }
    ByteArrayOutputStream out = null;
    ByteArrayInputStream in = null;
    GZIPInputStream gin = null;
    String decompressed = null;
    try {
      byte[] compressed = new BASE64Decoder().decodeBuffer(compressedStr);
      out = new ByteArrayOutputStream();
      in = new ByteArrayInputStream(compressed);
      gin = new GZIPInputStream(in);
      byte[] buffer = new byte[1024];
      int offset = -1;
      while((offset = gin.read(buffer)) != -1) {
        out.write(buffer, 0, offset);
      }
      decompressed = out.toString("UTF-8");
    } catch (Exception e) {
      decompressed = compressedStr;
    } finally {
      if (gin != null) {
        try {
          gin.close();
        } catch (IOException e) {
        }
      }
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
        }
      }
    }
    return decompressed;
  }
}
