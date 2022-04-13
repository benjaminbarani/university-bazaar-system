package com.example.signup;

public class BazaarItem {
    private String titleString;
    private String descriptionString;
    private String postString;
    BazaarItem(String text1, String text2, String text3)
    {
        titleString = text1;
        descriptionString = text2;
        postString = text3;
    }
    public String getTitleString()
    {
        return titleString;
    }
    public String getDescriptionString()
    {
        return descriptionString;
    }
    public String getPostString()
    {
        return postString;
    }
}
