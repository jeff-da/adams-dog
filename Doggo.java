import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Doggo {
  public static void main(String[] args) {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    Queue<String> endOfUrl = getEndsOfUrl();
    for (String s : endOfUrl) {
      System.out.println(getUrlAsString("http://www.countablethoughts.com/concat-then-factor/dl.py?" + s));
    }
  }

  private static Queue<String> getEndsOfUrl() {
    String first = "xa";
    for (int i = 0; i < alphabet.length; i++) {
      String curr = first + alphabet[i];
      for (int j = 0; j < alphabet.length; j++) {
        String curr2 = curr + alphabet[j];
        endOfUrl.add(curr2);
      }
    }
    String second = "xb";
    for (int i = 0; i < alphabet.length; i++) {
      String curr = second + alphabet[i];
      for (int j = 0; j < alphabet.length; j++) {
        String curr2 = curr + alphabet[j];
        endOfUrl.add(curr2);
      }
    }
    String third = "xc";
    for (int i = 0; i < 6; i++) {
      String curr = first + alphabet[i];
      for (int j = 0; j < alphabet.length; j++) {
        String curr2 = curr + alphabet[j];
        endOfUrl.add(curr2);
      }
    }
    String fourth = "xcg";
    for (int i = 0; i < 5; i++) {
      String curr = fourth + alphabet[i];
      endOfUrl.add(curr);
    }
  }

  public static String getUrlAsString(String url) {
    try {
      URL urlObj = new URL(url);
      URLConnection con = urlObj.openConnection();

      con.setDoOutput(true);
      con.setRequestProperty("Cookie", "myCookie=test123");
      con.connect();

      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

      StringBuilder response = new StringBuilder();
      String inputLine;

      String newLine = System.getProperty("line.separator");
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine + newLine);
      }
      in.close();
      return response.toString();
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
