package Entity;

import java.time.LocalDate;

/**
 * @author: qujundong
 * @date: 2020/11/28 下午6:34
 * @description:
 */
public class Man extends Person {
    private boolean sex;
    public Man(int id, String name, LocalDate localDate, boolean sex) {
        super(id, name, localDate);
        this.sex = sex;
    }

    @Override
    public String toString() {
        return super.toString() + " Man{" +
                "sex=" + sex +
                '}';
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
