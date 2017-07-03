package com.iwuyc.microservice.rank.bean;

public class TableInfo
{
    /**
     * 餐台号
     */
    private String tableId;

    /**
     * 就餐人数
     */
    private int dinerNum;

    public String getTableId()
    {
        return tableId;
    }

    public void setTableId(String tableId)
    {
        this.tableId = tableId;
    }

    public int getDinerNum()
    {
        return dinerNum;
    }

    public void setDinerNum(int dinerNum)
    {
        this.dinerNum = dinerNum;
    }

    @Override
    public String toString()
    {
        return "TableInfo [tableId=" + tableId + ", dinerNum=" + dinerNum + "]";
    }

}
