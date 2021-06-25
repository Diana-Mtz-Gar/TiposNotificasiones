package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button botoninbox;
    private Button boton;
    private Button botonaccion;
    NotificationCompat.Builder notificacion;
    private static final int idUnico = 454542;
    String CHANNEL_ID;
    private NotificationManager notificationManager;
    private Intent intent;
    private Intent intent2;
    private PendingIntent pendingIntent;
    private PendingIntent siPendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonaccion = (Button) findViewById(R.id.botonaccion);
        botoninbox = (Button) findViewById(R.id.botoninbox);
        boton = (Button) findViewById(R.id.boton);


        CHANNEL_ID = getApplicationContext().getString(R.string.app_name);

        notificacion = new NotificationCompat.Builder(this, CHANNEL_ID);
        notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        intent = new Intent(this, MainActivity.class);
        intent2 = new Intent(this, Ir.class);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    String name = "Notificación";

                    NotificationChannel notificationChannel =
                            new NotificationChannel(CHANNEL_ID, name, importance);

                    notificationChannel.enableVibration(true);

                    notificationManager.createNotificationChannel(notificationChannel);

                    pendingIntent =
                            PendingIntent.getActivity(MainActivity.this,
                                    0,
                                    intent,
                                    PendingIntent.FLAG_UPDATE_CURRENT);

                    notificacion.setSmallIcon(R.mipmap.ic_launcher);
                    notificacion.setTicker("Nueva notificación");
                    notificacion.setWhen(System.currentTimeMillis());
                    notificacion.setContentTitle("Título");
                    notificacion.setContentText("Notificación de prueba");
                    notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    notificacion.setAutoCancel(true);
                    notificacion.setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                    notificacion.setContentIntent(pendingIntent);

                    notificationManager.notify(idUnico, notificacion.build());
                }
            }
        });
        botoninbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    String name = "Notificación";

                    NotificationChannel notificationChannel =
                            new NotificationChannel(CHANNEL_ID, name, importance);

                    notificationChannel.enableVibration(true);

                    notificationManager.createNotificationChannel(notificationChannel);

                    pendingIntent =
                            PendingIntent.getActivity(MainActivity.this,
                                    0,
                                    intent,
                                    PendingIntent.FLAG_UPDATE_CURRENT);

                    notificacion.setSmallIcon(R.mipmap.ic_launcher);
                    notificacion.setTicker("Nueva notificación");
                    notificacion.setWhen(System.currentTimeMillis());
                    notificacion.setContentTitle("Notificasión de tipo inbox");
                    notificacion.setContentText("Se tiene la siguiente información");
                    notificacion.setStyle(new NotificationCompat.InboxStyle()
                            .addLine("Este es el mensaje 1")
                            .addLine("Este es el mensaje 2")
                            .addLine("Este es el mensaje 3")
                            .addLine("Este es el mensaje 4")
                            .setSummaryText("+ 2 mas"));
                    notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    notificacion.setAutoCancel(true);
                    notificacion.setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                    notificacion.setContentIntent(pendingIntent);

                    notificationManager.notify(idUnico, notificacion.build());
                }
            }
        });


        botonaccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    String name = "Notificación";

                    NotificationChannel notificationChannel =
                            new NotificationChannel(CHANNEL_ID, name, importance);

                    notificationChannel.enableVibration(true);

                    notificationManager.createNotificationChannel(notificationChannel);

                    pendingIntent =
                            PendingIntent.getActivity(MainActivity.this,
                                    0,
                                    intent,
                                    PendingIntent.FLAG_UPDATE_CURRENT);

                    siPendingIntent =
                            PendingIntent.getActivity( MainActivity.this,
                                    0,
                                    intent2,
                                    PendingIntent.FLAG_UPDATE_CURRENT);

                    notificacion.setSmallIcon(R.mipmap.ic_launcher);
                    notificacion.setTicker("Nueva notificación");
                    notificacion.setWhen(System.currentTimeMillis());
                    notificacion.setContentTitle("Requiere Acción");
                    notificacion.setContentText("Notificación de acción");
                    notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                    notificacion.setAutoCancel(true);
                    notificacion.setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                    notificacion.addAction(R.drawable.ic_baseline_arrow_forward_24, "Ir",siPendingIntent);

                    notificacion.addAction(R.drawable.ic_baseline_delete_forever_25, "Menu",pendingIntent);
                    notificationManager.notify(idUnico, notificacion.build());
                }
            }
        });
    }
}