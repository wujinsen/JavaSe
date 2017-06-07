//package cn.wjs.http;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.List;
//import java.util.zip.GZIPInputStream;
//
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.logging.Log;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpDelete;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.conn.HttpHostConnectException;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//
///**
// * @author 吴锦森 
// * @version 创建时间：2015年5月12日
// * 类说明
// */
//public class JSONHttpClient {
//	public <T> T PostObject(final String url, final T object,
//            final Class<T> objectClass) throws Exception {
//        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost(url);
//        try {
//            String data = new GsonBuilder().create().toJson(object);
//            StringEntity stringEntity = new StringEntity(data);
//            httpPost.setEntity(stringEntity);
//            httpPost.setHeader("Accept", "application/json");
//            httpPost.setHeader("Content-type", "application/json");
//            httpPost.setHeader("Accept-Encoding", "gzip");
//            HttpResponse httpResponse = defaultHttpClient.execute(httpPost);
//            if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                HttpEntity httpEntity = httpResponse.getEntity();
//                if (httpEntity != null) {
//                    InputStream inputStream = httpEntity.getContent();
//                    org.apache.http.Header contentEncoding = httpResponse
//                            .getFirstHeader("Content-Encoding");
//                    if (contentEncoding != null
//                            && contentEncoding.getValue().equalsIgnoreCase(
//                                    "gzip")) {
//                        inputStream = new GZIPInputStream(inputStream);
//                    }
//                    String resultString = convertStreamToString(inputStream);
//                    inputStream.close();
//                    return new GsonBuilder().create().fromJson(resultString,
//                            objectClass);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(ServiceUrl.G_Log_Flag, "Result:" + e.getMessage());
//            throw e;
//        }
//        return null;
//    }
// 
//    public <T> T PostParams(String url, final List<NameValuePair> params,
//            final Class<T> objectClass) throws Exception {
//        String paramString = URLEncodedUtils.format(params, "utf-8");
//        url += "?" + paramString;
//        return PostObject(url, null, objectClass);
//    }
// 
//    private String convertStreamToString(InputStream inputStream) {
//        BufferedReader bufferedReader = new BufferedReader(
//                new InputStreamReader(inputStream));
//        StringBuilder stringBuilder = new StringBuilder();
//        String line = null;
//        try {
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return stringBuilder.toString();
//    }
//    public <T> T Get(String url, List<NameValuePair> params,
//            final Class<T> objectClass) {
//        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//        String paramString = URLEncodedUtils.format(params, "utf-8");
//        url += "?" + paramString;
//        HttpGet httpGet = new HttpGet(url);
//        try {
//            httpGet.setHeader("Accept", "application/json");
//            HttpResponse httpResponse = defaultHttpClient.execute(httpGet);
//            if (httpResponse != null
//                    && httpResponse.getStatusLine().getStatusCode() == 200) {
//                HttpEntity httpEntity = httpResponse.getEntity();
//                if (httpEntity != null) {
//                    InputStream inputStream = httpEntity.getContent();
//                    String resultString = convertStreamToString(inputStream);
//                    inputStream.close();
//                    return new GsonBuilder().enableComplexMapKeySerialization()
//                            .create().fromJson(resultString, objectClass);
//                } else
//                    return null;
//            } else
//                return null;
// 
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(ServiceUrl.G_Log_Flag, "Result:" + e.getMessage());
//            return null;
//        }
//    }
// 
//    public String Get(String url, List<NameValuePair> params) {
// 
//        String requestUrl = url;
//        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//        String paramString = URLEncodedUtils.format(params, "utf-8");
//        url += "?" + paramString;
//        HttpGet httpGet = new HttpGet(url);
//        try {
//            httpGet.setHeader("Accept", "application/json");
//            HttpResponse httpResponse = defaultHttpClient.execute(httpGet);
//            if (httpResponse != null
//                    && httpResponse.getStatusLine().getStatusCode() == 200) {
//                HttpEntity httpEntity = httpResponse.getEntity();
//                if (httpEntity != null) {
//                    InputStream inputStream = httpEntity.getContent();
//                    String resultString = convertStreamToString(inputStream);
//                    inputStream.close();
//                    return resultString;
//                } else
//                    return "";
//            } else
//                return "error:" + httpResponse.getStatusLine().getStatusCode();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (e.getClass() == HttpHostConnectException.class)
//                return "error:" + "通信异常，请检查网络，请求：" + requestUrl + ",错误描述："
//                        + e.getMessage();
//            else
//                return "error:" + e.getMessage();
//        }
//    }
// 
//    public boolean Delete(String url, final List<NameValuePair> params) {
//        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
//        String paramString = URLEncodedUtils.format(params, "utf-8");
//        url += "?" + paramString;
//        HttpDelete httpDelete = new HttpDelete(url);
//        HttpResponse httpResponse = null;
//        try {
//            httpResponse = defaultHttpClient.execute(httpDelete);
//            return httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_NO_CONTENT;
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.e(ServiceUrl.G_Log_Flag, "Result:" + e.getMessage());
//        }
//        return false;
//    }
//}
