package cn.codesheep.test.设计模式.建造者模式;

/**
 * @program: javaSourceLearn
 * @description: 建造者模式实现
 * @author: Mr.Teddy
 * @create: 2020-09-22 14:04
 **/
public class StudentTest {

    public static void main(String[] args) {
        Student builder = new Student.Builder()
                .studentId(99)
                .studentName("你好")
                .studentAge(2)
                .studentAddress("河南")
                .buidle();

        System.out.println(builder);
    }
}


class Student {
    private int id;
    private String name;
    private int age;
    private String address;

    private Student() {}

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static final class Builder {
        private int id;
        private String name;
        private int age;
        private String address;

        Builder() {}

        Builder studentId(int id){
            this.id = id;
            return this;
        }
        Builder studentName(String name){
            this.name = name;
            return this;
        }
        Builder studentAge(int age){
            this.age = age;
            return this;
        }
        Builder studentAddress(String address){
            this.address = address;
            return this;
        }

        Student buidle(){
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

