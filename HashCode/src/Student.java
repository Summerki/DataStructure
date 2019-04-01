import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;

public class Student {

    int grade;
    int cls;
    String firstName;
    String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // 重写hashCode方法
    // 如果调用Object类的hashCode方法，则会根据地址生成hashCode值
    @Override
    public int hashCode() {
        int B = 31;

        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.toLowerCase().hashCode(); // 先转成小写再计算哈希值
        hash = hash * B + lastName.toLowerCase().hashCode();

        return hash;
    }

    // 重写equals方法
    // 为了解决哈希冲突，即使发生了哈希冲突也会根据重写的equals方法区分开每一个对象
    // 注意equals方法重写的套路
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(getClass() != o.getClass()){
            return false;
        }

        Student another = (Student)o;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }
}
