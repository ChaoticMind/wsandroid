package fi.bitrite.android.ws.activity;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import fi.bitrite.android.ws.search.Search;

public class SearchThread extends Thread {
	
	Handler handler;
	Search search;

	public SearchThread(Handler handler, Search search) {
		this.handler = handler;
		this.search = search;
	}
	
	public void run() {
		Message msg = handler.obtainMessage();
		
		try {
			msg.obj = search.doSearch();
		}
		
		catch (Exception e) {
			Log.e("WSAndroid", e.getMessage(), e);
			msg.obj = e;
		}
		
		handler.sendMessage(msg);
	}

}
