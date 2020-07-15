package com.example.notification_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.AndroidViewModel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.util.AndroidException;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notification( View view) {
        //any notification following things are mandatory
        /*smallIcon
        title
        Description
         */
        //three imp components
        /*notificationmanager(this can issue a notification or channel or not)
        notificationchannel(we can send notification on orea and above)
        notificationcompat.buider(to build notification)
         */
        NotificationManager nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            //we have to create a notification channel
            NotificationChannel nc =new NotificationChannel("Srm","Srmnotification",NotificationManager.IMPORTANCE_HIGH);
            nm.createNotificationChannel(nc);
        }
        //we have to write normally notification code
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"srm");
        builder.setSmallIcon(R.drawable.umbrella);
        builder.setContentTitle("sample notification");
        builder.setContentText("this is description of the notification");
        builder.setAutoCancel(true);
        /*pending intent :
        -it is description of the operation to be performed
        can be created using following method
        1)getActivity()-if we want to open an activity
        2)getService() -if we want to start a service with pending intent
        3)getBroadcast()-if we want send a broadcast withh pending intend
        ----requires 4 arguments
        context
        pending intent id
        intnet(action that you want to preform)
        flag(this flag will tell the existing pending intent about what to if there is a  new pending intent arrival)
         */
        PendingIntent pi=PendingIntent.getActivity(this,42, new Intent(this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        /*step-1 to convert any format img want ot display into to a bitmap image format
        2-is to create bigpicture style before you issue the notification
         */
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.srm);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));

        nm.notify(42,builder.build());


    }
}