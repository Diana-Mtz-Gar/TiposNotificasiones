package com.example.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
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

        botonaccion = (Button) findViewById(R.id.botonaccion);
        botoninbox = (Button) findViewById(R.id.botoninbox);
        boton = (Button) findViewById(R.id.boton);


        CHANNEL_ID = getApplicationContext().getString(R.string.app_name);

        notificacion = new NotificationCompat.Builder(this, CHANNEL_ID);
        notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        intent = new Intent(this, MainActivity.class);
        intent2 = new Intent(this, MainActivity2.class);


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
                    notificacion.addAction(R.mipmap.ic_launcher, "Ir",siPendingIntent);

                    notificacion.addAction(R.mipmap.ic_baseline_delete_forever_25, "Menu",pendingIntent);
                    notificationManager.notify(idUnico, notificacion.build());
                }
            }
        });
        /*botonpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    String name = "Notificación";

                    NotificationChannel notificationChannel =
                            new NotificationChannel(CHANNEL_ID, name, importance);

                    List <Notification> pages = new ArrayList<Notification>();
                    for (int i = 1; i <= 3; i++){
                        nt = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                                .setContentTitle("Notificasión" + i)
                                .setContentText("descripción de la notificasion en página" + i)
                                .build();
                        pages.add(nt);
                    }

                    werableExtender = new Notification.WearableExtender().addPages(pages);
                    notificationManager.createNotificationChannel(notificationChannel);

                    pendingIntent =
                            PendingIntent.getActivity(MainActivity.this,
                                    0,
                                    intent,
                                    PendingIntent.FLAG_UPDATE_CURRENT);

                    notificacion = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Nueva notificasión")
                            .setContentText("ejemplo de notificasiones de paginas");
                    notificationManager.notify(idUnico, notificacion.build());
                }
            }
        });*/
    }
}