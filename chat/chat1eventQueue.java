package com.chat;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueue;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;

public class chat1eventQueue extends SelectorComposer<Component>{
	
	@Wire
	Textbox t1;
    @Listen("onClick=#b1")
    public void post() {
    	String text =t1.getValue();
    	if(text.length() >0) {
    		t1.setValue("");
    	EventQueue<Event> q = EventQueues.lookup("queue1",EventQueues.APPLICATION,true);
    	q.publish(new Event("onChat",null,text));
    	}
    }

}
