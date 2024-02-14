package com.chat;



import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zkmax.ui.select.annotation.Subscribe;

public class chat2usingannotation  extends SelectorComposer<Component> {
    @Subscribe(value = "queue1" , scope = EventQueues.APPLICATION)
    public void receive(Event event) {
        Object data = event.getData();
        alert((String)data);
    }
    
}
