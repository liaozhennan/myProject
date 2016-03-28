package lzn.android;

import android.app.Activity;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by Allen on 2016/3/24.
 */
public class BaseActivity extends Activity  {
    Response.ErrorListener mErrListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            if(volleyError.getMessage() != null)
            {
                Log.e("volleyError", volleyError.getMessage());
                Log.e("volleyError", volleyError.getMessage());
            }

        }
    };

}
