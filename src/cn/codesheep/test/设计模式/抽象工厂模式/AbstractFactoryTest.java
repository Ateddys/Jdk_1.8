package cn.codesheep.test.设计模式.抽象工厂模式;

/**
 * @program: javaSourceLearn
 * @description: 抽象工厂模式
 * @author: Mr.Teddy
 * @create: 2020-09-21 15:43
 **/
public class AbstractFactoryTest {
    public static void main(String[] args) {
        // Mysql
        IDataBaseUtils iDataBaseUtils = new MysqlIDataBaseUtils();
        IConnection connection = iDataBaseUtils.getConnection();
        connection.connect();
        ICommand command = iDataBaseUtils.getCommand();
        command.command();

        // Oracle
        OracleIDataBaseUtils oracleIDataBaseUtils = new OracleIDataBaseUtils();
        IConnection oracleIConnection = oracleIDataBaseUtils.getConnection();
        oracleIConnection.connect();
        ICommand oracleCommand = oracleIDataBaseUtils.getCommand();
        oracleCommand.command();
    }
}

// 连接
interface IConnection {
    void connect();
}
class MysqlIConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("Mysql connected. ");
    }
}
class OracleIConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("Oracle connected. ");
    }
}



interface ICommand {
    void command();
}
class MysqlICommand implements ICommand{
    @Override
    public void command() {
        System.out.println("Mysql command. ");
    }
}
class OracleICommand implements ICommand {
    @Override
    public void command() {
        System.out.println("Oracle command. ");
    }
}



interface IDataBaseUtils {
    IConnection getConnection();
    ICommand getCommand();
}
class MysqlIDataBaseUtils implements IDataBaseUtils{
    @Override
    public IConnection getConnection() {
        return new MysqlIConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlICommand();
    }
}
class OracleIDataBaseUtils implements IDataBaseUtils {

    @Override
    public IConnection getConnection() {
        return new OracleIConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleICommand();
    }
}