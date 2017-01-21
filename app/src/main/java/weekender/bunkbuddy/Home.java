package weekender.bunkbuddy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView home_lv;
    DBHelper db;
    ArrayList<String> AL_name;
    ArrayList<Integer> AL_attended,AL_total;
    HomeAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        home_lv= (ListView) findViewById(R.id.home_lv);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        AL_name=new ArrayList<String>();
        AL_total=new ArrayList<Integer>();
        AL_attended=new ArrayList<Integer>();

        db=DBHelper.getInstance(getApplicationContext());

        Cursor sub=db.getAllSubjects();
        if(sub.getCount()==0)
            Toast.makeText(this, "NO DATA", Toast.LENGTH_LONG).show();
        else
        {
            int index=0;
            while(sub.moveToNext())
            {
                AL_name.add(index,sub.getString(1));

                Cursor sub2=db.getTotalLectures(sub.getInt(0));

                while(sub2.moveToNext())
                {
                    AL_total.add(index,sub2.getInt(0));
                }


                Cursor sub3=db.getAttendedLectures(sub.getInt(0));

                while(sub3.moveToNext())
                {
                    AL_attended.add(index,sub3.getInt(0));
                }

                index++;
            }

            itemsAdapter = new HomeAdapter(this,AL_name,AL_attended,AL_total);
            home_lv.setAdapter(itemsAdapter);

        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent mIntent=new Intent(Home.this,AddAttendance.class);
                //mIntent.putExtra("day",dayOfTheWeek);
                startActivity(mIntent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);







       /* AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(Home.this, Alarm_Receiver.class); // AlarmReceiver1 = broadcast receiver

        PendingIntent pendingIntent = PendingIntent.getBroadcast(  Home.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmIntent.setData((Uri.parse("custom://"+System.currentTimeMillis())));
        alarmManager.cancel(pendingIntent);

        Calendar alarmStartTime = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        alarmStartTime.set(Calendar.HOUR_OF_DAY, 3);
        alarmStartTime.set(Calendar.MINUTE, 30);
        alarmStartTime.set(Calendar.SECOND, 0);
        if (now.after(alarmStartTime)) {
            Log.d("Hey","Added a day");
            alarmStartTime.add(Calendar.DATE, 8);
        }

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
*/


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Subjects) {
            startActivity(new Intent(this,Subjects.class));
        } else if (id == R.id.nav_Timetable) {
            startActivity(new Intent(this,TimeTable.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
