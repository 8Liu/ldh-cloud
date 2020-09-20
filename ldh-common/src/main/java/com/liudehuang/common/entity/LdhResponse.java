package com.liudehuang.common.entity;

import java.util.HashMap;

public class LdhResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public LdhResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public LdhResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public LdhResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}
