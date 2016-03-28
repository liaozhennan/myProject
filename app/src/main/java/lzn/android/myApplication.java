package lzn.android;

import android.app.Application;

import lzn.android.request.RequestQueueSingleLeton;

/**
 * Created by Allen on 2016/3/24.
 */
public class myApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RequestQueueSingleLeton.getInstance(this.getApplicationContext());
    }
}
