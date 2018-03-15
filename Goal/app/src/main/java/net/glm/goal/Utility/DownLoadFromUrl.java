package net.glm.goal.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by Michael on 15/03/2018.
 */

public class DownLoadFromUrl {

    public String getJsonFromUrl (String mUrl) {
        String data = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL insideUrl = new URL(mUrl);
            httpURLConnection = (HttpURLConnection) insideUrl.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader mBuffer = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();

            String inputLine = "";
            while ((inputLine = mBuffer.readLine())!= null){
                stringBuffer.append(inputLine);
            }

            data = stringBuffer.toString();
            mBuffer.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();
        }



        return  data;
    }

}
