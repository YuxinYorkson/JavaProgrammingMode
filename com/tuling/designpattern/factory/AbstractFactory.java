/*
  当每个抽象产品都有多于一个的具体子类的时候，例如数据库，可以有连接（Connection）的不同，具体执行指令（Command）的不同
  这时，只有一个抽象的IDatabase已经无法满足，需要IConnection与ICommand一起来完成不同DB的实例化。IDataBase就被分解为了
  一个产品族包含IConnection和ICommand。

  这也是工厂方法模式和抽象工厂模式的具体区别。

  工厂方法模式：
  一个抽象产品类，可以派生出多个具体产品类。
  一个抽象工厂类，可以派生出多个具体工厂类。
  每个具体工厂类只能创建一个具体产品类的实例。
  抽象工厂模式：
  多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。
  一个抽象工厂类，可以派生出多个具体工厂类。
  每个具体工厂类可以创建多个具体产品类的实例。
  区别：
  工厂方法模式只有一个抽象产品类，而抽象工厂模式有多个。
  工厂方法模式的具体工厂类只能创建一个具体产品类的实例，而抽象工厂模式可以创建多个
 */
package com.tuling.designpattern.factory;

public class AbstractFactory {

    public static void main(String[] args) {

        //IDateBaseUtils iDateBaseUtils = new MySqlDataBaseUtils();
        IDateBaseUtils iDateBaseUtils = new OracleDataBaseUtils();
        IConnection connection = iDateBaseUtils.getConnection();
        connection.connect();
        ICommand command = iDateBaseUtils.getCommand();
        command.command();
    }
}

interface IConnection {
    void connect();
}

interface ICommand {
    void command();
}

//抽象工厂
interface IDateBaseUtils {
    IConnection getConnection();
    ICommand getCommand();
}

class MySqlConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("MySql connected.");
    }
}

class MySqlCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("MySql command executed.");
    }
}

class MySqlDataBaseUtils implements IDateBaseUtils {

    @Override
    public IConnection getConnection() {
        return new MySqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MySqlCommand();
    }
}

class OracleConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("Oracle connected.");
    }
}

class OracleCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("Oracle command executed.");
    }
}

class OracleDataBaseUtils implements IDateBaseUtils {

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}
