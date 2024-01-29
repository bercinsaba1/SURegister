package com.example.finalproject;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ClassRepository {
    public static final String CS = "1";
    public static final String ENS = "2";
    public static final String MATH = "3";
    public static final String MGMT = "4";
    public static final String PSY = "5";

    public void classItems(ExecutorService srv, Handler uiHandler) {
        List<ClassItem> retVal = new ArrayList<>();

        srv.execute(() -> {

            URL url;
            try {
                url = new URL("http://10.51.63.21:8080/suregister/getallc");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);

                }


                JSONArray arr = new JSONArray(stringBuilder.toString());

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject course = arr.getJSONObject(i);
                    List<Comment> commentsList = new ArrayList<>();
                    JSONArray newarr = course.getJSONArray("comments");

                    for (int j = 0; j < newarr.length(); j++) {
                        JSONObject newobj = newarr.getJSONObject(j);
                        commentsList.add(new Comment(newobj.getString("comment"), newobj.getString("commander")));
                    }


                    retVal.add(new ClassItem(course.getInt("capacity"), course.getInt("attendnum"),
                            course.getString("name"), course.getString("about"),
                            course.getString("instructor"), course.getString("info"), commentsList));
                    Log.i("DEV", "birincide" + commentsList.toString());
                }


            } catch (MalformedURLException e) {
                Log.e("DEV", e.getMessage());

            } catch (IOException e) {
                Log.e("DEV", e.getMessage());
            } catch (JSONException e) {
                Log.e("DEV", e.getMessage());
            }
            Message msgErr = new Message();
            msgErr.obj = retVal;
            uiHandler.sendMessage(msgErr);

        });


    }

    public void ClassItemsByCategoryId(ExecutorService srv, Handler uiHandler, String name) {  // in our API as class name
        List<ClassItem> retVal = new ArrayList<>();
        srv.execute(() -> {

            try {
                String courseCode = "";
                URL url = new URL("http://10.51.63.21:8080/suregister/getallc");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);

                }

                JSONArray arr = new JSONArray(stringBuilder.toString());

                if (name.equals(CS)) {
                    courseCode = "CS";
                } else if (name.equals(ENS)) {
                    courseCode = "ENS";
                } else if (name.equals(MATH)) {
                    courseCode = "MATH";
                } else if (name.equals(MGMT)) {
                    courseCode = "MGMT";
                } else if (name.equals(PSY)) {
                    courseCode = "PSY";
                }

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject course = arr.getJSONObject(i);
                    List<Comment> commentsList = new ArrayList<>();
                    JSONArray newarr = course.getJSONArray("comments");


                    for (int j = 0; j < newarr.length(); j++) {
                        JSONObject newobj = newarr.getJSONObject(j);
                        String commentt = newobj.getString("comment".toString());
                        String commanderr = newobj.getString("commander".toString());

                        commentsList.add(new Comment(commentt, commanderr));


                    }


                    if (course.getString("name").startsWith(courseCode)) {
                        retVal.add(new ClassItem(course.getInt("capacity"), course.getInt("attendnum"),
                                course.getString("name"), course.getString("about"),
                                course.getString("instructor"), course.getString("info"), commentsList));
                        Log.i("DEV", "ikincide" + commentsList.toString());
                    }
                }
                conn.disconnect();

            } catch (MalformedURLException e) {
                Log.e("DEV", e.getMessage());
            } catch (IOException e) {
                Log.e("DEV", e.getMessage());
            } catch (JSONException e) {
                Log.e("DEV", e.getMessage());
            }


            Message msgErr = new Message();
            msgErr.obj = retVal;
            uiHandler.sendMessage(msgErr);


        });


    }

    public void isUser(ExecutorService srv, Handler uiHandler, String username,String password) {
        srv.submit(()->{

            try {
                URL url = new URL("http://10.51.63.21:8080/suregister/searchbynames/" + username);

                HttpURLConnection conn = null;
                try {
                    conn = (HttpURLConnection) url.openConnection();


                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));


                    String line = "";
                    StringBuilder builder = new StringBuilder();

                    while((line = reader.readLine()) != null){
                        builder.append(line);
                    }


                    try {
                        JSONArray newarr = new JSONArray(builder.toString());
                        if(newarr.toString().length() != 2) {
                            JSONObject newobj = (newarr.getJSONObject(0));
                            Log.i("DEV", newobj.toString());
                            Log.i("DEV", newobj.getString("password"));
                            Log.i("DEV", password);
                            if(newobj.getString("password").equals(password)){

                                Message msg = new Message();
                                msg.what = 1;
                                uiHandler.sendEmptyMessage(msg.what);

                            }
                            else{
                                Message msg = new Message();
                                msg.what = 0;
                                uiHandler.sendEmptyMessage(msg.what);
                            }

                        }else{
                            Message msg = new Message();
                            msg.what = 0;
                            uiHandler.sendEmptyMessage(msg.what);
                        }
                        conn.disconnect();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }






                } catch (IOException e) {
                    throw new RuntimeException(e);
                }







            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }


        });


    }
    public void SıgnUp(ExecutorService srv, Handler uiHandler, String name, String password){

        srv.submit(()->{

            try {
                URL url = new URL("http://10.51.63.21:8080/suregister/assignstudent");


                try {
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/JSON");
                    JSONObject outputData = new JSONObject();

                    try {
                        outputData.put("username", name);
                        outputData.put("password", password);

                        Log.i("DEV","burdayız bebek");
                        Log.i("DEV",outputData.toString());


                        BufferedOutputStream writer = new BufferedOutputStream(conn.getOutputStream());

                        writer.write(outputData.toString().getBytes(StandardCharsets.UTF_8));

                        writer.flush();


                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                        String line = "";
                        StringBuilder builder = new StringBuilder();

                        while((line = reader.readLine()) != null){

                            builder.append(line);

                        }
                        Message msg = new Message();
                        msg.obj = builder.toString();
                        uiHandler.sendMessage(msg);

                        conn.disconnect();

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }


        });


    }
}






