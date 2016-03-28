package lzn.android;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

import lzn.android.request.requestManager;

public class MainActivity extends BaseActivity{
    private TextView mvTextView;
    private requestManager mRequestManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRequestManager = requestManager.getInstance(this);
        initView();
//        PraseXmlTest();
        NetRequest();



    }

    private void initView() {
        mvTextView = (TextView) this.findViewById(R.id.tv);
    }

    private void NetRequest() {
       new LoadTestAsyncTask().execute();
    }

    private class LoadTestAsyncTask extends AsyncTask<Void,Void,String>
    {
        @Override
        protected String doInBackground(Void... params) {
//            mvRequest.doGetRequest();
            mRequestManager.getData("",mListener,mErrListener );
            return null ;
        }
    }
    private void setData(String pStr)
    {
        mvTextView.setText(pStr);
    }
    Response.Listener mListener = new Response.Listener() {
        @Override
        public void onResponse(Object o) {
            String Str = ((String) o);
            setData(Str);
        }
    };

    private void PraseXmlTest() {
        try {
            Serializer serializer = new Persister();
            Lure lure = new Lure();
            lure.setCompany("Donzai");
            lure.setModel("Marlin Buster");
            lure.setQuantityInStock(23);
            lure.setType("Trolling");
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            Log.e("path", path.getName());
            File result = new File(path,"/lure.xml");
            serializer.write(lure, result);

            File source = new File(path,"/lure.xml");
            Lure lure1 = serializer.read(Lure.class, source);

            System.out.println(lure1.getCompany());
            System.out.println(lure1.getModel());
            System.out.println(lure1.getQuantityInStock());
            System.out.println(lure1.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
