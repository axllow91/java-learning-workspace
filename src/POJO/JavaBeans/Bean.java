package POJO.JavaBeans;

public class Bean {
    private Integer property;

    Bean() {
        // no-arg constructor
    }

    public void setProperty(Integer property) {
        if(property == 0) {
            return;
        }
        this.property = property;
    }

    public Integer getProperty() {
        if(property == 0) {
            return null;
        }
        return property;
    }
}

class GFG {
    public static void main(String[] args) {
        Bean bean = new Bean();

        bean.setProperty(0);
        System.out.println("After setting to 0: " + bean.getProperty());

        bean.setProperty(5);
        System.out.println("After setting to 5: " + bean.getProperty());
    }
}
