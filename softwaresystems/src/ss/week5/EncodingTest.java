package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";
        String input2 ="Hello Big World";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        System.out.println(Hex.encodeHexString(input2.getBytes()));
        
        String hexString = "4d6f64756c652032";
        char[] hexCharArray = hexString.toCharArray();
        String text = new String (Hex.decodeHex(hexCharArray));
        System.out.println(text);
        System.out.println("hex "+hexString.length() +"text " +text.length());
        
    
      for (int i=0; i<hexCharArray.length;i+=2){
    	 
    		  System.out.print(hexCharArray[i] + "" +hexCharArray[i+1] + "   ");
    	  System.out.print(text.substring(i/2,i/2+1)+"   ");
    	  System.out.print(text.substring(i/2,i/2+1).getBytes()+"   ");
    	  
    	  System.out.println("");
      }
      
      System.out.println("Base64 representation hello world= "+ Base64.encodeBase64String(input.getBytes()));
      
      hexString ="010203040506";
      byte[] hexByte=Hex.decodeHex(hexString.toCharArray());
      System.out.println (hexString +" decoded with hex, encoded with base64 = " + Base64.encodeBase64String(hexByte));
      
      String base64String = "U29mdHdhcmUgU3lzdGVtcw==";
      String decodedString = new String(Base64.decodeBase64(base64String));
      System.out.println("Base64 String decoded = "+ decodedString);
      
        
    }
}
