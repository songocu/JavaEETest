package timers;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

@Singleton
@Startup
public class SchejuledTimer {
	@Schedule(minute = "*/1", hour = "*", info = "myScheduledTimer", persistent = false)
	public void schedule(Timer timer) {
		System.out.println(
				this + "Squeduler executed now and ever minute " + new Date() + " using timer " + timer.getInfo());
	}
}
