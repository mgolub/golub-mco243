package golub.mco243.downloadLotsOfImages;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class IgnoreOperations {
	
	public static void main(String[] args){
		
		ExecutorService service = Executors.newFixedThreadPool(6);
		final AtomicInteger total = new AtomicInteger(0);
		final AtomicBoolean allowed = new AtomicBoolean(true);
		
		for (int i = 0; i < 10000; i++){
			
		}
	}

}
