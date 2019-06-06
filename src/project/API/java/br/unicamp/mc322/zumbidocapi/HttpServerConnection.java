package br.unicamp.mc322.zumbidocapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class HttpServerConnection {
    private static final String LINE_FEED = "\r\n";
    private static final String SERVER = "http://54.233.231.92:5000/";

    public int get(String getUrl, StringBuilder sb) throws Exception {
        URL url = new URL(SERVER+getUrl);
        HttpURLConnection httpConn;
        httpConn = (HttpURLConnection) url.openConnection();    	
        httpConn.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(httpConn.getInputStream(),Charset.forName("UTF-8")));
        String output;
        while ((output = br.readLine()) != null) {
          sb.append(output);
        }
        return httpConn.getResponseCode();
    }
        
	public void sendFile(File uploadFile) throws Exception {
        String boundary = "===" + System.currentTimeMillis() + "===";
        URL url = new URL(SERVER+"dataset/upload");
        HttpURLConnection httpConn;
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true);    // indicates POST method
        httpConn.setDoInput(true);
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + boundary);
        OutputStream outputStream = httpConn.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"),
                true);		
        String fileName = uploadFile.getName();
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append(
                "Content-Disposition: form-data; name=\"" + "file"
                        + "\"; filename=\"" + fileName + "\"")
                .append(LINE_FEED);
        writer.append(
                "Content-Type: "
                        + "text/csv")
                .append(LINE_FEED);
        writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.flush();

        FileInputStream inputStream = new FileInputStream(uploadFile);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.flush();
        inputStream.close();
        writer.append("--" + boundary+"--").append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.flush();		
        
        System.out.println(httpConn.getResponseCode());
	}
}
