package com.opensource.nathalia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextPhone;
    private EditText editTextEmail;
    private Button buttonSave;
    private Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = (EditText)findViewById(R.id.editTextName);
        editTextPhone = (EditText)findViewById(R.id.editTextPhone);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        buttonSave = (Button)findViewById(R.id.buttonSave);
        buttonCancel = (Button)findViewById(R.id.buttonCancel);
    }

    public void Onclick(View view)
    {
        Controller controller = new Controller(this);
        controller.add();
        controller.show();
        controller.remove();
        controller.remove();

    }

    protected String doPost() throws Exception
    {
        String response = "";

        try
        {
            URL url = new URL("http://10.0.2.2/webAgenda/servlet/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            OutputStream out = conn.getOutputStream();
            InputStream in = conn.getInputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));

            writer.flush();
            writer.close();
            out.close();

//          ObjectInputStream in = new ObjectInputStream(url.openConnection().getInputStream());
//          ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
//          out.writeObject(in);


            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK)
            {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                while ((line = br.readLine()) != null)
                {
                    response += line;
                }
            }

            else
            {
                response = "";
            }

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

        return response;

    }

    // HttpUrlConnection instead HttpServlet
    // android = 10021
}
