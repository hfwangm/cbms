package com.cbms.commons.web.taglib;

/**
 * Created by Administrator on 2015/3/18.
 */
public class BSRadioButtonsTag extends BSAbstractMultiCheckedElementTag {
    private static final long serialVersionUID = 6257615872362092808L;

    @Override
    protected String getInputType() {
        return "radio";
    }
}
