package com.company;
import java.io.Serializable;

public  class Number  implements Serializable
{
    private String region;
    private Integer number;
    private String word_code;

    public Number(String region, Integer number, String word_code)
    {
        this.region=region;
        this.number=number;
        this.word_code=word_code;
    }

    @Override
    public boolean equals(Object obj)
    {
                Number o=(Number)obj;
                if (this.region.equals(o.region) && (this.number==o.number && this.word_code==o.word_code)) return true; else return false;
    }

    @Override
    public String toString() {
        return region+" "+number+" "+word_code;
    }
}