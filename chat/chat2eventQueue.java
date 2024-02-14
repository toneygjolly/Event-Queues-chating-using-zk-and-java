package com.chat;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueue;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;

public class chat2eventQueue extends SelectorComposer<Component>{
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		EventQueue<Event> que = EventQueues.lookup("queue1",EventQueues.APPLICATION,true);
		que.subscribe(new EventListener() {
			public void onEvent(Event evt) {
				new Label((String)evt.getData()).setParent(comp);
				Messagebox.show("Received message: " +evt.getData());
				
			}
		});
	}
	

}
