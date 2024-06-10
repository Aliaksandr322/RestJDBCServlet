package utils;

import java.io.BufferedReader;
import java.io.IOException;

public class ConvertToString {
    public String convertToString(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        String str;
        while( (str = br.readLine()) != null ){
            sb.append(str);
        }
        return sb.toString().replace("[", "").replace("]", "");
    }
}
