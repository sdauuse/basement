package com.miao.list;

public class StudentEnhanceId extends Student{
    private int id;

    public StudentEnhanceId() {
    }

    public StudentEnhanceId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentEnhanceId{id = " + id + "}";
    }
}
