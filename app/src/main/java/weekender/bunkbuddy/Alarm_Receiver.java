package weekender.bunkbuddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Raj Kamdar on 08-01-2017.
 */
public class Alarm_Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service1 = new Intent(context, Notification_Service.class);
        service1.setData((Uri.parse("custom://" + System.currentTimeMillis())));
        context.startService(service1);
    }
}
