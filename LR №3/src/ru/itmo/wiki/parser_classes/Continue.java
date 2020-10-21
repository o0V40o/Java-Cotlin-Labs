package ru.itmo.wiki.parser_classes;

import java.util.HashMap;
import java.util.Map;

public class Continue {

    public Long sroffset;
    public String _continue;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Continue(Long sroffset, String _continue, Map<String, Object> additionalProperties) {
        this.sroffset = sroffset;
        this._continue = _continue;
        this.additionalProperties = additionalProperties;
    }
}