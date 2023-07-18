package com.github.shiyajian.order.event;

import com.github.shiyajian.support.event.Event;
import lombok.Data;

/**
 * @author shiyajian
 * create: 2023-05-09
 */
@Data
public class HelloCreateEvent implements Event {

    private Long id;

    @Override
    public String eventName() {
        return "hello.create.event";
    }
}
