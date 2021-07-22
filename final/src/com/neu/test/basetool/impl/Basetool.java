package com.neu.test.basetool.impl;

import com.neu.test.pojo.impl.Paper;

public class Basetool {
    private static Paper tool_p;
    public  static void set_chosen_paper(Paper p)
    {
        tool_p=p;
    }
    public static Paper get_chosen_paper()
    {
        return tool_p;
    }
}
