package Entity;

/**
 * @author: qujundong
 * @date: 2020/12/6 上午9:00
 * @description:
 */
public class Plant {

    public enum LifeCycle{ANNUAL, PERENNIAL, BIENNIAL}
    final String name;
    public final LifeCycle lifeCycle;
    public Plant(String name, LifeCycle lifeCycle){
        this.name = name;
        this.lifeCycle = lifeCycle;
    }
    @Override
    public String toString(){
        return name;
    }

}
