package com.example.emergency;

import android.widget.EditText;

public class userphone
{
    String phno1,phno2,phno3;
    public userphone()
    {

    }
    public userphone(String phno1, String phno2, String phno3) {

        this.phno1 = phno1;
        this.phno2 = phno2;
        this.phno3 = phno3;
    }

    public String getPhno1() {
        return phno1;
    }

    public void setPhno1(String phno1) {
        this.phno1 = phno1;
    }

    public String getPhno2() {
        return phno2;
    }

    public void setPhno2(String phno2) {
        this.phno2 = phno2;
    }

    public String getPhno3() {
        return phno3;
    }

    public void setPhno3(String phno3) {
        this.phno3 = phno3;
    }


}
