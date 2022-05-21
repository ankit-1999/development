package com.nagarro.trainee.advanceJava.thread;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.trainee.advanceJava.constant.Constant;
import com.nagarro.trainee.advanceJava.service.impl.TshirtServiceImpl;

public class WatcherService implements Runnable {
	
	@Autowired
	TshirtServiceImpl ip=new TshirtServiceImpl();

	public void run() {
		// TODO Auto-generated method stub
		
		try {
            
			// watch service to check if any modification is done in folder.if it is then it
			// will return an event i.e what type of event is fired
			System.out.println("watch service start ");
			WatchService watchservice =FileSystems.getDefault().newWatchService();
			Path path = Paths.get(Constant.FILEPATH); // path of file on which we will use watch services
			WatchKey key = path.register(watchservice, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
			while (true) {
				// key.pollEvents() will return list of all events accourred in registered path
				if (key.pollEvents().size() != 0) {
					
					System.out.println("modification done in csvFiles folder");
					ip.truncateTable();
					ip.praseFromCsv();
					

				}
				/*
				 * for(WatchEvent<?> event: key.pollEvents()) {
				 * System.out.println("event type "+event.kind()+
				 * "file effected"+event.context()); break; }
				 */
				try {
					Thread.sleep(20000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
