package com.example.eventfull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class LoginActivity extends AppCompatActivity {

    private EditText txtUserName = null;
    private EditText txtPassword = null;
    private JSONArray jsa = null;

    //The read() method essentially reads the file Users.txt and return a JsonArray with the data needed
    private JSONArray read(){
        //variables needed for reading the file
        FileInputStream fis;
        BufferedReader br;
        InputStreamReader isr;
        StringBuilder json = new StringBuilder();
        JSONArray jsa = null;
        try {

            fis = openFileInput("Users.txt"); //opens the saved file Users.txt and reads in bytes
            isr = new InputStreamReader(fis); //converts bytes to characters
            br = new BufferedReader(isr); //used to increase efficiency of reading characters
            String line;
            while((line = br.readLine())!=null){ //reads each line till the end
                json.append(line).append("\n"); //concatenates the string from file to json variable
            }

        } catch (FileNotFoundException e) { //catch exception
            e.printStackTrace();
        } catch (IOException e) { //catch exception
            e.printStackTrace();
        }
        try {
            jsa = new JSONArray(json.toString()); // converts the json string to a jsonArray
        } catch (JSONException e) { //catch exception
            e.printStackTrace();
        }
        return jsa; //returns jsonArray
    }

    //onCreate() method invoked once the application starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        jsa = read(); //initializes JsonArray with the data in file using method read()
        Button btnGet = findViewById(R.id.btnLogin);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    //login method verifies the username and password from jsonArray
    public void login(){
        User user;
        JSONObject jso = search(txtUserName.getText().toString(),jsa); //searches the needed JsonObject
        try {
            if(jso!=null){
                //if statement to check if the username and password are correct
                if((txtUserName.getText().toString().equals(jso.getString("userName"))) &&
                        (txtPassword.getText().toString().equals(jso.getString("Password")))){
                    //Switch statement to initialize users to the correct type
                    switch (jso.getString("type")) {
                        default:
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                        case "Admin":
                            user = new Admin(Integer.parseInt(jso.getString("id")),
                                    jso.getString("firstName"), jso.getString("lastName"),
                                    jso.getString("email"), jso.getString("userName"),
                                    jso.getString("Password"));
                            break;
                        case "member":
                            user = new Member(Integer.parseInt(jso.getString("id")),
                                    jso.getString("firstName"), jso.getString("lastName"),
                                    jso.getString("email"), jso.getString("userName"),
                                    jso.getString("Password"));
                            break;
                        case "seasonTicketHolder":
                            Toast.makeText(getApplicationContext(), "SeasonTicketHolder", Toast.LENGTH_LONG).show();
                            user = new SeasonTicketHolder(Integer.parseInt(jso.getString("id")),
                                    jso.getString("firstName"), jso.getString("lastName"),
                                    jso.getString("email"), jso.getString("userName"),
                                    jso.getString("Password"));
                            break;
                        case "staff":
                            user = new Staff(Integer.parseInt(jso.getString("id")),
                                    jso.getString("firstName"), jso.getString("lastName"),
                                    jso.getString("email"), jso.getString("userName"),
                                    jso.getString("Password"));
                            break;
                    }
                    Toast.makeText(getApplicationContext(),"Login Successful : user is"+ user.getClass(),Toast.LENGTH_LONG).show();
                    //nextActivity

                }else{
                    Toast.makeText(getApplicationContext(),"Login Failed UserName or Password incorrect",Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(getApplicationContext(),"Login Failed UserName does not exist",Toast.LENGTH_LONG).show();
            }
        }catch (JSONException e){ //catch exception
            e.printStackTrace();
        }
    }

    // searches for username within array and returns a jsonObject
   public JSONObject search(String userName, JSONArray jsa){
        JSONObject jso = null;
        for(int i = 0;i<jsa.length();i++){
            try {
                if(jsa.getJSONObject(i).getString("userName").equals(userName)){
                    jso = jsa.getJSONObject(i);
                }

            } catch (JSONException e) { //catch Exception
                e.printStackTrace();
            }
        }

        if (jso != null){
            return jso;
        }
        return null;
   }

}
